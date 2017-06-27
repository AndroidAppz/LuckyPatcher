package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.MappedByteBuffer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.tukaani.xz.common.Util;

public class runpatchsupportOld {
    private static boolean ART = false;
    public static String appdir = "/sdcard/";
    public static ArrayList<File> classesFiles = new ArrayList();
    private static boolean copyDC = false;
    private static boolean createAPK = false;
    public static File crkapk;
    public static String dir = "/sdcard/";
    public static String dir2 = "/sdcard/";
    public static String dirapp = "/data/app/";
    public static ArrayList<File> filestopatch = null;
    private static boolean pattern1 = true;
    private static boolean pattern2 = true;
    private static boolean pattern3 = true;
    public static PrintStream print;
    public static String result;
    public static String sddir = "/sdcard/";
    public static boolean system = false;
    public static String uid = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r70) {
        /*
        r9 = classesFiles;
        r9.clear();
        r55 = new com.android.vending.billing.InAppBillingService.LOCK.LogOutputStream;
        r9 = "System.out";
        r0 = r55;
        r0.<init>(r9);
        r9 = new java.io.PrintStream;
        r0 = r55;
        r9.<init>(r0);
        print = r9;
        r9 = new com.chelpus.root.utils.runpatchsupportOld$1;
        r9.<init>();
        com.chelpus.Utils.startRootJava(r9);
        r9 = 0;
        r9 = r70[r9];
        com.chelpus.Utils.kill(r9);
        r9 = print;
        r11 = "Support-Code Running!";
        r9.println(r11);
        r2 = new java.util.ArrayList;
        r2.<init>();
        r9 = 1;
        pattern1 = r9;
        r9 = 1;
        pattern2 = r9;
        r9 = 1;
        pattern3 = r9;
        r9 = new java.util.ArrayList;
        r9.<init>();
        filestopatch = r9;
        r9 = new java.io.File;	 Catch:{ Exception -> 0x053e }
        r11 = 3;
        r11 = r70[r11];	 Catch:{ Exception -> 0x053e }
        r9.<init>(r11);	 Catch:{ Exception -> 0x053e }
        r37 = r9.listFiles();	 Catch:{ Exception -> 0x053e }
        r0 = r37;
        r11 = r0.length;	 Catch:{ Exception -> 0x053e }
        r9 = 0;
    L_0x0051:
        if (r9 < r11) goto L_0x050b;
    L_0x0053:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r11 = "pattern0";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 != 0) goto L_0x0061;
    L_0x005e:
        r9 = 0;
        pattern1 = r9;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
    L_0x0061:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r11 = "pattern1";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 != 0) goto L_0x006f;
    L_0x006c:
        r9 = 0;
        pattern2 = r9;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
    L_0x006f:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r11 = "pattern2";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 != 0) goto L_0x007d;
    L_0x007a:
        r9 = 0;
        pattern3 = r9;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
    L_0x007d:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 == 0) goto L_0x0090;
    L_0x0082:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r11 = "createAPK";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 == 0) goto L_0x0090;
    L_0x008d:
        r9 = 1;
        createAPK = r9;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
    L_0x0090:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 == 0) goto L_0x00a3;
    L_0x0095:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r11 = "ART";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 == 0) goto L_0x00a3;
    L_0x00a0:
        r9 = 1;
        ART = r9;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
    L_0x00a3:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 == 0) goto L_0x00ae;
    L_0x00a8:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
    L_0x00ae:
        r9 = 7;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        if (r9 == 0) goto L_0x00b8;
    L_0x00b3:
        r9 = 7;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        uid = r9;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
    L_0x00b8:
        r9 = java.lang.System.out;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r11 = new java.lang.StringBuilder;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r12 = "uid:";
        r11.<init>(r12);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r12 = uid;	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r11 = r11.append(r12);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r11 = r11.toString();	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
        r9.println(r11);	 Catch:{ NullPointerException -> 0x1365, Exception -> 0x1362 }
    L_0x00ce:
        r9 = 5;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x135f, Exception -> 0x135c }
        r11 = "copyDC";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x135f, Exception -> 0x135c }
        if (r9 == 0) goto L_0x00dc;
    L_0x00d9:
        r9 = 1;
        copyDC = r9;	 Catch:{ NullPointerException -> 0x135f, Exception -> 0x135c }
    L_0x00dc:
        r9 = createAPK;
        if (r9 == 0) goto L_0x00e7;
    L_0x00e0:
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r9;
    L_0x00e7:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = new java.util.ArrayList;
        r5.<init>();
        r6 = new java.util.ArrayList;
        r6.<init>();
        r7 = new java.util.ArrayList;
        r7.<init>();
        r8 = new java.util.ArrayList;
        r8.<init>();
        r9 = "1A ?? FF FF";
        r3.add(r9);
        r9 = "1A ?? ?? ??";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "(pak intekekt 0)";
        r6.add(r9);
        r9 = "search_pack";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1B ?? FF FF FF FF";
        r3.add(r9);
        r9 = "1B ?? ?? ?? ?? ??";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "(pak intekekt 0)";
        r6.add(r9);
        r9 = "search_pack";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A ?? FF FF";
        r3.add(r9);
        r9 = "1A ?? ?? ??";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "(sha intekekt 2)";
        r6.add(r9);
        r9 = "search";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1B ?? FF FF FF FF";
        r3.add(r9);
        r9 = "1B ?? ?? ?? ?? ??";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "(sha intekekt 2 32 bit)";
        r6.add(r9);
        r9 = "search";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "0A ?? 39 ?? ?? 00";
        r3.add(r9);
        r9 = "12 S1 39 ?? ?? 00";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support2 Fixed!\n(sha intekekt 3)";
        r6.add(r9);
        r9 = "search";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A ?? FF FF 6E 20 ?? ?? ?? ?? 0C ??";
        r3.add(r9);
        r9 = "1A ?? ?? ?? 00 00 00 00 00 00 00 00";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(pak intekekt)";
        r6.add(r9);
        r9 = "search_pack";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A ?? FF FF 6E 20 ?? ?? ?? ??";
        r3.add(r9);
        r9 = "1A ?? ?? ?? 00 00 00 00 00 00";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(pak intekekt)";
        r6.add(r9);
        r9 = "search_pack";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A ?? FF FF 6E 20 ?? ?? ?? ??";
        r3.add(r9);
        r9 = "1A ?? ?? ?? 00 00 00 00 00 00";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(pak intekekt)";
        r6.add(r9);
        r9 = "search_pack";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1B ?? FF FF FF FF 6E 20 ?? ?? ?? ?? 0C ??";
        r3.add(r9);
        r9 = "1B ?? ?? ?? ?? ?? 00 00 00 00 00 00 00 00";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(pak intekekt 32 bit)";
        r6.add(r9);
        r9 = "search_pack";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1B ?? FF FF FF FF 6E 20 ?? ?? ?? ??";
        r3.add(r9);
        r9 = "1B ?? ?? ?? ?? ?? 00 00 00 00 00 00";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(pak intekekt 32 bit)";
        r6.add(r9);
        r9 = "search_pack";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1B ?? FF FF FF FF 6E 20 ?? ?? ?? ??";
        r3.add(r9);
        r9 = "1B ?? ?? ?? ?? ?? 00 00 00 00 00 00";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(pak intekekt 32 bit)";
        r6.add(r9);
        r9 = "search_pack";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E 20 FF FF ?? 00 0A ??";
        r3.add(r9);
        r9 = "6E 20 ?? ?? ?? 00 12 S1";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support2 Fixed!\n(sha intekekt 4)";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E 20 FF FF ?? 00";
        r3.add(r9);
        r9 = "00 00 00 00 00 00";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support3 Fixed!\n(intent for free)";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "0A ?? 39 ?? ?? ??";
        r3.add(r9);
        r9 = "12 S1 39 ?? ?? ??";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(ev1)";
        r6.add(r9);
        r9 = "search_sign_ver";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "0A ?? 38 ?? ?? ??";
        r3.add(r9);
        r9 = "12 S1 38 ?? ?? ??";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(ev1)";
        r6.add(r9);
        r9 = "search_sign_ver";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1C ?? FF FF";
        r3.add(r9);
        r9 = "1C ?? ?? ??";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support1 Fixed!\n(si)";
        r6.add(r9);
        r9 = "search_sign_ver";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "23 ?? ?? ?? 1C ?? ?? ?? 12 ?? 4D ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 39 ?? ?? ?? 1A ?? ?? ?? 1A";
        r3.add(r9);
        r9 = "23 ?? ?? ?? 1C ?? ?? ?? 12 ?? 4D ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 12 S1 39 ?? ?? ?? 1A ?? ?? ?? 1A";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support3 Fixed!\n(s)";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 72 ?? ?? ?? ?? ?? 0A ?? 39 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 12 ?? 6E";
        r3.add(r9);
        r9 = "1A ?? ?? ?? 00 00 00 00 00 00 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 72 ?? ?? ?? ?? ?? 0A ?? 39 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 12 ?? 6E";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support4 Fixed!\n(pak)";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 72 ?? ?? ?? ?? ?? 0A ?? 39 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0E 00";
        r3.add(r9);
        r9 = "1A ?? ?? ?? 00 00 00 00 00 00 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 72 ?? ?? ?? ?? ?? 0A ?? 39 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0E 00";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support4 Fixed!\n(pak)";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ?? 72 ?? ?? ?? ?? ?? 0A ?? 39 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 12 ?? 6E ?? ?? ?? ?? ?? 0E 00";
        r3.add(r9);
        r9 = "1A ?? ?? ?? 00 00 00 00 00 00 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ?? 72 ?? ?? ?? ?? ?? 0A ?? 39 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 12 ?? 6E ?? ?? ?? ?? ?? 0E 00";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support4 Fixed!\n(pak)";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = 0;
        r9 = r70[r9];
        r11 = "com.jetappfactory.";
        r9 = r9.contains(r11);
        if (r9 == 0) goto L_0x0408;
    L_0x03e3:
        r9 = "71 30 ?? ?? ?? ?? 0C ?? 6E 20 ?? ?? ?? ?? 54 ?? ?? ?? 28 ??";
        r3.add(r9);
        r9 = "71 30 ?? ?? ?? ?? 0C ?? 00 00 00 00 00 00 54 ?? ?? ?? 28 ??";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "support4 Fixed!\n(pak)";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
    L_0x0408:
        r21 = 0;
        r9 = java.lang.Boolean.valueOf(r21);
        com.chelpus.Utils.convertToPatchItemAuto(r2, r3, r4, r5, r6, r7, r8, r9);
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.booleanValue();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0421;
    L_0x0419:
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "RW";
        com.chelpus.Utils.remount(r9, r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0421:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x083a;
    L_0x0425:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x083a;
    L_0x0429:
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        dir = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        dirapp = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        clearTemp();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 4;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "not_system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0444;
    L_0x0441:
        r9 = 0;
        system = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0444:
        r9 = 4;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0452;
    L_0x044f:
        r9 = 1;
        system = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0452:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "CLASSES mode create odex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 0;
        r49 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "Get classes.dex.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Get classes.dex.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        unzipART(r17);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0490;
    L_0x0488:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x0544;
    L_0x0490:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0496:
        r44 = move-exception;
        r9 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        com.chelpus.Utils.sendFromRoot(r9);
    L_0x049c:
        r9 = filestopatch;
        r9 = r9.iterator();
    L_0x04a2:
        r11 = r9.hasNext();
        if (r11 != 0) goto L_0x134e;
    L_0x04a8:
        r9 = createAPK;
        if (r9 != 0) goto L_0x04f8;
    L_0x04ac:
        r9 = "Create ODEX:";
        com.chelpus.Utils.sendFromRoot(r9);
        r9 = 3;
        r9 = r70[r9];
        r11 = classesFiles;
        r12 = 2;
        r12 = r70[r12];
        r13 = uid;
        r14 = 2;
        r14 = r70[r14];
        r15 = uid;
        r14 = com.chelpus.Utils.getOdexForCreate(r14, r15);
        r57 = com.chelpus.Utils.create_ODEX_root(r9, r11, r12, r13, r14);
        r9 = new java.lang.StringBuilder;
        r11 = "chelpus_return_";
        r9.<init>(r11);
        r0 = r57;
        r9 = r9.append(r0);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        if (r57 != 0) goto L_0x04f8;
    L_0x04de:
        r9 = ART;
        if (r9 != 0) goto L_0x04f8;
    L_0x04e2:
        r9 = 1;
        r9 = r70[r9];
        r11 = 2;
        r11 = r70[r11];
        r12 = 2;
        r12 = r70[r12];
        r13 = 1;
        r12 = com.chelpus.Utils.getPlaceForOdex(r12, r13);
        r13 = uid;
        r14 = 3;
        r14 = r70[r14];
        com.chelpus.Utils.afterPatch(r9, r11, r12, r13, r14);
    L_0x04f8:
        r9 = "Optional Steps After Patch:";
        com.chelpus.Utils.sendFromRoot(r9);
        r9 = createAPK;
        if (r9 != 0) goto L_0x0504;
    L_0x0501:
        com.chelpus.Utils.exitFromRootJava();
    L_0x0504:
        r0 = r55;
        r9 = r0.allresult;
        result = r9;
        return;
    L_0x050b:
        r34 = r37[r9];	 Catch:{ Exception -> 0x053e }
        r12 = r34.isFile();	 Catch:{ Exception -> 0x053e }
        if (r12 == 0) goto L_0x053a;
    L_0x0513:
        r12 = r34.getName();	 Catch:{ Exception -> 0x053e }
        r13 = "busybox";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x053e }
        if (r12 != 0) goto L_0x053a;
    L_0x051f:
        r12 = r34.getName();	 Catch:{ Exception -> 0x053e }
        r13 = "reboot";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x053e }
        if (r12 != 0) goto L_0x053a;
    L_0x052b:
        r12 = r34.getName();	 Catch:{ Exception -> 0x053e }
        r13 = "dalvikvm";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x053e }
        if (r12 != 0) goto L_0x053a;
    L_0x0537:
        r34.delete();	 Catch:{ Exception -> 0x053e }
    L_0x053a:
        r9 = r9 + 1;
        goto L_0x0051;
    L_0x053e:
        r29 = move-exception;
        r29.printStackTrace();
        goto L_0x0053;
    L_0x0544:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x054f:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r11 != 0) goto L_0x081f;
    L_0x0555:
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 1;
        r46 = com.chelpus.Utils.getPlaceForOdex(r9, r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r45 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r45.<init>(r46);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r45.exists();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x056b;
    L_0x0568:
        r45.delete();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x056b:
        r45 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "-1";
        r11 = "-2";
        r0 = r46;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r45;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r45.exists();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0585;
    L_0x0582:
        r45.delete();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0585:
        r45 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "-2";
        r11 = "-1";
        r0 = r46;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r45;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r45.exists();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x059f;
    L_0x059c:
        r45.delete();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x059f:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r69 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x05a5:
        r9 = r69.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x049c;
    L_0x05ab:
        r36 = r69.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r36 = (java.io.File) r36;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "Find string id.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r64 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r64.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "com.android.vending";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "SHA1withRSA";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "com.android.vending.billing.InAppBillingService.BIND";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "Ljava/security/Signature;";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "verify";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "Landroid/content/Intent;";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "setPackage";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "engineVerify";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "Ljava/security/SignatureSpi;";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "String analysis.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "String analysis.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = copyDC;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x0967;
    L_0x060a:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r0 = r64;
        r48 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0615:
        r31 = 0;
        r32 = 0;
        r33 = 0;
        r30 = 0;
        r60 = 0;
        r47 = 1;
        r65 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r65.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.TypesItem;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Ljava/security/Signature;";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r65;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.TypesItem;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Ljava/security/SignatureSpi;";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r65;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r20 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r20.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Ljava/security/Signature;";
        r12 = "verify";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r20;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Landroid/content/Intent;";
        r12 = "setPackage";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r20;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = r48.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0663:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x0974;
    L_0x0669:
        r51 = 0;
        r52 = 1;
        if (r31 == 0) goto L_0x0671;
    L_0x066f:
        if (r32 != 0) goto L_0x06e8;
    L_0x0671:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "";
        r9.marker = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "";
        r9.marker = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "";
        r9.marker = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x06e8:
        if (r33 != 0) goto L_0x0708;
    L_0x06ea:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 4;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0708:
        r9 = "Parse data for patch.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Parse data for patch.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r12 = 0;
        r0 = r20;
        com.chelpus.Utils.getMethodsIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = r20.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0723:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x0cca;
    L_0x0729:
        if (r30 == 0) goto L_0x0741;
    L_0x072b:
        if (r60 == 0) goto L_0x0741;
    L_0x072d:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r0 = r65;
        com.chelpus.Utils.getTypesIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = r65.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x073b:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x0d5a;
    L_0x0741:
        r9 = r2.size();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r50 = r0;
        r68 = 0;
        r9 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x074f:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r11 != 0) goto L_0x0da7;
    L_0x0755:
        r22 = 0;
        r9 = "Set Strings.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Set Strings.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r59 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r59.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "com.android.vending.billing.InAppBillingService.BIND";
        r9 = r9.getBytes();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r59;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r59.size();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = new byte[r9][];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r58 = r0;
        r0 = r59;
        r1 = r58;
        r58 = r0.toArray(r1);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r58 = (byte[][]) r58;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r12 = 76;
        r0 = r58;
        r22 = com.chelpus.Utils.setStringIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0792:
        if (r22 > 0) goto L_0x0db3;
    L_0x0794:
        r66 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "rw";
        r0 = r36;
        r9.<init>(r0, r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r10 = r9.getChannel();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Size file:";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r10.size();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 0;
        r14 = r10.size();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (int) r14;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = (long) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r35 = r10.map(r11, r12, r14);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r24 = 0;
        r38 = 0;
        r26 = 90;
        r28 = 60;
        r27 = 90;
        r61 = 0;
        r63 = 0;
        r62 = 0;
        r54 = 0;
        r42 = 0;
    L_0x07dd:
        r9 = r35.hasRemaining();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x0dc3;
    L_0x07e3:
        r10.close();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12 - r66;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x05a5;
    L_0x0806:
        r29 = move-exception;
        r9 = new java.lang.StringBuilder;
        r11 = "Patch Process Exception: ";
        r9.<init>(r11);
        r11 = r29.toString();
        r9 = r9.append(r11);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        goto L_0x049c;
    L_0x081f:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r11 != 0) goto L_0x0831;
    L_0x082b:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0831:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x054f;
    L_0x083a:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x08eb;
    L_0x083e:
        r9 = 0;
        r49 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 5;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        unzipSD(r17);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = sddir;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = java.lang.String.valueOf(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11.<init>(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "/Modified/";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r49;
        r11 = r11.append(r0);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = ".apk";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = r11.toString();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        crkapk = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = crkapk;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r17;
        com.chelpus.Utils.copyFile(r0, r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = sddir;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = java.lang.String.valueOf(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "/Modified/AndroidManifest.xml";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r16.exists();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x08b1;
    L_0x08ab:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x08b1:
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.AxmlExample;	 Catch:{ Exception -> 0x08d5, FileNotFoundException -> 0x0496 }
        r9.<init>();	 Catch:{ Exception -> 0x08d5, FileNotFoundException -> 0x0496 }
        r11 = "19";
        r0 = r16;
        r9 = r9.changeTargetApi(r0, r11);	 Catch:{ Exception -> 0x08d5, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x08c3;
    L_0x08c0:
        r16.delete();	 Catch:{ Exception -> 0x08d5, FileNotFoundException -> 0x0496 }
    L_0x08c3:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x08cf;
    L_0x08c7:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x08da;
    L_0x08cf:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x08d5:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x08c3;
    L_0x08da:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x08e5:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r11 != 0) goto L_0x0922;
    L_0x08eb:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x059f;
    L_0x08ef:
        r9 = "ART mode create dex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 0;
        r49 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        unzipART(r17);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x091c;
    L_0x0914:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 != 0) goto L_0x093c;
    L_0x091c:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0922:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r11 != 0) goto L_0x0934;
    L_0x092e:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0934:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x08e5;
    L_0x093c:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0947:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r11 == 0) goto L_0x059f;
    L_0x094d:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r11 != 0) goto L_0x095f;
    L_0x0959:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x095f:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x0947;
    L_0x0967:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = 0;
        r0 = r64;
        r48 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x0615;
    L_0x0974:
        r40 = r11.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r40 = (com.android.vending.billing.InAppBillingService.LOCK.StringItem) r40;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r65.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x097e:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r12 != 0) goto L_0x0c78;
    L_0x0984:
        r9 = r20.iterator();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0988:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r12 != 0) goto L_0x0c96;
    L_0x098e:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "com.android.vending";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0afe;
    L_0x099a:
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r31 = 1;
    L_0x0afe:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "com.android.vending.billing.InAppBillingService.BIND";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0bda;
    L_0x0b0a:
        r9 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r13 = "c.a.v.b.i ";
        r12.<init>(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r40;
        r13 = r0.bits32;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.toString();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.println(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r32 = 1;
    L_0x0bda:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "SHA1withRSA";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0c5a;
    L_0x0be6:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r33 = 1;
    L_0x0c5a:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "engineVerify";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0c68;
    L_0x0c66:
        r30 = 1;
    L_0x0c68:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "Ljava/security/SignatureSpi;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0663;
    L_0x0c74:
        r60 = 1;
        goto L_0x0663;
    L_0x0c78:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.TypesItem) r41;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r41;
        r12 = r0.type;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r12 == 0) goto L_0x097e;
    L_0x0c8c:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r41;
        r0.Type = r12;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x097e;
    L_0x0c96:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r41;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r41;
        r12 = r0.object;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r12 == 0) goto L_0x0cb2;
    L_0x0caa:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r41;
        r0.Object = r12;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0cb2:
        r0 = r41;
        r12 = r0.method;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r12 == 0) goto L_0x0988;
    L_0x0cc0:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r41;
        r0.Method = r12;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x0988;
    L_0x0cca:
        r41 = r11.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r41;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r41;
        r9 = r0.found_index_command;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0723;
    L_0x0cd6:
        r0 = r41;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "Ljava/security/Signature;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0d15;
    L_0x0ce2:
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
    L_0x0d15:
        r0 = r41;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "Landroid/content/Intent;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0723;
    L_0x0d21:
        r9 = pattern3;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x0723;
    L_0x0d25:
        r9 = 12;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 12;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 12;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x0723;
    L_0x0d5a:
        r41 = r11.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.TypesItem) r41;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r41;
        r9 = r0.found_id_type;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x073b;
    L_0x0d66:
        r0 = r41;
        r9 = r0.type;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = "Ljava/security/SignatureSpi;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        if (r9 == 0) goto L_0x073b;
    L_0x0d72:
        r9 = 15;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 2;
        r0 = r41;
        r13 = r0.id_type;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 15;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 3;
        r0 = r41;
        r13 = r0.id_type;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = 15;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x073b;
    L_0x0da7:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r41;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r50[r68] = r41;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r68 = r68 + 1;
        goto L_0x074f;
    L_0x0db3:
        r22 = r22 + -1;
        r9 = "Reworked inapp string!";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r11 = "Reworked inapp string!";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x0792;
    L_0x0dc3:
        r9 = createAPK;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x0dec;
    L_0x0dc7:
        r9 = r35.position();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9 - r54;
        r11 = 149999; // 0x249ef float:2.10193E-40 double:7.41094E-319;
        if (r9 <= r11) goto L_0x0dec;
    L_0x0dd2:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = "Progress size:";
        r9.<init>(r11);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r35.position();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r54 = r35.position();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0dec:
        r24 = r35.position();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r23 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r39 = 0;
        r18 = 0;
    L_0x0df8:
        r0 = r50;
        r9 = r0.length;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r18;
        if (r0 < r9) goto L_0x0e0c;
    L_0x0dff:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r12 = 1;
        r42 = r42 + r12;
        goto L_0x07dd;
    L_0x0e0c:
        r53 = r50[r18];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 == 0) goto L_0x0ea8;
    L_0x0e1b:
        r9 = 5;
        r0 = r18;
        if (r0 == r9) goto L_0x0e3c;
    L_0x0e20:
        r9 = 6;
        r0 = r18;
        if (r0 == r9) goto L_0x0e3c;
    L_0x0e25:
        r9 = 7;
        r0 = r18;
        if (r0 == r9) goto L_0x0e3c;
    L_0x0e2a:
        r9 = 8;
        r0 = r18;
        if (r0 == r9) goto L_0x0e3c;
    L_0x0e30:
        r9 = 9;
        r0 = r18;
        if (r0 == r9) goto L_0x0e3c;
    L_0x0e36:
        r9 = 10;
        r0 = r18;
        if (r0 != r9) goto L_0x0ea8;
    L_0x0e3c:
        if (r39 != 0) goto L_0x0e42;
    L_0x0e3e:
        r63 = r63 + 1;
        r39 = 1;
    L_0x0e42:
        r0 = r63;
        r1 = r28;
        if (r0 >= r1) goto L_0x10c8;
    L_0x0e48:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r23;
        if (r0 != r9) goto L_0x0ea1;
    L_0x0e53:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x0e63;
    L_0x0e5c:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0e63:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r56 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0e70:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r56;
        if (r0 == r9) goto L_0x1010;
    L_0x0e7a:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 1;
        if (r9 == r11) goto L_0x1010;
    L_0x0e83:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 20;
        if (r9 == r11) goto L_0x1010;
    L_0x0e8d:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 21;
        if (r9 == r11) goto L_0x1010;
    L_0x0e97:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 23;
        if (r9 == r11) goto L_0x1010;
    L_0x0ea1:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0ea8:
        r0 = r53;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 == 0) goto L_0x0f2d;
    L_0x0eae:
        r9 = 13;
        r0 = r18;
        if (r0 == r9) goto L_0x0eba;
    L_0x0eb4:
        r9 = 14;
        r0 = r18;
        if (r0 != r9) goto L_0x0f2d;
    L_0x0eba:
        r9 = print;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = "search jump";
        r9.println(r11);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r39 != 0) goto L_0x0ec7;
    L_0x0ec3:
        r62 = r62 + 1;
        r39 = 1;
    L_0x0ec7:
        r0 = r62;
        r1 = r27;
        if (r0 >= r1) goto L_0x119f;
    L_0x0ecd:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r23;
        if (r0 != r9) goto L_0x0f26;
    L_0x0ed8:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x0ee8;
    L_0x0ee1:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0ee8:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r56 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0ef5:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r56;
        if (r0 == r9) goto L_0x10fc;
    L_0x0eff:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 1;
        if (r9 == r11) goto L_0x10fc;
    L_0x0f08:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 20;
        if (r9 == r11) goto L_0x10fc;
    L_0x0f12:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 21;
        if (r9 == r11) goto L_0x10fc;
    L_0x0f1c:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 23;
        if (r9 == r11) goto L_0x10fc;
    L_0x0f26:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0f2d:
        r0 = r53;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 == 0) goto L_0x0fa0;
    L_0x0f33:
        r9 = 4;
        r0 = r18;
        if (r0 != r9) goto L_0x0fa0;
    L_0x0f38:
        r61 = r61 + 1;
        r0 = r61;
        r1 = r26;
        if (r0 >= r1) goto L_0x1276;
    L_0x0f40:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r23;
        if (r0 != r9) goto L_0x0f99;
    L_0x0f4b:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x0f5b;
    L_0x0f54:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0f5b:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r56 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0f68:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r56;
        if (r0 == r9) goto L_0x11d3;
    L_0x0f72:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 1;
        if (r9 == r11) goto L_0x11d3;
    L_0x0f7b:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 20;
        if (r9 == r11) goto L_0x11d3;
    L_0x0f85:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 21;
        if (r9 == r11) goto L_0x11d3;
    L_0x0f8f:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 23;
        if (r9 == r11) goto L_0x11d3;
    L_0x0f99:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0fa0:
        r0 = r53;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x100c;
    L_0x0fa6:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r23;
        if (r0 != r9) goto L_0x100c;
    L_0x0fb1:
        r0 = r53;
        r9 = r0.pattern;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 == 0) goto L_0x100c;
    L_0x0fb7:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x0fc7;
    L_0x0fc0:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0fc7:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r56 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x0fd4:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r56;
        if (r0 == r9) goto L_0x12aa;
    L_0x0fde:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 1;
        if (r9 == r11) goto L_0x12aa;
    L_0x0fe7:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 20;
        if (r9 == r11) goto L_0x12aa;
    L_0x0ff1:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 21;
        if (r9 == r11) goto L_0x12aa;
    L_0x0ffb:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 23;
        if (r9 == r11) goto L_0x12aa;
    L_0x1005:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x100c:
        r18 = r18 + 1;
        goto L_0x0df8;
    L_0x1010:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x101e;
    L_0x1018:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r56;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x101e:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 20;
        if (r9 != r11) goto L_0x1031;
    L_0x1028:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r56 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x1031:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 21;
        if (r9 != r11) goto L_0x1046;
    L_0x103b:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r56 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x1046:
        r38 = r38 + 1;
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9.length;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r38;
        if (r0 != r9) goto L_0x10c2;
    L_0x1051:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r35.force();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = print;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9.println(r11);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = 1;
        r0 = r53;
        r0.result = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x1082:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 != 0) goto L_0x10a8;
    L_0x1088:
        r63 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0ea1;
    L_0x1093:
        r29 = move-exception;
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r0 = r29;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0496, Exception -> 0x0806 }
        goto L_0x07e3;
    L_0x10a8:
        r25 = r9.next();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 == 0) goto L_0x1082;
    L_0x10bc:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x1082;
    L_0x10c2:
        r56 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0e70;
    L_0x10c8:
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x10d1:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 != 0) goto L_0x10e2;
    L_0x10d7:
        r63 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0ea8;
    L_0x10e2:
        r25 = r9.next();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 == 0) goto L_0x10d1;
    L_0x10f6:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x10d1;
    L_0x10fc:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x110a;
    L_0x1104:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r56;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x110a:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 20;
        if (r9 != r11) goto L_0x111d;
    L_0x1114:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r56 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x111d:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 21;
        if (r9 != r11) goto L_0x1132;
    L_0x1127:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r56 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x1132:
        r38 = r38 + 1;
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9.length;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r38;
        if (r0 != r9) goto L_0x1199;
    L_0x113d:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r35.force();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = print;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9.println(r11);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = 1;
        r0 = r53;
        r0.result = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x116e:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 != 0) goto L_0x117f;
    L_0x1174:
        r62 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0f26;
    L_0x117f:
        r25 = r9.next();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 == 0) goto L_0x116e;
    L_0x1193:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x116e;
    L_0x1199:
        r56 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0ef5;
    L_0x119f:
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x11a8:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 != 0) goto L_0x11b9;
    L_0x11ae:
        r62 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0f2d;
    L_0x11b9:
        r25 = r9.next();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 == 0) goto L_0x11a8;
    L_0x11cd:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x11a8;
    L_0x11d3:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x11e1;
    L_0x11db:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r56;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x11e1:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 20;
        if (r9 != r11) goto L_0x11f4;
    L_0x11eb:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r56 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x11f4:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 21;
        if (r9 != r11) goto L_0x1209;
    L_0x11fe:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r56 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x1209:
        r38 = r38 + 1;
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9.length;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r38;
        if (r0 != r9) goto L_0x1270;
    L_0x1214:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r35.force();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = print;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9.println(r11);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = 1;
        r0 = r53;
        r0.result = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x1245:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 != 0) goto L_0x1256;
    L_0x124b:
        r61 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0f99;
    L_0x1256:
        r25 = r9.next();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 == 0) goto L_0x1245;
    L_0x126a:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x1245;
    L_0x1270:
        r56 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0f68;
    L_0x1276:
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x127f:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 != 0) goto L_0x1290;
    L_0x1285:
        r61 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0fa0;
    L_0x1290:
        r25 = r9.next();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 == 0) goto L_0x127f;
    L_0x12a4:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x127f;
    L_0x12aa:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x12b8;
    L_0x12b2:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r56;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x12b8:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 20;
        if (r9 != r11) goto L_0x12cb;
    L_0x12c2:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r56 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x12cb:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = 21;
        if (r9 != r11) goto L_0x12e0;
    L_0x12d5:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r56 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x12e0:
        r38 = r38 + 1;
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r9.length;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r38;
        if (r0 != r9) goto L_0x1348;
    L_0x12eb:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r35.force();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = print;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9.println(r11);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = 1;
        r0 = r53;
        r0.result = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r9 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = "";
        r9 = r9.equals(r11);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r9 != 0) goto L_0x1005;
    L_0x131f:
        r9 = 1;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
    L_0x1328:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 == 0) goto L_0x1005;
    L_0x132e:
        r25 = r9.next();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        if (r11 == 0) goto L_0x1328;
    L_0x1342:
        r11 = 1;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x1328;
    L_0x1348:
        r56 = r35.get();	 Catch:{ Exception -> 0x1093, FileNotFoundException -> 0x0496 }
        goto L_0x0fd4;
    L_0x134e:
        r36 = r9.next();
        r36 = (java.io.File) r36;
        com.chelpus.Utils.fixadler(r36);
        clearTempSD();
        goto L_0x04a2;
    L_0x135c:
        r9 = move-exception;
        goto L_0x00dc;
    L_0x135f:
        r9 = move-exception;
        goto L_0x00dc;
    L_0x1362:
        r9 = move-exception;
        goto L_0x00ce;
    L_0x1365:
        r9 = move-exception;
        goto L_0x00ce;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.runpatchsupportOld.main(java.lang.String[]):void");
    }

    public static void fixadler(File destFile) {
        try {
            FileInputStream localFileInputStream = new FileInputStream(destFile);
            byte[] arrayOfByte = new byte[localFileInputStream.available()];
            localFileInputStream.read(arrayOfByte);
            calcSignature(arrayOfByte, 0);
            calcChecksum(arrayOfByte, 0);
            localFileInputStream.close();
            FileOutputStream localFileOutputStream = new FileOutputStream(destFile);
            localFileOutputStream.write(arrayOfByte);
            localFileOutputStream.close();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private static final void calcChecksum(byte[] paramArrayOfByte, int j) {
        Adler32 localAdler32 = new Adler32();
        localAdler32.update(paramArrayOfByte, 12, paramArrayOfByte.length - (j + 12));
        int i = (int) localAdler32.getValue();
        paramArrayOfByte[j + 8] = (byte) i;
        paramArrayOfByte[j + 9] = (byte) (i >> 8);
        paramArrayOfByte[j + 10] = (byte) (i >> 16);
        paramArrayOfByte[j + 11] = (byte) (i >> 24);
    }

    private static final void calcSignature(byte[] paramArrayOfByte, int j) {
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
            localMessageDigest.update(paramArrayOfByte, 32, paramArrayOfByte.length - (j + 32));
            try {
                int i = localMessageDigest.digest(paramArrayOfByte, j + 12, 20);
                if (i != 20) {
                    throw new RuntimeException("unexpected digest write:" + i + "bytes");
                }
            } catch (DigestException localDigestException) {
                throw new RuntimeException(localDigestException);
            }
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            throw new RuntimeException(localNoSuchAlgorithmException);
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
                    File cl = (File) it.next();
                    if (cl.exists()) {
                        cl.delete();
                    }
                }
            }
            tempdex = new File(dir + "/classes.dex");
            if (tempdex.exists()) {
                tempdex.delete();
            }
            tempdex = new File(dir + "/classes.dex.apk");
            if (tempdex.exists()) {
                tempdex.delete();
            }
        } catch (Exception e) {
            Utils.sendFromRoot(e.toString());
        }
    }

    public static boolean byteverify(MappedByteBuffer fileBytes, int curentPos, byte curentByte, byte[] byteOrig, byte[] mask, byte[] byteReplace, byte[] rep_mask, String log, boolean pattern) {
        if (curentByte == byteOrig[0] && pattern) {
            if (rep_mask[0] == (byte) 0) {
                byteReplace[0] = curentByte;
            }
            int i = 1;
            fileBytes.position(curentPos + 1);
            byte prufbyte = fileBytes.get();
            while (true) {
                if (prufbyte != byteOrig[i] && mask[i] != (byte) 1) {
                    break;
                }
                if (rep_mask[i] == (byte) 0) {
                    byteReplace[i] = prufbyte;
                }
                i++;
                if (i == byteOrig.length) {
                    fileBytes.position(curentPos);
                    fileBytes.put(byteReplace);
                    fileBytes.force();
                    Utils.sendFromRoot(log);
                    return true;
                }
                prufbyte = fileBytes.get();
            }
            fileBytes.position(curentPos + 1);
        }
        return false;
    }

    public static void unzipSD(File apk) {
        try {
            FileInputStream fin = new FileInputStream(apk);
            ZipInputStream zin = new ZipInputStream(fin);
            boolean classesdex = false;
            while (true) {
                ZipEntry ze = zin.getNextEntry();
                if (ze == null) {
                    zin.close();
                    fin.close();
                    return;
                }
                FileOutputStream fout;
                byte[] buffer;
                int length;
                if (ze.getName().toLowerCase().startsWith("classes") && ze.getName().endsWith(".dex") && !ze.getName().contains(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    fout = new FileOutputStream(sddir + "/Modified/" + ze.getName());
                    buffer = new byte[Util.BLOCK_HEADER_SIZE_MAX];
                    while (true) {
                        length = zin.read(buffer);
                        if (length == -1) {
                            break;
                        }
                        fout.write(buffer, 0, length);
                    }
                    classesFiles.add(new File(sddir + "/Modified/" + ze.getName()));
                    classesdex = true;
                    if (!createAPK) {
                        zin.closeEntry();
                        fout.close();
                    }
                }
                if (ze.getName().equals("AndroidManifest.xml")) {
                    fout = new FileOutputStream(sddir + "/Modified/" + "AndroidManifest.xml");
                    buffer = new byte[Util.BLOCK_HEADER_SIZE_MAX];
                    while (true) {
                        length = zin.read(buffer);
                        if (length == -1) {
                            break;
                        }
                        fout.write(buffer, 0, length);
                    }
                    if (classesdex) {
                        zin.closeEntry();
                        fout.close();
                    }
                }
            }
        } catch (Exception e) {
            try {
                ZipFile zipFile = new ZipFile(apk);
                zipFile.extractFile("classes.dex", sddir + "/Modified/");
                classesFiles.add(new File(sddir + "/Modified/" + "classes.dex"));
                zipFile.extractFile("AndroidManifest.xml", sddir + "/Modified/");
            } catch (ZipException e1) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e1);
                Utils.sendFromRoot("Exception e1" + e.toString());
            } catch (Exception e12) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e12);
                Utils.sendFromRoot("Exception e1" + e.toString());
            }
            Utils.sendFromRoot("Decompressunzip " + e);
        }
    }

    public static void unzipART(File apk) {
        boolean found2 = false;
        try {
            FileInputStream fin = new FileInputStream(apk);
            ZipInputStream zipInputStream = new ZipInputStream(fin);
            for (ZipEntry ze = zipInputStream.getNextEntry(); ze != null && true; ze = zipInputStream.getNextEntry()) {
                String haystack = ze.getName();
                if (haystack.toLowerCase().startsWith("classes") && haystack.endsWith(".dex") && !haystack.contains(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    FileOutputStream fout = new FileOutputStream(sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack);
                    byte[] buffer = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
                    while (true) {
                        int length = zipInputStream.read(buffer);
                        if (length == -1) {
                            break;
                        }
                        fout.write(buffer, 0, length);
                    }
                    zipInputStream.closeEntry();
                    fout.close();
                    classesFiles.add(new File(sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack));
                    Utils.cmdParam("chmod", "777", sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + haystack);
                }
                if (haystack.equals("AndroidManifest.xml")) {
                    FileOutputStream fout2 = new FileOutputStream(sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
                    byte[] buffer2 = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
                    while (true) {
                        int length2 = zipInputStream.read(buffer2);
                        if (length2 == -1) {
                            break;
                        }
                        fout2.write(buffer2, 0, length2);
                    }
                    zipInputStream.closeEntry();
                    fout2.close();
                    Utils.cmdParam("chmod", "777", sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
                    found2 = true;
                }
                if (false && found2) {
                    break;
                }
            }
            zipInputStream.close();
            fin.close();
        } catch (Exception e) {
            try {
                ZipFile zipFile = new ZipFile(apk);
                zipFile.extractFile("classes.dex", sddir);
                classesFiles.add(new File(sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex"));
                Utils.cmdParam("chmod", "777", sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex");
                zipFile.extractFile("AndroidManifest.xml", sddir);
                Utils.cmdParam("chmod", "777", sddir + InternalZipConstants.ZIP_FILE_SEPARATOR + "AndroidManifest.xml");
            } catch (ZipException e1) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e1);
                Utils.sendFromRoot("Exception e1" + e.toString());
            } catch (Exception e12) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e12);
                Utils.sendFromRoot("Exception e1" + e.toString());
            }
            Utils.sendFromRoot("Exception e" + e.toString());
        }
    }

    public static void clearTempSD() {
        try {
            File tempdex = new File(sddir + "/Modified/classes.dex.apk");
            if (tempdex.exists()) {
                tempdex.delete();
            }
        } catch (Exception e) {
            Utils.sendFromRoot(e.toString());
        }
    }
}
