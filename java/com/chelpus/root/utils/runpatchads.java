/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.InputStream
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.MappedByteBuffer
 *  java.security.DigestException
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.zip.Adler32
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipInputStream
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class runpatchads {
    private static boolean ART;
    public static String AdsBlockFile;
    public static String appdir;
    public static ArrayList<File> classesFiles;
    private static boolean copyDC;
    private static boolean createAPK;
    public static File crkapk;
    private static boolean dependencies;
    public static String dir;
    public static String dir2;
    public static String dirapp;
    private static boolean fileblock;
    public static ArrayList<File> filestopatch;
    private static boolean full_offline;
    private static boolean pattern1;
    private static boolean pattern2;
    private static boolean pattern3;
    private static boolean pattern4;
    private static boolean pattern5;
    private static boolean pattern6;
    public static PrintStream print;
    public static String result;
    public static String sddir;
    public static byte[][] sites;
    public static boolean system;
    public static String uid;

    static {
        createAPK = false;
        fileblock = true;
        pattern1 = true;
        pattern2 = true;
        pattern3 = true;
        pattern4 = true;
        pattern5 = true;
        pattern6 = true;
        dependencies = true;
        full_offline = true;
        copyDC = false;
        ART = false;
        dirapp = "/data/app/";
        system = false;
        uid = "";
        dir = "/sdcard/";
        dir2 = "/sdcard/";
        filestopatch = null;
        sddir = "/sdcard/";
        appdir = "/sdcard/";
        AdsBlockFile = "";
        classesFiles = new ArrayList();
    }

    public static boolean byteverify(MappedByteBuffer mappedByteBuffer, int n, byte by, byte[] arrby, byte[] arrby2, byte[] arrby3, byte[] arrby4, String string, boolean bl) {
        if (by == arrby[0] && bl) {
            if (arrby4[0] == 0) {
                arrby3[0] = by;
            }
            int n2 = 1;
            mappedByteBuffer.position(n + 1);
            byte by2 = mappedByteBuffer.get();
            while (by2 == arrby[n2] || arrby2[n2] == 1) {
                if (arrby4[n2] == 0) {
                    arrby3[n2] = by2;
                }
                if (++n2 == arrby.length) {
                    mappedByteBuffer.position(n);
                    mappedByteBuffer.put(arrby3);
                    mappedByteBuffer.force();
                    Utils.sendFromRoot(string);
                    return true;
                }
                by2 = mappedByteBuffer.get();
            }
            mappedByteBuffer.position(n + 1);
        }
        return false;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void clearTemp() {
        try {
            File file;
            File file2;
            File file3 = new File(dir + "/AndroidManifest.xml");
            if (file3.exists()) {
                file3.delete();
            }
            if (classesFiles != null && classesFiles.size() > 0) {
                for (File file4 : classesFiles) {
                    if (!file4.exists()) continue;
                    file4.delete();
                }
            }
            if ((file2 = new File(dir + "/classes.dex")).exists()) {
                file2.delete();
            }
            if (!(file = new File(dir + "/classes.dex.apk")).exists()) return;
            {
                file.delete();
                return;
            }
        }
        catch (Exception var1_3) {
            Utils.sendFromRoot("" + var1_3.toString());
            return;
        }
    }

    public static void clearTempSD() {
        try {
            File file = new File(sddir + "/Modified/classes.dex.apk");
            if (file.exists()) {
                file.delete();
            }
            return;
        }
        catch (Exception var1_1) {
            Utils.sendFromRoot("" + var1_1.toString());
            return;
        }
    }

    public static void fixadler(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] arrby = new byte[fileInputStream.available()];
            fileInputStream.read(arrby);
            runpatchads.calcSignature(arrby, 0);
            runpatchads.calcChecksum(arrby, 0);
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
     * Exception decompiling
     */
    public static void main(String[] var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.UnsupportedOperationException
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op01WithProcessedDataAndByteJumps.getAStoreIdx(Op01WithProcessedDataAndByteJumps.java:77)
        // org.benf.cfr.reader.entities.exceptions.ExceptionGroup.isSynchronisedHandler(ExceptionGroup.java:90)
        // org.benf.cfr.reader.entities.exceptions.ExceptionGroup.removeSynchronisedHandlers(ExceptionGroup.java:67)
        // org.benf.cfr.reader.entities.exceptions.ExceptionAggregator.removeSynchronisedHandlers(ExceptionAggregator.java:376)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:317)
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
    public static void unzipART(File var0) {
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
    public static void unzipSD(File var0) {
        try {
            var1_1 = new FileInputStream(var0);
            var2_2 = new ZipInputStream((InputStream)var1_1);
            while ((var11_4 = var2_2.getNextEntry()) != null) {
                if (!var11_4.getName().toLowerCase().startsWith("classes") || !var11_4.getName().endsWith(".dex") || var11_4.getName().contains((CharSequence)"/")) continue;
                var12_3 = new FileOutputStream(runpatchads.sddir + "/Modified/" + var11_4.getName());
                var13_6 = new byte[1024];
                while ((var14_5 = var2_2.read(var13_6)) != -1) {
                    var12_3.write(var13_6, 0, var14_5);
                }
                var2_2.closeEntry();
                var12_3.close();
                runpatchads.classesFiles.add((Object)new File(runpatchads.sddir + "/Modified/" + var11_4.getName()));
            }
            ** GOTO lbl21
        }
        catch (Exception var3_7) {
            try {
                new ZipFile(var0).extractFile("classes.dex", runpatchads.sddir + "/Modified/");
                runpatchads.classesFiles.add((Object)new File(runpatchads.sddir + "/Modified/" + "classes.dex"));
                return;
            }
            catch (ZipException var7_8) {
                Utils.sendFromRoot("Error classes.dex decompress! " + (Object)var7_8);
                Utils.sendFromRoot("Exception e1" + var3_7.toString());
                return;
            }
            catch (Exception var4_9) {
                Utils.sendFromRoot("Error classes.dex decompress! " + (Object)var4_9);
                Utils.sendFromRoot("Exception e1" + var3_7.toString());
                return;
            }
lbl21: // 1 sources:
            var2_2.close();
            var1_1.close();
            return;
        }
    }

}

