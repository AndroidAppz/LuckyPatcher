/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Byte
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
package net.lingala.zip4j.core;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.SplitOutputStream;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndCentralDirLocator;
import net.lingala.zip4j.model.Zip64EndCentralDirRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.Raw;

public class HeaderWriter {
    private final int ZIP64_EXTRA_BUF = 50;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private byte[] byteArrayListToByteArray(List list) throws ZipException {
        if (list == null) {
            throw new ZipException("input byte array list is null, cannot conver to byte array");
        }
        if (list.size() <= 0) {
            return null;
        }
        Object object = new byte[list.size()];
        int n = 0;
        while (n < list.size()) {
            object[n] = Byte.parseByte((String)((String)list.get(n)));
            ++n;
        }
        return object;
    }

    private void copyByteArrayToArrayList(byte[] arrby, List list) throws ZipException {
        if (list == null || arrby == null) {
            throw new ZipException("one of the input parameters is null, cannot copy byte array to array list");
        }
        for (int i = 0; i < arrby.length; ++i) {
            list.add((Object)Byte.toString((byte)arrby[i]));
        }
    }

    private int countNumberOfFileHeaderEntriesOnDisk(ArrayList arrayList, int n) throws ZipException {
        if (arrayList == null) {
            throw new ZipException("file headers are null, cannot calculate number of entries on this disk");
        }
        int n2 = 0;
        for (int i = 0; i < arrayList.size(); ++i) {
            if (((FileHeader)arrayList.get(i)).getDiskNumberStart() != n) continue;
            ++n2;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processHeaderData(ZipModel zipModel, OutputStream outputStream) throws ZipException {
        try {
            boolean bl = outputStream instanceof SplitOutputStream;
            int n = 0;
            if (bl) {
                zipModel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(((SplitOutputStream)outputStream).getFilePointer());
                n = ((SplitOutputStream)outputStream).getCurrSplitFileCounter();
            }
            if (zipModel.isZip64Format()) {
                if (zipModel.getZip64EndCentralDirRecord() == null) {
                    zipModel.setZip64EndCentralDirRecord(new Zip64EndCentralDirRecord());
                }
                if (zipModel.getZip64EndCentralDirLocator() == null) {
                    zipModel.setZip64EndCentralDirLocator(new Zip64EndCentralDirLocator());
                }
                zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(n);
                zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(n + 1);
            }
            zipModel.getEndCentralDirRecord().setNoOfThisDisk(n);
            zipModel.getEndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(n);
            return;
        }
        catch (IOException var3_5) {
            throw new ZipException((Throwable)var3_5);
        }
    }

    /*
     * Exception decompiling
     */
    private void updateCompressedSizeInLocalFileHeader(SplitOutputStream var1_4, LocalFileHeader var2_6, long var3_3, long var5_2, byte[] var7_5, boolean var8) throws ZipException {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int writeCentralDirectory(ZipModel zipModel, OutputStream outputStream, List list) throws ZipException {
        if (zipModel == null) throw new ZipException("input parameters is null, cannot write central directory");
        if (outputStream == null) {
            throw new ZipException("input parameters is null, cannot write central directory");
        }
        if (zipModel.getCentralDirectory() == null) return 0;
        if (zipModel.getCentralDirectory().getFileHeaders() == null) return 0;
        if (zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return 0;
        }
        int n = 0;
        int n2 = 0;
        while (n2 < zipModel.getCentralDirectory().getFileHeaders().size()) {
            n += super.writeFileHeader(zipModel, (FileHeader)zipModel.getCentralDirectory().getFileHeaders().get(n2), outputStream, list);
            ++n2;
        }
        return n;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void writeEndOfCentralDirectoryRecord(ZipModel zipModel, OutputStream outputStream, int n, long l, List list) throws ZipException {
        byte[] arrby;
        byte[] arrby2;
        int n2;
        byte[] arrby3;
        int n3;
        if (zipModel == null || outputStream == null) {
            throw new ZipException("zip model or output stream is null, cannot write end of central directory record");
        }
        try {
            arrby2 = new byte[2];
            arrby3 = new byte[4];
            arrby = new byte[8];
            Raw.writeIntLittleEndian(arrby3, 0, (int)zipModel.getEndCentralDirRecord().getSignature());
            this.copyByteArrayToArrayList(arrby3, list);
            Raw.writeShortLittleEndian(arrby2, 0, (short)zipModel.getEndCentralDirRecord().getNoOfThisDisk());
            this.copyByteArrayToArrayList(arrby2, list);
            Raw.writeShortLittleEndian(arrby2, 0, (short)zipModel.getEndCentralDirRecord().getNoOfThisDiskStartOfCentralDir());
            this.copyByteArrayToArrayList(arrby2, list);
            if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null) {
                throw new ZipException("invalid central directory/file headers, cannot write end of central directory record");
            }
            n2 = zipModel.getCentralDirectory().getFileHeaders().size();
            n3 = zipModel.isSplitArchive() ? this.countNumberOfFileHeaderEntriesOnDisk(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndCentralDirRecord().getNoOfThisDisk()) : n2;
        }
        catch (Exception var7_9) {
            throw new ZipException((Throwable)var7_9);
        }
        Raw.writeShortLittleEndian(arrby2, 0, (short)n3);
        this.copyByteArrayToArrayList(arrby2, list);
        Raw.writeShortLittleEndian(arrby2, 0, (short)n2);
        this.copyByteArrayToArrayList(arrby2, list);
        Raw.writeIntLittleEndian(arrby3, 0, n);
        this.copyByteArrayToArrayList(arrby3, list);
        if (l > 0xFFFFFFFFL) {
            Raw.writeLongLittleEndian(arrby, 0, 0xFFFFFFFFL);
            System.arraycopy((Object)arrby, (int)0, (Object)arrby3, (int)0, (int)4);
            this.copyByteArrayToArrayList(arrby3, list);
        } else {
            Raw.writeLongLittleEndian(arrby, 0, l);
            System.arraycopy((Object)arrby, (int)0, (Object)arrby3, (int)0, (int)4);
            this.copyByteArrayToArrayList(arrby3, list);
        }
        String string = zipModel.getEndCentralDirRecord().getComment();
        int n4 = 0;
        if (string != null) {
            n4 = zipModel.getEndCentralDirRecord().getCommentLength();
        }
        Raw.writeShortLittleEndian(arrby2, 0, (short)n4);
        this.copyByteArrayToArrayList(arrby2, list);
        if (n4 > 0) {
            this.copyByteArrayToArrayList(zipModel.getEndCentralDirRecord().getCommentBytes(), list);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private int writeFileHeader(ZipModel var1_1, FileHeader var2_4, OutputStream var3_3, List var4) throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [26[TRYBLOCK]], but top level block is 17[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
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

    private void writeZip64EndOfCentralDirectoryLocator(ZipModel zipModel, OutputStream outputStream, List list) throws ZipException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("zip model or output stream is null, cannot write zip64 end of central directory locator");
        }
        try {
            byte[] arrby = new byte[4];
            byte[] arrby2 = new byte[8];
            Raw.writeIntLittleEndian(arrby, 0, 117853008);
            super.copyByteArrayToArrayList(arrby, list);
            Raw.writeIntLittleEndian(arrby, 0, zipModel.getZip64EndCentralDirLocator().getNoOfDiskStartOfZip64EndOfCentralDirRec());
            super.copyByteArrayToArrayList(arrby, list);
            Raw.writeLongLittleEndian(arrby2, 0, zipModel.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec());
            super.copyByteArrayToArrayList(arrby2, list);
            Raw.writeIntLittleEndian(arrby, 0, zipModel.getZip64EndCentralDirLocator().getTotNumberOfDiscs());
            super.copyByteArrayToArrayList(arrby, list);
            return;
        }
        catch (ZipException var5_6) {
            throw var5_6;
        }
        catch (Exception var4_7) {
            throw new ZipException((Throwable)var4_7);
        }
    }

    /*
     * Exception decompiling
     */
    private void writeZip64EndOfCentralDirectoryRecord(ZipModel var1_3, OutputStream var2_5, int var3_1, long var4_2, List var6_4) throws ZipException {
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

    private void writeZipHeaderBytes(ZipModel zipModel, OutputStream outputStream, byte[] arrby) throws ZipException {
        if (arrby == null) {
            throw new ZipException("invalid buff to write as zip headers");
        }
        try {
            if (outputStream instanceof SplitOutputStream && ((SplitOutputStream)outputStream).checkBuffSizeAndStartNextSplitFile(arrby.length)) {
                this.finalizeZipFile(zipModel, outputStream);
                return;
            }
            outputStream.write(arrby);
            return;
        }
        catch (IOException var4_4) {
            throw new ZipException((Throwable)var4_4);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void finalizeZipFile(ZipModel zipModel, OutputStream outputStream) throws ZipException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot finalize zip file");
        }
        try {
            super.processHeaderData(zipModel, outputStream);
            long l = zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir();
            ArrayList arrayList = new ArrayList();
            int n = super.writeCentralDirectory(zipModel, outputStream, (List)arrayList);
            if (zipModel.isZip64Format()) {
                if (zipModel.getZip64EndCentralDirRecord() == null) {
                    zipModel.setZip64EndCentralDirRecord(new Zip64EndCentralDirRecord());
                }
                if (zipModel.getZip64EndCentralDirLocator() == null) {
                    zipModel.setZip64EndCentralDirLocator(new Zip64EndCentralDirLocator());
                }
                zipModel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec(l + (long)n);
                if (outputStream instanceof SplitOutputStream) {
                    zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(((SplitOutputStream)outputStream).getCurrSplitFileCounter());
                    zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(1 + ((SplitOutputStream)outputStream).getCurrSplitFileCounter());
                } else {
                    zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(0);
                    zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(1);
                }
                super.writeZip64EndOfCentralDirectoryRecord(zipModel, outputStream, n, l, (List)arrayList);
                super.writeZip64EndOfCentralDirectoryLocator(zipModel, outputStream, (List)arrayList);
            }
            super.writeEndOfCentralDirectoryRecord(zipModel, outputStream, n, l, (List)arrayList);
            super.writeZipHeaderBytes(zipModel, outputStream, super.byteArrayListToByteArray((List)arrayList));
            return;
        }
        catch (ZipException var4_6) {
            throw var4_6;
        }
        catch (Exception var3_7) {
            throw new ZipException((Throwable)var3_7);
        }
    }

    public void finalizeZipFileWithoutValidations(ZipModel zipModel, OutputStream outputStream) throws ZipException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot finalize zip file without validations");
        }
        try {
            ArrayList arrayList = new ArrayList();
            long l = zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir();
            int n = super.writeCentralDirectory(zipModel, outputStream, (List)arrayList);
            if (zipModel.isZip64Format()) {
                if (zipModel.getZip64EndCentralDirRecord() == null) {
                    zipModel.setZip64EndCentralDirRecord(new Zip64EndCentralDirRecord());
                }
                if (zipModel.getZip64EndCentralDirLocator() == null) {
                    zipModel.setZip64EndCentralDirLocator(new Zip64EndCentralDirLocator());
                }
                zipModel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec(l + (long)n);
                super.writeZip64EndOfCentralDirectoryRecord(zipModel, outputStream, n, l, (List)arrayList);
                super.writeZip64EndOfCentralDirectoryLocator(zipModel, outputStream, (List)arrayList);
            }
            super.writeEndOfCentralDirectoryRecord(zipModel, outputStream, n, l, (List)arrayList);
            super.writeZipHeaderBytes(zipModel, outputStream, super.byteArrayListToByteArray((List)arrayList));
            return;
        }
        catch (ZipException var5_6) {
            throw var5_6;
        }
        catch (Exception var4_7) {
            throw new ZipException((Throwable)var4_7);
        }
    }

    /*
     * Exception decompiling
     */
    public void updateLocalFileHeader(LocalFileHeader var1_4, long var2_7, int var4_3, ZipModel var5_2, byte[] var6_6, int var7_5, SplitOutputStream var8) throws ZipException {
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

    public int writeExtendedLocalHeader(LocalFileHeader localFileHeader, OutputStream outputStream) throws ZipException, IOException {
        if (localFileHeader == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot write extended local header");
        }
        ArrayList arrayList = new ArrayList();
        byte[] arrby = new byte[4];
        Raw.writeIntLittleEndian(arrby, 0, 134695760);
        super.copyByteArrayToArrayList(arrby, (List)arrayList);
        Raw.writeIntLittleEndian(arrby, 0, (int)localFileHeader.getCrc32());
        super.copyByteArrayToArrayList(arrby, (List)arrayList);
        long l = localFileHeader.getCompressedSize();
        if (l >= Integer.MAX_VALUE) {
            l = Integer.MAX_VALUE;
        }
        Raw.writeIntLittleEndian(arrby, 0, (int)l);
        super.copyByteArrayToArrayList(arrby, (List)arrayList);
        long l2 = localFileHeader.getUncompressedSize();
        if (l2 >= Integer.MAX_VALUE) {
            l2 = Integer.MAX_VALUE;
        }
        Raw.writeIntLittleEndian(arrby, 0, (int)l2);
        super.copyByteArrayToArrayList(arrby, (List)arrayList);
        byte[] arrby2 = super.byteArrayListToByteArray((List)arrayList);
        outputStream.write(arrby2);
        return arrby2.length;
    }

    /*
     * Exception decompiling
     */
    public int writeLocalFileHeader(ZipModel var1, LocalFileHeader var2_3, OutputStream var3_2) throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 2[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
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
}

