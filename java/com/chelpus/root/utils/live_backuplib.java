package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;

public class live_backuplib {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        String dalvikDex = paramArrayOfString[0];
        try {
            File localFile1 = new File(dalvikDex);
            File localFile2 = new File(dalvikDex.replace("/data/data/", "/mnt/asec/"));
            if (localFile1.exists()) {
                localFile2 = localFile1;
            }
            if (!localFile2.exists()) {
                localFile2 = new File(new StringBuilder(String.valueOf(dalvikDex)).append("-1").toString());
            }
            if (!localFile2.exists()) {
                localFile2 = new File(dalvikDex.replace("-1", "-2"));
            }
            if (localFile2.exists()) {
                Utils.copyFile(localFile2, new File(localFile2.getAbsolutePath() + ".backup"));
                System.out.println("Backup - done!");
                Utils.exitFromRootJava();
                return;
            }
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Backup failed!\n\nMove Program to internal storage.");
        } catch (Exception e2) {
            System.out.println("Exception e" + e2.toString());
        }
    }
}
