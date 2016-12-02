/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class check_sd_from_root {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        try {
            if (new File(arrstring[0] + "/test.tmp").exists()) {
                System.out.println("LuckyPatcher: Found test.tmp");
                new File(arrstring[0] + "/test.tmp").delete();
            }
        }
        catch (Exception var1_1) {
            var1_1.printStackTrace();
        }
        Utils.exitFromRootJava();
    }

}

