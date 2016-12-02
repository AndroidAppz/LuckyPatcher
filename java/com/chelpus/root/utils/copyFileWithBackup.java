/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class copyFileWithBackup {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        File file = new File(arrstring[0]);
        File file2 = new File(arrstring[1]);
        if (file.equals((Object)file2)) {
            System.out.println("File copied!");
            Utils.exitFromRootJava();
            return;
        }
        File file3 = new File(arrstring[1] + ".chelpus.tmp");
        System.out.println((Object)file);
        System.out.println((Object)file2);
        if (file.exists()) {
            try {
                Utils.copyFile(file, file3);
            }
            catch (IllegalArgumentException var9_4) {
                var9_4.printStackTrace();
            }
            catch (Exception var4_5) {
                var4_5.printStackTrace();
            }
            if (file.length() != file3.length() && file.length() != 0) {
                file3.delete();
                System.out.println("Length of Files not equals. Destination deleted!");
            } else {
                file2.delete();
                file3.renameTo(file2);
                if (!file3.exists() && file2.exists() && file.length() == file2.length()) {
                    if (new File(Utils.getPlaceForOdex(file2.getAbsolutePath(), true)).exists()) {
                        new File(Utils.getPlaceForOdex(file2.getAbsolutePath(), true)).delete();
                    }
                    System.out.println(file2.length());
                    System.out.println("File copied!");
                } else {
                    System.out.println("Backup not replace original!");
                }
            }
        } else {
            System.out.println("Source File not Found!");
        }
        Utils.exitFromRootJava();
    }

}

