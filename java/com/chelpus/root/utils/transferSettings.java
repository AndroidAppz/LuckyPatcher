/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class transferSettings {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        String string = arrstring[0];
        String string2 = arrstring[1];
        String string3 = arrstring[2];
        String string4 = arrstring[3].replace((CharSequence)(string2 + "/app_lptest"), (CharSequence)"");
        System.out.println("dt:" + string4);
        try {
            Utils.killAll(string);
            new Utils("").setAllWritable(new File(string4 + string));
            new Utils("").setAllWritable(new File(string4 + string2));
            Utils.copyFolder(new File(string4 + string), new File(string4 + string2));
            if (new File(string4 + string2 + "/files/busybox").exists()) {
                System.out.println("busybox found");
            } else {
                System.out.println("busybox not found");
            }
            new Utils("tr").fixPermissions(new File(string4 + string2), "775");
            new Utils("r1").fixOwners(new File(string4 + string2), string3 + ":" + string3);
            new Utils("r2").fixOwners(new File(string4 + string2), string3 + "." + string3);
            String[] arrstring2 = new String[]{"chmod", "777", string4 + string2 + "/files/busybox"};
            Utils.run_all_no_root(arrstring2);
            String[] arrstring3 = new String[]{"chown", "0:0", string4 + string2 + "/files/busybox"};
            Utils.run_all_no_root(arrstring3);
            String[] arrstring4 = new String[]{"chown", "0.0", string4 + string2 + "/files/busybox"};
            Utils.run_all_no_root(arrstring4);
            String[] arrstring5 = new String[]{"chmod", "777", string4 + string2 + "/files/reboot"};
            Utils.run_all_no_root(arrstring5);
            String[] arrstring6 = new String[]{"chown", "0:0", string4 + string2 + "/files/reboot"};
            Utils.run_all_no_root(arrstring6);
            String[] arrstring7 = new String[]{"chown", "0.0", string4 + string2 + "/files/reboot"};
            Utils.run_all_no_root(arrstring7);
            String[] arrstring8 = new String[]{"chmod", "777", string4 + string2 + "/files/zipalign"};
            Utils.run_all_no_root(arrstring8);
            String[] arrstring9 = new String[]{"chown", "0:0", string4 + string2 + "/files/zipalign"};
            Utils.run_all_no_root(arrstring9);
            String[] arrstring10 = new String[]{"chown", "0.0", string4 + string2 + "/files/zipalign"};
            Utils.run_all_no_root(arrstring10);
            String[] arrstring11 = new String[]{"chmod", "777", string4 + string2 + "/files/p.apk"};
            Utils.run_all_no_root(arrstring11);
            String[] arrstring12 = new String[]{"chown", "0:0", string4 + string2 + "/files/p.apk"};
            Utils.run_all_no_root(arrstring12);
            String[] arrstring13 = new String[]{"chown", "0.0", string4 + string2 + "/files/p.apk"};
            Utils.run_all_no_root(arrstring13);
            new File(string4 + string2 + "/files/p.apk").delete();
            String[] arrstring14 = new String[]{"chmod", "777", string4 + string2 + "/files/dalvikvm"};
            Utils.run_all_no_root(arrstring14);
            String[] arrstring15 = new String[]{"chown", "0:0", string4 + string2 + "/files/dalvikvm"};
            Utils.run_all_no_root(arrstring15);
            String[] arrstring16 = new String[]{"chown", "0.0", string4 + string2 + "/files/dalvikvm"};
            Utils.run_all_no_root(arrstring16);
            System.out.println("all data copied to new settings");
        }
        catch (Exception var5_20) {
            var5_20.printStackTrace();
        }
        Utils.exitFromRootJava();
    }

}

