/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Process
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class copyLibsFilesToSystemBackup {
    public static String index;
    public static String libDir;
    public static boolean nospace;
    public static String pkgName;
    public static String sys_apk_dir;

    static {
        libDir = "";
        pkgName = "";
        index = "";
        sys_apk_dir = "";
        nospace = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ArrayList<String> getLibs(File file, String string) {
        ArrayList arrayList = new ArrayList();
        if (!string.startsWith("/mnt/")) {
            if (listAppsFragment.api >= 21) {
                File file2 = Utils.getDirs(new File(string));
                if (!file2.exists()) return arrayList;
                File[] arrfile = file2.listFiles();
                int n = arrfile.length;
                int n2 = 0;
                while (n2 < n) {
                    File[] arrfile2;
                    File file3 = arrfile[n2];
                    System.out.println("LuckyPatcher: file found in data dir - " + (Object)file3 + " is dir:" + file3.isDirectory());
                    if (file3.isDirectory() && file3.getAbsolutePath().equals((Object)((Object)file2 + "/" + "lib")) && (arrfile2 = file3.listFiles()) != null && arrfile2.length > 0) {
                        int n3 = arrfile2.length;
                        for (int i = 0; i < n3; ++i) {
                            File[] arrfile3 = arrfile2[i].listFiles();
                            if (arrfile3 == null || arrfile3.length <= 0) continue;
                            for (File file4 : arrfile3) {
                                arrayList.add((Object)file4.getAbsolutePath());
                                index = Utils.getDirs(file4).getAbsolutePath().replace((CharSequence)file2.getAbsolutePath(), (CharSequence)"");
                                libDir = sys_apk_dir + index + "/";
                                System.out.println("libdir" + libDir);
                                new File(libDir).mkdirs();
                                System.out.println("LuckyPatcher: found lib - " + file4.getAbsolutePath());
                            }
                        }
                    }
                    ++n2;
                }
                return arrayList;
            }
            if (!file.exists()) return arrayList;
            String[] arrstring = file.list();
            int n = arrstring.length;
            int n4 = 0;
            while (n4 < n) {
                String string2 = arrstring[n4];
                System.out.println("LuckyPatcher: file found in data dir - " + (Object)file + "/" + string2 + "id dir:" + new File(new StringBuilder().append((Object)file).append("/").append(string2).toString()).isDirectory());
                if (new File((Object)file + "/" + string2).isDirectory() && ((Object)file + "/" + string2).equals((Object)((Object)file + "/" + "lib"))) {
                    for (String string3 : new File((Object)file + "/" + string2).list()) {
                        if (!new File((Object)file + "/" + string2 + "/" + string3).isFile() || string3.contains((CharSequence)"libjnigraphics.so")) continue;
                        arrayList.add((Object)((Object)file + "/" + string2 + "/" + string3));
                        System.out.println("LuckyPatcher: found lib - " + (Object)file + "/" + string2 + "/" + string3 + " is dir:" + new File(new StringBuilder().append((Object)file).append("/").append(string2).toString()).isDirectory());
                    }
                }
                ++n4;
            }
            return arrayList;
        }
        File file5 = Utils.getDirs(new File(string));
        Utils.remount(file5.getAbsolutePath(), "rw");
        if (!file5.exists()) return arrayList;
        String[] arrstring = file5.list();
        int n = arrstring.length;
        int n5 = 0;
        while (n5 < n) {
            String string4 = arrstring[n5];
            System.out.println("LuckyPatcher: file found in data dir - " + (Object)file5 + "/" + string4);
            if (new File((Object)file5 + "/" + string4).isDirectory() && ((Object)file5 + "/" + string4).equals((Object)((Object)file5 + "/" + "lib"))) {
                for (String string5 : new File((Object)file5 + "/" + string4).list()) {
                    if (!new File((Object)file5 + "/" + string4 + "/" + string5).isFile() || string5.contains((CharSequence)"libjnigraphics.so")) continue;
                    arrayList.add((Object)((Object)file5 + "/" + string4 + "/" + string5));
                    System.out.println("LuckyPatcher: found lib - " + (Object)file5 + "/" + string4 + "/" + string5);
                }
            }
            ++n5;
        }
        return arrayList;
    }

    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        pkgName = arrstring[0];
        String string = arrstring[1];
        String string2 = arrstring[2];
        sys_apk_dir = Utils.getDirs(new File(arrstring[3])).getAbsolutePath();
        String string3 = arrstring[4];
        if (string3.equals((Object)"copyLibs")) {
            System.out.println("copyLibs");
            libDir = "/system/lib/";
            ArrayList<String> arrayList = copyLibsFilesToSystemBackup.getLibs(new File(string), string2);
            if (arrayList.size() > 0) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    File file = new File((String)iterator.next());
                    if (!new File(libDir).exists()) {
                        new File(libDir).mkdirs();
                    }
                    Utils.setPermissionDir(sys_apk_dir, sys_apk_dir + index, "755", true);
                    Utils.copyFile(file, new File(libDir + file.getName() + ".chelpus"));
                    copyLibsFilesToSystemBackup.run_all("chmod 0644 " + libDir + file.getName() + ".chelpus");
                    copyLibsFilesToSystemBackup.run_all("chown 0.0 " + libDir + file.getName() + ".chelpus");
                    copyLibsFilesToSystemBackup.run_all("chown 0:0 " + libDir + file.getName() + ".chelpus");
                    if (file.length() == new File(libDir + file.getName() + ".chelpus").length()) {
                        System.out.println("LuckyPatcher: copy lib " + libDir + file.getName() + ".chelpus");
                        continue;
                    }
                    Iterator iterator2 = arrayList.iterator();
                    while (iterator2.hasNext()) {
                        File file2 = new File((String)iterator2.next());
                        if (listAppsFragment.api < 21) {
                            new File(libDir + file2.getName() + ".chelpus").delete();
                            continue;
                        }
                        if (!libDir.startsWith("/system/priv-app/")) continue;
                        try {
                            new Utils("").deleteFolder(new File(libDir));
                        }
                        catch (IOException var20_9) {
                            var20_9.printStackTrace();
                        }
                    }
                    System.out.println("In /system space not found!");
                    nospace = true;
                    break;
                }
            }
        }
        if (string3.equals((Object)"replaceOldLibs")) {
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
            new ArrayList();
            File[] arrfile = new File(libDir).listFiles();
            if (arrfile != null && arrfile.length > 0) {
                for (File file : arrfile) {
                    if (!file.isFile() || !file.getName().endsWith(".chelpus")) continue;
                    System.out.println("Replace system lib:" + file.getAbsolutePath().replace((CharSequence)".chelpus", (CharSequence)""));
                    new File(file.getAbsolutePath().replace((CharSequence)".chelpus", (CharSequence)"")).delete();
                    file.renameTo(new File(file.getAbsolutePath().replace((CharSequence)".chelpus", (CharSequence)"")));
                }
            }
            copyLibsFilesToSystemBackup.removeLibs(new File(string), string2);
        }
        if (string3.equals((Object)"deleteBigLibs")) {
            System.out.println("deleteBigLibs");
            libDir = "/system/lib/";
            ArrayList<String> arrayList = copyLibsFilesToSystemBackup.getLibs(new File(string), string2);
            if (arrayList.size() > 0) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    File file = new File((String)iterator.next());
                    new File(libDir + file.getName() + ".chelpus").delete();
                }
            }
        }
        Utils.exitFromRootJava();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void removeLibs(File file, String string) {
        int n = 0;
        if (listAppsFragment.api < 21) {
            if (string.startsWith("/mnt/")) return;
            System.out.println("remove libs in data");
            if (!file.exists()) return;
            String[] arrstring = file.list();
            int n2 = arrstring.length;
            int n3 = 0;
            while (n3 < n2) {
                String string2 = arrstring[n3];
                System.out.println("LuckyPatcher: file found in data dir - " + (Object)file + "/" + string2);
                if (new File((Object)file + "/" + string2).isDirectory() && ((Object)file + "/" + string2).equals((Object)((Object)file + "/" + "lib"))) {
                    String[] arrstring2 = new File((Object)file + "/" + string2).list();
                    if (arrstring2 != null && arrstring2.length > 0) {
                        for (String string3 : arrstring2) {
                            if (!new File((Object)file + "/" + string2 + "/" + string3).isFile()) continue;
                            new File((Object)file + "/" + string2 + "/" + string3).delete();
                            System.out.println("LuckyPatcher: remove lib - " + (Object)file + "/" + string2 + "/" + string3);
                        }
                    }
                    System.out.println("delete dir" + (Object)file + "/" + string2);
                    new File((Object)file + "/" + string2).delete();
                } else {
                    System.out.println("file not dir lib" + (Object)file + "/" + string2 + " is File:" + new File(new StringBuilder().append((Object)file).append("/").append(string2).toString()).isFile());
                    if (((Object)file + "/" + string2).equals((Object)((Object)file + "/" + "lib"))) {
                        System.out.println("delete file" + (Object)file + "/" + string2);
                        new File((Object)file + "/" + string2).delete();
                    }
                }
                ++n3;
            }
            return;
        }
        System.out.println("remove libs in data for api 21");
        File file2 = Utils.getDirs(new File(string));
        if (!Utils.getDirs(new File(string)).exists()) return;
        File[] arrfile = file2.listFiles();
        int n4 = arrfile.length;
        while (n < n4) {
            File file3 = arrfile[n];
            System.out.println("LuckyPatcher: file found in data dir - " + (Object)file2 + "/" + (Object)file3);
            if (file3.isDirectory() && file3.getAbsolutePath().endsWith("/lib")) {
                try {
                    new Utils("").deleteFolder(file3);
                }
                catch (IOException var7_14) {
                    var7_14.printStackTrace();
                }
            }
            ++n;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private static void run_all(String var0) {
        try {
            var14_1 = Runtime.getRuntime().exec(var0 + "\n");
            var14_1.waitFor();
            var14_1.destroy();
        }
        catch (Exception var1_10) {
            ** continue;
        }
lbl7: // 2 sources:
        do {
            try {
                var12_2 = Runtime.getRuntime().exec("toolbox " + var0 + "\n");
                var12_2.waitFor();
                var12_2.destroy();
            }
            catch (Exception var2_9) {
                ** continue;
            }
lbl14: // 2 sources:
            do {
                try {
                    var10_3 = Runtime.getRuntime().exec("/system/bin/failsafe/toolbox " + var0 + "\n");
                    var10_3.waitFor();
                    var10_3.destroy();
                }
                catch (Exception var3_8) {
                    ** continue;
                }
lbl21: // 2 sources:
                do {
                    try {
                        var8_4 = Runtime.getRuntime().exec("busybox " + var0 + "\n");
                        var8_4.waitFor();
                        var8_4.destroy();
                    }
                    catch (Exception var4_7) {
                        ** continue;
                    }
lbl28: // 2 sources:
                    do {
                        try {
                            var6_5 = Runtime.getRuntime().exec(listAppsFragment.toolfilesdir + "/busybox " + var0 + "\n");
                            var6_5.waitFor();
                            var6_5.destroy();
                            return;
                        }
                        catch (Exception var5_6) {
                            return;
                        }
                        break;
                    } while (true);
                    break;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
    }

}

