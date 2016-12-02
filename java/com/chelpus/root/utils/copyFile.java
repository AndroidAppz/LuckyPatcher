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

public class copyFile {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        File file = new File(arrstring[0]);
        File file2 = new File(arrstring[1]);
        new Utils("").setAllReadable(file);
        if (file.equals((Object)file2)) {
            System.out.println(file2.length());
            System.out.println("File copied!");
            Utils.exitFromRootJava();
            return;
        }
        System.out.println((Object)file);
        System.out.println((Object)file2);
        if (file.exists()) {
            try {
                Utils.copyFile(file, file2);
            }
            catch (IllegalArgumentException var5_3) {
                var5_3.printStackTrace();
            }
            catch (Exception var3_4) {
                var3_4.printStackTrace();
            }
            if (file.length() != file2.length() && file.length() != 0) {
                file2.delete();
                System.out.println("Length of Files not equals. Destination deleted!");
            } else {
                new Utils("").setAllWritable(file2);
                new Utils("").setAllReadable(file2);
                System.out.println(file2.length());
                System.out.println("File copied!");
            }
        } else {
            System.out.println("Source File not Found!");
        }
        Utils.exitFromRootJava();
    }

}

