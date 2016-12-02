package com.chelpus.root.utils;

import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.google.util.Base64;
import com.google.android.finsky.billing.iab.google.util.Base64DecoderException;
import java.io.File;

public class WriteSettingsXposed {
    public static void main(String[] params) {
        Utils.startRootJava(new Object() {
        });
        try {
            Utils.save_text_to_file(new File("/data/lp/xposed"), new String(Base64.decode(params[0])));
            new File("/data/lp/xposed").setLastModified(System.currentTimeMillis());
        } catch (Base64DecoderException e) {
            e.printStackTrace();
        }
        Utils.run_all_no_root("chmod", "777", "/data/lp/xposed");
    }
}
