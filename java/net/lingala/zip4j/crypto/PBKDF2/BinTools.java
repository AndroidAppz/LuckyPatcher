package net.lingala.zip4j.crypto.PBKDF2;

import pxb.android.ResConst;

class BinTools {
    public static final String hex = "0123456789ABCDEF";

    BinTools() {
    }

    public static String bin2hex(byte[] b) {
        if (b == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (byte aB : b) {
            int v = (aB + ResConst.RES_XML_START_NAMESPACE_TYPE) % ResConst.RES_XML_START_NAMESPACE_TYPE;
            sb.append(hex.charAt((v / 16) & 15));
            sb.append(hex.charAt((v % 16) & 15));
        }
        return sb.toString();
    }

    public static byte[] hex2bin(String s) {
        String m = s;
        if (s == null) {
            m = "";
        } else if (s.length() % 2 != 0) {
            m = "0" + s;
        }
        byte[] r = new byte[(m.length() / 2)];
        int i = 0;
        int n = 0;
        while (i < m.length()) {
            int i2 = i + 1;
            char h = m.charAt(i);
            i = i2 + 1;
            r[n] = (byte) ((hex2bin(h) * 16) + hex2bin(m.charAt(i2)));
            n++;
        }
        return r;
    }

    public static int hex2bin(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 65) + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        throw new IllegalArgumentException("Input string may only contain hex digits, but found '" + c + "'");
    }
}
