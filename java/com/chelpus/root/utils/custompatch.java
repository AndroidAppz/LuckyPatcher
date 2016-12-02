/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.android.vending.billing.InAppBillingService.LOCK.PatchesItem
 *  com.android.vending.billing.InAppBillingService.LOCK.SearchItem
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;
import com.android.vending.billing.InAppBillingService.LOCK.SearchItem;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class custompatch {
    public static boolean ART = false;
    static final int BUFFER = 2048;
    public static final byte[] MAGIC = new byte[]{100, 101, 121, 10, 48, 51, 53, 0};
    public static boolean OdexPatch = false;
    public static int adler = 0;
    public static boolean armv7 = false;
    public static ArrayList<File> arrayFile2 = new ArrayList();
    private static final int beginTag = 0;
    public static ArrayList<File> classesFiles;
    private static final int classesTag = 1;
    public static boolean convert = false;
    private static String dataBase;
    private static boolean dataBaseExist = false;
    public static String dir;
    public static String dir2;
    public static String dirapp;
    private static final int endTag = 4;
    private static final int fileInApkTag = 14;
    public static boolean fixunpack = false;
    public static boolean goodResult = false;
    private static String group;
    private static final int libTagALL = 2;
    private static final int libTagARM64V8A = 16;
    private static final int libTagARMEABI = 6;
    private static final int libTagARMEABIV7A = 7;
    private static final int libTagMIPS = 8;
    private static final int libTagx86 = 9;
    public static File localFile2;
    public static String log;
    public static boolean manualpatch = false;
    public static boolean multidex = false;
    public static boolean multilib_patch = false;
    public static boolean odex = false;
    private static final int odexTag = 10;
    public static boolean odexpatch = false;
    private static final int odexpatchTag = 11;
    private static final int otherfilesTag = 3;
    private static final int packageTag = 5;
    private static ArrayList<PatchesItem> pat;
    public static boolean patchteil = false;
    public static String pkgName;
    public static String sddir;
    private static ArrayList<Byte> search;
    private static String searchStr;
    private static ArrayList<SearchItem> ser;
    private static final int set_copy_file_Tag = 15;
    private static final int set_permissions_Tag = 13;
    private static final int sqlTag = 12;
    public static boolean system;
    public static int tag;
    public static String uid;
    public static boolean unpack;
    private static boolean withFramework;

    static {
        pat = null;
        ser = null;
        search = null;
        patchteil = false;
        unpack = false;
        fixunpack = false;
        manualpatch = false;
        odex = false;
        dir = "/sdcard/";
        dir2 = "/sdcard/";
        dirapp = "/data/app/";
        sddir = "/data/app/";
        uid = "";
        system = false;
        odexpatch = false;
        OdexPatch = false;
        armv7 = false;
        ART = false;
        convert = false;
        dataBaseExist = false;
        dataBase = "";
        searchStr = "";
        group = "";
        withFramework = true;
        pkgName = "";
        log = "";
        classesFiles = new ArrayList();
        multidex = false;
        goodResult = false;
        multilib_patch = false;
    }

    public static void addToLog(String string) {
        log = log + string + "\n";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void clearTemp() {
        try {
            File file;
            File file2;
            File file3;
            File file4;
            File file5;
            File file6;
            File file7;
            File file8;
            File file9;
            File file10 = new File(dir + "/AndroidManifest.xml");
            if (file10.exists()) {
                file10.delete();
            }
            if (classesFiles != null && classesFiles.size() > 0) {
                for (File file11 : classesFiles) {
                    File file12 = new File(dir + "/" + file11.getName());
                    if (!file12.exists()) continue;
                    file12.delete();
                }
            }
            if ((file2 = new File(dir + "/classes.dex")).exists()) {
                file2.delete();
            }
            if ((file9 = new File(dir + "/classes1.dex")).exists()) {
                file9.delete();
            }
            if ((file4 = new File(dir + "/classes2.dex")).exists()) {
                file4.delete();
            }
            if ((file = new File(dir + "/classes3.dex")).exists()) {
                file.delete();
            }
            if ((file3 = new File(dir + "/classes4.dex")).exists()) {
                file3.delete();
            }
            if ((file7 = new File(dir + "/classes5.dex")).exists()) {
                file7.delete();
            }
            if ((file6 = new File(dir + "/classes6.dex")).exists()) {
                file6.delete();
            }
            if ((file5 = new File(dir + "/classes.dex.apk")).exists()) {
                file5.delete();
            }
            if (!(file8 = new File(dir + "/classes.dex.dex")).exists()) return;
            {
                file8.delete();
                return;
            }
        }
        catch (Exception var1_4) {
            custompatch.addToLog("" + var1_4.toString());
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public static void main(String[] var0) {
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
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 26[UNCONDITIONALDOLOOP]
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

    /*
     * Exception decompiling
     */
    public static void searchDalvik(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 6[CATCHBLOCK]
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void searchDalvikOdex(String string, String string2) throws FileNotFoundException {
        custompatch.searchDalvik(string);
        try {
            if (!odexpatch) {
                File file;
                File file2;
                File file3;
                File file4;
                String string3 = Utils.getOdexForCreate(string2, uid);
                File file5 = new File(string3);
                if (file5.exists()) {
                    file5.delete();
                }
                if ((file3 = new File(string3.replace((CharSequence)"-2", (CharSequence)"-1"))).exists()) {
                    file3.delete();
                }
                if ((file2 = new File(string3.replace((CharSequence)"-1", (CharSequence)"-2"))).exists()) {
                    file2.delete();
                }
                if ((file = new File(string3.replace((CharSequence)"-2", (CharSequence)""))).exists()) {
                    file.delete();
                }
                if ((file4 = new File(string3.replace((CharSequence)"-1", (CharSequence)""))).exists()) {
                    file4.delete();
                }
                File file6 = new File(string3);
                Utils.copyFile(localFile2, file6);
                if (!file6.exists() || file6.length() != localFile2.length()) return;
                String[] arrstring = new String[]{"chmod", "644", file6.getAbsolutePath()};
                Utils.run_all_no_root(arrstring);
                String[] arrstring2 = new String[]{"chown", "1000." + uid, file6.getAbsolutePath()};
                Utils.run_all_no_root(arrstring2);
                String[] arrstring3 = new String[]{"chown", "1000:" + uid, file6.getAbsolutePath()};
                Utils.run_all_no_root(arrstring3);
                localFile2 = file6;
                return;
            }
            localFile2 = new File(Utils.getPlaceForOdex(dirapp, true));
            return;
        }
        catch (Exception var2_12) {
            var2_12.printStackTrace();
            custompatch.addToLog("Exception e" + var2_12.toString());
        }
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
    public static void searchfile(String var0_1, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static ArrayList<File> searchlib(String var0_1, String var1, String var2_2) {
        var3_3 = new ArrayList();
        try {
            var4_4 = new ArrayList();
            var4_4.add((Object)"/data/data/");
            var4_4.add((Object)"/mnt/asec/");
            var4_4.add((Object)"/sd-ext/data/");
            var4_4.add((Object)"/data/sdext2/");
            var4_4.add((Object)"/data/sdext1/");
            var4_4.add((Object)"/data/sdext/");
            var13_5 = new ArrayList();
            var13_5.add((Object)var0_1);
            var13_5.add((Object)(var0_1 + "-1"));
            var13_5.add((Object)(var0_1 + "-2"));
            if (!var1.trim().equals((Object)"*")) ** GOTO lbl20
            custompatch.multilib_patch = true;
            var28_6 = new File("/data/data/" + var0_1 + "/lib/").listFiles();
            if (var28_6 == null || var28_6.length <= 0) ** GOTO lbl59
            var47_7 = var28_6.length;
            ** GOTO lbl54
lbl20: // 1 sources:
            custompatch.localFile2 = new File("/data/data/" + var0_1 + "/lib/" + var1);
            if (!custompatch.localFile2.exists()) {
                for (String var22_33 : var4_4) {
                    for (String var24_35 : var13_5) {
                        var25_34 = new File(var22_33 + var24_35);
                        if (!var25_34.exists() || (var26_32 = new Utils("sdf").findFile(var25_34, var1)).equals((Object)"")) continue;
                        custompatch.localFile2 = var27_36 = new File(var26_32);
                        Utils.addFileToList(custompatch.localFile2, var3_3);
                        custompatch.addToLog("Found lib:" + var26_32);
                    }
                }
            } else {
                Utils.addFileToList(custompatch.localFile2, var3_3);
            }
            if (new File((Object)(var18_38 = Utils.getDirs(var17_37 = new File(var2_2))).getAbsoluteFile() + "/lib").exists()) {
                custompatch.localFile2 = new File((Object)var18_38.getAbsoluteFile() + "/lib/arm/" + var1);
                if (custompatch.localFile2.exists()) {
                    Utils.addFileToList(custompatch.localFile2, var3_3);
                }
                if ((custompatch.localFile2 = new File((Object)var18_38.getAbsoluteFile() + "/lib/arm64/" + var1)).exists()) {
                    Utils.addFileToList(custompatch.localFile2, var3_3);
                }
                if ((custompatch.localFile2 = new File((Object)var18_38.getAbsoluteFile() + "/lib/x86/" + var1)).exists()) {
                    Utils.addFileToList(custompatch.localFile2, var3_3);
                }
                if ((custompatch.localFile2 = new File((Object)var18_38.getAbsoluteFile() + "/lib/x86_64/" + var1)).exists()) {
                    Utils.addFileToList(custompatch.localFile2, var3_3);
                }
                if ((custompatch.localFile2 = new File((Object)var18_38.getAbsoluteFile() + "/lib/mips/" + var1)).exists()) {
                    Utils.addFileToList(custompatch.localFile2, var3_3);
                }
            }
            if (!custompatch.localFile2.exists()) {
                custompatch.localFile2 = new File("/system/lib/" + var1);
            }
            if (var3_3.size() == 0) {
                throw new FileNotFoundException();
            }
            var19_39 = new File(var2_2);
            var20_40 = var19_39.getName().replace((CharSequence)var0_1, (CharSequence)"").replace((CharSequence)".apk", (CharSequence)"");
            if (new File("/data/app-lib/" + var0_1 + var20_40 + "/" + var1).exists() == false) return var3_3;
            Utils.addFileToList(new File("/data/app-lib/" + var0_1 + var20_40 + "/" + var1), var3_3);
            return var3_3;
lbl54: // 3 sources:
            for (var48_8 = 0; var48_8 < var47_7; ++var48_8) {
                var49_9 = var28_6[var48_8];
                if (var49_9.length() <= 0 || !var49_9.getName().endsWith(".so")) continue;
                Utils.addFileToList(var49_9, var3_3);
            }
lbl59: // 2 sources:
            var29_10 = new File(var2_2);
            var30_11 = var29_10.getName().replace((CharSequence)var0_1, (CharSequence)"").replace((CharSequence)".apk", (CharSequence)"");
            if (new File("/data/app-lib").exists() && (var43_12 = new File("/data/app-lib/" + var0_1 + var30_11 + "/").listFiles()) != null && var43_12.length > 0) {
                for (File var46_15 : var43_12) {
                    if (var46_15.length() <= 0 || !var46_15.getName().endsWith(".so")) continue;
                    Utils.addFileToList(var46_15, var3_3);
                }
            }
            var31_16 = var4_4.iterator();
            block9 : do lbl-1000: // 3 sources:
            {
                if (var31_16.hasNext() == false) return var3_3;
                var32_23 = (String)var31_16.next();
                var33_17 = new File(var32_23 + var0_1 + var30_11 + "/");
                if (var33_17.exists() && !(var36_19 = (var34_22 = new Utils("sdf")).findFileEndText(var33_17, ".so", var35_27 = new ArrayList())).equals((Object)"") && var35_27.size() > 0) {
                    var42_21 = var35_27.iterator();
                    while (var42_21.hasNext()) {
                        Utils.addFileToList((File)var42_21.next(), var3_3);
                        custompatch.addToLog("Found lib:" + var36_19);
                    }
                }
                if (!(var37_18 = new File(var32_23 + var0_1 + "/")).exists() || (var40_26 = (var38_25 = new Utils("sdf")).findFileEndText(var37_18, ".so", var39_24 = new ArrayList())).equals((Object)"") || var39_24.size() <= 0) ** GOTO lbl-1000
                var41_20 = var39_24.iterator();
                do {
                    if (!var41_20.hasNext()) continue block9;
                    Utils.addFileToList((File)var41_20.next(), var3_3);
                    custompatch.addToLog("Found lib:" + var40_26);
                } while (true);
                break;
            } while (true);
        }
        catch (FileNotFoundException var6_28) {
            custompatch.addToLog("Error LP: " + (Object)custompatch.localFile2 + " are not found!\n\nCheck the location libraries to solve problems!\n");
            return null;
        }
        catch (Exception var5_29) {
            custompatch.addToLog("Exception e" + var5_29.toString());
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    public static void unzip(File var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredCatch.transformStructuredChildren(StructuredCatch.java:72)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredTry.transformStructuredChildren(StructuredTry.java:81)
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

}

