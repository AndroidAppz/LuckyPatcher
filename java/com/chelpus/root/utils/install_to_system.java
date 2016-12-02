/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.PrintStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Process
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipInputStream
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class install_to_system {
    public static String CPU_ABI;
    public static String CPU_ABI2;
    public static String appfile;
    public static String datadir;
    public static String pkgName;
    public static String toolsfiles;

    static {
        appfile = "/sdcard/app.apk";
        datadir = "/data/data/";
        toolsfiles = "";
        pkgName = "";
        CPU_ABI = "";
        CPU_ABI2 = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static ArrayList<File> getLibs(File file) {
        File file2;
        ArrayList arrayList = new ArrayList();
        String string = toolsfiles + "/tmp/";
        File file3 = new File(toolsfiles + "/tmp/lib/");
        if (file3.exists()) {
            Utils utils = new Utils("");
            try {
                utils.deleteFolder(file3);
            }
            catch (IOException var5_5) {
                var5_5.printStackTrace();
            }
        }
        if (!file3.exists()) {
            new Decompress(file.getAbsolutePath(), string).unzip();
        }
        if (!(file2 = new File(toolsfiles + "/tmp/lib")).exists()) return arrayList;
        File[] arrfile = file2.listFiles();
        int n = arrfile.length;
        for (int i = 0; i < n; ++i) {
            File file4 = arrfile[i];
            System.out.println("LuckyPatcher: directory in lib found - " + (Object)file4);
            if (!file4.isDirectory() || !file4.getName().equals((Object)CPU_ABI)) continue;
            System.out.println("LuckyPatcher: - " + (Object)file4 + " " + file4.getName() + " " + CPU_ABI);
            for (File file5 : file4.listFiles()) {
                if (!file5.isFile() || !file5.toString().endsWith(".so")) continue;
                System.out.println((Object)file5);
                arrayList.add((Object)file5);
                System.out.println("LuckyPatcher: found lib file - " + CPU_ABI + " " + (Object)file5);
            }
        }
        System.out.println(arrayList.size());
        if (arrayList.size() != 0) return arrayList;
        int n2 = arrfile.length;
        int n3 = 0;
        while (n3 < n2) {
            File file6 = arrfile[n3];
            if (file6.isDirectory() && file6.getName().equals((Object)CPU_ABI2)) {
                for (File file7 : file6.listFiles()) {
                    if (!file7.isFile() || !file7.getName().endsWith(".so")) continue;
                    arrayList.add((Object)file7);
                    System.out.println("LuckyPatcher: found lib file - " + CPU_ABI2 + " " + (Object)file7);
                }
            }
            ++n3;
        }
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    public static void main(String[] var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl86 : TryStatement: try { 7[TRYBLOCK]

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
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private static void run_all(String var0) {
        try {
            var0 = var1_1 = new String(var0.getBytes(), "ISO-8859-1");
        }
        catch (UnsupportedEncodingException var17_7) {
            var17_7.printStackTrace();
            ** continue;
        }
lbl3: // 2 sources:
        do {
            var15_2 = Runtime.getRuntime().exec(var0 + "\n");
            var15_2.waitFor();
            var15_2.destroy();
lbl9: // 3 sources:
            var13_3 = Runtime.getRuntime().exec("toolbox " + var0 + "\n");
            var13_3.waitFor();
            var13_3.destroy();
lbl13: // 2 sources:
            var11_4 = Runtime.getRuntime().exec("/system/bin/failsafe/toolbox " + var0 + "\n");
            var11_4.waitFor();
            var11_4.destroy();
lbl17: // 2 sources:
            var9_5 = Runtime.getRuntime().exec("busybox " + var0 + "\n");
            var9_5.waitFor();
            var9_5.destroy();
lbl21: // 2 sources:
            var7_6 = Runtime.getRuntime().exec(install_to_system.toolsfiles + "/busybox " + var0 + "\n");
            var7_6.waitFor();
            var7_6.destroy();
            return;
            break;
        } while (true);
        catch (Exception var6_8) {
            return;
        }
        catch (Exception var5_9) {}
        ** GOTO lbl21
        catch (Exception var4_10) {}
        ** GOTO lbl17
        catch (Exception var3_11) {}
        ** GOTO lbl13
        catch (Exception var2_12) {
            ** GOTO lbl9
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
            if (!file.isDirectory()) {
                file.mkdirs();
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public void unzip() {
            try {
                var1_1 = new FileInputStream(this._zipFile);
                var2_2 = new ZipInputStream((InputStream)var1_1);
lbl4: // 4 sources:
                if ((var9_5 = var2_2.getNextEntry()) == null) ** GOTO lbl29
                if (!var9_5.isDirectory()) ** GOTO lbl8
                this._dirChecker(var9_5.getName());
                ** GOTO lbl4
lbl8: // 1 sources:
                if (!var9_5.getName().endsWith(".so") || var9_5.getName().contains((CharSequence)"libjnigraphics.so")) ** GOTO lbl4
                var10_8 = var9_5.getName().split("\\/+");
                var11_3 = "";
                var12_6 = 0;
            }
            catch (Exception var3_10) {
                System.out.println("Decompressunzip " + (Object)var3_10);
                var3_10.printStackTrace();
                try {
                    var4_11 = new ZipFile(this._zipFile);
                    var7_12 = var4_11.getFileHeaders().iterator();
                    while (var7_12.hasNext() != false) {
                        var8_13 = (FileHeader)var7_12.next();
                        if (!var8_13.getFileName().endsWith(".so") || var8_13.getFileName().contains((CharSequence)"libjnigraphics.so")) continue;
                        System.out.println(var8_13.getFileName());
                        var4_11.extractFile(var8_13.getFileName(), this._location);
                    }
                    return;
                }
                catch (ZipException var6_14) {
                    var6_14.printStackTrace();
                }
                return;
lbl29: // 1 sources:
                var2_2.close();
                var1_1.close();
                return;
                catch (Exception var5_15) {
                    var5_15.printStackTrace();
                    return;
                }
            }
            do {
                if (var12_6 >= -1 + var10_8.length) ** GOTO lbl40
                if (!var10_8[var12_6].equals((Object)"")) {
                    var11_3 = var11_3 + "/" + var10_8[var12_6];
                }
                ** GOTO lbl49
lbl40: // 1 sources:
                this._dirChecker(var11_3);
                var13_4 = new FileOutputStream(this._location + var9_5.getName());
                var14_7 = new byte[1024];
                while ((var15_9 = var2_2.read(var14_7)) != -1) {
                    var13_4.write(var14_7, 0, var15_9);
                }
                var2_2.closeEntry();
                var13_4.close();
                ** GOTO lbl4
lbl49: // 1 sources:
                ++var12_6;
            } while (true);
        }
    }

}

