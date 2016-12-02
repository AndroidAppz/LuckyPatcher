/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package net.lingala.zip4j.model;

public class ArchiveExtraDataRecord {
    private String extraFieldData;
    private int extraFieldLength;
    private int signature;

    public String getExtraFieldData() {
        return this.extraFieldData;
    }

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public int getSignature() {
        return this.signature;
    }

    public void setExtraFieldData(String string) {
        this.extraFieldData = string;
    }

    public void setExtraFieldLength(int n) {
        this.extraFieldLength = n;
    }

    public void setSignature(int n) {
        this.signature = n;
    }
}

