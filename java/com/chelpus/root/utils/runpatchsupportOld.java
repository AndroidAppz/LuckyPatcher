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
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11 = "pattern0";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 != 0) goto L_0x0097;
    L_0x0094:
        r9 = 0;
        pattern1 = r9;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
    L_0x0097:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11 = "pattern1";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 != 0) goto L_0x00a5;
    L_0x00a2:
        r9 = 0;
        pattern2 = r9;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
    L_0x00a5:
        r9 = 1;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11 = "pattern2";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 != 0) goto L_0x00b3;
    L_0x00b0:
        r9 = 0;
        pattern3 = r9;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
    L_0x00b3:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 == 0) goto L_0x00c6;
    L_0x00b8:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11 = "createAPK";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 == 0) goto L_0x00c6;
    L_0x00c3:
        r9 = 1;
        createAPK = r9;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
    L_0x00c6:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 == 0) goto L_0x00d9;
    L_0x00cb:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11 = "ART";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 == 0) goto L_0x00d9;
    L_0x00d6:
        r9 = 1;
        ART = r9;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
    L_0x00d9:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 == 0) goto L_0x00e4;
    L_0x00de:
        r9 = 6;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
    L_0x00e4:
        r9 = 7;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        if (r9 == 0) goto L_0x00ee;
    L_0x00e9:
        r9 = 7;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        uid = r9;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
    L_0x00ee:
        r9 = java.lang.System.out;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11 = new java.lang.StringBuilder;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11.<init>();	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r12 = "uid:";
        r11 = r11.append(r12);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r12 = uid;	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11 = r11.append(r12);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r11 = r11.toString();	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
        r9.println(r11);	 Catch:{ NullPointerException -> 0x137b, Exception -> 0x1378 }
    L_0x0108:
        r9 = 5;
        r9 = r70[r9];	 Catch:{ NullPointerException -> 0x1375, Exception -> 0x1372 }
        r11 = "copyDC";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1375, Exception -> 0x1372 }
        if (r9 == 0) goto L_0x0116;
    L_0x0113:
        r9 = 1;
        copyDC = r9;	 Catch:{ NullPointerException -> 0x1375, Exception -> 0x1372 }
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
        if (r9 == 0) goto L_0x0442;
    L_0x041d:
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
    L_0x0442:
        r21 = 0;
        r9 = java.lang.Boolean.valueOf(r21);
        com.chelpus.Utils.convertToPatchItemAuto(r2, r3, r4, r5, r6, r7, r8, r9);
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.booleanValue();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x045b;
    L_0x0453:
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "RW";
        com.chelpus.Utils.remount(r9, r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x045b:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 != 0) goto L_0x0677;
    L_0x045f:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 != 0) goto L_0x0677;
    L_0x0463:
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        dir = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        dirapp = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        clearTemp();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 4;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "not_system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x047e;
    L_0x047b:
        r9 = 0;
        system = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x047e:
        r9 = 4;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x048c;
    L_0x0489:
        r9 = 1;
        system = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x048c:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "CLASSES mode create odex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 0;
        r49 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "Get classes.dex.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Get classes.dex.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        unzipART(r17);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x04ca;
    L_0x04c2:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 != 0) goto L_0x04ef;
    L_0x04ca:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x04d0:
        r44 = move-exception;
        r9 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        com.chelpus.Utils.sendFromRoot(r9);
    L_0x04d6:
        r9 = filestopatch;
        r9 = r9.iterator();
    L_0x04dc:
        r11 = r9.hasNext();
        if (r11 == 0) goto L_0x130b;
    L_0x04e2:
        r36 = r9.next();
        r36 = (java.io.File) r36;
        com.chelpus.Utils.fixadler(r36);
        clearTempSD();
        goto L_0x04dc;
    L_0x04ef:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x04fa:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r11 == 0) goto L_0x0536;
    L_0x0500:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r11 != 0) goto L_0x052e;
    L_0x050c:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0512:
        r29 = move-exception;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r11 = "Patch Process Exception: ";
        r9 = r9.append(r11);
        r11 = r29.toString();
        r9 = r9.append(r11);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        goto L_0x04d6;
    L_0x052e:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x04fa;
    L_0x0536:
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 1;
        r46 = com.chelpus.Utils.getPlaceForOdex(r9, r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r45 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r45.<init>(r46);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r45.exists();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x054c;
    L_0x0549:
        r45.delete();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x054c:
        r45 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "-1";
        r11 = "-2";
        r0 = r46;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r45;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r45.exists();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0566;
    L_0x0563:
        r45.delete();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0566:
        r45 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "-2";
        r11 = "-1";
        r0 = r46;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r45;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r45.exists();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0580;
    L_0x057d:
        r45.delete();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0580:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r69 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0586:
        r9 = r69.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x04d6;
    L_0x058c:
        r36 = r69.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r36 = (java.io.File) r36;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "Find string id.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r64 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r64.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "com.android.vending";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "SHA1withRSA";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "com.android.vending.billing.InAppBillingService.BIND";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "Ljava/security/Signature;";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "verify";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "Landroid/content/Intent;";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "setPackage";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "engineVerify";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "Ljava/security/SignatureSpi;";
        r0 = r64;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "String analysis.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "String analysis.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = copyDC;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 != 0) goto L_0x07a4;
    L_0x05eb:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r0 = r64;
        r48 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x05f6:
        r31 = 0;
        r32 = 0;
        r33 = 0;
        r30 = 0;
        r60 = 0;
        r47 = 1;
        r65 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r65.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.TypesItem;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Ljava/security/Signature;";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r65;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.TypesItem;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Ljava/security/SignatureSpi;";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r65;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r20 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r20.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Ljava/security/Signature;";
        r12 = "verify";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r20;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Landroid/content/Intent;";
        r12 = "setPackage";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r20;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = r48.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0644:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0adc;
    L_0x064a:
        r40 = r11.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r40 = (com.android.vending.billing.InAppBillingService.LOCK.StringItem) r40;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r65.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0654:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r12 == 0) goto L_0x07b1;
    L_0x065a:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.TypesItem) r41;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r41;
        r12 = r0.type;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r12 == 0) goto L_0x0654;
    L_0x066e:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r41;
        r0.Type = r12;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x0654;
    L_0x0677:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0742;
    L_0x067b:
        r9 = 0;
        r49 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 5;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        unzipSD(r17);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = sddir;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "/Modified/";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r49;
        r11 = r11.append(r0);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = ".apk";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = r11.toString();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        crkapk = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = crkapk;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r17;
        com.chelpus.Utils.copyFile(r0, r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = sddir;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "/Modified/AndroidManifest.xml";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r16.exists();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 != 0) goto L_0x06ee;
    L_0x06e8:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x06ee:
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.AxmlExample;	 Catch:{ Exception -> 0x0712, FileNotFoundException -> 0x04d0 }
        r9.<init>();	 Catch:{ Exception -> 0x0712, FileNotFoundException -> 0x04d0 }
        r11 = "19";
        r0 = r16;
        r9 = r9.changeTargetApi(r0, r11);	 Catch:{ Exception -> 0x0712, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x0700;
    L_0x06fd:
        r16.delete();	 Catch:{ Exception -> 0x0712, FileNotFoundException -> 0x04d0 }
    L_0x0700:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x070c;
    L_0x0704:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 != 0) goto L_0x0717;
    L_0x070c:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0712:
        r29 = move-exception;
        r29.printStackTrace();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x0700;
    L_0x0717:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0722:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r11 == 0) goto L_0x0742;
    L_0x0728:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r11 != 0) goto L_0x073a;
    L_0x0734:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x073a:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x0722;
    L_0x0742:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0580;
    L_0x0746:
        r9 = "ART mode create dex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 0;
        r49 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 2;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 3;
        r9 = r70[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r17;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        unzipART(r17);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0773;
    L_0x076b:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 != 0) goto L_0x0779;
    L_0x0773:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0779:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0784:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r11 == 0) goto L_0x0580;
    L_0x078a:
        r19 = r9.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r19 = (java.io.File) r19;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = r19.exists();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r11 != 0) goto L_0x079c;
    L_0x0796:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x079c:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r19;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x0784;
    L_0x07a4:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r0 = r64;
        r48 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x05f6;
    L_0x07b1:
        r9 = r20.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x07b5:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r12 == 0) goto L_0x07ee;
    L_0x07bb:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r41;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r41;
        r12 = r0.object;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r12 == 0) goto L_0x07d7;
    L_0x07cf:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r41;
        r0.Object = r12;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x07d7:
        r0 = r41;
        r12 = r0.method;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r40;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r12 == 0) goto L_0x07b5;
    L_0x07e5:
        r0 = r40;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r41;
        r0.Method = r12;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x07b5;
    L_0x07ee:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "com.android.vending";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x095e;
    L_0x07fa:
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r31 = 1;
    L_0x095e:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "com.android.vending.billing.InAppBillingService.BIND";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0a3e;
    L_0x096a:
        r9 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r13 = "c.a.v.b.i ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r40;
        r13 = r0.bits32;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r13 = " ";
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.append(r13);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12.toString();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.println(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r32 = 1;
    L_0x0a3e:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "SHA1withRSA";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0abe;
    L_0x0a4a:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 4;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 5;
        r0 = r40;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r33 = 1;
    L_0x0abe:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "engineVerify";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0acc;
    L_0x0aca:
        r30 = 1;
    L_0x0acc:
        r0 = r40;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "Ljava/security/SignatureSpi;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0644;
    L_0x0ad8:
        r60 = 1;
        goto L_0x0644;
    L_0x0adc:
        r51 = 0;
        r52 = 1;
        if (r31 == 0) goto L_0x0ae4;
    L_0x0ae2:
        if (r32 != 0) goto L_0x0b5b;
    L_0x0ae4:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 5;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 6;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 7;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 8;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "";
        r9.marker = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 9;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "";
        r9.marker = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 10;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "";
        r9.marker = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0b5b:
        if (r33 != 0) goto L_0x0b7b;
    L_0x0b5d:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 4;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0b7b:
        r9 = "Parse data for patch.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Parse data for patch.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r12 = 0;
        r0 = r20;
        com.chelpus.Utils.getMethodsIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = r20.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0b96:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0c2c;
    L_0x0b9c:
        r41 = r11.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r41;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r41;
        r9 = r0.found_index_command;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0b96;
    L_0x0ba8:
        r0 = r41;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "Ljava/security/Signature;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0be7;
    L_0x0bb4:
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0be7:
        r0 = r41;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "Landroid/content/Intent;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0b96;
    L_0x0bf3:
        r9 = pattern3;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0b96;
    L_0x0bf7:
        r9 = 12;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 12;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r41;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 12;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x0b96;
    L_0x0c2c:
        if (r30 == 0) goto L_0x0c90;
    L_0x0c2e:
        if (r60 == 0) goto L_0x0c90;
    L_0x0c30:
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r0 = r65;
        com.chelpus.Utils.getTypesIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = r65.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0c3e:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0c90;
    L_0x0c44:
        r41 = r11.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.TypesItem) r41;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r41;
        r9 = r0.found_id_type;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0c3e;
    L_0x0c50:
        r0 = r41;
        r9 = r0.type;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = "Ljava/security/SignatureSpi;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r9 == 0) goto L_0x0c3e;
    L_0x0c5c:
        r9 = 15;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 2;
        r0 = r41;
        r13 = r0.id_type;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 15;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 3;
        r0 = r41;
        r13 = r0.id_type;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = 15;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x0c3e;
    L_0x0c90:
        r9 = r2.size();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto[r9];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r50 = r0;
        r68 = 0;
        r9 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0c9e:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        if (r11 == 0) goto L_0x0caf;
    L_0x0ca4:
        r41 = r9.next();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r41 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r41;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r50[r68] = r41;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r68 = r68 + 1;
        goto L_0x0c9e;
    L_0x0caf:
        r22 = 0;
        r9 = "Set Strings.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Set Strings.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r59 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r59.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "com.android.vending.billing.InAppBillingService.BIND";
        r9 = r9.getBytes();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r59;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r59.size();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = new byte[r9][];	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r58 = r0;
        r0 = r59;
        r1 = r58;
        r9 = r0.toArray(r1);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (byte[][]) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r9;
        r0 = (byte[][]) r0;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r58 = r0;
        r9 = r36.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = 0;
        r12 = 76;
        r0 = r58;
        r22 = com.chelpus.Utils.setStringIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0cf1:
        if (r22 <= 0) goto L_0x0d02;
    L_0x0cf3:
        r22 = r22 + -1;
        r9 = "Reworked inapp string!";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Reworked inapp string!";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x0cf1;
    L_0x0d02:
        r66 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "rw";
        r0 = r36;
        r9.<init>(r0, r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r10 = r9.getChannel();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "Size file:";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r10.size();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = 0;
        r14 = r10.size();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = (int) r14;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r14 = (long) r9;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r35 = r10.map(r11, r12, r14);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
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
    L_0x0d4f:
        r9 = r35.hasRemaining();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 == 0) goto L_0x0ed5;
    L_0x0d55:
        r9 = createAPK;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x0d82;
    L_0x0d59:
        r9 = r35.position();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9 - r54;
        r11 = 149999; // 0x249ef float:2.10193E-40 double:7.41094E-319;
        if (r9 <= r11) goto L_0x0d82;
    L_0x0d64:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9.<init>();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = "Progress size:";
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r35.position();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r54 = r35.position();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0d82:
        r24 = r35.position();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r23 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r39 = 0;
        r18 = 0;
    L_0x0d8e:
        r0 = r50;
        r9 = r0.length;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r18;
        if (r0 >= r9) goto L_0x12fe;
    L_0x0d95:
        r53 = r50[r18];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 == 0) goto L_0x0f0e;
    L_0x0da4:
        r9 = 5;
        r0 = r18;
        if (r0 == r9) goto L_0x0dc5;
    L_0x0da9:
        r9 = 6;
        r0 = r18;
        if (r0 == r9) goto L_0x0dc5;
    L_0x0dae:
        r9 = 7;
        r0 = r18;
        if (r0 == r9) goto L_0x0dc5;
    L_0x0db3:
        r9 = 8;
        r0 = r18;
        if (r0 == r9) goto L_0x0dc5;
    L_0x0db9:
        r9 = 9;
        r0 = r18;
        if (r0 == r9) goto L_0x0dc5;
    L_0x0dbf:
        r9 = 10;
        r0 = r18;
        if (r0 != r9) goto L_0x0f0e;
    L_0x0dc5:
        if (r39 != 0) goto L_0x0dcb;
    L_0x0dc7:
        r63 = r63 + 1;
        r39 = 1;
    L_0x0dcb:
        r0 = r63;
        r1 = r28;
        if (r0 >= r1) goto L_0x1024;
    L_0x0dd1:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r23;
        if (r0 != r9) goto L_0x0f07;
    L_0x0ddc:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x0dec;
    L_0x0de5:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0dec:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r56 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0df9:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r56;
        if (r0 == r9) goto L_0x0e2a;
    L_0x0e03:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 1;
        if (r9 == r11) goto L_0x0e2a;
    L_0x0e0c:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 20;
        if (r9 == r11) goto L_0x0e2a;
    L_0x0e16:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 21;
        if (r9 == r11) goto L_0x0e2a;
    L_0x0e20:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 23;
        if (r9 != r11) goto L_0x0f07;
    L_0x0e2a:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x0e38;
    L_0x0e32:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r56;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0e38:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 20;
        if (r9 != r11) goto L_0x0e4b;
    L_0x0e42:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r56 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0e4b:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 21;
        if (r9 != r11) goto L_0x0e60;
    L_0x0e55:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r56 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0e60:
        r38 = r38 + 1;
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r38;
        if (r0 != r9) goto L_0x101e;
    L_0x0e6b:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r35.force();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = print;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9.println(r11);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = 1;
        r0 = r53;
        r0.result = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0e9c:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x0efe;
    L_0x0ea2:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x0e9c;
    L_0x0eb6:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x0e9c;
    L_0x0ebc:
        r29 = move-exception;
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r0 = r29;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
    L_0x0ed5:
        r10.close();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r11 = "";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r12 = r12 - r66;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        r9 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x04d0, Exception -> 0x0512 }
        goto L_0x0586;
    L_0x0efe:
        r63 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0f07:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0f0e:
        r0 = r53;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 == 0) goto L_0x1068;
    L_0x0f14:
        r9 = 13;
        r0 = r18;
        if (r0 == r9) goto L_0x0f20;
    L_0x0f1a:
        r9 = 14;
        r0 = r18;
        if (r0 != r9) goto L_0x1068;
    L_0x0f20:
        r9 = print;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = "search jump";
        r9.println(r11);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r39 != 0) goto L_0x0f2d;
    L_0x0f29:
        r62 = r62 + 1;
        r39 = 1;
    L_0x0f2d:
        r0 = r62;
        r1 = r27;
        if (r0 >= r1) goto L_0x116c;
    L_0x0f33:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r23;
        if (r0 != r9) goto L_0x1061;
    L_0x0f3e:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x0f4e;
    L_0x0f47:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0f4e:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r56 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0f5b:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r56;
        if (r0 == r9) goto L_0x0f8c;
    L_0x0f65:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 1;
        if (r9 == r11) goto L_0x0f8c;
    L_0x0f6e:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 20;
        if (r9 == r11) goto L_0x0f8c;
    L_0x0f78:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 21;
        if (r9 == r11) goto L_0x0f8c;
    L_0x0f82:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 23;
        if (r9 != r11) goto L_0x1061;
    L_0x0f8c:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x0f9a;
    L_0x0f94:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r56;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0f9a:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 20;
        if (r9 != r11) goto L_0x0fad;
    L_0x0fa4:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r56 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0fad:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 21;
        if (r9 != r11) goto L_0x0fc2;
    L_0x0fb7:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r56 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0fc2:
        r38 = r38 + 1;
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r38;
        if (r0 != r9) goto L_0x1166;
    L_0x0fcd:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r35.force();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = print;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9.println(r11);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = 1;
        r0 = r53;
        r0.result = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x0ffe:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x1058;
    L_0x1004:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x0ffe;
    L_0x1018:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x0ffe;
    L_0x101e:
        r56 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x0df9;
    L_0x1024:
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x102d:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x104d;
    L_0x1033:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x102d;
    L_0x1047:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x102d;
    L_0x104d:
        r63 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x0f0e;
    L_0x1058:
        r62 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x1061:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x1068:
        r0 = r53;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 == 0) goto L_0x11b0;
    L_0x106e:
        r9 = 4;
        r0 = r18;
        if (r0 != r9) goto L_0x11b0;
    L_0x1073:
        r61 = r61 + 1;
        r0 = r61;
        r1 = r26;
        if (r0 >= r1) goto L_0x12b9;
    L_0x107b:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r23;
        if (r0 != r9) goto L_0x11a9;
    L_0x1086:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x1096;
    L_0x108f:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x1096:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r56 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x10a3:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r56;
        if (r0 == r9) goto L_0x10d4;
    L_0x10ad:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 1;
        if (r9 == r11) goto L_0x10d4;
    L_0x10b6:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 20;
        if (r9 == r11) goto L_0x10d4;
    L_0x10c0:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 21;
        if (r9 == r11) goto L_0x10d4;
    L_0x10ca:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 23;
        if (r9 != r11) goto L_0x11a9;
    L_0x10d4:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x10e2;
    L_0x10dc:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r56;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x10e2:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 20;
        if (r9 != r11) goto L_0x10f5;
    L_0x10ec:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r56 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x10f5:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 21;
        if (r9 != r11) goto L_0x110a;
    L_0x10ff:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r56 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x110a:
        r38 = r38 + 1;
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r38;
        if (r0 != r9) goto L_0x12b3;
    L_0x1115:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r35.force();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = print;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9.println(r11);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = 1;
        r0 = r53;
        r0.result = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x1146:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x11a0;
    L_0x114c:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x1146;
    L_0x1160:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x1146;
    L_0x1166:
        r56 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x0f5b;
    L_0x116c:
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x1175:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x1195;
    L_0x117b:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x1175;
    L_0x118f:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x1175;
    L_0x1195:
        r62 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x1068;
    L_0x11a0:
        r61 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x11a9:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x11b0:
        r0 = r53;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x12fa;
    L_0x11b6:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r23;
        if (r0 != r9) goto L_0x12fa;
    L_0x11c1:
        r0 = r53;
        r9 = r0.pattern;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 == 0) goto L_0x12fa;
    L_0x11c7:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x11d7;
    L_0x11d0:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 0;
        r9[r11] = r23;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x11d7:
        r38 = 1;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r56 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x11e4:
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r56;
        if (r0 == r9) goto L_0x1215;
    L_0x11ee:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 1;
        if (r9 == r11) goto L_0x1215;
    L_0x11f7:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 20;
        if (r9 == r11) goto L_0x1215;
    L_0x1201:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 21;
        if (r9 == r11) goto L_0x1215;
    L_0x120b:
        r0 = r53;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 23;
        if (r9 != r11) goto L_0x12f3;
    L_0x1215:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x1223;
    L_0x121d:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r56;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x1223:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 20;
        if (r9 != r11) goto L_0x1236;
    L_0x122d:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r56 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x1236:
        r0 = r53;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9[r38];	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = 21;
        if (r9 != r11) goto L_0x124b;
    L_0x1240:
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r56 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9[r38] = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x124b:
        r38 = r38 + 1;
        r0 = r53;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r9.length;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r38;
        if (r0 != r9) goto L_0x12ed;
    L_0x1256:
        r0 = r35;
        r1 = r24;
        r0.position(r1);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r35;
        r0.put(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r35.force();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = print;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9.println(r11);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = 1;
        r0 = r53;
        r0.result = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r9 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = "";
        r9 = r9.equals(r11);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r9 != 0) goto L_0x12f3;
    L_0x128a:
        r9 = 1;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x1293:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x12f3;
    L_0x1299:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x1293;
    L_0x12ad:
        r11 = 1;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x1293;
    L_0x12b3:
        r56 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x10a3;
    L_0x12b9:
        r9 = 0;
        r0 = r53;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x12c2:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x12e2;
    L_0x12c8:
        r25 = r9.next();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r25 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r25;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r25;
        r11 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r0 = r53;
        r12 = r0.marker;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        if (r11 == 0) goto L_0x12c2;
    L_0x12dc:
        r11 = 0;
        r0 = r25;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x12c2;
    L_0x12e2:
        r61 = 0;
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x11b0;
    L_0x12ed:
        r56 = r35.get();	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        goto L_0x11e4;
    L_0x12f3:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
    L_0x12fa:
        r18 = r18 + 1;
        goto L_0x0d8e;
    L_0x12fe:
        r9 = r24 + 1;
        r0 = r35;
        r0.position(r9);	 Catch:{ Exception -> 0x0ebc, FileNotFoundException -> 0x04d0 }
        r12 = 1;
        r42 = r42 + r12;
        goto L_0x0d4f;
    L_0x130b:
        r9 = createAPK;
        if (r9 != 0) goto L_0x135f;
    L_0x130f:
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
        r9.<init>();
        r11 = "chelpus_return_";
        r9 = r9.append(r11);
        r0 = r57;
        r9 = r9.append(r0);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        if (r57 != 0) goto L_0x135f;
    L_0x1345:
        r9 = ART;
        if (r9 != 0) goto L_0x135f;
    L_0x1349:
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
    L_0x135f:
        r9 = "Optional Steps After Patch:";
        com.chelpus.Utils.sendFromRoot(r9);
        r9 = createAPK;
        if (r9 != 0) goto L_0x136b;
    L_0x1368:
        com.chelpus.Utils.exitFromRootJava();
    L_0x136b:
        r0 = r55;
        r9 = r0.allresult;
        result = r9;
        return;
    L_0x1372:
        r9 = move-exception;
        goto L_0x0116;
    L_0x1375:
        r9 = move-exception;
        goto L_0x0116;
    L_0x1378:
        r9 = move-exception;
        goto L_0x0108;
    L_0x137b:
        r9 = move-exception;
        goto L_0x0108;
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
