/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  java.io.File
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;
import java.io.PrintStream;

public class optimizedex {
    /*
     * Enabled aggressive block sorting
     */
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        String string = arrstring[0];
        String string2 = arrstring[1];
        String string3 = arrstring[2];
        String string4 = listAppsFragment.toolfilesdir + "/tmp";
        int n = 255;
        if (Utils.classes_test(new File(string))) {
            n = Utils.dexopt(string, string4, Utils.getOdexForCreate(string, string2), string2, string3.equals((Object)"ART"));
        } else {
            System.out.println("chelpus_return_10");
        }
        if (n == 0) {
            System.out.println("chelpus_return_0");
        }
        if (n == 1) {
            System.out.println("chelpus_return_1");
        }
        if (n == 4) {
            System.out.println("chelpus_return_4");
        }
        Utils.exitFromRootJava();
    }

}

