package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class unusedodex {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        int j = 0;
        try {
            File appDir = new File("/data/app/");
            if (appDir.exists()) {
                for (File file : appDir.listFiles()) {
                    File TempFile = new File(Utils.changeExtension(file.toString(), "apk"));
                    if (file.toString().toLowerCase().endsWith(".odex") && !TempFile.exists()) {
                        file.delete();
                        System.out.println(file + "|");
                        j++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception e" + e.toString());
        }
        if (j > 0) {
            System.out.println("Unused ODEX in /data/app/ removed!");
        }
        Utils.exitFromRootJava();
    }
}
