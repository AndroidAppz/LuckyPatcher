package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;

public class live_backup {
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";

    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        String dalvikDex = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
        try {
            File localFile1 = new File(dalvikDex);
            if (!localFile1.exists()) {
                localFile1 = new File(dalvikDex.replace("-1", "-2"));
            }
            File localFile2 = new File(dalvikDex.replace("-1", ""));
            if (localFile1.exists()) {
                localFile2 = localFile1;
            }
            String dalvikDexTemp = dalvikDex.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
            localFile1 = new File(dalvikDexTemp);
            if (localFile1.exists()) {
                localFile2 = localFile1;
            }
            localFile1 = new File(dalvikDexTemp.replace("-1", "-2"));
            if (localFile1.exists()) {
                localFile2 = localFile1;
            }
            localFile1 = new File(dalvikDexTemp.replace("-1", ""));
            if (localFile1.exists()) {
                localFile2 = localFile1;
            }
            if (localFile2.exists()) {
                Utils.copyFile(localFile2, new File(localFile2.getAbsolutePath().replace("classes", "backup")));
                System.out.println("Backup - done!");
                Utils.exitFromRootJava();
                return;
            }
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Backup failed!");
        } catch (Exception e2) {
            System.out.println("Exception e" + e2.toString());
        }
    }
}
