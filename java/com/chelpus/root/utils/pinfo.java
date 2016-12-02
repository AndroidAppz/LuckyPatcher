package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;

public class pinfo {
    public static ArrayList<File> classesFiles = new ArrayList();
    public static String toolfilesdir = "";

    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        String source_file_v = paramArrayOfString[0];
        toolfilesdir = paramArrayOfString[1];
        String uid = paramArrayOfString[2];
        String odex;
        File dc;
        if (paramArrayOfString[3] == null || !paramArrayOfString[3].contains("recovery")) {
            unzipART(new File(toolfilesdir + "/p.apk"));
            odex = Utils.getOdexForCreate(source_file_v, uid);
            dc = Utils.getFileDalvikCache(source_file_v);
            if (dc != null && dc.exists()) {
                dc.renameTo(new File(dc.getAbsolutePath() + "_lpbackup"));
                Utils.dalvikvm_copyFile(toolfilesdir, dc.getAbsolutePath() + "_lpbackup", dc.getAbsolutePath());
                Utils.run_all_no_root("chmod", "777", dc.getAbsolutePath());
                Utils.run_all_no_root("chown", "0:0", dc.getAbsolutePath());
                Utils.run_all_no_root("chown", "0.0", dc.getAbsolutePath());
            }
            Utils.remount(odex, InternalZipConstants.WRITE_MODE);
            if (new File(odex).exists()) {
                new File(odex).renameTo(new File(odex + "_lpbackup"));
            }
            Utils.create_ODEX_root(toolfilesdir, classesFiles, source_file_v, uid, odex);
        } else {
            try {
                odex = Utils.getOdexForCreate(source_file_v, uid);
                Utils.remount(odex, InternalZipConstants.WRITE_MODE);
                dc = Utils.getFileDalvikCache(source_file_v);
                File b_dc = null;
                if (dc != null) {
                    b_dc = new File(dc.getAbsolutePath() + "_lpbackup");
                }
                if (b_dc == null || !b_dc.exists()) {
                    try {
                        Utils.create_DC_root(toolfilesdir, source_file_v, uid, Utils.getOdexForCreate(source_file_v, uid));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    b_dc.renameTo(dc);
                    new File(odex).delete();
                }
                if (new File(odex + "_lpbackup").exists()) {
                    new File(odex + "_lpbackup").renameTo(new File(odex));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Utils.exitFromRootJava();
    }

    public static void unzipART(File apk) {
        boolean found2 = false;
        try {
            FileInputStream fin = new FileInputStream(apk);
            ZipInputStream zipInputStream = new ZipInputStream(fin);
            for (ZipEntry ze = zipInputStream.getNextEntry(); ze != null && true; ze = zipInputStream.getNextEntry()) {
                String haystack = ze.getName();
                if (haystack.startsWith("classes") && haystack.endsWith(".dex") && !haystack.contains(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    FileOutputStream fout = new FileOutputStream(toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack);
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
                    classesFiles.add(new File(toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack));
                    Utils.cmdParam("chmod", "777", toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack);
                }
                if (haystack.equals("AndroidManifest.xml")) {
                    FileOutputStream fout2 = new FileOutputStream(toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
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
                    Utils.cmdParam("chmod", "777", toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
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
                zipFile.extractFile("classes.dex", toolfilesdir);
                classesFiles.add(new File(toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex"));
                Utils.cmdParam("chmod", "777", toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex");
                zipFile.extractFile("AndroidManifest.xml", toolfilesdir);
                Utils.cmdParam("chmod", "777", toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
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
}
