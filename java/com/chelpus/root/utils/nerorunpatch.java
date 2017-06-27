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
        r37 = r0;
        r3 = 1;
        r4 = 1;
        r37[r3] = r4;
        r3 = 3;
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
        r4 = 1;
        r37[r3] = r4;
        r3 = 9;
        r4 = 1;
        r37[r3] = r4;
        r3 = 11;
        r4 = 1;
        r37[r3] = r4;
        r3 = 12;
        r4 = 1;
        r37[r3] = r4;
        r3 = 13;
        r4 = 1;
        r37[r3] = r4;
        r3 = 16;
        r4 = 1;
        r37[r3] = r4;
        r3 = 17;
        r4 = 1;
        r37[r3] = r4;
        r3 = 18;
        r4 = 1;
        r37[r3] = r4;
        r3 = 19;
        r4 = 1;
        r37[r3] = r4;
        r3 = 22;
        r4 = 5;
        r37[r3] = r4;
        r3 = 23;
        r4 = 5;
        r37[r3] = r4;
        r3 = 8;
        r10 = new byte[r3];
        r10 = {98, 3, -1, -1, 51, -1, -1, -1};
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
        r18 = r0;
        r3 = 0;
        r4 = 16;
        r18[r3] = r4;
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
        r3 = 8;
        r11 = new byte[r3];
        r11 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r40 = r0;
        r3 = 1;
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
        r57 = r0;
        r3 = 4;
        r4 = 1;
        r57[r3] = r4;
        r3 = 5;
        r4 = 1;
        r57[r3] = r4;
        r3 = 8;
        r12 = new byte[r3];
        r12 = {98, 3, -1, -1, 51, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r41 = r0;
        r3 = 1;
        r4 = 1;
        r41[r3] = r4;
        r3 = 5;
        r4 = 1;
        r41[r3] = r4;
        r3 = 6;
        r4 = 1;
        r41[r3] = r4;
        r3 = 7;
        r4 = 1;
        r41[r3] = r4;
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
        r58 = r0;
        r3 = 4;
        r4 = 1;
        r58[r3] = r4;
        r3 = 5;
        r4 = 1;
        r58[r3] = r4;
        r3 = 8;
        r13 = new byte[r3];
        r13 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r42 = r0;
        r3 = 1;
        r4 = 1;
        r42[r3] = r4;
        r3 = 5;
        r4 = 1;
        r42[r3] = r4;
        r3 = 6;
        r4 = 1;
        r42[r3] = r4;
        r3 = 7;
        r4 = 1;
        r42[r3] = r4;
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
        r59 = r0;
        r3 = 4;
        r4 = 1;
        r59[r3] = r4;
        r3 = 5;
        r4 = 1;
        r59[r3] = r4;
        r3 = 8;
        r14 = new byte[r3];
        r14 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r43 = r0;
        r3 = 1;
        r4 = 1;
        r43[r3] = r4;
        r3 = 5;
        r4 = 1;
        r43[r3] = r4;
        r3 = 6;
        r4 = 1;
        r43[r3] = r4;
        r3 = 7;
        r4 = 1;
        r43[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r22 = r0;
        r3 = 0;
        r4 = 16;
        r22[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r60 = r0;
        r3 = 4;
        r4 = 1;
        r60[r3] = r4;
        r3 = 5;
        r4 = 1;
        r60[r3] = r4;
        r3 = 6;
        r4 = 1;
        r60[r3] = r4;
        r3 = 7;
        r4 = 1;
        r60[r3] = r4;
        r3 = 8;
        r15 = new byte[r3];
        r15 = {98, 3, -1, -1, 50, -1, -1, -1};
        r3 = 8;
        r0 = new byte[r3];
        r44 = r0;
        r3 = 1;
        r4 = 1;
        r44[r3] = r4;
        r3 = 5;
        r4 = 1;
        r44[r3] = r4;
        r3 = 6;
        r4 = 1;
        r44[r3] = r4;
        r3 = 7;
        r4 = 1;
        r44[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r23 = r0;
        r3 = 0;
        r4 = 16;
        r23[r3] = r4;
        r3 = 8;
        r0 = new byte[r3];
        r61 = r0;
        r3 = 4;
        r4 = 1;
        r61[r3] = r4;
        r3 = 5;
        r4 = 1;
        r61[r3] = r4;
        r3 = 6;
        r4 = 1;
        r61[r3] = r4;
        r3 = 7;
        r4 = 1;
        r61[r3] = r4;
        r3 = 16;
        r0 = new byte[r3];
        r16 = r0;
        r16 = {98, 3, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 56, -1, -1, -1};
        r3 = 16;
        r0 = new byte[r3];
        r45 = r0;
        r3 = 1;
        r4 = 1;
        r45[r3] = r4;
        r3 = 4;
        r4 = 1;
        r45[r3] = r4;
        r3 = 5;
        r4 = 1;
        r45[r3] = r4;
        r3 = 6;
        r4 = 1;
        r45[r3] = r4;
        r3 = 7;
        r4 = 1;
        r45[r3] = r4;
        r3 = 8;
        r4 = 1;
        r45[r3] = r4;
        r3 = 9;
        r4 = 1;
        r45[r3] = r4;
        r3 = 11;
        r4 = 1;
        r45[r3] = r4;
        r3 = 13;
        r4 = 1;
        r45[r3] = r4;
        r3 = 14;
        r4 = 1;
        r45[r3] = r4;
        r3 = 15;
        r4 = 1;
        r45[r3] = r4;
        r3 = 16;
        r0 = new byte[r3];
        r24 = r0;
        r3 = 0;
        r4 = 16;
        r24[r3] = r4;
        r3 = 16;
        r0 = new byte[r3];
        r62 = r0;
        r3 = 12;
        r4 = 1;
        r62[r3] = r4;
        r3 = 13;
        r4 = 1;
        r62[r3] = r4;
        r3 = 14;
        r4 = 1;
        r62[r3] = r4;
        r3 = 15;
        r4 = 1;
        r62[r3] = r4;
        r3 = 16;
        r9 = new byte[r3];
        r9 = {98, 3, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 57, -1, -1, -1};
        r3 = 16;
        r0 = new byte[r3];
        r38 = r0;
        r3 = 1;
        r4 = 1;
        r38[r3] = r4;
        r3 = 4;
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
        r4 = 1;
        r38[r3] = r4;
        r3 = 9;
        r4 = 1;
        r38[r3] = r4;
        r3 = 11;
        r4 = 1;
        r38[r3] = r4;
        r3 = 13;
        r4 = 1;
        r38[r3] = r4;
        r3 = 14;
        r4 = 1;
        r38[r3] = r4;
        r3 = 15;
        r4 = 1;
        r38[r3] = r4;
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
        r55 = r0;
        r3 = 12;
        r4 = 1;
        r55[r3] = r4;
        r3 = 13;
        r4 = 1;
        r55[r3] = r4;
        r3 = dalvikDexIn;
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r64[r5];
        r28 = r3.replace(r4, r5);
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r1 = r28;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 != 0) goto L_0x0327;
    L_0x0316:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "-2";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x0327:
        r35 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r35;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x0aa3, IOException -> 0x0a9e }
        if (r3 == 0) goto L_0x0aa8;
    L_0x033e:
        r34 = r33;
    L_0x0340:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r28;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r29;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r1 = r29;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x0365;
    L_0x0363:
        r34 = r33;
    L_0x0365:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "-2";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x037e;
    L_0x037c:
        r34 = r33;
    L_0x037e:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x0397;
    L_0x0395:
        r34 = r33;
    L_0x0397:
        r3 = dalvikDexIn2;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r64[r5];	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r28 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r1 = r28;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 != 0) goto L_0x03c2;
    L_0x03b1:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "-2";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x03c2:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 != 0) goto L_0x03d9;
    L_0x03c8:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x03d9:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x03e1;
    L_0x03df:
        r34 = r33;
    L_0x03e1:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r28;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r29;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r1 = r29;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x0406;
    L_0x0404:
        r34 = r33;
    L_0x0406:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "-2";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x041f;
    L_0x041d:
        r34 = r33;
    L_0x041f:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x0438;
    L_0x0436:
        r34 = r33;
    L_0x0438:
        r3 = dalvikDexIn;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r64[r5];	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r28 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "/data/";
        r4 = "/sd-ext/data/";
        r0 = r28;
        r28 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r1 = r28;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 != 0) goto L_0x046d;
    L_0x045c:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "-2";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x046d:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 != 0) goto L_0x0484;
    L_0x0473:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x0484:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x048c;
    L_0x048a:
        r34 = r33;
    L_0x048c:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r28;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r29;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r1 = r29;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x04b1;
    L_0x04af:
        r34 = r33;
    L_0x04b1:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "-2";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x04ca;
    L_0x04c8:
        r34 = r33;
    L_0x04ca:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x04e3;
    L_0x04e1:
        r34 = r33;
    L_0x04e3:
        r3 = dalvikDexIn2;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r64[r5];	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r28 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "/cache/";
        r4 = "/sd-ext/data/cache/";
        r0 = r28;
        r28 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r1 = r28;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 != 0) goto L_0x0518;
    L_0x0507:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "-2";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x0518:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 != 0) goto L_0x052f;
    L_0x051e:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "";
        r0 = r28;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x052f:
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x0537;
    L_0x0535:
        r34 = r33;
    L_0x0537:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r28;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r29;
        r29 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r1 = r29;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x055c;
    L_0x055a:
        r34 = r33;
    L_0x055c:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "-2";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x0575;
    L_0x0573:
        r34 = r33;
    L_0x0575:
        r33 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = "-1";
        r4 = "";
        r0 = r29;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r33;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = r33.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x058e;
    L_0x058c:
        r34 = r33;
    L_0x058e:
        r3 = r34.exists();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 != 0) goto L_0x0632;
    L_0x0594:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        throw r3;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x059a:
        r36 = move-exception;
    L_0x059b:
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
    L_0x05a2:
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
        r3 = r64[r3];
        r4 = "object";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x062e;
    L_0x05c4:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = "rw";
        r0 = r34;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r31 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r48 = 0;
        r49 = 0;
        r50 = 0;
        r51 = 0;
        r52 = 0;
        r53 = 0;
        r27 = 0;
        r26 = -1;
    L_0x05ef:
        r3 = r31.hasRemaining();	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x076d;
    L_0x05f5:
        r2.close();	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        if (r49 != 0) goto L_0x0601;
    L_0x05fa:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = "Error: License Key2 patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
    L_0x0601:
        if (r50 != 0) goto L_0x060a;
    L_0x0603:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = "Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
    L_0x060a:
        if (r51 != 0) goto L_0x0613;
    L_0x060c:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = "Error: Check License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
    L_0x0613:
        if (r52 != 0) goto L_0x061c;
    L_0x0615:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
    L_0x061c:
        if (r53 != 0) goto L_0x0625;
    L_0x061e:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = "Error: Market Free patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
    L_0x0625:
        if (r48 != 0) goto L_0x062e;
    L_0x0627:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = "Error: Cached License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
    L_0x062e:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x0632:
        r48 = 0;
        r63 = 1;
        r27 = 0;
        r46 = 0;
        r47 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = 1;
        r3 = r64[r3];	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = "object";
        r3 = r3.contains(r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r3 == 0) goto L_0x0656;
    L_0x0647:
        r3 = 1;
        r3 = r64[r3];	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = "object";
        r5 = "";
        r3 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r47 = java.lang.Integer.parseInt(r3);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
    L_0x0656:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = "rw";
        r0 = r34;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r31 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r26 = -1;
    L_0x0673:
        r3 = r31.hasRemaining();	 Catch:{ Exception -> 0x076a }
        if (r3 == 0) goto L_0x067f;
    L_0x0679:
        r0 = r46;
        r1 = r47;
        if (r0 < r1) goto L_0x06c0;
    L_0x067f:
        r2.close();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r5 = "{\"objects\":\"";
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r0 = r46;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r5 = "\"}";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        if (r48 != 0) goto L_0x05a2;
    L_0x06a0:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        r4 = "Error: Objects not Found!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x059a, IOException -> 0x06a9 }
        goto L_0x05a2;
    L_0x06a9:
        r36 = move-exception;
    L_0x06aa:
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r36;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x05a2;
    L_0x06c0:
        r63 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x076a }
        r27 = r31.position();	 Catch:{ Exception -> 0x076a }
        r26 = r31.get();	 Catch:{ Exception -> 0x076a }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x076a }
        r0 = r26;
        if (r0 != r3) goto L_0x0673;
    L_0x06d8:
        r32 = 1;
        r25 = 2;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x076a }
        r54 = r31.get();	 Catch:{ Exception -> 0x076a }
    L_0x06e7:
        if (r63 == 0) goto L_0x0673;
    L_0x06e9:
        r3 = r8[r32];	 Catch:{ Exception -> 0x076a }
        r0 = r54;
        if (r0 == r3) goto L_0x06f9;
    L_0x06ef:
        r3 = r37[r32];	 Catch:{ Exception -> 0x076a }
        r4 = 1;
        if (r3 == r4) goto L_0x06f9;
    L_0x06f4:
        r3 = r37[r32];	 Catch:{ Exception -> 0x076a }
        r4 = 5;
        if (r3 != r4) goto L_0x0673;
    L_0x06f9:
        r3 = r37[r32];	 Catch:{ Exception -> 0x076a }
        r4 = 5;
        if (r3 != r4) goto L_0x0721;
    L_0x06fe:
        r10[r25] = r54;	 Catch:{ Exception -> 0x076a }
        r13[r25] = r54;	 Catch:{ Exception -> 0x076a }
        r16[r25] = r54;	 Catch:{ Exception -> 0x076a }
        r9[r25] = r54;	 Catch:{ Exception -> 0x076a }
        r3 = 2;
        r0 = r25;
        if (r0 != r3) goto L_0x0761;
    L_0x070b:
        r3 = r54 + 1;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x076a }
        r11[r25] = r3;	 Catch:{ Exception -> 0x076a }
        r3 = r54 + 2;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x076a }
        r12[r25] = r3;	 Catch:{ Exception -> 0x076a }
        r3 = r54 + 1;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x076a }
        r14[r25] = r3;	 Catch:{ Exception -> 0x076a }
        r3 = r54 + 2;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x076a }
        r15[r25] = r3;	 Catch:{ Exception -> 0x076a }
    L_0x071f:
        r25 = r25 + 1;
    L_0x0721:
        r32 = r32 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x076a }
        r0 = r32;
        if (r0 != r3) goto L_0x075c;
    L_0x0728:
        r46 = r46 + 1;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r47;
        if (r0 != r3) goto L_0x0758;
    L_0x0730:
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x076a }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x076a }
        r5 = "Serach ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x076a }
        r0 = r46;
        r4 = r4.append(r0);	 Catch:{ Exception -> 0x076a }
        r5 = " - Done!\n";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x076a }
        r5 = " ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x076a }
        r5 = "byteOrig2[2]";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x076a }
        r4 = r4.toString();	 Catch:{ Exception -> 0x076a }
        r3.println(r4);	 Catch:{ Exception -> 0x076a }
    L_0x0758:
        r63 = 0;
        r48 = 1;
    L_0x075c:
        r54 = r31.get();	 Catch:{ Exception -> 0x076a }
        goto L_0x06e7;
    L_0x0761:
        r11[r25] = r54;	 Catch:{ Exception -> 0x076a }
        r12[r25] = r54;	 Catch:{ Exception -> 0x076a }
        r14[r25] = r54;	 Catch:{ Exception -> 0x076a }
        r15[r25] = r54;	 Catch:{ Exception -> 0x076a }
        goto L_0x071f;
    L_0x076a:
        r3 = move-exception;
        goto L_0x067f;
    L_0x076d:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r27 = r31.position();	 Catch:{ Exception -> 0x08ee }
        r26 = r31.get();	 Catch:{ Exception -> 0x08ee }
        r3 = 0;
        r3 = r10[r3];	 Catch:{ Exception -> 0x08ee }
        r0 = r26;
        if (r0 != r3) goto L_0x07aa;
    L_0x0783:
        r3 = 0;
        r3 = r56[r3];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x078b;
    L_0x0788:
        r3 = 0;
        r18[r3] = r26;	 Catch:{ Exception -> 0x08ee }
    L_0x078b:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
    L_0x0798:
        r3 = r10[r32];	 Catch:{ Exception -> 0x08ee }
        r0 = r54;
        if (r0 == r3) goto L_0x090f;
    L_0x079e:
        r3 = r39[r32];	 Catch:{ Exception -> 0x08ee }
        r4 = 1;
        if (r3 == r4) goto L_0x090f;
    L_0x07a3:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
    L_0x07aa:
        r3 = 0;
        r3 = r13[r3];	 Catch:{ Exception -> 0x08ee }
        r0 = r26;
        if (r0 != r3) goto L_0x07d8;
    L_0x07b1:
        r3 = 0;
        r3 = r59[r3];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x07b9;
    L_0x07b6:
        r3 = 0;
        r21[r3] = r26;	 Catch:{ Exception -> 0x08ee }
    L_0x07b9:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
    L_0x07c6:
        r3 = r13[r32];	 Catch:{ Exception -> 0x08ee }
        r0 = r54;
        if (r0 == r3) goto L_0x093e;
    L_0x07cc:
        r3 = r42[r32];	 Catch:{ Exception -> 0x08ee }
        r4 = 1;
        if (r3 == r4) goto L_0x093e;
    L_0x07d1:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
    L_0x07d8:
        r3 = 0;
        r3 = r11[r3];	 Catch:{ Exception -> 0x08ee }
        r0 = r26;
        if (r0 != r3) goto L_0x0806;
    L_0x07df:
        r3 = 0;
        r3 = r57[r3];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x07e7;
    L_0x07e4:
        r3 = 0;
        r19[r3] = r26;	 Catch:{ Exception -> 0x08ee }
    L_0x07e7:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
    L_0x07f4:
        r3 = r11[r32];	 Catch:{ Exception -> 0x08ee }
        r0 = r54;
        if (r0 == r3) goto L_0x096d;
    L_0x07fa:
        r3 = r40[r32];	 Catch:{ Exception -> 0x08ee }
        r4 = 1;
        if (r3 == r4) goto L_0x096d;
    L_0x07ff:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
    L_0x0806:
        r3 = 0;
        r3 = r12[r3];	 Catch:{ Exception -> 0x08ee }
        r0 = r26;
        if (r0 != r3) goto L_0x0834;
    L_0x080d:
        r3 = 0;
        r3 = r58[r3];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0815;
    L_0x0812:
        r3 = 0;
        r20[r3] = r26;	 Catch:{ Exception -> 0x08ee }
    L_0x0815:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
    L_0x0822:
        r3 = r12[r32];	 Catch:{ Exception -> 0x08ee }
        r0 = r54;
        if (r0 == r3) goto L_0x099c;
    L_0x0828:
        r3 = r41[r32];	 Catch:{ Exception -> 0x08ee }
        r4 = 1;
        if (r3 == r4) goto L_0x099c;
    L_0x082d:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
    L_0x0834:
        r3 = 0;
        r3 = r14[r3];	 Catch:{ Exception -> 0x08ee }
        r0 = r26;
        if (r0 != r3) goto L_0x0862;
    L_0x083b:
        r3 = 0;
        r3 = r60[r3];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0843;
    L_0x0840:
        r3 = 0;
        r22[r3] = r26;	 Catch:{ Exception -> 0x08ee }
    L_0x0843:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
    L_0x0850:
        r3 = r14[r32];	 Catch:{ Exception -> 0x08ee }
        r0 = r54;
        if (r0 == r3) goto L_0x09cb;
    L_0x0856:
        r3 = r43[r32];	 Catch:{ Exception -> 0x08ee }
        r4 = 1;
        if (r3 == r4) goto L_0x09cb;
    L_0x085b:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
    L_0x0862:
        r3 = 0;
        r3 = r16[r3];	 Catch:{ Exception -> 0x08ee }
        r0 = r26;
        if (r0 != r3) goto L_0x0890;
    L_0x0869:
        r3 = 0;
        r3 = r62[r3];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0871;
    L_0x086e:
        r3 = 0;
        r24[r3] = r26;	 Catch:{ Exception -> 0x08ee }
    L_0x0871:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
    L_0x087e:
        r3 = r16[r32];	 Catch:{ Exception -> 0x08ee }
        r0 = r54;
        if (r0 == r3) goto L_0x09fa;
    L_0x0884:
        r3 = r45[r32];	 Catch:{ Exception -> 0x08ee }
        r4 = 1;
        if (r3 == r4) goto L_0x09fa;
    L_0x0889:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
    L_0x0890:
        r3 = 0;
        r3 = r9[r3];	 Catch:{ Exception -> 0x08ee }
        r0 = r26;
        if (r0 != r3) goto L_0x08be;
    L_0x0897:
        r3 = 0;
        r3 = r55[r3];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x089f;
    L_0x089c:
        r3 = 0;
        r17[r3] = r26;	 Catch:{ Exception -> 0x08ee }
    L_0x089f:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
    L_0x08ac:
        r3 = r9[r32];	 Catch:{ Exception -> 0x08ee }
        r0 = r54;
        if (r0 == r3) goto L_0x0a2b;
    L_0x08b2:
        r3 = r38[r32];	 Catch:{ Exception -> 0x08ee }
        r4 = 1;
        if (r3 == r4) goto L_0x0a2b;
    L_0x08b7:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
    L_0x08be:
        r3 = 0;
        r3 = r15[r3];	 Catch:{ Exception -> 0x08ee }
        r0 = r26;
        if (r0 != r3) goto L_0x05ef;
    L_0x08c5:
        r3 = 0;
        r3 = r61[r3];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x08cd;
    L_0x08ca:
        r3 = 0;
        r23[r3] = r26;	 Catch:{ Exception -> 0x08ee }
    L_0x08cd:
        r32 = 1;
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
    L_0x08da:
        r3 = r15[r32];	 Catch:{ Exception -> 0x08ee }
        r0 = r54;
        if (r0 == r3) goto L_0x0a5a;
    L_0x08e0:
        r3 = r44[r32];	 Catch:{ Exception -> 0x08ee }
        r4 = 1;
        if (r3 == r4) goto L_0x0a5a;
    L_0x08e5:
        r3 = r27 + 1;
        r0 = r31;
        r0.position(r3);	 Catch:{ Exception -> 0x08ee }
        goto L_0x05ef;
    L_0x08ee:
        r30 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r0 = r30;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0905, IOException -> 0x0a81 }
        goto L_0x05f5;
    L_0x0905:
        r36 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
        goto L_0x062e;
    L_0x090f:
        r3 = r56[r32];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0915;
    L_0x0913:
        r18[r32] = r54;	 Catch:{ Exception -> 0x08ee }
    L_0x0915:
        r32 = r32 + 1;
        r3 = r10.length;	 Catch:{ Exception -> 0x08ee }
        r0 = r32;
        if (r0 != r3) goto L_0x0938;
    L_0x091c:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x08ee }
        r0 = r31;
        r1 = r18;
        r0.put(r1);	 Catch:{ Exception -> 0x08ee }
        r31.force();	 Catch:{ Exception -> 0x08ee }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x08ee }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x08ee }
        r49 = 1;
        goto L_0x07a3;
    L_0x0938:
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
        goto L_0x0798;
    L_0x093e:
        r3 = r59[r32];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0944;
    L_0x0942:
        r21[r32] = r54;	 Catch:{ Exception -> 0x08ee }
    L_0x0944:
        r32 = r32 + 1;
        r3 = r13.length;	 Catch:{ Exception -> 0x08ee }
        r0 = r32;
        if (r0 != r3) goto L_0x0967;
    L_0x094b:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x08ee }
        r0 = r31;
        r1 = r21;
        r0.put(r1);	 Catch:{ Exception -> 0x08ee }
        r31.force();	 Catch:{ Exception -> 0x08ee }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x08ee }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x08ee }
        r50 = 1;
        goto L_0x07d1;
    L_0x0967:
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
        goto L_0x07c6;
    L_0x096d:
        r3 = r57[r32];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0973;
    L_0x0971:
        r19[r32] = r54;	 Catch:{ Exception -> 0x08ee }
    L_0x0973:
        r32 = r32 + 1;
        r3 = r11.length;	 Catch:{ Exception -> 0x08ee }
        r0 = r32;
        if (r0 != r3) goto L_0x0996;
    L_0x097a:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x08ee }
        r0 = r31;
        r1 = r19;
        r0.put(r1);	 Catch:{ Exception -> 0x08ee }
        r31.force();	 Catch:{ Exception -> 0x08ee }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x08ee }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x08ee }
        r51 = 1;
        goto L_0x07ff;
    L_0x0996:
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
        goto L_0x07f4;
    L_0x099c:
        r3 = r58[r32];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x09a2;
    L_0x09a0:
        r20[r32] = r54;	 Catch:{ Exception -> 0x08ee }
    L_0x09a2:
        r32 = r32 + 1;
        r3 = r12.length;	 Catch:{ Exception -> 0x08ee }
        r0 = r32;
        if (r0 != r3) goto L_0x09c5;
    L_0x09a9:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x08ee }
        r0 = r31;
        r1 = r20;
        r0.put(r1);	 Catch:{ Exception -> 0x08ee }
        r31.force();	 Catch:{ Exception -> 0x08ee }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x08ee }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x08ee }
        r52 = 1;
        goto L_0x082d;
    L_0x09c5:
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
        goto L_0x0822;
    L_0x09cb:
        r3 = r60[r32];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x09d1;
    L_0x09cf:
        r22[r32] = r54;	 Catch:{ Exception -> 0x08ee }
    L_0x09d1:
        r32 = r32 + 1;
        r3 = r14.length;	 Catch:{ Exception -> 0x08ee }
        r0 = r32;
        if (r0 != r3) goto L_0x09f4;
    L_0x09d8:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x08ee }
        r0 = r31;
        r1 = r22;
        r0.put(r1);	 Catch:{ Exception -> 0x08ee }
        r31.force();	 Catch:{ Exception -> 0x08ee }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x08ee }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x08ee }
        r53 = 1;
        goto L_0x085b;
    L_0x09f4:
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
        goto L_0x0850;
    L_0x09fa:
        r3 = r62[r32];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0a00;
    L_0x09fe:
        r24[r32] = r54;	 Catch:{ Exception -> 0x08ee }
    L_0x0a00:
        r32 = r32 + 1;
        r0 = r16;
        r3 = r0.length;	 Catch:{ Exception -> 0x08ee }
        r0 = r32;
        if (r0 != r3) goto L_0x0a25;
    L_0x0a09:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x08ee }
        r0 = r31;
        r1 = r24;
        r0.put(r1);	 Catch:{ Exception -> 0x08ee }
        r31.force();	 Catch:{ Exception -> 0x08ee }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x08ee }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x08ee }
        r53 = 1;
        goto L_0x0889;
    L_0x0a25:
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
        goto L_0x087e;
    L_0x0a2b:
        r3 = r55[r32];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0a31;
    L_0x0a2f:
        r17[r32] = r54;	 Catch:{ Exception -> 0x08ee }
    L_0x0a31:
        r32 = r32 + 1;
        r3 = r9.length;	 Catch:{ Exception -> 0x08ee }
        r0 = r32;
        if (r0 != r3) goto L_0x0a54;
    L_0x0a38:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x08ee }
        r0 = r31;
        r1 = r17;
        r0.put(r1);	 Catch:{ Exception -> 0x08ee }
        r31.force();	 Catch:{ Exception -> 0x08ee }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x08ee }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x08ee }
        r53 = 1;
        goto L_0x08b7;
    L_0x0a54:
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
        goto L_0x08ac;
    L_0x0a5a:
        r3 = r61[r32];	 Catch:{ Exception -> 0x08ee }
        if (r3 != 0) goto L_0x0a60;
    L_0x0a5e:
        r23[r32] = r54;	 Catch:{ Exception -> 0x08ee }
    L_0x0a60:
        r32 = r32 + 1;
        r3 = r15.length;	 Catch:{ Exception -> 0x08ee }
        r0 = r32;
        if (r0 != r3) goto L_0x0a98;
    L_0x0a67:
        r0 = r31;
        r1 = r27;
        r0.position(r1);	 Catch:{ Exception -> 0x08ee }
        r0 = r31;
        r1 = r23;
        r0.put(r1);	 Catch:{ Exception -> 0x08ee }
        r31.force();	 Catch:{ Exception -> 0x08ee }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x08ee }
        r4 = "Done!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x08ee }
        goto L_0x08e5;
    L_0x0a81:
        r36 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r36;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x062e;
    L_0x0a98:
        r54 = r31.get();	 Catch:{ Exception -> 0x08ee }
        goto L_0x08da;
    L_0x0a9e:
        r36 = move-exception;
        r34 = r35;
        goto L_0x06aa;
    L_0x0aa3:
        r36 = move-exception;
        r34 = r35;
        goto L_0x059b;
    L_0x0aa8:
        r34 = r35;
        goto L_0x0340;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.nerorunpatch.main(java.lang.String[]):void");
    }
}
