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
    public static final byte[] MAGIC;
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
    public static boolean multi_patch = false;
    public static boolean multidex = false;
    public static boolean multilib_patch = false;
    private static final int nextPatchTag = 17;
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
    public static int tag = 200;
    public static String uid = "";
    public static boolean unpack = false;
    private static boolean withFramework = true;

    static {
        byte[] bArr = new byte[libTagMIPS];
        bArr[beginTag] = (byte) 100;
        bArr[classesTag] = (byte) 101;
        bArr[libTagALL] = (byte) 121;
        bArr[otherfilesTag] = (byte) 10;
        bArr[endTag] = (byte) 48;
        bArr[packageTag] = (byte) 51;
        bArr[libTagARMEABI] = (byte) 53;
        MAGIC = bArr;
    }

    public static void addToLog(String str) {
        log += str + "\n";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r72) {
        /*
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x022f }
        r7 = "SU Java-Code Running! ";
        r2.<init>(r7);	 Catch:{ Exception -> 0x022f }
        r7 = new com.chelpus.root.utils.custompatch$1;	 Catch:{ Exception -> 0x022f }
        r7.<init>();	 Catch:{ Exception -> 0x022f }
        r7 = r7.getClass();	 Catch:{ Exception -> 0x022f }
        r7 = r7.getEnclosingClass();	 Catch:{ Exception -> 0x022f }
        r7 = r7.getName();	 Catch:{ Exception -> 0x022f }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x022f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x022f }
        addToLog(r2);	 Catch:{ Exception -> 0x022f }
        r2 = 0;
        com.chelpus.Utils.startRootJava(r2);	 Catch:{ Exception -> 0x022f }
        r2 = 0;
        r2 = r72[r2];	 Catch:{ Exception -> 0x022f }
        pkgName = r2;	 Catch:{ Exception -> 0x022f }
        r2 = pkgName;	 Catch:{ Exception -> 0x0229 }
        com.chelpus.Utils.kill(r2);	 Catch:{ Exception -> 0x0229 }
        r2 = 2;
        r2 = r72[r2];	 Catch:{ Exception -> 0x0229 }
        r7 = "rw";
        com.chelpus.Utils.remount(r2, r7);	 Catch:{ Exception -> 0x0229 }
    L_0x0039:
        r2 = 9;
        r2 = r72[r2];	 Catch:{ Exception -> 0x0234 }
        if (r2 == 0) goto L_0x004e;
    L_0x003f:
        r2 = 9;
        r2 = r72[r2];	 Catch:{ Exception -> 0x0234 }
        r7 = "ART";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x0234 }
        if (r2 == 0) goto L_0x004e;
    L_0x004b:
        r2 = 1;
        ART = r2;	 Catch:{ Exception -> 0x0234 }
    L_0x004e:
        r2 = 10;
        r2 = r72[r2];	 Catch:{ Exception -> 0x0234 }
        if (r2 == 0) goto L_0x005a;
    L_0x0054:
        r2 = 10;
        r2 = r72[r2];	 Catch:{ Exception -> 0x0234 }
        uid = r2;	 Catch:{ Exception -> 0x0234 }
    L_0x005a:
        r2 = 11;
        r2 = r72[r2];	 Catch:{ Exception -> 0x0234 }
        if (r2 == 0) goto L_0x006c;
    L_0x0060:
        r2 = 11;
        r2 = r72[r2];	 Catch:{ Exception -> 0x0234 }
        r7 = "yes";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x0234 }
        withFramework = r2;	 Catch:{ Exception -> 0x0234 }
    L_0x006c:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0273 }
        r7 = 4;
        r7 = r72[r7];	 Catch:{ Exception -> 0x0273 }
        r2.<init>(r7);	 Catch:{ Exception -> 0x0273 }
        r33 = r2.listFiles();	 Catch:{ Exception -> 0x0273 }
        r0 = r33;
        r7 = r0.length;	 Catch:{ Exception -> 0x0273 }
        r2 = 0;
    L_0x007c:
        if (r2 < r7) goto L_0x023a;
    L_0x007e:
        r2 = 3;
        r2 = r72[r2];	 Catch:{ Exception -> 0x022f }
        sddir = r2;	 Catch:{ Exception -> 0x022f }
        r2 = 4;
        r2 = r72[r2];	 Catch:{ Exception -> 0x022f }
        dir = r2;	 Catch:{ Exception -> 0x022f }
        r2 = 4;
        r2 = r72[r2];	 Catch:{ Exception -> 0x022f }
        dir2 = r2;	 Catch:{ Exception -> 0x022f }
        r2 = 2;
        r2 = r72[r2];	 Catch:{ Exception -> 0x022f }
        dirapp = r2;	 Catch:{ Exception -> 0x022f }
        clearTemp();	 Catch:{ Exception -> 0x022f }
        r21 = "";
        r34 = "";
        r15 = "";
        r30 = 0;
        r29 = 0;
        r20 = 0;
        r2 = 6;
        r2 = r72[r2];	 Catch:{ Exception -> 0x022f }
        r7 = "not_system";
        r2 = r2.equals(r7);	 Catch:{ Exception -> 0x022f }
        if (r2 == 0) goto L_0x00af;
    L_0x00ac:
        r2 = 0;
        system = r2;	 Catch:{ Exception -> 0x022f }
    L_0x00af:
        r2 = 6;
        r2 = r72[r2];	 Catch:{ Exception -> 0x022f }
        r7 = "system";
        r2 = r2.equals(r7);	 Catch:{ Exception -> 0x022f }
        if (r2 == 0) goto L_0x00bd;
    L_0x00ba:
        r2 = 1;
        system = r2;	 Catch:{ Exception -> 0x022f }
    L_0x00bd:
        r2 = system;	 Catch:{ Exception -> 0x022f }
        if (r2 == 0) goto L_0x00f0;
    L_0x00c1:
        r11 = new java.io.File;	 Catch:{ Exception -> 0x022f }
        r2 = dirapp;	 Catch:{ Exception -> 0x022f }
        r11.<init>(r2);	 Catch:{ Exception -> 0x022f }
        r12 = new java.io.File;	 Catch:{ Exception -> 0x022f }
        r2 = dirapp;	 Catch:{ Exception -> 0x022f }
        r7 = 1;
        r2 = com.chelpus.Utils.getPlaceForOdex(r2, r7);	 Catch:{ Exception -> 0x022f }
        r12.<init>(r2);	 Catch:{ Exception -> 0x022f }
        r2 = r11.exists();	 Catch:{ Exception -> 0x022f }
        if (r2 == 0) goto L_0x00f0;
    L_0x00da:
        r2 = r12.exists();	 Catch:{ Exception -> 0x022f }
        if (r2 == 0) goto L_0x00f0;
    L_0x00e0:
        r2 = com.chelpus.Utils.classes_test(r11);	 Catch:{ Exception -> 0x022f }
        if (r2 != 0) goto L_0x00f0;
    L_0x00e6:
        r2 = 1;
        odexpatch = r2;	 Catch:{ Exception -> 0x022f }
        localFile2 = r12;	 Catch:{ Exception -> 0x022f }
        r2 = "\nOdex Application.\nOnly ODEX patch is enabled.\n";
        addToLog(r2);	 Catch:{ Exception -> 0x022f }
    L_0x00f0:
        r43 = "";
        r2 = 0;
        OdexPatch = r2;	 Catch:{ Exception -> 0x022f }
        r36 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0350 }
        r2 = 1;
        r2 = r72[r2];	 Catch:{ IOException -> 0x0350 }
        r0 = r36;
        r0.<init>(r2);	 Catch:{ IOException -> 0x0350 }
        r38 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0350 }
        r2 = "UTF-8";
        r0 = r38;
        r1 = r36;
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0350 }
        r17 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0350 }
        r0 = r17;
        r1 = r38;
        r0.<init>(r1);	 Catch:{ IOException -> 0x0350 }
        r2 = 2;
        r2 = r72[r2];	 Catch:{ IOException -> 0x0350 }
        searchDalvik(r2);	 Catch:{ IOException -> 0x0350 }
    L_0x0119:
        r43 = r17.readLine();	 Catch:{ IOException -> 0x0350 }
        if (r43 != 0) goto L_0x0279;
    L_0x011f:
        r17.close();	 Catch:{ IOException -> 0x0350 }
        r36.close();	 Catch:{ IOException -> 0x0350 }
    L_0x0125:
        r35 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 1;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r35;
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r37 = new java.io.InputStreamReader;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "UTF-8";
        r0 = r37;
        r1 = r35;
        r0.<init>(r1, r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r16 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r16;
        r1 = r37;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r22 = "";
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r63 = r0;
        r2 = 1;
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r51 = r0;
        r2 = 0;
        r7 = "";
        r51[r2] = r7;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r3 = 0;
        r4 = 0;
        r32 = "";
        r53 = "";
        r52 = "";
        r57 = 1;
        r61 = 1;
        r42 = 0;
        r47 = 0;
        r64 = "";
        r65 = "";
        r66 = "";
        r2 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        pat = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        ser = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        search = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r54 = 0;
    L_0x0182:
        r22 = r16.readLine();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r22 != 0) goto L_0x0353;
    L_0x0188:
        r16.close();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r61 == 0) goto L_0x019f;
    L_0x018d:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r34;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x019f:
        if (r61 != 0) goto L_0x01aa;
    L_0x01a1:
        r2 = patchteil;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x1892;
    L_0x01a5:
        r2 = "Not all patterns are replaced, but the program can work, test it!\nCustom Patch not valid for this Version of the Programm or already patched. ";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x01aa:
        if (r20 == 0) goto L_0x01c0;
    L_0x01ac:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "Changes Fix to: ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r21;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x01c0:
        r2 = fixunpack;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0213;
    L_0x01c4:
        r2 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = dir;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = dirapp;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r68 = uid;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r69 = dirapp;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r70 = uid;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r69 = com.chelpus.Utils.getOdexForCreate(r69, r70);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r68;
        r1 = r69;
        r56 = com.chelpus.Utils.create_ODEX_root(r2, r7, r8, r0, r1);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r56 == 0) goto L_0x01f7;
    L_0x01e3:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "Create odex error ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r56;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x01f7:
        if (r56 != 0) goto L_0x0213;
    L_0x01f9:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "\n~Package reworked!~\nChanges Fix to: ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 2;
        r7 = r72[r7];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0213:
        r37.close();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r35.close();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0219:
        r2 = log;
        com.chelpus.Utils.sendFromRootCP(r2);
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r2;
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x0229:
        r28 = move-exception;
        r28.printStackTrace();	 Catch:{ Exception -> 0x022f }
        goto L_0x0039;
    L_0x022f:
        r28 = move-exception;
        r28.printStackTrace();
        goto L_0x0219;
    L_0x0234:
        r28 = move-exception;
        r28.printStackTrace();	 Catch:{ Exception -> 0x022f }
        goto L_0x006c;
    L_0x023a:
        r31 = r33[r2];	 Catch:{ Exception -> 0x0273 }
        r8 = r31.isFile();	 Catch:{ Exception -> 0x0273 }
        if (r8 == 0) goto L_0x026f;
    L_0x0242:
        r8 = r31.getName();	 Catch:{ Exception -> 0x0273 }
        r68 = "busybox";
        r0 = r68;
        r8 = r8.equals(r0);	 Catch:{ Exception -> 0x0273 }
        if (r8 != 0) goto L_0x026f;
    L_0x0250:
        r8 = r31.getName();	 Catch:{ Exception -> 0x0273 }
        r68 = "reboot";
        r0 = r68;
        r8 = r8.equals(r0);	 Catch:{ Exception -> 0x0273 }
        if (r8 != 0) goto L_0x026f;
    L_0x025e:
        r8 = r31.getName();	 Catch:{ Exception -> 0x0273 }
        r68 = "dalvikvm";
        r0 = r68;
        r8 = r8.equals(r0);	 Catch:{ Exception -> 0x0273 }
        if (r8 != 0) goto L_0x026f;
    L_0x026c:
        r31.delete();	 Catch:{ Exception -> 0x0273 }
    L_0x026f:
        r2 = r2 + 1;
        goto L_0x007c;
    L_0x0273:
        r28 = move-exception;
        r28.printStackTrace();	 Catch:{ Exception -> 0x022f }
        goto L_0x007e;
    L_0x0279:
        r2 = r43.toUpperCase();	 Catch:{ IOException -> 0x0350 }
        r7 = "[ODEX-PATCH]";
        r2 = r2.contains(r7);	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x0288;
    L_0x0285:
        r2 = 1;
        OdexPatch = r2;	 Catch:{ IOException -> 0x0350 }
    L_0x0288:
        r2 = r43.toUpperCase();	 Catch:{ IOException -> 0x0350 }
        r7 = "[LIB-ARMEABI-V7A]";
        r2 = r2.contains(r7);	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x0297;
    L_0x0294:
        r2 = 1;
        armv7 = r2;	 Catch:{ IOException -> 0x0350 }
    L_0x0297:
        r2 = r43.toUpperCase();	 Catch:{ IOException -> 0x0350 }
        r7 = "[NEXT_PATCH]";
        r2 = r2.contains(r7);	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x02a6;
    L_0x02a3:
        r2 = 1;
        multi_patch = r2;	 Catch:{ IOException -> 0x0350 }
    L_0x02a6:
        r2 = r43.toUpperCase();	 Catch:{ IOException -> 0x0350 }
        r7 = "[PACKAGE]";
        r2 = r2.contains(r7);	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x0119;
    L_0x02b2:
        r2 = 2;
        r10 = r72[r2];	 Catch:{ IOException -> 0x0350 }
        r9 = new java.io.File;	 Catch:{ IOException -> 0x0350 }
        r9.<init>(r10);	 Catch:{ IOException -> 0x0350 }
        r2 = r9.exists();	 Catch:{ IOException -> 0x0350 }
        if (r2 != 0) goto L_0x02db;
    L_0x02c0:
        r9 = new java.io.File;	 Catch:{ IOException -> 0x0350 }
        r2 = "-1/";
        r7 = "-2/";
        r2 = r10.replace(r2, r7);	 Catch:{ IOException -> 0x0350 }
        r9.<init>(r2);	 Catch:{ IOException -> 0x0350 }
        r2 = r9.exists();	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x02db;
    L_0x02d3:
        r2 = "-1/";
        r7 = "-2/";
        r10 = r10.replace(r2, r7);	 Catch:{ IOException -> 0x0350 }
    L_0x02db:
        r2 = r9.exists();	 Catch:{ IOException -> 0x0350 }
        if (r2 != 0) goto L_0x02fc;
    L_0x02e1:
        r9 = new java.io.File;	 Catch:{ IOException -> 0x0350 }
        r2 = "-1/";
        r7 = "/";
        r2 = r10.replace(r2, r7);	 Catch:{ IOException -> 0x0350 }
        r9.<init>(r2);	 Catch:{ IOException -> 0x0350 }
        r2 = r9.exists();	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x02fc;
    L_0x02f4:
        r2 = "-1/";
        r7 = "";
        r10 = r10.replace(r2, r7);	 Catch:{ IOException -> 0x0350 }
    L_0x02fc:
        unzip(r9);	 Catch:{ IOException -> 0x0350 }
        r2 = odexpatch;	 Catch:{ IOException -> 0x0350 }
        if (r2 != 0) goto L_0x0119;
    L_0x0303:
        r2 = OdexPatch;	 Catch:{ IOException -> 0x0350 }
        if (r2 != 0) goto L_0x0119;
    L_0x0307:
        r2 = 1;
        r49 = com.chelpus.Utils.getPlaceForOdex(r10, r2);	 Catch:{ IOException -> 0x0350 }
        r48 = new java.io.File;	 Catch:{ IOException -> 0x0350 }
        r48.<init>(r49);	 Catch:{ IOException -> 0x0350 }
        r2 = r48.exists();	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x031a;
    L_0x0317:
        r48.delete();	 Catch:{ IOException -> 0x0350 }
    L_0x031a:
        r48 = new java.io.File;	 Catch:{ IOException -> 0x0350 }
        r2 = "-1";
        r7 = "-2";
        r0 = r49;
        r2 = r0.replace(r2, r7);	 Catch:{ IOException -> 0x0350 }
        r0 = r48;
        r0.<init>(r2);	 Catch:{ IOException -> 0x0350 }
        r2 = r48.exists();	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x0334;
    L_0x0331:
        r48.delete();	 Catch:{ IOException -> 0x0350 }
    L_0x0334:
        r48 = new java.io.File;	 Catch:{ IOException -> 0x0350 }
        r2 = "-2";
        r7 = "-1";
        r0 = r49;
        r2 = r0.replace(r2, r7);	 Catch:{ IOException -> 0x0350 }
        r0 = r48;
        r0.<init>(r2);	 Catch:{ IOException -> 0x0350 }
        r2 = r48.exists();	 Catch:{ IOException -> 0x0350 }
        if (r2 == 0) goto L_0x0119;
    L_0x034b:
        r48.delete();	 Catch:{ IOException -> 0x0350 }
        goto L_0x0119;
    L_0x0350:
        r2 = move-exception;
        goto L_0x0125;
    L_0x0353:
        r2 = "";
        r0 = r22;
        r2 = r0.equals(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0365;
    L_0x035d:
        r2 = pkgName;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r22;
        r22 = com.chelpus.Utils.apply_TAGS(r0, r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0365:
        r63[r54] = r22;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0382;
    L_0x0371:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0382;
    L_0x037b:
        r29 = 0;
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        switch(r2) {
            case 0: goto L_0x0c0d;
            case 1: goto L_0x0c76;
            case 2: goto L_0x0e7a;
            case 3: goto L_0x11c2;
            case 4: goto L_0x0c2d;
            case 5: goto L_0x0382;
            case 6: goto L_0x0f06;
            case 7: goto L_0x0f92;
            case 8: goto L_0x10aa;
            case 9: goto L_0x1136;
            case 10: goto L_0x0df2;
            case 11: goto L_0x11ef;
            case 12: goto L_0x126a;
            case 13: goto L_0x1281;
            case 14: goto L_0x140f;
            case 15: goto L_0x12df;
            case 16: goto L_0x101e;
            case 17: goto L_0x0c49;
            default: goto L_0x0382;
        };	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0382:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x039f;
    L_0x0386:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = java.lang.String.valueOf(r15);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r15 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x039f:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[PACKAGE]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x03b3;
    L_0x03ad:
        r2 = 5;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 1;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x03b3:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[BEGIN]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x03c6;
    L_0x03c1:
        r2 = 0;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r15 = "";
    L_0x03c6:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[CLASSES]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x03fd;
    L_0x03d4:
        r2 = 1;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = unpack;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x03fd;
    L_0x03db:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = dir;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "classes.dex";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x03fd:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[ODEX]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x040f;
    L_0x040b:
        r2 = 10;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x040f:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[SQLITE]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0421;
    L_0x041d:
        r2 = 12;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0421:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 12;
        if (r2 != r7) goto L_0x0568;
    L_0x0427:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "database";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x051f;
    L_0x043b:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x142e }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x142e }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x142e }
        r2 = "database";
        r0 = r39;
        r64 = r0.getString(r2);	 Catch:{ JSONException -> 0x142e }
        r24 = new java.io.File;	 Catch:{ JSONException -> 0x142e }
        r0 = r24;
        r1 = r64;
        r0.<init>(r1);	 Catch:{ JSONException -> 0x142e }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ JSONException -> 0x142e }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ JSONException -> 0x142e }
        r7 = 1;
        r8 = "777";
        r2[r7] = r8;	 Catch:{ JSONException -> 0x142e }
        r7 = 2;
        r2[r7] = r64;	 Catch:{ JSONException -> 0x142e }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ JSONException -> 0x142e }
        r2 = withFramework;	 Catch:{ JSONException -> 0x142e }
        if (r2 != 0) goto L_0x0493;
    L_0x046c:
        r2 = new java.io.File;	 Catch:{ JSONException -> 0x142e }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x142e }
        r8 = dir;	 Catch:{ JSONException -> 0x142e }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ JSONException -> 0x142e }
        r7.<init>(r8);	 Catch:{ JSONException -> 0x142e }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x142e }
        r8 = r24.getName();	 Catch:{ JSONException -> 0x142e }
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x142e }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x142e }
        r2.<init>(r7);	 Catch:{ JSONException -> 0x142e }
        r0 = r24;
        com.chelpus.Utils.copyFile(r0, r2);	 Catch:{ JSONException -> 0x142e }
    L_0x0493:
        r2 = r24.exists();	 Catch:{ JSONException -> 0x142e }
        if (r2 != 0) goto L_0x1429;
    L_0x0499:
        r2 = 0;
        localFile2 = r2;	 Catch:{ JSONException -> 0x142e }
        r2 = 0;
        r2 = r72[r2];	 Catch:{ JSONException -> 0x142e }
        r7 = r24.getName();	 Catch:{ JSONException -> 0x142e }
        searchfile(r2, r7);	 Catch:{ JSONException -> 0x142e }
        r2 = localFile2;	 Catch:{ JSONException -> 0x142e }
        if (r2 == 0) goto L_0x1425;
    L_0x04aa:
        r2 = localFile2;	 Catch:{ JSONException -> 0x142e }
        r2 = r2.exists();	 Catch:{ JSONException -> 0x142e }
        if (r2 == 0) goto L_0x1425;
    L_0x04b2:
        r24 = localFile2;	 Catch:{ JSONException -> 0x142e }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ JSONException -> 0x142e }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ JSONException -> 0x142e }
        r7 = 1;
        r8 = "777";
        r2[r7] = r8;	 Catch:{ JSONException -> 0x142e }
        r7 = 2;
        r2[r7] = r64;	 Catch:{ JSONException -> 0x142e }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ JSONException -> 0x142e }
        r2 = withFramework;	 Catch:{ JSONException -> 0x142e }
        if (r2 != 0) goto L_0x04f2;
    L_0x04cb:
        r2 = new java.io.File;	 Catch:{ JSONException -> 0x142e }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x142e }
        r8 = dir;	 Catch:{ JSONException -> 0x142e }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ JSONException -> 0x142e }
        r7.<init>(r8);	 Catch:{ JSONException -> 0x142e }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x142e }
        r8 = r24.getName();	 Catch:{ JSONException -> 0x142e }
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x142e }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x142e }
        r2.<init>(r7);	 Catch:{ JSONException -> 0x142e }
        r0 = r24;
        com.chelpus.Utils.copyFile(r0, r2);	 Catch:{ JSONException -> 0x142e }
    L_0x04f2:
        r2 = 1;
        dataBaseExist = r2;	 Catch:{ JSONException -> 0x142e }
    L_0x04f5:
        r2 = dataBaseExist;	 Catch:{ JSONException -> 0x142e }
        if (r2 == 0) goto L_0x04ff;
    L_0x04f9:
        r2 = r24.getAbsolutePath();	 Catch:{ JSONException -> 0x142e }
        dataBase = r2;	 Catch:{ JSONException -> 0x142e }
    L_0x04ff:
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ JSONException -> 0x142e }
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x142e }
        r7 = "Open SqLite database\n";
        r2.<init>(r7);	 Catch:{ JSONException -> 0x142e }
        r7 = r24.getAbsolutePath();	 Catch:{ JSONException -> 0x142e }
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x142e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x142e }
        addToLog(r2);	 Catch:{ JSONException -> 0x142e }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ JSONException -> 0x142e }
    L_0x051f:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "execute";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0568;
    L_0x0529:
        r2 = dataBaseExist;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0568;
    L_0x052d:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x144f }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x144f }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x144f }
        r2 = "execute";
        r0 = r39;
        r64 = r0.getString(r2);	 Catch:{ JSONException -> 0x144f }
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x144f }
        r7 = "Execute:\n";
        r2.<init>(r7);	 Catch:{ JSONException -> 0x144f }
        r0 = r64;
        r2 = r2.append(r0);	 Catch:{ JSONException -> 0x144f }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x144f }
        addToLog(r2);	 Catch:{ JSONException -> 0x144f }
        r2 = withFramework;	 Catch:{ JSONException -> 0x144f }
        if (r2 == 0) goto L_0x0568;
    L_0x0556:
        r2 = dataBase;	 Catch:{ Exception -> 0x1436, FileNotFoundException -> 0x0c25 }
        r7 = 0;
        r8 = 0;
        r25 = android.database.sqlite.SQLiteDatabase.openDatabase(r2, r7, r8);	 Catch:{ Exception -> 0x1436, FileNotFoundException -> 0x0c25 }
        r0 = r25;
        r1 = r64;
        r0.execSQL(r1);	 Catch:{ Exception -> 0x1436, FileNotFoundException -> 0x0c25 }
        r25.close();	 Catch:{ Exception -> 0x1436, FileNotFoundException -> 0x0c25 }
    L_0x0568:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 3;
        if (r2 != r7) goto L_0x05b8;
    L_0x056d:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1457 }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x1457 }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1457 }
        r2 = "name";
        r0 = r39;
        r64 = r0.getString(r2);	 Catch:{ JSONException -> 0x1457 }
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ JSONException -> 0x1457 }
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x1457 }
        r7 = "Patch for file \n";
        r2.<init>(r7);	 Catch:{ JSONException -> 0x1457 }
        r0 = r64;
        r2 = r2.append(r0);	 Catch:{ JSONException -> 0x1457 }
        r7 = ":";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x1457 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x1457 }
        addToLog(r2);	 Catch:{ JSONException -> 0x1457 }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ JSONException -> 0x1457 }
    L_0x05ac:
        r2 = 0;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r64;
        searchfile(r2, r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x05b8:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 13;
        if (r2 != r7) goto L_0x061a;
    L_0x05be:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "file_name";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x05e1;
    L_0x05c8:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x145f }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x145f }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x145f }
        r2 = "file_name";
        r0 = r39;
        r32 = r0.getString(r2);	 Catch:{ JSONException -> 0x145f }
    L_0x05d9:
        r2 = 0;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r32;
        searchfile(r2, r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x05e1:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "permissions";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x061a;
    L_0x05eb:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x061a;
    L_0x05f5:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x061a;
    L_0x05ff:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x061a;
    L_0x0609:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x146a }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x146a }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x146a }
        r2 = "permissions";
        r0 = r39;
        r53 = r0.getString(r2);	 Catch:{ JSONException -> 0x146a }
    L_0x061a:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 15;
        if (r2 != r7) goto L_0x0674;
    L_0x0620:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "file_name";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x063b;
    L_0x062a:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1472 }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x1472 }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1472 }
        r2 = "file_name";
        r0 = r39;
        r32 = r0.getString(r2);	 Catch:{ JSONException -> 0x1472 }
    L_0x063b:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "\"to\":";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0674;
    L_0x0645:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0674;
    L_0x064f:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0674;
    L_0x0659:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0674;
    L_0x0663:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x147d }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x147d }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x147d }
        r2 = "to";
        r0 = r39;
        r52 = r0.getString(r2);	 Catch:{ JSONException -> 0x147d }
    L_0x0674:
        if (r42 == 0) goto L_0x06a6;
    L_0x0676:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1485 }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x1485 }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1485 }
        r2 = "name";
        r0 = r39;
        r64 = r0.getString(r2);	 Catch:{ JSONException -> 0x1485 }
    L_0x0691:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 2;
        r7 = r72[r7];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r64;
        r2 = searchlib(r2, r0, r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        arrayFile2 = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 0;
    L_0x06a6:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[NEXT_PATCH]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x06bf;
    L_0x06b4:
        r2 = 17;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 0;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x06bf:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[LIB]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x06d7;
    L_0x06cd:
        r2 = 2;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 1;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x06d7:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[LIB-ARMEABI]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0711;
    L_0x06e5:
        r2 = 7;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "armeabi";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0707;
    L_0x06f4:
        r2 = 7;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "armeabi-v7a";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x148d;
    L_0x0703:
        r2 = armv7;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x148d;
    L_0x0707:
        r2 = 6;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 1;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x0711:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[LIB-ARMEABI-V7A]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0738;
    L_0x071f:
        r2 = 7;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "armeabi-v7a";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x1493;
    L_0x072e:
        r2 = 7;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 1;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x0738:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[LIB-ARM64-V8A]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0760;
    L_0x0746:
        r2 = 7;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "arm64-v8a";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x1499;
    L_0x0755:
        r2 = 16;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 1;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x0760:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[LIB-MIPS]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0788;
    L_0x076e:
        r2 = 7;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "mips";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x149f;
    L_0x077d:
        r2 = 8;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 1;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x0788:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[LIB-X86]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x07b0;
    L_0x0796:
        r2 = 7;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toLowerCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "x86";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x14a5;
    L_0x07a5:
        r2 = 9;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 1;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x07b0:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[OTHER FILES]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x07c8;
    L_0x07be:
        r2 = 3;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 0;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x07c8:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[SET_PERMISSIONS]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x07e1;
    L_0x07d6:
        r2 = 13;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 0;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x07e1:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[COPY_FILE]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x07fa;
    L_0x07ef:
        r2 = 15;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r42 = 0;
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
    L_0x07fa:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[ODEX-PATCH]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0813;
    L_0x0808:
        r2 = 11;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
        r42 = 0;
    L_0x0813:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[FILE_IN_APK]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x082c;
    L_0x0821:
        r2 = 14;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r29 = 0;
        r42 = 0;
    L_0x082c:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "group";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x085d;
    L_0x0836:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x085d;
    L_0x0840:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x085d;
    L_0x084a:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x14ab }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x14ab }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x14ab }
        r2 = "group";
        r0 = r39;
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x14ab }
        group = r2;	 Catch:{ JSONException -> 0x14ab }
    L_0x085d:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "original";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x08d3;
    L_0x0867:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x08d3;
    L_0x0871:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x08d3;
    L_0x087b:
        if (r47 == 0) goto L_0x088e;
    L_0x087d:
        r2 = tag;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 1;
        if (r2 != r7) goto L_0x14cd;
    L_0x0882:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0888:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x14b7;
    L_0x088e:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x14d7 }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x14d7 }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x14d7 }
        r2 = "original";
        r0 = r39;
        r64 = r0.getString(r2);	 Catch:{ JSONException -> 0x14d7 }
    L_0x089f:
        r64 = r64.trim();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = convert;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x08ab;
    L_0x08a7:
        r64 = com.chelpus.Utils.rework(r64);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x08ab:
        r2 = "[ \t]+";
        r0 = r64;
        r2 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r51 = r0;
        r2 = "[ \t]+";
        r0 = r64;
        r51 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r51;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r4 = new int[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r51;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r3 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r62 = 0;
    L_0x08cc:
        r0 = r51;
        r2 = r0.length;	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r0 = r62;
        if (r0 < r2) goto L_0x14df;
    L_0x08d3:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "\"object\"";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0988;
    L_0x08dd:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0988;
    L_0x08e7:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0988;
    L_0x08f1:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x158f }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x158f }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x158f }
        r2 = "object";
        r0 = r39;
        r66 = r0.getString(r2);	 Catch:{ JSONException -> 0x158f }
    L_0x0902:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "dalvikvm -Xverify:none -Xdexopt:none -cp ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 5;
        r7 = r72[r7];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 8;
        r7 = r72[r7];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = ".nerorunpatch ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 0;
        r7 = r72[r7];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " ";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "object";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r66;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r19 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r19;
        r46 = r2.exec(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r46.waitFor();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r45 = new java.io.DataInputStream;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r46.getInputStream();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r45;
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r45.available();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r14 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r45;
        r0.read(r14);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r59 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r59;
        r0.<init>(r14);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r46.destroy();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Done";
        r0 = r59;
        r2 = r0.contains(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x1597;
    L_0x097e:
        r60 = "Object patched!\n\n";
        addToLog(r60);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r61 = 1;
    L_0x0985:
        r2 = 1;
        manualpatch = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0988:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "search";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x09f4;
    L_0x0992:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x09f4;
    L_0x099c:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x09f4;
    L_0x09a6:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x15a0 }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x15a0 }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x15a0 }
        r2 = "search";
        r0 = r39;
        r66 = r0.getString(r2);	 Catch:{ JSONException -> 0x15a0 }
    L_0x09b7:
        r66 = r66.trim();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = convert;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x09c3;
    L_0x09bf:
        r66 = com.chelpus.Utils.rework(r66);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x09c3:
        r2 = "[ \t]+";
        r0 = r66;
        r2 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r51 = r0;
        r2 = "[ \t]+";
        r0 = r66;
        r51 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r51;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r4 = new int[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r51;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r3 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r62 = 0;
    L_0x09e4:
        r0 = r51;
        r2 = r0.length;	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r0 = r62;
        if (r0 < r2) goto L_0x15a8;
    L_0x09eb:
        if (r30 == 0) goto L_0x1632;
    L_0x09ed:
        r57 = 0;
        r2 = "Error LP: Patterns to search not valid!\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x09f4:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "replaced";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0a8f;
    L_0x09fe:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0a8f;
    L_0x0a08:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0a8f;
    L_0x0a12:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1665 }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x1665 }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1665 }
        r2 = "replaced";
        r0 = r39;
        r65 = r0.getString(r2);	 Catch:{ JSONException -> 0x1665 }
    L_0x0a23:
        r65 = r65.trim();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = convert;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0a2f;
    L_0x0a2b:
        r65 = com.chelpus.Utils.rework(r65);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0a2f:
        r2 = "[ \t]+";
        r0 = r65;
        r2 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r55 = r0;
        r2 = "[ \t]+";
        r0 = r65;
        r55 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r55;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r6 = new int[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r55;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r5 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r62 = 0;
    L_0x0a50:
        r0 = r55;
        r2 = r0.length;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r0 = r62;
        if (r0 < r2) goto L_0x166d;
    L_0x0a57:
        r2 = r6.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r4.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != r7) goto L_0x0a67;
    L_0x0a5b:
        r2 = r3.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r5.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != r7) goto L_0x0a67;
    L_0x0a5f:
        r2 = r5.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 4;
        if (r2 < r7) goto L_0x0a67;
    L_0x0a63:
        r2 = r3.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 4;
        if (r2 >= r7) goto L_0x0a69;
    L_0x0a67:
        r30 = 1;
    L_0x0a69:
        if (r30 == 0) goto L_0x0a72;
    L_0x0a6b:
        r57 = 0;
        r2 = "Error LP: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0a72:
        if (r30 != 0) goto L_0x0a8f;
    L_0x0a74:
        r2 = multilib_patch;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0a7c;
    L_0x0a78:
        r2 = multidex;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x176c;
    L_0x0a7c:
        r68 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "all_lib";
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r68;
        r0.add(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0a8b:
        r2 = "";
        group = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0a8f:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "insert";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0b10;
    L_0x0a99:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0b10;
    L_0x0aa3:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0b10;
    L_0x0aad:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x177d }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x177d }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x177d }
        r2 = "insert";
        r0 = r39;
        r65 = r0.getString(r2);	 Catch:{ JSONException -> 0x177d }
    L_0x0abe:
        r65 = r65.trim();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = convert;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0aca;
    L_0x0ac6:
        r65 = com.chelpus.Utils.rework(r65);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0aca:
        r2 = "[ \t]+";
        r0 = r65;
        r2 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r55 = r0;
        r2 = "[ \t]+";
        r0 = r65;
        r55 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r55;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r6 = new int[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r55;
        r2 = r0.length;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r5 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r62 = 0;
    L_0x0aeb:
        r0 = r55;
        r2 = r0.length;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r0 = r62;
        if (r0 < r2) goto L_0x1785;
    L_0x0af2:
        if (r30 == 0) goto L_0x0afb;
    L_0x0af4:
        r57 = 0;
        r2 = "Error LP: Dimensions of the original hex-string and repleced must be >3.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0afb:
        if (r30 != 0) goto L_0x0b10;
    L_0x0afd:
        r68 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = group;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 1;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r68;
        r0.add(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        group = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0b10:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "replace_from_file";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0bc6;
    L_0x0b1a:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "{";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0bc6;
    L_0x0b24:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "}";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0bc6;
    L_0x0b2e:
        r39 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x1884 }
        r2 = r63[r54];	 Catch:{ JSONException -> 0x1884 }
        r0 = r39;
        r0.<init>(r2);	 Catch:{ JSONException -> 0x1884 }
        r2 = "replace_from_file";
        r0 = r39;
        r65 = r0.getString(r2);	 Catch:{ JSONException -> 0x1884 }
    L_0x0b3f:
        r65 = r65.trim();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r13 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 1;
        r8 = r72[r8];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = com.chelpus.Utils.getDirs(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "/";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r65;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r13.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r65;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0b81;
    L_0x0b7a:
        r13 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r65;
        r13.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0b81:
        r68 = r13.length();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r68;
        r0 = (int) r0;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r40 = r0;
        r0 = r40;
        r5 = new byte[r0];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r23 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x188c, FileNotFoundException -> 0x0c25 }
        r0 = r23;
        r0.<init>(r13);	 Catch:{ Exception -> 0x188c, FileNotFoundException -> 0x0c25 }
    L_0x0b95:
        r0 = r23;
        r2 = r0.read(r5);	 Catch:{ Exception -> 0x188c, FileNotFoundException -> 0x0c25 }
        if (r2 > 0) goto L_0x0b95;
    L_0x0b9d:
        r23.close();	 Catch:{ Exception -> 0x188c, FileNotFoundException -> 0x0c25 }
    L_0x0ba0:
        r0 = r40;
        r6 = new int[r0];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 1;
        java.util.Arrays.fill(r6, r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r30 == 0) goto L_0x0bb1;
    L_0x0baa:
        r57 = 0;
        r2 = "Error LP: Patterns original and replaced not valid!\n- Dimensions of the original hex-string and repleced must be >3.\n- Dimensions of the original hex-string and repleced must be equal.\n- Pattern hex must be: AF 11 4B ** AA **\nCheck the template file and try again!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0bb1:
        if (r30 != 0) goto L_0x0bc6;
    L_0x0bb3:
        r68 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = group;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r68;
        r0.add(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        group = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0bc6:
        r2 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toUpperCase();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "[ADD-BOOT]";
        r2 = r2.contains(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0bdd;
    L_0x0bd4:
        r2 = multi_patch;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0bdd;
    L_0x0bd8:
        r2 = "Patch on Reboot added!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0bdd:
        if (r29 == 0) goto L_0x0bf8;
    L_0x0bdf:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = java.lang.String.valueOf(r34);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r63[r54];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r34 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0bf8:
        r2 = "[END]";
        r0 = r22;
        r2 = r0.contains(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0c09;
    L_0x0c02:
        r2 = 4;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r34 = "";
        r29 = 1;
    L_0x0c09:
        r54 = r54 + 1;
        goto L_0x0182;
    L_0x0c0d:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r15);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0c25:
        r28 = move-exception;
        r2 = "Custom Patch not Found. Put info about SuperSu.";
        addToLog(r2);	 Catch:{ Exception -> 0x022f }
        goto L_0x0219;
    L_0x0c2d:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r34;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r34 = "";
        goto L_0x0382;
    L_0x0c49:
        r2 = "\n****************************************";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Run next custom patch:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "****************************************\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0c5e:
        r28 = move-exception;
        r28.printStackTrace();	 Catch:{ Exception -> 0x022f }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x022f }
        r2.<init>();	 Catch:{ Exception -> 0x022f }
        r0 = r28;
        r2 = r2.append(r0);	 Catch:{ Exception -> 0x022f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x022f }
        addToLog(r2);	 Catch:{ Exception -> 0x022f }
        goto L_0x0219;
    L_0x0c76:
        r2 = odexpatch;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0cd0;
    L_0x0c7a:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = dirapp;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0382;
    L_0x0c90:
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "classes.dex not found!\nApply patch for odex:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0cae;
    L_0x0ca9:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0cae:
        r2 = manualpatch;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0cb8;
    L_0x0cb2:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0cb8:
        if (r57 != 0) goto L_0x0cbc;
    L_0x0cba:
        r61 = 0;
    L_0x0cbc:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0cd0:
        r2 = unpack;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0d60;
    L_0x0cd4:
        r2 = 2;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        searchDalvik(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = dirapp;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0d18;
    L_0x0cec:
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.getName();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = ".odex";
        r2 = r2.endsWith(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0d18;
    L_0x0cfa:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = dirapp;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.delete();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "odex file removed before\npatch for dalvik-cache...";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0d18:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0382;
    L_0x0d20:
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Patch for dalvik-cache:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0d3e;
    L_0x0d39:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0d3e:
        r2 = manualpatch;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0d48;
    L_0x0d42:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0d48:
        if (r57 != 0) goto L_0x0d4c;
    L_0x0d4a:
        r61 = 0;
    L_0x0d4c:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0d60:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0382;
    L_0x0d64:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0382;
    L_0x0d6c:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 1;
        if (r2 <= r7) goto L_0x0d78;
    L_0x0d75:
        r2 = 1;
        multidex = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0d78:
        r2 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0d7e:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x0d9e;
    L_0x0d84:
        r2 = 0;
        multidex = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0d9e:
        r18 = r2.next();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r18 = (java.io.File) r18;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r18;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 <= 0) goto L_0x0d7e;
    L_0x0dae:
        r7 = "---------------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "Patch for ";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r18.getName();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x0de3;
    L_0x0dde:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0de3:
        r7 = manualpatch;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x0ded;
    L_0x0de7:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0ded:
        if (r57 != 0) goto L_0x0d7e;
    L_0x0def:
        r61 = 0;
        goto L_0x0d7e;
    L_0x0df2:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0e25;
    L_0x0dfd:
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Dalvik-cache fixed to odex!\nPatch for odex:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0e1b;
    L_0x0e16:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0e1b:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r57 != 0) goto L_0x0e25;
    L_0x0e23:
        r61 = 0;
    L_0x0e25:
        r2 = "---------------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Dalvik-cache fixed to odex!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0e43;
    L_0x0e3e:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0e43:
        r2 = unpack;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x0e4d;
    L_0x0e47:
        r2 = 2;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        searchDalvik(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0e4d:
        r2 = 0;
        r2 = r72[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 2;
        r7 = r72[r7];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        searchDalvikOdex(r2, r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0e66;
    L_0x0e5e:
        r20 = 1;
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r21 = r2.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0e66:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0e7a:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0ea8;
    L_0x0e85:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0ea8;
    L_0x0e89:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0ea8;
    L_0x0e91:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0e97:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x0ebc;
    L_0x0e9d:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0ea8:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0ebc:
        r41 = r2.next();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r41 = (java.io.File) r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "Patch for libraries \n";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x0efb;
    L_0x0ef6:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0efb:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r57 != 0) goto L_0x0e97;
    L_0x0f03:
        r61 = 0;
        goto L_0x0e97;
    L_0x0f06:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0f34;
    L_0x0f11:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0f34;
    L_0x0f15:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0f34;
    L_0x0f1d:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0f23:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x0f48;
    L_0x0f29:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0f34:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0f48:
        r41 = r2.next();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r41 = (java.io.File) r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "--------------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "Patch for (armeabi) libraries \n";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "--------------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x0f87;
    L_0x0f82:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0f87:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r57 != 0) goto L_0x0f23;
    L_0x0f8f:
        r61 = 0;
        goto L_0x0f23;
    L_0x0f92:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0fc0;
    L_0x0f9d:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0fc0;
    L_0x0fa1:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x0fc0;
    L_0x0fa9:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0faf:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x0fd4;
    L_0x0fb5:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x0fc0:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x0fd4:
        r41 = r2.next();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r41 = (java.io.File) r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "Patch for (armeabi-v7a) libraries \n";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x1013;
    L_0x100e:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x1013:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r57 != 0) goto L_0x0faf;
    L_0x101b:
        r61 = 0;
        goto L_0x0faf;
    L_0x101e:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x104c;
    L_0x1029:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x104c;
    L_0x102d:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x104c;
    L_0x1035:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x103b:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x1060;
    L_0x1041:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x104c:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x1060:
        r41 = r2.next();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r41 = (java.io.File) r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "Patch for (arm64-v8a) libraries \n";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x109f;
    L_0x109a:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x109f:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r57 != 0) goto L_0x103b;
    L_0x10a7:
        r61 = 0;
        goto L_0x103b;
    L_0x10aa:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x10d8;
    L_0x10b5:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x10d8;
    L_0x10b9:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x10d8;
    L_0x10c1:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x10c7:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x10ec;
    L_0x10cd:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x10d8:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x10ec:
        r41 = r2.next();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r41 = (java.io.File) r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "Patch for (MIPS) libraries \n";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x112b;
    L_0x1126:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x112b:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r57 != 0) goto L_0x10c7;
    L_0x1133:
        r61 = 0;
        goto L_0x10c7;
    L_0x1136:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x1164;
    L_0x1141:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x1164;
    L_0x1145:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x1164;
    L_0x114d:
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x1153:
        r7 = r2.hasNext();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x1178;
    L_0x1159:
        r2 = 0;
        multilib_patch = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 0;
        goodResult = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x1164:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x1178:
        r41 = r2.next();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r41 = (java.io.File) r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r41;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "Patch for (x86) libraries \n";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r8.getName();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = ":";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "---------------------------\n";
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 != 0) goto L_0x11b7;
    L_0x11b2:
        r7 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x11b7:
        r7 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r57 != 0) goto L_0x1153;
    L_0x11bf:
        r61 = 0;
        goto L_0x1153;
    L_0x11c2:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x11db;
    L_0x11cd:
        r2 = manualpatch;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x11d7;
    L_0x11d1:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x11d7:
        if (r57 != 0) goto L_0x11db;
    L_0x11d9:
        r61 = 0;
    L_0x11db:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x11ef:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Patch for odex:";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x1210;
    L_0x120b:
        r2 = searchStr;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x1210:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = dirapp;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 1;
        r7 = com.chelpus.Utils.getPlaceForOdex(r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x122b;
    L_0x1226:
        r2 = "Odex not found! Please use befor other Patch, and after run Custom Patch!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x122b:
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r68 = r2.length();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r70 = 0;
        r2 = (r68 > r70 ? 1 : (r68 == r70 ? 0 : -1));
        if (r2 != 0) goto L_0x1241;
    L_0x1237:
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.delete();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Odex not found! Please use befor other Patch, and after run Custom Patch!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x1241:
        r2 = 0;
        unpack = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.size();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 <= 0) goto L_0x1256;
    L_0x124c:
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r57 = patchProcess(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r57 != 0) goto L_0x1256;
    L_0x1254:
        r61 = 0;
    L_0x1256:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x126a:
        r2 = 0;
        convert = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.clear();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        searchStr = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x1281:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x0382;
    L_0x128d:
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "Set permissions ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r53;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " for file:\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r32;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 1;
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r53;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 2;
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x12df:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r58 = "";
        if (r32 == 0) goto L_0x1381;
    L_0x12e7:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r32;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x1381;
    L_0x12f4:
        r58 = r32;
    L_0x12f6:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r52;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r26 = com.chelpus.Utils.getDirs(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r26.mkdirs();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 1;
        r8 = "777";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 2;
        r8 = r26.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r27 = r26.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "Copy file ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r32;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " to:\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r52;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r58;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 != 0) goto L_0x139e;
    L_0x1356:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "Error: File ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r32;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " not found to dir\n";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r58;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = com.chelpus.Utils.getDirs(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x1381:
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = sddir;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = "/";
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r32;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r58 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x12f6;
    L_0x139e:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r58;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r52;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        com.chelpus.Utils.copyFile(r2, r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r52;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r2 == 0) goto L_0x1409;
    L_0x13bc:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r52;
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r68 = r2.length();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = sddir;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r32;
        r7 = r7.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r70 = r2.length();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = (r68 > r70 ? 1 : (r68 == r70 ? 0 : -1));
        if (r2 != 0) goto L_0x1409;
    L_0x13ef:
        r2 = "File copied success.";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
    L_0x13f4:
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 0;
        r8 = "chmod";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 1;
        r8 = "777";
        r2[r7] = r8;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = 2;
        r2[r7] = r52;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        com.chelpus.Utils.run_all_no_root(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x1409:
        r2 = "File copied with error. Try again.";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x13f4;
    L_0x140f:
        r2 = "---------------------------";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Patch for file from apk:\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "---------------------------\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "You must run rebuild for this application with custom patch, then patch will work.\n";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0382;
    L_0x1425:
        r64 = "Error LP: File of Database not Found!";
        goto L_0x04f5;
    L_0x1429:
        r2 = 1;
        dataBaseExist = r2;	 Catch:{ JSONException -> 0x142e }
        goto L_0x04f5;
    L_0x142e:
        r28 = move-exception;
        r2 = "Error LP: Error Name of Database read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x051f;
    L_0x1436:
        r28 = move-exception;
        r2 = java.lang.System.out;	 Catch:{ JSONException -> 0x144f }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x144f }
        r8 = "LuckyPatcher: SQL error - ";
        r7.<init>(r8);	 Catch:{ JSONException -> 0x144f }
        r0 = r28;
        r7 = r7.append(r0);	 Catch:{ JSONException -> 0x144f }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x144f }
        r2.println(r7);	 Catch:{ JSONException -> 0x144f }
        goto L_0x0568;
    L_0x144f:
        r28 = move-exception;
        r2 = "Error LP: Error SQL exec read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0568;
    L_0x1457:
        r28 = move-exception;
        r2 = "Error LP: Error name of file read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x05ac;
    L_0x145f:
        r28 = move-exception;
        r28.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Error LP: Error name of file read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x05d9;
    L_0x146a:
        r28 = move-exception;
        r2 = "Error LP: Error permissions read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x061a;
    L_0x1472:
        r28 = move-exception;
        r28.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "Error LP: Error name of file read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x063b;
    L_0x147d:
        r28 = move-exception;
        r2 = "Error LP: Error file copy read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0674;
    L_0x1485:
        r28 = move-exception;
        r2 = "Error LP: Error name of libraries read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0691;
    L_0x148d:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0711;
    L_0x1493:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0738;
    L_0x1499:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0760;
    L_0x149f:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0788;
    L_0x14a5:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        tag = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x07b0;
    L_0x14ab:
        r28 = move-exception;
        r2 = "Error LP: Error original hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = "";
        group = r2;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x085d;
    L_0x14b7:
        r18 = r2.next();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r18 = (java.io.File) r18;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        localFile2 = r18;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = searchProcess(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        if (r7 == 0) goto L_0x0888;
    L_0x14c7:
        r61 = 1;
        r47 = 0;
        goto L_0x088e;
    L_0x14cd:
        r2 = ser;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r61 = searchProcess(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r47 = 0;
        goto L_0x088e;
    L_0x14d7:
        r28 = move-exception;
        r2 = "Error LP: Error original hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x089f;
    L_0x14df:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "*";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x14f9;
    L_0x14e9:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x14f9;
    L_0x14f3:
        r30 = 1;
        r2 = "60";
        r51[r62] = r2;	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
    L_0x14f9:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x150d;
    L_0x1503:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "\\?+";
        r2 = r2.matches(r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1574;
    L_0x150d:
        r2 = "60";
        r51[r62] = r2;	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r2 = 1;
        r4[r62] = r2;	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
    L_0x1514:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "W";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x153c;
    L_0x151e:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "w";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x153c;
    L_0x1528:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x153c;
    L_0x1532:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "r";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1562;
    L_0x153c:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "w";
        r8 = "";
        r2 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = "r";
        r8 = "";
        r50 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r2 = java.lang.Integer.valueOf(r50);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r67 = r2.intValue();	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r67 = r67 + 2;
        r4[r62] = r67;	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r2 = "60";
        r51[r62] = r2;	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
    L_0x1562:
        r2 = r51[r62];	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r7 = 16;
        r2 = java.lang.Integer.valueOf(r2, r7);	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r2 = r2.byteValue();	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r3[r62] = r2;	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        r62 = r62 + 1;
        goto L_0x08cc;
    L_0x1574:
        r2 = 0;
        r4[r62] = r2;	 Catch:{ Exception -> 0x1578, FileNotFoundException -> 0x0c25 }
        goto L_0x1514;
    L_0x1578:
        r28 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r28;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x08d3;
    L_0x158f:
        r28 = move-exception;
        r2 = "Error LP: Error number by object!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0902;
    L_0x1597:
        r60 = "Object not found!\n\n";
        addToLog(r60);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r61 = 0;
        goto L_0x0985;
    L_0x15a0:
        r28 = move-exception;
        r2 = "Error LP: Error search hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x09b7;
    L_0x15a8:
        r2 = r51[r62];	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r7 = "*";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x15c2;
    L_0x15b2:
        r2 = r51[r62];	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x15c2;
    L_0x15bc:
        r30 = 1;
        r2 = "60";
        r51[r62] = r2;	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
    L_0x15c2:
        r2 = r51[r62];	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x15d6;
    L_0x15cc:
        r2 = r51[r62];	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r7 = "\\?+";
        r2 = r2.matches(r7);	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1617;
    L_0x15d6:
        r2 = "60";
        r51[r62] = r2;	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r2 = 1;
        r4[r62] = r2;	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
    L_0x15dd:
        r2 = r51[r62];	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r2 = r2.toUpperCase();	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1605;
    L_0x15eb:
        r2 = r51[r62];	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r7 = "R";
        r8 = "";
        r50 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r2 = java.lang.Integer.valueOf(r50);	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r67 = r2.intValue();	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r67 = r67 + 2;
        r4[r62] = r67;	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r2 = "60";
        r51[r62] = r2;	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
    L_0x1605:
        r2 = r51[r62];	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r7 = 16;
        r2 = java.lang.Integer.valueOf(r2, r7);	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r2 = r2.byteValue();	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r3[r62] = r2;	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        r62 = r62 + 1;
        goto L_0x09e4;
    L_0x1617:
        r2 = 0;
        r4[r62] = r2;	 Catch:{ Exception -> 0x161b, FileNotFoundException -> 0x0c25 }
        goto L_0x15dd;
    L_0x161b:
        r28 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r28;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x09eb;
    L_0x1632:
        r47 = 1;
        r44 = new com.android.vending.billing.InAppBillingService.LOCK.SearchItem;	 Catch:{ Exception -> 0x164b, FileNotFoundException -> 0x0c25 }
        r0 = r44;
        r0.<init>(r3, r4);	 Catch:{ Exception -> 0x164b, FileNotFoundException -> 0x0c25 }
        r2 = r3.length;	 Catch:{ Exception -> 0x164b, FileNotFoundException -> 0x0c25 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x164b, FileNotFoundException -> 0x0c25 }
        r0 = r44;
        r0.repByte = r2;	 Catch:{ Exception -> 0x164b, FileNotFoundException -> 0x0c25 }
        r2 = ser;	 Catch:{ Exception -> 0x164b, FileNotFoundException -> 0x0c25 }
        r0 = r44;
        r2.add(r0);	 Catch:{ Exception -> 0x164b, FileNotFoundException -> 0x0c25 }
        goto L_0x09f4;
    L_0x164b:
        r28 = move-exception;
        r28.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r28;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x09f4;
    L_0x1665:
        r28 = move-exception;
        r2 = "Error LP: Error replaced hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0a23;
    L_0x166d:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "*";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1687;
    L_0x1677:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x1687;
    L_0x1681:
        r30 = 1;
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
    L_0x1687:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x169b;
    L_0x1691:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "\\?+";
        r2 = r2.matches(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1750;
    L_0x169b:
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = 0;
        r6[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
    L_0x16a2:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "sq";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x16b8;
    L_0x16b0:
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = 253; // 0xfd float:3.55E-43 double:1.25E-321;
        r6[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
    L_0x16b8:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "s1";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x16cc;
    L_0x16c2:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "S1";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x16d4;
    L_0x16cc:
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = 254; // 0xfe float:3.56E-43 double:1.255E-321;
        r6[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
    L_0x16d4:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "s0";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x16e8;
    L_0x16de:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "S0";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x16f0;
    L_0x16e8:
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
    L_0x16f0:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "W";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x1718;
    L_0x16fa:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "w";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x1718;
    L_0x1704:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x1718;
    L_0x170e:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x173e;
    L_0x1718:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "w";
        r8 = "";
        r2 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = "r";
        r8 = "";
        r50 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = java.lang.Integer.valueOf(r50);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r67 = r2.intValue();	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r67 = r67 + 2;
        r6[r62] = r67;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
    L_0x173e:
        r2 = r55[r62];	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r7 = 16;
        r2 = java.lang.Integer.valueOf(r2, r7);	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r2 = r2.byteValue();	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r5[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        r62 = r62 + 1;
        goto L_0x0a50;
    L_0x1750:
        r2 = 1;
        r6[r62] = r2;	 Catch:{ Exception -> 0x1755, FileNotFoundException -> 0x0c25 }
        goto L_0x16a2;
    L_0x1755:
        r28 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r28;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0a57;
    L_0x176c:
        r68 = pat;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = group;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r68;
        r0.add(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0a8b;
    L_0x177d:
        r28 = move-exception;
        r2 = "Error LP: Error insert hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0abe;
    L_0x1785:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "*";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x179f;
    L_0x178f:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x179f;
    L_0x1799:
        r30 = 1;
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
    L_0x179f:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "**";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x17b3;
    L_0x17a9:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "\\?+";
        r2 = r2.matches(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1868;
    L_0x17b3:
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = 0;
        r6[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
    L_0x17ba:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "sq";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x17d0;
    L_0x17c8:
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = 253; // 0xfd float:3.55E-43 double:1.25E-321;
        r6[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
    L_0x17d0:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "s1";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x17e4;
    L_0x17da:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "S1";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x17ec;
    L_0x17e4:
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = 254; // 0xfe float:3.56E-43 double:1.255E-321;
        r6[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
    L_0x17ec:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "s0";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x1800;
    L_0x17f6:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "S0";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1808;
    L_0x1800:
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
    L_0x1808:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "W";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x1830;
    L_0x1812:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "w";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x1830;
    L_0x181c:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 != 0) goto L_0x1830;
    L_0x1826:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "R";
        r2 = r2.contains(r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        if (r2 == 0) goto L_0x1856;
    L_0x1830:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "w";
        r8 = "";
        r2 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = "r";
        r8 = "";
        r50 = r2.replace(r7, r8);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = java.lang.Integer.valueOf(r50);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r67 = r2.intValue();	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r67 = r67 + 2;
        r6[r62] = r67;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = "60";
        r55[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
    L_0x1856:
        r2 = r55[r62];	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r7 = 16;
        r2 = java.lang.Integer.valueOf(r2, r7);	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r2 = r2.byteValue();	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r5[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        r62 = r62 + 1;
        goto L_0x0aeb;
    L_0x1868:
        r2 = 1;
        r6[r62] = r2;	 Catch:{ Exception -> 0x186d, FileNotFoundException -> 0x0c25 }
        goto L_0x17ba;
    L_0x186d:
        r28 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r7 = " ";
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r0 = r28;
        r2 = r2.append(r0);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0af2;
    L_0x1884:
        r28 = move-exception;
        r2 = "Error LP: Error replaced hex read!";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0b3f;
    L_0x188c:
        r28 = move-exception;
        r28.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x0ba0;
    L_0x1892:
        r2 = "Custom Patch not valid for this Version of the Programm or already patched. ";
        addToLog(r2);	 Catch:{ FileNotFoundException -> 0x0c25, Exception -> 0x0c5e }
        goto L_0x01aa;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.custompatch.main(java.lang.String[]):void");
    }

    public static boolean patchProcess(java.util.ArrayList<com.android.vending.billing.InAppBillingService.LOCK.PatchesItem> r32) {
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
        r26 = 1;
        r20 = 0;
        if (r32 == 0) goto L_0x0016;
    L_0x0006:
        r3 = r32.size();
        if (r3 <= 0) goto L_0x0016;
    L_0x000c:
        r3 = r32.iterator();
    L_0x0010:
        r4 = r3.hasNext();
        if (r4 != 0) goto L_0x00d0;
    L_0x0016:
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
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = localFile2;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = "rw";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = "Size file:";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = r2.size();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        com.chelpus.Utils.sendFromRootCP(r3);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = 0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r17 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r32.toArray();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[r3];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r27 = r0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r32.size();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[r3];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r27 = r0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r0 = r32;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r1 = r27;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r27 = r0.toArray(r1);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r27 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItem[]) r27;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r13 = -1;
        r28 = 0;
        r8 = 0;
    L_0x007f:
        r3 = r17.hasRemaining();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 == 0) goto L_0x0087;
    L_0x0085:
        if (r8 == 0) goto L_0x0109;
    L_0x0087:
        r2.close();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = "Analise Results:";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        com.chelpus.Utils.sendFromRootCP(r3);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r18 = 0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0091:
        r0 = r27;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r0 = r18;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r0 < r3) goto L_0x036d;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0098:
        r18 = 0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x009a:
        r0 = r27;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r0 = r18;
        if (r0 < r3) goto L_0x03a1;
    L_0x00a1:
        r3 = tag;
        r4 = 1;
        if (r3 != r4) goto L_0x00aa;
    L_0x00a6:
        r3 = unpack;
        if (r3 == 0) goto L_0x00b0;
    L_0x00aa:
        r3 = tag;
        r4 = 10;
        if (r3 != r4) goto L_0x00bb;
    L_0x00b0:
        r3 = ART;
        if (r3 != 0) goto L_0x00bb;
    L_0x00b4:
        r3 = localFile2;
        r4 = dirapp;
        com.chelpus.Utils.fixadlerOdex(r3, r4);
    L_0x00bb:
        r3 = unpack;
        if (r3 == 0) goto L_0x00cf;
    L_0x00bf:
        r3 = odexpatch;
        if (r3 != 0) goto L_0x00cf;
    L_0x00c3:
        r3 = OdexPatch;
        if (r3 != 0) goto L_0x00cf;
    L_0x00c7:
        r3 = localFile2;
        com.chelpus.Utils.fixadler(r3);
        r3 = 1;
        fixunpack = r3;
    L_0x00cf:
        return r26;
    L_0x00d0:
        r21 = r3.next();
        r21 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItem) r21;
        r4 = 0;
        r0 = r21;
        r0.result = r4;
        r4 = tag;
        r5 = 1;
        if (r4 != r5) goto L_0x0010;
    L_0x00e0:
        r4 = multidex;
        if (r4 == 0) goto L_0x0010;
    L_0x00e4:
        r0 = r21;
        r4 = r0.group;
        r5 = "";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0010;
    L_0x00f0:
        r4 = new java.lang.StringBuilder;
        r5 = "multi_";
        r4.<init>(r5);
        r0 = r20;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r0 = r21;
        r0.group = r4;
        r20 = r20 + 1;
        goto L_0x0010;
    L_0x0109:
        r3 = r17.position();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3 - r28;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 512000; // 0x7d000 float:7.17465E-40 double:2.529616E-318;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 <= r4) goto L_0x012e;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0114:
        r3 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = "Progress size:";	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3.<init>(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r17.position();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.toString();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        com.chelpus.Utils.sendFromRootCP(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r28 = r17.position();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x012e:
        r3 = r13 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r17;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0.position(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r13 = r17.position();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r12 = r17.get();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r18 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x013f:
        r0 = r27;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r0.length;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r18;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r0 >= r3) goto L_0x007f;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0146:
        r0 = r17;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0.position(r13);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r12 == r3) goto L_0x017f;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0154:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 == r4) goto L_0x017f;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x015e:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r4];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 <= r4) goto L_0x01be;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0168:
        r3 = search;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r5 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4[r5];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.get(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = (java.lang.Byte) r3;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.byteValue();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r12 != r3) goto L_0x01be;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x017f:
        r19 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r13 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r17;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0.position(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r29 = r12;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x018a:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r29;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r0 == r3) goto L_0x01c2;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0194:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 <= r4) goto L_0x01b5;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x019d:
        r3 = search;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4[r19];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.get(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = (java.lang.Byte) r3;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.byteValue();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r29;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r0 == r3) goto L_0x01c2;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x01b5:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 == r4) goto L_0x01c2;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x01be:
        r18 = r18 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        goto L_0x013f;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x01c2:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r19;
        if (r0 >= r3) goto L_0x0248;
    L_0x01cb:
        r3 = r27[r18];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        if (r3 != 0) goto L_0x01d9;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
    L_0x01d3:
        r3 = r27[r18];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3[r19] = r29;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
    L_0x01d9:
        r3 = r27[r18];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r4 = 1;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        if (r3 <= r4) goto L_0x0208;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
    L_0x01e2:
        r3 = r27[r18];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r4 = 253; // 0xfd float:3.55E-43 double:1.25E-321;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        if (r3 >= r4) goto L_0x0208;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
    L_0x01ec:
        r3 = r27[r18];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3.repMask;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r31 = r3 + -2;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r27[r18];	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r4 = r3.repByte;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = search;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r0 = r31;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3.get(r0);	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = (java.lang.Byte) r3;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r3 = r3.byteValue();	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
        r4[r19] = r3;	 Catch:{ Exception -> 0x031b, IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, FileNotFoundException -> 0x0313 }
    L_0x0208:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 253; // 0xfd float:3.55E-43 double:1.25E-321;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 != r4) goto L_0x0220;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0212:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r29 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r5 = r29 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r5 = r5 * 16;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4 + r5;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3[r19] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0220:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 254; // 0xfe float:3.56E-43 double:1.255E-321;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 != r4) goto L_0x0235;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x022a:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r29 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4 + 16;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3[r19] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0235:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 != r4) goto L_0x0248;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x023f:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r29 & 15;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3[r19] = r4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0248:
        r19 = r19 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r19;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r0 != r3) goto L_0x0367;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0253:
        r16 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r3.origMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r5 = r4.length;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x025b:
        if (r3 < r5) goto L_0x034f;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x025d:
        if (r16 != 0) goto L_0x0260;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x025f:
        r8 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0260:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.insert;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 != 0) goto L_0x0272;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0266:
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4.length;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r3 == r4) goto L_0x02c4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0272:
        r25 = r17.position();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r2.size();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = (int) r4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r22 = r3 - r25;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r22;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r10 = new byte[r0];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r17;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r1 = r22;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0.get(r10, r3, r1);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r11 = java.nio.ByteBuffer.wrap(r10);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r30 = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.origByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r3.length;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r24 = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r14 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r30;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r1 = r24;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r0 < r1) goto L_0x035b;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x02a2:
        r3 = r30 - r24;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3 + r25;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = (long) r3;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r2.position(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x02aa:
        r2.write(r11);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r2.size();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r6 = (long) r14;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r4 - r6;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r2.truncate(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r6 = r2.size();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r6 = (int) r6;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r6 = (long) r6;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r17 = r2.map(r3, r4, r6);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x02c4:
        r4 = (long) r13;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r2.position(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repByte;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r11 = java.nio.ByteBuffer.wrap(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r2.write(r11);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r17.force();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = "\nPattern N";	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3.<init>(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = r18 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = ": Patch done! \n(Offset: ";	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = java.lang.Integer.toHexString(r13);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = ")\n";	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.toString();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        addToLog(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3.result = r4;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        patchteil = r3;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        goto L_0x01be;
    L_0x0308:
        r15 = move-exception;
        r15.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = "Byte by search not found! Please edit pattern for search.\n";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        goto L_0x0087;
    L_0x0313:
        r23 = move-exception;
        r3 = "Error LP: Program files are not found!\nMove Program to internal storage.";
        addToLog(r3);
        goto L_0x00a1;
    L_0x031b:
        r15 = move-exception;
        r3 = r27[r18];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.repMask;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3[r19];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r31 = r3 + -2;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = "Byte N";	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3.<init>(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r31;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = " not found! Please edit search pattern for byte ";	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r0 = r31;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = ".";	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r3.toString();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        addToLog(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        goto L_0x0208;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x034c:
        r3 = move-exception;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        goto L_0x0087;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x034f:
        r9 = r4[r3];	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        if (r9 != 0) goto L_0x0357;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0353:
        r16 = 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        goto L_0x025d;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0357:
        r3 = r3 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        goto L_0x025b;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x035b:
        r3 = r24 - r30;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r3 = r25 - r3;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r4 = (long) r3;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r2.position(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        r14 = r24 - r30;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        goto L_0x02aa;	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
    L_0x0367:
        r29 = r17.get();	 Catch:{ IndexOutOfBoundsException -> 0x0308, BufferUnderflowException -> 0x034c, Exception -> 0x0486, FileNotFoundException -> 0x0313 }
        goto L_0x018a;
    L_0x036d:
        r3 = r27[r18];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 == 0) goto L_0x0385;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0373:
        r3 = r27[r18];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.group;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = "";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 != 0) goto L_0x0385;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x037f:
        r0 = r27;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = r0.length;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = 0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0383:
        if (r3 < r4) goto L_0x0389;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0385:
        r18 = r18 + 1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        goto L_0x0091;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0389:
        r25 = r27[r3];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r0 = r25;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = r0.group;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r6 = r27[r18];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r6 = r6.group;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = r5.equals(r6);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r5 == 0) goto L_0x039e;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0399:
        r5 = 1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r0 = r25;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r0.groupResult = r5;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x039e:
        r3 = r3 + 1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        goto L_0x0383;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x03a1:
        r3 = r27[r18];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 != 0) goto L_0x0449;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x03a7:
        r3 = r27[r18];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.group;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = "";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 != 0) goto L_0x044d;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x03b3:
        r3 = r27[r18];	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.groupResult;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 != 0) goto L_0x0449;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x03b9:
        r3 = multidex;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 == 0) goto L_0x03ef;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x03bd:
        r3 = localFile2;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = r5.size();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = r5 + -1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = r4.get(r5);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 == 0) goto L_0x03ef;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x03d3:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = r18 + 1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r26 = 0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x03ef:
        r3 = multilib_patch;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 == 0) goto L_0x0425;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x03f3:
        r3 = localFile2;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = arrayFile2;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = r5.size();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r5 = r5 + -1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = r4.get(r5);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 == 0) goto L_0x0425;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0409:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = r18 + 1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r26 = 0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0425:
        r3 = multidex;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 != 0) goto L_0x0449;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0429:
        r3 = multilib_patch;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        if (r3 != 0) goto L_0x0449;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x042d:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = r18 + 1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r26 = 0;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x0449:
        r18 = r18 + 1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        goto L_0x009a;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
    L_0x044d:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = "\nPattern N";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = r18 + 1;	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r4 = ":\nError LP: Pattern not found!\nor patch is already applied?!\n";	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x0313, BufferUnderflowException -> 0x0483, Exception -> 0x046a }
        r26 = 0;
        goto L_0x0449;
    L_0x046a:
        r15 = move-exception;
        r3 = new java.lang.StringBuilder;
        r4 = "Exception e";
        r3.<init>(r4);
        r4 = r15.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        addToLog(r3);
        goto L_0x00a1;
    L_0x0483:
        r3 = move-exception;
        goto L_0x00a1;
    L_0x0486:
        r3 = move-exception;
        goto L_0x0087;
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
        if (r24 == 0) goto L_0x0018;
    L_0x0008:
        r3 = r24.size();
        if (r3 <= 0) goto L_0x0018;
    L_0x000e:
        r3 = r24.iterator();
    L_0x0012:
        r4 = r3.hasNext();
        if (r4 != 0) goto L_0x0066;
    L_0x0018:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = localFile2;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r5 = "rw";
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r12 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r24.toArray();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.SearchItem[r3];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r20 = r0;
        r3 = r24.size();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.SearchItem[r3];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r20 = r0;
        r0 = r24;
        r1 = r20;
        r20 = r0.toArray(r1);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r20 = (com.android.vending.billing.InAppBillingService.LOCK.SearchItem[]) r20;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r16 = 0;
    L_0x0050:
        r3 = r12.hasRemaining();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r3 != 0) goto L_0x0070;
    L_0x0056:
        r2.close();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r13 = 0;
    L_0x005a:
        r0 = r20;
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        if (r13 < r3) goto L_0x011a;
    L_0x005f:
        r13 = 0;
    L_0x0060:
        r0 = r20;
        r3 = r0.length;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        if (r13 < r3) goto L_0x014f;
    L_0x0065:
        return r19;
    L_0x0066:
        r15 = r3.next();
        r15 = (com.android.vending.billing.InAppBillingService.LOCK.SearchItem) r15;
        r4 = 0;
        r15.result = r4;
        goto L_0x0012;
    L_0x0070:
        r10 = r12.position();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r9 = r12.get();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r13 = 0;
    L_0x0079:
        r0 = r20;
        r3 = r0.length;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r13 < r3) goto L_0x0088;
    L_0x007e:
        r3 = r10 + 1;
        r12.position(r3);	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = 1;
        r16 = r16 + r4;
        goto L_0x0050;
    L_0x0088:
        r12.position(r10);	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.result;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r3 != 0) goto L_0x00d5;
    L_0x0091:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r9 == r3) goto L_0x00a3;
    L_0x009a:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r3 == 0) goto L_0x00d5;
    L_0x00a3:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r3 == 0) goto L_0x00b3;
    L_0x00ac:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = 0;
        r3[r4] = r9;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
    L_0x00b3:
        r14 = 1;
        r3 = r10 + 1;
        r12.position(r3);	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r21 = r12.get();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
    L_0x00bd:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.result;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r3 != 0) goto L_0x00cd;
    L_0x00c3:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r0 = r21;
        if (r0 == r3) goto L_0x00d8;
    L_0x00cd:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r3 != 0) goto L_0x00d8;
    L_0x00d5:
        r13 = r13 + 1;
        goto L_0x0079;
    L_0x00d8:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.origMask;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3[r14];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r3 <= 0) goto L_0x00e6;
    L_0x00e0:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.repByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3[r14] = r21;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
    L_0x00e6:
        r14 = r14 + 1;
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.origByte;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = r3.length;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        if (r14 != r3) goto L_0x0115;
    L_0x00ef:
        r3 = r20[r13];	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = 1;
        r3.result = r4;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r3 = 1;
        patchteil = r3;	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        goto L_0x00d5;
    L_0x00f8:
        r11 = move-exception;
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = "Search byte error: ";
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.append(r11);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        addToLog(r3);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        goto L_0x0056;
    L_0x010d:
        r18 = move-exception;
        r3 = "Error LP: Program files are not found!\nMove Program to internal storage.";
        addToLog(r3);
        goto L_0x0065;
    L_0x0115:
        r21 = r12.get();	 Catch:{ Exception -> 0x00f8, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        goto L_0x00bd;
    L_0x011a:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        if (r3 != 0) goto L_0x014b;
    L_0x0120:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = "Bytes by serach N";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = r13 + 1;
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = ":\nError LP: Bytes not found!";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = "\n";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r19 = 0;
    L_0x014b:
        r13 = r13 + 1;
        goto L_0x005a;
    L_0x014f:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        if (r3 == 0) goto L_0x017e;
    L_0x0155:
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = "\nBytes by search N";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = r13 + 1;
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = ":";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = "\n";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
    L_0x017e:
        r22 = 0;
    L_0x0180:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.length;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r0 = r22;
        if (r0 < r3) goto L_0x01a4;
    L_0x0189:
        r3 = searchStr;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4.<init>(r3);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = "\n";
        r3 = r4.append(r3);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r13 = r13 + 1;
        goto L_0x0060;
    L_0x01a4:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3[r22];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = 1;
        if (r3 <= r4) goto L_0x0215;
    L_0x01ad:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.origMask;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3[r22];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r23 = r3 + -2;
        r3 = search;	 Catch:{ Exception -> 0x0219, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = r20[r13];	 Catch:{ Exception -> 0x0219, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = r4.repByte;	 Catch:{ Exception -> 0x0219, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = r4[r22];	 Catch:{ Exception -> 0x0219, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r4 = java.lang.Byte.valueOf(r4);	 Catch:{ Exception -> 0x0219, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
        r0 = r23;
        r3.set(r0, r4);	 Catch:{ Exception -> 0x0219, FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c }
    L_0x01c6:
        r3 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.result;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        if (r3 == 0) goto L_0x0215;
    L_0x01cc:
        r3 = 1;
        r8 = new byte[r3];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = 0;
        r3 = search;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r0 = r23;
        r3 = r3.get(r0);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = (java.lang.Byte) r3;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.byteValue();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r8[r4] = r3;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = searchStr;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = "R";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r0 = r23;
        r3 = r3.append(r0);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = "=";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = com.chelpus.Utils.bytesToHex(r8);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = r4.toUpperCase();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = " ";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        searchStr = r3;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
    L_0x0215:
        r22 = r22 + 1;
        goto L_0x0180;
    L_0x0219:
        r11 = move-exception;
        r3 = search;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = r20[r13];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = r4.repByte;	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = r4[r22];	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r4 = java.lang.Byte.valueOf(r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        r0 = r23;
        r3.add(r0, r4);	 Catch:{ FileNotFoundException -> 0x010d, BufferUnderflowException -> 0x022c, Exception -> 0x0245 }
        goto L_0x01c6;
    L_0x022c:
        r11 = move-exception;
        r3 = new java.lang.StringBuilder;
        r4 = "Exception e";
        r3.<init>(r4);
        r4 = r11.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        addToLog(r3);
        goto L_0x0065;
    L_0x0245:
        r11 = move-exception;
        r3 = new java.lang.StringBuilder;
        r4 = "Exception e";
        r3.<init>(r4);
        r4 = r11.toString();
        r3 = r3.append(r4);
        r3 = r3.toString();
        addToLog(r3);
        goto L_0x0065;
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
                addToLog(e);
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
            pakDirs.add(new StringBuilder(String.valueOf(pkgName)).append("-1").toString());
            pakDirs.add(new StringBuilder(String.valueOf(pkgName)).append("-2").toString());
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
                    d = new File(new StringBuilder(String.valueOf(dir)).append(pkgName).append(index).append(InternalZipConstants.ZIP_FILE_SEPARATOR).toString());
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
                    File d1 = new File(new StringBuilder(String.valueOf(dir)).append(pkgName).append(InternalZipConstants.ZIP_FILE_SEPARATOR).toString());
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
                        d = new File(new StringBuilder(String.valueOf(dir)).append((String) it2.next()).toString());
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
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 == 0) goto L_0x001b;
    L_0x000b:
        r7 = "/mnt/sdcard";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x001b;
    L_0x0013:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x001a:
        return;
    L_0x001b:
        r7 = "/mnt/sdcard";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x002b;
    L_0x0023:
        r7 = "/sdcard";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 == 0) goto L_0x0129;
    L_0x002b:
        r5 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r5.<init>();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "/mnt/sdcard/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "/storage/emulated/legacy/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "/storage/emulated/0/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "/storage/sdcard0/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "/storage/sdcard/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "/storage/sdcard1/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "/sdcard/";
        r5.add(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r5.iterator();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x0057:
        r8 = r7.hasNext();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r8 != 0) goto L_0x0085;
    L_0x005d:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x001a;
    L_0x0065:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x006b:
        r1 = move-exception;
        r7 = new java.lang.StringBuilder;
        r8 = "Error LP: ";
        r7.<init>(r8);
        r7 = r7.append(r12);
        r8 = " are not found!\n\nRun the application file to appear in the folder with the data.!\n";
        r7 = r7.append(r8);
        r7 = r7.toString();
        addToLog(r7);
        goto L_0x001a;
    L_0x0085:
        r4 = r7.next();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r4 = (java.lang.String) r4;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/mnt/sdcard/";
        r9 = r12.replace(r9, r4);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r8;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r8 == 0) goto L_0x0057;
    L_0x00a0:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r10 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9.<init>(r10);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r10 = "test.tmp";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9 = r9.toString();	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r8.<init>(r9);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r8.createNewFile();	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r10 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9.<init>(r10);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r10 = "test.tmp";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9 = r9.toString();	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r8.<init>(r9);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r8 = r8.exists();	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        if (r8 == 0) goto L_0x011e;
    L_0x00d9:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r10 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9.<init>(r10);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r10 = "test.tmp";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9 = r9.toString();	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r8.<init>(r9);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r8.delete();	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        goto L_0x005d;
    L_0x00f6:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/figjvaja_papka";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r8;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        goto L_0x0057;
    L_0x0105:
        r0 = move-exception;
        r7 = new java.lang.StringBuilder;
        r8 = "Exception e";
        r7.<init>(r8);
        r8 = r0.toString();
        r7 = r7.append(r8);
        r7 = r7.toString();
        addToLog(r7);
        goto L_0x001a;
    L_0x011e:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        r9 = "/figjvaja_papka";
        r8.<init>(r9);	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        localFile2 = r8;	 Catch:{ Exception -> 0x00f6, FileNotFoundException -> 0x006b }
        goto L_0x0057;
    L_0x0129:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/data/data/";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x016b;
    L_0x0146:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/dbdata/databases/";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x016b;
    L_0x0163:
        r7 = "/shared_prefs/";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 == 0) goto L_0x0239;
    L_0x016b:
        r3 = "";
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/data/data/";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 == 0) goto L_0x01a1;
    L_0x018a:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/data/data/";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r3 = r7.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x01a1:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/dbdata/databases/";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 == 0) goto L_0x01d5;
    L_0x01be:
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/dbdata/databases/";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = pkgName;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = "/shared_prefs/";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r3 = r7.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x01d5:
        r7 = "/shared_prefs/";
        r7 = r12.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 == 0) goto L_0x01df;
    L_0x01dd:
        r3 = "/shared_prefs/";
    L_0x01df:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/data/data/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = pkgName;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/shared_prefs/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r12.replace(r3, r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x022b;
    L_0x0209:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/dbdata/databases/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = pkgName;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/shared_prefs/";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r12.replace(r3, r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x022b:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x001a;
    L_0x0233:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x0239:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/data/data/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x027b;
    L_0x025b:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/mnt/asec/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "-1";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x027b:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x02a3;
    L_0x0283:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/mnt/asec/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "-2";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x02a3:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x02c5;
    L_0x02ab:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/mnt/asec/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x02c5:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x02e7;
    L_0x02cd:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/sd-ext/data/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x02e7:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x0309;
    L_0x02ef:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/data/sdext2/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x0309:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x032b;
    L_0x0311:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/data/sdext1/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x032b:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x034d;
    L_0x0333:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/data/sdext/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x034d:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x0383;
    L_0x0355:
        r6 = new com.chelpus.Utils;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "fgh";
        r6.<init>(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r9 = "/data/data/";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.append(r11);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r2 = r6.findFile(r7, r12);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = "";
        r7 = r2.equals(r7);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x0383;
    L_0x037c:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>(r2);	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        localFile2 = r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
    L_0x0383:
        r7 = localFile2;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        if (r7 != 0) goto L_0x001a;
    L_0x038b:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x006b, Exception -> 0x0105 }
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
            addToLog(e.toString());
        }
    }
}
