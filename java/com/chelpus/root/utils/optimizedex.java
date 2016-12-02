package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.File;

public class optimizedex {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        String path_apk = paramArrayOfString[0];
        String uid = paramArrayOfString[1];
        String runtime = paramArrayOfString[2];
        String workingDir = listAppsFragment.toolfilesdir + "/tmp";
        int res = 255;
        if (Utils.classes_test(new File(path_apk))) {
            res = Utils.dexopt(path_apk, workingDir, Utils.getOdexForCreate(path_apk, uid), uid, Boolean.valueOf(runtime.equals("ART")));
        } else {
            System.out.println("chelpus_return_10");
        }
        if (res == 0) {
            System.out.println("chelpus_return_0");
        }
        if (res == 1) {
            System.out.println("chelpus_return_1");
        }
        if (res == 4) {
            System.out.println("chelpus_return_4");
        }
        Utils.exitFromRootJava();
    }
}
