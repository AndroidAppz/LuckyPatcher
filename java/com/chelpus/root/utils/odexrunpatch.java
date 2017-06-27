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
        r9 = new java.io.File;	 Catch:{ Exception -> 0x0b1f }
        r11 = 3;
        r11 = r81[r11];	 Catch:{ Exception -> 0x0b1f }
        r9.<init>(r11);	 Catch:{ Exception -> 0x0b1f }
        r43 = r9.listFiles();	 Catch:{ Exception -> 0x0b1f }
        r0 = r43;
        r11 = r0.length;	 Catch:{ Exception -> 0x0b1f }
        r9 = 0;
    L_0x005c:
        if (r9 < r11) goto L_0x0aec;
    L_0x005e:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "pattern1";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x006c;
    L_0x0069:
        r9 = 0;
        pattern1 = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x006c:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "pattern2";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x007a;
    L_0x0077:
        r9 = 0;
        pattern2 = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x007a:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "pattern3";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x0088;
    L_0x0085:
        r9 = 0;
        pattern3 = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x0088:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "pattern4";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x0096;
    L_0x0093:
        r9 = 0;
        pattern4 = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x0096:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "pattern5";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x00a4;
    L_0x00a1:
        r9 = 0;
        pattern5 = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x00a4:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "pattern6";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x00b2;
    L_0x00af:
        r9 = 0;
        pattern6 = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x00b2:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "dependencies";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x00c0;
    L_0x00bd:
        r9 = 0;
        dependencies = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x00c0:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "amazon";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x00ce;
    L_0x00cb:
        r9 = 0;
        amazon = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x00ce:
        r9 = 1;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "samsung";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 != 0) goto L_0x00dc;
    L_0x00d9:
        r9 = 0;
        samsung = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x00dc:
        r9 = 6;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "createAPK";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 == 0) goto L_0x00ea;
    L_0x00e7:
        r9 = 1;
        createAPK = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x00ea:
        r9 = 6;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 == 0) goto L_0x00fd;
    L_0x00ef:
        r9 = 6;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        r11 = "ART";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 == 0) goto L_0x00fd;
    L_0x00fa:
        r9 = 1;
        ART = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x00fd:
        r9 = 7;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        if (r9 == 0) goto L_0x0107;
    L_0x0102:
        r9 = 7;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        uid = r9;	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x0107:
        r9 = 6;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ NullPointerException -> 0x172d, Exception -> 0x172a }
    L_0x010d:
        r9 = 5;
        r9 = r81[r9];	 Catch:{ NullPointerException -> 0x1727, Exception -> 0x1724 }
        r11 = "copyDC";
        r9 = r9.contains(r11);	 Catch:{ NullPointerException -> 0x1727, Exception -> 0x1724 }
        if (r9 == 0) goto L_0x011b;
    L_0x0118:
        r9 = 1;
        copyDC = r9;	 Catch:{ NullPointerException -> 0x1727, Exception -> 0x1724 }
    L_0x011b:
        r9 = createAPK;
        if (r9 == 0) goto L_0x0126;
    L_0x011f:
        r9 = 0;
        r9 = java.lang.Boolean.valueOf(r9);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r9;
    L_0x0126:
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
        r9 = 0;
        r11 = 5;
        r18[r9] = r11;
        r9 = 4;
        r11 = 1;
        r18[r9] = r11;
        r9 = 5;
        r11 = 1;
        r18[r9] = r11;
        r9 = 8;
        r11 = 2;
        r18[r9] = r11;
        r9 = 9;
        r11 = 1;
        r18[r9] = r11;
        r9 = 12;
        r11 = 3;
        r18[r9] = r11;
        r9 = 13;
        r11 = 1;
        r18[r9] = r11;
        r9 = 16;
        r11 = 15;
        r18[r9] = r11;
        r9 = 20;
        r11 = 26;
        r18[r9] = r11;
        r9 = 24;
        r11 = 15;
        r18[r9] = r11;
        r9 = 28;
        r11 = 89;
        r18[r9] = r11;
        r9 = 29;
        r0 = new byte[r9];
        r51 = r0;
        r9 = 16;
        r11 = 1;
        r51[r9] = r11;
        r9 = 20;
        r11 = 1;
        r51[r9] = r11;
        r9 = 24;
        r11 = 1;
        r51[r9] = r11;
        r9 = 28;
        r11 = 1;
        r51[r9] = r11;
        r9 = 29;
        r0 = new byte[r9];
        r21 = r0;
        r9 = 0;
        r11 = 5;
        r21[r9] = r11;
        r9 = 4;
        r11 = 1;
        r21[r9] = r11;
        r9 = 5;
        r11 = 1;
        r21[r9] = r11;
        r9 = 8;
        r11 = 2;
        r21[r9] = r11;
        r9 = 9;
        r11 = 1;
        r21[r9] = r11;
        r9 = 12;
        r11 = 3;
        r21[r9] = r11;
        r9 = 13;
        r11 = 1;
        r21[r9] = r11;
        r9 = 16;
        r11 = 15;
        r21[r9] = r11;
        r9 = 20;
        r11 = 15;
        r21[r9] = r11;
        r9 = 24;
        r11 = 15;
        r21[r9] = r11;
        r9 = 28;
        r11 = 89;
        r21[r9] = r11;
        r9 = 29;
        r0 = new byte[r9];
        r69 = r0;
        r9 = 16;
        r11 = 2;
        r69[r9] = r11;
        r9 = 20;
        r11 = 3;
        r69[r9] = r11;
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
        r9 = 1;
        r11 = 1;
        r52[r9] = r11;
        r9 = 2;
        r11 = 1;
        r52[r9] = r11;
        r9 = 3;
        r11 = 1;
        r52[r9] = r11;
        r9 = 5;
        r11 = 1;
        r52[r9] = r11;
        r9 = 6;
        r11 = 1;
        r52[r9] = r11;
        r9 = 7;
        r11 = 1;
        r52[r9] = r11;
        r9 = 8;
        r11 = 1;
        r52[r9] = r11;
        r9 = 9;
        r11 = 1;
        r52[r9] = r11;
        r9 = 11;
        r11 = 1;
        r52[r9] = r11;
        r9 = 13;
        r11 = 1;
        r52[r9] = r11;
        r9 = 14;
        r11 = 1;
        r52[r9] = r11;
        r9 = 15;
        r11 = 1;
        r52[r9] = r11;
        r9 = 16;
        r11 = 1;
        r52[r9] = r11;
        r9 = 17;
        r11 = 1;
        r52[r9] = r11;
        r9 = 19;
        r11 = 1;
        r52[r9] = r11;
        r9 = 21;
        r11 = 1;
        r52[r9] = r11;
        r9 = 22;
        r11 = 1;
        r52[r9] = r11;
        r9 = 23;
        r11 = 1;
        r52[r9] = r11;
        r9 = 25;
        r11 = 1;
        r52[r9] = r11;
        r9 = 26;
        r11 = 1;
        r52[r9] = r11;
        r9 = 27;
        r11 = 1;
        r52[r9] = r11;
        r9 = 29;
        r11 = 1;
        r52[r9] = r11;
        r9 = 30;
        r11 = 1;
        r52[r9] = r11;
        r9 = 31;
        r11 = 1;
        r52[r9] = r11;
        r9 = 32;
        r0 = new byte[r9];
        r22 = r0;
        r22 = {26, 102, 102, 102, 113, 102, 102, 102, 102, 102, 12, 102, 113, 102, 102, 102, 102, 102, 12, 102, 33, 102, 102, 102, 53, 102, 102, 102, 34, 102, 102, 102};
        r9 = 32;
        r0 = new byte[r9];
        r70 = r0;
        r9 = 13;
        r0 = new byte[r9];
        r20 = r0;
        r9 = 1;
        r11 = 70;
        r20[r9] = r11;
        r9 = 2;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 3;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 4;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 5;
        r11 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r20[r9] = r11;
        r9 = 6;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 7;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 8;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 9;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 10;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 11;
        r11 = 10;
        r20[r9] = r11;
        r9 = 12;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r20[r9] = r11;
        r9 = 13;
        r0 = new byte[r9];
        r53 = r0;
        r9 = 0;
        r11 = 1;
        r53[r9] = r11;
        r9 = 2;
        r11 = 1;
        r53[r9] = r11;
        r9 = 3;
        r11 = 1;
        r53[r9] = r11;
        r9 = 4;
        r11 = 1;
        r53[r9] = r11;
        r9 = 6;
        r11 = 1;
        r53[r9] = r11;
        r9 = 7;
        r11 = 1;
        r53[r9] = r11;
        r9 = 8;
        r11 = 1;
        r53[r9] = r11;
        r9 = 9;
        r11 = 1;
        r53[r9] = r11;
        r9 = 10;
        r11 = 1;
        r53[r9] = r11;
        r9 = 12;
        r11 = 1;
        r53[r9] = r11;
        r9 = 13;
        r0 = new byte[r9];
        r23 = r0;
        r9 = 1;
        r11 = 70;
        r23[r9] = r11;
        r9 = 2;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 3;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 4;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 5;
        r11 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r23[r9] = r11;
        r9 = 6;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 7;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 8;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 9;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 10;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 11;
        r11 = 18;
        r23[r9] = r11;
        r9 = 12;
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r23[r9] = r11;
        r9 = 13;
        r0 = new byte[r9];
        r71 = r0;
        r9 = 11;
        r11 = 1;
        r71[r9] = r11;
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
        if (r9 != 0) goto L_0x0959;
    L_0x0934:
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
    L_0x0959:
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
        if (r9 != 0) goto L_0x0b25;
    L_0x09a6:
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
    L_0x09f0:
        r28 = 0;
        r9 = java.lang.Boolean.valueOf(r28);
        com.chelpus.Utils.convertToPatchItemAuto(r2, r3, r4, r5, r6, r7, r8, r9);
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.booleanValue();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0a09;
    L_0x0a01:
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "RW";
        com.chelpus.Utils.remount(r9, r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0a09:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 != 0) goto L_0x0d94;
    L_0x0a0d:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 != 0) goto L_0x0d94;
    L_0x0a11:
        r9 = 3;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        dir = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        dirapp = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        clearTemp();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 4;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "not_system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0a2c;
    L_0x0a29:
        r9 = 0;
        system = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0a2c:
        r9 = 4;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "system";
        r9 = r9.equals(r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0a3a;
    L_0x0a37:
        r9 = 1;
        system = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0a3a:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "CLASSES mode create odex enabled.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 0;
        r60 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 3;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "Get classes.dex.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "Get classes.dex.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        unzipART(r16);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0a78;
    L_0x0a70:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 != 0) goto L_0x0b71;
    L_0x0a78:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0a7e:
        r48 = move-exception;
        r9 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        com.chelpus.Utils.sendFromRoot(r9);
        r48.printStackTrace();
    L_0x0a87:
        r9 = filestopatch;
        r9 = r9.iterator();
    L_0x0a8d:
        r11 = r9.hasNext();
        if (r11 != 0) goto L_0x1716;
    L_0x0a93:
        r9 = createAPK;
        if (r9 != 0) goto L_0x0ade;
    L_0x0a97:
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
        r11 = "chelpus_return_";
        r9.<init>(r11);
        r0 = r68;
        r9 = r9.append(r0);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        if (r68 != 0) goto L_0x0ade;
    L_0x0ac4:
        r9 = ART;
        if (r9 != 0) goto L_0x0ade;
    L_0x0ac8:
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
    L_0x0ade:
        r9 = createAPK;
        if (r9 != 0) goto L_0x0ae5;
    L_0x0ae2:
        com.chelpus.Utils.exitFromRootJava();
    L_0x0ae5:
        r0 = r66;
        r9 = r0.allresult;
        result = r9;
        return;
    L_0x0aec:
        r39 = r43[r9];	 Catch:{ Exception -> 0x0b1f }
        r12 = r39.isFile();	 Catch:{ Exception -> 0x0b1f }
        if (r12 == 0) goto L_0x0b1b;
    L_0x0af4:
        r12 = r39.getName();	 Catch:{ Exception -> 0x0b1f }
        r13 = "busybox";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0b1f }
        if (r12 != 0) goto L_0x0b1b;
    L_0x0b00:
        r12 = r39.getName();	 Catch:{ Exception -> 0x0b1f }
        r13 = "reboot";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0b1f }
        if (r12 != 0) goto L_0x0b1b;
    L_0x0b0c:
        r12 = r39.getName();	 Catch:{ Exception -> 0x0b1f }
        r13 = "dalvikvm";
        r12 = r12.equals(r13);	 Catch:{ Exception -> 0x0b1f }
        if (r12 != 0) goto L_0x0b1b;
    L_0x0b18:
        r39.delete();	 Catch:{ Exception -> 0x0b1f }
    L_0x0b1b:
        r9 = r9 + 1;
        goto L_0x005c;
    L_0x0b1f:
        r35 = move-exception;
        r35.printStackTrace();
        goto L_0x005e;
    L_0x0b25:
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
        goto L_0x09f0;
    L_0x0b71:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0b7c:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r11 != 0) goto L_0x0d79;
    L_0x0b82:
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = 1;
        r57 = com.chelpus.Utils.getPlaceForOdex(r9, r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r56 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r56.<init>(r57);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r56.exists();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0b98;
    L_0x0b95:
        r56.delete();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0b98:
        r56 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "-1";
        r11 = "-2";
        r0 = r57;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r56;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r56.exists();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0bb2;
    L_0x0baf:
        r56.delete();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0bb2:
        r56 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "-2";
        r11 = "-1";
        r0 = r57;
        r9 = r0.replace(r9, r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r56;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r56.exists();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0bcc;
    L_0x0bc9:
        r56.delete();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0bcc:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r80 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0bd2:
        r9 = r80.hasNext();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0a87;
    L_0x0bd8:
        r41 = r80.next();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r41 = (java.io.File) r41;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "Find string id.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r76 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r76.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "com.android.vending";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "SHA1withRSA";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "com.android.vending.billing.InAppBillingService.BIND";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "Ljava/security/Signature;";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "verify";
        r0 = r76;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "String analysis.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "String analysis.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r41.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = 0;
        r0 = r76;
        r59 = com.chelpus.Utils.getStringIds(r9, r0, r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r36 = 0;
        r37 = 0;
        r38 = 0;
        r58 = 1;
        r27 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r27.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = new com.android.vending.billing.InAppBillingService.LOCK.CommandItem;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "Ljava/security/Signature;";
        r12 = "verify";
        r9.<init>(r11, r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r27;
        r0.add(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = r59.iterator();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0c41:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 != 0) goto L_0x0e7d;
    L_0x0c47:
        r62 = 0;
        r63 = 1;
        if (r36 == 0) goto L_0x0c4f;
    L_0x0c4d:
        if (r37 != 0) goto L_0x0c63;
    L_0x0c4f:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0c63:
        if (r38 != 0) goto L_0x0c83;
    L_0x0c65:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 4;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = 0;
        r9.pattern = r11;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0c83:
        r9 = "Parse data for patch.";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = print;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "Parse data for patch.";
        r9.println(r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r41.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = 0;
        r12 = 0;
        r0 = r27;
        com.chelpus.Utils.getMethodsIds(r9, r0, r11, r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 0;
        r0 = r27;
        r9 = r0.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.index_command;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 0;
        r9 = r9[r12];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = java.lang.Integer.toHexString(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11.println(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 0;
        r0 = r27;
        r9 = r0.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.index_command;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 1;
        r9 = r9[r12];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = java.lang.Integer.toHexString(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11.println(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = r27.iterator();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0ccc:
        r9 = r11.hasNext();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 != 0) goto L_0x0fc3;
    L_0x0cd2:
        r9 = r2.size();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = new com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r61 = r0;
        r77 = 0;
        r9 = r2.iterator();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0ce0:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r11 != 0) goto L_0x1010;
    L_0x0ce6:
        r78 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "rw";
        r0 = r41;
        r9.<init>(r0, r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r10 = r9.getChannel();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = "Size file:";
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = r10.size();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 0;
        r14 = r10.size();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (int) r14;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = (long) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r40 = r10.map(r11, r12, r14);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
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
    L_0x0d31:
        r9 = r40.hasRemaining();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x101c;
    L_0x0d37:
        r10.close();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = r12 - r78;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = r9.append(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = "Analise Results:";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        goto L_0x0bd2;
    L_0x0d5a:
        r35 = move-exception;
        r9 = new java.lang.StringBuilder;
        r11 = "Exception e";
        r9.<init>(r11);
        r11 = r35.toString();
        r9 = r9.append(r11);
        r9 = r9.toString();
        com.chelpus.Utils.sendFromRoot(r9);
        r35.printStackTrace();
        r35.printStackTrace();
        goto L_0x0a87;
    L_0x0d79:
        r26 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r26 = (java.io.File) r26;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = r26.exists();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r11 != 0) goto L_0x0d8b;
    L_0x0d85:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0d8b:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r26;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        goto L_0x0b7c;
    L_0x0d94:
        r9 = createAPK;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0e06;
    L_0x0d98:
        r9 = 0;
        r60 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 5;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        unzipSD(r16);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = sddir;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = java.lang.String.valueOf(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11.<init>(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = "/Modified/";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r60;
        r11 = r11.append(r0);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = ".apk";
        r11 = r11.append(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = r11.toString();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>(r11);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        crkapk = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = crkapk;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r16;
        com.chelpus.Utils.copyFile(r0, r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0def;
    L_0x0de7:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 != 0) goto L_0x0df5;
    L_0x0def:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0df5:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0e00:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r11 != 0) goto L_0x0e38;
    L_0x0e06:
        r9 = ART;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0bcc;
    L_0x0e0a:
        r9 = 0;
        r60 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 2;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        appdir = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 3;
        r9 = r81[r9];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        sddir = r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        clearTempSD();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r16 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = appdir;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r16;
        r0.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        unzipART(r16);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0e32;
    L_0x0e2a:
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.size();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 != 0) goto L_0x0e52;
    L_0x0e32:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0e38:
        r26 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r26 = (java.io.File) r26;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = r26.exists();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r11 != 0) goto L_0x0e4a;
    L_0x0e44:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0e4a:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r26;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        goto L_0x0e00;
    L_0x0e52:
        r9 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.clear();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = classesFiles;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.iterator();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0e5d:
        r11 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r11 == 0) goto L_0x0bcc;
    L_0x0e63:
        r26 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r26 = (java.io.File) r26;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r11 = r26.exists();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r11 != 0) goto L_0x0e75;
    L_0x0e6f:
        r9 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        throw r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0e75:
        r11 = filestopatch;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r26;
        r11.add(r0);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        goto L_0x0e5d;
    L_0x0e7d:
        r46 = r11.next();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r46 = (com.android.vending.billing.InAppBillingService.LOCK.StringItem) r46;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r27.iterator();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0e87:
        r12 = r9.hasNext();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r12 != 0) goto L_0x0f8f;
    L_0x0e8d:
        r0 = r46;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = "com.android.vending.billing.InAppBillingService.BIND";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0f0d;
    L_0x0e99:
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 2;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 0;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 3;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 2;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 3;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 4;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 1;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 5;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r37 = 0;
    L_0x0f0d:
        r0 = r46;
        r9 = r0.str;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = "SHA1withRSA";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0c41;
    L_0x0f19:
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 2;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 2;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 3;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 2;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 3;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 4;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 2;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 3;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 5;
        r0 = r46;
        r13 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 3;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r38 = 1;
        goto L_0x0c41;
    L_0x0f8f:
        r47 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r47 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r47;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r47;
        r12 = r0.object;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r46;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r12 == 0) goto L_0x0fab;
    L_0x0fa3:
        r0 = r46;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r47;
        r0.Object = r12;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
    L_0x0fab:
        r0 = r47;
        r12 = r0.method;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r46;
        r13 = r0.str;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = r12.equals(r13);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r12 == 0) goto L_0x0e87;
    L_0x0fb9:
        r0 = r46;
        r12 = r0.offset;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r47;
        r0.Method = r12;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        goto L_0x0e87;
    L_0x0fc3:
        r47 = r11.next();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r47 = (com.android.vending.billing.InAppBillingService.LOCK.CommandItem) r47;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r47;
        r9 = r0.found_index_command;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0ccc;
    L_0x0fcf:
        r0 = r47;
        r9 = r0.object;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = "Ljava/security/Signature;";
        r9 = r9.equals(r12);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        if (r9 == 0) goto L_0x0ccc;
    L_0x0fdb:
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 2;
        r0 = r47;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 0;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.origByte;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 3;
        r0 = r47;
        r13 = r0.index_command;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r14 = 1;
        r13 = r13[r14];	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9[r12] = r13;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = 11;
        r9 = r2.get(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r9;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r12 = 1;
        r9.pattern = r12;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        goto L_0x0ccc;
    L_0x1010:
        r47 = r9.next();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r47 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r47;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r61[r77] = r47;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r77 = r77 + 1;
        goto L_0x0ce0;
    L_0x101c:
        r9 = createAPK;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x1045;
    L_0x1020:
        r9 = r40.position();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9 - r65;
        r11 = 149999; // 0x249ef float:2.10193E-40 double:7.41094E-319;
        if (r9 <= r11) goto L_0x1045;
    L_0x102b:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = "Progress size:";
        r9.<init>(r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r40.position();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9.append(r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9.toString();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r65 = r40.position();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1045:
        r30 = r40.position();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r29 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r49 != 0) goto L_0x1051;
    L_0x104f:
        if (r50 == 0) goto L_0x1053;
    L_0x1051:
        r31 = r31 + 1;
    L_0x1053:
        r9 = 380; // 0x17c float:5.32E-43 double:1.877E-321;
        r0 = r31;
        if (r0 <= r9) goto L_0x105d;
    L_0x1059:
        r49 = 0;
        r31 = 0;
    L_0x105d:
        r9 = 0;
        r9 = r18[r9];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r29;
        if (r0 != r9) goto L_0x108f;
    L_0x1064:
        r9 = pattern1;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 == 0) goto L_0x108f;
    L_0x1068:
        r9 = 0;
        r9 = r69[r9];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x1070;
    L_0x106d:
        r9 = 0;
        r21[r9] = r29;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1070:
        r44 = 1;
        r25 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r24 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r73 = 0;
        r72 = 0;
    L_0x1085:
        r9 = r18[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r67;
        if (r0 == r9) goto L_0x111c;
    L_0x108b:
        r9 = r51[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x111c;
    L_0x108f:
        r54 = new java.util.ArrayList;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r54.<init>();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r55 = new java.util.ArrayList;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r55.<init>();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r45 = 0;
        r17 = 0;
    L_0x109d:
        r0 = r61;
        r9 = r0.length;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r17;
        if (r0 < r9) goto L_0x118d;
    L_0x10a4:
        r9 = 0;
        r9 = r19[r9];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r29;
        if (r0 != r9) goto L_0x10cf;
    L_0x10ab:
        r9 = pattern4;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 == 0) goto L_0x10cf;
    L_0x10af:
        r9 = 0;
        r9 = r70[r9];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x10b7;
    L_0x10b4:
        r9 = 0;
        r22[r9] = r29;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x10b7:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x10c4:
        r9 = r19[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r67;
        if (r0 == r9) goto L_0x16ca;
    L_0x10ca:
        r9 = r52[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 1;
        if (r9 == r11) goto L_0x16ca;
    L_0x10cf:
        r9 = 16;
        r0 = r29;
        if (r0 >= r9) goto L_0x10fb;
    L_0x10d5:
        if (r49 == 0) goto L_0x10fb;
    L_0x10d7:
        r9 = pattern4;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 == 0) goto L_0x10fb;
    L_0x10db:
        r9 = 0;
        r9 = r71[r9];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x10e3;
    L_0x10e0:
        r9 = 0;
        r23[r9] = r29;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x10e3:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x10f0:
        r9 = r20[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r67;
        if (r0 == r9) goto L_0x16e7;
    L_0x10f6:
        r9 = r53[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 1;
        if (r9 == r11) goto L_0x16e7;
    L_0x10fb:
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x0d31;
    L_0x1104:
        r35 = move-exception;
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r0 = r35;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        r35.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0a7e, Exception -> 0x0d5a }
        goto L_0x0d37;
    L_0x111c:
        r9 = r69[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 2;
        if (r9 != r11) goto L_0x1135;
    L_0x1121:
        r9 = r40.position();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9 + 7;
        r0 = r40;
        r9 = r0.get(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r67;
        if (r0 != r9) goto L_0x1135;
    L_0x1131:
        r24 = r44;
        r73 = r67;
    L_0x1135:
        r9 = r69[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 == 0) goto L_0x113e;
    L_0x1139:
        r9 = r69[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 2;
        if (r9 != r11) goto L_0x1140;
    L_0x113e:
        r21[r44] = r67;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1140:
        r9 = r69[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 3;
        if (r9 != r11) goto L_0x1149;
    L_0x1145:
        r72 = r67;
        r25 = r44;
    L_0x1149:
        r44 = r44 + 1;
        r0 = r18;
        r9 = r0.length;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r44;
        if (r0 != r9) goto L_0x1187;
    L_0x1152:
        r9 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r25;
        if (r0 >= r9) goto L_0x108f;
    L_0x1158:
        if (r72 == 0) goto L_0x108f;
    L_0x115a:
        r21[r25] = r73;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r24 + 7;
        r11 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r9 >= r11) goto L_0x108f;
    L_0x1162:
        if (r73 == 0) goto L_0x108f;
    L_0x1164:
        r9 = r24 + 8;
        r21[r9] = r72;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r40;
        r1 = r21;
        r0.put(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r40.force();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = "lvl patch N1!\n";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = print;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = "lvl patch N1!\n";
        r9.print(r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x108f;
    L_0x1187:
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x1085;
    L_0x118d:
        r64 = r61[r17];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 == 0) goto L_0x122f;
    L_0x119c:
        r9 = 5;
        r0 = r17;
        if (r0 == r9) goto L_0x11bd;
    L_0x11a1:
        r9 = 6;
        r0 = r17;
        if (r0 == r9) goto L_0x11bd;
    L_0x11a6:
        r9 = 7;
        r0 = r17;
        if (r0 == r9) goto L_0x11bd;
    L_0x11ab:
        r9 = 8;
        r0 = r17;
        if (r0 == r9) goto L_0x11bd;
    L_0x11b1:
        r9 = 9;
        r0 = r17;
        if (r0 == r9) goto L_0x11bd;
    L_0x11b7:
        r9 = 10;
        r0 = r17;
        if (r0 != r9) goto L_0x122f;
    L_0x11bd:
        if (r45 != 0) goto L_0x11c3;
    L_0x11bf:
        r75 = r75 + 1;
        r45 = 1;
    L_0x11c3:
        r0 = r75;
        r1 = r34;
        if (r0 >= r1) goto L_0x1434;
    L_0x11c9:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r29;
        if (r0 != r9) goto L_0x1228;
    L_0x11d4:
        r54.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r55.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x11ea;
    L_0x11e3:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9[r11] = r29;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x11ea:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x11f7:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r67;
        if (r0 == r9) goto L_0x131e;
    L_0x1201:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 1;
        if (r9 == r11) goto L_0x131e;
    L_0x120a:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 20;
        if (r9 == r11) goto L_0x131e;
    L_0x1214:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 21;
        if (r9 == r11) goto L_0x131e;
    L_0x121e:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 == r11) goto L_0x131e;
    L_0x1228:
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x122f:
        r0 = r64;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 == 0) goto L_0x12a8;
    L_0x1235:
        r9 = 4;
        r0 = r17;
        if (r0 != r9) goto L_0x12a8;
    L_0x123a:
        r74 = r74 + 1;
        r0 = r74;
        r1 = r33;
        if (r0 >= r1) goto L_0x157e;
    L_0x1242:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r29;
        if (r0 != r9) goto L_0x12a1;
    L_0x124d:
        r54.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r55.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x1263;
    L_0x125c:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9[r11] = r29;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1263:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1270:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r67;
        if (r0 == r9) goto L_0x1468;
    L_0x127a:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 1;
        if (r9 == r11) goto L_0x1468;
    L_0x1283:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 20;
        if (r9 == r11) goto L_0x1468;
    L_0x128d:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 21;
        if (r9 == r11) goto L_0x1468;
    L_0x1297:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 == r11) goto L_0x1468;
    L_0x12a1:
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x12a8:
        r0 = r64;
        r9 = r0.markerTrig;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x131a;
    L_0x12ae:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r29;
        if (r0 != r9) goto L_0x131a;
    L_0x12b9:
        r0 = r64;
        r9 = r0.pattern;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 == 0) goto L_0x131a;
    L_0x12bf:
        r54.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r55.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9 = r9[r11];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x12d5;
    L_0x12ce:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 0;
        r9[r11] = r29;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x12d5:
        r44 = 1;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x12e2:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r67;
        if (r0 == r9) goto L_0x15b2;
    L_0x12ec:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 1;
        if (r9 == r11) goto L_0x15b2;
    L_0x12f5:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 20;
        if (r9 == r11) goto L_0x15b2;
    L_0x12ff:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 21;
        if (r9 == r11) goto L_0x15b2;
    L_0x1309:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 == r11) goto L_0x15b2;
    L_0x1313:
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x131a:
        r17 = r17 + 1;
        goto L_0x109d;
    L_0x131e:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x132c;
    L_0x1326:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r67;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x132c:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 20;
        if (r9 != r11) goto L_0x133f;
    L_0x1336:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r67 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x133f:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 21;
        if (r9 != r11) goto L_0x1354;
    L_0x1349:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r67 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1354:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 != r11) goto L_0x136d;
    L_0x135e:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = java.lang.Byte.valueOf(r67);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r54;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x136d:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 != r11) goto L_0x1386;
    L_0x1377:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = java.lang.Integer.valueOf(r44);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r55;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1386:
        r44 = r44 + 1;
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9.length;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r44;
        if (r0 != r9) goto L_0x142e;
    L_0x1391:
        r9 = r54.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 > 0) goto L_0x139d;
    L_0x1397:
        r9 = r55.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 <= 0) goto L_0x13ad;
    L_0x139d:
        r68 = 0;
    L_0x139f:
        r9 = r54.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r68;
        if (r0 < r9) goto L_0x13ef;
    L_0x13a7:
        r54.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r55.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x13ad:
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r40;
        r0.put(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r40.force();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = print;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9.println(r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = 1;
        r0 = r64;
        r0.result = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = 0;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x13de:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 != 0) goto L_0x1414;
    L_0x13e4:
        r75 = 0;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x1228;
    L_0x13ef:
        r0 = r64;
        r11 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r55;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = (java.lang.Integer) r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r12 = r9.intValue();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r54;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = (java.lang.Byte) r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9.byteValue();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11[r12] = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r68 = r68 + 1;
        goto L_0x139f;
    L_0x1414:
        r32 = r9.next();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 == 0) goto L_0x13de;
    L_0x1428:
        r11 = 0;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x13de;
    L_0x142e:
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x11f7;
    L_0x1434:
        r9 = 0;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x143d:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 != 0) goto L_0x144e;
    L_0x1443:
        r75 = 0;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x122f;
    L_0x144e:
        r32 = r9.next();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 == 0) goto L_0x143d;
    L_0x1462:
        r11 = 0;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x143d;
    L_0x1468:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x1476;
    L_0x1470:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r67;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1476:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 20;
        if (r9 != r11) goto L_0x1489;
    L_0x1480:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r67 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1489:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 21;
        if (r9 != r11) goto L_0x149e;
    L_0x1493:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r67 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x149e:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 != r11) goto L_0x14b7;
    L_0x14a8:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = java.lang.Byte.valueOf(r67);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r54;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x14b7:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 != r11) goto L_0x14d0;
    L_0x14c1:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = java.lang.Integer.valueOf(r44);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r55;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x14d0:
        r44 = r44 + 1;
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9.length;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r44;
        if (r0 != r9) goto L_0x1578;
    L_0x14db:
        r9 = r54.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 > 0) goto L_0x14e7;
    L_0x14e1:
        r9 = r55.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 <= 0) goto L_0x14f7;
    L_0x14e7:
        r68 = 0;
    L_0x14e9:
        r9 = r54.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r68;
        if (r0 < r9) goto L_0x1539;
    L_0x14f1:
        r54.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r55.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x14f7:
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r40;
        r0.put(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r40.force();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = print;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9.println(r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = 1;
        r0 = r64;
        r0.result = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = 0;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1528:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 != 0) goto L_0x155e;
    L_0x152e:
        r74 = 0;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x12a1;
    L_0x1539:
        r0 = r64;
        r11 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r55;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = (java.lang.Integer) r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r12 = r9.intValue();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r54;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = (java.lang.Byte) r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9.byteValue();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11[r12] = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r68 = r68 + 1;
        goto L_0x14e9;
    L_0x155e:
        r32 = r9.next();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 == 0) goto L_0x1528;
    L_0x1572:
        r11 = 0;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x1528;
    L_0x1578:
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x1270;
    L_0x157e:
        r9 = 0;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1587:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 != 0) goto L_0x1598;
    L_0x158d:
        r74 = 0;
        r9 = r30 + 1;
        r0 = r40;
        r0.position(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x12a8;
    L_0x1598:
        r32 = r9.next();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 == 0) goto L_0x1587;
    L_0x15ac:
        r11 = 0;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x1587;
    L_0x15b2:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x15c0;
    L_0x15ba:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r67;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x15c0:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 20;
        if (r9 != r11) goto L_0x15d3;
    L_0x15ca:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r67 & 15;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x15d3:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 21;
        if (r9 != r11) goto L_0x15e8;
    L_0x15dd:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r67 & 15;
        r11 = r11 + 16;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9[r44] = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x15e8:
        r0 = r64;
        r9 = r0.origMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 != r11) goto L_0x1601;
    L_0x15f2:
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = java.lang.Byte.valueOf(r67);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r54;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1601:
        r0 = r64;
        r9 = r0.repMask;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = 23;
        if (r9 != r11) goto L_0x161a;
    L_0x160b:
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = java.lang.Integer.valueOf(r44);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r55;
        r0.add(r9, r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x161a:
        r44 = r44 + 1;
        r0 = r64;
        r9 = r0.origByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9.length;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r44;
        if (r0 != r9) goto L_0x16c4;
    L_0x1625:
        r9 = r54.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 > 0) goto L_0x1631;
    L_0x162b:
        r9 = r55.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 <= 0) goto L_0x1641;
    L_0x1631:
        r68 = 0;
    L_0x1633:
        r9 = r54.size();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r68;
        if (r0 < r9) goto L_0x169e;
    L_0x163b:
        r54.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r55.clear();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x1641:
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r40;
        r0.put(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r40.force();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.resultText;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = print;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r11 = r0.resultText;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9.println(r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = 1;
        r0 = r64;
        r0.result = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r9 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = "";
        r9 = r9.equals(r11);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x1313;
    L_0x1675:
        r9 = 1;
        r0 = r64;
        r0.markerTrig = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x167e:
        r11 = r9.hasNext();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 == 0) goto L_0x1313;
    L_0x1684:
        r32 = r9.next();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r32 = (com.android.vending.billing.InAppBillingService.LOCK.PatchesItemAuto) r32;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r32;
        r11 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r64;
        r12 = r0.marker;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11 = r11.equals(r12);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r11 == 0) goto L_0x167e;
    L_0x1698:
        r11 = 1;
        r0 = r32;
        r0.markerTrig = r11;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x167e;
    L_0x169e:
        r0 = r64;
        r11 = r0.repByte;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r55;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = (java.lang.Integer) r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r12 = r9.intValue();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r54;
        r1 = r68;
        r9 = r0.get(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = (java.lang.Byte) r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = r9.byteValue();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r11[r12] = r9;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r68 = r68 + 1;
        goto L_0x1633;
    L_0x16c4:
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x12e2;
    L_0x16ca:
        r9 = r70[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x16d0;
    L_0x16ce:
        r22[r44] = r67;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x16d0:
        r44 = r44 + 1;
        r0 = r19;
        r9 = r0.length;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r44;
        if (r0 != r9) goto L_0x16e1;
    L_0x16d9:
        r30 = r40.position();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r49 = 1;
        goto L_0x10cf;
    L_0x16e1:
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x10c4;
    L_0x16e7:
        r9 = r71[r44];	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        if (r9 != 0) goto L_0x16ed;
    L_0x16eb:
        r23[r44] = r67;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
    L_0x16ed:
        r44 = r44 + 1;
        r0 = r20;
        r9 = r0.length;	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r44;
        if (r0 != r9) goto L_0x1710;
    L_0x16f6:
        r0 = r40;
        r1 = r30;
        r0.position(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r0 = r40;
        r1 = r23;
        r0.put(r1);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r40.force();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r9 = "lvl patch N5!\n";
        com.chelpus.Utils.sendFromRoot(r9);	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        r49 = 0;
        goto L_0x10fb;
    L_0x1710:
        r67 = r40.get();	 Catch:{ Exception -> 0x1104, FileNotFoundException -> 0x0a7e }
        goto L_0x10f0;
    L_0x1716:
        r42 = r9.next();
        r42 = (java.io.File) r42;
        com.chelpus.Utils.fixadler(r42);
        clearTempSD();
        goto L_0x0a8d;
    L_0x1724:
        r9 = move-exception;
        goto L_0x011b;
    L_0x1727:
        r9 = move-exception;
        goto L_0x011b;
    L_0x172a:
        r9 = move-exception;
        goto L_0x010d;
    L_0x172d:
        r9 = move-exception;
        goto L_0x010d;
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
            Utils.sendFromRoot(e.toString());
        }
    }
}
