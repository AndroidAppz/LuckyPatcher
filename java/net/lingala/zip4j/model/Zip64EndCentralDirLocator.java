/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package net.lingala.zip4j.model;

public class Zip64EndCentralDirLocator {
    private int noOfDiskStartOfZip64EndOfCentralDirRec;
    private long offsetZip64EndOfCentralDirRec;
    private long signature;
    private int totNumberOfDiscs;

    public int getNoOfDiskStartOfZip64EndOfCentralDirRec() {
        return this.noOfDiskStartOfZip64EndOfCentralDirRec;
    }

    public long getOffsetZip64EndOfCentralDirRec() {
        return this.offsetZip64EndOfCentralDirRec;
    }

    public long getSignature() {
        return this.signature;
    }

    public int getTotNumberOfDiscs() {
        return this.totNumberOfDiscs;
    }

    public void setNoOfDiskStartOfZip64EndOfCentralDirRec(int n) {
        this.noOfDiskStartOfZip64EndOfCentralDirRec = n;
    }

    public void setOffsetZip64EndOfCentralDirRec(long l) {
        this.offsetZip64EndOfCentralDirRec = l;
    }

    public void setSignature(long l) {
        this.signature = l;
    }

    public void setTotNumberOfDiscs(int n) {
        this.totNumberOfDiscs = n;
    }
}

