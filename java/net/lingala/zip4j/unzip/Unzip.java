/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package net.lingala.zip4j.unzip;

import java.io.File;
import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.UnzipEngine;
import net.lingala.zip4j.util.Zip4jUtil;

public class Unzip {
    private ZipModel zipModel;

    public Unzip(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("ZipModel is null");
        }
        this.zipModel = zipModel;
    }

    /*
     * Enabled aggressive block sorting
     */
    private long calculateTotalWork(ArrayList arrayList) throws ZipException {
        if (arrayList == null) {
            throw new ZipException("fileHeaders is null, cannot calculate total work");
        }
        long l = 0;
        int n = 0;
        while (n < arrayList.size()) {
            FileHeader fileHeader = (FileHeader)arrayList.get(n);
            l = fileHeader.getZip64ExtendedInfo() != null && fileHeader.getZip64ExtendedInfo().getUnCompressedSize() > 0 ? (l += fileHeader.getZip64ExtendedInfo().getCompressedSize()) : (l += fileHeader.getCompressedSize());
            ++n;
        }
        return l;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void checkOutputDirectoryStructure(FileHeader fileHeader, String string, String string2) throws ZipException {
        if (fileHeader == null) throw new ZipException("Cannot check output directory structure...one of the parameters was null");
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("Cannot check output directory structure...one of the parameters was null");
        }
        String string3 = fileHeader.getFileName();
        if (Zip4jUtil.isStringNotNullAndNotEmpty(string2)) {
            string3 = string2;
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string3)) {
            return;
        }
        String string4 = string + string3;
        try {
            File file = new File(new File(string4).getParent());
            if (file.exists()) return;
            file.mkdirs();
            return;
        }
        catch (Exception var7_7) {
            throw new ZipException((Throwable)var7_7);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void initExtractAll(ArrayList arrayList, UnzipParameters unzipParameters, ProgressMonitor progressMonitor, String string) throws ZipException {
        int n = 0;
        while (n < arrayList.size()) {
            super.initExtractFile((FileHeader)arrayList.get(n), string, unzipParameters, null, progressMonitor);
            if (progressMonitor.isCancelAllTasks()) {
                progressMonitor.setResult(3);
                progressMonitor.setState(0);
                return;
            }
            ++n;
        }
    }

    /*
     * Exception decompiling
     */
    private void initExtractFile(FileHeader var1_4, String var2_5, UnzipParameters var3_2, String var4_3, ProgressMonitor var5_1) throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 8[CATCHBLOCK]
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

    public void extractAll(final UnzipParameters unzipParameters, final String string, final ProgressMonitor progressMonitor, boolean bl) throws ZipException {
        CentralDirectory centralDirectory = this.zipModel.getCentralDirectory();
        if (centralDirectory == null || centralDirectory.getFileHeaders() == null) {
            throw new ZipException("invalid central directory in zipModel");
        }
        final ArrayList arrayList = centralDirectory.getFileHeaders();
        progressMonitor.setCurrentOperation(1);
        progressMonitor.setTotalWork(super.calculateTotalWork(arrayList));
        progressMonitor.setState(1);
        if (bl) {
            new Thread("Zip4j"){

                public void run() {
                    try {
                        Unzip.this.initExtractAll(arrayList, unzipParameters, progressMonitor, string);
                        progressMonitor.endProgressMonitorSuccess();
                        return;
                    }
                    catch (ZipException var1_1) {
                        return;
                    }
                }
            }.start();
            return;
        }
        super.initExtractAll(arrayList, unzipParameters, progressMonitor, string);
    }

    public void extractFile(final FileHeader fileHeader, final String string, final UnzipParameters unzipParameters, final String string2, final ProgressMonitor progressMonitor, boolean bl) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("fileHeader is null");
        }
        progressMonitor.setCurrentOperation(1);
        progressMonitor.setTotalWork(fileHeader.getCompressedSize());
        progressMonitor.setState(1);
        progressMonitor.setPercentDone(0);
        progressMonitor.setFileName(fileHeader.getFileName());
        if (bl) {
            new Thread("Zip4j"){

                public void run() {
                    try {
                        Unzip.this.initExtractFile(fileHeader, string, unzipParameters, string2, progressMonitor);
                        progressMonitor.endProgressMonitorSuccess();
                        return;
                    }
                    catch (ZipException var1_1) {
                        return;
                    }
                }
            }.start();
            return;
        }
        this.initExtractFile(fileHeader, string, unzipParameters, string2, progressMonitor);
        progressMonitor.endProgressMonitorSuccess();
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) throws ZipException {
        return new UnzipEngine(this.zipModel, fileHeader).getInputStream();
    }

}

