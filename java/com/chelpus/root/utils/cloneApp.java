package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.AxmlExample;
import com.android.vending.billing.InAppBillingService.LOCK.LogOutputStream;
import com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.util.InternalZipConstants;
import org.tukaani.xz.common.Util;

public class cloneApp {
    public static String appdir = "/sdcard/";
    public static ArrayList<File> classesFiles = new ArrayList();
    public static File crkapk;
    public static String dir = "/sdcard/";
    public static String dir2 = "/sdcard/";
    public static String dirapp = "/data/app/";
    public static ArrayList<File> filestopatch = null;
    public static PrintStream print;
    public static ArrayList<File> resourcesFiles = new ArrayList();
    public static ArrayList<File> resourcesFiles_temp = new ArrayList();
    public static String result;
    public static String sddir = "/sdcard/";
    public static boolean system = false;

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
                    } else if ((ze.getName().endsWith(".xml") && !ze.getName().toLowerCase().equals("androidmanifest.xml")) || ze.getName().toLowerCase().endsWith("resources.arsc") || ze.getName().toLowerCase().endsWith(".so")) {
                        String[] tail = ze.getName().split("\\/+");
                        String data_dir = "";
                        for (i = 0; i < tail.length - 1; i++) {
                            if (!tail[i].equals("")) {
                                data_dir = data_dir + InternalZipConstants.ZIP_FILE_SEPARATOR + tail[i];
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
                            fout.write(buffer, 0, length);
                        }
                        cloneApp.resourcesFiles_temp.add(new File(this._location + ze.getName()));
                        zin.closeEntry();
                        fout.close();
                    }
                }
            } catch (Exception e) {
                cloneApp.print.println("Decompressunzip " + e);
                try {
                    ZipFile zipFile = new ZipFile(this._zipFile);
                    List fileHeaderList = zipFile.getFileHeaders();
                    for (i = 0; i < fileHeaderList.size(); i++) {
                        FileHeader fileHeader = (FileHeader) fileHeaderList.get(i);
                        if (fileHeader.getFileName().endsWith(".xml") || fileHeader.getFileName().toLowerCase().endsWith("resources.arsc")) {
                            cloneApp.print.println(fileHeader.getFileName());
                            zipFile.extractFile(fileHeader.getFileName(), this._location);
                            cloneApp.resourcesFiles_temp.add(new File(this._location + fileHeader.getFileName()));
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
            r9 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x002b }
            r0 = r20;
            r0 = r0._zipFile;	 Catch:{ Exception -> 0x002b }
            r17 = r0;
            r0 = r17;
            r9.<init>(r0);	 Catch:{ Exception -> 0x002b }
            r15 = new java.util.zip.ZipInputStream;	 Catch:{ Exception -> 0x002b }
            r15.<init>(r9);	 Catch:{ Exception -> 0x002b }
            r14 = 0;
        L_0x0013:
            r14 = r15.getNextEntry();	 Catch:{ Exception -> 0x002b }
            if (r14 == 0) goto L_0x0172;
        L_0x0019:
            r17 = r14.isDirectory();	 Catch:{ Exception -> 0x002b }
            if (r17 == 0) goto L_0x00a4;
        L_0x001f:
            r17 = r14.getName();	 Catch:{ Exception -> 0x002b }
            r0 = r20;
            r1 = r17;
            r0._dirChecker(r1);	 Catch:{ Exception -> 0x002b }
            goto L_0x0013;
        L_0x002b:
            r5 = move-exception;
            r17 = com.chelpus.root.utils.cloneApp.print;
            r18 = new java.lang.StringBuilder;
            r18.<init>();
            r19 = "Decompressunzip ";
            r18 = r18.append(r19);
            r0 = r18;
            r18 = r0.append(r5);
            r18 = r18.toString();
            r17.println(r18);
            r16 = new net.lingala.zip4j.core.ZipFile;	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r0 = r20;
            r0 = r0._zipFile;	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r17 = r0;
            r16.<init>(r17);	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r8 = r16.getFileHeaders();	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r11 = 0;
        L_0x0056:
            r17 = r8.size();	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r0 = r17;
            if (r11 >= r0) goto L_0x0178;
        L_0x005e:
            r7 = r8.get(r11);	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r7 = (net.lingala.zip4j.model.FileHeader) r7;	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r17 = r7.getFileName();	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r0 = r17;
            r1 = r21;
            r17 = r0.equals(r1);	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            if (r17 == 0) goto L_0x017c;
        L_0x0072:
            r17 = com.chelpus.root.utils.cloneApp.print;	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r18 = r7.getFileName();	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r17.println(r18);	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r17 = r7.getFileName();	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r0 = r20;
            r0 = r0._location;	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r18 = r0;
            r16.extractFile(r17, r18);	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r17 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r17.<init>();	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r0 = r20;
            r0 = r0._location;	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r18 = r0;
            r17 = r17.append(r18);	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r18 = r7.getFileName();	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r17 = r17.append(r18);	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
            r17 = r17.toString();	 Catch:{ ZipException -> 0x0180, Exception -> 0x0185 }
        L_0x00a3:
            return r17;
        L_0x00a4:
            r17 = "/";
            r0 = r21;
            r1 = r17;
            r17 = r0.startsWith(r1);	 Catch:{ Exception -> 0x002b }
            if (r17 == 0) goto L_0x00be;
        L_0x00b0:
            r17 = "/";
            r18 = "";
            r0 = r21;
            r1 = r17;
            r2 = r18;
            r21 = r0.replaceFirst(r1, r2);	 Catch:{ Exception -> 0x002b }
        L_0x00be:
            r17 = r14.getName();	 Catch:{ Exception -> 0x002b }
            r0 = r17;
            r1 = r21;
            r17 = r0.equals(r1);	 Catch:{ Exception -> 0x002b }
            if (r17 == 0) goto L_0x0013;
        L_0x00cc:
            r17 = r14.getName();	 Catch:{ Exception -> 0x002b }
            r18 = "\\/+";
            r13 = r17.split(r18);	 Catch:{ Exception -> 0x002b }
            r4 = "";
            r11 = 0;
        L_0x00d9:
            r0 = r13.length;	 Catch:{ Exception -> 0x002b }
            r17 = r0;
            r17 = r17 + -1;
            r0 = r17;
            if (r11 >= r0) goto L_0x010a;
        L_0x00e2:
            r17 = r13[r11];	 Catch:{ Exception -> 0x002b }
            r18 = "";
            r17 = r17.equals(r18);	 Catch:{ Exception -> 0x002b }
            if (r17 != 0) goto L_0x0107;
        L_0x00ec:
            r17 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002b }
            r17.<init>();	 Catch:{ Exception -> 0x002b }
            r0 = r17;
            r17 = r0.append(r4);	 Catch:{ Exception -> 0x002b }
            r18 = "/";
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x002b }
            r18 = r13[r11];	 Catch:{ Exception -> 0x002b }
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x002b }
            r4 = r17.toString();	 Catch:{ Exception -> 0x002b }
        L_0x0107:
            r11 = r11 + 1;
            goto L_0x00d9;
        L_0x010a:
            r0 = r20;
            r0._dirChecker(r4);	 Catch:{ Exception -> 0x002b }
            r10 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x002b }
            r17 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002b }
            r17.<init>();	 Catch:{ Exception -> 0x002b }
            r0 = r20;
            r0 = r0._location;	 Catch:{ Exception -> 0x002b }
            r18 = r0;
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x002b }
            r18 = r14.getName();	 Catch:{ Exception -> 0x002b }
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x002b }
            r17 = r17.toString();	 Catch:{ Exception -> 0x002b }
            r0 = r17;
            r10.<init>(r0);	 Catch:{ Exception -> 0x002b }
            r17 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r0 = r17;
            r3 = new byte[r0];	 Catch:{ Exception -> 0x002b }
        L_0x0137:
            r12 = r15.read(r3);	 Catch:{ Exception -> 0x002b }
            r17 = -1;
            r0 = r17;
            if (r12 == r0) goto L_0x0149;
        L_0x0141:
            r17 = 0;
            r0 = r17;
            r10.write(r3, r0, r12);	 Catch:{ Exception -> 0x002b }
            goto L_0x0137;
        L_0x0149:
            r15.closeEntry();	 Catch:{ Exception -> 0x002b }
            r10.close();	 Catch:{ Exception -> 0x002b }
            r15.close();	 Catch:{ Exception -> 0x002b }
            r9.close();	 Catch:{ Exception -> 0x002b }
            r17 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002b }
            r17.<init>();	 Catch:{ Exception -> 0x002b }
            r0 = r20;
            r0 = r0._location;	 Catch:{ Exception -> 0x002b }
            r18 = r0;
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x002b }
            r18 = r14.getName();	 Catch:{ Exception -> 0x002b }
            r17 = r17.append(r18);	 Catch:{ Exception -> 0x002b }
            r17 = r17.toString();	 Catch:{ Exception -> 0x002b }
            goto L_0x00a3;
        L_0x0172:
            r15.close();	 Catch:{ Exception -> 0x002b }
            r9.close();	 Catch:{ Exception -> 0x002b }
        L_0x0178:
            r17 = "";
            goto L_0x00a3;
        L_0x017c:
            r11 = r11 + 1;
            goto L_0x0056;
        L_0x0180:
            r6 = move-exception;
            r6.printStackTrace();
            goto L_0x0178;
        L_0x0185:
            r6 = move-exception;
            r6.printStackTrace();
            goto L_0x0178;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.cloneApp.Decompress.unzip(java.lang.String):java.lang.String");
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

    public static void main(String[] paramArrayOfString) {
        LogOutputStream logOutputStream = new LogOutputStream("System.out");
        print = new PrintStream(logOutputStream);
        classesFiles.clear();
        resourcesFiles.clear();
        resourcesFiles_temp.clear();
        Utils.startRootJava(new Object() {
        });
        Utils.kill(paramArrayOfString[0]);
        print.println("Support-Code Running!");
        ArrayList<PatchesItemAuto> patchesList = new ArrayList();
        filestopatch = new ArrayList();
        try {
            for (File file : new File(paramArrayOfString[2]).listFiles()) {
                if (!(!file.isFile() || file.getName().equals("busybox") || file.getName().equals("reboot") || file.getName().equals("dalvikvm"))) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (paramArrayOfString[6] != null) {
                Utils.sendFromRoot(paramArrayOfString[6]);
            }
        } catch (NullPointerException e2) {
        } catch (Exception e3) {
        }
        listAppsFragment.startUnderRoot = Boolean.valueOf(false);
        try {
            String packageName = paramArrayOfString[0];
            appdir = paramArrayOfString[1];
            sddir = paramArrayOfString[3];
            String options = paramArrayOfString[4];
            clearTempSD();
            File apk = new File(appdir);
            if (options.contains("DeepWork")) {
                unzipSD(apk, false);
                String zipFile = apk.getAbsolutePath();
                String unzipLocation = sddir + "/Modified/tmp/";
                if (new File(sddir + "/Modified/tmp/").exists()) {
                    new Utils("").deleteFolder(new File(sddir + "/Modified/tmp/"));
                }
                new Decompress(zipFile, unzipLocation).unzip();
            } else {
                unzipSD(apk, false);
            }
            crkapk = new File(sddir + "/Modified/" + packageName + ".apk");
            Utils.copyFile(apk, crkapk);
            String newPackageName = Utils.stringModifyLastChar(packageName);
            String[] stringsForChange = null;
            File androidManifest = new File(sddir + "/Modified/AndroidManifest.xml");
            if (androidManifest.exists()) {
                try {
                    String[] perms;
                    String[] prov;
                    int leng;
                    int i;
                    int k;
                    if (options.contains("DeepWork")) {
                        int count;
                        perms = new AxmlExample().getLocalPermisson(androidManifest);
                        prov = new AxmlExample().getProvidersAuthorities(androidManifest);
                        leng = 0;
                        if (perms != null && perms.length > 0) {
                            count = 0;
                            for (String contains : perms) {
                                if (!contains.contains(packageName)) {
                                    count++;
                                }
                            }
                            leng = 0 + count;
                        }
                        if (prov != null && prov.length > 0) {
                            count = 0;
                            for (String contains2 : prov) {
                                if (!contains2.contains(packageName)) {
                                    count++;
                                }
                            }
                            leng += count;
                        }
                        stringsForChange = new String[(leng + 1)];
                        k = 0;
                        if (perms != null && perms.length > 0) {
                            for (i = 0; i < perms.length; i++) {
                                if (!perms[i].contains(packageName)) {
                                    stringsForChange[k] = perms[i];
                                    k++;
                                }
                            }
                        }
                        if (prov != null && prov.length > 0) {
                            for (i = 0; i < prov.length; i++) {
                                if (!prov[i].contains(packageName)) {
                                    stringsForChange[k] = prov[i];
                                    k++;
                                }
                            }
                        }
                        stringsForChange[k] = packageName;
                        Utils.replaceStrings(androidManifest.getAbsolutePath(), stringsForChange);
                    } else {
                        perms = new AxmlExample().getLocalPermisson(androidManifest);
                        prov = new AxmlExample().getProvidersAuthorities(androidManifest);
                        leng = 0;
                        if (perms != null && perms.length > 0) {
                            leng = 0 + perms.length;
                        }
                        if (prov != null && prov.length > 0) {
                            leng += prov.length;
                        }
                        stringsForChange = new String[leng];
                        k = 0;
                        if (perms != null && perms.length > 0) {
                            for (String contains22 : perms) {
                                stringsForChange[k] = contains22;
                                k++;
                            }
                        }
                        if (prov != null && prov.length > 0) {
                            for (String contains222 : prov) {
                                stringsForChange[k] = contains222;
                                k++;
                            }
                        }
                        if (!new AxmlExample().changePackageName(androidManifest, packageName, newPackageName)) {
                            androidManifest.delete();
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                Iterator it;
                File cl;
                File filepatch;
                if (options.contains("DeepWork")) {
                    if (classesFiles == null || classesFiles.size() == 0) {
                        throw new FileNotFoundException();
                    }
                    filestopatch.clear();
                    it = classesFiles.iterator();
                    while (it.hasNext()) {
                        cl = (File) it.next();
                        if (cl.exists()) {
                            filestopatch.add(cl);
                        } else {
                            throw new FileNotFoundException();
                        }
                    }
                    it = filestopatch.iterator();
                    while (it.hasNext()) {
                        filepatch = (File) it.next();
                        Utils.sendFromRoot("String analysis.");
                        print.println("String analysis.");
                        if (Utils.changePackageNameIds(filepatch.getAbsolutePath(), packageName, newPackageName) > 0) {
                            System.out.println("classes.dex changed!");
                        }
                        if (Utils.replaceStrings(filepatch.getAbsolutePath(), stringsForChange) > 0) {
                            System.out.println("global classes.dex changed!");
                        }
                        Utils.sendFromRoot("Analise Results:");
                        Utils.fixadler(filepatch);
                    }
                    if (resourcesFiles_temp == null || resourcesFiles_temp.size() == 0) {
                        throw new FileNotFoundException();
                    }
                    filestopatch.clear();
                    it = resourcesFiles_temp.iterator();
                    while (it.hasNext()) {
                        cl = (File) it.next();
                        if (cl.exists()) {
                            filestopatch.add(cl);
                        } else {
                            throw new FileNotFoundException();
                        }
                    }
                    it = filestopatch.iterator();
                    while (it.hasNext()) {
                        filepatch = (File) it.next();
                        if (Utils.replaceStrings(filepatch.getAbsolutePath(), stringsForChange) > 0) {
                            System.out.println("resource changed!");
                            resourcesFiles.add(filepatch);
                        }
                    }
                } else if (classesFiles == null || classesFiles.size() == 0) {
                    throw new FileNotFoundException();
                } else {
                    filestopatch.clear();
                    it = classesFiles.iterator();
                    while (it.hasNext()) {
                        cl = (File) it.next();
                        if (cl.exists()) {
                            filestopatch.add(cl);
                        } else {
                            throw new FileNotFoundException();
                        }
                    }
                    it = filestopatch.iterator();
                    while (it.hasNext()) {
                        filepatch = (File) it.next();
                        Utils.sendFromRoot("String analysis.");
                        print.println("String analysis.");
                        if (Utils.replaceStrings(filepatch.getAbsolutePath(), stringsForChange) > 0) {
                            System.out.println("classes.dex changed!");
                        }
                        Utils.sendFromRoot("Analise Results:");
                        Utils.fixadler(filepatch);
                    }
                }
                Utils.sendFromRoot("Analise Results:");
                Utils.sendFromRoot("Optional Steps After Patch:");
                result = logOutputStream.allresult;
                return;
            }
            throw new FileNotFoundException();
        } catch (Exception e42) {
            e42.printStackTrace();
        }
    }

    public static void unzipSD(File apk, boolean skipClasses) {
        try {
            FileInputStream fin = new FileInputStream(apk);
            ZipInputStream zin = new ZipInputStream(fin);
            boolean classesdex = false;
            while (true) {
                ZipEntry ze = zin.getNextEntry();
                if (ze != null) {
                    FileOutputStream fout;
                    byte[] buffer;
                    int length;
                    if (!skipClasses && ze.getName().startsWith("classes") && ze.getName().endsWith(".dex") && !ze.getName().contains(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                        fout = new FileOutputStream(sddir + "/Modified/" + ze.getName());
                        buffer = new byte[Util.BLOCK_HEADER_SIZE_MAX];
                        while (true) {
                            length = zin.read(buffer);
                            if (length == -1) {
                                break;
                            }
                            fout.write(buffer, 0, length);
                        }
                        classesFiles.add(new File(sddir + "/Modified/" + ze.getName()));
                        classesdex = true;
                    }
                    if (ze.getName().equals("AndroidManifest.xml")) {
                        fout = new FileOutputStream(sddir + "/Modified/" + "AndroidManifest.xml");
                        buffer = new byte[Util.BLOCK_HEADER_SIZE_MAX];
                        while (true) {
                            length = zin.read(buffer);
                            if (length == -1) {
                                break;
                            }
                            fout.write(buffer, 0, length);
                        }
                        if (classesdex) {
                            zin.closeEntry();
                            fout.close();
                        }
                    }
                } else {
                    zin.close();
                    fin.close();
                    return;
                }
            }
        } catch (Exception e) {
            try {
                ZipFile zipFile = new ZipFile(apk);
                zipFile.extractFile("classes.dex", sddir + "/Modified/");
                classesFiles.add(new File(sddir + "/Modified/" + "classes.dex"));
                zipFile.extractFile("AndroidManifest.xml", sddir + "/Modified/");
            } catch (ZipException e1) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e1);
                Utils.sendFromRoot("Exception e1" + e.toString());
            } catch (Exception e12) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e12);
                Utils.sendFromRoot("Exception e1" + e.toString());
            }
            Utils.sendFromRoot("Decompressunzip " + e);
        }
    }

    public static void clearTempSD() {
        try {
            File tempdex = new File(sddir + "/Modified/classes.dex.apk");
            if (tempdex.exists()) {
                tempdex.delete();
            }
        } catch (Exception e) {
            Utils.sendFromRoot("" + e.toString());
        }
    }
}
