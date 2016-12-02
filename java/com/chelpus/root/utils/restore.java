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

public class restore {
    private static String dalvikDexIn;
    private static String dalvikDexIn2;

    static {
        dalvikDexIn2 = "/cache/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
        dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void main(String[] var0) {
        Utils.startRootJava();
        var1_1 = restore.dalvikDexIn.replace((CharSequence)"zamenitetodelo", (CharSequence)var0[0]);
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
            if (!(var11_9 = new File(var10_8 = restore.dalvikDexIn2.replace((CharSequence)"zamenitetodelo", (CharSequence)var0[0]))).exists()) {
                var11_9 = new File(var10_8.replace((CharSequence)"-1", (CharSequence)"-2"));
            }
            if (!var11_9.exists()) {
                var11_9 = new File(var10_8.replace((CharSequence)"-1", (CharSequence)""));
            }
            if (var11_9.exists()) {
                var5_3 = var11_9;
            }
            if ((var13_11 = new File(var12_10 = var10_8.replace((CharSequence)"data@app", (CharSequence)"mnt@asec").replace((CharSequence)".apk@classes.dex", (CharSequence)"@pkg.apk@classes.dex"))).exists()) {
                var5_3 = var13_11;
            }
            if ((var14_12 = new File(var12_10.replace((CharSequence)"-1", (CharSequence)"-2"))).exists()) {
                var5_3 = var14_12;
            }
            if ((var15_13 = new File(var12_10.replace((CharSequence)"-1", (CharSequence)""))).exists()) {
                var5_3 = var15_13;
            }
            if (!(var17_15 = new File(var16_14 = restore.dalvikDexIn.replace((CharSequence)"zamenitetodelo", (CharSequence)var0[0]).replace((CharSequence)"/data/", (CharSequence)"/sd-ext/data/"))).exists()) {
                var17_15 = new File(var16_14.replace((CharSequence)"-1", (CharSequence)"-2"));
            }
            if (!var17_15.exists()) {
                var17_15 = new File(var16_14.replace((CharSequence)"-1", (CharSequence)""));
            }
            if (var17_15.exists()) {
                var5_3 = var17_15;
            }
            if ((var19_17 = new File(var18_16 = var16_14.replace((CharSequence)"data@app", (CharSequence)"mnt@asec").replace((CharSequence)".apk@classes.dex", (CharSequence)"@pkg.apk@classes.dex"))).exists()) {
                var5_3 = var19_17;
            }
            if ((var20_18 = new File(var18_16.replace((CharSequence)"-1", (CharSequence)"-2"))).exists()) {
                var5_3 = var20_18;
            }
            if ((var21_19 = new File(var18_16.replace((CharSequence)"-1", (CharSequence)""))).exists()) {
                var5_3 = var21_19;
            }
            if (!(var23_21 = new File(var22_20 = restore.dalvikDexIn2.replace((CharSequence)"zamenitetodelo", (CharSequence)var0[0]).replace((CharSequence)"/cache/", (CharSequence)"/sd-ext/data/cache/"))).exists()) {
                var23_21 = new File(var22_20.replace((CharSequence)"-1", (CharSequence)"-2"));
            }
            if (!var23_21.exists()) {
                var23_21 = new File(var22_20.replace((CharSequence)"-1", (CharSequence)""));
            }
            if (var23_21.exists()) {
                var5_3 = var23_21;
            }
            if ((var25_23 = new File(var24_22 = var22_20.replace((CharSequence)"data@app", (CharSequence)"mnt@asec").replace((CharSequence)".apk@classes.dex", (CharSequence)"@pkg.apk@classes.dex"))).exists()) {
                var5_3 = var25_23;
            }
            if ((var26_24 = new File(var24_22.replace((CharSequence)"-1", (CharSequence)"-2"))).exists()) {
                var5_3 = var26_24;
            }
            if ((var27_25 = new File(var24_22.replace((CharSequence)"-1", (CharSequence)""))).exists()) {
                var5_3 = var27_25;
            }
            if (!var5_3.exists()) {
                throw new FileNotFoundException();
            }
            var28_27 = new File(var5_3.getAbsolutePath().replace((CharSequence)"classes", (CharSequence)"backup"));
            if (!var28_27.exists()) {
                throw new FileNotFoundException();
            }
            Utils.copyFile(var28_27, var5_3);
            System.out.println("Restore - done!");
            ** GOTO lbl65
        }
        catch (FileNotFoundException var4_26) {
            System.out.println("Error: Backup files are not found!");
            ** GOTO lbl65
            catch (Exception var3_28) {
                System.out.println("Exception e" + var3_28.toString());
            }
lbl65: // 3 sources:
            Utils.exitFromRootJava();
            return;
        }
    }
}

