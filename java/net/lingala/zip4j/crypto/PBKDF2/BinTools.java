/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package net.lingala.zip4j.crypto.PBKDF2;

class BinTools {
    public static final String hex = "0123456789ABCDEF";

    BinTools() {
    }

    public static String bin2hex(byte[] arrby) {
        if (arrby == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(2 * arrby.length);
        int n = arrby.length;
        for (int i = 0; i < n; ++i) {
            int n2 = (256 + arrby[i]) % 256;
            stringBuffer.append("0123456789ABCDEF".charAt(15 & n2 / 16));
            stringBuffer.append("0123456789ABCDEF".charAt(15 & n2 % 16));
        }
        return stringBuffer.toString();
    }

    public static int hex2bin(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'A' && c <= 'F') {
            return 10 + (c - 65);
        }
        if (c >= 'a' && c <= 'f') {
            return 10 + (c - 97);
        }
        throw new IllegalArgumentException("Input string may only contain hex digits, but found '" + c + "'");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static byte[] hex2bin(String string) {
        String string2 = string;
        if (string == null) {
            string2 = "";
        } else if (string.length() % 2 != 0) {
            string2 = "0" + string;
        }
        byte[] arrby = new byte[string2.length() / 2];
        int n = 0;
        int n2 = 0;
        while (n < string2.length()) {
            int n3 = n + 1;
            char c = string2.charAt(n);
            n = n3 + 1;
            char c2 = string2.charAt(n3);
            arrby[n2] = (byte)(16 * BinTools.hex2bin(c) + BinTools.hex2bin(c2));
            ++n2;
        }
        return arrby;
    }
}

