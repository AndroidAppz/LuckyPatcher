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

public class reworkSuperSu {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] arrstring) {
        String string = "";
        Utils.startRootJava(new Object(){});
        if (arrstring[0] != null) {
            string = arrstring[0];
        }
        if (!string.equals((Object)"none")) {
            try {
                String string2;
                String string3 = string + "/files/supersu.cfg";
                String string4 = string + "/shared_prefs/eu.chainfire.supersu_preferences.xml";
                if (new File(string3).exists() && (string2 = Utils.read_from_file(new File(string3))).contains((CharSequence)"enablemountnamespaceseparation=1")) {
                    String string5;
                    System.out.println("Mount name space separation in SuperSu detected.");
                    System.out.println("Try disable.");
                    String string6 = string2.replace((CharSequence)"enablemountnamespaceseparation=1", (CharSequence)"enablemountnamespaceseparation=0");
                    Utils.save_text_to_file(new File(string3), string6);
                    System.out.println("supersu.cfg fixed.");
                    if (new File(string4).exists() && (string5 = Utils.read_from_file(new File(string4))).contains((CharSequence)"<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"true\" />")) {
                        System.out.println("Try disable to prefs.");
                        String string7 = string5.replace((CharSequence)"<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"true\" />", (CharSequence)"<boolean name=\"config_default_enablemountnamespaceseparation\" value=\"false\" />");
                        Utils.save_text_to_file(new File(string4), string7);
                        System.out.println("supersu prefs fixed.");
                        Utils.reboot();
                    }
                }
            }
            catch (Exception var2_8) {
                var2_8.printStackTrace();
            }
        }
        Utils.exitFromRootJava();
    }

}

