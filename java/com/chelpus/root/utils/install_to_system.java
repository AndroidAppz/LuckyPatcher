package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.util.InternalZipConstants;
import org.tukaani.xz.common.Util;

public class install_to_system {
    public static String CPU_ABI = "";
    public static String CPU_ABI2 = "";
    public static String appfile = "/sdcard/app.apk";
    public static String datadir = "/data/data/";
    public static String pkgName = "";
    public static String toolsfiles = "";

    public static class Decompress {
        private String _location;
        private String _zipFile;

        public Decompress(String zipFile, String location) {
            this._zipFile = zipFile;
            this._location = location;
            _dirChecker("");
        }

        public void unzip() {
            try {
                FileInputStream fin = new FileInputStream(this._zipFile);
                ZipInputStream zipInputStream = new ZipInputStream(fin);
                while (true) {
                    ZipEntry ze = zipInputStream.getNextEntry();
                    if (ze == null) {
                        zipInputStream.close();
                        fin.close();
                        return;
                    } else if (ze.isDirectory()) {
                        _dirChecker(ze.getName());
                    } else if (ze.getName().endsWith(".so") && !ze.getName().contains("libjnigraphics.so")) {
                        String[] tail = ze.getName().split("\\/+");
                        String data_dir = "";
                        for (int i = 0; i < tail.length - 1; i++) {
                            if (!tail[i].equals("")) {
                                data_dir = data_dir + InternalZipConstants.ZIP_FILE_SEPARATOR + tail[i];
                            }
                        }
                        _dirChecker(data_dir);
                        FileOutputStream fout = new FileOutputStream(this._location + ze.getName());
                        byte[] buffer = new byte[Util.BLOCK_HEADER_SIZE_MAX];
                        while (true) {
                            int length = zipInputStream.read(buffer);
                            if (length == -1) {
                                break;
                            }
                            fout.write(buffer, 0, length);
                        }
                        zipInputStream.closeEntry();
                        fout.close();
                    }
                }
            } catch (Exception e) {
                System.out.println("Decompressunzip " + e);
                e.printStackTrace();
                try {
                    ZipFile zipFile = new ZipFile(this._zipFile);
                    for (FileHeader fileHeader : zipFile.getFileHeaders()) {
                        if (fileHeader.getFileName().endsWith(".so") && !fileHeader.getFileName().contains("libjnigraphics.so")) {
                            System.out.println(fileHeader.getFileName());
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

        private void _dirChecker(String dir) {
            File f = new File(this._location + dir);
            if (!f.isDirectory()) {
                f.mkdirs();
            }
        }
    }

    public static void main(String[] paramArrayOfString) {
        boolean nospace = false;
        Utils.startRootJava(new Object() {
        });
        System.out.println(paramArrayOfString[1]);
        appfile = paramArrayOfString[1];
        datadir = paramArrayOfString[2];
        toolsfiles = paramArrayOfString[3];
        pkgName = paramArrayOfString[0];
        CPU_ABI = paramArrayOfString[4];
        CPU_ABI2 = paramArrayOfString[5];
        String system_app_dir = "/system/app/";
        try {
            if (new File("/system/priv-app").exists() && new File("/system/priv-app").list() != null) {
                system_app_dir = "/system/priv-app/";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Iterator it;
            if (listAppsFragment.api >= 21) {
                system_app_dir = "/system/priv-app/" + pkgName + InternalZipConstants.ZIP_FILE_SEPARATOR;
                if (!new File(system_app_dir).exists()) {
                    new File(system_app_dir).mkdirs();
                    Utils.cmdParam("chmod", "755", "/system/priv-app/" + pkgName);
                }
            }
            File appapk = new File(appfile);
            ArrayList<File> libs = getLibs(appapk);
            String libDir = "/system/lib/";
            if (listAppsFragment.api >= 21) {
                if (CPU_ABI.toLowerCase().contains("x86") || CPU_ABI2.contains("x86")) {
                    libDir = "/system/priv-app/" + pkgName + "/lib/x86/";
                }
                if (CPU_ABI.toLowerCase().contains("arm") || CPU_ABI2.contains("arm")) {
                    libDir = "/system/priv-app/" + pkgName + "/lib/arm/";
                }
            }
            if (libs.size() > 0) {
                it = libs.iterator();
                while (it.hasNext()) {
                    File lib = (File) it.next();
                    try {
                        if (!new File(libDir).exists()) {
                            new File(libDir).mkdirs();
                            Utils.cmdParam("chmod", "755", "/system/priv-app/" + pkgName + "/lib");
                        }
                        Utils.setPermissionDir("/system/priv-app/" + pkgName, libDir, "755", true);
                        Utils.copyFile(lib, new File(libDir + lib.getName()));
                        run_all("chmod 0644 " + libDir + lib.getName());
                        run_all("chown 0.0 " + libDir + lib.getName());
                        run_all("chown 0:0 " + libDir + lib.getName());
                        if (lib.length() == new File(libDir + lib.getName()).length()) {
                            System.out.println("LuckyPatcher: copy lib " + libDir + lib.getName());
                        } else {
                            it = libs.iterator();
                            while (it.hasNext()) {
                                new File(libDir + ((File) it.next()).getName()).delete();
                            }
                            System.out.println("In /system space not found!");
                            nospace = true;
                        }
                    } catch (Exception e2) {
                        it = libs.iterator();
                        while (it.hasNext()) {
                            new File(libDir + ((File) it.next()).getName()).delete();
                        }
                        System.out.println("In /system space not found!");
                        nospace = true;
                    }
                }
            }
            if (nospace) {
                new File(system_app_dir + pkgName + ".apk").delete();
            } else {
                try {
                    if (new File(system_app_dir + pkgName + ".odex").exists()) {
                        new File(system_app_dir + pkgName + ".odex").delete();
                    }
                    String destination = system_app_dir + pkgName + ".apk";
                    if (!Utils.dalvikvm_copyFile(listAppsFragment.toolfilesdir, appfile, destination)) {
                        System.out.println("In /system space not found!");
                        new File(system_app_dir + pkgName + ".apk").delete();
                    }
                } catch (Exception e3) {
                    System.out.println("In /system space not found!");
                    new File(system_app_dir + pkgName + ".apk").delete();
                    e3.printStackTrace();
                }
                if (appapk.length() == new File(system_app_dir + pkgName + ".apk").length()) {
                    run_all("chmod 0644 " + system_app_dir + pkgName + ".apk");
                    run_all("chown 0.0 " + system_app_dir + pkgName + ".apk");
                    run_all("chown 0:0 " + system_app_dir + pkgName + ".apk");
                } else {
                    new File(system_app_dir + pkgName + ".apk").delete();
                    System.out.println("In /system space not found!");
                    it = libs.iterator();
                    while (it.hasNext()) {
                        new File(libDir + ((File) it.next()).getName()).delete();
                    }
                }
            }
            File tmp = new File(toolsfiles + "/tmp");
            if (tmp.exists()) {
                Utils utils = new Utils("");
                try {
                    utils.deleteFolder(tmp);
                    utils.deleteFolder(new File(datadir));
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            File dalvik = Utils.getFileDalvikCache(system_app_dir + pkgName + ".apk");
            if (dalvik != null) {
                dalvik.delete();
            }
        } catch (Exception e32) {
            System.out.println("LuckyPatcher Error move to System: " + e32);
            e32.printStackTrace();
        }
        Utils.exitFromRootJava();
    }

    public static ArrayList<File> getLibs(File appapk) {
        ArrayList<File> libs = new ArrayList();
        String unzipLocation = toolsfiles + "/tmp/";
        File tmp = new File(toolsfiles + "/tmp/lib/");
        if (tmp.exists()) {
            try {
                new Utils("").deleteFolder(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!tmp.exists()) {
            new Decompress(appapk.getAbsolutePath(), unzipLocation).unzip();
        }
        File arh = new File(toolsfiles + "/tmp/lib");
        if (arh.exists()) {
            File[] files = arh.listFiles();
            for (File dirlibs : files) {
                System.out.println("LuckyPatcher: directory in lib found - " + dirlibs);
                if (dirlibs.isDirectory() && dirlibs.getName().equals(CPU_ABI)) {
                    System.out.println("LuckyPatcher: - " + dirlibs + " " + dirlibs.getName() + " " + CPU_ABI);
                    for (File lib : dirlibs.listFiles()) {
                        if (lib.isFile() && lib.toString().endsWith(".so")) {
                            System.out.println(lib);
                            libs.add(lib);
                            System.out.println("LuckyPatcher: found lib file - " + CPU_ABI + " " + lib);
                        }
                    }
                }
            }
            System.out.println(libs.size());
            if (libs.size() == 0) {
                for (File dirlibs2 : files) {
                    if (dirlibs2.isDirectory() && dirlibs2.getName().equals(CPU_ABI2)) {
                        for (File lib2 : dirlibs2.listFiles()) {
                            if (lib2.isFile() && lib2.getName().endsWith(".so")) {
                                libs.add(lib2);
                                System.out.println("LuckyPatcher: found lib file - " + CPU_ABI2 + " " + lib2);
                            }
                        }
                    }
                }
            }
        }
        return libs;
    }

    private static void run_all(String cmd) {
        try {
            cmd = new String(cmd.getBytes(), "ISO-8859-1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        try {
            Process localProcess = Runtime.getRuntime().exec(cmd + "\n");
            localProcess.waitFor();
            localProcess.destroy();
        } catch (Exception e) {
        }
        try {
            localProcess = Runtime.getRuntime().exec("toolbox " + cmd + "\n");
            localProcess.waitFor();
            localProcess.destroy();
        } catch (Exception e2) {
        }
        try {
            localProcess = Runtime.getRuntime().exec("/system/bin/failsafe/toolbox " + cmd + "\n");
            localProcess.waitFor();
            localProcess.destroy();
        } catch (Exception e3) {
        }
        try {
            localProcess = Runtime.getRuntime().exec("busybox " + cmd + "\n");
            localProcess.waitFor();
            localProcess.destroy();
        } catch (Exception e4) {
        }
        try {
            localProcess = Runtime.getRuntime().exec(toolsfiles + "/busybox " + cmd + "\n");
            localProcess.waitFor();
            localProcess.destroy();
        } catch (Exception e5) {
        }
    }
}
