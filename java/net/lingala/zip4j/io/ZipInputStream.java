/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 */
package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.BaseInputStream;
import net.lingala.zip4j.unzip.UnzipEngine;

public class ZipInputStream
extends InputStream {
    private BaseInputStream is;

    public ZipInputStream(BaseInputStream baseInputStream) {
        this.is = baseInputStream;
    }

    public int available() throws IOException {
        return this.is.available();
    }

    public void close() throws IOException {
        this.close(false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close(boolean bl) throws IOException {
        try {
            this.is.close();
            if (bl) return;
        }
        catch (ZipException var2_2) {
            throw new IOException(var2_2.getMessage());
        }
        if (this.is.getUnzipEngine() == null) return;
        this.is.getUnzipEngine().checkCRC();
    }

    public int read() throws IOException {
        int n = this.is.read();
        if (n != -1) {
            this.is.getUnzipEngine().updateCRC(n);
        }
        return n;
    }

    public int read(byte[] arrby) throws IOException {
        return this.read(arrby, 0, arrby.length);
    }

    public int read(byte[] arrby, int n, int n2) throws IOException {
        int n3 = this.is.read(arrby, n, n2);
        if (n3 > 0 && this.is.getUnzipEngine() != null) {
            this.is.getUnzipEngine().updateCRC(arrby, n, n3);
        }
        return n3;
    }

    public long skip(long l) throws IOException {
        return this.is.skip(l);
    }
}

