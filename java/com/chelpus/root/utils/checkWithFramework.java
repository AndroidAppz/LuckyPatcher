/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsatisfiedLinkError
 */
package com.chelpus.root.utils;

import android.util.Log;
import com.chelpus.Utils;
import java.io.PrintStream;

public class checkWithFramework {
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        try {
            Log.d((String)"", (String)"");
        }
        catch (UnsatisfiedLinkError var1_1) {
            System.out.println("withoutFramework");
            return;
        }
        System.out.println("found wtchFrm");
        Utils.exitFromRootJava();
    }

}

