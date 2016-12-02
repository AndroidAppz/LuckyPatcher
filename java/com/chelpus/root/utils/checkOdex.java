package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import net.lingala.zip4j.util.InternalZipConstants;

public class checkOdex {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        File dirodex = new File(Utils.getPlaceForOdex(paramArrayOfString[0], true));
        File dirapp = new File(paramArrayOfString[1] + InternalZipConstants.ZIP_FILE_SEPARATOR + paramArrayOfString[2]);
        if (dirodex.length() == 0) {
            dirodex.delete();
        }
        if (!dirodex.exists() || dirodex.length() == 0) {
            try {
                if (dirapp.exists()) {
                    try {
                        Utils.copyFile(dirapp, dirodex);
                    } catch (Exception e) {
                        e.printStackTrace();
                        dirodex.delete();
                    }
                    if (dirapp.length() != dirodex.length()) {
                        dirodex.delete();
                    }
                    if (dirodex.length() == 0) {
                        dirodex.delete();
                    }
                    if (dirodex.exists() && dirodex.length() != 0) {
                        System.out.println("ODEX FILE FOUND!");
                    }
                } else {
                    System.out.println("ODEX FILE NOT FOUND!");
                }
            } catch (Exception e2) {
                System.out.println("Exception e" + e2.toString());
            }
            Utils.exitFromRootJava();
        }
        System.out.println("ODEX FILE FOUND!");
        Utils.exitFromRootJava();
    }
}
