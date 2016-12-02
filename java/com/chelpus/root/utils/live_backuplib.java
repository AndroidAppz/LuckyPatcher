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

public class live_backuplib {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void main(String[] var0) {
        Utils.startRootJava(new Object(){});
        var1_1 = var0[0];
        try {
            var2_2 = new File(var1_1);
            var3_3 = new File(var1_1.replace((CharSequence)"/data/data/", (CharSequence)"/mnt/asec/"));
            if (var2_2.exists()) {
                var3_3 = var2_2;
            }
            if (!var3_3.exists()) {
                var3_3 = new File(var1_1 + "-1");
            }
            if (!var3_3.exists()) {
                var3_3 = new File(var1_1.replace((CharSequence)"-1", (CharSequence)"-2"));
            }
            if (!var3_3.exists()) {
                throw new FileNotFoundException();
            }
            Utils.copyFile(var3_3, new File(var3_3.getAbsolutePath() + ".backup"));
            System.out.println("Backup - done!");
            ** GOTO lbl22
        }
        catch (FileNotFoundException var5_4) {
            System.out.println("Error: Backup failed!\n\nMove Program to internal storage.");
            ** GOTO lbl22
            catch (Exception var4_5) {
                System.out.println("Exception e" + var4_5.toString());
            }
lbl22: // 3 sources:
            Utils.exitFromRootJava();
            return;
        }
    }

}

