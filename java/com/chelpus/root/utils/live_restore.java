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

public class live_restore {
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void main(String[] var0) {
        Utils.startRootJava(new Object(){});
        var1_1 = live_restore.dalvikDexIn.replace((CharSequence)"zamenitetodelo", (CharSequence)var0[0]);
        try {
            var2_2 = new File(var1_1);
            if (!var2_2.exists()) {
                var2_2 = new File(var1_1.replace((CharSequence)"-1", (CharSequence)"-2"));
            }
            var5_3 = new File(var1_1.replace((CharSequence)"-1", (CharSequence)""));
            if (var2_2.exists()) {
                var5_3 = var2_2;
            }
            if ((var7_5 = new File(var6_4 = var1_1.replace((CharSequence)"data@app", (CharSequence)"mnt@asec").replace((CharSequence)".apk@classes.dex", (CharSequence)"@pkg.apk@classes.dex"))).exists()) {
                var5_3 = var7_5;
            }
            if ((var8_6 = new File(var6_4.replace((CharSequence)"-1", (CharSequence)"-2"))).exists()) {
                var5_3 = var8_6;
            }
            if ((var9_7 = new File(var6_4.replace((CharSequence)"-1", (CharSequence)""))).exists()) {
                var5_3 = var9_7;
            }
            if (!var5_3.exists()) {
                throw new FileNotFoundException();
            }
            var10_9 = new File(var5_3.getAbsolutePath().replace((CharSequence)"classes", (CharSequence)"backup"));
            if (!var10_9.exists()) {
                throw new FileNotFoundException();
            }
            Utils.copyFile(var10_9, var5_3);
            System.out.println("Restore - done!");
            ** GOTO lbl29
        }
        catch (FileNotFoundException var4_8) {
            System.out.println("Error: Backup files are not found!");
            ** GOTO lbl29
            catch (Exception var3_10) {
                System.out.println("Exception e" + var3_10.toString());
            }
lbl29: // 3 sources:
            Utils.exitFromRootJava();
            return;
        }
    }

}

