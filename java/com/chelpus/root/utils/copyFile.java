package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class copyFile {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        File source = new File(paramArrayOfString[0]);
        File destination = new File(paramArrayOfString[1]);
        new Utils("").setAllReadable(source);
        if (source.equals(destination)) {
            System.out.println(destination.length());
            System.out.println("File copied!");
            Utils.exitFromRootJava();
            return;
        }
        System.out.println(source);
        System.out.println(destination);
        if (source.exists()) {
            try {
                Utils.copyFile(source, destination);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (source.length() == destination.length() || source.length() == 0) {
                new Utils("").setAllWritable(destination);
                new Utils("").setAllReadable(destination);
                System.out.println(destination.length());
                System.out.println("File copied!");
            } else {
                destination.delete();
                System.out.println("Length of Files not equals. Destination deleted!");
            }
        } else {
            System.out.println("Source File not Found!");
        }
        Utils.exitFromRootJava();
    }
}
