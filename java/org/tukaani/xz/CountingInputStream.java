/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 */
package org.tukaani.xz;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class CountingInputStream
extends FilterInputStream {
    private long size = 0;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public long getSize() {
        return this.size;
    }

    public int read() throws IOException {
        int n = this.in.read();
        if (n != -1 && this.size >= 0) {
            this.size = 1 + this.size;
        }
        return n;
    }

    public int read(byte[] arrby, int n, int n2) throws IOException {
        int n3 = this.in.read(arrby, n, n2);
        if (n3 > 0 && this.size >= 0) {
            this.size += (long)n3;
        }
        return n3;
    }
}

