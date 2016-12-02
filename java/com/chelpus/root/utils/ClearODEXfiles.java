package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import net.lingala.zip4j.util.InternalZipConstants;

public class ClearODEXfiles {
    public static void main(String[] paramArrayOfString) {
        File[] appFiles;
        File odex;
        String toolfilesdir = paramArrayOfString[0];
        Utils.startRootJava(new Object() {
        });
        try {
            if (new File("/data/app").exists()) {
                for (File tail : new File("/data/app").listFiles()) {
                    if (listAppsFragment.api >= 21) {
                        if (tail.isDirectory()) {
                            appFiles = tail.listFiles();
                            if (appFiles != null && appFiles.length > 0) {
                                for (File inFile : appFiles) {
                                    if (inFile.isFile() && inFile.getAbsolutePath().endsWith(".apk")) {
                                        odex = new File(Utils.getPlaceForOdex(inFile.getAbsolutePath(), true));
                                        if (odex.exists() && inFile.getAbsoluteFile().toString().endsWith(".apk") && Utils.classes_test(inFile)) {
                                            odex.delete();
                                        }
                                    }
                                }
                            }
                        }
                    } else if (tail.getAbsolutePath().endsWith(".odex")) {
                        tail.delete();
                    }
                }
            }
        } catch (Exception e) {
        }
        System.out.println("LuckyPatcher: Dalvik-Cache deleted.");
        try {
            Utils.remount("/system", InternalZipConstants.WRITE_MODE);
            for (File sys_file : new File("/system/app").listFiles()) {
                if (listAppsFragment.api < 21) {
                    odex = new File(Utils.getPlaceForOdex(sys_file.getAbsolutePath(), true));
                    System.out.println(odex.getAbsolutePath());
                    if (odex.exists() && sys_file.getAbsoluteFile().toString().endsWith(".apk") && Utils.classes_test(sys_file)) {
                        odex.delete();
                    }
                } else if (sys_file.isDirectory()) {
                    appFiles = sys_file.listFiles();
                    if (appFiles != null && appFiles.length > 0) {
                        for (File inFile2 : appFiles) {
                            if (inFile2.isFile() && inFile2.getAbsolutePath().endsWith(".apk")) {
                                odex = new File(Utils.getPlaceForOdex(inFile2.getAbsolutePath(), true));
                                if (odex.exists() && inFile2.getAbsoluteFile().toString().endsWith(".apk") && Utils.classes_test(inFile2)) {
                                    odex.delete();
                                }
                            }
                        }
                    }
                }
            }
            for (File sys_file2 : new File("/system/priv-app").listFiles()) {
                if (listAppsFragment.api < 21) {
                    odex = new File(Utils.getPlaceForOdex(sys_file2.getAbsolutePath(), true));
                    System.out.println(odex.getAbsolutePath());
                    if (odex.exists() && sys_file2.getAbsoluteFile().toString().endsWith(".apk") && Utils.classes_test(sys_file2)) {
                        odex.delete();
                    }
                } else if (sys_file2.isDirectory()) {
                    appFiles = sys_file2.listFiles();
                    if (appFiles != null && appFiles.length > 0) {
                        for (File inFile22 : appFiles) {
                            if (inFile22.isFile() && inFile22.getAbsolutePath().endsWith(".apk")) {
                                odex = new File(Utils.getPlaceForOdex(inFile22.getAbsolutePath(), true));
                                if (odex.exists() && inFile22.getAbsoluteFile().toString().endsWith(".apk") && Utils.classes_test(inFile22)) {
                                    odex.delete();
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("LuckyPatcher: System apps deodex all.");
        } catch (Exception e2) {
        }
        try {
            for (File dir : new File("/mnt/asec").listFiles()) {
                if (dir.isDirectory()) {
                    for (File file : dir.listFiles()) {
                        if (file.getAbsoluteFile().toString().endsWith(".odex")) {
                            Utils.remount(file.getAbsolutePath(), InternalZipConstants.WRITE_MODE);
                            file.delete();
                        }
                    }
                }
            }
        } catch (Exception e3) {
        }
        Utils.exitFromRootJava();
    }
}
