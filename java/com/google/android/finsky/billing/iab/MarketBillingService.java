/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.os.Bundle
 *  android.os.IBinder
 *  com.android.vending.billing.IMarketBillingService
 *  com.android.vending.billing.IMarketBillingService$Stub
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Random
 */
package com.google.android.finsky.billing.iab;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import com.android.vending.billing.IMarketBillingService;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import java.io.PrintStream;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MarketBillingService
extends Service {
    public static final String TAG = "BillingHack";
    private static Context context;
    private static String dev_pay;
    private static String item;
    private static Random sRandom;
    private final IMarketBillingService.Stub mBinder;
    BillingNotifier mNotifier;
    PackageManager mPackageManager;

    static {
        item = "";
        dev_pay = "";
        sRandom = new Random();
        sRandom = new Random();
    }

    public MarketBillingService() {
        this.mBinder = new IMarketBillingService.Stub(){
            long request_id;

            private long getNextInAppRequestId() {
                this.request_id = Long.MAX_VALUE & sRandom.nextLong();
                return this.request_id;
            }

            private int updateWithRequestId(Bundle bundle, long l) {
                bundle.putLong("REQUEST_ID", l);
                return 0;
            }

            public long confirmNotifications(String string, String[] arrstring) {
                return super.getNextInAppRequestId();
            }

            public long restoreTransactions(String string, long l) {
                return super.getNextInAppRequestId();
            }

            /*
             * Exception decompiling
             */
            public Bundle sendBillingRequest(Bundle var1) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // java.util.ConcurrentModificationException
                // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredDo.transformStructuredChildren(StructuredDo.java:53)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
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
        };
        this.mNotifier = new BillingNotifier(this);
    }

    static /* synthetic */ String access$000() {
        return item;
    }

    static /* synthetic */ String access$002(String string) {
        item = string;
        return string;
    }

    static /* synthetic */ String access$100() {
        return dev_pay;
    }

    static /* synthetic */ String access$102(String string) {
        dev_pay = string;
        return string;
    }

    public static Intent findReceiverName(Context context, String string, Intent intent) {
        ListIterator listIterator = listAppsFragment.getPkgMng().queryBroadcastReceivers(intent, 0).listIterator();
        while (listIterator.hasNext()) {
            Object object = listIterator.next();
            if (((ResolveInfo)object).activityInfo == null || !string.equals((Object)((ResolveInfo)object).activityInfo.packageName)) continue;
            intent.setClassName(string, ((ResolveInfo)object).activityInfo.name);
            intent.setPackage(string);
            return intent;
        }
        System.out.println("Cannot find billing receiver in package '" + string + "' for action: " + intent.getAction());
        return null;
    }

    public static boolean sendResponseCode(Context context, String string, long l, int n) {
        Intent intent = MarketBillingService.findReceiverName(listAppsFragment.getInstance(), string, new Intent("com.android.vending.billing.RESPONSE_CODE"));
        if (intent == null) {
            return false;
        }
        intent.putExtra("request_id", l);
        intent.putExtra("response_code", n);
        listAppsFragment.getInstance().sendBroadcast(intent);
        return true;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public class BillingNotifier {
        private MarketBillingService mService;

        public BillingNotifier(MarketBillingService marketBillingService2) {
            this.mService = marketBillingService2;
        }

        protected boolean sendPurchaseStateChanged(String string, String string2, String string3) {
            Intent intent = MarketBillingService.findReceiverName((Context)this.mService, string, new Intent("com.android.vending.billing.PURCHASE_STATE_CHANGED"));
            if (intent == null) {
                return false;
            }
            intent.putExtra("inapp_signed_data", string2);
            intent.putExtra("inapp_signature", string3);
            this.mService.sendBroadcast(intent);
            return true;
        }

        protected boolean sendResponseCode(String string, long l, int n) {
            return MarketBillingService.sendResponseCode((Context)this.mService, string, l, n);
        }
    }

}

