/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 */
package org.tukaani.xz.lz;

import org.tukaani.xz.lz.Hash234;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;

final class HC4
extends LZEncoder {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final int[] chain;
    private int cyclicPos = -1;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !HC4.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    HC4(int n, int n2, int n3, int n4, int n5, int n6) {
        super(n, n2, n3, n4, n5);
        this.hash = new Hash234(n);
        this.cyclicSize = n + 1;
        this.chain = new int[this.cyclicSize];
        this.lzPos = this.cyclicSize;
        this.matches = new Matches(n4 - 1);
        if (n6 <= 0) {
            n6 = 4 + n4 / 4;
        }
        this.depthLimit = n6;
    }

    static int getMemoryUsage(int n) {
        return 10 + (Hash234.getMemoryUsage(n) + n / 256);
    }

    private int movePos() {
        int n = this.movePos(4, 4);
        if (n != 0) {
            int n2;
            int n3;
            this.lzPos = n2 = 1 + this.lzPos;
            if (n2 == Integer.MAX_VALUE) {
                int n4 = Integer.MAX_VALUE - this.cyclicSize;
                this.hash.normalize(n4);
                HC4.normalize(this.chain, n4);
                this.lzPos -= n4;
            }
            this.cyclicPos = n3 = 1 + this.cyclicPos;
            if (n3 == this.cyclicSize) {
                this.cyclicPos = 0;
            }
        }
        return n;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Matches getMatches() {
        this.matches.count = 0;
        int n = this.matchLenMax;
        int n2 = this.niceLen;
        int n3 = this.movePos();
        if (n3 < n) {
            if (n3 == 0) {
                return this.matches;
            }
            n = n3;
            if (n2 > n3) {
                n2 = n3;
            }
        }
        this.hash.calcHashes(this.buf, this.readPos);
        int n4 = this.lzPos - this.hash.getHash2Pos();
        int n5 = this.lzPos - this.hash.getHash3Pos();
        int n6 = this.hash.getHash4Pos();
        this.hash.updateTables(this.lzPos);
        this.chain[this.cyclicPos] = n6;
        int n7 = this.cyclicSize;
        int n8 = 0;
        if (n4 < n7) {
            byte by = this.buf[this.readPos - n4];
            byte by2 = this.buf[this.readPos];
            n8 = 0;
            if (by == by2) {
                n8 = 2;
                this.matches.len[0] = 2;
                this.matches.dist[0] = n4 - 1;
                this.matches.count = 1;
            }
        }
        if (n4 != n5 && n5 < this.cyclicSize && this.buf[this.readPos - n5] == this.buf[this.readPos]) {
            n8 = 3;
            int[] arrn = this.matches.dist;
            Matches matches = this.matches;
            int n9 = matches.count;
            matches.count = n9 + 1;
            arrn[n9] = n5 - 1;
            n4 = n5;
        }
        if (this.matches.count > 0) {
            while (n8 < n && this.buf[n8 + this.readPos - n4] == this.buf[n8 + this.readPos]) {
                ++n8;
            }
            this.matches.len[-1 + this.matches.count] = n8;
            if (n8 >= n2) {
                return this.matches;
            }
        }
        if (n8 < 3) {
            n8 = 3;
        }
        int n10 = this.depthLimit;
        do {
            int n11 = this.lzPos - n6;
            int n12 = n10 - 1;
            if (n10 == 0 || n11 >= this.cyclicSize) {
                return this.matches;
            }
            int[] arrn = this.chain;
            int n13 = this.cyclicPos - n11;
            int n14 = n11 > this.cyclicPos ? this.cyclicSize : 0;
            n6 = arrn[n14 + n13];
            if (this.buf[n8 + this.readPos - n11] == this.buf[n8 + this.readPos] && this.buf[this.readPos - n11] == this.buf[this.readPos]) {
                int n15 = 0;
                while (++n15 < n && this.buf[n15 + this.readPos - n11] == this.buf[n15 + this.readPos]) {
                }
                if (n15 > n8) {
                    n8 = n15;
                    this.matches.len[this.matches.count] = n15;
                    this.matches.dist[this.matches.count] = n11 - 1;
                    Matches matches = this.matches;
                    matches.count = 1 + matches.count;
                    if (n15 >= n2) {
                        return this.matches;
                    }
                }
            }
            n10 = n12;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void skip(int var1) {
        if (HC4.$assertionsDisabled || var1 >= 0) ** GOTO lbl11
        throw new AssertionError();
lbl-1000: // 2 sources:
        {
            var1 = var2_2 - 1;
            if (var2_2 <= 0) return;
            if (super.movePos() != 0) {
                this.hash.calcHashes(this.buf, this.readPos);
                this.chain[this.cyclicPos] = this.hash.getHash4Pos();
                this.hash.updateTables(this.lzPos);
                var2_2 = var1;
                continue;
            }
lbl11: // 3 sources:
            var2_2 = var1;
            ** while (true)
        }
    }
}

