package com.chelpus;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Build.VERSION;
import com.android.vending.billing.InAppBillingService.LOCK.CoreItem;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.google.android.finsky.billing.iab.BuyMarketActivity;
import com.google.android.finsky.billing.iab.InAppBillingService;
import com.google.android.finsky.billing.iab.MarketBillingService;
import com.google.android.finsky.services.LicensingService;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.IXposedHookZygoteInit.StartupParam;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class XSupport implements IXposedHookLoadPackage, IXposedHookZygoteInit {
    public static boolean enable = true;
    public static boolean hide = false;
    public static boolean patch1 = true;
    public static boolean patch2 = true;
    public static boolean patch3 = true;
    public static boolean patch4 = false;
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

    public void initZygote(StartupParam startupParam) throws Throwable {
        Class<?> packageParserClass = XposedHelpers.findClass(Common.PACKAGEPARSER, null);
        Class<?> jarVerifierClass = XposedHelpers.findClass(Common.JARVERIFIER, null);
        this.disableCheckSignatures = true;
        if (VERSION.SDK_INT > 18) {
            try {
                XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.org.conscrypt.OpenSSLSignature", null), "engineVerify", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        System.out.println("engineVerify");
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch1) {
                            param.setResult(Boolean.valueOf(true));
                        }
                    }
                });
            } catch (Exception e) {
            }
        }
        if (VERSION.SDK_INT > 14 && VERSION.SDK_INT < 19) {
            try {
                XposedBridge.hookAllMethods(XposedHelpers.findClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSignature", null), "engineVerify", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        System.out.println("engineVerify");
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch1) {
                            param.setResult(Boolean.valueOf(true));
                        }
                    }
                });
            } catch (Exception e2) {
            }
        }
        if (VERSION.SDK_INT == 10) {
            try {
                XposedBridge.hookAllMethods(XposedHelpers.findClass("org.bouncycastle.jce.provider.JDKDigestSignature", null), "engineVerify", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        System.out.println("engineVerify");
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch1) {
                            param.setResult(Boolean.valueOf(true));
                        }
                    }
                });
            } catch (ClassNotFoundException e3) {
            }
        }
        XposedHelpers.findAndHookMethod("java.security.MessageDigest", null, "isEqual", new Object[]{byte[].class, byte[].class, new XC_MethodHook() {
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XSupport.this.loadPrefs();
                if (XSupport.enable && XSupport.patch2) {
                    param.setResult(Boolean.valueOf(true));
                }
            }
        }});
    }

    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (listAppsFragment.class.getPackage().getName().equals(lpparam.packageName)) {
            XposedHelpers.findAndHookMethod("com.chelpus.Utils", lpparam.classLoader, "isXposedEnabled", new Object[]{new XC_MethodHook() {
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(Boolean.valueOf(true));
                }
            }});
        }
        XposedHelpers.findAndHookMethod("android.content.ContextWrapper", null, "bindService", new Object[]{Intent.class, ServiceConnection.class, Integer.TYPE, new XC_MethodHook() {
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XSupport.this.loadPrefs();
                if (XSupport.enable && XSupport.patch4) {
                    ComponentName component;
                    Intent serviceIntent;
                    Intent intent = param.args[0];
                    if (intent != null) {
                        if (((intent.getAction() != null && Utils.isMarketIntent(intent.getAction())) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("inappbillingservice"))) && XSupport.this.checkIntentRework(param, intent, 0, 0)) {
                            component = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
                            serviceIntent = new Intent();
                            serviceIntent.setComponent(component);
                            param.args[0] = serviceIntent;
                        }
                        if (((intent.getAction() != null && intent.getAction().toLowerCase().equals("com.android.vending.billing.marketbillingservice.bind")) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("marketbillingservice"))) && XSupport.this.checkIntentRework(param, intent, 0, 0)) {
                            component = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
                            serviceIntent = new Intent();
                            serviceIntent.setComponent(component);
                            param.args[0] = serviceIntent;
                        }
                    }
                    if (intent == null) {
                        return;
                    }
                    if (((intent.getAction() != null && intent.getAction().toLowerCase().equals("com.android.vending.licensing.ilicensingservice")) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("licensingservice"))) && XSupport.this.checkIntentRework(param, intent, 1, 0)) {
                        component = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
                        serviceIntent = new Intent();
                        serviceIntent.setComponent(component);
                        param.args[0] = serviceIntent;
                    }
                }
            }
        }});
        XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ContextImpl", lpparam.classLoader), "queryIntentServices", new XC_MethodHook() {
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XSupport.this.loadPrefs();
                if (XSupport.enable && XSupport.patch4) {
                    Intent intent = param.args[0];
                    if (intent != null) {
                        try {
                            ComponentName component;
                            Intent serviceIntent;
                            if (((intent.getAction() != null && Utils.isMarketIntent(intent.getAction())) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("inappbillingservice"))) && XSupport.this.checkIntentRework(param, intent, 0, 1)) {
                                component = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
                                serviceIntent = new Intent();
                                serviceIntent.setComponent(component);
                                param.args[0] = serviceIntent;
                            }
                            if (((intent.getAction() != null && intent.getAction().toLowerCase().equals("com.android.vending.billing.marketbillingservice.bind")) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("marketbillingservice"))) && XSupport.this.checkIntentRework(param, intent, 0, 1)) {
                                component = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
                                serviceIntent = new Intent();
                                serviceIntent.setComponent(component);
                                param.args[0] = serviceIntent;
                            }
                            if (((intent.getAction() != null && intent.getAction().toLowerCase().equals("com.android.vending.licensing.ilicensingservice")) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("licensingservice"))) && XSupport.this.checkIntentRework(param, intent, 1, 1)) {
                                component = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
                                serviceIntent = new Intent();
                                serviceIntent.setComponent(component);
                                param.args[0] = serviceIntent;
                            }
                            if (intent.getAction() != null && intent.getAction().equals("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND")) {
                                Intent intent1 = new Intent("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND");
                                intent1.setPackage(listAppsFragment.class.getPackage().getName());
                                param.args[0] = intent1;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        });
        if (Common.ANDROID_PKG.equals(lpparam.packageName) && lpparam.processName.equals(Common.ANDROID_PKG)) {
            if (VERSION.SDK_INT > 10) {
                Class<?> packageManagerClass = XposedHelpers.findClass(Common.PACKAGEMANAGERSERVICE, lpparam.classLoader);
                XposedBridge.hookAllConstructors(XposedHelpers.findClass(Common.PACKAGEMANAGERSERVICE, lpparam.classLoader), new XC_MethodHook() {
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        System.out.println("SetPmContext");
                        XSupport.this.PMcontext = (Context) param.args[0];
                    }
                });
                if (Common.LOLLIPOP_NEWER) {
                    XposedBridge.hookAllMethods(packageManagerClass, "installPackageAsUser", new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch3) {
                                int id = Common.JB_MR1_NEWER ? 2 : 1;
                                int flags = ((Integer) param.args[id]).intValue();
                                if ((flags & Common.INSTALL_ALLOW_DOWNGRADE) == 0) {
                                    param.args[id] = Integer.valueOf(flags | Common.INSTALL_ALLOW_DOWNGRADE);
                                }
                            }
                        }
                    });
                } else if (Common.JB_MR1_NEWER) {
                    XposedBridge.hookAllMethods(packageManagerClass, "installPackageWithVerificationAndEncryption", new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch3) {
                                int id = Common.JB_MR1_NEWER ? 2 : 1;
                                int flags = ((Integer) param.args[id]).intValue();
                                if ((flags & Common.INSTALL_ALLOW_DOWNGRADE) == 0) {
                                    param.args[id] = Integer.valueOf(flags | Common.INSTALL_ALLOW_DOWNGRADE);
                                }
                            }
                        }
                    });
                } else {
                    XposedBridge.hookAllMethods(packageManagerClass, "installPackageWithVerification", new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch3) {
                                int flags;
                                int id = 1;
                                if (VERSION.SDK_INT >= 14) {
                                    id = 2;
                                }
                                try {
                                    flags = ((Integer) param.args[id]).intValue();
                                } catch (ClassCastException e) {
                                    flags = ((Integer) param.args[1]).intValue();
                                    id = 1;
                                }
                                if ((flags & Common.INSTALL_ALLOW_DOWNGRADE) == 0) {
                                    param.args[id] = Integer.valueOf(flags | Common.INSTALL_ALLOW_DOWNGRADE);
                                }
                            }
                        }
                    });
                }
                XposedBridge.hookAllMethods(XposedHelpers.findClass(Common.PACKAGEMANAGERSERVICE, lpparam.classLoader), "queryIntentServices", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch4) {
                            Intent intent = param.args[0];
                            if (intent != null) {
                                try {
                                    ComponentName component;
                                    Intent serviceIntent;
                                    if (((intent.getAction() != null && Utils.isMarketIntent(intent.getAction())) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("inappbillingservice"))) && XSupport.this.checkIntentRework(param, intent, 0, 2)) {
                                        component = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
                                        serviceIntent = new Intent();
                                        serviceIntent.setComponent(component);
                                        param.args[0] = serviceIntent;
                                    }
                                    if (((intent.getAction() != null && intent.getAction().toLowerCase().equals("com.android.vending.billing.marketbillingservice.bind")) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("marketbillingservice"))) && XSupport.this.checkIntentRework(param, intent, 0, 2)) {
                                        component = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
                                        serviceIntent = new Intent();
                                        serviceIntent.setComponent(component);
                                        param.args[0] = serviceIntent;
                                    }
                                    if (((intent.getAction() != null && intent.getAction().toLowerCase().equals("com.android.vending.licensing.ilicensingservice")) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("licensingservice"))) && XSupport.this.checkIntentRework(param, intent, 1, 2)) {
                                        component = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
                                        serviceIntent = new Intent();
                                        serviceIntent.setComponent(component);
                                        param.args[0] = serviceIntent;
                                    }
                                    if (intent.getAction() != null && intent.getAction().equals("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND")) {
                                        Intent intent1 = new Intent("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND");
                                        intent1.setPackage(listAppsFragment.class.getPackage().getName());
                                        param.args[0] = intent1;
                                    }
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                });
                if (Common.LOLLIPOP_NEWER) {
                    XposedBridge.hookAllMethods(packageManagerClass, "checkUpgradeKeySetLP", new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            XSupport.this.loadPrefs();
                            if (XSupport.enable && XSupport.patch3) {
                                param.setResult(Boolean.valueOf(true));
                            }
                        }
                    });
                }
                XposedBridge.hookAllMethods(packageManagerClass, "scanPackageLI", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.disableCheckSignatures = false;
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.disableCheckSignatures = true;
                    }
                });
                XposedBridge.hookAllMethods(packageManagerClass, "verifySignaturesLP", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch3) {
                            param.setResult(Boolean.valueOf(true));
                        }
                    }
                });
                XposedBridge.hookAllMethods(packageManagerClass, "compareSignatures", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch3 && XSupport.this.disableCheckSignatures) {
                            param.setResult(Integer.valueOf(0));
                        }
                    }
                });
                XposedBridge.hookAllMethods(packageManagerClass, "getPackageInfo", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide) {
                            String pkg = param.args[0];
                            if (pkg != null && pkg.equals(listAppsFragment.class.getPackage().getName()) && XSupport.this.checkForHide(param)) {
                                param.setResult(null);
                            }
                        }
                    }
                });
                XposedBridge.hookAllMethods(packageManagerClass, "getApplicationInfo", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide) {
                            String pkg = param.args[0];
                            if (pkg != null && pkg.equals(listAppsFragment.class.getPackage().getName()) && XSupport.this.checkForHideApp(param)) {
                                param.setResult(null);
                            }
                        }
                    }
                });
                XposedBridge.hookAllMethods(packageManagerClass, "generatePackageInfo", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        if ((XSupport.this.skip1 || XSupport.this.skip2 || XSupport.this.skip3) && ((String) XposedHelpers.getObjectField(param.args[0], BuyMarketActivity.EXTRA_PACKAGENAME)).equals(listAppsFragment.class.getPackage().getName())) {
                            param.setResult(null);
                        }
                    }
                });
                XposedBridge.hookAllMethods(packageManagerClass, "getInstalledApplications", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(param)) {
                            XSupport.this.skip2 = true;
                        }
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.skip2 = false;
                    }
                });
                XposedBridge.hookAllMethods(packageManagerClass, "getInstalledPackages", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(param)) {
                            XSupport.this.skip1 = true;
                        }
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.skip1 = false;
                    }
                });
                XposedBridge.hookAllMethods(packageManagerClass, "getPreferredPackages", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(param)) {
                            XSupport.this.skip3 = true;
                        }
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.skip3 = false;
                    }
                });
            } else {
                XposedBridge.hookAllConstructors(XposedHelpers.findClass("com.android.server.PackageManagerService", lpparam.classLoader), new XC_MethodHook() {
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        System.out.println("SetPmContext");
                        XSupport.this.PMcontext = (Context) param.args[0];
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", lpparam.classLoader), "getPackageInfo", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide) {
                            String pkg = param.args[0];
                            if (pkg != null && pkg.equals(listAppsFragment.class.getPackage().getName()) && XSupport.this.checkForHide(param)) {
                                param.setResult(null);
                            }
                        }
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", lpparam.classLoader), "getApplicationInfo", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide) {
                            String pkg = param.args[0];
                            if (pkg != null && pkg.equals(listAppsFragment.class.getPackage().getName()) && XSupport.this.checkForHideApp(param)) {
                                param.setResult(null);
                            }
                        }
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass(Common.PACKAGEPARSER, lpparam.classLoader), "generatePackageInfo", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && ((String) XposedHelpers.getObjectField(param.args[0], BuyMarketActivity.EXTRA_PACKAGENAME)).equals(listAppsFragment.class.getPackage().getName()) && XSupport.this.skipGB) {
                            param.setResult(null);
                        }
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass(Common.PACKAGEPARSER, lpparam.classLoader), "generateApplicationInfo", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && ((String) XposedHelpers.getObjectField(param.args[0], BuyMarketActivity.EXTRA_PACKAGENAME)).equals(listAppsFragment.class.getPackage().getName()) && XSupport.this.skipGB) {
                            param.setResult(null);
                        }
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", lpparam.classLoader), "getInstalledApplications", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(param)) {
                            XSupport.this.skipGB = true;
                        }
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.skipGB = false;
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", lpparam.classLoader), "getInstalledPackages", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(param)) {
                            XSupport.this.skipGB = true;
                        }
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.skipGB = false;
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", lpparam.classLoader), "getPreferredPackages", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.hide && XSupport.this.checkForHideApp(param)) {
                            XSupport.this.skipGB = true;
                        }
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.skipGB = false;
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", lpparam.classLoader), "checkSignaturesLP", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch3) {
                            param.setResult(Integer.valueOf(0));
                        }
                    }
                });
                XposedBridge.hookAllMethods(XposedHelpers.findClass("com.android.server.PackageManagerService", lpparam.classLoader), "queryIntentServices", new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XSupport.this.loadPrefs();
                        if (XSupport.enable && XSupport.patch4) {
                            Intent intent = param.args[0];
                            if (intent != null) {
                                try {
                                    ComponentName component;
                                    Intent serviceIntent;
                                    if (((intent.getAction() != null && Utils.isMarketIntent(intent.getAction())) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("inappbillingservice"))) && XSupport.this.checkIntentRework(param, intent, 0, 2)) {
                                        component = new ComponentName(listAppsFragment.class.getPackage().getName(), InAppBillingService.class.getName());
                                        serviceIntent = new Intent();
                                        serviceIntent.setComponent(component);
                                        param.args[0] = serviceIntent;
                                    }
                                    if (((intent.getAction() != null && intent.getAction().toLowerCase().equals("com.android.vending.billing.marketbillingservice.bind")) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("marketbillingservice"))) && XSupport.this.checkIntentRework(param, intent, 0, 2)) {
                                        component = new ComponentName(listAppsFragment.class.getPackage().getName(), MarketBillingService.class.getName());
                                        serviceIntent = new Intent();
                                        serviceIntent.setComponent(component);
                                        param.args[0] = serviceIntent;
                                    }
                                    if (((intent.getAction() != null && intent.getAction().toLowerCase().equals("com.android.vending.licensing.ilicensingservice")) || (intent.getComponent() != null && intent.getComponent().toString().contains(Common.GOOGLEPLAY_PKG) && intent.getComponent().toString().toLowerCase().contains("licensingservice"))) && XSupport.this.checkIntentRework(param, intent, 1, 2)) {
                                        component = new ComponentName(listAppsFragment.class.getPackage().getName(), LicensingService.class.getName());
                                        serviceIntent = new Intent();
                                        serviceIntent.setComponent(component);
                                        param.args[0] = serviceIntent;
                                    }
                                    if (intent.getAction() != null && intent.getAction().equals("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND")) {
                                        Intent intent1 = new Intent("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND");
                                        intent1.setPackage(listAppsFragment.class.getPackage().getName());
                                        param.args[0] = intent1;
                                    }
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                });
            }
        }
        if (VERSION.SDK_INT > 10) {
            XposedBridge.hookAllConstructors(XposedHelpers.findClass("android.app.ApplicationPackageManager", lpparam.classLoader), new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XSupport.this.ctx = (Context) param.args[0];
                    XSupport.this.loadPrefs();
                    if (XSupport.enable && XSupport.hide) {
                        XSupport.this.forHide = Boolean.valueOf(false);
                        if (XSupport.this.ctx != null && !XSupport.this.ctx.getPackageName().equals(listAppsFragment.class.getPackage().getName()) && !XSupport.this.ctx.getPackageName().equals("de.robv.android.xposed.installer") && !XSupport.this.ctx.getPackageName().contains("supersu") && !XSupport.this.ctx.getPackageName().contains("superuser") && !XSupport.this.ctx.getPackageName().contains("pro.burgerz.wsm.manager")) {
                            XSupport.this.forHide = Boolean.valueOf(true);
                            try {
                                ApplicationInfo info = (ApplicationInfo) XposedHelpers.callMethod(param.thisObject, "getApplicationInfo", new Object[]{XSupport.this.ctx.getPackageName(), Integer.valueOf(0)});
                                if (info != null) {
                                    if ((info.flags & 1) != 0) {
                                        XSupport.this.forHide = Boolean.valueOf(false);
                                        return;
                                    }
                                    XSupport.this.forHide = Boolean.valueOf(true);
                                }
                                Intent intent_home = new Intent("android.intent.action.MAIN");
                                intent_home.addCategory("android.intent.category.HOME");
                                intent_home.addCategory("android.intent.category.DEFAULT");
                                for (ResolveInfo launcher : (List) XposedHelpers.callMethod(param.thisObject, "queryIntentActivities", new Object[]{intent_home, Integer.valueOf(0)})) {
                                    if (launcher.activityInfo.packageName.equals(XSupport.this.ctx.getPackageName())) {
                                        XSupport.this.forHide = Boolean.valueOf(false);
                                        return;
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                XSupport.this.forHide = Boolean.valueOf(false);
                            }
                        }
                    }
                }
            });
            String cClassName = "android.app.ApplicationPackageManager";
            XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", lpparam.classLoader), "getPackageInfo", new XC_MethodHook() {
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide) {
                        String pkg = param.args[0];
                        if (pkg != null && pkg.equals(listAppsFragment.class.getPackage().getName())) {
                            param.setThrowable(new NameNotFoundException());
                        }
                    }
                }
            });
            XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", lpparam.classLoader), "getApplicationInfo", new XC_MethodHook() {
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide) {
                        String pkg = param.args[0];
                        if (pkg != null && pkg.equals(listAppsFragment.class.getPackage().getName())) {
                            param.setThrowable(new NameNotFoundException());
                        }
                    }
                }
            });
            XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", lpparam.classLoader), "getInstalledApplications", new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide) {
                        List<ApplicationInfo> list;
                        ApplicationInfo found;
                        if (XSupport.this.ctx != null) {
                            list = (List) param.getResult();
                            found = null;
                        } else {
                            list = (List) param.getResult();
                            found = null;
                        }
                        for (ApplicationInfo app : list) {
                            if (app.packageName.equals(listAppsFragment.class.getPackage().getName())) {
                                found = app;
                            }
                        }
                        if (found != null) {
                            list.remove(found);
                            param.setResult(list);
                        }
                    }
                }
            });
            XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", lpparam.classLoader), "getInstalledPackages", new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide) {
                        List<PackageInfo> list;
                        PackageInfo found;
                        if (XSupport.this.ctx != null) {
                            list = (List) param.getResult();
                            found = null;
                        } else {
                            list = (List) param.getResult();
                            found = null;
                        }
                        for (PackageInfo app : list) {
                            if (app.packageName.equals(listAppsFragment.class.getPackage().getName())) {
                                found = app;
                            }
                        }
                        if (found != null) {
                            param.setResult(list);
                        }
                    }
                }
            });
            XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ApplicationPackageManager", lpparam.classLoader), "getPreferredPackages", new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XSupport.this.loadPrefs();
                    if (XSupport.this.forHide != null && XSupport.this.forHide.booleanValue() && XSupport.enable && XSupport.hide) {
                        List<PackageInfo> list;
                        PackageInfo found;
                        if (XSupport.this.ctx != null) {
                            list = (List) param.getResult();
                            found = null;
                        } else {
                            list = (List) param.getResult();
                            found = null;
                        }
                        for (PackageInfo app : list) {
                            if (app.packageName.equals(listAppsFragment.class.getPackage().getName())) {
                                found = app;
                            }
                        }
                        if (found != null) {
                            list.remove(found);
                            param.setResult(list);
                        }
                    }
                }
            });
        }
    }

    public void loadPrefs() {
        try {
            if (new File("/data/lp/xposed").exists()) {
                if (!new File("/data/lp/xposed").canRead()) {
                    try {
                        new File("/data/lp/xposed").setReadable(true, false);
                    } catch (NoSuchMethodError e) {
                        e.printStackTrace();
                    }
                }
                if (this.initialize == 0 || this.initialize != new File("/data/lp/xposed").lastModified()) {
                    if (!(this.initialize == 0 || this.initialize == new File("/data/lp/xposed").lastModified())) {
                        System.out.println("Update settings xposed");
                    }
                    this.initialize = new File("/data/lp/xposed").lastModified();
                    ArrayList<CoreItem> s = new ArrayList();
                    JSONObject settings = null;
                    try {
                        settings = Utils.readXposedParamBoolean();
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (settings != null) {
                        patch1 = settings.optBoolean("patch1", true);
                        patch2 = settings.optBoolean("patch2", true);
                        patch3 = settings.optBoolean("patch3", true);
                        patch4 = settings.optBoolean("patch4", false);
                        hide = settings.optBoolean("hide", false);
                        enable = settings.optBoolean("module_on", true);
                        return;
                    }
                    return;
                }
                return;
            }
            patch1 = true;
            patch2 = true;
            patch3 = true;
            patch4 = false;
            hide = false;
            enable = true;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public boolean checkForHide(MethodHookParam param) {
        int uid = Binder.getCallingUid();
        String packageName = (String) XposedHelpers.callMethod(param.thisObject, "getNameForUid", new Object[]{Integer.valueOf(uid)});
        if (packageName.contains(":") || packageName.contains(listAppsFragment.class.getPackage().getName()) || packageName.contains("de.robv.android.xposed.installer") || packageName.contains("supersu") || packageName.contains("superuser") || packageName.contains("pro.burgerz.wsm.manager")) {
            return false;
        }
        boolean fh = true;
        PackageManager pm = this.PMcontext.getPackageManager();
        try {
            ApplicationInfo info = pm.getApplicationInfo(packageName, 0);
            if (info != null) {
                if ((info.flags & 1) != 0) {
                    return false;
                }
                fh = true;
            }
            if (fh) {
                Intent intent_home = new Intent("android.intent.action.MAIN");
                intent_home.addCategory("android.intent.category.HOME");
                intent_home.addCategory("android.intent.category.DEFAULT");
                for (ResolveInfo launcher : pm.queryIntentActivities(intent_home, 0)) {
                    if (launcher.activityInfo.packageName.equals(packageName)) {
                        return false;
                    }
                }
                if (fh) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkForHideApp(MethodHookParam param) {
        int uid = Binder.getCallingUid();
        String packageName = (String) XposedHelpers.callMethod(param.thisObject, "getNameForUid", new Object[]{Integer.valueOf(uid)});
        if (packageName.contains(":") || packageName.contains(listAppsFragment.class.getPackage().getName()) || packageName.contains("de.robv.android.xposed.installer") || packageName.contains("supersu") || packageName.contains("superuser") || packageName.contains("pro.burgerz.wsm.manager")) {
            return false;
        }
        boolean fh = true;
        PackageManager pm = this.PMcontext.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(packageName, 0);
            if (info != null) {
                if ((info.applicationInfo.flags & 1) != 0) {
                    return false;
                }
                fh = true;
            }
            if (fh) {
                Intent intent_home = new Intent("android.intent.action.MAIN");
                intent_home.addCategory("android.intent.category.HOME");
                intent_home.addCategory("android.intent.category.DEFAULT");
                for (ResolveInfo launcher : pm.queryIntentActivities(intent_home, 0)) {
                    if (launcher.activityInfo.packageName.equals(packageName)) {
                        return false;
                    }
                }
                if (fh) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkIntentRework(MethodHookParam param, Intent intent, int serviceCheck, int methodGetContext) {
        String xexe;
        if (methodGetContext == 0) {
            Context cont;
            try {
                cont = (Context) XposedHelpers.callMethod(param.thisObject, "getBaseContext", new Object[0]);
            } catch (ClassCastException e) {
                cont = (Context) XposedHelpers.getObjectField(param.thisObject, "mBase");
            }
            if (cont != null) {
                if (serviceCheck != 0 || (cont.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) == 2 && cont.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) == 2)) {
                    if (serviceCheck == 1 && cont.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2) {
                        if (intent.getStringExtra("xexe") == null || !intent.getStringExtra("xexe").equals("lp")) {
                            return true;
                        }
                        return false;
                    }
                } else if (intent.getStringExtra("xexe") == null || !intent.getStringExtra("xexe").equals("lp")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if (methodGetContext == 1) {
            if (serviceCheck == 0 && (((PackageManager) XposedHelpers.callMethod(param.thisObject, "getPackageManager", new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) != 2 || ((PackageManager) XposedHelpers.callMethod(param.thisObject, "getPackageManager", new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) != 2)) {
                try {
                    xexe = intent.getStringExtra("xexe");
                } catch (Exception e2) {
                    System.out.println("skip inapp xposed queryIntentServices");
                    xexe = null;
                }
                if (xexe == null || !xexe.equals("lp")) {
                    return true;
                }
                return false;
            } else if (serviceCheck == 1 && ((PackageManager) XposedHelpers.callMethod(param.thisObject, "getPackageManager", new Object[0])).getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2) {
                try {
                    xexe = intent.getStringExtra("xexe");
                } catch (Exception e3) {
                    System.out.println("skip inapp xposed queryIntentServices");
                    xexe = null;
                }
                if (xexe == null || !xexe.equals("lp")) {
                    return true;
                }
                return false;
            }
        }
        if (methodGetContext == 2) {
            if (serviceCheck == 0 && (this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, InAppBillingService.class.getName())) != 2 || this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, MarketBillingService.class.getName())) != 2)) {
                try {
                    xexe = intent.getStringExtra("xexe");
                } catch (Exception e4) {
                    System.out.println("skip inapp xposed queryIntentServices");
                    xexe = null;
                }
                if (xexe == null || !xexe.equals("lp")) {
                    return true;
                }
                return false;
            } else if (serviceCheck == 1 && this.PMcontext.getPackageManager().getComponentEnabledSetting(new ComponentName(Common.PACKAGE_NAME, LicensingService.class.getName())) != 2) {
                try {
                    xexe = intent.getStringExtra("xexe");
                } catch (Exception e5) {
                    System.out.println("skip inapp xposed queryIntentServices");
                    xexe = null;
                }
                if (xexe == null || !xexe.equals("lp")) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
