package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;

class CountingOutputStream extends FinishableOutputStream {
    private final OutputStream out;
    private long size = 0;

    public CountingOutputStream(OutputStream out) {
        this.out = out;
    }

    public void write(int b) throws IOException {
        this.out.write(b);
        if (this.size >= 0) {
            this.size++;
        }
    }

    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        if (this.size >= 0) {
            this.size += (long) len;
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void close() throws IOException {
        this.out.close();
    }

    public long getSize() {
        return this.size;
    }
}
