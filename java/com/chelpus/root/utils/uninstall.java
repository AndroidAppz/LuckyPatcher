package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.util.InternalZipConstants;

public class uninstall {
    public static String datadir = "/data/data/";
    public static String dirapp = "/data/app/";
    public static boolean odexpatch = false;
    public static boolean system = false;

    public static void main(String[] paramArrayOfString) {
        try {
            Utils.startRootJava(new Object() {
            });
            dirapp = paramArrayOfString[1];
            system = true;
            datadir = paramArrayOfString[2];
            File appapk = new File(dirapp);
            File appodex = new File(Utils.getPlaceForOdex(dirapp, true));
            System.out.println("Start getLibs!");
            ArrayList<String> libs = getLibs(appapk);
            System.out.println("Start delete lib!");
            if (!libs.isEmpty()) {
                Iterator it = libs.iterator();
                while (it.hasNext()) {
                    File libfile = new File("/system/lib/" + ((String) it.next()));
                    if (libfile.exists()) {
                        libfile.delete();
                    }
                }
            }
            System.out.println("Start delete data directory!");
            Utils utils = new Utils("uninstall system");
            try {
                System.out.println("Start delete dir!");
                utils.deleteFolder(new File(datadir));
                utils.deleteFolder(new File(datadir.replace("/data/data/", "/dbdata/databases/")));
            } catch (Exception e) {
                System.out.println("LuckyPatcher Error uninstall: " + e);
                e.printStackTrace();
            }
            System.out.println("Start delete dc!");
            try {
                File dc_file = Utils.getFileDalvikCache(dirapp);
                if (dc_file != null) {
                    dc_file.delete();
                    System.out.println("Dalvik-cache " + dc_file + " deleted.");
                } else {
                    System.out.println("dalvik-cache not found.");
                }
                System.out.println("Start delete odex.");
                if (appodex.exists()) {
                    appodex.delete();
                }
            } catch (Exception e2) {
                System.out.println("Error: Exception e" + e2.toString());
                e2.printStackTrace();
            }
            System.out.println("Start delete apk!");
            File apk = new File(dirapp);
            if (apk.exists()) {
                apk.delete();
                System.out.println("Delete apk:" + dirapp);
            }
        } catch (Exception e22) {
            System.out.println("LuckyPatcher Error uninstall: " + e22);
            e22.printStackTrace();
        }
        Utils.exitFromRootJava();
    }

    public static ArrayList<String> getLibs(File apk) {
        ZipInputStream in;
        String filename;
        Throwable th;
        ZipInputStream in2 = null;
        FileInputStream fin = null;
        ArrayList<String> libs = new ArrayList();
        String[] tail;
        try {
            FileInputStream fin2 = new FileInputStream(apk);
            try {
                in = new ZipInputStream(fin2);
            } catch (IOException e) {
                fin = fin2;
                try {
                    for (FileHeader fileHeader : new ZipFile(apk).getFileHeaders()) {
                        if (!fileHeader.getFileName().endsWith(".so")) {
                            System.out.println(fileHeader.getFileName());
                            tail = fileHeader.getFileName().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
                            filename = tail[tail.length - 1];
                            libs.add(filename);
                            libs.add(filename);
                        }
                    }
                } catch (ZipException e1) {
                    e1.printStackTrace();
                } catch (Exception e12) {
                    e12.printStackTrace();
                } catch (Throwable th2) {
                    th = th2;
                    if (in2 != null) {
                        try {
                            in2.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (fin != null) {
                        try {
                            fin.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
                if (in2 != null) {
                    try {
                        in2.close();
                    } catch (IOException e4) {
                    }
                }
                if (fin != null) {
                    try {
                        fin.close();
                    } catch (IOException e5) {
                    }
                }
                return libs;
            } catch (Throwable th3) {
                th = th3;
                fin = fin2;
                if (in2 != null) {
                    in2.close();
                }
                if (fin != null) {
                    fin.close();
                }
                throw th;
            }
            try {
                for (ZipEntry entry = in.getNextEntry(); entry != null; entry = in.getNextEntry()) {
                    if (entry.getName().startsWith("lib/")) {
                        tail = entry.getName().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
                        filename = tail[tail.length - 1];
                        if (!(!libs.isEmpty() || filename.equals("") || filename.contains("libjnigraphics.so"))) {
                            libs.add(filename);
                        }
                        if (!(libs.contains(filename) || filename.equals("") || filename.contains("libjnigraphics.so"))) {
                            libs.add(filename);
                        }
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e6) {
                    }
                }
                if (fin2 != null) {
                    try {
                        fin2.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (IOException e8) {
                fin = fin2;
                in2 = in;
                for (FileHeader fileHeader2 : new ZipFile(apk).getFileHeaders()) {
                    if (!fileHeader2.getFileName().endsWith(".so")) {
                        System.out.println(fileHeader2.getFileName());
                        tail = fileHeader2.getFileName().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
                        filename = tail[tail.length - 1];
                        libs.add(filename);
                        libs.add(filename);
                    }
                }
                if (in2 != null) {
                    in2.close();
                }
                if (fin != null) {
                    fin.close();
                }
                return libs;
            } catch (Throwable th4) {
                th = th4;
                fin = fin2;
                in2 = in;
                if (in2 != null) {
                    in2.close();
                }
                if (fin != null) {
                    fin.close();
                }
                throw th;
            }
        } catch (IOException e9) {
            for (FileHeader fileHeader22 : new ZipFile(apk).getFileHeaders()) {
                if (!fileHeader22.getFileName().endsWith(".so")) {
                    System.out.println(fileHeader22.getFileName());
                    tail = fileHeader22.getFileName().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
                    filename = tail[tail.length - 1];
                    if (!(!libs.isEmpty() || filename.equals("") || filename.contains("libjnigraphics.so"))) {
                        libs.add(filename);
                    }
                    if (!(libs.contains(filename) || filename.equals("") || filename.contains("libjnigraphics.so"))) {
                        libs.add(filename);
                    }
                }
            }
            if (in2 != null) {
                in2.close();
            }
            if (fin != null) {
                fin.close();
            }
            return libs;
        }
        return libs;
    }
}
