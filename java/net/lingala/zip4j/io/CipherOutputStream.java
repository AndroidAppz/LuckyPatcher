/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.TimeZone
 *  java.util.zip.CRC32
 */
package net.lingala.zip4j.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.zip.CRC32;
import net.lingala.zip4j.core.HeaderWriter;
import net.lingala.zip4j.crypto.AESEncrpyter;
import net.lingala.zip4j.crypto.IEncrypter;
import net.lingala.zip4j.crypto.StandardEncrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.BaseOutputStream;
import net.lingala.zip4j.io.SplitOutputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

public class CipherOutputStream
extends BaseOutputStream {
    private long bytesWrittenForThisFile;
    protected CRC32 crc;
    private IEncrypter encrypter;
    protected FileHeader fileHeader;
    protected LocalFileHeader localFileHeader;
    protected OutputStream outputStream;
    private byte[] pendingBuffer;
    private int pendingBufferLength;
    private File sourceFile;
    private long totalBytesRead;
    private long totalBytesWritten;
    protected ZipModel zipModel;
    protected ZipParameters zipParameters;

    public CipherOutputStream(OutputStream outputStream, ZipModel zipModel) {
        this.outputStream = outputStream;
        super.initZipModel(zipModel);
        this.crc = new CRC32();
        this.totalBytesWritten = 0;
        this.bytesWrittenForThisFile = 0;
        this.pendingBuffer = new byte[16];
        this.pendingBufferLength = 0;
        this.totalBytesRead = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void createFileHeader() throws ZipException {
        String string;
        this.fileHeader = new FileHeader();
        this.fileHeader.setSignature(33639248);
        this.fileHeader.setVersionMadeBy(20);
        this.fileHeader.setVersionNeededToExtract(20);
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            this.fileHeader.setCompressionMethod(99);
            this.fileHeader.setAesExtraDataRecord(this.generateAESExtraDataRecord(this.zipParameters));
        } else {
            this.fileHeader.setCompressionMethod(this.zipParameters.getCompressionMethod());
        }
        if (this.zipParameters.isEncryptFiles()) {
            this.fileHeader.setEncrypted(true);
            this.fileHeader.setEncryptionMethod(this.zipParameters.getEncryptionMethod());
        }
        if (this.zipParameters.isSourceExternalStream()) {
            this.fileHeader.setLastModFileTime((int)Zip4jUtil.javaToDosTime(System.currentTimeMillis()));
            if (!Zip4jUtil.isStringNotNullAndNotEmpty(this.zipParameters.getFileNameInZip())) {
                throw new ZipException("fileNameInZip is null or empty");
            }
            string = this.zipParameters.getFileNameInZip();
        } else {
            this.fileHeader.setLastModFileTime((int)Zip4jUtil.javaToDosTime(Zip4jUtil.getLastModifiedFileTime(this.sourceFile, this.zipParameters.getTimeZone())));
            this.fileHeader.setUncompressedSize(this.sourceFile.length());
            string = Zip4jUtil.getRelativeFileName(this.sourceFile.getAbsolutePath(), this.zipParameters.getRootFolderInZip(), this.zipParameters.getDefaultFolderPath());
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("fileName is null or empty. unable to create file header");
        }
        this.fileHeader.setFileName(string);
        if (Zip4jUtil.isStringNotNullAndNotEmpty(this.zipModel.getFileNameCharset())) {
            this.fileHeader.setFileNameLength(Zip4jUtil.getEncodedStringLength(string, this.zipModel.getFileNameCharset()));
        } else {
            this.fileHeader.setFileNameLength(Zip4jUtil.getEncodedStringLength(string));
        }
        if (this.outputStream instanceof SplitOutputStream) {
            this.fileHeader.setDiskNumberStart(((SplitOutputStream)this.outputStream).getCurrSplitFileCounter());
        } else {
            this.fileHeader.setDiskNumberStart(0);
        }
        boolean bl = this.zipParameters.isSourceExternalStream();
        int n = 0;
        if (!bl) {
            n = this.getFileAttributes(this.sourceFile);
        }
        byte[] arrby = new byte[]{(byte)n, 0, 0, 0};
        this.fileHeader.setExternalFileAttr(arrby);
        if (this.zipParameters.isSourceExternalStream()) {
            FileHeader fileHeader = this.fileHeader;
            boolean bl2 = string.endsWith("/") || string.endsWith("\\");
            fileHeader.setDirectory(bl2);
        } else {
            this.fileHeader.setDirectory(this.sourceFile.isDirectory());
        }
        if (this.fileHeader.isDirectory()) {
            this.fileHeader.setCompressedSize(0);
            this.fileHeader.setUncompressedSize(0);
        } else if (!this.zipParameters.isSourceExternalStream()) {
            long l = Zip4jUtil.getFileLengh(this.sourceFile);
            if (this.zipParameters.getCompressionMethod() == 0) {
                if (this.zipParameters.getEncryptionMethod() == 0) {
                    this.fileHeader.setCompressedSize(12 + l);
                } else if (this.zipParameters.getEncryptionMethod() == 99) {
                    int n2;
                    switch (this.zipParameters.getAesKeyStrength()) {
                        default: {
                            throw new ZipException("invalid aes key strength, cannot determine key sizes");
                        }
                        case 1: {
                            n2 = 8;
                            break;
                        }
                        case 3: {
                            n2 = 16;
                        }
                    }
                    this.fileHeader.setCompressedSize(2 + (10 + (l + (long)n2)));
                } else {
                    this.fileHeader.setCompressedSize(0);
                }
            } else {
                this.fileHeader.setCompressedSize(0);
            }
            this.fileHeader.setUncompressedSize(l);
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 0) {
            this.fileHeader.setCrc32(this.zipParameters.getSourceFileCRC());
        }
        byte[] arrby2 = new byte[2];
        arrby2[0] = Raw.bitArrayToByte(this.generateGeneralPurposeBitArray(this.fileHeader.isEncrypted(), this.zipParameters.getCompressionMethod()));
        boolean bl3 = Zip4jUtil.isStringNotNullAndNotEmpty(this.zipModel.getFileNameCharset());
        arrby2[1] = bl3 && this.zipModel.getFileNameCharset().equalsIgnoreCase("UTF8") || !bl3 && Zip4jUtil.detectCharSet(this.fileHeader.getFileName()).equals((Object)"UTF8") ? 8 : 0;
        this.fileHeader.setGeneralPurposeFlag(arrby2);
    }

    private void createLocalFileHeader() throws ZipException {
        if (this.fileHeader == null) {
            throw new ZipException("file header is null, cannot create local file header");
        }
        this.localFileHeader = new LocalFileHeader();
        this.localFileHeader.setSignature(67324752);
        this.localFileHeader.setVersionNeededToExtract(this.fileHeader.getVersionNeededToExtract());
        this.localFileHeader.setCompressionMethod(this.fileHeader.getCompressionMethod());
        this.localFileHeader.setLastModFileTime(this.fileHeader.getLastModFileTime());
        this.localFileHeader.setUncompressedSize(this.fileHeader.getUncompressedSize());
        this.localFileHeader.setFileNameLength(this.fileHeader.getFileNameLength());
        this.localFileHeader.setFileName(this.fileHeader.getFileName());
        this.localFileHeader.setEncrypted(this.fileHeader.isEncrypted());
        this.localFileHeader.setEncryptionMethod(this.fileHeader.getEncryptionMethod());
        this.localFileHeader.setAesExtraDataRecord(this.fileHeader.getAesExtraDataRecord());
        this.localFileHeader.setCrc32(this.fileHeader.getCrc32());
        this.localFileHeader.setCompressedSize(this.fileHeader.getCompressedSize());
        this.localFileHeader.setGeneralPurposeFlag((byte[])this.fileHeader.getGeneralPurposeFlag().clone());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void encryptAndWrite(byte[] arrby, int n, int n2) throws IOException {
        if (this.encrypter != null) {
            this.encrypter.encryptData(arrby, n, n2);
        }
        this.outputStream.write(arrby, n, n2);
        this.totalBytesWritten += (long)n2;
        this.bytesWrittenForThisFile += (long)n2;
        return;
        catch (ZipException zipException) {
            throw new IOException(zipException.getMessage());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private AESExtraDataRecord generateAESExtraDataRecord(ZipParameters zipParameters) throws ZipException {
        if (zipParameters == null) {
            throw new ZipException("zip parameters are null, cannot generate AES Extra Data record");
        }
        AESExtraDataRecord aESExtraDataRecord = new AESExtraDataRecord();
        aESExtraDataRecord.setSignature(39169);
        aESExtraDataRecord.setDataSize(7);
        aESExtraDataRecord.setVendorID("AE");
        aESExtraDataRecord.setVersionNumber(2);
        if (zipParameters.getAesKeyStrength() == 1) {
            aESExtraDataRecord.setAesStrength(1);
        } else {
            if (zipParameters.getAesKeyStrength() != 3) {
                throw new ZipException("invalid AES key strength, cannot generate AES Extra data record");
            }
            aESExtraDataRecord.setAesStrength(3);
        }
        aESExtraDataRecord.setCompressionMethod(zipParameters.getCompressionMethod());
        return aESExtraDataRecord;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int[] generateGeneralPurposeBitArray(boolean bl, int n) {
        int[] arrn = new int[8];
        arrn[0] = bl ? 1 : 0;
        if (n != 8) {
            arrn[1] = 0;
            arrn[2] = 0;
        }
        arrn[3] = 1;
        return arrn;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int getFileAttributes(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null, cannot get file attributes");
        }
        if (!file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            if (!file.isHidden()) return 16;
            return 18;
        }
        if (!file.canWrite() && file.isHidden()) {
            return 3;
        }
        if (!file.canWrite()) {
            return 1;
        }
        if (!file.isHidden()) return 0;
        return 2;
    }

    private void initEncrypter() throws ZipException {
        if (!this.zipParameters.isEncryptFiles()) {
            this.encrypter = null;
            return;
        }
        switch (this.zipParameters.getEncryptionMethod()) {
            default: {
                throw new ZipException("invalid encprytion method");
            }
            case 0: {
                this.encrypter = new StandardEncrypter(this.zipParameters.getPassword(), (65535 & this.localFileHeader.getLastModFileTime()) << 16);
                return;
            }
            case 99: 
        }
        this.encrypter = new AESEncrpyter(this.zipParameters.getPassword(), this.zipParameters.getAesKeyStrength());
    }

    /*
     * Enabled aggressive block sorting
     */
    private void initZipModel(ZipModel zipModel) {
        this.zipModel = zipModel == null ? new ZipModel() : zipModel;
        if (this.zipModel.getEndCentralDirRecord() == null) {
            this.zipModel.setEndCentralDirRecord(new EndCentralDirRecord());
        }
        if (this.zipModel.getCentralDirectory() == null) {
            this.zipModel.setCentralDirectory(new CentralDirectory());
        }
        if (this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            this.zipModel.getCentralDirectory().setFileHeaders(new ArrayList());
        }
        if (this.zipModel.getLocalFileHeaderList() == null) {
            this.zipModel.setLocalFileHeaderList((List)new ArrayList());
        }
        if (this.outputStream instanceof SplitOutputStream && ((SplitOutputStream)this.outputStream).isSplitZipFile()) {
            this.zipModel.setSplitArchive(true);
            this.zipModel.setSplitLength(((SplitOutputStream)this.outputStream).getSplitLength());
        }
        this.zipModel.getEndCentralDirRecord().setSignature(101010256);
    }

    public void close() throws IOException {
        if (this.outputStream != null) {
            this.outputStream.close();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void closeEntry() throws IOException, ZipException {
        if (this.pendingBufferLength != 0) {
            this.encryptAndWrite(this.pendingBuffer, 0, this.pendingBufferLength);
            this.pendingBufferLength = 0;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            if (!(this.encrypter instanceof AESEncrpyter)) {
                throw new ZipException("invalid encrypter for AES encrypted file");
            }
            this.outputStream.write(((AESEncrpyter)this.encrypter).getFinalMac());
            this.bytesWrittenForThisFile = 10 + this.bytesWrittenForThisFile;
            this.totalBytesWritten = 10 + this.totalBytesWritten;
        }
        this.fileHeader.setCompressedSize(this.bytesWrittenForThisFile);
        this.localFileHeader.setCompressedSize(this.bytesWrittenForThisFile);
        if (this.zipParameters.isSourceExternalStream()) {
            this.fileHeader.setUncompressedSize(this.totalBytesRead);
            if (this.localFileHeader.getUncompressedSize() != this.totalBytesRead) {
                this.localFileHeader.setUncompressedSize(this.totalBytesRead);
            }
        }
        long l = this.crc.getValue();
        if (this.fileHeader.isEncrypted() && this.fileHeader.getEncryptionMethod() == 99) {
            l = 0;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            this.fileHeader.setCrc32(0);
            this.localFileHeader.setCrc32(0);
        } else {
            this.fileHeader.setCrc32(l);
            this.localFileHeader.setCrc32(l);
        }
        this.zipModel.getLocalFileHeaderList().add((Object)this.localFileHeader);
        this.zipModel.getCentralDirectory().getFileHeaders().add((Object)this.fileHeader);
        HeaderWriter headerWriter = new HeaderWriter();
        this.totalBytesWritten += (long)headerWriter.writeExtendedLocalHeader(this.localFileHeader, this.outputStream);
        this.crc.reset();
        this.bytesWrittenForThisFile = 0;
        this.encrypter = null;
        this.totalBytesRead = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void decrementCompressedFileSize(int n) {
        if (n <= 0 || (long)n > this.bytesWrittenForThisFile) {
            return;
        }
        this.bytesWrittenForThisFile -= (long)n;
    }

    public void finish() throws IOException, ZipException {
        this.zipModel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(this.totalBytesWritten);
        new HeaderWriter().finalizeZipFile(this.zipModel, this.outputStream);
    }

    public File getSourceFile() {
        return this.sourceFile;
    }

    /*
     * Exception decompiling
     */
    public void putNextEntry(File var1, ZipParameters var2_2) throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public void setSourceFile(File file) {
        this.sourceFile = file;
    }

    protected void updateTotalBytesRead(int n) {
        if (n > 0) {
            this.totalBytesRead += (long)n;
        }
    }

    @Override
    public void write(int n) throws IOException {
        byte[] arrby = new byte[]{(byte)n};
        this.write(arrby, 0, 1);
    }

    public void write(byte[] arrby) throws IOException {
        if (arrby == null) {
            throw new NullPointerException();
        }
        if (arrby.length == 0) {
            return;
        }
        this.write(arrby, 0, arrby.length);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void write(byte[] arrby, int n, int n2) throws IOException {
        if (n2 == 0) {
            return;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            if (this.pendingBufferLength != 0) {
                if (n2 < 16 - this.pendingBufferLength) {
                    System.arraycopy((Object)arrby, (int)n, (Object)this.pendingBuffer, (int)this.pendingBufferLength, (int)n2);
                    this.pendingBufferLength = n2 + this.pendingBufferLength;
                    return;
                }
                System.arraycopy((Object)arrby, (int)n, (Object)this.pendingBuffer, (int)this.pendingBufferLength, (int)(16 - this.pendingBufferLength));
                super.encryptAndWrite(this.pendingBuffer, 0, this.pendingBuffer.length);
                n = 16 - this.pendingBufferLength;
                n2 -= n;
                this.pendingBufferLength = 0;
            }
            if (n2 != 0 && n2 % 16 != 0) {
                System.arraycopy((Object)arrby, (int)(n2 + n - n2 % 16), (Object)this.pendingBuffer, (int)0, (int)(n2 % 16));
                this.pendingBufferLength = n2 % 16;
                n2 -= this.pendingBufferLength;
            }
        }
        if (n2 == 0) return;
        super.encryptAndWrite(arrby, n, n2);
    }
}

