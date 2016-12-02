/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Array
 */
package net.lingala.zip4j.crypto.engine;

import java.lang.reflect.Array;
import net.lingala.zip4j.exception.ZipException;

public class AESEngine {
    private static final byte[] S = new byte[]{99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, -128, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, -68, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
    private static final int[] T0;
    private static final int[] rcon;
    private int C0;
    private int C1;
    private int C2;
    private int C3;
    private int rounds;
    private int[][] workingKey = null;

    static {
        rcon = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
        T0 = new int[]{-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};
    }

    public AESEngine(byte[] arrby) throws ZipException {
        this.init(arrby);
    }

    private final void encryptBlock(int[][] arrn) {
        this.C0 ^= arrn[0][0];
        this.C1 ^= arrn[0][1];
        this.C2 ^= arrn[0][2];
        this.C3 ^= arrn[0][3];
        int n = 1;
        while (n < -1 + this.rounds) {
            int n2 = T0[255 & this.C0] ^ super.shift(T0[255 & this.C1 >> 8], 24) ^ super.shift(T0[255 & this.C2 >> 16], 16) ^ super.shift(T0[255 & this.C3 >> 24], 8) ^ arrn[n][0];
            int n3 = T0[255 & this.C1] ^ super.shift(T0[255 & this.C2 >> 8], 24) ^ super.shift(T0[255 & this.C3 >> 16], 16) ^ super.shift(T0[255 & this.C0 >> 24], 8) ^ arrn[n][1];
            int n4 = T0[255 & this.C2] ^ super.shift(T0[255 & this.C3 >> 8], 24) ^ super.shift(T0[255 & this.C0 >> 16], 16) ^ super.shift(T0[255 & this.C1 >> 24], 8) ^ arrn[n][2];
            int n5 = T0[255 & this.C3] ^ super.shift(T0[255 & this.C0 >> 8], 24) ^ super.shift(T0[255 & this.C1 >> 16], 16) ^ super.shift(T0[255 & this.C2 >> 24], 8);
            int n6 = n + 1;
            int n7 = n5 ^ arrn[n][3];
            this.C0 = T0[n2 & 255] ^ super.shift(T0[255 & n3 >> 8], 24) ^ super.shift(T0[255 & n4 >> 16], 16) ^ super.shift(T0[255 & n7 >> 24], 8) ^ arrn[n6][0];
            this.C1 = T0[n3 & 255] ^ super.shift(T0[255 & n4 >> 8], 24) ^ super.shift(T0[255 & n7 >> 16], 16) ^ super.shift(T0[255 & n2 >> 24], 8) ^ arrn[n6][1];
            this.C2 = T0[n4 & 255] ^ super.shift(T0[255 & n7 >> 8], 24) ^ super.shift(T0[255 & n2 >> 16], 16) ^ super.shift(T0[255 & n3 >> 24], 8) ^ arrn[n6][2];
            int n8 = T0[n7 & 255] ^ super.shift(T0[255 & n2 >> 8], 24) ^ super.shift(T0[255 & n3 >> 16], 16) ^ super.shift(T0[255 & n4 >> 24], 8);
            n = n6 + 1;
            this.C3 = n8 ^ arrn[n6][3];
        }
        int n9 = T0[255 & this.C0] ^ super.shift(T0[255 & this.C1 >> 8], 24) ^ super.shift(T0[255 & this.C2 >> 16], 16) ^ super.shift(T0[255 & this.C3 >> 24], 8) ^ arrn[n][0];
        int n10 = T0[255 & this.C1] ^ super.shift(T0[255 & this.C2 >> 8], 24) ^ super.shift(T0[255 & this.C3 >> 16], 16) ^ super.shift(T0[255 & this.C0 >> 24], 8) ^ arrn[n][1];
        int n11 = T0[255 & this.C2] ^ super.shift(T0[255 & this.C3 >> 8], 24) ^ super.shift(T0[255 & this.C0 >> 16], 16) ^ super.shift(T0[255 & this.C1 >> 24], 8) ^ arrn[n][2];
        int n12 = T0[255 & this.C3] ^ super.shift(T0[255 & this.C0 >> 8], 24) ^ super.shift(T0[255 & this.C1 >> 16], 16) ^ super.shift(T0[255 & this.C2 >> 24], 8);
        int n13 = n + 1;
        int n14 = n12 ^ arrn[n][3];
        this.C0 = 255 & S[n9 & 255] ^ (255 & S[255 & n10 >> 8]) << 8 ^ (255 & S[255 & n11 >> 16]) << 16 ^ S[255 & n14 >> 24] << 24 ^ arrn[n13][0];
        this.C1 = 255 & S[n10 & 255] ^ (255 & S[255 & n11 >> 8]) << 8 ^ (255 & S[255 & n14 >> 16]) << 16 ^ S[255 & n9 >> 24] << 24 ^ arrn[n13][1];
        this.C2 = 255 & S[n11 & 255] ^ (255 & S[255 & n14 >> 8]) << 8 ^ (255 & S[255 & n9 >> 16]) << 16 ^ S[255 & n10 >> 24] << 24 ^ arrn[n13][2];
        this.C3 = 255 & S[n14 & 255] ^ (255 & S[255 & n9 >> 8]) << 8 ^ (255 & S[255 & n10 >> 16]) << 16 ^ S[255 & n11 >> 24] << 24 ^ arrn[n13][3];
    }

    /*
     * Enabled aggressive block sorting
     */
    private int[][] generateWorkingKey(byte[] arrby) throws ZipException {
        int n = arrby.length / 4;
        if (n != 4 && n != 6 && n != 8 || n * 4 != arrby.length) {
            throw new ZipException("invalid key length (not 128/192/256)");
        }
        this.rounds = n + 6;
        int[] arrn = new int[]{1 + this.rounds, 4};
        int[][] arrn2 = (int[][])Array.newInstance((Class)Integer.TYPE, (int[])arrn);
        int n2 = 0;
        for (int i = 0; i < arrby.length; i += 4, ++n2) {
            arrn2[n2 >> 2][n2 & 3] = 255 & arrby[i] | (255 & arrby[i + 1]) << 8 | (255 & arrby[i + 2]) << 16 | arrby[i + 3] << 24;
        }
        int n3 = 1 + this.rounds << 2;
        int n4 = n;
        while (n4 < n3) {
            int n5 = arrn2[n4 - 1 >> 2][3 & n4 - 1];
            if (n4 % n == 0) {
                n5 = super.subWord(super.shift(n5, 8)) ^ rcon[-1 + n4 / n];
            } else if (n > 6 && n4 % n == 4) {
                n5 = super.subWord(n5);
            }
            arrn2[n4 >> 2][n4 & 3] = n5 ^ arrn2[n4 - n >> 2][3 & n4 - n];
            ++n4;
        }
        return arrn2;
    }

    private int shift(int n, int n2) {
        return n >>> n2 | n << - n2;
    }

    private final void stateIn(byte[] arrby, int n) {
        int n2 = n + 1;
        int n3 = this.C0 = 255 & arrby[n];
        int n4 = n2 + 1;
        int n5 = this.C0 = n3 | (255 & arrby[n2]) << 8;
        int n6 = n4 + 1;
        int n7 = this.C0 = n5 | (255 & arrby[n4]) << 16;
        int n8 = n6 + 1;
        this.C0 = n7 | arrby[n6] << 24;
        int n9 = n8 + 1;
        int n10 = this.C1 = 255 & arrby[n8];
        int n11 = n9 + 1;
        int n12 = this.C1 = n10 | (255 & arrby[n9]) << 8;
        int n13 = n11 + 1;
        int n14 = this.C1 = n12 | (255 & arrby[n11]) << 16;
        int n15 = n13 + 1;
        this.C1 = n14 | arrby[n13] << 24;
        int n16 = n15 + 1;
        int n17 = this.C2 = 255 & arrby[n15];
        int n18 = n16 + 1;
        int n19 = this.C2 = n17 | (255 & arrby[n16]) << 8;
        int n20 = n18 + 1;
        int n21 = this.C2 = n19 | (255 & arrby[n18]) << 16;
        int n22 = n20 + 1;
        this.C2 = n21 | arrby[n20] << 24;
        int n23 = n22 + 1;
        int n24 = this.C3 = 255 & arrby[n22];
        int n25 = n23 + 1;
        int n26 = this.C3 = n24 | (255 & arrby[n23]) << 8;
        int n27 = n25 + 1;
        int n28 = this.C3 = n26 | (255 & arrby[n25]) << 16;
        n27 + 1;
        this.C3 = n28 | arrby[n27] << 24;
    }

    private final void stateOut(byte[] arrby, int n) {
        int n2 = n + 1;
        arrby[n] = (byte)this.C0;
        int n3 = n2 + 1;
        arrby[n2] = (byte)(this.C0 >> 8);
        int n4 = n3 + 1;
        arrby[n3] = (byte)(this.C0 >> 16);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(this.C0 >> 24);
        int n6 = n5 + 1;
        arrby[n5] = (byte)this.C1;
        int n7 = n6 + 1;
        arrby[n6] = (byte)(this.C1 >> 8);
        int n8 = n7 + 1;
        arrby[n7] = (byte)(this.C1 >> 16);
        int n9 = n8 + 1;
        arrby[n8] = (byte)(this.C1 >> 24);
        int n10 = n9 + 1;
        arrby[n9] = (byte)this.C2;
        int n11 = n10 + 1;
        arrby[n10] = (byte)(this.C2 >> 8);
        int n12 = n11 + 1;
        arrby[n11] = (byte)(this.C2 >> 16);
        int n13 = n12 + 1;
        arrby[n12] = (byte)(this.C2 >> 24);
        int n14 = n13 + 1;
        arrby[n13] = (byte)this.C3;
        int n15 = n14 + 1;
        arrby[n14] = (byte)(this.C3 >> 8);
        int n16 = n15 + 1;
        arrby[n15] = (byte)(this.C3 >> 16);
        n16 + 1;
        arrby[n16] = (byte)(this.C3 >> 24);
    }

    private int subWord(int n) {
        return 255 & S[n & 255] | (255 & S[255 & n >> 8]) << 8 | (255 & S[255 & n >> 16]) << 16 | S[255 & n >> 24] << 24;
    }

    public void init(byte[] arrby) throws ZipException {
        this.workingKey = super.generateWorkingKey(arrby);
    }

    public int processBlock(byte[] arrby, int n, byte[] arrby2, int n2) throws ZipException {
        if (this.workingKey == null) {
            throw new ZipException("AES engine not initialised");
        }
        if (n + 16 > arrby.length) {
            throw new ZipException("input buffer too short");
        }
        if (n2 + 16 > arrby2.length) {
            throw new ZipException("output buffer too short");
        }
        super.stateIn(arrby, n);
        super.encryptBlock(this.workingKey);
        super.stateOut(arrby2, n2);
        return 16;
    }

    public int processBlock(byte[] arrby, byte[] arrby2) throws ZipException {
        return this.processBlock(arrby, 0, arrby2, 0);
    }
}

