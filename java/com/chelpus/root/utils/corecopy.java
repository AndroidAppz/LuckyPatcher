package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import net.lingala.zip4j.util.InternalZipConstants;

public class corecopy {
    public static String toolfilesdir = "";

    public static void main(String[] paramArrayOfString) {
        File corepatched;
        if (paramArrayOfString[3] != null) {
            toolfilesdir = paramArrayOfString[3];
        }
        Utils.startRootJava(new Object() {
        });
        Utils.remount("/system", InternalZipConstants.WRITE_MODE);
        if (paramArrayOfString[1].contains("odex")) {
            corepatched = new File("/system/framework/core.patched");
            File corepatched2 = new File("/system/framework/services.patched");
            File dalvikcache = new File(paramArrayOfString[0]);
            File dalvikcache2 = new File(paramArrayOfString[2]);
            if (!(false || paramArrayOfString[0].contains("empty") || Utils.exists("/system/framework/not.space"))) {
                if (dalvikcache.length() != corepatched.length()) {
                    try {
                        new File("/system/framework/not.space").createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new File("/system/framework/core.patched").delete();
                    new File("/system/framework/patch1.done").delete();
                    new File("/system/framework/patch1.2.done").delete();
                    new File("/system/framework/patch2.done").delete();
                    new File("/system/framework/patch3.done").delete();
                    new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").delete();
                    System.out.println("LuckyPatcher: Core odexed failed 2!");
                } else if (corepatched.exists()) {
                    new File("/system/framework/not.space").delete();
                    try {
                        new File(listAppsFragment.toolfilesdir + "/ClearDalvik.on").createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    if (new File("/system/framework/core.odex").exists()) {
                        Utils.run_all_no_root("rm", "/system/framework/core.odex");
                        if (new File("/system/framework/core.odex").exists()) {
                            new File("/system/framework/core.odex").delete();
                        }
                    }
                    corepatched.renameTo(new File("/system/framework/core.odex"));
                    Utils.run_all_no_root("chmod", "644", "/system/framework/core.odex");
                    Utils.run_all_no_root("chown", "0.0", "/system/framework/core.odex");
                    Utils.run_all_no_root("chown", "0:0", "/system/framework/core.odex");
                    Utils.run_all_no_root("rm", dalvikcache.getAbsolutePath());
                    if (dalvikcache.exists()) {
                        dalvikcache.delete();
                    }
                    System.out.println("LuckyPatcher: Core odexed!");
                } else {
                    System.out.println("LuckyPatcher: Core odexed failed!");
                }
            }
        }
        if (paramArrayOfString[1].contains("delete")) {
            corepatched = new File("/system/framework/core.patched");
            if (corepatched.exists()) {
                corepatched.delete();
            }
        }
        Utils.exitFromRootJava();
    }
}
