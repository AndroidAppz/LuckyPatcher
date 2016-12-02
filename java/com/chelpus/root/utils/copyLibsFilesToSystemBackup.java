package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;

public class copyLibsFilesToSystemBackup {
    public static String index = "";
    public static String libDir = "";
    public static boolean nospace = false;
    public static String pkgName = "";
    public static String sys_apk_dir = "";

    public static void main(String[] paramArrayOfString) {
        ArrayList<String> libs;
        Iterator it;
        Utils.startRootJava(new Object() {
        });
        pkgName = paramArrayOfString[0];
        String dirData = paramArrayOfString[1];
        String dirApk = paramArrayOfString[2];
        sys_apk_dir = Utils.getDirs(new File(paramArrayOfString[3])).getAbsolutePath();
        String function = paramArrayOfString[4];
        if (function.equals("copyLibs")) {
            System.out.println("copyLibs");
            libDir = "/system/lib/";
            libs = getLibs(new File(dirData), dirApk);
            if (libs.size() > 0) {
                it = libs.iterator();
                while (it.hasNext()) {
                    File source = new File((String) it.next());
                    if (!new File(libDir).exists()) {
                        new File(libDir).mkdirs();
                    }
                    Utils.setPermissionDir(sys_apk_dir, sys_apk_dir + index, "755", true);
                    Utils.copyFile(source, new File(libDir + source.getName() + ".chelpus"));
                    run_all("chmod 0644 " + libDir + source.getName() + ".chelpus");
                    run_all("chown 0.0 " + libDir + source.getName() + ".chelpus");
                    run_all("chown 0:0 " + libDir + source.getName() + ".chelpus");
                    if (source.length() == new File(libDir + source.getName() + ".chelpus").length()) {
                        System.out.println("LuckyPatcher: copy lib " + libDir + source.getName() + ".chelpus");
                    } else {
                        it = libs.iterator();
                        while (it.hasNext()) {
                            File source2 = new File((String) it.next());
                            if (listAppsFragment.api < 21) {
                                new File(libDir + source2.getName() + ".chelpus").delete();
                            } else if (libDir.startsWith("/system/priv-app/")) {
                                try {
                                    new Utils("").deleteFolder(new File(libDir));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        System.out.println("In /system space not found!");
                        nospace = true;
                    }
                }
            }
        }
        if (function.equals("replaceOldLibs")) {
            System.out.println("replaceOldLibs");
            libDir = "/system/lib/";
            if (listAppsFragment.api >= 21) {
                if (new File(sys_apk_dir + "/lib/x86").exists()) {
                    libDir = sys_apk_dir + "/lib/x86/";
                }
                if (new File(sys_apk_dir + "/lib/x86_64").exists()) {
                    libDir = sys_apk_dir + "/lib/x86_64/";
                }
                if (new File(sys_apk_dir + "/lib/arm").exists()) {
                    libDir = sys_apk_dir + "/lib/arm/";
                }
                if (new File(sys_apk_dir + "/lib/arm64").exists()) {
                    libDir = sys_apk_dir + "/lib/arm64/";
                }
                if (new File(sys_apk_dir + "/lib/mips").exists()) {
                    libDir = sys_apk_dir + "/lib/mips/";
                }
            }
            ArrayList<File> libs2 = new ArrayList();
            File[] files = new File(libDir).listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".chelpus")) {
                        System.out.println("Replace system lib:" + file.getAbsolutePath().replace(".chelpus", ""));
                        new File(file.getAbsolutePath().replace(".chelpus", "")).delete();
                        file.renameTo(new File(file.getAbsolutePath().replace(".chelpus", "")));
                    }
                }
            }
            removeLibs(new File(dirData), dirApk);
        }
        if (function.equals("deleteBigLibs")) {
            System.out.println("deleteBigLibs");
            libDir = "/system/lib/";
            libs = getLibs(new File(dirData), dirApk);
            if (libs.size() > 0) {
                it = libs.iterator();
                while (it.hasNext()) {
                    new File(libDir + new File((String) it.next()).getName() + ".chelpus").delete();
                }
            }
        }
        Utils.exitFromRootJava();
    }

    public static ArrayList<String> getLibs(File datadir, String apk_file) {
        ArrayList<String> libs = new ArrayList();
        if (apk_file.startsWith("/mnt/")) {
            datadir = Utils.getDirs(new File(apk_file));
            Utils.remount(datadir.getAbsolutePath(), InternalZipConstants.WRITE_MODE);
            if (datadir.exists()) {
                for (String file : datadir.list()) {
                    System.out.println("LuckyPatcher: file found in data dir - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file);
                    if (new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file).isDirectory() && (datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file).equals(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + "lib")) {
                        for (String lib : new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file).list()) {
                            if (new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file + InternalZipConstants.ZIP_FILE_SEPARATOR + lib).isFile() && !lib.contains("libjnigraphics.so")) {
                                libs.add(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file + InternalZipConstants.ZIP_FILE_SEPARATOR + lib);
                                System.out.println("LuckyPatcher: found lib - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file + InternalZipConstants.ZIP_FILE_SEPARATOR + lib);
                            }
                        }
                    }
                }
            }
        } else if (listAppsFragment.api >= 21) {
            datadir = Utils.getDirs(new File(apk_file));
            if (datadir.exists()) {
                for (File file2 : datadir.listFiles()) {
                    System.out.println("LuckyPatcher: file found in data dir - " + file2 + " is dir:" + file2.isDirectory());
                    if (file2.isDirectory() && file2.getAbsolutePath().equals(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + "lib")) {
                        File[] dirs = file2.listFiles();
                        if (dirs != null && dirs.length > 0) {
                            for (File dir : dirs) {
                                File[] libs_files = dir.listFiles();
                                if (libs_files != null && libs_files.length > 0) {
                                    for (File lib2 : libs_files) {
                                        libs.add(lib2.getAbsolutePath());
                                        index = Utils.getDirs(lib2).getAbsolutePath().replace(datadir.getAbsolutePath(), "");
                                        libDir = sys_apk_dir + index + InternalZipConstants.ZIP_FILE_SEPARATOR;
                                        System.out.println("libdir" + libDir);
                                        new File(libDir).mkdirs();
                                        System.out.println("LuckyPatcher: found lib - " + lib2.getAbsolutePath());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (datadir.exists()) {
            for (String file3 : datadir.list()) {
                System.out.println("LuckyPatcher: file found in data dir - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3 + "id dir:" + new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3).isDirectory());
                if (new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3).isDirectory() && (datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3).equals(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + "lib")) {
                    for (String lib3 : new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3).list()) {
                        if (new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib3).isFile() && !lib3.contains("libjnigraphics.so")) {
                            libs.add(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib3);
                            System.out.println("LuckyPatcher: found lib - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib3 + " is dir:" + new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3).isDirectory());
                        }
                    }
                }
            }
        }
        return libs;
    }

    public static void removeLibs(File datadir, String apk_file) {
        int i = 0;
        int length;
        if (listAppsFragment.api >= 21) {
            System.out.println("remove libs in data for api 21");
            datadir = Utils.getDirs(new File(apk_file));
            if (Utils.getDirs(new File(apk_file)).exists()) {
                File[] files = datadir.listFiles();
                length = files.length;
                while (i < length) {
                    File file = files[i];
                    System.out.println("LuckyPatcher: file found in data dir - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file);
                    if (file.isDirectory() && file.getAbsolutePath().endsWith("/lib")) {
                        try {
                            new Utils("").deleteFolder(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    i++;
                }
            }
        } else if (!apk_file.startsWith("/mnt/")) {
            System.out.println("remove libs in data");
            if (datadir.exists()) {
                for (String file2 : datadir.list()) {
                    System.out.println("LuckyPatcher: file found in data dir - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2);
                    if (new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2).isDirectory() && (datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2).equals(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + "lib")) {
                        String[] liblist = new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2).list();
                        if (liblist != null && liblist.length > 0) {
                            for (String lib : liblist) {
                                if (new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib).isFile()) {
                                    new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib).delete();
                                    System.out.println("LuckyPatcher: remove lib - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib);
                                }
                            }
                        }
                        System.out.println("delete dir" + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2);
                        new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2).delete();
                    } else {
                        System.out.println("file not dir lib" + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2 + " is File:" + new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2).isFile());
                        if ((datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2).equals(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + "lib")) {
                            System.out.println("delete file" + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2);
                            new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2).delete();
                        }
                    }
                }
            }
        }
    }

    private static void run_all(String cmd) {
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
            localProcess = Runtime.getRuntime().exec(listAppsFragment.toolfilesdir + "/busybox " + cmd + "\n");
            localProcess.waitFor();
            localProcess.destroy();
        } catch (Exception e5) {
        }
    }
}
