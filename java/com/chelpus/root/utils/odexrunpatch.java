package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.tukaani.xz.common.Util;

public class odexrunpatch {
    public static boolean ART = false;
    private static boolean amazon = true;
    public static String appdir = "/sdcard/";
    public static ArrayList<File> classesFiles = new ArrayList();
    public static boolean copyDC = false;
    private static boolean createAPK = false;
    public static File crkapk;
    private static boolean dependencies = true;
    public static String dir = "/sdcard/";
    public static String dirapp = "/data/app/";
    public static ArrayList<File> filestopatch = null;
    private static boolean pattern1 = true;
    private static boolean pattern2 = true;
    private static boolean pattern3 = true;
    private static boolean pattern4 = true;
    private static boolean pattern5 = true;
    private static boolean pattern6 = true;
    public static PrintStream print;
    public static String result;
    private static boolean samsung = true;
    public static String sddir = "/sdcard/";
    public static boolean system = false;
    public static String uid = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r81) {
        /*
        r9 = classesFiles;
        r9.clear();
        r66 = new com.android.vending.billing.InAppBillingService.LOCK.LogOutputStream;
        r9 = "System.out";
        r0 = r66;
        r0.<init>(r9);
        r9 = new java.io.PrintStream;
        r0 = r66;
        r9.<init>(r0);
        print = r9;
        r9 = new com.chelpus.root.utils.odexrunpatch$1;
        r9.<init>();
        com.chelpus.Utils.startRootJava(r9);
        r9 = 0;
        r9 = r81[r9];
        com.chelpus.Utils.kill(r9);
        r2 = new java.util.ArrayList;
        r2.<init>();
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
        amazon = r9;
        r9 = 1;
        samsung = r9;
        r9 = new java.util.ArrayList;
        r9.<init>();
        filestopatch = r9;
        r9 = new java.io.File;	 Catch:{ Exception -> 0x0090 }
        r11 = 3;
        r11 = r81[r11];	 Catch:{ Exception -> 0x0090 }
        r9.<init>(r11);	 Catch:{ Exception -> 0x0090 }
        r43 = r9.listFiles();	 Catch:{ Exception -> 0x0090 }
        r0 = r43;
        r11 = r0.length;	 Catch:{ Exception -> 0x0090 }
        r9 = 0;
    L_0x005c:
        if (r9 >= r11) goto L_0x0094;
    L_0x005e:
        r39 = r43[r9];	 Catch:{ Exception -> 0x0090 }
        r12 = r39.isFile();	 Catch:{ Exception -> 0x0090 }
        if (r12 == 0) goto L_0x008d;
    L_0x0066:
        r12 = r39.getName();	 Catch:{ Exception -> 0x0090 }
        r13 = "busybox";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0090 }
        if (r12 != 0) goto L_0x008d;
    L_0x0072:
        r12 = r39.getName();	 Catch:{ Exception -> 0x0090 }
        r13 = "reboot";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0090 }
        if (r12 != 0) goto L_0x008d;
    L_0x007e:
        r12 = r39.getName();	 Catch:{ Exception -> 0x0090 }
        r13 = "dalvikvm";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0090 }
        if (r12 != 0) goto L_0x008d;
    L_0x008a:
        r39.delete();	 Catch:{ Exception -> 0x0090 }
    L_0x008d:
        r9 = r9 + 1;
        goto L_0x005c;
    L_0x0090:
        r35 = move-exception;
        r35.printStackTrace();
    L_0x0094:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "pattern1";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x00a2;
    L_0x009f:
        r9 = 0;
        pattern1 = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x00a2:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "pattern2";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x00b0;
    L_0x00ad:
        r9 = 0;
        pattern2 = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x00b0:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "pattern3";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x00be;
    L_0x00bb:
        r9 = 0;
        pattern3 = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x00be:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "pattern4";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x00cc;
    L_0x00c9:
        r9 = 0;
        pattern4 = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x00cc:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "pattern5";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x00da;
    L_0x00d7:
        r9 = 0;
        pattern5 = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x00da:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "pattern6";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x00e8;
    L_0x00e5:
        r9 = 0;
        pattern6 = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x00e8:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "dependencies";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x00f6;
    L_0x00f3:
        r9 = 0;
        dependencies = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x00f6:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "amazon";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x0104;
    L_0x0101:
        r9 = 0;
        amazon = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x0104:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "samsung";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 != 0) goto L_0x0112;
    L_0x010f:
        r9 = 0;
        samsung = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x0112:
        r9 = 6;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "createAPK";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 == 0) goto L_0x0120;
    L_0x011d:
        r9 = 1;
        createAPK = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x0120:
        r9 = 6;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 == 0) goto L_0x0133;
    L_0x0125:
        r9 = 6;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        r11 = "ART";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 == 0) goto L_0x0133;
    L_0x0130:
        r9 = 1;
        ART = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x0133:
        r9 = 7;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        if (r9 == 0) goto L_0x013d;
    L_0x0138:
        r9 = 7;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        uid = r9;	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x013d:
        r9 = 6;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x159d, Exception -> 0x159a }
    L_0x0143:
        r9 = 5;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x1597, Exception -> 0x1594 }
        r11 = "copyDC";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1597, Exception -> 0x1594 }
        if (r9 == 0) goto L_0x0151;
    L_0x014e:
        r9 = 1;
        copyDC = r9;	 Catch:{ NullPointerException -> 0x1597, Exception -> 0x1594 }
    L_0x0151:
        r9 = createAPK;
        if (r9 == 0) goto L_0x015c;
    L_0x0155:
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r9;
    L_0x015c:
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
        r9 = 29;
        r0 = new byte[r9];
        r18 = r0;
        r18 = {5, 0, 0, 0, 1, 1, 0, 0, 2, 1, 0, 0, 3, 1, 0, 0, 15, 0, 0, 0, 26, 0, 0, 0, 15, 0, 0, 0, 89};
        r9 = 29;
        r0 = new byte[r9];
        r51 = r0;
        r51 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1};
        r9 = 29;
        r0 = new byte[r9];
        r21 = r0;
        r21 = {5, 0, 0, 0, 1, 1, 0, 0, 2, 1, 0, 0, 3, 1, 0, 0, 15, 0, 0, 0, 15, 0, 0, 0, 15, 0, 0, 0, 89};
        r9 = 29;
        r0 = new byte[r9];
        r69 = r0;
        r69 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0};
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
        r9 = "lvl patch N2!\n(sha intekekt 3)";
        r6.add(r9);
        r9 = "search";
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
        r9 = "70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 62 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 44 00 01 00 2B 00 ?? ?? ?? ?? 62 ?? ?? ?? 11";
        r3.add(r9);
        r9 = "70 ?? ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 38 ?? ?? ?? 62 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 12 10 00 00 2B 00 ?? ?? ?? ?? 62 ?? ?? ?? 11";
        r4.add(r9);
        r9 = pattern3;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N2!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 39 ?? ?? ?? 53 ?? ?? ?? 31";
        r3.add(r9);
        r9 = "12 S1 12 S1 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 39 ?? ?? ?? 53 ?? ?? ?? 31";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "0a ?? 38 ?? 0e 00 1a ?? ?? ?? 1A ?? ?? ?? 71 ?? ?? ?? ?? ?? 72";
        r3.add(r9);
        r9 = "0a ?? 33 00 ?? ?? 1a ?? ?? ?? 1A ?? ?? ?? 71 ?? ?? ?? ?? ?? 72";
        r4.add(r9);
        r9 = pattern2;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N4!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A ?? ?? ?? 70 ?? ?? ?? ?? ?? 27 ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? 12";
        r3.add(r9);
        r9 = "1A ?? ?? ?? 70 ?? ?? ?? ?? ?? 27 ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? 12";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N5!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? 12 ??";
        r3.add(r9);
        r9 = "22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? 12 ??";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N5!\nparse response code";
        r6.add(r9);
        r9 = "patch5";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? 31 ?? ?? ?? 3B ?? ?? ?? 01";
        r3.add(r9);
        r9 = "12 S1 12 S1 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? 31 ?? ?? ?? 3B ?? ?? ?? 01";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 01 ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 01 ?? 28";
        r3.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 01 ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 01 ?? 28";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 01 ?? 28";
        r3.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 01 ?? 28";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 28";
        r3.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12 ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 0C ?? ?? ?? ?? ?? ?? ?? 28";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A";
        r3.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 1A ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 21 ?? 12 ?? 35 ?? ?? ?? 22 ?? ?? ?? 1A ?? ?? ?? 70 ?? ?? ?? ?? ?? 27 ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A";
        r3.add(r9);
        r9 = "0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 21 ?? 12 ?? 35 ?? ?? ?? 22 ?? ?? ?? 1A ?? ?? ?? 70 ?? ?? ?? ?? ?? 27 ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 5B ?? ?? ?? 12 ?? 46 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N5!\n";
        r6.add(r9);
        r9 = "patch5";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = 32;
        r0 = new byte[r9];
        r19 = r0;
        r19 = {26, 102, 102, 102, 113, 102, 102, 102, 102, 102, 12, 102, 113, 102, 102, 102, 102, 102, 12, 102, 33, 102, 102, 102, 53, 102, 102, 102, 34, 102, 102, 102};
        r9 = 32;
        r0 = new byte[r9];
        r52 = r0;
        r52 = {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        r9 = 32;
        r0 = new byte[r9];
        r22 = r0;
        r22 = {26, 102, 102, 102, 113, 102, 102, 102, 102, 102, 12, 102, 113, 102, 102, 102, 102, 102, 12, 102, 33, 102, 102, 102, 53, 102, 102, 102, 34, 102, 102, 102};
        r9 = 32;
        r0 = new byte[r9];
        r70 = r0;
        r70 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r9 = 13;
        r0 = new byte[r9];
        r20 = r0;
        r20 = {0, 70, 102, 102, 102, 113, 102, 102, 102, 102, 102, 10, 102};
        r9 = 13;
        r0 = new byte[r9];
        r53 = r0;
        r53 = {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1};
        r9 = 13;
        r0 = new byte[r9];
        r23 = r0;
        r23 = {0, 70, 102, 102, 102, 113, 102, 102, 102, 102, 102, 18, 102};
        r9 = 13;
        r0 = new byte[r9];
        r71 = r0;
        r71 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 62 ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 62 ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A";
        r3.add(r9);
        r9 = "2C ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 0A ?? 0F ?? 62 ?? ?? ?? ?? ?? ?? ?? ?? ?? 28 ?? 62 ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? ?? 12";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? ?? ?? 33 ?? ?? ?? 53";
        r3.add(r9);
        r9 = "12 S1 12 S1 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? ?? ?? 33 ?? ?? ?? 53";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6C 61 63 6B 79 70 61 74 63 68";
        r3.add(r9);
        r9 = "6C 75 63 75 79 70 75 74 63 68";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6C 75 63 6B 79 70 61 74 63 68";
        r3.add(r9);
        r9 = "6C 75 63 75 79 70 75 74 75 68";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "64 69 6D 6F 6E 76 69 64 65 6F 2E";
        r3.add(r9);
        r9 = "64 69 6D 69 6E 69 69 64 65 6F 2E";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 33 ?? ?? ?? 53 ?? ?? ?? 31";
        r3.add(r9);
        r9 = "12 S1 12 S1 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 33 ?? ?? ?? 53 ?? ?? ?? 31";
        r4.add(r9);
        r9 = pattern5;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E 10 ?? ?? ?? ?? 0A ?? 6E 10 ?? ?? ?? ?? 0C ?? 6E 10 ?? ?? ?? ?? 0C ?? 6E 40";
        r3.add(r9);
        r9 = "6E 10 ?? ?? ?? ?? 12 ?? 6E 10 ?? ?? ?? ?? 0C ?? 6E 10 ?? ?? ?? ?? 0C ?? 6E 40";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "62 01 ?? ?? 6E 20 ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A 01 71 10 ?? ?? ?? ?? 0C 02 71 10 ?? ?? ?? ?? 6E 10 ?? ?? ?? ?? 0C 02 6E 10 ?? ?? ?? ?? 0C 03 6E 40 ?? ?? ?? ?? 28";
        r3.add(r9);
        r9 = "62 01 ?? ?? 6E 20 ?? ?? ?? ?? 6E ?? ?? ?? ?? ?? 12 01 71 10 ?? ?? ?? ?? 0C 02 71 10 ?? ?? ?? ?? 6E 10 ?? ?? ?? ?? 0C 02 6E 10 ?? ?? ?? ?? 0C 03 6E 40 ?? ?? ?? ?? 28";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 39 ?? ?? ?? 53 ?? ?? ?? 31";
        r3.add(r9);
        r9 = "12 S0 12 S0 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 39 ?? ?? ?? 53 ?? ?? ?? 31";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 33 ?? ?? ?? 53 ?? ?? ?? 31";
        r3.add(r9);
        r9 = "12 S0 12 S0 71 ?? ?? ?? ?? ?? 0B ?? 52 ?? ?? ?? 33 ?? ?? ?? 53 ?? ?? ?? 31";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? ?? ?? 33 ?? ?? ?? 53";
        r3.add(r9);
        r9 = "12 S0 12 S0 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? ?? ?? 33 ?? ?? ?? 53";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "12 ?? 12 ?? 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? 31 ?? ?? ?? 3B ?? ?? ?? 01";
        r3.add(r9);
        r9 = "12 S0 12 S0 71 ?? ?? ?? ?? ?? 0B ?? ?? ?? ?? ?? ?? ?? 31 ?? ?? ?? 3B ?? ?? ?? 01";
        r4.add(r9);
        r9 = pattern6;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 00 00 01 33 R0 ?? ?? 54 ?? ?? ?? 71 10 ?? ?? ?? ?? 0C 01";
        r3.add(r9);
        r9 = "13 W0 00 01 33 00 00 01 54 ?? ?? ?? 71 10 ?? ?? ?? ?? 0C 01";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "1A 05 ?? ?? 63 00 ?? ?? 38 00 09 00 62 00 ?? ?? 1A 01 ?? ?? 6E 20 ?? ?? ?? ?? 54 60 ?? ?? 1A 01 ?? ?? 6E 20 ?? ?? ?? ?? ?? ?? 38 00 0A 00 62 00";
        r3.add(r9);
        r9 = "1A 05 ?? ?? 63 00 ?? ?? 38 00 09 00 62 00 ?? ?? 1A 01 ?? ?? 6E 20 ?? ?? ?? ?? 54 60 ?? ?? 1A 01 ?? ?? 6E 20 ?? ?? ?? ?? ?? ?? 33 00 ?? ?? 62 00";
        r4.add(r9);
        r9 = amazon;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "amazon patch N1!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "6E 20 ?? ?? ?? ?? 0C 00 38 00 05 00 12 10 ?? ?? 0F 00 12 00 ?? ?? 0D 00 ?? ?? 27 00";
        r3.add(r9);
        r9 = "6E 20 ?? ?? ?? ?? 0C 00 33 00 ?? ?? 12 10 ?? ?? 0F 00 12 00 ?? ?? 0D 00 ?? ?? 27 00";
        r4.add(r9);
        r9 = amazon;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "amazon patch N1!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 09 00 6E ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 ?? ?? ?? 59 ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 27";
        r3.add(r9);
        r9 = "13 ?? 09 00 6E ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 00 ?? ?? 59 ?? ?? ?? 22 ?? ?? ?? 70 ?? ?? ?? ?? ?? 27";
        r4.add(r9);
        r9 = samsung;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "samsung patch N1!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 09 00 13 ?? 0B 00 6E ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 ?? ?? ?? 59 ?? ?? ?? 22 ?? ?? ?? 12 ?? 70 ?? ?? ?? ?? ?? 27";
        r3.add(r9);
        r9 = "13 ?? 09 00 13 ?? 0B 00 6E ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0A ?? 32 00 ?? ?? 59 ?? ?? ?? 22 ?? ?? ?? 12 ?? 70 ?? ?? ?? ?? ?? 27";
        r4.add(r9);
        r9 = samsung;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "samsung patch N1!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0A ?? 0F ?? 00 00";
        r3.add(r9);
        r9 = "54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 12 S1 0F ?? 00 00";
        r4.add(r9);
        r9 = samsung;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "samsung patch N2!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? 0F ?? 00 00";
        r3.add(r9);
        r9 = "54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12 S1 0F ?? 00 00";
        r4.add(r9);
        r9 = samsung;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "samsung patch N2!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 0A ?? 0F ?? 00 00";
        r3.add(r9);
        r9 = "54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 6E ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0C ?? 71 ?? ?? ?? ?? ?? 12 S1 0F ?? 00 00";
        r4.add(r9);
        r9 = samsung;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "samsung patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "54 ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ??";
        r3.add(r9);
        r9 = "54 ?? ?? ?? 54 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0C ?? 54 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 0A ?? 33 00 ?? ??";
        r4.add(r9);
        r9 = samsung;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "samsung patch N3!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 32 00 33 ?? ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12";
        r3.add(r9);
        r9 = "13 ?? 32 00 32 00 ?? ?? 6E ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 54 ?? ?? ?? 71 ?? ?? ?? ?? ?? 12";
        r4.add(r9);
        r9 = samsung;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "samsung patch N4!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "13 ?? 32 00 33 ?? ?? ?? 70 ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 54 ?? ?? ?? 59 ?? ?? ?? ?? ?? 28";
        r3.add(r9);
        r9 = "13 ?? 32 00 32 00 ?? ?? 70 ?? ?? ?? ?? ?? 0A ?? 38 ?? ?? ?? 54 ?? ?? ?? 59 ?? ?? ?? ?? ?? 28";
        r4.add(r9);
        r9 = samsung;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "samsung patch N4!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "38 ?? 06 00 32 ?? 04 00 33 ?? ?? ?? 1A ?? ?? ?? 71";
        r3.add(r9);
        r9 = "12 ?? 00 00 32 00 04 00 33 ?? ?? ?? ?? ?? ?? ?? ??";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N6!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = 0;
        r9 = r81[r9];
        r11 = "com.buak.Link2SD";
        r9 = r9.contains(r11);
        if (r9 != 0) goto L_0x07fa;
    L_0x07d5:
        r9 = "00 05 2E 6F 64 65 78 00";
        r3.add(r9);
        r9 = "00 05 2E 6F 64 65 79 00";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
    L_0x07fa:
        r9 = "00 04 6F 64 65 78 00";
        r3.add(r9);
        r9 = "00 04 6F 64 65 79 00";
        r4.add(r9);
        r9 = pattern4;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "lvl patch N7!\n";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = "2F 4C 75 63 6B 79 50 61 74 63 68 65 72";
        r3.add(r9);
        r9 = "2F 4C 75 63 6B 79 50 79 74 63 68 65 72";
        r4.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r5.add(r9);
        r9 = "";
        r6.add(r9);
        r9 = "";
        r7.add(r9);
        r9 = 1;
        r9 = java.lang.Boolean.valueOf(r9);
        r8.add(r9);
        r9 = ART;
        if (r9 != 0) goto L_0x0941;
    L_0x0847:
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
    L_0x0891:
        r28 = 0;
        r9 = java.lang.Boolean.valueOf(r28);
        com.chelpus.Utils.convertToPatchItemAuto(r2, r3, r4, r5, r6, r7, r8, r9);
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.booleanValue();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x08aa;
    L_0x08a2:
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "RW";
        com.chelpus.Utils.remount(r9, r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x08aa:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 != 0) goto L_0x0ae3;
    L_0x08ae:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 != 0) goto L_0x0ae3;
    L_0x08b2:
        r9 = 3;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        dir = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        dirapp = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        clearTemp();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 4;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "not_system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x08cd;
    L_0x08ca:
        r9 = 0;
        system = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x08cd:
        r9 = 4;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x08db;
    L_0x08d8:
        r9 = 1;
        system = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x08db:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "CLASSES mode create odex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 0;
        r60 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 3;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "Get classes.dex.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "Get classes.dex.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        unzipART(r16);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0919;
    L_0x0911:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 != 0) goto L_0x098d;
    L_0x0919:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x091f:
        r48 = move-exception;
        r9 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        com.chelpus.Utils.sendFromRoot(r9);
        r48.printStackTrace();
    L_0x0928:
        r9 = filestopatch;
        r9 = r9.iterator();
    L_0x092e:
        r11 = r9.hasNext();
        if (r11 == 0) goto L_0x1537;
    L_0x0934:
        r42 = r9.next();
        r42 = (java.io.File) r42;
        com.chelpus.Utils.fixadler(r42);
        clearTempSD();
        goto L_0x092e;
    L_0x0941:
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
        goto L_0x0891;
    L_0x098d:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0998:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r11 == 0) goto L_0x09db;
    L_0x099e:
        r26 = r9.next();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r26 = (java.io.File) r26;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = r26.exists();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r11 != 0) goto L_0x09d3;
    L_0x09aa:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x09b0:
        r35 = move-exception;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r11 = "Exception e";
        r9 = r9.append(r11);
        r11 = r35.toString();
        r9 = r9.append(r11);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        r35.printStackTrace();
        r35.printStackTrace();
        goto L_0x0928;
    L_0x09d3:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r26;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        goto L_0x0998;
    L_0x09db:
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = 1;
        r57 = com.chelpus.Utils.getPlaceForOdex(r9, r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r56 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r56.<init>(r57);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r56.exists();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x09f1;
    L_0x09ee:
        r56.delete();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x09f1:
        r56 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "-1";
        r11 = "-2";
        r0 = r57;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r56;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r56.exists();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0a0b;
    L_0x0a08:
        r56.delete();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0a0b:
        r56 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "-2";
        r11 = "-1";
        r0 = r57;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r56;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r56.exists();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0a25;
    L_0x0a22:
        r56.delete();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0a25:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r80 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0a2b:
        r9 = r80.hasNext();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0928;
    L_0x0a31:
        r41 = r80.next();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r41 = (java.io.File) r41;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "Find string id.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r76 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r76.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "com.android.vending";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "SHA1withRSA";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "com.android.vending.billing.InAppBillingService.BIND";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "Ljava/security/Signature;";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "verify";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "String analysis.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "String analysis.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r41.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = 0;
        r0 = r76;
        r59 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r36 = 0;
        r37 = 0;
        r38 = 0;
        r58 = 1;
        r27 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r27.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "Ljava/security/Signature;";
        r12 = "verify";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r27;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = r59.iterator();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0a9a:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0cce;
    L_0x0aa0:
        r46 = r11.next();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r46 = (com.android.vending.billing.InAppBillingService.LOCK.StringItem) r46;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r27.iterator();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0aaa:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r12 == 0) goto L_0x0bcc;
    L_0x0ab0:
        r47 = r9.next();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r47 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r47;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r47;
        r12 = r0.object;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r46;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r12 == 0) goto L_0x0acc;
    L_0x0ac4:
        r0 = r46;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r47;
        r0.Object = r12;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0acc:
        r0 = r47;
        r12 = r0.method;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r46;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r12 == 0) goto L_0x0aaa;
    L_0x0ada:
        r0 = r46;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r47;
        r0.Method = r12;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        goto L_0x0aaa;
    L_0x0ae3:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0b6f;
    L_0x0ae7:
        r9 = 0;
        r60 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 5;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        unzipSD(r16);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = sddir;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = "/Modified/";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r60;
        r11 = r11.append(r0);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = ".apk";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = r11.toString();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        crkapk = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = crkapk;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r16;
        com.chelpus.Utils.copyFile(r0, r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0b3e;
    L_0x0b36:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 != 0) goto L_0x0b44;
    L_0x0b3e:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0b44:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0b4f:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r11 == 0) goto L_0x0b6f;
    L_0x0b55:
        r26 = r9.next();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r26 = (java.io.File) r26;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = r26.exists();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r11 != 0) goto L_0x0b67;
    L_0x0b61:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0b67:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r26;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        goto L_0x0b4f;
    L_0x0b6f:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0a25;
    L_0x0b73:
        r9 = 0;
        r60 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 3;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        unzipART(r16);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0b9b;
    L_0x0b93:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 != 0) goto L_0x0ba1;
    L_0x0b9b:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0ba1:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0bac:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r11 == 0) goto L_0x0a25;
    L_0x0bb2:
        r26 = r9.next();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r26 = (java.io.File) r26;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = r26.exists();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r11 != 0) goto L_0x0bc4;
    L_0x0bbe:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        throw r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0bc4:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r26;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        goto L_0x0bac;
    L_0x0bcc:
        r0 = r46;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = "com.android.vending.billing.InAppBillingService.BIND";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0c4c;
    L_0x0bd8:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 2;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 3;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 2;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 3;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 4;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 5;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r37 = 0;
    L_0x0c4c:
        r0 = r46;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = "SHA1withRSA";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0a9a;
    L_0x0c58:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 2;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 3;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 2;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 3;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 4;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 5;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r38 = 1;
        goto L_0x0a9a;
    L_0x0cce:
        r62 = 0;
        r63 = 1;
        if (r36 == 0) goto L_0x0cd6;
    L_0x0cd4:
        if (r37 != 0) goto L_0x0cea;
    L_0x0cd6:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0cea:
        if (r38 != 0) goto L_0x0d0a;
    L_0x0cec:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 4;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0d0a:
        r9 = "Parse data for patch.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "Parse data for patch.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r41.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = 0;
        r12 = 0;
        r0 = r27;
        com.chelpus.Utils.getMethodsIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 0;
        r0 = r27;
        r9 = r0.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.index_command;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 0;
        r9 = r9[r12];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = java.lang.Integer.toHexString(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11.println(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 0;
        r0 = r27;
        r9 = r0.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.index_command;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 1;
        r9 = r9[r12];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = java.lang.Integer.toHexString(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11.println(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = r27.iterator();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0d53:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0da5;
    L_0x0d59:
        r47 = r11.next();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r47 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r47;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r47;
        r9 = r0.found_index_command;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0d53;
    L_0x0d65:
        r0 = r47;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = "Ljava/security/Signature;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r9 == 0) goto L_0x0d53;
    L_0x0d71:
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 2;
        r0 = r47;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 3;
        r0 = r47;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        goto L_0x0d53;
    L_0x0da5:
        r9 = r2.size();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto[r9];	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r61 = r0;
        r77 = 0;
        r9 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x0db3:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        if (r11 == 0) goto L_0x0dc4;
    L_0x0db9:
        r47 = r9.next();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r47 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r47;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r61[r77] = r47;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r77 = r77 + 1;
        goto L_0x0db3;
    L_0x0dc4:
        r78 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "rw";
        r0 = r41;
        r9.<init>(r0, r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r10 = r9.getChannel();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "Size file:";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = r10.size();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = 0;
        r14 = r10.size();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = (int) r14;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r14 = (long) r9;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r40 = r10.map(r11, r12, r14);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r49 = 0;
        r50 = 0;
        r33 = 90;
        r34 = 40;
        r74 = 0;
        r75 = 0;
        r30 = -1;
        r31 = 0;
        r73 = 0;
        r72 = 0;
        r65 = 0;
    L_0x0e13:
        r9 = r40.hasRemaining();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x10d0;
    L_0x0e19:
        r9 = createAPK;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x0e46;
    L_0x0e1d:
        r9 = r40.position();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9 - r65;
        r11 = 149999; // 0x249ef float:2.10193E-40 double:7.41094E-319;
        if (r9 <= r11) goto L_0x0e46;
    L_0x0e28:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9.<init>();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = "Progress size:";
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r40.position();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9.toString();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r65 = r40.position();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0e46:
        r30 = r40.position();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r29 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r49 != 0) goto L_0x0e52;
    L_0x0e50:
        if (r50 == 0) goto L_0x0e54;
    L_0x0e52:
        r31 = r31 + 1;
    L_0x0e54:
        r9 = 380; // 0x17c float:5.32E-43 double:1.877E-321;
        r0 = r31;
        if (r0 <= r9) goto L_0x0e5e;
    L_0x0e5a:
        r49 = 0;
        r31 = 0;
    L_0x0e5e:
        r9 = 0;
        r9 = r18[r9];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r29;
        if (r0 != r9) goto L_0x0ef9;
    L_0x0e65:
        r9 = pattern1;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x0ef9;
    L_0x0e69:
        r9 = 0;
        r9 = r69[r9];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x0e71;
    L_0x0e6e:
        r9 = 0;
        r21[r9] = r29;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0e71:
        r44 = 1;
        r25 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r24 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r73 = 0;
        r72 = 0;
    L_0x0e86:
        r9 = r18[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r67;
        if (r0 == r9) goto L_0x0e90;
    L_0x0e8c:
        r9 = r51[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x0ef9;
    L_0x0e90:
        r9 = r69[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 2;
        if (r9 != r11) goto L_0x0ea9;
    L_0x0e95:
        r9 = r40.position();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9 + 7;
        r0 = r40;
        r9 = r0.get(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r67;
        if (r0 != r9) goto L_0x0ea9;
    L_0x0ea5:
        r24 = r44;
        r73 = r67;
    L_0x0ea9:
        r9 = r69[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x0eb2;
    L_0x0ead:
        r9 = r69[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 2;
        if (r9 != r11) goto L_0x0eb4;
    L_0x0eb2:
        r21[r44] = r67;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0eb4:
        r9 = r69[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 3;
        if (r9 != r11) goto L_0x0ebd;
    L_0x0eb9:
        r72 = r67;
        r25 = r44;
    L_0x0ebd:
        r44 = r44 + 1;
        r0 = r18;
        r9 = r0.length;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r44;
        if (r0 != r9) goto L_0x1057;
    L_0x0ec6:
        r9 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r25;
        if (r0 >= r9) goto L_0x0ef9;
    L_0x0ecc:
        if (r72 == 0) goto L_0x0ef9;
    L_0x0ece:
        r21[r25] = r73;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r24 + 7;
        r11 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r9 >= r11) goto L_0x0ef9;
    L_0x0ed6:
        if (r73 == 0) goto L_0x0ef9;
    L_0x0ed8:
        r9 = r24 + 8;
        r21[r9] = r72;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r40;
        r1 = r21;
        r0.put(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r40.force();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = "lvl patch N1!\n";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = print;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = "lvl patch N1!\n";
        r9.print(r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0ef9:
        r54 = new java.util.ArrayList;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r54.<init>();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r55 = new java.util.ArrayList;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r55.<init>();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r45 = 0;
        r17 = 0;
    L_0x0f07:
        r0 = r61;
        r9 = r0.length;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r17;
        if (r0 >= r9) goto L_0x1491;
    L_0x0f0e:
        r64 = r61[r17];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x1109;
    L_0x0f1d:
        r9 = 5;
        r0 = r17;
        if (r0 == r9) goto L_0x0f3e;
    L_0x0f22:
        r9 = 6;
        r0 = r17;
        if (r0 == r9) goto L_0x0f3e;
    L_0x0f27:
        r9 = 7;
        r0 = r17;
        if (r0 == r9) goto L_0x0f3e;
    L_0x0f2c:
        r9 = 8;
        r0 = r17;
        if (r0 == r9) goto L_0x0f3e;
    L_0x0f32:
        r9 = 9;
        r0 = r17;
        if (r0 == r9) goto L_0x0f3e;
    L_0x0f38:
        r9 = 10;
        r0 = r17;
        if (r0 != r9) goto L_0x1109;
    L_0x0f3e:
        if (r45 != 0) goto L_0x0f44;
    L_0x0f40:
        r75 = r75 + 1;
        r45 = 1;
    L_0x0f44:
        r0 = r75;
        r1 = r34;
        if (r0 >= r1) goto L_0x122f;
    L_0x0f4a:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r29;
        if (r0 != r9) goto L_0x1102;
    L_0x0f55:
        r54.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r55.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x0f6b;
    L_0x0f64:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9[r11] = r29;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0f6b:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0f78:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r67;
        if (r0 == r9) goto L_0x0fa9;
    L_0x0f82:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 1;
        if (r9 == r11) goto L_0x0fa9;
    L_0x0f8b:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 20;
        if (r9 == r11) goto L_0x0fa9;
    L_0x0f95:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 21;
        if (r9 == r11) goto L_0x0fa9;
    L_0x0f9f:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x1102;
    L_0x0fa9:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x0fb7;
    L_0x0fb1:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r67;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0fb7:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 20;
        if (r9 != r11) goto L_0x0fca;
    L_0x0fc1:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r67 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0fca:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 21;
        if (r9 != r11) goto L_0x0fdf;
    L_0x0fd4:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r67 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0fdf:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x0ff8;
    L_0x0fe9:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = java.lang.Byte.valueOf(r67);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r54;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x0ff8:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x1011;
    L_0x1002:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = java.lang.Integer.valueOf(r44);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r55;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1011:
        r44 = r44 + 1;
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9.length;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r44;
        if (r0 != r9) goto L_0x1229;
    L_0x101c:
        r9 = r54.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 > 0) goto L_0x1028;
    L_0x1022:
        r9 = r55.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 <= 0) goto L_0x1063;
    L_0x1028:
        r68 = 0;
    L_0x102a:
        r9 = r54.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r68;
        if (r0 >= r9) goto L_0x105d;
    L_0x1032:
        r0 = r64;
        r11 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r55;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = (java.lang.Integer) r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r12 = r9.intValue();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r54;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = (java.lang.Byte) r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9.byteValue();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11[r12] = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r68 = r68 + 1;
        goto L_0x102a;
    L_0x1057:
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x0e86;
    L_0x105d:
        r54.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r55.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1063:
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r40;
        r0.put(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r40.force();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = print;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9.println(r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = 1;
        r0 = r64;
        r0.result = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = 0;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1094:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x10f9;
    L_0x109a:
        r32 = r9.next();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x1094;
    L_0x10ae:
        r11 = 0;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x1094;
    L_0x10b4:
        r35 = move-exception;
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r0 = r35;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r35.printStackTrace();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
    L_0x10d0:
        r10.close();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r11 = "";
        r9 = r9.append(r11);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r12 = r12 - r78;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        r9 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x091f, Exception -> 0x09b0 }
        goto L_0x0a2b;
    L_0x10f9:
        r75 = 0;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1102:
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1109:
        r0 = r64;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x12ca;
    L_0x110f:
        r9 = 4;
        r0 = r17;
        if (r0 != r9) goto L_0x12ca;
    L_0x1114:
        r74 = r74 + 1;
        r0 = r74;
        r1 = r33;
        if (r0 >= r1) goto L_0x13e9;
    L_0x111c:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r29;
        if (r0 != r9) goto L_0x12c3;
    L_0x1127:
        r54.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r55.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x113d;
    L_0x1136:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9[r11] = r29;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x113d:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x114a:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r67;
        if (r0 == r9) goto L_0x117b;
    L_0x1154:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 1;
        if (r9 == r11) goto L_0x117b;
    L_0x115d:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 20;
        if (r9 == r11) goto L_0x117b;
    L_0x1167:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 21;
        if (r9 == r11) goto L_0x117b;
    L_0x1171:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x12c3;
    L_0x117b:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x1189;
    L_0x1183:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r67;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1189:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 20;
        if (r9 != r11) goto L_0x119c;
    L_0x1193:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r67 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x119c:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 21;
        if (r9 != r11) goto L_0x11b1;
    L_0x11a6:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r67 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x11b1:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x11ca;
    L_0x11bb:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = java.lang.Byte.valueOf(r67);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r54;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x11ca:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x11e3;
    L_0x11d4:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = java.lang.Integer.valueOf(r44);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r55;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x11e3:
        r44 = r44 + 1;
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9.length;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r44;
        if (r0 != r9) goto L_0x13e3;
    L_0x11ee:
        r9 = r54.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 > 0) goto L_0x11fa;
    L_0x11f4:
        r9 = r55.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 <= 0) goto L_0x1269;
    L_0x11fa:
        r68 = 0;
    L_0x11fc:
        r9 = r54.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r68;
        if (r0 >= r9) goto L_0x1263;
    L_0x1204:
        r0 = r64;
        r11 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r55;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = (java.lang.Integer) r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r12 = r9.intValue();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r54;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = (java.lang.Byte) r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9.byteValue();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11[r12] = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r68 = r68 + 1;
        goto L_0x11fc;
    L_0x1229:
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x0f78;
    L_0x122f:
        r9 = 0;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1238:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x1258;
    L_0x123e:
        r32 = r9.next();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x1238;
    L_0x1252:
        r11 = 0;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x1238;
    L_0x1258:
        r75 = 0;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x1109;
    L_0x1263:
        r54.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r55.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1269:
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r40;
        r0.put(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r40.force();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = print;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9.println(r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = 1;
        r0 = r64;
        r0.result = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = 0;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x129a:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x12ba;
    L_0x12a0:
        r32 = r9.next();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x129a;
    L_0x12b4:
        r11 = 0;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x129a;
    L_0x12ba:
        r74 = 0;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x12c3:
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x12ca:
        r0 = r64;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x148d;
    L_0x12d0:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r29;
        if (r0 != r9) goto L_0x148d;
    L_0x12db:
        r0 = r64;
        r9 = r0.pattern;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x148d;
    L_0x12e1:
        r54.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r55.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x12f7;
    L_0x12f0:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 0;
        r9[r11] = r29;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x12f7:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1304:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r67;
        if (r0 == r9) goto L_0x1335;
    L_0x130e:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 1;
        if (r9 == r11) goto L_0x1335;
    L_0x1317:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 20;
        if (r9 == r11) goto L_0x1335;
    L_0x1321:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 21;
        if (r9 == r11) goto L_0x1335;
    L_0x132b:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x1486;
    L_0x1335:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x1343;
    L_0x133d:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r67;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1343:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 20;
        if (r9 != r11) goto L_0x1356;
    L_0x134d:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r67 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1356:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 21;
        if (r9 != r11) goto L_0x136b;
    L_0x1360:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r67 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9[r44] = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x136b:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x1384;
    L_0x1375:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = java.lang.Byte.valueOf(r67);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r54;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1384:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 23;
        if (r9 != r11) goto L_0x139d;
    L_0x138e:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = java.lang.Integer.valueOf(r44);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r55;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x139d:
        r44 = r44 + 1;
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9.length;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r44;
        if (r0 != r9) goto L_0x1480;
    L_0x13a8:
        r9 = r54.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 > 0) goto L_0x13b4;
    L_0x13ae:
        r9 = r55.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 <= 0) goto L_0x1423;
    L_0x13b4:
        r68 = 0;
    L_0x13b6:
        r9 = r54.size();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r68;
        if (r0 >= r9) goto L_0x141d;
    L_0x13be:
        r0 = r64;
        r11 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r55;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = (java.lang.Integer) r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r12 = r9.intValue();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r54;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = (java.lang.Byte) r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r9.byteValue();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11[r12] = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r68 = r68 + 1;
        goto L_0x13b6;
    L_0x13e3:
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x114a;
    L_0x13e9:
        r9 = 0;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x13f2:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x1412;
    L_0x13f8:
        r32 = r9.next();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x13f2;
    L_0x140c:
        r11 = 0;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x13f2;
    L_0x1412:
        r74 = 0;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x12ca;
    L_0x141d:
        r54.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r55.clear();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1423:
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r40;
        r0.put(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r40.force();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = print;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9.println(r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = 1;
        r0 = r64;
        r0.result = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r9 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = "";
        r9 = r9.equals(r11);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x1486;
    L_0x1457:
        r9 = 1;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1460:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x1486;
    L_0x1466:
        r32 = r9.next();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r11 == 0) goto L_0x1460;
    L_0x147a:
        r11 = 1;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x1460;
    L_0x1480:
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x1304;
    L_0x1486:
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x148d:
        r17 = r17 + 1;
        goto L_0x0f07;
    L_0x1491:
        r9 = 0;
        r9 = r19[r9];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r29;
        if (r0 != r9) goto L_0x14d1;
    L_0x1498:
        r9 = pattern4;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x14d1;
    L_0x149c:
        r9 = 0;
        r9 = r70[r9];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x14a4;
    L_0x14a1:
        r9 = 0;
        r22[r9] = r29;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x14a4:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x14b1:
        r9 = r19[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r67;
        if (r0 == r9) goto L_0x14bc;
    L_0x14b7:
        r9 = r52[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 1;
        if (r9 != r11) goto L_0x14d1;
    L_0x14bc:
        r9 = r70[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x14c2;
    L_0x14c0:
        r22[r44] = r67;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x14c2:
        r44 = r44 + 1;
        r0 = r19;
        r9 = r0.length;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r44;
        if (r0 != r9) goto L_0x152d;
    L_0x14cb:
        r30 = r40.position();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r49 = 1;
    L_0x14d1:
        r9 = 16;
        r0 = r29;
        if (r0 >= r9) goto L_0x1524;
    L_0x14d7:
        if (r49 == 0) goto L_0x1524;
    L_0x14d9:
        r9 = pattern4;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 == 0) goto L_0x1524;
    L_0x14dd:
        r9 = 0;
        r9 = r71[r9];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x14e5;
    L_0x14e2:
        r9 = 0;
        r23[r9] = r29;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x14e5:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x14f2:
        r9 = r20[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r67;
        if (r0 == r9) goto L_0x14fd;
    L_0x14f8:
        r9 = r53[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r11 = 1;
        if (r9 != r11) goto L_0x1524;
    L_0x14fd:
        r9 = r71[r44];	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        if (r9 != 0) goto L_0x1503;
    L_0x1501:
        r23[r44] = r67;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
    L_0x1503:
        r44 = r44 + 1;
        r0 = r20;
        r9 = r0.length;	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r44;
        if (r0 != r9) goto L_0x1532;
    L_0x150c:
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r0 = r40;
        r1 = r23;
        r0.put(r1);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r40.force();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r9 = "lvl patch N5!\n";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        r49 = 0;
    L_0x1524:
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x0e13;
    L_0x152d:
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x14b1;
    L_0x1532:
        r67 = r40.get();	 Catch:{ Exception -> 0x10b4, FileNotFoundException -> 0x091f }
        goto L_0x14f2;
    L_0x1537:
        r9 = createAPK;
        if (r9 != 0) goto L_0x1586;
    L_0x153b:
        r9 = 3;
        r9 = r81[r9];
        r11 = classesFiles;
        r12 = 2;
        r12 = r81[r12];
        r13 = uid;
        r14 = 2;
        r14 = r81[r14];
        r15 = uid;
        r14 = com.chelpus.Utils.getOdexForCreate(r14, r15);
        r68 = com.chelpus.Utils.create_ODEX_root(r9, r11, r12, r13, r14);
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r11 = "chelpus_return_";
        r9 = r9.append(r11);
        r0 = r68;
        r9 = r9.append(r0);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        if (r68 != 0) goto L_0x1586;
    L_0x156c:
        r9 = ART;
        if (r9 != 0) goto L_0x1586;
    L_0x1570:
        r9 = 1;
        r9 = r81[r9];
        r11 = 2;
        r11 = r81[r11];
        r12 = 2;
        r12 = r81[r12];
        r13 = 1;
        r12 = com.chelpus.Utils.getPlaceForOdex(r12, r13);
        r13 = uid;
        r14 = 3;
        r14 = r81[r14];
        com.chelpus.Utils.afterPatch(r9, r11, r12, r13, r14);
    L_0x1586:
        r9 = createAPK;
        if (r9 != 0) goto L_0x158d;
    L_0x158a:
        com.chelpus.Utils.exitFromRootJava();
    L_0x158d:
        r0 = r66;
        r9 = r0.allresult;
        result = r9;
        return;
    L_0x1594:
        r9 = move-exception;
        goto L_0x0151;
    L_0x1597:
        r9 = move-exception;
        goto L_0x0151;
    L_0x159a:
        r9 = move-exception;
        goto L_0x0143;
    L_0x159d:
        r9 = move-exception;
        goto L_0x0143;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.odexrunpatch.main(java.lang.String[]):void");
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
