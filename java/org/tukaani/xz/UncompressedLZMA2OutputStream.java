package org.tukaani.xz;

import java.io.DataOutputStream;
import java.io.IOException;
import net.lingala.zip4j.util.InternalZipConstants;

class UncompressedLZMA2OutputStream extends FinishableOutputStream {
    private boolean dictResetNeeded = true;
    private IOException exception = null;
    private boolean finished = false;
    private FinishableOutputStream out;
    private final DataOutputStream outData;
    private final byte[] tempBuf = new byte[1];
    private final byte[] uncompBuf = new byte[InternalZipConstants.MIN_SPLIT_LENGTH];
    private int uncompPos = 0;

    static int getMemoryUsage() {
        return 70;
    }

    UncompressedLZMA2OutputStream(FinishableOutputStream out) {
        if (out == null) {
            throw new NullPointerException();
        }
        this.out = out;
        this.outData = new DataOutputStream(out);
    }

    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    public void write(byte[] buf, int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len < 0 || off + len > buf.length) {
            throw new IndexOutOfBoundsException();
        } else if (this.exception != null) {
            throw this.exception;
        } else if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        } else {
            while (len > 0) {
                try {
                    int copySize = Math.min(this.uncompBuf.length - this.uncompPos, len);
                    System.arraycopy(buf, off, this.uncompBuf, this.uncompPos, copySize);
                    len -= copySize;
                    this.uncompPos += copySize;
                    if (this.uncompPos == this.uncompBuf.length) {
                        writeChunk();
                    }
                } catch (IOException e) {
                    this.exception = e;
                    throw e;
                }
            }
        }
    }

    private void writeChunk() throws IOException {
        this.outData.writeByte(this.dictResetNeeded ? 1 : 2);
        this.outData.writeShort(this.uncompPos - 1);
        this.outData.write(this.uncompBuf, 0, this.uncompPos);
        this.uncompPos = 0;
        this.dictResetNeeded = false;
    }

    private void writeEndMarker() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        } else if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        } else {
            try {
                if (this.uncompPos > 0) {
                    writeChunk();
                }
                this.out.write(0);
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void flush() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        } else if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        } else {
            try {
                if (this.uncompPos > 0) {
                    writeChunk();
                }
                this.out.flush();
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            writeEndMarker();
            try {
                this.out.finish();
                this.finished = true;
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void close() throws IOException {
        if (this.out != null) {
            if (!this.finished) {
                try {
                    writeEndMarker();
                } catch (IOException e) {
                }
            }
            try {
                this.out.close();
            } catch (IOException e2) {
                if (this.exception == null) {
                    this.exception = e2;
                }
            }
            this.out = null;
        }
        if (this.exception != null) {
            throw this.exception;
        }
    }
}
