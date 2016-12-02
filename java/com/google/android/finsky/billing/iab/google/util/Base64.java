/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.google.android.finsky.billing.iab.google.util;

import com.google.android.finsky.billing.iab.google.util.Base64DecoderException;

public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] ALPHABET;
    private static final byte[] DECODABET;
    public static final boolean DECODE = false;
    public static final boolean ENCODE = true;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte NEW_LINE = 10;
    private static final byte[] WEBSAFE_ALPHABET;
    private static final byte[] WEBSAFE_DECODABET;
    private static final byte WHITE_SPACE_ENC = -5;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !Base64.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
        ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        WEBSAFE_ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
        WEBSAFE_DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    }

    private Base64() {
    }

    public static byte[] decode(String string) throws Base64DecoderException {
        byte[] arrby = string.getBytes();
        return Base64.decode(arrby, 0, arrby.length);
    }

    public static byte[] decode(byte[] arrby) throws Base64DecoderException {
        return Base64.decode(arrby, 0, arrby.length);
    }

    public static byte[] decode(byte[] arrby, int n, int n2) throws Base64DecoderException {
        return Base64.decode(arrby, n, n2, DECODABET);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static byte[] decode(byte[] var0_1, int var1, int var2_3, byte[] var3_2) throws Base64DecoderException {
        var4_4 = new byte[2 + var2_3 * 3 / 4];
        var5_5 = 0;
        var6_6 = new byte[4];
        var8_8 = 0;
        for (var7_7 = 0; var7_7 < var2_3; ++var7_7) {
            var12_10 = (byte)(127 & var0_1[var7_7 + var1]);
            var13_9 = var3_2[var12_10];
            if (var13_9 < -5) throw new Base64DecoderException("Bad Base64 input character at " + var7_7 + ": " + var0_1[var7_7 + var1] + "(decimal)");
            if (var13_9 < -1) ** GOTO lbl35
            if (var12_10 != 61) {
                var14_11 = var8_8 + 1;
                var6_6[var8_8] = var12_10;
                if (var14_11 == 4) {
                    var5_5 += Base64.decode4to3(var6_6, 0, var4_4, var5_5, var3_2);
                    var14_11 = 0;
                }
            } else {
                var15_12 = var2_3 - var7_7;
                var16_13 = (byte)(127 & var0_1[var1 + (var2_3 - 1)]);
                if (var8_8 == 0) throw new Base64DecoderException("invalid padding byte '=' at byte offset " + var7_7);
                if (var8_8 == 1) {
                    throw new Base64DecoderException("invalid padding byte '=' at byte offset " + var7_7);
                }
                if (var8_8 == 3) {
                    if (var15_12 > 2) throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + var7_7);
                }
                if (var8_8 == 4 && var15_12 > 1) {
                    throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + var7_7);
                }
                if (var16_13 != 61 && var16_13 != 10) {
                    throw new Base64DecoderException("encoded value has invalid trailing byte");
                }
                if (var8_8 == 0) break;
                if (var8_8 == 1) {
                    throw new Base64DecoderException("single trailing character at offset " + (var2_3 - 1));
                }
                var8_8 + 1;
                var6_6[var8_8] = 61;
                var5_5 += Base64.decode4to3(var6_6, 0, var4_4, var5_5, var3_2);
                break;
lbl35: // 1 sources:
                var14_11 = var8_8;
            }
            var8_8 = var14_11;
        }
        var10_14 = new byte[var5_5];
        System.arraycopy((Object)var4_4, (int)0, (Object)var10_14, (int)0, (int)var5_5);
        return var10_14;
    }

    private static int decode4to3(byte[] arrby, int n, byte[] arrby2, int n2, byte[] arrby3) {
        if (arrby[n + 2] == 61) {
            arrby2[n2] = (byte)((arrby3[arrby[n]] << 24 >>> 6 | arrby3[arrby[n + 1]] << 24 >>> 12) >>> 16);
            return 1;
        }
        if (arrby[n + 3] == 61) {
            int n3 = arrby3[arrby[n]] << 24 >>> 6 | arrby3[arrby[n + 1]] << 24 >>> 12 | arrby3[arrby[n + 2]] << 24 >>> 18;
            arrby2[n2] = (byte)(n3 >>> 16);
            arrby2[n2 + 1] = (byte)(n3 >>> 8);
            return 2;
        }
        int n4 = arrby3[arrby[n]] << 24 >>> 6 | arrby3[arrby[n + 1]] << 24 >>> 12 | arrby3[arrby[n + 2]] << 24 >>> 18 | arrby3[arrby[n + 3]] << 24 >>> 24;
        arrby2[n2] = (byte)(n4 >> 16);
        arrby2[n2 + 1] = (byte)(n4 >> 8);
        arrby2[n2 + 2] = (byte)n4;
        return 3;
    }

    public static byte[] decodeWebSafe(String string) throws Base64DecoderException {
        byte[] arrby = string.getBytes();
        return Base64.decodeWebSafe(arrby, 0, arrby.length);
    }

    public static byte[] decodeWebSafe(byte[] arrby) throws Base64DecoderException {
        return Base64.decodeWebSafe(arrby, 0, arrby.length);
    }

    public static byte[] decodeWebSafe(byte[] arrby, int n, int n2) throws Base64DecoderException {
        return Base64.decode(arrby, n, n2, WEBSAFE_DECODABET);
    }

    public static String encode(byte[] arrby) {
        return Base64.encode(arrby, 0, arrby.length, ALPHABET, true);
    }

    public static String encode(byte[] arrby, int n, int n2, byte[] arrby2, boolean bl) {
        byte[] arrby3 = Base64.encode(arrby, n, n2, arrby2, Integer.MAX_VALUE);
        int n3 = arrby3.length;
        while (!bl && n3 > 0 && arrby3[n3 - 1] == 61) {
            --n3;
        }
        return new String(arrby3, 0, n3);
    }

    public static byte[] encode(byte[] arrby, int n, int n2, byte[] arrby2, int n3) {
        int n4 = 4 * ((n2 + 2) / 3);
        byte[] arrby3 = new byte[n4 + n4 / n3];
        int n5 = 0;
        int n6 = 0;
        int n7 = n2 - 2;
        int n8 = 0;
        while (n5 < n7) {
            int n9 = arrby[n5 + n] << 24 >>> 8 | arrby[n + (n5 + 1)] << 24 >>> 16 | arrby[n + (n5 + 2)] << 24 >>> 24;
            arrby3[n6] = arrby2[n9 >>> 18];
            arrby3[n6 + 1] = arrby2[63 & n9 >>> 12];
            arrby3[n6 + 2] = arrby2[63 & n9 >>> 6];
            arrby3[n6 + 3] = arrby2[n9 & 63];
            if ((n8 += 4) == n3) {
                arrby3[n6 + 4] = 10;
                ++n6;
                n8 = 0;
            }
            n5 += 3;
            n6 += 4;
        }
        if (n5 < n2) {
            Base64.encode3to4(arrby, n5 + n, n2 - n5, arrby3, n6, arrby2);
            if (n8 + 4 == n3) {
                arrby3[n6 + 4] = 10;
                ++n6;
            }
            n6 += 4;
        }
        if (!$assertionsDisabled && n6 != arrby3.length) {
            throw new AssertionError();
        }
        return arrby3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static byte[] encode3to4(byte[] arrby, int n, int n2, byte[] arrby2, int n3, byte[] arrby3) {
        int n4 = n2 > 0 ? arrby[n] << 24 >>> 8 : 0;
        int n5 = n2 > 1 ? arrby[n + 1] << 24 >>> 16 : 0;
        int n6 = n5 | n4;
        int n7 = 0;
        if (n2 > 2) {
            n7 = arrby[n + 2] << 24 >>> 24;
        }
        int n8 = n6 | n7;
        switch (n2) {
            default: {
                return arrby2;
            }
            case 3: {
                arrby2[n3] = arrby3[n8 >>> 18];
                arrby2[n3 + 1] = arrby3[63 & n8 >>> 12];
                arrby2[n3 + 2] = arrby3[63 & n8 >>> 6];
                arrby2[n3 + 3] = arrby3[n8 & 63];
                return arrby2;
            }
            case 2: {
                arrby2[n3] = arrby3[n8 >>> 18];
                arrby2[n3 + 1] = arrby3[63 & n8 >>> 12];
                arrby2[n3 + 2] = arrby3[63 & n8 >>> 6];
                arrby2[n3 + 3] = 61;
                return arrby2;
            }
            case 1: 
        }
        arrby2[n3] = arrby3[n8 >>> 18];
        arrby2[n3 + 1] = arrby3[63 & n8 >>> 12];
        arrby2[n3 + 2] = 61;
        arrby2[n3 + 3] = 61;
        return arrby2;
    }

    public static String encodeWebSafe(byte[] arrby, boolean bl) {
        return Base64.encode(arrby, 0, arrby.length, WEBSAFE_ALPHABET, bl);
    }
}

