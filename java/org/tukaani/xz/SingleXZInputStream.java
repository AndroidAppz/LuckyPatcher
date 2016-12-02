package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexHash;

public class SingleXZInputStream extends InputStream {
    private BlockInputStream blockDecoder;
    private Check check;
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private final IndexHash indexHash;
    private int memoryLimit;
    private StreamFlags streamHeaderFlags;
    private final byte[] tempBuf;

    public SingleXZInputStream(InputStream in) throws IOException {
        this.blockDecoder = null;
        this.indexHash = new IndexHash();
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        initialize(in, -1);
    }

    public SingleXZInputStream(InputStream in, int memoryLimit) throws IOException {
        this.blockDecoder = null;
        this.indexHash = new IndexHash();
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        initialize(in, memoryLimit);
    }

    SingleXZInputStream(InputStream in, int memoryLimit, byte[] streamHeader) throws IOException {
        this.blockDecoder = null;
        this.indexHash = new IndexHash();
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        initialize(in, memoryLimit, streamHeader);
    }

    private void initialize(InputStream in, int memoryLimit) throws IOException {
        byte[] streamHeader = new byte[12];
        new DataInputStream(in).readFully(streamHeader);
        initialize(in, memoryLimit, streamHeader);
    }

    private void initialize(InputStream in, int memoryLimit, byte[] streamHeader) throws IOException {
        this.in = in;
        this.memoryLimit = memoryLimit;
        this.streamHeaderFlags = DecoderUtil.decodeStreamHeader(streamHeader);
        this.check = Check.getInstance(this.streamHeaderFlags.checkType);
    }

    public int getCheckType() {
        return this.streamHeaderFlags.checkType;
    }

    public String getCheckName() {
        return this.check.getName();
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
                        if (this.blockDecoder == null) {
                            try {
                                this.blockDecoder = new BlockInputStream(this.in, this.check, this.memoryLimit, -1, -1);
                            } catch (IndexIndicatorException e) {
                                this.indexHash.validate(this.in);
                                validateStreamFooter();
                                this.endReached = true;
                                if (size <= 0) {
                                    return -1;
                                }
                                return size;
                            }
                        }
                        int ret = this.blockDecoder.read(buf, off, len);
                        if (ret > 0) {
                            size += ret;
                            off += ret;
                            len -= ret;
                        } else if (ret == -1) {
                            this.indexHash.add(this.blockDecoder.getUnpaddedSize(), this.blockDecoder.getUncompressedSize());
                            this.blockDecoder = null;
                        }
                    } catch (IOException e2) {
                        this.exception = e2;
                        if (size != 0) {
                            return size;
                        }
                        throw e2;
                    }
                }
                return size;
            }
        }
    }

    private void validateStreamFooter() throws IOException {
        byte[] buf = new byte[12];
        new DataInputStream(this.in).readFully(buf);
        StreamFlags streamFooterFlags = DecoderUtil.decodeStreamFooter(buf);
        if (!DecoderUtil.areStreamFlagsEqual(this.streamHeaderFlags, streamFooterFlags) || this.indexHash.getIndexSize() != streamFooterFlags.backwardSize) {
            throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
        }
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        } else if (this.exception == null) {
            return this.blockDecoder == null ? 0 : this.blockDecoder.available();
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
