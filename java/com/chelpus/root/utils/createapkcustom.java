package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;
import com.android.vending.billing.InAppBillingService.LOCK.LogOutputStream;
import com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;
import com.android.vending.billing.InAppBillingService.LOCK.SearchItem;
import com.chelpus.HttpRequest;
import com.chelpus.Utils;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.tukaani.xz.common.Util;

public class createapkcustom {
    static final int BUFFER = 2048;
    private static final int all = 4;
    public static String appdir = "/sdcard/";
    private static final int arm64v8a = 5;
    private static final int armeabi = 0;
    private static final int armeabiv7a = 1;
    private static final int beginTag = 0;
    public static ArrayList<File> classesFiles = new ArrayList();
    private static final int classesTag = 1;
    public static File crkapk = null;
    public static String dir = "/sdcard/";
    public static String dir2 = "/sdcard/";
    private static final int endTag = 4;
    private static final int fileInApkTag = 10;
    public static boolean goodResult = false;
    private static String group = "";
    private static final int libTagALL = 2;
    private static final int libTagARM64V8A = 11;
    private static final int libTagARMEABI = 6;
    private static final int libTagARMEABIV7A = 7;
    private static final int libTagMIPS = 8;
    private static final int libTagx86 = 9;
    private static ArrayList<String> libs = new ArrayList();
    public static File localFile2 = null;
    public static boolean manualpatch = false;
    private static final int mips = 2;
    public static boolean multi_patch = false;
    public static boolean multidex = false;
    public static boolean multilib_patch = false;
    private static final int nextPatchTag = 12;
    public static String packageName = "";
    private static final int packageTag = 5;
    private static ArrayList<PatchesItem> pat = null;
    public static ArrayList<String> patchedLibs = new ArrayList();
    public static boolean patchteil = false;
    private static PrintStream print = null;
    public static String sddir = "/sdcard/";
    private static ArrayList<Byte> search = null;
    private static String searchStr = "";
    private static ArrayList<SearchItem> ser = null;
    public static int tag = 200;
    public static String tooldir = "/sdcard/";
    public static boolean unpack = false;
    private static final int x86 = 3;

    public static class Decompress {
        private String _location;
        private String _zipFile;

        public Decompress(String zipFile, String location) {
            this._zipFile = zipFile;
            this._location = location;
            _dirChecker("");
        }

        public void unzip() {
            int i;
            try {
                FileInputStream fin = new FileInputStream(this._zipFile);
                ZipInputStream zin = new ZipInputStream(fin);
                while (true) {
                    ZipEntry ze = zin.getNextEntry();
                    if (ze == null) {
                        zin.close();
                        fin.close();
                        return;
                    } else if (ze.isDirectory()) {
                        _dirChecker(ze.getName());
                    } else if (ze.getName().endsWith(".so")) {
                        String[] tail = ze.getName().split("\\/+");
                        String data_dir = "";
                        for (i = createapkcustom.beginTag; i < tail.length - 1; i += createapkcustom.classesTag) {
                            if (!tail[i].equals("")) {
                                data_dir = new StringBuilder(String.valueOf(data_dir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(tail[i]).toString();
                            }
                        }
                        _dirChecker(data_dir);
                        FileOutputStream fout = new FileOutputStream(this._location + ze.getName());
                        byte[] buffer = new byte[Util.BLOCK_HEADER_SIZE_MAX];
                        while (true) {
                            int length = zin.read(buffer);
                            if (length == -1) {
                                break;
                            }
                            fout.write(buffer, createapkcustom.beginTag, length);
                        }
                        zin.closeEntry();
                        fout.close();
                    }
                }
            } catch (Exception e) {
                createapkcustom.print.println("Decompressunzip " + e);
                try {
                    ZipFile zipFile = new ZipFile(this._zipFile);
                    List fileHeaderList = zipFile.getFileHeaders();
                    for (i = createapkcustom.beginTag; i < fileHeaderList.size(); i += createapkcustom.classesTag) {
                        FileHeader fileHeader = (FileHeader) fileHeaderList.get(i);
                        if (fileHeader.getFileName().endsWith(".so")) {
                            createapkcustom.print.println(fileHeader.getFileName());
                            zipFile.extractFile(fileHeader.getFileName(), this._location);
                        }
                    }
                } catch (ZipException e1) {
                    e1.printStackTrace();
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String unzip(java.lang.String r21) {
            /*
            r20 = this;
            r9 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0034 }
            r0 = r20;
            r0 = r0._zipFile;	 Catch:{ Exception -> 0x0034 }
            r17 = r0;
            r0 = r17;
            r9.<init>(r0);	 Catch:{ Exception -> 0x0034 }
            r15 = new java.util.zip.ZipInputStream;	 Catch:{ Exception -> 0x0034 }
            r15.<init>(r9);	 Catch:{ Exception -> 0x0034 }
            r14 = 0;
        L_0x0013:
            r14 = r15.getNextEntry();	 Catch:{ Exception -> 0x0034 }
            if (r14 != 0) goto L_0x0022;
        L_0x0019:
            r15.close();	 Catch:{ Exception -> 0x0034 }
            r9.close();	 Catch:{ Exception -> 0x0034 }
        L_0x001f:
            r17 = "";
        L_0x0021:
            return r17;
        L_0x0022:
            r17 = r14.isDirectory();	 Catch:{ Exception -> 0x0034 }
            if (r17 == 0) goto L_0x00ae;
        L_0x0028:
            r17 = r14.getName();	 Catch:{ Exception -> 0x0034 }
            r0 = r20;
            r1 = r17;
            r0._dirChecker(r1);	 Catch:{ Exception -> 0x0034 }
            goto L_0x0013;
        L_0x0034:
            r5 = move-exception;
            r17 = com.chelpus.root.utils.createapkcustom.print;
            r18 = new java.lang.StringBuilder;
            r19 = "Decompressunzip ";
            r18.<init>(r19);
            r0 = r18;
            r18 = r0.append(r5);
            r18 = r18.toString();
            r17.println(r18);
            r16 = new net.lingala.zip4j.core.ZipFile;	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r0 = r20;
            r0 = r0._zipFile;	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r17 = r0;
            r16.<init>(r17);	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r8 = r16.getFileHeaders();	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r11 = 0;
        L_0x005d:
            r17 = r8.size();	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r0 = r17;
            if (r11 >= r0) goto L_0x001f;
        L_0x0065:
            r7 = r8.get(r11);	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r7 = (net.lingala.zip4j.model.FileHeader) r7;	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r17 = r7.getFileName();	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r0 = r17;
            r1 = r21;
            r17 = r0.equals(r1);	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            if (r17 == 0) goto L_0x017b;
        L_0x0079:
            r17 = com.chelpus.root.utils.createapkcustom.print;	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r18 = r7.getFileName();	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r17.println(r18);	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r17 = r7.getFileName();	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r0 = r20;
            r0 = r0._location;	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r18 = r0;
            r16.extractFile(r17, r18);	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r17 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r0 = r20;
            r0 = r0._location;	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r18 = r0;
            r18 = java.lang.String.valueOf(r18);	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r17.<init>(r18);	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r18 = r7.getFileName();	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r17 = r17.append(r18);	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            r17 = r17.toString();	 Catch:{ ZipException -> 0x017f, Exception -> 0x0185 }
            goto L_0x0021;
        L_0x00ae:
            r17 = "/";
            r0 = r21;
            r1 = r17;
            r17 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0034 }
            if (r17 == 0) goto L_0x00c8;
        L_0x00ba:
            r17 = "/";
            r18 = "";
            r0 = r21;
            r1 = r17;
            r2 = r18;
            r21 = r0.replaceFirst(r1, r2);	 Catch:{ Exception -> 0x0034 }
        L_0x00c8:
            r17 = r14.getName();	 Catch:{ Exception -> 0x0034 }
            r0 = r17;
            r1 = r21;
            r17 = r0.equals(r1);	 Catch:{ Exception -> 0x0034 }
            if (r17 == 0) goto L_0x0013;
        L_0x00d6:
            r17 = r14.getName();	 Catch:{ Exception -> 0x0034 }
            r18 = "\\/+";
            r13 = r17.split(r18);	 Catch:{ Exception -> 0x0034 }
            r4 = "";
            r11 = 0;
        L_0x00e3:
            r0 = r13.length;	 Catch:{ Exception -> 0x0034 }
            r17 = r0;
            r17 = r17 + -1;
            r0 = r17;
            if (r11 < r0) goto L_0x014c;
        L_0x00ec:
            r0 = r20;
            r0._dirChecker(r4);	 Catch:{ Exception -> 0x0034 }
            r10 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0034 }
            r17 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0034 }
            r0 = r20;
            r0 = r0._location;	 Catch:{ Exception -> 0x0034 }
            r18 = r0;
            r18 = java.lang.String.valueOf(r18);	 Catch:{ Exception -> 0x0034 }
            r17.<init>(r18);	 Catch:{ Exception -> 0x0034 }
            r18 = r14.getName();	 Catch:{ Exception -> 0x0034 }
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x0034 }
            r17 = r17.toString();	 Catch:{ Exception -> 0x0034 }
            r0 = r17;
            r10.<init>(r0);	 Catch:{ Exception -> 0x0034 }
            r17 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r0 = r17;
            r3 = new byte[r0];	 Catch:{ Exception -> 0x0034 }
        L_0x0119:
            r12 = r15.read(r3);	 Catch:{ Exception -> 0x0034 }
            r17 = -1;
            r0 = r17;
            if (r12 != r0) goto L_0x0173;
        L_0x0123:
            r15.closeEntry();	 Catch:{ Exception -> 0x0034 }
            r10.close();	 Catch:{ Exception -> 0x0034 }
            r15.close();	 Catch:{ Exception -> 0x0034 }
            r9.close();	 Catch:{ Exception -> 0x0034 }
            r17 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0034 }
            r0 = r20;
            r0 = r0._location;	 Catch:{ Exception -> 0x0034 }
            r18 = r0;
            r18 = java.lang.String.valueOf(r18);	 Catch:{ Exception -> 0x0034 }
            r17.<init>(r18);	 Catch:{ Exception -> 0x0034 }
            r18 = r14.getName();	 Catch:{ Exception -> 0x0034 }
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x0034 }
            r17 = r17.toString();	 Catch:{ Exception -> 0x0034 }
            goto L_0x0021;
        L_0x014c:
            r17 = r13[r11];	 Catch:{ Exception -> 0x0034 }
            r18 = "";
            r17 = r17.equals(r18);	 Catch:{ Exception -> 0x0034 }
            if (r17 != 0) goto L_0x016f;
        L_0x0156:
            r17 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0034 }
            r18 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0034 }
            r17.<init>(r18);	 Catch:{ Exception -> 0x0034 }
            r18 = "/";
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x0034 }
            r18 = r13[r11];	 Catch:{ Exception -> 0x0034 }
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x0034 }
            r4 = r17.toString();	 Catch:{ Exception -> 0x0034 }
        L_0x016f:
            r11 = r11 + 1;
            goto L_0x00e3;
        L_0x0173:
            r17 = 0;
            r0 = r17;
            r10.write(r3, r0, r12);	 Catch:{ Exception -> 0x0034 }
            goto L_0x0119;
        L_0x017b:
            r11 = r11 + 1;
            goto L_0x005d;
        L_0x017f:
            r6 = move-exception;
            r6.printStackTrace();
            goto L_0x001f;
        L_0x0185:
            r6 = move-exception;
            r6.printStackTrace();
            goto L_0x001f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.createapkcustom.Decompress.unzip(java.lang.String):java.lang.String");
        }

        private void _dirChecker(String dir) {
            File f = new File(this._location + dir);
            if (f.isFile()) {
                f.delete();
            }
            if (!f.exists()) {
                f.mkdirs();
            }
        }
    }

    public static String main(String[] paramArrayOfString) {
        LogOutputStream logOutputStream = new LogOutputStream("System.out");
        print = new PrintStream(logOutputStream);
        classesFiles.clear();
        libs.clear();
        patchedLibs.clear();
        print.println("SU Java-Code Running!");
        patchedLibs.clear();
        packageName = paramArrayOfString[beginTag];
        appdir = paramArrayOfString[mips];
        sddir = paramArrayOfString[x86];
        tooldir = paramArrayOfString[endTag];
        clearTemp();
        try {
            new Utils("createcustompatch").deleteFolder(new File(sddir + "/tmp/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        manualpatch = false;
        String finalText = "";
        String beginText = "";
        boolean error = false;
        boolean end = false;
        getClassesDex();
        String line = "";
        try {
            InputStream fileInputStream = new FileInputStream(paramArrayOfString[classesTag]);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(fileInputStream, HttpRequest.CHARSET_UTF8));
            while (true) {
                line = br1.readLine();
                if (line == null) {
                    break;
                }
                if (line.toUpperCase().contains("[LIB-ARMEABI-V7A]") || line.toUpperCase().contains("[LIB-ARMEABI]") || line.toUpperCase().contains("[LIB-ARM64-V8A]") || line.toUpperCase().contains("[LIB-MIPS]") || line.toUpperCase().contains("[LIB-X86]") || line.toUpperCase().contains("[LIB]")) {
                    File apk = new File(appdir);
                    crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
                    if (!crkapk.exists()) {
                        Utils.copyFile(apk, crkapk);
                    }
                    extractLibs(crkapk);
                }
                if (line.toUpperCase().contains("[NEXT_PATCH]")) {
                    multi_patch = true;
                }
            }
            br1.close();
            fileInputStream.close();
        } catch (IOException e2) {
        }
        try {
            fileInputStream = new FileInputStream(paramArrayOfString[classesTag]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, HttpRequest.CHARSET_UTF8));
            String data = "";
            String[] txtdata = new String[1000];
            new String[classesTag][beginTag] = "";
            byte[] byteOrig = null;
            int[] mask = null;
            boolean result = true;
            boolean sumresult = true;
            boolean libr = false;
            boolean mark_search = false;
            boolean fileInApk = false;
            String value1 = "";
            String value2 = "";
            String value3 = "";
            pat = new ArrayList();
            ser = new ArrayList();
            search = new ArrayList();
            int r = beginTag;
            while (true) {
                data = br.readLine();
                if (data == null) {
                    if (sumresult) {
                        print.println(finalText);
                    }
                    if (!sumresult) {
                        if (patchteil) {
                            print.println("Not all patterns are replaced, but the program can work, test it!\nCustom Patch not valid for this Version of the Programm or already patched. ");
                        } else {
                            print.println("Custom Patch not valid for this Version of the Programm or already patched. ");
                        }
                    }
                    clearTemp();
                    fileInputStream.close();
                    clearTemp();
                    result = logOutputStream.allresult;
                    System.out.println(result);
                    try {
                        logOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return result;
                }
                Iterator it;
                String[] orhex;
                int t;
                String[] rephex;
                int[] rep_mask;
                byte[] byteReplace;
                if (!data.equals("")) {
                    data = Utils.apply_TAGS(data, packageName);
                }
                txtdata[r] = data;
                if (txtdata[r].contains("[") && txtdata[r].contains("]")) {
                    end = false;
                    String lib;
                    switch (tag) {
                        case beginTag /*0*/:
                            print.println(beginText + "\n");
                            tag = 200;
                            break;
                        case classesTag /*1*/:
                            System.out.println("classesTag work");
                            if (classesFiles != null && classesFiles.size() == 0) {
                                getClassesDex();
                            }
                            if (classesFiles != null && classesFiles.size() > 0) {
                                if (classesFiles.size() > classesTag) {
                                    multidex = true;
                                }
                                it = classesFiles.iterator();
                                while (it.hasNext()) {
                                    File cl = (File) it.next();
                                    localFile2 = cl;
                                    if (pat.size() > 0) {
                                        print.println("---------------------------------");
                                        print.println("Patch for " + cl.getName() + ":");
                                        print.println("---------------------------------\n");
                                        if (!searchStr.equals("")) {
                                            print.println(searchStr);
                                        }
                                        if (!manualpatch) {
                                            result = patchProcess(pat);
                                        }
                                        if (!result) {
                                            sumresult = false;
                                        }
                                    }
                                }
                                multidex = false;
                                goodResult = false;
                                ser.clear();
                                pat.clear();
                                tag = 200;
                                searchStr = "";
                                break;
                            }
                        case mips /*2*/:
                            it = libs.iterator();
                            while (it.hasNext()) {
                                lib = (String) it.next();
                                localFile2 = new File(lib);
                                print.println("---------------------------");
                                print.println("Patch for libraries \n" + localFile2.getPath().replace(sddir + "/tmp", "") + ":");
                                print.println("---------------------------\n");
                                if (!searchStr.equals("")) {
                                    print.println(searchStr);
                                }
                                if (!manualpatch) {
                                    result = patchProcess(pat);
                                }
                                if (!result) {
                                    sumresult = false;
                                }
                                if (!patchedLibs.contains(lib)) {
                                    patchedLibs.add(lib);
                                }
                            }
                            multilib_patch = false;
                            goodResult = false;
                            ser.clear();
                            pat.clear();
                            tag = 200;
                            searchStr = "";
                            break;
                        case endTag /*4*/:
                            print.println(finalText + "\n");
                            finalText = "";
                            end = false;
                            tag = 200;
                            break;
                        case libTagARMEABI /*6*/:
                            it = libs.iterator();
                            while (it.hasNext()) {
                                lib = (String) it.next();
                                localFile2 = new File(lib);
                                print.println("--------------------------------");
                                print.println("Patch for (armeabi) libraries \n" + localFile2.getPath().replace(sddir + "/tmp", "") + ":");
                                print.println("--------------------------------\n");
                                if (!searchStr.equals("")) {
                                    print.println(searchStr);
                                }
                                if (!manualpatch) {
                                    result = patchProcess(pat);
                                }
                                if (!result) {
                                    sumresult = false;
                                }
                                if (!patchedLibs.contains(lib)) {
                                    patchedLibs.add(lib);
                                }
                            }
                            multilib_patch = false;
                            goodResult = false;
                            ser.clear();
                            pat.clear();
                            tag = 200;
                            searchStr = "";
                            break;
                        case libTagARMEABIV7A /*7*/:
                            it = libs.iterator();
                            while (it.hasNext()) {
                                lib = (String) it.next();
                                localFile2 = new File(lib);
                                print.println("---------------------------------------");
                                print.println("Patch for (armeabi-v7a) libraries \n" + localFile2.getPath().replace(sddir + "/tmp", "") + ":");
                                print.println("---------------------------------------\n");
                                if (!searchStr.equals("")) {
                                    print.println(searchStr);
                                }
                                if (!manualpatch) {
                                    result = patchProcess(pat);
                                }
                                if (!result) {
                                    sumresult = false;
                                }
                                if (!patchedLibs.contains(lib)) {
                                    patchedLibs.add(lib);
                                }
                            }
                            multilib_patch = false;
                            goodResult = false;
                            ser.clear();
                            pat.clear();
                            tag = 200;
                            searchStr = "";
                            break;
                        case libTagMIPS /*8*/:
                            it = libs.iterator();
                            while (it.hasNext()) {
                                lib = (String) it.next();
                                localFile2 = new File(lib);
                                print.println("---------------------------");
                                print.println("Patch for (MIPS) libraries \n" + localFile2.getPath().replace(sddir + "/tmp", "") + ":");
                                print.println("---------------------------\n");
                                if (!searchStr.equals("")) {
                                    print.println(searchStr);
                                }
                                if (!manualpatch) {
                                    result = patchProcess(pat);
                                }
                                if (!result) {
                                    sumresult = false;
                                }
                                if (!patchedLibs.contains(lib)) {
                                    patchedLibs.add(lib);
                                }
                            }
                            multilib_patch = false;
                            goodResult = false;
                            ser.clear();
                            pat.clear();
                            tag = 200;
                            searchStr = "";
                            break;
                        case libTagx86 /*9*/:
                            it = libs.iterator();
                            while (it.hasNext()) {
                                lib = (String) it.next();
                                localFile2 = new File(lib);
                                print.println("---------------------------");
                                print.println("Patch for (x86) libraries \n" + localFile2.getPath().replace(sddir + "/tmp", "") + ":");
                                print.println("---------------------------\n");
                                if (!searchStr.equals("")) {
                                    print.println(searchStr);
                                }
                                if (!manualpatch) {
                                    result = patchProcess(pat);
                                }
                                if (!result) {
                                    sumresult = false;
                                }
                                if (!patchedLibs.contains(lib)) {
                                    patchedLibs.add(lib);
                                }
                            }
                            multilib_patch = false;
                            goodResult = false;
                            ser.clear();
                            pat.clear();
                            tag = 200;
                            searchStr = "";
                            break;
                        case fileInApkTag /*10*/:
                            print.println("---------------------------");
                            print.println("Patch for file from apk\n" + localFile2.getPath().replace(sddir + "/tmp", "") + ":");
                            print.println("---------------------------\n");
                            if (!searchStr.equals("")) {
                                print.println(searchStr);
                            }
                            if (!manualpatch) {
                                result = patchProcess(pat);
                            }
                            if (!result) {
                                sumresult = false;
                            }
                            if (!patchedLibs.contains(localFile2.getAbsolutePath())) {
                                patchedLibs.add(localFile2.getAbsolutePath());
                            }
                            ser.clear();
                            pat.clear();
                            tag = 200;
                            searchStr = "";
                            break;
                        case libTagARM64V8A /*11*/:
                            it = libs.iterator();
                            while (it.hasNext()) {
                                lib = (String) it.next();
                                localFile2 = new File(lib);
                                print.println("---------------------------------------");
                                print.println("Patch for (arm64-v8a) libraries \n" + localFile2.getPath().replace(sddir + "/tmp", "") + ":");
                                print.println("---------------------------------------\n");
                                if (!searchStr.equals("")) {
                                    print.println(searchStr);
                                }
                                if (!manualpatch) {
                                    result = patchProcess(pat);
                                }
                                if (!result) {
                                    sumresult = false;
                                }
                                if (!patchedLibs.contains(lib)) {
                                    patchedLibs.add(lib);
                                }
                            }
                            multilib_patch = false;
                            goodResult = false;
                            ser.clear();
                            pat.clear();
                            tag = 200;
                            searchStr = "";
                            break;
                        case nextPatchTag /*12*/:
                            print.println("\n****************************************");
                            print.println("Run next custom patch:");
                            print.println("****************************************\n");
                            tag = 200;
                            break;
                    }
                }
                if (tag == 0) {
                    beginText = new StringBuilder(String.valueOf(beginText)).append("\n").append(txtdata[r]).toString();
                }
                if (txtdata[r].contains("[BEGIN]")) {
                    tag = beginTag;
                    beginText = "";
                }
                if (txtdata[r].contains("[CLASSES]") || txtdata[r].contains("[ODEX]")) {
                    tag = classesTag;
                    if (classesFiles != null && classesFiles.size() == 0) {
                        getClassesDex();
                    }
                }
                if (txtdata[r].contains("[PACKAGE]")) {
                    tag = packageTag;
                    if (classesFiles != null && classesFiles.size() == 0) {
                        getClassesDex();
                    }
                    System.out.println("classes files = " + classesFiles.size());
                }
                if (libr) {
                    ser.clear();
                    pat.clear();
                    try {
                        value1 = new JSONObject(txtdata[r]).getString("name");
                    } catch (JSONException e4) {
                        print.println("Error LP: Error name of libraries read!");
                    }
                    switch (tag) {
                        case mips /*2*/:
                            libs.clear();
                            libs = searchlib(endTag, value1);
                            break;
                        case libTagARMEABI /*6*/:
                            libs.clear();
                            libs = searchlib(beginTag, value1);
                            break;
                        case libTagARMEABIV7A /*7*/:
                            libs.clear();
                            libs = searchlib(classesTag, value1);
                            break;
                        case libTagMIPS /*8*/:
                            libs.clear();
                            libs = searchlib(mips, value1);
                            break;
                        case libTagx86 /*9*/:
                            libs.clear();
                            libs = searchlib(x86, value1);
                            break;
                        case libTagARM64V8A /*11*/:
                            libs.clear();
                            libs = searchlib(packageTag, value1);
                            break;
                    }
                    libr = false;
                }
                if (fileInApk) {
                    ser.clear();
                    pat.clear();
                    try {
                        value1 = new JSONObject(txtdata[r]).getString("name");
                    } catch (JSONException e5) {
                        print.println("Error LP: Error name of file from apk read!");
                    }
                    String file = getFileFromApk(value1);
                    if (new File(file).exists()) {
                        localFile2 = new File(file);
                    } else {
                        print.println("file for patch not found in apk.");
                    }
                    fileInApk = false;
                }
                if (txtdata[r].toUpperCase().contains("[NEXT_PATCH]")) {
                    tag = nextPatchTag;
                    libr = false;
                    unpack = false;
                    fileInApk = false;
                    end = false;
                }
                if (txtdata[r].contains("[LIB-ARMEABI]")) {
                    tag = libTagARMEABI;
                    unpack = false;
                    fileInApk = false;
                    libr = true;
                }
                if (txtdata[r].contains("[LIB-ARMEABI-V7A]")) {
                    tag = libTagARMEABIV7A;
                    unpack = false;
                    fileInApk = false;
                    libr = true;
                }
                if (txtdata[r].contains("[LIB-ARM64-V8A]")) {
                    tag = libTagARM64V8A;
                    unpack = false;
                    fileInApk = false;
                    libr = true;
                }
                if (txtdata[r].contains("[LIB-MIPS]")) {
                    tag = libTagMIPS;
                    unpack = false;
                    fileInApk = false;
                    libr = true;
                }
                if (txtdata[r].contains("[LIB-X86]")) {
                    tag = libTagx86;
                    unpack = false;
                    fileInApk = false;
                    libr = true;
                }
                if (txtdata[r].contains("[LIB]")) {
                    tag = mips;
                    unpack = false;
                    fileInApk = false;
                    libr = true;
                }
                if (txtdata[r].contains("[FILE_IN_APK]")) {
                    tag = fileInApkTag;
                    unpack = false;
                    libr = false;
                    fileInApk = true;
                }
                if (txtdata[r].contains("group") && txtdata[r].contains("{") && txtdata[r].contains("}")) {
                    try {
                        group = new JSONObject(txtdata[r]).getString("group");
                    } catch (JSONException e6) {
                        print.println("Error LP: Error original hex read!");
                        group = "";
                    }
                }
                if (txtdata[r].contains("original") && txtdata[r].contains("{") && txtdata[r].contains("}")) {
                    if (mark_search) {
                        System.out.println("tag = " + tag);
                        if (tag == classesTag) {
                            it = classesFiles.iterator();
                            do {
                                if (it.hasNext()) {
                                    localFile2 = (File) it.next();
                                }
                            } while (!searchProcess(ser));
                            sumresult = true;
                            mark_search = false;
                        } else {
                            sumresult = searchProcess(ser);
                            mark_search = false;
                        }
                    }
                    try {
                        value1 = new JSONObject(txtdata[r]).getString("original");
                    } catch (JSONException e7) {
                        print.println("Error LP: Error original hex read!");
                    }
                    value1 = value1.trim();
                    orhex = new String[value1.split("[ \t]+").length];
                    orhex = value1.split("[ \t]+");
                    mask = new int[orhex.length];
                    byteOrig = new byte[orhex.length];
                    t = beginTag;
                    while (t < orhex.length) {
                        try {
                            if (orhex[t].contains("*") && !orhex[t].contains("**")) {
                                error = true;
                                orhex[t] = "60";
                            }
                            if (orhex[t].contains("**") || orhex[t].matches("\\?+")) {
                                orhex[t] = "60";
                                mask[t] = classesTag;
                            } else {
                                mask[t] = beginTag;
                            }
                            if (orhex[t].contains("W") || orhex[t].contains("w") || orhex[t].contains("R") || orhex[t].contains(InternalZipConstants.READ_MODE)) {
                                mask[t] = Integer.valueOf(orhex[t].toLowerCase().replace("w", "").replace(InternalZipConstants.READ_MODE, "")).intValue() + mips;
                                orhex[t] = "60";
                            }
                            byteOrig[t] = Integer.valueOf(orhex[t], 16).byteValue();
                            t += classesTag;
                        } catch (Exception e8) {
                            print.println(" " + e8);
                        }
                    }
                }
                if (txtdata[r].contains("\"object\"") && txtdata[r].contains("{") && txtdata[r].contains("}")) {
                    try {
                        value3 = new JSONObject(txtdata[r]).getString("object");
                    } catch (JSONException e9) {
                        print.println("Error LP: Error number by object!");
                    }
                    Process localProcess9 = Runtime.getRuntime().exec("dalvikvm -Xverify:none -Xdexopt:none -cp " + paramArrayOfString[packageTag] + " " + paramArrayOfString[libTagARMEABI] + ".createnerorunpatch " + paramArrayOfString[beginTag] + " " + "object" + value3 + " " + sddir + " " + tooldir + "\n");
                    localProcess9.waitFor();
                    DataInputStream dataInputStream = new DataInputStream(localProcess9.getInputStream());
                    byte[] arrayOfByte = new byte[dataInputStream.available()];
                    dataInputStream.read(arrayOfByte);
                    String str = new String(arrayOfByte);
                    localProcess9.destroy();
                    if (str.contains("Done")) {
                        print.println("Object patched!\n\n");
                        sumresult = true;
                    } else {
                        print.println("Object not found!\n\n");
                        sumresult = false;
                    }
                    fixadler(localFile2);
                    manualpatch = true;
                }
                if (txtdata[r].contains("search") && txtdata[r].contains("{") && txtdata[r].contains("}")) {
                    try {
                        value3 = new JSONObject(txtdata[r]).getString("search");
                    } catch (JSONException e10) {
                        print.println("Error LP: Error search hex read!");
                    }
                    value3 = value3.trim();
                    orhex = new String[value3.split("[ \t]+").length];
                    orhex = value3.split("[ \t]+");
                    mask = new int[orhex.length];
                    byteOrig = new byte[orhex.length];
                    t = beginTag;
                    while (t < orhex.length) {
                        try {
                            if (orhex[t].contains("*") && !orhex[t].contains("**")) {
                                error = true;
                                orhex[t] = "60";
                            }
                            if (orhex[t].contains("**") || orhex[t].matches("\\?+")) {
                                orhex[t] = "60";
                                mask[t] = classesTag;
                            } else {
                                mask[t] = beginTag;
                            }
                            if (orhex[t].toUpperCase().contains("R")) {
                                mask[t] = Integer.valueOf(orhex[t].replace("R", "")).intValue() + mips;
                                orhex[t] = "60";
                            }
                            byteOrig[t] = Integer.valueOf(orhex[t], 16).byteValue();
                            t += classesTag;
                        } catch (Exception e82) {
                            print.println("search pattern read: " + e82);
                        }
                    }
                    if (error) {
                        result = false;
                        print.println("Error LP: Patterns to search not valid!\n");
                    } else {
                        mark_search = true;
                        try {
                            SearchItem searchItem = new SearchItem(byteOrig, mask);
                            searchItem.repByte = new byte[byteOrig.length];
                            ser.add(searchItem);
                        } catch (Exception e822) {
                            print.println(" " + e822);
                        }
                    }
                }
                if (txtdata[r].contains("replaced") && txtdata[r].contains("{") && txtdata[r].contains("}")) {
                    try {
                        value2 = new JSONObject(txtdata[r]).getString("replaced");
                    } catch (JSONException e11) {
                        print.println("Error LP: Error replaced hex read!");
                    }
                    value2 = value2.trim();
                    rephex = new String[value2.split("[ \t]+").length];
                    rephex = value2.split("[ \t]+");
                    rep_mask = new int[rephex.length];
                    byteReplace = new byte[rephex.length];
                    t = beginTag;
                    while (t < rephex.length) {
                        try {
                            if (rephex[t].contains("*") && !rephex[t].contains("**")) {
                                error = true;
                                rephex[t] = "60";
                            }
                            if (rephex[t].contains("**") || rephex[t].matches("\\?+")) {
                                rephex[t] = "60";
                                rep_mask[t] = beginTag;
                            } else {
                                rep_mask[t] = classesTag;
                            }
                            if (rephex[t].toLowerCase().contains("sq")) {
                                rephex[t] = "60";
                                rep_mask[t] = 253;
                            }
                            if (rephex[t].contains("s1") || rephex[t].contains("S1")) {
                                rephex[t] = "60";
                                rep_mask[t] = 254;
                            }
                            if (rephex[t].contains("s0") || rephex[t].contains("S0")) {
                                rephex[t] = "60";
                                rep_mask[t] = 255;
                            }
                            if (rephex[t].contains("W") || rephex[t].contains("w") || rephex[t].contains("R") || rephex[t].contains("R")) {
                                rep_mask[t] = Integer.valueOf(rephex[t].toLowerCase().replace("w", "").replace(InternalZipConstants.READ_MODE, "")).intValue() + mips;
                                rephex[t] = "60";
                            }
                            byteReplace[t] = Integer.valueOf(rephex[t], 16).byteValue();
                            t += classesTag;
                        } catch (Exception e8222) {
                            print.println(" " + e8222);
                        }
                    }
                    if (rep_mask.length != mask.length || byteOrig.length != byteReplace.length || byteReplace.length < endTag || byteOrig.length < endTag) {
                        error = true;
                    }
                    if (error) {
                        result = false;
                        print.println("Error LP: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!");
                    }
                    if (!error) {
                        pat.add(new PatchesItem(byteOrig, mask, byteReplace, rep_mask, group, false));
                        group = "";
                    }
                }
                if (txtdata[r].contains("insert") && txtdata[r].contains("{") && txtdata[r].contains("}")) {
                    try {
                        value2 = new JSONObject(txtdata[r]).getString("insert");
                    } catch (JSONException e12) {
                        Utils.sendFromRoot("Error LP: Error insert hex read!");
                    }
                    value2 = value2.trim();
                    rephex = new String[value2.split("[ \t]+").length];
                    rephex = value2.split("[ \t]+");
                    rep_mask = new int[rephex.length];
                    byteReplace = new byte[rephex.length];
                    t = beginTag;
                    while (t < rephex.length) {
                        try {
                            if (rephex[t].contains("*") && !rephex[t].contains("**")) {
                                error = true;
                                rephex[t] = "60";
                            }
                            if (rephex[t].contains("**") || rephex[t].matches("\\?+")) {
                                rephex[t] = "60";
                                rep_mask[t] = beginTag;
                            } else {
                                rep_mask[t] = classesTag;
                            }
                            if (rephex[t].toLowerCase().contains("sq")) {
                                rephex[t] = "60";
                                rep_mask[t] = 253;
                            }
                            if (rephex[t].contains("s1") || rephex[t].contains("S1")) {
                                rephex[t] = "60";
                                rep_mask[t] = 254;
                            }
                            if (rephex[t].contains("s0") || rephex[t].contains("S0")) {
                                rephex[t] = "60";
                                rep_mask[t] = 255;
                            }
                            if (rephex[t].contains("W") || rephex[t].contains("w") || rephex[t].contains("R") || rephex[t].contains("R")) {
                                rep_mask[t] = Integer.valueOf(rephex[t].toLowerCase().replace("w", "").replace(InternalZipConstants.READ_MODE, "")).intValue() + mips;
                                rephex[t] = "60";
                            }
                            byteReplace[t] = Integer.valueOf(rephex[t], 16).byteValue();
                            t += classesTag;
                        } catch (Exception e82222) {
                            Utils.sendFromRoot(" " + e82222);
                        }
                    }
                    if (byteReplace.length < endTag || byteOrig.length < endTag) {
                        error = true;
                    }
                    if (error) {
                        result = false;
                        Utils.sendFromRoot("Error LP: Dimensions of the original hex-string and repleced must be >3.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!");
                    }
                    if (!error) {
                        if (multilib_patch || multidex) {
                            pat.add(new PatchesItem(byteOrig, mask, byteReplace, rep_mask, "all_lib", true));
                        } else {
                            pat.add(new PatchesItem(byteOrig, mask, byteReplace, rep_mask, group, true));
                        }
                        group = "";
                    }
                }
                if (txtdata[r].contains("replace_from_file") && txtdata[r].contains("{") && txtdata[r].contains("}")) {
                    try {
                        value2 = new JSONObject(txtdata[r]).getString("replace_from_file");
                    } catch (JSONException e13) {
                        print.println("Error LP: Error replaced hex read!");
                    }
                    value2 = value2.trim();
                    File arrayFile = new File(Utils.getDirs(new File(paramArrayOfString[classesTag])) + InternalZipConstants.ZIP_FILE_SEPARATOR + value2);
                    int len = (int) arrayFile.length();
                    byteReplace = new byte[len];
                    try {
                        do {
                        } while (new FileInputStream(arrayFile).read(byteReplace) > 0);
                    } catch (Exception e822222) {
                        e822222.printStackTrace();
                    }
                    rep_mask = new int[len];
                    Arrays.fill(rep_mask, classesTag);
                    if (error) {
                        result = false;
                        print.println("Error LP: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!");
                    }
                    if (!error) {
                        pat.add(new PatchesItem(byteOrig, mask, byteReplace, rep_mask, group, false));
                        group = "";
                    }
                }
                if (end) {
                    finalText = new StringBuilder(String.valueOf(finalText)).append("\n").append(txtdata[r]).toString();
                }
                if (data.contains("[END]")) {
                    tag = endTag;
                    finalText = "";
                    end = true;
                }
                r += classesTag;
            }
        } catch (FileNotFoundException e14) {
            print.println("Custom Patch not Found!\n");
        } catch (IOException e22) {
            print.println("Patch process Error LP: " + e22);
        } catch (InterruptedException e32) {
            e32.printStackTrace();
        }
    }

    public static boolean patchProcess(java.util.ArrayList<com.android.vending.billing.InAppBillingService.LOCK.PatchesItem> r28) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:42)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:66)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:173)
*/
        /*
        r23 = 1;
        r17 = 0;
        if (r28 == 0) goto L_0x0016;
    L_0x0006:
        r3 = r28.size();
        if (r3 <= 0) goto L_0x0016;
    L_0x000c:
        r3 = r28.iterator();
    L_0x0010:
        r4 = r3.hasNext();
        if (r4 != 0) goto L_0x006e;
    L_0x0016:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = localFile2;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = "rw";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = 0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r14 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r28.toArray();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[r3];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r24 = r0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r28.size();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[r3];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r24 = r0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r0 = r28;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r1 = r24;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r24 = r0.toArray(r1);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r24 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[]) r24;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r11 = -1;
    L_0x004d:
        r3 = r14.hasRemaining();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 != 0) goto L_0x00a7;
    L_0x0053:
        r2.close();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r15 = 0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x0057:
        r0 = r24;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r15 < r3) goto L_0x02c6;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x005c:
        r15 = 0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x005d:
        r0 = r24;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r15 < r3) goto L_0x02fa;
    L_0x0062:
        r3 = tag;
        r4 = 1;
        if (r3 != r4) goto L_0x006c;
    L_0x0067:
        r3 = localFile2;
        fixadler(r3);
    L_0x006c:
        r3 = 1;
        return r3;
    L_0x006e:
        r18 = r3.next();
        r18 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItem) r18;
        r4 = 0;
        r0 = r18;
        r0.result = r4;
        r4 = tag;
        r5 = 1;
        if (r4 != r5) goto L_0x0010;
    L_0x007e:
        r4 = multidex;
        if (r4 == 0) goto L_0x0010;
    L_0x0082:
        r0 = r18;
        r4 = r0.group;
        r5 = "";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0010;
    L_0x008e:
        r4 = new java.lang.StringBuilder;
        r5 = "multi_";
        r4.<init>(r5);
        r0 = r17;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r0 = r18;
        r0.group = r4;
        r17 = r17 + 1;
        goto L_0x0010;
    L_0x00a7:
        r3 = r11 + 1;
        r14.position(r3);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r11 = r14.position();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r10 = r14.get();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r15 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x00b5:
        r0 = r24;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r0.length;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r15 >= r3) goto L_0x004d;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x00ba:
        r14.position(r11);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r10 == r3) goto L_0x00f1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x00c6:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 == r4) goto L_0x00f1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x00d0:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 <= r4) goto L_0x012e;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x00da:
        r3 = search;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4[r5];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.get(r4);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = (java.lang.Byte) r3;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.byteValue();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r10 != r3) goto L_0x012e;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x00f1:
        r16 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r11 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r14.position(r3);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r25 = r10;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x00fa:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r25;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r0 == r3) goto L_0x0131;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x0104:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 <= r4) goto L_0x0125;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x010d:
        r3 = search;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4[r16];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.get(r4);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = (java.lang.Byte) r3;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.byteValue();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r25;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r0 == r3) goto L_0x0131;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x0125:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 == r4) goto L_0x0131;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x012e:
        r15 = r15 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        goto L_0x00b5;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x0131:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r16;
        if (r0 >= r3) goto L_0x01b7;
    L_0x013a:
        r3 = r24[r15];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        if (r3 != 0) goto L_0x0148;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
    L_0x0142:
        r3 = r24[r15];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3[r16] = r25;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
    L_0x0148:
        r3 = r24[r15];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r4 = 1;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        if (r3 <= r4) goto L_0x0177;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
    L_0x0151:
        r3 = r24[r15];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r4 = 253; // 0xfd float:3.55E-43 double:1.25E-321;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        if (r3 >= r4) goto L_0x0177;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
    L_0x015b:
        r3 = r24[r15];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r27 = r3 + -2;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r24[r15];	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r4 = r3.repByte;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = search;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r0 = r27;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3.get(r0);	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = (java.lang.Byte) r3;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r3 = r3.byteValue();	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
        r4[r16] = r3;	 Catch:{ Exception -> 0x027e, IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, FileNotFoundException -> 0x0274 }
    L_0x0177:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 253; // 0xfd float:3.55E-43 double:1.25E-321;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 != r4) goto L_0x018f;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x0181:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r25 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = r25 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = r5 * 16;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4 + r5;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3[r16] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x018f:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 254; // 0xfe float:3.56E-43 double:1.255E-321;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 != r4) goto L_0x01a4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x0199:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r25 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4 + 16;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3[r16] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x01a4:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 != r4) goto L_0x01b7;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x01ae:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r25 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3[r16] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x01b7:
        r16 = r16 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r16;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r0 != r3) goto L_0x02c0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x01c2:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.insert;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 != 0) goto L_0x01d4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x01c8:
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.length;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r3 == r4) goto L_0x0224;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x01d4:
        r22 = r14.position();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r2.size();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = (int) r4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r19 = r3 - r22;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r19;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r8 = new byte[r0];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r19;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r14.get(r8, r3, r0);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r9 = java.nio.ByteBuffer.wrap(r8);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r26 = r0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r21 = r0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r12 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r26;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r1 = r21;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        if (r0 < r1) goto L_0x02b4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x0202:
        r3 = r26 - r21;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3 + r22;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = (long) r3;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r2.position(r4);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x020a:
        r2.write(r9);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r2.size();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r6 = (long) r12;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4 - r6;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r2.truncate(r4);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r6 = r2.size();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r6 = (int) r6;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r6 = (long) r6;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r14 = r2.map(r3, r4, r6);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x0224:
        r4 = (long) r11;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r2.position(r4);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r9 = java.nio.ByteBuffer.wrap(r3);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r2.write(r9);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r14.force();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = print;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = "\nPattern N";	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4.<init>(r5);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = r15 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.append(r5);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = ": Patch done! \n(Offset: ";	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.append(r5);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = java.lang.Integer.toHexString(r11);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.append(r5);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = ")\n";	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.append(r5);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.toString();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3.println(r4);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3.result = r4;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        patchteil = r3;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        goto L_0x012e;
    L_0x026a:
        r13 = move-exception;
        r3 = print;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = "Byte by search not found! Please edit pattern for search.\n";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        goto L_0x0053;
    L_0x0274:
        r20 = move-exception;
        r3 = print;
        r4 = "Error LP: Program files are not found!\nMove Program to internal storage.";
        r3.println(r4);
        goto L_0x0062;
    L_0x027e:
        r13 = move-exception;
        r3 = r24[r15];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r3[r16];	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r27 = r3 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = print;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = "Byte N";	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4.<init>(r5);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r27;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = " not found! Please edit search pattern for byte ";	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.append(r5);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r0 = r27;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r5 = ".";	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.append(r5);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = r4.toString();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3.println(r4);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        goto L_0x0177;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x02b1:
        r3 = move-exception;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        goto L_0x0053;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x02b4:
        r3 = r21 - r26;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r3 = r22 - r3;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r4 = (long) r3;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r2.position(r4);	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        r12 = r21 - r26;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        goto L_0x020a;	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
    L_0x02c0:
        r25 = r14.get();	 Catch:{ IndexOutOfBoundsException -> 0x026a, BufferUnderflowException -> 0x02b1, Exception -> 0x03f0, FileNotFoundException -> 0x0274 }
        goto L_0x00fa;
    L_0x02c6:
        r3 = r24[r15];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 == 0) goto L_0x02de;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x02cc:
        r3 = r24[r15];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.group;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = "";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 != 0) goto L_0x02de;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x02d8:
        r0 = r24;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r0.length;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = 0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x02dc:
        if (r3 < r4) goto L_0x02e2;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x02de:
        r15 = r15 + 1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        goto L_0x0057;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x02e2:
        r22 = r24[r3];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r0 = r22;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = r0.group;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r6 = r24[r15];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r6 = r6.group;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = r5.equals(r6);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r5 == 0) goto L_0x02f7;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x02f2:
        r5 = 1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r0 = r22;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r0.groupResult = r5;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x02f7:
        r3 = r3 + 1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        goto L_0x02dc;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x02fa:
        r3 = r24[r15];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 != 0) goto L_0x03af;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x0300:
        r3 = r24[r15];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.group;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = "";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 != 0) goto L_0x03b3;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x030c:
        r3 = r24[r15];	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.groupResult;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 != 0) goto L_0x03af;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x0312:
        r3 = multidex;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 == 0) goto L_0x034a;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x0316:
        r3 = localFile2;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = r5.size();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = r5 + -1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.get(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 == 0) goto L_0x034a;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x032c:
        r3 = print;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = r15 + 1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r23 = 0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x034a:
        r3 = multilib_patch;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 == 0) goto L_0x0389;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x034e:
        r4 = localFile2;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = libs;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r6 = libs;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r6 = r6.size();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r6 = r6 + -1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r3.get(r6);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = (java.lang.String) r3;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3 = r4.equals(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 == 0) goto L_0x0389;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x036b:
        r3 = print;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = r15 + 1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r23 = 0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x0389:
        r3 = multidex;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 != 0) goto L_0x03af;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x038d:
        r3 = multilib_patch;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        if (r3 != 0) goto L_0x03af;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x0391:
        r3 = print;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = r15 + 1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r23 = 0;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x03af:
        r15 = r15 + 1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        goto L_0x005d;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
    L_0x03b3:
        r3 = print;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = r15 + 1;	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r5 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0274, BufferUnderflowException -> 0x03ed, Exception -> 0x03d2 }
        r23 = 0;
        goto L_0x03af;
    L_0x03d2:
        r13 = move-exception;
        r3 = print;
        r4 = new java.lang.StringBuilder;
        r5 = "Exception e";
        r4.<init>(r5);
        r5 = r13.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x0062;
    L_0x03ed:
        r3 = move-exception;
        goto L_0x0062;
    L_0x03f0:
        r3 = move-exception;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.createapkcustom.patchProcess(java.util.ArrayList):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean searchProcess(java.util.ArrayList<com.android.vending.billing.InAppBillingService.LOCK.SearchItem> r24) {
        /*
        r19 = 1;
        r3 = "";
        searchStr = r3;
        if (r24 == 0) goto L_0x0018;
    L_0x0008:
        r3 = r24.size();
        if (r3 <= 0) goto L_0x0018;
    L_0x000e:
        r3 = r24.iterator();
    L_0x0012:
        r4 = r3.hasNext();
        if (r4 != 0) goto L_0x0066;
    L_0x0018:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = localFile2;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r5 = "rw";
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r12 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r24.toArray();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.SearchItem[r3];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r20 = r0;
        r3 = r24.size();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.SearchItem[r3];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r20 = r0;
        r0 = r24;
        r1 = r20;
        r20 = r0.toArray(r1);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r20 = (com.android.vending.billing.InAppBillingService.LOCK.SearchItem[]) r20;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r16 = 0;
    L_0x0050:
        r3 = r12.hasRemaining();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r3 != 0) goto L_0x0070;
    L_0x0056:
        r2.close();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r13 = 0;
    L_0x005a:
        r0 = r20;
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        if (r13 < r3) goto L_0x011e;
    L_0x005f:
        r13 = 0;
    L_0x0060:
        r0 = r20;
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        if (r13 < r3) goto L_0x0153;
    L_0x0065:
        return r19;
    L_0x0066:
        r15 = r3.next();
        r15 = (com.android.vending.billing.InAppBillingService.LOCK.SearchItem) r15;
        r4 = 0;
        r15.result = r4;
        goto L_0x0012;
    L_0x0070:
        r10 = r12.position();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r9 = r12.get();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r13 = 0;
    L_0x0079:
        r0 = r20;
        r3 = r0.length;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r13 < r3) goto L_0x0088;
    L_0x007e:
        r3 = r10 + 1;
        r12.position(r3);	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = 1;
        r16 = r16 + r4;
        goto L_0x0050;
    L_0x0088:
        r12.position(r10);	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.result;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r3 != 0) goto L_0x00d5;
    L_0x0091:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r9 == r3) goto L_0x00a3;
    L_0x009a:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r3 == 0) goto L_0x00d5;
    L_0x00a3:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r3 == 0) goto L_0x00b3;
    L_0x00ac:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = 0;
        r3[r4] = r9;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
    L_0x00b3:
        r14 = 1;
        r3 = r10 + 1;
        r12.position(r3);	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r21 = r12.get();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
    L_0x00bd:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.result;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r3 != 0) goto L_0x00cd;
    L_0x00c3:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r0 = r21;
        if (r0 == r3) goto L_0x00d8;
    L_0x00cd:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r3 != 0) goto L_0x00d8;
    L_0x00d5:
        r13 = r13 + 1;
        goto L_0x0079;
    L_0x00d8:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r3 <= 0) goto L_0x00e6;
    L_0x00e0:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3[r14] = r21;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
    L_0x00e6:
        r14 = r14 + 1;
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = r3.length;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        if (r14 != r3) goto L_0x0119;
    L_0x00ef:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = 1;
        r3.result = r4;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r3 = 1;
        patchteil = r3;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        goto L_0x00d5;
    L_0x00f8:
        r11 = move-exception;
        r3 = print;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r5 = "Search byte error: ";
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = r4.append(r11);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        goto L_0x0056;
    L_0x010f:
        r18 = move-exception;
        r3 = print;
        r4 = "Error LP: Program files are not found!\nMove Program to internal storage.";
        r3.println(r4);
        goto L_0x0065;
    L_0x0119:
        r21 = r12.get();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        goto L_0x00bd;
    L_0x011e:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        if (r3 != 0) goto L_0x014f;
    L_0x0124:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = "Bytes by serach N";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = r13 + 1;
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = ":\nError LP: Bytes not found!";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = "\n";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r19 = 0;
    L_0x014f:
        r13 = r13 + 1;
        goto L_0x005a;
    L_0x0153:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        if (r3 == 0) goto L_0x0182;
    L_0x0159:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = "\nBytes by search N";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = r13 + 1;
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = ":";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = "\n";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
    L_0x0182:
        r22 = 0;
    L_0x0184:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r0 = r22;
        if (r0 < r3) goto L_0x01a8;
    L_0x018d:
        r3 = searchStr;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4.<init>(r3);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = "\n";
        r3 = r4.append(r3);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r13 = r13 + 1;
        goto L_0x0060;
    L_0x01a8:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3[r22];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = 1;
        if (r3 <= r4) goto L_0x0219;
    L_0x01b1:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3[r22];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r23 = r3 + -2;
        r3 = search;	 Catch:{ Exception -> 0x021d, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = r20[r13];	 Catch:{ Exception -> 0x021d, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = r4.repByte;	 Catch:{ Exception -> 0x021d, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = r4[r22];	 Catch:{ Exception -> 0x021d, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r4 = java.lang.Byte.valueOf(r4);	 Catch:{ Exception -> 0x021d, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
        r0 = r23;
        r3.set(r0, r4);	 Catch:{ Exception -> 0x021d, FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230 }
    L_0x01ca:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        if (r3 == 0) goto L_0x0219;
    L_0x01d0:
        r3 = 1;
        r8 = new byte[r3];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = 0;
        r3 = search;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r0 = r23;
        r3 = r3.get(r0);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = (java.lang.Byte) r3;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.byteValue();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r8[r4] = r3;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = "R";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r0 = r23;
        r3 = r3.append(r0);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = "=";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = com.chelpus.Utils.bytesToHex(r8);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = r4.toUpperCase();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = " ";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
    L_0x0219:
        r22 = r22 + 1;
        goto L_0x0184;
    L_0x021d:
        r11 = move-exception;
        r3 = search;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = r4.repByte;	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = r4[r22];	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r4 = java.lang.Byte.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        r0 = r23;
        r3.add(r0, r4);	 Catch:{ FileNotFoundException -> 0x010f, BufferUnderflowException -> 0x0230, Exception -> 0x024b }
        goto L_0x01ca;
    L_0x0230:
        r11 = move-exception;
        r3 = print;
        r4 = new java.lang.StringBuilder;
        r5 = "Exception e";
        r4.<init>(r5);
        r5 = r11.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x0065;
    L_0x024b:
        r11 = move-exception;
        r11.printStackTrace();
        r3 = print;
        r4 = new java.lang.StringBuilder;
        r5 = "Exception e";
        r4.<init>(r5);
        r5 = r11.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.createapkcustom.searchProcess(java.util.ArrayList):boolean");
    }

    public static void getClassesDex() {
        try {
            File apk = new File(appdir);
            crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
            Utils.copyFile(apk, crkapk);
            unzip(crkapk);
            if (classesFiles == null || classesFiles.size() == 0) {
                throw new FileNotFoundException();
            }
            if (classesFiles != null && classesFiles.size() > 0) {
                Iterator it = classesFiles.iterator();
                while (it.hasNext()) {
                    if (!((File) it.next()).exists()) {
                        throw new FileNotFoundException();
                    }
                }
            }
            System.out.println("get classes.dex " + classesFiles.size());
        } catch (FileNotFoundException e) {
            print.println("Error LP: unzip classes.dex fault!\n\n");
        } catch (Exception e2) {
            print.println("Extract classes.dex error: " + e2.toString());
        }
    }

    public static ArrayList<String> searchlib(int architectura, String libname) {
        ArrayList<String> libs = new ArrayList();
        try {
            if (!libname.trim().equals("*")) {
                switch (architectura) {
                    case beginTag /*0*/:
                        libs.clear();
                        String arh = sddir + "/tmp/lib/armeabi/" + libname;
                        if (new File(sddir + "/tmp/lib/armeabi/" + libname).exists()) {
                            libs.add(arh);
                            break;
                        }
                        throw new FileNotFoundException();
                    case classesTag /*1*/:
                        libs.clear();
                        String arh1 = sddir + "/tmp/lib/armeabi-v7a/" + libname;
                        if (new File(sddir + "/tmp/lib/armeabi-v7a/" + libname).exists()) {
                            libs.add(arh1);
                            break;
                        }
                        throw new FileNotFoundException();
                    case mips /*2*/:
                        libs.clear();
                        String arh2 = sddir + "/tmp/lib/mips/" + libname;
                        if (new File(sddir + "/tmp/lib/mips/" + libname).exists()) {
                            libs.add(arh2);
                            break;
                        }
                        throw new FileNotFoundException();
                    case x86 /*3*/:
                        libs.clear();
                        String arh3 = sddir + "/tmp/lib/x86/" + libname;
                        if (new File(sddir + "/tmp/lib/x86/" + libname).exists()) {
                            libs.add(arh3);
                            if (new File(sddir + "/tmp/lib/x86_64/" + libname).exists()) {
                                libs.add(arh3);
                                break;
                            }
                        }
                        throw new FileNotFoundException();
                        break;
                    case endTag /*4*/:
                        String arh4 = sddir + "/tmp/lib/armeabi/" + libname;
                        if (new File(arh4).exists()) {
                            libs.add(arh4);
                        }
                        arh4 = sddir + "/tmp/lib/armeabi-v7a/" + libname;
                        if (new File(arh4).exists()) {
                            libs.add(arh4);
                        }
                        arh4 = sddir + "/tmp/lib/mips/" + libname;
                        if (new File(arh4).exists()) {
                            libs.add(arh4);
                        }
                        arh4 = sddir + "/tmp/lib/x86/" + libname;
                        if (new File(arh4).exists()) {
                            libs.add(arh4);
                        }
                        arh4 = sddir + "/tmp/lib/x86_64/" + libname;
                        if (new File(arh4).exists()) {
                            libs.add(arh4);
                        }
                        arh4 = sddir + "/tmp/lib/arm64-v8a/" + libname;
                        if (new File(arh4).exists()) {
                            libs.add(arh4);
                            break;
                        }
                        break;
                    case packageTag /*5*/:
                        libs.clear();
                        String arh5 = sddir + "/tmp/lib/arm64-v8a/" + libname;
                        if (new File(sddir + "/tmp/lib/arm64-v8a/" + libname).exists()) {
                            libs.add(arh5);
                            break;
                        }
                        throw new FileNotFoundException();
                    default:
                        break;
                }
            }
            multilib_patch = true;
            ArrayList<File> foundlibs = new ArrayList();
            new Utils("").findFileEndText(new File(sddir + "/tmp/lib/"), ".so", foundlibs);
            if (foundlibs.size() > 0) {
                Iterator it = foundlibs.iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file.length() > 0) {
                        libs.add(file.getAbsolutePath());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            print.println("Lib not found!" + e.toString());
        } catch (Exception e2) {
            print.println("Lib select error: " + e2.toString());
        }
        return libs;
    }

    public static String getFileFromApk(String file) {
        try {
            File apk = new File(appdir);
            crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
            if (!crkapk.exists()) {
                Utils.copyFile(apk, crkapk);
            }
            return extractFile(crkapk, file);
        } catch (Exception e) {
            print.println("Lib select error: " + e.toString());
            return "";
        }
    }

    public static void fixadler(File destFile) {
        try {
            FileInputStream localFileInputStream = new FileInputStream(destFile);
            byte[] arrayOfByte = new byte[localFileInputStream.available()];
            localFileInputStream.read(arrayOfByte);
            calcSignature(arrayOfByte, beginTag);
            calcChecksum(arrayOfByte, beginTag);
            localFileInputStream.close();
            FileOutputStream localFileOutputStream = new FileOutputStream(destFile);
            localFileOutputStream.write(arrayOfByte);
            localFileOutputStream.close();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private static final void calcChecksum(byte[] paramArrayOfByte, int j) {
        Adler32 localAdler32 = new Adler32();
        localAdler32.update(paramArrayOfByte, nextPatchTag, paramArrayOfByte.length - (j + nextPatchTag));
        int i = (int) localAdler32.getValue();
        paramArrayOfByte[j + libTagMIPS] = (byte) i;
        paramArrayOfByte[j + libTagx86] = (byte) (i >> libTagMIPS);
        paramArrayOfByte[j + fileInApkTag] = (byte) (i >> 16);
        paramArrayOfByte[j + libTagARM64V8A] = (byte) (i >> 24);
    }

    private static final void calcSignature(byte[] paramArrayOfByte, int j) {
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
            localMessageDigest.update(paramArrayOfByte, 32, paramArrayOfByte.length - (j + 32));
            try {
                int i = localMessageDigest.digest(paramArrayOfByte, j + nextPatchTag, 20);
                if (i != 20) {
                    throw new RuntimeException("unexpected digest write:" + i + "bytes");
                }
            } catch (DigestException localDigestException) {
                throw new RuntimeException(localDigestException);
            }
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            throw new RuntimeException(localNoSuchAlgorithmException);
        }
    }

    public static void unzip(File apk) {
        classesFiles.clear();
        try {
            FileInputStream fin = new FileInputStream(apk);
            ZipInputStream zin = new ZipInputStream(fin);
            while (true) {
                ZipEntry ze = zin.getNextEntry();
                if (ze == null) {
                    zin.close();
                    fin.close();
                    return;
                } else if (ze.getName().toLowerCase().startsWith("classes") && ze.getName().endsWith(".dex") && !ze.getName().contains(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    FileOutputStream fout = new FileOutputStream(sddir + "/Modified/" + ze.getName());
                    byte[] buffer = new byte[Util.BLOCK_HEADER_SIZE_MAX];
                    while (true) {
                        int length = zin.read(buffer);
                        if (length == -1) {
                            break;
                        }
                        fout.write(buffer, beginTag, length);
                    }
                    classesFiles.add(new File(sddir + "/Modified/" + ze.getName()));
                    zin.closeEntry();
                    fout.close();
                }
            }
        } catch (Exception e) {
            try {
                new ZipFile(apk).extractFile("classes.dex", sddir + "/Modified/");
                classesFiles.add(new File(sddir + "/Modified/" + "classes.dex"));
            } catch (ZipException e1) {
                print.println("Error LP: Error classes.dex decompress! " + e1);
                print.println("Exception e1" + e.toString());
            } catch (Exception e12) {
                print.println("Error LP: Error classes.dex decompress! " + e12);
                print.println("Exception e1" + e.toString());
            }
        }
    }

    public static void clearTemp() {
        try {
            File tempdex = new File(sddir + "/Modified/classes.dex.apk");
            if (tempdex.exists()) {
                tempdex.delete();
            }
        } catch (Exception e) {
            print.println(e.toString());
        }
    }

    public static void extractLibs(File apk) {
        String zipFile = apk.getAbsolutePath();
        String unzipLocation = sddir + "/tmp/";
        if (!new File(sddir + "/tmp/lib/").exists()) {
            new Decompress(zipFile, unzipLocation).unzip();
        }
    }

    public static String extractFile(File apk, String file) {
        return new Decompress(apk.getAbsolutePath(), sddir + "/tmp/").unzip(file);
    }

    public static void zipLib(ArrayList<String> filesIn) {
        try {
            ArrayList<AddFilesItem> files = new ArrayList();
            Iterator it = filesIn.iterator();
            while (it.hasNext()) {
                String file = (String) it.next();
                System.out.println(file);
                files.add(new AddFilesItem(file, sddir + "/tmp/"));
            }
            Utils.addFilesToZip(crkapk.getAbsolutePath(), new StringBuilder(String.valueOf(crkapk.getAbsolutePath())).append("checlpis.zip").toString(), files);
            crkapk.delete();
            if (!crkapk.exists()) {
                new File(new StringBuilder(String.valueOf(crkapk.getAbsolutePath())).append("checlpis.zip").toString()).renameTo(crkapk);
            }
            if (crkapk.exists()) {
                System.out.println(crkapk.getAbsolutePath());
                System.out.println(crkapk.length());
                String[] strArr = new String[x86];
                strArr[beginTag] = "chmod";
                strArr[classesTag] = "777";
                strArr[mips] = "'" + crkapk.getAbsolutePath() + "'";
                Utils.cmdParam(strArr);
                new Utils("").setAllWritable(Utils.getDirs(crkapk));
            }
        } catch (Exception e) {
            print.println("Error LP: Error libs compress! " + e);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            print.println("Error LP: Error libs compress! Out of memory for operation: " + e2);
        }
    }
}
