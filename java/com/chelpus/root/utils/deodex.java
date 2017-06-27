package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import net.lingala.zip4j.util.InternalZipConstants;

public class deodex {
    public static void main(String[] paramArrayOfString) {
        File backFile;
        Utils.startRootJava(new Object() {
        });
        Utils.kill(paramArrayOfString[0]);
        Utils.remount(paramArrayOfString[1], InternalZipConstants.WRITE_MODE);
        String backTemp;
        try {
            if (Utils.getFileDalvikCache(paramArrayOfString[1]) == null) {
                throw new FileNotFoundException();
            }
            backTemp = Utils.getPlaceForOdex(paramArrayOfString[1], true);
            backFile = new File(backTemp);
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp.replace("-2", "-1"));
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp.replace("-1", "-2"));
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp.replace("-2", ""));
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp.replace("-1", ""));
            if (backFile.exists()) {
                backFile.delete();
            }
            Utils.exitFromRootJava();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
            if (Utils.classes_test(new File(paramArrayOfString[1]))) {
                backTemp = Utils.getPlaceForOdex(paramArrayOfString[1], true);
                backFile = new File(backTemp);
                if (backFile.exists()) {
                    backFile.delete();
                }
                backFile = new File(backTemp.replace("-2", "-1"));
                if (backFile.exists()) {
                    backFile.delete();
                }
                backFile = new File(backTemp.replace("-1", "-2"));
                if (backFile.exists()) {
                    backFile.delete();
                }
                backFile = new File(backTemp.replace("-2", ""));
                if (backFile.exists()) {
                    backFile.delete();
                }
                backFile = new File(backTemp.replace("-1", ""));
                if (backFile.exists()) {
                    backFile.delete();
                }
            }
        } catch (Exception e2) {
            System.out.println("Exception e" + e2.toString());
        }
    }
}
