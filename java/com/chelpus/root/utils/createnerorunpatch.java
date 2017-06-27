package com.chelpus.root.utils;

import java.io.File;

public class createnerorunpatch {
    public static File classes;
    public static File crkapk;
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
    public static String sddir = "/sdcard/";
    public static String tooldir = "/sdcard/";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r59) {
        /*
        r3 = new com.chelpus.root.utils.createnerorunpatch$1;
        r3.<init>();
        com.chelpus.Utils.startRootJava(r3);
        r3 = 2;
        r3 = r59[r3];
        sddir = r3;
        r3 = 3;
        r3 = r59[r3];
        tooldir = r3;
        r3 = 24;
        r8 = new byte[r3];
        r3 = 0;
        r4 = 18;
        r8[r3] = r4;
        r3 = 1;
        r4 = 36;
        r8[r3] = r4;
        r3 = 2;
        r4 = 18;
        r8[r3] = r4;
        r3 = 3;
        r4 = 19;
        r8[r3] = r4;
        r3 = 4;
        r4 = 18;
        r8[r3] = r4;
        r3 = 5;
        r4 = 2;
        r8[r3] = r4;
        r3 = 6;
        r4 = 34;
        r8[r3] = r4;
        r3 = 8;
        r4 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r8[r3] = r4;
        r3 = 10;
        r4 = 26;
        r8[r3] = r4;
        r3 = 11;
        r4 = 1;
        r8[r3] = r4;
        r3 = 12;
        r4 = 1;
        r8[r3] = r4;
        r3 = 13;
        r4 = 1;
        r8[r3] = r4;
        r3 = 14;
        r4 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r8[r3] = r4;
        r3 = 15;
        r4 = 48;
        r8[r3] = r4;
        r3 = 16;
        r4 = 61;
        r8[r3] = r4;
        r3 = 17;
        r4 = 1;
        r8[r3] = r4;
        r3 = 18;
        r4 = 16;
        r8[r3] = r4;
        r3 = 19;
        r4 = 2;
        r8[r3] = r4;
        r3 = 20;
        r4 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r8[r3] = r4;
        r3 = 22;
        r4 = 76;
        r8[r3] = r4;
        r3 = 24;
        r0 = new byte[r3];
        r32 = r0;
        r3 = 1;
        r4 = 1;
        r32[r3] = r4;
        r3 = 3;
        r4 = 1;
        r32[r3] = r4;
        r3 = 5;
        r4 = 1;
        r32[r3] = r4;
        r3 = 6;
        r4 = 1;
        r32[r3] = r4;
        r3 = 7;
        r4 = 1;
        r32[r3] = r4;
        r3 = 8;
        r4 = 1;
        r32[r3] = r4;
        r3 = 9;
        r4 = 1;
        r32[r3] = r4;
        r3 = 11;
        r4 = 1;
        r32[r3] = r4;
        r3 = 12;
        r4 = 1;
        r32[r3] = r4;
        r3 = 13;
        r4 = 1;
        r32[r3] = r4;
        r3 = 16;
        r4 = 1;
        r32[r3] = r4;
        r3 = 17;
        r4 = 1;
        r32[r3] = r4;
        r3 = 18;
        r4 = 1;
        r32[r3] = r4;
        r3 = 19;
        r4 = 1;
        r32[r3] = r4;
        r3 = 22;
        r4 = 5;
        r32[r3] = r4;
        r3 = 23;
        r4 = 5;
        r32[r3] = r4;
        r3 = 8;
        r10 = new byte[r3];
        r10 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r34 = r0;
        r3 = 1;
        r4 = 1;
        r34[r3] = r4;
        r3 = 5;
        r4 = 1;
        r34[r3] = r4;
        r3 = 6;
        r4 = 1;
        r34[r3] = r4;
        r3 = 7;
        r4 = 1;
        r34[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r18 = r0;
        r3 = 0;
        r4 = 16;
        r18[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r51 = r0;
        r3 = 4;
        r4 = 1;
        r51[r3] = r4;
        r3 = 5;
        r4 = 1;
        r51[r3] = r4;
        r3 = 6;
        r4 = 1;
        r51[r3] = r4;
        r3 = 7;
        r4 = 1;
        r51[r3] = r4;
        r3 = 8;
        r11 = new byte[r3];
        r11 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r35 = r0;
        r3 = 1;
        r4 = 1;
        r35[r3] = r4;
        r3 = 5;
        r4 = 1;
        r35[r3] = r4;
        r3 = 6;
        r4 = 1;
        r35[r3] = r4;
        r3 = 7;
        r4 = 1;
        r35[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r19 = r0;
        r3 = 0;
        r4 = 16;
        r19[r3] = r4;
        r3 = 4;
        r4 = 41;
        r19[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r52 = r0;
        r3 = 4;
        r4 = 1;
        r52[r3] = r4;
        r3 = 5;
        r4 = 1;
        r52[r3] = r4;
        r3 = 8;
        r12 = new byte[r3];
        r12 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r36 = r0;
        r3 = 1;
        r4 = 1;
        r36[r3] = r4;
        r3 = 5;
        r4 = 1;
        r36[r3] = r4;
        r3 = 6;
        r4 = 1;
        r36[r3] = r4;
        r3 = 7;
        r4 = 1;
        r36[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r20 = r0;
        r3 = 0;
        r4 = 16;
        r20[r3] = r4;
        r3 = 4;
        r4 = 41;
        r20[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r53 = r0;
        r3 = 4;
        r4 = 1;
        r53[r3] = r4;
        r3 = 5;
        r4 = 1;
        r53[r3] = r4;
        r3 = 8;
        r13 = new byte[r3];
        r13 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r37 = r0;
        r3 = 1;
        r4 = 1;
        r37[r3] = r4;
        r3 = 5;
        r4 = 1;
        r37[r3] = r4;
        r3 = 6;
        r4 = 1;
        r37[r3] = r4;
        r3 = 7;
        r4 = 1;
        r37[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r21 = r0;
        r3 = 0;
        r4 = 16;
        r21[r3] = r4;
        r3 = 4;
        r4 = 41;
        r21[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r54 = r0;
        r3 = 4;
        r4 = 1;
        r54[r3] = r4;
        r3 = 5;
        r4 = 1;
        r54[r3] = r4;
        r3 = 8;
        r14 = new byte[r3];
        r14 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r38 = r0;
        r3 = 1;
        r4 = 1;
        r38[r3] = r4;
        r3 = 5;
        r4 = 1;
        r38[r3] = r4;
        r3 = 6;
        r4 = 1;
        r38[r3] = r4;
        r3 = 7;
        r4 = 1;
        r38[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r22 = r0;
        r3 = 0;
        r4 = 16;
        r22[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r55 = r0;
        r3 = 4;
        r4 = 1;
        r55[r3] = r4;
        r3 = 5;
        r4 = 1;
        r55[r3] = r4;
        r3 = 6;
        r4 = 1;
        r55[r3] = r4;
        r3 = 7;
        r4 = 1;
        r55[r3] = r4;
        r3 = 8;
        r15 = new byte[r3];
        r15 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r39 = r0;
        r3 = 1;
        r4 = 1;
        r39[r3] = r4;
        r3 = 5;
        r4 = 1;
        r39[r3] = r4;
        r3 = 6;
        r4 = 1;
        r39[r3] = r4;
        r3 = 7;
        r4 = 1;
        r39[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r23 = r0;
        r3 = 0;
        r4 = 16;
        r23[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r56 = r0;
        r3 = 4;
        r4 = 1;
        r56[r3] = r4;
        r3 = 5;
        r4 = 1;
        r56[r3] = r4;
        r3 = 6;
        r4 = 1;
        r56[r3] = r4;
        r3 = 7;
        r4 = 1;
        r56[r3] = r4;
        r3 = 16;
        r0 = new byte[r3];
        r16 = r0;
        r16 = {98, 3, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 56, -1, -1, -1};
        r3 = 16;
        r0 = new byte[r3];
        r40 = r0;
        r3 = 1;
        r4 = 1;
        r40[r3] = r4;
        r3 = 4;
        r4 = 1;
        r40[r3] = r4;
        r3 = 5;
        r4 = 1;
        r40[r3] = r4;
        r3 = 6;
        r4 = 1;
        r40[r3] = r4;
        r3 = 7;
        r4 = 1;
        r40[r3] = r4;
        r3 = 8;
        r4 = 1;
        r40[r3] = r4;
        r3 = 9;
        r4 = 1;
        r40[r3] = r4;
        r3 = 11;
        r4 = 1;
        r40[r3] = r4;
        r3 = 13;
        r4 = 1;
        r40[r3] = r4;
        r3 = 14;
        r4 = 1;
        r40[r3] = r4;
        r3 = 15;
        r4 = 1;
        r40[r3] = r4;
        r3 = 16;
        r0 = new byte[r3];
        r24 = r0;
        r3 = 0;
        r4 = 16;
        r24[r3] = r4;
        r3 = 16;
        r0 = new byte[r3];
        r57 = r0;
        r3 = 12;
        r4 = 1;
        r57[r3] = r4;
        r3 = 13;
        r4 = 1;
        r57[r3] = r4;
        r3 = 14;
        r4 = 1;
        r57[r3] = r4;
        r3 = 15;
        r4 = 1;
        r57[r3] = r4;
        r3 = 16;
        r9 = new byte[r3];
        r9 = {98, 3, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 57, -1, -1, -1};
        r3 = 16;
        r0 = new byte[r3];
        r33 = r0;
        r3 = 1;
        r4 = 1;
        r33[r3] = r4;
        r3 = 4;
        r4 = 1;
        r33[r3] = r4;
        r3 = 5;
        r4 = 1;
        r33[r3] = r4;
        r3 = 6;
        r4 = 1;
        r33[r3] = r4;
        r3 = 7;
        r4 = 1;
        r33[r3] = r4;
        r3 = 8;
        r4 = 1;
        r33[r3] = r4;
        r3 = 9;
        r4 = 1;
        r33[r3] = r4;
        r3 = 11;
        r4 = 1;
        r33[r3] = r4;
        r3 = 13;
        r4 = 1;
        r33[r3] = r4;
        r3 = 14;
        r4 = 1;
        r33[r3] = r4;
        r3 = 15;
        r4 = 1;
        r33[r3] = r4;
        r3 = 16;
        r0 = new byte[r3];
        r17 = r0;
        r3 = 0;
        r4 = 16;
        r17[r3] = r4;
        r3 = 12;
        r4 = 41;
        r17[r3] = r4;
        r3 = 16;
        r0 = new byte[r3];
        r50 = r0;
        r3 = 12;
        r4 = 1;
        r50[r3] = r4;
        r3 = 13;
        r4 = 1;
        r50[r3] = r4;
        r3 = dalvikDexIn;
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r59[r5];
        r3.replace(r4, r5);
        r3 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r5 = sddir;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r5 = "/Modified/classes.dex";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        classes = r3;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r3 = classes;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r3 = r3.exists();	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        if (r3 != 0) goto L_0x03cf;
    L_0x0331:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        throw r3;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
    L_0x0337:
        r31 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
    L_0x033f:
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r5 = " ";
        r4.<init>(r5);
        r5 = 2;
        r5 = r10[r5];
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        r3 = 1;
        r3 = r59[r3];
        r4 = "object";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x03cb;
    L_0x0361:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = classes;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r5 = "rw";
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r29 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r43 = 0;
        r44 = 0;
        r45 = 0;
        r46 = 0;
        r47 = 0;
        r48 = 0;
        r27 = 0;
        r26 = -1;
    L_0x038c:
        r3 = r29.hasRemaining();	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x050a;
    L_0x0392:
        r2.close();	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        if (r44 != 0) goto L_0x039e;
    L_0x0397:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = "Error: License Key2 patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
    L_0x039e:
        if (r45 != 0) goto L_0x03a7;
    L_0x03a0:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = "Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
    L_0x03a7:
        if (r46 != 0) goto L_0x03b0;
    L_0x03a9:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = "Error: Check License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
    L_0x03b0:
        if (r47 != 0) goto L_0x03b9;
    L_0x03b2:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
    L_0x03b9:
        if (r48 != 0) goto L_0x03c2;
    L_0x03bb:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
    L_0x03c2:
        if (r43 != 0) goto L_0x03cb;
    L_0x03c4:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = "Error: Cached License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
    L_0x03cb:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x03cf:
        r43 = 0;
        r58 = 1;
        r27 = 0;
        r41 = 0;
        r42 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = 1;
        r3 = r59[r3];	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = "object";
        r3 = r3.contains(r4);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        if (r3 == 0) goto L_0x03f3;
    L_0x03e4:
        r3 = 1;
        r3 = r59[r3];	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = "object";
        r5 = "";
        r3 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r42 = java.lang.Integer.parseInt(r3);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
    L_0x03f3:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = classes;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r5 = "rw";
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r29 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r26 = -1;
    L_0x0410:
        r3 = r29.hasRemaining();	 Catch:{ Exception -> 0x0507 }
        if (r3 == 0) goto L_0x041c;
    L_0x0416:
        r0 = r41;
        r1 = r42;
        if (r0 < r1) goto L_0x045d;
    L_0x041c:
        r2.close();	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r5 = "{\"objects\":\"";
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r0 = r41;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r5 = "\"}";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        if (r43 != 0) goto L_0x033f;
    L_0x043d:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        r4 = "Error: Objects not Found!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0337, IOException -> 0x0446 }
        goto L_0x033f;
    L_0x0446:
        r31 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r31;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x033f;
    L_0x045d:
        r58 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0507 }
        r27 = r29.position();	 Catch:{ Exception -> 0x0507 }
        r26 = r29.get();	 Catch:{ Exception -> 0x0507 }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x0507 }
        r0 = r26;
        if (r0 != r3) goto L_0x0410;
    L_0x0475:
        r30 = 1;
        r25 = 2;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0507 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0507 }
    L_0x0484:
        if (r58 == 0) goto L_0x0410;
    L_0x0486:
        r3 = r8[r30];	 Catch:{ Exception -> 0x0507 }
        r0 = r49;
        if (r0 == r3) goto L_0x0496;
    L_0x048c:
        r3 = r32[r30];	 Catch:{ Exception -> 0x0507 }
        r4 = 1;
        if (r3 == r4) goto L_0x0496;
    L_0x0491:
        r3 = r32[r30];	 Catch:{ Exception -> 0x0507 }
        r4 = 5;
        if (r3 != r4) goto L_0x0410;
    L_0x0496:
        r3 = r32[r30];	 Catch:{ Exception -> 0x0507 }
        r4 = 5;
        if (r3 != r4) goto L_0x04be;
    L_0x049b:
        r10[r25] = r49;	 Catch:{ Exception -> 0x0507 }
        r13[r25] = r49;	 Catch:{ Exception -> 0x0507 }
        r16[r25] = r49;	 Catch:{ Exception -> 0x0507 }
        r9[r25] = r49;	 Catch:{ Exception -> 0x0507 }
        r3 = 2;
        r0 = r25;
        if (r0 != r3) goto L_0x04fe;
    L_0x04a8:
        r3 = r49 + 1;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0507 }
        r11[r25] = r3;	 Catch:{ Exception -> 0x0507 }
        r3 = r49 + 2;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0507 }
        r12[r25] = r3;	 Catch:{ Exception -> 0x0507 }
        r3 = r49 + 1;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0507 }
        r14[r25] = r3;	 Catch:{ Exception -> 0x0507 }
        r3 = r49 + 2;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0507 }
        r15[r25] = r3;	 Catch:{ Exception -> 0x0507 }
    L_0x04bc:
        r25 = r25 + 1;
    L_0x04be:
        r30 = r30 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x0507 }
        r0 = r30;
        if (r0 != r3) goto L_0x04f9;
    L_0x04c5:
        r41 = r41 + 1;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r42;
        if (r0 != r3) goto L_0x04f5;
    L_0x04cd:
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0507 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0507 }
        r5 = "Serach ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0507 }
        r0 = r41;
        r4 = r4.append(r0);	 Catch:{ Exception -> 0x0507 }
        r5 = " - Done!\n";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0507 }
        r5 = " ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0507 }
        r5 = "byteOrig2[2]";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0507 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0507 }
        r3.println(r4);	 Catch:{ Exception -> 0x0507 }
    L_0x04f5:
        r58 = 0;
        r43 = 1;
    L_0x04f9:
        r49 = r29.get();	 Catch:{ Exception -> 0x0507 }
        goto L_0x0484;
    L_0x04fe:
        r11[r25] = r49;	 Catch:{ Exception -> 0x0507 }
        r12[r25] = r49;	 Catch:{ Exception -> 0x0507 }
        r14[r25] = r49;	 Catch:{ Exception -> 0x0507 }
        r15[r25] = r49;	 Catch:{ Exception -> 0x0507 }
        goto L_0x04bc;
    L_0x0507:
        r3 = move-exception;
        goto L_0x041c;
    L_0x050a:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r27 = r29.position();	 Catch:{ Exception -> 0x068b }
        r26 = r29.get();	 Catch:{ Exception -> 0x068b }
        r3 = 0;
        r3 = r10[r3];	 Catch:{ Exception -> 0x068b }
        r0 = r26;
        if (r0 != r3) goto L_0x0547;
    L_0x0520:
        r3 = 0;
        r3 = r51[r3];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x0528;
    L_0x0525:
        r3 = 0;
        r18[r3] = r26;	 Catch:{ Exception -> 0x068b }
    L_0x0528:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
    L_0x0535:
        r3 = r10[r30];	 Catch:{ Exception -> 0x068b }
        r0 = r49;
        if (r0 == r3) goto L_0x06ac;
    L_0x053b:
        r3 = r34[r30];	 Catch:{ Exception -> 0x068b }
        r4 = 1;
        if (r3 == r4) goto L_0x06ac;
    L_0x0540:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
    L_0x0547:
        r3 = 0;
        r3 = r13[r3];	 Catch:{ Exception -> 0x068b }
        r0 = r26;
        if (r0 != r3) goto L_0x0575;
    L_0x054e:
        r3 = 0;
        r3 = r54[r3];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x0556;
    L_0x0553:
        r3 = 0;
        r21[r3] = r26;	 Catch:{ Exception -> 0x068b }
    L_0x0556:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
    L_0x0563:
        r3 = r13[r30];	 Catch:{ Exception -> 0x068b }
        r0 = r49;
        if (r0 == r3) goto L_0x06db;
    L_0x0569:
        r3 = r37[r30];	 Catch:{ Exception -> 0x068b }
        r4 = 1;
        if (r3 == r4) goto L_0x06db;
    L_0x056e:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
    L_0x0575:
        r3 = 0;
        r3 = r11[r3];	 Catch:{ Exception -> 0x068b }
        r0 = r26;
        if (r0 != r3) goto L_0x05a3;
    L_0x057c:
        r3 = 0;
        r3 = r52[r3];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x0584;
    L_0x0581:
        r3 = 0;
        r19[r3] = r26;	 Catch:{ Exception -> 0x068b }
    L_0x0584:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
    L_0x0591:
        r3 = r11[r30];	 Catch:{ Exception -> 0x068b }
        r0 = r49;
        if (r0 == r3) goto L_0x070a;
    L_0x0597:
        r3 = r35[r30];	 Catch:{ Exception -> 0x068b }
        r4 = 1;
        if (r3 == r4) goto L_0x070a;
    L_0x059c:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
    L_0x05a3:
        r3 = 0;
        r3 = r12[r3];	 Catch:{ Exception -> 0x068b }
        r0 = r26;
        if (r0 != r3) goto L_0x05d1;
    L_0x05aa:
        r3 = 0;
        r3 = r53[r3];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x05b2;
    L_0x05af:
        r3 = 0;
        r20[r3] = r26;	 Catch:{ Exception -> 0x068b }
    L_0x05b2:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
    L_0x05bf:
        r3 = r12[r30];	 Catch:{ Exception -> 0x068b }
        r0 = r49;
        if (r0 == r3) goto L_0x0739;
    L_0x05c5:
        r3 = r36[r30];	 Catch:{ Exception -> 0x068b }
        r4 = 1;
        if (r3 == r4) goto L_0x0739;
    L_0x05ca:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
    L_0x05d1:
        r3 = 0;
        r3 = r14[r3];	 Catch:{ Exception -> 0x068b }
        r0 = r26;
        if (r0 != r3) goto L_0x05ff;
    L_0x05d8:
        r3 = 0;
        r3 = r55[r3];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x05e0;
    L_0x05dd:
        r3 = 0;
        r22[r3] = r26;	 Catch:{ Exception -> 0x068b }
    L_0x05e0:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
    L_0x05ed:
        r3 = r14[r30];	 Catch:{ Exception -> 0x068b }
        r0 = r49;
        if (r0 == r3) goto L_0x0768;
    L_0x05f3:
        r3 = r38[r30];	 Catch:{ Exception -> 0x068b }
        r4 = 1;
        if (r3 == r4) goto L_0x0768;
    L_0x05f8:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
    L_0x05ff:
        r3 = 0;
        r3 = r16[r3];	 Catch:{ Exception -> 0x068b }
        r0 = r26;
        if (r0 != r3) goto L_0x062d;
    L_0x0606:
        r3 = 0;
        r3 = r57[r3];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x060e;
    L_0x060b:
        r3 = 0;
        r24[r3] = r26;	 Catch:{ Exception -> 0x068b }
    L_0x060e:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
    L_0x061b:
        r3 = r16[r30];	 Catch:{ Exception -> 0x068b }
        r0 = r49;
        if (r0 == r3) goto L_0x0797;
    L_0x0621:
        r3 = r40[r30];	 Catch:{ Exception -> 0x068b }
        r4 = 1;
        if (r3 == r4) goto L_0x0797;
    L_0x0626:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
    L_0x062d:
        r3 = 0;
        r3 = r9[r3];	 Catch:{ Exception -> 0x068b }
        r0 = r26;
        if (r0 != r3) goto L_0x065b;
    L_0x0634:
        r3 = 0;
        r3 = r50[r3];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x063c;
    L_0x0639:
        r3 = 0;
        r17[r3] = r26;	 Catch:{ Exception -> 0x068b }
    L_0x063c:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
    L_0x0649:
        r3 = r9[r30];	 Catch:{ Exception -> 0x068b }
        r0 = r49;
        if (r0 == r3) goto L_0x07c8;
    L_0x064f:
        r3 = r33[r30];	 Catch:{ Exception -> 0x068b }
        r4 = 1;
        if (r3 == r4) goto L_0x07c8;
    L_0x0654:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
    L_0x065b:
        r3 = 0;
        r3 = r15[r3];	 Catch:{ Exception -> 0x068b }
        r0 = r26;
        if (r0 != r3) goto L_0x038c;
    L_0x0662:
        r3 = 0;
        r3 = r56[r3];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x066a;
    L_0x0667:
        r3 = 0;
        r23[r3] = r26;	 Catch:{ Exception -> 0x068b }
    L_0x066a:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
    L_0x0677:
        r3 = r15[r30];	 Catch:{ Exception -> 0x068b }
        r0 = r49;
        if (r0 == r3) goto L_0x07f7;
    L_0x067d:
        r3 = r39[r30];	 Catch:{ Exception -> 0x068b }
        r4 = 1;
        if (r3 == r4) goto L_0x07f7;
    L_0x0682:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x068b }
        goto L_0x038c;
    L_0x068b:
        r28 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r0 = r28;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x06a2, IOException -> 0x081e }
        goto L_0x0392;
    L_0x06a2:
        r31 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
        goto L_0x03cb;
    L_0x06ac:
        r3 = r51[r30];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x06b2;
    L_0x06b0:
        r18[r30] = r49;	 Catch:{ Exception -> 0x068b }
    L_0x06b2:
        r30 = r30 + 1;
        r3 = r10.length;	 Catch:{ Exception -> 0x068b }
        r0 = r30;
        if (r0 != r3) goto L_0x06d5;
    L_0x06b9:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x068b }
        r0 = r29;
        r1 = r18;
        r0.put(r1);	 Catch:{ Exception -> 0x068b }
        r29.force();	 Catch:{ Exception -> 0x068b }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x068b }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x068b }
        r44 = 1;
        goto L_0x0540;
    L_0x06d5:
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
        goto L_0x0535;
    L_0x06db:
        r3 = r54[r30];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x06e1;
    L_0x06df:
        r21[r30] = r49;	 Catch:{ Exception -> 0x068b }
    L_0x06e1:
        r30 = r30 + 1;
        r3 = r13.length;	 Catch:{ Exception -> 0x068b }
        r0 = r30;
        if (r0 != r3) goto L_0x0704;
    L_0x06e8:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x068b }
        r0 = r29;
        r1 = r21;
        r0.put(r1);	 Catch:{ Exception -> 0x068b }
        r29.force();	 Catch:{ Exception -> 0x068b }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x068b }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x068b }
        r45 = 1;
        goto L_0x056e;
    L_0x0704:
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
        goto L_0x0563;
    L_0x070a:
        r3 = r52[r30];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x0710;
    L_0x070e:
        r19[r30] = r49;	 Catch:{ Exception -> 0x068b }
    L_0x0710:
        r30 = r30 + 1;
        r3 = r11.length;	 Catch:{ Exception -> 0x068b }
        r0 = r30;
        if (r0 != r3) goto L_0x0733;
    L_0x0717:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x068b }
        r0 = r29;
        r1 = r19;
        r0.put(r1);	 Catch:{ Exception -> 0x068b }
        r29.force();	 Catch:{ Exception -> 0x068b }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x068b }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x068b }
        r46 = 1;
        goto L_0x059c;
    L_0x0733:
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
        goto L_0x0591;
    L_0x0739:
        r3 = r53[r30];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x073f;
    L_0x073d:
        r20[r30] = r49;	 Catch:{ Exception -> 0x068b }
    L_0x073f:
        r30 = r30 + 1;
        r3 = r12.length;	 Catch:{ Exception -> 0x068b }
        r0 = r30;
        if (r0 != r3) goto L_0x0762;
    L_0x0746:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x068b }
        r0 = r29;
        r1 = r20;
        r0.put(r1);	 Catch:{ Exception -> 0x068b }
        r29.force();	 Catch:{ Exception -> 0x068b }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x068b }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x068b }
        r47 = 1;
        goto L_0x05ca;
    L_0x0762:
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
        goto L_0x05bf;
    L_0x0768:
        r3 = r55[r30];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x076e;
    L_0x076c:
        r22[r30] = r49;	 Catch:{ Exception -> 0x068b }
    L_0x076e:
        r30 = r30 + 1;
        r3 = r14.length;	 Catch:{ Exception -> 0x068b }
        r0 = r30;
        if (r0 != r3) goto L_0x0791;
    L_0x0775:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x068b }
        r0 = r29;
        r1 = r22;
        r0.put(r1);	 Catch:{ Exception -> 0x068b }
        r29.force();	 Catch:{ Exception -> 0x068b }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x068b }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x068b }
        r48 = 1;
        goto L_0x05f8;
    L_0x0791:
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
        goto L_0x05ed;
    L_0x0797:
        r3 = r57[r30];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x079d;
    L_0x079b:
        r24[r30] = r49;	 Catch:{ Exception -> 0x068b }
    L_0x079d:
        r30 = r30 + 1;
        r0 = r16;
        r3 = r0.length;	 Catch:{ Exception -> 0x068b }
        r0 = r30;
        if (r0 != r3) goto L_0x07c2;
    L_0x07a6:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x068b }
        r0 = r29;
        r1 = r24;
        r0.put(r1);	 Catch:{ Exception -> 0x068b }
        r29.force();	 Catch:{ Exception -> 0x068b }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x068b }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x068b }
        r48 = 1;
        goto L_0x0626;
    L_0x07c2:
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
        goto L_0x061b;
    L_0x07c8:
        r3 = r50[r30];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x07ce;
    L_0x07cc:
        r17[r30] = r49;	 Catch:{ Exception -> 0x068b }
    L_0x07ce:
        r30 = r30 + 1;
        r3 = r9.length;	 Catch:{ Exception -> 0x068b }
        r0 = r30;
        if (r0 != r3) goto L_0x07f1;
    L_0x07d5:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x068b }
        r0 = r29;
        r1 = r17;
        r0.put(r1);	 Catch:{ Exception -> 0x068b }
        r29.force();	 Catch:{ Exception -> 0x068b }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x068b }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x068b }
        r48 = 1;
        goto L_0x0654;
    L_0x07f1:
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
        goto L_0x0649;
    L_0x07f7:
        r3 = r56[r30];	 Catch:{ Exception -> 0x068b }
        if (r3 != 0) goto L_0x07fd;
    L_0x07fb:
        r23[r30] = r49;	 Catch:{ Exception -> 0x068b }
    L_0x07fd:
        r30 = r30 + 1;
        r3 = r15.length;	 Catch:{ Exception -> 0x068b }
        r0 = r30;
        if (r0 != r3) goto L_0x0835;
    L_0x0804:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x068b }
        r0 = r29;
        r1 = r23;
        r0.put(r1);	 Catch:{ Exception -> 0x068b }
        r29.force();	 Catch:{ Exception -> 0x068b }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x068b }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x068b }
        goto L_0x0682;
    L_0x081e:
        r31 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r31;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x03cb;
    L_0x0835:
        r49 = r29.get();	 Catch:{ Exception -> 0x068b }
        goto L_0x0677;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.createnerorunpatch.main(java.lang.String[]):void");
    }
}
