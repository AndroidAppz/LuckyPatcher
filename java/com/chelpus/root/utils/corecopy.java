/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class corecopy {
    public static String toolfilesdir = "";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] arrstring) {
        File file;
        if (arrstring[3] != null) {
            toolfilesdir = arrstring[3];
        }
        Utils.startRootJava(new Object(){});
        Utils.remount("/system", "rw");
        if (arrstring[1].contains((CharSequence)"odex")) {
            File file2 = new File("/system/framework/core.patched");
            new File("/system/framework/services.patched");
            File file3 = new File(arrstring[0]);
            new File(arrstring[2]);
            if (!(false || arrstring[0].contains((CharSequence)"empty") || Utils.exists("/system/framework/not.space"))) {
                if (file3.length() == file2.length()) {
                    if (file2.exists()) {
                        new File("/system/framework/not.space").delete();
                        try {
                            new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").createNewFile();
                        }
                        catch (IOException var17_5) {
                            var17_5.printStackTrace();
                        }
                        if (new File("/system/framework/core.odex").exists()) {
                            Utils.run_all_no_root("rm", "/system/framework/core.odex");
                            if (new File("/system/framework/core.odex").exists()) {
                                new File("/system/framework/core.odex").delete();
                            }
                        }
                        file2.renameTo(new File("/system/framework/core.odex"));
                        Utils.run_all_no_root("chmod", "644", "/system/framework/core.odex");
                        Utils.run_all_no_root("chown", "0.0", "/system/framework/core.odex");
                        Utils.run_all_no_root("chown", "0:0", "/system/framework/core.odex");
                        String[] arrstring2 = new String[]{"rm", file3.getAbsolutePath()};
                        Utils.run_all_no_root(arrstring2);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        System.out.println("LuckyPatcher: Core odexed!");
                    } else {
                        System.out.println("LuckyPatcher: Core odexed failed!");
                    }
                } else {
                    try {
                        new File("/system/framework/not.space").createNewFile();
                    }
                    catch (IOException var8_6) {
                        var8_6.printStackTrace();
                    }
                    new File("/system/framework/core.patched").delete();
                    new File("/system/framework/patch1.done").delete();
                    new File("/system/framework/patch1.2.done").delete();
                    new File("/system/framework/patch2.done").delete();
                    new File("/system/framework/patch3.done").delete();
                    new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").delete();
                    System.out.println("LuckyPatcher: Core odexed failed 2!");
                }
            }
        }
        if (arrstring[1].contains((CharSequence)"delete") && (file = new File("/system/framework/core.patched")).exists()) {
            file.delete();
        }
        Utils.exitFromRootJava();
    }

}

