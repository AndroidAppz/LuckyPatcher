package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import kellinwood.security.zipsigner.ZipSigner;
import org.tukaani.xz.XZ;
import pxb.android.axml.ValueWrapper;
import pxb.android.axmlLP.AxmlVisitor;

public class checkRoot {
    public static void main(String[] paramArrayOfString) {
        String api = "";
        String runtime = "";
        String selinux = "permissive";
        String dataDirSuperSu = "";
        Utils.startRootJava(new Object() {
        });
        String toolfilesdir = "";
        if (paramArrayOfString[0] != null) {
            toolfilesdir = paramArrayOfString[0];
        }
        if (paramArrayOfString[1] != null) {
            api = paramArrayOfString[1];
        }
        if (paramArrayOfString[2] != null) {
            runtime = paramArrayOfString[2];
        }
        if (paramArrayOfString[3] != null) {
            dataDirSuperSu = paramArrayOfString[3];
        }
        if (!dataDirSuperSu.equals(ZipSigner.KEY_NONE) && Integer.valueOf(api).intValue() >= 14) {
            try {
                String cfgSuperSu = dataDirSuperSu + "/files/supersu.cfg";
                String shared_prefs_SuperSu = dataDirSuperSu + "/shared_prefs/eu.chainfire.supersu_preferences.xml";
                if (new File(cfgSuperSu).exists() && Utils.read_from_file(new File(cfgSuperSu)).contains("enablemountnamespaceseparation=1")) {
                    if (!new File(shared_prefs_SuperSu).exists()) {
                        Utils.save_text_to_file(new File(cfgSuperSu), Utils.read_from_file(new File(cfgSuperSu)).replace("enablemountnamespaceseparation=1", "enablemountnamespaceseparation=0"));
                    } else if (Utils.read_from_file(new File(shared_prefs_SuperSu)).contains("<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"true\" />")) {
                        System.out.println("Mount name space separation in SuperSu detected.");
                    } else {
                        Utils.save_text_to_file(new File(cfgSuperSu), Utils.read_from_file(new File(cfgSuperSu)).replace("enablemountnamespaceseparation=1", "enablemountnamespaceseparation=0"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        listAppsFragment.toolfilesdir = toolfilesdir;
        System.out.println("root found!");
        try {
            if (Utils.cmdParam("getenforce").toLowerCase().contains("enforcing")) {
                System.out.println("selinux is enforcing!");
                selinux = "enforce";
                try {
                    Utils utils = new Utils("");
                    Utils.cmdParam("setenforce", "0");
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
        }
        File dir = new File("/data/lp");
        File utils_file = new File("/data/lp/lp_utils");
        if (utils_file.exists()) {
            String path = "";
            String apiS = "";
            String runtimeS = "";
            String selinuxS = "";
            String[] params = Utils.read_from_file(utils_file).split("%chelpus%");
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    switch (i) {
                        case XZ.CHECK_NONE /*0*/:
                            path = params[i];
                            break;
                        case AxmlVisitor.TYPE_REFERENCE /*1*/:
                            apiS = params[i];
                            break;
                        case ValueWrapper.STYLE /*2*/:
                            runtimeS = params[i];
                            break;
                        case AxmlVisitor.TYPE_STRING /*3*/:
                            selinuxS = params[i];
                            break;
                        default:
                            break;
                    }
                }
            }
            if (path.equals(toolfilesdir) && api.equals(apiS) && runtime.equals(runtimeS) && selinux.equals(selinuxS)) {
                System.out.println("Utils file found and correct");
                Utils.run_all_no_root("chmod", "777", utils_file.getAbsolutePath());
            } else {
                System.out.println("Utils file contain incorrect path " + path);
                Utils.run_all_no_root("chmod", "777", utils_file.getAbsolutePath());
                Utils.run_all_no_root("chmod", "777", dir.getAbsolutePath());
                Utils.save_text_to_file(utils_file, toolfilesdir + "%chelpus%" + api + "%chelpus%" + runtime + "%chelpus%" + selinux);
            }
        } else {
            dir.mkdirs();
            if (!dir.exists()) {
                System.out.println("LP: dirs for utils not created.");
            }
            try {
                utils_file.createNewFile();
                Utils.save_text_to_file(utils_file, toolfilesdir + "%chelpus%" + api + "%chelpus%" + runtime + "%chelpus%" + selinux);
                Utils.run_all_no_root("chmod", "777", utils_file.getAbsolutePath());
                Utils.run_all_no_root("chmod", "777", dir.getAbsolutePath());
            } catch (IOException e4) {
                e4.printStackTrace();
                System.out.println("LP: file for utils not created.");
            }
        }
        if (!Utils.initXposedParam()) {
            System.out.println("Xposed settings not initialized");
        }
        if (!(new File("/system/xbin/busybox").exists() || new File("/system/bin/busybox").exists() || new File("/bin/busybox").exists() || new File("/sbin/busybox").exists() || new File("/su/bin/busybox").exists() || new File("/su/xbin/busybox").exists() || new File("/su/xbin_bind/busybox").exists())) {
            System.out.println("LuckyPatcher: busybox not install!");
            System.out.println("busybox not found!");
        }
        if (new File(toolfilesdir + "/dalvikvm").exists()) {
            String dalvikvm = toolfilesdir + "/dalvikvm";
            Utils.run_all_no_root("chmod", "777", dalvikvm);
            Utils.run_all_no_root("chown", "0.0", dalvikvm);
            Utils.run_all_no_root("chown", "0:0", dalvikvm);
        }
        if (new File(toolfilesdir + "/busybox").exists()) {
            String busybox = toolfilesdir + "/busybox";
            Utils.run_all_no_root("chmod", "06777", busybox);
            Utils.run_all_no_root("chown", "0.0", busybox);
            Utils.run_all_no_root("chown", "0:0", busybox);
        }
        if (new File(toolfilesdir + "/reboot").exists()) {
            String reboot = toolfilesdir + "/reboot";
            Utils.run_all_no_root("chmod", "777", reboot);
            Utils.run_all_no_root("chown", "0.0", reboot);
            Utils.run_all_no_root("chown", "0:0", reboot);
        }
        int j = 0;
        try {
            File appDir = new File("/data/app/");
            if (appDir.exists()) {
                File[] files = appDir.listFiles();
                System.out.print("\nUnusedOdexList:");
                for (File file : files) {
                    File TempFile = new File(Utils.changeExtension(file.toString(), "apk"));
                    if (file.toString().toLowerCase().endsWith(".odex") && !TempFile.exists()) {
                        file.delete();
                        System.out.print(file + "|");
                        j++;
                    }
                }
                System.out.print("\n");
            }
        } catch (Exception e5) {
            System.out.println("Exception e" + e5.toString());
        }
        if (j > 0) {
            System.out.println("Unused ODEX in /data/app/ removed!");
        }
        Utils.exitFromRootJava();
    }
}
