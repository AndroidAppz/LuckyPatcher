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

public class runpatchads {
    private static boolean ART = false;
    public static String AdsBlockFile = "";
    public static String appdir = "/sdcard/";
    public static ArrayList<File> classesFiles = new ArrayList();
    private static boolean copyDC = false;
    private static boolean createAPK = false;
    public static File crkapk;
    private static boolean dependencies = true;
    public static String dir = "/sdcard/";
    public static String dir2 = "/sdcard/";
    public static String dirapp = "/data/app/";
    private static boolean fileblock = true;
    public static ArrayList<File> filestopatch = null;
    private static boolean full_offline = true;
    private static boolean pattern1 = true;
    private static boolean pattern2 = true;
    private static boolean pattern3 = true;
    private static boolean pattern4 = true;
    private static boolean pattern5 = true;
    private static boolean pattern6 = true;
    public static PrintStream print;
    public static String result;
    public static String sddir = "/sdcard/";
    public static byte[][] sites;
    public static boolean system = false;
    public static String uid = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r63) {
        /*
        r9 = classesFiles;
        r9.clear();
        r48 = new com.android.vending.billing.InAppBillingService.LOCK.LogOutputStream;
        r9 = "System.out";
        r0 = r48;
        r0.<init>(r9);
        r9 = new java.io.PrintStream;
        r0 = r48;
        r9.<init>(r0);
        print = r9;
        r9 = print;
        r11 = "Ads-Code Running!";
        r9.println(r11);
        r9 = new com.chelpus.root.utils.runpatchads$1;
        r9.<init>();
        com.chelpus.Utils.startRootJava(r9);
        r9 = "Ads-Code Running!";
        com.chelpus.Utils.sendFromRoot(r9);
        r9 = 0;
        r9 = r63[r9];
        com.chelpus.Utils.kill(r9);
        r2 = new java.util.ArrayList;
        r2.<init>();
        r9 = 1;
        fileblock = r9;
        r9 = 1;
        pattern1 = r9;
        r9 = 1;
        pattern2 = r9;
        r9 = 1;
        pattern3 = r9;
        r9 = 1;
        pattern4 = r9;
        r9 = 1;
        pattern5 = r9;
        r9 = 1;
        pattern6 = r9;
        r9 = 1;
        dependencies = r9;
        r9 = 1;
        full_offline = r9;
        r9 = new java.util.ArrayList;
        r9.<init>();
        filestopatch = r9;
        r9 = new java.io.File;	 Catch:{ Exception -> 0x009c }
        r11 = 3;
        r11 = r63[r11];	 Catch:{ Exception -> 0x009c }
        r9.<init>(r11);	 Catch:{ Exception -> 0x009c }
        r34 = r9.listFiles();	 Catch:{ Exception -> 0x009c }
        r0 = r34;
        r11 = r0.length;	 Catch:{ Exception -> 0x009c }
        r9 = 0;
    L_0x0068:
        if (r9 >= r11) goto L_0x00a0;
    L_0x006a:
        r31 = r34[r9];	 Catch:{ Exception -> 0x009c }
        r12 = r31.isFile();	 Catch:{ Exception -> 0x009c }
        if (r12 == 0) goto L_0x0099;
    L_0x0072:
        r12 = r31.getName();	 Catch:{ Exception -> 0x009c }
        r13 = "busybox";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x009c }
        if (r12 != 0) goto L_0x0099;
    L_0x007e:
        r12 = r31.getName();	 Catch:{ Exception -> 0x009c }
        r13 = "reboot";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x009c }
        if (r12 != 0) goto L_0x0099;
    L_0x008a:
        r12 = r31.getName();	 Catch:{ Exception -> 0x009c }
        r13 = "dalvikvm";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x009c }
        if (r12 != 0) goto L_0x0099;
    L_0x0096:
        r31.delete();	 Catch:{ Exception -> 0x009c }
    L_0x0099:
        r9 = r9 + 1;
        goto L_0x0068;
    L_0x009c:
        r27 = move-exception;
        r27.printStackTrace();
    L_0x00a0:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "pattern0";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x00ae;
    L_0x00ab:
        r9 = 0;
        fileblock = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x00ae:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "pattern1";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x00bc;
    L_0x00b9:
        r9 = 0;
        pattern1 = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x00bc:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "pattern2";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x00ca;
    L_0x00c7:
        r9 = 0;
        pattern2 = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x00ca:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "pattern3";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x00d8;
    L_0x00d5:
        r9 = 0;
        pattern3 = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x00d8:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "pattern4";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x00e6;
    L_0x00e3:
        r9 = 0;
        pattern4 = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x00e6:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "pattern5";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x00f4;
    L_0x00f1:
        r9 = 0;
        pattern5 = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x00f4:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "pattern6";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x0102;
    L_0x00ff:
        r9 = 0;
        pattern6 = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x0102:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "dependencies";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x0110;
    L_0x010d:
        r9 = 0;
        dependencies = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x0110:
        r9 = 1;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "fulloffline";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 != 0) goto L_0x011e;
    L_0x011b:
        r9 = 0;
        full_offline = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x011e:
        r9 = 6;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 == 0) goto L_0x0131;
    L_0x0123:
        r9 = 6;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "createAPK";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 == 0) goto L_0x0131;
    L_0x012e:
        r9 = 1;
        createAPK = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x0131:
        r9 = 6;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 == 0) goto L_0x0144;
    L_0x0136:
        r9 = 6;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "ART";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 == 0) goto L_0x0144;
    L_0x0141:
        r9 = 1;
        ART = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x0144:
        r9 = 6;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 == 0) goto L_0x014f;
    L_0x0149:
        r9 = 6;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x014f:
        r9 = 7;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 == 0) goto L_0x0172;
    L_0x0154:
        r9 = new java.lang.StringBuilder;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r9.<init>();	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = "1 ";
        r9 = r9.append(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r11 = 7;
        r11 = r63[r11];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r9 = r9.append(r11);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r9 = r9.toString();	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        r9 = 7;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        AdsBlockFile = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x0172:
        r9 = 8;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        if (r9 == 0) goto L_0x0a5a;
    L_0x0178:
        r9 = 8;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        uid = r9;	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
    L_0x017e:
        r9 = 5;
        r9 = r63[r9];	 Catch:{ NullPointerException -> 0x129d, Exception -> 0x129a }
        r11 = "copyDC";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x129d, Exception -> 0x129a }
        if (r9 == 0) goto L_0x018c;
    L_0x0189:
        r9 = 1;
        copyDC = r9;	 Catch:{ NullPointerException -> 0x129d, Exception -> 0x129a }
    L_0x018c:
        r9 = createAPK;
        if (r9 == 0) goto L_0x0197;
    L_0x0190:
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r9;
    L_0x0197:
        r54 = new java.util.ArrayList;
        r54.<init>();
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
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "(offline intekekt 0)";
        r6.add(r9);
        r9 = "search_offline";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1B ?? FF FF FF FF";
        r3.add(r9);
        r9 = "1B ?? ?? ?? ?? ??";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "(offline intekekt 0)";
        r6.add(r9);
        r9 = "search_offline";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E 10 FF FF ?? 00 0C ??";
        r3.add(r9);
        r9 = "6E 10 ?? ?? ?? 00 12 S0";
        r4.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline (sha intekekt 4)";
        r6.add(r9);
        r9 = "search_offline";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E 10 FF FF ?? 00 0C ??";
        r3.add(r9);
        r9 = "6E 10 ?? ?? ?? 00 12 S0";
        r4.add(r9);
        r9 = full_offline;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\nfull_offline (sha intekekt 4)";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 F1 12 E2 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "12 31 12 32 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? d8 02 13 ?? 5a 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 03 00 13 ?? 03 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? d4 01 13 ?? 3c 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 03 00 13 ?? 03 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 2c 01 13 ?? fa 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 03 00 13 ?? 03 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 40 01 13 ?? 32 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 03 00 13 ?? 03 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 40 01 ?? ?? ?? ?? 13 ?? 32 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 03 00 ?? ?? ?? ?? 13 ?? 03 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? A0 00 13 ?? 58 02 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 03 00 13 ?? 03 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 00 11 00 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 38 ?? 0D 00 12 E1 12 E2 6E ?? ?? ?? ?? ?? 12 E1 12 E2 6E ?? ?? ?? ?? ?? 0E 00 12 E0 12 E1 6E 40";
        r3.add(r9);
        r9 = "13 00 11 00 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 38 ?? 0D 00 12 11 12 12 6E ?? ?? ?? ?? ?? 12 11 12 12 6E ?? ?? ?? ?? ?? 0E 00 12 10 12 11 6E 40";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 00 11 00 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 38 ?? 0D 00 12 E0 12 E1 6E ?? ?? ?? ?? ?? 12 E0 12 E1 6E ?? ?? ?? ?? ?? 0E 00 12 E0 12 E1 6E 40";
        r3.add(r9);
        r9 = "13 00 11 00 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 38 ?? 0D 00 12 10 12 11 6E ?? ?? ?? ?? ?? 12 10 12 11 6E ?? ?? ?? ?? ?? 0E 00 12 10 12 11 6E 40";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E ?? ?? ?? ?? ?? 39 ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0A ?? 6E ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0A ?? D8 ?? ?? FE D8 ?? ?? FE 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0E 00";
        r3.add(r9);
        r9 = "6E ?? ?? ?? ?? ?? 39 ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0A ?? 6E ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0A ?? 12 ?? 00 00 12 ?? 00 00 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0E 00";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 04 39 06 0A 00 22 00 ?? ?? 1A 01 ?? ?? 70 20 ?? ?? ?? ?? 27 00 71 10 ?? ?? ?? ?? 70 20 ?? ?? ?? ?? 71 10 ?? ?? ?? ?? 5B ?? ?? ?? 59 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 5B";
        r3.add(r9);
        r9 = "0E 00 39 06 0A 00 22 00 ?? ?? 1A 01 ?? ?? 70 20 ?? ?? ?? ?? 27 00 71 10 ?? ?? ?? ?? 70 20 ?? ?? ?? ?? 71 10 ?? ?? ?? ?? 5B ?? ?? ?? 59 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 5B";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\nIMAdView";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 F1 12 E2 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "12 01 12 02 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads1 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? d4 01 13 ?? 3c 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 00 00 13 ?? 00 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 2c 01 13 ?? fa 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 00 00 13 ?? 00 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 40 01 13 ?? 32 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 00 00 13 ?? 00 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 40 01 ?? ?? ?? ?? 13 ?? 32 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 00 00 ?? ?? ?? ?? 13 ?? 00 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? d8 02 13 ?? 5a 00 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 00 00 13 ?? 00 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? A0 00 13 ?? 58 02 1A ?? ?? ?? 70 ??";
        r3.add(r9);
        r9 = "13 ?? 00 00 13 ?? 00 00 1A ?? ?? ?? 70 ??";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 00 11 00 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 38 ?? 0D 00 12 E1 12 E2 6E ?? ?? ?? ?? ?? 12 E1 12 E2 6E ?? ?? ?? ?? ?? 0E 00 12 E0 12 E1 6E 40";
        r3.add(r9);
        r9 = "13 00 11 00 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 38 ?? 0D 00 12 11 12 12 6E ?? ?? ?? ?? ?? 12 11 12 12 6E ?? ?? ?? ?? ?? 0E 00 12 10 12 11 6E 40";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 00 11 00 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 38 ?? 0D 00 12 E0 12 E1 6E ?? ?? ?? ?? ?? 12 E0 12 E1 6E ?? ?? ?? ?? ?? 0E 00 12 E0 12 E1 6E 40";
        r3.add(r9);
        r9 = "13 00 11 00 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 38 ?? 0D 00 12 10 12 11 6E ?? ?? ?? ?? ?? 12 10 12 11 6E ?? ?? ?? ?? ?? 0E 00 12 10 12 11 6E 40";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E ?? ?? ?? ?? ?? 39 ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0A ?? 6E ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0A ?? D8 ?? ?? FE D8 ?? ?? FE 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0E 00";
        r3.add(r9);
        r9 = "6E ?? ?? ?? ?? ?? 39 ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0A ?? 6E ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0A ?? 12 ?? 00 00 12 ?? 00 00 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0E 00";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 04 39 06 0A 00 22 00 ?? ?? 1A 01 ?? ?? 70 20 ?? ?? ?? ?? 27 00 71 10 ?? ?? ?? ?? 70 20 ?? ?? ?? ?? 71 10 ?? ?? ?? ?? 5B ?? ?? ?? 59 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 5B";
        r3.add(r9);
        r9 = "0E 00 39 06 0A 00 22 00 ?? ?? 1A 01 ?? ?? 70 20 ?? ?? ?? ?? 27 00 71 10 ?? ?? ?? ?? 70 20 ?? ?? ?? ?? 71 10 ?? ?? ?? ?? 5B ?? ?? ?? 59 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 5B";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads2 Fixed!\nIMAdView";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "55 ?? ?? ?? 39 00 ?? ?? 22 ?? ?? ?? 54 ?? ?? ?? 70 ?? ?? ?? ?? ?? 54 ?? ?? ?? 72 ?? ?? ?? ?? ?? 0C 01 54";
        r3.add(r9);
        r9 = "55 ?? ?? ?? 32 00 ?? ?? 22 ?? ?? ?? 54 ?? ?? ?? 70 ?? ?? ?? ?? ?? 54 ?? ?? ?? 72 ?? ?? ?? ?? ?? 0C 01 54";
        r4.add(r9);
        r9 = pattern3;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads3 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1D ?? 54 ?? ?? ?? 39 ?? ?? ?? 5B ?? ?? ?? 12 00 5C ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 54 ?? ?? ?? 6E 10";
        r3.add(r9);
        r9 = "1D ?? 54 ?? ?? ?? 39 ?? ?? ?? 5B ?? ?? ?? 12 10 5C ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 54 ?? ?? ?? 6E 10";
        r4.add(r9);
        r9 = pattern3;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads3 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1D ?? 70 ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 1A ?? ?? ?? 71 ?? ?? ?? ?? ?? 1E ?? 0E 00 71";
        r3.add(r9);
        r9 = "1D ?? 70 ?? ?? ?? ?? ?? 0A ?? 33 00 ?? ?? 1A ?? ?? ?? 71 ?? ?? ?? ?? ?? 1E ?? 0E 00 71";
        r4.add(r9);
        r9 = pattern3;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads3 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1D 01 54 10 ?? ?? 38 00 ?? ?? 12 10 1E 01 0F 00 12 00 28 ?? ?? ?? 1E 01 27 00";
        r3.add(r9);
        r9 = "1D 01 54 10 ?? ?? 33 00 ?? ?? 12 10 1E 01 0F 00 12 00 28 ?? ?? ?? 1E 01 27 00";
        r4.add(r9);
        r9 = pattern3;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads3 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "71 10 ?? ?? ?? ?? 15 03 FF FF 07 60 07 71 07 82 07 94 07 A5 76 06";
        r3.add(r9);
        r9 = "71 10 ?? ?? ?? ?? 15 03 00 FF 07 60 07 71 07 82 07 94 07 A5 76 06";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads4 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "71 10 ?? ?? ?? ?? 15 03 FF FF 07 60 07 71 07 82 07 94 07 A5 74 06";
        r3.add(r9);
        r9 = "71 10 ?? ?? ?? ?? 15 03 00 FF 07 60 07 71 07 82 07 94 07 A5 74 06";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads4 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 33 ?? ?? ?? 1A ?? ?? ?? 71";
        r3.add(r9);
        r9 = "12 ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 33 00 ?? ?? 1A ?? ?? ?? 71";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads4 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A 00 ?? ?? 6E 20 ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E 10 ?? ?? ?? ?? 0C 00 39 00 04 00 12 00 11 00";
        r3.add(r9);
        r9 = "1A 00 ?? ?? 6E 20 ?? ?? ?? ?? 0C 01 1F ?? ?? ?? 6E 10 ?? ?? ?? ?? 0C 00 33 00 ?? ?? 12 00 11 00";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? 00 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 33 ?? ?? 00 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A";
        r3.add(r9);
        r9 = "6E ?? ?? ?? ?? ?? 0C ?? 32 00 ?? 00 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 33 ?? ?? 00 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 39 ?? ?? ?? 0F ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 33 ?? ?? ?? 01 ?? 28 ?? 01 ?? 28";
        r3.add(r9);
        r9 = "12 ?? 12 ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 33 00 ?? ?? 0F ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 33 ?? ?? ?? 01 ?? 28 ?? 01 ?? 28";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 39 ?? ?? ?? 01 ?? 0F ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 33 ?? ?? ?? 01 ?? 28 ?? 01 ?? 28";
        r3.add(r9);
        r9 = "12 ?? 12 ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 33 00 ?? ?? 01 ?? 0F ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 33 ?? ?? ?? 01 ?? 28 ?? 01 ?? 28";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 15 6E 10 ?? ?? ?? ?? 0C 01 1A ?? ?? ?? 6E 20 ?? ?? ?? ?? 0A 04 12 ?? 33 ?? ?? ?? 0F 05 6E 10";
        r3.add(r9);
        r9 = "12 05 6E 10 ?? ?? ?? ?? 0C 01 1A ?? ?? ?? 6E 20 ?? ?? ?? ?? 0A 04 12 ?? 33 ?? ?? ?? 0F 05 6E 10";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "54 ?? ?? ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 1A ?? ?? ?? 54 ?? ?? ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 38";
        r3.add(r9);
        r9 = "54 ?? ?? ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 1A ?? ?? ?? 54 ?? ?? ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 00 ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 38";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 01 39 04 04 00 01 10 0F 00 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 39 ?? ?? ?? 01 10 28";
        r3.add(r9);
        r9 = "12 01 33 00 ?? ?? 01 10 0F 00 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 39 ?? ?? ?? 01 10 28";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 01 6E ?? ?? ?? ?? ?? 0C ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 38";
        r3.add(r9);
        r9 = "12 01 6E ?? ?? ?? ?? ?? 0C ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 32 00 ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 38";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E ?? ?? ?? ?? ?? 0C ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 12 ?? 0F ?? 12 00 28";
        r3.add(r9);
        r9 = "6E ?? ?? ?? ?? ?? 0C ?? 1A ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 1F ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 32 00 ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 00 ?? ?? 12 ?? 0F ?? 12 00 28";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads5 Fixed!\noffline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "54 ?? ?? ?? 39 ?? ?? ?? 1A ?? ?? ?? 1A ?? ?? ?? 71 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0E 00 1A";
        r3.add(r9);
        r9 = "54 ?? ?? ?? 33 00 ?? ?? 1A ?? ?? ?? 1A ?? ?? ?? 71 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0E 00 1A";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads6 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 00 62 ?? ?? ?? 38 ?? ?? 00 62 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 39 ?? ?? 00";
        r3.add(r9);
        r9 = "12 00 62 ?? ?? ?? 32 00 ?? 00 62 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 39 ?? ?? 00";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads6 Fixed!\nangry offline";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = 0;
        r9 = r63[r9];
        r11 = "com.buak.Link2SD";
        r9 = r9.contains(r11);
        if (r9 != 0) goto L_0x0845;
    L_0x0820:
        r9 = "00 05 2E 6F 64 65 78 00";
        r3.add(r9);
        r9 = "00 05 2E 6F 64 65 79 00";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads6 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
    L_0x0845:
        r9 = "00 04 6F 64 65 78 00";
        r3.add(r9);
        r9 = "00 04 6F 64 65 79 00";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads6 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 22 ?? ?? ?? 12 E3 12 E4 70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 54";
        r3.add(r9);
        r9 = "54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 22 ?? ?? ?? 12 03 12 04 70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 54 ?? ?? ?? 54";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads6 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 08 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 39 ?? 04 00 01 ?? 0F 05 1A ?? ?? ?? 12";
        r3.add(r9);
        r9 = "12 08 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 33 00 ?? ?? 01 ?? 0F 05 1A ?? ?? ?? 12";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "ads6 Fixed!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = ART;
        if (r9 != 0) goto L_0x0a64;
    L_0x08b8:
        r9 = "13 ?? 09 00 12 ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ??";
        r3.add(r9);
        r9 = "12 00 0F 00 12 ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ??";
        r4.add(r9);
        r9 = dependencies;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "com.android.vending dependencies removed\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 13 ?? 09 00 6E ?? ?? ?? ?? ?? 0C ??";
        r3.add(r9);
        r9 = "12 ?? 12 ?? 12 00 0F 00 6E ?? ?? ?? ?? ?? 0C ??";
        r4.add(r9);
        r9 = dependencies;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "com.android.vending dependencies removed\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
    L_0x0902:
        r20 = 0;
        r9 = java.lang.Boolean.valueOf(r20);
        com.chelpus.Utils.convertToPatchItemAuto(r2, r3, r4, r5, r6, r7, r8, r9);
        r9 = fileblock;
        if (r9 == 0) goto L_0x09b6;
    L_0x090f:
        r9 = AdsBlockFile;	 Catch:{ Exception -> 0x0951 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x0951 }
        r51 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0951 }
        r9 = AdsBlockFile;	 Catch:{ Exception -> 0x0951 }
        r0 = r51;
        r0.<init>(r9);	 Catch:{ Exception -> 0x0951 }
        r53 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0951 }
        r9 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0951 }
        r0 = r51;
        r9.<init>(r0);	 Catch:{ Exception -> 0x0951 }
        r0 = r53;
        r0.<init>(r9);	 Catch:{ Exception -> 0x0951 }
        r9 = fileblock;	 Catch:{ Exception -> 0x0951 }
        if (r9 == 0) goto L_0x0ab0;
    L_0x092f:
        r38 = r53.readLine();	 Catch:{ Exception -> 0x0951 }
        if (r38 == 0) goto L_0x0ab0;
    L_0x0935:
        r38 = r38.trim();	 Catch:{ Exception -> 0x0951 }
        r9 = "";
        r0 = r38;
        r9 = r0.equals(r9);	 Catch:{ Exception -> 0x0951 }
        if (r9 != 0) goto L_0x092f;
    L_0x0943:
        r9 = "UTF-8";
        r0 = r38;
        r9 = r0.getBytes(r9);	 Catch:{ Exception -> 0x0951 }
        r0 = r54;
        r0.add(r9);	 Catch:{ Exception -> 0x0951 }
        goto L_0x092f;
    L_0x0951:
        r27 = move-exception;
        r27.printStackTrace();
    L_0x0955:
        r51 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0996 }
        r9 = AdsBlockFile;	 Catch:{ Exception -> 0x0996 }
        r11 = "AdsBlockList.txt";
        r12 = "AdsBlockList_user_edit.txt";
        r9 = r9.replace(r11, r12);	 Catch:{ Exception -> 0x0996 }
        r0 = r51;
        r0.<init>(r9);	 Catch:{ Exception -> 0x0996 }
        r53 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0996 }
        r9 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0996 }
        r0 = r51;
        r9.<init>(r0);	 Catch:{ Exception -> 0x0996 }
        r0 = r53;
        r0.<init>(r9);	 Catch:{ Exception -> 0x0996 }
    L_0x0974:
        r38 = r53.readLine();	 Catch:{ Exception -> 0x0996 }
        if (r38 == 0) goto L_0x0ab5;
    L_0x097a:
        r38 = r38.trim();	 Catch:{ Exception -> 0x0996 }
        r9 = "";
        r0 = r38;
        r9 = r0.equals(r9);	 Catch:{ Exception -> 0x0996 }
        if (r9 != 0) goto L_0x0974;
    L_0x0988:
        r9 = "UTF-8";
        r0 = r38;
        r9 = r0.getBytes(r9);	 Catch:{ Exception -> 0x0996 }
        r0 = r54;
        r0.add(r9);	 Catch:{ Exception -> 0x0996 }
        goto L_0x0974;
    L_0x0996:
        r27 = move-exception;
        r27.printStackTrace();
    L_0x099a:
        r9 = r54.isEmpty();
        if (r9 != 0) goto L_0x09b6;
    L_0x09a0:
        r9 = r54.size();
        r9 = new byte[r9][];
        sites = r9;
        r9 = sites;
        r0 = r54;
        r9 = r0.toArray(r9);
        r9 = (byte[][]) r9;
        r9 = (byte[][]) r9;
        sites = r9;
    L_0x09b6:
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.booleanValue();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x09c6;
    L_0x09be:
        r9 = 2;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "RW";
        com.chelpus.Utils.remount(r9, r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x09c6:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 != 0) goto L_0x0bfc;
    L_0x09ca:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 != 0) goto L_0x0bfc;
    L_0x09ce:
        r9 = 3;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        dir = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 2;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        dirapp = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        clearTemp();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 4;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "not_system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x09e9;
    L_0x09e6:
        r9 = 0;
        system = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x09e9:
        r9 = 4;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x09f7;
    L_0x09f4:
        r9 = 1;
        system = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x09f7:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "CLASSES mode create odex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 0;
        r44 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 2;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 3;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "Get classes.dex.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "Get classes.dex.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        unzipART(r16);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0a35;
    L_0x0a2d:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 != 0) goto L_0x0aba;
    L_0x0a35:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0a3b:
        r39 = move-exception;
        r9 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        com.chelpus.Utils.sendFromRoot(r9);
    L_0x0a41:
        r9 = filestopatch;
        r9 = r9.iterator();
    L_0x0a47:
        r11 = r9.hasNext();
        if (r11 == 0) goto L_0x123d;
    L_0x0a4d:
        r33 = r9.next();
        r33 = (java.io.File) r33;
        com.chelpus.Utils.fixadler(r33);
        clearTempSD();
        goto L_0x0a47;
    L_0x0a5a:
        r9 = "fignya";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x0a61, Exception -> 0x12a0 }
        goto L_0x017e;
    L_0x0a61:
        r9 = move-exception;
        goto L_0x017e;
    L_0x0a64:
        r9 = "13 ?? 09 00 12 ?? 12 ?? 6E ?? ?? ?? ?? ?? 0C ??";
        r3.add(r9);
        r9 = "12 S0 00 00 12 S0 12 S0 6E ?? ?? ?? ?? ?? 0C ??";
        r4.add(r9);
        r9 = dependencies;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "com.android.vending dependencies removed\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 13 ?? 09 00 6E ?? ?? ?? ?? ?? 0C ??";
        r3.add(r9);
        r9 = "12 S0 12 S0 12 S0 00 00 6E ?? ?? ?? ?? ?? 0C ??";
        r4.add(r9);
        r9 = dependencies;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "com.android.vending dependencies removed\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        goto L_0x0902;
    L_0x0ab0:
        r51.close();	 Catch:{ Exception -> 0x0951 }
        goto L_0x0955;
    L_0x0ab5:
        r51.close();	 Catch:{ Exception -> 0x0996 }
        goto L_0x099a;
    L_0x0aba:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0ac5:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r11 == 0) goto L_0x0b02;
    L_0x0acb:
        r18 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r18 = (java.io.File) r18;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = r18.exists();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r11 != 0) goto L_0x0afa;
    L_0x0ad7:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0add:
        r27 = move-exception;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r11 = "Patch Process Exception: ";
        r9 = r9.append(r11);
        r11 = r27.toString();
        r9 = r9.append(r11);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        goto L_0x0a41;
    L_0x0afa:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r18;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0ac5;
    L_0x0b02:
        r9 = 2;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = 1;
        r41 = com.chelpus.Utils.getPlaceForOdex(r9, r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r40 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r40.<init>(r41);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r40.exists();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0b18;
    L_0x0b15:
        r40.delete();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0b18:
        r40 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "-1";
        r11 = "-2";
        r0 = r41;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r40;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r40.exists();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0b32;
    L_0x0b2f:
        r40.delete();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0b32:
        r40 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "-2";
        r11 = "-1";
        r0 = r41;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r40;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r40.exists();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0b4c;
    L_0x0b49:
        r40.delete();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0b4c:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r61 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0b52:
        r9 = r61.hasNext();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0a41;
    L_0x0b58:
        r33 = r61.next();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r33 = (java.io.File) r33;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "Find string id.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r57 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r57.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "phone";
        r0 = r57;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "Landroid/net/ConnectivityManager;";
        r0 = r57;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "getActiveNetworkInfo";
        r0 = r57;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "String analysis.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "String analysis.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r33.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = 0;
        r0 = r57;
        r43 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r28 = 0;
        r29 = 0;
        r30 = 0;
        r42 = 1;
        r19 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r19.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "Landroid/net/ConnectivityManager;";
        r12 = "getActiveNetworkInfo";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r19;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = r43.iterator();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0bb3:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0d87;
    L_0x0bb9:
        r36 = r11.next();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r36 = (com.android.vending.billing.InAppBillingService.LOCK.StringItem) r36;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r19.iterator();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0bc3:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r12 == 0) goto L_0x0cea;
    L_0x0bc9:
        r37 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r37 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r37;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r37;
        r12 = r0.object;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r36;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r12 == 0) goto L_0x0be5;
    L_0x0bdd:
        r0 = r36;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r37;
        r0.Object = r12;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0be5:
        r0 = r37;
        r12 = r0.method;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r36;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r12 == 0) goto L_0x0bc3;
    L_0x0bf3:
        r0 = r36;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r37;
        r0.Method = r12;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0bc3;
    L_0x0bfc:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0c88;
    L_0x0c00:
        r9 = 0;
        r44 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 2;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 5;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        unzipSD(r16);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = sddir;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = "/Modified/";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r44;
        r11 = r11.append(r0);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = ".apk";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = r11.toString();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        crkapk = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = crkapk;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r16;
        com.chelpus.Utils.copyFile(r0, r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0c57;
    L_0x0c4f:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 != 0) goto L_0x0c5d;
    L_0x0c57:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0c5d:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0c68:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r11 == 0) goto L_0x0c88;
    L_0x0c6e:
        r18 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r18 = (java.io.File) r18;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = r18.exists();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r11 != 0) goto L_0x0c80;
    L_0x0c7a:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0c80:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r18;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0c68;
    L_0x0c88:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0b4c;
    L_0x0c8c:
        r9 = "ART mode create dex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 0;
        r44 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 2;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 3;
        r9 = r63[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        unzipART(r16);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0cb9;
    L_0x0cb1:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 != 0) goto L_0x0cbf;
    L_0x0cb9:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0cbf:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0cca:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r11 == 0) goto L_0x0b4c;
    L_0x0cd0:
        r18 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r18 = (java.io.File) r18;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = r18.exists();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r11 != 0) goto L_0x0ce2;
    L_0x0cdc:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0ce2:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r18;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0cca;
    L_0x0cea:
        r0 = r36;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = "phone";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0bb3;
    L_0x0cf6:
        r0 = r36;
        r9 = r0.bits32;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 != 0) goto L_0x0d30;
    L_0x0cfc:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 2;
        r0 = r36;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 3;
        r0 = r36;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 0;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0d2c:
        r28 = 1;
        goto L_0x0bb3;
    L_0x0d30:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 0;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 2;
        r0 = r36;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 3;
        r0 = r36;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 4;
        r0 = r36;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 5;
        r0 = r36;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0d2c;
    L_0x0d87:
        if (r28 != 0) goto L_0x0d8d;
    L_0x0d89:
        r9 = full_offline;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0e7e;
    L_0x0d8d:
        r9 = "Parse data for patch.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "Parse data for patch.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r33.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = 0;
        r12 = 0;
        r0 = r19;
        com.chelpus.Utils.getMethodsIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 0;
        r0 = r19;
        r9 = r0.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.index_command;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 0;
        r9 = r9[r12];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = java.lang.Integer.toHexString(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11.println(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 0;
        r0 = r19;
        r9 = r0.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.index_command;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 1;
        r9 = r9[r12];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = java.lang.Integer.toHexString(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11.println(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = r19.iterator();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0dd6:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0e5e;
    L_0x0ddc:
        r37 = r11.next();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r37 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r37;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r37;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = "Landroid/net/ConnectivityManager;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0dd6;
    L_0x0dee:
        r0 = r37;
        r9 = r0.found_index_command;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0e48;
    L_0x0df4:
        r9 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = "save to command";
        r9.println(r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 2;
        r0 = r37;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 3;
        r0 = r37;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 2;
        r0 = r37;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 3;
        r0 = r37;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0dd6;
    L_0x0e48:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 0;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 0;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0dd6;
    L_0x0e5e:
        if (r28 != 0) goto L_0x0e7e;
    L_0x0e60:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0e7e:
        r9 = r2.size();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto[r9];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r45 = r0;
        r60 = 0;
        r9 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0e8c:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r11 == 0) goto L_0x0e9d;
    L_0x0e92:
        r37 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r37 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r37;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r45[r60] = r37;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r60 = r60 + 1;
        goto L_0x0e8c;
    L_0x0e9d:
        r21 = 0;
        r9 = fileblock;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        if (r9 == 0) goto L_0x0ebc;
    L_0x0ea3:
        r9 = "String analysis.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "String analysis.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r33.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = sites;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 0;
        r13 = 64;
        r21 = com.chelpus.Utils.setStringIds(r9, r11, r12, r13);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x0ebc:
        if (r21 <= 0) goto L_0x0ecd;
    L_0x0ebe:
        r21 = r21 + -1;
        r9 = "Site from AdsBlockList blocked!";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "Site from AdsBlockList blocked!";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0ebc;
    L_0x0ecd:
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "Relaced strings:";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = r33.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 1;
        r12 = new java.lang.String[r12];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r13 = 0;
        r14 = "com.google.android.gms.ads.identifier.service.START";
        r12[r13] = r14;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r13 = 0;
        r14 = 1;
        r14 = new java.lang.String[r14];	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r15 = 0;
        r62 = "com.google.android.gms.ads.identifier.service.STAPT";
        r14[r15] = r62;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = com.chelpus.Utils.replaceStringIds(r11, r12, r13, r14);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r58 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "rw";
        r0 = r33;
        r9.<init>(r0, r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r10 = r9.getChannel();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "Size file:";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = r10.size();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = 0;
        r14 = r10.size();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = (int) r14;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r14 = (long) r9;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r32 = r10.map(r11, r12, r14);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r23 = 0;
        r35 = 0;
        r25 = 574; // 0x23e float:8.04E-43 double:2.836E-321;
        r26 = 40;
        r55 = 0;
        r56 = 0;
        r49 = 0;
        r47 = 0;
    L_0x0f45:
        r9 = r32.hasRemaining();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 == 0) goto L_0x10ab;
    L_0x0f4b:
        r9 = createAPK;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 != 0) goto L_0x0f78;
    L_0x0f4f:
        r9 = r32.position();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9 - r47;
        r11 = 149999; // 0x249ef float:2.10193E-40 double:7.41094E-319;
        if (r9 <= r11) goto L_0x0f78;
    L_0x0f5a:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9.<init>();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = "Progress size:";
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = r32.position();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9.toString();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r47 = r32.position();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x0f78:
        r23 = r32.position();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r22 = r32.get();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r49 = 0;
        r17 = 0;
    L_0x0f84:
        r0 = r45;
        r9 = r0.length;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r17;
        if (r0 >= r9) goto L_0x1232;
    L_0x0f8b:
        r46 = r45[r17];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r32;
        r1 = r23;
        r0.position(r1);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 == 0) goto L_0x10e4;
    L_0x0f9a:
        r9 = 2;
        r0 = r17;
        if (r0 != r9) goto L_0x10e4;
    L_0x0f9f:
        r55 = r55 + 1;
        r0 = r55;
        r1 = r25;
        if (r0 >= r1) goto L_0x11ed;
    L_0x0fa7:
        r0 = r46;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r22;
        if (r0 != r9) goto L_0x10dd;
    L_0x0fb2:
        r0 = r46;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 != 0) goto L_0x0fc2;
    L_0x0fbb:
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 0;
        r9[r11] = r22;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x0fc2:
        r35 = 1;
        r9 = r23 + 1;
        r0 = r32;
        r0.position(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r50 = r32.get();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x0fcf:
        r0 = r46;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r50;
        if (r0 == r9) goto L_0x1000;
    L_0x0fd9:
        r0 = r46;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 1;
        if (r9 == r11) goto L_0x1000;
    L_0x0fe2:
        r0 = r46;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 20;
        if (r9 == r11) goto L_0x1000;
    L_0x0fec:
        r0 = r46;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 21;
        if (r9 == r11) goto L_0x1000;
    L_0x0ff6:
        r0 = r46;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 23;
        if (r9 != r11) goto L_0x10dd;
    L_0x1000:
        r0 = r46;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 != 0) goto L_0x100e;
    L_0x1008:
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9[r35] = r50;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x100e:
        r0 = r46;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 20;
        if (r9 != r11) goto L_0x1021;
    L_0x1018:
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = r50 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9[r35] = r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x1021:
        r0 = r46;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 21;
        if (r9 != r11) goto L_0x1036;
    L_0x102b:
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = r50 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9[r35] = r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x1036:
        r35 = r35 + 1;
        r0 = r46;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9.length;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r35;
        if (r0 != r9) goto L_0x11e7;
    L_0x1041:
        r0 = r32;
        r1 = r23;
        r0.position(r1);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r32;
        r0.put(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r32.force();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = print;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9.println(r11);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = 1;
        r0 = r46;
        r0.result = r9;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = 0;
        r0 = r46;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x1072:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r11 == 0) goto L_0x10d4;
    L_0x1078:
        r24 = r9.next();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r24 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r24;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r24;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r11 == 0) goto L_0x1072;
    L_0x108c:
        r11 = 0;
        r0 = r24;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        goto L_0x1072;
    L_0x1092:
        r27 = move-exception;
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r0 = r27;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
    L_0x10ab:
        r10.close();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r11 = "";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r12 = r12 - r58;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        r9 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a3b, Exception -> 0x0add }
        goto L_0x0b52;
    L_0x10d4:
        r55 = 0;
        r9 = r23 + 1;
        r0 = r32;
        r0.position(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x10dd:
        r9 = r23 + 1;
        r0 = r32;
        r0.position(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x10e4:
        r0 = r46;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 != 0) goto L_0x122e;
    L_0x10ea:
        r0 = r46;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r22;
        if (r0 != r9) goto L_0x122e;
    L_0x10f5:
        r0 = r46;
        r9 = r0.pattern;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 == 0) goto L_0x122e;
    L_0x10fb:
        r0 = r46;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 != 0) goto L_0x110b;
    L_0x1104:
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 0;
        r9[r11] = r22;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x110b:
        r35 = 1;
        r9 = r23 + 1;
        r0 = r32;
        r0.position(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r50 = r32.get();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x1118:
        r0 = r46;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r50;
        if (r0 == r9) goto L_0x1149;
    L_0x1122:
        r0 = r46;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 1;
        if (r9 == r11) goto L_0x1149;
    L_0x112b:
        r0 = r46;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 20;
        if (r9 == r11) goto L_0x1149;
    L_0x1135:
        r0 = r46;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 21;
        if (r9 == r11) goto L_0x1149;
    L_0x113f:
        r0 = r46;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 23;
        if (r9 != r11) goto L_0x1227;
    L_0x1149:
        r0 = r46;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 != 0) goto L_0x1157;
    L_0x1151:
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9[r35] = r50;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x1157:
        r0 = r46;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 20;
        if (r9 != r11) goto L_0x116a;
    L_0x1161:
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = r50 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9[r35] = r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x116a:
        r0 = r46;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9[r35];	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = 21;
        if (r9 != r11) goto L_0x117f;
    L_0x1174:
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = r50 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9[r35] = r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x117f:
        r35 = r35 + 1;
        r0 = r46;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r9.length;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r35;
        if (r0 != r9) goto L_0x1221;
    L_0x118a:
        r0 = r32;
        r1 = r23;
        r0.position(r1);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r32;
        r0.put(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r32.force();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = print;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9.println(r11);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = 1;
        r0 = r46;
        r0.result = r9;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r9 = r0.marker;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = "";
        r9 = r9.equals(r11);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r9 != 0) goto L_0x1227;
    L_0x11be:
        r9 = 1;
        r0 = r46;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x11c7:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r11 == 0) goto L_0x1227;
    L_0x11cd:
        r24 = r9.next();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r24 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r24;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r24;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r11 == 0) goto L_0x11c7;
    L_0x11e1:
        r11 = 1;
        r0 = r24;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        goto L_0x11c7;
    L_0x11e7:
        r50 = r32.get();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        goto L_0x0fcf;
    L_0x11ed:
        r9 = 0;
        r0 = r46;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x11f6:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r11 == 0) goto L_0x1216;
    L_0x11fc:
        r24 = r9.next();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r24 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r24;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r24;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r0 = r46;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        if (r11 == 0) goto L_0x11f6;
    L_0x1210:
        r11 = 0;
        r0 = r24;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        goto L_0x11f6;
    L_0x1216:
        r55 = 0;
        r9 = r23 + 1;
        r0 = r32;
        r0.position(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        goto L_0x10e4;
    L_0x1221:
        r50 = r32.get();	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        goto L_0x1118;
    L_0x1227:
        r9 = r23 + 1;
        r0 = r32;
        r0.position(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
    L_0x122e:
        r17 = r17 + 1;
        goto L_0x0f84;
    L_0x1232:
        if (r49 != 0) goto L_0x0f45;
    L_0x1234:
        r9 = r23 + 1;
        r0 = r32;
        r0.position(r9);	 Catch:{ Exception -> 0x1092, FileNotFoundException -> 0x0a3b }
        goto L_0x0f45;
    L_0x123d:
        r9 = createAPK;
        if (r9 != 0) goto L_0x128c;
    L_0x1241:
        r9 = 3;
        r9 = r63[r9];
        r11 = classesFiles;
        r12 = 2;
        r12 = r63[r12];
        r13 = uid;
        r14 = 2;
        r14 = r63[r14];
        r15 = uid;
        r14 = com.chelpus.Utils.getOdexForCreate(r14, r15);
        r52 = com.chelpus.Utils.create_ODEX_root(r9, r11, r12, r13, r14);
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r11 = "chelpus_return_";
        r9 = r9.append(r11);
        r0 = r52;
        r9 = r9.append(r0);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        if (r52 != 0) goto L_0x128c;
    L_0x1272:
        r9 = ART;
        if (r9 != 0) goto L_0x128c;
    L_0x1276:
        r9 = 1;
        r9 = r63[r9];
        r11 = 2;
        r11 = r63[r11];
        r12 = 2;
        r12 = r63[r12];
        r13 = 1;
        r12 = com.chelpus.Utils.getPlaceForOdex(r12, r13);
        r13 = uid;
        r14 = 3;
        r14 = r63[r14];
        com.chelpus.Utils.afterPatch(r9, r11, r12, r13, r14);
    L_0x128c:
        r9 = createAPK;
        if (r9 != 0) goto L_0x1293;
    L_0x1290:
        com.chelpus.Utils.exitFromRootJava();
    L_0x1293:
        r0 = r48;
        r9 = r0.allresult;
        result = r9;
        return;
    L_0x129a:
        r9 = move-exception;
        goto L_0x018c;
    L_0x129d:
        r9 = move-exception;
        goto L_0x018c;
    L_0x12a0:
        r9 = move-exception;
        goto L_0x017e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.runpatchads.main(java.lang.String[]):void");
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
            while (true) {
                ZipEntry ze = zin.getNextEntry();
                if (ze == null) {
                    zin.close();
                    fin.close();
                    return;
                } else if (ze.getName().toLowerCase().startsWith("classes") && ze.getName().endsWith(".dex") && !ze.getName().contains(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    FileOutputStream fout = new FileOutputStream(sddir + "/Modified/" + ze.getName());
                    byte[] buffer = new byte[Util.BLOCK_HEADER_SIZE_MAX];
                    while (true) {
                        int length = zin.read(buffer);
                        if (length == -1) {
                            break;
                        }
                        fout.write(buffer, 0, length);
                    }
                    zin.closeEntry();
                    fout.close();
                    classesFiles.add(new File(sddir + "/Modified/" + ze.getName()));
                }
            }
        } catch (Exception e) {
            try {
                new ZipFile(apk).extractFile("classes.dex", sddir + "/Modified/");
                classesFiles.add(new File(sddir + "/Modified/" + "classes.dex"));
            } catch (ZipException e1) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e1);
                Utils.sendFromRoot("Exception e1" + e.toString());
            } catch (Exception e12) {
                Utils.sendFromRoot("Error classes.dex decompress! " + e12);
                Utils.sendFromRoot("Exception e1" + e.toString());
            }
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
