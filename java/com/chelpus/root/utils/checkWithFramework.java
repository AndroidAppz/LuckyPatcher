package com.chelpus.root.utils;

import android.util.Log;
import com.chelpus.Utils;

public class checkWithFramework {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        try {
            Log.d("", "");
            System.out.println("found wtchFrm");
            Utils.exitFromRootJava();
        } catch (UnsatisfiedLinkError e) {
            System.out.println("withoutFramework");
        }
    }
}
