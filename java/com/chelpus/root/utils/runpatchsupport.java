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

public class runpatchsupport {
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
        r56 = new com.android.vending.billing.InAppBillingService.LOCK.LogOutputStream;
        r9 = "System.out";
        r0 = r56;
        r0.<init>(r9);
        r9 = new java.io.PrintStream;
        r0 = r56;
        r9.<init>(r0);
        print = r9;
        r9 = new com.chelpus.root.utils.runpatchsupport$1;
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
        r9 = new java.io.File;	 Catch:{ Exception -> 0x040f }
        r11 = 3;
        r11 = r70[r11];	 Catch:{ Exception -> 0x040f }
        r9.<init>(r11);	 Catch:{ Exception -> 0x040f }
        r37 = r9.listFiles();	 Catch:{ Exception -> 0x040f }
        r0 = r37;
        r11 = r0.length;	 Catch:{ Exception -> 0x040f }
        r9 = 0;
    L_0x0051:
        if (r9 < r11) goto L_0x03dc;
    L_0x0053:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r11 = "pattern0";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 != 0) goto L_0x0061;
    L_0x005e:
        r9 = 0;
        pattern1 = r9;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
    L_0x0061:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r11 = "pattern1";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 != 0) goto L_0x006f;
    L_0x006c:
        r9 = 0;
        pattern2 = r9;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
    L_0x006f:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r11 = "pattern2";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 != 0) goto L_0x007d;
    L_0x007a:
        r9 = 0;
        pattern3 = r9;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
    L_0x007d:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 == 0) goto L_0x0090;
    L_0x0082:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r11 = "createAPK";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 == 0) goto L_0x0090;
    L_0x008d:
        r9 = 1;
        createAPK = r9;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
    L_0x0090:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 == 0) goto L_0x00a3;
    L_0x0095:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r11 = "ART";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 == 0) goto L_0x00a3;
    L_0x00a0:
        r9 = 1;
        ART = r9;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
    L_0x00a3:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 == 0) goto L_0x00ae;
    L_0x00a8:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
    L_0x00ae:
        r9 = 7;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        if (r9 == 0) goto L_0x00b8;
    L_0x00b3:
        r9 = 7;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        uid = r9;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
    L_0x00b8:
        r9 = java.lang.System.out;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r11 = new java.lang.StringBuilder;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r12 = "uid:";
        r11.<init>(r12);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r12 = uid;	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r11 = r11.append(r12);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r11 = r11.toString();	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
        r9.println(r11);	 Catch:{ NullPointerException -> 0x1151, Exception -> 0x114e }
    L_0x00ce:
        r9 = 5;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x114b, Exception -> 0x1148 }
        r11 = "copyDC";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x114b, Exception -> 0x1148 }
        if (r9 == 0) goto L_0x00dc;
    L_0x00d9:
        r9 = 1;
        copyDC = r9;	 Catch:{ NullPointerException -> 0x114b, Exception -> 0x1148 }
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
        r9 = "1A ?? FF FF";
        r3.add(r9);
        r9 = "1A ?? FF FF";
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
        r9 = "1B ?? FF FF FF FF";
        r3.add(r9);
        r9 = "1B ?? FF FF FF FF";
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
        r21 = 0;
        r9 = java.lang.Boolean.valueOf(r21);
        com.chelpus.Utils.convertToPatchItemAuto(r2, r3, r4, r5, r6, r7, r8, r9);
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.booleanValue();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x02f2;
    L_0x02ea:
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "RW";
        com.chelpus.Utils.remount(r9, r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x02f2:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x06ba;
    L_0x02f6:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x06ba;
    L_0x02fa:
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        dir = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        dirapp = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        clearTemp();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 4;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "not_system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0315;
    L_0x0312:
        r9 = 0;
        system = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0315:
        r9 = 4;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0323;
    L_0x0320:
        r9 = 1;
        system = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0323:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "CLASSES mode create odex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 0;
        r50 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "Get classes.dex.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Get classes.dex.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        unzipART(r17);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0361;
    L_0x0359:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x0415;
    L_0x0361:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0367:
        r44 = move-exception;
        r9 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        com.chelpus.Utils.sendFromRoot(r9);
    L_0x036d:
        r9 = filestopatch;
        r9 = r9.iterator();
    L_0x0373:
        r11 = r9.hasNext();
        if (r11 != 0) goto L_0x113a;
    L_0x0379:
        r9 = createAPK;
        if (r9 != 0) goto L_0x03c9;
    L_0x037d:
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
        r58 = com.chelpus.Utils.create_ODEX_root(r9, r11, r12, r13, r14);
        r9 = new java.lang.StringBuilder;
        r11 = "chelpus_return_";
        r9.<init>(r11);
        r0 = r58;
        r9 = r9.append(r0);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        if (r58 != 0) goto L_0x03c9;
    L_0x03af:
        r9 = ART;
        if (r9 != 0) goto L_0x03c9;
    L_0x03b3:
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
    L_0x03c9:
        r9 = "Optional Steps After Patch:";
        com.chelpus.Utils.sendFromRoot(r9);
        r9 = createAPK;
        if (r9 != 0) goto L_0x03d5;
    L_0x03d2:
        com.chelpus.Utils.exitFromRootJava();
    L_0x03d5:
        r0 = r56;
        r9 = r0.allresult;
        result = r9;
        return;
    L_0x03dc:
        r34 = r37[r9];	 Catch:{ Exception -> 0x040f }
        r12 = r34.isFile();	 Catch:{ Exception -> 0x040f }
        if (r12 == 0) goto L_0x040b;
    L_0x03e4:
        r12 = r34.getName();	 Catch:{ Exception -> 0x040f }
        r13 = "busybox";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x040f }
        if (r12 != 0) goto L_0x040b;
    L_0x03f0:
        r12 = r34.getName();	 Catch:{ Exception -> 0x040f }
        r13 = "reboot";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x040f }
        if (r12 != 0) goto L_0x040b;
    L_0x03fc:
        r12 = r34.getName();	 Catch:{ Exception -> 0x040f }
        r13 = "dalvikvm";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x040f }
        if (r12 != 0) goto L_0x040b;
    L_0x0408:
        r34.delete();	 Catch:{ Exception -> 0x040f }
    L_0x040b:
        r9 = r9 + 1;
        goto L_0x0051;
    L_0x040f:
        r29 = move-exception;
        r29.printStackTrace();
        goto L_0x0053;
    L_0x0415:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0420:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r11 != 0) goto L_0x069f;
    L_0x0426:
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 1;
        r47 = com.chelpus.Utils.getPlaceForOdex(r9, r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r46 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r46.<init>(r47);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r46.exists();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x043c;
    L_0x0439:
        r46.delete();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x043c:
        r46 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "-1";
        r11 = "-2";
        r0 = r47;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r46;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r46.exists();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0456;
    L_0x0453:
        r46.delete();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0456:
        r46 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "-2";
        r11 = "-1";
        r0 = r47;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r46;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r46.exists();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0470;
    L_0x046d:
        r46.delete();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0470:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r68 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0476:
        r9 = r68.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x036d;
    L_0x047c:
        r36 = r68.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r36 = (java.io.File) r36;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "Find string id.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r63 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r63.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "com.android.vending";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "SHA1withRSA";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "com.android.vending.billing.InAppBillingService.BIND";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "Ljava/security/Signature;";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "verify";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "Landroid/content/Intent;";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "setPackage";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "engineVerify";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "Ljava/security/SignatureSpi;";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "String analysis.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "String analysis.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = copyDC;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x07e7;
    L_0x04db:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r0 = r63;
        r49 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x04e6:
        r31 = 0;
        r32 = 0;
        r33 = 0;
        r30 = 0;
        r59 = 0;
        r48 = 1;
        r66 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r66.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.TypesItem;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Ljava/security/Signature;";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r66;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.TypesItem;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Ljava/security/SignatureSpi;";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r66;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r20 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r20.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Ljava/security/Signature;";
        r12 = "verify";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r20;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Landroid/content/Intent;";
        r12 = "setPackage";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r20;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = r49.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0534:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x07f4;
    L_0x053a:
        r52 = 0;
        r53 = 1;
        if (r31 == 0) goto L_0x0542;
    L_0x0540:
        if (r32 != 0) goto L_0x056a;
    L_0x0542:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x056a:
        if (r33 != 0) goto L_0x058a;
    L_0x056c:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 4;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x058a:
        r45 = 0;
        if (r32 == 0) goto L_0x0acc;
    L_0x058e:
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Relaced strings:";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 1;
        r12 = new java.lang.String[r12];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r13 = 0;
        r14 = "com.android.vending.billing.InAppBillingService.BIND";
        r12[r13] = r14;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r13 = 0;
        r14 = 1;
        r14 = new java.lang.String[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r15 = 0;
        r69 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.class;
        r69 = r69.getPackage();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r69 = r69.getName();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14[r15] = r69;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = com.chelpus.Utils.replaceStringIds(r11, r12, r13, r14);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r45 = 1;
    L_0x05c3:
        r9 = "Parse data for patch.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Parse data for patch.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r12 = 0;
        r0 = r20;
        com.chelpus.Utils.getMethodsIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = r20.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x05de:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x0ad0;
    L_0x05e4:
        if (r30 == 0) goto L_0x05fc;
    L_0x05e6:
        if (r59 == 0) goto L_0x05fc;
    L_0x05e8:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r0 = r66;
        com.chelpus.Utils.getTypesIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = r66.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x05f6:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x0b5d;
    L_0x05fc:
        r9 = r2.size();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r51 = r0;
        r67 = 0;
        r9 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x060a:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r11 != 0) goto L_0x0baa;
    L_0x0610:
        r22 = 0;
    L_0x0612:
        if (r22 > 0) goto L_0x0bb6;
    L_0x0614:
        r64 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "rw";
        r0 = r36;
        r9.<init>(r0, r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r10 = r9.getChannel();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Size file:";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r10.size();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 0;
        r14 = r10.size();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (int) r14;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = (long) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r35 = r10.map(r11, r12, r14);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r24 = 0;
        r38 = 0;
        r26 = 90;
        r28 = 60;
        r27 = 90;
        r60 = 0;
        r62 = 0;
        r61 = 0;
        r55 = 0;
        r42 = 0;
    L_0x065d:
        r9 = r35.hasRemaining();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0bc6;
    L_0x0663:
        r10.close();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12 - r64;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x0476;
    L_0x0686:
        r29 = move-exception;
        r9 = new java.lang.StringBuilder;
        r11 = "Patch Process Exception: ";
        r9.<init>(r11);
        r11 = r29.toString();
        r9 = r9.append(r11);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        goto L_0x036d;
    L_0x069f:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r11 != 0) goto L_0x06b1;
    L_0x06ab:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x06b1:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x0420;
    L_0x06ba:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x076b;
    L_0x06be:
        r9 = 0;
        r50 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 5;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        unzipSD(r17);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = sddir;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = java.lang.String.valueOf(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11.<init>(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "/Modified/";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r50;
        r11 = r11.append(r0);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = ".apk";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = r11.toString();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        crkapk = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = crkapk;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r17;
        com.chelpus.Utils.copyFile(r0, r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = sddir;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = java.lang.String.valueOf(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "/Modified/AndroidManifest.xml";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r16.exists();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x0731;
    L_0x072b:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0731:
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.AxmlExample;	 Catch:{ Exception -> 0x0755, FileNotFoundException -> 0x0367 }
        r9.<init>();	 Catch:{ Exception -> 0x0755, FileNotFoundException -> 0x0367 }
        r11 = "19";
        r0 = r16;
        r9 = r9.changeTargetApi(r0, r11);	 Catch:{ Exception -> 0x0755, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0743;
    L_0x0740:
        r16.delete();	 Catch:{ Exception -> 0x0755, FileNotFoundException -> 0x0367 }
    L_0x0743:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x074f;
    L_0x0747:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x075a;
    L_0x074f:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0755:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x0743;
    L_0x075a:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0765:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r11 != 0) goto L_0x07a2;
    L_0x076b:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0470;
    L_0x076f:
        r9 = "ART mode create dex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 0;
        r50 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        unzipART(r17);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x079c;
    L_0x0794:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 != 0) goto L_0x07bc;
    L_0x079c:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x07a2:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r11 != 0) goto L_0x07b4;
    L_0x07ae:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x07b4:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x0765;
    L_0x07bc:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x07c7:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r11 == 0) goto L_0x0470;
    L_0x07cd:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r11 != 0) goto L_0x07df;
    L_0x07d9:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x07df:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x07c7;
    L_0x07e7:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = 0;
        r0 = r63;
        r49 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x04e6;
    L_0x07f4:
        r40 = r11.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r40 = (com.android.vending.billing.InAppBillingService.LOCK.StringItem) r40;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r66.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x07fe:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r12 != 0) goto L_0x0a7a;
    L_0x0804:
        r9 = r20.iterator();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0808:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r12 != 0) goto L_0x0a98;
    L_0x080e:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "com.android.vending";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x088e;
    L_0x081a:
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r31 = 1;
    L_0x088e:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "com.android.vending.billing.InAppBillingService.BIND";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x09dc;
    L_0x089a:
        r9 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r13 = "c.a.v.b.i ";
        r12.<init>(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r40;
        r13 = r0.bits32;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.toString();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.println(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r32 = 1;
    L_0x09dc:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "SHA1withRSA";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0a5c;
    L_0x09e8:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r33 = 1;
    L_0x0a5c:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "engineVerify";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0a6a;
    L_0x0a68:
        r30 = 1;
    L_0x0a6a:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "Ljava/security/SignatureSpi;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0534;
    L_0x0a76:
        r59 = 1;
        goto L_0x0534;
    L_0x0a7a:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.TypesItem) r41;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r41;
        r12 = r0.type;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r12 == 0) goto L_0x07fe;
    L_0x0a8e:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r41;
        r0.Type = r12;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x07fe;
    L_0x0a98:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r41;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r41;
        r12 = r0.object;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r12 == 0) goto L_0x0ab4;
    L_0x0aac:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r41;
        r0.Object = r12;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0ab4:
        r0 = r41;
        r12 = r0.method;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r12 == 0) goto L_0x0808;
    L_0x0ac2:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r41;
        r0.Method = r12;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x0808;
    L_0x0acc:
        r45 = 0;
        goto L_0x05c3;
    L_0x0ad0:
        r41 = r11.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r41;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r41;
        r9 = r0.found_index_command;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x05de;
    L_0x0adc:
        r0 = r41;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "Ljava/security/Signature;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x0b18;
    L_0x0ae8:
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
    L_0x0b18:
        r0 = r41;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "Landroid/content/Intent;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x05de;
    L_0x0b24:
        r9 = pattern3;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x05de;
    L_0x0b28:
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x05de;
    L_0x0b5d:
        r41 = r11.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.TypesItem) r41;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r41;
        r9 = r0.found_id_type;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x05f6;
    L_0x0b69:
        r0 = r41;
        r9 = r0.type;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = "Ljava/security/SignatureSpi;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        if (r9 == 0) goto L_0x05f6;
    L_0x0b75:
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 2;
        r0 = r41;
        r13 = r0.id_type;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 3;
        r0 = r41;
        r13 = r0.id_type;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x05f6;
    L_0x0baa:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r41;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r51[r67] = r41;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r67 = r67 + 1;
        goto L_0x060a;
    L_0x0bb6:
        r22 = r22 + -1;
        r9 = "Reworked inapp string!";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r11 = "Reworked inapp string!";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x0612;
    L_0x0bc6:
        r9 = createAPK;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0bef;
    L_0x0bca:
        r9 = r35.position();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9 - r55;
        r11 = 149999; // 0x249ef float:2.10193E-40 double:7.41094E-319;
        if (r9 <= r11) goto L_0x0bef;
    L_0x0bd5:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = "Progress size:";
        r9.<init>(r11);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r35.position();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r55 = r35.position();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0bef:
        r24 = r35.position();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r23 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r39 = 0;
        r18 = 0;
    L_0x0bfb:
        r0 = r51;
        r9 = r0.length;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r18;
        if (r0 < r9) goto L_0x0c0f;
    L_0x0c02:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r12 = 1;
        r42 = r42 + r12;
        goto L_0x065d;
    L_0x0c0f:
        r54 = r51[r18];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 == 0) goto L_0x0c94;
    L_0x0c1e:
        r9 = 5;
        r0 = r18;
        if (r0 == r9) goto L_0x0c28;
    L_0x0c23:
        r9 = 6;
        r0 = r18;
        if (r0 != r9) goto L_0x0c94;
    L_0x0c28:
        if (r39 != 0) goto L_0x0c2e;
    L_0x0c2a:
        r62 = r62 + 1;
        r39 = 1;
    L_0x0c2e:
        r0 = r62;
        r1 = r28;
        if (r0 >= r1) goto L_0x0eb4;
    L_0x0c34:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r23;
        if (r0 != r9) goto L_0x0c8d;
    L_0x0c3f:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0c4f;
    L_0x0c48:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0c4f:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r57 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0c5c:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r57;
        if (r0 == r9) goto L_0x0dfc;
    L_0x0c66:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 1;
        if (r9 == r11) goto L_0x0dfc;
    L_0x0c6f:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 20;
        if (r9 == r11) goto L_0x0dfc;
    L_0x0c79:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 21;
        if (r9 == r11) goto L_0x0dfc;
    L_0x0c83:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 23;
        if (r9 == r11) goto L_0x0dfc;
    L_0x0c8d:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0c94:
        r0 = r54;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 == 0) goto L_0x0d19;
    L_0x0c9a:
        r9 = 9;
        r0 = r18;
        if (r0 == r9) goto L_0x0ca6;
    L_0x0ca0:
        r9 = 10;
        r0 = r18;
        if (r0 != r9) goto L_0x0d19;
    L_0x0ca6:
        r9 = print;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = "search jump";
        r9.println(r11);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r39 != 0) goto L_0x0cb3;
    L_0x0caf:
        r61 = r61 + 1;
        r39 = 1;
    L_0x0cb3:
        r0 = r61;
        r1 = r27;
        if (r0 >= r1) goto L_0x0f8b;
    L_0x0cb9:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r23;
        if (r0 != r9) goto L_0x0d12;
    L_0x0cc4:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0cd4;
    L_0x0ccd:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0cd4:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r57 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0ce1:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r57;
        if (r0 == r9) goto L_0x0ee8;
    L_0x0ceb:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 1;
        if (r9 == r11) goto L_0x0ee8;
    L_0x0cf4:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 20;
        if (r9 == r11) goto L_0x0ee8;
    L_0x0cfe:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 21;
        if (r9 == r11) goto L_0x0ee8;
    L_0x0d08:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 23;
        if (r9 == r11) goto L_0x0ee8;
    L_0x0d12:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0d19:
        r0 = r54;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 == 0) goto L_0x0d8c;
    L_0x0d1f:
        r9 = 4;
        r0 = r18;
        if (r0 != r9) goto L_0x0d8c;
    L_0x0d24:
        r60 = r60 + 1;
        r0 = r60;
        r1 = r26;
        if (r0 >= r1) goto L_0x1062;
    L_0x0d2c:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r23;
        if (r0 != r9) goto L_0x0d85;
    L_0x0d37:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0d47;
    L_0x0d40:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0d47:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r57 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0d54:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r57;
        if (r0 == r9) goto L_0x0fbf;
    L_0x0d5e:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 1;
        if (r9 == r11) goto L_0x0fbf;
    L_0x0d67:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 20;
        if (r9 == r11) goto L_0x0fbf;
    L_0x0d71:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 21;
        if (r9 == r11) goto L_0x0fbf;
    L_0x0d7b:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 23;
        if (r9 == r11) goto L_0x0fbf;
    L_0x0d85:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0d8c:
        r0 = r54;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0df8;
    L_0x0d92:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r23;
        if (r0 != r9) goto L_0x0df8;
    L_0x0d9d:
        r0 = r54;
        r9 = r0.pattern;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 == 0) goto L_0x0df8;
    L_0x0da3:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0db3;
    L_0x0dac:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0db3:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r57 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0dc0:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r57;
        if (r0 == r9) goto L_0x1096;
    L_0x0dca:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 1;
        if (r9 == r11) goto L_0x1096;
    L_0x0dd3:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 20;
        if (r9 == r11) goto L_0x1096;
    L_0x0ddd:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 21;
        if (r9 == r11) goto L_0x1096;
    L_0x0de7:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 23;
        if (r9 == r11) goto L_0x1096;
    L_0x0df1:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0df8:
        r18 = r18 + 1;
        goto L_0x0bfb;
    L_0x0dfc:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0e0a;
    L_0x0e04:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r57;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0e0a:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 20;
        if (r9 != r11) goto L_0x0e1d;
    L_0x0e14:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r57 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0e1d:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 21;
        if (r9 != r11) goto L_0x0e32;
    L_0x0e27:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r57 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0e32:
        r38 = r38 + 1;
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r38;
        if (r0 != r9) goto L_0x0eae;
    L_0x0e3d:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r35.force();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = print;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9.println(r11);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = 1;
        r0 = r54;
        r0.result = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0e6e:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 != 0) goto L_0x0e94;
    L_0x0e74:
        r62 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0c8d;
    L_0x0e7f:
        r29 = move-exception;
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r0 = r29;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0367, Exception -> 0x0686 }
        goto L_0x0663;
    L_0x0e94:
        r25 = r9.next();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 == 0) goto L_0x0e6e;
    L_0x0ea8:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0e6e;
    L_0x0eae:
        r57 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0c5c;
    L_0x0eb4:
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0ebd:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 != 0) goto L_0x0ece;
    L_0x0ec3:
        r62 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0c94;
    L_0x0ece:
        r25 = r9.next();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 == 0) goto L_0x0ebd;
    L_0x0ee2:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0ebd;
    L_0x0ee8:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0ef6;
    L_0x0ef0:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r57;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0ef6:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 20;
        if (r9 != r11) goto L_0x0f09;
    L_0x0f00:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r57 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0f09:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 21;
        if (r9 != r11) goto L_0x0f1e;
    L_0x0f13:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r57 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0f1e:
        r38 = r38 + 1;
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r38;
        if (r0 != r9) goto L_0x0f85;
    L_0x0f29:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r35.force();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = print;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9.println(r11);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = 1;
        r0 = r54;
        r0.result = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0f5a:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 != 0) goto L_0x0f6b;
    L_0x0f60:
        r61 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0d12;
    L_0x0f6b:
        r25 = r9.next();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 == 0) goto L_0x0f5a;
    L_0x0f7f:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0f5a;
    L_0x0f85:
        r57 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0ce1;
    L_0x0f8b:
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0f94:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 != 0) goto L_0x0fa5;
    L_0x0f9a:
        r61 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0d19;
    L_0x0fa5:
        r25 = r9.next();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 == 0) goto L_0x0f94;
    L_0x0fb9:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0f94;
    L_0x0fbf:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0fcd;
    L_0x0fc7:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r57;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0fcd:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 20;
        if (r9 != r11) goto L_0x0fe0;
    L_0x0fd7:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r57 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0fe0:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 21;
        if (r9 != r11) goto L_0x0ff5;
    L_0x0fea:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r57 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x0ff5:
        r38 = r38 + 1;
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r38;
        if (r0 != r9) goto L_0x105c;
    L_0x1000:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r35.force();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = print;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9.println(r11);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = 1;
        r0 = r54;
        r0.result = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x1031:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 != 0) goto L_0x1042;
    L_0x1037:
        r60 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0d85;
    L_0x1042:
        r25 = r9.next();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 == 0) goto L_0x1031;
    L_0x1056:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x1031;
    L_0x105c:
        r57 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0d54;
    L_0x1062:
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x106b:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 != 0) goto L_0x107c;
    L_0x1071:
        r60 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0d8c;
    L_0x107c:
        r25 = r9.next();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 == 0) goto L_0x106b;
    L_0x1090:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x106b;
    L_0x1096:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x10a4;
    L_0x109e:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r57;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x10a4:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 20;
        if (r9 != r11) goto L_0x10b7;
    L_0x10ae:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r57 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x10b7:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = 21;
        if (r9 != r11) goto L_0x10cc;
    L_0x10c1:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r57 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x10cc:
        r38 = r38 + 1;
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r38;
        if (r0 != r9) goto L_0x1134;
    L_0x10d7:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r35.force();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = print;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9.println(r11);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = 1;
        r0 = r54;
        r0.result = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r9 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = "";
        r9 = r9.equals(r11);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r9 != 0) goto L_0x0df1;
    L_0x110b:
        r9 = 1;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
    L_0x1114:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 == 0) goto L_0x0df1;
    L_0x111a:
        r25 = r9.next();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        if (r11 == 0) goto L_0x1114;
    L_0x112e:
        r11 = 1;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x1114;
    L_0x1134:
        r57 = r35.get();	 Catch:{ Exception -> 0x0e7f, FileNotFoundException -> 0x0367 }
        goto L_0x0dc0;
    L_0x113a:
        r36 = r9.next();
        r36 = (java.io.File) r36;
        com.chelpus.Utils.fixadler(r36);
        clearTempSD();
        goto L_0x0373;
    L_0x1148:
        r9 = move-exception;
        goto L_0x00dc;
    L_0x114b:
        r9 = move-exception;
        goto L_0x00dc;
    L_0x114e:
        r9 = move-exception;
        goto L_0x00ce;
    L_0x1151:
        r9 = move-exception;
        goto L_0x00ce;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.runpatchsupport.main(java.lang.String[]):void");
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
