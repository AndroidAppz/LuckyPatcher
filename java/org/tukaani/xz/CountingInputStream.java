package org.tukaani.xz;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class CountingInputStream extends FilterInputStream {
    private long size = 0;

    public CountingInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int ret = this.in.read();
        if (ret != -1 && this.size >= 0) {
            this.size++;
        }
        return ret;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int ret = this.in.read(b, off, len);
        if (ret > 0 && this.size >= 0) {
            this.size += (long) ret;
        }
        return ret;
    }

    public long getSize() {
        return this.size;
    }
}
