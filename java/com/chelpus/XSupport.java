/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  de.robv.android.xposed.IXposedHookLoadPackage
 *  de.robv.android.xposed.IXposedHookZygoteInit
 *  de.robv.android.xposed.IXposedHookZygoteInit$StartupParam
 *  de.robv.android.xposed.XC_MethodHook
 *  de.robv.android.xposed.XC_MethodHook$MethodHookParam
 *  de.robv.android.xposed.XSharedPreferences
 *  de.robv.android.xposed.XposedBridge
 *  de.robv.android.xposed.XposedHelpers
 *  de.robv.android.xposed.callbacks.XC_LoadPackage
 *  de.robv.android.xposed.callbacks.XC_LoadPackage$LoadPackageParam
 *  java.io.PrintStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Package
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 */
package com.chelpus;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Common;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.InAppBillingService;
import com.google.android.finsky.billing.iab.MarketBillingService;
import com.google.android.finsky.services.LicensingService;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import java.io.PrintStream;
import java.util.List;

public class XSupport
implements IXposedHookLoadPackage,
IXposedHookZygoteInit {
    public static boolean enable;
    public static boolean hide;
    public static boolean patch1;
    public static boolean patch2;
    public static boolean patch3;
    public static boolean patch4;
    Context PMcontext = null;
    public boolean checkDuplicatedPermissions;
    public boolean checkPermissions;
    public boolean checkSignatures;
    Context ctx = null;
    public String currentPkgInApp = null;
    public boolean disableCheckSignatures;
    Boolean forHide = null;
    Boolean hideFromThisApp = null;
    public long initialize = 0;
    public boolean installUnsignedApps;
    Context mContext = null;
    public XSharedPreferences prefs;
    boolean skip1 = false;
    boolean skip2 = false;
    boolean skip3 = false;
    boolean skipGB = false;
    public boolean verifyApps;

    static {
        patch1 = true;
        patch2 = true;
        patch3 = true;
        patch4 = false;
        hide = false;
        enable = true;
    }

    /*
     * Exception decompiling
     */
    public boolean checkForHide(XC_MethodHook.MethodHookParam var1) {
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
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public boolean checkForHideApp(XC_MethodHook.MethodHookParam var1) {
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
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean checkIntentRework(XC_MethodHook.MethodHookParam methodHookParam, Intent intent, int n, int n2) {
        if (n2 == 0) {
            Context context;
            try {
                context = (Context)XposedHelpers.callMethod((Object)methodHookParam.thisObject, (String)"getBaseContext", (Object[])new Object[0]);
            }
            catch (ClassCastException var17_6) {
                context = (Context)XposedHelpers.getObjectField((Object)methodHookParam.thisObject, (String)"mBase");
            }
            if (context != null) {
                if (n == 0 && (context.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) != 2 || context.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) != 2)) {
                    if (intent.getStringExtra("xexe") != null && intent.getStringExtra("xexe").equals((Object)"lp")) {
                        return false;
                    }
                    return true;
                }
                if (n == 1 && context.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2) {
                    if (intent.getStringExtra("xexe") != null && intent.getStringExtra("xexe").equals((Object)"lp")) {
                        return false;
                    }
                    return true;
                }
            }
        }
        if (n2 == 1) {
            if (n == 0 && (((PackageManager)XposedHelpers.callMethod((Object)methodHookParam.thisObject, (String)"getPackageManager", (Object[])new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) != 2 || ((PackageManager)XposedHelpers.callMethod((Object)methodHookParam.thisObject, (String)"getPackageManager", (Object[])new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) != 2)) {
                String string;
                try {
                    String string2;
                    string = string2 = intent.getStringExtra("xexe");
                }
                catch (Exception var14_9) {
                    System.out.println("skip inapp xposed queryIntentServices");
                    return true;
                }
                if (string != null && string.equals((Object)"lp")) {
                    return false;
                }
                return true;
            }
            if (n == 1 && ((PackageManager)XposedHelpers.callMethod((Object)methodHookParam.thisObject, (String)"getPackageManager", (Object[])new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2) {
                String string;
                try {
                    String string3;
                    string = string3 = intent.getStringExtra("xexe");
                }
                catch (Exception var11_12) {
                    System.out.println("skip inapp xposed queryIntentServices");
                    return true;
                }
                if (string != null && string.equals((Object)"lp")) {
                    return false;
                }
                return true;
            }
        }
        if (n2 == 2) {
            if (n == 0 && (this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) != 2 || this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) != 2)) {
                String string;
                try {
                    String string4;
                    string = string4 = intent.getStringExtra("xexe");
                }
                catch (Exception var8_15) {
                    System.out.println("skip inapp xposed queryIntentServices");
                    return true;
                }
                if (string != null && string.equals((Object)"lp")) {
                    return false;
                }
                return true;
            }
            if (n == 1 && this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2) {
                String string;
                try {
                    String string5;
                    string = string5 = intent.getStringExtra("xexe");
                }
                catch (Exception var5_18) {
                    System.out.println("skip inapp xposed queryIntentServices");
                    return true;
                }
                if (string != null && string.equals((Object)"lp")) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (listAppsFragment.class.getPackage().getName().equals((Object)loadPackageParam.packageName)) {
            ClassLoader classLoader = loadPackageParam.classLoader;
            Object[] arrobject = new Object[]{new XC_MethodHook(){

                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    methodHookParam.setResult((Object)true);
                }
            }};
            XposedHelpers.findAndHookMethod((String)"com.chelpus.Utils", (ClassLoader)classLoader, (String)"isXposedEnabled", (Object[])arrobject);
        }
        Object[] arrobject = new Object[]{Intent.class, ServiceConnection.class, Integer.TYPE, new XC_MethodHook(){

            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                XSupport.this.loadPrefs();
                if (XSupport.enable && XSupport.patch4) {
                    Intent intent = (Intent)methodHookParam.args[0];
                    if (intent != null) {
                        if ((intent.getAction() != null && Utils.isMarketIntent(intent.getAction()) || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"inappbillingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 0, 0)) {
                            ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
                            Intent intent2 = new Intent();
                            intent2.setComponent(componentName);
                            methodHookParam.args[0] = intent2;
                        }
                        if ((intent.getAction() != null && intent.getAction().toLowerCase().equals((Object)"com.android.vending.billing.marketbillingservice.bind") || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"marketbillingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 0, 0)) {
                            ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
                            Intent intent3 = new Intent();
                            intent3.setComponent(componentName);
                            methodHookParam.args[0] = intent3;
                        }
                    }
                    if (intent != null && (intent.getAction() != null && intent.getAction().toLowerCase().equals((Object)"com.android.vending.licensing.ilicensingservice") || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"licensingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 1, 0)) {
                        ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
                        Intent intent4 = new Intent();
                        intent4.setComponent(componentName);
                        methodHookParam.args[0] = intent4;
                    }
                }
            }
        }};
        XposedHelpers.findAndHookMethod((String)"android.content.ContextWrapper", (ClassLoader)null, (String)"bindService", (Object[])arrobject);
        XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"android.app.ContextImpl", (ClassLoader)loadPackageParam.classLoader), (String)"queryIntentServices", (XC_MethodHook)new XC_MethodHook(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                Intent intent;
                XSupport.this.loadPrefs();
                if (!XSupport.enable || !XSupport.patch4 || (intent = (Intent)methodHookParam.args[0]) == null) return;
                try {
                    if ((intent.getAction() != null && Utils.isMarketIntent(intent.getAction()) || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"inappbillingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 0, 1)) {
                        ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
                        Intent intent2 = new Intent();
                        intent2.setComponent(componentName);
                        methodHookParam.args[0] = intent2;
                    }
                    if ((intent.getAction() != null && intent.getAction().toLowerCase().equals((Object)"com.android.vending.billing.marketbillingservice.bind") || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"marketbillingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 0, 1)) {
                        ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
                        Intent intent3 = new Intent();
                        intent3.setComponent(componentName);
                        methodHookParam.args[0] = intent3;
                    }
                    if ((intent.getAction() != null && intent.getAction().toLowerCase().equals((Object)"com.android.vending.licensing.ilicensingservice") || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"licensingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 1, 1)) {
                        ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
                        Intent intent4 = new Intent();
                        intent4.setComponent(componentName);
                        methodHookParam.args[0] = intent4;
                    }
                    if (intent.getAction() == null || !intent.getAction().equals((Object)"com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND")) return;
                    Intent intent5 = new Intent("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND");
                    intent5.setPackage(listAppsFragment.class.getPackage().getName());
                    methodHookParam.args[0] = intent5;
                    return;
                }
                catch (Exception var3_10) {
                    return;
                }
            }
        });
        if ("android".equals((Object)loadPackageParam.packageName) && loadPackageParam.processName.equals((Object)"android")) {
            if (Build.VERSION.SDK_INT > 10) {
                Class class_ = XposedHelpers.findClass((String)"com.android.server.pm.PackageManagerService", (ClassLoader)loadPackageParam.classLoader);
                XposedBridge.hookAllConstructors((Class)XposedHelpers.findClass((String)"com.android.server.pm.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        System.out.println("SetPmContext");
                        XSupport.this.PMcontext = (Context)methodHookParam.args[0];
                    }
                });
                if (Common.LOLLIPOP_NEWER) {
                    XposedBridge.hookAllMethods((Class)class_, (String)"installPackageAsUser", (XC_MethodHook)new XC_MethodHook(){

                        /*
                         * Enabled aggressive block sorting
                         */
                        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch3) {
                                int n = Common.JB_MR1_NEWER ? 2 : 1;
                                int n2 = (Integer)methodHookParam.args[n];
                                if ((n2 & 128) != 0) return;
                                int n3 = n2 | 128;
                                methodHookParam.args[n] = n3;
                            }
                        }
                    });
                } else if (Common.JB_MR1_NEWER) {
                    XposedBridge.hookAllMethods((Class)class_, (String)"installPackageWithVerificationAndEncryption", (XC_MethodHook)new XC_MethodHook(){

                        /*
                         * Enabled aggressive block sorting
                         */
                        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch3) {
                                int n = Common.JB_MR1_NEWER ? 2 : 1;
                                int n2 = (Integer)methodHookParam.args[n];
                                if ((n2 & 128) != 0) return;
                                int n3 = n2 | 128;
                                methodHookParam.args[n] = n3;
                            }
                        }
                    });
                } else {
                    XposedBridge.hookAllMethods((Class)class_, (String)"installPackageWithVerification", (XC_MethodHook)new XC_MethodHook(){

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch3) {
                                int n;
                                int n2 = 1;
                                if (Build.VERSION.SDK_INT >= 14) {
                                    n2 = 2;
                                }
                                try {
                                    int n3;
                                    n = n3 = ((Integer)methodHookParam.args[n2]).intValue();
                                }
                                catch (ClassCastException var3_6) {
                                    n = (Integer)methodHookParam.args[1];
                                    n2 = 1;
                                }
                                if ((n & 128) != 0) return;
                                int n4 = n | 128;
                                methodHookParam.args[n2] = n4;
                            }
                        }
                    });
                }
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.server.pm.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (String)"queryIntentServices", (XC_MethodHook)new XC_MethodHook(){

                    /*
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        Intent intent;
                        XSupport.this.loadPrefs();
                        if (!XSupport.enable || !XSupport.patch4 || (intent = (Intent)methodHookParam.args[0]) == null) return;
                        try {
                            if ((intent.getAction() != null && Utils.isMarketIntent(intent.getAction()) || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"inappbillingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 0, 2)) {
                                ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
                                Intent intent2 = new Intent();
                                intent2.setComponent(componentName);
                                methodHookParam.args[0] = intent2;
                            }
                            if ((intent.getAction() != null && intent.getAction().toLowerCase().equals((Object)"com.android.vending.billing.marketbillingservice.bind") || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"marketbillingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 0, 2)) {
                                ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
                                Intent intent3 = new Intent();
                                intent3.setComponent(componentName);
                                methodHookParam.args[0] = intent3;
                            }
                            if ((intent.getAction() != null && intent.getAction().toLowerCase().equals((Object)"com.android.vending.licensing.ilicensingservice") || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"licensingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 1, 2)) {
                                ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
                                Intent intent4 = new Intent();
                                intent4.setComponent(componentName);
                                methodHookParam.args[0] = intent4;
                            }
                            if (intent.getAction() == null || !intent.getAction().equals((Object)"com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND")) return;
                            Intent intent5 = new Intent("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND");
                            intent5.setPackage(listAppsFragment.class.getPackage().getName());
                            methodHookParam.args[0] = intent5;
                            return;
                        }
                        catch (Exception var3_10) {
                            return;
                        }
                    }
                });
                if (Common.LOLLIPOP_NEWER) {
                    XposedBridge.hookAllMethods((Class)class_, (String)"checkUpgradeKeySetLP", (XC_MethodHook)new XC_MethodHook(){

                        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch3) {
                                methodHookParam.setResult((Object)true);
                            }
                        }
                    });
                }
                XposedBridge.hookAllMethods((Class)class_, (String)"scanPackageLI", (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.disableCheckSignatures = true;
                    }

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.disableCheckSignatures = false;
                    }
                });
                XposedBridge.hookAllMethods((Class)class_, (String)"verifySignaturesLP", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch3) {
                            methodHookParam.setResult((Object)true);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)class_, (String)"compareSignatures", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch3 && XSupport.this.disableCheckSignatures) {
                            methodHookParam.setResult((Object)0);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)class_, (String)"getPackageInfo", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        String string;
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && (string = (String)methodHookParam.args[0]) != null && string.equals((Object)listAppsFragment.class.getPackage().getName()) && XSupport.this.checkForHide(methodHookParam)) {
                            methodHookParam.setResult((Object)null);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)class_, (String)"getApplicationInfo", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        String string;
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && (string = (String)methodHookParam.args[0]) != null && string.equals((Object)listAppsFragment.class.getPackage().getName()) && XSupport.this.checkForHideApp(methodHookParam)) {
                            methodHookParam.setResult((Object)null);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)class_, (String)"generatePackageInfo", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        if ((XSupport.this.skip1 || XSupport.this.skip2 || XSupport.this.skip3) && ((String)XposedHelpers.getObjectField((Object)methodHookParam.args[0], (String)"packageName")).equals((Object)listAppsFragment.class.getPackage().getName())) {
                            methodHookParam.setResult((Object)null);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)class_, (String)"getInstalledApplications", (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.skip2 = false;
                    }

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(methodHookParam)) {
                            XSupport.this.skip2 = true;
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)class_, (String)"getInstalledPackages", (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.skip1 = false;
                    }

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(methodHookParam)) {
                            XSupport.this.skip1 = true;
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)class_, (String)"getPreferredPackages", (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.skip3 = false;
                    }

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(methodHookParam)) {
                            XSupport.this.skip3 = true;
                        }
                    }
                });
            } else {
                XposedBridge.hookAllConstructors((Class)XposedHelpers.findClass((String)"com.android.server.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        System.out.println("SetPmContext");
                        XSupport.this.PMcontext = (Context)methodHookParam.args[0];
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.server.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (String)"getPackageInfo", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        String string;
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && (string = (String)methodHookParam.args[0]) != null && string.equals((Object)listAppsFragment.class.getPackage().getName()) && XSupport.this.checkForHide(methodHookParam)) {
                            methodHookParam.setResult((Object)null);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.server.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (String)"getApplicationInfo", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        String string;
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && (string = (String)methodHookParam.args[0]) != null && string.equals((Object)listAppsFragment.class.getPackage().getName()) && XSupport.this.checkForHideApp(methodHookParam)) {
                            methodHookParam.setResult((Object)null);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"android.content.pm.PackageParser", (ClassLoader)loadPackageParam.classLoader), (String)"generatePackageInfo", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && ((String)XposedHelpers.getObjectField((Object)methodHookParam.args[0], (String)"packageName")).equals((Object)listAppsFragment.class.getPackage().getName()) && XSupport.this.skipGB) {
                            methodHookParam.setResult((Object)null);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"android.content.pm.PackageParser", (ClassLoader)loadPackageParam.classLoader), (String)"generateApplicationInfo", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && ((String)XposedHelpers.getObjectField((Object)methodHookParam.args[0], (String)"packageName")).equals((Object)listAppsFragment.class.getPackage().getName()) && XSupport.this.skipGB) {
                            methodHookParam.setResult((Object)null);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.server.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (String)"getInstalledApplications", (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.skipGB = false;
                    }

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(methodHookParam)) {
                            XSupport.this.skipGB = true;
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.server.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (String)"getInstalledPackages", (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.skipGB = false;
                    }

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(methodHookParam)) {
                            XSupport.this.skipGB = true;
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.server.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (String)"getPreferredPackages", (XC_MethodHook)new XC_MethodHook(){

                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.skipGB = false;
                    }

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(methodHookParam)) {
                            XSupport.this.skipGB = true;
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.server.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (String)"checkSignaturesLP", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch3) {
                            methodHookParam.setResult((Object)0);
                        }
                    }
                });
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.server.PackageManagerService", (ClassLoader)loadPackageParam.classLoader), (String)"queryIntentServices", (XC_MethodHook)new XC_MethodHook(){

                    /*
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        Intent intent;
                        XSupport.this.loadPrefs();
                        if (!XSupport.enable || !XSupport.patch4 || (intent = (Intent)methodHookParam.args[0]) == null) return;
                        try {
                            if ((intent.getAction() != null && Utils.isMarketIntent(intent.getAction()) || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"inappbillingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 0, 2)) {
                                ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
                                Intent intent2 = new Intent();
                                intent2.setComponent(componentName);
                                methodHookParam.args[0] = intent2;
                            }
                            if ((intent.getAction() != null && intent.getAction().toLowerCase().equals((Object)"com.android.vending.billing.marketbillingservice.bind") || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"marketbillingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 0, 2)) {
                                ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
                                Intent intent3 = new Intent();
                                intent3.setComponent(componentName);
                                methodHookParam.args[0] = intent3;
                            }
                            if ((intent.getAction() != null && intent.getAction().toLowerCase().equals((Object)"com.android.vending.licensing.ilicensingservice") || intent.getComponent() != null && intent.getComponent().toString().contains((CharSequence)"com.android.vending") && intent.getComponent().toString().toLowerCase().contains((CharSequence)"licensingservice")) && XSupport.this.checkIntentRework(methodHookParam, intent, 1, 2)) {
                                ComponentName componentName = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
                                Intent intent4 = new Intent();
                                intent4.setComponent(componentName);
                                methodHookParam.args[0] = intent4;
                            }
                            if (intent.getAction() == null || !intent.getAction().equals((Object)"com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND")) return;
                            Intent intent5 = new Intent("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND");
                            intent5.setPackage(listAppsFragment.class.getPackage().getName());
                            methodHookParam.args[0] = intent5;
                            return;
                        }
                        catch (Exception var3_10) {
                            return;
                        }
                    }
                });
            }
        }
        if (Build.VERSION.SDK_INT > 10) {
            XposedBridge.hookAllConstructors((Class)XposedHelpers.findClass((String)"android.app.ApplicationPackageManager", (ClassLoader)loadPackageParam.classLoader), (XC_MethodHook)new XC_MethodHook(){

                /*
                 * Exception decompiling
                 */
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam var1) throws Throwable {
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
            });
            XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"android.app.ApplicationPackageManager", (ClassLoader)loadPackageParam.classLoader), (String)"getPackageInfo", (XC_MethodHook)new XC_MethodHook(){

                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    String string;
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide && (string = (String)methodHookParam.args[0]) != null && string.equals((Object)listAppsFragment.class.getPackage().getName())) {
                        methodHookParam.setThrowable((Throwable)new PackageManager.NameNotFoundException());
                    }
                }
            });
            XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"android.app.ApplicationPackageManager", (ClassLoader)loadPackageParam.classLoader), (String)"getApplicationInfo", (XC_MethodHook)new XC_MethodHook(){

                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    String string;
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide && (string = (String)methodHookParam.args[0]) != null && string.equals((Object)listAppsFragment.class.getPackage().getName())) {
                        methodHookParam.setThrowable((Throwable)new PackageManager.NameNotFoundException());
                    }
                }
            });
            XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"android.app.ApplicationPackageManager", (ClassLoader)loadPackageParam.classLoader), (String)"getInstalledApplications", (XC_MethodHook)new XC_MethodHook(){

                protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide) {
                        if (XSupport.this.ctx != null) {
                            // empty if block
                        }
                        List list = (List)methodHookParam.getResult();
                        ApplicationInfo applicationInfo = null;
                        for (ApplicationInfo applicationInfo2 : list) {
                            if (!applicationInfo2.packageName.equals((Object)listAppsFragment.class.getPackage().getName())) continue;
                            applicationInfo = applicationInfo2;
                        }
                        if (applicationInfo != null) {
                            list.remove((Object)applicationInfo);
                            methodHookParam.setResult((Object)list);
                        }
                    }
                }
            });
            XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"android.app.ApplicationPackageManager", (ClassLoader)loadPackageParam.classLoader), (String)"getInstalledPackages", (XC_MethodHook)new XC_MethodHook(){

                protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide) {
                        if (XSupport.this.ctx != null) {
                            // empty if block
                        }
                        List list = (List)methodHookParam.getResult();
                        PackageInfo packageInfo = null;
                        for (PackageInfo packageInfo2 : list) {
                            if (!packageInfo2.packageName.equals((Object)listAppsFragment.class.getPackage().getName())) continue;
                            packageInfo = packageInfo2;
                        }
                        if (packageInfo != null) {
                            methodHookParam.setResult((Object)list);
                        }
                    }
                }
            });
            XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"android.app.ApplicationPackageManager", (ClassLoader)loadPackageParam.classLoader), (String)"getPreferredPackages", (XC_MethodHook)new XC_MethodHook(){

                protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide) {
                        if (XSupport.this.ctx != null) {
                            // empty if block
                        }
                        List list = (List)methodHookParam.getResult();
                        PackageInfo packageInfo = null;
                        for (PackageInfo packageInfo2 : list) {
                            if (!packageInfo2.packageName.equals((Object)listAppsFragment.class.getPackage().getName())) continue;
                            packageInfo = packageInfo2;
                        }
                        if (packageInfo != null) {
                            list.remove((Object)packageInfo);
                            methodHookParam.setResult((Object)list);
                        }
                    }
                }
            });
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void initZygote(IXposedHookZygoteInit.StartupParam var1) throws Throwable {
        XposedHelpers.findClass((String)"android.content.pm.PackageParser", (ClassLoader)null);
        XposedHelpers.findClass((String)"java.util.jar.JarVerifier$VerifierEntry", (ClassLoader)null);
        this.disableCheckSignatures = true;
        if (Build.VERSION.SDK_INT > 18) {
            XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"com.android.org.conscrypt.OpenSSLSignature", (ClassLoader)null), (String)"engineVerify", (XC_MethodHook)new XC_MethodHook(){

                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                    System.out.println("engineVerify");
                    XSupport.this.loadPrefs();
                    if (XSupport.enable && XSupport.patch1) {
                        methodHookParam.setResult((Object)true);
                    }
                }
            });
        }
lbl7: // 4 sources:
        do {
            if (Build.VERSION.SDK_INT > 14 && Build.VERSION.SDK_INT < 19) {
                XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"org.apache.harmony.xnet.provider.jsse.OpenSSLSignature", (ClassLoader)null), (String)"engineVerify", (XC_MethodHook)new XC_MethodHook(){

                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                        System.out.println("engineVerify");
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch1) {
                            methodHookParam.setResult((Object)true);
                        }
                    }
                });
            }
lbl11: // 4 sources:
            do {
                if (Build.VERSION.SDK_INT == 10) {
                    XposedBridge.hookAllMethods((Class)XposedHelpers.findClass((String)"org.bouncycastle.jce.provider.JDKDigestSignature", (ClassLoader)null), (String)"engineVerify", (XC_MethodHook)new XC_MethodHook(){

                        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                            System.out.println("engineVerify");
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch1) {
                                methodHookParam.setResult((Object)true);
                            }
                        }
                    });
                }
lbl15: // 4 sources:
                do {
                    var4_2 = new Object[]{byte[].class, byte[].class, new XC_MethodHook(){

                        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch2) {
                                methodHookParam.setResult((Object)true);
                            }
                        }
                    }};
                    XposedHelpers.findAndHookMethod((String)"java.security.MessageDigest", (ClassLoader)null, (String)"isEqual", (Object[])var4_2);
                    return;
                    break;
                } while (true);
                catch (ClassNotFoundException var6_3) {
                    ** continue;
                }
                break;
            } while (true);
            catch (Exception var8_4) {
                ** continue;
            }
            break;
        } while (true);
        catch (Exception var10_5) {
            ** continue;
        }
    }

    /*
     * Exception decompiling
     */
    public void loadPrefs() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [5, 0] lbl34 : TryStatement: try { 3[TRYBLOCK]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

}

