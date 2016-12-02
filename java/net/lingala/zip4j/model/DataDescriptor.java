/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package net.lingala.zip4j.model;

public class DataDescriptor {
    private int compressedSize;
    private String crc32;
    private int uncompressedSize;

    public int getCompressedSize() {
        return this.compressedSize;
    }

    public String getCrc32() {
        return this.crc32;
    }

    public int getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void setCompressedSize(int n) {
        this.compressedSize = n;
    }

    public void setCrc32(String string) {
        this.crc32 = string;
    }

    public void setUncompressedSize(int n) {
        this.uncompressedSize = n;
    }
}

