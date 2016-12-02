/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package net.lingala.zip4j.model;

public class EndCentralDirRecord {
    private String comment;
    private byte[] commentBytes;
    private int commentLength;
    private int noOfThisDisk;
    private int noOfThisDiskStartOfCentralDir;
    private long offsetOfStartOfCentralDir;
    private long signature;
    private int sizeOfCentralDir;
    private int totNoOfEntriesInCentralDir;
    private int totNoOfEntriesInCentralDirOnThisDisk;

    public String getComment() {
        return this.comment;
    }

    public byte[] getCommentBytes() {
        return this.commentBytes;
    }

    public int getCommentLength() {
        return this.commentLength;
    }

    public int getNoOfThisDisk() {
        return this.noOfThisDisk;
    }

    public int getNoOfThisDiskStartOfCentralDir() {
        return this.noOfThisDiskStartOfCentralDir;
    }

    public long getOffsetOfStartOfCentralDir() {
        return this.offsetOfStartOfCentralDir;
    }

    public long getSignature() {
        return this.signature;
    }

    public int getSizeOfCentralDir() {
        return this.sizeOfCentralDir;
    }

    public int getTotNoOfEntriesInCentralDir() {
        return this.totNoOfEntriesInCentralDir;
    }

    public int getTotNoOfEntriesInCentralDirOnThisDisk() {
        return this.totNoOfEntriesInCentralDirOnThisDisk;
    }

    public void setComment(String string) {
        this.comment = string;
    }

    public void setCommentBytes(byte[] arrby) {
        this.commentBytes = arrby;
    }

    public void setCommentLength(int n) {
        this.commentLength = n;
    }

    public void setNoOfThisDisk(int n) {
        this.noOfThisDisk = n;
    }

    public void setNoOfThisDiskStartOfCentralDir(int n) {
        this.noOfThisDiskStartOfCentralDir = n;
    }

    public void setOffsetOfStartOfCentralDir(long l) {
        this.offsetOfStartOfCentralDir = l;
    }

    public void setSignature(long l) {
        this.signature = l;
    }

    public void setSizeOfCentralDir(int n) {
        this.sizeOfCentralDir = n;
    }

    public void setTotNoOfEntriesInCentralDir(int n) {
        this.totNoOfEntriesInCentralDir = n;
    }

    public void setTotNoOfEntriesInCentralDirOnThisDisk(int n) {
        this.totNoOfEntriesInCentralDirOnThisDisk = n;
    }
}

