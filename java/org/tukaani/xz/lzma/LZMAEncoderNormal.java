/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 */
package org.tukaani.xz.lzma;

import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.lzma.LZMAEncoder;
import org.tukaani.xz.lzma.Optimum;
import org.tukaani.xz.lzma.State;
import org.tukaani.xz.rangecoder.RangeEncoder;

final class LZMAEncoderNormal
extends LZMAEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int EXTRA_SIZE_AFTER = 0;
    private static int EXTRA_SIZE_BEFORE = 0;
    private static final int OPTS = 4096;
    private Matches matches;
    private final State nextState = new State();
    private int optCur = 0;
    private int optEnd = 0;
    private final Optimum[] opts = new Optimum[4096];
    private final int[] repLens = new int[4];

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !LZMAEncoderNormal.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
        EXTRA_SIZE_BEFORE = 4096;
        EXTRA_SIZE_AFTER = 4096;
    }

    LZMAEncoderNormal(RangeEncoder rangeEncoder, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        super(rangeEncoder, LZEncoder.getInstance(n4, Math.max((int)n5, (int)EXTRA_SIZE_BEFORE), EXTRA_SIZE_AFTER, n6, 273, n7, n8), n, n2, n3, n4, n6);
        for (int i = 0; i < 4096; ++i) {
            this.opts[i] = new Optimum();
        }
    }

    private void calc1BytePrices(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8 = this.lz.getByte(0);
        int n9 = this.lz.getByte(1 + this.opts[this.optCur].reps[0]);
        int n10 = this.opts[this.optCur].price + this.literalEncoder.getPrice(n8, n9, this.lz.getByte(1), n, this.opts[this.optCur].state);
        int n11 = this.opts[1 + this.optCur].price;
        boolean bl = false;
        if (n10 < n11) {
            this.opts[1 + this.optCur].set1(n10, this.optCur, -1);
            bl = true;
        }
        if (n9 == n8 && (this.opts[1 + this.optCur].optPrev == this.optCur || this.opts[1 + this.optCur].backPrev != 0) && (n7 = this.getShortRepPrice(n4, this.opts[this.optCur].state, n2)) <= this.opts[1 + this.optCur].price) {
            this.opts[1 + this.optCur].set1(n7, this.optCur, 0);
            bl = true;
        }
        if (!bl && n9 != n8 && n3 > 2 && (n5 = this.lz.getMatchLen(1, this.opts[this.optCur].reps[0], n6 = Math.min((int)this.niceLen, (int)(n3 - 1)))) >= 2) {
            this.nextState.set(this.opts[this.optCur].state);
            this.nextState.updateLiteral();
            int n12 = n + 1 & this.posMask;
            int n13 = n10 + this.getLongRepAndLenPrice(0, n5, this.nextState, n12);
            int n14 = n5 + (1 + this.optCur);
            while (this.optEnd < n14) {
                int n15;
                Optimum[] arroptimum = this.opts;
                this.optEnd = n15 = 1 + this.optEnd;
                arroptimum[n15].reset();
            }
            if (n13 < this.opts[n14].price) {
                this.opts[n14].set2(n13, this.optCur, 0);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private int calcLongRepPrices(int n, int n2, int n3, int n4) {
        int n5 = 2;
        int n6 = Math.min((int)n3, (int)this.niceLen);
        int n7 = 0;
        while (n7 < 4) {
            int n8 = this.lz.getMatchLen(this.opts[this.optCur].reps[n7], n6);
            if (n8 >= 2) {
                int n9;
                int n10;
                while (this.optEnd < n8 + this.optCur) {
                    int n11;
                    Optimum[] arroptimum = this.opts;
                    this.optEnd = n11 = 1 + this.optEnd;
                    arroptimum[n11].reset();
                }
                int n12 = this.getLongRepPrice(n4, n7, this.opts[this.optCur].state, n2);
                for (int i = n8; i >= 2; --i) {
                    int n13 = n12 + this.repLenEncoder.getPrice(i, n2);
                    if (n13 >= this.opts[i + this.optCur].price) continue;
                    this.opts[i + this.optCur].set1(n13, this.optCur, n7);
                }
                if (n7 == 0) {
                    n5 = n8 + 1;
                }
                if ((n9 = this.lz.getMatchLen(n8 + 1, this.opts[this.optCur].reps[n7], n10 = Math.min((int)this.niceLen, (int)(-1 + (n3 - n8))))) >= 2) {
                    int n14 = n12 + this.repLenEncoder.getPrice(n8, n2);
                    this.nextState.set(this.opts[this.optCur].state);
                    this.nextState.updateLongRep();
                    int n15 = this.lz.getByte(n8, 0);
                    int n16 = this.lz.getByte(0);
                    int n17 = this.lz.getByte(n8, 1);
                    int n18 = n14 + this.literalEncoder.getPrice(n15, n16, n17, n + n8, this.nextState);
                    this.nextState.updateLiteral();
                    int n19 = 1 + (n + n8) & this.posMask;
                    int n20 = n18 + this.getLongRepAndLenPrice(0, n9, this.nextState, n19);
                    int n21 = n9 + (1 + (n8 + this.optCur));
                    while (this.optEnd < n21) {
                        int n22;
                        Optimum[] arroptimum = this.opts;
                        this.optEnd = n22 = 1 + this.optEnd;
                        arroptimum[n22].reset();
                    }
                    if (n20 < this.opts[n21].price) {
                        this.opts[n21].set3(n20, this.optCur, n7, n8, 0);
                    }
                }
            }
            ++n7;
        }
        return n5;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void calcNormalMatchPrices(int n, int n2, int n3, int n4, int n5) {
        if (this.matches.len[-1 + this.matches.count] > n3) {
            this.matches.count = 0;
            while (this.matches.len[this.matches.count] < n3) {
                Matches matches = this.matches;
                matches.count = 1 + matches.count;
            }
            int[] arrn = this.matches.len;
            Matches matches = this.matches;
            int n6 = matches.count;
            matches.count = n6 + 1;
            arrn[n6] = n3;
        }
        if (this.matches.len[-1 + this.matches.count] < n5) {
            return;
        }
        while (this.optEnd < this.optCur + this.matches.len[-1 + this.matches.count]) {
            int n7;
            Optimum[] arroptimum = this.opts;
            this.optEnd = n7 = 1 + this.optEnd;
            arroptimum[n7].reset();
        }
        int n8 = this.getNormalMatchPrice(n4, this.opts[this.optCur].state);
        int n9 = 0;
        while (n5 > this.matches.len[n9]) {
            ++n9;
        }
        int n10 = n5;
        do {
            int n11;
            int n12;
            if ((n12 = this.getMatchAndLenPrice(n8, n11 = this.matches.dist[n9], n10, n2)) < this.opts[n10 + this.optCur].price) {
                this.opts[n10 + this.optCur].set1(n12, this.optCur, n11 + 4);
            }
            if (n10 == this.matches.len[n9]) {
                int n13;
                int n14 = Math.min((int)this.niceLen, (int)(-1 + (n3 - n10)));
                int n15 = this.lz.getMatchLen(n10 + 1, n11, n14);
                if (n15 >= 2) {
                    this.nextState.set(this.opts[this.optCur].state);
                    this.nextState.updateMatch();
                    int n16 = this.lz.getByte(n10, 0);
                    int n17 = this.lz.getByte(0);
                    int n18 = this.lz.getByte(n10, 1);
                    int n19 = n12 + this.literalEncoder.getPrice(n16, n17, n18, n + n10, this.nextState);
                    this.nextState.updateLiteral();
                    int n20 = 1 + (n + n10) & this.posMask;
                    int n21 = n19 + this.getLongRepAndLenPrice(0, n15, this.nextState, n20);
                    int n22 = n15 + (1 + (n10 + this.optCur));
                    while (this.optEnd < n22) {
                        int n23;
                        Optimum[] arroptimum = this.opts;
                        this.optEnd = n23 = 1 + this.optEnd;
                        arroptimum[n23].reset();
                    }
                    if (n21 < this.opts[n22].price) {
                        this.opts[n22].set3(n21, this.optCur, n11 + 4, n10, 0);
                    }
                }
                if (++n9 == (n13 = this.matches.count)) {
                    return;
                }
            }
            ++n10;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int convertOpts() {
        this.optEnd = this.optCur;
        int n = this.opts[this.optCur].optPrev;
        do {
            Optimum optimum = this.opts[this.optCur];
            if (optimum.prev1IsLiteral) {
                this.opts[n].optPrev = this.optCur;
                this.opts[n].backPrev = -1;
                int n2 = n - 1;
                this.optCur = n;
                if (optimum.hasPrev2) {
                    this.opts[n2].optPrev = n2 + 1;
                    this.opts[n2].backPrev = optimum.backPrev2;
                    this.optCur = n2;
                    n = optimum.optPrev2;
                } else {
                    n = n2;
                }
            }
            int n3 = this.opts[n].optPrev;
            this.opts[n].optPrev = this.optCur;
            this.optCur = n;
            n = n3;
        } while (this.optCur > 0);
        this.optCur = this.opts[0].optPrev;
        this.back = this.opts[this.optCur].backPrev;
        return this.optCur;
    }

    static int getMemoryUsage(int n, int n2, int n3) {
        return 256 + LZEncoder.getMemoryUsage(n, Math.max((int)n2, (int)EXTRA_SIZE_BEFORE), EXTRA_SIZE_AFTER, 273, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void updateOptStateAndReps() {
        int n = this.opts[this.optCur].optPrev;
        if (!$assertionsDisabled && n >= this.optCur) {
            throw new AssertionError();
        }
        if (this.opts[this.optCur].prev1IsLiteral) {
            --n;
            if (this.opts[this.optCur].hasPrev2) {
                this.opts[this.optCur].state.set(this.opts[this.opts[this.optCur].optPrev2].state);
                if (this.opts[this.optCur].backPrev2 < 4) {
                    this.opts[this.optCur].state.updateLongRep();
                } else {
                    this.opts[this.optCur].state.updateMatch();
                }
            } else {
                this.opts[this.optCur].state.set(this.opts[n].state);
            }
            this.opts[this.optCur].state.updateLiteral();
        } else {
            this.opts[this.optCur].state.set(this.opts[n].state);
        }
        if (n == -1 + this.optCur) {
            if (!$assertionsDisabled && this.opts[this.optCur].backPrev != 0 && this.opts[this.optCur].backPrev != -1) {
                throw new AssertionError();
            }
            if (this.opts[this.optCur].backPrev == 0) {
                this.opts[this.optCur].state.updateShortRep();
            } else {
                this.opts[this.optCur].state.updateLiteral();
            }
            System.arraycopy((Object)this.opts[n].reps, (int)0, (Object)this.opts[this.optCur].reps, (int)0, (int)4);
            return;
        } else {
            int n2;
            int n3;
            if (this.opts[this.optCur].prev1IsLiteral && this.opts[this.optCur].hasPrev2) {
                n = this.opts[this.optCur].optPrev2;
                n3 = this.opts[this.optCur].backPrev2;
                this.opts[this.optCur].state.updateLongRep();
            } else {
                n3 = this.opts[this.optCur].backPrev;
                if (n3 < 4) {
                    this.opts[this.optCur].state.updateLongRep();
                } else {
                    this.opts[this.optCur].state.updateMatch();
                }
            }
            if (n3 >= 4) {
                this.opts[this.optCur].reps[0] = n3 - 4;
                System.arraycopy((Object)this.opts[n].reps, (int)0, (Object)this.opts[this.optCur].reps, (int)1, (int)3);
                return;
            }
            this.opts[this.optCur].reps[0] = this.opts[n].reps[n3];
            for (n2 = 1; n2 <= n3; ++n2) {
                this.opts[this.optCur].reps[n2] = this.opts[n].reps[n2 - 1];
            }
            while (n2 < 4) {
                this.opts[this.optCur].reps[n2] = this.opts[n].reps[n2];
                ++n2;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    int getNextSymbol() {
        if (this.optCur < this.optEnd) {
            var38_1 = this.opts[this.optCur].optPrev - this.optCur;
            this.optCur = this.opts[this.optCur].optPrev;
            this.back = this.opts[this.optCur].backPrev;
            return var38_1;
        }
        if (!LZMAEncoderNormal.$assertionsDisabled && this.optCur != this.optEnd) {
            throw new AssertionError();
        }
        this.optCur = 0;
        this.optEnd = 0;
        this.back = -1;
        if (this.readAhead == -1) {
            this.matches = this.getMatches();
        }
        if ((var1_2 = Math.min((int)this.lz.getAvail(), (int)273)) < 2) {
            return 1;
        }
        var2_3 = 0;
        for (var3_4 = 0; var3_4 < 4; ++var3_4) {
            this.repLens[var3_4] = this.lz.getMatchLen(this.reps[var3_4], var1_2);
            if (this.repLens[var3_4] < 2) {
                this.repLens[var3_4] = 0;
                continue;
            }
            if (this.repLens[var3_4] <= this.repLens[var2_3]) continue;
            var2_3 = var3_4;
        }
        if (this.repLens[var2_3] >= this.niceLen) {
            this.back = var2_3;
            this.skip(-1 + this.repLens[var2_3]);
            return this.repLens[var2_3];
        }
        var4_5 = this.matches.count;
        var5_6 = 0;
        if (var4_5 > 0) {
            var5_6 = this.matches.len[-1 + this.matches.count];
            var36_7 = this.matches.dist[-1 + this.matches.count];
            var37_8 = this.niceLen;
            if (var5_6 >= var37_8) {
                this.back = var36_7 + 4;
                this.skip(var5_6 - 1);
                return var5_6;
            }
        }
        var6_9 = this.lz.getByte(0);
        var7_10 = this.lz.getByte(1 + this.reps[0]);
        if (var5_6 < 2 && var6_9 != var7_10 && this.repLens[var2_3] < 2) {
            return 1;
        }
        var8_11 = this.lz.getPos();
        var9_12 = var8_11 & this.posMask;
        var10_13 = this.lz.getByte(1);
        var11_14 = this.literalEncoder.getPrice(var6_9, var7_10, var10_13, var8_11, this.state);
        this.opts[1].set1(var11_14, 0, -1);
        var12_15 = this.getAnyMatchPrice(this.state, var9_12);
        var13_16 = this.getAnyRepPrice(var12_15, this.state);
        if (var7_10 == var6_9 && (var35_17 = this.getShortRepPrice(var13_16, this.state, var9_12)) < this.opts[1].price) {
            this.opts[1].set1(var35_17, 0, 0);
        }
        var14_18 = this.repLens[var2_3];
        this.optEnd = Math.max((int)var5_6, (int)var14_18);
        if (this.optEnd < 2) {
            if (!LZMAEncoderNormal.$assertionsDisabled && this.optEnd != 0) {
                throw new AssertionError(this.optEnd);
            }
            this.back = this.opts[1].backPrev;
            return 1;
        }
        this.updatePrices();
        this.opts[0].state.set(this.state);
        System.arraycopy((Object)this.reps, (int)0, (Object)this.opts[0].reps, (int)0, (int)4);
        for (var15_19 = this.optEnd; var15_19 >= 2; --var15_19) {
            this.opts[var15_19].reset();
        }
        for (var16_20 = 0; var16_20 < 4; ++var16_20) {
            var31_24 = this.repLens[var16_20];
            if (var31_24 < 2) continue;
            var32_23 = this.state;
            var33_21 = this.getLongRepPrice(var13_16, var16_20, var32_23, var9_12);
            do {
                if ((var34_22 = var33_21 + this.repLenEncoder.getPrice(var31_24, var9_12)) >= this.opts[var31_24].price) continue;
                this.opts[var31_24].set1(var34_22, 0, var16_20);
            } while (--var31_24 >= 2);
        }
        var17_25 = Math.max((int)(1 + this.repLens[0]), (int)2);
        if (var17_25 > var5_6) ** GOTO lbl86
        var24_26 = this.getNormalMatchPrice(var12_15, this.state);
        var25_27 = 0;
        while (var17_25 > (var26_28 = this.matches.len[var25_27])) {
            ++var25_27;
        }
        ** GOTO lbl83
lbl82: // 1 sources:
        ++var17_25;
lbl83: // 2 sources:
        if ((var28_29 = this.getMatchAndLenPrice(var24_26, var27_32 = this.matches.dist[var25_27], var17_25, var9_12)) < this.opts[var17_25].price) {
            this.opts[var17_25].set1(var28_29, 0, var27_32 + 4);
        }
        if (var17_25 != (var29_31 = this.matches.len[var25_27]) || ++var25_27 != (var30_30 = this.matches.count)) ** GOTO lbl82
lbl86: // 2 sources:
        var18_33 = Math.min((int)this.lz.getAvail(), (int)4095);
        do {
            this.optCur = var19_37 = 1 + this.optCur;
            if (var19_37 >= this.optEnd) return this.convertOpts();
            this.matches = this.getMatches();
            if (this.matches.count > 0 && this.matches.len[-1 + this.matches.count] >= this.niceLen) {
                return this.convertOpts();
            }
            var20_36 = ++var8_11 & this.posMask;
            this.updateOptStateAndReps();
            var21_35 = this.opts[this.optCur].price + this.getAnyMatchPrice(this.opts[this.optCur].state, var20_36);
            var22_38 = this.getAnyRepPrice(var21_35, this.opts[this.optCur].state);
            this.calc1BytePrices(var8_11, var20_36, --var18_33, var22_38);
            if (var18_33 < 2) continue;
            var23_34 = this.calcLongRepPrices(var8_11, var20_36, var18_33, var22_38);
            if (this.matches.count <= 0) continue;
            this.calcNormalMatchPrices(var8_11, var20_36, var18_33, var21_35, var23_34);
        } while (true);
    }

    @Override
    public void reset() {
        this.optCur = 0;
        this.optEnd = 0;
        super.reset();
    }
}

