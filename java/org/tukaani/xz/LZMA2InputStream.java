package org.tukaani.xz;

import com.chelpus.Common;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.common.Util;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromBuffer;

public class LZMA2InputStream extends InputStream {
    private static final int COMPRESSED_SIZE_MAX = 65536;
    public static final int DICT_SIZE_MAX = 2147483632;
    public static final int DICT_SIZE_MIN = 4096;
    private boolean endReached;
    private IOException exception;
    private DataInputStream in;
    private boolean isLZMAChunk;
    private final LZDecoder lz;
    private LZMADecoder lzma;
    private boolean needDictReset;
    private boolean needProps;
    private final RangeDecoderFromBuffer rc;
    private final byte[] tempBuf;
    private int uncompressedSize;

    public static int getMemoryUsage(int dictSize) {
        return (getDictSize(dictSize) / Util.BLOCK_HEADER_SIZE_MAX) + 104;
    }

    private static int getDictSize(int dictSize) {
        if (dictSize >= DICT_SIZE_MIN && dictSize <= DICT_SIZE_MAX) {
            return (dictSize + 15) & -16;
        }
        throw new IllegalArgumentException("Unsupported dictionary size " + dictSize);
    }

    public LZMA2InputStream(InputStream in, int dictSize) {
        this(in, dictSize, null);
    }

    public LZMA2InputStream(InputStream in, int dictSize, byte[] presetDict) {
        this.rc = new RangeDecoderFromBuffer(COMPRESSED_SIZE_MAX);
        this.uncompressedSize = 0;
        this.needDictReset = true;
        this.needProps = true;
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        if (in == null) {
            throw new NullPointerException();
        }
        this.in = new DataInputStream(in);
        this.lz = new LZDecoder(getDictSize(dictSize), presetDict);
        if (presetDict != null && presetDict.length > 0) {
            this.needDictReset = false;
        }
    }

    public int read() throws IOException {
        return read(this.tempBuf, 0, 1) == -1 ? -1 : this.tempBuf[0] & 255;
    }

    public int read(byte[] buf, int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len < 0 || off + len > buf.length) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        } else {
            if (this.in == null) {
                throw new XZIOException("Stream closed");
            } else if (this.exception != null) {
                throw this.exception;
            } else if (this.endReached) {
                return -1;
            } else {
                int size = 0;
                while (len > 0) {
                    try {
                        if (this.uncompressedSize == 0) {
                            decodeChunkHeader();
                            if (this.endReached) {
                                if (size == 0) {
                                    return -1;
                                }
                                return size;
                            }
                        }
                        int copySizeMax = Math.min(this.uncompressedSize, len);
                        if (this.isLZMAChunk) {
                            this.lz.setLimit(copySizeMax);
                            this.lzma.decode();
                            if (!this.rc.isInBufferOK()) {
                                throw new CorruptedInputException();
                            }
                        }
                        this.lz.copyUncompressed(this.in, copySizeMax);
                        int copiedSize = this.lz.flush(buf, off);
                        off += copiedSize;
                        len -= copiedSize;
                        size += copiedSize;
                        this.uncompressedSize -= copiedSize;
                        if (this.uncompressedSize == 0 && (!this.rc.isFinished() || this.lz.hasPending())) {
                            throw new CorruptedInputException();
                        }
                    } catch (IOException e) {
                        this.exception = e;
                        throw e;
                    }
                }
                return size;
            }
        }
    }

    private void decodeChunkHeader() throws IOException {
        int control = this.in.readUnsignedByte();
        if (control == 0) {
            this.endReached = true;
            return;
        }
        if (control >= 224 || control == 1) {
            this.needProps = true;
            this.needDictReset = false;
            this.lz.reset();
        } else if (this.needDictReset) {
            throw new CorruptedInputException();
        }
        if (control >= Common.INSTALL_ALLOW_DOWNGRADE) {
            this.isLZMAChunk = true;
            this.uncompressedSize = (control & 31) << 16;
            this.uncompressedSize += this.in.readUnsignedShort() + 1;
            int compressedSize = this.in.readUnsignedShort() + 1;
            if (control >= 192) {
                this.needProps = false;
                decodeProps();
            } else if (this.needProps) {
                throw new CorruptedInputException();
            } else if (control >= 160) {
                this.lzma.reset();
            }
            this.rc.prepareInputBuffer(this.in, compressedSize);
        } else if (control > 2) {
            throw new CorruptedInputException();
        } else {
            this.isLZMAChunk = false;
            this.uncompressedSize = this.in.readUnsignedShort() + 1;
        }
    }

    private void decodeProps() throws IOException {
        int props = this.in.readUnsignedByte();
        if (props > 224) {
            throw new CorruptedInputException();
        }
        int pb = props / 45;
        props -= (pb * 9) * 5;
        int lp = props / 9;
        int lc = props - (lp * 9);
        if (lc + lp > 4) {
            throw new CorruptedInputException();
        }
        this.lzma = new LZMADecoder(this.lz, this.rc, lc, lp, pb);
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        } else if (this.exception == null) {
            return this.uncompressedSize;
        } else {
            throw this.exception;
        }
    }

    public void close() throws IOException {
        if (this.in != null) {
            try {
                this.in.close();
            } finally {
                this.in = null;
            }
        }
    }
}
