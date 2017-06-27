package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class transferSettings {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        String pkgOld = paramArrayOfString[0];
        String pkgNew = paramArrayOfString[1];
        String uid = paramArrayOfString[2];
        String dir_for_transfer = paramArrayOfString[3].replace(new StringBuilder(String.valueOf(pkgNew)).append("/app_lptest").toString(), "");
        System.out.println("dt:" + dir_for_transfer);
        try {
            Utils.killAll(pkgOld);
            new Utils("").setAllWritable(new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgOld).toString()));
            new Utils("").setAllWritable(new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).toString()));
            Utils.copyFolder(new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgOld).toString()), new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).toString()));
            if (new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/busybox").toString()).exists()) {
                System.out.println("busybox found");
            } else {
                System.out.println("busybox not found");
            }
            new Utils("tr").fixPermissions(new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).toString()), "775");
            new Utils("r1").fixOwners(new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).toString()), new StringBuilder(String.valueOf(uid)).append(":").append(uid).toString());
            new Utils("r2").fixOwners(new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).toString()), new StringBuilder(String.valueOf(uid)).append(".").append(uid).toString());
            Utils.run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/busybox").toString());
            Utils.run_all_no_root("chown", "0:0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/busybox").toString());
            Utils.run_all_no_root("chown", "0.0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/busybox").toString());
            Utils.run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/reboot").toString());
            Utils.run_all_no_root("chown", "0:0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/reboot").toString());
            Utils.run_all_no_root("chown", "0.0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/reboot").toString());
            Utils.run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/zipalign").toString());
            Utils.run_all_no_root("chown", "0:0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/zipalign").toString());
            Utils.run_all_no_root("chown", "0.0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/zipalign").toString());
            Utils.run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/p.apk").toString());
            Utils.run_all_no_root("chown", "0:0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/p.apk").toString());
            Utils.run_all_no_root("chown", "0.0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/p.apk").toString());
            new File(new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/p.apk").toString()).delete();
            Utils.run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/dalvikvm").toString());
            Utils.run_all_no_root("chown", "0:0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/dalvikvm").toString());
            Utils.run_all_no_root("chown", "0.0", new StringBuilder(String.valueOf(dir_for_transfer)).append(pkgNew).append("/files/dalvikvm").toString());
            System.out.println("all data copied to new settings");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Utils.exitFromRootJava();
    }
}
