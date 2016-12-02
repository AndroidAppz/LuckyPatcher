package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.common.Util;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromStream;

public class LZMAInputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!LZMAInputStream.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static final int DICT_SIZE_MAX = 2147483632;
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private LZDecoder lz;
    private LZMADecoder lzma;
    private RangeDecoderFromStream rc;
    private long remainingSize;
    private final byte[] tempBuf;

    public static int getMemoryUsage(int dictSize, byte propsByte) throws UnsupportedOptionsException, CorruptedInputException {
        if (dictSize < 0 || dictSize > DICT_SIZE_MAX) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        int props = propsByte & 255;
        if (props > 224) {
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        props %= 45;
        int lp = props / 9;
        return getMemoryUsage(dictSize, props - (lp * 9), lp);
    }

    public static int getMemoryUsage(int dictSize, int lc, int lp) {
        if (lc >= 0 && lc <= 8 && lp >= 0 && lp <= 4) {
            return ((getDictSize(dictSize) / Util.BLOCK_HEADER_SIZE_MAX) + 10) + ((1536 << (lc + lp)) / Util.BLOCK_HEADER_SIZE_MAX);
        }
        throw new IllegalArgumentException("Invalid lc or lp");
    }

    private static int getDictSize(int dictSize) {
        if (dictSize < 0 || dictSize > DICT_SIZE_MAX) {
            throw new IllegalArgumentException("LZMA dictionary is too big for this implementation");
        }
        if (dictSize < LZMA2Options.DICT_SIZE_MIN) {
            dictSize = LZMA2Options.DICT_SIZE_MIN;
        }
        return (dictSize + 15) & -16;
    }

    public LZMAInputStream(InputStream in) throws IOException {
        this(in, -1);
    }

    public LZMAInputStream(InputStream in, int memoryLimit) throws IOException {
        int i;
        this.endReached = $assertionsDisabled;
        this.tempBuf = new byte[1];
        this.exception = null;
        DataInputStream inData = new DataInputStream(in);
        byte propsByte = inData.readByte();
        int dictSize = 0;
        for (i = 0; i < 4; i++) {
            dictSize |= inData.readUnsignedByte() << (i * 8);
        }
        long uncompSize = 0;
        for (i = 0; i < 8; i++) {
            uncompSize |= ((long) inData.readUnsignedByte()) << (i * 8);
        }
        int memoryNeeded = getMemoryUsage(dictSize, propsByte);
        if (memoryLimit == -1 || memoryNeeded <= memoryLimit) {
            initialize(in, uncompSize, propsByte, dictSize, null);
            return;
        }
        throw new MemoryLimitException(memoryNeeded, memoryLimit);
    }

    public LZMAInputStream(InputStream in, long uncompSize, byte propsByte, int dictSize) throws IOException {
        this.endReached = $assertionsDisabled;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(in, uncompSize, propsByte, dictSize, null);
    }

    public LZMAInputStream(InputStream in, long uncompSize, byte propsByte, int dictSize, byte[] presetDict) throws IOException {
        this.endReached = $assertionsDisabled;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(in, uncompSize, propsByte, dictSize, presetDict);
    }

    public LZMAInputStream(InputStream in, long uncompSize, int lc, int lp, int pb, int dictSize, byte[] presetDict) throws IOException {
        this.endReached = $assertionsDisabled;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(in, uncompSize, lc, lp, pb, dictSize, presetDict);
    }

    private void initialize(InputStream in, long uncompSize, byte propsByte, int dictSize, byte[] presetDict) throws IOException {
        if (uncompSize < -1) {
            throw new UnsupportedOptionsException("Uncompressed size is too big");
        }
        int props = propsByte & 255;
        if (props > 224) {
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        int pb = props / 45;
        props -= (pb * 9) * 5;
        int lp = props / 9;
        int lc = props - (lp * 9);
        if (dictSize < 0 || dictSize > DICT_SIZE_MAX) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        initialize(in, uncompSize, lc, lp, pb, dictSize, presetDict);
    }

    private void initialize(InputStream in, long uncompSize, int lc, int lp, int pb, int dictSize, byte[] presetDict) throws IOException {
        if (uncompSize < -1 || lc < 0 || lc > 8 || lp < 0 || lp > 4 || pb < 0 || pb > 4) {
            throw new IllegalArgumentException();
        }
        this.in = in;
        dictSize = getDictSize(dictSize);
        if (uncompSize >= 0 && ((long) dictSize) > uncompSize) {
            dictSize = getDictSize((int) uncompSize);
        }
        this.lz = new LZDecoder(getDictSize(dictSize), presetDict);
        this.rc = new RangeDecoderFromStream(in);
        this.lzma = new LZMADecoder(this.lz, this.rc, lc, lp, pb);
        this.remainingSize = uncompSize;
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
                    int copySizeMax = len;
                    if (this.remainingSize >= 0 && this.remainingSize < ((long) len)) {
                        copySizeMax = (int) this.remainingSize;
                    }
                    this.lz.setLimit(copySizeMax);
                    try {
                        this.lzma.decode();
                    } catch (CorruptedInputException e) {
                        if (this.remainingSize == -1 && this.lzma.endMarkerDetected()) {
                            this.endReached = true;
                            this.rc.normalize();
                        } else {
                            throw e;
                        }
                    } catch (IOException e2) {
                        this.exception = e2;
                        throw e2;
                    }
                    int copiedSize = this.lz.flush(buf, off);
                    off += copiedSize;
                    len -= copiedSize;
                    size += copiedSize;
                    if (this.remainingSize >= 0) {
                        this.remainingSize -= (long) copiedSize;
                        if (!$assertionsDisabled && this.remainingSize < 0) {
                            throw new AssertionError();
                        } else if (this.remainingSize == 0) {
                            this.endReached = true;
                        }
                    }
                    if (this.endReached) {
                        if (!this.rc.isFinished() || this.lz.hasPending()) {
                            throw new CorruptedInputException();
                        } else if (size == 0) {
                            return -1;
                        } else {
                            return size;
                        }
                    }
                }
                return size;
            }
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
