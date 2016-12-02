package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;

public class rename {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        File file = new File(paramArrayOfString[0]);
        File new_name = new File(paramArrayOfString[1]);
        System.out.println(file);
        System.out.println(new_name);
        file.renameTo(new_name);
        System.out.println("File rename from " + file + " to " + new_name);
        Utils.exitFromRootJava();
    }
}
