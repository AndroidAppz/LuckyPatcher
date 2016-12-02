/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.IOException;
import org.tukaani.xz.DeltaOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.delta.DeltaEncoder;

class DeltaOutputStream
extends FinishableOutputStream {
    private static final int FILTER_BUF_SIZE = 4096;
    private final DeltaEncoder delta;
    private IOException exception = null;
    private final byte[] filterBuf = new byte[4096];
    private boolean finished = false;
    private FinishableOutputStream out;
    private final byte[] tempBuf = new byte[1];

    DeltaOutputStream(FinishableOutputStream finishableOutputStream, DeltaOptions deltaOptions) {
        this.out = finishableOutputStream;
        this.delta = new DeltaEncoder(deltaOptions.getDistance());
    }

    static int getMemoryUsage() {
        return 5;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        if (this.out == null) ** GOTO lbl10
        try {
            this.out.close();
        }
        catch (IOException var1_1) {
            if (this.exception != null) ** GOTO lbl8
            this.exception = var1_1;
            ** continue;
        }
lbl8: // 3 sources:
        do {
            this.out = null;
lbl10: // 2 sources:
            if (this.exception == null) return;
            throw this.exception;
            break;
        } while (true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void finish() throws IOException {
        if (this.finished) return;
        if (this.exception != null) {
            throw this.exception;
        }
        try {
            this.out.finish();
        }
        catch (IOException iOException) {
            this.exception = iOException;
            throw iOException;
        }
        this.finished = true;
    }

    public void flush() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        try {
            this.out.flush();
            return;
        }
        catch (IOException var1_1) {
            this.exception = var1_1;
            throw var1_1;
        }
    }

    public void write(int n) throws IOException {
        this.tempBuf[0] = (byte)n;
        this.write(this.tempBuf, 0, 1);
    }

    public void write(byte[] arrby, int n, int n2) throws IOException {
        if (n < 0 || n2 < 0 || n + n2 < 0 || n + n2 > arrby.length) {
            throw new IndexOutOfBoundsException();
        }
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished");
        }
        while (n2 > 4096) {
            this.delta.encode(arrby, n, 4096, this.filterBuf);
            this.out.write(this.filterBuf);
            n += 4096;
            n2 -= 4096;
        }
        try {
            this.delta.encode(arrby, n, n2, this.filterBuf);
            this.out.write(this.filterBuf, 0, n2);
            return;
        }
        catch (IOException var4_4) {
            this.exception = var4_4;
            throw var4_4;
        }
    }
}

