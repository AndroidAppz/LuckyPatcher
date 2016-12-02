/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 */
package org.tukaani.xz.lzma;

import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.lzma.LZMAEncoder;
import org.tukaani.xz.rangecoder.RangeEncoder;

final class LZMAEncoderFast
extends LZMAEncoder {
    private static int EXTRA_SIZE_AFTER;
    private static int EXTRA_SIZE_BEFORE;
    private Matches matches = null;

    static {
        EXTRA_SIZE_BEFORE = 1;
        EXTRA_SIZE_AFTER = 272;
    }

    LZMAEncoderFast(RangeEncoder rangeEncoder, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        super(rangeEncoder, LZEncoder.getInstance(n4, Math.max((int)n5, (int)EXTRA_SIZE_BEFORE), EXTRA_SIZE_AFTER, n6, 273, n7, n8), n, n2, n3, n4, n6);
    }

    private boolean changePair(int n, int n2) {
        if (n < n2 >>> 7) {
            return true;
        }
        return false;
    }

    static int getMemoryUsage(int n, int n2, int n3) {
        return LZEncoder.getMemoryUsage(n, Math.max((int)n2, (int)EXTRA_SIZE_BEFORE), EXTRA_SIZE_AFTER, 273, n3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    int getNextSymbol() {
        if (this.readAhead == -1) {
            this.matches = this.getMatches();
        }
        this.back = -1;
        var1_1 = Math.min((int)this.lz.getAvail(), (int)273);
        if (var1_1 < 2) {
            return 1;
        }
        var2_2 = 0;
        var3_3 = 0;
        for (var4_4 = 0; var4_4 < 4; ++var4_4) {
            var13_5 = this.lz.getMatchLen(this.reps[var4_4], var1_1);
            if (var13_5 < 2) continue;
            if (var13_5 >= this.niceLen) {
                this.back = var4_4;
                this.skip(var13_5 - 1);
                return var13_5;
            }
            if (var13_5 <= var2_2) continue;
            var3_3 = var4_4;
            var2_2 = var13_5;
        }
        var5_6 = this.matches.count;
        var6_7 = 0;
        var7_8 = 0;
        if (var5_6 <= 0) ** GOTO lbl37
        var7_8 = this.matches.len[-1 + this.matches.count];
        var6_7 = this.matches.dist[-1 + this.matches.count];
        if (var7_8 < this.niceLen) ** GOTO lbl34
        this.back = var6_7 + 4;
        this.skip(var7_8 - 1);
        return var7_8;
lbl-1000: // 1 sources:
        {
            var12_9 = this.matches;
            var12_9.count = -1 + var12_9.count;
            var7_8 = this.matches.len[-1 + this.matches.count];
            var6_7 = this.matches.dist[-1 + this.matches.count];
lbl34: // 2 sources:
            ** while (this.matches.count > 1 && var7_8 == 1 + this.matches.len[-2 + this.matches.count] && this.changePair((int)this.matches.dist[-2 + this.matches.count], (int)var6_7))
        }
lbl35: // 1 sources:
        if (var7_8 == 2 && var6_7 >= 128) {
            var7_8 = 1;
        }
lbl37: // 4 sources:
        if (var2_2 >= 2 && (var2_2 + 1 >= var7_8 || var2_2 + 2 >= var7_8 && var6_7 >= 512 || var2_2 + 3 >= var7_8 && var6_7 >= 32768)) {
            this.back = var3_3;
            this.skip(var2_2 - 1);
            return var2_2;
        }
        if (var7_8 < 2) return 1;
        if (var1_1 <= 2) {
            return 1;
        }
        this.matches = this.getMatches();
        if (this.matches.count > 0) {
            var10_10 = this.matches.len[-1 + this.matches.count];
            var11_11 = this.matches.dist[-1 + this.matches.count];
            if (var10_10 >= var7_8) {
                if (var11_11 < var6_7) return 1;
            }
            if (var10_10 == var7_8 + 1) {
                if (this.changePair(var6_7, var11_11) == false) return 1;
            }
            if (var10_10 > var7_8 + 1) return 1;
            if (var10_10 + 1 >= var7_8 && var7_8 >= 3 && this.changePair(var11_11, var6_7)) {
                return 1;
            }
        }
        var8_12 = Math.max((int)(var7_8 - 1), (int)2);
        var9_13 = 0;
        do {
            if (var9_13 >= 4) {
                this.back = var6_7 + 4;
                this.skip(var7_8 - 2);
                return var7_8;
            }
            if (this.lz.getMatchLen(this.reps[var9_13], var8_12) == var8_12) {
                return 1;
            }
            ++var9_13;
        } while (true);
    }
}

