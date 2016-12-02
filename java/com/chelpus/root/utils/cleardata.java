package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class cleardata {
    public static void main(String[] paramArrayOfString) {
        String system;
        int i = 0;
        Utils.startRootJava(new Object() {
        });
        Utils ut = new Utils("clear data");
        try {
            system = paramArrayOfString[1];
        } catch (Exception e) {
            system = "not";
        }
        try {
            int length;
            String s;
            File appDir = new File(paramArrayOfString[0]);
            if (appDir.exists()) {
                for (String s2 : appDir.list()) {
                    if (!s2.equals("lib") || system.contains("system")) {
                        ut.deleteFolder(new File(appDir, s2));
                    }
                }
            }
            System.out.println("ok");
            appDir = new File(paramArrayOfString[0].replace("/data/data/", "/dbdata/databases/"));
            if (appDir.exists()) {
                for (String s22 : appDir.list()) {
                    if (!s22.equals("lib") || system.contains("system")) {
                        ut.deleteFolder(new File(appDir, s22));
                    }
                }
            }
            System.out.println("ok");
            appDir = new File(paramArrayOfString[0].replace("/data/data/", "/dbdata/data/"));
            if (appDir.exists()) {
                String[] children = appDir.list();
                length = children.length;
                while (i < length) {
                    s22 = children[i];
                    if (!s22.equals("lib") || system.contains("system")) {
                        ut.deleteFolder(new File(appDir, s22));
                    }
                    i++;
                }
            }
            System.out.println("ok");
            if (system.contains("system")) {
                appDir.delete();
            }
        } catch (Exception e2) {
            System.out.println("Exception e" + e2.toString());
        }
        Utils.exitFromRootJava();
    }
}
