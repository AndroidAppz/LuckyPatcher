/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.util.Log
 *  com.android.vending.billing.IInAppBillingService
 *  com.android.vending.billing.IInAppBillingService$Stub
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  java.io.PrintStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.List
 */
package com.google.android.finsky.billing.iab;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.BuyActivity;
import com.google.android.finsky.billing.iab.DbHelper;
import com.google.android.finsky.billing.iab.ItemsListItem;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class InAppBillingService
extends Service {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String ITEM_TYPE_SUBS = "subs";
    public static final String TAG = "BillingHack";
    static ServiceConnection mServiceConn;
    boolean googleBillingDisabled = false;
    IBinder mB = null;
    private final IInAppBillingService.Stub mBinder;
    Context mContext;
    IInAppBillingService mService;
    boolean mSetupDone = false;
    boolean skipSetupDone = false;

    public InAppBillingService() {
        this.mBinder = new IInAppBillingService.Stub(){
            final ArrayList<String> productIDinapp;
            final ArrayList<String> productIDsubs;

            public int consumePurchase(int n, String string, String string2) throws RemoteException {
                Log.d((String)"BillingHack", (String)"consumePurchase");
                return 0;
            }

            public Bundle getBuyIntent(int n, String string, String string2, String string3, String string4) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putInt("RESPONSE_CODE", 0);
                Intent intent = new Intent();
                intent.setClass(InAppBillingService.this.getApplicationContext(), (Class)BuyActivity.class);
                intent.setAction("com.google.android.finsky.billing.iab.BUY");
                intent.addFlags(3);
                intent.putExtra("packageName", string);
                intent.putExtra("product", string2);
                intent.putExtra("payload", string4);
                intent.putExtra("Type", string3);
                ArrayList<ItemsListItem> arrayList = new DbHelper(InAppBillingService.this.mContext, string).getItems();
                if (arrayList.size() != 0) {
                    for (ItemsListItem itemsListItem : arrayList) {
                        if (itemsListItem.autobuy != 1 || !itemsListItem.itemID.equals((Object)string2)) continue;
                        intent.putExtra("autorepeat", itemsListItem.pSignature);
                    }
                }
                bundle.putParcelable("BUY_INTENT", (Parcelable)PendingIntent.getActivity((Context)InAppBillingService.this.getApplicationContext(), (int)0, (Intent)intent, (int)134217728));
                return bundle;
            }

            public Bundle getBuyIntentToReplaceSkus(int n, String string, List list, String string2, String string3, String string4) throws RemoteException {
                System.out.println("LuckyPatcher: use api 5 getBuyIntentToReplaceSkus");
                Bundle bundle = new Bundle();
                bundle.putInt("RESPONSE_CODE", 0);
                Intent intent = new Intent();
                intent.setClass(InAppBillingService.this.getApplicationContext(), (Class)BuyActivity.class);
                intent.setAction("com.google.android.finsky.billing.iab.BUY");
                intent.addFlags(3);
                intent.putExtra("packageName", string);
                intent.putExtra("product", string2);
                intent.putExtra("payload", string4);
                intent.putExtra("Type", string3);
                bundle.putParcelable("BUY_INTENT", (Parcelable)PendingIntent.getActivity((Context)InAppBillingService.this.getApplicationContext(), (int)0, (Intent)intent, (int)134217728));
                return bundle;
            }

            public Bundle getPurchases(int n, String string, String string2, String string3) throws RemoteException {
                Log.d((String)"BillingHack", (String)"getPurchases");
                ArrayList<ItemsListItem> arrayList = new DbHelper(InAppBillingService.this.mContext, string).getItems();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                if (arrayList.size() != 0) {
                    for (ItemsListItem itemsListItem : arrayList) {
                        if (itemsListItem.savePurchase != 1) continue;
                        arrayList2.add((Object)itemsListItem.itemID);
                        arrayList3.add((Object)itemsListItem.pData);
                        if (itemsListItem.pSignature.equals((Object)"1")) {
                            arrayList4.add((Object)Utils.gen_sha1withrsa(itemsListItem.pData));
                            continue;
                        }
                        arrayList4.add((Object)"");
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putInt("RESPONSE_CODE", 0);
                bundle.putStringArrayList("INAPP_PURCHASE_ITEM_LIST", arrayList2);
                bundle.putStringArrayList("INAPP_PURCHASE_DATA_LIST", arrayList3);
                bundle.putStringArrayList("INAPP_DATA_SIGNATURE_LIST", arrayList4);
                return bundle;
            }

            /*
             * Exception decompiling
             */
            public Bundle getSkuDetails(int var1_1, String var2_4, String var3_3, Bundle var4) throws RemoteException {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // java.util.ConcurrentModificationException
                // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
                // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
                // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
                // org.benf.cfr.reader.Main.doJar(Main.java:128)
                // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
                // java.lang.Thread.run(Thread.java:818)
                throw new IllegalStateException("Decompilation failed");
            }

            public int isBillingSupported(int n, String string, String string2) throws RemoteException {
                Log.d((String)"BillingHack", (String)"isBillingSupported");
                InAppBillingService.this.startGoogleBilling();
                return 0;
            }

            public int isPromoEligible(int n, String string, String string2) throws RemoteException {
                return 0;
            }
        };
    }

    public void connectToBilling(final String string) {
        this.startGoogleBilling();
        if (this.mSetupDone) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        mServiceConn = new ServiceConnection(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                System.out.println("Billing service try to connect.");
                InAppBillingService.this.mService = IInAppBillingService.Stub.asInterface((IBinder)iBinder);
                try {
                    int n = InAppBillingService.this.mService.isBillingSupported(3, string, "inapp");
                    if (n != 0) {
                        System.out.println("bill error:" + n);
                        InAppBillingService.this.skipSetupDone = true;
                        return;
                    }
                    if (InAppBillingService.this.mService.isBillingSupported(3, string, "subs") == 0) {
                        // empty if block
                    }
                    System.out.println("Billing service connected.");
                    InAppBillingService.this.mSetupDone = true;
                    return;
                }
                catch (RemoteException var3_4) {
                    var3_4.printStackTrace();
                    return;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                System.out.println("Billing service disconnected.");
                InAppBillingService.this.mService = null;
                InAppBillingService.this.mSetupDone = false;
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        intent.putExtra("xexe", "lp");
        if (listAppsFragment.getPkgMng().queryIntentServices(intent, 0).isEmpty()) {
            new Utils("w").waitLP(2000);
        }
        if (!listAppsFragment.getPkgMng().queryIntentServices(intent, 0).isEmpty()) {
            block0 : for (ResolveInfo resolveInfo : listAppsFragment.getPkgMng().queryIntentServices(intent, 0)) {
                if (resolveInfo.serviceInfo.packageName == null || !resolveInfo.serviceInfo.packageName.equals((Object)"com.android.vending")) continue;
                ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                Intent intent2 = new Intent();
                intent2.setComponent(componentName);
                intent2.putExtra("xexe", "lp");
                if (!listAppsFragment.getInstance().bindService(intent2, mServiceConn, 1)) continue;
                int n = 0;
                while (!this.mSetupDone && !this.skipSetupDone) {
                    new Utils("w").waitLP(500);
                    if (++n != 30) continue;
                    continue block0;
                }
            }
        } else {
            System.out.println("Billing service unavailable on device.");
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public IBinder onBind(Intent intent) {
        if (intent == null) return this.mBinder;
        if (intent.getStringExtra("xexe") != null && intent.getStringExtra("xexe").equals((Object)"lp") && intent.getPackage() == null) {
            System.out.println("Connect from proxy.");
            this.mSetupDone = false;
            this.skipSetupDone = true;
            return this.mBinder;
        }
        System.out.println("Connect from patch.");
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        System.out.println("create bill+skip:" + this.skipSetupDone);
        this.mContext = this;
        if (listAppsFragment.su) {
            this.startGoogleBilling();
        }
    }

    public void onDestroy() {
        System.out.println("destroy billing");
        super.onDestroy();
    }

    /*
     * Enabled aggressive block sorting
     */
    public int onStartCommand(Intent intent, int n, int n2) {
        if (intent == null) return super.onStartCommand(intent, n, n2);
        if (intent.getStringExtra("xexe") != null && intent.getStringExtra("xexe").equals((Object)"lp")) {
            this.skipSetupDone = true;
            return super.onStartCommand(intent, n, n2);
        }
        System.out.println("Connect from app.");
        return super.onStartCommand(intent, n, n2);
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        System.out.println("on Task Removed billing");
    }

    public boolean onUnbind(Intent intent) {
        System.out.println("destroy billing");
        return super.onUnbind(intent);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    void startGoogleBilling() {
        PackageInfo packageInfo;
        listAppsFragment.init((Context)this);
        if (!listAppsFragment.su) return;
        try {}
        catch (PackageManager.NameNotFoundException var1_3) {
            var1_3.printStackTrace();
            return;
        }
        PackageInfo packageInfo2 = packageInfo = listAppsFragment.getPkgMng().getPackageInfo("com.android.vending", 516);
        if (packageInfo2 == null) return;
        if (packageInfo2.services == null) return;
        if (packageInfo2.services.length == 0) return;
        int n = 0;
        while (n < packageInfo2.services.length) {
            try {
                if ((packageInfo2.services[n].name.endsWith("InAppBillingService") || packageInfo2.services[n].name.endsWith("MarketBillingService")) && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName("com.android.vending", packageInfo2.services[n].name)) != 1) {
                    this.googleBillingDisabled = true;
                    Utils.market_billing_services(true);
                }
            }
            catch (Exception var4_5) {
                var4_5.printStackTrace();
            }
            ++n;
        }
    }

}

