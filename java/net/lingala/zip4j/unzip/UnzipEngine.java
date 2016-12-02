/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.zip.CRC32
 */
package net.lingala.zip4j.unzip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.CRC32;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.crypto.StandardDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.UnzipUtil;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

public class UnzipEngine {
    private CRC32 crc;
    private int currSplitFileCounter = 0;
    private IDecrypter decrypter;
    private FileHeader fileHeader;
    private LocalFileHeader localFileHeader;
    private ZipModel zipModel;

    public UnzipEngine(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new ZipException("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        }
        this.zipModel = zipModel;
        this.fileHeader = fileHeader;
        this.crc = new CRC32();
    }

    private int calculateAESSaltLength(AESExtraDataRecord aESExtraDataRecord) throws ZipException {
        if (aESExtraDataRecord == null) {
            throw new ZipException("unable to determine salt length: AESExtraDataRecord is null");
        }
        switch (aESExtraDataRecord.getAesStrength()) {
            default: {
                throw new ZipException("unable to determine salt length: invalid aes key strength");
            }
            case 1: {
                return 8;
            }
            case 2: {
                return 12;
            }
            case 3: 
        }
        return 16;
    }

    /*
     * Exception decompiling
     */
    private boolean checkLocalHeader() throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredTry.transformStructuredChildren(StructuredTry.java:79)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private RandomAccessFile checkSplitFile() throws ZipException {
        if (!this.zipModel.isSplitArchive()) return null;
        int n = this.fileHeader.getDiskNumberStart();
        this.currSplitFileCounter = n + 1;
        String string = this.zipModel.getZipFile();
        String string2 = n == this.zipModel.getEndCentralDirRecord().getNoOfThisDisk() ? this.zipModel.getZipFile() : (n >= 9 ? string.substring(0, string.lastIndexOf(".")) + ".z" + (n + 1) : string.substring(0, string.lastIndexOf(".")) + ".z0" + (n + 1));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(string2, "r");
            if (this.currSplitFileCounter != 1) return randomAccessFile;
            byte[] arrby = new byte[4];
            randomAccessFile.read(arrby);
            if ((long)Raw.readIntLittleEndian(arrby, 0) == 134695760) return randomAccessFile;
            throw new ZipException("invalid first part split file signature");
        }
        catch (FileNotFoundException var6_6) {
            throw new ZipException((Throwable)var6_6);
        }
        catch (IOException var5_7) {
            throw new ZipException((Throwable)var5_7);
        }
    }

    /*
     * Exception decompiling
     */
    private void closeStreams(InputStream var1_1, OutputStream var2_2) throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:371)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:449)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
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

    private RandomAccessFile createFileHandler(String string) throws ZipException {
        if (this.zipModel == null || !Zip4jUtil.isStringNotNullAndNotEmpty(this.zipModel.getZipFile())) {
            throw new ZipException("input parameter is null in getFilePointer");
        }
        try {
            if (this.zipModel.isSplitArchive()) {
                return super.checkSplitFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.zipModel.getZipFile()), string);
            return randomAccessFile;
        }
        catch (FileNotFoundException var3_3) {
            throw new ZipException((Throwable)var3_3);
        }
        catch (Exception var2_4) {
            throw new ZipException((Throwable)var2_4);
        }
    }

    private byte[] getAESPasswordVerifier(RandomAccessFile randomAccessFile) throws ZipException {
        try {
            byte[] arrby = new byte[2];
            randomAccessFile.read(arrby);
            return arrby;
        }
        catch (IOException var2_3) {
            throw new ZipException((Throwable)var2_3);
        }
    }

    private byte[] getAESSalt(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.localFileHeader.getAesExtraDataRecord() == null) {
            return null;
        }
        try {
            byte[] arrby = new byte[super.calculateAESSaltLength(this.localFileHeader.getAesExtraDataRecord())];
            randomAccessFile.seek(this.localFileHeader.getOffsetStartOfData());
            randomAccessFile.read(arrby);
            return arrby;
        }
        catch (IOException var2_3) {
            throw new ZipException((Throwable)var2_3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String getOutputFileNameWithPath(String string, String string2) throws ZipException {
        String string3;
        if (Zip4jUtil.isStringNotNullAndNotEmpty(string2)) {
            string3 = string2;
            do {
                return string + System.getProperty((String)"file.separator") + string3;
                break;
            } while (true);
        }
        string3 = this.fileHeader.getFileName();
        return string + System.getProperty((String)"file.separator") + string3;
    }

    private FileOutputStream getOutputStream(String string, String string2) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("invalid output path");
        }
        try {
            File file = new File(super.getOutputFileNameWithPath(string, string2));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            return fileOutputStream;
        }
        catch (FileNotFoundException var4_5) {
            throw new ZipException((Throwable)var4_5);
        }
    }

    private byte[] getStandardDecrypterHeaderBytes(RandomAccessFile randomAccessFile) throws ZipException {
        try {
            byte[] arrby = new byte[12];
            randomAccessFile.seek(this.localFileHeader.getOffsetStartOfData());
            randomAccessFile.read(arrby, 0, 12);
            return arrby;
        }
        catch (IOException var3_3) {
            throw new ZipException((Throwable)var3_3);
        }
        catch (Exception var2_4) {
            throw new ZipException((Throwable)var2_4);
        }
    }

    private void init(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.localFileHeader == null) {
            throw new ZipException("local file header is null, cannot initialize input stream");
        }
        try {
            super.initDecrypter(randomAccessFile);
            return;
        }
        catch (ZipException var3_2) {
            throw var3_2;
        }
        catch (Exception var2_3) {
            throw new ZipException((Throwable)var2_3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void initDecrypter(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.localFileHeader == null) {
            throw new ZipException("local file header is null, cannot init decrypter");
        }
        if (!this.localFileHeader.isEncrypted()) return;
        if (this.localFileHeader.getEncryptionMethod() == 0) {
            this.decrypter = new StandardDecrypter(this.fileHeader, super.getStandardDecrypterHeaderBytes(randomAccessFile));
            return;
        }
        if (this.localFileHeader.getEncryptionMethod() != 99) throw new ZipException("unsupported encryption method");
        this.decrypter = new AESDecrypter(this.localFileHeader, super.getAESSalt(randomAccessFile), super.getAESPasswordVerifier(randomAccessFile));
    }

    public void checkCRC() throws ZipException {
        if (this.fileHeader != null) {
            if (this.fileHeader.getEncryptionMethod() == 99) {
                if (this.decrypter != null && this.decrypter instanceof AESDecrypter) {
                    byte[] arrby = ((AESDecrypter)this.decrypter).getCalculatedAuthenticationBytes();
                    byte[] arrby2 = ((AESDecrypter)this.decrypter).getStoredMac();
                    byte[] arrby3 = new byte[10];
                    if (arrby3 == null || arrby2 == null) {
                        throw new ZipException("CRC (MAC) check failed for " + this.fileHeader.getFileName());
                    }
                    System.arraycopy((Object)arrby, (int)0, (Object)arrby3, (int)0, (int)10);
                    if (!Arrays.equals((byte[])arrby3, (byte[])arrby2)) {
                        throw new ZipException("invalid CRC (MAC) for file: " + this.fileHeader.getFileName());
                    }
                }
            } else if ((0xFFFFFFFFL & this.crc.getValue()) != this.fileHeader.getCrc32()) {
                String string = "invalid CRC for file: " + this.fileHeader.getFileName();
                if (this.localFileHeader.isEncrypted() && this.localFileHeader.getEncryptionMethod() == 0) {
                    string = string + " - Wrong Password?";
                }
                throw new ZipException(string);
            }
        }
    }

    public IDecrypter getDecrypter() {
        return this.decrypter;
    }

    public FileHeader getFileHeader() {
        return this.fileHeader;
    }

    /*
     * Exception decompiling
     */
    public ZipInputStream getInputStream() throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
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

    public LocalFileHeader getLocalFileHeader() {
        return this.localFileHeader;
    }

    public ZipModel getZipModel() {
        return this.zipModel;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public RandomAccessFile startNextSplitFile() throws IOException, FileNotFoundException {
        String string = this.zipModel.getZipFile();
        String string2 = this.currSplitFileCounter == this.zipModel.getEndCentralDirRecord().getNoOfThisDisk() ? this.zipModel.getZipFile() : (this.currSplitFileCounter >= 9 ? string.substring(0, string.lastIndexOf(".")) + ".z" + (1 + this.currSplitFileCounter) : string.substring(0, string.lastIndexOf(".")) + ".z0" + (1 + this.currSplitFileCounter));
        this.currSplitFileCounter = 1 + this.currSplitFileCounter;
        try {
            if (Zip4jUtil.checkFileExists(string2)) return new RandomAccessFile(string2, "r");
            {
                throw new IOException("zip split file does not exist: " + string2);
            }
        }
        catch (ZipException var3_3) {
            throw new IOException(var3_3.getMessage());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unzipFile(ProgressMonitor progressMonitor, String string, String string2, UnzipParameters unzipParameters) throws ZipException {
        if (this.zipModel == null || this.fileHeader == null || !Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("Invalid parameters passed during unzipping file. One or more of the parameters were null");
        }
        ZipInputStream zipInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            int n;
            byte[] arrby = new byte[4096];
            zipInputStream = this.getInputStream();
            fileOutputStream = super.getOutputStream(string, string2);
            while ((n = zipInputStream.read(arrby)) != -1) {
                fileOutputStream.write(arrby, 0, n);
                progressMonitor.updateWorkCompleted(n);
                if (!progressMonitor.isCancelAllTasks()) continue;
                progressMonitor.setResult(3);
                progressMonitor.setState(0);
                return;
            }
            super.closeStreams(zipInputStream, (OutputStream)fileOutputStream);
            UnzipUtil.applyFileAttributes(this.fileHeader, new File(super.getOutputFileNameWithPath(string, string2)), unzipParameters);
            return;
        }
        catch (IOException var9_9) {
            throw new ZipException((Throwable)var9_9);
        }
        catch (Exception var7_11) {
            throw new ZipException((Throwable)var7_11);
        }
        finally {
            super.closeStreams(zipInputStream, (OutputStream)fileOutputStream);
        }
    }

    public void updateCRC(int n) {
        this.crc.update(n);
    }

    public void updateCRC(byte[] arrby, int n, int n2) {
        if (arrby != null) {
            this.crc.update(arrby, n, n2);
        }
    }
}

