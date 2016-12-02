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

public class unusedodex {
    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void main(String[] var0) {
        Utils.startRootJava(new Object(){});
        var1_1 = 0;
        var2_2 = new File("/data/app/");
        var4_3 = var2_2.exists();
        var1_1 = 0;
        ** if (!var4_3) goto lbl-1000
lbl-1000: // 1 sources:
        {
            var5_4 = var2_2.listFiles();
            var6_5 = var5_4.length;
            for (var7_6 = 0; var7_6 < var6_5; ++var7_6) {
                var8_7 = var5_4[var7_6];
                var9_8 = new File(Utils.changeExtension(var8_7.toString(), "apk"));
                if (!var8_7.toString().toLowerCase().endsWith(".odex") || var9_8.exists()) continue;
                var8_7.delete();
                System.out.println((Object)var8_7 + "|");
                ++var1_1;
            }
        }
lbl-1000: // 1 sources:
        {
        }
        {
            catch (Exception var3_9) {
                System.out.println("Exception e" + var3_9.toString());
                break;
            }
        }
        if (var1_1 > 0) {
            System.out.println("Unused ODEX in /data/app/ removed!");
        }
        Utils.exitFromRootJava();
    }

}

