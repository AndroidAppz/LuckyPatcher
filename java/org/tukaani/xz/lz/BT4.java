/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 */
package org.tukaani.xz.lz;

import org.tukaani.xz.lz.Hash234;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;

final class BT4
extends LZEncoder {
    private int cyclicPos = -1;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;
    private final int[] tree;

    /*
     * Enabled aggressive block sorting
     */
    BT4(int n, int n2, int n3, int n4, int n5, int n6) {
        super(n, n2, n3, n4, n5);
        this.lzPos = this.cyclicSize = n + 1;
        this.hash = new Hash234(n);
        this.tree = new int[2 * this.cyclicSize];
        this.matches = new Matches(n4 - 1);
        if (n6 <= 0) {
            n6 = 16 + n4 / 2;
        }
        this.depthLimit = n6;
    }

    static int getMemoryUsage(int n) {
        return 10 + (Hash234.getMemoryUsage(n) + n / 128);
    }

    private int movePos() {
        int n = this.movePos(this.niceLen, 4);
        if (n != 0) {
            int n2;
            int n3;
            this.lzPos = n2 = 1 + this.lzPos;
            if (n2 == Integer.MAX_VALUE) {
                int n4 = Integer.MAX_VALUE - this.cyclicSize;
                this.hash.normalize(n4);
                BT4.normalize(this.tree, n4);
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
    private void skip(int n, int n2) {
        int n3 = this.depthLimit;
        int n4 = 1 + (this.cyclicPos << 1);
        int n5 = this.cyclicPos << 1;
        int n6 = 0;
        int n7 = 0;
        do {
            int n8 = this.lzPos - n2;
            int n9 = n3 - 1;
            if (n3 == 0 || n8 >= this.cyclicSize) {
                this.tree[n4] = 0;
                this.tree[n5] = 0;
                return;
            }
            int n10 = this.cyclicPos - n8;
            int n11 = n8 > this.cyclicPos ? this.cyclicSize : 0;
            int n12 = n11 + n10 << 1;
            int n13 = Math.min((int)n6, (int)n7);
            if (this.buf[n13 + this.readPos - n8] == this.buf[n13 + this.readPos]) {
                do {
                    if (++n13 != n) continue;
                    this.tree[n5] = this.tree[n12];
                    this.tree[n4] = this.tree[n12 + 1];
                    return;
                } while (this.buf[n13 + this.readPos - n8] == this.buf[n13 + this.readPos]);
            }
            if ((255 & this.buf[n13 + this.readPos - n8]) < (255 & this.buf[n13 + this.readPos])) {
                this.tree[n5] = n2;
                n5 = n12 + 1;
                n2 = this.tree[n5];
                n7 = n13;
            } else {
                this.tree[n4] = n2;
                n4 = n12;
                n2 = this.tree[n4];
                n6 = n13;
            }
            n3 = n9;
        } while (true);
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
                this.skip(n2, n6);
                return this.matches;
            }
        }
        if (n8 < 3) {
            n8 = 3;
        }
        int n10 = this.depthLimit;
        int n11 = 1 + (this.cyclicPos << 1);
        int n12 = this.cyclicPos << 1;
        int n13 = 0;
        int n14 = 0;
        do {
            int n15 = this.lzPos - n6;
            int n16 = n10 - 1;
            if (n10 == 0 || n15 >= this.cyclicSize) {
                this.tree[n11] = 0;
                this.tree[n12] = 0;
                return this.matches;
            }
            int n17 = this.cyclicPos - n15;
            int n18 = n15 > this.cyclicPos ? this.cyclicSize : 0;
            int n19 = n18 + n17 << 1;
            int n20 = Math.min((int)n13, (int)n14);
            if (this.buf[n20 + this.readPos - n15] == this.buf[n20 + this.readPos]) {
                while (++n20 < n && this.buf[n20 + this.readPos - n15] == this.buf[n20 + this.readPos]) {
                }
                if (n20 > n8) {
                    n8 = n20;
                    this.matches.len[this.matches.count] = n20;
                    this.matches.dist[this.matches.count] = n15 - 1;
                    Matches matches = this.matches;
                    matches.count = 1 + matches.count;
                    if (n20 >= n2) {
                        this.tree[n12] = this.tree[n19];
                        this.tree[n11] = this.tree[n19 + 1];
                        return this.matches;
                    }
                }
            }
            if ((255 & this.buf[n20 + this.readPos - n15]) < (255 & this.buf[n20 + this.readPos])) {
                this.tree[n12] = n6;
                n12 = n19 + 1;
                n6 = this.tree[n12];
                n14 = n20;
            } else {
                this.tree[n11] = n6;
                n11 = n19;
                n6 = this.tree[n11];
                n13 = n20;
            }
            n10 = n16;
        } while (true);
    }

    @Override
    public void skip(int n) {
        int n2 = n;
        do {
            int n3 = n2 - 1;
            if (n2 <= 0) break;
            int n4 = this.niceLen;
            int n5 = super.movePos();
            if (n5 < n4) {
                if (n5 == 0) {
                    n2 = n3;
                    continue;
                }
                n4 = n5;
            }
            this.hash.calcHashes(this.buf, this.readPos);
            int n6 = this.hash.getHash4Pos();
            this.hash.updateTables(this.lzPos);
            super.skip(n4, n6);
            n2 = n3;
        } while (true);
    }
}

