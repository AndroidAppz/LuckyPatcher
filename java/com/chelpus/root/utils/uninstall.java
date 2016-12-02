/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class uninstall {
    public static String datadir;
    public static String dirapp;
    public static boolean odexpatch;
    public static boolean system;

    static {
        dirapp = "/data/app/";
        datadir = "/data/data/";
        system = false;
        odexpatch = false;
    }

    /*
     * Exception decompiling
     */
    public static ArrayList<String> getLibs(File var0) {
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
    public static void main(String[] var0) {
        Utils.startRootJava(new Object(){});
        uninstall.dirapp = var0[1];
        uninstall.system = true;
        uninstall.datadir = var0[2];
        var2_1 = new File(uninstall.dirapp);
        var3_2 = new File(Utils.getPlaceForOdex(uninstall.dirapp, true));
        System.out.println("Start getLibs!");
        var4_3 = uninstall.getLibs(var2_1);
        System.out.println("Start delete lib!");
        if (!var4_3.isEmpty()) {
            for (String var14_5 : var4_3) {
                var15_6 = new File("/system/lib/" + var14_5);
                if (!var15_6.exists()) continue;
                var15_6.delete();
            }
        }
        System.out.println("Start delete data directory!");
        var5_8 = new Utils("uninstall system");
lbl-1000: // 4 sources:
        {
            catch (Exception var1_7) {
                System.out.println("LuckyPatcher Error uninstall: " + (Object)var1_7);
                var1_7.printStackTrace();
lbl22: // 2 sources:
                Utils.exitFromRootJava();
                return;
            }
        }
        System.out.println("Start delete dir!");
        var5_8.deleteFolder(new File(uninstall.datadir));
        var5_8.deleteFolder(new File(uninstall.datadir.replace((CharSequence)"/data/data/", (CharSequence)"/dbdata/databases/")));
        {
            catch (Exception var6_11) {
                System.out.println("LuckyPatcher Error uninstall: " + (Object)var6_11);
                var6_11.printStackTrace();
            }
            System.out.println("Start delete dc!");
            try {
                var10_9 = Utils.getFileDalvikCache(uninstall.dirapp);
                if (var10_9 != null) {
                    var10_9.delete();
                    System.out.println("Dalvik-cache " + (Object)var10_9 + " deleted.");
                } else {
                    System.out.println("dalvik-cache not found.");
                }
                System.out.println("Start delete odex.");
                if (var3_2.exists()) {
                    var3_2.delete();
                }
                ** GOTO lbl49
            }
            catch (Exception var7_12) {
                System.out.println("Error: Exception e" + var7_12.toString());
                var7_12.printStackTrace();
lbl49: // 2 sources:
                ** try [egrp 5[TRYBLOCK] [8 : 333->433)] { 
lbl50: // 1 sources:
                System.out.println("Start delete apk!");
                var8_10 = new File(uninstall.dirapp);
                if (var8_10.exists()) {
                    var8_10.delete();
                    System.out.println("Delete apk:" + uninstall.dirapp);
                }
                ** GOTO lbl22
            }
        }
    }

}

