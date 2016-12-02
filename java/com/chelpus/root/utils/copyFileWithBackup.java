package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class copyFileWithBackup {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        File source = new File(paramArrayOfString[0]);
        File destination = new File(paramArrayOfString[1]);
        if (source.equals(destination)) {
            System.out.println("File copied!");
            Utils.exitFromRootJava();
            return;
        }
        File destination_tmp = new File(paramArrayOfString[1] + ".chelpus.tmp");
        System.out.println(source);
        System.out.println(destination);
        if (source.exists()) {
            try {
                Utils.copyFile(source, destination_tmp);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (source.length() == destination_tmp.length() || source.length() == 0) {
                destination.delete();
                destination_tmp.renameTo(destination);
                if (!destination_tmp.exists() && destination.exists() && source.length() == destination.length()) {
                    if (new File(Utils.getPlaceForOdex(destination.getAbsolutePath(), true)).exists()) {
                        new File(Utils.getPlaceForOdex(destination.getAbsolutePath(), true)).delete();
                    }
                    System.out.println(destination.length());
                    System.out.println("File copied!");
                } else {
                    System.out.println("Backup not replace original!");
                }
            } else {
                destination_tmp.delete();
                System.out.println("Length of Files not equals. Destination deleted!");
            }
        } else {
            System.out.println("Source File not Found!");
        }
        Utils.exitFromRootJava();
    }
}
