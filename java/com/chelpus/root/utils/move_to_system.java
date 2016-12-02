package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;

public class move_to_system {
    public static String datadir = "/data/data/";
    public static String dirapp = "/data/app/";
    public static String index = "";
    public static String libDir = "";
    public static String pkgName = "";
    public static String toolsfiles = "";

    public static void main(String[] paramArrayOfString) {
        boolean nospace = false;
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
            Utils.startRootJava(new Object() {
            });
            dirapp = paramArrayOfString[1];
            datadir = paramArrayOfString[2];
            toolsfiles = paramArrayOfString[3];
            pkgName = paramArrayOfString[0];
            File appapk = new File(dirapp);
            if (listAppsFragment.api >= 21) {
                system_app_dir = "/system/priv-app/" + pkgName + InternalZipConstants.ZIP_FILE_SEPARATOR;
                if (!new File(system_app_dir).exists()) {
                    new File(system_app_dir).mkdirs();
                    Utils.cmdParam("chmod", "755", "/system/priv-app/" + pkgName);
                }
            }
            libDir = "/system/lib/";
            ArrayList<String> libs = getLibs(new File(datadir), dirapp, listAppsFragment.api);
            if (libs.size() > 0) {
                it = libs.iterator();
                while (it.hasNext()) {
                    File source = new File((String) it.next());
                    if (!new File(libDir).exists()) {
                        new File(libDir).mkdirs();
                    }
                    Utils.setPermissionDir("/system/priv-app/" + pkgName, "/system/priv-app/" + pkgName + index, "755", true);
                    Utils.copyFile(source, new File(libDir + source.getName()));
                    run_all("chmod 0644 " + libDir + source.getName());
                    run_all("chown 0.0 " + libDir + source.getName());
                    run_all("chown 0:0 " + libDir + source.getName());
                    if (source.length() == new File(libDir + source.getName()).length()) {
                        System.out.println("LuckyPatcher: copy lib " + libDir + source.getName());
                    } else {
                        it = libs.iterator();
                        while (it.hasNext()) {
                            File source2 = new File((String) it.next());
                            if (listAppsFragment.api < 21) {
                                new File(libDir + source2.getName()).delete();
                            } else if (libDir.startsWith("/system/priv-app/")) {
                                new Utils("").deleteFolder(new File(libDir));
                            }
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
                    String source3 = dirapp;
                    Utils.cmdParam("dd", "if=" + source3, "of=" + destination);
                    if (!(new File(destination).exists() && appapk.length() == new File(system_app_dir + pkgName + ".apk").length())) {
                        Utils.cmdParam("toolbox", "dd", "if=" + source3, "of=" + destination);
                    }
                    if (!(new File(destination).exists() && appapk.length() == new File(system_app_dir + pkgName + ".apk").length())) {
                        Utils.cmdParam("busybox", "dd", "if=" + source3, "of=" + destination);
                    }
                    if (!(new File(destination).exists() && appapk.length() == new File(system_app_dir + pkgName + ".apk").length())) {
                        Utils.cmdParam(toolsfiles + "/busybox", "dd", "if=" + source3, "of=" + destination);
                    }
                    if (!(new File(destination).exists() && appapk.length() == new File(system_app_dir + pkgName + ".apk").length())) {
                        Utils.cmdParam(toolsfiles + "/busybox", "cp", "-fp", source3, destination);
                    }
                    if (!(new File(destination).exists() && appapk.length() == new File(system_app_dir + pkgName + ".apk").length())) {
                        Utils.copyFile(appapk, new File(system_app_dir + pkgName + ".apk"));
                    }
                } catch (Exception e2) {
                    System.out.println("In /system space not found!");
                    new File(system_app_dir + pkgName + ".apk").delete();
                    e2.printStackTrace();
                }
                if (appapk.length() == new File(system_app_dir + pkgName + ".apk").length()) {
                    if (dirapp.startsWith("/mnt/")) {
                        Utils.cmdParam("pm", "uninstall", pkgName);
                    } else {
                        appapk.delete();
                        try {
                            removeLibs(new File(datadir), dirapp, listAppsFragment.api);
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                    run_all("chmod 0644 " + system_app_dir + pkgName + ".apk");
                    run_all("chown 0.0 " + system_app_dir + pkgName + ".apk");
                    run_all("chown 0:0 " + system_app_dir + pkgName + ".apk");
                } else {
                    new File(system_app_dir + pkgName + ".apk").delete();
                    System.out.println("In /system space not found!");
                    it = libs.iterator();
                    while (it.hasNext()) {
                        new File(libDir + new File((String) it.next()).getName()).delete();
                    }
                }
            }
        } catch (Exception e222) {
            System.out.println("LuckyPatcher Error move to System: " + e222);
            e222.printStackTrace();
        }
        Utils.exitFromRootJava();
    }

    public static ArrayList<String> getLibs(File datadir, String apk_file, int api) {
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
        } else if (api >= 21) {
            datadir = Utils.getDirs(new File(apk_file));
            if (datadir.exists()) {
                for (File file2 : datadir.listFiles()) {
                    System.out.println("LuckyPatcher: file found in data dir - " + file2);
                    if (file2.isDirectory() && file2.getAbsolutePath().equals(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + "lib")) {
                        File[] dirs = file2.listFiles();
                        if (dirs != null && dirs.length > 0) {
                            for (File dir : dirs) {
                                File[] libs_files = dir.listFiles();
                                if (libs_files != null && libs_files.length > 0) {
                                    for (File lib2 : libs_files) {
                                        libs.add(lib2.getAbsolutePath());
                                        index = Utils.getDirs(lib2).getAbsolutePath().replace(datadir.getAbsolutePath(), "");
                                        libDir = "/system/priv-app/" + pkgName + index + InternalZipConstants.ZIP_FILE_SEPARATOR;
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
                System.out.println("LuckyPatcher: file found in data dir - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3);
                if (new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3).isDirectory() && (datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3).equals(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + "lib")) {
                    for (String lib3 : new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3).list()) {
                        if (new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib3).isFile() && !lib3.contains("libjnigraphics.so")) {
                            libs.add(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib3);
                            System.out.println("LuckyPatcher: found lib - " + datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file3 + InternalZipConstants.ZIP_FILE_SEPARATOR + lib3);
                        }
                    }
                }
            }
        }
        return libs;
    }

    public static void removeLibs(File datadir, String apk_file, int api) {
        int i = 0;
        int length;
        if (api >= 21) {
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
        } else if (!apk_file.startsWith("/mnt/") && datadir.exists()) {
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
                    new File(datadir + InternalZipConstants.ZIP_FILE_SEPARATOR + file2).delete();
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
            localProcess = Runtime.getRuntime().exec(toolsfiles + "/busybox " + cmd + "\n");
            localProcess.waitFor();
            localProcess.destroy();
        } catch (Exception e5) {
        }
    }
}
