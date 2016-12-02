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
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.Unzip;
import net.lingala.zip4j.util.Zip4jUtil;

public class FileHeader {
    private AESExtraDataRecord aesExtraDataRecord;
    private long compressedSize;
    private int compressionMethod;
    private long crc32 = 0;
    private byte[] crcBuff;
    private boolean dataDescriptorExists;
    private int diskNumberStart;
    private int encryptionMethod = -1;
    private byte[] externalFileAttr;
    private ArrayList extraDataRecords;
    private int extraFieldLength;
    private String fileComment;
    private int fileCommentLength;
    private String fileName;
    private int fileNameLength;
    private boolean fileNameUTF8Encoded;
    private byte[] generalPurposeFlag;
    private byte[] internalFileAttr;
    private boolean isDirectory;
    private boolean isEncrypted;
    private int lastModFileTime;
    private long offsetLocalHeader;
    private char[] password;
    private int signature;
    private long uncompressedSize = 0;
    private int versionMadeBy;
    private int versionNeededToExtract;
    private Zip64ExtendedInfo zip64ExtendedInfo;

    public void extractFile(ZipModel zipModel, String string, UnzipParameters unzipParameters, String string2, ProgressMonitor progressMonitor, boolean bl) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("input zipModel is null");
        }
        if (!Zip4jUtil.checkOutputFolder(string)) {
            throw new ZipException("Invalid output path");
        }
        if (this == null) {
            throw new ZipException("invalid file header");
        }
        new Unzip(zipModel).extractFile(this, string, unzipParameters, string2, progressMonitor, bl);
    }

    public void extractFile(ZipModel zipModel, String string, UnzipParameters unzipParameters, ProgressMonitor progressMonitor, boolean bl) throws ZipException {
        this.extractFile(zipModel, string, unzipParameters, null, progressMonitor, bl);
    }

    public void extractFile(ZipModel zipModel, String string, ProgressMonitor progressMonitor, boolean bl) throws ZipException {
        this.extractFile(zipModel, string, null, progressMonitor, bl);
    }

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
        return 0xFFFFFFFFL & this.crc32;
    }

    public byte[] getCrcBuff() {
        return this.crcBuff;
    }

    public int getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public int getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public byte[] getExternalFileAttr() {
        return this.externalFileAttr;
    }

    public ArrayList getExtraDataRecords() {
        return this.extraDataRecords;
    }

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public String getFileComment() {
        return this.fileComment;
    }

    public int getFileCommentLength() {
        return this.fileCommentLength;
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

    public byte[] getInternalFileAttr() {
        return this.internalFileAttr;
    }

    public int getLastModFileTime() {
        return this.lastModFileTime;
    }

    public long getOffsetLocalHeader() {
        return this.offsetLocalHeader;
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

    public int getVersionMadeBy() {
        return this.versionMadeBy;
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

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.fileNameUTF8Encoded;
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

    public void setDirectory(boolean bl) {
        this.isDirectory = bl;
    }

    public void setDiskNumberStart(int n) {
        this.diskNumberStart = n;
    }

    public void setEncrypted(boolean bl) {
        this.isEncrypted = bl;
    }

    public void setEncryptionMethod(int n) {
        this.encryptionMethod = n;
    }

    public void setExternalFileAttr(byte[] arrby) {
        this.externalFileAttr = arrby;
    }

    public void setExtraDataRecords(ArrayList arrayList) {
        this.extraDataRecords = arrayList;
    }

    public void setExtraFieldLength(int n) {
        this.extraFieldLength = n;
    }

    public void setFileComment(String string) {
        this.fileComment = string;
    }

    public void setFileCommentLength(int n) {
        this.fileCommentLength = n;
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

    public void setInternalFileAttr(byte[] arrby) {
        this.internalFileAttr = arrby;
    }

    public void setLastModFileTime(int n) {
        this.lastModFileTime = n;
    }

    public void setOffsetLocalHeader(long l) {
        this.offsetLocalHeader = l;
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

    public void setVersionMadeBy(int n) {
        this.versionMadeBy = n;
    }

    public void setVersionNeededToExtract(int n) {
        this.versionNeededToExtract = n;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.zip64ExtendedInfo = zip64ExtendedInfo;
    }
}

