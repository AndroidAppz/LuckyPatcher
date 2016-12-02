/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class checkDataSize {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] arrstring) {
        float f;
        Utils.startRootJava(null);
        File file = new File(arrstring[0]);
        Utils utils = new Utils("calculSize");
        try {
            float f2;
            f = f2 = utils.sizeFolder(file, true);
        }
        catch (IOException var3_7) {
            var3_7.printStackTrace();
            f = 0.0f;
        }
        PrintStream printStream = System.out;
        Object[] arrobject = new Object[]{Float.valueOf((float)f)};
        printStream.println(String.format((String)"%.3f", (Object[])arrobject));
        Utils.exitFromRootJava();
    }
}

