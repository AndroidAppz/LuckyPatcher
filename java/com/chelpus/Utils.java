package com.chelpus;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;
import com.android.vending.billing.InAppBillingService.LOCK.AlertDlg;
import com.android.vending.billing.InAppBillingService.LOCK.BindItem;
import com.android.vending.billing.InAppBillingService.LOCK.CommandItem;
import com.android.vending.billing.InAppBillingService.LOCK.Components;
import com.android.vending.billing.InAppBillingService.LOCK.FileApkListItem;
import com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface;
import com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.Stub;
import com.android.vending.billing.InAppBillingService.LOCK.Mount;
import com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto;
import com.android.vending.billing.InAppBillingService.LOCK.ShellOnMainThreadException;
import com.android.vending.billing.InAppBillingService.LOCK.StringItem;
import com.android.vending.billing.InAppBillingService.LOCK.TypesItem;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.google.android.finsky.billing.iab.google.util.Base64;
import dalvik.system.DexFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipInput;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;
import org.tukaani.xz.XZOutputStream;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import pxb.android.axml.AxmlParser;
import pxb.android.axml.ValueWrapper;
import pxb.android.axmlLP.AxmlVisitor;

public class Utils {
    static final String AB = "abcdefghijklmnopqrstuvwxyz";
    static final String AB2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String LIB_ART = "libart.so";
    private static final String LIB_ART_D = "libartd.so";
    private static final String LIB_DALVIK = "libdvm.so";
    public static final String ROOT_NOT_FOUND = "lucky patcher root not found!";
    private static final String SELECT_RUNTIME_PROPERTY = "persist.sys.dalvik.vm.lib";
    protected static final char[] hexArray = BinTools.hex.toCharArray();
    private static String internalBusybox = "";
    static ITestServiceInterface mService = null;
    static ServiceConnection mServiceConn = null;
    public static String pattern_check = "297451286";
    static Random rnd = new Random();
    float folder_size = 0.0f;

    class AnonymousClass11 implements OnKeyListener {
        private final /* synthetic */ WindowManager val$manager;

        AnonymousClass11(WindowManager windowManager) {
            this.val$manager = windowManager;
        }

        public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
            System.out.println("keyCode " + keyCode);
            if (keyCode == 4) {
                this.val$manager.removeView(view.getRootView());
            }
            return false;
        }
    }

    class AnonymousClass12 implements OnClickListener {
        private final /* synthetic */ WindowManager val$manager;

        AnonymousClass12(WindowManager windowManager) {
            this.val$manager = windowManager;
        }

        public void onClick(View view) {
            this.val$manager.removeView(view.getRootView());
        }
    }

    class AnonymousClass13 implements OnKeyListener {
        private final /* synthetic */ WindowManager val$manager;

        AnonymousClass13(WindowManager windowManager) {
            this.val$manager = windowManager;
        }

        public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
            System.out.println("keyCode " + keyCode);
            if (keyCode == 4) {
                this.val$manager.removeView(view.getRootView());
            }
            return false;
        }
    }

    class AnonymousClass15 implements Runnable {
        private final /* synthetic */ boolean val$enable;

        AnonymousClass15(boolean z) {
            this.val$enable = z;
        }

        public void run() {
            ArrayList<Components> tmpList = new ArrayList();
            PackageInfo info = Utils.getPkgInfo(Common.GOOGLEPLAY_PKG, 516);
            boolean found = false;
            if (info != null && info.services != null && info.services.length != 0) {
                int d = 0;
                while (d < info.services.length) {
                    try {
                        if (this.val$enable) {
                            if ((info.services[d].name.endsWith("InAppBillingService") || info.services[d].name.endsWith("MarketBillingService")) && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 1) {
                                new Utils("").cmdRoot("pm enable 'com.android.vending/" + info.services[d].name + "'");
                                found = true;
                            }
                        } else if ((info.services[d].name.endsWith("InAppBillingService") || info.services[d].name.endsWith("MarketBillingService")) && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 2) {
                            new Utils("").cmdRoot("pm disable 'com.android.vending/" + info.services[d].name + "'");
                            found = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    d++;
                }
                if (!found && this.val$enable) {
                    new Utils("").cmdRoot("pm enable 'com.android.vending/com.google.android.finsky.billing.iab.InAppBillingService'");
                    new Utils("").cmdRoot("pm enable 'com.android.vending/com.google.android.finsky.billing.iab.FirstPartyInAppBillingService'");
                    new Utils("").cmdRoot("pm enable 'com.android.vending/com.google.android.finsky.billing.iab.MarketBillingService'");
                }
                if (listAppsFragment.frag != null) {
                    listAppsFragment.frag.runToMain(new Runnable() {
                        public void run() {
                            try {
                                if (listAppsFragment.menu_adapt != null) {
                                    listAppsFragment.removeDialogLP(11);
                                    listAppsFragment.menu_adapt.notifyDataSetChanged();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    class AnonymousClass16 implements Runnable {
        private final /* synthetic */ boolean val$enable;

        AnonymousClass16(boolean z) {
            this.val$enable = z;
        }

        public void run() {
            ArrayList<Components> tmpList = new ArrayList();
            PackageInfo info = Utils.getPkgInfo(Common.GOOGLEPLAY_PKG, 516);
            boolean found_service = false;
            if (info != null && info.services != null && info.services.length != 0) {
                int d = 0;
                while (d < info.services.length) {
                    try {
                        if (this.val$enable) {
                            if (info.services[d].name.endsWith("LicensingService") && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 1) {
                                found_service = true;
                                new Utils("").cmdRoot("pm enable 'com.android.vending/" + info.services[d].name + "'");
                            }
                        } else if (info.services[d].name.endsWith("LicensingService") && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 2) {
                            found_service = true;
                            new Utils("").cmdRoot("pm disable 'com.android.vending/" + info.services[d].name + "'");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    d++;
                }
                if (!found_service && this.val$enable) {
                    new Utils("").cmdRoot("pm enable 'com.android.vending/com.google.android.finsky.services.LicensingService'");
                }
                if (listAppsFragment.frag != null) {
                    listAppsFragment.frag.runToMain(new Runnable() {
                        public void run() {
                            try {
                                if (listAppsFragment.menu_adapt != null) {
                                    listAppsFragment.removeDialogLP(11);
                                    listAppsFragment.menu_adapt.notifyDataSetChanged();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    class AnonymousClass1 implements Runnable {
        private final /* synthetic */ Activity val$context;
        private final /* synthetic */ String val$message;
        private final /* synthetic */ String val$title;

        AnonymousClass1(Activity activity, String str, String str2) {
            this.val$context = activity;
            this.val$title = str;
            this.val$message = str2;
        }

        public void run() {
            AlertDlg dialog = new AlertDlg(this.val$context);
            dialog.setTitle(this.val$title);
            dialog.setMessage(this.val$message);
            dialog.setPositiveButton(2131362193, null);
            try {
                Utils.showDialog(dialog.create());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class OatFunc {
        public int codeOffset = 0;
        public int codeSize = 0;
        public String funcName = null;

        public OatFunc(String funcName, int codeOffset, int codeSize) {
            this.funcName = funcName;
            this.codeOffset = codeOffset;
            this.codeSize = codeSize;
        }
    }

    public class OatFuncDump {
        public ArrayList<OatFunc> funcArray = new ArrayList();
        public String instruction = null;
    }

    class RootTimerTask extends TimerTask {
        Worker work = null;

        public RootTimerTask(Worker worker) {
            this.work = worker;
        }

        public void run() {
            int i = 0;
            if (System.currentTimeMillis() - this.work.lastTimeGetStream < 300000) {
                System.out.println("LuckyPatcher: timeout cancel. Too long process...");
            } else if (listAppsFragment.result.equals("")) {
                System.out.println("LuckyPatcher: timeout for wait root. exit...");
                try {
                    this.work.interrupt();
                    this.work.input.close();
                    try {
                        listAppsFragment com_android_vending_billing_InAppBillingService_LOCK_listAppsFragment;
                        if (listAppsFragment.frag != null) {
                            com_android_vending_billing_InAppBillingService_LOCK_listAppsFragment = listAppsFragment.frag;
                            listAppsFragment.removeDialogLP(23);
                        }
                        com_android_vending_billing_InAppBillingService_LOCK_listAppsFragment = listAppsFragment.frag;
                        listAppsFragment.removeDialogLP(1);
                        com_android_vending_billing_InAppBillingService_LOCK_listAppsFragment = listAppsFragment.frag;
                        listAppsFragment.removeDialogLP(11);
                        String commands = "";
                        try {
                            for (String com : this.work.commands) {
                                commands = "\n" + com;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        listAppsFragment.frag.showMessage("Root error", "Your root hung at commands:" + commands + "\nTry restart operation or updating your superSu and binary su.");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        String[] access$0 = this.work.commands;
                        int length = access$0.length;
                        while (i < length) {
                            System.out.println("Lucky Patcher: freezes root commands:" + access$0[i]);
                            i++;
                        }
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                    Utils.exitRoot();
                    listAppsFragment.semaphoreRoot.release();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private class Worker extends Thread {
        private String[] commands;
        private Integer exitCode;
        public DataInputStream input;
        public long lastTimeGetStream;
        private String result;

        private Worker() {
            this.result = "";
            this.commands = null;
            this.exitCode = null;
            this.input = null;
            this.lastTimeGetStream = 0;
        }

        public void run() {
            boolean dalvikfound = false;
            boolean except = false;
            boolean checkRoot = false;
            boolean skipOut = false;
            boolean send_to_dialog = false;
            for (String command : this.commands) {
                if (command.equals("skipOut")) {
                    skipOut = true;
                }
                if (command.contains("-Xbootclasspath:")) {
                    dalvikfound = true;
                }
                if (command.contains(".runpatchsupport ") || command.contains(".runpatchsupportOld ") || command.contains(".runpatchads ") || command.contains(".odexrunpatch ") || command.contains(".custompatch ")) {
                    send_to_dialog = true;
                }
                if (command.contains(".custompatch ")) {
                }
            }
            while (!this.result.contains("SU Java-Code Running!") && !except) {
                if (this.commands[0].contains("env LD_LIBRARY_PATH=")) {
                    System.out.println("re-run Dalvik on root with environment " + this.commands[0]);
                }
                try {
                    if (this.commands[0].equals("checkRoot")) {
                        System.out.println("LuckyPatcher: test root.");
                        this.commands[0] = "ps init";
                        checkRoot = true;
                    }
                    listAppsFragment.countRoot++;
                    int thread_number = listAppsFragment.countRoot;
                    System.out.println("Block root thread" + listAppsFragment.countRoot);
                    try {
                        if (!listAppsFragment.semaphoreRoot.tryAcquire(300, TimeUnit.SECONDS)) {
                            System.out.println("Root command timeout. Bad root.");
                            Utils.exitRoot();
                            listAppsFragment.semaphoreRoot.release();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    listAppsFragment.countRoot--;
                    Utils.getRoot();
                    System.out.println("UNBlock root thread N" + thread_number);
                    for (String command2 : this.commands) {
                        if (dalvikfound) {
                            listAppsFragment.suOutputStream.writeBytes(new String((listAppsFragment.toolfilesdir + "/busybox killall dalvikvm\n").getBytes(), "ISO-8859-1"));
                        }
                        if (!command2.equals("skipOut")) {
                            listAppsFragment.suOutputStream.writeBytes(new String(new StringBuilder(String.valueOf(command2)).append("\n").toString().getBytes(), "ISO-8859-1"));
                        }
                    }
                    listAppsFragment.suOutputStream.writeBytes("echo 'chelpus done!'\n");
                    listAppsFragment.suOutputStream.flush();
                    if (skipOut) {
                        break;
                    }
                    this.result = Utils.this.getInput(send_to_dialog, this);
                    if (send_to_dialog) {
                        send_to_dialog = false;
                    }
                    try {
                        if (listAppsFragment.suErrorInputStream == null) {
                            break;
                        }
                        byte[] arrayErrorOfByte = new byte[listAppsFragment.suErrorInputStream.available()];
                        listAppsFragment.suErrorInputStream.read(arrayErrorOfByte);
                        listAppsFragment.errorOutput = new String(arrayErrorOfByte);
                        if (listAppsFragment.errorOutput.contains("env: not found")) {
                            Utils.exitRoot();
                        }
                        if (new String(arrayErrorOfByte).trim().equals("")) {
                            listAppsFragment.errorOutput = "";
                        } else {
                            System.out.println("LuckyApcther root errors: " + listAppsFragment.errorOutput);
                            listAppsFragment.errorOutput = new String(arrayErrorOfByte);
                        }
                        if (dalvikfound) {
                            int i = 0;
                            while (i < this.commands.length) {
                                if (this.commands[i].contains("-Xbootclasspath:")) {
                                    if (this.commands[i].contains("env LD_LIBRARY_PATH=") || this.commands[i].contains(".checkDataSize ") || this.commands[i].contains(".custompatch ")) {
                                        except = true;
                                        break;
                                    }
                                    String val = System.getenv("LD_LIBRARY_PATH");
                                    String temp = this.commands[i];
                                    if (listAppsFragment.errorOutput.contains("env: not found")) {
                                        this.commands[i] = "env LD_LIBRARY_PATH=" + val + " " + temp;
                                    } else {
                                        except = true;
                                    }
                                    if (this.result.contains("SU Java-Code Running!")) {
                                        except = true;
                                    } else {
                                        this.result = "";
                                    }
                                }
                                i++;
                            }
                        } else {
                            except = true;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        Utils.exitRoot();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (IOException localIOException) {
                    localIOException.printStackTrace();
                    System.out.println("LuckyPatcher (result root): root not found.");
                    listAppsFragment.semaphoreRoot.release();
                    return;
                } catch (Exception e32) {
                    e32.printStackTrace();
                    listAppsFragment.semaphoreRoot.release();
                    return;
                }
            }
            if (checkRoot) {
                System.out.println("LuckyPatcher (result root): " + this.result);
            }
            if (this.result.equals("") && checkRoot) {
                if (dalvikfound) {
                    Utils.exitRoot();
                } else {
                    listAppsFragment.semaphoreRoot.release();
                }
                this.result = Utils.ROOT_NOT_FOUND;
                return;
            }
            if (this.result.equals("")) {
                this.result = "~";
            }
            if (dalvikfound) {
                Utils.exitRoot();
            } else {
                listAppsFragment.semaphoreRoot.release();
            }
        }
    }

    public Utils(String activity) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.chelpus.Utils.OatFuncDump getOffsetOatdump(java.io.File r26, java.util.ArrayList<java.lang.String> r27) {
        /*
        r25 = this;
        r18 = "";
        r17 = 0;
        r15 = new java.util.ArrayList;
        r15.<init>();
        r16 = new java.util.ArrayList;
        r16.<init>();
        r13 = new com.chelpus.Utils$OatFuncDump;
        r0 = r25;
        r13.<init>();
        r22 = 4;
        r0 = r22;
        r4 = new java.lang.String[r0];	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = 0;
        r23 = "oatdump";
        r4[r22] = r23;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = 1;
        r23 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r24 = "--oat-file=";
        r23.<init>(r24);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r24 = r26.getAbsolutePath();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r23 = r23.append(r24);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r23 = r23.toString();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r4[r22] = r23;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = 2;
        r23 = "--no-disassemble";
        r4[r22] = r23;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = 3;
        r23 = "--no-dump:vmap";
        r4[r22] = r23;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r0 = r22;
        r17 = r0.exec(r4);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r3 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r23 = r17.getInputStream();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22.<init>(r23);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r0 = r22;
        r3.<init>(r0);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r10 = 0;
        r11 = 0;
        r8 = 0;
        r5 = 0;
    L_0x0062:
        r12 = r3.readLine();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        if (r12 != 0) goto L_0x0070;
    L_0x0068:
        if (r17 == 0) goto L_0x006d;
    L_0x006a:
        r17.destroy();
    L_0x006d:
        r17 = 0;
        return r13;
    L_0x0070:
        if (r10 != 0) goto L_0x0083;
    L_0x0072:
        if (r11 == 0) goto L_0x0077;
    L_0x0074:
        r13.instruction = r12;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r10 = 1;
    L_0x0077:
        r22 = "INSTRUCTION SET:";
        r0 = r22;
        r22 = r12.equals(r0);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        if (r22 == 0) goto L_0x0062;
    L_0x0081:
        r11 = 1;
        goto L_0x0062;
    L_0x0083:
        if (r5 != 0) goto L_0x00a7;
    L_0x0085:
        r22 = "dex_method_idx";
        r0 = r22;
        r22 = r12.contains(r0);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        if (r22 == 0) goto L_0x0062;
    L_0x008f:
        r22 = r27.iterator();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
    L_0x0093:
        r23 = r22.hasNext();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        if (r23 == 0) goto L_0x0062;
    L_0x0099:
        r9 = r22.next();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r9 = (java.lang.String) r9;	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r23 = r12.contains(r9);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        if (r23 == 0) goto L_0x0093;
    L_0x00a5:
        r5 = r9;
        goto L_0x0093;
    L_0x00a7:
        r22 = "CODE: ";
        r0 = r22;
        r22 = r12.contains(r0);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        if (r22 == 0) goto L_0x0062;
    L_0x00b1:
        r8 = r8 + 1;
        r22 = 40;
        r0 = r22;
        r22 = r12.indexOf(r0);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = r22 + 1;
        r23 = 41;
        r0 = r23;
        r23 = r12.indexOf(r0);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r0 = r22;
        r1 = r23;
        r21 = r12.substring(r0, r1);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = "\\s+";
        r20 = r21.split(r22);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = 0;
        r22 = r20[r22];	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r23 = 0;
        r23 = r20[r23];	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r24 = 61;
        r23 = r23.indexOf(r24);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r23 = r23 + 1;
        r22 = r22.substring(r23);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = java.lang.Integer.decode(r22);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r14 = r22.intValue();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = 2;
        r22 = r20[r22];	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r23 = 2;
        r23 = r20[r23];	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r24 = 61;
        r23 = r23.indexOf(r24);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r23 = r23 + 1;
        r22 = r22.substring(r23);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r22 = java.lang.Integer.decode(r22);	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r19 = r22.intValue();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r0 = r13.funcArray;	 Catch:{ Exception -> 0x0140, IOException -> 0x012e }
        r22 = r0;
        r23 = new com.chelpus.Utils$OatFunc;	 Catch:{ Exception -> 0x0140, IOException -> 0x012e }
        r0 = r23;
        r1 = r25;
        r2 = r19;
        r0.<init>(r5, r14, r2);	 Catch:{ Exception -> 0x0140, IOException -> 0x012e }
        r22.add(r23);	 Catch:{ Exception -> 0x0140, IOException -> 0x012e }
    L_0x011d:
        r5 = 0;
        r22 = r27.size();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r0 = r22;
        if (r8 != r0) goto L_0x0062;
    L_0x0126:
        r3.close();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        r17.destroy();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        goto L_0x0068;
    L_0x012e:
        r7 = move-exception;
        r22 = r7.toString();
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.errorOutput = r22;
        r22 = java.lang.System.out;
        r23 = r7.toString();
        r22.println(r23);
        goto L_0x0068;
    L_0x0140:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ IOException -> 0x012e, Exception -> 0x0145 }
        goto L_0x011d;
    L_0x0145:
        r6 = move-exception;
        r6.printStackTrace();
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.Utils.getOffsetOatdump(java.io.File, java.util.ArrayList):com.chelpus.Utils$OatFuncDump");
    }

    public static void showDialog(Dialog dialog) {
        try {
            if (listAppsFragment.patchAct != null && !listAppsFragment.patchAct.isFinishing()) {
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialogYesNo(String title, String message, DialogInterface.OnClickListener yes, DialogInterface.OnClickListener no, OnCancelListener cancel) {
        try {
            if (listAppsFragment.patchAct != null && !listAppsFragment.patchAct.isFinishing()) {
                Dialog dialog = new AlertDlg(listAppsFragment.frag.getContext()).setTitle(title).setMessage(message).setIcon(2130837547).setPositiveButton(getText(2131361795), yes).setNegativeButton(getText(2131362169), no).setOnCancelListener(cancel).create();
                showDialog(dialog);
                dialog.findViewById(16908299);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialogYesNoAndCheckBox(String title, String message, String checkbox_text, OnCheckedChangeListener onCheckedChangeListener, boolean default_set_checkbox, DialogInterface.OnClickListener yes, DialogInterface.OnClickListener no, OnCancelListener cancel) {
        try {
            if (listAppsFragment.patchAct != null && !listAppsFragment.patchAct.isFinishing()) {
                Dialog dialog = new AlertDlg(listAppsFragment.frag.getContext()).setTitle(title).setMessage(message).setIcon(2130837547).setPositiveButton(getText(2131361795), yes).setNegativeButton(getText(2131362169), no).setOnCancelListener(cancel).setCheckBox(checkbox_text, onCheckedChangeListener, default_set_checkbox).create();
                showDialog(dialog);
                dialog.findViewById(16908299);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialogCustomYes(String title, String message, String button_yes, DialogInterface.OnClickListener yes, DialogInterface.OnClickListener no, OnCancelListener cancel) {
        try {
            if (listAppsFragment.patchAct != null && !listAppsFragment.patchAct.isFinishing()) {
                Dialog dialog = new AlertDlg(listAppsFragment.frag.getContext()).setTitle(title).setMessage(message).setIcon(2130837547).setPositiveButton(button_yes, yes).setNegativeButton(getText(2131362169), no).setOnCancelListener(cancel).create();
                showDialog(dialog);
                dialog.findViewById(16908299);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialogCustomYesNo(String title, String message, String button_yes, DialogInterface.OnClickListener yes, String button_no, DialogInterface.OnClickListener no, OnCancelListener cancel) {
        try {
            if (listAppsFragment.patchAct != null && !listAppsFragment.patchAct.isFinishing()) {
                Dialog dialog = new AlertDlg(listAppsFragment.frag.getContext()).setTitle(title).setMessage(message).setIcon(2130837547).setPositiveButton(button_yes, yes).setNegativeButton(button_no, no).setOnCancelListener(cancel).create();
                showDialog(dialog);
                dialog.findViewById(16908299);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showMessage(Activity context, String title, String message) {
        context.runOnUiThread(new AnonymousClass1(context, title, message));
    }

    public static long getRandom(long start, long end) {
        long val;
        Random random = new Random();
        long bits;
        do {
            bits = (random.nextLong() << 1) >>> 1;
            val = bits % ((end - start) + 1);
        } while ((bits - val) + (end - start) < 0);
        return val + start;
    }

    public static boolean pattern_checker(Activity context) {
        System.out.println(context.getApplicationInfo().sourceDir);
        String str = "MIIDDTCCAfWgAwIBAgIEeR8eUDANBgkqhkiG9w0BAQsFADA3MQswCQYDVQQGEwJVUzEQMA4GA1UEChMHQW5kcm9pZDEWMBQGA1UEAxMNQW5kcm9pZCBEZWJ1ZzAeFw0xMTEyMDgwNjA1MTBaFw00MTExMzAwNjA1MTBaMDcxCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdBbmRyb2lkMRYwFAYDVQQDEw1BbmRyb2lkIERlYnVnMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhENqFp22Dq9M/CEU4on3/xGfoWggUk4tahTdC/okxdVO/nB27odddvB+zDiMSq+mGFprWxk31pzu+W31pbdq4tnBF6aqzhLanAjxVoeuqNUDzXfqNhxjQDJjZ9Q9zntEHNllIkfJclYyADf1GHjQs9vpgo58EXQ4Wt8REG9P+8My5ENmVkfTA3L7yryyTnplRn7d+jVtIcJEKY0s/kCFfRMNJnM2vYYWGpXrmEJFMNPtjvPGvnNgMojHLgWqY7z7foplBjGfEItX/huYZqp7+ZaGWyrksXHStEUXUa7TJJiW++R4e4VL6jIDwTHGOAgYaVA/ZarfLquQhXP28vBNhwIDAQABoyEwHzAdBgNVHQ4EFgQUNrZ//EPQx9WdAor2L5dvsy6i9eYwDQYJKoZIhvcNAQELBQADggEBAH09ZytGQmSrbGNjbCMnuZ+UuKOP+nN5j0U0hbMisC+2rcox36S23hVDPEc7rcBMo/Aep4kY/CZCO9UnRVP5NG3YugQU2mwimM2po4pZZbOBCDx4dEjA4ymJpKlS4fEPQ1qp5p9um8wmMVg5Yl5y9dGpxNF/USDW5jq+H8SBhfcrro+m4V+G/jPGWSN/0QwJpb0dmsD2MLgw7/HyJPnymvSEzom6e7Oe4aJDzOKuRM5hrfvsNyH+WTq+f+IElEVMg1zwo0JHhFTppxEFROPHTYO2FjMdrA26KdPcLTS07pzpP00/0n+4R7SPoAHzMBptlvNZws9KvaQEiOc0ObXhjL0=";
        byte[] s = null;
        try {
            s = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            System.out.println();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        if (Base64.encode(s).replaceAll("\n", "").equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isRebuildedOrOdex(String pkgName, Context context) {
        String str = "MIIEqDCCA5CgAwIBAgIJAJNurL4H8gHfMA0GCSqGSIb3DQEBBQUAMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTAeFw0wODAyMjkwMTMzNDZaFw0zNTA3MTcwMTMzNDZaMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBANaTGQTexgskse3HYuDZ2CU+Ps1s6x3i/waMqOi8qM1r03hupwqnbOYOuw+ZNVn/2T53qUPn6D1LZLjk/qLT5lbx4meoG7+yMLV4wgRDvkxyGLhG9SEVhvA4oU6Jwr44f46+z4/Kw9oe4zDJ6pPQp8PcSvNQIg1QCAcy4ICXF+5qBTNZ5qaU7Cyz8oSgpGbIepTYOzEJOmc3Li9kEsBubULxWBjf/gOBzAzURNps3cO4JFgZSAGzJWQTT7/emMkod0jb9WdqVA2BVMi7yge54kdVMxHEa5r3b97szI5p58ii0I54JiCUP5lyfTwE/nKZHZnfm644oLIXf6MdW2r+6R8CAQOjgfwwgfkwHQYDVR0OBBYEFEhZAFY9JyxGrhGGBaR0GawJyowRMIHJBgNVHSMEgcEwgb6AFEhZAFY9JyxGrhGGBaR0GawJyowRoYGapIGXMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbYIJAJNurL4H8gHfMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADggEBAHqvlozrUMRBBVEY0NqrrwFbinZaJ6cVosK0TyIUFf/azgMJWr+kLfcHCHJsIGnlw27drgQAvilFLAhLwn62oX6snb4YLCBOsVMR9FXYJLZW2+TcIkCRLXWG/oiVHQGo/rWuWkJgU134NDEFJCJGjDbiLCpe+ZTWHdcwauTJ9pUbo8EvHRkU3cYfGmLaLfgn9gP+pWA7LFQNvXwBnDa6sppCccEX31I828XzgXpJ4O+mDL1/dBd+ek8ZPUP0IgdyZm5MTYPhvVqGCHzzTy3sIeJFymwrsBbmg2OAUNLEMO6nwmocSdN2ClirfxqCzJOLSDE4QyS9BAH6EhY6UFcOaE0=";
        byte[] s = null;
        try {
            PackageInfo pkgInfo = listAppsFragment.getPkgMng().getPackageInfo(pkgName, 64);
            try {
                s = pkgInfo.signatures[0].toByteArray();
                if (isOdex(pkgInfo.applicationInfo.sourceDir) || listAppsFragment.getConfig().getBoolean(pkgName, false)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        }
        if (s == null) {
            return false;
        }
        if (Base64.encode(s).replaceAll("\n", "").equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isModified(String pkgName, Context context) {
        String str = "MIIEqDCCA5CgAwIBAgIJAJNurL4H8gHfMA0GCSqGSIb3DQEBBQUAMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTAeFw0wODAyMjkwMTMzNDZaFw0zNTA3MTcwMTMzNDZaMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBANaTGQTexgskse3HYuDZ2CU+Ps1s6x3i/waMqOi8qM1r03hupwqnbOYOuw+ZNVn/2T53qUPn6D1LZLjk/qLT5lbx4meoG7+yMLV4wgRDvkxyGLhG9SEVhvA4oU6Jwr44f46+z4/Kw9oe4zDJ6pPQp8PcSvNQIg1QCAcy4ICXF+5qBTNZ5qaU7Cyz8oSgpGbIepTYOzEJOmc3Li9kEsBubULxWBjf/gOBzAzURNps3cO4JFgZSAGzJWQTT7/emMkod0jb9WdqVA2BVMi7yge54kdVMxHEa5r3b97szI5p58ii0I54JiCUP5lyfTwE/nKZHZnfm644oLIXf6MdW2r+6R8CAQOjgfwwgfkwHQYDVR0OBBYEFEhZAFY9JyxGrhGGBaR0GawJyowRMIHJBgNVHSMEgcEwgb6AFEhZAFY9JyxGrhGGBaR0GawJyowRoYGapIGXMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbYIJAJNurL4H8gHfMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADggEBAHqvlozrUMRBBVEY0NqrrwFbinZaJ6cVosK0TyIUFf/azgMJWr+kLfcHCHJsIGnlw27drgQAvilFLAhLwn62oX6snb4YLCBOsVMR9FXYJLZW2+TcIkCRLXWG/oiVHQGo/rWuWkJgU134NDEFJCJGjDbiLCpe+ZTWHdcwauTJ9pUbo8EvHRkU3cYfGmLaLfgn9gP+pWA7LFQNvXwBnDa6sppCccEX31I828XzgXpJ4O+mDL1/dBd+ek8ZPUP0IgdyZm5MTYPhvVqGCHzzTy3sIeJFymwrsBbmg2OAUNLEMO6nwmocSdN2ClirfxqCzJOLSDE4QyS9BAH6EhY6UFcOaE0=";
        byte[] s = null;
        try {
            s = listAppsFragment.getPkgMng().getPackageInfo(pkgName, 64).signatures[0].toByteArray();
            if (listAppsFragment.getConfig().getBoolean(pkgName, false)) {
                return true;
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        if (Base64.encode(s).replaceAll("\n", "").equals(str)) {
            return true;
        }
        return false;
    }

    public void deleteFolder(File fileOrDirectory) throws IOException {
        if (fileOrDirectory.exists()) {
            if (fileOrDirectory.isDirectory() && fileOrDirectory.listFiles() != null) {
                for (File child : fileOrDirectory.listFiles()) {
                    deleteFolder(child);
                }
            }
            new File(fileOrDirectory.toString()).delete();
        }
    }

    public String findFile(File fileOrDirectory, String name) throws IOException {
        if (!fileOrDirectory.exists()) {
            return "";
        }
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                String result = findFile(child, name);
                if (!result.equals("")) {
                    return result;
                }
            }
        }
        if (fileOrDirectory.getName().equals(name)) {
            return fileOrDirectory.getAbsolutePath();
        }
        return "";
    }

    public void fixPermissions(File fileOrDirectory, String permission) throws IOException {
        run_all_no_root("chmod", permission, fileOrDirectory.getAbsolutePath());
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                run_all_no_root("chmod", permission, fileOrDirectory.getAbsolutePath());
                fixPermissions(child, permission);
            }
        }
    }

    public void fixOwners(File fileOrDirectory, String owners) throws IOException {
        run_all_no_root("chown", owners, fileOrDirectory.getAbsolutePath());
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                run_all_no_root("chown", owners, fileOrDirectory.getAbsolutePath());
                fixOwners(child, owners);
            }
        }
    }

    public void setAllWritable(File fileOrDirectory) {
        try {
            fileOrDirectory.setWritable(true);
            if (fileOrDirectory.isDirectory()) {
                for (File child : fileOrDirectory.listFiles()) {
                    fileOrDirectory.setWritable(true);
                    setAllWritable(child);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
        }
    }

    public void setAllReadable(File fileOrDirectory) {
        try {
            fileOrDirectory.setReadable(true);
            if (fileOrDirectory.isDirectory()) {
                for (File child : fileOrDirectory.listFiles()) {
                    fileOrDirectory.setReadable(true);
                    setAllReadable(child);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
        }
    }

    public String findFileEndText(File fileOrDirectory, String name, ArrayList<File> listFiles) throws IOException {
        if (!fileOrDirectory.exists()) {
            return "";
        }
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                String result = findFileEndText(child, name, listFiles);
                if (!result.equals("")) {
                    addFileToList(new File(result), listFiles);
                }
            }
        }
        if (!fileOrDirectory.getName().endsWith(name)) {
            return "";
        }
        addFileToList(fileOrDirectory, listFiles);
        return fileOrDirectory.getAbsolutePath();
    }

    public String findFileContainText(File fileOrDirectory, String name) throws IOException {
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                String result = findFileContainText(child, name);
                if (!result.equals("")) {
                    return result;
                }
            }
        }
        if (fileOrDirectory.getName().contains(name)) {
            return fileOrDirectory.getAbsolutePath();
        }
        return "";
    }

    public float sizeFolder(File fileOrDirectory, boolean top) throws IOException {
        if (top) {
            this.folder_size = 0.0f;
        }
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                sizeFolder(child, false);
            }
        }
        this.folder_size += (float) new File(fileOrDirectory.toString()).length();
        return this.folder_size / 1048576.0f;
    }

    public static void copyFolder(File src, File dest) throws Exception {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from " + src + "  to " + dest);
            }
            String[] files = src.list();
            if (files.length > 0) {
                for (String file : files) {
                    copyFolder(new File(src, file), new File(dest, file));
                }
                return;
            }
            return;
        }
        copyFile(src, dest);
    }

    public static void copyFile(File in, File out) {
        String destination;
        boolean no_space = false;
        try {
            String source;
            FileChannel inChannel = new FileInputStream(in).getChannel();
            FileChannel outChannel = new FileOutputStream(out).getChannel();
            try {
                for (long position = 0; position < inChannel.size(); position += inChannel.transferTo(position, (long) 67076096, outChannel)) {
                }
                if (inChannel != null) {
                    inChannel.close();
                }
                if (outChannel != null) {
                    outChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (e.toString().toLowerCase().contains("no space left")) {
                    no_space = true;
                }
                if (!e.toString().toLowerCase().contains("no space left")) {
                    System.out.println("try copy with root");
                    if (listAppsFragment.su) {
                        if (getRootUid()) {
                            source = in.getAbsoluteFile().toString();
                            destination = out.getAbsoluteFile().toString();
                            cmd("dd if=" + source + " of=" + destination);
                            if (!(new File(destination).exists() && in.length() == out.length())) {
                                cmd("toolbox dd if=" + source + " of=" + destination);
                            }
                            if (!(new File(destination).exists() && in.length() == out.length())) {
                                cmd("busybox dd if=" + source + " of=" + destination);
                            }
                            if (in.length() != out.length()) {
                                out.delete();
                            }
                        } else {
                            copyFile(in.getAbsoluteFile().toString(), out.getAbsoluteFile().toString(), true, true);
                        }
                    }
                }
                if (inChannel != null) {
                    inChannel.close();
                }
                if (outChannel != null) {
                    outChannel.close();
                }
            } catch (Throwable th) {
                if (inChannel != null) {
                    inChannel.close();
                }
                if (outChannel != null) {
                    outChannel.close();
                }
            }
            if (in.length() != out.length()) {
                out.delete();
                if (listAppsFragment.su && !no_space) {
                    if (listAppsFragment.startUnderRoot.booleanValue()) {
                        source = in.getAbsoluteFile().toString();
                        destination = out.getAbsoluteFile().toString();
                        cmdParam("dd", "if=" + source, "of=" + destination);
                        if (!(new File(destination).exists() && in.length() == out.length())) {
                            cmdParam("toolbox", "dd", "if=" + source, "of=" + destination);
                        }
                        if (!(new File(destination).exists() && in.length() == out.length())) {
                            cmdParam("busybox", "dd", "if=" + source, "of=" + destination);
                        }
                        if (in.length() != out.length()) {
                            out.delete();
                            return;
                        }
                        return;
                    }
                    copyFile(in.getAbsoluteFile().toString(), out.getAbsoluteFile().toString(), true, true);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void clear_dalvik_cache() {
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            if (listAppsFragment.api >= 23) {
                try {
                    if (new File("/data/app").exists()) {
                        for (File tail : new File("/data/app").listFiles()) {
                            if (tail.isDirectory()) {
                                File[] oats = tail.listFiles();
                                if (oats != null && oats.length > 0) {
                                    for (File oat : oats) {
                                        if (oat.isDirectory() && oat.getName().equals("oat")) {
                                            System.out.println("delete folder:" + oat.getAbsolutePath());
                                            new Utils("").deleteFolder(oat);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
            run_all_no_root("rm", "/data/dalvik-cache/*.dex");
            run_all_no_root("rm", "/data/dalvik-cache/*.oat");
            run_all_no_root("rm", "/data/dalvik-cache/*.art");
            run_all_no_root("rm", "/data/dalvik-cache/arm/*.dex");
            run_all_no_root("rm", "/data/dalvik-cache/arm/*.art");
            run_all_no_root("rm", "/data/dalvik-cache/arm/*.oat");
            run_all_no_root("rm", "/data/dalvik-cache/arm64/*.dex");
            run_all_no_root("rm", "/data/dalvik-cache/arm64/*.art");
            run_all_no_root("rm", "/data/dalvik-cache/arm64/*.oat");
            run_all_no_root("rm", "/data/dalvik-cache/x86/*.dex");
            run_all_no_root("rm", "/data/dalvik-cache/x86/*.art");
            run_all_no_root("rm", "/data/dalvik-cache/x86/*.oat");
            run_all_no_root("rm", "/data/dalvik-cache/x86_64/*.dex");
            run_all_no_root("rm", "/data/dalvik-cache/x86_64/*.art");
            run_all_no_root("rm", "/data/dalvik-cache/x86_64/*.oat");
            return;
        }
        run_all("rm /data/dalvik-cache/*.dex");
        run_all("rm /data/dalvik-cache/*.oat");
        run_all("rm /data/dalvik-cache/*.art");
        run_all("rm /data/dalvik-cache/arm/*.dex");
        run_all("rm /data/dalvik-cache/arm/*.art");
        run_all("rm /data/dalvik-cache/arm/*.oat");
        run_all("rm /data/dalvik-cache/arm64/*.dex");
        run_all("rm /data/dalvik-cache/arm64/*.art");
        run_all("rm /data/dalvik-cache/arm64/*.oat");
        run_all("rm /data/dalvik-cache/x86/*.dex");
        run_all("rm /data/dalvik-cache/x86/*.art");
        run_all("rm /data/dalvik-cache/x86/*.oat");
        run_all("rm /data/dalvik-cache/x86_64/*.dex");
        run_all("rm /data/dalvik-cache/x86_64/*.art");
        run_all("rm /data/dalvik-cache/x86_64/*.oat");
    }

    public static boolean getRootUid() {
        try {
            if (System.getProperty("user.name").contains("root")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<File> getCustomPatchesForPkg(String pkgName) {
        int i;
        ArrayList<File> s = new ArrayList();
        if (listAppsFragment.customlist == null || listAppsFragment.customlist.length == 0) {
            listAppsFragment.init(listAppsFragment.getInstance());
            try {
                listAppsFragment.basepath = listAppsFragment.getConfig().getString("basepath", listAppsFragment.basepath);
                listAppsFragment.customlist = new File[new File(listAppsFragment.basepath).listFiles().length];
                listAppsFragment.customlist = new File(listAppsFragment.basepath).listFiles();
                ArrayList<File> cus = new ArrayList();
                cus.clear();
                i = 0;
                while (i < listAppsFragment.customlist.length) {
                    if (listAppsFragment.customlist[i].isFile() && listAppsFragment.customlist[i].getName().endsWith(".txt")) {
                        cus.add(listAppsFragment.customlist[i]);
                    }
                    i++;
                }
                if (cus.size() > 0) {
                    listAppsFragment.customlist = new File[cus.size()];
                    listAppsFragment.customlist = (File[]) cus.toArray(listAppsFragment.customlist);
                }
            } catch (Exception e) {
                System.out.println("Not found dir by Lucky Patcher. Custom patch not found.");
            }
        }
        try {
            if (listAppsFragment.customlist != null && listAppsFragment.customlist.length > 0) {
                i = 0;
                while (i < listAppsFragment.customlist.length) {
                    if (listAppsFragment.customlist[i].getName().contains("_%ALL%.txt")) {
                        if (pkgName.contains(listAppsFragment.customlist[i].getName().replace("_%ALL%.txt", ""))) {
                            s.add(listAppsFragment.customlist[i]);
                        } else if (listAppsFragment.customlist[i].getName().contains("_%ALL%.txt") && listAppsFragment.customlist[i].getName().contains("%ALL%_") && pkgName.contains(listAppsFragment.customlist[i].getName().split("%ALL%_")[1].replace("_%ALL%.txt", ""))) {
                            s.add(listAppsFragment.customlist[i]);
                        }
                    }
                    if (listAppsFragment.customlist[i].getName().replace(".txt", "").endsWith(pkgName)) {
                        s.add(listAppsFragment.customlist[i]);
                    }
                    i++;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return s;
    }

    public static boolean isCustomPatchesForPkg(String pkgName) {
        int i;
        if (listAppsFragment.customlist == null || listAppsFragment.customlist.length == 0) {
            listAppsFragment.init(listAppsFragment.getInstance());
            try {
                listAppsFragment.basepath = listAppsFragment.getConfig().getString("basepath", listAppsFragment.basepath);
                listAppsFragment.customlist = new File[new File(listAppsFragment.basepath).listFiles().length];
                listAppsFragment.customlist = new File(listAppsFragment.basepath).listFiles();
                ArrayList<File> cus = new ArrayList();
                cus.clear();
                i = 0;
                while (i < listAppsFragment.customlist.length) {
                    if (listAppsFragment.customlist[i].isFile() && listAppsFragment.customlist[i].getName().endsWith(".txt")) {
                        cus.add(listAppsFragment.customlist[i]);
                    }
                    i++;
                }
                if (cus.size() > 0) {
                    listAppsFragment.customlist = new File[cus.size()];
                    listAppsFragment.customlist = (File[]) cus.toArray(listAppsFragment.customlist);
                }
            } catch (Exception e) {
                System.out.println("Not found dir by Lucky Patcher. Custom patch not found.");
            }
        }
        try {
            if (listAppsFragment.customlist == null || listAppsFragment.customlist.length <= 0) {
                return false;
            }
            i = 0;
            while (i < listAppsFragment.customlist.length) {
                if (listAppsFragment.customlist[i].getName().contains("_%ALL%.txt")) {
                    if (pkgName.contains(listAppsFragment.customlist[i].getName().replace("_%ALL%.txt", ""))) {
                        return true;
                    }
                    if (listAppsFragment.customlist[i].getName().contains("_%ALL%.txt") && listAppsFragment.customlist[i].getName().contains("%ALL%_") && pkgName.contains(listAppsFragment.customlist[i].getName().split("%ALL%_")[1].replace("_%ALL%.txt", ""))) {
                        return true;
                    }
                }
                if (listAppsFragment.customlist[i].getName().replace(".txt", "").endsWith(pkgName)) {
                    return true;
                }
                i++;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String changeExtension(String file, String extension) {
        String result = "";
        if (file != null) {
            String[] teils = file.split("\\.");
            for (int i = 0; i < teils.length; i++) {
                if (i < teils.length - 1) {
                    result = new StringBuilder(String.valueOf(result)).append(teils[i]).append(".").toString();
                } else {
                    result = new StringBuilder(String.valueOf(result)).append(extension).toString();
                }
            }
        }
        return result;
    }

    public static String removeExtension(String file) {
        String result = "";
        if (file == null) {
            return result;
        }
        String[] teils = file.split("\\.");
        for (int i = 0; i < teils.length; i++) {
            if (i >= teils.length - 2) {
                return new StringBuilder(String.valueOf(result)).append(teils[i]).toString();
            }
            result = new StringBuilder(String.valueOf(result)).append(teils[i]).append(".").toString();
        }
        return result;
    }

    public static long getfirstInstallTime(String pkgName, boolean apkTime) {
        long installDate = 0;
        if (listAppsFragment.api <= 8 || apkTime) {
            try {
                return new File(listAppsFragment.getPkgMng().getPackageInfo(pkgName, 0).applicationInfo.sourceDir).lastModified();
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                return installDate;
            }
        }
        try {
            return listAppsFragment.getPkgMng().getPackageInfo(pkgName, 0).lastUpdateTime;
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
            return installDate;
        }
    }

    public static Drawable getApkIcon(String path) {
        PackageManager pm = listAppsFragment.getPkgMng();
        PackageInfo info = pm.getPackageArchiveInfo(path, 1);
        if (info == null) {
            return null;
        }
        ApplicationInfo appInfo = info.applicationInfo;
        if (VERSION.SDK_INT >= 8) {
            appInfo.sourceDir = path;
            appInfo.publicSourceDir = path;
        }
        return appInfo.loadIcon(pm);
    }

    public static ApplicationInfo getApkInfo(String path) {
        PackageInfo info = listAppsFragment.getPkgMng().getPackageArchiveInfo(path, 1);
        if (info == null) {
            return null;
        }
        ApplicationInfo appInfo = info.applicationInfo;
        if (VERSION.SDK_INT < 8) {
            return appInfo;
        }
        appInfo.sourceDir = path;
        appInfo.publicSourceDir = path;
        return appInfo;
    }

    public static PackageInfo getApkPackageInfo(String path) {
        PackageInfo info = listAppsFragment.getPkgMng().getPackageArchiveInfo(path, 1);
        return info != null ? info : null;
    }

    public static String getApkLabelName(String path) {
        PackageManager pm = listAppsFragment.getPkgMng();
        PackageInfo info = pm.getPackageArchiveInfo(path, 1);
        if (info == null) {
            return null;
        }
        ApplicationInfo appInfo = info.applicationInfo;
        if (VERSION.SDK_INT >= 8) {
            appInfo.sourceDir = path;
            appInfo.publicSourceDir = path;
        }
        return appInfo.loadLabel(pm).toString();
    }

    public static String cmd(String... commands) {
        int i = 0;
        String result = "";
        Process process = null;
        boolean skipOut = false;
        for (String command : commands) {
            String command2;
            if (command2.equals("skipOut")) {
                skipOut = true;
            }
        }
        int length = commands.length;
        while (i < length) {
            command2 = commands[i];
            try {
                if (!command2.equals("skipOut")) {
                    process = Runtime.getRuntime().exec(new String(command2.getBytes(), "ISO-8859-1"));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    if (skipOut) {
                        new Utils("w").waitLP(2000);
                    } else {
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            result = new StringBuilder(String.valueOf(result)).append(line).append("\n").toString();
                        }
                        process.waitFor();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (InterruptedException e22) {
                e22.printStackTrace();
            }
            i++;
        }
        process.destroy();
        return result;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String cmdParam(java.lang.String... r20) {
        /*
        r16 = "";
        r14 = 0;
        r12 = new java.util.ArrayList;
        r12.<init>();
        r13 = new java.util.ArrayList;
        r13.<init>();
        r4 = 0;
        r0 = r20;
        r0 = r0.length;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = r0;
        r17 = 0;
    L_0x0015:
        r0 = r17;
        r1 = r18;
        if (r0 < r1) goto L_0x008e;
    L_0x001b:
        if (r4 != 0) goto L_0x00d4;
    L_0x001d:
        r17 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r1 = r20;
        r14 = r0.exec(r1);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r3 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = r14.getInputStream();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17.<init>(r18);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r3.<init>(r0);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
    L_0x0039:
        r8 = r3.readLine();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        if (r8 != 0) goto L_0x00b9;
    L_0x003f:
        r14.waitFor();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
    L_0x0042:
        r17 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r18 = r14.getErrorStream();	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r17.<init>(r18);	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.suErrorInputStream = r17;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r17 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.suErrorInputStream;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        if (r17 == 0) goto L_0x0087;
    L_0x0051:
        r17 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.suErrorInputStream;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r17 = r17.available();	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r0 = r17;
        r2 = new byte[r0];	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r17 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.suErrorInputStream;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r0 = r17;
        r0.read(r2);	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r17 = new java.lang.String;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r0 = r17;
        r0.<init>(r2);	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.errorOutput = r17;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r17 = new java.lang.String;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r0 = r17;
        r0.<init>(r2);	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r17 = r17.trim();	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r18 = "";
        r17 = r17.equals(r18);	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        if (r17 != 0) goto L_0x0161;
    L_0x007e:
        r17 = new java.lang.String;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        r0 = r17;
        r0.<init>(r2);	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.errorOutput = r17;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
    L_0x0087:
        if (r14 == 0) goto L_0x008c;
    L_0x0089:
        r14.destroy();
    L_0x008c:
        r14 = 0;
        return r16;
    L_0x008e:
        r7 = r20[r17];	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r19 = "grep";
        r0 = r19;
        r19 = r7.equals(r0);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        if (r19 == 0) goto L_0x009b;
    L_0x009a:
        r4 = 1;
    L_0x009b:
        if (r4 == 0) goto L_0x00a4;
    L_0x009d:
        r13.add(r7);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
    L_0x00a0:
        r17 = r17 + 1;
        goto L_0x0015;
    L_0x00a4:
        r12.add(r7);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        goto L_0x00a0;
    L_0x00a8:
        r6 = move-exception;
        r17 = r6.toString();
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.errorOutput = r17;
        r17 = java.lang.System.out;
        r18 = r6.toString();
        r17.println(r18);
        goto L_0x0087;
    L_0x00b9:
        r17 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = java.lang.String.valueOf(r16);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17.<init>(r18);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r17 = r0.append(r8);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = "\n";
        r17 = r17.append(r18);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r16 = r17.toString();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        goto L_0x0039;
    L_0x00d4:
        r18 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = r12.size();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r0 = new java.lang.String[r0];	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = r0;
        r0 = r17;
        r17 = r12.toArray(r0);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = (java.lang.String[]) r17;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r18;
        r1 = r17;
        r9 = r0.exec(r1);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = r13.size();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r0 = new java.lang.String[r0];	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = r0;
        r0 = r17;
        r17 = r13.toArray(r0);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = (java.lang.String[]) r17;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r18;
        r1 = r17;
        r10 = r0.exec(r1);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r11 = new com.chelpus.Piper;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = r9.getInputStream();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = r10.getOutputStream();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r1 = r18;
        r11.<init>(r0, r1);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = new java.lang.Thread;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r0.<init>(r11);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17.start();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r15 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = r10.getInputStream();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17.<init>(r18);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r15.<init>(r0);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
    L_0x013b:
        r8 = r15.readLine();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        if (r8 != 0) goto L_0x0147;
    L_0x0141:
        r10.waitFor();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r14 = r10;
        goto L_0x0042;
    L_0x0147:
        r17 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = java.lang.String.valueOf(r16);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r17.<init>(r18);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r0 = r17;
        r17 = r0.append(r8);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r18 = "\n";
        r17 = r17.append(r18);	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        r16 = r17.toString();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        goto L_0x013b;
    L_0x0161:
        r17 = "";
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.errorOutput = r17;	 Catch:{ Exception -> 0x0167, IOException -> 0x00a8, InterruptedException -> 0x016d }
        goto L_0x0087;
    L_0x0167:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ IOException -> 0x00a8, InterruptedException -> 0x016d, Exception -> 0x0173 }
        goto L_0x0087;
    L_0x016d:
        r6 = move-exception;
        r6.printStackTrace();
        goto L_0x0087;
    L_0x0173:
        r5 = move-exception;
        r5.printStackTrace();
        goto L_0x0087;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.Utils.cmdParam(java.lang.String[]):java.lang.String");
    }

    public String cmdRoot(String... commands) {
        int i = 0;
        try {
            if (onMainThread()) {
                throw new ShellOnMainThreadException("Application attempted to run a shell command from the main thread");
            }
        } catch (ShellOnMainThreadException e) {
            e.printStackTrace();
        }
        try {
            if (listAppsFragment.startUnderRoot.booleanValue()) {
                throw new ShellOnMainThreadException("Application attempted to run a shell command from the main thread");
            }
        } catch (ShellOnMainThreadException e2) {
            e2.printStackTrace();
        }
        if (!listAppsFragment.su && !commands[0].equals("checkRoot")) {
            return ROOT_NOT_FOUND;
        }
        Worker worker = new Worker();
        worker.commands = commands;
        worker.start();
        boolean f = false;
        try {
            int length = commands.length;
            while (i < length) {
                String command = commands[i];
                if (command.contains("-Xbootclasspath:") || command.contains("dd ") || command.contains("cp ") || command.contains("cat ") || command.contains("pm ")) {
                    f = true;
                }
                i++;
            }
            if (f) {
                worker.join();
            } else {
                worker.join();
                worker.exitCode;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            worker.interrupt();
            Thread.currentThread().interrupt();
            exitRoot();
        }
        return worker.result;
    }

    public String getInput(boolean send_to_dialog, Worker worker) throws Exception {
        Timer timer = new Timer();
        RootTimerTask task = new RootTimerTask(worker);
        if (!(worker.commands[0].contains(".corepatch ") || worker.commands[0].contains("oatdump "))) {
            timer.schedule(task, 600000);
            System.out.println("Input a string within 3 minuten: ");
        }
        String result = "";
        try {
            worker.input = listAppsFragment.suInputStream;
            while (true) {
                String line = readLine(worker.input);
                if (line != null) {
                    worker.lastTimeGetStream = System.currentTimeMillis();
                    if (send_to_dialog && listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                        String message1;
                        if (line.contains("Get classes.dex.")) {
                            message1 = line;
                            listAppsFragment.frag.runToMain(new Runnable() {
                                public void run() {
                                    if (listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131362200));
                                        listAppsFragment.progress_loading.setIndeterminate(false, listAppsFragment.frag.getContext());
                                    }
                                }
                            });
                        }
                        if (line.equals("String analysis.")) {
                            message1 = line;
                            listAppsFragment.frag.runToMain(new Runnable() {
                                public void run() {
                                    if (listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131362201));
                                        listAppsFragment.progress_loading.setIndeterminate(false, listAppsFragment.frag.getContext());
                                    }
                                }
                            });
                        }
                        if (line.equals("Parse data for patch.")) {
                            message1 = line;
                            listAppsFragment.frag.runToMain(new Runnable() {
                                public void run() {
                                    if (listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131362199));
                                        listAppsFragment.progress_loading.setIndeterminate(false, listAppsFragment.frag.getContext());
                                    }
                                }
                            });
                        }
                        if (line.startsWith("Progress size:")) {
                            message1 = line;
                            listAppsFragment.frag.runToMain(new Runnable() {
                                public void run() {
                                    if (listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131362203));
                                        try {
                                            listAppsFragment.progress_loading.setProgress(Integer.valueOf(message1.replace("Progress size:", "")).intValue());
                                        } catch (NumberFormatException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            });
                        }
                        if (line.startsWith("Size file:")) {
                            message1 = line;
                            listAppsFragment.frag.runToMain(new Runnable() {
                                public void run() {
                                    if (listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131362203));
                                        try {
                                            listAppsFragment.progress_loading.setMax(Integer.valueOf(message1.replace("Size file:", "")).intValue());
                                        } catch (NumberFormatException e) {
                                            e.printStackTrace();
                                        }
                                        listAppsFragment.progress_loading.setProgressNumberFormat("%1d/%2d bytes");
                                    }
                                }
                            });
                        }
                        if (line.startsWith("Analise Results:")) {
                            message1 = line;
                            listAppsFragment.frag.runToMain(new Runnable() {
                                public void run() {
                                    if (listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131362204));
                                        listAppsFragment.progress_loading.setMax(6);
                                        listAppsFragment.progress_loading.setProgress(3);
                                        listAppsFragment.progress_loading.setProgressNumberFormat("%1d/%2d");
                                    }
                                }
                            });
                        }
                        if (line.startsWith("Create ODEX:")) {
                            message1 = line;
                            listAppsFragment.frag.runToMain(new Runnable() {
                                public void run() {
                                    if (listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131362205));
                                        listAppsFragment.progress_loading.setProgress(4);
                                    }
                                }
                            });
                        }
                        if (line.startsWith("Optional Steps After Patch:")) {
                            message1 = line;
                            listAppsFragment.frag.runToMain(new Runnable() {
                                public void run() {
                                    if (listAppsFragment.progress_loading != null && listAppsFragment.progress_loading.isShowing()) {
                                        listAppsFragment.progress_loading.setMessage(Utils.getText(2131362206));
                                        listAppsFragment.progress_loading.setProgress(6);
                                    }
                                }
                            });
                        }
                    }
                    if (line.contains("com.chelpus.root.utils.custompatch")) {
                        System.out.println(result);
                        result = "";
                    }
                    if (line.contains("chelpus done!")) {
                        break;
                    } else if (!line.contains("chelpusstart!")) {
                        result = new StringBuilder(String.valueOf(result)).append(line).append("\n").toString();
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("you have entered: " + result);
        return result;
    }

    public static SpannableString getColoredText(String str, String color, String styleText) {
        SpannableString io = new SpannableString(str);
        int typeFace = 0;
        try {
            if (styleText.toLowerCase().contains("bold")) {
                typeFace = 1;
            }
            if (styleText.toLowerCase().contains("bold_italic")) {
                typeFace = 3;
            }
            if (styleText.toLowerCase().contains("italic")) {
                typeFace = 2;
            }
            if (!color.equals("")) {
                io.setSpan(new ForegroundColorSpan(Color.parseColor(color)), 0, str.length(), 0);
            }
            io.setSpan(new StyleSpan(typeFace), 0, str.length(), 0);
            return io;
        } catch (Exception e) {
            e.printStackTrace();
            if (str.length() == 0) {
                str = " ";
            }
            return new SpannableString(str);
        }
    }

    public static SpannableString getColoredText(String str, int color, String styleText) {
        SpannableString io = new SpannableString(str);
        int typeFace = 0;
        try {
            if (styleText.toLowerCase().contains("bold")) {
                typeFace = 1;
            }
            if (styleText.toLowerCase().contains("bold_italic")) {
                typeFace = 3;
            }
            if (styleText.toLowerCase().contains("italic")) {
                typeFace = 2;
            }
            io.setSpan(new ForegroundColorSpan(color), 0, str.length(), 0);
            io.setSpan(new StyleSpan(typeFace), 0, str.length(), 0);
            return io;
        } catch (Exception e) {
            e.printStackTrace();
            if (str.length() == 0) {
                str = " ";
            }
            return new SpannableString(str);
        }
    }

    public static void setTitle(Builder builder, int icon, String text) {
        LinearLayout title = (LinearLayout) View.inflate(listAppsFragment.frag.getContext(), 2130968606, null);
        TextView title_text = (TextView) title.findViewById(2131558429);
        ((ImageView) title.findViewById(2131558428)).setImageDrawable(listAppsFragment.getRes().getDrawable(icon));
        title_text.setText(text);
        builder.setCustomTitle(title);
    }

    public static String readLine(InputStream in) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        while (true) {
            int b = in.read();
            if (b < 0) {
                return null;
            }
            if (b == 10) {
                return new String(buffer.toByteArray(), HttpRequest.CHARSET_UTF8);
            }
            buffer.write(b);
        }
    }

    public static void run_all(String commanda) {
        try {
            if (listAppsFragment.su && !listAppsFragment.checktools) {
                ArrayList<String> toolss = new ArrayList();
                toolss.clear();
                toolss.add(listAppsFragment.toolfilesdir + "/busybox");
                if (exists("/system/bin/failsafe/toolbox")) {
                    toolss.add("/system/bin/failsafe/toolbox");
                }
                listAppsFragment.errorOutput = "";
                new Utils("").cmdRoot("busybox chmod 777 " + listAppsFragment.toolfilesdir + "/busybox");
                if (listAppsFragment.errorOutput.equals("")) {
                    toolss.add("busybox");
                }
                listAppsFragment.errorOutput = "";
                new Utils("").cmdRoot("toolbox chmod 777 " + listAppsFragment.toolfilesdir + "/busybox");
                if (listAppsFragment.errorOutput.equals("")) {
                    toolss.add("toolbox");
                } else {
                    System.out.println("skip toolbox in tools");
                }
                listAppsFragment.tools = new String[toolss.size()];
                listAppsFragment.tools = (String[]) toolss.toArray(listAppsFragment.tools);
                listAppsFragment.checktools = true;
            }
            if (listAppsFragment.su) {
                String[] commands = new String[(listAppsFragment.tools.length + 1)];
                int i = 1;
                commands[0] = commanda;
                for (String tool : listAppsFragment.tools) {
                    commands[i] = tool + " " + commanda;
                    i++;
                }
                new Utils("").cmdRoot(commands);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void run_all_no_root(String... params) {
        try {
            if (!listAppsFragment.checktools) {
                ArrayList<String> toolss = new ArrayList();
                toolss.clear();
                toolss.add(listAppsFragment.toolfilesdir + "/busybox");
                if (exists("/system/bin/failsafe/toolbox")) {
                    toolss.add("/system/bin/failsafe/toolbox");
                }
                listAppsFragment.errorOutput = "";
                cmdParam("busybox", "chmod", "777", listAppsFragment.toolfilesdir + "/busybox");
                if (listAppsFragment.errorOutput.equals("")) {
                    toolss.add("busybox");
                } else {
                    System.out.println("skip busybox in tools");
                }
                listAppsFragment.errorOutput = "";
                cmdParam("toolbox", "chmod", "777", listAppsFragment.toolfilesdir + "/busybox");
                if (listAppsFragment.errorOutput.equals("")) {
                    toolss.add("toolbox");
                } else {
                    System.out.println("skip toolbox in tools");
                }
                listAppsFragment.tools = new String[toolss.size()];
                listAppsFragment.tools = (String[]) toolss.toArray(listAppsFragment.tools);
                listAppsFragment.checktools = true;
            }
            cmdParam(params);
            if (listAppsFragment.tools != null && listAppsFragment.tools.length > 0) {
                String[] tool_params = new String[(params.length + 1)];
                int i = 1;
                for (String param : params) {
                    tool_params[i] = param;
                    i++;
                }
                for (String tool : listAppsFragment.tools) {
                    tool_params[0] = tool;
                    cmdParam(tool_params);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkBind(BindItem item) {
        if (item.TargetDir.trim().startsWith("~chelpus_disabled~")) {
            return false;
        }
        String data1 = "";
        String target1 = "";
        String data = item.SourceDir.trim();
        String target = item.TargetDir.trim();
        if (data.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            data1 = data;
        } else {
            data1 = data.trim() + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        if (target.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            target1 = target;
        } else {
            target1 = target.trim() + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        new File(target).mkdirs();
        new File(data).mkdirs();
        if (!new File(target).exists()) {
            verify_and_run("mkdir", "-p '" + target + "'");
        }
        if (!new File(data).exists()) {
            verify_and_run("mkdir", "-p '" + data + "'");
        }
        try {
            new File(new StringBuilder(String.valueOf(data1)).append("test.txt").toString()).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        run_all("echo '' >'" + data1 + "test.txt'");
        if (exists(new StringBuilder(String.valueOf(target1)).append("test.txt").toString())) {
            new File(new StringBuilder(String.valueOf(data1)).append("test.txt").toString()).delete();
            if (exists(new StringBuilder(String.valueOf(data1)).append("test.txt").toString())) {
                run_all("rm '" + data1 + "test.txt'");
            }
            return true;
        }
        new File(new StringBuilder(String.valueOf(data1)).append("test.txt").toString()).delete();
        if (!exists(new StringBuilder(String.valueOf(data1)).append("test.txt").toString())) {
            return false;
        }
        run_all("rm '" + data1 + "test.txt'");
        return false;
    }

    public static void verify_bind_and_run(String commanda, String parameters, String data, String target) {
        if (!target.trim().startsWith("~chelpus_disabled~")) {
            String data1 = "";
            String target1 = "";
            data = data.trim();
            target = target.trim();
            if (data.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                data1 = data;
            } else {
                data1 = data.trim() + InternalZipConstants.ZIP_FILE_SEPARATOR;
            }
            if (target.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                target1 = target;
            } else {
                target1 = target.trim() + InternalZipConstants.ZIP_FILE_SEPARATOR;
            }
            new File(target).mkdirs();
            new File(data).mkdirs();
            if (!new File(target).exists()) {
                verify_and_run("mkdir", "-p '" + target + "'");
            }
            if (!new File(data).exists()) {
                verify_and_run("mkdir", "-p '" + data + "'");
            }
            try {
                new File(new StringBuilder(String.valueOf(data1)).append("test.txt").toString()).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            run_all("echo '' >'" + data1 + "test.txt'");
            if (exists(new StringBuilder(String.valueOf(target1)).append("test.txt").toString())) {
                System.out.println("LuckyPatcher(Binder): " + target + " exists!");
            } else {
                run_all("umount '" + target + "'");
                System.out.println("data: " + data1 + "test.txt");
                System.out.println("target: " + target1 + "test.txt");
                try {
                    new File(new StringBuilder(String.valueOf(data1)).append("test.txt").toString()).createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                run_all("echo '' >'" + data1 + "test.txt'");
                if (!exists(new StringBuilder(String.valueOf(target1)).append("test.txt").toString())) {
                    new Utils("").cmdRoot("busybox " + commanda + " " + parameters);
                    try {
                        new File(new StringBuilder(String.valueOf(data1)).append("test.txt").toString()).createNewFile();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                    run_all("echo '' >'" + data1 + "test.txt'");
                    if (!exists(new StringBuilder(String.valueOf(target1)).append("test.txt").toString())) {
                        new Utils("").cmdRoot(listAppsFragment.toolfilesdir + "/busybox " + commanda + " " + parameters);
                        new Utils("").cmdRoot("busybox " + commanda + " " + parameters);
                        try {
                            new File(new StringBuilder(String.valueOf(data1)).append("test.txt").toString()).createNewFile();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                        run_all("echo '' >'" + data1 + "test.txt'");
                        if (!exists(new StringBuilder(String.valueOf(target1)).append("test.txt").toString())) {
                            System.out.println("LuckyPatcher(Binder error): bind not created!");
                        }
                    }
                }
            }
            if (exists(new StringBuilder(String.valueOf(data1)).append("test.txt").toString())) {
                if (exists(new StringBuilder(String.valueOf(target1)).append("test.txt").toString())) {
                    System.out.println("LuckyPatcher(Binder): " + target + " binded!");
                } else {
                    System.out.println("LuckyPatcher(Binder error): " + target + " not binded!");
                }
                new File(new StringBuilder(String.valueOf(data1)).append("test.txt").toString()).delete();
                if (exists(new StringBuilder(String.valueOf(data1)).append("test.txt").toString())) {
                    run_all("rm '" + data1 + "test.txt'");
                }
            }
        }
    }

    public static void verify_and_run(String commanda, String parameters) {
        listAppsFragment.errorOutput = "";
        new Utils("").cmdRoot(new StringBuilder(String.valueOf(commanda)).append(" ").append(parameters).toString());
        if (!listAppsFragment.errorOutput.equals("")) {
            new Utils("").cmdRoot("busybox " + commanda + " " + parameters);
        }
        if (!listAppsFragment.errorOutput.equals("")) {
            new Utils("").cmdRoot(listAppsFragment.toolfilesdir + "/busybox " + commanda + " " + parameters);
        }
    }

    public static boolean exists(String file) {
        if (new File(file).exists()) {
            return true;
        }
        if (!listAppsFragment.su) {
            return false;
        }
        if (!listAppsFragment.startUnderRoot.booleanValue()) {
            String result = new Utils("").cmdRoot("ls " + file);
            System.out.println(result);
            if (result.equals(file)) {
                return true;
            }
        }
        return false;
    }

    public static void kill(String process) {
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            killAll(process);
        } else {
            killAll(process);
        }
    }

    public static void startApp(String pkgName) {
        Intent i = listAppsFragment.getPkgMng().getLaunchIntentForPackage(pkgName);
        if (pkgName == null) {
            System.out.println("Error LP: pkgname is null");
        }
        if (i == null) {
            System.out.println("Error LP: launch intent is null");
        }
        if (i == null) {
            Intent main = new Intent("android.intent.action.MAIN", null);
            main.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> launchables = listAppsFragment.getPkgMng().queryIntentActivities(main, 0);
            if (launchables != null) {
                for (ResolveInfo ri : launchables) {
                    if (ri.activityInfo.packageName.equals(pkgName)) {
                        ActivityInfo activity = ri.activityInfo;
                        ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                        i = new Intent("android.intent.action.MAIN");
                        i.addCategory("android.intent.category.LAUNCHER");
                        i.setComponent(name);
                        break;
                    }
                }
            }
        }
        if (listAppsFragment.su) {
            if (i != null) {
                new Utils("").cmdRoot("am start -n " + pkgName + InternalZipConstants.ZIP_FILE_SEPARATOR + i.getComponent().getClassName());
            }
        } else if (listAppsFragment.patchAct != null && i != null) {
            listAppsFragment.patchAct.startActivity(i);
        }
    }

    public static boolean remount(String path, String IO) {
        Mount mountPoint;
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            if (path.toLowerCase().startsWith("/system")) {
                cmdParam("stop", "ric");
                if (new File("/sbin/ric").exists() || new File("/system/bin/ric").exists()) {
                    cmdParam("stop", "ric");
                    run_all_no_root("pkill", "-f", "/sbin/ric");
                    run_all_no_root("pkill", "-f", "/system/bin/ric");
                }
            }
            if (path.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) && !path.equals(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                path = path.substring(0, path.lastIndexOf(InternalZipConstants.ZIP_FILE_SEPARATOR));
            }
            mountPoint = findMountPointRecursive(path);
            if (mountPoint != null) {
                if (!mountPoint.getFlags().contains(IO.toLowerCase(Locale.US))) {
                    try {
                        System.out.println("Run command remount:mount -o remount," + IO.toLowerCase(Locale.US) + " " + mountPoint.getDevice().getAbsolutePath() + " " + mountPoint.getMountPoint().getAbsolutePath());
                        run_all_no_root("blockdev", "--setrw", mountPoint.getDevice().getAbsolutePath());
                        run_all_no_root("mount", "-o", "remount," + IO.toLowerCase(Locale.US), mountPoint.getDevice().getAbsolutePath(), mountPoint.getMountPoint().getAbsolutePath());
                        if (!findMountPointRecursive(path).getFlags().contains(IO.toLowerCase(Locale.US))) {
                            run_all_no_root("mount", "-o", "remount", IO.toLowerCase(Locale.US), findMountPointRecursive(path).getDevice().getAbsolutePath(), findMountPointRecursive(path).getMountPoint().getAbsolutePath());
                        }
                    } catch (Exception e) {
                    }
                    mountPoint = findMountPointRecursive(path);
                }
                if (mountPoint != null) {
                    System.out.println(mountPoint.getFlags() + " AND " + IO.toLowerCase(Locale.US));
                    if (mountPoint.getFlags().toString().contains(IO.toLowerCase(Locale.US))) {
                        System.out.println("Lucky Patcher: remount " + path + " to " + IO);
                        return true;
                    }
                }
            }
            System.out.println("LuckyPatcher:not remount " + path + " to " + IO);
            return false;
        }
        if (path.toLowerCase().startsWith("/system")) {
            new Utils("").cmdRoot("stop ric");
            if (exists("/sbin/ric") || exists("/system/bin/ric")) {
                new Utils("").cmdRoot("stop ric");
                run_all("pkill -f /sbin/ric");
                run_all("pkill -f /system/bin/ric");
            }
        }
        if (path.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) && !path.equals(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            path = path.substring(0, path.lastIndexOf(InternalZipConstants.ZIP_FILE_SEPARATOR));
        }
        mountPoint = findMountPointRecursive(path);
        if (mountPoint != null) {
            if (!mountPoint.getFlags().contains(IO.toLowerCase(Locale.US))) {
                try {
                    System.out.println("Run command remount:mount -o remount," + IO.toLowerCase(Locale.US) + " " + mountPoint.getDevice().getAbsolutePath() + " " + mountPoint.getMountPoint().getAbsolutePath());
                    run_all("blockdev --setrw " + mountPoint.getDevice().getAbsolutePath());
                    run_all("mount -o remount," + IO.toLowerCase(Locale.US) + " " + mountPoint.getDevice().getAbsolutePath() + " " + mountPoint.getMountPoint().getAbsolutePath());
                    mountPoint = findMountPointRecursive(path);
                    if (!mountPoint.getFlags().contains(IO.toLowerCase(Locale.US))) {
                        run_all("mount -o remount " + IO.toLowerCase(Locale.US) + " " + mountPoint.getDevice().getAbsolutePath() + " " + mountPoint.getMountPoint().getAbsolutePath());
                    }
                } catch (Exception e2) {
                }
                mountPoint = findMountPointRecursive(path);
            }
            if (mountPoint != null) {
                System.out.println(mountPoint.getFlags() + " AND " + IO.toLowerCase(Locale.US));
                if (mountPoint.getFlags().toString().contains(IO.toLowerCase(Locale.US))) {
                    System.out.println("Lucky Patcher: remount " + path + " to " + IO);
                    return true;
                }
            }
        }
        System.out.println("LuckyPatcher:not remount " + path + " to " + IO);
        return false;
    }

    private static Mount findMountPointRecursive(String file) {
        try {
            ArrayList<Mount> mounts = getMounts();
            File path = new File(file);
            if (path == null) {
                return null;
            }
            Mount mount;
            Iterator it = mounts.iterator();
            while (it.hasNext()) {
                mount = (Mount) it.next();
                if (mount.getMountPoint().equals(path)) {
                    return mount;
                }
            }
            ArrayList<Mount> selects = new ArrayList();
            it = mounts.iterator();
            while (it.hasNext()) {
                mount = (Mount) it.next();
                if (file.startsWith(mount.getMountPoint().getAbsolutePath())) {
                    selects.add(mount);
                }
            }
            Mount select = null;
            it = selects.iterator();
            while (it.hasNext()) {
                Mount m = (Mount) it.next();
                if (select == null) {
                    select = m;
                }
                if (select.getMountPoint().getAbsolutePath().length() < m.getMountPoint().getAbsolutePath().length()) {
                    select = m;
                }
            }
            if (select != null) {
                System.out.println("recursive mount " + select.getMountPoint().getAbsolutePath());
            }
            return select;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Mount> getMounts() {
        Exception e;
        LineNumberReader lineNumberReader;
        String result = "";
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            result = cmdParam(listAppsFragment.toolfilesdir + "/busybox", "mount");
            if (result.startsWith("~")) {
                result = cmdParam("mount");
                if (result.startsWith("~")) {
                    result = cmdParam("busybox", "mount");
                }
                if (result.startsWith("~")) {
                    result = cmdParam("toolbox", "mount");
                }
            }
        } else {
            result = new Utils("").cmdRoot(listAppsFragment.toolfilesdir + "/busybox mount");
            if (result.startsWith("~")) {
                exitRoot();
                try {
                    listAppsFragment.getSu();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                result = new Utils("").cmdRoot("mount");
                if (result.startsWith("~")) {
                    result = new Utils("").cmdRoot("busybox mount");
                }
                if (result.startsWith("~")) {
                    result = new Utils("").cmdRoot("toolbox mount");
                }
            }
        }
        String[] strings = result.split("\n");
        ArrayList<Mount> mounts = new ArrayList();
        boolean sys_mounts = false;
        try {
            for (String line : strings) {
                String[] fields;
                String line2;
                fields = line2.replace(" on ", " ").replace(" type ", " ").split("\\s+");
                if (fields[1].startsWith("/system")) {
                    sys_mounts = true;
                }
                mounts.add(new Mount(new File(fields[0]), new File(fields[1]), fields[2], fields[3]));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (sys_mounts) {
            return mounts;
        }
        System.out.println("LuckyPatcher: get mounts from /proc/mounts");
        String tempFile = "/data/local/RootToolsMounts";
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            copyFile("/proc/mounts", "/data/local/RootToolsMounts", false, true);
            run_all_no_root("chmod", "777", "/data/local/RootToolsMounts");
        } else {
            copyFile("/proc/mounts", "/data/local/RootToolsMounts", false, true);
            run_all("chmod 777 /data/local/RootToolsMounts");
        }
        mounts.clear();
        try {
            LineNumberReader lnr = new LineNumberReader(new FileReader("/data/local/RootToolsMounts"));
            try {
                ArrayList<Mount> mounts2 = new ArrayList();
                while (true) {
                    line2 = lnr.readLine();
                    if (line2 == null) {
                        lnr.close();
                        return mounts2;
                    }
                    try {
                        fields = line2.split(" ");
                        mounts2.add(new Mount(new File(fields[0]), new File(fields[1]), fields[2], fields[3]));
                    } catch (Exception e4) {
                        e3 = e4;
                        lineNumberReader = lnr;
                        mounts = mounts2;
                    }
                }
            } catch (Exception e5) {
                e3 = e5;
                lineNumberReader = lnr;
                e3.printStackTrace();
                return mounts;
            }
        } catch (Exception e6) {
            e3 = e6;
            e3.printStackTrace();
            return mounts;
        }
    }

    public static void exitRoot() {
        if (!listAppsFragment.startUnderRoot.booleanValue()) {
            System.out.println("LuckyPatcher: exit root.");
            try {
                if (listAppsFragment.suOutputStream != null) {
                    listAppsFragment.suOutputStream.writeBytes("exit\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (listAppsFragment.suProcess != null) {
                    listAppsFragment.suProcess.destroy();
                }
                if (listAppsFragment.suOutputStream != null) {
                    listAppsFragment.suOutputStream.close();
                }
                if (listAppsFragment.suInputStream != null) {
                    listAppsFragment.suInputStream.close();
                }
                if (listAppsFragment.suErrorInputStream != null) {
                    listAppsFragment.suErrorInputStream.close();
                }
            } catch (Exception e22) {
                e22.printStackTrace();
            }
            listAppsFragment.suProcess = null;
            listAppsFragment.suOutputStream = null;
            listAppsFragment.suInputStream = null;
            listAppsFragment.suErrorInputStream = null;
        }
        listAppsFragment.semaphoreRoot.release();
    }

    public static void getRoot() {
        if (!listAppsFragment.startUnderRoot.booleanValue()) {
            try {
                if (listAppsFragment.suProcess == null) {
                    System.out.println("LuckyPatcher: GET ROOT.");
                    listAppsFragment.suProcess = Runtime.getRuntime().exec("su");
                    listAppsFragment.suOutputStream = new DataOutputStream(listAppsFragment.suProcess.getOutputStream());
                    listAppsFragment.suInputStream = new DataInputStream(listAppsFragment.suProcess.getInputStream());
                    listAppsFragment.suErrorInputStream = new DataInputStream(listAppsFragment.suProcess.getErrorStream());
                    return;
                }
                try {
                    listAppsFragment.suOutputStream.writeBytes("echo chelpusstart!\n");
                } catch (Exception e) {
                    exitRoot();
                    listAppsFragment.suProcess = Runtime.getRuntime().exec("su");
                    listAppsFragment.suOutputStream = new DataOutputStream(listAppsFragment.suProcess.getOutputStream());
                    listAppsFragment.suInputStream = new DataInputStream(listAppsFragment.suProcess.getInputStream());
                    listAppsFragment.suErrorInputStream = new DataInputStream(listAppsFragment.suProcess.getErrorStream());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static File getFileDalvikCache(String pathToapk) {
        if (listAppsFragment.api >= 23 && !pathToapk.startsWith("/system/")) {
            String indexDir = "";
            File apk = new File(pathToapk);
            if (new File("/data/dalvik-cache/arm").exists() && new File("/data/dalvik-cache/arm").isDirectory()) {
                indexDir = "/arm";
            }
            if (new File("/data/dalvik-cache/arm64").exists() && new File("/data/dalvik-cache/arm64").isDirectory()) {
                indexDir = "/arm64";
            }
            if (new File("/data/dalvik-cache/x86").exists() && new File("/data/dalvik-cache/x86").isDirectory()) {
                indexDir = "/x86";
            }
            if (new File("/data/dalvik-cache/x86_64").exists() && new File("/data/dalvik-cache/x86_64").isDirectory()) {
                indexDir = "/x86_64";
            }
            String name_odex = changeExtension(apk.getName(), "odex");
            if (!pathToapk.startsWith("/system")) {
                if (indexDir.equals("/arm64")) {
                    File test_file = new File(getDirs(apk) + "/oat/arm/" + name_odex);
                    if (test_file.exists() && test_file.length() != 0) {
                        indexDir = "/arm";
                    }
                }
                File result = new File(getDirs(apk) + "/oat" + indexDir + InternalZipConstants.ZIP_FILE_SEPARATOR + name_odex);
                if (result.exists()) {
                    return result;
                }
            }
        }
        String dalvikcachefile = pathToapk.replaceAll(InternalZipConstants.ZIP_FILE_SEPARATOR, "@");
        while (dalvikcachefile.startsWith("@")) {
            dalvikcachefile = dalvikcachefile.replaceFirst("@", "");
        }
        dalvikcachefile = new StringBuilder(String.valueOf(dalvikcachefile)).append("@classes.dex").toString();
        String dalvik = "";
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            try {
                dalvik = new Utils("").findFileContainText(new File("/data/dalvik-cache"), dalvikcachefile);
                if (dalvik.startsWith("/data/dalvik-cache/arm/") && new File("/data/dalvik-cache/arm64/" + dalvikcachefile).exists()) {
                    dalvik = "/data/dalvik-cache/arm64/" + dalvikcachefile;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!dalvik.equals("")) {
                System.out.println(dalvik);
                if (new File(dalvik).exists()) {
                    return new File(dalvik);
                }
            }
        } else if (new File("/data/dalvik-cache/x86/" + dalvikcachefile).exists()) {
            return new File("/data/dalvik-cache/x86/" + dalvikcachefile);
        } else {
            if (new File("/data/dalvik-cache/x86_64/" + dalvikcachefile).exists()) {
                return new File("/data/dalvik-cache/x86_64/" + dalvikcachefile);
            }
            if (new File("/data/dalvik-cache/arm64/" + dalvikcachefile).exists()) {
                return new File("/data/dalvik-cache/arm64/" + dalvikcachefile);
            }
            if (new File("/data/dalvik-cache/arm/" + dalvikcachefile).exists()) {
                return new File("/data/dalvik-cache/arm/" + dalvikcachefile);
            }
            if (new File("/data/dalvik-cache/" + dalvikcachefile).exists()) {
                return new File("/data/dalvik-cache/" + dalvikcachefile);
            }
        }
        return null;
    }

    public static File getFileDalvikCacheName(String pathToapk) {
        String artcache = "/data/art-cache/";
        if (new File(artcache).exists()) {
            String artcachefile = pathToapk.replaceAll(InternalZipConstants.ZIP_FILE_SEPARATOR, "@");
            while (artcachefile.startsWith("@")) {
                artcachefile = artcachefile.replaceFirst("@", "");
            }
            artcachefile = new StringBuilder(String.valueOf(artcachefile)).append(".oat").toString();
            if (new File(new StringBuilder(String.valueOf(artcache)).append(artcachefile).toString()).exists()) {
                System.out.println("\nLuckyPatcher: found dalvik-cache! " + artcache + artcachefile);
                return new File(new StringBuilder(String.valueOf(artcache)).append(artcachefile).toString());
            }
        }
        String[] dirs_for_dalvikcache = new String[]{"/data/dalvik-cache/", "/data/dalvik-cache/arm64/", "/data/dalvik-cache/arm/", "/data/dalvik-cache/x86/", "/data/dalvik-cache/x86_64/", "/sd-ext/data/dalvik-cache/", "/cache/dalvik-cache/", "/sd-ext/data/cache/dalvik-cache/", "/data/cache/dalvik-cache/"};
        String dalvikcachefile = pathToapk.replaceAll(InternalZipConstants.ZIP_FILE_SEPARATOR, "@");
        while (dalvikcachefile.startsWith("@")) {
            dalvikcachefile = dalvikcachefile.replaceFirst("@", "");
        }
        dalvikcachefile = new StringBuilder(String.valueOf(dalvikcachefile)).append("@classes.dex").toString();
        System.out.println("dalvikfile: " + dalvikcachefile);
        File foundfiles = null;
        for (String dalvikdir : dirs_for_dalvikcache) {
            if (new File(new StringBuilder(String.valueOf(dalvikdir)).append(dalvikcachefile).toString()).exists()) {
                System.out.println("\nLuckyPatcher: found dalvik-cache! " + dalvikdir + dalvikcachefile);
                foundfiles = new File(new StringBuilder(String.valueOf(dalvikdir)).append(dalvikcachefile).toString());
            }
        }
        if (foundfiles == null) {
            if (exists("/data/dalvik-cache/arm") || exists("/data/dalvik-cache/arm64") || exists("/data/dalvik-cache/x86") || exists("/data/dalvik-cache/x86_64")) {
                if (exists("/data/dalvik-cache/arm")) {
                    foundfiles = new File("/data/dalvik-cache/arm/" + dalvikcachefile);
                }
                if (exists("/data/dalvik-cache/arm64")) {
                    foundfiles = new File("/data/dalvik-cache/arm64/" + dalvikcachefile);
                }
                if (exists("/data/dalvik-cache/x86")) {
                    foundfiles = new File("/data/dalvik-cache/x86/" + dalvikcachefile);
                }
                if (exists("/data/dalvik-cache/x86_64")) {
                    foundfiles = new File("/data/dalvik-cache/x86_64/" + dalvikcachefile);
                }
            } else {
                foundfiles = new File("/data/dalvik-cache/" + dalvikcachefile);
            }
        }
        if (listAppsFragment.api >= 23) {
            if (!pathToapk.startsWith("/system/")) {
                String str = "";
                File apk = new File(pathToapk);
                if (listAppsFragment.startUnderRoot.booleanValue()) {
                    if (new File("/data/dalvik-cache/arm").exists() && new File("/data/dalvik-cache/arm").isDirectory()) {
                        str = "/arm";
                    }
                    if (new File("/data/dalvik-cache/arm64").exists() && new File("/data/dalvik-cache/arm64").isDirectory()) {
                        str = "/arm64";
                    }
                    if (new File("/data/dalvik-cache/x86").exists() && new File("/data/dalvik-cache/x86").isDirectory()) {
                        str = "/x86";
                    }
                    if (new File("/data/dalvik-cache/x86_64").exists() && new File("/data/dalvik-cache/x86_64").isDirectory()) {
                        str = "/x86_64";
                    }
                } else {
                    if (exists("/data/dalvik-cache/arm")) {
                        str = "/arm";
                    }
                    if (exists("/data/dalvik-cache/arm64")) {
                        str = "/arm64";
                    }
                    if (exists("/data/dalvik-cache/x86")) {
                        str = "/x86";
                    }
                    if (exists("/data/dalvik-cache/x86_64")) {
                        str = "/x86_64";
                    }
                }
                String name_odex = changeExtension(apk.getName(), "odex");
                if (!pathToapk.startsWith("/system")) {
                    if (str.equals("/arm64")) {
                        File test_file = new File(getDirs(apk) + "/oat/arm/" + name_odex);
                        if (test_file.exists() && test_file.length() != 0) {
                            str = "/arm";
                        }
                    }
                    File result = new File(getDirs(apk) + "/oat" + str + InternalZipConstants.ZIP_FILE_SEPARATOR + name_odex);
                    if (result.exists()) {
                        return result;
                    }
                }
            }
        }
        return foundfiles;
    }

    public static int convertFourBytesToInt(byte b1, byte b2, byte b3, byte b4) {
        return (((b4 << 24) | ((b3 & 255) << 16)) | ((b2 & 255) << 8)) | (b1 & 255);
    }

    public static String checkRuntimeFromCache(String apkFile) {
        String result = "";
        if (listAppsFragment.api < 19) {
            return "DALVIK";
        }
        try {
            FileInputStream localFileInputStream = new FileInputStream(getFileDalvikCache(apkFile));
            byte[] odexHeader = new byte[7];
            localFileInputStream.read(odexHeader);
            localFileInputStream.close();
            byte[] magicDex = new byte[]{(byte) 100, (byte) 101, (byte) 120};
            byte[] bArr = new byte[3];
            bArr = new byte[]{(byte) 100, (byte) 101, (byte) 121};
            int i = 0;
            while (i < 3) {
                if (odexHeader[i] == magicDex[i] || odexHeader[i] == bArr[i]) {
                    i++;
                } else {
                    System.out.println("The magic value is not the expected value " + new String(odexHeader));
                    return "ART";
                }
            }
            return "DALVIK";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
            try {
                System.out.println("Althernative runtime check with java.vm.version");
                if (Integer.parseInt(System.getProperty("java.vm.version").charAt(0)) > 1) {
                    return "ART";
                }
                return "DALVIK";
            } catch (Exception e1) {
                e1.printStackTrace();
                if (listAppsFragment.api >= 21) {
                    return "ART";
                }
                return "DALVIK";
            }
        }
        return "UNKNOWN";
    }

    public static void fixadlerOdex(File destFile, String apk) {
        CRC32 crc2;
        byte[] MAGIC = new byte[8];
        MAGIC[0] = (byte) 100;
        MAGIC[1] = (byte) 101;
        MAGIC[2] = (byte) 121;
        MAGIC[3] = (byte) 10;
        MAGIC[4] = (byte) 48;
        MAGIC[5] = (byte) 51;
        MAGIC[6] = (byte) 53;
        try {
            FileInputStream fileInputStream = new FileInputStream(destFile);
            byte[] odexHeader = new byte[40];
            fileInputStream.read(odexHeader);
            fileInputStream.close();
            for (int i = 0; i < 4; i++) {
                if (odexHeader[i] != MAGIC[i]) {
                    System.out.println("The magic value is not the expected value " + new String(odexHeader));
                    return;
                }
            }
            try {
                ByteBuffer buffer = ByteBuffer.wrap(odexHeader);
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                buffer.position(8);
                int dexoffset = buffer.getInt();
                buffer.position(12);
                int dexLength = buffer.getInt();
                buffer.position(16);
                int depsOffset = buffer.getInt();
                buffer.position(20);
                int depsLength = buffer.getInt();
                buffer.position(24);
                int auxOffset = buffer.getInt();
                buffer.position(28);
                int auxLength = buffer.getInt();
                buffer.position(32);
                int flags = buffer.getInt();
                calcChecksumOdexFly(dexoffset, dexLength, destFile);
                if (listAppsFragment.startUnderRoot.booleanValue()) {
                    run_all_no_root("chmod", "644", apk);
                } else {
                    run_all("chmod 644 " + apk);
                }
                if (apk != null && new File(apk).exists() && new File(apk).length() != 0) {
                    ZioEntry inEntry;
                    int time;
                    int crc;
                    FileChannel ChannelDex;
                    MappedByteBuffer fileBytes;
                    ZipInput input = ZipInput.read(apk);
                    Iterator it = input.getEntries().values().iterator();
                    do {
                        if (it.hasNext()) {
                            try {
                                inEntry = (ZioEntry) it.next();
                            } catch (Exception e) {
                                System.out.println("alternative method");
                                e.printStackTrace();
                                System.out.println("start");
                                System.out.println(apk);
                                InputStream fileInputStream2 = new FileInputStream(apk);
                                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream2);
                                ZipEntry ze = zipInputStream.getNextEntry();
                                while (ze != null) {
                                    try {
                                        if (ze.getName().equals("classes.dex")) {
                                            try {
                                                System.out.println("zeTime:" + ze.getTime());
                                                time = (int) javaToDosTime(ze.getTime());
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                                time = 0;
                                            }
                                            try {
                                                crc = (int) ze.getCrc();
                                                if (crc == -1) {
                                                    crc2 = new CRC32();
                                                    crc2.reset();
                                                    byte[] buffer2 = new byte[LZMA2Options.DICT_SIZE_MIN];
                                                    while (true) {
                                                        int length = zipInputStream.read(buffer2);
                                                        if (length == -1) {
                                                            break;
                                                        }
                                                        crc2.update(buffer2, 0, length);
                                                    }
                                                    crc = (int) crc2.getValue();
                                                }
                                            } catch (Exception e12) {
                                                e12.printStackTrace();
                                                crc = 0;
                                            }
                                            try {
                                                ChannelDex = new RandomAccessFile(destFile, InternalZipConstants.WRITE_MODE).getChannel();
                                                fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                                                if (time != 0) {
                                                    fileBytes.position(depsOffset);
                                                    fileBytes.put((byte) time);
                                                    fileBytes.force();
                                                    System.out.println("for file:" + destFile);
                                                    System.out.println("time0:" + ((byte) time));
                                                    fileBytes.position(depsOffset + 1);
                                                    fileBytes.put((byte) (time >> 8));
                                                    fileBytes.force();
                                                    System.out.println("time1:" + (((byte) time) >> 8));
                                                    fileBytes.position(depsOffset + 2);
                                                    fileBytes.put((byte) (time >> 16));
                                                    fileBytes.force();
                                                    System.out.println("time2:" + (((byte) time) >> 16));
                                                    fileBytes.position(depsOffset + 3);
                                                    fileBytes.put((byte) (time >> 24));
                                                    fileBytes.force();
                                                    System.out.println("time3:" + (((byte) time) >> 24));
                                                }
                                                if (crc != 0) {
                                                    fileBytes.position(depsOffset + 4);
                                                    fileBytes.put((byte) crc);
                                                    fileBytes.force();
                                                    fileBytes.position(depsOffset + 5);
                                                    fileBytes.put((byte) (crc >> 8));
                                                    fileBytes.force();
                                                    fileBytes.position(depsOffset + 6);
                                                    fileBytes.put((byte) (crc >> 16));
                                                    fileBytes.force();
                                                    fileBytes.position(depsOffset + 7);
                                                    fileBytes.put((byte) (crc >> 24));
                                                    fileBytes.force();
                                                }
                                                ChannelDex.close();
                                            } catch (FileNotFoundException e13) {
                                                e13.printStackTrace();
                                            } catch (IOException e14) {
                                                e14.printStackTrace();
                                            }
                                            zipInputStream.closeEntry();
                                            zipInputStream.close();
                                            fileInputStream2.close();
                                            return;
                                        }
                                        ze = zipInputStream.getNextEntry();
                                    } catch (Exception e122) {
                                        e122.printStackTrace();
                                        return;
                                    }
                                }
                                zipInputStream.close();
                                fileInputStream2.close();
                                return;
                            }
                        }
                        return;
                    } while (!inEntry.getName().equals("classes.dex"));
                    try {
                        time = (int) javaToDosTime(inEntry.getTime());
                        System.out.println("Time:" + time);
                    } catch (Exception e1222) {
                        e1222.printStackTrace();
                        time = 0;
                    }
                    try {
                        crc = inEntry.getCrc32();
                        System.out.println("CRC32:" + crc);
                        if (crc == -1) {
                            crc2 = new CRC32();
                            crc2.reset();
                            byte[] data = inEntry.getData();
                            crc2.update(data, 0, data.length);
                            crc = (int) crc2.getValue();
                            System.out.println("CRC32:" + crc);
                        }
                    } catch (Exception e12222) {
                        e12222.printStackTrace();
                        crc = 0;
                    }
                    try {
                        ChannelDex = new RandomAccessFile(destFile, InternalZipConstants.WRITE_MODE).getChannel();
                        fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                        if (time != 0) {
                            fileBytes.position(depsOffset);
                            fileBytes.put((byte) time);
                            fileBytes.force();
                            fileBytes.position(depsOffset + 1);
                            fileBytes.put((byte) (time >> 8));
                            fileBytes.force();
                            fileBytes.position(depsOffset + 2);
                            fileBytes.put((byte) (time >> 16));
                            fileBytes.force();
                            fileBytes.position(depsOffset + 3);
                            fileBytes.put((byte) (time >> 24));
                            fileBytes.force();
                        }
                        if (crc != 0) {
                            fileBytes.position(depsOffset + 4);
                            fileBytes.put((byte) crc);
                            fileBytes.force();
                            fileBytes.position(depsOffset + 5);
                            fileBytes.put((byte) (crc >> 8));
                            fileBytes.force();
                            fileBytes.position(depsOffset + 6);
                            fileBytes.put((byte) (crc >> 16));
                            fileBytes.force();
                            fileBytes.position(depsOffset + 7);
                            fileBytes.put((byte) (crc >> 24));
                            fileBytes.force();
                        }
                        ChannelDex.close();
                    } catch (FileNotFoundException e132) {
                        e132.printStackTrace();
                    } catch (IOException e142) {
                        e142.printStackTrace();
                    }
                    input.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public static void fixCRCart(File destFile, ArrayList<File> classesFiles, String apk, String modApp) {
        int crc;
        ArrayList<Integer> crcArr = new ArrayList(classesFiles.size());
        byte[] MAGIC = new byte[8];
        MAGIC[0] = (byte) 100;
        MAGIC[1] = (byte) 101;
        MAGIC[2] = (byte) 121;
        MAGIC[3] = (byte) 10;
        MAGIC[4] = (byte) 48;
        MAGIC[5] = (byte) 51;
        MAGIC[6] = (byte) 53;
        run_all_no_root("chmod", "777", destFile.getAbsolutePath());
        if (apk != null) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        System.out.println(apk);
                        run_all_no_root("chmod", "644", apk);
                        InputStream fileInputStream = new FileInputStream(apk);
                        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                        for (ZipEntry ze = zipInputStream.getNextEntry(); ze != null; ze = zipInputStream.getNextEntry()) {
                            String haystack = ze.getName();
                            if (haystack.startsWith("classes")) {
                                if (haystack.endsWith(".dex")) {
                                    int t = 0;
                                    while (t < classesFiles.size()) {
                                        if (((File) classesFiles.get(t)).getName().equals(haystack)) {
                                            CRC32 crc2;
                                            try {
                                                crc = (int) ze.getCrc();
                                                if (crc == -1) {
                                                    crc2 = new CRC32();
                                                    crc2.reset();
                                                    byte[] buffer2 = new byte[LZMA2Options.DICT_SIZE_MIN];
                                                    while (true) {
                                                        int length = zipInputStream.read(buffer2);
                                                        if (length == -1) {
                                                            break;
                                                        }
                                                        crc2.update(buffer2, 0, length);
                                                    }
                                                    crc = (int) crc2.getValue();
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                crc = 0;
                                            }
                                            try {
                                                crcArr.add(t, Integer.valueOf(crc));
                                                zipInputStream.closeEntry();
                                            } catch (Exception e2) {
                                                System.out.println("Start alternative method.");
                                                System.out.println("start");
                                                ZipInput input = ZipInput.read(apk);
                                                for (ZioEntry inEntry : input.getEntries().values()) {
                                                    if (inEntry.getName().startsWith("classes") && inEntry.getName().endsWith(".dex")) {
                                                        t = 0;
                                                        while (t < classesFiles.size()) {
                                                            if (((File) classesFiles.get(t)).getName().equals(inEntry.getName())) {
                                                                try {
                                                                    crc = inEntry.getCrc32();
                                                                    System.out.println("CRC32:" + crc);
                                                                    if (crc == -1) {
                                                                        crc2 = new CRC32();
                                                                        crc2.reset();
                                                                        byte[] data = inEntry.getData();
                                                                        crc2.update(data, 0, data.length);
                                                                        crc = (int) crc2.getValue();
                                                                        System.out.println("CRC32:" + crc);
                                                                    }
                                                                } catch (Exception e1) {
                                                                    e1.printStackTrace();
                                                                    crc = 0;
                                                                }
                                                                try {
                                                                    crcArr.add(t, Integer.valueOf(crc));
                                                                    input.close();
                                                                } catch (Exception e12) {
                                                                    e12.printStackTrace();
                                                                }
                                                            } else {
                                                                t++;
                                                            }
                                                        }
                                                        continue;
                                                    }
                                                }
                                            }
                                        } else {
                                            t++;
                                        }
                                    }
                                    continue;
                                } else {
                                    continue;
                                }
                            }
                        }
                        zipInputStream.close();
                        fileInputStream.close();
                        try {
                            FileChannel ChannelDex = new RandomAccessFile(destFile, InternalZipConstants.WRITE_MODE).getChannel();
                            MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                            fileBytes.position(LZMA2Options.DICT_SIZE_MIN);
                            int curentPos = -1;
                            byte[] path_apk = modApp.getBytes();
                            byte[] path_apk_multiclasses = new StringBuilder(String.valueOf(modApp)).append(":classes").toString().getBytes();
                            byte[] replaceBytes = apk.getBytes();
                            while (fileBytes.hasRemaining()) {
                                try {
                                    int i;
                                    byte prufbyte;
                                    int f;
                                    fileBytes.position(curentPos + 1);
                                    curentPos = fileBytes.position();
                                    byte curentByte = fileBytes.get();
                                    if (curentByte == path_apk_multiclasses[0]) {
                                        i = 1;
                                        fileBytes.position(curentPos + 1);
                                        prufbyte = fileBytes.get();
                                        while (prufbyte == path_apk_multiclasses[i]) {
                                            i++;
                                            if (i == path_apk_multiclasses.length) {
                                                int y = 0;
                                                byte[] endF = ".dex".getBytes();
                                                String classesName = "classes";
                                                while (y < 7) {
                                                    y++;
                                                    prufbyte = fileBytes.get();
                                                    classesName = new StringBuilder(String.valueOf(classesName)).append((char) prufbyte).toString();
                                                    if (prufbyte == endF[0]) {
                                                        int u = 1;
                                                        prufbyte = fileBytes.get();
                                                        while (u < endF.length && prufbyte == endF[u]) {
                                                            classesName = new StringBuilder(String.valueOf(classesName)).append((char) prufbyte).toString();
                                                            u++;
                                                            if (u == endF.length) {
                                                                f = 0;
                                                                while (f < classesFiles.size()) {
                                                                    if (((File) classesFiles.get(f)).getName().equals(classesName)) {
                                                                        if (((Integer) crcArr.get(f)).intValue() != 0) {
                                                                            fileBytes.put(((Integer) crcArr.get(f)).byteValue());
                                                                            fileBytes.force();
                                                                            fileBytes.put((byte) (((Integer) crcArr.get(f)).intValue() >> 8));
                                                                            fileBytes.force();
                                                                            fileBytes.put((byte) (((Integer) crcArr.get(f)).intValue() >> 16));
                                                                            fileBytes.force();
                                                                            fileBytes.put((byte) (((Integer) crcArr.get(f)).intValue() >> 24));
                                                                            fileBytes.force();
                                                                        }
                                                                        fileBytes.position(curentPos);
                                                                        fileBytes.put(replaceBytes);
                                                                        fileBytes.force();
                                                                        curentPos = fileBytes.position();
                                                                        curentByte = fileBytes.get();
                                                                    } else {
                                                                        f++;
                                                                    }
                                                                }
                                                            }
                                                            prufbyte = fileBytes.get();
                                                        }
                                                    }
                                                }
                                            } else {
                                                prufbyte = fileBytes.get();
                                            }
                                        }
                                    }
                                    if (curentByte == path_apk[0]) {
                                        i = 1;
                                        fileBytes.position(curentPos + 1);
                                        prufbyte = fileBytes.get();
                                        while (prufbyte == path_apk[i]) {
                                            i++;
                                            if (i == path_apk.length) {
                                                int index = 255;
                                                for (f = 0; f < classesFiles.size(); f++) {
                                                    if (((File) classesFiles.get(f)).getName().equals("classes.dex")) {
                                                        index = f;
                                                    }
                                                }
                                                if (index != 255) {
                                                    if (fileBytes.get(curentPos - 1) != (byte) 61) {
                                                        if (fileBytes.get(curentPos - 2) != (byte) 101) {
                                                            if (((Integer) crcArr.get(index)).intValue() != 0) {
                                                                fileBytes.put(((Integer) crcArr.get(index)).byteValue());
                                                                fileBytes.force();
                                                                fileBytes.put((byte) (((Integer) crcArr.get(index)).intValue() >> 8));
                                                                fileBytes.force();
                                                                fileBytes.put((byte) (((Integer) crcArr.get(index)).intValue() >> 16));
                                                                fileBytes.force();
                                                                fileBytes.put((byte) (((Integer) crcArr.get(index)).intValue() >> 24));
                                                                fileBytes.force();
                                                            }
                                                            fileBytes.position(curentPos);
                                                            fileBytes.put(replaceBytes);
                                                            fileBytes.force();
                                                        }
                                                    }
                                                }
                                            } else {
                                                prufbyte = fileBytes.get();
                                            }
                                        }
                                    }
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            ChannelDex.close();
                        } catch (Exception e32) {
                            e32.printStackTrace();
                        }
                    } catch (Exception e322) {
                        e322.printStackTrace();
                    }
                }
            } catch (Exception e3222) {
                System.out.println(e3222);
            }
        }
    }

    public static int convertTwoBytesToInt(byte b1, byte b2) {
        return ((b2 & 255) << 8) | (b1 & 255);
    }

    public static int convertByteToInt(byte b1) {
        return b1 & 255;
    }

    public static boolean isELFfiles(File file) {
        try {
            FileChannel ChannelDex = new RandomAccessFile(file, InternalZipConstants.READ_MODE).getChannel();
            MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_ONLY, 0, (long) ((int) ChannelDex.size()));
            fileBytes.position(0);
            if (fileBytes.get() == Byte.MAX_VALUE && fileBytes.get() == (byte) 69 && fileBytes.get() == (byte) 76 && fileBytes.get() == (byte) 70) {
                ChannelDex.close();
                System.out.println("Check file: is ELF.");
                return true;
            }
            ChannelDex.close();
            System.out.println("Check file: is not ELF.");
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<StringItem> getStringIds(String apk, ArrayList<String> strings, boolean odex) {
        System.out.println("scan: " + apk);
        run_all_no_root("chmod", "777", apk);
        ArrayList<StringItem> results = new ArrayList();
        FileChannel ChannelDex;
        MappedByteBuffer fileBytes;
        int size_of_data;
        int str_lenght;
        int[] offsets;
        int i;
        int index;
        int[] size_strs;
        String[] strs;
        int j;
        int s;
        byte[] buf;
        int r;
        byte[] res;
        boolean bits;
        if (odex) {
            if (new File(apk).exists()) {
                try {
                    ChannelDex = new RandomAccessFile(apk, InternalZipConstants.READ_MODE).getChannel();
                    fileBytes = ChannelDex.map(MapMode.READ_ONLY, 0, (long) ((int) ChannelDex.size()));
                    fileBytes.position(8);
                    int offset_to_dex = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                    fileBytes.position(offset_to_dex + 56);
                    size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                    fileBytes.position(convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()) + offset_to_dex);
                    str_lenght = size_of_data;
                    offsets = new int[str_lenght];
                    for (i = 0; i < str_lenght; i++) {
                        offsets[i] = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()) + offset_to_dex;
                    }
                    index = 0;
                    size_strs = new int[strings.size()];
                    strs = new String[strings.size()];
                    for (i = 0; i < size_strs.length; i++) {
                        size_strs[i] = ((String) strings.get(i)).length();
                        strs[i] = (String) strings.get(i);
                    }
                    for (int offset : offsets) {
                        for (j = 0; j < size_strs.length; j++) {
                            s = convertByteToInt(fileBytes.get(offset));
                            if (s == size_strs[j]) {
                                buf = new byte[s];
                                fileBytes.position(offset + 1);
                                for (r = 0; r < buf.length; r++) {
                                    buf[r] = fileBytes.get();
                                }
                                if (strs[j].equals(new String(buf))) {
                                    res = new byte[]{(byte) index, (byte) (index >> 8), (byte) (index >> 16), (byte) (index >> 24)};
                                    bits = false;
                                    if (offsets.length > InternalZipConstants.MAX_ALLOWED_ZIP_COMMENT_LENGTH) {
                                        bits = true;
                                    }
                                    results.add(new StringItem(strs[j], res, bits));
                                }
                            }
                        }
                        index++;
                    }
                    ChannelDex.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (apk != null) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        if (new File(apk).exists()) {
                            try {
                                ChannelDex = new RandomAccessFile(apk, InternalZipConstants.READ_MODE).getChannel();
                                fileBytes = ChannelDex.map(MapMode.READ_ONLY, 0, (long) ((int) ChannelDex.size()));
                                fileBytes.position(56);
                                size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                fileBytes.position(convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()));
                                str_lenght = size_of_data;
                                offsets = new int[str_lenght];
                                for (i = 0; i < str_lenght; i++) {
                                    offsets[i] = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                }
                                index = 0;
                                size_strs = new int[strings.size()];
                                strs = new String[strings.size()];
                                for (i = 0; i < size_strs.length; i++) {
                                    size_strs[i] = ((String) strings.get(i)).length();
                                    strs[i] = (String) strings.get(i);
                                }
                                for (int offset2 : offsets) {
                                    for (j = 0; j < size_strs.length; j++) {
                                        s = convertByteToInt(fileBytes.get(offset2));
                                        if (s == size_strs[j]) {
                                            buf = new byte[s];
                                            fileBytes.position(offset2 + 1);
                                            for (r = 0; r < buf.length; r++) {
                                                buf[r] = fileBytes.get();
                                            }
                                            if (strs[j].equals(new String(buf))) {
                                                res = new byte[]{(byte) index, (byte) (index >> 8), (byte) (index >> 16), (byte) (index >> 24)};
                                                bits = false;
                                                if (offsets.length > InternalZipConstants.MAX_ALLOWED_ZIP_COMMENT_LENGTH) {
                                                    bits = true;
                                                }
                                                results.add(new StringItem(strs[j], res, bits));
                                            }
                                        }
                                    }
                                    index++;
                                }
                                ChannelDex.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                }
            } catch (Exception e222) {
                System.out.println(e222);
            }
        }
        return results;
    }

    public static int setStringIds(String apk, byte[][] sites, boolean odex, byte charForReplace) {
        System.out.println("scan: " + apk);
        int result = 0;
        run_all_no_root("chmod", "777", apk);
        ArrayList<StringItem> results = new ArrayList();
        FileChannel ChannelDex;
        MappedByteBuffer fileBytes;
        int size_of_data;
        int str_lenght;
        int[] offsets;
        int i;
        int size;
        byte[] buf;
        int position;
        int r;
        int b;
        byte[] pattern_for_block;
        int y;
        int off;
        if (odex) {
            if (new File(apk).exists()) {
                try {
                    ChannelDex = new RandomAccessFile(apk, InternalZipConstants.WRITE_MODE).getChannel();
                    fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                    fileBytes.position(8);
                    int offset_to_dex = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                    fileBytes.position(offset_to_dex + 56);
                    size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                    int offset_to_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()) + offset_to_dex;
                    System.out.println("LuckyPatcher offset_to_data=" + Integer.toHexString(offset_to_data));
                    fileBytes.position(offset_to_data);
                    str_lenght = size_of_data;
                    offsets = new int[str_lenght];
                    for (i = 0; i < str_lenght; i++) {
                        offsets[i] = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()) + offset_to_dex;
                    }
                    for (int offset : offsets) {
                        size = convertByteToInt(fileBytes.get(offset));
                        buf = new byte[size];
                        position = offset + 1;
                        fileBytes.position(position);
                        for (r = 0; r < buf.length; r++) {
                            buf[r] = fileBytes.get();
                        }
                        for (b = 0; b < sites.length; b++) {
                            pattern_for_block = (byte[]) Array.get(sites, b);
                            if (pattern_for_block.length < size && pattern_for_block.length > 2) {
                                y = 0;
                                while (y < buf.length) {
                                    if (buf[y] == pattern_for_block[0]) {
                                        i = 1;
                                        off = y;
                                        while (i < pattern_for_block.length && y + i < buf.length && buf[y + i] == pattern_for_block[i]) {
                                            i++;
                                            if (i == pattern_for_block.length) {
                                                if (pattern_for_block.length > 2) {
                                                    fileBytes.position((position + off) + (pattern_for_block.length - 1));
                                                    fileBytes.put(charForReplace);
                                                }
                                                fileBytes.force();
                                                result++;
                                            }
                                        }
                                    }
                                    y++;
                                }
                            }
                        }
                    }
                    ChannelDex.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (apk != null) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        if (new File(apk).exists()) {
                            try {
                                ChannelDex = new RandomAccessFile(apk, InternalZipConstants.WRITE_MODE).getChannel();
                                fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                                fileBytes.position(56);
                                size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                byte[] stringsList = new byte[(size_of_data / 4)];
                                fileBytes.position(convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()));
                                str_lenght = size_of_data;
                                offsets = new int[str_lenght];
                                for (i = 0; i < str_lenght; i++) {
                                    offsets[i] = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                }
                                for (int offset2 : offsets) {
                                    size = convertByteToInt(fileBytes.get(offset2));
                                    buf = new byte[size];
                                    position = offset2 + 1;
                                    fileBytes.position(position);
                                    for (r = 0; r < buf.length; r++) {
                                        buf[r] = fileBytes.get();
                                    }
                                    for (b = 0; b < sites.length; b++) {
                                        pattern_for_block = (byte[]) Array.get(sites, b);
                                        if (pattern_for_block.length <= size && pattern_for_block.length > 2) {
                                            y = 0;
                                            while (y < buf.length) {
                                                if (buf[y] == pattern_for_block[0]) {
                                                    i = 1;
                                                    off = y;
                                                    while (i < pattern_for_block.length && y + i < buf.length && buf[y + i] == pattern_for_block[i]) {
                                                        i++;
                                                        if (i == pattern_for_block.length) {
                                                            if (pattern_for_block.length > 2) {
                                                                fileBytes.position((position + off) + (pattern_for_block.length - 1));
                                                                fileBytes.put(charForReplace);
                                                            }
                                                            fileBytes.force();
                                                            result++;
                                                        }
                                                    }
                                                }
                                                y++;
                                            }
                                        }
                                    }
                                }
                                ChannelDex.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                }
            } catch (Exception e222) {
                System.out.println(e222);
            }
        }
        return result;
    }

    public static int replaceStringIds(String apk, String[] strings, boolean odex, String[] replaceStrings) {
        System.out.println("scan: " + apk);
        int result = 0;
        run_all_no_root("chmod", "777", apk);
        ArrayList<StringItem> results = new ArrayList();
        FileChannel ChannelDex;
        MappedByteBuffer fileBytes;
        int size_of_data;
        int str_lenght;
        int[] offsets;
        int i;
        int size;
        byte[] buf;
        int position;
        int r;
        int b;
        byte[] string_for_replace;
        if (odex) {
            if (new File(apk).exists()) {
                try {
                    ChannelDex = new RandomAccessFile(apk, InternalZipConstants.WRITE_MODE).getChannel();
                    fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                    fileBytes.position(8);
                    int offset_to_dex = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                    fileBytes.position(offset_to_dex + 56);
                    size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                    int offset_to_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()) + offset_to_dex;
                    System.out.println("LuckyPatcher offset_to_data=" + Integer.toHexString(offset_to_data));
                    fileBytes.position(offset_to_data);
                    str_lenght = size_of_data;
                    offsets = new int[str_lenght];
                    for (i = 0; i < str_lenght; i++) {
                        offsets[i] = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()) + offset_to_dex;
                    }
                    for (int offset : offsets) {
                        size = convertByteToInt(fileBytes.get(offset));
                        buf = new byte[size];
                        position = offset + 1;
                        fileBytes.position(position);
                        for (r = 0; r < buf.length; r++) {
                            buf[r] = fileBytes.get();
                        }
                        for (b = 0; b < strings.length; b++) {
                            if (new String(buf).equals(strings[b])) {
                                string_for_replace = replaceStrings[b].getBytes();
                                if (string_for_replace.length <= size) {
                                    fileBytes.position(offset);
                                    fileBytes.put((byte) string_for_replace.length);
                                    fileBytes.position(position);
                                    fileBytes.put(string_for_replace);
                                    fileBytes.put((byte) 0);
                                    fileBytes.force();
                                    System.out.println("Replace string:" + strings[b]);
                                    result++;
                                }
                            }
                        }
                    }
                    ChannelDex.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (apk != null) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        if (new File(apk).exists()) {
                            try {
                                ChannelDex = new RandomAccessFile(apk, InternalZipConstants.WRITE_MODE).getChannel();
                                fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                                fileBytes.position(56);
                                size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                byte[] stringsList = new byte[(size_of_data / 4)];
                                fileBytes.position(convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()));
                                str_lenght = size_of_data;
                                offsets = new int[str_lenght];
                                for (i = 0; i < str_lenght; i++) {
                                    offsets[i] = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                }
                                for (int offset2 : offsets) {
                                    size = convertByteToInt(fileBytes.get(offset2));
                                    buf = new byte[size];
                                    position = offset2 + 1;
                                    fileBytes.position(position);
                                    for (r = 0; r < buf.length; r++) {
                                        buf[r] = fileBytes.get();
                                    }
                                    for (b = 0; b < strings.length; b++) {
                                        if (new String(buf).equals(strings[b])) {
                                            string_for_replace = replaceStrings[b].getBytes();
                                            if (string_for_replace.length <= size) {
                                                fileBytes.position(offset2);
                                                fileBytes.put((byte) string_for_replace.length);
                                                fileBytes.position(position);
                                                fileBytes.put(string_for_replace);
                                                fileBytes.put((byte) 0);
                                                fileBytes.force();
                                                System.out.println("Replace string:" + strings[b]);
                                                result++;
                                            }
                                        }
                                    }
                                }
                                ChannelDex.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                }
            } catch (Exception e222) {
                System.out.println(e222);
            }
        }
        return result;
    }

    public static int changePackageNameIds(String apk, String packageName, String newPackageName) {
        String pkgNameClasses = "L" + packageName.replaceAll("\\.", InternalZipConstants.ZIP_FILE_SEPARATOR);
        String pkgNameClassesNew = "L" + newPackageName.replaceAll("\\.", InternalZipConstants.ZIP_FILE_SEPARATOR);
        System.out.println(new StringBuilder(String.valueOf(pkgNameClasses)).append(" ").append(pkgNameClassesNew).toString());
        System.out.println("scan: " + apk);
        int result = 0;
        run_all_no_root("chmod", "777", apk);
        ArrayList<StringItem> results = new ArrayList();
        if (apk != null) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        if (new File(apk).exists()) {
                            try {
                                FileChannel ChannelDex = new RandomAccessFile(apk, InternalZipConstants.WRITE_MODE).getChannel();
                                MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                                fileBytes.position(56);
                                int size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                byte[] stringsList = new byte[(size_of_data / 4)];
                                fileBytes.position(convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()));
                                int str_lenght = size_of_data;
                                int[] offsets = new int[str_lenght];
                                for (int i = 0; i < str_lenght; i++) {
                                    offsets[i] = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                }
                                for (int offset : offsets) {
                                    byte[] string_for_replace;
                                    int size = convertByteToInt(fileBytes.get(offset));
                                    byte[] buf = new byte[size];
                                    int position = offset + 1;
                                    fileBytes.position(position);
                                    for (int r = 0; r < buf.length; r++) {
                                        buf[r] = fileBytes.get();
                                    }
                                    if (size >= newPackageName.length() && new String(buf).contains(packageName)) {
                                        string_for_replace = new String(buf).replaceAll(packageName, newPackageName).getBytes();
                                        if (string_for_replace.length <= size) {
                                            fileBytes.position(offset);
                                            fileBytes.put((byte) string_for_replace.length);
                                            fileBytes.position(position);
                                            fileBytes.put(string_for_replace);
                                            fileBytes.put((byte) 0);
                                            fileBytes.force();
                                            result++;
                                        }
                                    }
                                    if (size >= pkgNameClasses.length() && new String(buf).contains(pkgNameClasses)) {
                                        string_for_replace = new String(buf).replaceAll(pkgNameClasses, pkgNameClassesNew).getBytes();
                                        if (string_for_replace.length <= size) {
                                            fileBytes.position(offset);
                                            fileBytes.put((byte) string_for_replace.length);
                                            fileBytes.position(position);
                                            fileBytes.put(string_for_replace);
                                            fileBytes.put((byte) 0);
                                            fileBytes.force();
                                            result++;
                                        }
                                    }
                                }
                                ChannelDex.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e22) {
                System.out.println(e22);
            }
        }
        return result;
    }

    public static int replaceString(String apk, String packageName, String newPackageName) {
        int result = 0;
        byte[] bArr = new byte[packageName.length()];
        bArr = packageName.getBytes();
        byte[] bArr2 = new byte[newPackageName.length()];
        bArr2 = newPackageName.getBytes();
        byte[] byteOrig = new byte[((packageName.length() + packageName.length()) - 1)];
        byte[] byteReplace = new byte[((newPackageName.length() + newPackageName.length()) - 1)];
        int i = 0;
        for (byte b : bArr) {
            byteOrig[i] = b;
            if (i < byteOrig.length - 2) {
                byteOrig[i + 1] = (byte) 0;
            }
            i += 2;
        }
        i = 0;
        for (byte b2 : bArr2) {
            byteReplace[i] = b2;
            if (i < byteReplace.length - 2) {
                byteReplace[i + 1] = (byte) 0;
            }
            i += 2;
        }
        run_all_no_root("chmod", "777", apk);
        if (apk != null) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        if (new File(apk).exists()) {
                            FileChannel ChannelDex = new RandomAccessFile(apk, InternalZipConstants.WRITE_MODE).getChannel();
                            MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                            fileBytes.position(0);
                            while (fileBytes.hasRemaining()) {
                                byte prufbyte;
                                int curentPos = fileBytes.position();
                                byte curentByte = fileBytes.get();
                                if (byteOrig != null && curentByte == byteOrig[0]) {
                                    i = 1;
                                    fileBytes.position(curentPos + 1);
                                    prufbyte = fileBytes.get();
                                    while (fileBytes.hasRemaining() && i < byteOrig.length && prufbyte == byteOrig[i]) {
                                        i++;
                                        try {
                                            if (i == byteOrig.length) {
                                                System.out.println("change package name to " + new File(apk).getName());
                                                fileBytes.position(curentPos);
                                                fileBytes.put(byteReplace);
                                                fileBytes.force();
                                                result++;
                                            }
                                            if (fileBytes.hasRemaining()) {
                                                prufbyte = fileBytes.get();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    fileBytes.position(curentPos + 1);
                                }
                                if (bArr != null && curentByte == bArr[0]) {
                                    i = 1;
                                    fileBytes.position(curentPos + 1);
                                    prufbyte = fileBytes.get();
                                    while (fileBytes.hasRemaining() && i < bArr.length && prufbyte == bArr[i]) {
                                        i++;
                                        if (i == bArr.length) {
                                            System.out.println("change package name to " + new File(apk).getName());
                                            fileBytes.position(curentPos);
                                            fileBytes.put(bArr2);
                                            fileBytes.force();
                                            result++;
                                        }
                                        if (fileBytes.hasRemaining()) {
                                            prufbyte = fileBytes.get();
                                        }
                                    }
                                    fileBytes.position(curentPos + 1);
                                }
                                fileBytes.position(curentPos + 1);
                            }
                            ChannelDex.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e22) {
                System.out.println(e22);
            }
        }
        return result;
    }

    public static int replaceStrings(String apk, String[] stringsForChange) {
        int i;
        int j;
        byte[][] stringsNew = new byte[stringsForChange.length][];
        byte[][] stringsSpaceNew = new byte[stringsForChange.length][];
        byte[][] stringsOrig = new byte[stringsForChange.length][];
        byte[][] stringsSpaceOrig = new byte[stringsForChange.length][];
        if (stringsForChange != null && stringsForChange.length > 0) {
            for (i = 0; i < stringsForChange.length; i++) {
                stringsOrig[i] = new byte[stringsForChange[i].length()];
                stringsOrig[i] = stringsForChange[i].getBytes();
                stringsNew[i] = new byte[stringsForChange[i].length()];
                stringsNew[i] = stringModifyLastChar(stringsForChange[i]).getBytes();
                stringsSpaceOrig[i] = new byte[((stringsOrig[i].length * 2) - 1)];
                stringsSpaceNew[i] = new byte[((stringsOrig[i].length * 2) - 1)];
                j = 0;
                for (byte b : stringsOrig[i]) {
                    stringsSpaceOrig[i][j] = b;
                    if (j < stringsSpaceOrig[i].length - 2) {
                        stringsSpaceOrig[i][j + 1] = (byte) 0;
                    }
                    j += 2;
                }
                j = 0;
                for (byte b2 : stringsNew[i]) {
                    stringsSpaceNew[i][j] = b2;
                    if (j < stringsSpaceNew[i].length - 2) {
                        stringsSpaceNew[i][j + 1] = (byte) 0;
                    }
                    j += 2;
                }
            }
        }
        int result = 0;
        run_all_no_root("chmod", "777", apk);
        if (apk != null) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        if (new File(apk).exists()) {
                            FileChannel ChannelDex = new RandomAccessFile(apk, InternalZipConstants.WRITE_MODE).getChannel();
                            MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                            fileBytes.position(0);
                            while (fileBytes.hasRemaining()) {
                                int curentPos = fileBytes.position();
                                byte curentByte = fileBytes.get();
                                j = 0;
                                while (j < stringsOrig.length) {
                                    try {
                                        byte prufbyte;
                                        if (stringsOrig[j] != null && curentByte == stringsOrig[j][0]) {
                                            i = 1;
                                            fileBytes.position(curentPos + 1);
                                            prufbyte = fileBytes.get();
                                            while (fileBytes.hasRemaining() && i < stringsOrig[j].length && prufbyte == stringsOrig[j][i]) {
                                                i++;
                                                if (i == stringsOrig[j].length) {
                                                    fileBytes.position(curentPos);
                                                    fileBytes.put(stringsNew[j]);
                                                    fileBytes.force();
                                                    result++;
                                                }
                                                if (fileBytes.hasRemaining()) {
                                                    prufbyte = fileBytes.get();
                                                }
                                            }
                                            fileBytes.position(curentPos + 1);
                                        }
                                        if (stringsSpaceOrig[j] != null && curentByte == stringsSpaceOrig[j][0]) {
                                            i = 1;
                                            fileBytes.position(curentPos + 1);
                                            prufbyte = fileBytes.get();
                                            while (fileBytes.hasRemaining() && i < stringsSpaceOrig[j].length && prufbyte == stringsSpaceOrig[j][i]) {
                                                i++;
                                                if (i == stringsSpaceOrig[j].length) {
                                                    fileBytes.position(curentPos);
                                                    fileBytes.put(stringsSpaceNew[j]);
                                                    fileBytes.force();
                                                    result++;
                                                }
                                                if (fileBytes.hasRemaining()) {
                                                    prufbyte = fileBytes.get();
                                                }
                                            }
                                            fileBytes.position(curentPos + 1);
                                        }
                                        j++;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                fileBytes.position(curentPos + 1);
                            }
                            ChannelDex.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e22) {
                System.out.println(e22);
            }
        }
        return result;
    }

    public static boolean getMethodsIds(String apk, ArrayList<CommandItem> commands, boolean odex, boolean onlyFirst) {
        System.out.println("scan: " + apk);
        boolean result = false;
        run_all_no_root("chmod", "777", apk);
        ArrayList<StringItem> results = new ArrayList();
        if (!(odex || apk == null)) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        if (new File(apk).exists()) {
                            try {
                                int i;
                                byte[] res;
                                Iterator it;
                                CommandItem item;
                                FileChannel ChannelDex = new RandomAccessFile(apk, InternalZipConstants.READ_MODE).getChannel();
                                MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_ONLY, 0, (long) ((int) ChannelDex.size()));
                                fileBytes.position(64);
                                int size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                int offset_to_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                System.out.println("LuckyPatcher offset_to_data=" + Integer.toHexString(offset_to_data));
                                fileBytes.position(offset_to_data);
                                int index = 0;
                                for (i = 0; i < size_of_data; i++) {
                                    res = new byte[]{fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()};
                                    it = commands.iterator();
                                    while (it.hasNext()) {
                                        item = (CommandItem) it.next();
                                        if (res[0] == item.Object[0] && res[1] == item.Object[1] && res[2] == item.Object[2] && res[3] == item.Object[3]) {
                                            item.id_object[0] = (byte) index;
                                            item.id_object[1] = (byte) (index >> 8);
                                            item.found_id_object = true;
                                        }
                                    }
                                    index++;
                                }
                                boolean trigger = false;
                                it = commands.iterator();
                                while (it.hasNext()) {
                                    if (((CommandItem) it.next()).found_id_object) {
                                        trigger = true;
                                    }
                                }
                                if (trigger) {
                                    fileBytes.position(88);
                                    size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                    fileBytes.position(convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()));
                                    byte[] command_ids = new byte[size_of_data];
                                    index = 0;
                                    for (i = 0; i < command_ids.length; i++) {
                                        res = new byte[]{fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()};
                                        it = commands.iterator();
                                        while (it.hasNext()) {
                                            item = (CommandItem) it.next();
                                            if (res[0] == item.id_object[0] && res[1] == item.id_object[1] && res[4] == item.Method[0] && res[5] == item.Method[1] && res[6] == item.Method[2] && res[7] == item.Method[3]) {
                                                if (!onlyFirst || !item.found_index_command) {
                                                    item.index_command[0] = (byte) index;
                                                    item.index_command[1] = (byte) (index >> 8);
                                                    item.found_index_command = true;
                                                    result = true;
                                                }
                                            }
                                        }
                                        index++;
                                    }
                                }
                                ChannelDex.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e22) {
                System.out.println(e22);
            }
        }
        return result;
    }

    public static boolean getTypesIds(String apk, ArrayList<TypesItem> types, boolean odex) {
        System.out.println("scan: " + apk);
        boolean result = false;
        run_all_no_root("chmod", "777", apk);
        ArrayList<StringItem> results = new ArrayList();
        if (!(odex || apk == null)) {
            try {
                if (new File(apk).exists() && new File(apk).length() != 0) {
                    try {
                        if (new File(apk).exists()) {
                            try {
                                Iterator it;
                                FileChannel ChannelDex = new RandomAccessFile(apk, InternalZipConstants.READ_MODE).getChannel();
                                MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_ONLY, 0, (long) ((int) ChannelDex.size()));
                                fileBytes.position(64);
                                int size_of_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                int offset_to_data = convertFourBytesToInt(fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get());
                                System.out.println("LuckyPatcher offset_to_data=" + Integer.toHexString(offset_to_data));
                                fileBytes.position(offset_to_data);
                                int index = 0;
                                for (int i = 0; i < size_of_data; i++) {
                                    byte[] res = new byte[]{fileBytes.get(), fileBytes.get(), fileBytes.get(), fileBytes.get()};
                                    it = types.iterator();
                                    while (it.hasNext()) {
                                        TypesItem item = (TypesItem) it.next();
                                        if (res[0] == item.Type[0] && res[1] == item.Type[1] && res[2] == item.Type[2] && res[3] == item.Type[3]) {
                                            item.id_type[0] = (byte) index;
                                            item.id_type[1] = (byte) (index >> 8);
                                            item.found_id_type = true;
                                        }
                                    }
                                    index++;
                                }
                                it = types.iterator();
                                while (it.hasNext()) {
                                    if (((TypesItem) it.next()).found_id_type) {
                                        result = true;
                                    }
                                }
                                ChannelDex.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e22) {
                System.out.println(e22);
            }
        }
        return result;
    }

    private static void calcChecksumOdexFly(int dex_offset, int lengt, File fixFile) {
        try {
            FileChannel ChannelDex = new RandomAccessFile(fixFile, InternalZipConstants.WRITE_MODE).getChannel();
            MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
            Adler32 localAdler32 = new Adler32();
            fileBytes.position(dex_offset + 12);
            while (lengt > 0) {
                localAdler32.update(fileBytes.get());
                lengt--;
            }
            int adler = (int) localAdler32.getValue();
            fileBytes.position(dex_offset + 8);
            fileBytes.put((byte) adler);
            fileBytes.force();
            fileBytes.position(dex_offset + 9);
            fileBytes.put((byte) (adler >> 8));
            fileBytes.force();
            fileBytes.position(dex_offset + 10);
            fileBytes.put((byte) (adler >> 16));
            fileBytes.force();
            fileBytes.position(dex_offset + 11);
            fileBytes.put((byte) (adler >> 24));
            fileBytes.force();
            ChannelDex.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void fixadler(File destFile) {
        try {
            cmdParam("chmod", "777", destFile.getAbsolutePath());
            calcSignature(destFile);
            calcChecksum(destFile);
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private static final void calcChecksum(File dexFile) {
        FileChannel ChannelDex = null;
        try {
            ChannelDex = new RandomAccessFile(dexFile, InternalZipConstants.WRITE_MODE).getChannel();
            MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
            Adler32 localAdler32 = new Adler32();
            fileBytes.position(12);
            while (fileBytes.hasRemaining()) {
                localAdler32.update(fileBytes.get());
            }
            int adler = (int) localAdler32.getValue();
            fileBytes.position(8);
            fileBytes.put((byte) adler);
            fileBytes.force();
            fileBytes.position(9);
            fileBytes.put((byte) (adler >> 8));
            fileBytes.force();
            fileBytes.position(10);
            fileBytes.put((byte) (adler >> 16));
            fileBytes.force();
            fileBytes.position(11);
            fileBytes.put((byte) (adler >> 24));
            fileBytes.force();
            ChannelDex.close();
            if (ChannelDex != null) {
                try {
                    ChannelDex.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (ChannelDex != null) {
                try {
                    ChannelDex.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IOException e32) {
            e32.printStackTrace();
            if (ChannelDex != null) {
                try {
                    ChannelDex.close();
                } catch (IOException e322) {
                    e322.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (ChannelDex != null) {
                try {
                    ChannelDex.close();
                } catch (IOException e3222) {
                    e3222.printStackTrace();
                }
            }
        }
    }

    private static final void calcSignature(File dexFile) {
        try {
            FileChannel ChannelDex = new RandomAccessFile(dexFile, InternalZipConstants.WRITE_MODE).getChannel();
            MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
            MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
            byte[] signature = new byte[20];
            fileBytes.position(32);
            while (fileBytes.hasRemaining()) {
                localMessageDigest.update(fileBytes.get());
            }
            int i = localMessageDigest.digest(signature, 0, 20);
            if (i != 20) {
                throw new RuntimeException("unexpected digest write:" + i + "bytes");
            }
            fileBytes.position(12);
            fileBytes.put(signature);
            fileBytes.force();
            ChannelDex.close();
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            throw new RuntimeException(localNoSuchAlgorithmException);
        } catch (DigestException localDigestException) {
            throw new RuntimeException(localDigestException);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean checkRoot(Boolean message, String interBusybox) {
        internalBusybox = interBusybox;
        new Thread(new Runnable() {
            public void run() {
                try {
                    String result;
                    if (Utils.exists("/system/bin/su")) {
                        if (listAppsFragment.su) {
                            System.out.println("LuckyPatcher: skip root test.");
                            return;
                        }
                        result = new Utils("").cmdRoot("stat -c %a /system/bin/su", Utils.internalBusybox + " stat -c %a /system/bin/su", "busybox stat -c %a /system/bin/su");
                        System.out.println("LuckyPatcher (chek root): get permissions " + result + " /system/bin/su");
                        if (result.contains("6755") || !result.matches("[0-9]")) {
                            System.out.println("LuckyPatcher (chek root): Permissions is true.(/system/bin/su)");
                            return;
                        }
                        System.out.println("LuckyPatcher (chek root): Permissions /system/bin/su not correct.");
                        Utils.remount("/system", InternalZipConstants.WRITE_MODE);
                        new Utils("").cmdRoot("chmod 06755 /system/bin/su");
                        Utils.remount("/system", "ro");
                        result = new Utils("").cmdRoot("stat -c %a /system/bin/su");
                        System.out.println("LuckyPatcher (chek root): " + result + " /system/bin/su");
                        if (result.contains("6755")) {
                            System.out.println("LuckyPatcher (chek root): permission /system/bin/su set 06755");
                        }
                    } else if (Utils.exists("/system/xbin/su")) {
                        new Utils("").cmdRoot("chmod 06777 internalBusybox");
                        if (listAppsFragment.su) {
                            System.out.println("LuckyPatcher: skip root test.");
                            return;
                        }
                        result = new Utils("").cmdRoot("stat -c %a /system/xbin/su", Utils.internalBusybox + " stat -c %a /system/xbin/su", "busybox stat -c %a /system/xbin/su");
                        System.out.println("LuckyPatcher (chek root): get permissions " + result + " /system/xbin/su");
                        if (result.contains("6755") || !result.matches("[0-9]")) {
                            System.out.println("LuckyPatcher (chek root): Permissions is true.(/system/xbin/su)");
                            return;
                        }
                        System.out.println("LuckyPatcher (chek root): Permissions /system/xbin/su not correct.");
                        Utils.remount("/system", InternalZipConstants.WRITE_MODE);
                        new Utils("").cmdRoot("chmod 06755 /system/xbin/su");
                        Utils.remount("/system", "ro");
                        result = new Utils("").cmdRoot("stat -c %a /system/xbin/su");
                        System.out.println("LuckyPatcher (chek root): " + result + " /system/xbin/su");
                        if (result.contains("6755")) {
                            System.out.println("LuckyPatcher (chek root): permission /system/xbin/su set 06755");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).run();
        return true;
    }

    public static int chmod(File path, int mode) throws Exception {
        return ((Integer) Class.forName("android.os.FileUtils").getMethod("setPermissions", new Class[]{String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}).invoke(null, new Object[]{path.getAbsolutePath(), Integer.valueOf(mode), Integer.valueOf(-1), Integer.valueOf(-1)})).intValue();
    }

    public static String read_from_file(File file) {
        Exception e1;
        byte[] result = new byte[((int) file.length())];
        try {
            RandomAccessFile ram = new RandomAccessFile(file, InternalZipConstants.READ_MODE);
            RandomAccessFile randomAccessFile;
            try {
                ram.seek(0);
                ram.read(result);
                ram.close();
                randomAccessFile = ram;
            } catch (Exception e) {
                e1 = e;
                randomAccessFile = ram;
                e1.printStackTrace();
                return new String(result);
            }
        } catch (Exception e2) {
            e1 = e2;
            e1.printStackTrace();
            return new String(result);
        }
        return new String(result);
    }

    public static File getDirs(File file) {
        String[] teils = file.toString().split(File.separator);
        String dir = "";
        for (int i = 0; i < teils.length; i++) {
            if (i != teils.length - 1) {
                dir = new StringBuilder(String.valueOf(dir)).append(teils[i]).append(File.separator).toString();
            }
        }
        return new File(dir);
    }

    public static boolean save_text_to_end_file(File file, String data) {
        Exception e1;
        try {
            if (!file.exists()) {
                getDirs(file).mkdirs();
                file.createNewFile();
            }
            System.out.println("...rrunning my app...");
            RandomAccessFile ram = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            RandomAccessFile randomAccessFile;
            try {
                long lenghtFile = file.length();
                ram.seek(file.length());
                ram.write(data.getBytes());
                System.out.println("...file length..." + ram.length());
                ram.close();
                if (file.length() != ((long) data.length()) + lenghtFile) {
                    randomAccessFile = ram;
                    return false;
                }
                randomAccessFile = ram;
                return true;
            } catch (Exception e) {
                e1 = e;
                randomAccessFile = ram;
                e1.printStackTrace();
                return false;
            }
        } catch (Exception e2) {
            e1 = e2;
            e1.printStackTrace();
            return false;
        }
    }

    public static boolean save_text_to_end_file_from_file(File file, File file2) {
        RandomAccessFile ram2;
        Exception e1;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        String starttag = "#Lucky Patcher block Ads start#";
        String endtag = "#Lucky Patcher block Ads finish#";
        try {
            System.out.println("...rrunning my app...");
            RandomAccessFile ram = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            try {
                ram2 = new RandomAccessFile(file2, InternalZipConstants.READ_MODE);
            } catch (Exception e) {
                e1 = e;
                randomAccessFile = ram;
                e1.printStackTrace();
                return false;
            }
            try {
                long lenghtFile = file.length();
                ram.seek(file.length());
                try {
                    ram.write("#Lucky Patcher block Ads start#\n".getBytes());
                    byte[] readData = new byte[LZMA2Options.DICT_SIZE_MIN];
                    while (true) {
                        int length = ram2.read(readData);
                        if (length <= 0) {
                            ram.write("#Lucky Patcher block Ads finish#\n\n\n\r\n".getBytes());
                            ram2.close();
                            ram.close();
                            randomAccessFile2 = ram2;
                            randomAccessFile = ram;
                            return true;
                        }
                        ram.write(readData, 0, length);
                    }
                } catch (IOException io) {
                    io.printStackTrace();
                    randomAccessFile2 = ram2;
                    randomAccessFile = ram;
                    return false;
                }
            } catch (Exception e2) {
                e1 = e2;
                randomAccessFile2 = ram2;
                randomAccessFile = ram;
                e1.printStackTrace();
                return false;
            }
        } catch (Exception e3) {
            e1 = e3;
            e1.printStackTrace();
            return false;
        }
    }

    public static boolean save_text_to_file(File file, String data) {
        RandomAccessFile randomAccessFile;
        Exception e1;
        try {
            if (!file.exists()) {
                getDirs(file).mkdirs();
                file.createNewFile();
                try {
                    file.setReadable(true, false);
                    file.setWritable(true, false);
                } catch (NoSuchMethodError e) {
                    e.printStackTrace();
                }
            }
            System.out.println("...rrunning my app...");
            RandomAccessFile ram = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            try {
                ram.setLength(0);
                ram.seek(0);
                ram.write(data.getBytes());
                ram.close();
                if (file.length() != ((long) data.length())) {
                    randomAccessFile = ram;
                    return false;
                }
                return true;
            } catch (Exception e2) {
                e1 = e2;
                randomAccessFile = ram;
                e1.printStackTrace();
                return false;
            }
        } catch (Exception e3) {
            e1 = e3;
            e1.printStackTrace();
            return false;
        }
    }

    public static boolean getRawToFile(int raw_resource, File store_to) {
        if (store_to.exists()) {
            store_to.delete();
        } else {
            getDirs(store_to).mkdirs();
        }
        System.out.println("try get file from raw");
        try {
            byte[] readData = new byte[8192];
            InputStream fis = listAppsFragment.getRes().openRawResource(raw_resource);
            FileOutputStream fos = new FileOutputStream(store_to);
            for (int i = fis.read(readData); i > 0; i = fis.read(readData)) {
                fos.write(readData, 0, i);
            }
            fos.flush();
            fos.close();
            fis.close();
            System.out.println("get file from raw");
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static byte[] getFileBuffer(File file, int lenght) {
        try {
            byte[] readData = new byte[lenght];
            new FileInputStream(file).read(readData);
            return readData;
        } catch (IOException e) {
            return null;
        }
    }

    public static byte[] getRawBuffer(int raw_resource, int lenght) {
        try {
            byte[] readData = new byte[lenght];
            listAppsFragment.getRes().openRawResource(raw_resource).read(readData);
            return readData;
        } catch (IOException e) {
            return null;
        }
    }

    public static long getRawLength(int raw_resource) {
        try {
            InputStream inputStream = listAppsFragment.getRes().openRawResource(raw_resource);
            long length = 0;
            byte[] readData = new byte[8192];
            while (true) {
                int block = inputStream.read(readData);
                if (block == -1) {
                    System.out.println("LuckyPatcher (RAW): length = " + length);
                    return length;
                }
                length += (long) block;
            }
        } catch (IOException e) {
            return 0;
        }
    }

    public static String getRawToString(int raw_resource) {
        String result = "";
        try {
            byte[] readData = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
            InputStream fis = listAppsFragment.getRes().openRawResource(raw_resource);
            int i = 0;
            while (i != -1) {
                i = fis.read(readData);
                result = new StringBuilder(String.valueOf(result)).append(new String(readData, HttpRequest.CHARSET_UTF8)).toString();
            }
            fis.close();
            return result;
        } catch (IOException e) {
            return "";
        }
    }

    public static void getAssets(String filename, String path) throws IOException {
        new File(path).mkdirs();
        InputStream in = listAppsFragment.getRes().getAssets().open(filename);
        OutputStream out = new FileOutputStream(new StringBuilder(String.valueOf(path)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(filename).toString());
        byte[] buffer = new byte[8192];
        while (true) {
            int read = in.read(buffer);
            if (read == -1) {
                in.close();
                out.flush();
                out.close();
                return;
            }
            out.write(buffer, 0, read);
        }
    }

    public static boolean isOdex(String apk_file) {
        try {
            File apk = new File(apk_file);
            String name_odex = changeExtension(apk.getName(), "odex");
            if (listAppsFragment.api >= 23) {
                if (new File(getDirs(apk) + "/oat/arm/" + name_odex).exists() || new File(getDirs(apk) + "/oat/arm64/" + name_odex).exists() || new File(getDirs(apk) + "/oat/x86/" + name_odex).exists() || new File(getDirs(apk) + "/oat/x86_64/" + name_odex).exists()) {
                    return true;
                }
            } else if (new File(changeExtension(apk_file, "odex")).exists() || new File(getDirs(apk) + "/arm/" + changeExtension(apk.getName(), "odex")).exists() || new File(getDirs(apk) + "/arm64/" + changeExtension(apk.getName(), "odex")).exists() || new File(getDirs(apk) + "/x86/" + changeExtension(apk.getName(), "odex")).exists()) {
                return true;
            } else {
                if (new File(getDirs(apk) + "/x86_64/" + changeExtension(apk.getName(), "odex")).exists()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getPlaceForOdex(String apk_file, boolean vnutriRoot) {
        File apk = new File(apk_file);
        boolean lolka = false;
        String indexDir = "";
        if (listAppsFragment.api >= 23) {
            String name_odex = changeExtension(apk.getName(), "odex");
            if (vnutriRoot) {
                if (new File("/data/dalvik-cache/arm").exists() && new File("/data/dalvik-cache/arm").isDirectory()) {
                    indexDir = "/arm";
                }
                if (new File("/data/dalvik-cache/arm64").exists() && new File("/data/dalvik-cache/arm64").isDirectory()) {
                    indexDir = "/arm64";
                }
                if (new File("/data/dalvik-cache/x86").exists() && new File("/data/dalvik-cache/x86").isDirectory()) {
                    indexDir = "/x86";
                }
                if (new File("/data/dalvik-cache/x86_64").exists() && new File("/data/dalvik-cache/x86_64").isDirectory()) {
                    indexDir = "/x86_64";
                }
                if (!indexDir.equals("") && new File("/data/dalvik-cache" + indexDir).exists() && new File("/data/dalvik-cache" + indexDir).isDirectory()) {
                }
            } else {
                if (exists("/data/dalvik-cache/arm")) {
                    indexDir = "/arm";
                }
                if (exists("/data/dalvik-cache/arm64")) {
                    indexDir = "/arm64";
                }
                if (exists("/data/dalvik-cache/x86")) {
                    indexDir = "/x86";
                }
                if (exists("/data/dalvik-cache/x86_64")) {
                    indexDir = "/x86_64";
                }
                if (!indexDir.equals("") && exists("/data/dalvik-cache" + indexDir)) {
                }
            }
            return getDirs(apk) + "/oat" + indexDir + InternalZipConstants.ZIP_FILE_SEPARATOR + name_odex;
        }
        if (vnutriRoot) {
            if (new File("/data/dalvik-cache/arm").exists() && new File("/data/dalvik-cache/arm").isDirectory()) {
                indexDir = "/arm";
            }
            if (new File("/data/dalvik-cache/arm64").exists() && new File("/data/dalvik-cache/arm64").isDirectory()) {
                indexDir = "/arm64";
            }
            if (new File("/data/dalvik-cache/x86").exists() && new File("/data/dalvik-cache/x86").isDirectory()) {
                indexDir = "/x86";
            }
            if (new File("/data/dalvik-cache/x86_64").exists() && new File("/data/dalvik-cache/x86_64").isDirectory()) {
                indexDir = "/x86_64";
            }
            if (!indexDir.equals("") && new File("/data/dalvik-cache" + indexDir).exists() && new File("/data/dalvik-cache" + indexDir).isDirectory()) {
                lolka = true;
            }
        } else {
            if (exists("/data/dalvik-cache/arm")) {
                indexDir = "/arm";
            }
            if (exists("/data/dalvik-cache/arm64")) {
                indexDir = "/arm64";
            }
            if (exists("/data/dalvik-cache/x86")) {
                indexDir = "/x86";
            }
            if (exists("/data/dalvik-cache/x86_64")) {
                indexDir = "/x86_64";
            }
            if (!indexDir.equals("") && exists("/data/dalvik-cache" + indexDir)) {
                lolka = true;
            }
        }
        if (lolka) {
            return getDirs(apk) + indexDir + InternalZipConstants.ZIP_FILE_SEPARATOR + changeExtension(apk.getName(), "odex");
        }
        return changeExtension(apk_file, "odex");
    }

    public static String getOdexForCreate(String apk_file, String uid) {
        if (listAppsFragment.startUnderRoot == null || !listAppsFragment.startUnderRoot.booleanValue()) {
            if (listAppsFragment.startUnderRoot == null) {
                System.out.println("uderRoot not defined");
            }
            if (!listAppsFragment.startUnderRoot.booleanValue()) {
                System.out.println("uderRoot false");
            }
        } else {
            System.out.println("Start under Root");
        }
        File apk = new File(apk_file);
        boolean lolka = false;
        String str = "";
        if (listAppsFragment.api >= 23) {
            String name_odex = changeExtension(apk.getName(), "odex");
            if (listAppsFragment.startUnderRoot.booleanValue()) {
                if (new File("/data/dalvik-cache/arm").exists() && new File("/data/dalvik-cache/arm").isDirectory()) {
                    str = "/arm";
                }
                if (new File("/data/dalvik-cache/arm64").exists() && new File("/data/dalvik-cache/arm64").isDirectory()) {
                    str = "/arm64";
                }
                if (new File("/data/dalvik-cache/x86").exists() && new File("/data/dalvik-cache/x86").isDirectory()) {
                    str = "/x86";
                }
                if (new File("/data/dalvik-cache/x86_64").exists() && new File("/data/dalvik-cache/x86_64").isDirectory()) {
                    str = "/x86_64";
                }
                if (!str.equals("") && new File("/data/dalvik-cache" + str).exists() && new File("/data/dalvik-cache" + str).isDirectory()) {
                    System.out.println(new StringBuilder(String.valueOf(str)).append(" to dalvik cache found").toString());
                    System.out.println("check " + getDirs(apk) + "/oat" + str);
                    if (!(new File(getDirs(apk) + "/oat" + str).exists() && new File(getDirs(apk) + "/oat" + str).isDirectory())) {
                        new File(getDirs(apk) + "/oat" + str).mkdirs();
                        System.out.println("try make dirs");
                        if (new File(getDirs(apk) + "/oat" + str).exists()) {
                            System.out.println("dirs created");
                            if (uid.equals("0")) {
                                run_all_no_root("chmod", "755", getDirs(apk) + "/oat");
                                run_all_no_root("chown", "0." + uid, getDirs(apk) + "/oat");
                                run_all_no_root("chown", "0:" + uid, getDirs(apk) + "/oat");
                                run_all_no_root("chmod", "755", getDirs(apk) + "/oat" + str);
                                run_all_no_root("chown", "0." + uid, getDirs(apk) + "/oat" + str);
                                run_all_no_root("chown", "0:" + uid, getDirs(apk) + "/oat" + str);
                            } else {
                                run_all_no_root("chmod", "755", getDirs(apk) + "/oat");
                                run_all_no_root("chown", "1000." + uid, getDirs(apk) + "/oat");
                                run_all_no_root("chown", "1000:" + uid, getDirs(apk) + "/oat");
                                run_all_no_root("chmod", "755", getDirs(apk) + "/oat" + str);
                                run_all_no_root("chown", "1000." + uid, getDirs(apk) + "/oat" + str);
                                run_all_no_root("chown", "1000:" + uid, getDirs(apk) + "/oat" + str);
                            }
                        }
                    }
                }
            } else {
                if (exists("/data/dalvik-cache/arm")) {
                    str = "/arm";
                }
                if (exists("/data/dalvik-cache/arm64")) {
                    str = "/arm64";
                }
                if (exists("/data/dalvik-cache/x86")) {
                    str = "/x86";
                }
                if (exists("/data/dalvik-cache/x86_64")) {
                    str = "/x86_64";
                }
                if (!str.equals("") && exists("/data/dalvik-cache" + str)) {
                    if (!exists(getDirs(apk) + "/oat" + str)) {
                        run_all("mkdir -p '" + getDirs(apk) + "/oat" + str + "'");
                        if (exists(getDirs(apk) + "/oat" + str)) {
                            if (uid.equals("0")) {
                                run_all("chmod 755 " + getDirs(apk) + "/oat");
                                run_all("chown 0." + uid + " " + getDirs(apk) + "/oat");
                                run_all("chown 0:" + uid + " " + getDirs(apk) + "/oat");
                                run_all("chmod 755 " + getDirs(apk) + "/oat" + str);
                                run_all("chown 0." + uid + " " + getDirs(apk) + "/oat" + str);
                                run_all("chown 0:" + uid + " " + getDirs(apk) + "/oat" + str);
                            } else {
                                run_all("chmod 755 " + getDirs(apk) + "/oat");
                                run_all("chown 1000." + uid + " " + getDirs(apk) + "/oat");
                                run_all("chown 1000:" + uid + " " + getDirs(apk) + "/oat");
                                run_all("chmod 755 " + getDirs(apk) + "/oat" + str);
                                run_all("chown 1000." + uid + " " + getDirs(apk) + "/oat" + str);
                                run_all("chown 1000:" + uid + " " + getDirs(apk) + "/oat" + str);
                            }
                        }
                    }
                }
            }
            if (str.equals("/arm64")) {
                File test_file = new File(getDirs(apk) + "/oat/arm/" + name_odex);
                if (test_file.exists() && test_file.length() != 0) {
                    str = "/arm";
                }
            }
            return getDirs(apk) + "/oat" + str + InternalZipConstants.ZIP_FILE_SEPARATOR + name_odex;
        }
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            if (new File("/data/dalvik-cache/arm").exists() && new File("/data/dalvik-cache/arm").isDirectory()) {
                str = "/arm";
            }
            if (new File("/data/dalvik-cache/arm64").exists() && new File("/data/dalvik-cache/arm64").isDirectory()) {
                str = "/arm64";
            }
            if (new File("/data/dalvik-cache/x86").exists() && new File("/data/dalvik-cache/x86").isDirectory()) {
                str = "/x86";
            }
            if (new File("/data/dalvik-cache/x86_64").exists() && new File("/data/dalvik-cache/x86_64").isDirectory()) {
                str = "/x86_64";
            }
            if (!str.equals("") && new File("/data/dalvik-cache" + str).exists() && new File("/data/dalvik-cache" + str).isDirectory()) {
                System.out.println(new StringBuilder(String.valueOf(str)).append(" to dalvik cache found").toString());
                System.out.println("check " + getDirs(apk) + str);
                if (!(new File(getDirs(apk) + str).exists() && new File(getDirs(apk) + str).isDirectory())) {
                    new File(getDirs(apk) + str).mkdirs();
                    System.out.println("try make dirs");
                    if (new File(getDirs(apk) + str).exists()) {
                        System.out.println("dirs created");
                        if (uid.equals("0")) {
                            run_all_no_root("chmod", "755", getDirs(apk) + str);
                            run_all_no_root("chown", "0." + uid, getDirs(apk) + str);
                            run_all_no_root("chown", "0:" + uid, getDirs(apk) + str);
                        } else {
                            run_all_no_root("chmod", "755", getDirs(apk) + str);
                            run_all_no_root("chown", "1000." + uid, getDirs(apk) + str);
                            run_all_no_root("chown", "1000:" + uid, getDirs(apk) + str);
                        }
                    }
                }
                lolka = true;
            }
        } else {
            if (exists("/data/dalvik-cache/arm")) {
                str = "/arm";
            }
            if (exists("/data/dalvik-cache/arm64")) {
                str = "/arm64";
            }
            if (exists("/data/dalvik-cache/x86")) {
                str = "/x86";
            }
            if (exists("/data/dalvik-cache/x86_64")) {
                str = "/x86_64";
            }
            if (!str.equals("") && exists("/data/dalvik-cache" + str)) {
                if (!exists(getDirs(apk) + str)) {
                    run_all("mkdir -p '" + getDirs(apk) + str + "'");
                    if (exists(getDirs(apk) + str)) {
                        if (uid.equals("0")) {
                            run_all("chmod 755 " + getDirs(apk) + str);
                            run_all("chown 0." + uid + " " + getDirs(apk) + str);
                            run_all("chown 0:" + uid + " " + getDirs(apk) + str);
                        } else {
                            run_all("chmod 755 " + getDirs(apk) + str);
                            run_all("chown 1000." + uid + " " + getDirs(apk) + str);
                            run_all("chown 1000:" + uid + " " + getDirs(apk) + str);
                        }
                    }
                }
                lolka = true;
            }
        }
        if (lolka) {
            return getDirs(apk) + str + InternalZipConstants.ZIP_FILE_SEPARATOR + changeExtension(apk.getName(), "odex");
        }
        return changeExtension(apk_file, "odex");
    }

    public static final boolean isAds(String name) {
        if (name.contains(".ads.") || name.contains("adwhirl") || name.contains("amobee") || name.contains("burstly") || name.contains("com.adknowledge.") || name.contains("cauly.android.ad.") || name.contains(".greystripe.") || name.contains("inmobi.") || name.contains("inneractive.api.ads.") || name.contains(".jumptap.adtag.") || name.contains(".mdotm.android.ads.") || name.contains("medialets.advertising.") || name.contains(".millennialmedia.android.") || name.contains(".mobclix.android.sdk.") || name.contains(".mobfox.sdk.") || name.contains(".adserver.adview.") || name.contains(".mopub.mobileads.") || name.contains("com.oneriot.") || name.contains(".papaya.offer.") || name.contains("pontiflex.mobile.webview.sdk.activities") || name.contains(".qwapi.adclient.android.view.") || name.contains(".smaato.SOMA.") || name.contains(".vdopia.client.android.") || name.contains(".zestadz.android.") || name.contains("com.appenda.") || name.contains("com.airpush.android.") || name.contains("com.Leadbolt.") || name.contains("com.moolah.") || name.contains("com.tapit.adview.notif.") || name.contains("com.urbanairship.push.") || name.contains("com.xtify.android.sdk.") || name.contains("MediaPlayerWrapper") || name.contains(".vungle.") || name.contains(".tapjoy.") || name.contains(".nbpcorp.") || name.contains("com.appenda.") || name.contains(".plus1.sdk.") || name.contains(".adsdk.") || name.contains(".mdotm.") || name.contains("AdView") || name.contains("mad.ad.")) {
            return true;
        }
        return false;
    }

    public static void convertToPatchItemAuto(ArrayList<PatchesItemAuto> patchesList, ArrayList<String> origStr, ArrayList<String> replStr, ArrayList<Boolean> trigger, ArrayList<String> ResultText, ArrayList<String> markers, ArrayList<Boolean> dontConvert, Boolean convert) {
        for (int i = 0; i < origStr.size(); i++) {
            String value1 = (String) origStr.get(i);
            String value2 = (String) replStr.get(i);
            if (!((Boolean) dontConvert.get(i)).booleanValue() && convert.booleanValue()) {
                value1 = rework((String) origStr.get(i));
                value2 = rework((String) replStr.get(i));
            }
            Boolean trig = (Boolean) trigger.get(i);
            String restxt = (String) ResultText.get(i);
            new String[1][0] = "";
            boolean error = false;
            value1 = value1.trim();
            String[] orhex = new String[value1.split("[ \t]+").length];
            orhex = value1.split("[ \t]+");
            int[] maskB = new int[orhex.length];
            byte[] byteOrigB = new byte[orhex.length];
            int t = 0;
            while (t < orhex.length) {
                try {
                    if (orhex[t].matches("\\?+")) {
                        orhex[t] = "60";
                        maskB[t] = 1;
                    } else {
                        maskB[t] = 0;
                    }
                    if (!orhex[t].toUpperCase().contains("R")) {
                        byteOrigB[t] = Integer.valueOf(orhex[t], 16).byteValue();
                    }
                    if (orhex[t].toUpperCase().contains("R")) {
                        byteOrigB[t] = Integer.valueOf(orhex[t].toUpperCase().replace("R", ""), 16).byteValue();
                        maskB[t] = 23;
                    }
                    t++;
                } catch (Exception e) {
                    System.out.println(" " + e);
                }
            }
            value2 = value2.trim();
            String[] rephex = new String[value2.split("[ \t]+").length];
            rephex = value2.split("[ \t]+");
            int[] rep_maskB = new int[rephex.length];
            byte[] byteReplaceB = new byte[rephex.length];
            t = 0;
            while (t < rephex.length) {
                try {
                    if (rephex[t].matches("\\?+")) {
                        rephex[t] = "60";
                        rep_maskB[t] = 0;
                    } else {
                        rep_maskB[t] = 1;
                    }
                    if (rephex[t].toUpperCase().contains("S1")) {
                        rephex[t] = "60";
                        rep_maskB[t] = 21;
                    }
                    if (rephex[t].toUpperCase().contains("S0")) {
                        rephex[t] = "60";
                        rep_maskB[t] = 20;
                    }
                    if (!rephex[t].toUpperCase().contains("W")) {
                        byteReplaceB[t] = Integer.valueOf(rephex[t], 16).byteValue();
                    }
                    if (rephex[t].toUpperCase().contains("W")) {
                        byteReplaceB[t] = Integer.valueOf(rephex[t].toUpperCase().replace("W", ""), 16).byteValue();
                        rep_maskB[t] = 23;
                    }
                    t++;
                } catch (Exception e2) {
                    System.out.println(" " + e2);
                }
            }
            if (rep_maskB.length != maskB.length || byteOrigB.length != byteReplaceB.length || byteReplaceB.length < 4 || byteOrigB.length < 4) {
                error = true;
            }
            if (error) {
                System.out.println("Error: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!");
            }
            if (!error) {
                patchesList.add(new PatchesItemAuto(byteOrigB, maskB, byteReplaceB, rep_maskB, trig.booleanValue(), restxt, (String) markers.get(i)));
            }
        }
    }

    public static void convertStringToArraysPatch(String original, String replace, byte[] origbytes, byte[] origmask, byte[] replbytes, byte[] replmask) {
        new String[1][0] = "";
        boolean error = false;
        original = original.trim();
        String[] orhex = new String[original.split("[ \t]+").length];
        orhex = original.split("[ \t]+");
        int t = 0;
        while (t < orhex.length) {
            try {
                if (orhex[t].matches("\\?+")) {
                    orhex[t] = "60";
                    origmask[t] = (byte) 1;
                } else {
                    origmask[t] = (byte) 0;
                }
                if (!orhex[t].toUpperCase().contains("R")) {
                    origbytes[t] = Integer.valueOf(orhex[t], 16).byteValue();
                }
                if (orhex[t].toUpperCase().contains("R")) {
                    origbytes[t] = Integer.valueOf(orhex[t].toUpperCase().replace("R", ""), 16).byteValue();
                    origmask[t] = (byte) 23;
                }
                t++;
            } catch (Exception e) {
                System.out.println(" " + e);
            }
        }
        replace = replace.trim();
        String[] rephex = new String[replace.split("[ \t]+").length];
        rephex = replace.split("[ \t]+");
        t = 0;
        while (t < rephex.length) {
            try {
                if (rephex[t].matches("\\?+")) {
                    rephex[t] = "60";
                    replmask[t] = (byte) 0;
                } else {
                    replmask[t] = (byte) 1;
                }
                if (rephex[t].toUpperCase().contains("S1")) {
                    rephex[t] = "60";
                    replmask[t] = (byte) 21;
                }
                if (rephex[t].toUpperCase().contains("S0")) {
                    rephex[t] = "60";
                    replmask[t] = (byte) 20;
                }
                if (!rephex[t].toUpperCase().contains("W")) {
                    replbytes[t] = Integer.valueOf(rephex[t], 16).byteValue();
                }
                if (rephex[t].toUpperCase().contains("W")) {
                    replbytes[t] = Integer.valueOf(rephex[t].toUpperCase().replace("W", ""), 16).byteValue();
                    replmask[t] = (byte) 23;
                }
                t++;
            } catch (Exception e2) {
                System.out.println(" " + e2);
            }
        }
        if (replmask.length != origmask.length || origbytes.length != replbytes.length || replbytes.length < 4 || origbytes.length < 4) {
            error = true;
        }
        if (error) {
            System.out.println("Error: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!");
        }
    }

    public static String rework(String str) {
        if (str.contains("52")) {
            str = str.replaceAll("52", "f2");
        }
        if (str.contains("53")) {
            str = str.replaceAll("53", "f3");
        }
        if (str.contains("54")) {
            str = str.replaceAll("54", "f4");
        }
        if (str.contains("55")) {
            str = str.replaceAll("55", "f2");
        }
        if (str.contains("59")) {
            str = str.replaceAll("59", "f5");
        }
        if (str.toUpperCase().contains("5A")) {
            str = str.toUpperCase().replaceAll("5A", "F6");
        }
        if (str.toUpperCase().contains("5B")) {
            str = str.toUpperCase().replaceAll("5B", "F7");
        }
        if (str.toUpperCase().contains("5C")) {
            str = str.toUpperCase().replaceAll("5C", "F5");
        }
        if (str.toUpperCase().contains("5D")) {
            str = str.toUpperCase().replaceAll("5D", "F5");
        }
        if (str.contains("74")) {
            str = str.replaceAll("74", "f9");
        }
        if (str.toUpperCase().contains("6E")) {
            return str.toUpperCase().replaceAll("6E", "F8");
        }
        return str;
    }

    public static boolean isServiceRunning(String serviceClassName) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) listAppsFragment.getInstance().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo.service.getClassName().equals(serviceClassName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean killAll(String processName) {
        String result;
        String[] proc_lines;
        ArrayList<String> pids;
        String pid;
        Iterator it;
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            result = cmdParam(listAppsFragment.toolfilesdir + "/busybox", "ps", "grep", processName);
            if (result.startsWith("~")) {
                if (result.startsWith("~")) {
                    result = cmdParam(listAppsFragment.toolfilesdir + "/busybox", "ps");
                }
                if (result.startsWith("~")) {
                    result = cmdParam("busybox", "ps");
                }
                if (result.startsWith("~")) {
                    result = cmdParam("toolbox", "ps");
                }
            }
            if (!(result.equals("~") || result.equals(""))) {
                proc_lines = result.split("\n");
                pids = new ArrayList();
                if (proc_lines.length > 1) {
                    for (String line : proc_lines) {
                        if (line.contains(processName) && !line.contains(new StringBuilder(String.valueOf(processName)).append(".").toString())) {
                            try {
                                pid = new StringBuilder(String.valueOf(line)).append("\n").toString().trim().split("\\s+")[0];
                                pids.add(pid);
                                System.out.println("Found pid: " + pid + " for " + processName);
                            } catch (Exception e) {
                                System.out.println("Error with regex! " + e);
                            }
                        }
                    }
                    if (pids.size() > 0) {
                        it = pids.iterator();
                        while (it.hasNext()) {
                            pid = (String) it.next();
                            System.out.println("Kill: " + pid + " for " + processName);
                            if (!pid.equals("0")) {
                                cmdParam("kill", "-9", pid);
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        result = new Utils("").cmdRoot(listAppsFragment.toolfilesdir + "/busybox ps |grep '" + processName + "'");
        if (result.startsWith("~")) {
            exitRoot();
            try {
                listAppsFragment.getSu();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            result = new Utils("").cmdRoot(listAppsFragment.toolfilesdir + "/busybox ps");
            if (result.startsWith("~")) {
                result = new Utils("").cmdRoot("busybox ps");
            }
            if (result.startsWith("~")) {
                result = new Utils("").cmdRoot("ps");
            }
        }
        if (!(result.equals("~") || result.equals(""))) {
            proc_lines = result.split("\n");
            pids = new ArrayList();
            if (proc_lines.length > 1) {
                for (String line2 : proc_lines) {
                    if (line2.contains(processName) && !line2.contains(new StringBuilder(String.valueOf(processName)).append(".").toString())) {
                        try {
                            pid = new StringBuilder(String.valueOf(line2)).append("\n").toString().trim().split("\\s+")[0];
                            pids.add(pid);
                            System.out.println("Found pid: " + pid + " for " + processName);
                        } catch (Exception e3) {
                            System.out.println("Error with regex! " + e3);
                        }
                    }
                }
                if (pids.size() > 0) {
                    it = pids.iterator();
                    while (it.hasNext()) {
                        pid = (String) it.next();
                        System.out.println("Kill: " + pid + " for " + processName);
                        if (!pid.equals("0")) {
                            new Utils("").cmdRoot("kill -9 " + pid);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static void showSystemWindow(String title, String message, OnClickListener YesOnClickListener, OnClickListener NoOnClickListener) {
        WindowManager manager = (WindowManager) listAppsFragment.getInstance().getSystemService("window");
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 17;
        layoutParams.type = 2003;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.alpha = 1.0f;
        layoutParams.packageName = listAppsFragment.getInstance().getPackageName();
        layoutParams.buttonBrightness = 1.0f;
        layoutParams.windowAnimations = 16973826;
        View view = View.inflate(listAppsFragment.getInstance(), 2130968631, null);
        Button yesButton = (Button) view.findViewById(2131558443);
        Button noButton = (Button) view.findViewById(2131558441);
        TextView messageView = (TextView) view.findViewById(2131558604);
        ((TextView) view.findViewById(2131558478)).setText(title);
        messageView.setText(message);
        yesButton.setOnClickListener(YesOnClickListener);
        noButton.setOnClickListener(NoOnClickListener);
        yesButton.setOnKeyListener(new AnonymousClass11(manager));
        manager.addView(view, layoutParams);
    }

    public static void showSystemWindowOk(String title, String message) {
        WindowManager manager = (WindowManager) listAppsFragment.getInstance().getSystemService("window");
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 17;
        layoutParams.type = 2003;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.alpha = 1.0f;
        layoutParams.packageName = listAppsFragment.getInstance().getPackageName();
        layoutParams.buttonBrightness = 1.0f;
        layoutParams.windowAnimations = 2131427330;
        View view = View.inflate(listAppsFragment.getInstance(), 2130968632, null);
        Button okButton = (Button) view.findViewById(2131558605);
        TextView messageView = (TextView) view.findViewById(2131558604);
        ((TextView) view.findViewById(2131558478)).setText(title);
        messageView.setText(message);
        okButton.setOnClickListener(new AnonymousClass12(manager));
        okButton.setOnKeyListener(new AnonymousClass13(manager));
        manager.addView(view, layoutParams);
    }

    public static boolean copyFile(String source, String destination, boolean remountAsRw, boolean preserveFileAttributes) {
        boolean result = true;
        String filePermission;
        String permissions;
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            File sourceF = new File(source);
            File destinationF = new File(destination);
            if (remountAsRw) {
                remount(destination, "RW");
            }
            filePermission = "";
            if (preserveFileAttributes) {
                permissions = getPermissions(source);
                if (permissions != null) {
                    try {
                        if (!permissions.equals("")) {
                            filePermission = permissions;
                        }
                    } catch (Exception e) {
                        filePermission = "777";
                    }
                }
                filePermission = "777";
            }
            cmdParam("dd", "if=" + source, "of=" + destination);
            if (!(new File(destination).exists() && sourceF.length() == destinationF.length())) {
                cmdParam("toolbox", "dd", "if=" + source, "of=" + destination);
            }
            if (!(new File(destination).exists() && sourceF.length() == destinationF.length())) {
                cmdParam("busybox", "dd", "if=" + source, "of=" + destination);
            }
            if (!(new File(destination).exists() && sourceF.length() == destinationF.length())) {
                cmdParam(listAppsFragment.toolfilesdir + "/busybox", "dd", "if=" + source, "of=" + destination);
            }
            if (!(new File(destination).exists() && sourceF.length() == destinationF.length())) {
                copyFile(sourceF, destinationF);
            }
            if (sourceF.length() == destinationF.length()) {
                if (preserveFileAttributes) {
                    run_all_no_root("chmod", filePermission, destination);
                }
                return true;
            }
            destinationF.delete();
            System.out.println("LuckyPatcher (cmdCopy): error copy... not enougth space to destination.");
            return false;
        }
        try {
            if (exists(source)) {
                if (remountAsRw) {
                    remount(destination, "RW");
                }
                filePermission = "";
                if (preserveFileAttributes) {
                    permissions = getPermissions(source);
                    if (permissions != null) {
                        try {
                            if (!permissions.equals("")) {
                                filePermission = permissions;
                            }
                        } catch (Exception e2) {
                            filePermission = "777";
                        }
                    }
                    filePermission = "777";
                }
                exitRoot();
                new Utils("").cmdRoot("dd if=" + source + " of=" + destination);
                if (!exists(destination)) {
                    new Utils("").cmdRoot("toolbox dd if=" + source + " of=" + destination);
                }
                if (!exists(destination)) {
                    new Utils("").cmdRoot("busybox dd if=" + source + " of=" + destination);
                }
                if (!exists(destination)) {
                    new Utils("").cmdRoot(listAppsFragment.toolfilesdir + "/busybox dd if=" + source + " of=" + destination);
                }
                if (!exists(destination)) {
                    new Utils("").cmdRoot(listAppsFragment.toolfilesdir + "/busybox cp -fp " + source + " " + destination);
                }
                if (preserveFileAttributes) {
                    run_all("chmod " + filePermission + " " + destination);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            result = false;
        }
        return result;
    }

    public static void getFilesWithPkgName(String pkgName, File sys_folder, ArrayList<File> result) {
        remount("/system", InternalZipConstants.WRITE_MODE);
        File[] files = sys_folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("LuckyPatcher: 0 packages found in " + sys_folder.getAbsolutePath());
            return;
        }
        for (File apkfile : files) {
            if (apkfile.getAbsolutePath().endsWith(".apk")) {
                try {
                    if (pkgName.equals(new FileApkListItem(listAppsFragment.getInstance(), apkfile, false).pkgName)) {
                        result.add(apkfile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (File dir : files) {
            if (dir.isDirectory()) {
                try {
                    File[] filesDir = dir.listFiles();
                    if (!(filesDir == null || filesDir.length == 0)) {
                        for (File file : filesDir) {
                            if (file.getAbsolutePath().endsWith(".apk")) {
                                try {
                                    if (pkgName.equals(new FileApkListItem(listAppsFragment.getInstance(), file, false).pkgName)) {
                                        result.add(file);
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
        }
    }

    public static void removePkgFromSystem(String pkgName) {
        remount("/system", InternalZipConstants.WRITE_MODE);
        ArrayList<File> foldersSysApps = new ArrayList();
        foldersSysApps.add(new File("/system/app"));
        foldersSysApps.add(new File("/system/priv-app"));
        Iterator it = foldersSysApps.iterator();
        while (it.hasNext()) {
            File sys_folder = (File) it.next();
            File[] files = sys_folder.listFiles();
            if (files == null || files.length == 0) {
                System.out.println("LuckyPatcher: 0 packages found in " + sys_folder.getAbsolutePath());
            } else {
                int i;
                for (File apkfile : files) {
                    if (apkfile.getAbsolutePath().endsWith(".apk")) {
                        try {
                            if (pkgName.equals(new FileApkListItem(listAppsFragment.getInstance(), apkfile, false).pkgName)) {
                                run_all("chmod 777 '" + apkfile.getAbsolutePath() + "'");
                                run_all("rm '" + apkfile.getAbsolutePath() + "'");
                                run_all("rm '" + getPlaceForOdex(apkfile.getAbsolutePath(), false) + "'");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                for (File dir : files) {
                    if (dir.isDirectory()) {
                        File[] filesDir = dir.listFiles();
                        if (!(filesDir == null || filesDir.length == 0)) {
                            int length = filesDir.length;
                            i = 0;
                            while (i < length) {
                                try {
                                    File file = filesDir[i];
                                    if (file.getAbsolutePath().endsWith(".apk")) {
                                        try {
                                            if (pkgName.equals(new FileApkListItem(listAppsFragment.getInstance(), file, false).pkgName)) {
                                                run_all("chmod 777 '" + file.getAbsolutePath() + "'");
                                                run_all("rm '" + file.getAbsolutePath() + "'");
                                                run_all("rm '" + getPlaceForOdex(file.getAbsolutePath(), false) + "'");
                                                run_all("rm -rf '" + dir.getAbsolutePath() + "'");
                                            }
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    i++;
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static String getText(int string_id) {
        if (listAppsFragment.resources == null) {
            listAppsFragment.resources = listAppsFragment.getRes();
        }
        return listAppsFragment.resources.getString(string_id);
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[(bytes.length * 2)];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 255;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[(j * 2) + 1] = hexArray[v & 15];
        }
        return new String(hexChars);
    }

    public static String getCurrentRuntimeValue() {
        try {
            if (listAppsFragment.runtime.contains("ART")) {
                return "ART";
            }
            if (listAppsFragment.runtime.contains("DALVIK")) {
                return "Dalvik";
            }
            return "ART";
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Class<?> systemProperties = Class.forName("android.os.SystemProperties");
                try {
                    Method get = systemProperties.getMethod("get", new Class[]{String.class, String.class});
                    if (get == null) {
                        return "WTF?!";
                    }
                    try {
                        String value = (String) get.invoke(systemProperties, new Object[]{SELECT_RUNTIME_PROPERTY, "Dalvik"});
                        System.out.println(value);
                        if (LIB_DALVIK.equals(value)) {
                            return "Dalvik";
                        }
                        if (LIB_ART.equals(value)) {
                            return "ART";
                        }
                        if (LIB_ART_D.equals(value)) {
                            return "ART debug build";
                        }
                        return value;
                    } catch (IllegalAccessException e2) {
                        return "IllegalAccessException";
                    } catch (IllegalArgumentException e3) {
                        return "IllegalArgumentException";
                    } catch (InvocationTargetException e4) {
                        return "InvocationTargetException";
                    }
                } catch (NoSuchMethodException e5) {
                    return "SystemProperties.get(String key, String def) method is not found";
                }
            } catch (ClassNotFoundException e6) {
                e6.printStackTrace();
                return "Dalvik";
            } catch (Exception e7) {
                e7.printStackTrace();
                return "Dalvik";
            }
        }
    }

    public static boolean checkCoreJarPatch11() {
        try {
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger("12345678", 16), new BigInteger("11", 16))));
            sig.update("367".getBytes());
            if (sig.verify("123098".getBytes())) {
                return true;
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            return false;
        } catch (InvalidKeyException e2) {
            return false;
        } catch (SignatureException e3) {
            return false;
        } catch (InvalidKeySpecException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean checkCoreJarPatch12() {
        try {
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger("12345678", 16), new BigInteger("11", 16))));
            sig.update("367".getBytes());
            if (sig.verify("123098".getBytes(), 1, 5)) {
                return true;
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            return false;
        } catch (InvalidKeyException e2) {
            return false;
        } catch (SignatureException e3) {
            return false;
        } catch (InvalidKeySpecException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean checkCoreJarPatch20() {
        return MessageDigest.isEqual("12".getBytes(), "45".getBytes());
    }

    public static boolean checkCoreJarPatch30(PackageManager pkg) {
        String platform = "";
        try {
            platform = Base64.encode(listAppsFragment.getPkgMng().getPackageInfo(Common.ANDROID_PKG, 64).signatures[0].toByteArray()).replaceAll("\n", "");
        } catch (Exception e) {
            platform = "chelpa";
        }
        String lp = "";
        try {
            lp = Base64.encode(listAppsFragment.getPkgMng().getPackageInfo(listAppsFragment.class.getPackage().getName(), 64).signatures[0].toByteArray());
            lp = platform.replaceAll("\n", "");
        } catch (Exception e2) {
            lp = "chelpa";
        }
        String[] pkgs = listAppsFragment.getPackages();
        if (pkgs != null && pkgs.length > 0) {
            for (String pkgName : pkgs) {
                if (!(pkgName.equals(Common.ANDROID_PKG) || pkgName.equals(listAppsFragment.class.getPackage().getName()))) {
                    try {
                        android.content.pm.Signature[] sigs = listAppsFragment.getPkgMng().getPackageInfo(pkgName, 64).signatures;
                        if (sigs != null && sigs.length == 1) {
                            int length = sigs.length;
                            int i = 0;
                            while (i < length) {
                                String char1 = Base64.encode(sigs[i].toByteArray()).replaceAll("\n", "");
                                if (char1.equals(platform) || char1.equals(lp)) {
                                    i++;
                                } else if (pkg.checkSignatures(pkgName, listAppsFragment.getInstance().getPackageName()) == 0) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                            continue;
                        }
                    } catch (NameNotFoundException e3) {
                        e3.printStackTrace();
                        System.out.println("dont get Android signature");
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkCoreJarPatch40() {
        mServiceConn = new ServiceConnection() {
            public void onServiceDisconnected(ComponentName name) {
                System.out.println("Licensing service disconnected.");
                Utils.mService = null;
            }

            public void onServiceConnected(ComponentName name, IBinder service) {
                boolean res = false;
                Utils.mService = Stub.asInterface(service);
                try {
                    res = Utils.mService.checkService();
                    System.out.println("TestService:" + res);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                System.out.println("TestService:" + res);
            }
        };
        if (mService != null) {
            return false;
        }
        try {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.LOCK.ITestServiceInterface.BIND");
            intent.setPackage(Common.GOOGLEPLAY_PKG);
            if (listAppsFragment.getPkgMng().queryIntentServices(intent, 0).isEmpty()) {
                return false;
            }
            for (ResolveInfo se : listAppsFragment.getPkgMng().queryIntentServices(intent, 0)) {
                if (se.serviceInfo.packageName != null && se.serviceInfo.packageName.equals(listAppsFragment.getInstance().getPackageName())) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static long javaToDosTime(long time) {
        Date d = new Date(time);
        int year = d.getYear() + 1900;
        if (year < 1980) {
            return 2162688;
        }
        return (long) (((((((year - 1980) << 25) | ((d.getMonth() + 1) << 21)) | (d.getDate() << 16)) | (d.getHours() << 11)) | (d.getMinutes() << 5)) | (d.getSeconds() >> 1));
    }

    public static boolean dalvikvm_copyFile(String toolfilesdir, String source, String destination) {
        File sourceF = new File(source);
        File destinationF = new File(destination);
        if (sourceF.exists()) {
            remount(destination, "RW");
            cmdParam("dd", "if=" + source, "of=" + destination);
            if (!(new File(destination).exists() && sourceF.length() == destinationF.length())) {
                cmdParam("busybox", "dd", "if=" + source, "of=" + destination);
            }
            if (!(new File(destination).exists() && sourceF.length() == destinationF.length())) {
                cmdParam(listAppsFragment.toolfilesdir + "/busybox", "dd", "if=" + source, "of=" + destination);
            }
            if (sourceF.length() == destinationF.length() || sourceF.length() == 0) {
                System.out.println(destinationF.length());
                System.out.println("File copied!");
                return true;
            }
            destinationF.delete();
            System.out.println("Length of Files not equals. Destination deleted!");
            return false;
        }
        System.out.println("Source File not Found!");
        return false;
    }

    public static int dexopt(String apk_file, String workingDir, String odexFile, String uid, Boolean art) {
        int result = 0;
        System.out.println(workingDir);
        new File(workingDir).mkdirs();
        run_all_no_root("chmod", "777", apk_file);
        run_all_no_root("chmod", "777", getDirs(new File(workingDir)).getAbsolutePath());
        run_all_no_root("chown", "0:0", getDirs(new File(workingDir)).getAbsolutePath());
        run_all_no_root("chown", "0.0", getDirs(new File(workingDir)).getAbsolutePath());
        run_all_no_root("chmod", "777", workingDir);
        run_all_no_root("chown", "0:0", workingDir);
        run_all_no_root("chown", "0.0", workingDir);
        if (odexFile == null) {
            odexFile = getOdexForCreate(apk_file, uid);
        }
        if (odexFile != null) {
            remount(odexFile, InternalZipConstants.WRITE_MODE);
        }
        boolean free_space = false;
        String apkOdex = getOdexForCreate(apk_file, uid);
        String apkname = new File(apk_file).getName();
        String odexName = changeExtension(apkname, "odex");
        String oatFile = new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(changeExtension(apkname, "dex")).toString();
        try {
            File dalvik_art = getFileDalvikCacheName(apk_file);
            String dalvik_name = dalvik_art.getName();
            System.out.println("dex-opt-art");
            if (new File(oatFile).exists()) {
                new File(oatFile).delete();
            }
            try {
                File checkdex;
                File[] files;
                if (art.booleanValue()) {
                    String instructions = "";
                    if (dalvik_art.getAbsolutePath().contains("/arm/")) {
                        instructions = "arm";
                    }
                    if (dalvik_art.getAbsolutePath().contains("/arm64/")) {
                        instructions = "arm64";
                    }
                    if (dalvik_art.getAbsolutePath().contains("/x86/")) {
                        instructions = "x86";
                    }
                    if (dalvik_art.getAbsolutePath().contains("/x86_64/")) {
                        instructions = "x86_64";
                    }
                    System.out.println("try create oat with dex2oat:");
                    System.out.println(cmdParam("dex2oat", "--dex-file=" + apk_file, "--oat-file=" + oatFile, "--instruction-set=" + instructions));
                    System.out.println("end");
                    if (!new File(oatFile).exists() || new File(oatFile).length() == 0) {
                        new File(oatFile).delete();
                        if (new File(oatFile).exists()) {
                            run_all_no_root("rm", oatFile);
                        }
                        checkdex = new File(oatFile);
                        System.out.println(oatFile);
                        System.out.println(odexFile);
                        if (checkdex.exists() && checkdex.length() == 0) {
                            checkdex.delete();
                        }
                        if (checkdex.exists()) {
                            System.out.println("oat file found. try copy and permission apply.");
                            new File(apkOdex).delete();
                            if (new File(apkOdex).exists()) {
                                run_all_no_root("rm", apkOdex);
                            }
                            if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, checkdex.getAbsolutePath(), odexFile)) {
                                free_space = false;
                                System.out.println("Error:Free space for odex not enougth.");
                                if (checkdex.exists()) {
                                    checkdex.delete();
                                }
                                if (checkdex.exists()) {
                                    run_all_no_root("rm", checkdex.getAbsolutePath());
                                }
                                new File(apkOdex).delete();
                                if (new File(apkOdex).exists()) {
                                    run_all_no_root("rm", apkOdex);
                                }
                                if (new File(getOdexForCreate(apk_file, uid)).exists()) {
                                    System.out.println("Error:dont delete corrupt odex.");
                                }
                            } else {
                                System.out.println("Free space for odex enougth.");
                                free_space = true;
                            }
                            if (apk_file.startsWith("/system")) {
                                run_all_no_root("chmod", "0644", odexFile);
                                run_all_no_root("chown", "1000." + uid, odexFile);
                                run_all_no_root("chown", "1000:" + uid, odexFile);
                            } else {
                                run_all_no_root("chmod", "0644", odexFile);
                                run_all_no_root("chown", "0.0", odexFile);
                                run_all_no_root("chown", "0:0", odexFile);
                            }
                        }
                        if (new File(oatFile).exists()) {
                            new File(oatFile).delete();
                        }
                        files = new File(workingDir).listFiles();
                        if (files != null && files.length > 0) {
                            for (File file : files) {
                                file.delete();
                            }
                        }
                        if (new File(workingDir).exists()) {
                            new File(workingDir).delete();
                        }
                        run_all_no_root("chmod", "644", apk_file);
                        if (free_space) {
                            return 1;
                        }
                        return result;
                    }
                    System.out.println("odex file create to tmp dir.");
                    checkdex = new File(oatFile);
                    System.out.println(oatFile);
                    System.out.println(odexFile);
                    checkdex.delete();
                    if (checkdex.exists()) {
                        System.out.println("oat file found. try copy and permission apply.");
                        new File(apkOdex).delete();
                        if (new File(apkOdex).exists()) {
                            run_all_no_root("rm", apkOdex);
                        }
                        if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, checkdex.getAbsolutePath(), odexFile)) {
                            free_space = false;
                            System.out.println("Error:Free space for odex not enougth.");
                            if (checkdex.exists()) {
                                checkdex.delete();
                            }
                            if (checkdex.exists()) {
                                run_all_no_root("rm", checkdex.getAbsolutePath());
                            }
                            new File(apkOdex).delete();
                            if (new File(apkOdex).exists()) {
                                run_all_no_root("rm", apkOdex);
                            }
                            if (new File(getOdexForCreate(apk_file, uid)).exists()) {
                                System.out.println("Error:dont delete corrupt odex.");
                            }
                        } else {
                            System.out.println("Free space for odex enougth.");
                            free_space = true;
                        }
                        if (apk_file.startsWith("/system")) {
                            run_all_no_root("chmod", "0644", odexFile);
                            run_all_no_root("chown", "1000." + uid, odexFile);
                            run_all_no_root("chown", "1000:" + uid, odexFile);
                        } else {
                            run_all_no_root("chmod", "0644", odexFile);
                            run_all_no_root("chown", "0.0", odexFile);
                            run_all_no_root("chown", "0:0", odexFile);
                        }
                    }
                    if (new File(oatFile).exists()) {
                        new File(oatFile).delete();
                    }
                    files = new File(workingDir).listFiles();
                    while (r18 < r19) {
                        file.delete();
                    }
                    if (new File(workingDir).exists()) {
                        new File(workingDir).delete();
                    }
                    run_all_no_root("chmod", "644", apk_file);
                    if (free_space) {
                        return result;
                    }
                    return 1;
                }
                System.out.println("try create oat with DexFile.");
                try {
                    new File(oatFile).delete();
                    DexFile.loadDex(apk_file, oatFile, 0).close();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (UnsatisfiedLinkError e2) {
                    System.out.println("withoutFramework");
                }
                System.out.println("end. check file. ");
                if (new File(oatFile).exists()) {
                    System.out.println("found file " + oatFile + " " + new File(oatFile).length());
                }
                if (new File(odexFile).exists()) {
                    System.out.println("found file " + odexFile + " " + new File(odexFile).length());
                }
                if (!new File(oatFile).exists() || new File(oatFile).length() == 0) {
                    new File(oatFile).delete();
                    if (new File(oatFile).exists()) {
                        run_all_no_root("rm", oatFile);
                    }
                    if (!new File(oatFile).exists() || new File(oatFile).length() == 0) {
                        new File(oatFile).delete();
                        if (new File(oatFile).exists()) {
                            run_all_no_root("rm", oatFile);
                        }
                    }
                    checkdex = new File(oatFile);
                    System.out.println(oatFile);
                    System.out.println(odexFile);
                    checkdex.delete();
                    if (checkdex.exists()) {
                        System.out.println("oat file found. try copy and permission apply.");
                        new File(apkOdex).delete();
                        if (new File(apkOdex).exists()) {
                            run_all_no_root("rm", apkOdex);
                        }
                        if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, checkdex.getAbsolutePath(), odexFile)) {
                            System.out.println("Free space for odex enougth.");
                            free_space = true;
                        } else {
                            free_space = false;
                            System.out.println("Error:Free space for odex not enougth.");
                            if (checkdex.exists()) {
                                checkdex.delete();
                            }
                            if (checkdex.exists()) {
                                run_all_no_root("rm", checkdex.getAbsolutePath());
                            }
                            new File(apkOdex).delete();
                            if (new File(apkOdex).exists()) {
                                run_all_no_root("rm", apkOdex);
                            }
                            if (new File(getOdexForCreate(apk_file, uid)).exists()) {
                                System.out.println("Error:dont delete corrupt odex.");
                            }
                        }
                        if (apk_file.startsWith("/system")) {
                            run_all_no_root("chmod", "0644", odexFile);
                            run_all_no_root("chown", "0.0", odexFile);
                            run_all_no_root("chown", "0:0", odexFile);
                        } else {
                            run_all_no_root("chmod", "0644", odexFile);
                            run_all_no_root("chown", "1000." + uid, odexFile);
                            run_all_no_root("chown", "1000:" + uid, odexFile);
                        }
                    }
                    if (new File(oatFile).exists()) {
                        new File(oatFile).delete();
                    }
                    files = new File(workingDir).listFiles();
                    while (r18 < r19) {
                        file.delete();
                    }
                    if (new File(workingDir).exists()) {
                        new File(workingDir).delete();
                    }
                    run_all_no_root("chmod", "644", apk_file);
                    if (free_space) {
                        return 1;
                    }
                    return result;
                }
                System.out.println("odex file create to tmp dir.");
                checkdex = new File(oatFile);
                System.out.println(oatFile);
                System.out.println(odexFile);
                checkdex.delete();
                if (checkdex.exists()) {
                    System.out.println("oat file found. try copy and permission apply.");
                    new File(apkOdex).delete();
                    if (new File(apkOdex).exists()) {
                        run_all_no_root("rm", apkOdex);
                    }
                    if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, checkdex.getAbsolutePath(), odexFile)) {
                        free_space = false;
                        System.out.println("Error:Free space for odex not enougth.");
                        if (checkdex.exists()) {
                            checkdex.delete();
                        }
                        if (checkdex.exists()) {
                            run_all_no_root("rm", checkdex.getAbsolutePath());
                        }
                        new File(apkOdex).delete();
                        if (new File(apkOdex).exists()) {
                            run_all_no_root("rm", apkOdex);
                        }
                        if (new File(getOdexForCreate(apk_file, uid)).exists()) {
                            System.out.println("Error:dont delete corrupt odex.");
                        }
                    } else {
                        System.out.println("Free space for odex enougth.");
                        free_space = true;
                    }
                    if (apk_file.startsWith("/system")) {
                        run_all_no_root("chmod", "0644", odexFile);
                        run_all_no_root("chown", "1000." + uid, odexFile);
                        run_all_no_root("chown", "1000:" + uid, odexFile);
                    } else {
                        run_all_no_root("chmod", "0644", odexFile);
                        run_all_no_root("chown", "0.0", odexFile);
                        run_all_no_root("chown", "0:0", odexFile);
                    }
                }
                if (new File(oatFile).exists()) {
                    new File(oatFile).delete();
                }
                files = new File(workingDir).listFiles();
                while (r18 < r19) {
                    file.delete();
                }
                if (new File(workingDir).exists()) {
                    new File(workingDir).delete();
                }
                run_all_no_root("chmod", "644", apk_file);
                if (free_space) {
                    return result;
                }
                return 1;
            } catch (Exception e3) {
                e3.printStackTrace();
                result = 4;
            }
        } catch (Exception e32) {
            e32.printStackTrace();
            result = 4;
        }
    }

    public static int create_ODEX_root(String workingDir, ArrayList<File> classesFiles, String apk_file, String uid, String odexFile) {
        run_all_no_root("chmod", "777", workingDir);
        run_all_no_root("chown", "0:0", workingDir);
        run_all_no_root("chown", "0.0", workingDir);
        if (odexFile == null) {
            odexFile = getOdexForCreate(apk_file, uid);
        }
        boolean free_space = false;
        boolean free_space_int = true;
        boolean genARTerror = false;
        String apk_name = new File(apk_file).getName();
        String apkOdex = getOdexForCreate(apk_file, uid);
        File dalvikFile = getFileDalvikCacheName(apk_file);
        String apkname = new File(apk_file).getName();
        String odexName = changeExtension(apkname, "odex");
        String dexName = changeExtension(apkname, "dex");
        String oatFile = new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(odexName).toString();
        DexFile dex = null;
        boolean ART = false;
        if (getCurrentRuntimeValue().contains("ART")) {
            ART = true;
        } else {
            ART = false;
        }
        Iterator it = classesFiles.iterator();
        while (it.hasNext()) {
            try {
                run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(((File) it.next()).getName()).toString());
                if (((File) it.next()).exists()) {
                    run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(cl.getName()).toString());
                    run_all_no_root("chown", "1000." + uid, new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(cl.getName()).toString());
                } else {
                    if (dex != null) {
                        try {
                            dex.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return 4;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(workingDir)).append("/AndroidManifest.xml").toString());
        run_all_no_root("chown", "1000." + uid, new StringBuilder(String.valueOf(workingDir)).append("/AndroidManifest.xml").toString());
        new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).delete();
        if (new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).exists()) {
            run_all_no_root("rm", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString());
        }
        File dalvik_art = getFileDalvikCacheName(apk_file);
        String dalvik_name = dalvik_art.getName();
        String rebuild_apk = "";
        File checkdex;
        if (ART) {
            System.out.println("dex-opt-art");
            rebuild_apk = zipART(apk_name, workingDir, classesFiles, apk_file);
            if (rebuild_apk.equals("") || !new File(rebuild_apk).exists()) {
                System.out.println("Error: dont create rebuild apk to /data/tmp/");
            } else {
                System.out.println("apk found and copy created apk size " + new File(rebuild_apk).length());
            }
            try {
                String instructions = "";
                if (dalvik_art.getAbsolutePath().contains("/arm/")) {
                    instructions = "arm";
                }
                if (dalvik_art.getAbsolutePath().contains("/arm64/")) {
                    instructions = "arm64";
                }
                if (dalvik_art.getAbsolutePath().contains("/x86/")) {
                    instructions = "x86";
                }
                if (dalvik_art.getAbsolutePath().contains("/x86_64/")) {
                    instructions = "x86_64";
                }
                new File(oatFile).delete();
                if (new File(oatFile).exists()) {
                    run_all_no_root("rm", oatFile);
                }
                System.out.println("try create oat with dex2oat:");
                System.out.println(cmdParam("dex2oat", "--dex-file=" + rebuild_apk, "--oat-file=" + oatFile, "--instruction-set=" + instructions));
                System.out.println("end");
                String destinationPatchedOat;
                File[] files;
                Utils utils;
                if (!new File(oatFile).exists() || new File(oatFile).length() == 0) {
                    new File(oatFile).delete();
                    if (new File(oatFile).exists()) {
                        run_all_no_root("rm", oatFile);
                    }
                    checkdex = new File(oatFile);
                    if (checkdex.exists() && checkdex.length() == 0) {
                        checkdex.delete();
                    }
                    if (new File(checkdex.getAbsolutePath()).exists()) {
                        genARTerror = true;
                    } else {
                        System.out.println("oat file found. try copy and permission apply.");
                        destinationPatchedOat = odexFile;
                        if (odexFile.startsWith("/mnt/asec/") && dalvikFile.exists()) {
                            free_space = false;
                            destinationPatchedOat = dalvikFile.getAbsolutePath();
                        }
                        new File(destinationPatchedOat).delete();
                        if (new File(destinationPatchedOat).exists()) {
                            run_all_no_root("rm", destinationPatchedOat);
                        }
                        System.out.println("try copy to:" + destinationPatchedOat);
                        if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, checkdex.getAbsolutePath(), destinationPatchedOat)) {
                            System.out.println("Error:Free space for odex not enougth.");
                            if (checkdex.exists()) {
                                checkdex.delete();
                            }
                            if (checkdex.exists()) {
                                run_all_no_root("rm", checkdex.getAbsolutePath());
                            }
                            new File(apkOdex).delete();
                            if (new File(apkOdex).exists()) {
                                run_all_no_root("rm", apkOdex);
                            }
                            if (new File(getOdexForCreate(apk_file, uid)).exists()) {
                                System.out.println("Error:dont delete corrupt odex.");
                            }
                            odexFile = dalvikFile.getAbsolutePath();
                            if (rebuild_apk.equals("") && new File(rebuild_apk).exists()) {
                                System.out.println("apk found and copy created apk2");
                            } else {
                                System.out.println("Error: dont create rebuild apk to /data/tmp/");
                            }
                            System.out.println("try create oat with DexFile2:");
                            oatFile = new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dalvikFile.getName()).toString();
                            instructions = "";
                            if (dalvik_art.getAbsolutePath().contains("/arm/")) {
                                instructions = "arm";
                            }
                            if (dalvik_art.getAbsolutePath().contains("/arm64/")) {
                                instructions = "arm64";
                            }
                            if (dalvik_art.getAbsolutePath().contains("/x86/")) {
                                instructions = "x86";
                            }
                            if (dalvik_art.getAbsolutePath().contains("/x86_64/")) {
                                instructions = "x86_64";
                            }
                            new File(oatFile).delete();
                            if (new File(oatFile).exists()) {
                                run_all_no_root("rm", oatFile);
                            }
                            System.out.println("try create oat with dex2oat:");
                            System.out.println(cmdParam("dex2oat", "--dex-file=" + rebuild_apk, "--oat-file=" + oatFile, "--instruction-set=" + instructions));
                            System.out.println("end");
                            if (new File(oatFile).exists()) {
                                System.out.println("oat2 created with dex2oat - length=" + new File(oatFile).length());
                                fixCRCart(new File(oatFile), classesFiles, apk_file, rebuild_apk);
                            }
                            checkdex = new File(oatFile);
                            if (checkdex.exists() && checkdex.length() == 0) {
                                checkdex.delete();
                            }
                            if (new File(checkdex.getAbsolutePath()).exists()) {
                                genARTerror = true;
                            } else {
                                System.out.println("oat file found. try copy and permission apply.");
                                if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, oatFile, dalvikFile.getAbsolutePath())) {
                                    new File(apkOdex).delete();
                                    if (new File(apkOdex).exists()) {
                                        run_all_no_root("rm", apkOdex);
                                    }
                                    free_space = false;
                                    free_space_int = false;
                                } else {
                                    odexFile = dalvikFile.getAbsolutePath();
                                    free_space = false;
                                }
                            }
                        } else {
                            System.out.println("Free space for odex enougth.");
                            System.out.println("odex is (" + destinationPatchedOat + ") enougth.");
                            free_space = true;
                            if (odexFile.startsWith("/mnt/asec/") && dalvikFile.exists()) {
                                free_space = false;
                                run_all_no_root("chmod", "0644", destinationPatchedOat);
                                run_all_no_root("chown", "1000." + uid, destinationPatchedOat);
                                run_all_no_root("chown", "1000:" + uid, destinationPatchedOat);
                            }
                            if ((listAppsFragment.api < 23 || dalvikFile.exists()) && !dalvikFile.getAbsolutePath().equals(destinationPatchedOat)) {
                                if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, oatFile, dalvikFile.getAbsolutePath())) {
                                    new File(apkOdex).delete();
                                    if (new File(apkOdex).exists()) {
                                        run_all_no_root("rm", apkOdex);
                                    }
                                    free_space = false;
                                    if (!apkOdex.startsWith("/mnt/asec")) {
                                        free_space_int = false;
                                    }
                                } else {
                                    odexFile = dalvikFile.getAbsolutePath();
                                    if (new File(new StringBuilder(String.valueOf(destinationPatchedOat)).append(".art").toString()).exists()) {
                                        new File(new StringBuilder(String.valueOf(destinationPatchedOat)).append(".art").toString()).delete();
                                    }
                                    free_space = true;
                                    if (apk_file.startsWith("/system")) {
                                        run_all_no_root("chmod", "0644", destinationPatchedOat);
                                        run_all_no_root("chown", "1000." + uid, destinationPatchedOat);
                                        run_all_no_root("chown", "1000:" + uid, destinationPatchedOat);
                                    } else {
                                        run_all_no_root("chmod", "0644", destinationPatchedOat);
                                        run_all_no_root("chown", "0.0", destinationPatchedOat);
                                        run_all_no_root("chown", "0:0", destinationPatchedOat);
                                    }
                                    odexFile = getOdexForCreate(apk_file, uid);
                                }
                            }
                        }
                    }
                    run_all_no_root("chmod", "777", "/data/tmp");
                    try {
                        files = new File("/data/tmp").listFiles();
                        if (files != null) {
                            for (File f : files) {
                                utils = new Utils("1");
                                f.delete();
                                if (f.exists()) {
                                    utils.deleteFolder(f);
                                }
                            }
                        }
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                } else {
                    System.out.println("oat created with dex2oat - length=" + new File(oatFile).length());
                    fixCRCart(new File(oatFile), classesFiles, apk_file, rebuild_apk);
                    checkdex = new File(oatFile);
                    checkdex.delete();
                    if (new File(checkdex.getAbsolutePath()).exists()) {
                        genARTerror = true;
                    } else {
                        System.out.println("oat file found. try copy and permission apply.");
                        destinationPatchedOat = odexFile;
                        free_space = false;
                        destinationPatchedOat = dalvikFile.getAbsolutePath();
                        new File(destinationPatchedOat).delete();
                        if (new File(destinationPatchedOat).exists()) {
                            run_all_no_root("rm", destinationPatchedOat);
                        }
                        System.out.println("try copy to:" + destinationPatchedOat);
                        if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, checkdex.getAbsolutePath(), destinationPatchedOat)) {
                            System.out.println("Error:Free space for odex not enougth.");
                            if (checkdex.exists()) {
                                checkdex.delete();
                            }
                            if (checkdex.exists()) {
                                run_all_no_root("rm", checkdex.getAbsolutePath());
                            }
                            new File(apkOdex).delete();
                            if (new File(apkOdex).exists()) {
                                run_all_no_root("rm", apkOdex);
                            }
                            if (new File(getOdexForCreate(apk_file, uid)).exists()) {
                                System.out.println("Error:dont delete corrupt odex.");
                            }
                            odexFile = dalvikFile.getAbsolutePath();
                            if (rebuild_apk.equals("")) {
                            }
                            System.out.println("Error: dont create rebuild apk to /data/tmp/");
                            System.out.println("try create oat with DexFile2:");
                            oatFile = new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dalvikFile.getName()).toString();
                            instructions = "";
                            if (dalvik_art.getAbsolutePath().contains("/arm/")) {
                                instructions = "arm";
                            }
                            if (dalvik_art.getAbsolutePath().contains("/arm64/")) {
                                instructions = "arm64";
                            }
                            if (dalvik_art.getAbsolutePath().contains("/x86/")) {
                                instructions = "x86";
                            }
                            if (dalvik_art.getAbsolutePath().contains("/x86_64/")) {
                                instructions = "x86_64";
                            }
                            new File(oatFile).delete();
                            if (new File(oatFile).exists()) {
                                run_all_no_root("rm", oatFile);
                            }
                            System.out.println("try create oat with dex2oat:");
                            System.out.println(cmdParam("dex2oat", "--dex-file=" + rebuild_apk, "--oat-file=" + oatFile, "--instruction-set=" + instructions));
                            System.out.println("end");
                            if (new File(oatFile).exists()) {
                                System.out.println("oat2 created with dex2oat - length=" + new File(oatFile).length());
                                fixCRCart(new File(oatFile), classesFiles, apk_file, rebuild_apk);
                            }
                            checkdex = new File(oatFile);
                            checkdex.delete();
                            if (new File(checkdex.getAbsolutePath()).exists()) {
                                genARTerror = true;
                            } else {
                                System.out.println("oat file found. try copy and permission apply.");
                                if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, oatFile, dalvikFile.getAbsolutePath())) {
                                    new File(apkOdex).delete();
                                    if (new File(apkOdex).exists()) {
                                        run_all_no_root("rm", apkOdex);
                                    }
                                    free_space = false;
                                    free_space_int = false;
                                } else {
                                    odexFile = dalvikFile.getAbsolutePath();
                                    free_space = false;
                                }
                            }
                        } else {
                            System.out.println("Free space for odex enougth.");
                            System.out.println("odex is (" + destinationPatchedOat + ") enougth.");
                            free_space = true;
                            free_space = false;
                            run_all_no_root("chmod", "0644", destinationPatchedOat);
                            run_all_no_root("chown", "1000." + uid, destinationPatchedOat);
                            run_all_no_root("chown", "1000:" + uid, destinationPatchedOat);
                            if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, oatFile, dalvikFile.getAbsolutePath())) {
                                new File(apkOdex).delete();
                                if (new File(apkOdex).exists()) {
                                    run_all_no_root("rm", apkOdex);
                                }
                                free_space = false;
                                if (apkOdex.startsWith("/mnt/asec")) {
                                    free_space_int = false;
                                }
                            } else {
                                odexFile = dalvikFile.getAbsolutePath();
                                if (new File(new StringBuilder(String.valueOf(destinationPatchedOat)).append(".art").toString()).exists()) {
                                    new File(new StringBuilder(String.valueOf(destinationPatchedOat)).append(".art").toString()).delete();
                                }
                                free_space = true;
                                if (apk_file.startsWith("/system")) {
                                    run_all_no_root("chmod", "0644", destinationPatchedOat);
                                    run_all_no_root("chown", "1000." + uid, destinationPatchedOat);
                                    run_all_no_root("chown", "1000:" + uid, destinationPatchedOat);
                                } else {
                                    run_all_no_root("chmod", "0644", destinationPatchedOat);
                                    run_all_no_root("chown", "0.0", destinationPatchedOat);
                                    run_all_no_root("chown", "0:0", destinationPatchedOat);
                                }
                                odexFile = getOdexForCreate(apk_file, uid);
                            }
                        }
                    }
                    run_all_no_root("chmod", "777", "/data/tmp");
                    files = new File("/data/tmp").listFiles();
                    if (files != null) {
                        for (File f2 : files) {
                            utils = new Utils("1");
                            f2.delete();
                            if (f2.exists()) {
                                utils.deleteFolder(f2);
                            }
                        }
                    }
                }
            } catch (Exception e222) {
                e222.printStackTrace();
            }
        } else {
            zip(apk_name, workingDir, classesFiles, new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString());
            run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString());
            run_all_no_root("chown", "1000." + uid, new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString());
            run_all_no_root("chown", "1000:" + uid, new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString());
            if (new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).exists() && new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).length() != 0) {
                System.out.println("LuckyPatcher (CustomPatch): foundreworked apk " + workingDir + InternalZipConstants.ZIP_FILE_SEPARATOR + apk_name);
            }
            if (new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).exists() && new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).length() == 0) {
                new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).delete();
            }
            try {
                new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dalvikFile.getName()).toString()).delete();
                dex = DexFile.loadDex(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString(), new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dalvikFile.getName()).toString(), 0);
            } catch (RuntimeException e3) {
                e3.printStackTrace();
            } catch (Exception e2222) {
                e2222.printStackTrace();
            }
            String dexname = dalvikFile.getName();
            System.out.println(dexname);
            System.out.println(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString());
            checkdex = new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString());
            if (checkdex.exists() && checkdex.length() == 0) {
                checkdex.delete();
            }
            if (new File(checkdex.getAbsolutePath()).exists()) {
                fixadlerOdex(checkdex, apk_file);
                if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString(), odexFile)) {
                    System.out.println("Free space for odex enougth.");
                    free_space = true;
                } else {
                    new File(apkOdex).delete();
                    if (new File(apkOdex).exists()) {
                        run_all_no_root("rm", apkOdex);
                    }
                    if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString(), dalvikFile.getAbsolutePath())) {
                        odexFile = dalvikFile.getAbsolutePath();
                        free_space = false;
                    } else {
                        new File(apkOdex).delete();
                        if (new File(apkOdex).exists()) {
                            run_all_no_root("rm", apkOdex);
                        }
                        free_space = false;
                    }
                }
            }
            if (!(!free_space || ART || new File(apkOdex).exists())) {
                System.out.println("lackypatch: dexopt-wrapper used!");
                run_all_no_root("chown", "0.0", new StringBuilder(String.valueOf(workingDir)).append("/dexopt-wrapper").toString());
                run_all_no_root("chown", "0:0", new StringBuilder(String.valueOf(workingDir)).append("/dexopt-wrapper").toString());
                run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(workingDir)).append("/dexopt-wrapper").toString());
                String resu = cmdParam(listAppsFragment.toolfilesdir + "/dexopt-wrapper", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString(), apkOdex);
                System.out.println(resu);
                if (!resu.contains("succes") || resu.contains("failed")) {
                    new File(apkOdex).delete();
                    run_all_no_root("rm", apkOdex);
                    odexFile = dalvikFile.getAbsolutePath();
                    if (new File(apkOdex).exists()) {
                        run_all_no_root("rm", odexFile);
                    }
                    run_all_no_root("rm", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString());
                    cmdParam(listAppsFragment.toolfilesdir + "/dexopt-wrapper", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString(), new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString());
                    run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString());
                    run_all_no_root("chown", "0.0", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString());
                    run_all_no_root("chown", "0:0", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString());
                    fixadlerOdex(new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString()), apk_file);
                    copyFile(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dexname).toString(), odexFile, false, true);
                } else {
                    fixadlerOdex(new File(apkOdex), apk_file);
                }
            }
        }
        if (apk_file.startsWith("/system")) {
            run_all_no_root("chmod", "0644", odexFile);
            run_all_no_root("chown", "0.0", odexFile);
            run_all_no_root("chown", "0:0", odexFile);
        } else {
            run_all_no_root("chmod", "0644", odexFile);
            run_all_no_root("chown", "1000." + uid, odexFile);
            run_all_no_root("chown", "1000:" + uid, odexFile);
        }
        new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dalvikFile.getName()).toString()).delete();
        new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(dalvikFile.getName()).toString()).delete();
        new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).delete();
        if (new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString()).exists()) {
            run_all_no_root("rm", new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(apk_name).toString());
        }
        if (dex != null) {
            try {
                dex.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (!free_space_int) {
            return 3;
        }
        if (ART && genARTerror) {
            return 2;
        }
        if (ART && !free_space) {
            return 1;
        }
        if (ART && free_space) {
            return 0;
        }
        if (!ART && !free_space) {
            return 1;
        }
        if (ART || !free_space) {
            return 0;
        }
        return 0;
    }

    public void waitLP(long millissecond) {
        long endTime = System.currentTimeMillis() + millissecond;
        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        }
    }

    public static int create_DC_root(String workingDir, String apk_file, String uid, String odexFile) {
        run_all_no_root("chmod", "777", workingDir);
        run_all_no_root("chown", "0:0", workingDir);
        run_all_no_root("chown", "0.0", workingDir);
        File dalvik_art = null;
        try {
            dalvik_art = getFileDalvikCacheName(apk_file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (odexFile == null) {
            odexFile = getOdexForCreate(apk_file, uid);
        }
        if (odexFile != null && new File(odexFile).exists()) {
            remount(odexFile, "RW");
            new File(odexFile).delete();
        }
        boolean free_space = false;
        String apk_name = new File(apk_file).getName();
        String apkOdex = getOdexForCreate(apk_file, uid);
        File dalvikFile = getFileDalvikCacheName(apk_file);
        String odexName = changeExtension(new File(apk_file).getName(), "odex");
        DexFile dex = null;
        boolean z = false;
        if (getCurrentRuntimeValue().contains("ART")) {
            z = true;
        } else {
            z = false;
        }
        if (dalvik_art.exists()) {
            dalvik_art.delete();
        }
        if (z) {
            System.out.println("dex-opt-art");
            try {
                System.out.println("try create oat with DexFile:");
                String instructions = "";
                if (dalvik_art.getAbsolutePath().contains("/arm/")) {
                    instructions = "arm";
                }
                if (dalvik_art.getAbsolutePath().contains("/arm64/")) {
                    instructions = "arm64";
                }
                if (dalvik_art.getAbsolutePath().contains("/x86/")) {
                    instructions = "x86";
                }
                if (dalvik_art.getAbsolutePath().contains("/x86_64/")) {
                    instructions = "x86_64";
                }
                dalvik_art.delete();
                if (dalvik_art.exists()) {
                    run_all_no_root("rm", dalvik_art.getAbsolutePath());
                }
                System.out.println("try create oat with dex2oat:");
                System.out.println(cmdParam("dex2oat", "--dex-file=" + apk_file, "--oat-file=" + dalvik_art.getAbsolutePath(), "--instruction-set=" + instructions));
                System.out.println("end");
                if (!dalvik_art.exists() || dalvik_art.length() == 0) {
                    dalvik_art.delete();
                    if (dalvik_art.exists()) {
                        run_all_no_root("rm", dalvik_art.getAbsolutePath());
                    }
                } else {
                    System.out.println("oat created with dex2oat - length=" + dalvik_art.length());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                dalvik_art.delete();
                dex = DexFile.loadDex(apk_file, new StringBuilder(String.valueOf(workingDir)).append("/temp.dex").toString(), 0);
            } catch (RuntimeException e3) {
                e3.printStackTrace();
            } catch (Exception e22) {
                e22.printStackTrace();
            }
            try {
                if (dalvikvm_copyFile(listAppsFragment.toolfilesdir, new StringBuilder(String.valueOf(workingDir)).append("/temp.dex").toString(), dalvik_art.getAbsolutePath())) {
                    System.out.println("Free space for dex enougth.");
                    free_space = true;
                }
                new File(new StringBuilder(String.valueOf(workingDir)).append("/temp.dex").toString()).delete();
                if (dalvik_art.exists() && dalvik_art.length() == 0) {
                    dalvik_art.delete();
                }
            } catch (Exception e222) {
                e222.printStackTrace();
            }
        }
        if (apk_file.startsWith("/system")) {
            run_all_no_root("chmod", "0644", dalvik_art.getAbsolutePath());
            run_all_no_root("chown", "0.0", dalvik_art.getAbsolutePath());
            run_all_no_root("chown", "0:0", dalvik_art.getAbsolutePath());
        } else {
            run_all_no_root("chmod", "0644", dalvik_art.getAbsolutePath());
            run_all_no_root("chown", "1000." + uid, dalvik_art.getAbsolutePath());
            run_all_no_root("chown", "1000:" + uid, dalvik_art.getAbsolutePath());
        }
        if (dex != null) {
            try {
                dex.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (!true) {
            return 3;
        }
        if (z && false) {
            return 2;
        }
        if (z && !free_space) {
            return 1;
        }
        if (z && free_space) {
            return 0;
        }
        if (!z && !free_space) {
            return 1;
        }
        if (z || !free_space) {
            return 0;
        }
        return 0;
    }

    public static void afterPatch(String patterns, String app_apk, String odexFile, String uid, String toolsfiledir) {
        System.out.println("uid:" + uid);
        if (patterns.contains("copyDC") || patterns.contains("deleteDC")) {
            File dalvikcache = getFileDalvikCache(app_apk);
            if (dalvikcache != null) {
                dalvikcache.delete();
                if (patterns.contains("copyDC")) {
                    copyFile(new File(odexFile), dalvikcache);
                    if (dalvikcache.exists() && dalvikcache.length() == new File(odexFile).length()) {
                        new File(odexFile).delete();
                        run_all_no_root("chmod", "644", dalvikcache.getAbsolutePath());
                        run_all_no_root("chown", "1000:" + uid, dalvikcache.getAbsolutePath());
                        run_all_no_root("chown", "1000." + uid, dalvikcache.getAbsolutePath());
                    }
                }
            } else if (patterns.contains("copyDC")) {
                File dfile = getFileDalvikCacheName(app_apk);
                copyFile(new File(odexFile), dfile);
                if (dfile.exists() && dfile.length() == new File(odexFile).length()) {
                    new File(odexFile).delete();
                    run_all_no_root("chmod", "644", dfile.getAbsolutePath());
                    run_all_no_root("chown", "1000:" + uid, dfile.getAbsolutePath());
                    run_all_no_root("chown", "1000." + uid, dfile.getAbsolutePath());
                }
            }
        }
    }

    public static void zip(String apkname, String workingDir, ArrayList<File> classesFiles, String rebuild_apk) {
        FileInputStream fi;
        BufferedInputStream origin;
        int count;
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(rebuild_apk, false)));
        byte[] data = new byte[LZMA2Options.DICT_SIZE_MIN];
        Iterator it = classesFiles.iterator();
        BufferedInputStream origin2 = null;
        while (it.hasNext()) {
            try {
                File cl = (File) it.next();
                fi = new FileInputStream(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(cl.getName()).toString());
                origin = new BufferedInputStream(fi, LZMA2Options.DICT_SIZE_MIN);
            } catch (Exception e) {
                Exception e2 = e;
                origin = origin2;
            }
            try {
                out.putNextEntry(new ZipEntry(cl.getName()));
                while (true) {
                    count = origin.read(data, 0, LZMA2Options.DICT_SIZE_MIN);
                    if (count == -1) {
                        break;
                    }
                    out.write(data, 0, count);
                }
                origin.close();
                out.closeEntry();
                fi.close();
                origin2 = origin;
            } catch (Exception e3) {
                e2 = e3;
            }
        }
        fi = new FileInputStream(new StringBuilder(String.valueOf(workingDir)).append("/AndroidManifest.xml").toString());
        origin = new BufferedInputStream(fi, LZMA2Options.DICT_SIZE_MIN);
        out.putNextEntry(new ZipEntry("AndroidManifest.xml"));
        while (true) {
            count = origin.read(data, 0, LZMA2Options.DICT_SIZE_MIN);
            if (count == -1) {
                break;
            }
            out.write(data, 0, count);
        }
        origin.close();
        out.closeEntry();
        out.close();
        fi.close();
        new File(new StringBuilder(String.valueOf(workingDir)).append("/AndroidManifest.xml").toString()).delete();
        it = classesFiles.iterator();
        while (it.hasNext()) {
            new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(((File) it.next()).getName()).toString()).delete();
        }
        e2.printStackTrace();
        new File(new StringBuilder(String.valueOf(workingDir)).append("/AndroidManifest.xml").toString()).delete();
        it = classesFiles.iterator();
        while (it.hasNext()) {
            new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(((File) it.next()).getName()).toString()).delete();
        }
    }

    public static String zipART(String apkname, String workingDir, ArrayList<File> classesFiles, String apkfile) {
        Iterator it;
        String dataWorkDir = "/data/tmp";
        String createWorkApp = "";
        String createWorkDir = "";
        run_all_no_root("chmod", "777", "/data/tmp");
        try {
            System.out.println("Try create tmp.");
            new File("/data/tmp").mkdir();
            if (new File(dataWorkDir).exists()) {
                run_all_no_root("chmod", "777", "/data/tmp");
                try {
                    File[] files = new File("/data/tmp").listFiles();
                    if (files != null) {
                        for (File f : files) {
                            Utils utils = new Utils("1");
                            f.delete();
                            if (f.exists()) {
                                utils.deleteFolder(f);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("tmp dir not found. Try create with root.");
                new File(dataWorkDir).mkdirs();
                if (!new File(dataWorkDir).exists()) {
                    run_all_no_root("mkdir", dataWorkDir);
                }
                if (new File(dataWorkDir).exists()) {
                    run_all_no_root("chmod", "777", "/data/tmp");
                } else {
                    System.out.println("tmp dir not created.");
                }
            }
            if (apkfile.length() > ("/data/tmp/" + apkname).length() && apkfile.length() - ("/data/tmp/" + apkname).length() > 1) {
                char[] dir_delta = new char[((apkfile.length() - ("/data/tmp/" + apkname).length()) - 1)];
                for (int i = 0; i < dir_delta.length; i++) {
                    dir_delta[i] = '1';
                }
                createWorkApp = "/data/tmp/" + new String(dir_delta) + InternalZipConstants.ZIP_FILE_SEPARATOR + apkname;
                createWorkDir = "/data/tmp/" + new String(dir_delta);
                new File("/data/tmp/" + new String(dir_delta)).mkdirs();
                if (new File("/data/tmp/" + new String(dir_delta)).exists()) {
                    System.out.println("Dir delta created.");
                }
                System.out.println("Path to create zip: " + createWorkApp);
                System.out.println("Path to origin zip: " + apkfile);
            }
            if (apkfile.length() == ("/data/tmp/" + apkname).length()) {
                createWorkApp = "/data/tmp/" + apkname;
                createWorkDir = "";
            }
            if (new File(createWorkApp).exists()) {
                new File(createWorkApp).delete();
            }
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createWorkApp, false)));
            byte[] data = new byte[LZMA2Options.DICT_SIZE_MIN];
            it = classesFiles.iterator();
            while (it.hasNext()) {
                File cl = (File) it.next();
                FileInputStream fi = new FileInputStream(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(cl.getName()).toString());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fi, LZMA2Options.DICT_SIZE_MIN);
                zipOutputStream.putNextEntry(new ZipEntry(cl.getName()));
                while (true) {
                    int count = bufferedInputStream.read(data, 0, LZMA2Options.DICT_SIZE_MIN);
                    if (count == -1) {
                        break;
                    }
                    zipOutputStream.write(data, 0, count);
                }
                bufferedInputStream.close();
                zipOutputStream.closeEntry();
                fi.close();
            }
            zipOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            if (new File(createWorkApp).exists()) {
                new File(createWorkApp).delete();
            }
        }
        new File(new StringBuilder(String.valueOf(workingDir)).append("/AndroidManifest.xml").toString()).delete();
        it = classesFiles.iterator();
        while (it.hasNext()) {
            new File(new StringBuilder(String.valueOf(workingDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(((File) it.next()).getName()).toString()).delete();
        }
        if (new File(createWorkApp).exists() && new File(createWorkApp).length() != 0) {
            return createWorkApp;
        }
        if (new File(createWorkApp).exists()) {
            new File(createWorkApp).delete();
        }
        if (new File(createWorkDir).exists() && createWorkDir.contains("1")) {
            new File(createWorkDir).delete();
        }
        return "";
    }

    public static boolean XZDecompress(File file_xz, String decompressDir) {
        byte[] buf = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
        String name = null;
        File dir = new File(decompressDir);
        if (!dir.exists() || dir.isFile()) {
            if (dir.isFile()) {
                dir.delete();
            }
            dir.mkdirs();
        }
        if (dir.exists()) {
            File decFile;
            if (decompressDir.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                decFile = new File(new StringBuilder(String.valueOf(decompressDir)).append(removeExtension(file_xz.getName())).toString());
            } else {
                decFile = new File(new StringBuilder(String.valueOf(decompressDir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(removeExtension(file_xz.getName())).toString());
            }
            try {
                name = file_xz.getAbsolutePath();
                InputStream in = new XZInputStream(new FileInputStream(file_xz));
                FileOutputStream out = new FileOutputStream(decFile);
                while (true) {
                    int size = in.read(buf);
                    if (size == -1) {
                        break;
                    }
                    out.write(buf, 0, size);
                }
                if (decFile.exists()) {
                    return true;
                }
                decFile.delete();
                return false;
            } catch (FileNotFoundException e) {
                System.err.println("XZDec: Cannot open " + name + ": " + e.getMessage());
                decFile.delete();
                return false;
            } catch (EOFException e2) {
                System.err.println("XZDec: Unexpected end of input on " + name);
                decFile.delete();
                return false;
            } catch (IOException e3) {
                System.err.println("XZDec: Error decompressing from " + name + ": " + e3.getMessage());
                decFile.delete();
                return false;
            }
        }
        System.out.println("not found dir for ectract xz.");
        return false;
    }

    public static boolean XZCompress(File file, File compress) throws OutOfMemoryError {
        try {
            FileInputStream inFile = new FileInputStream(file);
            XZOutputStream out = new XZOutputStream(new FileOutputStream(compress), new LZMA2Options());
            byte[] buf = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
            while (true) {
                int size = inFile.read(buf);
                if (size == -1) {
                    break;
                }
                out.write(buf, 0, size);
            }
            out.finish();
            if (compress.exists()) {
                return true;
            }
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("File not found for xz compress.");
            e.printStackTrace();
            return false;
        } catch (UnsupportedOptionsException e2) {
            System.out.println("Unsupported options for xz compress.");
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            System.out.println("IO Error for xz compress.");
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean hasXposed() {
        if (System.getenv("CLASSPATH") == null || !System.getenv("CLASSPATH").contains("Xposed")) {
            return false;
        }
        return true;
    }

    public static boolean isXposedEnabled() {
        return false;
    }

    public static boolean initXposedParam() {
        JSONObject settings;
        if (!new File("/data/lp/xposed").exists()) {
            if (!new File("/data/lp").exists()) {
                if (listAppsFragment.startUnderRoot.booleanValue()) {
                    new File("/data/lp").mkdirs();
                    try {
                        new File("/data/lp").setWritable(true, false);
                        new File("/data/lp").setReadable(true, false);
                    } catch (NoSuchMethodError e) {
                        e.printStackTrace();
                    }
                    run_all_no_root("chmod", "777", "/data/lp");
                } else {
                    run_all("mkdir /data/lp");
                    try {
                        new File("/data/lp").setWritable(true, false);
                        new File("/data/lp").setReadable(true, false);
                    } catch (NoSuchMethodError e2) {
                        e2.printStackTrace();
                    }
                    run_all("chmod 777 /data/lp");
                }
            }
            settings = new JSONObject();
            try {
                settings.put("patch1", true);
                settings.put("patch2", true);
                settings.put("patch3", false);
                settings.put("patch4", false);
                settings.put("hide", false);
                settings.put("module_on", true);
                if (listAppsFragment.startUnderRoot.booleanValue()) {
                    save_text_to_file(new File("/data/lp/xposed"), settings.toString());
                    try {
                        new File("/data/lp/xposed").setWritable(true, false);
                        new File("/data/lp/xposed").setReadable(true, false);
                    } catch (NoSuchMethodError e22) {
                        e22.printStackTrace();
                    }
                    run_all_no_root("chmod", "777", "/data/lp/xposed");
                } else {
                    save_text_to_file(new File("/data/lp/xposed"), settings.toString());
                    try {
                        new File("/data/lp/xposed").setWritable(true, false);
                        new File("/data/lp/xposed").setReadable(true, false);
                    } catch (NoSuchMethodError e222) {
                        e222.printStackTrace();
                    }
                    run_all("chmod 777 /data/lp/xposed");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
                return false;
            }
        } else if (listAppsFragment.startUnderRoot.booleanValue()) {
            try {
                new File("/data/lp/xposed").setWritable(true, false);
                new File("/data/lp/xposed").setReadable(true, false);
            } catch (NoSuchMethodError e2222) {
                e2222.printStackTrace();
            }
            run_all_no_root("chmod", "777", "/data/lp/xposed");
        } else {
            try {
                new File("/data/lp/xposed").setWritable(true, false);
                new File("/data/lp/xposed").setReadable(true, false);
            } catch (NoSuchMethodError e22222) {
                e22222.printStackTrace();
            }
            run_all("chmod 777 /data/lp/xposed");
        }
        try {
            settings = new JSONObject(read_from_file(new File("/data/lp/xposed")));
        } catch (JSONException e4) {
            if (listAppsFragment.startUnderRoot.booleanValue()) {
                run_all_no_root("chmod", "777", "/data/lp/xposed");
            } else {
                run_all("chmod 777 /data/lp/xposed");
            }
        }
        try {
            settings = new JSONObject(read_from_file(new File("/data/lp/xposed")));
        } catch (JSONException e32) {
            e32.printStackTrace();
            settings = new JSONObject();
            try {
                settings.put("patch1", true);
                settings.put("patch2", true);
                settings.put("patch3", false);
                settings.put("patch4", false);
                settings.put("hide", false);
                settings.put("module_on", true);
                if (listAppsFragment.startUnderRoot.booleanValue()) {
                    save_text_to_file(new File("/data/lp/xposed"), settings.toString());
                    run_all_no_root("chmod", "777", "/data/lp/xposed");
                } else {
                    save_text_to_file(new File("/data/lp/xposed"), settings.toString());
                    run_all("chmod 777 /data/lp/xposed");
                }
                try {
                    settings = new JSONObject(read_from_file(new File("/data/lp/xposed")));
                } catch (JSONException e1) {
                    e1.printStackTrace();
                    return false;
                }
            } catch (JSONException e12) {
                e12.printStackTrace();
                return false;
            }
        }
        try {
            boolean result = settings.getBoolean("module_on");
            return true;
        } catch (JSONException e322) {
            e322.printStackTrace();
            return false;
        }
    }

    public static boolean saveXposedParamBoolean(String param, boolean save, boolean setAccess) {
        try {
            JSONObject settings = new JSONObject(read_from_file(new File("/data/lp/xposed")));
            try {
                settings.put(param, save);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println(settings.toString());
            save_text_to_file(new File("/data/lp/xposed"), settings.toString());
            if (setAccess) {
                if (listAppsFragment.startUnderRoot.booleanValue()) {
                    run_all_no_root("chmod", "777", "/data/lp/xposed");
                    try {
                        new File("/data/lp/settings_android_changed").createNewFile();
                        try {
                            new File("/data/lp/settings_android_changed").setWritable(true, false);
                            new File("/data/lp/settings_android_changed").setReadable(true, false);
                        } catch (NoSuchMethodError e2) {
                            e2.printStackTrace();
                        }
                        new File("/data/lp/settings_changed").createNewFile();
                        try {
                            new File("/data/lp/settings_changed").setWritable(true, false);
                            new File("/data/lp/settings_changed").setReadable(true, false);
                        } catch (NoSuchMethodError e22) {
                            e22.printStackTrace();
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    run_all("chmod 777 /data/lp/xposed");
                    try {
                        new File("/data/lp/settings_android_changed").createNewFile();
                        try {
                            new File("/data/lp/settings_android_changed").setWritable(true, false);
                            new File("/data/lp/settings_android_changed").setReadable(true, false);
                        } catch (NoSuchMethodError e222) {
                            e222.printStackTrace();
                        }
                        new File("/data/lp/settings_changed").createNewFile();
                        try {
                            new File("/data/lp/settings_changed").setWritable(true, false);
                            new File("/data/lp/settings_changed").setReadable(true, false);
                        } catch (NoSuchMethodError e2222) {
                            e2222.printStackTrace();
                        }
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = settings;
            return true;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static JSONObject readXposedParamBoolean() throws JSONException {
        return new JSONObject(read_from_file(new File("/data/lp/xposed")));
    }

    public static void dexoptcopy() {
        int resFile;
        File tempopt = new File(listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "dexopt-wrapper");
        if (Build.CPU_ABI.toLowerCase().trim().equals("x86")) {
            resFile = 2131099657;
        } else if (Build.CPU_ABI.toUpperCase().trim().equals("MIPS")) {
            resFile = 2131099656;
        } else {
            resFile = 2131099655;
        }
        if (tempopt.exists() && tempopt.length() == getRawLength(resFile)) {
            run_all("chmod 777 " + listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "dexopt-wrapper");
            run_all("chown 0.0 " + listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "dexopt-wrapper");
            run_all("chmod 0:0 " + listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "dexopt-wrapper");
            return;
        }
        try {
            getRawToFile(resFile, new File(listAppsFragment.toolfilesdir + "/dexopt-wrapper"));
        } catch (Exception e) {
        }
        try {
            chmod(new File(listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "dexopt-wrapper"), 777);
        } catch (Exception e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
        run_all("chmod 777 " + listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "dexopt-wrapper");
        run_all("chown 0.0 " + listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "dexopt-wrapper");
        run_all("chmod 0:0 " + listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "dexopt-wrapper");
    }

    private static void getSignatureKeys() {
        try {
            if (new File(listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "zipalign").exists() && new File(listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "zipalign").length() == getRawLength(2131099666)) {
                chmod(new File(listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "zipalign"), 777);
                run_all("chmod 777 " + listAppsFragment.toolfilesdir + InternalZipConstants.ZIP_FILE_SEPARATOR + "zipalign");
            } else {
                getRawToFile(2131099666, new File(listAppsFragment.toolfilesdir + "/zipalign"));
                chmod(new File(listAppsFragment.getInstance().getFilesDir() + InternalZipConstants.ZIP_FILE_SEPARATOR + "zipalign"), 777);
                run_all("chmod 777 " + listAppsFragment.getInstance().getFilesDir() + InternalZipConstants.ZIP_FILE_SEPARATOR + "zipalign");
            }
            getAssets("testkey.pk8", listAppsFragment.basepath + "/Modified/Keys");
            getAssets("testkey.sbt", listAppsFragment.basepath + "/Modified/Keys");
            getAssets("testkey.x509.pem", listAppsFragment.basepath + "/Modified/Keys");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFilesToZip(String inputZipFilename, String outputZipFilename, ArrayList<AddFilesItem> modified_files) throws IOException {
        Exception e;
        ZipInput input = ZipInput.read(inputZipFilename);
        JarOutputStream output = new JarOutputStream(new FileOutputStream(outputZipFilename));
        for (ZioEntry inEntry : input.getEntries().values()) {
            Iterator it;
            AddFilesItem file;
            JarEntry jarEntry;
            int num;
            JarEntry outEntry;
            if (inEntry.getCompression() == (short) 0) {
                CRC32 crc;
                outEntry = new JarEntry(inEntry.getName());
                outEntry.setMethod(0);
                boolean mark2 = false;
                it = modified_files.iterator();
                while (it.hasNext()) {
                    file = (AddFilesItem) it.next();
                    if (inEntry.getName().equals(file.fileName.replace(file.basePath, ""))) {
                        try {
                            File fileF = new File(file.fileName);
                            byte[] buffer = new byte[((int) fileF.length())];
                            FileInputStream data = new FileInputStream(file.fileName);
                            data.read(buffer);
                            data.close();
                            outEntry.setCompressedSize(fileF.length());
                            outEntry.setSize(fileF.length());
                            crc = new CRC32();
                            crc.update(buffer);
                            outEntry.setCrc(crc.getValue());
                            outEntry.setTime(inEntry.getTime());
                            mark2 = true;
                        } catch (Exception e2) {
                            try {
                                System.out.println(e2);
                            } catch (Exception e3) {
                                e2 = e3;
                                jarEntry = outEntry;
                            }
                        }
                    }
                }
                if (!mark2) {
                    outEntry.setCompressedSize((long) inEntry.getSize());
                    outEntry.setSize((long) inEntry.getSize());
                    crc = new CRC32();
                    crc.update(inEntry.getData());
                    outEntry.setCrc(crc.getValue());
                    outEntry.setTime(inEntry.getTime());
                    jarEntry = outEntry;
                }
                jarEntry = outEntry;
            } else {
                outEntry = new JarEntry(inEntry.getName());
                outEntry.setTime(inEntry.getTime());
                outEntry.setMethod(inEntry.getCompression());
                jarEntry = outEntry;
            }
            boolean mark = false;
            it = modified_files.iterator();
            while (it.hasNext()) {
                InputStream data2;
                file = (AddFilesItem) it.next();
                if (inEntry.getName().equals(file.fileName.replace(file.basePath, ""))) {
                    try {
                        fileF = new File(file.fileName);
                        buffer = new byte[8192];
                        data2 = new FileInputStream(file.fileName);
                        output.putNextEntry(jarEntry);
                        while (true) {
                            num = data2.read(buffer);
                            if (num <= 0) {
                                break;
                            }
                            output.write(buffer, 0, num);
                        }
                        output.flush();
                        data2.close();
                        mark = true;
                        fileF.delete();
                        System.out.println("LuckyPatcher (signer): Additional files added! " + file);
                    } catch (Exception e22) {
                        try {
                            System.out.println(e22);
                        } catch (Exception e4) {
                            e22 = e4;
                        }
                    }
                }
            }
            if (!mark) {
                output.putNextEntry(jarEntry);
                data2 = inEntry.getInputStream();
                buffer = new byte[8192];
                while (true) {
                    num = data2.read(buffer);
                    if (num <= 0) {
                        break;
                    }
                    output.write(buffer, 0, num);
                }
                output.flush();
            }
        }
        output.close();
        return;
        System.out.println(e22);
        e22.printStackTrace();
    }

    public static void addFileToList(File fileF, ArrayList<File> files) {
        if (files != null && files.size() > 0) {
            boolean foundEq = false;
            Iterator it = files.iterator();
            while (it.hasNext()) {
                if (((File) it.next()).length() == fileF.length()) {
                    foundEq = true;
                }
            }
            if (!foundEq) {
                files.add(fileF);
            }
        } else if (files != null) {
            files.add(fileF);
        }
    }

    public static String getSimulink(String file) {
        String result = "";
        Matcher symlinkMatcher;
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            symlinkMatcher = Pattern.compile("^.*?\\-\\>\\s+(.*)$").matcher(cmdParam("ls", "-l", file));
            if (symlinkMatcher.find()) {
                result = symlinkMatcher.group(1);
                System.out.println("Symlink found: " + result);
                return result;
            }
            String get = cmdParam(listAppsFragment.toolfilesdir + "/busybox", "ls", "-l", file);
            System.out.println(get);
            symlinkMatcher = Pattern.compile("^.*?\\-\\>\\s+(.*)$").matcher(get);
            if (symlinkMatcher.find()) {
                result = symlinkMatcher.group(1);
                System.out.println("Symlink found: " + result);
                return result;
            }
            System.out.println("No symlink found!");
            return "";
        }
        symlinkMatcher = Pattern.compile("^.*?\\-\\>\\s+(.*)$").matcher(new Utils("").cmdRoot("ls -l " + file));
        if (symlinkMatcher.find()) {
            result = symlinkMatcher.group(1);
            System.out.println("Symlink found: " + result);
            return result;
        }
        symlinkMatcher = Pattern.compile("^.*?\\-\\>\\s+(.*)$").matcher(new Utils("").cmdRoot(listAppsFragment.toolfilesdir + "/busybox ls -l " + file));
        if (symlinkMatcher.find()) {
            result = symlinkMatcher.group(1);
            System.out.println("Symlink found: " + result);
            return result;
        }
        System.out.println("No symlink found!");
        return "";
    }

    public static void market_billing_services(boolean enable) {
        if (listAppsFragment.su) {
            new Thread(new AnonymousClass15(enable)).start();
        }
    }

    public static void market_billing_services_to_main_stream(boolean enable) {
        if (listAppsFragment.su) {
            ArrayList<Components> tmpList = new ArrayList();
            PackageInfo info = null;
            try {
                info = listAppsFragment.getPkgMng().getPackageInfo(Common.GOOGLEPLAY_PKG, 516);
            } catch (NameNotFoundException e1) {
                e1.printStackTrace();
            }
            if (info != null && info.services != null && info.services.length != 0) {
                int d = 0;
                while (d < info.services.length) {
                    if (!enable) {
                        try {
                            if ((info.services[d].name.endsWith("InAppBillingService") || info.services[d].name.endsWith("MarketBillingService")) && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 2) {
                                new Utils("").cmdRoot("pm disable 'com.android.vending/" + info.services[d].name + "'", "skipOut");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if ((info.services[d].name.endsWith("InAppBillingService") || info.services[d].name.endsWith("MarketBillingService")) && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 1) {
                        new Utils("").cmdRoot("pm enable 'com.android.vending/" + info.services[d].name + "'", "skipOut");
                    }
                    d++;
                }
            }
        }
    }

    public static void market_licensing_services(boolean enable) {
        if (listAppsFragment.su) {
            new Thread(new AnonymousClass16(enable)).start();
        }
    }

    public static PackageInfo getPkgInfo(String pkgName, int flag) {
        PackageInfo info = null;
        try {
            info = listAppsFragment.getPkgMng().getPackageInfo(pkgName, flag);
        } catch (NameNotFoundException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e12) {
            e12.printStackTrace();
        }
        return info;
    }

    public static void market_licensing_services_to_main_stream(boolean enable) {
        if (listAppsFragment.su) {
            ArrayList<Components> tmpList = new ArrayList();
            PackageInfo info = getPkgInfo(Common.GOOGLEPLAY_PKG, 516);
            if (info != null && info.services != null && info.services.length != 0) {
                int d = 0;
                while (d < info.services.length) {
                    if (!enable) {
                        try {
                            if (info.services[d].name.endsWith("LicensingService") && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 2) {
                                new Utils("").cmdRoot("pm disable 'com.android.vending/" + info.services[d].name + "'", "skipOut");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (info.services[d].name.endsWith("LicensingService") && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 1) {
                        new Utils("").cmdRoot("pm enable 'com.android.vending/" + info.services[d].name + "'", "skipOut");
                    }
                    d++;
                }
            }
        }
    }

    public static void setPermissionDir(String startDir, String dir, String permissions, boolean setPermissionForStartDir) {
        if (new File(dir).exists()) {
            String[] dirs = dir.split(File.separator);
            String dir_tmp = InternalZipConstants.ZIP_FILE_SEPARATOR;
            for (int i = 0; i < dirs.length; i++) {
                if (!dirs[i].equals("")) {
                    dir_tmp = new StringBuilder(String.valueOf(dir_tmp)).append(dirs[i]).toString();
                }
                if (dir_tmp.startsWith(startDir) || new StringBuilder(String.valueOf(dir_tmp)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).toString().startsWith(startDir)) {
                    if (setPermissionForStartDir) {
                        cmdParam("chmod", permissions, dir_tmp);
                    }
                    setPermissionForStartDir = true;
                }
                if (!dirs[i].equals("")) {
                    dir_tmp = new StringBuilder(String.valueOf(dir_tmp)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).toString();
                }
            }
        }
    }

    public static void setOwnerDir(String startDir, String dir, String owner, boolean setOwnerForStartDir) {
        if (new File(dir).exists()) {
            String[] dirs = dir.split(File.separator);
            String dir_tmp = InternalZipConstants.ZIP_FILE_SEPARATOR;
            for (int i = 0; i < dirs.length; i++) {
                if (!dirs[i].equals("")) {
                    dir_tmp = new StringBuilder(String.valueOf(dir_tmp)).append(dirs[i]).toString();
                }
                if (dir_tmp.startsWith(startDir) || new StringBuilder(String.valueOf(dir_tmp)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).toString().startsWith(startDir)) {
                    if (setOwnerForStartDir) {
                        cmdParam("chown", owner, dir_tmp);
                        cmdParam("chown", owner.replace(":", "."), dir_tmp);
                    }
                    setOwnerForStartDir = true;
                }
                if (!dirs[i].equals("")) {
                    dir_tmp = new StringBuilder(String.valueOf(dir_tmp)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).toString();
                }
            }
        }
    }

    public static String getPermissions(String file) {
        String result = "";
        String get;
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            get = cmdParam(listAppsFragment.toolfilesdir + "/busybox", "stat", "-c", "%a", file).replaceAll("\n", "").replaceAll("\r", "").trim();
            System.out.println("'" + get + "'");
            if (!get.matches("(\\d+)")) {
                System.out.println("try get permission again");
                get = cmdParam("busybox", "stat", "-c", "%a", file).replaceAll("\n", "").replaceAll("\r", "").trim();
            }
            return !get.matches("(\\d+)") ? "" : get;
        } else {
            get = cmdParam(listAppsFragment.toolfilesdir + "/busybox", "stat", "-c", "%a", file).replaceAll("\n", "").replaceAll("\r", "").trim();
            System.out.println(get);
            if (!get.matches("(\\d+)")) {
                System.out.println("try get permission again");
                get = cmdParam("busybox", "stat", "-c", "%a", file).replaceAll("\n", "").replaceAll("\r", "").trim();
            }
            if (get.matches("(\\d+)")) {
                return get;
            }
            return "";
        }
    }

    public static void copyArchFiles(ZipInputStream in, JarOutputStream out, ArrayList<AddFilesItem> filess) throws IOException {
        Exception e;
        boolean mark2 = false;
        AddFilesItem[] files = (AddFilesItem[]) filess.toArray(new AddFilesItem[filess.size()]);
        byte[] buffer = new byte[8192];
        CRC32 crc = new CRC32();
        crc.reset();
        ZipEntry outEntry = null;
        while (true) {
            ZipEntry inEntry = in.getNextEntry();
            if (inEntry == null) {
                out.finish();
                out.close();
                return;
            }
            int length = files.length;
            int i = 0;
            ZipEntry outEntry2 = outEntry;
            while (i < length) {
                AddFilesItem file = files[i];
                if (inEntry.getName().equals(file.fileName.replace(file.basePath, ""))) {
                    try {
                        outEntry = new ZipEntry(inEntry.getName());
                        try {
                            outEntry.setTime(inEntry.getTime());
                            File fileF = new File(file.fileName);
                            FileInputStream data = new FileInputStream(file.fileName);
                            byte[] buffer2 = new byte[((int) fileF.length())];
                            data.read(buffer2);
                            outEntry.setSize(fileF.length());
                            crc.update(buffer2);
                            outEntry.setCrc(crc.getValue());
                            outEntry.setMethod(inEntry.getMethod());
                            data.close();
                            mark2 = true;
                        } catch (Exception e2) {
                            e = e2;
                            System.out.println(e);
                            i++;
                            outEntry2 = outEntry;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        outEntry = outEntry2;
                        System.out.println(e);
                        i++;
                        outEntry2 = outEntry;
                    }
                } else {
                    outEntry = outEntry2;
                }
                i++;
                outEntry2 = outEntry;
            }
            if (inEntry.getMethod() == 0) {
                if (!mark2) {
                    outEntry = new ZipEntry(inEntry);
                    outEntry.setMethod(0);
                    outEntry.setTime(inEntry.getTime());
                    outEntry.setCompressedSize(inEntry.getSize());
                    outEntry.setSize(inEntry.getSize());
                    out.putNextEntry(outEntry);
                    crc.reset();
                }
                outEntry = outEntry2;
            } else {
                if (!mark2) {
                    outEntry = new JarEntry(inEntry.getName());
                    out.putNextEntry(outEntry);
                    outEntry.setTime(inEntry.getTime());
                }
                outEntry = outEntry2;
            }
            int num;
            if (mark2) {
                for (AddFilesItem file2 : files) {
                    if (inEntry.getName().equals(file2.fileName.replace(file2.basePath, ""))) {
                        try {
                            fileF = new File(file2.fileName);
                            data = new FileInputStream(file2.fileName);
                            out.putNextEntry(outEntry);
                            while (true) {
                                num = data.read(buffer);
                                if (num <= 0) {
                                    break;
                                }
                                out.write(buffer, 0, num);
                            }
                            out.flush();
                            fileF.delete();
                            data.close();
                        } catch (Exception e4) {
                            System.out.println(e4);
                        }
                    }
                }
                mark2 = false;
            } else {
                while (true) {
                    num = in.read(buffer);
                    if (num <= 0) {
                        break;
                    }
                    out.write(buffer, 0, num);
                    crc.update(buffer, 0, num);
                }
                out.flush();
                outEntry.setCrc(crc.getValue());
            }
        }
    }

    public static boolean classes_test(File apk) {
        try {
            FileInputStream fin = new FileInputStream(apk);
            ZipInputStream zin = new ZipInputStream(fin);
            for (ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry()) {
                if (ze.getName().toLowerCase().equals("classes.dex")) {
                    zin.closeEntry();
                    zin.close();
                    fin.close();
                    return true;
                }
            }
            zin.close();
            fin.close();
        } catch (Exception e) {
            try {
                for (ZioEntry inEntry : ZipInput.read(apk.getAbsolutePath()).getEntries().values()) {
                    if (inEntry.getName().toLowerCase().equals("classes.dex")) {
                        return true;
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isBootOatCache() {
        if (new File("/data/dalvik-cache/arm/system@framework@boot.oat").exists() || new File("/data/dalvik-cache/arm64/system@framework@boot.oat").exists() || new File("/data/dalvik-cache/x86/system@framework@boot.oat").exists() || new File("/data/dalvik-cache/x86_64/system@framework@boot.oat").exists() || new File("/data/dalvik-cache/oat/arm/system@framework@boot.oat").exists() || new File("/data/dalvik-cache/oat/arm64/system@framework@boot.oat").exists() || new File("/data/dalvik-cache/oat/x86/system@framework@boot.oat").exists() || new File("/data/dalvik-cache/oat/x86_64/system@framework@boot.oat").exists()) {
            return true;
        }
        return false;
    }

    public static boolean isServicesCache() {
        if (new File("/data/dalvik-cache/arm/system@framework@services.jar@classes.dex").exists() || new File("/data/dalvik-cache/arm64/system@framework@services.jar@classes.dex").exists() || new File("/data/dalvik-cache/x86/system@framework@services.jar@classes.dex").exists() || new File("/data/dalvik-cache/x86_64/system@framework@services.jar@classes.dex").exists() || new File("/data/dalvik-cache/oat/arm/system@framework@services.jar@classes.dex").exists() || new File("/data/dalvik-cache/oat/arm64/system@framework@services.jar@classes.dex").exists() || new File("/data/dalvik-cache/oat/x86/system@framework@services.jar@classes.dex").exists() || new File("/data/dalvik-cache/oat/x86_64/system@framework@services.jar@classes.dex").exists()) {
            return true;
        }
        return false;
    }

    public static void reboot() {
        if (listAppsFragment.startUnderRoot.booleanValue()) {
            try {
                cmdParam("reboot");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                cmdParam("/system/bin/reboot");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                cmdParam("/system/xbin/reboot");
            } catch (Exception e22) {
                e22.printStackTrace();
            }
            try {
                cmdParam("busybox reboot");
            } catch (Exception e222) {
                e222.printStackTrace();
            }
            try {
                cmd("reboot");
            } catch (Exception e2222) {
                e2222.printStackTrace();
            }
            try {
                run_all_no_root("reboot");
            } catch (Exception e22222) {
                e22222.printStackTrace();
            }
            try {
                run_all_no_root(listAppsFragment.toolfilesdir + "/reboot");
                return;
            } catch (Exception e222222) {
                e222222.printStackTrace();
                return;
            }
        }
        try {
            new Utils("").cmdRoot("reboot");
        } catch (Exception e2222222) {
            e2222222.printStackTrace();
        }
        try {
            new Utils("").cmdRoot("/system/bin/reboot");
        } catch (Exception e22222222) {
            e22222222.printStackTrace();
        }
        try {
            new Utils("").cmdRoot("/system/xbin/reboot");
        } catch (Exception e222222222) {
            e222222222.printStackTrace();
        }
        try {
            new Utils("").cmdRoot("busybox reboot");
        } catch (Exception e2222222222) {
            e2222222222.printStackTrace();
        }
        try {
            cmd("reboot");
        } catch (Exception e22222222222) {
            e22222222222.printStackTrace();
        }
        try {
            run_all("reboot");
        } catch (Exception e222222222222) {
            e222222222222.printStackTrace();
        }
        try {
            listAppsFragment.patchAct.runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(listAppsFragment.getInstance(), Utils.getText(2131362237), 1).show();
                }
            });
        } catch (Exception e2222222222222) {
            e2222222222222.printStackTrace();
        }
        new Utils("w").waitLP(5000);
        try {
            run_all(listAppsFragment.getInstance().getFilesDir() + "/reboot");
        } catch (Exception e22222222222222) {
            e22222222222222.printStackTrace();
        }
    }

    public static String getRandomStringLowerCase(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String getRandomStringUpperLowerCase(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB2.charAt(rnd.nextInt(AB2.length())));
        }
        return sb.toString();
    }

    public static String gen_sha1withrsa(String in_text) {
        byte[] sign = new byte[in_text.length()];
        rnd.nextBytes(sign);
        return Base64.encode(sign);
    }

    public static String sha1withrsa_sign(String in_text) {
        String result = "";
        try {
            PrivateKey privateKey = KeyPairGenerator.getInstance("RSA").generateKeyPair().getPrivate();
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initSign(privateKey);
            instance.update(in_text.getBytes());
            byte[] signature = instance.sign();
            result = Base64.encode(signature);
            System.out.println("b64: " + Base64.encode(signature));
            System.out.println("Signature: " + new String(signature));
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return result;
        } catch (SignatureException e2) {
            e2.printStackTrace();
            return result;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return result;
        }
    }

    public static boolean onMainThread() {
        return Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isWithFramework() {
        if (listAppsFragment.api >= 23) {
            return false;
        }
        String result = new Utils("").cmdRoot(listAppsFragment.dalvikruncommandWithFramework + ".checkWithFramework 123");
        listAppsFragment.startUnderRoot = Boolean.valueOf(false);
        if (result.contains("withoutFramework") || listAppsFragment.errorOutput.contains("java.lang.ClassNotFoundException:")) {
            return false;
        }
        System.out.println("WithFramework support");
        return true;
    }

    public static boolean isInstalledOnSdCard(String pkgName) {
        if (listAppsFragment.api > 7) {
            try {
                if ((listAppsFragment.getPkgMng().getPackageInfo(pkgName, 0).applicationInfo.flags & 262144) == 262144) {
                    return true;
                }
                return false;
            } catch (NameNotFoundException e) {
            }
        }
        try {
            String filesDir = listAppsFragment.getPkgMng().getPackageInfo(pkgName, 0).applicationInfo.sourceDir;
            if (filesDir.startsWith("/data/")) {
                return false;
            }
            if (filesDir.contains("/mnt/") || filesDir.contains("/sdcard/")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
        }
    }

    public static String getXmlAttribute(String parseText, String itemName, String attributeName) {
        try {
            NodeList nl = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(parseText))).getElementsByTagName(itemName);
            if (0 < nl.getLength()) {
                return ((Element) nl.item(0)).getAttribute(attributeName);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return "";
    }

    public static boolean sendFromRoot(String msg) {
        System.out.println(msg);
        return false;
    }

    public static boolean sendFromRootCP(String msg) {
        System.out.println(msg);
        return false;
    }

    public static void exitFromRootJava() {
        boolean root = listAppsFragment.startUnderRoot.booleanValue();
        listAppsFragment.startUnderRoot = Boolean.valueOf(false);
        if (root) {
            System.exit(0);
        }
    }

    public static void exit() {
        if (!listAppsFragment.getConfig().getBoolean("OnBootService", false) && !listAppsFragment.patchOnBoot && !listAppsFragment.desktop_launch && !listAppsFragment.appDisabler && !listAppsFragment.binderWidget) {
            System.out.println("Enf: " + getSELinux());
            if (getSELinux().equals("enforce")) {
                try {
                    new Utils("").cmdRoot("setenforce 1");
                } catch (Exception e) {
                }
            }
            System.out.println("LP - exit.");
            System.exit(0);
        }
    }

    public static String apply_TAGS(String text, String package_name) {
        return text.replaceAll("%PACKAGE_NAME%", package_name);
    }

    public static String getSELinux() {
        File dir = new File("/data/lp");
        File utils_file = new File("/data/lp/lp_utils");
        if (utils_file.exists()) {
            try {
                String[] params = read_from_file(utils_file).split("%chelpus%");
                if (params != null && params.length > 0) {
                    int i = 0;
                    while (i < params.length) {
                        switch (i) {
                            case AxmlVisitor.TYPE_STRING /*3*/:
                                return params[i];
                            default:
                                i++;
                        }
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println("Lucky Patcher not found utils.");
        }
        return "";
    }

    public static void startRootJava(Object obj) {
        if (obj != null) {
            System.out.println("SU Java-Code Running! " + obj.getClass().getEnclosingClass().getName());
        }
        listAppsFragment.startUnderRoot = Boolean.valueOf(true);
        listAppsFragment.toolfilesdir = "";
        File dir = new File("/data/lp");
        File utils_file = new File("/data/lp/lp_utils");
        if (utils_file.exists()) {
            String[] params = read_from_file(utils_file).split("%chelpus%");
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    switch (i) {
                        case XZ.CHECK_NONE /*0*/:
                            listAppsFragment.toolfilesdir = params[i];
                            continue;
                        case AxmlVisitor.TYPE_REFERENCE /*1*/:
                            listAppsFragment.api = Integer.parseInt(params[i]);
                            break;
                        case ValueWrapper.STYLE /*2*/:
                            break;
                        case AxmlVisitor.TYPE_STRING /*3*/:
                            break;
                        default:
                            break;
                    }
                    listAppsFragment.runtime = params[i];
                    listAppsFragment.selinux = params[i];
                    continue;
                }
            }
            if (obj != null) {
                System.out.println("tools read:" + listAppsFragment.toolfilesdir + "/busybox");
            }
            if (!new File(listAppsFragment.toolfilesdir + "/busybox").exists()) {
                return;
            }
            if (obj != null) {
                System.out.println("Lucky Patcher found utils.");
            } else if (obj != null) {
                System.out.println("Lucky Patcher not found busybox util.");
            }
        } else if (obj != null) {
            System.out.println("Lucky Patcher not found utils.");
        }
    }

    public static void startRootJava() {
        System.out.println("SU Java-Code Running!");
        listAppsFragment.startUnderRoot = Boolean.valueOf(true);
        listAppsFragment.toolfilesdir = "";
        File dir = new File("/data/lp");
        File utils_file = new File("/data/lp/lp_utils");
        if (utils_file.exists()) {
            String[] params = read_from_file(utils_file).split("%chelpus%");
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    switch (i) {
                        case XZ.CHECK_NONE /*0*/:
                            listAppsFragment.toolfilesdir = params[i];
                            continue;
                        case AxmlVisitor.TYPE_REFERENCE /*1*/:
                            listAppsFragment.api = Integer.parseInt(params[i]);
                            break;
                        case ValueWrapper.STYLE /*2*/:
                            break;
                        case AxmlVisitor.TYPE_STRING /*3*/:
                            break;
                        default:
                            break;
                    }
                    listAppsFragment.runtime = params[i];
                    listAppsFragment.selinux = params[i];
                    continue;
                }
            }
        }
    }

    public static ArrayList<File> getStoragesReadable() {
        ArrayList<File> start_dirs = new ArrayList();
        start_dirs.clear();
        try {
            for (Entry<String, String> entry : System.getenv().entrySet()) {
                try {
                    if (((String) entry.getKey()).toString().toLowerCase().contains("storage") && !((String) entry.getKey()).toString().toLowerCase().equals("android_storage")) {
                        File dir_for_test = new File(((String) entry.getValue()).toString());
                        if (dir_for_test.exists() && dir_for_test.canRead()) {
                            start_dirs.add(dir_for_test);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return start_dirs;
    }

    public static ArrayList<File> getStoragesWriteable() {
        ArrayList<File> start_dirs = new ArrayList();
        start_dirs.clear();
        try {
            for (Entry<String, String> entry : System.getenv().entrySet()) {
                try {
                    if (((String) entry.getKey()).toString().toLowerCase().contains("storage") && !((String) entry.getKey()).toString().toLowerCase().equals("android_storage")) {
                        File dir_for_test = new File(((String) entry.getValue()).toString());
                        if (dir_for_test.exists() && dir_for_test.canWrite()) {
                            start_dirs.add(dir_for_test);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return start_dirs;
    }

    public static boolean isMarketIntent(String action) {
        if (action.toLowerCase().equals("com.android.vending.billing.inappbillingservice.bind") || action.toLowerCase().equals("ir.cafebazaar.pardakht.inappbillingservice.bind") || action.toLowerCase().equals("com.nokia.payment.iapenabler.inappbillingservice.bind") || action.toLowerCase().equals("net.jhoobin.jhub.inappbillingservice.bind") || action.toLowerCase().equals("net.jhoobin.jhub.billing.iinappbillingservice") || action.toLowerCase().equals(listAppsFragment.class.getPackage().getName().toLowerCase())) {
            return true;
        }
        return false;
    }

    public static final boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) listAppsFragment.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static final void setIcon(int n) {
        switch (n) {
            case XZ.CHECK_NONE /*0*/:
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Original"), 1, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Flint"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-2"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-3"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-4"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-5"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-6"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-7"), 2, 1);
                try {
                    if (listAppsFragment.frag != null && listAppsFragment.api > 10) {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130837544);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    return;
                } catch (NoSuchMethodError e2) {
                    return;
                }
            case AxmlVisitor.TYPE_REFERENCE /*1*/:
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Original"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Flint"), 1, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-2"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-3"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-4"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-5"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-6"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-7"), 2, 1);
                try {
                    if (listAppsFragment.frag != null && listAppsFragment.api > 10) {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903046);
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    return;
                } catch (NoSuchMethodError e4) {
                    return;
                }
            case ValueWrapper.STYLE /*2*/:
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Original"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Flint"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-2"), 1, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-3"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-4"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-5"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-6"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-7"), 2, 1);
                try {
                    if (listAppsFragment.frag != null && listAppsFragment.api > 10) {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903047);
                        return;
                    }
                    return;
                } catch (Exception e5) {
                    return;
                } catch (NoSuchMethodError e6) {
                    return;
                }
            case AxmlVisitor.TYPE_STRING /*3*/:
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Original"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Flint"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-2"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-3"), 1, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-4"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-5"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-6"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-7"), 2, 1);
                try {
                    if (listAppsFragment.frag != null && listAppsFragment.api > 10) {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903048);
                        return;
                    }
                    return;
                } catch (Exception e7) {
                    return;
                } catch (NoSuchMethodError e8) {
                    return;
                }
            case AxmlParser.START_NS /*4*/:
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Original"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Flint"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-2"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-3"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-4"), 1, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-5"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-6"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-7"), 2, 1);
                try {
                    if (listAppsFragment.frag != null && listAppsFragment.api > 10) {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903049);
                        return;
                    }
                    return;
                } catch (Exception e9) {
                    return;
                } catch (NoSuchMethodError e10) {
                    return;
                }
            case AxmlParser.END_NS /*5*/:
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Original"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Flint"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-2"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-3"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-4"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-5"), 1, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-6"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-7"), 2, 1);
                try {
                    if (listAppsFragment.frag != null && listAppsFragment.api > 10) {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903050);
                        return;
                    }
                    return;
                } catch (Exception e11) {
                    return;
                } catch (NoSuchMethodError e12) {
                    return;
                }
            case AxmlParser.TEXT /*6*/:
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Original"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Flint"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-2"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-3"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-4"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-5"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-6"), 1, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-7"), 2, 1);
                try {
                    if (listAppsFragment.frag != null && listAppsFragment.api > 10) {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903050);
                        return;
                    }
                    return;
                } catch (Exception e13) {
                    return;
                } catch (NoSuchMethodError e14) {
                    return;
                }
            case AxmlParser.END_FILE /*7*/:
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Original"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-Flint"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-2"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-3"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-4"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-5"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-6"), 2, 1);
                listAppsFragment.getPkgMng().setComponentEnabledSetting(new ComponentName(listAppsFragment.getInstance(), "com.android.vending.billing.InAppBillingService.LOCK.MainActivity-7"), 1, 1);
                try {
                    if (listAppsFragment.frag != null && listAppsFragment.api > 10) {
                        listAppsFragment.frag.getActivity().getActionBar().setIcon(2130903050);
                        return;
                    }
                    return;
                } catch (Exception e15) {
                    return;
                } catch (NoSuchMethodError e16) {
                    return;
                }
            default:
                return;
        }
    }

    public static final void activityToFront() {
        Intent inte = new Intent(listAppsFragment.frag.getContext(), listAppsFragment.frag.getActivity().getClass());
        inte.setFlags(131072);
        listAppsFragment.frag.getContext().startActivity(inte);
    }

    public static final void turn_on_patch_on_boot(String patterns) {
        String saved = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
        if (patterns.contains("patch1")) {
            listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", saved.replaceAll("patch1", "") + "patch1").commit();
        }
        saved = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
        if (patterns.contains("patch2")) {
            listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", saved.replaceAll("patch2", "") + "patch2").commit();
        }
        saved = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
        if (patterns.contains("patch3")) {
            listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", saved.replaceAll("patch3", "") + "patch3").commit();
        }
    }

    public static final void turn_off_patch_on_boot_all() {
        listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", "").commit();
    }

    public static final void turn_off_patch_on_boot(String patterns) {
        String saved = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
        if (patterns.contains("patch1")) {
            listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", saved.replaceAll("patch1", "")).commit();
        }
        saved = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
        if (patterns.contains("patch2")) {
            listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", saved.replaceAll("patch2", "")).commit();
        }
        saved = listAppsFragment.getConfig().getString("patch_dalvik_on_boot_patterns", "");
        if (patterns.contains("patch3")) {
            listAppsFragment.getConfig().edit().putString("patch_dalvik_on_boot_patterns", saved.replaceAll("patch3", "")).commit();
        }
    }

    public static String stringModifyLastChar(String str) {
        byte[] pn = str.getBytes();
        for (int h = 0; h < pn.length; h++) {
            if (h == pn.length - 1) {
                if (pn[h] == (byte) 122) {
                    pn[h] = (byte) 65;
                } else {
                    pn[h] = (byte) (pn[h] + 1);
                }
            }
        }
        return new String(pn);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth();
        if (width <= 0) {
            width = 1;
        }
        int height = drawable.getIntrinsicHeight();
        if (height <= 0) {
            height = 1;
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
