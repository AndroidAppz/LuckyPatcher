package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XZInputStream extends InputStream {
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private final int memoryLimit;
    private final byte[] tempBuf;
    private SingleXZInputStream xzIn;

    public XZInputStream(InputStream in) throws IOException {
        this(in, -1);
    }

    public XZInputStream(InputStream in, int memoryLimit) throws IOException {
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.in = in;
        this.memoryLimit = memoryLimit;
        this.xzIn = new SingleXZInputStream(in, memoryLimit);
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
                        if (this.xzIn == null) {
                            prepareNextStream();
                            if (this.endReached) {
                                if (size == 0) {
                                    return -1;
                                }
                                return size;
                            }
                        }
                        int ret = this.xzIn.read(buf, off, len);
                        if (ret > 0) {
                            size += ret;
                            off += ret;
                            len -= ret;
                        } else if (ret == -1) {
                            this.xzIn = null;
                        }
                    } catch (IOException e) {
                        this.exception = e;
                        if (size != 0) {
                            return size;
                        }
                        throw e;
                    }
                }
                return size;
            }
        }
    }

    private void prepareNextStream() throws IOException {
        DataInputStream inData = new DataInputStream(this.in);
        byte[] buf = new byte[12];
        while (inData.read(buf, 0, 1) != -1) {
            inData.readFully(buf, 1, 3);
            if (buf[0] != (byte) 0 || buf[1] != (byte) 0 || buf[2] != (byte) 0) {
                inData.readFully(buf, 4, 8);
                try {
                    this.xzIn = new SingleXZInputStream(this.in, this.memoryLimit, buf);
                    return;
                } catch (XZFormatException e) {
                    throw new CorruptedInputException("Garbage after a valid XZ Stream");
                }
            } else if (buf[3] != (byte) 0) {
                inData.readFully(buf, 4, 8);
                this.xzIn = new SingleXZInputStream(this.in, this.memoryLimit, buf);
                return;
            }
        }
        this.endReached = true;
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        } else if (this.exception == null) {
            return this.xzIn == null ? 0 : this.xzIn.available();
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
