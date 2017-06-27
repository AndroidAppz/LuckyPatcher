package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.LogOutputStream;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;

public class integrate_dalvik_code {
    public static boolean ART = false;
    public static String apk_on_sd = "";
    public static ArrayList<File> classesFiles = new ArrayList();
    public static String dir = "/sdcard/";
    public static String dirapp = "/data/app/";
    public static PrintStream print;
    public static String result;
    public static String sddir = "/sdcard/";
    public static boolean system = false;
    public static String uid = "";

    public static void main(String[] paramArrayOfString) {
        LogOutputStream pout = new LogOutputStream("System.out");
        print = new PrintStream(pout);
        Utils.startRootJava(new Object() {
        });
        Utils.kill(paramArrayOfString[0]);
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
            if (paramArrayOfString[4] != null && paramArrayOfString[4].contains("ART")) {
                ART = true;
            }
            if (paramArrayOfString[5] != null) {
                uid = paramArrayOfString[5];
            }
            if (paramArrayOfString[6] != null) {
                apk_on_sd = paramArrayOfString[6];
            }
            Utils.sendFromRoot(paramArrayOfString[4]);
        } catch (NullPointerException e2) {
        } catch (Exception e3) {
        }
        try {
            if (listAppsFragment.startUnderRoot.booleanValue()) {
                Utils.remount(paramArrayOfString[1], "RW");
            }
            String packageName;
            Iterator it;
            if (!ART) {
                dir = paramArrayOfString[2];
                dirapp = paramArrayOfString[1];
                clearTemp();
                if (paramArrayOfString[3].equals("not_system")) {
                    system = false;
                }
                if (paramArrayOfString[3].equals("system")) {
                    system = true;
                }
                Utils.sendFromRoot("CLASSES mode create odex enabled.");
                packageName = paramArrayOfString[0];
                sddir = paramArrayOfString[2];
                clearTempSD();
                File apk = new File(apk_on_sd);
                Utils.sendFromRoot("Get classes.dex.");
                print.println("Get classes.dex.");
                unzipART(apk);
                if (classesFiles == null || classesFiles.size() == 0) {
                    throw new FileNotFoundException();
                }
                it = classesFiles.iterator();
                while (it.hasNext()) {
                    if (!((File) it.next()).exists()) {
                        throw new FileNotFoundException();
                    }
                }
                String odexstr = Utils.getPlaceForOdex(paramArrayOfString[1], true);
                File odexfile = new File(odexstr);
                if (odexfile.exists()) {
                    odexfile.delete();
                }
                odexfile = new File(odexstr.replace("-1", "-2"));
                if (odexfile.exists()) {
                    odexfile.delete();
                }
                odexfile = new File(odexstr.replace("-2", "-1"));
                if (odexfile.exists()) {
                    odexfile.delete();
                }
            } else if (ART) {
                packageName = paramArrayOfString[0];
                sddir = paramArrayOfString[2];
                clearTempSD();
                unzipART(new File(apk_on_sd));
                if (classesFiles == null || classesFiles.size() == 0) {
                    throw new FileNotFoundException();
                }
                it = classesFiles.iterator();
                while (it.hasNext()) {
                    if (!((File) it.next()).exists()) {
                        throw new FileNotFoundException();
                    }
                }
            }
        } catch (FileNotFoundException localFileNotFoundException) {
            Utils.sendFromRoot("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
            localFileNotFoundException.printStackTrace();
        } catch (Exception e4) {
            Utils.sendFromRoot("Exception e" + e4.toString());
            e4.printStackTrace();
            e4.printStackTrace();
        }
        clearTempSD();
        Utils.sendFromRoot("chelpus_return_" + Utils.create_ODEX_root(paramArrayOfString[2], classesFiles, paramArrayOfString[1], uid, Utils.getOdexForCreate(paramArrayOfString[1], uid)));
        Utils.exitFromRootJava();
        result = pout.allresult;
    }

    public static void clearTemp() {
        try {
            File tempdex = new File(dir + "/AndroidManifest.xml");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            if (classesFiles != null && classesFiles.size() > 0) {
                Iterator it = classesFiles.iterator();
                while (it.hasNext()) {
                    File cl = (File) it.next();
                    if (cl.exists()) {
                        cl.delete();
                    }
                }
            }
            tempdex = new File(dir + "/classes.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes.dex.apk");
            if (tempdex.exists()) {
                tempdex.delete();
            }
        } catch (Exception e) {
            Utils.sendFromRoot(e.toString());
        }
    }

    public static void unzipART(File apk) {
        boolean found2 = false;
        try {
            FileInputStream fin = new FileInputStream(apk);
            ZipInputStream zipInputStream = new ZipInputStream(fin);
            for (ZipEntry ze = zipInputStream.getNextEntry(); ze != null && true; ze = zipInputStream.getNextEntry()) {
                String haystack = ze.getName();
                if (haystack.toLowerCase().startsWith("classes") && haystack.endsWith(".dex") && !haystack.contains(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    FileOutputStream fout = new FileOutputStream(sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack);
                    byte[] buffer = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
                    while (true) {
                        int length = zipInputStream.read(buffer);
                        if (length == -1) {
                            break;
                        }
                        fout.write(buffer, 0, length);
                    }
                    zipInputStream.closeEntry();
                    fout.close();
                    classesFiles.add(new File(sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack));
                    Utils.cmdParam("chmod", "777", sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack);
                }
                if (haystack.equals("AndroidManifest.xml")) {
                    FileOutputStream fout2 = new FileOutputStream(sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
                    byte[] buffer2 = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
                    while (true) {
                        int length2 = zipInputStream.read(buffer2);
                        if (length2 == -1) {
                            break;
                        }
                        fout2.write(buffer2, 0, length2);
                    }
                    zipInputStream.closeEntry();
                    fout2.close();
                    Utils.cmdParam("chmod", "777", sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
                    found2 = true;
                }
                if (false && found2) {
                    break;
                }
            }
            zipInputStream.close();
            fin.close();
        } catch (Exception e) {
            try {
                ZipFile zipFile = new ZipFile(apk);
                zipFile.extractFile("classes.dex", sddir);
                classesFiles.add(new File(sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex"));
                Utils.cmdParam("chmod", "777", sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex");
                zipFile.extractFile("AndroidManifest.xml", sddir);
                Utils.cmdParam("chmod", "777", sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
            } catch (ZipException e1) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e1);
                Utils.sendFromRoot("Exception e1" + e.toString());
            } catch (Exception e12) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e12);
                Utils.sendFromRoot("Exception e1" + e.toString());
            }
            Utils.sendFromRoot("Exception e" + e.toString());
        }
    }

    public static void clearTempSD() {
        try {
            File tempdex = new File(sddir + "/Modified/classes.dex.apk");
            if (tempdex.exists()) {
                tempdex.delete();
            }
        } catch (Exception e) {
            Utils.sendFromRoot(e.toString());
        }
    }
}
