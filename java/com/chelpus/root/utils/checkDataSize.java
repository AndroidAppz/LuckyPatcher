package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.IOException;

public class checkDataSize {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(null);
        float size = 0.0f;
        try {
            size = new Utils("calculSize").sizeFolder(new File(paramArrayOfString[0]), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%.3f", new Object[]{Float.valueOf(size)}));
        Utils.exitFromRootJava();
    }
}
