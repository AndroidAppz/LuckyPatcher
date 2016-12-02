/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 */
package org.tukaani.xz.lz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.lz.BT4;
import org.tukaani.xz.lz.HC4;
import org.tukaani.xz.lz.Matches;

public abstract class LZEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MF_BT4 = 20;
    public static final int MF_HC4 = 4;
    final byte[] buf;
    private boolean finishing = false;
    private final int keepSizeAfter;
    private final int keepSizeBefore;
    final int matchLenMax;
    final int niceLen;
    private int pendingSize = 0;
    private int readLimit = -1;
    int readPos = -1;
    private int writePos = 0;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !LZEncoder.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    LZEncoder(int n, int n2, int n3, int n4, int n5) {
        this.buf = new byte[LZEncoder.getBufSize(n, n2, n3, n5)];
        this.keepSizeBefore = n2 + n;
        this.keepSizeAfter = n3 + n5;
        this.matchLenMax = n5;
        this.niceLen = n4;
    }

    private static int getBufSize(int n, int n2, int n3, int n4) {
        int n5 = n2 + n;
        int n6 = n3 + n4;
        return Math.min((int)(262144 + n / 2), (int)536870912) + (n5 + n6);
    }

    public static LZEncoder getInstance(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        switch (n6) {
            default: {
                throw new IllegalArgumentException();
            }
            case 4: {
                return new HC4(n, n2, n3, n4, n5, n7);
            }
            case 20: 
        }
        return new BT4(n, n2, n3, n4, n5, n7);
    }

    public static int getMemoryUsage(int n, int n2, int n3, int n4, int n5) {
        int n6 = 10 + LZEncoder.getBufSize(n, n2, n3, n4) / 1024;
        switch (n5) {
            default: {
                throw new IllegalArgumentException();
            }
            case 4: {
                return n6 + HC4.getMemoryUsage(n);
            }
            case 20: 
        }
        return n6 + BT4.getMemoryUsage(n);
    }

    private void moveWindow() {
        int n = -16 & 1 + this.readPos - this.keepSizeBefore;
        int n2 = this.writePos - n;
        System.arraycopy((Object)this.buf, (int)n, (Object)this.buf, (int)0, (int)n2);
        this.readPos -= n;
        this.readLimit -= n;
        this.writePos -= n;
    }

    /*
     * Enabled aggressive block sorting
     */
    static void normalize(int[] arrn, int n) {
        int n2 = 0;
        while (n2 < arrn.length) {
            arrn[n2] = arrn[n2] <= n ? 0 : arrn[n2] - n;
            ++n2;
        }
    }

    private void processPendingBytes() {
        if (this.pendingSize > 0 && this.readPos < this.readLimit) {
            this.readPos -= this.pendingSize;
            int n = this.pendingSize;
            this.pendingSize = 0;
            this.skip(n);
            if (!$assertionsDisabled && this.pendingSize >= n) {
                throw new AssertionError();
            }
        }
    }

    public void copyUncompressed(OutputStream outputStream, int n, int n2) throws IOException {
        outputStream.write(this.buf, 1 + this.readPos - n, n2);
    }

    public int fillWindow(byte[] arrby, int n, int n2) {
        if (!$assertionsDisabled && this.finishing) {
            throw new AssertionError();
        }
        if (this.readPos >= this.buf.length - this.keepSizeAfter) {
            super.moveWindow();
        }
        if (n2 > this.buf.length - this.writePos) {
            n2 = this.buf.length - this.writePos;
        }
        System.arraycopy((Object)arrby, (int)n, (Object)this.buf, (int)this.writePos, (int)n2);
        this.writePos = n2 + this.writePos;
        if (this.writePos >= this.keepSizeAfter) {
            this.readLimit = this.writePos - this.keepSizeAfter;
        }
        super.processPendingBytes();
        return n2;
    }

    public int getAvail() {
        if (!$assertionsDisabled && !this.isStarted()) {
            throw new AssertionError();
        }
        return this.writePos - this.readPos;
    }

    public int getByte(int n) {
        return 255 & this.buf[this.readPos - n];
    }

    public int getByte(int n, int n2) {
        return 255 & this.buf[n + this.readPos - n2];
    }

    public int getMatchLen(int n, int n2) {
        int n3;
        int n4 = -1 + (this.readPos - n);
        for (n3 = 0; n3 < n2 && this.buf[n3 + this.readPos] == this.buf[n4 + n3]; ++n3) {
        }
        return n3;
    }

    public int getMatchLen(int n, int n2, int n3) {
        int n4;
        int n5 = n + this.readPos;
        int n6 = -1 + (n5 - n2);
        for (n4 = 0; n4 < n3 && this.buf[n5 + n4] == this.buf[n6 + n4]; ++n4) {
        }
        return n4;
    }

    public abstract Matches getMatches();

    public int getPos() {
        return this.readPos;
    }

    public boolean hasEnoughData(int n) {
        if (this.readPos - n < this.readLimit) {
            return true;
        }
        return false;
    }

    public boolean isStarted() {
        if (this.readPos != -1) {
            return true;
        }
        return false;
    }

    int movePos(int n, int n2) {
        if (!$assertionsDisabled && n < n2) {
            throw new AssertionError();
        }
        this.readPos = 1 + this.readPos;
        int n3 = this.writePos - this.readPos;
        if (!(n3 >= n || n3 >= n2 && this.finishing)) {
            this.pendingSize = 1 + this.pendingSize;
            n3 = 0;
        }
        return n3;
    }

    public void setFinishing() {
        this.readLimit = -1 + this.writePos;
        this.finishing = true;
        this.processPendingBytes();
    }

    public void setFlushing() {
        this.readLimit = -1 + this.writePos;
        this.processPendingBytes();
    }

    public void setPresetDict(int n, byte[] arrby) {
        if (!$assertionsDisabled && this.isStarted()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.writePos != 0) {
            throw new AssertionError();
        }
        if (arrby != null) {
            int n2 = Math.min((int)arrby.length, (int)n);
            System.arraycopy((Object)arrby, (int)(arrby.length - n2), (Object)this.buf, (int)0, (int)n2);
            this.writePos = n2 + this.writePos;
            this.skip(n2);
        }
    }

    public abstract void skip(int var1);

    public boolean verifyMatches(Matches matches) {
        int n = Math.min((int)this.getAvail(), (int)this.matchLenMax);
        for (int i = 0; i < matches.count; ++i) {
            if (this.getMatchLen(matches.dist[i], n) == matches.len[i]) continue;
            return false;
        }
        return true;
    }
}

