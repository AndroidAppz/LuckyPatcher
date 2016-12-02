/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  com.android.vending.licensing.ILicenseResultListener
 *  com.android.vending.licensing.ILicenseResultListener$Stub
 *  com.android.vending.licensing.ILicensingService
 *  com.android.vending.licensing.ILicensingService$Stub
 *  com.google.android.vending.licensing.LicenseChecker
 *  com.google.android.vending.licensing.util.Base64
 *  com.google.android.vending.licensing.util.Base64DecoderException
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.System
 *  java.util.List
 */
package com.google.android.finsky.services;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.android.vending.licensing.ILicenseResultListener;
import com.android.vending.licensing.ILicensingService;
import com.chelpus.Utils;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.PrintStream;
import java.util.List;

public class LicensingService
extends Service {
    static ServiceConnection mServiceConn;
    private final ILicensingService.Stub mBinder;
    public LicenseChecker mChecker;
    private ILicenseResultListener mListener;
    ILicensingService mService;
    boolean mSetupDone = false;
    public int responseCode = 255;
    public String signature = "";
    public String signedData = "";

    public LicensingService() {
        this.mBinder = new ILicensingService.Stub(){

            public void checkLicense(long l, String string, ILicenseResultListener iLicenseResultListener) throws RemoteException {
                try {
                    PackageInfo packageInfo = LicensingService.this.getPackageManager().getPackageInfo(string, 0);
                    LicensingService.this.connectToLicensing(l, string);
                    if (LicensingService.this.responseCode != 255 && LicensingService.this.responseCode == 0) {
                        System.out.println("Transfer license from Google Play");
                        iLicenseResultListener.verifyLicense(LicensingService.this.responseCode, LicensingService.this.signedData, LicensingService.this.signature);
                        return;
                    }
                    String string2 = "0|" + l + "|" + string + "|" + packageInfo.versionCode + "|ANlOHQOShF3uJUwv3Ql+fbsgEG9FD35Hag==|" + (31536000000L + System.currentTimeMillis()) + ":GR=10&VT=" + String.valueOf((long)(System.currentTimeMillis() + Long.valueOf((String)"31622400000"))) + "&GT=" + String.valueOf((long)(31536000000L + (31536000000L + System.currentTimeMillis())));
                    new Utils("w").waitLP(4000);
                    iLicenseResultListener.verifyLicense(0, string2, "hL9GqWwZL35OoLxZQN1EYmyylu3zmf8umnXW4P0EPqGjV0QcRYjD+NtiqoDEmxnnocvrqA7Z/0v+i0O4cwgOsD7/Tg3B1QI/ukA7ZUcibvFQUNoq7KjUWSg1Qn5MauaFFhAhZbuP840wnCuntxVDUkVJ6GDymDXLqhFG1LbZmNoPl6QjkschEBLVth1YtBxE4GnbVVI8Cq5LY7/F0N8d6EGLIISD6ekoD4lkhxq3nORsibX7kjmotyhLpO7THNMXvOeXeKhVp6dNSblOHp9tcL6l/NJY7sHPw/DBSxteW2hZ9y7yyaMxMAz+nTIN/V8gJXzeaRlmIXntJpQDEMz5pQ==");
                    return;
                }
                catch (Exception var5_6) {
                    try {
                        iLicenseResultListener.verifyLicense(258, null, null);
                        return;
                    }
                    catch (RemoteException var6_7) {
                        return;
                    }
                }
            }
        };
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private void cleanupService() {
        if (this.mService == null) ** GOTO lbl8
        try {
            listAppsFragment.getInstance().unbindService(LicensingService.mServiceConn);
        }
        catch (IllegalArgumentException var1_1) {
            ** continue;
        }
lbl6: // 2 sources:
        do {
            this.mService = null;
lbl8: // 2 sources:
            return;
            break;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void connectToLicensing(final long var1, final String var3_2) {
        LicensingService.mServiceConn = new ServiceConnection(){

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                System.out.println("Licensing service try to connect.");
                LicensingService.this.mService = ILicensingService.Stub.asInterface((IBinder)iBinder);
                try {
                    System.out.println("Calling checkLicense on service for " + var3_2);
                    LicensingService.this.mService.checkLicense(var1, var3_2, (ILicenseResultListener)new ILicenseResultListener.Stub(){

                        public void verifyLicense(int n, String string, String string2) throws RemoteException {
                            LicensingService.this.responseCode = n;
                            if (LicensingService.this.responseCode == 259) {
                                // empty if block
                            }
                            LicensingService.this.signedData = string;
                            LicensingService.this.signature = string2;
                            LicensingService.this.mSetupDone = true;
                        }
                    });
                    return;
                }
                catch (RemoteException var3_3) {
                    var3_3.printStackTrace();
                    LicensingService.this.mSetupDone = true;
                    return;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                System.out.println("Licensing service disconnected.");
                LicensingService.this.mService = null;
            }

        };
        if (this.mService != null) return;
        try {
            var4_3 = new Intent(new String(Base64.decode((String)"Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U=")));
            var4_3.setPackage("com.android.vending");
            var4_3.putExtra("xexe", "lp");
            if (listAppsFragment.getPkgMng().queryIntentServices(var4_3, 0).isEmpty()) {
                new Utils("w").waitLP(5000);
            }
            var9_4 = listAppsFragment.getPkgMng().queryIntentServices(var4_3, 0).isEmpty();
            var10_5 = false;
            if (var9_4) ** GOTO lbl-1000
            for (ResolveInfo var13_7 : listAppsFragment.getPkgMng().queryIntentServices(var4_3, 0)) {
                if (var13_7.serviceInfo.packageName == null || !var13_7.serviceInfo.packageName.equals((Object)"com.android.vending")) continue;
                var14_8 = new ComponentName(var13_7.serviceInfo.packageName, var13_7.serviceInfo.name);
                var15_9 = new Intent();
                var15_9.setComponent(var14_8);
                var15_9.putExtra("xexe", "lp");
                var10_5 = listAppsFragment.getInstance().bindService(var15_9, LicensingService.mServiceConn, 1);
            }
            if (!var10_5) lbl-1000: // 2 sources:
            {
                super.cleanupService();
                return;
            }
            var12_10 = 0;
lbl24: // 2 sources:
            if (this.mSetupDone) ** GOTO lbl-1000
            new Utils("w").waitLP(2000);
            if (var12_10 > 10) lbl-1000: // 2 sources:
            {
                System.out.println("Stop licensing");
                super.cleanupService();
                return;
            }
        }
        catch (SecurityException var6_11) {
            super.cleanupService();
            return;
        }
        catch (Base64DecoderException var5_12) {
            var5_12.printStackTrace();
            super.cleanupService();
            return;
        }
        ++var12_10;
        ** GOTO lbl24
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

}

