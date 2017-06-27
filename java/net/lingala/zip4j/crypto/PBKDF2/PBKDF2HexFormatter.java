package net.lingala.zip4j.crypto.PBKDF2;

class PBKDF2HexFormatter {
    PBKDF2HexFormatter() {
    }

    public boolean fromString(PBKDF2Parameters p, String s) {
        if (p == null || s == null) {
            return true;
        }
        String[] p123 = s.split(":");
        if (p123 == null || p123.length != 3) {
            return true;
        }
        byte[] salt = BinTools.hex2bin(p123[0]);
        int iterationCount = Integer.parseInt(p123[1]);
        byte[] bDK = BinTools.hex2bin(p123[2]);
        p.setSalt(salt);
        p.setIterationCount(iterationCount);
        p.setDerivedKey(bDK);
        return false;
    }

    public String toString(PBKDF2Parameters p) {
        return new StringBuilder(String.valueOf(BinTools.bin2hex(p.getSalt()))).append(":").append(String.valueOf(p.getIterationCount())).append(":").append(BinTools.bin2hex(p.getDerivedKey())).toString();
    }
}
