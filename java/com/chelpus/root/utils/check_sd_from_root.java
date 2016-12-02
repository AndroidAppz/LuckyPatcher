package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class check_sd_from_root {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        try {
            if (new File(paramArrayOfString[0] + "/test.tmp").exists()) {
                System.out.println("LuckyPatcher: Found test.tmp");
                new File(paramArrayOfString[0] + "/test.tmp").delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Utils.exitFromRootJava();
    }
}
