/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.NoSuchAlgorithmException
 */
package org.tukaani.xz.check;

import java.security.NoSuchAlgorithmException;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.check.CRC32;
import org.tukaani.xz.check.CRC64;
import org.tukaani.xz.check.None;
import org.tukaani.xz.check.SHA256;

public abstract class Check {
    String name;
    int size;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Check getInstance(int n) throws UnsupportedOptionsException {
        switch (n) {
            default: {
                do {
                    throw new UnsupportedOptionsException("Unsupported Check ID " + n);
                    break;
                } while (true);
            }
            case 0: {
                return new None();
            }
            case 1: {
                return new CRC32();
            }
            case 4: {
                return new CRC64();
            }
            case 10: 
        }
        try {
            return new SHA256();
        }
        catch (NoSuchAlgorithmException var2_2) {
            throw new UnsupportedOptionsException("Unsupported Check ID " + n);
        }
    }

    public abstract byte[] finish();

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public void update(byte[] arrby) {
        this.update(arrby, 0, arrby.length);
    }

    public abstract void update(byte[] var1, int var2, int var3);
}

