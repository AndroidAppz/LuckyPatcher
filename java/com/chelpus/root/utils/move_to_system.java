/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Process
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class move_to_system {
    public static String datadir;
    public static String dirapp;
    public static String index;
    public static String libDir;
    public static String pkgName;
    public static String toolsfiles;

    static {
        dirapp = "/data/app/";
        datadir = "/data/data/";
        toolsfiles = "";
        pkgName = "";
        libDir = "";
        index = "";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ArrayList<String> getLibs(File file, String string, int n) {
        ArrayList arrayList = new ArrayList();
        if (!string.startsWith("/mnt/")) {
            if (n >= 21) {
                File file2 = Utils.getDirs(new File(string));
                if (!file2.exists()) return arrayList;
                File[] arrfile = file2.listFiles();
                int n2 = arrfile.length;
                int n3 = 0;
                while (n3 < n2) {
                    File[] arrfile2;
                    File file3 = arrfile[n3];
                    System.out.println("LuckyPatcher: file found in data dir - " + (Object)file3);
                    if (file3.isDirectory() && file3.getAbsolutePath().equals((Object)((Object)file2 + "/" + "lib")) && (arrfile2 = file3.listFiles()) != null && arrfile2.length > 0) {
                        int n4 = arrfile2.length;
                        for (int i = 0; i < n4; ++i) {
                            File[] arrfile3 = arrfile2[i].listFiles();
                            if (arrfile3 == null || arrfile3.length <= 0) continue;
                            for (File file4 : arrfile3) {
                                arrayList.add((Object)file4.getAbsolutePath());
                                index = Utils.getDirs(file4).getAbsolutePath().replace((CharSequence)file2.getAbsolutePath(), (CharSequence)"");
                                libDir = "/system/priv-app/" + pkgName + index + "/";
                                System.out.println("libdir" + libDir);
                                new File(libDir).mkdirs();
                                System.out.println("LuckyPatcher: found lib - " + file4.getAbsolutePath());
                            }
                        }
                    }
                    ++n3;
                }
                return arrayList;
            }
            if (!file.exists()) return arrayList;
            String[] arrstring = file.list();
            int n5 = arrstring.length;
            int n6 = 0;
            while (n6 < n5) {
                String string2 = arrstring[n6];
                System.out.println("LuckyPatcher: file found in data dir - " + (Object)file + "/" + string2);
                if (new File((Object)file + "/" + string2).isDirectory() && ((Object)file + "/" + string2).equals((Object)((Object)file + "/" + "lib"))) {
                    for (String string3 : new File((Object)file + "/" + string2).list()) {
                        if (!new File((Object)file + "/" + string2 + "/" + string3).isFile() || string3.contains((CharSequence)"libjnigraphics.so")) continue;
                        arrayList.add((Object)((Object)file + "/" + string2 + "/" + string3));
                        System.out.println("LuckyPatcher: found lib - " + (Object)file + "/" + string2 + "/" + string3);
                    }
                }
                ++n6;
            }
            return arrayList;
        }
        File file5 = Utils.getDirs(new File(string));
        Utils.remount(file5.getAbsolutePath(), "rw");
        if (!file5.exists()) return arrayList;
        String[] arrstring = file5.list();
        int n7 = arrstring.length;
        int n8 = 0;
        while (n8 < n7) {
            String string4 = arrstring[n8];
            System.out.println("LuckyPatcher: file found in data dir - " + (Object)file5 + "/" + string4);
            if (new File((Object)file5 + "/" + string4).isDirectory() && ((Object)file5 + "/" + string4).equals((Object)((Object)file5 + "/" + "lib"))) {
                for (String string5 : new File((Object)file5 + "/" + string4).list()) {
                    if (!new File((Object)file5 + "/" + string4 + "/" + string5).isFile() || string5.contains((CharSequence)"libjnigraphics.so")) continue;
                    arrayList.add((Object)((Object)file5 + "/" + string4 + "/" + string5));
                    System.out.println("LuckyPatcher: found lib - " + (Object)file5 + "/" + string4 + "/" + string5);
                }
            }
            ++n8;
        }
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    public static void main(String[] var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl49 : TryStatement: try { 2[TRYBLOCK]

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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void removeLibs(File file, String string, int n) {
        int n2 = 0;
        if (n < 21) {
            if (string.startsWith("/mnt/")) return;
            if (!file.exists()) return;
            String[] arrstring = file.list();
            int n3 = arrstring.length;
            int n4 = 0;
            while (n4 < n3) {
                String string2 = arrstring[n4];
                System.out.println("LuckyPatcher: file found in data dir - " + (Object)file + "/" + string2);
                if (new File((Object)file + "/" + string2).isDirectory() && ((Object)file + "/" + string2).equals((Object)((Object)file + "/" + "lib"))) {
                    String[] arrstring2 = new File((Object)file + "/" + string2).list();
                    if (arrstring2 != null && arrstring2.length > 0) {
                        for (String string3 : arrstring2) {
                            if (!new File((Object)file + "/" + string2 + "/" + string3).isFile()) continue;
                            new File((Object)file + "/" + string2 + "/" + string3).delete();
                            System.out.println("LuckyPatcher: remove lib - " + (Object)file + "/" + string2 + "/" + string3);
                        }
                    }
                    new File((Object)file + "/" + string2).delete();
                }
                ++n4;
            }
            return;
        }
        File file2 = Utils.getDirs(new File(string));
        if (!Utils.getDirs(new File(string)).exists()) return;
        File[] arrfile = file2.listFiles();
        int n5 = arrfile.length;
        while (n2 < n5) {
            File file3 = arrfile[n2];
            System.out.println("LuckyPatcher: file found in data dir - " + (Object)file2 + "/" + (Object)file3);
            if (file3.isDirectory() && file3.getAbsolutePath().endsWith("/lib")) {
                try {
                    new Utils("").deleteFolder(file3);
                }
                catch (IOException var8_15) {
                    var8_15.printStackTrace();
                }
            }
            ++n2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private static void run_all(String var0) {
        try {
            var14_1 = Runtime.getRuntime().exec(var0 + "\n");
            var14_1.waitFor();
            var14_1.destroy();
        }
        catch (Exception var1_10) {
            ** continue;
        }
lbl7: // 2 sources:
        do {
            try {
                var12_2 = Runtime.getRuntime().exec("toolbox " + var0 + "\n");
                var12_2.waitFor();
                var12_2.destroy();
            }
            catch (Exception var2_9) {
                ** continue;
            }
lbl14: // 2 sources:
            do {
                try {
                    var10_3 = Runtime.getRuntime().exec("/system/bin/failsafe/toolbox " + var0 + "\n");
                    var10_3.waitFor();
                    var10_3.destroy();
                }
                catch (Exception var3_8) {
                    ** continue;
                }
lbl21: // 2 sources:
                do {
                    try {
                        var8_4 = Runtime.getRuntime().exec("busybox " + var0 + "\n");
                        var8_4.waitFor();
                        var8_4.destroy();
                    }
                    catch (Exception var4_7) {
                        ** continue;
                    }
lbl28: // 2 sources:
                    do {
                        try {
                            var6_5 = Runtime.getRuntime().exec(move_to_system.toolsfiles + "/busybox " + var0 + "\n");
                            var6_5.waitFor();
                            var6_5.destroy();
                            return;
                        }
                        catch (Exception var5_6) {
                            return;
                        }
                        break;
                    } while (true);
                    break;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
    }

}

