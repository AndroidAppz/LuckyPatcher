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
        r8 = {18, 36, 18, 19, 18, 2, 34, 0, 111, 0, 26, 1, 1, 1, 112, 48, 61, 1, 16, 2, 105, 0, 76, 0};
        r3 = 24;
        r0 = new byte[r3];
        r32 = r0;
        r32 = {0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 5, 5};
        r3 = 8;
        r10 = new byte[r3];
        r10 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r34 = r0;
        r34 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r18 = r0;
        r18 = {16, 0, 0, 0, 0, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r51 = r0;
        r51 = {0, 0, 0, 0, 1, 1, 1, 1};
        r3 = 8;
        r11 = new byte[r3];
        r11 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r35 = r0;
        r35 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r19 = r0;
        r19 = {16, 0, 0, 0, 41, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r52 = r0;
        r52 = {0, 0, 0, 0, 1, 1, 0, 0};
        r3 = 8;
        r12 = new byte[r3];
        r12 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r36 = r0;
        r36 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r20 = r0;
        r20 = {16, 0, 0, 0, 41, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r53 = r0;
        r53 = {0, 0, 0, 0, 1, 1, 0, 0};
        r3 = 8;
        r13 = new byte[r3];
        r13 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r37 = r0;
        r37 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r21 = r0;
        r21 = {16, 0, 0, 0, 41, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r54 = r0;
        r54 = {0, 0, 0, 0, 1, 1, 0, 0};
        r3 = 8;
        r14 = new byte[r3];
        r14 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r38 = r0;
        r38 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r22 = r0;
        r22 = {16, 0, 0, 0, 0, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r55 = r0;
        r55 = {0, 0, 0, 0, 1, 1, 1, 1};
        r3 = 8;
        r15 = new byte[r3];
        r15 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r39 = r0;
        r39 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r23 = r0;
        r23 = {16, 0, 0, 0, 0, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r56 = r0;
        r56 = {0, 0, 0, 0, 1, 1, 1, 1};
        r3 = 16;
        r0 = new byte[r3];
        r16 = r0;
        r16 = {98, 3, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 56, -1, -1, -1};
        r3 = 16;
        r0 = new byte[r3];
        r40 = r0;
        r40 = {0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1};
        r3 = 16;
        r0 = new byte[r3];
        r24 = r0;
        r24 = {16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 16;
        r0 = new byte[r3];
        r57 = r0;
        r57 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        r3 = 16;
        r9 = new byte[r3];
        r9 = {98, 3, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 57, -1, -1, -1};
        r3 = 16;
        r0 = new byte[r3];
        r33 = r0;
        r33 = {0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1};
        r3 = 16;
        r0 = new byte[r3];
        r17 = r0;
        r17 = {16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 41, 0, 0, 0};
        r3 = 16;
        r0 = new byte[r3];
        r50 = r0;
        r50 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0};
        r3 = dalvikDexIn;
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r59[r5];
        r3.replace(r4, r5);
        r3 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r5 = sddir;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r5 = "/Modified/classes.dex";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        classes = r3;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r3 = classes;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r3 = r3.exists();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        if (r3 != 0) goto L_0x04d8;
    L_0x0162:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        throw r3;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
    L_0x0168:
        r31 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
    L_0x0170:
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = " ";
        r4 = r4.append(r5);
        r5 = 2;
        r5 = r10[r5];
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        r3 = 1;
        r3 = r59[r3];
        r4 = "object";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x04d4;
    L_0x0196:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = classes;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r5 = "rw";
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r29 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r43 = 0;
        r44 = 0;
        r45 = 0;
        r46 = 0;
        r47 = 0;
        r48 = 0;
        r27 = 0;
        r26 = -1;
    L_0x01c1:
        r3 = r29.hasRemaining();	 Catch:{ Exception -> 0x0480 }
        if (r3 == 0) goto L_0x049b;
    L_0x01c7:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r27 = r29.position();	 Catch:{ Exception -> 0x0480 }
        r26 = r29.get();	 Catch:{ Exception -> 0x0480 }
        r3 = 0;
        r3 = r10[r3];	 Catch:{ Exception -> 0x0480 }
        r0 = r26;
        if (r0 != r3) goto L_0x022b;
    L_0x01dd:
        r3 = 0;
        r3 = r51[r3];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x01e5;
    L_0x01e2:
        r3 = 0;
        r18[r3] = r26;	 Catch:{ Exception -> 0x0480 }
    L_0x01e5:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
    L_0x01f2:
        r3 = r10[r30];	 Catch:{ Exception -> 0x0480 }
        r0 = r49;
        if (r0 == r3) goto L_0x01fd;
    L_0x01f8:
        r3 = r34[r30];	 Catch:{ Exception -> 0x0480 }
        r4 = 1;
        if (r3 != r4) goto L_0x0224;
    L_0x01fd:
        r3 = r51[r30];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x0203;
    L_0x0201:
        r18[r30] = r49;	 Catch:{ Exception -> 0x0480 }
    L_0x0203:
        r30 = r30 + 1;
        r3 = r10.length;	 Catch:{ Exception -> 0x0480 }
        r0 = r30;
        if (r0 != r3) goto L_0x061f;
    L_0x020a:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x0480 }
        r0 = r29;
        r1 = r18;
        r0.put(r1);	 Catch:{ Exception -> 0x0480 }
        r29.force();	 Catch:{ Exception -> 0x0480 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0480 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0480 }
        r44 = 1;
    L_0x0224:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
    L_0x022b:
        r3 = 0;
        r3 = r13[r3];	 Catch:{ Exception -> 0x0480 }
        r0 = r26;
        if (r0 != r3) goto L_0x0280;
    L_0x0232:
        r3 = 0;
        r3 = r54[r3];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x023a;
    L_0x0237:
        r3 = 0;
        r21[r3] = r26;	 Catch:{ Exception -> 0x0480 }
    L_0x023a:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
    L_0x0247:
        r3 = r13[r30];	 Catch:{ Exception -> 0x0480 }
        r0 = r49;
        if (r0 == r3) goto L_0x0252;
    L_0x024d:
        r3 = r37[r30];	 Catch:{ Exception -> 0x0480 }
        r4 = 1;
        if (r3 != r4) goto L_0x0279;
    L_0x0252:
        r3 = r54[r30];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x0258;
    L_0x0256:
        r21[r30] = r49;	 Catch:{ Exception -> 0x0480 }
    L_0x0258:
        r30 = r30 + 1;
        r3 = r13.length;	 Catch:{ Exception -> 0x0480 }
        r0 = r30;
        if (r0 != r3) goto L_0x0625;
    L_0x025f:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x0480 }
        r0 = r29;
        r1 = r21;
        r0.put(r1);	 Catch:{ Exception -> 0x0480 }
        r29.force();	 Catch:{ Exception -> 0x0480 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0480 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0480 }
        r45 = 1;
    L_0x0279:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
    L_0x0280:
        r3 = 0;
        r3 = r11[r3];	 Catch:{ Exception -> 0x0480 }
        r0 = r26;
        if (r0 != r3) goto L_0x02d5;
    L_0x0287:
        r3 = 0;
        r3 = r52[r3];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x028f;
    L_0x028c:
        r3 = 0;
        r19[r3] = r26;	 Catch:{ Exception -> 0x0480 }
    L_0x028f:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
    L_0x029c:
        r3 = r11[r30];	 Catch:{ Exception -> 0x0480 }
        r0 = r49;
        if (r0 == r3) goto L_0x02a7;
    L_0x02a2:
        r3 = r35[r30];	 Catch:{ Exception -> 0x0480 }
        r4 = 1;
        if (r3 != r4) goto L_0x02ce;
    L_0x02a7:
        r3 = r52[r30];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x02ad;
    L_0x02ab:
        r19[r30] = r49;	 Catch:{ Exception -> 0x0480 }
    L_0x02ad:
        r30 = r30 + 1;
        r3 = r11.length;	 Catch:{ Exception -> 0x0480 }
        r0 = r30;
        if (r0 != r3) goto L_0x062b;
    L_0x02b4:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x0480 }
        r0 = r29;
        r1 = r19;
        r0.put(r1);	 Catch:{ Exception -> 0x0480 }
        r29.force();	 Catch:{ Exception -> 0x0480 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0480 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0480 }
        r46 = 1;
    L_0x02ce:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
    L_0x02d5:
        r3 = 0;
        r3 = r12[r3];	 Catch:{ Exception -> 0x0480 }
        r0 = r26;
        if (r0 != r3) goto L_0x032a;
    L_0x02dc:
        r3 = 0;
        r3 = r53[r3];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x02e4;
    L_0x02e1:
        r3 = 0;
        r20[r3] = r26;	 Catch:{ Exception -> 0x0480 }
    L_0x02e4:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
    L_0x02f1:
        r3 = r12[r30];	 Catch:{ Exception -> 0x0480 }
        r0 = r49;
        if (r0 == r3) goto L_0x02fc;
    L_0x02f7:
        r3 = r36[r30];	 Catch:{ Exception -> 0x0480 }
        r4 = 1;
        if (r3 != r4) goto L_0x0323;
    L_0x02fc:
        r3 = r53[r30];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x0302;
    L_0x0300:
        r20[r30] = r49;	 Catch:{ Exception -> 0x0480 }
    L_0x0302:
        r30 = r30 + 1;
        r3 = r12.length;	 Catch:{ Exception -> 0x0480 }
        r0 = r30;
        if (r0 != r3) goto L_0x0631;
    L_0x0309:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x0480 }
        r0 = r29;
        r1 = r20;
        r0.put(r1);	 Catch:{ Exception -> 0x0480 }
        r29.force();	 Catch:{ Exception -> 0x0480 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0480 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0480 }
        r47 = 1;
    L_0x0323:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
    L_0x032a:
        r3 = 0;
        r3 = r14[r3];	 Catch:{ Exception -> 0x0480 }
        r0 = r26;
        if (r0 != r3) goto L_0x037f;
    L_0x0331:
        r3 = 0;
        r3 = r55[r3];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x0339;
    L_0x0336:
        r3 = 0;
        r22[r3] = r26;	 Catch:{ Exception -> 0x0480 }
    L_0x0339:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
    L_0x0346:
        r3 = r14[r30];	 Catch:{ Exception -> 0x0480 }
        r0 = r49;
        if (r0 == r3) goto L_0x0351;
    L_0x034c:
        r3 = r38[r30];	 Catch:{ Exception -> 0x0480 }
        r4 = 1;
        if (r3 != r4) goto L_0x0378;
    L_0x0351:
        r3 = r55[r30];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x0357;
    L_0x0355:
        r22[r30] = r49;	 Catch:{ Exception -> 0x0480 }
    L_0x0357:
        r30 = r30 + 1;
        r3 = r14.length;	 Catch:{ Exception -> 0x0480 }
        r0 = r30;
        if (r0 != r3) goto L_0x0637;
    L_0x035e:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x0480 }
        r0 = r29;
        r1 = r22;
        r0.put(r1);	 Catch:{ Exception -> 0x0480 }
        r29.force();	 Catch:{ Exception -> 0x0480 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0480 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0480 }
        r48 = 1;
    L_0x0378:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
    L_0x037f:
        r3 = 0;
        r3 = r16[r3];	 Catch:{ Exception -> 0x0480 }
        r0 = r26;
        if (r0 != r3) goto L_0x03d6;
    L_0x0386:
        r3 = 0;
        r3 = r57[r3];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x038e;
    L_0x038b:
        r3 = 0;
        r24[r3] = r26;	 Catch:{ Exception -> 0x0480 }
    L_0x038e:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
    L_0x039b:
        r3 = r16[r30];	 Catch:{ Exception -> 0x0480 }
        r0 = r49;
        if (r0 == r3) goto L_0x03a6;
    L_0x03a1:
        r3 = r40[r30];	 Catch:{ Exception -> 0x0480 }
        r4 = 1;
        if (r3 != r4) goto L_0x03cf;
    L_0x03a6:
        r3 = r57[r30];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x03ac;
    L_0x03aa:
        r24[r30] = r49;	 Catch:{ Exception -> 0x0480 }
    L_0x03ac:
        r30 = r30 + 1;
        r0 = r16;
        r3 = r0.length;	 Catch:{ Exception -> 0x0480 }
        r0 = r30;
        if (r0 != r3) goto L_0x063d;
    L_0x03b5:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x0480 }
        r0 = r29;
        r1 = r24;
        r0.put(r1);	 Catch:{ Exception -> 0x0480 }
        r29.force();	 Catch:{ Exception -> 0x0480 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0480 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0480 }
        r48 = 1;
    L_0x03cf:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
    L_0x03d6:
        r3 = 0;
        r3 = r9[r3];	 Catch:{ Exception -> 0x0480 }
        r0 = r26;
        if (r0 != r3) goto L_0x042b;
    L_0x03dd:
        r3 = 0;
        r3 = r50[r3];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x03e5;
    L_0x03e2:
        r3 = 0;
        r17[r3] = r26;	 Catch:{ Exception -> 0x0480 }
    L_0x03e5:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
    L_0x03f2:
        r3 = r9[r30];	 Catch:{ Exception -> 0x0480 }
        r0 = r49;
        if (r0 == r3) goto L_0x03fd;
    L_0x03f8:
        r3 = r33[r30];	 Catch:{ Exception -> 0x0480 }
        r4 = 1;
        if (r3 != r4) goto L_0x0424;
    L_0x03fd:
        r3 = r50[r30];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x0403;
    L_0x0401:
        r17[r30] = r49;	 Catch:{ Exception -> 0x0480 }
    L_0x0403:
        r30 = r30 + 1;
        r3 = r9.length;	 Catch:{ Exception -> 0x0480 }
        r0 = r30;
        if (r0 != r3) goto L_0x0643;
    L_0x040a:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x0480 }
        r0 = r29;
        r1 = r17;
        r0.put(r1);	 Catch:{ Exception -> 0x0480 }
        r29.force();	 Catch:{ Exception -> 0x0480 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0480 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0480 }
        r48 = 1;
    L_0x0424:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
    L_0x042b:
        r3 = 0;
        r3 = r15[r3];	 Catch:{ Exception -> 0x0480 }
        r0 = r26;
        if (r0 != r3) goto L_0x01c1;
    L_0x0432:
        r3 = 0;
        r3 = r56[r3];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x043a;
    L_0x0437:
        r3 = 0;
        r23[r3] = r26;	 Catch:{ Exception -> 0x0480 }
    L_0x043a:
        r30 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
    L_0x0447:
        r3 = r15[r30];	 Catch:{ Exception -> 0x0480 }
        r0 = r49;
        if (r0 == r3) goto L_0x0452;
    L_0x044d:
        r3 = r39[r30];	 Catch:{ Exception -> 0x0480 }
        r4 = 1;
        if (r3 != r4) goto L_0x0477;
    L_0x0452:
        r3 = r56[r30];	 Catch:{ Exception -> 0x0480 }
        if (r3 != 0) goto L_0x0458;
    L_0x0456:
        r23[r30] = r49;	 Catch:{ Exception -> 0x0480 }
    L_0x0458:
        r30 = r30 + 1;
        r3 = r15.length;	 Catch:{ Exception -> 0x0480 }
        r0 = r30;
        if (r0 != r3) goto L_0x0649;
    L_0x045f:
        r0 = r29;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x0480 }
        r0 = r29;
        r1 = r23;
        r0.put(r1);	 Catch:{ Exception -> 0x0480 }
        r29.force();	 Catch:{ Exception -> 0x0480 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0480 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0480 }
    L_0x0477:
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x0480 }
        goto L_0x01c1;
    L_0x0480:
        r28 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r0 = r28;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
    L_0x049b:
        r2.close();	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        if (r44 != 0) goto L_0x04a7;
    L_0x04a0:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = "Error: License Key2 patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
    L_0x04a7:
        if (r45 != 0) goto L_0x04b0;
    L_0x04a9:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = "Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
    L_0x04b0:
        if (r46 != 0) goto L_0x04b9;
    L_0x04b2:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = "Error: Check License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
    L_0x04b9:
        if (r47 != 0) goto L_0x04c2;
    L_0x04bb:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
    L_0x04c2:
        if (r48 != 0) goto L_0x04cb;
    L_0x04c4:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
    L_0x04cb:
        if (r43 != 0) goto L_0x04d4;
    L_0x04cd:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
        r4 = "Error: Cached License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x064f, IOException -> 0x0659 }
    L_0x04d4:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x04d8:
        r43 = 0;
        r58 = 1;
        r27 = 0;
        r41 = 0;
        r42 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = 1;
        r3 = r59[r3];	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = "object";
        r3 = r3.contains(r4);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        if (r3 == 0) goto L_0x04fc;
    L_0x04ed:
        r3 = 1;
        r3 = r59[r3];	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = "object";
        r5 = "";
        r3 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r42 = java.lang.Integer.parseInt(r3);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
    L_0x04fc:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = classes;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r5 = "rw";
        r3.<init>(r4, r5);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r29 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r26 = -1;
    L_0x0519:
        r3 = r29.hasRemaining();	 Catch:{ Exception -> 0x05d3 }
        if (r3 == 0) goto L_0x05d4;
    L_0x051f:
        r0 = r41;
        r1 = r42;
        if (r0 >= r1) goto L_0x05d4;
    L_0x0525:
        r58 = 1;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x05d3 }
        r27 = r29.position();	 Catch:{ Exception -> 0x05d3 }
        r26 = r29.get();	 Catch:{ Exception -> 0x05d3 }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x05d3 }
        r0 = r26;
        if (r0 != r3) goto L_0x0519;
    L_0x053d:
        r30 = 1;
        r25 = 2;
        r3 = r27 + 1;
        r0 = r29;
        r0.position(r3);	 Catch:{ Exception -> 0x05d3 }
        r49 = r29.get();	 Catch:{ Exception -> 0x05d3 }
    L_0x054c:
        if (r58 == 0) goto L_0x0519;
    L_0x054e:
        r3 = r8[r30];	 Catch:{ Exception -> 0x05d3 }
        r0 = r49;
        if (r0 == r3) goto L_0x055e;
    L_0x0554:
        r3 = r32[r30];	 Catch:{ Exception -> 0x05d3 }
        r4 = 1;
        if (r3 == r4) goto L_0x055e;
    L_0x0559:
        r3 = r32[r30];	 Catch:{ Exception -> 0x05d3 }
        r4 = 5;
        if (r3 != r4) goto L_0x0519;
    L_0x055e:
        r3 = r32[r30];	 Catch:{ Exception -> 0x05d3 }
        r4 = 5;
        if (r3 != r4) goto L_0x0586;
    L_0x0563:
        r10[r25] = r49;	 Catch:{ Exception -> 0x05d3 }
        r13[r25] = r49;	 Catch:{ Exception -> 0x05d3 }
        r16[r25] = r49;	 Catch:{ Exception -> 0x05d3 }
        r9[r25] = r49;	 Catch:{ Exception -> 0x05d3 }
        r3 = 2;
        r0 = r25;
        if (r0 != r3) goto L_0x05ca;
    L_0x0570:
        r3 = r49 + 1;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x05d3 }
        r11[r25] = r3;	 Catch:{ Exception -> 0x05d3 }
        r3 = r49 + 2;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x05d3 }
        r12[r25] = r3;	 Catch:{ Exception -> 0x05d3 }
        r3 = r49 + 1;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x05d3 }
        r14[r25] = r3;	 Catch:{ Exception -> 0x05d3 }
        r3 = r49 + 2;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x05d3 }
        r15[r25] = r3;	 Catch:{ Exception -> 0x05d3 }
    L_0x0584:
        r25 = r25 + 1;
    L_0x0586:
        r30 = r30 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x05d3 }
        r0 = r30;
        if (r0 != r3) goto L_0x05c5;
    L_0x058d:
        r41 = r41 + 1;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r42;
        if (r0 != r3) goto L_0x05c1;
    L_0x0595:
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x05d3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05d3 }
        r4.<init>();	 Catch:{ Exception -> 0x05d3 }
        r5 = "Serach ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x05d3 }
        r0 = r41;
        r4 = r4.append(r0);	 Catch:{ Exception -> 0x05d3 }
        r5 = " - Done!\n";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x05d3 }
        r5 = " ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x05d3 }
        r5 = "byteOrig2[2]";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x05d3 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x05d3 }
        r3.println(r4);	 Catch:{ Exception -> 0x05d3 }
    L_0x05c1:
        r58 = 0;
        r43 = 1;
    L_0x05c5:
        r49 = r29.get();	 Catch:{ Exception -> 0x05d3 }
        goto L_0x054c;
    L_0x05ca:
        r11[r25] = r49;	 Catch:{ Exception -> 0x05d3 }
        r12[r25] = r49;	 Catch:{ Exception -> 0x05d3 }
        r14[r25] = r49;	 Catch:{ Exception -> 0x05d3 }
        r15[r25] = r49;	 Catch:{ Exception -> 0x05d3 }
        goto L_0x0584;
    L_0x05d3:
        r3 = move-exception;
    L_0x05d4:
        r2.close();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r5 = "{\"objects\":\"";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r0 = r41;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r5 = "\"}";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        if (r43 != 0) goto L_0x0170;
    L_0x05f9:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        r4 = "Error: Objects not Found!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0168, IOException -> 0x0602 }
        goto L_0x0170;
    L_0x0602:
        r31 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "";
        r4 = r4.append(r5);
        r0 = r31;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x0170;
    L_0x061f:
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
        goto L_0x01f2;
    L_0x0625:
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
        goto L_0x0247;
    L_0x062b:
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
        goto L_0x029c;
    L_0x0631:
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
        goto L_0x02f1;
    L_0x0637:
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
        goto L_0x0346;
    L_0x063d:
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
        goto L_0x039b;
    L_0x0643:
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
        goto L_0x03f2;
    L_0x0649:
        r49 = r29.get();	 Catch:{ Exception -> 0x0480 }
        goto L_0x0447;
    L_0x064f:
        r31 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
        goto L_0x04d4;
    L_0x0659:
        r31 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "";
        r4 = r4.append(r5);
        r0 = r31;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x04d4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.createnerorunpatch.main(java.lang.String[]):void");
    }
}
