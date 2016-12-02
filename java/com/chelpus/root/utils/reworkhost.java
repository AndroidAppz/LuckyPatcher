/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class reworkhost {
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        Utils.save_text_to_file(new File("/system/etc/hosts"), "127.0.0.1       localhost\n");
        Utils.cmdParam("chmod", "0644", "/system/etc/hosts");
        Utils.exitFromRootJava();
    }

}

