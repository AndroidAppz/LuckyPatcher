/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class rename {
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        File file = new File(arrstring[0]);
        File file2 = new File(arrstring[1]);
        System.out.println((Object)file);
        System.out.println((Object)file2);
        file.renameTo(file2);
        System.out.println("File rename from " + (Object)file + " to " + (Object)file2);
        Utils.exitFromRootJava();
    }

}

