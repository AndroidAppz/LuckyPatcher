/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package net.lingala.zip4j.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip64EndCentralDirLocator;
import net.lingala.zip4j.model.Zip64EndCentralDirRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.Zip4jUtil;

public class ArchiveMaintainer {
    /*
     * Enabled aggressive block sorting
     */
    private long calculateTotalWorkForMergeOp(ZipModel zipModel) throws ZipException {
        long l = 0;
        if (!zipModel.isSplitArchive()) {
            return l;
        }
        int n = zipModel.getEndCentralDirRecord().getNoOfThisDisk();
        String string = zipModel.getZipFile();
        int n2 = 0;
        while (n2 <= n) {
            String string2 = zipModel.getEndCentralDirRecord().getNoOfThisDisk() == 0 ? zipModel.getZipFile() : (9 >= 0 ? string.substring(0, string.lastIndexOf(".")) + ".z" + 1 : string.substring(0, string.lastIndexOf(".")) + ".z0" + 1);
            l += Zip4jUtil.getFileLengh(new File(string2));
            ++n2;
        }
        return l;
    }

    private long calculateTotalWorkForRemoveOp(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        return Zip4jUtil.getFileLengh(new File(zipModel.getZipFile())) - fileHeader.getCompressedSize();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void copyFile(RandomAccessFile randomAccessFile, OutputStream outputStream, long l, long l2, ProgressMonitor progressMonitor) throws ZipException {
        if (randomAccessFile == null || outputStream == null) {
            throw new ZipException("input or output stream is null, cannot copy file");
        }
        if (l < 0) {
            throw new ZipException("starting offset is negative, cannot copy file");
        }
        if (l2 < 0) {
            throw new ZipException("end offset is negative, cannot copy file");
        }
        if (l > l2) {
            throw new ZipException("start offset is greater than end offset, cannot copy file");
        }
        if (l != l2) {
            int n;
            byte[] arrby;
            if (progressMonitor.isCancelAllTasks()) {
                progressMonitor.setResult(3);
                progressMonitor.setState(0);
                return;
            }
            randomAccessFile.seek(l);
            long l3 = 0;
            long l4 = l2 - l;
            if (l2 - l < 4096) {
                arrby = new byte[(int)(l2 - l)];
            }
            try {
                arrby = new byte[4096];
            }
            catch (IOException var9_10) {
                throw new ZipException((Throwable)var9_10);
            }
            catch (Exception var8_11) {
                throw new ZipException((Throwable)var8_11);
            }
            while ((n = randomAccessFile.read(arrby)) != -1) {
                outputStream.write(arrby, 0, n);
                progressMonitor.updateWorkCompleted(n);
                if (progressMonitor.isCancelAllTasks()) {
                    progressMonitor.setResult(3);
                    return;
                }
                if ((l3 += (long)n) == l4) break;
                if (l3 + (long)arrby.length <= l4) continue;
                arrby = new byte[(int)(l4 - l3)];
            }
        }
    }

    private RandomAccessFile createFileHandler(ZipModel zipModel, String string) throws ZipException {
        if (zipModel == null || !Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getZipFile())) {
            throw new ZipException("input parameter is null in getFilePointer, cannot create file handler to remove file");
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(zipModel.getZipFile()), string);
            return randomAccessFile;
        }
        catch (FileNotFoundException var4_4) {
            throw new ZipException((Throwable)var4_4);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private RandomAccessFile createSplitZipFileHandler(ZipModel zipModel, int n) throws ZipException {
        String string;
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot create split file handler");
        }
        if (n < 0) {
            throw new ZipException("invlaid part number, cannot create split file handler");
        }
        try {
            String string2 = zipModel.getZipFile();
            string = n == zipModel.getEndCentralDirRecord().getNoOfThisDisk() ? zipModel.getZipFile() : (n >= 9 ? string2.substring(0, string2.lastIndexOf(".")) + ".z" + (n + 1) : string2.substring(0, string2.lastIndexOf(".")) + ".z0" + (n + 1));
        }
        catch (FileNotFoundException var4_6) {
            throw new ZipException((Throwable)var4_6);
        }
        File file = new File(string);
        if (Zip4jUtil.checkFileExists(file)) return new RandomAccessFile(file, "r");
        throw new ZipException("split file does not exist: " + string);
        catch (Exception exception) {
            throw new ZipException((Throwable)exception);
        }
    }

    /*
     * Exception decompiling
     */
    private void initMergeSplitZipFile(ZipModel var1, File var2_3, ProgressMonitor var3_2) throws ZipException {
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

    private OutputStream prepareOutputStreamForMerge(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("outFile is null, cannot create outputstream");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            return fileOutputStream;
        }
        catch (FileNotFoundException var4_3) {
            throw new ZipException((Throwable)var4_3);
        }
        catch (Exception var3_4) {
            throw new ZipException((Throwable)var3_4);
        }
    }

    private void restoreFileName(File file, String string) throws ZipException {
        if (file.delete()) {
            if (!new File(string).renameTo(file)) {
                throw new ZipException("cannot rename modified zip file");
            }
        } else {
            throw new ZipException("cannot delete old zip file");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void updateSplitEndCentralDirectory(ZipModel var1_1) throws ZipException {
        if (var1_1 != null) ** GOTO lbl4
        try {
            throw new ZipException("zip model is null - cannot update end of central directory for split zip model");
lbl4: // 1 sources:
            if (var1_1.getCentralDirectory() == null) {
                throw new ZipException("corrupt zip model - getCentralDirectory, cannot update split zip model");
            }
            var1_1.getEndCentralDirRecord().setNoOfThisDisk(0);
            var1_1.getEndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(0);
            var1_1.getEndCentralDirRecord().setTotNoOfEntriesInCentralDir(var1_1.getCentralDirectory().getFileHeaders().size());
            var1_1.getEndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(var1_1.getCentralDirectory().getFileHeaders().size());
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
     * Exception decompiling
     */
    private void updateSplitFileHeader(ZipModel var1, ArrayList var2_3, boolean var3_2) throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl6 : TryStatement: try { 1[TRYBLOCK]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
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

    private void updateSplitZip64EndCentralDirLocator(ZipModel zipModel, ArrayList arrayList) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot update split Zip64 end of central directory locator");
        }
        if (zipModel.getZip64EndCentralDirLocator() == null) {
            return;
        }
        zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(0);
        long l = 0;
        for (int i = 0; i < arrayList.size(); ++i) {
            l += ((Long)arrayList.get(i)).longValue();
        }
        zipModel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec(l + zipModel.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec());
        zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(1);
    }

    private void updateSplitZip64EndCentralDirRec(ZipModel zipModel, ArrayList arrayList) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot update split Zip64 end of central directory record");
        }
        if (zipModel.getZip64EndCentralDirRecord() == null) {
            return;
        }
        zipModel.getZip64EndCentralDirRecord().setNoOfThisDisk(0);
        zipModel.getZip64EndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(0);
        zipModel.getZip64EndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(zipModel.getEndCentralDirRecord().getTotNoOfEntriesInCentralDir());
        long l = 0;
        for (int i = 0; i < arrayList.size(); ++i) {
            l += ((Long)arrayList.get(i)).longValue();
        }
        zipModel.getZip64EndCentralDirRecord().setOffsetStartCenDirWRTStartDiskNo(l + zipModel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo());
    }

    private void updateSplitZipModel(ZipModel zipModel, ArrayList arrayList, boolean bl) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot update split zip model");
        }
        zipModel.setSplitArchive(false);
        super.updateSplitFileHeader(zipModel, arrayList, bl);
        super.updateSplitEndCentralDirectory(zipModel);
        if (zipModel.isZip64Format()) {
            super.updateSplitZip64EndCentralDirLocator(zipModel, arrayList);
            super.updateSplitZip64EndCentralDirRec(zipModel, arrayList);
        }
    }

    public void initProgressMonitorForMergeOp(ZipModel zipModel, ProgressMonitor progressMonitor) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot calculate total work for merge op");
        }
        progressMonitor.setCurrentOperation(4);
        progressMonitor.setFileName(zipModel.getZipFile());
        progressMonitor.setTotalWork(super.calculateTotalWorkForMergeOp(zipModel));
        progressMonitor.setState(1);
    }

    public void initProgressMonitorForRemoveOp(ZipModel zipModel, FileHeader fileHeader, ProgressMonitor progressMonitor) throws ZipException {
        if (zipModel == null || fileHeader == null || progressMonitor == null) {
            throw new ZipException("one of the input parameters is null, cannot calculate total work");
        }
        progressMonitor.setCurrentOperation(2);
        progressMonitor.setFileName(fileHeader.getFileName());
        progressMonitor.setTotalWork(super.calculateTotalWorkForRemoveOp(zipModel, fileHeader));
        progressMonitor.setState(1);
    }

    /*
     * Exception decompiling
     */
    public HashMap initRemoveZipFile(ZipModel var1, FileHeader var2_3, ProgressMonitor var3_2) throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl28 : TryStatement: try { 3[TRYBLOCK]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
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

    public void mergeSplitZipFiles(final ZipModel zipModel, final File file, final ProgressMonitor progressMonitor, boolean bl) throws ZipException {
        if (bl) {
            new Thread("Zip4j"){

                public void run() {
                    try {
                        ArchiveMaintainer.this.initMergeSplitZipFile(zipModel, file, progressMonitor);
                        return;
                    }
                    catch (ZipException var1_1) {
                        return;
                    }
                }
            }.start();
            return;
        }
        super.initMergeSplitZipFile(zipModel, file, progressMonitor);
    }

    public HashMap removeZipFile(final ZipModel zipModel, final FileHeader fileHeader, final ProgressMonitor progressMonitor, boolean bl) throws ZipException {
        if (bl) {
            new Thread("Zip4j"){

                public void run() {
                    try {
                        ArchiveMaintainer.this.initRemoveZipFile(zipModel, fileHeader, progressMonitor);
                        progressMonitor.endProgressMonitorSuccess();
                        return;
                    }
                    catch (ZipException var1_1) {
                        return;
                    }
                }
            }.start();
            return null;
        }
        HashMap hashMap = this.initRemoveZipFile(zipModel, fileHeader, progressMonitor);
        progressMonitor.endProgressMonitorSuccess();
        return hashMap;
    }

    /*
     * Exception decompiling
     */
    public void setComment(ZipModel var1_1, String var2_2) throws ZipException {
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

}

