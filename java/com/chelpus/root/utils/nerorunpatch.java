package com.chelpus.root.utils;

public class nerorunpatch {
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
    private static String dalvikDexIn2 = "/cache/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r64) {
        /*
        r34 = 0;
        com.chelpus.Utils.startRootJava();
        r3 = 0;
        r3 = r64[r3];
        com.chelpus.Utils.kill(r3);
        r3 = 24;
        r8 = new byte[r3];
        r8 = {18, 36, 18, 19, 18, 2, 34, 0, 111, 0, 26, 1, 1, 1, 112, 48, 61, 1, 16, 2, 105, 0, 76, 0};
        r3 = 24;
        r0 = new byte[r3];
        r37 = r0;
        r37 = {0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 5, 5};
        r3 = 8;
        r10 = new byte[r3];
        r10 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r39 = r0;
        r39 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r18 = r0;
        r18 = {16, 0, 0, 0, 0, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r56 = r0;
        r56 = {0, 0, 0, 0, 1, 1, 1, 1};
        r3 = 8;
        r11 = new byte[r3];
        r11 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r40 = r0;
        r40 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r19 = r0;
        r19 = {16, 0, 0, 0, 41, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r57 = r0;
        r57 = {0, 0, 0, 0, 1, 1, 0, 0};
        r3 = 8;
        r12 = new byte[r3];
        r12 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r41 = r0;
        r41 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r20 = r0;
        r20 = {16, 0, 0, 0, 41, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r58 = r0;
        r58 = {0, 0, 0, 0, 1, 1, 0, 0};
        r3 = 8;
        r13 = new byte[r3];
        r13 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r42 = r0;
        r42 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r21 = r0;
        r21 = {16, 0, 0, 0, 41, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r59 = r0;
        r59 = {0, 0, 0, 0, 1, 1, 0, 0};
        r3 = 8;
        r14 = new byte[r3];
        r14 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r43 = r0;
        r43 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r22 = r0;
        r22 = {16, 0, 0, 0, 0, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r60 = r0;
        r60 = {0, 0, 0, 0, 1, 1, 1, 1};
        r3 = 8;
        r15 = new byte[r3];
        r15 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r44 = r0;
        r44 = {0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 8;
        r0 = new byte[r3];
        r23 = r0;
        r23 = {16, 0, 0, 0, 0, 0, 0, 0};
        r3 = 8;
        r0 = new byte[r3];
        r61 = r0;
        r61 = {0, 0, 0, 0, 1, 1, 1, 1};
        r3 = 16;
        r0 = new byte[r3];
        r16 = r0;
        r16 = {98, 3, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 56, -1, -1, -1};
        r3 = 16;
        r0 = new byte[r3];
        r45 = r0;
        r45 = {0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1};
        r3 = 16;
        r0 = new byte[r3];
        r24 = r0;
        r24 = {16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 16;
        r0 = new byte[r3];
        r62 = r0;
        r62 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        r3 = 16;
        r9 = new byte[r3];
        r9 = {98, 3, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 57, -1, -1, -1};
        r3 = 16;
        r0 = new byte[r3];
        r38 = r0;
        r38 = {0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1};
        r3 = 16;
        r0 = new byte[r3];
        r17 = r0;
        r17 = {16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 41, 0, 0, 0};
        r3 = 16;
        r0 = new byte[r3];
        r55 = r0;
        r55 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0};
        r3 = dalvikDexIn;
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r64[r5];
        r28 = r3.replace(r4, r5);
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r1 = r28;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 != 0) goto L_0x0158;
    L_0x0147:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "-2";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x0158:
        r35 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r35;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x08dd, IOException -> 0x08d9 }
        if (r3 == 0) goto L_0x08e2;
    L_0x016f:
        r34 = r33;
    L_0x0171:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r28;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r29;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r1 = r29;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x0196;
    L_0x0194:
        r34 = r33;
    L_0x0196:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "-2";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x01af;
    L_0x01ad:
        r34 = r33;
    L_0x01af:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x01c8;
    L_0x01c6:
        r34 = r33;
    L_0x01c8:
        r3 = dalvikDexIn2;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r64[r5];	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r28 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r1 = r28;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 != 0) goto L_0x01f3;
    L_0x01e2:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "-2";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x01f3:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 != 0) goto L_0x020a;
    L_0x01f9:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x020a:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x0212;
    L_0x0210:
        r34 = r33;
    L_0x0212:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r28;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r29;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r1 = r29;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x0237;
    L_0x0235:
        r34 = r33;
    L_0x0237:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "-2";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x0250;
    L_0x024e:
        r34 = r33;
    L_0x0250:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x0269;
    L_0x0267:
        r34 = r33;
    L_0x0269:
        r3 = dalvikDexIn;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r64[r5];	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r28 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "/data/";
        r4 = "/sd-ext/data/";
        r0 = r28;
        r28 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r1 = r28;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 != 0) goto L_0x029e;
    L_0x028d:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "-2";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x029e:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 != 0) goto L_0x02b5;
    L_0x02a4:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x02b5:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x02bd;
    L_0x02bb:
        r34 = r33;
    L_0x02bd:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r28;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r29;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r1 = r29;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x02e2;
    L_0x02e0:
        r34 = r33;
    L_0x02e2:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "-2";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x02fb;
    L_0x02f9:
        r34 = r33;
    L_0x02fb:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x0314;
    L_0x0312:
        r34 = r33;
    L_0x0314:
        r3 = dalvikDexIn2;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r64[r5];	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r28 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "/cache/";
        r4 = "/sd-ext/data/cache/";
        r0 = r28;
        r28 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r1 = r28;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 != 0) goto L_0x0349;
    L_0x0338:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "-2";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x0349:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 != 0) goto L_0x0360;
    L_0x034f:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x0360:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x0368;
    L_0x0366:
        r34 = r33;
    L_0x0368:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r28;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r29;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r1 = r29;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x038d;
    L_0x038b:
        r34 = r33;
    L_0x038d:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "-2";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x03a6;
    L_0x03a4:
        r34 = r33;
    L_0x03a6:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = "-1";
        r4 = "";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x03bf;
    L_0x03bd:
        r34 = r33;
    L_0x03bf:
        r3 = r34.exists();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 != 0) goto L_0x073b;
    L_0x03c5:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        throw r3;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x03cb:
        r36 = move-exception;
    L_0x03cc:
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
    L_0x03d3:
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
        r3 = r64[r3];
        r4 = "object";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x0737;
    L_0x03f9:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = "rw";
        r0 = r34;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r31 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r48 = 0;
        r49 = 0;
        r50 = 0;
        r51 = 0;
        r52 = 0;
        r53 = 0;
        r27 = 0;
        r26 = -1;
    L_0x0424:
        r3 = r31.hasRemaining();	 Catch:{ Exception -> 0x06e3 }
        if (r3 == 0) goto L_0x06fe;
    L_0x042a:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r27 = r31.position();	 Catch:{ Exception -> 0x06e3 }
        r26 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        r3 = 0;
        r3 = r10[r3];	 Catch:{ Exception -> 0x06e3 }
        r0 = r26;
        if (r0 != r3) goto L_0x048e;
    L_0x0440:
        r3 = 0;
        r3 = r56[r3];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x0448;
    L_0x0445:
        r3 = 0;
        r18[r3] = r26;	 Catch:{ Exception -> 0x06e3 }
    L_0x0448:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
    L_0x0455:
        r3 = r10[r32];	 Catch:{ Exception -> 0x06e3 }
        r0 = r54;
        if (r0 == r3) goto L_0x0460;
    L_0x045b:
        r3 = r39[r32];	 Catch:{ Exception -> 0x06e3 }
        r4 = 1;
        if (r3 != r4) goto L_0x0487;
    L_0x0460:
        r3 = r56[r32];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x0466;
    L_0x0464:
        r18[r32] = r54;	 Catch:{ Exception -> 0x06e3 }
    L_0x0466:
        r32 = r32 + 1;
        r3 = r10.length;	 Catch:{ Exception -> 0x06e3 }
        r0 = r32;
        if (r0 != r3) goto L_0x0882;
    L_0x046d:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x06e3 }
        r0 = r31;
        r1 = r18;
        r0.put(r1);	 Catch:{ Exception -> 0x06e3 }
        r31.force();	 Catch:{ Exception -> 0x06e3 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x06e3 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x06e3 }
        r49 = 1;
    L_0x0487:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
    L_0x048e:
        r3 = 0;
        r3 = r13[r3];	 Catch:{ Exception -> 0x06e3 }
        r0 = r26;
        if (r0 != r3) goto L_0x04e3;
    L_0x0495:
        r3 = 0;
        r3 = r59[r3];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x049d;
    L_0x049a:
        r3 = 0;
        r21[r3] = r26;	 Catch:{ Exception -> 0x06e3 }
    L_0x049d:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
    L_0x04aa:
        r3 = r13[r32];	 Catch:{ Exception -> 0x06e3 }
        r0 = r54;
        if (r0 == r3) goto L_0x04b5;
    L_0x04b0:
        r3 = r42[r32];	 Catch:{ Exception -> 0x06e3 }
        r4 = 1;
        if (r3 != r4) goto L_0x04dc;
    L_0x04b5:
        r3 = r59[r32];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x04bb;
    L_0x04b9:
        r21[r32] = r54;	 Catch:{ Exception -> 0x06e3 }
    L_0x04bb:
        r32 = r32 + 1;
        r3 = r13.length;	 Catch:{ Exception -> 0x06e3 }
        r0 = r32;
        if (r0 != r3) goto L_0x0888;
    L_0x04c2:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x06e3 }
        r0 = r31;
        r1 = r21;
        r0.put(r1);	 Catch:{ Exception -> 0x06e3 }
        r31.force();	 Catch:{ Exception -> 0x06e3 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x06e3 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x06e3 }
        r50 = 1;
    L_0x04dc:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
    L_0x04e3:
        r3 = 0;
        r3 = r11[r3];	 Catch:{ Exception -> 0x06e3 }
        r0 = r26;
        if (r0 != r3) goto L_0x0538;
    L_0x04ea:
        r3 = 0;
        r3 = r57[r3];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x04f2;
    L_0x04ef:
        r3 = 0;
        r19[r3] = r26;	 Catch:{ Exception -> 0x06e3 }
    L_0x04f2:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
    L_0x04ff:
        r3 = r11[r32];	 Catch:{ Exception -> 0x06e3 }
        r0 = r54;
        if (r0 == r3) goto L_0x050a;
    L_0x0505:
        r3 = r40[r32];	 Catch:{ Exception -> 0x06e3 }
        r4 = 1;
        if (r3 != r4) goto L_0x0531;
    L_0x050a:
        r3 = r57[r32];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x0510;
    L_0x050e:
        r19[r32] = r54;	 Catch:{ Exception -> 0x06e3 }
    L_0x0510:
        r32 = r32 + 1;
        r3 = r11.length;	 Catch:{ Exception -> 0x06e3 }
        r0 = r32;
        if (r0 != r3) goto L_0x088e;
    L_0x0517:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x06e3 }
        r0 = r31;
        r1 = r19;
        r0.put(r1);	 Catch:{ Exception -> 0x06e3 }
        r31.force();	 Catch:{ Exception -> 0x06e3 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x06e3 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x06e3 }
        r51 = 1;
    L_0x0531:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
    L_0x0538:
        r3 = 0;
        r3 = r12[r3];	 Catch:{ Exception -> 0x06e3 }
        r0 = r26;
        if (r0 != r3) goto L_0x058d;
    L_0x053f:
        r3 = 0;
        r3 = r58[r3];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x0547;
    L_0x0544:
        r3 = 0;
        r20[r3] = r26;	 Catch:{ Exception -> 0x06e3 }
    L_0x0547:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
    L_0x0554:
        r3 = r12[r32];	 Catch:{ Exception -> 0x06e3 }
        r0 = r54;
        if (r0 == r3) goto L_0x055f;
    L_0x055a:
        r3 = r41[r32];	 Catch:{ Exception -> 0x06e3 }
        r4 = 1;
        if (r3 != r4) goto L_0x0586;
    L_0x055f:
        r3 = r58[r32];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x0565;
    L_0x0563:
        r20[r32] = r54;	 Catch:{ Exception -> 0x06e3 }
    L_0x0565:
        r32 = r32 + 1;
        r3 = r12.length;	 Catch:{ Exception -> 0x06e3 }
        r0 = r32;
        if (r0 != r3) goto L_0x0894;
    L_0x056c:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x06e3 }
        r0 = r31;
        r1 = r20;
        r0.put(r1);	 Catch:{ Exception -> 0x06e3 }
        r31.force();	 Catch:{ Exception -> 0x06e3 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x06e3 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x06e3 }
        r52 = 1;
    L_0x0586:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
    L_0x058d:
        r3 = 0;
        r3 = r14[r3];	 Catch:{ Exception -> 0x06e3 }
        r0 = r26;
        if (r0 != r3) goto L_0x05e2;
    L_0x0594:
        r3 = 0;
        r3 = r60[r3];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x059c;
    L_0x0599:
        r3 = 0;
        r22[r3] = r26;	 Catch:{ Exception -> 0x06e3 }
    L_0x059c:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
    L_0x05a9:
        r3 = r14[r32];	 Catch:{ Exception -> 0x06e3 }
        r0 = r54;
        if (r0 == r3) goto L_0x05b4;
    L_0x05af:
        r3 = r43[r32];	 Catch:{ Exception -> 0x06e3 }
        r4 = 1;
        if (r3 != r4) goto L_0x05db;
    L_0x05b4:
        r3 = r60[r32];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x05ba;
    L_0x05b8:
        r22[r32] = r54;	 Catch:{ Exception -> 0x06e3 }
    L_0x05ba:
        r32 = r32 + 1;
        r3 = r14.length;	 Catch:{ Exception -> 0x06e3 }
        r0 = r32;
        if (r0 != r3) goto L_0x089a;
    L_0x05c1:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x06e3 }
        r0 = r31;
        r1 = r22;
        r0.put(r1);	 Catch:{ Exception -> 0x06e3 }
        r31.force();	 Catch:{ Exception -> 0x06e3 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x06e3 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x06e3 }
        r53 = 1;
    L_0x05db:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
    L_0x05e2:
        r3 = 0;
        r3 = r16[r3];	 Catch:{ Exception -> 0x06e3 }
        r0 = r26;
        if (r0 != r3) goto L_0x0639;
    L_0x05e9:
        r3 = 0;
        r3 = r62[r3];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x05f1;
    L_0x05ee:
        r3 = 0;
        r24[r3] = r26;	 Catch:{ Exception -> 0x06e3 }
    L_0x05f1:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
    L_0x05fe:
        r3 = r16[r32];	 Catch:{ Exception -> 0x06e3 }
        r0 = r54;
        if (r0 == r3) goto L_0x0609;
    L_0x0604:
        r3 = r45[r32];	 Catch:{ Exception -> 0x06e3 }
        r4 = 1;
        if (r3 != r4) goto L_0x0632;
    L_0x0609:
        r3 = r62[r32];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x060f;
    L_0x060d:
        r24[r32] = r54;	 Catch:{ Exception -> 0x06e3 }
    L_0x060f:
        r32 = r32 + 1;
        r0 = r16;
        r3 = r0.length;	 Catch:{ Exception -> 0x06e3 }
        r0 = r32;
        if (r0 != r3) goto L_0x08a0;
    L_0x0618:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x06e3 }
        r0 = r31;
        r1 = r24;
        r0.put(r1);	 Catch:{ Exception -> 0x06e3 }
        r31.force();	 Catch:{ Exception -> 0x06e3 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x06e3 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x06e3 }
        r53 = 1;
    L_0x0632:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
    L_0x0639:
        r3 = 0;
        r3 = r9[r3];	 Catch:{ Exception -> 0x06e3 }
        r0 = r26;
        if (r0 != r3) goto L_0x068e;
    L_0x0640:
        r3 = 0;
        r3 = r55[r3];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x0648;
    L_0x0645:
        r3 = 0;
        r17[r3] = r26;	 Catch:{ Exception -> 0x06e3 }
    L_0x0648:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
    L_0x0655:
        r3 = r9[r32];	 Catch:{ Exception -> 0x06e3 }
        r0 = r54;
        if (r0 == r3) goto L_0x0660;
    L_0x065b:
        r3 = r38[r32];	 Catch:{ Exception -> 0x06e3 }
        r4 = 1;
        if (r3 != r4) goto L_0x0687;
    L_0x0660:
        r3 = r55[r32];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x0666;
    L_0x0664:
        r17[r32] = r54;	 Catch:{ Exception -> 0x06e3 }
    L_0x0666:
        r32 = r32 + 1;
        r3 = r9.length;	 Catch:{ Exception -> 0x06e3 }
        r0 = r32;
        if (r0 != r3) goto L_0x08a6;
    L_0x066d:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x06e3 }
        r0 = r31;
        r1 = r17;
        r0.put(r1);	 Catch:{ Exception -> 0x06e3 }
        r31.force();	 Catch:{ Exception -> 0x06e3 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x06e3 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x06e3 }
        r53 = 1;
    L_0x0687:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
    L_0x068e:
        r3 = 0;
        r3 = r15[r3];	 Catch:{ Exception -> 0x06e3 }
        r0 = r26;
        if (r0 != r3) goto L_0x0424;
    L_0x0695:
        r3 = 0;
        r3 = r61[r3];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x069d;
    L_0x069a:
        r3 = 0;
        r23[r3] = r26;	 Catch:{ Exception -> 0x06e3 }
    L_0x069d:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
    L_0x06aa:
        r3 = r15[r32];	 Catch:{ Exception -> 0x06e3 }
        r0 = r54;
        if (r0 == r3) goto L_0x06b5;
    L_0x06b0:
        r3 = r44[r32];	 Catch:{ Exception -> 0x06e3 }
        r4 = 1;
        if (r3 != r4) goto L_0x06da;
    L_0x06b5:
        r3 = r61[r32];	 Catch:{ Exception -> 0x06e3 }
        if (r3 != 0) goto L_0x06bb;
    L_0x06b9:
        r23[r32] = r54;	 Catch:{ Exception -> 0x06e3 }
    L_0x06bb:
        r32 = r32 + 1;
        r3 = r15.length;	 Catch:{ Exception -> 0x06e3 }
        r0 = r32;
        if (r0 != r3) goto L_0x08ac;
    L_0x06c2:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x06e3 }
        r0 = r31;
        r1 = r23;
        r0.put(r1);	 Catch:{ Exception -> 0x06e3 }
        r31.force();	 Catch:{ Exception -> 0x06e3 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x06e3 }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x06e3 }
    L_0x06da:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x06e3 }
        goto L_0x0424;
    L_0x06e3:
        r30 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r0 = r30;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
    L_0x06fe:
        r2.close();	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        if (r49 != 0) goto L_0x070a;
    L_0x0703:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = "Error: License Key2 patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
    L_0x070a:
        if (r50 != 0) goto L_0x0713;
    L_0x070c:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = "Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
    L_0x0713:
        if (r51 != 0) goto L_0x071c;
    L_0x0715:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = "Error: Check License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
    L_0x071c:
        if (r52 != 0) goto L_0x0725;
    L_0x071e:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
    L_0x0725:
        if (r53 != 0) goto L_0x072e;
    L_0x0727:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
    L_0x072e:
        if (r48 != 0) goto L_0x0737;
    L_0x0730:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
        r4 = "Error: Cached License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x08b2, IOException -> 0x08bc }
    L_0x0737:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x073b:
        r48 = 0;
        r63 = 1;
        r27 = 0;
        r46 = 0;
        r47 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = 1;
        r3 = r64[r3];	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = "object";
        r3 = r3.contains(r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r3 == 0) goto L_0x075f;
    L_0x0750:
        r3 = 1;
        r3 = r64[r3];	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = "object";
        r5 = "";
        r3 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r47 = java.lang.Integer.parseInt(r3);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
    L_0x075f:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = "rw";
        r0 = r34;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r31 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r26 = -1;
    L_0x077c:
        r3 = r31.hasRemaining();	 Catch:{ Exception -> 0x0836 }
        if (r3 == 0) goto L_0x0837;
    L_0x0782:
        r0 = r46;
        r1 = r47;
        if (r0 >= r1) goto L_0x0837;
    L_0x0788:
        r63 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x0836 }
        r27 = r31.position();	 Catch:{ Exception -> 0x0836 }
        r26 = r31.get();	 Catch:{ Exception -> 0x0836 }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x0836 }
        r0 = r26;
        if (r0 != r3) goto L_0x077c;
    L_0x07a0:
        r32 = 1;
        r25 = 2;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x0836 }
        r54 = r31.get();	 Catch:{ Exception -> 0x0836 }
    L_0x07af:
        if (r63 == 0) goto L_0x077c;
    L_0x07b1:
        r3 = r8[r32];	 Catch:{ Exception -> 0x0836 }
        r0 = r54;
        if (r0 == r3) goto L_0x07c1;
    L_0x07b7:
        r3 = r37[r32];	 Catch:{ Exception -> 0x0836 }
        r4 = 1;
        if (r3 == r4) goto L_0x07c1;
    L_0x07bc:
        r3 = r37[r32];	 Catch:{ Exception -> 0x0836 }
        r4 = 5;
        if (r3 != r4) goto L_0x077c;
    L_0x07c1:
        r3 = r37[r32];	 Catch:{ Exception -> 0x0836 }
        r4 = 5;
        if (r3 != r4) goto L_0x07e9;
    L_0x07c6:
        r10[r25] = r54;	 Catch:{ Exception -> 0x0836 }
        r13[r25] = r54;	 Catch:{ Exception -> 0x0836 }
        r16[r25] = r54;	 Catch:{ Exception -> 0x0836 }
        r9[r25] = r54;	 Catch:{ Exception -> 0x0836 }
        r3 = 2;
        r0 = r25;
        if (r0 != r3) goto L_0x082d;
    L_0x07d3:
        r3 = r54 + 1;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0836 }
        r11[r25] = r3;	 Catch:{ Exception -> 0x0836 }
        r3 = r54 + 2;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0836 }
        r12[r25] = r3;	 Catch:{ Exception -> 0x0836 }
        r3 = r54 + 1;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0836 }
        r14[r25] = r3;	 Catch:{ Exception -> 0x0836 }
        r3 = r54 + 2;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0836 }
        r15[r25] = r3;	 Catch:{ Exception -> 0x0836 }
    L_0x07e7:
        r25 = r25 + 1;
    L_0x07e9:
        r32 = r32 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x0836 }
        r0 = r32;
        if (r0 != r3) goto L_0x0828;
    L_0x07f0:
        r46 = r46 + 1;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r47;
        if (r0 != r3) goto L_0x0824;
    L_0x07f8:
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0836 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0836 }
        r4.<init>();	 Catch:{ Exception -> 0x0836 }
        r5 = "Serach ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0836 }
        r0 = r46;
        r4 = r4.append(r0);	 Catch:{ Exception -> 0x0836 }
        r5 = " - Done!\n";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0836 }
        r5 = " ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0836 }
        r5 = "byteOrig2[2]";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0836 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0836 }
        r3.println(r4);	 Catch:{ Exception -> 0x0836 }
    L_0x0824:
        r63 = 0;
        r48 = 1;
    L_0x0828:
        r54 = r31.get();	 Catch:{ Exception -> 0x0836 }
        goto L_0x07af;
    L_0x082d:
        r11[r25] = r54;	 Catch:{ Exception -> 0x0836 }
        r12[r25] = r54;	 Catch:{ Exception -> 0x0836 }
        r14[r25] = r54;	 Catch:{ Exception -> 0x0836 }
        r15[r25] = r54;	 Catch:{ Exception -> 0x0836 }
        goto L_0x07e7;
    L_0x0836:
        r3 = move-exception;
    L_0x0837:
        r2.close();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r5 = "{\"objects\":\"";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r0 = r46;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r5 = "\"}";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        if (r48 != 0) goto L_0x03d3;
    L_0x085c:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        r4 = "Error: Objects not Found!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x03cb, IOException -> 0x0865 }
        goto L_0x03d3;
    L_0x0865:
        r36 = move-exception;
    L_0x0866:
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "";
        r4 = r4.append(r5);
        r0 = r36;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x03d3;
    L_0x0882:
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        goto L_0x0455;
    L_0x0888:
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        goto L_0x04aa;
    L_0x088e:
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        goto L_0x04ff;
    L_0x0894:
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        goto L_0x0554;
    L_0x089a:
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        goto L_0x05a9;
    L_0x08a0:
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        goto L_0x05fe;
    L_0x08a6:
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        goto L_0x0655;
    L_0x08ac:
        r54 = r31.get();	 Catch:{ Exception -> 0x06e3 }
        goto L_0x06aa;
    L_0x08b2:
        r36 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
        goto L_0x0737;
    L_0x08bc:
        r36 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "";
        r4 = r4.append(r5);
        r0 = r36;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x0737;
    L_0x08d9:
        r36 = move-exception;
        r34 = r35;
        goto L_0x0866;
    L_0x08dd:
        r36 = move-exception;
        r34 = r35;
        goto L_0x03cc;
    L_0x08e2:
        r34 = r35;
        goto L_0x0171;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.nerorunpatch.main(java.lang.String[]):void");
    }
}
