package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;

public class odexSystemApps {
    public static void main(String[] paramArrayOfString) {
        File odex;
        File dalvik;
        Utils.startRootJava(new Object() {
        });
        String toolsfiledir = paramArrayOfString[0];
        for (File file : new File("/system/app").listFiles()) {
            File[] appFiles;
            if (listAppsFragment.api >= 21) {
                if (file.isDirectory()) {
                    appFiles = file.listFiles();
                    if (appFiles != null && appFiles.length > 0) {
                        for (File inFile : appFiles) {
                            if (inFile.isFile() && inFile.getAbsolutePath().endsWith(".apk")) {
                                odex = new File(Utils.getOdexForCreate(inFile.getAbsolutePath(), "0"));
                                dalvik = Utils.getFileDalvikCache(inFile.getAbsolutePath());
                                if (!(odex.exists() || dalvik == null || !dalvik.exists())) {
                                    try {
                                        Utils.copyFile(dalvik, odex);
                                        if (dalvik.length() != odex.length()) {
                                            odex.delete();
                                            System.out.println("Not enought space!");
                                        } else {
                                            Utils.cmdParam("chmod", "644", odex.getAbsolutePath());
                                            Utils.cmdParam("chown", "0.0", odex.getAbsolutePath());
                                            Utils.cmdParam("chown", "0:0", odex.getAbsolutePath());
                                            dalvik.delete();
                                        }
                                    } catch (Exception e) {
                                        odex.delete();
                                        System.out.println("IO Exception!");
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (file.isFile() && file.getAbsolutePath().endsWith(".apk")) {
                odex = new File(Utils.getOdexForCreate(file.getAbsolutePath(), "0"));
                dalvik = Utils.getFileDalvikCache(file.getAbsolutePath());
                if (!(odex.exists() || dalvik == null || !dalvik.exists())) {
                    try {
                        Utils.copyFile(dalvik, odex);
                        if (dalvik.length() != odex.length()) {
                            odex.delete();
                            System.out.println("Not enought space!");
                        } else {
                            Utils.cmdParam("chmod", "644", odex.getAbsolutePath());
                            Utils.cmdParam("chown", "0.0", odex.getAbsolutePath());
                            Utils.cmdParam("chown", "0:0", odex.getAbsolutePath());
                            dalvik.delete();
                        }
                    } catch (Exception e2) {
                        odex.delete();
                        System.out.println("IO Exception!");
                        e2.printStackTrace();
                    }
                }
            }
        }
        File systemdir = new File("/system/priv-app");
        if (systemdir.exists()) {
            for (File file2 : systemdir.listFiles()) {
                if (listAppsFragment.api >= 21) {
                    if (file2.isDirectory()) {
                        appFiles = file2.listFiles();
                        if (appFiles != null && appFiles.length > 0) {
                            for (File inFile2 : appFiles) {
                                if (inFile2.isFile() && inFile2.getAbsolutePath().endsWith(".apk")) {
                                    odex = new File(Utils.getOdexForCreate(inFile2.getAbsolutePath(), "0"));
                                    dalvik = Utils.getFileDalvikCache(inFile2.getAbsolutePath());
                                    if (!(odex.exists() || dalvik == null || !dalvik.exists())) {
                                        try {
                                            Utils.copyFile(dalvik, odex);
                                            if (dalvik.length() != odex.length()) {
                                                odex.delete();
                                                System.out.println("Not enought space!");
                                            } else {
                                                Utils.cmdParam("chmod", "644", odex.getAbsolutePath());
                                                Utils.cmdParam("chown", "0.0", odex.getAbsolutePath());
                                                Utils.cmdParam("chown", "0:0", odex.getAbsolutePath());
                                                dalvik.delete();
                                            }
                                        } catch (Exception e22) {
                                            odex.delete();
                                            System.out.println("IO Exception!");
                                            e22.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (file2.isFile() && file2.getAbsolutePath().endsWith(".apk")) {
                    odex = new File(Utils.getOdexForCreate(file2.getAbsolutePath(), "0"));
                    dalvik = Utils.getFileDalvikCache(file2.getAbsolutePath());
                    if (!(odex.exists() || dalvik == null || !dalvik.exists())) {
                        try {
                            Utils.copyFile(dalvik, odex);
                            if (dalvik.length() != odex.length()) {
                                odex.delete();
                                System.out.println("Not enought space!");
                            } else {
                                Utils.cmdParam("chmod", "644", odex.getAbsolutePath());
                                Utils.cmdParam("chown", "0.0", odex.getAbsolutePath());
                                Utils.cmdParam("chown", "0:0", odex.getAbsolutePath());
                                dalvik.delete();
                            }
                        } catch (Exception e222) {
                            odex.delete();
                            System.out.println("IO Exception!");
                            e222.printStackTrace();
                        }
                    }
                }
            }
        }
        Utils.exitFromRootJava();
    }
}
