package com.google.android.finsky.services;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.android.vending.licensing.ILicenseResultListener;
import com.android.vending.licensing.ILicensingService;
import com.android.vending.licensing.ILicensingService.Stub;
import com.chelpus.Common;
import com.chelpus.Utils;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import pxb.android.ResConst;

public class LicensingService extends Service {
    static ServiceConnection mServiceConn;
    private final Stub mBinder = new Stub() {
        public void checkLicense(long nonce, String packageName, ILicenseResultListener listener) throws RemoteException {
            try {
                PackageInfo v1 = LicensingService.this.getPackageManager().getPackageInfo(packageName, 0);
                LicensingService.this.connectToLicensing(nonce, packageName);
                if (LicensingService.this.responseCode == 255 || LicensingService.this.responseCode != 0) {
                    String signedData = "0|" + nonce + "|" + packageName + "|" + v1.versionCode + "|ANlOHQOShF3uJUwv3Ql+fbsgEG9FD35Hag==|" + (System.currentTimeMillis() + 31536000000L) + ":GR=10&VT=" + String.valueOf(System.currentTimeMillis() + Long.valueOf("31622400000").longValue()) + "&GT=" + String.valueOf((System.currentTimeMillis() + 31536000000L) + 31536000000L);
                    new Utils("w").waitLP(4000);
                    listener.verifyLicense(0, signedData, "hL9GqWwZL35OoLxZQN1EYmyylu3zmf8umnXW4P0EPqGjV0QcRYjD+NtiqoDEmxnnocvrqA7Z/0v+i0O4cwgOsD7/Tg3B1QI/ukA7ZUcibvFQUNoq7KjUWSg1Qn5MauaFFhAhZbuP840wnCuntxVDUkVJ6GDymDXLqhFG1LbZmNoPl6QjkschEBLVth1YtBxE4GnbVVI8Cq5LY7/F0N8d6EGLIISD6ekoD4lkhxq3nORsibX7kjmotyhLpO7THNMXvOeXeKhVp6dNSblOHp9tcL6l/NJY7sHPw/DBSxteW2hZ9y7yyaMxMAz+nTIN/V8gJXzeaRlmIXntJpQDEMz5pQ==");
                    return;
                }
                System.out.println("Transfer license from Google Play");
                listener.verifyLicense(LicensingService.this.responseCode, LicensingService.this.signedData, LicensingService.this.signature);
            } catch (Exception e) {
                try {
                    listener.verifyLicense(ResConst.RES_XML_START_ELEMENT_TYPE, null, null);
                } catch (RemoteException e2) {
                }
            }
        }
    };
    public LicenseChecker mChecker;
    private ILicenseResultListener mListener;
    ILicensingService mService;
    boolean mSetupDone = false;
    public int responseCode = 255;
    public String signature = "";
    public String signedData = "";

    public void connectToLicensing(long nonce, String pkgName) {
        final String str = pkgName;
        final long j = nonce;
        mServiceConn = new ServiceConnection() {
            public void onServiceDisconnected(ComponentName name) {
                System.out.println("Licensing service disconnected.");
                LicensingService.this.mService = null;
            }

            public void onServiceConnected(ComponentName name, IBinder service) {
                System.out.println("Licensing service try to connect.");
                LicensingService.this.mService = Stub.asInterface(service);
                try {
                    System.out.println("Calling checkLicense on service for " + str);
                    LicensingService.this.mService.checkLicense(j, str, new ILicenseResultListener.Stub() {
                        public void verifyLicense(int responseCode1, String signedData1, String signature1) throws RemoteException {
                            LicensingService.this.responseCode = responseCode1;
                            LicensingService.this.signedData = signedData1;
                            LicensingService.this.signature = signature1;
                            LicensingService.this.mSetupDone = true;
                        }
                    });
                } catch (RemoteException e) {
                    e.printStackTrace();
                    LicensingService.this.mSetupDone = true;
                }
            }
        };
        if (this.mService == null) {
            try {
                Intent intent = new Intent(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U=")));
                intent.setPackage(Common.GOOGLEPLAY_PKG);
                intent.putExtra("xexe", "lp");
                boolean bindResult = false;
                if (listAppsFragment.getPkgMng().queryIntentServices(intent, 0).isEmpty()) {
                    new Utils("w").waitLP(5000);
                }
                if (!listAppsFragment.getPkgMng().queryIntentServices(intent, 0).isEmpty()) {
                    for (ResolveInfo se : listAppsFragment.getPkgMng().queryIntentServices(intent, 0)) {
                        if (se.serviceInfo.packageName != null && se.serviceInfo.packageName.equals(Common.GOOGLEPLAY_PKG)) {
                            ComponentName component = new ComponentName(se.serviceInfo.packageName, se.serviceInfo.name);
                            intent = new Intent();
                            intent.setComponent(component);
                            intent.putExtra("xexe", "lp");
                            bindResult = listAppsFragment.getInstance().bindService(intent, mServiceConn, 1);
                        }
                    }
                }
                if (bindResult) {
                    int i = 0;
                    while (!this.mSetupDone) {
                        new Utils("w").waitLP(2000);
                        if (i > 10) {
                            break;
                        }
                        i++;
                    }
                    System.out.println("Stop licensing");
                    cleanupService();
                    return;
                }
                cleanupService();
            } catch (SecurityException e) {
                cleanupService();
            } catch (Base64DecoderException e2) {
                e2.printStackTrace();
                cleanupService();
            }
        }
    }

    private void cleanupService() {
        if (this.mService != null) {
            try {
                listAppsFragment.getInstance().unbindService(mServiceConn);
            } catch (IllegalArgumentException e) {
            }
            this.mService = null;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
