/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package net.lingala.zip4j.crypto.engine;

public class ZipCryptoEngine {
    private static final int[] CRC_TABLE = new int[256];
    private final int[] keys = new int[3];

    /*
     * Enabled aggressive block sorting
     */
    static {
        int n = 0;
        while (n < 256) {
            int n2 = n;
            for (int i = 0; i < 8; ++i) {
                if ((n2 & 1) == 1) {
                    n2 = -306674912 ^ n2 >>> 1;
                    continue;
                }
                n2 >>>= 1;
            }
            ZipCryptoEngine.CRC_TABLE[n] = n2;
            ++n;
        }
    }

    private int crc32(int n, byte by) {
        return n >>> 8 ^ CRC_TABLE[255 & (n ^ by)];
    }

    public byte decryptByte() {
        int n = 2 | this.keys[2];
        return (byte)(n * (n ^ 1) >>> 8);
    }

    public void initKeys(char[] arrc) {
        this.keys[0] = 305419896;
        this.keys[1] = 591751049;
        this.keys[2] = 878082192;
        for (int i = 0; i < arrc.length; ++i) {
            this.updateKeys((byte)(255 & arrc[i]));
        }
    }

    public void updateKeys(byte by) {
        this.keys[0] = super.crc32(this.keys[0], by);
        int[] arrn = this.keys;
        arrn[1] = arrn[1] + (255 & this.keys[0]);
        this.keys[1] = 1 + 134775813 * this.keys[1];
        this.keys[2] = super.crc32(this.keys[2], (byte)(this.keys[1] >> 24));
    }
}

