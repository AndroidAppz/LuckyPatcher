/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.simple;

import org.tukaani.xz.simple.SimpleFilter;

public final class X86
implements SimpleFilter {
    private static final boolean[] MASK_TO_ALLOWED_STATUS = new boolean[]{true, true, true, false, true, false, false, false};
    private static final int[] MASK_TO_BIT_NUMBER = new int[]{0, 1, 2, 2, 3, 3, 3, 3};
    private final boolean isEncoder;
    private int pos;
    private int prevMask = 0;

    public X86(boolean bl, int n) {
        this.isEncoder = bl;
        this.pos = n + 5;
    }

    private static boolean test86MSByte(byte by) {
        int n = by & 255;
        if (n == 0 || n == 255) {
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public int code(byte[] var1, int var2_3, int var3_2) {
        var4_4 = var2_3 - 1;
        var5_5 = -5 + (var2_3 + var3_2);
        var6_6 = var2_3;
        block0 : do {
            if (var6_6 > var5_5) ** GOTO lbl20
            if ((254 & var1[var6_6]) != 232) ** GOTO lbl29
            var11_7 = var6_6 - var4_4;
            if ((var11_7 & -4) == 0) ** GOTO lbl11
            this.prevMask = 0;
            ** GOTO lbl-1000
lbl11: // 1 sources:
            this.prevMask = 7 & this.prevMask << var11_7 - 1;
            if (this.prevMask != 0 && (!X86.MASK_TO_ALLOWED_STATUS[this.prevMask] || X86.test86MSByte(var1[var6_6 + 4 - X86.MASK_TO_BIT_NUMBER[this.prevMask]]))) {
                var4_4 = var6_6;
                this.prevMask = 1 | this.prevMask << 1;
            } else lbl-1000: // 2 sources:
            {
                var4_4 = var6_6;
                if (X86.test86MSByte(var1[var6_6 + 4])) break;
                this.prevMask = 1 | this.prevMask << 1;
            }
            ** GOTO lbl29
lbl20: // 1 sources:
            var7_11 = var6_6 - var4_4;
            var8_12 = var7_11 & -4;
            var9_13 = 0;
            if (var8_12 == 0) {
                var9_13 = this.prevMask << var7_11 - 1;
            }
            this.prevMask = var9_13;
            var10_14 = var6_6 - var2_3;
            this.pos = var10_14 + this.pos;
            return var10_14;
lbl29: // 4 sources:
            do {
                ++var6_6;
                continue block0;
                break;
            } while (true);
            break;
        } while (true);
        var12_9 = 255 & var1[var6_6 + 1] | (255 & var1[var6_6 + 2]) << 8 | (255 & var1[var6_6 + 3]) << 16 | (255 & var1[var6_6 + 4]) << 24;
        do {
            var13_8 = this.isEncoder != false ? var12_9 + (var6_6 + this.pos - var2_3) : var12_9 - (var6_6 + this.pos - var2_3);
            if (this.prevMask == 0 || !X86.test86MSByte((byte)(var13_8 >>> 24 - (var14_10 = 8 * X86.MASK_TO_BIT_NUMBER[this.prevMask])))) break;
            var12_9 = var13_8 ^ -1 + (1 << 32 - var14_10);
        } while (true);
        var1[var6_6 + 1] = (byte)var13_8;
        var1[var6_6 + 2] = (byte)(var13_8 >>> 8);
        var1[var6_6 + 3] = (byte)(var13_8 >>> 16);
        var1[var6_6 + 4] = (byte)(-1 ^ -1 + (1 & var13_8 >>> 24));
        var6_6 += 4;
        ** while (true)
    }
}

