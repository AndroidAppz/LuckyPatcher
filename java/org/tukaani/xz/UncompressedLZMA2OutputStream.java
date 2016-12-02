/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package org.tukaani.xz;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.XZIOException;

class UncompressedLZMA2OutputStream
extends FinishableOutputStream {
    private boolean dictResetNeeded = true;
    private IOException exception = null;
    private boolean finished = false;
    private FinishableOutputStream out;
    private final DataOutputStream outData;
    private final byte[] tempBuf = new byte[1];
    private final byte[] uncompBuf = new byte[65536];
    private int uncompPos = 0;

    UncompressedLZMA2OutputStream(FinishableOutputStream finishableOutputStream) {
        if (finishableOutputStream == null) {
            throw new NullPointerException();
        }
        this.out = finishableOutputStream;
        this.outData = new DataOutputStream((OutputStream)finishableOutputStream);
    }

    static int getMemoryUsage() {
        return 70;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void writeChunk() throws IOException {
        DataOutputStream dataOutputStream = this.outData;
        int n = this.dictResetNeeded ? 1 : 2;
        dataOutputStream.writeByte(n);
        this.outData.writeShort(-1 + this.uncompPos);
        this.outData.write(this.uncompBuf, 0, this.uncompPos);
        this.uncompPos = 0;
        this.dictResetNeeded = false;
    }

    private void writeEndMarker() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        try {
            if (this.uncompPos > 0) {
                this.writeChunk();
            }
            this.out.write(0);
            return;
        }
        catch (IOException var1_1) {
            this.exception = var1_1;
            throw var1_1;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        if (this.out == null) ** GOTO lbl14
        if (!this.finished) {
            this.writeEndMarker();
        }
lbl5: // 4 sources:
        do {
            try {
                this.out.close();
            }
            catch (IOException var1_1) {
                if (this.exception != null) ** GOTO lbl12
                this.exception = var1_1;
                ** continue;
            }
lbl12: // 3 sources:
            do {
                this.out = null;
lbl14: // 2 sources:
                if (this.exception == null) return;
                throw this.exception;
                break;
            } while (true);
            break;
        } while (true);
        catch (IOException var2_2) {
            ** continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void finish() throws IOException {
        if (this.finished) return;
        this.writeEndMarker();
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
            if (this.uncompPos > 0) {
                this.writeChunk();
            }
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
            throw new XZIOException("Stream finished or closed");
        }
        while (n2 > 0) {
            int n3;
            try {
                n3 = Math.min((int)(this.uncompBuf.length - this.uncompPos), (int)n2);
                System.arraycopy((Object)arrby, (int)n, (Object)this.uncompBuf, (int)this.uncompPos, (int)n3);
            }
            catch (IOException var4_5) {
                this.exception = var4_5;
                throw var4_5;
            }
            n2 -= n3;
            this.uncompPos = n3 + this.uncompPos;
            if (this.uncompPos != this.uncompBuf.length) continue;
            super.writeChunk();
            continue;
        }
    }
}

