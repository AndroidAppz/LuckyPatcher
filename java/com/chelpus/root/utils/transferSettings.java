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
        String dir_for_transfer = paramArrayOfString[3].replace(pkgNew + "/app_lptest", "");
        System.out.println("dt:" + dir_for_transfer);
        try {
            Utils.killAll(pkgOld);
            new Utils("").setAllWritable(new File(dir_for_transfer + pkgOld));
            new Utils("").setAllWritable(new File(dir_for_transfer + pkgNew));
            Utils.copyFolder(new File(dir_for_transfer + pkgOld), new File(dir_for_transfer + pkgNew));
            if (new File(dir_for_transfer + pkgNew + "/files/busybox").exists()) {
                System.out.println("busybox found");
            } else {
                System.out.println("busybox not found");
            }
            new Utils("tr").fixPermissions(new File(dir_for_transfer + pkgNew), "775");
            new Utils("r1").fixOwners(new File(dir_for_transfer + pkgNew), uid + ":" + uid);
            new Utils("r2").fixOwners(new File(dir_for_transfer + pkgNew), uid + "." + uid);
            Utils.run_all_no_root("chmod", "777", dir_for_transfer + pkgNew + "/files/busybox");
            Utils.run_all_no_root("chown", "0:0", dir_for_transfer + pkgNew + "/files/busybox");
            Utils.run_all_no_root("chown", "0.0", dir_for_transfer + pkgNew + "/files/busybox");
            Utils.run_all_no_root("chmod", "777", dir_for_transfer + pkgNew + "/files/reboot");
            Utils.run_all_no_root("chown", "0:0", dir_for_transfer + pkgNew + "/files/reboot");
            Utils.run_all_no_root("chown", "0.0", dir_for_transfer + pkgNew + "/files/reboot");
            Utils.run_all_no_root("chmod", "777", dir_for_transfer + pkgNew + "/files/zipalign");
            Utils.run_all_no_root("chown", "0:0", dir_for_transfer + pkgNew + "/files/zipalign");
            Utils.run_all_no_root("chown", "0.0", dir_for_transfer + pkgNew + "/files/zipalign");
            Utils.run_all_no_root("chmod", "777", dir_for_transfer + pkgNew + "/files/p.apk");
            Utils.run_all_no_root("chown", "0:0", dir_for_transfer + pkgNew + "/files/p.apk");
            Utils.run_all_no_root("chown", "0.0", dir_for_transfer + pkgNew + "/files/p.apk");
            new File(dir_for_transfer + pkgNew + "/files/p.apk").delete();
            Utils.run_all_no_root("chmod", "777", dir_for_transfer + pkgNew + "/files/dalvikvm");
            Utils.run_all_no_root("chown", "0:0", dir_for_transfer + pkgNew + "/files/dalvikvm");
            Utils.run_all_no_root("chown", "0.0", dir_for_transfer + pkgNew + "/files/dalvikvm");
            System.out.println("all data copied to new settings");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Utils.exitFromRootJava();
    }
}
