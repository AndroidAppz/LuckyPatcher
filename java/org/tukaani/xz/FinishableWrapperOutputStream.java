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

public class FinishableWrapperOutputStream
extends FinishableOutputStream {
    protected OutputStream out;

    public FinishableWrapperOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(int n) throws IOException {
        this.out.write(n);
    }

    public void write(byte[] arrby) throws IOException {
        this.out.write(arrby);
    }

    public void write(byte[] arrby, int n, int n2) throws IOException {
        this.out.write(arrby, n, n2);
    }
}

