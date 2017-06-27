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
        r3 = 0;
        r4 = 10;
        r8[r3] = r4;
        r3 = 1;
        r4 = 1;
        r8[r3] = r4;
        r3 = 2;
        r4 = 56;
        r8[r3] = r4;
        r3 = 3;
        r4 = 1;
        r8[r3] = r4;
        r3 = 4;
        r4 = 14;
        r8[r3] = r4;
        r3 = 6;
        r4 = 26;
        r8[r3] = r4;
        r3 = 8;
        r4 = 12;
        r8[r3] = r4;
        r3 = 9;
        r4 = 2;
        r8[r3] = r4;
        r3 = 10;
        r4 = 26;
        r8[r3] = r4;
        r3 = 11;
        r4 = 1;
        r8[r3] = r4;
        r3 = 12;
        r0 = new byte[r3];
        r29 = r0;
        r3 = 8;
        r4 = 1;
        r29[r3] = r4;
        r3 = 9;
        r4 = 1;
        r29[r3] = r4;
        r3 = 12;
        r12 = new byte[r3];
        r3 = 0;
        r4 = 18;
        r12[r3] = r4;
        r3 = 1;
        r4 = 4;
        r12[r3] = r4;
        r3 = 2;
        r4 = 41;
        r12[r3] = r4;
        r3 = 6;
        r4 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r12[r3] = r4;
        r3 = 7;
        r4 = 64;
        r12[r3] = r4;
        r3 = 8;
        r4 = 85;
        r12[r3] = r4;
        r3 = 9;
        r4 = 45;
        r12[r3] = r4;
        r3 = 10;
        r4 = 14;
        r12[r3] = r4;
        r3 = 11;
        r4 = 51;
        r12[r3] = r4;
        r3 = 12;
        r0 = new byte[r3];
        r39 = r0;
        r3 = 0;
        r4 = 1;
        r39[r3] = r4;
        r3 = 1;
        r4 = 1;
        r39[r3] = r4;
        r3 = 2;
        r4 = 1;
        r39[r3] = r4;
        r3 = 3;
        r4 = 1;
        r39[r3] = r4;
        r3 = 12;
        r9 = new byte[r3];
        r3 = 0;
        r4 = 56;
        r9[r3] = r4;
        r3 = 1;
        r4 = 1;
        r9[r3] = r4;
        r3 = 2;
        r4 = 43;
        r9[r3] = r4;
        r3 = 4;
        r4 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r9[r3] = r4;
        r3 = 5;
        r4 = 16;
        r9[r3] = r4;
        r3 = 6;
        r4 = 19;
        r9[r3] = r4;
        r3 = 7;
        r4 = 7;
        r9[r3] = r4;
        r3 = 8;
        r4 = 7;
        r9[r3] = r4;
        r3 = 10;
        r4 = 12;
        r9[r3] = r4;
        r3 = 11;
        r4 = 1;
        r9[r3] = r4;
        r3 = 12;
        r0 = new byte[r3];
        r30 = r0;
        r3 = 4;
        r4 = 1;
        r30[r3] = r4;
        r3 = 5;
        r4 = 1;
        r30[r3] = r4;
        r3 = 6;
        r4 = 1;
        r30[r3] = r4;
        r3 = 7;
        r4 = 1;
        r30[r3] = r4;
        r3 = 8;
        r4 = 1;
        r30[r3] = r4;
        r3 = 9;
        r4 = 1;
        r30[r3] = r4;
        r3 = 12;
        r13 = new byte[r3];
        r3 = 4;
        r4 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r13[r3] = r4;
        r3 = 5;
        r4 = 16;
        r13[r3] = r4;
        r3 = 6;
        r4 = 19;
        r13[r3] = r4;
        r3 = 7;
        r4 = 7;
        r13[r3] = r4;
        r3 = 8;
        r4 = 7;
        r13[r3] = r4;
        r3 = 10;
        r4 = 12;
        r13[r3] = r4;
        r3 = 11;
        r4 = 1;
        r13[r3] = r4;
        r3 = 12;
        r0 = new byte[r3];
        r40 = r0;
        r3 = 0;
        r4 = 1;
        r40[r3] = r4;
        r3 = 1;
        r4 = 1;
        r40[r3] = r4;
        r3 = 2;
        r4 = 1;
        r40[r3] = r4;
        r3 = 3;
        r4 = 1;
        r40[r3] = r4;
        r3 = 14;
        r10 = new byte[r3];
        r3 = 0;
        r4 = 56;
        r10[r3] = r4;
        r3 = 2;
        r4 = 6;
        r10[r3] = r4;
        r3 = 4;
        r4 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r10[r3] = r4;
        r3 = 5;
        r4 = 16;
        r10[r3] = r4;
        r3 = 6;
        r4 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r10[r3] = r4;
        r3 = 7;
        r4 = 7;
        r10[r3] = r4;
        r3 = 8;
        r4 = 4;
        r10[r3] = r4;
        r3 = 10;
        r4 = 14;
        r10[r3] = r4;
        r3 = 12;
        r4 = 84;
        r10[r3] = r4;
        r3 = 13;
        r4 = 64;
        r10[r3] = r4;
        r3 = 14;
        r0 = new byte[r3];
        r31 = r0;
        r3 = 4;
        r4 = 1;
        r31[r3] = r4;
        r3 = 5;
        r4 = 1;
        r31[r3] = r4;
        r3 = 6;
        r4 = 1;
        r31[r3] = r4;
        r3 = 7;
        r4 = 1;
        r31[r3] = r4;
        r3 = 8;
        r4 = 1;
        r31[r3] = r4;
        r3 = 9;
        r4 = 1;
        r31[r3] = r4;
        r3 = 12;
        r4 = 1;
        r31[r3] = r4;
        r3 = 13;
        r4 = 1;
        r31[r3] = r4;
        r3 = 14;
        r14 = new byte[r3];
        r3 = 4;
        r4 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r14[r3] = r4;
        r3 = 5;
        r4 = 16;
        r14[r3] = r4;
        r3 = 6;
        r4 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r14[r3] = r4;
        r3 = 7;
        r4 = 7;
        r14[r3] = r4;
        r3 = 8;
        r4 = 4;
        r14[r3] = r4;
        r3 = 10;
        r4 = 14;
        r14[r3] = r4;
        r3 = 12;
        r4 = 84;
        r14[r3] = r4;
        r3 = 13;
        r4 = 64;
        r14[r3] = r4;
        r3 = 14;
        r0 = new byte[r3];
        r41 = r0;
        r3 = 0;
        r4 = 1;
        r41[r3] = r4;
        r3 = 1;
        r4 = 1;
        r41[r3] = r4;
        r3 = 2;
        r4 = 1;
        r41[r3] = r4;
        r3 = 3;
        r4 = 1;
        r41[r3] = r4;
        r3 = 14;
        r11 = new byte[r3];
        r3 = 0;
        r4 = 56;
        r11[r3] = r4;
        r3 = 2;
        r4 = 87;
        r11[r3] = r4;
        r3 = 4;
        r4 = 84;
        r11[r3] = r4;
        r3 = 5;
        r4 = 96;
        r11[r3] = r4;
        r3 = 6;
        r4 = 2;
        r11[r3] = r4;
        r3 = 7;
        r4 = 3;
        r11[r3] = r4;
        r3 = 8;
        r4 = 84;
        r11[r3] = r4;
        r3 = 10;
        r4 = 1;
        r11[r3] = r4;
        r3 = 11;
        r4 = 2;
        r11[r3] = r4;
        r3 = 12;
        r4 = 84;
        r11[r3] = r4;
        r3 = 13;
        r4 = 97;
        r11[r3] = r4;
        r3 = 14;
        r0 = new byte[r3];
        r32 = r0;
        r3 = 4;
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
        r3 = 10;
        r4 = 1;
        r32[r3] = r4;
        r3 = 11;
        r4 = 1;
        r32[r3] = r4;
        r3 = 12;
        r4 = 1;
        r32[r3] = r4;
        r3 = 14;
        r15 = new byte[r3];
        r3 = 4;
        r4 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r15[r3] = r4;
        r3 = 5;
        r4 = 16;
        r15[r3] = r4;
        r3 = 6;
        r4 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r15[r3] = r4;
        r3 = 7;
        r4 = 7;
        r15[r3] = r4;
        r3 = 8;
        r4 = 4;
        r15[r3] = r4;
        r3 = 10;
        r4 = 14;
        r15[r3] = r4;
        r3 = 12;
        r4 = 84;
        r15[r3] = r4;
        r3 = 13;
        r4 = 64;
        r15[r3] = r4;
        r3 = 14;
        r0 = new byte[r3];
        r42 = r0;
        r3 = 0;
        r4 = 1;
        r42[r3] = r4;
        r3 = 1;
        r4 = 1;
        r42[r3] = r4;
        r3 = 2;
        r4 = 1;
        r42[r3] = r4;
        r3 = 3;
        r4 = 1;
        r42[r3] = r4;
        r3 = dalvikDexIn;
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r44[r5];
        r19 = r3.replace(r4, r5);
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r0 = r26;
        r1 = r19;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        if (r3 != 0) goto L_0x02a0;
    L_0x028f:
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = "-1";
        r4 = "-2";
        r0 = r19;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r0 = r26;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
    L_0x02a0:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = "-1";
        r4 = "";
        r0 = r19;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r0 = r27;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        if (r3 == 0) goto L_0x02b9;
    L_0x02b7:
        r27 = r26;
    L_0x02b9:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r19;
        r20 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r20;
        r20 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r0 = r26;
        r1 = r20;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        if (r3 == 0) goto L_0x02de;
    L_0x02dc:
        r27 = r26;
    L_0x02de:
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = "-1";
        r4 = "-2";
        r0 = r20;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r0 = r26;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        if (r3 == 0) goto L_0x02f7;
    L_0x02f5:
        r27 = r26;
    L_0x02f7:
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = "-1";
        r4 = "";
        r0 = r20;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r0 = r26;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = r26.exists();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        if (r3 == 0) goto L_0x0310;
    L_0x030e:
        r27 = r26;
    L_0x0310:
        r3 = r27.exists();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        if (r3 != 0) goto L_0x0328;
    L_0x0316:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        throw r3;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
    L_0x031c:
        r28 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
    L_0x0324:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x0328:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = "rw";
        r0 = r27;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r22 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r33 = 0;
        r34 = 0;
        r35 = 0;
        r36 = 0;
        r37 = 0;
        r43 = 0;
        r24 = 0;
    L_0x0351:
        r3 = r22.hasRemaining();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x03a2;
    L_0x0357:
        r2.close();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        if (r34 != 0) goto L_0x0363;
    L_0x035c:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = "Error: License Key2 patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
    L_0x0363:
        if (r35 != 0) goto L_0x036c;
    L_0x0365:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = "Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
    L_0x036c:
        if (r37 != 0) goto L_0x0375;
    L_0x036e:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = "Error: Check License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
    L_0x0375:
        if (r36 != 0) goto L_0x037e;
    L_0x0377:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
    L_0x037e:
        if (r33 != 0) goto L_0x0324;
    L_0x0380:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = "Error: Cached License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        goto L_0x0324;
    L_0x0388:
        r21 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r5 = "Exception e";
        r4.<init>(r5);
        r5 = r21.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x0324;
    L_0x03a2:
        r18 = r22.position();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r17 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r17;
        if (r0 != r3) goto L_0x03da;
    L_0x03b1:
        r3 = 0;
        r3 = r39[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = 2;
        if (r3 != r4) goto L_0x03b9;
    L_0x03b7:
        r43 = r17;
    L_0x03b9:
        r3 = 0;
        r3 = r39[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x03c1;
    L_0x03be:
        r3 = 0;
        r12[r3] = r17;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x03c1:
        r23 = 1;
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r38 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x03d0:
        r3 = r8[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r38;
        if (r0 == r3) goto L_0x0471;
    L_0x03d6:
        r3 = r29[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x0471;
    L_0x03da:
        r3 = 0;
        r3 = r9[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r17;
        if (r0 != r3) goto L_0x0408;
    L_0x03e1:
        r3 = 0;
        r3 = r40[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x03e9;
    L_0x03e6:
        r3 = 0;
        r13[r3] = r17;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x03e9:
        r23 = 1;
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r38 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x03f6:
        r3 = r9[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r38;
        if (r0 == r3) goto L_0x04b9;
    L_0x03fc:
        r3 = r30[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = 1;
        if (r3 == r4) goto L_0x04b9;
    L_0x0401:
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0408:
        r3 = 0;
        r3 = r10[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r17;
        if (r0 != r3) goto L_0x0436;
    L_0x040f:
        r3 = 0;
        r3 = r41[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x0417;
    L_0x0414:
        r3 = 0;
        r14[r3] = r17;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0417:
        r23 = 1;
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r38 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0424:
        r3 = r10[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r38;
        if (r0 == r3) goto L_0x04e6;
    L_0x042a:
        r3 = r31[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = 1;
        if (r3 == r4) goto L_0x04e6;
    L_0x042f:
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0436:
        r3 = 0;
        r3 = r11[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r17;
        if (r0 != r3) goto L_0x0464;
    L_0x043d:
        r3 = 0;
        r3 = r42[r3];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x0445;
    L_0x0442:
        r3 = 0;
        r15[r3] = r17;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0445:
        r23 = 1;
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r38 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0452:
        r3 = r11[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r38;
        if (r0 == r3) goto L_0x0513;
    L_0x0458:
        r3 = r32[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = 1;
        if (r3 == r4) goto L_0x0513;
    L_0x045d:
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0464:
        r3 = r18 + 1;
        r0 = r22;
        r0.position(r3);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = 1;
        r24 = r24 + r4;
        goto L_0x0351;
    L_0x0471:
        r3 = r39[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = 2;
        if (r3 != r4) goto L_0x0478;
    L_0x0476:
        r43 = r38;
    L_0x0478:
        r3 = r39[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 == 0) goto L_0x0481;
    L_0x047c:
        r3 = r39[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = 2;
        if (r3 != r4) goto L_0x0483;
    L_0x0481:
        r12[r23] = r38;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0483:
        r3 = r39[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = 3;
        if (r3 != r4) goto L_0x048a;
    L_0x0488:
        r16 = r23;
    L_0x048a:
        r23 = r23 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r23;
        if (r0 != r3) goto L_0x04b3;
    L_0x0491:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r16;
        if (r0 >= r3) goto L_0x0499;
    L_0x0497:
        r12[r16] = r43;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0499:
        r0 = r22;
        r1 = r18;
        r0.position(r1);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r22;
        r0.put(r12);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r22.force();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = "Check License Key Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r37 = 1;
        goto L_0x03da;
    L_0x04b3:
        r38 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        goto L_0x03d0;
    L_0x04b9:
        r3 = r40[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x04bf;
    L_0x04bd:
        r13[r23] = r38;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x04bf:
        r23 = r23 + 1;
        r3 = r9.length;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r23;
        if (r0 != r3) goto L_0x04e0;
    L_0x04c6:
        r0 = r22;
        r1 = r18;
        r0.position(r1);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r22;
        r0.put(r13);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r22.force();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = "License Key Fixed2!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r34 = 1;
        goto L_0x0401;
    L_0x04e0:
        r38 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        goto L_0x03f6;
    L_0x04e6:
        r3 = r41[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x04ec;
    L_0x04ea:
        r14[r23] = r38;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x04ec:
        r23 = r23 + 1;
        r3 = r10.length;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r23;
        if (r0 != r3) goto L_0x050d;
    L_0x04f3:
        r0 = r22;
        r1 = r18;
        r0.position(r1);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r22;
        r0.put(r14);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r22.force();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = "Internet Connection Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r35 = 1;
        goto L_0x042f;
    L_0x050d:
        r38 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        goto L_0x0424;
    L_0x0513:
        r3 = r42[r23];	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        if (r3 != 0) goto L_0x0519;
    L_0x0517:
        r15[r23] = r38;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
    L_0x0519:
        r23 = r23 + 1;
        r3 = r11.length;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r23;
        if (r0 != r3) goto L_0x053a;
    L_0x0520:
        r0 = r22;
        r1 = r18;
        r0.position(r1);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r0 = r22;
        r0.put(r15);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r22.force();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r4 = "Cached License Key Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        r33 = 1;
        goto L_0x045d;
    L_0x053a:
        r38 = r22.get();	 Catch:{ Exception -> 0x0540, FileNotFoundException -> 0x031c }
        goto L_0x0452;
    L_0x0540:
        r21 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r0 = r21;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x031c, Exception -> 0x0388 }
        goto L_0x0357;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.remove.main(java.lang.String[]):void");
    }
}
