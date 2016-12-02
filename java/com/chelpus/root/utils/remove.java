package com.chelpus.root.utils;

public class remove {
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r44) {
        /*
        r3 = new com.chelpus.root.utils.remove$1;
        r3.<init>();
        com.chelpus.Utils.startRootJava(r3);
        r3 = 12;
        r8 = new byte[r3];
        r8 = {10, 1, 56, 1, 14, 0, 26, 0, 12, 2, 26, 1};
        r3 = 12;
        r0 = new byte[r3];
        r29 = r0;
        r29 = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0};
        r3 = 12;
        r12 = new byte[r3];
        r12 = {18, 4, 41, 0, 0, 0, 113, 64, 85, 45, 14, 51};
        r3 = 12;
        r0 = new byte[r3];
        r39 = r0;
        r39 = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 12;
        r9 = new byte[r3];
        r9 = {56, 1, 43, 0, 110, 16, 19, 7, 7, 0, 12, 1};
        r3 = 12;
        r0 = new byte[r3];
        r30 = r0;
        r30 = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0};
        r3 = 12;
        r13 = new byte[r3];
        r13 = {0, 0, 0, 0, 110, 16, 19, 7, 7, 0, 12, 1};
        r3 = 12;
        r0 = new byte[r3];
        r40 = r0;
        r40 = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 14;
        r10 = new byte[r3];
        r10 = {56, 0, 6, 0, 112, 16, 117, 7, 4, 0, 14, 0, 84, 64};
        r3 = 14;
        r0 = new byte[r3];
        r31 = r0;
        r31 = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1};
        r3 = 14;
        r14 = new byte[r3];
        r14 = {0, 0, 0, 0, 112, 16, 117, 7, 4, 0, 14, 0, 84, 64};
        r3 = 14;
        r0 = new byte[r3];
        r41 = r0;
        r41 = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 14;
        r11 = new byte[r3];
        r11 = {56, 0, 87, 0, 84, 96, 2, 3, 84, 0, 1, 2, 84, 97};
        r3 = 14;
        r0 = new byte[r3];
        r32 = r0;
        r32 = {0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0};
        r3 = 14;
        r15 = new byte[r3];
        r15 = {0, 0, 0, 0, 112, 16, 117, 7, 4, 0, 14, 0, 84, 64};
        r3 = 14;
        r0 = new byte[r3];
        r42 = r0;
        r42 = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = dalvikDexIn;
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r44[r5];
        r19 = r3.replace(r4, r5);
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r0 = r26;
        r1 = r19;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        if (r3 != 0) goto L_0x00b3;
    L_0x00a2:
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = "-1";
        r4 = "-2";
        r0 = r19;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r0 = r26;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
    L_0x00b3:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = "-1";
        r4 = "";
        r0 = r19;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r0 = r27;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        if (r3 == 0) goto L_0x00cc;
    L_0x00ca:
        r27 = r26;
    L_0x00cc:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r19;
        r20 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r20;
        r20 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r0 = r26;
        r1 = r20;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        if (r3 == 0) goto L_0x00f1;
    L_0x00ef:
        r27 = r26;
    L_0x00f1:
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = "-1";
        r4 = "-2";
        r0 = r20;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r0 = r26;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        if (r3 == 0) goto L_0x010a;
    L_0x0108:
        r27 = r26;
    L_0x010a:
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = "-1";
        r4 = "";
        r0 = r20;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r0 = r26;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        if (r3 == 0) goto L_0x0123;
    L_0x0121:
        r27 = r26;
    L_0x0123:
        r3 = r27.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        if (r3 != 0) goto L_0x013b;
    L_0x0129:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        throw r3;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
    L_0x012f:
        r28 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
    L_0x0137:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x013b:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = "rw";
        r0 = r27;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r22 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r33 = 0;
        r34 = 0;
        r35 = 0;
        r36 = 0;
        r37 = 0;
        r43 = 0;
        r24 = 0;
    L_0x0164:
        r3 = r22.hasRemaining();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 == 0) goto L_0x031a;
    L_0x016a:
        r18 = r22.position();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r17 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r17;
        if (r0 != r3) goto L_0x01e2;
    L_0x0179:
        r3 = 0;
        r3 = r39[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = 2;
        if (r3 != r4) goto L_0x0181;
    L_0x017f:
        r43 = r17;
    L_0x0181:
        r3 = 0;
        r3 = r39[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x0189;
    L_0x0186:
        r3 = 0;
        r12[r3] = r17;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x0189:
        r23 = 1;
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r38 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x0198:
        r3 = r8[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r38;
        if (r0 == r3) goto L_0x01a2;
    L_0x019e:
        r3 = r29[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 == 0) goto L_0x01e2;
    L_0x01a2:
        r3 = r39[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = 2;
        if (r3 != r4) goto L_0x01a9;
    L_0x01a7:
        r43 = r38;
    L_0x01a9:
        r3 = r39[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 == 0) goto L_0x01b2;
    L_0x01ad:
        r3 = r39[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = 2;
        if (r3 != r4) goto L_0x01b4;
    L_0x01b2:
        r12[r23] = r38;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x01b4:
        r3 = r39[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = 3;
        if (r3 != r4) goto L_0x01bb;
    L_0x01b9:
        r16 = r23;
    L_0x01bb:
        r23 = r23 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r23;
        if (r0 != r3) goto L_0x02e8;
    L_0x01c2:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r16;
        if (r0 >= r3) goto L_0x01ca;
    L_0x01c8:
        r12[r16] = r43;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x01ca:
        r0 = r22;
        r1 = r18;
        r0.position(r1);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r22;
        r0.put(r12);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r22.force();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = "Check License Key Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r37 = 1;
    L_0x01e2:
        r3 = 0;
        r3 = r9[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r17;
        if (r0 != r3) goto L_0x0235;
    L_0x01e9:
        r3 = 0;
        r3 = r40[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x01f1;
    L_0x01ee:
        r3 = 0;
        r13[r3] = r17;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x01f1:
        r23 = 1;
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r38 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x01fe:
        r3 = r9[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r38;
        if (r0 == r3) goto L_0x0209;
    L_0x0204:
        r3 = r30[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = 1;
        if (r3 != r4) goto L_0x022e;
    L_0x0209:
        r3 = r40[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x020f;
    L_0x020d:
        r13[r23] = r38;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x020f:
        r23 = r23 + 1;
        r3 = r9.length;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r23;
        if (r0 != r3) goto L_0x02ee;
    L_0x0216:
        r0 = r22;
        r1 = r18;
        r0.position(r1);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r22;
        r0.put(r13);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r22.force();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = "License Key Fixed2!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r34 = 1;
    L_0x022e:
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x0235:
        r3 = 0;
        r3 = r10[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r17;
        if (r0 != r3) goto L_0x0288;
    L_0x023c:
        r3 = 0;
        r3 = r41[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x0244;
    L_0x0241:
        r3 = 0;
        r14[r3] = r17;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x0244:
        r23 = 1;
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r38 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x0251:
        r3 = r10[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r38;
        if (r0 == r3) goto L_0x025c;
    L_0x0257:
        r3 = r31[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = 1;
        if (r3 != r4) goto L_0x0281;
    L_0x025c:
        r3 = r41[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x0262;
    L_0x0260:
        r14[r23] = r38;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x0262:
        r23 = r23 + 1;
        r3 = r10.length;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r23;
        if (r0 != r3) goto L_0x02f4;
    L_0x0269:
        r0 = r22;
        r1 = r18;
        r0.position(r1);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r22;
        r0.put(r14);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r22.force();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = "Internet Connection Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r35 = 1;
    L_0x0281:
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x0288:
        r3 = 0;
        r3 = r11[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r17;
        if (r0 != r3) goto L_0x02db;
    L_0x028f:
        r3 = 0;
        r3 = r42[r3];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x0297;
    L_0x0294:
        r3 = 0;
        r15[r3] = r17;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x0297:
        r23 = 1;
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r38 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x02a4:
        r3 = r11[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r38;
        if (r0 == r3) goto L_0x02af;
    L_0x02aa:
        r3 = r32[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = 1;
        if (r3 != r4) goto L_0x02d4;
    L_0x02af:
        r3 = r42[r23];	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x02b5;
    L_0x02b3:
        r15[r23] = r38;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x02b5:
        r23 = r23 + 1;
        r3 = r11.length;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r23;
        if (r0 != r3) goto L_0x02fa;
    L_0x02bc:
        r0 = r22;
        r1 = r18;
        r0.position(r1);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r0 = r22;
        r0.put(r15);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r22.force();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = "Cached License Key Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r33 = 1;
    L_0x02d4:
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
    L_0x02db:
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        r4 = 1;
        r24 = r24 + r4;
        goto L_0x0164;
    L_0x02e8:
        r38 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        goto L_0x0198;
    L_0x02ee:
        r38 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        goto L_0x01fe;
    L_0x02f4:
        r38 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        goto L_0x0251;
    L_0x02fa:
        r38 = r22.get();	 Catch:{ Exception -> 0x02ff, FileNotFoundException -> 0x012f }
        goto L_0x02a4;
    L_0x02ff:
        r21 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r0 = r21;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
    L_0x031a:
        r2.close();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        if (r34 != 0) goto L_0x0326;
    L_0x031f:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = "Error: License Key2 patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
    L_0x0326:
        if (r35 != 0) goto L_0x032f;
    L_0x0328:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = "Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
    L_0x032f:
        if (r37 != 0) goto L_0x0338;
    L_0x0331:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = "Error: Check License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
    L_0x0338:
        if (r36 != 0) goto L_0x0341;
    L_0x033a:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
    L_0x0341:
        if (r33 != 0) goto L_0x0137;
    L_0x0343:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        r4 = "Error: Cached License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x034c }
        goto L_0x0137;
    L_0x034c:
        r21 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Exception e";
        r4 = r4.append(r5);
        r5 = r21.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x0137;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.remove.main(java.lang.String[]):void");
    }
}
