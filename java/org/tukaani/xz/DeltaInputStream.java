/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.NullPointerException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.delta.DeltaDecoder;

public class DeltaInputStream
extends InputStream {
    public static final int DISTANCE_MAX = 256;
    public static final int DISTANCE_MIN = 1;
    private final DeltaDecoder delta;
    private IOException exception = null;
    private InputStream in;
    private final byte[] tempBuf = new byte[1];

    public DeltaInputStream(InputStream inputStream, int n) {
        if (inputStream == null) {
            throw new NullPointerException();
        }
        this.in = inputStream;
        this.delta = new DeltaDecoder(n);
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (this.exception != null) {
            throw this.exception;
        }
        return this.in.available();
    }

    public void close() throws IOException {
        if (this.in != null) {
            this.in.close();
        }
        return;
        finally {
            this.in = null;
        }
    }

    public int read() throws IOException {
        if (this.read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return 255 & this.tempBuf[0];
    }

    public int read(byte[] arrby, int n, int n2) throws IOException {
        int n3;
        if (n2 == 0) {
            return 0;
        }
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (this.exception != null) {
            throw this.exception;
        }
        try {
            n3 = this.in.read(arrby, n, n2);
            if (n3 == -1) {
                return -1;
            }
        }
        catch (IOException var4_5) {
            this.exception = var4_5;
            throw var4_5;
        }
        this.delta.decode(arrby, n, n3);
        return n3;
    }
}

