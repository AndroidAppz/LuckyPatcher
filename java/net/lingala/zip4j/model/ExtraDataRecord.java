/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package net.lingala.zip4j.model;

public class ExtraDataRecord {
    private byte[] data;
    private long header;
    private int sizeOfData;

    public byte[] getData() {
        return this.data;
    }

    public long getHeader() {
        return this.header;
    }

    public int getSizeOfData() {
        return this.sizeOfData;
    }

    public void setData(byte[] arrby) {
        this.data = arrby;
    }

    public void setHeader(long l) {
        this.header = l;
    }

    public void setSizeOfData(int n) {
        this.sizeOfData = n;
    }
}

