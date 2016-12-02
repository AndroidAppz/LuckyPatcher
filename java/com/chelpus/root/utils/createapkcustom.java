/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem
 *  com.android.vending.billing.InAppBillingService.LOCK.PatchesItem
 *  com.android.vending.billing.InAppBillingService.LOCK.SearchItem
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.InputStream
 *  java.io.PrintStream
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.DigestException
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.zip.Adler32
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipInputStream
 */
package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;
import com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;
import com.android.vending.billing.InAppBillingService.LOCK.SearchItem;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class createapkcustom {
    static final int BUFFER = 2048;
    private static final int all = 4;
    public static String appdir;
    private static final int arm64v8a = 5;
    private static final int armeabi = 0;
    private static final int armeabiv7a = 1;
    private static final int beginTag = 0;
    public static ArrayList<File> classesFiles;
    private static final int classesTag = 1;
    public static File crkapk;
    public static String dir;
    public static String dir2;
    private static final int endTag = 4;
    private static final int fileInApkTag = 10;
    public static boolean goodResult = false;
    private static String group;
    private static final int libTagALL = 2;
    private static final int libTagARM64V8A = 11;
    private static final int libTagARMEABI = 6;
    private static final int libTagARMEABIV7A = 7;
    private static final int libTagMIPS = 8;
    private static final int libTagx86 = 9;
    private static ArrayList<String> libs;
    public static File localFile2;
    public static boolean manualpatch = false;
    private static final int mips = 2;
    public static boolean multidex = false;
    public static boolean multilib_patch = false;
    public static String packageName;
    private static final int packageTag = 5;
    private static ArrayList<PatchesItem> pat;
    public static ArrayList<String> patchedLibs;
    public static boolean patchteil = false;
    private static PrintStream print;
    public static String sddir;
    private static ArrayList<Byte> search;
    private static String searchStr;
    private static ArrayList<SearchItem> ser;
    public static int tag = 0;
    public static String tooldir;
    public static boolean unpack = false;
    private static final int x86 = 3;

    static {
        pat = null;
        ser = null;
        search = null;
        patchteil = false;
        unpack = false;
        manualpatch = false;
        dir = "/sdcard/";
        dir2 = "/sdcard/";
        sddir = "/sdcard/";
        appdir = "/sdcard/";
        tooldir = "/sdcard/";
        packageName = "";
        libs = new ArrayList();
        patchedLibs = new ArrayList();
        group = "";
        classesFiles = new ArrayList();
        multidex = false;
        goodResult = false;
        multilib_patch = false;
        searchStr = "";
    }

    static /* synthetic */ PrintStream access$000() {
        return print;
    }

    private static final void calcChecksum(byte[] arrby, int n) {
        Adler32 adler32 = new Adler32();
        adler32.update(arrby, 12, arrby.length - (n + 12));
        int n2 = (int)adler32.getValue();
        arrby[n + 8] = (byte)n2;
        arrby[n + 9] = (byte)(n2 >> 8);
        arrby[n + 10] = (byte)(n2 >> 16);
        arrby[n + 11] = (byte)(n2 >> 24);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void calcSignature(byte[] arrby, int n) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance((String)"SHA-1");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException((Throwable)noSuchAlgorithmException);
        }
        messageDigest.update(arrby, 32, arrby.length - (n + 32));
        int n3 = n + 12;
        try {
            int n2 = messageDigest.digest(arrby, n3, 20);
            if (n2 == 20) return;
            {
                throw new RuntimeException("unexpected digest write:" + n2 + "bytes");
            }
        }
        catch (DigestException var5_5) {
            throw new RuntimeException((Throwable)var5_5);
        }
    }

    public static void clearTemp() {
        try {
            File file = new File(sddir + "/Modified/classes.dex.apk");
            if (file.exists()) {
                file.delete();
            }
            return;
        }
        catch (Exception var1_1) {
            print.println("" + var1_1.toString());
            return;
        }
    }

    public static String extractFile(File file, String string) {
        return new Decompress(file.getAbsolutePath(), sddir + "/tmp/").unzip(string);
    }

    public static void extractLibs(File file) {
        String string = file.getAbsolutePath();
        String string2 = sddir + "/tmp/";
        if (!new File(sddir + "/tmp/lib/").exists()) {
            new Decompress(string, string2).unzip();
        }
    }

    public static void fixadler(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] arrby = new byte[fileInputStream.available()];
            fileInputStream.read(arrby);
            createapkcustom.calcSignature(arrby, 0);
            createapkcustom.calcChecksum(arrby, 0);
            fileInputStream.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(arrby);
            fileOutputStream.close();
            return;
        }
        catch (Exception var2_4) {
            var2_4.printStackTrace();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void getClassesDex() {
        try {
            File file = new File(appdir);
            crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
            Utils.copyFile(file, crkapk);
            createapkcustom.unzip(crkapk);
            if (classesFiles == null || classesFiles.size() == 0) {
                throw new FileNotFoundException();
            }
            if (classesFiles != null && classesFiles.size() > 0) {
                Iterator iterator = classesFiles.iterator();
                while (iterator.hasNext()) {
                    if (((File)iterator.next()).exists()) continue;
                    throw new FileNotFoundException();
                }
            }
            System.out.println("get classes.dex " + classesFiles.size());
            return;
        }
        catch (FileNotFoundException var2_1) {
            print.println("Error LP: unzip classes.dex fault!\n\n");
            return;
        }
        catch (Exception var1_3) {
            print.println("Extract classes.dex error: " + var1_3.toString());
            return;
        }
    }

    public static String getFileFromApk(String string) {
        try {
            File file = new File(appdir);
            crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
            if (!crkapk.exists()) {
                Utils.copyFile(file, crkapk);
            }
            String string2 = createapkcustom.extractFile(crkapk, string);
            return string2;
        }
        catch (Exception var2_3) {
            print.println("Lib select error: " + var2_3.toString());
            return "";
        }
    }

    /*
     * Exception decompiling
     */
    public static String main(String[] var0) {
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

    /*
     * Exception decompiling
     */
    public static boolean patchProcess(ArrayList<PatchesItem> var0) {
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

    /*
     * Exception decompiling
     */
    public static boolean searchProcess(ArrayList<SearchItem> var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl81 : TryStatement: try { 9[TRYBLOCK]

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

    /*
     * Exception decompiling
     */
    public static ArrayList<String> searchlib(int var0_1, String var1) {
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void unzip(File var0) {
        createapkcustom.classesFiles.clear();
        try {
            var1_1 = new FileInputStream(var0);
            var2_2 = new ZipInputStream((InputStream)var1_1);
            while ((var7_5 = var2_2.getNextEntry()) != null) {
                if (!var7_5.getName().toLowerCase().startsWith("classes") || !var7_5.getName().endsWith(".dex") || var7_5.getName().contains((CharSequence)"/")) continue;
                var8_3 = new FileOutputStream(createapkcustom.sddir + "/Modified/" + var7_5.getName());
                var9_6 = new byte[1024];
                while ((var10_4 = var2_2.read(var9_6)) != -1) {
                    var8_3.write(var9_6, 0, var10_4);
                }
                createapkcustom.classesFiles.add((Object)new File(createapkcustom.sddir + "/Modified/" + var7_5.getName()));
                var2_2.closeEntry();
                var8_3.close();
            }
            ** GOTO lbl22
        }
        catch (Exception var3_7) {
            try {
                new ZipFile(var0).extractFile("classes.dex", createapkcustom.sddir + "/Modified/");
                createapkcustom.classesFiles.add((Object)new File(createapkcustom.sddir + "/Modified/" + "classes.dex"));
                return;
            }
            catch (ZipException var5_8) {
                createapkcustom.print.println("Error LP: Error classes.dex decompress! " + (Object)var5_8);
                createapkcustom.print.println("Exception e1" + var3_7.toString());
                return;
            }
            catch (Exception var4_9) {
                createapkcustom.print.println("Error LP: Error classes.dex decompress! " + (Object)var4_9);
                createapkcustom.print.println("Exception e1" + var3_7.toString());
                return;
            }
lbl22: // 1 sources:
            var2_2.close();
            var1_1.close();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zipLib(ArrayList<String> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            for (String string : arrayList) {
                System.out.println(string);
                arrayList2.add((Object)new AddFilesItem(string, sddir + "/tmp/"));
            }
            Utils.addFilesToZip(crkapk.getAbsolutePath(), crkapk.getAbsolutePath() + "checlpis.zip", arrayList2);
            crkapk.delete();
            if (!crkapk.exists()) {
                new File(crkapk.getAbsolutePath() + "checlpis.zip").renameTo(crkapk);
            }
            if (!crkapk.exists()) return;
            {
                System.out.println(crkapk.getAbsolutePath());
                System.out.println(crkapk.length());
                String[] arrstring = new String[]{"chmod", "777", "'" + crkapk.getAbsolutePath() + "'"};
                Utils.cmdParam(arrstring);
                new Utils("").setAllWritable(Utils.getDirs(crkapk));
                return;
            }
        }
        catch (Exception var3_4) {
            print.println("Error LP: Error libs compress! " + (Object)var3_4);
            return;
        }
        catch (OutOfMemoryError var2_6) {
            var2_6.printStackTrace();
            print.println("Error LP: Error libs compress! Out of memory for operation: " + (Object)var2_6);
            return;
        }
    }

    public static class Decompress {
        private String _location;
        private String _zipFile;

        public Decompress(String string, String string2) {
            this._zipFile = string;
            this._location = string2;
            super._dirChecker("");
        }

        private void _dirChecker(String string) {
            File file = new File(this._location + string);
            if (file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        }

        /*
         * Exception decompiling
         */
        public String unzip(String var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl20 : TryStatement: try { 2[TRYBLOCK]

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
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }

        /*
         * Exception decompiling
         */
        public void unzip() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl20 : TryStatement: try { 2[TRYBLOCK]

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
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }
    }

}

