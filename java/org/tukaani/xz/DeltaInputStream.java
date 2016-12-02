package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.delta.DeltaDecoder;

public class DeltaInputStream extends InputStream {
    public static final int DISTANCE_MAX = 256;
    public static final int DISTANCE_MIN = 1;
    private final DeltaDecoder delta;
    private IOException exception = null;
    private InputStream in;
    private final byte[] tempBuf = new byte[DISTANCE_MIN];

    public DeltaInputStream(InputStream in, int distance) {
        if (in == null) {
            throw new NullPointerException();
        }
        this.in = in;
        this.delta = new DeltaDecoder(distance);
    }

    public int read() throws IOException {
        return read(this.tempBuf, 0, DISTANCE_MIN) == -1 ? -1 : this.tempBuf[0] & 255;
    }

    public int read(byte[] buf, int off, int len) throws IOException {
        if (len == 0) {
            return 0;
        }
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        } else if (this.exception != null) {
            throw this.exception;
        } else {
            try {
                int size = this.in.read(buf, off, len);
                if (size == -1) {
                    return -1;
                }
                this.delta.decode(buf, off, size);
                return size;
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        } else if (this.exception == null) {
            return this.in.available();
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
