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
        r9 = new java.io.File;	 Catch:{ Exception -> 0x0085 }
        r11 = 3;
        r11 = r70[r11];	 Catch:{ Exception -> 0x0085 }
        r9.<init>(r11);	 Catch:{ Exception -> 0x0085 }
        r37 = r9.listFiles();	 Catch:{ Exception -> 0x0085 }
        r0 = r37;
        r11 = r0.length;	 Catch:{ Exception -> 0x0085 }
        r9 = 0;
    L_0x0051:
        if (r9 >= r11) goto L_0x0089;
    L_0x0053:
        r34 = r37[r9];	 Catch:{ Exception -> 0x0085 }
        r12 = r34.isFile();	 Catch:{ Exception -> 0x0085 }
        if (r12 == 0) goto L_0x0082;
    L_0x005b:
        r12 = r34.getName();	 Catch:{ Exception -> 0x0085 }
        r13 = "busybox";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0085 }
        if (r12 != 0) goto L_0x0082;
    L_0x0067:
        r12 = r34.getName();	 Catch:{ Exception -> 0x0085 }
        r13 = "reboot";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0085 }
        if (r12 != 0) goto L_0x0082;
    L_0x0073:
        r12 = r34.getName();	 Catch:{ Exception -> 0x0085 }
        r13 = "dalvikvm";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0085 }
        if (r12 != 0) goto L_0x0082;
    L_0x007f:
        r34.delete();	 Catch:{ Exception -> 0x0085 }
    L_0x0082:
        r9 = r9 + 1;
        goto L_0x0051;
    L_0x0085:
        r29 = move-exception;
        r29.printStackTrace();
    L_0x0089:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11 = "pattern0";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 != 0) goto L_0x0097;
    L_0x0094:
        r9 = 0;
        pattern1 = r9;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
    L_0x0097:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11 = "pattern1";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 != 0) goto L_0x00a5;
    L_0x00a2:
        r9 = 0;
        pattern2 = r9;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
    L_0x00a5:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11 = "pattern2";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 != 0) goto L_0x00b3;
    L_0x00b0:
        r9 = 0;
        pattern3 = r9;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
    L_0x00b3:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 == 0) goto L_0x00c6;
    L_0x00b8:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11 = "createAPK";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 == 0) goto L_0x00c6;
    L_0x00c3:
        r9 = 1;
        createAPK = r9;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
    L_0x00c6:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 == 0) goto L_0x00d9;
    L_0x00cb:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11 = "ART";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 == 0) goto L_0x00d9;
    L_0x00d6:
        r9 = 1;
        ART = r9;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
    L_0x00d9:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 == 0) goto L_0x00e4;
    L_0x00de:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
    L_0x00e4:
        r9 = 7;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        if (r9 == 0) goto L_0x00ee;
    L_0x00e9:
        r9 = 7;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        uid = r9;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
    L_0x00ee:
        r9 = java.lang.System.out;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11 = new java.lang.StringBuilder;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11.<init>();	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r12 = "uid:";
        r11 = r11.append(r12);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r12 = uid;	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11 = r11.append(r12);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r11 = r11.toString();	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
        r9.println(r11);	 Catch:{ NullPointerException -> 0x1166, Exception -> 0x1163 }
    L_0x0108:
        r9 = 5;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1160, Exception -> 0x115d }
        r11 = "copyDC";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1160, Exception -> 0x115d }
        if (r9 == 0) goto L_0x0116;
    L_0x0113:
        r9 = 1;
        copyDC = r9;	 Catch:{ NullPointerException -> 0x1160, Exception -> 0x115d }
    L_0x0116:
        r9 = createAPK;
        if (r9 == 0) goto L_0x0121;
    L_0x011a:
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r9;
    L_0x0121:
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
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.booleanValue();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x032c;
    L_0x0324:
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "RW";
        com.chelpus.Utils.remount(r9, r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x032c:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 != 0) goto L_0x0548;
    L_0x0330:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 != 0) goto L_0x0548;
    L_0x0334:
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        dir = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        dirapp = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        clearTemp();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 4;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "not_system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x034f;
    L_0x034c:
        r9 = 0;
        system = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x034f:
        r9 = 4;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x035d;
    L_0x035a:
        r9 = 1;
        system = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x035d:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "CLASSES mode create odex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 0;
        r50 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "Get classes.dex.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Get classes.dex.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        unzipART(r17);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x039b;
    L_0x0393:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 != 0) goto L_0x03c0;
    L_0x039b:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x03a1:
        r44 = move-exception;
        r9 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        com.chelpus.Utils.sendFromRoot(r9);
    L_0x03a7:
        r9 = filestopatch;
        r9 = r9.iterator();
    L_0x03ad:
        r11 = r9.hasNext();
        if (r11 == 0) goto L_0x10f6;
    L_0x03b3:
        r36 = r9.next();
        r36 = (java.io.File) r36;
        com.chelpus.Utils.fixadler(r36);
        clearTempSD();
        goto L_0x03ad;
    L_0x03c0:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x03cb:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r11 == 0) goto L_0x0407;
    L_0x03d1:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r11 != 0) goto L_0x03ff;
    L_0x03dd:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x03e3:
        r29 = move-exception;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r11 = "Patch Process Exception: ";
        r9 = r9.append(r11);
        r11 = r29.toString();
        r9 = r9.append(r11);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        goto L_0x03a7;
    L_0x03ff:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x03cb;
    L_0x0407:
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 1;
        r47 = com.chelpus.Utils.getPlaceForOdex(r9, r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r46 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r46.<init>(r47);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r46.exists();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x041d;
    L_0x041a:
        r46.delete();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x041d:
        r46 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "-1";
        r11 = "-2";
        r0 = r47;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r46;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r46.exists();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0437;
    L_0x0434:
        r46.delete();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0437:
        r46 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "-2";
        r11 = "-1";
        r0 = r47;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r46;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r46.exists();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0451;
    L_0x044e:
        r46.delete();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0451:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r68 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0457:
        r9 = r68.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x03a7;
    L_0x045d:
        r36 = r68.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r36 = (java.io.File) r36;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "Find string id.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r63 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r63.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "com.android.vending";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "SHA1withRSA";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "com.android.vending.billing.InAppBillingService.BIND";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "Ljava/security/Signature;";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "verify";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "Landroid/content/Intent;";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "setPackage";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "engineVerify";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "Ljava/security/SignatureSpi;";
        r0 = r63;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "String analysis.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "String analysis.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = copyDC;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 != 0) goto L_0x0675;
    L_0x04bc:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r0 = r63;
        r49 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x04c7:
        r31 = 0;
        r32 = 0;
        r33 = 0;
        r30 = 0;
        r59 = 0;
        r48 = 1;
        r66 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r66.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.TypesItem;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Ljava/security/Signature;";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r66;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.TypesItem;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Ljava/security/SignatureSpi;";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r66;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r20 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r20.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Ljava/security/Signature;";
        r12 = "verify";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r20;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Landroid/content/Intent;";
        r12 = "setPackage";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r20;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r49.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0515:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x092f;
    L_0x051b:
        r40 = r11.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r40 = (com.android.vending.billing.InAppBillingService.LOCK.StringItem) r40;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r66.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0525:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r12 == 0) goto L_0x0682;
    L_0x052b:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.TypesItem) r41;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r41;
        r12 = r0.type;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r12 == 0) goto L_0x0525;
    L_0x053f:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r41;
        r0.Type = r12;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x0525;
    L_0x0548:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0613;
    L_0x054c:
        r9 = 0;
        r50 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 5;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        unzipSD(r17);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = sddir;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "/Modified/";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r50;
        r11 = r11.append(r0);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = ".apk";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r11.toString();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        crkapk = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = crkapk;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r17;
        com.chelpus.Utils.copyFile(r0, r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = sddir;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "/Modified/AndroidManifest.xml";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r16.exists();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 != 0) goto L_0x05bf;
    L_0x05b9:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x05bf:
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.AxmlExample;	 Catch:{ Exception -> 0x05e3, FileNotFoundException -> 0x03a1 }
        r9.<init>();	 Catch:{ Exception -> 0x05e3, FileNotFoundException -> 0x03a1 }
        r11 = "19";
        r0 = r16;
        r9 = r9.changeTargetApi(r0, r11);	 Catch:{ Exception -> 0x05e3, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x05d1;
    L_0x05ce:
        r16.delete();	 Catch:{ Exception -> 0x05e3, FileNotFoundException -> 0x03a1 }
    L_0x05d1:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x05dd;
    L_0x05d5:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 != 0) goto L_0x05e8;
    L_0x05dd:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x05e3:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x05d1;
    L_0x05e8:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x05f3:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r11 == 0) goto L_0x0613;
    L_0x05f9:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r11 != 0) goto L_0x060b;
    L_0x0605:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x060b:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x05f3;
    L_0x0613:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0451;
    L_0x0617:
        r9 = "ART mode create dex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 0;
        r50 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        unzipART(r17);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0644;
    L_0x063c:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 != 0) goto L_0x064a;
    L_0x0644:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x064a:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0655:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r11 == 0) goto L_0x0451;
    L_0x065b:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r11 != 0) goto L_0x066d;
    L_0x0667:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x066d:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x0655;
    L_0x0675:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r0 = r63;
        r49 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x04c7;
    L_0x0682:
        r9 = r20.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0686:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r12 == 0) goto L_0x06bf;
    L_0x068c:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r41;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r41;
        r12 = r0.object;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r12 == 0) goto L_0x06a8;
    L_0x06a0:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r41;
        r0.Object = r12;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x06a8:
        r0 = r41;
        r12 = r0.method;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r12 == 0) goto L_0x0686;
    L_0x06b6:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r41;
        r0.Method = r12;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x0686;
    L_0x06bf:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "com.android.vending";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x073f;
    L_0x06cb:
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r31 = 1;
    L_0x073f:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "com.android.vending.billing.InAppBillingService.BIND";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0891;
    L_0x074b:
        r9 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r13 = "c.a.v.b.i ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r40;
        r13 = r0.bits32;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12.toString();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.println(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.repByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r32 = 1;
    L_0x0891:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "SHA1withRSA";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0911;
    L_0x089d:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r33 = 1;
    L_0x0911:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "engineVerify";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x091f;
    L_0x091d:
        r30 = 1;
    L_0x091f:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "Ljava/security/SignatureSpi;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0515;
    L_0x092b:
        r59 = 1;
        goto L_0x0515;
    L_0x092f:
        r52 = 0;
        r53 = 1;
        if (r31 == 0) goto L_0x0937;
    L_0x0935:
        if (r32 != 0) goto L_0x095f;
    L_0x0937:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x095f:
        if (r33 != 0) goto L_0x097f;
    L_0x0961:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 4;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x097f:
        r45 = 0;
        if (r32 == 0) goto L_0x0a6a;
    L_0x0983:
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Relaced strings:";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 1;
        r12 = new java.lang.String[r12];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r13 = 0;
        r14 = "com.android.vending.billing.InAppBillingService.BIND";
        r12[r13] = r14;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r13 = 0;
        r14 = 1;
        r14 = new java.lang.String[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r15 = 0;
        r69 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.class;
        r69 = r69.getPackage();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r69 = r69.getName();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14[r15] = r69;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = com.chelpus.Utils.replaceStringIds(r11, r12, r13, r14);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r45 = 1;
    L_0x09bc:
        r9 = "Parse data for patch.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Parse data for patch.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r12 = 0;
        r0 = r20;
        com.chelpus.Utils.getMethodsIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r20.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x09d7:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0a6e;
    L_0x09dd:
        r41 = r11.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r41;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r41;
        r9 = r0.found_index_command;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x09d7;
    L_0x09e9:
        r0 = r41;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "Ljava/security/Signature;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0a25;
    L_0x09f5:
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0a25:
        r0 = r41;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "Landroid/content/Intent;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x09d7;
    L_0x0a31:
        r9 = pattern3;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x09d7;
    L_0x0a35:
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x09d7;
    L_0x0a6a:
        r45 = 0;
        goto L_0x09bc;
    L_0x0a6e:
        if (r30 == 0) goto L_0x0ad2;
    L_0x0a70:
        if (r59 == 0) goto L_0x0ad2;
    L_0x0a72:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = 0;
        r0 = r66;
        com.chelpus.Utils.getTypesIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = r66.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0a80:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0ad2;
    L_0x0a86:
        r41 = r11.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.TypesItem) r41;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r41;
        r9 = r0.found_id_type;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0a80;
    L_0x0a92:
        r0 = r41;
        r9 = r0.type;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = "Ljava/security/SignatureSpi;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r9 == 0) goto L_0x0a80;
    L_0x0a9e:
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 2;
        r0 = r41;
        r13 = r0.id_type;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 3;
        r0 = r41;
        r13 = r0.id_type;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x0a80;
    L_0x0ad2:
        r9 = r2.size();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto[r9];	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r51 = r0;
        r67 = 0;
        r9 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0ae0:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        if (r11 == 0) goto L_0x0af1;
    L_0x0ae6:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r41;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r51[r67] = r41;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r67 = r67 + 1;
        goto L_0x0ae0;
    L_0x0af1:
        r22 = 0;
    L_0x0af3:
        if (r22 <= 0) goto L_0x0b04;
    L_0x0af5:
        r22 = r22 + -1;
        r9 = "Reworked inapp string!";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Reworked inapp string!";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x0af3;
    L_0x0b04:
        r64 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "rw";
        r0 = r36;
        r9.<init>(r0, r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r10 = r9.getChannel();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "Size file:";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r10.size();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = 0;
        r14 = r10.size();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = (int) r14;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r14 = (long) r9;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r35 = r10.map(r11, r12, r14);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
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
    L_0x0b51:
        r9 = r35.hasRemaining();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 == 0) goto L_0x0cc0;
    L_0x0b57:
        r9 = createAPK;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x0b84;
    L_0x0b5b:
        r9 = r35.position();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9 - r55;
        r11 = 149999; // 0x249ef float:2.10193E-40 double:7.41094E-319;
        if (r9 <= r11) goto L_0x0b84;
    L_0x0b66:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9.<init>();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = "Progress size:";
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r35.position();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r55 = r35.position();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0b84:
        r24 = r35.position();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r23 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r39 = 0;
        r18 = 0;
    L_0x0b90:
        r0 = r51;
        r9 = r0.length;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r18;
        if (r0 >= r9) goto L_0x10e9;
    L_0x0b97:
        r54 = r51[r18];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 == 0) goto L_0x0cf9;
    L_0x0ba6:
        r9 = 5;
        r0 = r18;
        if (r0 == r9) goto L_0x0bb0;
    L_0x0bab:
        r9 = 6;
        r0 = r18;
        if (r0 != r9) goto L_0x0cf9;
    L_0x0bb0:
        if (r39 != 0) goto L_0x0bb6;
    L_0x0bb2:
        r62 = r62 + 1;
        r39 = 1;
    L_0x0bb6:
        r0 = r62;
        r1 = r28;
        if (r0 >= r1) goto L_0x0e0f;
    L_0x0bbc:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r23;
        if (r0 != r9) goto L_0x0cf2;
    L_0x0bc7:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x0bd7;
    L_0x0bd0:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0bd7:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r57 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0be4:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r57;
        if (r0 == r9) goto L_0x0c15;
    L_0x0bee:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 1;
        if (r9 == r11) goto L_0x0c15;
    L_0x0bf7:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 20;
        if (r9 == r11) goto L_0x0c15;
    L_0x0c01:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 21;
        if (r9 == r11) goto L_0x0c15;
    L_0x0c0b:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 23;
        if (r9 != r11) goto L_0x0cf2;
    L_0x0c15:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x0c23;
    L_0x0c1d:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r57;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0c23:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 20;
        if (r9 != r11) goto L_0x0c36;
    L_0x0c2d:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r57 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0c36:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 21;
        if (r9 != r11) goto L_0x0c4b;
    L_0x0c40:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r57 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0c4b:
        r38 = r38 + 1;
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r38;
        if (r0 != r9) goto L_0x0e09;
    L_0x0c56:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r35.force();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = print;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9.println(r11);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = 1;
        r0 = r54;
        r0.result = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0c87:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0ce9;
    L_0x0c8d:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0c87;
    L_0x0ca1:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0c87;
    L_0x0ca7:
        r29 = move-exception;
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r0 = r29;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
    L_0x0cc0:
        r10.close();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r11 = "";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r12 = r12 - r64;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        r9 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x03a1, Exception -> 0x03e3 }
        goto L_0x0457;
    L_0x0ce9:
        r62 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0cf2:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0cf9:
        r0 = r54;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 == 0) goto L_0x0e53;
    L_0x0cff:
        r9 = 9;
        r0 = r18;
        if (r0 == r9) goto L_0x0d0b;
    L_0x0d05:
        r9 = 10;
        r0 = r18;
        if (r0 != r9) goto L_0x0e53;
    L_0x0d0b:
        r9 = print;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = "search jump";
        r9.println(r11);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r39 != 0) goto L_0x0d18;
    L_0x0d14:
        r61 = r61 + 1;
        r39 = 1;
    L_0x0d18:
        r0 = r61;
        r1 = r27;
        if (r0 >= r1) goto L_0x0f57;
    L_0x0d1e:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r23;
        if (r0 != r9) goto L_0x0e4c;
    L_0x0d29:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x0d39;
    L_0x0d32:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0d39:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r57 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0d46:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r57;
        if (r0 == r9) goto L_0x0d77;
    L_0x0d50:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 1;
        if (r9 == r11) goto L_0x0d77;
    L_0x0d59:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 20;
        if (r9 == r11) goto L_0x0d77;
    L_0x0d63:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 21;
        if (r9 == r11) goto L_0x0d77;
    L_0x0d6d:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 23;
        if (r9 != r11) goto L_0x0e4c;
    L_0x0d77:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x0d85;
    L_0x0d7f:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r57;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0d85:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 20;
        if (r9 != r11) goto L_0x0d98;
    L_0x0d8f:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r57 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0d98:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 21;
        if (r9 != r11) goto L_0x0dad;
    L_0x0da2:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r57 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0dad:
        r38 = r38 + 1;
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r38;
        if (r0 != r9) goto L_0x0f51;
    L_0x0db8:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r35.force();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = print;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9.println(r11);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = 1;
        r0 = r54;
        r0.result = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0de9:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0e43;
    L_0x0def:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0de9;
    L_0x0e03:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0de9;
    L_0x0e09:
        r57 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0be4;
    L_0x0e0f:
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0e18:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0e38;
    L_0x0e1e:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0e18;
    L_0x0e32:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0e18;
    L_0x0e38:
        r62 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0cf9;
    L_0x0e43:
        r61 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0e4c:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0e53:
        r0 = r54;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 == 0) goto L_0x0f9b;
    L_0x0e59:
        r9 = 4;
        r0 = r18;
        if (r0 != r9) goto L_0x0f9b;
    L_0x0e5e:
        r60 = r60 + 1;
        r0 = r60;
        r1 = r26;
        if (r0 >= r1) goto L_0x10a4;
    L_0x0e66:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r23;
        if (r0 != r9) goto L_0x0f94;
    L_0x0e71:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x0e81;
    L_0x0e7a:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0e81:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r57 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0e8e:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r57;
        if (r0 == r9) goto L_0x0ebf;
    L_0x0e98:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 1;
        if (r9 == r11) goto L_0x0ebf;
    L_0x0ea1:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 20;
        if (r9 == r11) goto L_0x0ebf;
    L_0x0eab:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 21;
        if (r9 == r11) goto L_0x0ebf;
    L_0x0eb5:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 23;
        if (r9 != r11) goto L_0x0f94;
    L_0x0ebf:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x0ecd;
    L_0x0ec7:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r57;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0ecd:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 20;
        if (r9 != r11) goto L_0x0ee0;
    L_0x0ed7:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r57 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0ee0:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 21;
        if (r9 != r11) goto L_0x0ef5;
    L_0x0eea:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r57 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0ef5:
        r38 = r38 + 1;
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r38;
        if (r0 != r9) goto L_0x109e;
    L_0x0f00:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r35.force();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = print;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9.println(r11);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = 1;
        r0 = r54;
        r0.result = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0f31:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0f8b;
    L_0x0f37:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0f31;
    L_0x0f4b:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0f31;
    L_0x0f51:
        r57 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0d46;
    L_0x0f57:
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0f60:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0f80;
    L_0x0f66:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x0f60;
    L_0x0f7a:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0f60;
    L_0x0f80:
        r61 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0e53;
    L_0x0f8b:
        r60 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0f94:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0f9b:
        r0 = r54;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x10e5;
    L_0x0fa1:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r23;
        if (r0 != r9) goto L_0x10e5;
    L_0x0fac:
        r0 = r54;
        r9 = r0.pattern;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 == 0) goto L_0x10e5;
    L_0x0fb2:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x0fc2;
    L_0x0fbb:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0fc2:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r57 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x0fcf:
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r57;
        if (r0 == r9) goto L_0x1000;
    L_0x0fd9:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 1;
        if (r9 == r11) goto L_0x1000;
    L_0x0fe2:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 20;
        if (r9 == r11) goto L_0x1000;
    L_0x0fec:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 21;
        if (r9 == r11) goto L_0x1000;
    L_0x0ff6:
        r0 = r54;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 23;
        if (r9 != r11) goto L_0x10de;
    L_0x1000:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x100e;
    L_0x1008:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r57;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x100e:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 20;
        if (r9 != r11) goto L_0x1021;
    L_0x1018:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r57 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x1021:
        r0 = r54;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = 21;
        if (r9 != r11) goto L_0x1036;
    L_0x102b:
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r57 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x1036:
        r38 = r38 + 1;
        r0 = r54;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r38;
        if (r0 != r9) goto L_0x10d8;
    L_0x1041:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r35.force();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = print;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9.println(r11);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = 1;
        r0 = r54;
        r0.result = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r9 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = "";
        r9 = r9.equals(r11);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r9 != 0) goto L_0x10de;
    L_0x1075:
        r9 = 1;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x107e:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x10de;
    L_0x1084:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x107e;
    L_0x1098:
        r11 = 1;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x107e;
    L_0x109e:
        r57 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0e8e;
    L_0x10a4:
        r9 = 0;
        r0 = r54;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x10ad:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x10cd;
    L_0x10b3:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r0 = r54;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        if (r11 == 0) goto L_0x10ad;
    L_0x10c7:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x10ad;
    L_0x10cd:
        r60 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0f9b;
    L_0x10d8:
        r57 = r35.get();	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        goto L_0x0fcf;
    L_0x10de:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
    L_0x10e5:
        r18 = r18 + 1;
        goto L_0x0b90;
    L_0x10e9:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ca7, FileNotFoundException -> 0x03a1 }
        r12 = 1;
        r42 = r42 + r12;
        goto L_0x0b51;
    L_0x10f6:
        r9 = createAPK;
        if (r9 != 0) goto L_0x114a;
    L_0x10fa:
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
        r9.<init>();
        r11 = "chelpus_return_";
        r9 = r9.append(r11);
        r0 = r58;
        r9 = r9.append(r0);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        if (r58 != 0) goto L_0x114a;
    L_0x1130:
        r9 = ART;
        if (r9 != 0) goto L_0x114a;
    L_0x1134:
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
    L_0x114a:
        r9 = "Optional Steps After Patch:";
        com.chelpus.Utils.sendFromRoot(r9);
        r9 = createAPK;
        if (r9 != 0) goto L_0x1156;
    L_0x1153:
        com.chelpus.Utils.exitFromRootJava();
    L_0x1156:
        r0 = r56;
        r9 = r0.allresult;
        result = r9;
        return;
    L_0x115d:
        r9 = move-exception;
        goto L_0x0116;
    L_0x1160:
        r9 = move-exception;
        goto L_0x0116;
    L_0x1163:
        r9 = move-exception;
        goto L_0x0108;
    L_0x1166:
        r9 = move-exception;
        goto L_0x0108;
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
            Utils.sendFromRoot("" + e.toString());
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
                if (ze != null) {
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
                } else {
                    zin.close();
                    fin.close();
                    return;
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
            Utils.sendFromRoot("" + e.toString());
        }
    }
}
