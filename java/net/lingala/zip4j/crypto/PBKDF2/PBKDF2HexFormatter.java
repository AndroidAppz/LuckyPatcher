/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package net.lingala.zip4j.crypto.PBKDF2;

import net.lingala.zip4j.crypto.PBKDF2.BinTools;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters;

class PBKDF2HexFormatter {
    PBKDF2HexFormatter() {
    }

    public boolean fromString(PBKDF2Parameters pBKDF2Parameters, String string) {
        if (pBKDF2Parameters == null || string == null) {
            return true;
        }
        String[] arrstring = string.split(":");
        if (arrstring == null || arrstring.length != 3) {
            return true;
        }
        byte[] arrby = BinTools.hex2bin(arrstring[0]);
        int n = Integer.parseInt((String)arrstring[1]);
        byte[] arrby2 = BinTools.hex2bin(arrstring[2]);
        pBKDF2Parameters.setSalt(arrby);
        pBKDF2Parameters.setIterationCount(n);
        pBKDF2Parameters.setDerivedKey(arrby2);
        return false;
    }

    public String toString(PBKDF2Parameters pBKDF2Parameters) {
        return BinTools.bin2hex(pBKDF2Parameters.getSalt()) + ":" + String.valueOf((int)pBKDF2Parameters.getIterationCount()) + ":" + BinTools.bin2hex(pBKDF2Parameters.getDerivedKey());
    }
}

