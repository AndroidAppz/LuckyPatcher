/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package net.lingala.zip4j.model;

public class AESExtraDataRecord {
    private int aesStrength = -1;
    private int compressionMethod = -1;
    private int dataSize = -1;
    private long signature = -1;
    private String vendorID = null;
    private int versionNumber = -1;

    public int getAesStrength() {
        return this.aesStrength;
    }

    public int getCompressionMethod() {
        return this.compressionMethod;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public long getSignature() {
        return this.signature;
    }

    public String getVendorID() {
        return this.vendorID;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public void setAesStrength(int n) {
        this.aesStrength = n;
    }

    public void setCompressionMethod(int n) {
        this.compressionMethod = n;
    }

    public void setDataSize(int n) {
        this.dataSize = n;
    }

    public void setSignature(long l) {
        this.signature = l;
    }

    public void setVendorID(String string) {
        this.vendorID = string;
    }

    public void setVersionNumber(int n) {
        this.versionNumber = n;
    }
}

