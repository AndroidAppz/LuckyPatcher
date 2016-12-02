/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package net.lingala.zip4j.model;

public class DigitalSignature {
    private int headerSignature;
    private String signatureData;
    private int sizeOfData;

    public int getHeaderSignature() {
        return this.headerSignature;
    }

    public String getSignatureData() {
        return this.signatureData;
    }

    public int getSizeOfData() {
        return this.sizeOfData;
    }

    public void setHeaderSignature(int n) {
        this.headerSignature = n;
    }

    public void setSignatureData(String string) {
        this.signatureData = string;
    }

    public void setSizeOfData(int n) {
        this.sizeOfData = n;
    }
}

