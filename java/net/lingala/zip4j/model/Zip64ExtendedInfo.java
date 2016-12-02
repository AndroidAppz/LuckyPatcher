/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package net.lingala.zip4j.model;

public class Zip64ExtendedInfo {
    private long compressedSize = -1;
    private int diskNumberStart = -1;
    private int header;
    private long offsetLocalHeader = -1;
    private int size;
    private long unCompressedSize = -1;

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public int getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public int getHeader() {
        return this.header;
    }

    public long getOffsetLocalHeader() {
        return this.offsetLocalHeader;
    }

    public int getSize() {
        return this.size;
    }

    public long getUnCompressedSize() {
        return this.unCompressedSize;
    }

    public void setCompressedSize(long l) {
        this.compressedSize = l;
    }

    public void setDiskNumberStart(int n) {
        this.diskNumberStart = n;
    }

    public void setHeader(int n) {
        this.header = n;
    }

    public void setOffsetLocalHeader(long l) {
        this.offsetLocalHeader = l;
    }

    public void setSize(int n) {
        this.size = n;
    }

    public void setUnCompressedSize(long l) {
        this.unCompressedSize = l;
    }
}

