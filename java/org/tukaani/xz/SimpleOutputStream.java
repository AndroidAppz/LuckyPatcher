package org.tukaani.xz;

import java.io.IOException;
import org.tukaani.xz.simple.SimpleFilter;

class SimpleOutputStream extends FinishableOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!SimpleOutputStream.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final int FILTER_BUF_SIZE = 4096;
    private IOException exception = null;
    private final byte[] filterBuf = new byte[FILTER_BUF_SIZE];
    private boolean finished = $assertionsDisabled;
    private FinishableOutputStream out;
    private int pos = 0;
    private final SimpleFilter simpleFilter;
    private final byte[] tempBuf = new byte[1];
    private int unfiltered = 0;

    static int getMemoryUsage() {
        return 5;
    }

    SimpleOutputStream(FinishableOutputStream out, SimpleFilter simpleFilter) {
        if (out == null) {
            throw new NullPointerException();
        }
        this.out = out;
        this.simpleFilter = simpleFilter;
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
                int copySize = Math.min(len, 4096 - (this.pos + this.unfiltered));
                System.arraycopy(buf, off, this.filterBuf, this.pos + this.unfiltered, copySize);
                off += copySize;
                len -= copySize;
                this.unfiltered += copySize;
                int filtered = this.simpleFilter.code(this.filterBuf, this.pos, this.unfiltered);
                if ($assertionsDisabled || filtered <= this.unfiltered) {
                    this.unfiltered -= filtered;
                    try {
                        this.out.write(this.filterBuf, this.pos, filtered);
                        this.pos += filtered;
                        if (this.pos + this.unfiltered == FILTER_BUF_SIZE) {
                            System.arraycopy(this.filterBuf, this.pos, this.filterBuf, 0, this.unfiltered);
                            this.pos = 0;
                        }
                    } catch (IOException e) {
                        this.exception = e;
                        throw e;
                    }
                }
                throw new AssertionError();
            }
        }
    }

    private void writePending() throws IOException {
        if (!$assertionsDisabled && this.finished) {
            throw new AssertionError();
        } else if (this.exception != null) {
            throw this.exception;
        } else {
            try {
                this.out.write(this.filterBuf, this.pos, this.unfiltered);
                this.finished = true;
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void flush() throws IOException {
        throw new UnsupportedOptionsException("Flushing is not supported");
    }

    public void finish() throws IOException {
        if (!this.finished) {
            writePending();
            try {
                this.out.finish();
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
                    writePending();
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
