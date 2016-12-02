/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.google.util.Base64;
import com.google.android.finsky.billing.iab.google.util.Base64DecoderException;
import java.io.File;

public class WriteSettingsXposed {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] arrstring) {
        Utils.startRootJava(new Object(){});
        try {
            Utils.save_text_to_file(new File("/data/lp/xposed"), new String(Base64.decode(arrstring[0])));
            new File("/data/lp/xposed").setLastModified(System.currentTimeMillis());
        }
        catch (Base64DecoderException var1_1) {
            var1_1.printStackTrace();
        }
        Utils.run_all_no_root("chmod", "777", "/data/lp/xposed");
    }

}

