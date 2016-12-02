/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package net.lingala.zip4j.crypto.PBKDF2;

public class PBKDF2Parameters {
    protected byte[] derivedKey;
    protected String hashAlgorithm;
    protected String hashCharset;
    protected int iterationCount;
    protected byte[] salt;

    public PBKDF2Parameters() {
        this.hashAlgorithm = null;
        this.hashCharset = "UTF-8";
        this.salt = null;
        this.iterationCount = 1000;
        this.derivedKey = null;
    }

    public PBKDF2Parameters(String string, String string2, byte[] arrby, int n) {
        this.hashAlgorithm = string;
        this.hashCharset = string2;
        this.salt = arrby;
        this.iterationCount = n;
        this.derivedKey = null;
    }

    public PBKDF2Parameters(String string, String string2, byte[] arrby, int n, byte[] arrby2) {
        this.hashAlgorithm = string;
        this.hashCharset = string2;
        this.salt = arrby;
        this.iterationCount = n;
        this.derivedKey = arrby2;
    }

    public byte[] getDerivedKey() {
        return this.derivedKey;
    }

    public String getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public String getHashCharset() {
        return this.hashCharset;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void setDerivedKey(byte[] arrby) {
        this.derivedKey = arrby;
    }

    public void setHashAlgorithm(String string) {
        this.hashAlgorithm = string;
    }

    public void setHashCharset(String string) {
        this.hashCharset = string;
    }

    public void setIterationCount(int n) {
        this.iterationCount = n;
    }

    public void setSalt(byte[] arrby) {
        this.salt = arrby;
    }
}

