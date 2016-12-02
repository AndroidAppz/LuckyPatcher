/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 */
package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.FinishableOutputStream;

class CountingOutputStream
extends FinishableOutputStream {
    private final OutputStream out;
    private long size = 0;

    public CountingOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public long getSize() {
        return this.size;
    }

    public void write(int n) throws IOException {
        this.out.write(n);
        if (this.size >= 0) {
            this.size = 1 + this.size;
        }
    }

    public void write(byte[] arrby, int n, int n2) throws IOException {
        this.out.write(arrby, n, n2);
        if (this.size >= 0) {
            this.size += (long)n2;
        }
    }
}

