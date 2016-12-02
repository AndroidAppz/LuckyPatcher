/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 */
package org.tukaani.xz.lz;

import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.CorruptedInputException;

public final class LZDecoder {
    private final byte[] buf;
    private int full = 0;
    private int limit = 0;
    private int pendingDist = 0;
    private int pendingLen = 0;
    private int pos = 0;
    private int start = 0;

    public LZDecoder(int n, byte[] arrby) {
        this.buf = new byte[n];
        if (arrby != null) {
            this.full = this.pos = Math.min((int)arrby.length, (int)n);
            this.start = this.pos;
            System.arraycopy((Object)arrby, (int)(arrby.length - this.pos), (Object)this.buf, (int)0, (int)this.pos);
        }
    }

    public void copyUncompressed(DataInputStream dataInputStream, int n) throws IOException {
        int n2 = Math.min((int)(this.buf.length - this.pos), (int)n);
        dataInputStream.readFully(this.buf, this.pos, n2);
        this.pos = n2 + this.pos;
        if (this.full < this.pos) {
            this.full = this.pos;
        }
    }

    public int flush(byte[] arrby, int n) {
        int n2 = this.pos - this.start;
        if (this.pos == this.buf.length) {
            this.pos = 0;
        }
        System.arraycopy((Object)this.buf, (int)this.start, (Object)arrby, (int)n, (int)n2);
        this.start = this.pos;
        return n2;
    }

    public int getByte(int n) {
        int n2 = -1 + (this.pos - n);
        if (n >= this.pos) {
            n2 += this.buf.length;
        }
        return 255 & this.buf[n2];
    }

    public int getPos() {
        return this.pos;
    }

    public boolean hasPending() {
        if (this.pendingLen > 0) {
            return true;
        }
        return false;
    }

    public boolean hasSpace() {
        if (this.pos < this.limit) {
            return true;
        }
        return false;
    }

    public void putByte(byte by) {
        byte[] arrby = this.buf;
        int n = this.pos;
        this.pos = n + 1;
        arrby[n] = by;
        if (this.full < this.pos) {
            this.full = this.pos;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void repeat(int n, int n2) throws IOException {
        if (n < 0 || n >= this.full) {
            throw new CorruptedInputException();
        }
        int n3 = Math.min((int)(this.limit - this.pos), (int)n2);
        this.pendingLen = n2 - n3;
        this.pendingDist = n;
        int n4 = -1 + (this.pos - n);
        if (n >= this.pos) {
            n4 += this.buf.length;
        }
        do {
            byte[] arrby = this.buf;
            int n5 = this.pos;
            this.pos = n5 + 1;
            byte[] arrby2 = this.buf;
            int n6 = n4 + 1;
            arrby[n5] = arrby2[n4];
            n4 = n6 == this.buf.length ? 0 : n6;
        } while (--n3 > 0);
        if (this.full < this.pos) {
            this.full = this.pos;
        }
    }

    public void repeatPending() throws IOException {
        if (this.pendingLen > 0) {
            this.repeat(this.pendingDist, this.pendingLen);
        }
    }

    public void reset() {
        this.start = 0;
        this.pos = 0;
        this.full = 0;
        this.limit = 0;
        this.buf[-1 + this.buf.length] = 0;
    }

    public void setLimit(int n) {
        if (this.buf.length - this.pos <= n) {
            this.limit = this.buf.length;
            return;
        }
        this.limit = n + this.pos;
    }
}

