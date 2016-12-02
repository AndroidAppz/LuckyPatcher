package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import net.lingala.zip4j.util.InternalZipConstants;

public class clearDalvikCache {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        listAppsFragment.toolfilesdir = paramArrayOfString[0];
        if (new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").exists()) {
            new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").delete();
            if (new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").exists()) {
                System.out.println("LuckyPatcher: (error) try delete ClearDalvik.on - fault!");
            } else {
                File[] oats;
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
                } catch (Exception e) {
                }
                if (listAppsFragment.api >= 23) {
                    try {
                        if (new File("/data/app").exists()) {
                            for (File tail : new File("/data/app").listFiles()) {
                                if (tail.isDirectory()) {
                                    oats = tail.listFiles();
                                    if (oats != null && oats.length > 0) {
                                        for (File oat : oats) {
                                            if (oat.isDirectory() && oat.getName().equals("oat")) {
                                                System.out.println("delete folder:" + oat.getAbsolutePath());
                                                new Utils("").deleteFolder(oat);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                    }
                }
                try {
                    if (new File("/data/dalvik-cache").exists()) {
                        for (File tail2 : new File("/data/dalvik-cache").listFiles()) {
                            if (tail2.isDirectory()) {
                                oats = tail2.listFiles();
                                if (oats != null && oats.length > 0) {
                                    for (File oat2 : oats) {
                                        if (oat2.isFile()) {
                                            oat2.delete();
                                        }
                                    }
                                }
                            }
                            if (tail2.isFile()) {
                                tail2.delete();
                            }
                        }
                    }
                } catch (Exception e3) {
                }
                try {
                    if (new File("/cache/dalvik-cache").exists()) {
                        for (String tail3 : new File("/cache/dalvik-cache").list()) {
                            new File("/cache/dalvik-cache/" + tail3).delete();
                        }
                    }
                } catch (Exception e4) {
                }
                try {
                    if (new File("/sd-ext/data/dalvik-cache").exists()) {
                        for (String tail32 : new File("/sd-ext/data/dalvik-cache").list()) {
                            new File("/sd-ext/data/dalvik-cache/" + tail32).delete();
                        }
                    }
                } catch (Exception e5) {
                }
                try {
                    if (new File("/sd-ext/data/cache/dalvik-cache").exists()) {
                        for (String tail322 : new File("/sd-ext/data/cache/dalvik-cache").list()) {
                            new File("/sd-ext/data/cache/dalvik-cache/" + tail322).delete();
                        }
                    }
                } catch (Exception e6) {
                }
                try {
                    if (new File("/data/app").exists()) {
                        for (String tail3222 : new File("/data/app").list()) {
                            if (tail3222.endsWith(".odex")) {
                                new File("/data/app/" + tail3222).delete();
                            }
                        }
                    }
                } catch (Exception e7) {
                }
                System.out.println("LuckyPatcher: Dalvik-Cache deleted.");
                try {
                    File odex;
                    Utils.remount("/system", InternalZipConstants.WRITE_MODE);
                    for (File sys_file : new File("/system/app").listFiles()) {
                        odex = new File(Utils.getPlaceForOdex(sys_file.getAbsolutePath(), true));
                        if (odex.exists() && sys_file.getAbsoluteFile().toString().endsWith(".apk") && Utils.classes_test(sys_file)) {
                            odex.delete();
                        }
                    }
                    for (File sys_file2 : new File("/system/priv-app").listFiles()) {
                        odex = new File(Utils.getPlaceForOdex(sys_file2.getAbsolutePath(), true));
                        if (odex.exists() && sys_file2.getAbsoluteFile().toString().endsWith(".apk") && Utils.classes_test(sys_file2)) {
                            odex.delete();
                        }
                    }
                    System.out.println("LuckyPatcher: System apps deodex all.");
                } catch (Exception e8) {
                }
            }
        }
        Utils.exitFromRootJava();
    }
}
