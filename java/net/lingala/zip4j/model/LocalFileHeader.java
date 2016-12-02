/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package net.lingala.zip4j.model;

import java.util.ArrayList;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.Zip64ExtendedInfo;

public class LocalFileHeader {
    private AESExtraDataRecord aesExtraDataRecord;
    private long compressedSize;
    private int compressionMethod;
    private long crc32 = 0;
    private byte[] crcBuff;
    private boolean dataDescriptorExists;
    private int encryptionMethod = -1;
    private ArrayList extraDataRecords;
    private byte[] extraField;
    private int extraFieldLength;
    private String fileName;
    private int fileNameLength;
    private boolean fileNameUTF8Encoded;
    private byte[] generalPurposeFlag;
    private boolean isEncrypted;
    private int lastModFileTime;
    private long offsetStartOfData;
    private char[] password;
    private int signature;
    private long uncompressedSize = 0;
    private int versionNeededToExtract;
    private boolean writeComprSizeInZip64ExtraRecord = false;
    private Zip64ExtendedInfo zip64ExtendedInfo;

    public AESExtraDataRecord getAesExtraDataRecord() {
        return this.aesExtraDataRecord;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public int getCompressionMethod() {
        return this.compressionMethod;
    }

    public long getCrc32() {
        return this.crc32;
    }

    public byte[] getCrcBuff() {
        return this.crcBuff;
    }

    public int getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public ArrayList getExtraDataRecords() {
        return this.extraDataRecords;
    }

    public byte[] getExtraField() {
        return this.extraField;
    }

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFileNameLength() {
        return this.fileNameLength;
    }

    public byte[] getGeneralPurposeFlag() {
        return this.generalPurposeFlag;
    }

    public int getLastModFileTime() {
        return this.lastModFileTime;
    }

    public long getOffsetStartOfData() {
        return this.offsetStartOfData;
    }

    public char[] getPassword() {
        return this.password;
    }

    public int getSignature() {
        return this.signature;
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public int getVersionNeededToExtract() {
        return this.versionNeededToExtract;
    }

    public Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.zip64ExtendedInfo;
    }

    public boolean isDataDescriptorExists() {
        return this.dataDescriptorExists;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.fileNameUTF8Encoded;
    }

    public boolean isWriteComprSizeInZip64ExtraRecord() {
        return this.writeComprSizeInZip64ExtraRecord;
    }

    public void setAesExtraDataRecord(AESExtraDataRecord aESExtraDataRecord) {
        this.aesExtraDataRecord = aESExtraDataRecord;
    }

    public void setCompressedSize(long l) {
        this.compressedSize = l;
    }

    public void setCompressionMethod(int n) {
        this.compressionMethod = n;
    }

    public void setCrc32(long l) {
        this.crc32 = l;
    }

    public void setCrcBuff(byte[] arrby) {
        this.crcBuff = arrby;
    }

    public void setDataDescriptorExists(boolean bl) {
        this.dataDescriptorExists = bl;
    }

    public void setEncrypted(boolean bl) {
        this.isEncrypted = bl;
    }

    public void setEncryptionMethod(int n) {
        this.encryptionMethod = n;
    }

    public void setExtraDataRecords(ArrayList arrayList) {
        this.extraDataRecords = arrayList;
    }

    public void setExtraField(byte[] arrby) {
        this.extraField = arrby;
    }

    public void setExtraFieldLength(int n) {
        this.extraFieldLength = n;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    public void setFileNameLength(int n) {
        this.fileNameLength = n;
    }

    public void setFileNameUTF8Encoded(boolean bl) {
        this.fileNameUTF8Encoded = bl;
    }

    public void setGeneralPurposeFlag(byte[] arrby) {
        this.generalPurposeFlag = arrby;
    }

    public void setLastModFileTime(int n) {
        this.lastModFileTime = n;
    }

    public void setOffsetStartOfData(long l) {
        this.offsetStartOfData = l;
    }

    public void setPassword(char[] arrc) {
        this.password = arrc;
    }

    public void setSignature(int n) {
        this.signature = n;
    }

    public void setUncompressedSize(long l) {
        this.uncompressedSize = l;
    }

    public void setVersionNeededToExtract(int n) {
        this.versionNeededToExtract = n;
    }

    public void setWriteComprSizeInZip64ExtraRecord(boolean bl) {
        this.writeComprSizeInZip64ExtraRecord = bl;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.zip64ExtendedInfo = zip64ExtendedInfo;
    }
}

