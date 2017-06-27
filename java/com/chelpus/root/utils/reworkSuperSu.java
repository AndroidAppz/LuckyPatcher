package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import kellinwood.security.zipsigner.ZipSigner;

public class reworkSuperSu {
    public static void main(String[] paramArrayOfString) {
        String dataDirSuperSu = "";
        Utils.startRootJava(new Object() {
        });
        String toolfilesdir = "";
        if (paramArrayOfString[0] != null) {
            dataDirSuperSu = paramArrayOfString[0];
        }
        if (!dataDirSuperSu.equals(ZipSigner.KEY_NONE)) {
            try {
                String cfgSuperSu = new StringBuilder(String.valueOf(dataDirSuperSu)).append("/files/supersu.cfg").toString();
                String shared_prefs_SuperSu = new StringBuilder(String.valueOf(dataDirSuperSu)).append("/shared_prefs/eu.chainfire.supersu_preferences.xml").toString();
                if (new File(cfgSuperSu).exists()) {
                    String cfg = Utils.read_from_file(new File(cfgSuperSu));
                    if (cfg.contains("enablemountnamespaceseparation=1")) {
                        System.out.println("Mount name space separation in SuperSu detected.");
                        System.out.println("Try disable.");
                        Utils.save_text_to_file(new File(cfgSuperSu), cfg.replace("enablemountnamespaceseparation=1", "enablemountnamespaceseparation=0"));
                        System.out.println("supersu.cfg fixed.");
                        if (new File(shared_prefs_SuperSu).exists()) {
                            cfg = Utils.read_from_file(new File(shared_prefs_SuperSu));
                            if (cfg.contains("<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"true\" />")) {
                                System.out.println("Try disable to prefs.");
                                Utils.save_text_to_file(new File(shared_prefs_SuperSu), cfg.replace("<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"true\" />", "<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"false\" />"));
                                System.out.println("supersu prefs fixed.");
                                Utils.reboot();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Utils.exitFromRootJava();
    }
}
