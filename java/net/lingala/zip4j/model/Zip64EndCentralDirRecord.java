/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package net.lingala.zip4j.model;

public class Zip64EndCentralDirRecord {
    private byte[] extensibleDataSector;
    private int noOfThisDisk;
    private int noOfThisDiskStartOfCentralDir;
    private long offsetStartCenDirWRTStartDiskNo;
    private long signature;
    private long sizeOfCentralDir;
    private long sizeOfZip64EndCentralDirRec;
    private long totNoOfEntriesInCentralDir;
    private long totNoOfEntriesInCentralDirOnThisDisk;
    private int versionMadeBy;
    private int versionNeededToExtract;

    public byte[] getExtensibleDataSector() {
        return this.extensibleDataSector;
    }

    public int getNoOfThisDisk() {
        return this.noOfThisDisk;
    }

    public int getNoOfThisDiskStartOfCentralDir() {
        return this.noOfThisDiskStartOfCentralDir;
    }

    public long getOffsetStartCenDirWRTStartDiskNo() {
        return this.offsetStartCenDirWRTStartDiskNo;
    }

    public long getSignature() {
        return this.signature;
    }

    public long getSizeOfCentralDir() {
        return this.sizeOfCentralDir;
    }

    public long getSizeOfZip64EndCentralDirRec() {
        return this.sizeOfZip64EndCentralDirRec;
    }

    public long getTotNoOfEntriesInCentralDir() {
        return this.totNoOfEntriesInCentralDir;
    }

    public long getTotNoOfEntriesInCentralDirOnThisDisk() {
        return this.totNoOfEntriesInCentralDirOnThisDisk;
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public int getVersionNeededToExtract() {
        return this.versionNeededToExtract;
    }

    public void setExtensibleDataSector(byte[] arrby) {
        this.extensibleDataSector = arrby;
    }

    public void setNoOfThisDisk(int n) {
        this.noOfThisDisk = n;
    }

    public void setNoOfThisDiskStartOfCentralDir(int n) {
        this.noOfThisDiskStartOfCentralDir = n;
    }

    public void setOffsetStartCenDirWRTStartDiskNo(long l) {
        this.offsetStartCenDirWRTStartDiskNo = l;
    }

    public void setSignature(long l) {
        this.signature = l;
    }

    public void setSizeOfCentralDir(long l) {
        this.sizeOfCentralDir = l;
    }

    public void setSizeOfZip64EndCentralDirRec(long l) {
        this.sizeOfZip64EndCentralDirRec = l;
    }

    public void setTotNoOfEntriesInCentralDir(long l) {
        this.totNoOfEntriesInCentralDir = l;
    }

    public void setTotNoOfEntriesInCentralDirOnThisDisk(long l) {
        this.totNoOfEntriesInCentralDirOnThisDisk = l;
    }

    public void setVersionMadeBy(int n) {
        this.versionMadeBy = n;
    }

    public void setVersionNeededToExtract(int n) {
        this.versionNeededToExtract = n;
    }
}

