/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
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
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class deodex {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void main(String[] var0) {
        Utils.startRootJava(new Object(){});
        Utils.kill(var0[0]);
        Utils.remount(var0[1], "rw");
        try {
            if (Utils.getFileDalvikCache(var0[1]) == null) {
                throw new FileNotFoundException();
            }
            var15_8 = Utils.getPlaceForOdex(var0[1], true);
            var16_9 = new File(var15_8);
            if (var16_9.exists()) {
                var16_9.delete();
            }
            if ((var17_10 = new File(var15_8.replace((CharSequence)"-2", (CharSequence)"-1"))).exists()) {
                var17_10.delete();
            }
            if ((var18_11 = new File(var15_8.replace((CharSequence)"-1", (CharSequence)"-2"))).exists()) {
                var18_11.delete();
            }
            if ((var19_12 = new File(var15_8.replace((CharSequence)"-2", (CharSequence)""))).exists()) {
                var19_12.delete();
            }
            if ((var20_13 = new File(var15_8.replace((CharSequence)"-1", (CharSequence)""))).exists()) {
                var20_13.delete();
            }
            ** GOTO lbl38
        }
        catch (FileNotFoundException var3_1) {
            System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
            if (Utils.classes_test(new File(var0[1]))) {
                var4_2 = Utils.getPlaceForOdex(var0[1], true);
                var5_3 = new File(var4_2);
                if (var5_3.exists()) {
                    var5_3.delete();
                }
                if ((var6_4 = new File(var4_2.replace((CharSequence)"-2", (CharSequence)"-1"))).exists()) {
                    var6_4.delete();
                }
                if ((var7_5 = new File(var4_2.replace((CharSequence)"-1", (CharSequence)"-2"))).exists()) {
                    var7_5.delete();
                }
                if ((var8_6 = new File(var4_2.replace((CharSequence)"-2", (CharSequence)""))).exists()) {
                    var8_6.delete();
                }
                if ((var9_7 = new File(var4_2.replace((CharSequence)"-1", (CharSequence)""))).exists()) {
                    var9_7.delete();
                }
            }
            ** GOTO lbl38
            catch (Exception var2_14) {
                System.out.println("Exception e" + var2_14.toString());
            }
lbl38: // 3 sources:
            Utils.exitFromRootJava();
            return;
        }
    }

}

