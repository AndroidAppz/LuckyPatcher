package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;
import com.android.vending.billing.InAppBillingService.LOCK.SearchItem;
import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;

public class custompatch {
    public static boolean ART = false;
    static final int BUFFER = 2048;
    public static final byte[] MAGIC = new byte[]{(byte) 100, (byte) 101, (byte) 121, (byte) 10, (byte) 48, (byte) 51, (byte) 53, (byte) 0};
    public static boolean OdexPatch = false;
    public static int adler = 0;
    public static boolean armv7 = false;
    public static ArrayList<File> arrayFile2 = new ArrayList();
    private static final int beginTag = 0;
    public static ArrayList<File> classesFiles = new ArrayList();
    private static final int classesTag = 1;
    public static boolean convert = false;
    private static String dataBase = "";
    private static boolean dataBaseExist = false;
    public static String dir = "/sdcard/";
    public static String dir2 = "/sdcard/";
    public static String dirapp = "/data/app/";
    private static final int endTag = 4;
    private static final int fileInApkTag = 14;
    public static boolean fixunpack = false;
    public static boolean goodResult = false;
    private static String group = "";
    private static final int libTagALL = 2;
    private static final int libTagARM64V8A = 16;
    private static final int libTagARMEABI = 6;
    private static final int libTagARMEABIV7A = 7;
    private static final int libTagMIPS = 8;
    private static final int libTagx86 = 9;
    public static File localFile2 = null;
    public static String log = "";
    public static boolean manualpatch = false;
    public static boolean multidex = false;
    public static boolean multilib_patch = false;
    public static boolean odex = false;
    private static final int odexTag = 10;
    public static boolean odexpatch = false;
    private static final int odexpatchTag = 11;
    private static final int otherfilesTag = 3;
    private static final int packageTag = 5;
    private static ArrayList<PatchesItem> pat = null;
    public static boolean patchteil = false;
    public static String pkgName = "";
    public static String sddir = "/data/app/";
    private static ArrayList<Byte> search = null;
    private static String searchStr = "";
    private static ArrayList<SearchItem> ser = null;
    private static final int set_copy_file_Tag = 15;
    private static final int set_permissions_Tag = 13;
    private static final int sqlTag = 12;
    public static boolean system = false;
    public static int tag;
    public static String uid = "";
    public static boolean unpack = false;
    private static boolean withFramework = true;

    public static void addToLog(String str) {
        log += str + "\n";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r76) {
        /*
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c0 }
        r2.<init>();	 Catch:{ Exception -> 0x00c0 }
        r7 = "SU Java-Code Running! ";
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x00c0 }
        r7 = new com.chelpus.root.utils.custompatch$1;	 Catch:{ Exception -> 0x00c0 }
        r7.<init>();	 Catch:{ Exception -> 0x00c0 }
        r7 = r7.getClass();	 Catch:{ Exception -> 0x00c0 }
        r7 = r7.getEnclosingClass();	 Catch:{ Exception -> 0x00c0 }
        r7 = r7.getName();	 Catch:{ Exception -> 0x00c0 }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x00c0 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00c0 }
        addToLog(r2);	 Catch:{ Exception -> 0x00c0 }
        r2 = 0;
        com.chelpus.Utils.startRootJava(r2);	 Catch:{ Exception -> 0x00c0 }
        r2 = 0;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00c0 }
        pkgName = r2;	 Catch:{ Exception -> 0x00c0 }
        r2 = pkgName;	 Catch:{ Exception -> 0x00ba }
        com.chelpus.Utils.kill(r2);	 Catch:{ Exception -> 0x00ba }
        r2 = 2;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00ba }
        r7 = "rw";
        com.chelpus.Utils.remount(r2, r7);	 Catch:{ Exception -> 0x00ba }
    L_0x003d:
        r2 = 9;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00d4 }
        if (r2 == 0) goto L_0x0052;
    L_0x0043:
        r2 = 9;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00d4 }
        r7 = "ART";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x00d4 }
        if (r2 == 0) goto L_0x0052;
    L_0x004f:
        r2 = 1;
        ART = r2;	 Catch:{ Exception -> 0x00d4 }
    L_0x0052:
        r2 = 10;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00d4 }
        if (r2 == 0) goto L_0x005e;
    L_0x0058:
        r2 = 10;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00d4 }
        uid = r2;	 Catch:{ Exception -> 0x00d4 }
    L_0x005e:
        r2 = 11;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00d4 }
        if (r2 == 0) goto L_0x0070;
    L_0x0064:
        r2 = 11;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00d4 }
        r7 = "yes";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x00d4 }
        withFramework = r2;	 Catch:{ Exception -> 0x00d4 }
    L_0x0070:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x00d9 }
        r7 = 4;
        r7 = r76[r7];	 Catch:{ Exception -> 0x00d9 }
        r2.<init>(r7);	 Catch:{ Exception -> 0x00d9 }
        r34 = r2.listFiles();	 Catch:{ Exception -> 0x00d9 }
        r0 = r34;
        r7 = r0.length;	 Catch:{ Exception -> 0x00d9 }
        r2 = 0;
    L_0x0080:
        if (r2 >= r7) goto L_0x00dd;
    L_0x0082:
        r32 = r34[r2];	 Catch:{ Exception -> 0x00d9 }
        r8 = r32.isFile();	 Catch:{ Exception -> 0x00d9 }
        if (r8 == 0) goto L_0x00b7;
    L_0x008a:
        r8 = r32.getName();	 Catch:{ Exception -> 0x00d9 }
        r71 = "busybox";
        r0 = r71;
        r8 = r8.equals(r0);	 Catch:{ Exception -> 0x00d9 }
        if (r8 != 0) goto L_0x00b7;
    L_0x0098:
        r8 = r32.getName();	 Catch:{ Exception -> 0x00d9 }
        r71 = "reboot";
        r0 = r71;
        r8 = r8.equals(r0);	 Catch:{ Exception -> 0x00d9 }
        if (r8 != 0) goto L_0x00b7;
    L_0x00a6:
        r8 = r32.getName();	 Catch:{ Exception -> 0x00d9 }
        r71 = "dalvikvm";
        r0 = r71;
        r8 = r8.equals(r0);	 Catch:{ Exception -> 0x00d9 }
        if (r8 != 0) goto L_0x00b7;
    L_0x00b4:
        r32.delete();	 Catch:{ Exception -> 0x00d9 }
    L_0x00b7:
        r2 = r2 + 1;
        goto L_0x0080;
    L_0x00ba:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ Exception -> 0x00c0 }
        goto L_0x003d;
    L_0x00c0:
        r29 = move-exception;
        r29.printStackTrace();
    L_0x00c4:
        r2 = log;
        com.chelpus.Utils.sendFromRootCP(r2);
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r2;
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x00d4:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ Exception -> 0x00c0 }
        goto L_0x0070;
    L_0x00d9:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ Exception -> 0x00c0 }
    L_0x00dd:
        r2 = 3;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00c0 }
        sddir = r2;	 Catch:{ Exception -> 0x00c0 }
        r2 = 4;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00c0 }
        dir = r2;	 Catch:{ Exception -> 0x00c0 }
        r2 = 4;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00c0 }
        dir2 = r2;	 Catch:{ Exception -> 0x00c0 }
        r2 = 2;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00c0 }
        dirapp = r2;	 Catch:{ Exception -> 0x00c0 }
        clearTemp();	 Catch:{ Exception -> 0x00c0 }
        r22 = "";
        r35 = "";
        r15 = "";
        r31 = 0;
        r30 = 0;
        r21 = 0;
        r2 = 6;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00c0 }
        r7 = "not_system";
        r2 = r2.equals(r7);	 Catch:{ Exception -> 0x00c0 }
        if (r2 == 0) goto L_0x010e;
    L_0x010b:
        r2 = 0;
        system = r2;	 Catch:{ Exception -> 0x00c0 }
    L_0x010e:
        r2 = 6;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00c0 }
        r7 = "system";
        r2 = r2.equals(r7);	 Catch:{ Exception -> 0x00c0 }
        if (r2 == 0) goto L_0x011c;
    L_0x0119:
        r2 = 1;
        system = r2;	 Catch:{ Exception -> 0x00c0 }
    L_0x011c:
        r2 = system;	 Catch:{ Exception -> 0x00c0 }
        if (r2 == 0) goto L_0x014f;
    L_0x0120:
        r10 = new java.io.File;	 Catch:{ Exception -> 0x00c0 }
        r2 = dirapp;	 Catch:{ Exception -> 0x00c0 }
        r10.<init>(r2);	 Catch:{ Exception -> 0x00c0 }
        r11 = new java.io.File;	 Catch:{ Exception -> 0x00c0 }
        r2 = dirapp;	 Catch:{ Exception -> 0x00c0 }
        r7 = 1;
        r2 = com.chelpus.Utils.getPlaceForOdex(r2, r7);	 Catch:{ Exception -> 0x00c0 }
        r11.<init>(r2);	 Catch:{ Exception -> 0x00c0 }
        r2 = r10.exists();	 Catch:{ Exception -> 0x00c0 }
        if (r2 == 0) goto L_0x014f;
    L_0x0139:
        r2 = r11.exists();	 Catch:{ Exception -> 0x00c0 }
        if (r2 == 0) goto L_0x014f;
    L_0x013f:
        r2 = com.chelpus.Utils.classes_test(r10);	 Catch:{ Exception -> 0x00c0 }
        if (r2 != 0) goto L_0x014f;
    L_0x0145:
        r2 = 1;
        odexpatch = r2;	 Catch:{ Exception -> 0x00c0 }
        localFile2 = r11;	 Catch:{ Exception -> 0x00c0 }
        r2 = "\nOdex Application.\nOnly ODEX patch is enabled.\n";
        addToLog(r2);	 Catch:{ Exception -> 0x00c0 }
    L_0x014f:
        r44 = "";
        r2 = 0;
        OdexPatch = r2;	 Catch:{ Exception -> 0x00c0 }
        r37 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0197 }
        r2 = 1;
        r2 = r76[r2];	 Catch:{ IOException -> 0x0197 }
        r0 = r37;
        r0.<init>(r2);	 Catch:{ IOException -> 0x0197 }
        r39 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0197 }
        r2 = "UTF-8";
        r0 = r39;
        r1 = r37;
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0197 }
        r17 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0197 }
        r0 = r17;
        r1 = r39;
        r0.<init>(r1);	 Catch:{ IOException -> 0x0197 }
    L_0x0172:
        r44 = r17.readLine();	 Catch:{ IOException -> 0x0197 }
        if (r44 == 0) goto L_0x0951;
    L_0x0178:
        r2 = r44.toUpperCase();	 Catch:{ IOException -> 0x0197 }
        r7 = "[ODEX-PATCH]";
        r2 = r2.contains(r7);	 Catch:{ IOException -> 0x0197 }
        if (r2 == 0) goto L_0x0187;
    L_0x0184:
        r2 = 1;
        OdexPatch = r2;	 Catch:{ IOException -> 0x0197 }
    L_0x0187:
        r2 = r44.toUpperCase();	 Catch:{ IOException -> 0x0197 }
        r7 = "[LIB-ARMEABI-V7A]";
        r2 = r2.contains(r7);	 Catch:{ IOException -> 0x0197 }
        if (r2 == 0) goto L_0x0172;
    L_0x0193:
        r2 = 1;
        armv7 = r2;	 Catch:{ IOException -> 0x0197 }
        goto L_0x0172;
    L_0x0197:
        r2 = move-exception;
    L_0x0198:
        r2 = 2;
        r2 = r76[r2];	 Catch:{ Exception -> 0x00c0 }
        searchDalvik(r2);	 Catch:{ Exception -> 0x00c0 }
        r36 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 1;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r36;
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r38 = new java.io.InputStreamReader;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "UTF-8";
        r0 = r38;
        r1 = r36;
        r0.<init>(r1, r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r16 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r16;
        r1 = r38;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r23 = "";
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r66 = r0;
        r2 = 1;
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r52 = r0;
        r2 = 0;
        r7 = "";
        r52[r2] = r7;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r3 = 0;
        r4 = 0;
        r33 = "";
        r56 = "";
        r54 = "";
        r60 = 1;
        r64 = 1;
        r43 = 0;
        r14 = 0;
        r48 = 0;
        r53 = 0;
        r55 = 0;
        r20 = 0;
        r67 = "";
        r68 = "";
        r69 = "";
        r2 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        pat = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        ser = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        search = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r57 = 0;
    L_0x0202:
        r23 = r16.readLine();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r23 == 0) goto L_0x1872;
    L_0x0208:
        r2 = "";
        r0 = r23;
        r2 = r0.equals(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x021a;
    L_0x0212:
        r2 = pkgName;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r23;
        r23 = com.chelpus.Utils.apply_TAGS(r0, r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x021a:
        r66[r57] = r23;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[PACKAGE]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x02e5;
    L_0x022a:
        r2 = 5;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 1;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 2;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r9.<init>(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r9.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0264;
    L_0x023e:
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 2;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "-1/";
        r8 = "-2/";
        r2 = r2.replace(r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r9.<init>(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r9.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0264;
    L_0x0254:
        r2 = 2;
        r7 = 2;
        r7 = r76[r7];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "-1/";
        r71 = "-2/";
        r0 = r71;
        r7 = r7.replace(r8, r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r76[r2] = r7;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0264:
        r2 = r9.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0290;
    L_0x026a:
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 2;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "-1/";
        r8 = "/";
        r2 = r2.replace(r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r9.<init>(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r9.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0290;
    L_0x0280:
        r2 = 2;
        r7 = 2;
        r7 = r76[r7];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "-1/";
        r71 = "";
        r0 = r71;
        r7 = r7.replace(r8, r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r76[r2] = r7;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0290:
        unzip(r9);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = odexpatch;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x02e5;
    L_0x0297:
        r2 = OdexPatch;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x02e5;
    L_0x029b:
        r2 = 2;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 1;
        r50 = com.chelpus.Utils.getPlaceForOdex(r2, r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r49 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r49.<init>(r50);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r49.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x02b1;
    L_0x02ae:
        r49.delete();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x02b1:
        r49 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "-1";
        r7 = "-2";
        r0 = r50;
        r2 = r0.replace(r2, r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r49;
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r49.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x02cb;
    L_0x02c8:
        r49.delete();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x02cb:
        r49 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "-2";
        r7 = "-1";
        r0 = r50;
        r2 = r0.replace(r2, r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r49;
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r49.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x02e5;
    L_0x02e2:
        r49.delete();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x02e5:
        if (r14 == 0) goto L_0x0322;
    L_0x02e7:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0305;
    L_0x02f1:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0305;
    L_0x02fb:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0322;
    L_0x0305:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r15);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r14 = 0;
    L_0x0322:
        if (r14 == 0) goto L_0x033d;
    L_0x0324:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r15);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r15 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x033d:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0356;
    L_0x0347:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0356;
    L_0x0351:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        switch(r2) {
            case 1: goto L_0x0959;
            case 2: goto L_0x0b87;
            case 3: goto L_0x0ee7;
            case 4: goto L_0x0356;
            case 5: goto L_0x0356;
            case 6: goto L_0x0c17;
            case 7: goto L_0x0ca7;
            case 8: goto L_0x0dc7;
            case 9: goto L_0x0e57;
            case 10: goto L_0x0aff;
            case 11: goto L_0x0f14;
            case 12: goto L_0x0f92;
            case 13: goto L_0x0fa9;
            case 14: goto L_0x1147;
            case 15: goto L_0x1011;
            case 16: goto L_0x0d37;
            default: goto L_0x0356;
        };	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0356:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[BEGIN]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0368;
    L_0x0364:
        r2 = 0;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r14 = 1;
    L_0x0368:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[CLASSES]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x039f;
    L_0x0376:
        r2 = 1;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = unpack;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x039f;
    L_0x037d:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = dir;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "classes.dex";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x039f:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[ODEX]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x03b1;
    L_0x03ad:
        r2 = 10;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x03b1:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[SQLITE]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x03c3;
    L_0x03bf:
        r2 = 12;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x03c3:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 12;
        if (r2 != r7) goto L_0x0512;
    L_0x03c9:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "database";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x04c5;
    L_0x03dd:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1166 }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x1166 }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1166 }
        r2 = "database";
        r0 = r40;
        r67 = r0.getString(r2);	 Catch:{ JSONException -> 0x1166 }
        r25 = new java.io.File;	 Catch:{ JSONException -> 0x1166 }
        r0 = r25;
        r1 = r67;
        r0.<init>(r1);	 Catch:{ JSONException -> 0x1166 }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ JSONException -> 0x1166 }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ JSONException -> 0x1166 }
        r7 = 1;
        r8 = "777";
        r2[r7] = r8;	 Catch:{ JSONException -> 0x1166 }
        r7 = 2;
        r2[r7] = r67;	 Catch:{ JSONException -> 0x1166 }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ JSONException -> 0x1166 }
        r2 = withFramework;	 Catch:{ JSONException -> 0x1166 }
        if (r2 != 0) goto L_0x0435;
    L_0x040e:
        r2 = new java.io.File;	 Catch:{ JSONException -> 0x1166 }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x1166 }
        r7.<init>();	 Catch:{ JSONException -> 0x1166 }
        r8 = dir;	 Catch:{ JSONException -> 0x1166 }
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x1166 }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x1166 }
        r8 = r25.getName();	 Catch:{ JSONException -> 0x1166 }
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x1166 }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x1166 }
        r2.<init>(r7);	 Catch:{ JSONException -> 0x1166 }
        r0 = r25;
        com.chelpus.Utils.copyFile(r0, r2);	 Catch:{ JSONException -> 0x1166 }
    L_0x0435:
        r2 = r25.exists();	 Catch:{ JSONException -> 0x1166 }
        if (r2 != 0) goto L_0x1161;
    L_0x043b:
        r2 = 0;
        localFile2 = r2;	 Catch:{ JSONException -> 0x1166 }
        r2 = 0;
        r2 = r76[r2];	 Catch:{ JSONException -> 0x1166 }
        r7 = r25.getName();	 Catch:{ JSONException -> 0x1166 }
        searchfile(r2, r7);	 Catch:{ JSONException -> 0x1166 }
        r2 = localFile2;	 Catch:{ JSONException -> 0x1166 }
        if (r2 == 0) goto L_0x115d;
    L_0x044c:
        r2 = localFile2;	 Catch:{ JSONException -> 0x1166 }
        r2 = r2.exists();	 Catch:{ JSONException -> 0x1166 }
        if (r2 == 0) goto L_0x115d;
    L_0x0454:
        r25 = localFile2;	 Catch:{ JSONException -> 0x1166 }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ JSONException -> 0x1166 }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ JSONException -> 0x1166 }
        r7 = 1;
        r8 = "777";
        r2[r7] = r8;	 Catch:{ JSONException -> 0x1166 }
        r7 = 2;
        r2[r7] = r67;	 Catch:{ JSONException -> 0x1166 }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ JSONException -> 0x1166 }
        r2 = withFramework;	 Catch:{ JSONException -> 0x1166 }
        if (r2 != 0) goto L_0x0494;
    L_0x046d:
        r2 = new java.io.File;	 Catch:{ JSONException -> 0x1166 }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x1166 }
        r7.<init>();	 Catch:{ JSONException -> 0x1166 }
        r8 = dir;	 Catch:{ JSONException -> 0x1166 }
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x1166 }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x1166 }
        r8 = r25.getName();	 Catch:{ JSONException -> 0x1166 }
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x1166 }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x1166 }
        r2.<init>(r7);	 Catch:{ JSONException -> 0x1166 }
        r0 = r25;
        com.chelpus.Utils.copyFile(r0, r2);	 Catch:{ JSONException -> 0x1166 }
    L_0x0494:
        r2 = 1;
        dataBaseExist = r2;	 Catch:{ JSONException -> 0x1166 }
    L_0x0497:
        r2 = dataBaseExist;	 Catch:{ JSONException -> 0x1166 }
        if (r2 == 0) goto L_0x04a1;
    L_0x049b:
        r2 = r25.getAbsolutePath();	 Catch:{ JSONException -> 0x1166 }
        dataBase = r2;	 Catch:{ JSONException -> 0x1166 }
    L_0x04a1:
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ JSONException -> 0x1166 }
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x1166 }
        r2.<init>();	 Catch:{ JSONException -> 0x1166 }
        r7 = "Open SqLite database\n";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x1166 }
        r7 = r25.getAbsolutePath();	 Catch:{ JSONException -> 0x1166 }
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x1166 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x1166 }
        addToLog(r2);	 Catch:{ JSONException -> 0x1166 }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ JSONException -> 0x1166 }
    L_0x04c5:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "execute";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0512;
    L_0x04cf:
        r2 = dataBaseExist;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0512;
    L_0x04d3:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x118b }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x118b }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x118b }
        r2 = "execute";
        r0 = r40;
        r67 = r0.getString(r2);	 Catch:{ JSONException -> 0x118b }
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x118b }
        r2.<init>();	 Catch:{ JSONException -> 0x118b }
        r7 = "Execute:\n";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x118b }
        r0 = r67;
        r2 = r2.append(r0);	 Catch:{ JSONException -> 0x118b }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x118b }
        addToLog(r2);	 Catch:{ JSONException -> 0x118b }
        r2 = withFramework;	 Catch:{ JSONException -> 0x118b }
        if (r2 == 0) goto L_0x0512;
    L_0x0500:
        r2 = dataBase;	 Catch:{ Exception -> 0x116e, FileNotFoundException -> 0x09b3 }
        r7 = 0;
        r8 = 0;
        r26 = android.database.sqlite.SQLiteDatabase.openDatabase(r2, r7, r8);	 Catch:{ Exception -> 0x116e, FileNotFoundException -> 0x09b3 }
        r0 = r26;
        r1 = r67;
        r0.execSQL(r1);	 Catch:{ Exception -> 0x116e, FileNotFoundException -> 0x09b3 }
        r26.close();	 Catch:{ Exception -> 0x116e, FileNotFoundException -> 0x09b3 }
    L_0x0512:
        if (r53 == 0) goto L_0x0561;
    L_0x0514:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1193 }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x1193 }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1193 }
        r2 = "name";
        r0 = r40;
        r67 = r0.getString(r2);	 Catch:{ JSONException -> 0x1193 }
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ JSONException -> 0x1193 }
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x1193 }
        r2.<init>();	 Catch:{ JSONException -> 0x1193 }
        r7 = "Patch for file \n";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x1193 }
        r0 = r67;
        r2 = r2.append(r0);	 Catch:{ JSONException -> 0x1193 }
        r7 = ":";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x1193 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x1193 }
        addToLog(r2);	 Catch:{ JSONException -> 0x1193 }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ JSONException -> 0x1193 }
    L_0x0557:
        r2 = 0;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r67;
        searchfile(r2, r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r53 = 0;
    L_0x0561:
        if (r55 == 0) goto L_0x05bf;
    L_0x0563:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "file_name";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0586;
    L_0x056d:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x119b }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x119b }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x119b }
        r2 = "file_name";
        r0 = r40;
        r33 = r0.getString(r2);	 Catch:{ JSONException -> 0x119b }
    L_0x057e:
        r2 = 0;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r33;
        searchfile(r2, r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0586:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "permissions";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x05bf;
    L_0x0590:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x05bf;
    L_0x059a:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x05bf;
    L_0x05a4:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x05bf;
    L_0x05ae:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x11a6 }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x11a6 }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x11a6 }
        r2 = "permissions";
        r0 = r40;
        r56 = r0.getString(r2);	 Catch:{ JSONException -> 0x11a6 }
    L_0x05bf:
        if (r20 == 0) goto L_0x0615;
    L_0x05c1:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "file_name";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x05dc;
    L_0x05cb:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x11ae }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x11ae }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x11ae }
        r2 = "file_name";
        r0 = r40;
        r33 = r0.getString(r2);	 Catch:{ JSONException -> 0x11ae }
    L_0x05dc:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "\"to\":";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0615;
    L_0x05e6:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0615;
    L_0x05f0:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0615;
    L_0x05fa:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0615;
    L_0x0604:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x11b9 }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x11b9 }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x11b9 }
        r2 = "to";
        r0 = r40;
        r54 = r0.getString(r2);	 Catch:{ JSONException -> 0x11b9 }
    L_0x0615:
        if (r43 == 0) goto L_0x0647;
    L_0x0617:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x11c1 }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x11c1 }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x11c1 }
        r2 = "name";
        r0 = r40;
        r67 = r0.getString(r2);	 Catch:{ JSONException -> 0x11c1 }
    L_0x0632:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 2;
        r7 = r76[r7];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r67;
        r2 = searchlib(r2, r0, r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        arrayFile2 = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 0;
    L_0x0647:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[LIB]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0666;
    L_0x0655:
        r2 = 2;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 1;
        r53 = 0;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x0666:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[LIB-ARMEABI]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x06a7;
    L_0x0674:
        r2 = 7;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "armeabi";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0696;
    L_0x0683:
        r2 = 7;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "armeabi-v7a";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x11c9;
    L_0x0692:
        r2 = armv7;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x11c9;
    L_0x0696:
        r2 = 6;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 1;
        r53 = 0;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x06a7:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[LIB-ARMEABI-V7A]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x06d5;
    L_0x06b5:
        r2 = 7;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "armeabi-v7a";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x11cf;
    L_0x06c4:
        r2 = 7;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 1;
        r53 = 0;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x06d5:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[LIB-ARM64-V8A]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0704;
    L_0x06e3:
        r2 = 7;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "arm64-v8a";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x11d5;
    L_0x06f2:
        r2 = 16;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 1;
        r53 = 0;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x0704:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[LIB-MIPS]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0733;
    L_0x0712:
        r2 = 7;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "mips";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x11db;
    L_0x0721:
        r2 = 8;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 1;
        r53 = 0;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x0733:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[LIB-X86]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0762;
    L_0x0741:
        r2 = 7;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "x86";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x11e1;
    L_0x0750:
        r2 = 9;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 1;
        r53 = 0;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x0762:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[OTHER FILES]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0781;
    L_0x0770:
        r2 = 3;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 0;
        r53 = 1;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x0781:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[SET_PERMISSIONS]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x07a1;
    L_0x078f:
        r2 = 13;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 0;
        r53 = 0;
        r55 = 1;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x07a1:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[COPY_FILE]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x07c1;
    L_0x07af:
        r2 = 15;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 0;
        r53 = 0;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 1;
    L_0x07c1:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[ODEX-PATCH]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x07e1;
    L_0x07cf:
        r2 = 11;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
        r43 = 0;
        r53 = 0;
        r55 = 0;
        r2 = 1;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x07e1:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[FILE_IN_APK]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0801;
    L_0x07ef:
        r2 = 14;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r43 = 0;
        r53 = 0;
        r55 = 0;
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r20 = 0;
    L_0x0801:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "group";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0832;
    L_0x080b:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0832;
    L_0x0815:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0832;
    L_0x081f:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x11e7 }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x11e7 }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x11e7 }
        r2 = "group";
        r0 = r40;
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x11e7 }
        group = r2;	 Catch:{ JSONException -> 0x11e7 }
    L_0x0832:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "original";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1223;
    L_0x083c:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1223;
    L_0x0846:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1223;
    L_0x0850:
        if (r48 == 0) goto L_0x0877;
    L_0x0852:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 1;
        if (r2 != r7) goto L_0x11f3;
    L_0x0857:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x085d:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x0877;
    L_0x0863:
        r18 = r2.next();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r18 = (java.io.File) r18;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r18;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = searchProcess(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x085d;
    L_0x0873:
        r64 = 1;
        r48 = 0;
    L_0x0877:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x11fd }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x11fd }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x11fd }
        r2 = "original";
        r0 = r40;
        r67 = r0.getString(r2);	 Catch:{ JSONException -> 0x11fd }
    L_0x0888:
        r67 = r67.trim();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = convert;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0894;
    L_0x0890:
        r67 = com.chelpus.Utils.rework(r67);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0894:
        r2 = "[ \t]+";
        r0 = r67;
        r2 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r52 = r0;
        r2 = "[ \t]+";
        r0 = r67;
        r52 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r52;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r4 = new int[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r52;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r3 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r65 = 0;
    L_0x08b5:
        r0 = r52;
        r2 = r0.length;	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r0 = r65;
        if (r0 >= r2) goto L_0x1223;
    L_0x08bc:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "*";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x08d6;
    L_0x08c6:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x08d6;
    L_0x08d0:
        r31 = 1;
        r2 = "60";
        r52[r65] = r2;	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
    L_0x08d6:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x08ea;
    L_0x08e0:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "\\?+";
        r2 = r2.matches(r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1205;
    L_0x08ea:
        r2 = "60";
        r52[r65] = r2;	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r2 = 1;
        r4[r65] = r2;	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
    L_0x08f1:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "W";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x0919;
    L_0x08fb:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "w";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x0919;
    L_0x0905:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x0919;
    L_0x090f:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "r";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x093f;
    L_0x0919:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "w";
        r8 = "";
        r2 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = "r";
        r8 = "";
        r51 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r2 = java.lang.Integer.valueOf(r51);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r70 = r2.intValue();	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r70 = r70 + 2;
        r4[r65] = r70;	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r2 = "60";
        r52[r65] = r2;	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
    L_0x093f:
        r2 = r52[r65];	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r7 = 16;
        r2 = java.lang.Integer.valueOf(r2, r7);	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r2 = r2.byteValue();	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r3[r65] = r2;	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        r65 = r65 + 1;
        goto L_0x08b5;
    L_0x0951:
        r17.close();	 Catch:{ IOException -> 0x0197 }
        r37.close();	 Catch:{ IOException -> 0x0197 }
        goto L_0x0198;
    L_0x0959:
        r2 = odexpatch;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x09bb;
    L_0x095d:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = dirapp;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0356;
    L_0x0973:
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "classes.dex not found!\nApply patch for odex:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0991;
    L_0x098c:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0991:
        r2 = manualpatch;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x099b;
    L_0x0995:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x099b:
        if (r60 != 0) goto L_0x099f;
    L_0x099d:
        r64 = 0;
    L_0x099f:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x09b3:
        r29 = move-exception;
        r2 = "Custom Patch not Found. Put info about SuperSu.";
        addToLog(r2);	 Catch:{ Exception -> 0x00c0 }
        goto L_0x00c4;
    L_0x09bb:
        r2 = unpack;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0a69;
    L_0x09bf:
        r2 = 2;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        searchDalvik(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = dirapp;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0a03;
    L_0x09d7:
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.getName();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = ".odex";
        r2 = r2.endsWith(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0a03;
    L_0x09e5:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = dirapp;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.delete();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "odex file removed before\npatch for dalvik-cache...";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0a03:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0356;
    L_0x0a0b:
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Patch for dalvik-cache:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0a29;
    L_0x0a24:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0a29:
        r2 = manualpatch;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0a33;
    L_0x0a2d:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0a33:
        if (r60 != 0) goto L_0x0a37;
    L_0x0a35:
        r64 = 0;
    L_0x0a37:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0a4b:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ Exception -> 0x00c0 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c0 }
        r2.<init>();	 Catch:{ Exception -> 0x00c0 }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x00c0 }
        r0 = r29;
        r2 = r2.append(r0);	 Catch:{ Exception -> 0x00c0 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00c0 }
        addToLog(r2);	 Catch:{ Exception -> 0x00c0 }
        goto L_0x00c4;
    L_0x0a69:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0356;
    L_0x0a6d:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0356;
    L_0x0a75:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 1;
        if (r2 <= r7) goto L_0x0a81;
    L_0x0a7e:
        r2 = 1;
        multidex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0a81:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0a87:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x0ae5;
    L_0x0a8d:
        r18 = r2.next();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r18 = (java.io.File) r18;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r18;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 <= 0) goto L_0x0a87;
    L_0x0a9d:
        r7 = "---------------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "Patch for ";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r18.getName();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 != 0) goto L_0x0ad6;
    L_0x0ad1:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0ad6:
        r7 = manualpatch;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 != 0) goto L_0x0ae0;
    L_0x0ada:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0ae0:
        if (r60 != 0) goto L_0x0a87;
    L_0x0ae2:
        r64 = 0;
        goto L_0x0a87;
    L_0x0ae5:
        r2 = 0;
        multidex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0aff:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0b32;
    L_0x0b0a:
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Dalvik-cache fixed to odex!\nPatch for odex:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0b28;
    L_0x0b23:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0b28:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r60 != 0) goto L_0x0b32;
    L_0x0b30:
        r64 = 0;
    L_0x0b32:
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Dalvik-cache fixed to odex!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0b50;
    L_0x0b4b:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0b50:
        r2 = unpack;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0b5a;
    L_0x0b54:
        r2 = 2;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        searchDalvik(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0b5a:
        r2 = 0;
        r2 = r76[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 2;
        r7 = r76[r7];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        searchDalvikOdex(r2, r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0b73;
    L_0x0b6b:
        r21 = 1;
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r22 = r2.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0b73:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0b87:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0c03;
    L_0x0b92:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0c03;
    L_0x0b96:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0c03;
    L_0x0b9e:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0ba4:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x0bf8;
    L_0x0baa:
        r42 = r2.next();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r42 = (java.io.File) r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "Patch for libraries \n";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 != 0) goto L_0x0bed;
    L_0x0be8:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0bed:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r60 != 0) goto L_0x0ba4;
    L_0x0bf5:
        r64 = 0;
        goto L_0x0ba4;
    L_0x0bf8:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0c03:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0c17:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0c93;
    L_0x0c22:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0c93;
    L_0x0c26:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0c93;
    L_0x0c2e:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0c34:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x0c88;
    L_0x0c3a:
        r42 = r2.next();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r42 = (java.io.File) r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "--------------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "Patch for (armeabi) libraries \n";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "--------------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 != 0) goto L_0x0c7d;
    L_0x0c78:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0c7d:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r60 != 0) goto L_0x0c34;
    L_0x0c85:
        r64 = 0;
        goto L_0x0c34;
    L_0x0c88:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0c93:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0ca7:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0d23;
    L_0x0cb2:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0d23;
    L_0x0cb6:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0d23;
    L_0x0cbe:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0cc4:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x0d18;
    L_0x0cca:
        r42 = r2.next();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r42 = (java.io.File) r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "Patch for (armeabi-v7a) libraries \n";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 != 0) goto L_0x0d0d;
    L_0x0d08:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0d0d:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r60 != 0) goto L_0x0cc4;
    L_0x0d15:
        r64 = 0;
        goto L_0x0cc4;
    L_0x0d18:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0d23:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0d37:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0db3;
    L_0x0d42:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0db3;
    L_0x0d46:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0db3;
    L_0x0d4e:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0d54:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x0da8;
    L_0x0d5a:
        r42 = r2.next();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r42 = (java.io.File) r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "Patch for (arm64-v8a) libraries \n";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 != 0) goto L_0x0d9d;
    L_0x0d98:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0d9d:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r60 != 0) goto L_0x0d54;
    L_0x0da5:
        r64 = 0;
        goto L_0x0d54;
    L_0x0da8:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0db3:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0dc7:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0e43;
    L_0x0dd2:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0e43;
    L_0x0dd6:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0e43;
    L_0x0dde:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0de4:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x0e38;
    L_0x0dea:
        r42 = r2.next();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r42 = (java.io.File) r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "Patch for (MIPS) libraries \n";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 != 0) goto L_0x0e2d;
    L_0x0e28:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0e2d:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r60 != 0) goto L_0x0de4;
    L_0x0e35:
        r64 = 0;
        goto L_0x0de4;
    L_0x0e38:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0e43:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0e57:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0ed3;
    L_0x0e62:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0ed3;
    L_0x0e66:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0ed3;
    L_0x0e6e:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0e74:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 == 0) goto L_0x0ec8;
    L_0x0e7a:
        r42 = r2.next();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r42 = (java.io.File) r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r42;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "Patch for (x86) libraries \n";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "---------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r7 != 0) goto L_0x0ebd;
    L_0x0eb8:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0ebd:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r60 != 0) goto L_0x0e74;
    L_0x0ec5:
        r64 = 0;
        goto L_0x0e74;
    L_0x0ec8:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0ed3:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0ee7:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0f00;
    L_0x0ef2:
        r2 = manualpatch;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0efc;
    L_0x0ef6:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0efc:
        if (r60 != 0) goto L_0x0f00;
    L_0x0efe:
        r64 = 0;
    L_0x0f00:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0f14:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Patch for odex:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0f35;
    L_0x0f30:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0f35:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = dirapp;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        localFile2 = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x0f50;
    L_0x0f4b:
        r2 = "Odex not found! Please use befor other Patch, and after run Custom Patch!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0f50:
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r72 = r2.length();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r74 = 0;
        r2 = (r72 > r74 ? 1 : (r72 == r74 ? 0 : -1));
        if (r2 != 0) goto L_0x0f66;
    L_0x0f5c:
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.delete();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Odex not found! Please use befor other Patch, and after run Custom Patch!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x0f66:
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 0;
        odex = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 <= 0) goto L_0x0f7e;
    L_0x0f74:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r60 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r60 != 0) goto L_0x0f7e;
    L_0x0f7c:
        r64 = 0;
    L_0x0f7e:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0f92:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x0fa9:
        r55 = 0;
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x0356;
    L_0x0fb3:
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "Set permissions ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r56;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " for file:\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r33;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 1;
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r71 = "";
        r0 = r71;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r56;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 2;
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x1011:
        r20 = 0;
        r61 = "";
        if (r33 == 0) goto L_0x10b9;
    L_0x1017:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r33;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x10b9;
    L_0x1024:
        r61 = r33;
    L_0x1026:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r54;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r27 = com.chelpus.Utils.getDirs(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r27.mkdirs();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 1;
        r8 = "777";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 2;
        r8 = r27.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r28 = r27.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "Copy file ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r33;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " to:\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r54;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r61;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x10d6;
    L_0x108a:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "Error: File ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r33;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " not found to dir\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r61;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = com.chelpus.Utils.getDirs(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x10b9:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = sddir;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "/";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r33;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r61 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x1026;
    L_0x10d6:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r61;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r54;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        com.chelpus.Utils.copyFile(r2, r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r54;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1141;
    L_0x10f4:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r54;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r72 = r2.length();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = sddir;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r33;
        r7 = r7.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r74 = r2.length();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = (r72 > r74 ? 1 : (r72 == r74 ? 0 : -1));
        if (r2 != 0) goto L_0x1141;
    L_0x1127:
        r2 = "File copied success.";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x112c:
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 1;
        r8 = "777";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 2;
        r2[r7] = r54;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x1141:
        r2 = "File copied with error. Try again.";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x112c;
    L_0x1147:
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Patch for file from apk:\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "You must run rebuild for this application with custom patch, then patch will work.\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0356;
    L_0x115d:
        r67 = "Error LP: File of Database not Found!";
        goto L_0x0497;
    L_0x1161:
        r2 = 1;
        dataBaseExist = r2;	 Catch:{ JSONException -> 0x1166 }
        goto L_0x0497;
    L_0x1166:
        r29 = move-exception;
        r2 = "Error LP: Error Name of Database read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x04c5;
    L_0x116e:
        r29 = move-exception;
        r2 = java.lang.System.out;	 Catch:{ JSONException -> 0x118b }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x118b }
        r7.<init>();	 Catch:{ JSONException -> 0x118b }
        r8 = "LuckyPatcher: SQL error - ";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x118b }
        r0 = r29;
        r7 = r7.append(r0);	 Catch:{ JSONException -> 0x118b }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x118b }
        r2.println(r7);	 Catch:{ JSONException -> 0x118b }
        goto L_0x0512;
    L_0x118b:
        r29 = move-exception;
        r2 = "Error LP: Error SQL exec read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0512;
    L_0x1193:
        r29 = move-exception;
        r2 = "Error LP: Error name of file read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0557;
    L_0x119b:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Error LP: Error name of file read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x057e;
    L_0x11a6:
        r29 = move-exception;
        r2 = "Error LP: Error permissions read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x05bf;
    L_0x11ae:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Error LP: Error name of file read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x05dc;
    L_0x11b9:
        r29 = move-exception;
        r2 = "Error LP: Error file copy read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0615;
    L_0x11c1:
        r29 = move-exception;
        r2 = "Error LP: Error name of libraries read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0632;
    L_0x11c9:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x06a7;
    L_0x11cf:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x06d5;
    L_0x11d5:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0704;
    L_0x11db:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0733;
    L_0x11e1:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0762;
    L_0x11e7:
        r29 = move-exception;
        r2 = "Error LP: Error original hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        group = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0832;
    L_0x11f3:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r64 = searchProcess(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r48 = 0;
        goto L_0x0877;
    L_0x11fd:
        r29 = move-exception;
        r2 = "Error LP: Error original hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x0888;
    L_0x1205:
        r2 = 0;
        r4[r65] = r2;	 Catch:{ Exception -> 0x120a, FileNotFoundException -> 0x09b3 }
        goto L_0x08f1;
    L_0x120a:
        r29 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r29;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1223:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "\"object\"";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x12dc;
    L_0x122d:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x12dc;
    L_0x1237:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x12dc;
    L_0x1241:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x13ad }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x13ad }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x13ad }
        r2 = "object";
        r0 = r40;
        r69 = r0.getString(r2);	 Catch:{ JSONException -> 0x13ad }
    L_0x1252:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "dalvikvm -Xverify:none -Xdexopt:none -cp ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 5;
        r7 = r76[r7];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 8;
        r7 = r76[r7];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = ".nerorunpatch ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 0;
        r7 = r76[r7];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "object";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r69;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r19 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r19;
        r47 = r2.exec(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r47.waitFor();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r46 = new java.io.DataInputStream;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r47.getInputStream();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r46;
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r46.available();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r13 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r46;
        r0.read(r13);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r62 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r62;
        r0.<init>(r13);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r47.destroy();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "Done";
        r0 = r62;
        r2 = r0.contains(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x13b5;
    L_0x12d2:
        r63 = "Object patched!\n\n";
        addToLog(r63);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r64 = 1;
    L_0x12d9:
        r2 = 1;
        manualpatch = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x12dc:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "search";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x13ec;
    L_0x12e6:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x13ec;
    L_0x12f0:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x13ec;
    L_0x12fa:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x13be }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x13be }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x13be }
        r2 = "search";
        r0 = r40;
        r69 = r0.getString(r2);	 Catch:{ JSONException -> 0x13be }
    L_0x130b:
        r69 = r69.trim();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = convert;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1317;
    L_0x1313:
        r69 = com.chelpus.Utils.rework(r69);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1317:
        r2 = "[ \t]+";
        r0 = r69;
        r2 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r52 = r0;
        r2 = "[ \t]+";
        r0 = r69;
        r52 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r52;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r4 = new int[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r52;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r3 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r65 = 0;
    L_0x1338:
        r0 = r52;
        r2 = r0.length;	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r0 = r65;
        if (r0 >= r2) goto L_0x13e3;
    L_0x133f:
        r2 = r52[r65];	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r7 = "*";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1359;
    L_0x1349:
        r2 = r52[r65];	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x1359;
    L_0x1353:
        r31 = 1;
        r2 = "60";
        r52[r65] = r2;	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
    L_0x1359:
        r2 = r52[r65];	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x136d;
    L_0x1363:
        r2 = r52[r65];	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r7 = "\\?+";
        r2 = r2.matches(r7);	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x13c6;
    L_0x136d:
        r2 = "60";
        r52[r65] = r2;	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r2 = 1;
        r4[r65] = r2;	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
    L_0x1374:
        r2 = r52[r65];	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r2 = r2.toUpperCase();	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x139c;
    L_0x1382:
        r2 = r52[r65];	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r7 = "R";
        r8 = "";
        r51 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r2 = java.lang.Integer.valueOf(r51);	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r70 = r2.intValue();	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r70 = r70 + 2;
        r4[r65] = r70;	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r2 = "60";
        r52[r65] = r2;	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
    L_0x139c:
        r2 = r52[r65];	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r7 = 16;
        r2 = java.lang.Integer.valueOf(r2, r7);	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r2 = r2.byteValue();	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r3[r65] = r2;	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        r65 = r65 + 1;
        goto L_0x1338;
    L_0x13ad:
        r29 = move-exception;
        r2 = "Error LP: Error number by object!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x1252;
    L_0x13b5:
        r63 = "Object not found!\n\n";
        addToLog(r63);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r64 = 0;
        goto L_0x12d9;
    L_0x13be:
        r29 = move-exception;
        r2 = "Error LP: Error search hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x130b;
    L_0x13c6:
        r2 = 0;
        r4[r65] = r2;	 Catch:{ Exception -> 0x13ca, FileNotFoundException -> 0x09b3 }
        goto L_0x1374;
    L_0x13ca:
        r29 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r29;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x13e3:
        if (r31 == 0) goto L_0x1532;
    L_0x13e5:
        r60 = 0;
        r2 = "Error LP: Patterns to search not valid!\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x13ec:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "replaced";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x15c7;
    L_0x13f6:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x15c7;
    L_0x1400:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x15c7;
    L_0x140a:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1569 }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x1569 }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1569 }
        r2 = "replaced";
        r0 = r40;
        r68 = r0.getString(r2);	 Catch:{ JSONException -> 0x1569 }
    L_0x141b:
        r68 = r68.trim();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = convert;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1427;
    L_0x1423:
        r68 = com.chelpus.Utils.rework(r68);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1427:
        r2 = "[ \t]+";
        r0 = r68;
        r2 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r58 = r0;
        r2 = "[ \t]+";
        r0 = r68;
        r58 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r58;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r6 = new int[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r58;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r5 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r65 = 0;
    L_0x1448:
        r0 = r58;
        r2 = r0.length;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r0 = r65;
        if (r0 >= r2) goto L_0x158f;
    L_0x144f:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "*";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1469;
    L_0x1459:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x1469;
    L_0x1463:
        r31 = 1;
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
    L_0x1469:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x147d;
    L_0x1473:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "\\?+";
        r2 = r2.matches(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1571;
    L_0x147d:
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = 0;
        r6[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
    L_0x1484:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "sq";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x149a;
    L_0x1492:
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = 253; // 0xfd float:3.55E-43 double:1.25E-321;
        r6[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
    L_0x149a:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "s1";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x14ae;
    L_0x14a4:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "S1";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x14b6;
    L_0x14ae:
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = 254; // 0xfe float:3.56E-43 double:1.255E-321;
        r6[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
    L_0x14b6:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "s0";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x14ca;
    L_0x14c0:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "S0";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x14d2;
    L_0x14ca:
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
    L_0x14d2:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "W";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x14fa;
    L_0x14dc:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "w";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x14fa;
    L_0x14e6:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x14fa;
    L_0x14f0:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1520;
    L_0x14fa:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "w";
        r8 = "";
        r2 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = "r";
        r8 = "";
        r51 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = java.lang.Integer.valueOf(r51);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r70 = r2.intValue();	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r70 = r70 + 2;
        r6[r65] = r70;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
    L_0x1520:
        r2 = r58[r65];	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r7 = 16;
        r2 = java.lang.Integer.valueOf(r2, r7);	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r2 = r2.byteValue();	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r5[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        r65 = r65 + 1;
        goto L_0x1448;
    L_0x1532:
        r48 = 1;
        r45 = new com.android.vending.billing.InAppBillingService.LOCK.SearchItem;	 Catch:{ Exception -> 0x154b, FileNotFoundException -> 0x09b3 }
        r0 = r45;
        r0.<init>(r3, r4);	 Catch:{ Exception -> 0x154b, FileNotFoundException -> 0x09b3 }
        r2 = r3.length;	 Catch:{ Exception -> 0x154b, FileNotFoundException -> 0x09b3 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x154b, FileNotFoundException -> 0x09b3 }
        r0 = r45;
        r0.repByte = r2;	 Catch:{ Exception -> 0x154b, FileNotFoundException -> 0x09b3 }
        r2 = ser;	 Catch:{ Exception -> 0x154b, FileNotFoundException -> 0x09b3 }
        r0 = r45;
        r2.add(r0);	 Catch:{ Exception -> 0x154b, FileNotFoundException -> 0x09b3 }
        goto L_0x13ec;
    L_0x154b:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r29;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x13ec;
    L_0x1569:
        r29 = move-exception;
        r2 = "Error LP: Error replaced hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x141b;
    L_0x1571:
        r2 = 1;
        r6[r65] = r2;	 Catch:{ Exception -> 0x1576, FileNotFoundException -> 0x09b3 }
        goto L_0x1484;
    L_0x1576:
        r29 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r29;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x158f:
        r2 = r6.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r4.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != r7) goto L_0x159f;
    L_0x1593:
        r2 = r3.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r5.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != r7) goto L_0x159f;
    L_0x1597:
        r2 = r5.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 4;
        if (r2 < r7) goto L_0x159f;
    L_0x159b:
        r2 = r3.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 4;
        if (r2 >= r7) goto L_0x15a1;
    L_0x159f:
        r31 = 1;
    L_0x15a1:
        if (r31 == 0) goto L_0x15aa;
    L_0x15a3:
        r60 = 0;
        r2 = "Error LP: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x15aa:
        if (r31 != 0) goto L_0x15c7;
    L_0x15ac:
        r2 = multilib_patch;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 != 0) goto L_0x15b4;
    L_0x15b0:
        r2 = multidex;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x170d;
    L_0x15b4:
        r71 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "all_lib";
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r71;
        r0.add(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x15c3:
        r2 = "";
        group = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x15c7:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "insert";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x176c;
    L_0x15d1:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x176c;
    L_0x15db:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x176c;
    L_0x15e5:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x171e }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x171e }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x171e }
        r2 = "insert";
        r0 = r40;
        r68 = r0.getString(r2);	 Catch:{ JSONException -> 0x171e }
    L_0x15f6:
        r68 = r68.trim();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = convert;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1602;
    L_0x15fe:
        r68 = com.chelpus.Utils.rework(r68);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1602:
        r2 = "[ \t]+";
        r0 = r68;
        r2 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r58 = r0;
        r2 = "[ \t]+";
        r0 = r68;
        r58 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r58;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r6 = new int[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r58;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r5 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r65 = 0;
    L_0x1623:
        r0 = r58;
        r2 = r0.length;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r0 = r65;
        if (r0 >= r2) goto L_0x1744;
    L_0x162a:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "*";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1644;
    L_0x1634:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x1644;
    L_0x163e:
        r31 = 1;
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
    L_0x1644:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x1658;
    L_0x164e:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "\\?+";
        r2 = r2.matches(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1726;
    L_0x1658:
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = 0;
        r6[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
    L_0x165f:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "sq";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1675;
    L_0x166d:
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = 253; // 0xfd float:3.55E-43 double:1.25E-321;
        r6[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
    L_0x1675:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "s1";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x1689;
    L_0x167f:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "S1";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x1691;
    L_0x1689:
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = 254; // 0xfe float:3.56E-43 double:1.255E-321;
        r6[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
    L_0x1691:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "s0";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x16a5;
    L_0x169b:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "S0";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x16ad;
    L_0x16a5:
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
    L_0x16ad:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "W";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x16d5;
    L_0x16b7:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "w";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x16d5;
    L_0x16c1:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 != 0) goto L_0x16d5;
    L_0x16cb:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        if (r2 == 0) goto L_0x16fb;
    L_0x16d5:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "w";
        r8 = "";
        r2 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = "r";
        r8 = "";
        r51 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = java.lang.Integer.valueOf(r51);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r70 = r2.intValue();	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r70 = r70 + 2;
        r6[r65] = r70;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = "60";
        r58[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
    L_0x16fb:
        r2 = r58[r65];	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r7 = 16;
        r2 = java.lang.Integer.valueOf(r2, r7);	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r2 = r2.byteValue();	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r5[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        r65 = r65 + 1;
        goto L_0x1623;
    L_0x170d:
        r71 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = group;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r71;
        r0.add(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x15c3;
    L_0x171e:
        r29 = move-exception;
        r2 = "Error LP: Error insert hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x15f6;
    L_0x1726:
        r2 = 1;
        r6[r65] = r2;	 Catch:{ Exception -> 0x172b, FileNotFoundException -> 0x09b3 }
        goto L_0x165f;
    L_0x172b:
        r29 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r29;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1744:
        r2 = r5.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 4;
        if (r2 < r7) goto L_0x174c;
    L_0x1748:
        r2 = r3.length;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 4;
        if (r2 >= r7) goto L_0x174e;
    L_0x174c:
        r31 = 1;
    L_0x174e:
        if (r31 == 0) goto L_0x1757;
    L_0x1750:
        r60 = 0;
        r2 = "Error LP: Dimensions of the original hex-string and repleced must be >3.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1757:
        if (r31 != 0) goto L_0x176c;
    L_0x1759:
        r71 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = group;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 1;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r71;
        r0.add(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        group = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x176c:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "replace_from_file";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1822;
    L_0x1776:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1822;
    L_0x1780:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1822;
    L_0x178a:
        r40 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1865 }
        r2 = r66[r57];	 Catch:{ JSONException -> 0x1865 }
        r0 = r40;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1865 }
        r2 = "replace_from_file";
        r0 = r40;
        r68 = r0.getString(r2);	 Catch:{ JSONException -> 0x1865 }
    L_0x179b:
        r68 = r68.trim();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r12 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 1;
        r8 = r76[r8];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = com.chelpus.Utils.getDirs(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "/";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r68;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r12.<init>(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r68;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x17dd;
    L_0x17d6:
        r12 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r68;
        r12.<init>(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x17dd:
        r72 = r12.length();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r72;
        r0 = (int) r0;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r41 = r0;
        r0 = r41;
        r5 = new byte[r0];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r24 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x09b3 }
        r0 = r24;
        r0.<init>(r12);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x09b3 }
    L_0x17f1:
        r0 = r24;
        r2 = r0.read(r5);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x09b3 }
        if (r2 > 0) goto L_0x17f1;
    L_0x17f9:
        r24.close();	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x09b3 }
    L_0x17fc:
        r0 = r41;
        r6 = new int[r0];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = 1;
        java.util.Arrays.fill(r6, r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r31 == 0) goto L_0x180d;
    L_0x1806:
        r60 = 0;
        r2 = "Error LP: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x180d:
        if (r31 != 0) goto L_0x1822;
    L_0x180f:
        r71 = pat;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = group;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r71;
        r0.add(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = "";
        group = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1822:
        r2 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "[ADD-BOOT]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1835;
    L_0x1830:
        r2 = "Patch on Reboot added!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1835:
        if (r30 == 0) goto L_0x1852;
    L_0x1837:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r35;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = r66[r57];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r35 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x1852:
        r2 = "[END]";
        r0 = r23;
        r2 = r0.contains(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1861;
    L_0x185c:
        r2 = 4;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r30 = 1;
    L_0x1861:
        r57 = r57 + 1;
        goto L_0x0202;
    L_0x1865:
        r29 = move-exception;
        r2 = "Error LP: Error replaced hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x179b;
    L_0x186d:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x17fc;
    L_0x1872:
        r16.close();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r64 == 0) goto L_0x188f;
    L_0x1877:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r35;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x188f:
        if (r64 != 0) goto L_0x189a;
    L_0x1891:
        r2 = patchteil;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x1917;
    L_0x1895:
        r2 = "Not all patterns are replaced, but the program can work, test it!\nCustom Patch not valid for this Version of the Programm or already patched. ";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x189a:
        if (r21 == 0) goto L_0x18b4;
    L_0x189c:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "Changes Fix to: ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r22;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x18b4:
        r2 = fixunpack;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r2 == 0) goto L_0x190f;
    L_0x18b8:
        r2 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = dir;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = classesFiles;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = dirapp;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r71 = uid;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r72 = dirapp;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r73 = uid;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r72 = com.chelpus.Utils.getOdexForCreate(r72, r73);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r71;
        r1 = r72;
        r59 = com.chelpus.Utils.create_ODEX_root(r2, r7, r8, r0, r1);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        if (r59 == 0) goto L_0x18ef;
    L_0x18d7:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "Create odex error ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r0 = r59;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x18ef:
        if (r59 != 0) goto L_0x190f;
    L_0x18f1:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = "\n~Package reworked!~\nChanges Fix to: ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r7 = 2;
        r7 = r76[r7];	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
    L_0x190f:
        r38.close();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        r36.close();	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x00c4;
    L_0x1917:
        r2 = "Custom Patch not valid for this Version of the Programm or already patched. ";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x09b3, Exception -> 0x0a4b }
        goto L_0x189a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.custompatch.main(java.lang.String[]):void");
    }

    public static boolean patchProcess(java.util.ArrayList<com.android.vending.billing.InAppBillingService.LOCK.PatchesItem> r29) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:42)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:66)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:173)
*/
        /*
        r24 = 1;
        r19 = 0;
        if (r29 == 0) goto L_0x0052;
    L_0x0006:
        r3 = r29.size();
        if (r3 <= 0) goto L_0x0052;
    L_0x000c:
        r3 = r29.iterator();
    L_0x0010:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0052;
    L_0x0016:
        r20 = r3.next();
        r20 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItem) r20;
        r4 = 0;
        r0 = r20;
        r0.result = r4;
        r4 = tag;
        r5 = 1;
        if (r4 != r5) goto L_0x0010;
    L_0x0026:
        r4 = multidex;
        if (r4 == 0) goto L_0x0010;
    L_0x002a:
        r0 = r20;
        r4 = r0.group;
        r5 = "";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0010;
    L_0x0036:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "multi_";
        r4 = r4.append(r5);
        r0 = r19;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r0 = r20;
        r0.group = r4;
        r19 = r19 + 1;
        goto L_0x0010;
    L_0x0052:
        r3 = 3;
        r3 = new java.lang.String[r3];
        r4 = 0;
        r5 = "chmod";
        r3[r4] = r5;
        r4 = 1;
        r5 = "777";
        r3[r4] = r5;
        r4 = 2;
        r5 = localFile2;
        r5 = r5.getAbsolutePath();
        r3[r4] = r5;
        com.chelpus.Utils.run_all_no_root(r3);
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = localFile2;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = "rw";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = "Size file:";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = r2.size();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        com.chelpus.Utils.sendFromRootCP(r3);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = 0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r16 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r29.toArray();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[r3];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r25 = r0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r29.size();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[r3];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r25 = r0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = r29;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r1 = r25;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r0.toArray(r1);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[]) r3;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = r3;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[]) r0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r25 = r0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r13 = -1;
        r26 = 0;
        r8 = 0;
    L_0x00c4:
        r3 = r16.hasRemaining();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 == 0) goto L_0x0386;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x00ca:
        if (r8 != 0) goto L_0x0386;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x00cc:
        r3 = r16.position();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3 - r26;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 512000; // 0x7d000 float:7.17465E-40 double:2.529616E-318;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 <= r4) goto L_0x00f5;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x00d7:
        r3 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = "Progress size:";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r16.position();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.toString();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        com.chelpus.Utils.sendFromRootCP(r3);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r26 = r16.position();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x00f5:
        r3 = r13 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0.position(r3);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r13 = r16.position();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r12 = r16.get();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r17 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0106:
        r0 = r25;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r0.length;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r17;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r0 >= r3) goto L_0x00c4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x010d:
        r0 = r16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0.position(r13);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r12 == r3) goto L_0x0146;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x011b:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 == r4) goto L_0x0146;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0125:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 <= r4) goto L_0x0343;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x012f:
        r3 = search;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4[r5];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.get(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = (java.lang.Byte) r3;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.byteValue();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r12 != r3) goto L_0x0343;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0146:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 != 0) goto L_0x0156;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x014f:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3[r4] = r12;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0156:
        r3 = r25[r17];	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4 = 1;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        if (r3 <= r4) goto L_0x0187;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
    L_0x0160:
        r3 = r25[r17];	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4 = 253; // 0xfd float:3.55E-43 double:1.25E-321;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        if (r3 >= r4) goto L_0x0187;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
    L_0x016b:
        r3 = r25[r17];	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4 = r3.repByte;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r5 = 0;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = search;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r6 = r25[r17];	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r6 = r6.repMask;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r7 = 0;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r6 = r6[r7];	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r6 = r6 + -2;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.get(r6);	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = (java.lang.Byte) r3;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.byteValue();	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4[r5] = r3;	 Catch:{ Exception -> 0x0347, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
    L_0x0187:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 253; // 0xfd float:3.55E-43 double:1.25E-321;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 != r4) goto L_0x01a1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0192:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = r12 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r6 = r12 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r6 = r6 * 16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = r5 + r6;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = (byte) r5;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3[r4] = r5;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x01a1:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 254; // 0xfe float:3.56E-43 double:1.255E-321;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 != r4) goto L_0x01b8;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x01ac:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = r12 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = r5 + 16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = (byte) r5;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3[r4] = r5;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x01b8:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 != r4) goto L_0x01cd;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x01c3:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = r12 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = (byte) r5;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3[r4] = r5;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x01cd:
        r18 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r13 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0.position(r3);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r27 = r16.get();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x01da:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r27;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r0 == r3) goto L_0x020e;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x01e4:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 <= r4) goto L_0x0205;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x01ed:
        r3 = search;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4[r18];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.get(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = (java.lang.Byte) r3;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.byteValue();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r27;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r0 == r3) goto L_0x020e;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0205:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 1;
        if (r3 != r4) goto L_0x0343;
    L_0x020e:
        r3 = r25[r17];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        if (r3 != 0) goto L_0x021c;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
    L_0x0216:
        r3 = r25[r17];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3[r18] = r27;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
    L_0x021c:
        r3 = r25[r17];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4 = 1;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        if (r3 <= r4) goto L_0x024b;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
    L_0x0225:
        r3 = r25[r17];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4 = 253; // 0xfd float:3.55E-43 double:1.25E-321;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        if (r3 >= r4) goto L_0x024b;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
    L_0x022f:
        r3 = r25[r17];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r28 = r3 + -2;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r25[r17];	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4 = r3.repByte;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = search;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r0 = r28;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.get(r0);	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = (java.lang.Byte) r3;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r3 = r3.byteValue();	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
        r4[r18] = r3;	 Catch:{ Exception -> 0x03c7, IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, FileNotFoundException -> 0x04ed }
    L_0x024b:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 253; // 0xfd float:3.55E-43 double:1.25E-321;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 != r4) goto L_0x0263;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0255:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r27 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = r27 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = r5 * 16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4 + r5;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3[r18] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0263:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 254; // 0xfe float:3.56E-43 double:1.255E-321;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 != r4) goto L_0x0278;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x026d:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r27 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4 + 16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3[r18] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0278:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 != r4) goto L_0x028b;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0282:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r27 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3[r18] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x028b:
        r18 = r18 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r18;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r0 != r3) goto L_0x0402;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0296:
        r15 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r5 = r4.length;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x029d:
        if (r3 >= r5) goto L_0x02a4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x029f:
        r9 = r4[r3];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r9 != 0) goto L_0x03fe;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x02a3:
        r15 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x02a4:
        if (r15 != 0) goto L_0x02a7;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x02a6:
        r8 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x02a7:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.insert;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 != 0) goto L_0x02b9;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x02ad:
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4.length;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        if (r3 == r4) goto L_0x02fd;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x02b9:
        r23 = r16.position();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r2.size();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = (int) r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r21 = r3 - r23;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r21;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r10 = new byte[r0];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r1 = r21;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0.get(r10, r3, r1);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r11 = java.nio.ByteBuffer.wrap(r10);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r4.length;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3 - r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3 + r23;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = (long) r3;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r2.position(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r2.write(r11);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r6 = r2.size();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r6 = (int) r6;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r6 = (long) r6;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r16 = r2.map(r3, r4, r6);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r16;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r1 = r23;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0.position(r1);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x02fd:
        r4 = (long) r13;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r2.position(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r11 = java.nio.ByteBuffer.wrap(r3);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r2.write(r11);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r16.force();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = "\nPattern N";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = r17 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = ": Patch done! \n(Offset: ";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = java.lang.Integer.toHexString(r13);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = ")\n";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.toString();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        addToLog(r3);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3.result = r4;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        patchteil = r3;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0343:
        r17 = r17 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        goto L_0x0106;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0347:
        r14 = move-exception;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r28 = r3 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = "Byte N";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r28;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = " not found! Please edit search pattern for byte ";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r28;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = ".";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.toString();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        addToLog(r3);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        goto L_0x0187;
    L_0x037d:
        r14 = move-exception;
        r14.printStackTrace();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = "Byte by search not found! Please edit pattern for search.\n";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0386:
        r2.close();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = "Analise Results:";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        com.chelpus.Utils.sendFromRootCP(r3);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r17 = 0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0390:
        r0 = r25;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = r17;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r0 >= r3) goto L_0x040b;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0397:
        r3 = r25[r17];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 == 0) goto L_0x0408;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x039d:
        r3 = r25[r17];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.group;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = "";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 != 0) goto L_0x0408;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x03a9:
        r0 = r25;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = r0.length;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = 0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x03ad:
        if (r3 >= r4) goto L_0x0408;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x03af:
        r23 = r25[r3];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = r23;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = r0.group;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r6 = r25[r17];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r6 = r6.group;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = r5.equals(r6);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r5 == 0) goto L_0x03c4;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x03bf:
        r5 = 1;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = r23;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0.groupResult = r5;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x03c4:
        r3 = r3 + 1;
        goto L_0x03ad;
    L_0x03c7:
        r14 = move-exception;
        r3 = r25[r17];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3[r18];	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r28 = r3 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = "Byte N";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r28;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = " not found! Please edit search pattern for byte ";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r0 = r28;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r4 = ".";	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        r3 = r3.toString();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        addToLog(r3);	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        goto L_0x024b;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x03fc:
        r3 = move-exception;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        goto L_0x0386;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x03fe:
        r3 = r3 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        goto L_0x029d;	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
    L_0x0402:
        r27 = r16.get();	 Catch:{ IndexOutOfBoundsException -> 0x037d, BufferUnderflowException -> 0x03fc, Exception -> 0x0540, FileNotFoundException -> 0x04ed }
        goto L_0x01da;
    L_0x0408:
        r17 = r17 + 1;
        goto L_0x0390;
    L_0x040b:
        r17 = 0;
    L_0x040d:
        r0 = r25;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r0 = r17;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r0 >= r3) goto L_0x04f3;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0414:
        r3 = r25[r17];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 != 0) goto L_0x04c8;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x041a:
        r3 = r25[r17];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.group;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = "";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 != 0) goto L_0x04cc;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0426:
        r3 = r25[r17];	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.groupResult;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 != 0) goto L_0x04c8;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x042c:
        r3 = multidex;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 == 0) goto L_0x0466;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0430:
        r3 = localFile2;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = r5.size();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = r5 + -1;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = r4.get(r5);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 == 0) goto L_0x0466;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0446:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = r17 + 1;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r24 = 0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0466:
        r3 = multilib_patch;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 == 0) goto L_0x04a0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x046a:
        r3 = localFile2;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = r5.size();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r5 = r5 + -1;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = r4.get(r5);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 == 0) goto L_0x04a0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x0480:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = r17 + 1;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r24 = 0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x04a0:
        r3 = multidex;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 != 0) goto L_0x04c8;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x04a4:
        r3 = multilib_patch;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        if (r3 != 0) goto L_0x04c8;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x04a8:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = r17 + 1;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r24 = 0;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x04c8:
        r17 = r17 + 1;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        goto L_0x040d;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
    L_0x04cc:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = r17 + 1;	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r4 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x04ed, BufferUnderflowException -> 0x053e, Exception -> 0x0522 }
        r24 = 0;
        goto L_0x04c8;
    L_0x04ed:
        r22 = move-exception;
        r3 = "Error LP: Program files are not found!\nMove Program to internal storage.";
        addToLog(r3);
    L_0x04f3:
        r3 = tag;
        r4 = 1;
        if (r3 != r4) goto L_0x04fc;
    L_0x04f8:
        r3 = unpack;
        if (r3 == 0) goto L_0x0502;
    L_0x04fc:
        r3 = tag;
        r4 = 10;
        if (r3 != r4) goto L_0x050d;
    L_0x0502:
        r3 = ART;
        if (r3 != 0) goto L_0x050d;
    L_0x0506:
        r3 = localFile2;
        r4 = dirapp;
        com.chelpus.Utils.fixadlerOdex(r3, r4);
    L_0x050d:
        r3 = unpack;
        if (r3 == 0) goto L_0x0521;
    L_0x0511:
        r3 = odexpatch;
        if (r3 != 0) goto L_0x0521;
    L_0x0515:
        r3 = OdexPatch;
        if (r3 != 0) goto L_0x0521;
    L_0x0519:
        r3 = localFile2;
        com.chelpus.Utils.fixadler(r3);
        r3 = 1;
        fixunpack = r3;
    L_0x0521:
        return r24;
    L_0x0522:
        r14 = move-exception;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Exception e";
        r3 = r3.append(r4);
        r4 = r14.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        addToLog(r3);
        goto L_0x04f3;
    L_0x053e:
        r3 = move-exception;
        goto L_0x04f3;
    L_0x0540:
        r3 = move-exception;
        goto L_0x0386;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.custompatch.patchProcess(java.util.ArrayList):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean searchProcess(java.util.ArrayList<com.android.vending.billing.InAppBillingService.LOCK.SearchItem> r24) {
        /*
        r19 = 1;
        r3 = "";
        searchStr = r3;
        if (r24 == 0) goto L_0x0022;
    L_0x0008:
        r3 = r24.size();
        if (r3 <= 0) goto L_0x0022;
    L_0x000e:
        r3 = r24.iterator();
    L_0x0012:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0022;
    L_0x0018:
        r15 = r3.next();
        r15 = (com.android.vending.billing.InAppBillingService.LOCK.SearchItem) r15;
        r4 = 0;
        r15.result = r4;
        goto L_0x0012;
    L_0x0022:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = localFile2;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r5 = "rw";
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r12 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r24.toArray();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.SearchItem[r3];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r20 = r0;
        r3 = r24.size();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.SearchItem[r3];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r20 = r0;
        r0 = r24;
        r1 = r20;
        r3 = r0.toArray(r1);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = (com.android.vending.billing.InAppBillingService.LOCK.SearchItem[]) r3;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r0 = r3;
        r0 = (com.android.vending.billing.InAppBillingService.LOCK.SearchItem[]) r0;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r20 = r0;
        r16 = 0;
    L_0x005f:
        r3 = r12.hasRemaining();	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r3 == 0) goto L_0x0109;
    L_0x0065:
        r10 = r12.position();	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r9 = r12.get();	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r13 = 0;
    L_0x006e:
        r0 = r20;
        r3 = r0.length;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r13 >= r3) goto L_0x00e7;
    L_0x0073:
        r12.position(r10);	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.result;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r3 != 0) goto L_0x00df;
    L_0x007c:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r9 == r3) goto L_0x008e;
    L_0x0085:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r3 == 0) goto L_0x00df;
    L_0x008e:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r3 == 0) goto L_0x009e;
    L_0x0097:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = 0;
        r3[r4] = r9;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
    L_0x009e:
        r14 = 1;
        r3 = r10 + 1;
        r12.position(r3);	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r21 = r12.get();	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
    L_0x00a8:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.result;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r3 != 0) goto L_0x00b8;
    L_0x00ae:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r0 = r21;
        if (r0 == r3) goto L_0x00c0;
    L_0x00b8:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r3 == 0) goto L_0x00df;
    L_0x00c0:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r3 <= 0) goto L_0x00ce;
    L_0x00c8:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3[r14] = r21;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
    L_0x00ce:
        r14 = r14 + 1;
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = r3.length;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        if (r14 != r3) goto L_0x00e2;
    L_0x00d7:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = 1;
        r3.result = r4;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r3 = 1;
        patchteil = r3;	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
    L_0x00df:
        r13 = r13 + 1;
        goto L_0x006e;
    L_0x00e2:
        r21 = r12.get();	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        goto L_0x00a8;
    L_0x00e7:
        r3 = r10 + 1;
        r12.position(r3);	 Catch:{ Exception -> 0x00f2, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = 1;
        r16 = r16 + r4;
        goto L_0x005f;
    L_0x00f2:
        r11 = move-exception;
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = "Search byte error: ";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.append(r11);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
    L_0x0109:
        r2.close();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r13 = 0;
    L_0x010d:
        r0 = r20;
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        if (r13 >= r3) goto L_0x0146;
    L_0x0112:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        if (r3 != 0) goto L_0x0143;
    L_0x0118:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = "Bytes by serach N";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = r13 + 1;
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = ":\nError LP: Bytes not found!";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = "\n";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r19 = 0;
    L_0x0143:
        r13 = r13 + 1;
        goto L_0x010d;
    L_0x0146:
        r13 = 0;
    L_0x0147:
        r0 = r20;
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        if (r13 >= r3) goto L_0x0213;
    L_0x014c:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        if (r3 == 0) goto L_0x017b;
    L_0x0152:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = "\nBytes by search N";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = r13 + 1;
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = ":";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = "\n";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
    L_0x017b:
        r22 = 0;
    L_0x017d:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r0 = r22;
        if (r0 >= r3) goto L_0x0214;
    L_0x0186:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3[r22];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = 1;
        if (r3 <= r4) goto L_0x01f7;
    L_0x018f:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3[r22];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r23 = r3 + -2;
        r3 = search;	 Catch:{ Exception -> 0x01fa, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = r20[r13];	 Catch:{ Exception -> 0x01fa, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = r4.repByte;	 Catch:{ Exception -> 0x01fa, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = r4[r22];	 Catch:{ Exception -> 0x01fa, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r4 = java.lang.Byte.valueOf(r4);	 Catch:{ Exception -> 0x01fa, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
        r0 = r23;
        r3.set(r0, r4);	 Catch:{ Exception -> 0x01fa, FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f }
    L_0x01a8:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        if (r3 == 0) goto L_0x01f7;
    L_0x01ae:
        r3 = 1;
        r8 = new byte[r3];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = 0;
        r3 = search;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r0 = r23;
        r3 = r3.get(r0);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = (java.lang.Byte) r3;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.byteValue();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r8[r4] = r3;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = "R";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r0 = r23;
        r3 = r3.append(r0);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = "=";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = com.chelpus.Utils.bytesToHex(r8);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = r4.toUpperCase();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = " ";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
    L_0x01f7:
        r22 = r22 + 1;
        goto L_0x017d;
    L_0x01fa:
        r11 = move-exception;
        r3 = search;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = r20[r13];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = r4.repByte;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = r4[r22];	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = java.lang.Byte.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r0 = r23;
        r3.add(r0, r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        goto L_0x01a8;
    L_0x020d:
        r18 = move-exception;
        r3 = "Error LP: Program files are not found!\nMove Program to internal storage.";
        addToLog(r3);
    L_0x0213:
        return r19;
    L_0x0214:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r4 = "\n";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x020d, BufferUnderflowException -> 0x022f, Exception -> 0x024b }
        r13 = r13 + 1;
        goto L_0x0147;
    L_0x022f:
        r11 = move-exception;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Exception e";
        r3 = r3.append(r4);
        r4 = r11.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        addToLog(r3);
        goto L_0x0213;
    L_0x024b:
        r11 = move-exception;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Exception e";
        r3 = r3.append(r4);
        r4 = r11.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        addToLog(r3);
        goto L_0x0213;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.custompatch.searchProcess(java.util.ArrayList):boolean");
    }

    public static void searchDalvik(String apk_file) {
        File dalv = Utils.getFileDalvikCache(apk_file);
        if (dalv != null) {
            try {
                localFile2 = dalv;
            } catch (FileNotFoundException localFileNotFoundException) {
                localFileNotFoundException.printStackTrace();
                if (!system) {
                    addToLog("Error LP: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
                    return;
                }
                return;
            } catch (Exception e) {
                addToLog("" + e);
                return;
            }
        }
        if (odexpatch) {
            localFile2 = new File(Utils.getPlaceForOdex(dirapp, true));
        }
        try {
            if (!localFile2.exists()) {
                localFile2 = new File(Utils.getPlaceForOdex(dirapp, true));
            }
        } catch (Exception e2) {
            localFile2 = new File(Utils.getPlaceForOdex(dirapp, true));
        } catch (FileNotFoundException localFileNotFoundException2) {
            localFileNotFoundException2.printStackTrace();
            if (!system) {
                addToLog("Error LP: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
                return;
            }
            return;
        }
        if (!localFile2.exists()) {
            throw new FileNotFoundException();
        }
    }

    public static void searchDalvikOdex(String param, String param2) throws FileNotFoundException {
        searchDalvik(param);
        try {
            if (odexpatch) {
                localFile2 = new File(Utils.getPlaceForOdex(dirapp, true));
                return;
            }
            String backTemp = Utils.getOdexForCreate(param2, uid);
            File backFile = new File(backTemp);
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp.replace("-2", "-1"));
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp.replace("-1", "-2"));
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp.replace("-2", ""));
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp.replace("-1", ""));
            if (backFile.exists()) {
                backFile.delete();
            }
            backFile = new File(backTemp);
            Utils.copyFile(localFile2, backFile);
            if (backFile.exists() && backFile.length() == localFile2.length()) {
                String[] strArr = new String[otherfilesTag];
                strArr[beginTag] = "chmod";
                strArr[classesTag] = "644";
                strArr[libTagALL] = backFile.getAbsolutePath();
                Utils.run_all_no_root(strArr);
                strArr = new String[otherfilesTag];
                strArr[beginTag] = "chown";
                strArr[classesTag] = "1000." + uid;
                strArr[libTagALL] = backFile.getAbsolutePath();
                Utils.run_all_no_root(strArr);
                strArr = new String[otherfilesTag];
                strArr[beginTag] = "chown";
                strArr[classesTag] = "1000:" + uid;
                strArr[libTagALL] = backFile.getAbsolutePath();
                Utils.run_all_no_root(strArr);
                localFile2 = backFile;
            }
        } catch (Exception e) {
            e.printStackTrace();
            addToLog("Exception e" + e.toString());
        }
    }

    public static ArrayList<File> searchlib(String pkgName, String libname, String apk_file) {
        ArrayList<File> libs = new ArrayList();
        try {
            ArrayList<String> dataDirs = new ArrayList();
            dataDirs.add("/data/data/");
            dataDirs.add("/mnt/asec/");
            dataDirs.add("/sd-ext/data/");
            dataDirs.add("/data/sdext2/");
            dataDirs.add("/data/sdext1/");
            dataDirs.add("/data/sdext/");
            ArrayList<String> pakDirs = new ArrayList();
            pakDirs.add(pkgName);
            pakDirs.add(pkgName + "-1");
            pakDirs.add(pkgName + "-2");
            String index;
            Iterator it;
            String dir;
            File d;
            String result;
            Iterator it2;
            if (libname.trim().equals("*")) {
                int length;
                int i;
                File file;
                multilib_patch = true;
                File[] getFiles = new File("/data/data/" + pkgName + "/lib/").listFiles();
                if (getFiles != null && getFiles.length > 0) {
                    length = getFiles.length;
                    for (i = beginTag; i < length; i += classesTag) {
                        file = getFiles[i];
                        if (file.length() > 0 && file.getName().endsWith(".so")) {
                            Utils.addFileToList(file, libs);
                        }
                    }
                }
                index = "";
                index = new File(apk_file).getName().replace(pkgName, "").replace(".apk", "");
                if (new File("/data/app-lib").exists()) {
                    getFiles = new File("/data/app-lib/" + pkgName + index + InternalZipConstants.ZIP_FILE_SEPARATOR).listFiles();
                    if (getFiles != null && getFiles.length > 0) {
                        length = getFiles.length;
                        for (i = beginTag; i < length; i += classesTag) {
                            file = getFiles[i];
                            if (file.length() > 0 && file.getName().endsWith(".so")) {
                                Utils.addFileToList(file, libs);
                            }
                        }
                    }
                }
                it = dataDirs.iterator();
                while (it.hasNext()) {
                    Utils ad;
                    ArrayList<File> foundFiles;
                    dir = (String) it.next();
                    d = new File(dir + pkgName + index + InternalZipConstants.ZIP_FILE_SEPARATOR);
                    if (d.exists()) {
                        ad = new Utils("sdf");
                        foundFiles = new ArrayList();
                        result = ad.findFileEndText(d, ".so", foundFiles);
                        if (!result.equals("") && foundFiles.size() > 0) {
                            it2 = foundFiles.iterator();
                            while (it2.hasNext()) {
                                Utils.addFileToList((File) it2.next(), libs);
                                addToLog("Found lib:" + result);
                            }
                        }
                    }
                    File d1 = new File(dir + pkgName + InternalZipConstants.ZIP_FILE_SEPARATOR);
                    if (d1.exists()) {
                        ad = new Utils("sdf");
                        foundFiles = new ArrayList();
                        result = ad.findFileEndText(d1, ".so", foundFiles);
                        if (!result.equals("") && foundFiles.size() > 0) {
                            it2 = foundFiles.iterator();
                            while (it2.hasNext()) {
                                Utils.addFileToList((File) it2.next(), libs);
                                addToLog("Found lib:" + result);
                            }
                        }
                    }
                }
                return libs;
            }
            localFile2 = new File("/data/data/" + pkgName + "/lib/" + libname);
            if (localFile2.exists()) {
                Utils.addFileToList(localFile2, libs);
            } else {
                it = dataDirs.iterator();
                while (it.hasNext()) {
                    dir = (String) it.next();
                    it2 = pakDirs.iterator();
                    while (it2.hasNext()) {
                        d = new File(dir + ((String) it2.next()));
                        if (d.exists()) {
                            result = new Utils("sdf").findFile(d, libname);
                            if (!result.equals("")) {
                                localFile2 = new File(result);
                                Utils.addFileToList(localFile2, libs);
                                addToLog("Found lib:" + result);
                            }
                        }
                    }
                }
            }
            File dir2 = Utils.getDirs(new File(apk_file));
            if (new File(dir2.getAbsoluteFile() + "/lib").exists()) {
                localFile2 = new File(dir2.getAbsoluteFile() + "/lib/arm/" + libname);
                if (localFile2.exists()) {
                    Utils.addFileToList(localFile2, libs);
                }
                localFile2 = new File(dir2.getAbsoluteFile() + "/lib/arm64/" + libname);
                if (localFile2.exists()) {
                    Utils.addFileToList(localFile2, libs);
                }
                localFile2 = new File(dir2.getAbsoluteFile() + "/lib/x86/" + libname);
                if (localFile2.exists()) {
                    Utils.addFileToList(localFile2, libs);
                }
                localFile2 = new File(dir2.getAbsoluteFile() + "/lib/x86_64/" + libname);
                if (localFile2.exists()) {
                    Utils.addFileToList(localFile2, libs);
                }
                localFile2 = new File(dir2.getAbsoluteFile() + "/lib/mips/" + libname);
                if (localFile2.exists()) {
                    Utils.addFileToList(localFile2, libs);
                }
            }
            if (!localFile2.exists()) {
                localFile2 = new File("/system/lib/" + libname);
            }
            if (libs.size() == 0) {
                throw new FileNotFoundException();
            }
            index = "";
            index = new File(apk_file).getName().replace(pkgName, "").replace(".apk", "");
            if (!new File("/data/app-lib/" + pkgName + index + InternalZipConstants.ZIP_FILE_SEPARATOR + libname).exists()) {
                return libs;
            }
            Utils.addFileToList(new File("/data/app-lib/" + pkgName + index + InternalZipConstants.ZIP_FILE_SEPARATOR + libname), libs);
            return libs;
        } catch (FileNotFoundException e) {
            addToLog("Error LP: " + localFile2 + " are not found!\n\nCheck the location libraries to solve problems!\n");
            return null;
        } catch (Exception e2) {
            addToLog("Exception e" + e2.toString());
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void searchfile(java.lang.String r11, java.lang.String r12) {
        /*
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 == 0) goto L_0x001b;
    L_0x000b:
        r7 = "/mnt/sdcard";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x001b;
    L_0x0013:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x001a:
        return;
    L_0x001b:
        r7 = "/mnt/sdcard";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x002b;
    L_0x0023:
        r7 = "/sdcard";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 == 0) goto L_0x0130;
    L_0x002b:
        r5 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r5.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "/mnt/sdcard/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "/storage/emulated/legacy/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "/storage/emulated/0/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "/storage/sdcard0/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "/storage/sdcard/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "/storage/sdcard1/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "/sdcard/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r5.iterator();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x0057:
        r8 = r7.hasNext();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r8 == 0) goto L_0x00cc;
    L_0x005d:
        r4 = r7.next();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r4 = (java.lang.String) r4;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/mnt/sdcard/";
        r9 = r12.replace(r9, r4);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r8;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r8 == 0) goto L_0x0057;
    L_0x0078:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9.<init>();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = r9.append(r4);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r10 = "test.tmp";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r8.<init>(r9);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r8.createNewFile();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9.<init>();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = r9.append(r4);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r10 = "test.tmp";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r8.<init>(r9);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r8 = r8.exists();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        if (r8 == 0) goto L_0x00f9;
    L_0x00b1:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9.<init>();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = r9.append(r4);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r10 = "test.tmp";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r8.<init>(r9);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r8.delete();	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
    L_0x00cc:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x001a;
    L_0x00d4:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x00da:
        r1 = move-exception;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "Error LP: ";
        r7 = r7.append(r8);
        r7 = r7.append(r12);
        r8 = " are not found!\n\nRun the application file to appear in the folder with the data.!\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        addToLog(r7);
        goto L_0x001a;
    L_0x00f9:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        r9 = "/figjvaja_papka";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        localFile2 = r8;	 Catch:{ Exception -> 0x0104, FileNotFoundException -> 0x00da }
        goto L_0x0057;
    L_0x0104:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/figjvaja_papka";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r8;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        goto L_0x0057;
    L_0x0113:
        r0 = move-exception;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "Exception e";
        r7 = r7.append(r8);
        r8 = r0.toString();
        r7 = r7.append(r8);
        r7 = r7.toString();
        addToLog(r7);
        goto L_0x001a;
    L_0x0130:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/data/data/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x017a;
    L_0x0151:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/dbdata/databases/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x017a;
    L_0x0172:
        r7 = "/shared_prefs/";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 == 0) goto L_0x0260;
    L_0x017a:
        r3 = "";
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/data/data/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 == 0) goto L_0x01b8;
    L_0x019d:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/data/data/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r3 = r7.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x01b8:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/dbdata/databases/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 == 0) goto L_0x01f4;
    L_0x01d9:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/dbdata/databases/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r3 = r7.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x01f4:
        r7 = "/shared_prefs/";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 == 0) goto L_0x01fe;
    L_0x01fc:
        r3 = "/shared_prefs/";
    L_0x01fe:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/data/data/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = pkgName;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/shared_prefs/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r12.replace(r3, r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x0252;
    L_0x022c:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/dbdata/databases/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = pkgName;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/shared_prefs/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r12.replace(r3, r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x0252:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x001a;
    L_0x025a:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x0260:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/data/data/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x02aa;
    L_0x0286:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/mnt/asec/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "-1";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x02aa:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x02d6;
    L_0x02b2:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/mnt/asec/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "-2";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x02d6:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x02fc;
    L_0x02de:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/mnt/asec/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x02fc:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x0322;
    L_0x0304:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/sd-ext/data/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x0322:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x0348;
    L_0x032a:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/data/sdext2/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x0348:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x036e;
    L_0x0350:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/data/sdext1/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x036e:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x0394;
    L_0x0376:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/data/sdext/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x0394:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x03ce;
    L_0x039c:
        r6 = new com.chelpus.Utils;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "fgh";
        r6.<init>(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r9 = "/data/data/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r2 = r6.findFile(r7, r12);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = "";
        r7 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x03ce;
    L_0x03c7:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>(r2);	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
    L_0x03ce:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        if (r7 != 0) goto L_0x001a;
    L_0x03d6:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x00da, Exception -> 0x0113 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.custompatch.searchfile(java.lang.String, java.lang.String):void");
    }

    public static void unzip(File apk) {
        String[] strArr;
        Exception e;
        ZipFile zipFile;
        int i;
        classesFiles.clear();
        boolean found2 = false;
        FileInputStream fin = null;
        ZipInputStream zin = null;
        try {
            FileInputStream fin2 = new FileInputStream(apk);
            try {
                ZipInputStream zipInputStream = new ZipInputStream(fin2);
                try {
                    for (ZipEntry ze = zipInputStream.getNextEntry(); ze != null && true; ze = zipInputStream.getNextEntry()) {
                        String haystack = ze.getName();
                        if (haystack.toLowerCase().startsWith("classes") && haystack.endsWith(".dex") && !haystack.contains(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                            FileOutputStream fout = new FileOutputStream(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack);
                            byte[] buffer = new byte[BUFFER];
                            while (true) {
                                int length = zipInputStream.read(buffer);
                                if (length == -1) {
                                    break;
                                }
                                fout.write(buffer, beginTag, length);
                            }
                            zipInputStream.closeEntry();
                            fout.close();
                            classesFiles.add(new File(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack));
                            strArr = new String[otherfilesTag];
                            strArr[beginTag] = "chmod";
                            strArr[classesTag] = "777";
                            strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack;
                            Utils.run_all_no_root(strArr);
                        }
                        if (haystack.equals("AndroidManifest.xml")) {
                            FileOutputStream fout2 = new FileOutputStream(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
                            byte[] buffer2 = new byte[BUFFER];
                            while (true) {
                                int length2 = zipInputStream.read(buffer2);
                                if (length2 == -1) {
                                    break;
                                }
                                fout2.write(buffer2, beginTag, length2);
                            }
                            zipInputStream.closeEntry();
                            fout2.close();
                            strArr = new String[otherfilesTag];
                            strArr[beginTag] = "chmod";
                            strArr[classesTag] = "777";
                            strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml";
                            Utils.run_all_no_root(strArr);
                            found2 = true;
                        }
                        if (false && found2) {
                            break;
                        }
                    }
                    zipInputStream.close();
                    fin2.close();
                    zin = zipInputStream;
                    fin = fin2;
                } catch (Exception e2) {
                    e = e2;
                    zin = zipInputStream;
                    fin = fin2;
                }
            } catch (Exception e3) {
                e = e3;
                fin = fin2;
                e.printStackTrace();
                if (zin != null) {
                    try {
                        zin.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        zipFile = new ZipFile(apk);
                        zipFile.extractFile("classes.dex", dir);
                        strArr = new String[otherfilesTag];
                        strArr[beginTag] = "chmod";
                        strArr[classesTag] = "777";
                        strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex";
                        Utils.run_all_no_root(strArr);
                        classesFiles.add(new File(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex"));
                        i = classesTag;
                        while (i < odexTag) {
                            i += classesTag;
                            try {
                                zipFile.extractFile("classes" + i + ".dex", dir);
                                strArr = new String[otherfilesTag];
                                strArr[beginTag] = "chmod";
                                strArr[classesTag] = "777";
                                strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes" + i + ".dex";
                                Utils.run_all_no_root(strArr);
                                classesFiles.add(new File(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes" + i + ".dex"));
                            } catch (ZipException e4) {
                            } catch (Exception e5) {
                            }
                        }
                        zipFile.extractFile("AndroidManifest.xml", dir);
                        strArr = new String[otherfilesTag];
                        strArr[beginTag] = "chmod";
                        strArr[classesTag] = "777";
                        strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml";
                        Utils.run_all_no_root(strArr);
                        addToLog("Exception bad apk file:\n" + e.toString());
                    }
                }
                if (fin != null) {
                    fin.close();
                }
                try {
                    zipFile = new ZipFile(apk);
                    zipFile.extractFile("classes.dex", dir);
                    strArr = new String[otherfilesTag];
                    strArr[beginTag] = "chmod";
                    strArr[classesTag] = "777";
                    strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex";
                    Utils.run_all_no_root(strArr);
                    classesFiles.add(new File(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex"));
                    i = classesTag;
                    while (i < odexTag) {
                        i += classesTag;
                        zipFile.extractFile("classes" + i + ".dex", dir);
                        strArr = new String[otherfilesTag];
                        strArr[beginTag] = "chmod";
                        strArr[classesTag] = "777";
                        strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes" + i + ".dex";
                        Utils.run_all_no_root(strArr);
                        classesFiles.add(new File(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes" + i + ".dex"));
                    }
                    zipFile.extractFile("AndroidManifest.xml", dir);
                    strArr = new String[otherfilesTag];
                    strArr[beginTag] = "chmod";
                    strArr[classesTag] = "777";
                    strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml";
                    Utils.run_all_no_root(strArr);
                } catch (ZipException e12) {
                    e12.printStackTrace();
                    addToLog("Error LP: Error classes.dex decompress! " + e12);
                    addToLog("Exception " + e.toString());
                } catch (Exception e13) {
                    e13.printStackTrace();
                    addToLog("Error LP: Error classes.dex decompress! " + e13);
                    addToLog("Exception " + e.toString());
                }
                addToLog("Exception bad apk file:\n" + e.toString());
            }
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            if (zin != null) {
                zin.close();
            }
            if (fin != null) {
                fin.close();
            }
            zipFile = new ZipFile(apk);
            zipFile.extractFile("classes.dex", dir);
            strArr = new String[otherfilesTag];
            strArr[beginTag] = "chmod";
            strArr[classesTag] = "777";
            strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex";
            Utils.run_all_no_root(strArr);
            classesFiles.add(new File(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex"));
            i = classesTag;
            while (i < odexTag) {
                i += classesTag;
                zipFile.extractFile("classes" + i + ".dex", dir);
                strArr = new String[otherfilesTag];
                strArr[beginTag] = "chmod";
                strArr[classesTag] = "777";
                strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes" + i + ".dex";
                Utils.run_all_no_root(strArr);
                classesFiles.add(new File(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes" + i + ".dex"));
            }
            zipFile.extractFile("AndroidManifest.xml", dir);
            strArr = new String[otherfilesTag];
            strArr[beginTag] = "chmod";
            strArr[classesTag] = "777";
            strArr[libTagALL] = dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml";
            Utils.run_all_no_root(strArr);
            addToLog("Exception bad apk file:\n" + e.toString());
        }
    }

    public static void clearTemp() {
        try {
            File tempdex = new File(dir + "/AndroidManifest.xml");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            if (classesFiles != null && classesFiles.size() > 0) {
                Iterator it = classesFiles.iterator();
                while (it.hasNext()) {
                    tempdex = new File(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + ((File) it.next()).getName());
                    if (tempdex.exists()) {
                        tempdex.delete();
                    }
                }
            }
            tempdex = new File(dir + "/classes.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes1.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes2.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes3.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes4.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes5.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes6.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes.dex.apk");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes.dex.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
        } catch (Exception e) {
            addToLog("" + e.toString());
        }
    }
}
