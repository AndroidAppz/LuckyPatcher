package com.chelpus.root.utils;

public class runpatch {
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
    private static String dalvikDexIn2 = "/cache/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
    public static String dirapp = "/data/app/";
    public static boolean odexpatch = false;
    private static boolean pattern1 = true;
    private static boolean pattern2 = true;
    private static boolean pattern3 = true;
    private static boolean pattern4 = true;
    public static boolean system = false;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r105) {
        /*
        r3 = 1;
        pattern1 = r3;
        r3 = 1;
        pattern2 = r3;
        r3 = 1;
        pattern3 = r3;
        r3 = 1;
        pattern4 = r3;
        r3 = new com.chelpus.root.utils.runpatch$1;
        r3.<init>();
        com.chelpus.Utils.startRootJava(r3);
        r3 = 3;
        r3 = r105[r3];
        dirapp = r3;
        r3 = 2;
        r3 = r105[r3];
        r4 = "not_system";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0027;
    L_0x0024:
        r3 = 0;
        system = r3;
    L_0x0027:
        r3 = 2;
        r3 = r105[r3];
        r4 = "system";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0035;
    L_0x0032:
        r3 = 1;
        system = r3;
    L_0x0035:
        r8 = new java.io.File;
        r3 = dirapp;
        r8.<init>(r3);
        r9 = new java.io.File;
        r3 = dirapp;
        r4 = 1;
        r3 = com.chelpus.Utils.getPlaceForOdex(r3, r4);
        r9.<init>(r3);
        r3 = system;
        if (r3 == 0) goto L_0x006a;
    L_0x004c:
        r3 = r8.exists();
        if (r3 == 0) goto L_0x006a;
    L_0x0052:
        r3 = r9.exists();
        if (r3 == 0) goto L_0x006a;
    L_0x0058:
        r3 = com.chelpus.Utils.classes_test(r8);
        if (r3 != 0) goto L_0x006a;
    L_0x005e:
        r3 = 1;
        odexpatch = r3;
        r56 = r9;
        r3 = java.lang.System.out;
        r4 = "\nOdex Application.\nOnly ODEX patch is enabled.\n";
        r3.println(r4);
    L_0x006a:
        r3 = 1;
        r3 = r105[r3];
        if (r3 == 0) goto L_0x00a7;
    L_0x006f:
        r3 = 1;
        r3 = r105[r3];
        r4 = "pattern1";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x007d;
    L_0x007a:
        r3 = 0;
        pattern1 = r3;
    L_0x007d:
        r3 = 1;
        r3 = r105[r3];
        r4 = "pattern2";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x008b;
    L_0x0088:
        r3 = 0;
        pattern2 = r3;
    L_0x008b:
        r3 = 1;
        r3 = r105[r3];
        r4 = "pattern3";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0099;
    L_0x0096:
        r3 = 0;
        pattern3 = r3;
    L_0x0099:
        r3 = 1;
        r3 = r105[r3];
        r4 = "pattern4";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x00a7;
    L_0x00a4:
        r3 = 0;
        pattern4 = r3;
    L_0x00a7:
        r3 = 29;
        r10 = new byte[r3];
        r10 = {5, 0, 0, 0, 1, 1, 0, 0, 2, 1, 0, 0, 3, 1, 0, 0, 15, 0, 0, 0, 26, 0, 0, 0, 15, 0, 0, 0, 89};
        r3 = 29;
        r0 = new byte[r3];
        r60 = r0;
        r60 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1};
        r3 = 29;
        r0 = new byte[r3];
        r27 = r0;
        r27 = {5, 0, 0, 0, 1, 1, 0, 0, 2, 1, 0, 0, 3, 1, 0, 0, 15, 0, 0, 0, 15, 0, 0, 0, 15, 0, 0, 0, 89};
        r3 = 29;
        r0 = new byte[r3];
        r85 = r0;
        r85 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 23;
        r0 = new byte[r3];
        r20 = r0;
        r20 = {16, 0, 0, 0, 0, 10, 0, 56, 0, 8, 0, 84, 16, 0, 0, 114, 16, 0, 0, 0, 0, 14, 0};
        r3 = 23;
        r0 = new byte[r3];
        r70 = r0;
        r70 = {0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0};
        r3 = 23;
        r0 = new byte[r3];
        r37 = r0;
        r37 = {16, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 84, 16, 0, 0, 0};
        r3 = 23;
        r0 = new byte[r3];
        r95 = r0;
        r95 = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 21;
        r0 = new byte[r3];
        r22 = r0;
        r22 = {10, 0, 56, 0, 14, 0, 26, 0, 0, 0, 26, 0, 0, 0, 113, 0, 0, 0, 0, 0, 114};
        r3 = 21;
        r0 = new byte[r3];
        r72 = r0;
        r72 = {0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0};
        r3 = 21;
        r0 = new byte[r3];
        r39 = r0;
        r39 = {10, 0, 0, 0, 0, 0, 26, 0, 0, 0, 26, 0, 0, 0, 113, 0, 0, 0, 0, 0, 114};
        r3 = 21;
        r0 = new byte[r3];
        r97 = r0;
        r97 = {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 41;
        r0 = new byte[r3];
        r23 = r0;
        r23 = {26, 102, 102, 102, 112, 102, 102, 102, 102, 102, 39, 102, 34, 102, 102, 102, 112, 102, 102, 102, 102, 102, 18, 102, 70, 102, 102, 102, 113, 102, 102, 102, 102, 102, 10, 102, 102, 102, 102, 102, 18};
        r3 = 41;
        r0 = new byte[r3];
        r73 = r0;
        r73 = {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0};
        r3 = 41;
        r0 = new byte[r3];
        r40 = r0;
        r40 = {26, 102, 102, 102, 112, 102, 102, 102, 102, 102, 39, 102, 34, 102, 102, 102, 112, 102, 102, 102, 102, 102, 18, 102, 70, 102, 102, 102, 113, 102, 102, 102, 102, 102, 18, 102, 102, 102, 102, 102, 18};
        r3 = 41;
        r0 = new byte[r3];
        r98 = r0;
        r98 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        r3 = 22;
        r0 = new byte[r3];
        r24 = r0;
        r24 = {56, 0, 11, 0, 0, 16, 0, 0, 0, 0, 12, 0, 114, 0, 0, 0, 0, 0, 0, 0, 14, 0};
        r3 = 22;
        r0 = new byte[r3];
        r74 = r0;
        r74 = {0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1};
        r3 = 22;
        r0 = new byte[r3];
        r41 = r0;
        r41 = {0, 0, 0, 0, 0, 16, 0, 0, 0, 12, 0, 114, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0};
        r3 = 22;
        r0 = new byte[r3];
        r99 = r0;
        r99 = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 34;
        r0 = new byte[r3];
        r25 = r0;
        r25 = {34, 102, 102, 102, 112, 102, 102, 102, 102, 102, 91, 102, 102, 102, 18, 102, 70, 102, 102, 102, 113, 102, 102, 102, 102, 102, 10, 102, 102, 102, 102, 102, 18, 102};
        r3 = 34;
        r0 = new byte[r3];
        r75 = r0;
        r75 = {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1};
        r3 = 34;
        r0 = new byte[r3];
        r42 = r0;
        r42 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0};
        r3 = 34;
        r0 = new byte[r3];
        r100 = r0;
        r100 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
        r3 = 12;
        r0 = new byte[r3];
        r26 = r0;
        r26 = {56, 9, 6, 0, 50, 73, 4, 0, 51, 89, -68, 0};
        r3 = 12;
        r0 = new byte[r3];
        r76 = r0;
        r76 = {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1};
        r3 = 12;
        r0 = new byte[r3];
        r43 = r0;
        r43 = {18, 0, 0, 0, 41, 0, 0, 0, 0, 0, 0, 84};
        r3 = 12;
        r0 = new byte[r3];
        r101 = r0;
        r101 = {1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        r3 = 73;
        r11 = new byte[r3];
        r11 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 1, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 1, 102, 40};
        r3 = 73;
        r0 = new byte[r3];
        r61 = r0;
        r61 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0};
        r3 = 73;
        r0 = new byte[r3];
        r28 = r0;
        r28 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 1, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 18, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 1, 102, 40};
        r3 = 73;
        r0 = new byte[r3];
        r86 = r0;
        r86 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 71;
        r12 = new byte[r3];
        r12 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 1, 102, 40};
        r3 = 71;
        r0 = new byte[r3];
        r62 = r0;
        r62 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0};
        r3 = 71;
        r0 = new byte[r3];
        r29 = r0;
        r29 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 18, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 1, 102, 40};
        r3 = 71;
        r0 = new byte[r3];
        r87 = r0;
        r87 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 69;
        r13 = new byte[r3];
        r13 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 40};
        r3 = 69;
        r0 = new byte[r3];
        r63 = r0;
        r63 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0};
        r3 = 69;
        r0 = new byte[r3];
        r30 = r0;
        r30 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 18, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 12, 102, 102, 102, 102, 102, 102, 102, 40};
        r3 = 69;
        r0 = new byte[r3];
        r88 = r0;
        r88 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 45;
        r14 = new byte[r3];
        r14 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10};
        r3 = 45;
        r0 = new byte[r3];
        r64 = r0;
        r64 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        r3 = 45;
        r0 = new byte[r3];
        r31 = r0;
        r31 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 18};
        r3 = 45;
        r0 = new byte[r3];
        r89 = r0;
        r89 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        r3 = 61;
        r15 = new byte[r3];
        r15 = {12, 102, 113, 102, 102, 102, 102, 102, 12, 102, 33, 102, 18, 102, 53, 102, 102, 102, 34, 102, 102, 102, 26, 102, 102, 102, 112, 102, 102, 102, 102, 102, 39, 102, 34, 102, 102, 102, 112, 102, 102, 102, 102, 102, 91, 102, 102, 102, 18, 102, 70, 102, 102, 102, 113, 102, 102, 102, 102, 102, 10};
        r3 = 61;
        r0 = new byte[r3];
        r65 = r0;
        r65 = {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0};
        r3 = 61;
        r0 = new byte[r3];
        r32 = r0;
        r32 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18};
        r3 = 61;
        r0 = new byte[r3];
        r90 = r0;
        r90 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        r3 = 32;
        r0 = new byte[r3];
        r16 = r0;
        r16 = {26, 102, 102, 102, 113, 102, 102, 102, 102, 102, 12, 102, 113, 102, 102, 102, 102, 102, 12, 102, 33, 102, 102, 102, 53, 102, 102, 102, 34, 102, 102, 102};
        r3 = 32;
        r0 = new byte[r3];
        r66 = r0;
        r66 = {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        r3 = 32;
        r0 = new byte[r3];
        r33 = r0;
        r33 = {26, 102, 102, 102, 113, 102, 102, 102, 102, 102, 12, 102, 113, 102, 102, 102, 102, 102, 12, 102, 33, 102, 102, 102, 53, 102, 102, 102, 34, 102, 102, 102};
        r3 = 32;
        r0 = new byte[r3];
        r91 = r0;
        r91 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 13;
        r0 = new byte[r3];
        r17 = r0;
        r17 = {0, 70, 102, 102, 102, 113, 102, 102, 102, 102, 102, 10, 102};
        r3 = 13;
        r0 = new byte[r3];
        r67 = r0;
        r67 = {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1};
        r3 = 13;
        r0 = new byte[r3];
        r34 = r0;
        r34 = {0, 70, 102, 102, 102, 113, 102, 102, 102, 102, 102, 18, 102};
        r3 = 13;
        r0 = new byte[r3];
        r92 = r0;
        r92 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        r3 = 45;
        r0 = new byte[r3];
        r18 = r0;
        r18 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 98, 102, 102, 102, 102, 102, 102, 102, 102, 102, 40, 102, 98, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10};
        r3 = 45;
        r0 = new byte[r3];
        r68 = r0;
        r68 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        r3 = 45;
        r0 = new byte[r3];
        r35 = r0;
        r35 = {44, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 10, 102, 15, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 40, 102, 26, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 18};
        r3 = 45;
        r0 = new byte[r3];
        r93 = r0;
        r93 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        r3 = 25;
        r0 = new byte[r3];
        r19 = r0;
        r19 = {18, 102, 18, 102, 113, 102, 102, 102, 102, 102, 11, 102, 102, 102, 102, 102, 102, 102, 102, 102, 51, 102, 102, 102, -13};
        r3 = 25;
        r0 = new byte[r3];
        r69 = r0;
        r69 = {0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0};
        r3 = 25;
        r0 = new byte[r3];
        r36 = r0;
        r36 = {18, 16, 15, 0, 113, 102, 102, 102, 102, 102, 11, 102, 102, 102, 102, 102, 102, 102, 102, 102, 51, 102, 102, 102, -13};
        r3 = 25;
        r0 = new byte[r3];
        r94 = r0;
        r94 = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 10;
        r0 = new byte[r3];
        r21 = r0;
        r21 = {108, 97, 99, 107, 121, 112, 97, 116, 99, 104};
        r3 = 10;
        r0 = new byte[r3];
        r71 = r0;
        r71 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        r3 = 10;
        r0 = new byte[r3];
        r38 = r0;
        r38 = {108, 117, 99, 107, 121, 112, 97, 116, 99, 104};
        r3 = 10;
        r0 = new byte[r3];
        r96 = r0;
        r96 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        r3 = dalvikDexIn;
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r105[r5];
        r48 = r3.replace(r4, r5);
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r48;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 != 0) goto L_0x032a;
    L_0x0319:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "-2";
        r0 = r48;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x032a:
        r56 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "";
        r0 = r48;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r56;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0343;
    L_0x0341:
        r56 = r53;
    L_0x0343:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r48;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r49;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r49;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0368;
    L_0x0366:
        r56 = r53;
    L_0x0368:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "-2";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0381;
    L_0x037f:
        r56 = r53;
    L_0x0381:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x039a;
    L_0x0398:
        r56 = r53;
    L_0x039a:
        r3 = dalvikDexIn2;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r105[r5];	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r48 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r48;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 != 0) goto L_0x03c5;
    L_0x03b4:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "-2";
        r0 = r48;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x03c5:
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 != 0) goto L_0x03dc;
    L_0x03cb:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "";
        r0 = r48;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x03dc:
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x03e4;
    L_0x03e2:
        r56 = r53;
    L_0x03e4:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r48;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r49;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r49;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0409;
    L_0x0407:
        r56 = r53;
    L_0x0409:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "-2";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0422;
    L_0x0420:
        r56 = r53;
    L_0x0422:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x043b;
    L_0x0439:
        r56 = r53;
    L_0x043b:
        r3 = dalvikDexIn;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r105[r5];	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r48 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "/data/";
        r4 = "/sd-ext/data/";
        r0 = r48;
        r48 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r48;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 != 0) goto L_0x0470;
    L_0x045f:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "-2";
        r0 = r48;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0470:
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 != 0) goto L_0x0487;
    L_0x0476:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "";
        r0 = r48;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0487:
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x048f;
    L_0x048d:
        r56 = r53;
    L_0x048f:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r48;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r49;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r49;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x04b4;
    L_0x04b2:
        r56 = r53;
    L_0x04b4:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "-2";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x04cd;
    L_0x04cb:
        r56 = r53;
    L_0x04cd:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x04e6;
    L_0x04e4:
        r56 = r53;
    L_0x04e6:
        r3 = dalvikDexIn2;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r105[r5];	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r48 = r3.replace(r4, r5);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "/cache/";
        r4 = "/sd-ext/data/cache/";
        r0 = r48;
        r48 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r48;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 != 0) goto L_0x051b;
    L_0x050a:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "-2";
        r0 = r48;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x051b:
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 != 0) goto L_0x0532;
    L_0x0521:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "";
        r0 = r48;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0532:
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x053a;
    L_0x0538:
        r56 = r53;
    L_0x053a:
        r3 = "data@app";
        r4 = "mnt@asec";
        r0 = r48;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r0 = r49;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r49;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x055f;
    L_0x055d:
        r56 = r53;
    L_0x055f:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "-2";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0578;
    L_0x0576:
        r56 = r53;
    L_0x0578:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "-1";
        r4 = "";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0591;
    L_0x058f:
        r56 = r53;
    L_0x0591:
        r3 = system;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0612;
    L_0x0595:
        r104 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = dirapp;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r104;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r103 = r104.getName();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = dalvikDexIn;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "zamenitetodelo-1.apk";
        r0 = r103;
        r48 = r3.replace(r4, r0);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "data@app";
        r4 = "system@app";
        r0 = r48;
        r49 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r1 = r49;
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x05c7;
    L_0x05c5:
        r56 = r53;
    L_0x05c7:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "/data/dalvik-cache/";
        r4 = "/sd-ext/data/dalvik-cache/";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x05e0;
    L_0x05de:
        r56 = r53;
    L_0x05e0:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "/data/dalvik-cache/";
        r4 = "/sd-ext/data/cache/dalvik-cache/";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x05f9;
    L_0x05f7:
        r56 = r53;
    L_0x05f9:
        r53 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = "/data/dalvik-cache/";
        r4 = "/cache/dalvik-cache/";
        r0 = r49;
        r3 = r0.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r53;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = r53.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0612;
    L_0x0610:
        r56 = r53;
    L_0x0612:
        r3 = odexpatch;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 == 0) goto L_0x0618;
    L_0x0616:
        r56 = r9;
    L_0x0618:
        r3 = r56.exists();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r3 != 0) goto L_0x0630;
    L_0x061e:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        throw r3;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0624:
        r57 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
    L_0x062c:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x0630:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "rw";
        r0 = r56;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r51 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r77 = 0;
        r78 = 0;
        r79 = 0;
        r80 = 0;
        r81 = 0;
        r82 = 0;
        r83 = 0;
        r58 = 0;
        r59 = 0;
        r47 = 0;
        r102 = 0;
        r54 = 0;
    L_0x0663:
        r3 = r51.hasRemaining();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0d0a;
    L_0x0669:
        r46 = r51.position();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r45 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r58 != 0) goto L_0x0675;
    L_0x0673:
        if (r59 == 0) goto L_0x0677;
    L_0x0675:
        r47 = r47 + 1;
    L_0x0677:
        r3 = 380; // 0x17c float:5.32E-43 double:1.877E-321;
        r0 = r47;
        if (r0 <= r3) goto L_0x0681;
    L_0x067d:
        r58 = 0;
        r47 = 0;
    L_0x0681:
        r3 = 0;
        r3 = r10[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x06f7;
    L_0x0688:
        r3 = pattern1;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x06f7;
    L_0x068c:
        r3 = 0;
        r3 = r85[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 2;
        if (r3 != r4) goto L_0x0694;
    L_0x0692:
        r102 = r45;
    L_0x0694:
        r3 = 0;
        r3 = r85[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x069c;
    L_0x0699:
        r3 = 0;
        r27[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x069c:
        r52 = 1;
        r44 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x06ab:
        r3 = r10[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x06b5;
    L_0x06b1:
        r3 = r60[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x06f7;
    L_0x06b5:
        r3 = r85[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 2;
        if (r3 != r4) goto L_0x06bc;
    L_0x06ba:
        r102 = r84;
    L_0x06bc:
        r3 = r85[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x06c5;
    L_0x06c0:
        r3 = r85[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 2;
        if (r3 != r4) goto L_0x06c7;
    L_0x06c5:
        r27[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x06c7:
        r3 = r85[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 3;
        if (r3 != r4) goto L_0x06ce;
    L_0x06cc:
        r44 = r52;
    L_0x06ce:
        r52 = r52 + 1;
        r3 = r10.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0c89;
    L_0x06d5:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r44;
        if (r0 >= r3) goto L_0x06dd;
    L_0x06db:
        r27[r44] = r102;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x06dd:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r27;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "Check License Key Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r80 = 1;
    L_0x06f7:
        r3 = 0;
        r3 = r20[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0752;
    L_0x06fe:
        r3 = pattern3;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0752;
    L_0x0702:
        r3 = 0;
        r3 = r95[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x070a;
    L_0x0707:
        r3 = 0;
        r37[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x070a:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0717:
        r3 = r20[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0722;
    L_0x071d:
        r3 = r70[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x074b;
    L_0x0722:
        r3 = r95[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0728;
    L_0x0726:
        r37[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0728:
        r52 = r52 + 1;
        r0 = r20;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0c8f;
    L_0x0731:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r37;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "License Key Fixed2!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r78 = 1;
    L_0x074b:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0752:
        r3 = 0;
        r3 = r22[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x07ad;
    L_0x0759:
        r3 = pattern2;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x07ad;
    L_0x075d:
        r3 = 0;
        r3 = r97[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0765;
    L_0x0762:
        r3 = 0;
        r39[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0765:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0772:
        r3 = r22[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x077d;
    L_0x0778:
        r3 = r72[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x07a6;
    L_0x077d:
        r3 = r97[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0783;
    L_0x0781:
        r39[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0783:
        r52 = r52 + 1;
        r0 = r22;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0c95;
    L_0x078c:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r39;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "Cached License Key Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r77 = 1;
    L_0x07a6:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x07ad:
        r3 = 0;
        r3 = r24[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0808;
    L_0x07b4:
        r3 = pattern2;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0808;
    L_0x07b8:
        r3 = 0;
        r3 = r99[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x07c0;
    L_0x07bd:
        r3 = 0;
        r41[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x07c0:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x07cd:
        r3 = r24[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x07d8;
    L_0x07d3:
        r3 = r74[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0801;
    L_0x07d8:
        r3 = r99[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x07de;
    L_0x07dc:
        r41[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x07de:
        r52 = r52 + 1;
        r0 = r24;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0c9b;
    L_0x07e7:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r41;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "Internet Connection Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r79 = 1;
    L_0x0801:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0808:
        r3 = 0;
        r3 = r19[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0863;
    L_0x080f:
        r3 = pattern2;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0863;
    L_0x0813:
        r3 = 0;
        r3 = r94[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x081b;
    L_0x0818:
        r3 = 0;
        r36[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x081b:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0828:
        r3 = r19[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0833;
    L_0x082e:
        r3 = r69[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x085c;
    L_0x0833:
        r3 = r94[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0839;
    L_0x0837:
        r36[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0839:
        r52 = r52 + 1;
        r0 = r19;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0ca1;
    L_0x0842:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r36;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "Internet Connection Fixed!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r79 = 1;
    L_0x085c:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0863:
        r3 = 0;
        r3 = r21[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x08b1;
    L_0x086a:
        r3 = 0;
        r3 = r96[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0872;
    L_0x086f:
        r3 = 0;
        r38[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0872:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x087f:
        r3 = r21[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x088a;
    L_0x0885:
        r3 = r71[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x08aa;
    L_0x088a:
        r3 = r96[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0890;
    L_0x088e:
        r38[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0890:
        r52 = r52 + 1;
        r0 = r21;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0ca7;
    L_0x0899:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r38;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x08aa:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x08b1:
        r3 = 0;
        r3 = r25[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x090e;
    L_0x08b8:
        if (r81 != 0) goto L_0x090e;
    L_0x08ba:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x090e;
    L_0x08be:
        r3 = 0;
        r3 = r100[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x08c6;
    L_0x08c3:
        r3 = 0;
        r42[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x08c6:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x08d3:
        r3 = r25[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x08de;
    L_0x08d9:
        r3 = r75[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0907;
    L_0x08de:
        r3 = r100[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x08e4;
    L_0x08e2:
        r42[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x08e4:
        r52 = r52 + 1;
        r0 = r25;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0cad;
    L_0x08ed:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r42;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N5!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r81 = 1;
    L_0x0907:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x090e:
        r3 = 0;
        r3 = r15[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0969;
    L_0x0915:
        if (r81 != 0) goto L_0x0969;
    L_0x0917:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0969;
    L_0x091b:
        r3 = 0;
        r3 = r90[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0923;
    L_0x0920:
        r3 = 0;
        r32[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0923:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0930:
        r3 = r15[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x093b;
    L_0x0936:
        r3 = r65[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0962;
    L_0x093b:
        r3 = r90[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0941;
    L_0x093f:
        r32[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0941:
        r52 = r52 + 1;
        r3 = r15.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0cb3;
    L_0x0948:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r32;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N5!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r81 = 1;
    L_0x0962:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0969:
        r3 = 0;
        r3 = r26[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x09c4;
    L_0x0970:
        r3 = pattern3;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x09c4;
    L_0x0974:
        r3 = 0;
        r3 = r101[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x097c;
    L_0x0979:
        r3 = 0;
        r43[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x097c:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0989:
        r3 = r26[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0994;
    L_0x098f:
        r3 = r76[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x09bd;
    L_0x0994:
        r3 = r101[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x099a;
    L_0x0998:
        r43[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x099a:
        r52 = r52 + 1;
        r0 = r26;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0cb9;
    L_0x09a3:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r43;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N6!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r82 = 1;
    L_0x09bd:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x09c4:
        r3 = 0;
        r3 = r11[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0a1d;
    L_0x09cb:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0a1d;
    L_0x09cf:
        r3 = 0;
        r3 = r86[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x09d7;
    L_0x09d4:
        r3 = 0;
        r28[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x09d7:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x09e4:
        r3 = r11[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x09ef;
    L_0x09ea:
        r3 = r61[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0a16;
    L_0x09ef:
        r3 = r86[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x09f5;
    L_0x09f3:
        r28[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x09f5:
        r52 = r52 + 1;
        r3 = r11.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0cbf;
    L_0x09fc:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r28;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N7!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r83 = 1;
    L_0x0a16:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0a1d:
        r3 = 0;
        r3 = r18[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0a78;
    L_0x0a24:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0a78;
    L_0x0a28:
        r3 = 0;
        r3 = r93[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0a30;
    L_0x0a2d:
        r3 = 0;
        r35[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0a30:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0a3d:
        r3 = r18[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0a48;
    L_0x0a43:
        r3 = r68[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0a71;
    L_0x0a48:
        r3 = r93[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0a4e;
    L_0x0a4c:
        r35[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0a4e:
        r52 = r52 + 1;
        r0 = r18;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0cc5;
    L_0x0a57:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r35;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N7!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r83 = 1;
    L_0x0a71:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0a78:
        r3 = 0;
        r3 = r12[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0ad1;
    L_0x0a7f:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0ad1;
    L_0x0a83:
        r3 = 0;
        r3 = r87[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0a8b;
    L_0x0a88:
        r3 = 0;
        r29[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0a8b:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0a98:
        r3 = r12[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0aa3;
    L_0x0a9e:
        r3 = r62[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0aca;
    L_0x0aa3:
        r3 = r87[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0aa9;
    L_0x0aa7:
        r29[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0aa9:
        r52 = r52 + 1;
        r3 = r12.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0ccb;
    L_0x0ab0:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r29;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N7!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r83 = 1;
    L_0x0aca:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0ad1:
        r3 = 0;
        r3 = r13[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0b2a;
    L_0x0ad8:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0b2a;
    L_0x0adc:
        r3 = 0;
        r3 = r88[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0ae4;
    L_0x0ae1:
        r3 = 0;
        r30[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0ae4:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0af1:
        r3 = r13[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0afc;
    L_0x0af7:
        r3 = r63[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0b23;
    L_0x0afc:
        r3 = r88[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0b02;
    L_0x0b00:
        r30[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0b02:
        r52 = r52 + 1;
        r3 = r13.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0cd1;
    L_0x0b09:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r30;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N7!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r83 = 1;
    L_0x0b23:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0b2a:
        r3 = 0;
        r3 = r14[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0b83;
    L_0x0b31:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0b83;
    L_0x0b35:
        r3 = 0;
        r3 = r89[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0b3d;
    L_0x0b3a:
        r3 = 0;
        r31[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0b3d:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0b4a:
        r3 = r14[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0b55;
    L_0x0b50:
        r3 = r64[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0b7c;
    L_0x0b55:
        r3 = r89[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0b5b;
    L_0x0b59:
        r31[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0b5b:
        r52 = r52 + 1;
        r3 = r14.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0cd7;
    L_0x0b62:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r31;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N7!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r83 = 1;
    L_0x0b7c:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0b83:
        r3 = 0;
        r3 = r23[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0bd7;
    L_0x0b8a:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0bd7;
    L_0x0b8e:
        r3 = 0;
        r3 = r98[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0b96;
    L_0x0b93:
        r3 = 0;
        r40[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0b96:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0ba3:
        r3 = r23[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0bae;
    L_0x0ba9:
        r3 = r73[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0bd7;
    L_0x0bae:
        r3 = r98[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0bb4;
    L_0x0bb2:
        r40[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0bb4:
        r52 = r52 + 1;
        r0 = r23;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0cdd;
    L_0x0bbd:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r40;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N5!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r81 = 1;
    L_0x0bd7:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = 0;
        r3 = r16[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r45;
        if (r0 != r3) goto L_0x0c1e;
    L_0x0be5:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0c1e;
    L_0x0be9:
        r3 = 0;
        r3 = r91[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0bf1;
    L_0x0bee:
        r3 = 0;
        r33[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0bf1:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0bfe:
        r3 = r16[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0c09;
    L_0x0c04:
        r3 = r66[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0c1e;
    L_0x0c09:
        r3 = r91[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0c0f;
    L_0x0c0d:
        r33[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0c0f:
        r52 = r52 + 1;
        r0 = r16;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0ce3;
    L_0x0c18:
        r46 = r51.position();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r58 = 1;
    L_0x0c1e:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = 16;
        r0 = r45;
        if (r0 >= r3) goto L_0x0c7c;
    L_0x0c2b:
        if (r58 == 0) goto L_0x0c7c;
    L_0x0c2d:
        r3 = pattern4;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 == 0) goto L_0x0c7c;
    L_0x0c31:
        r3 = 0;
        r3 = r92[r3];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0c39;
    L_0x0c36:
        r3 = 0;
        r34[r3] = r45;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0c39:
        r52 = 1;
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0c46:
        r3 = r17[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r84;
        if (r0 == r3) goto L_0x0c51;
    L_0x0c4c:
        r3 = r67[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        if (r3 != r4) goto L_0x0c7c;
    L_0x0c51:
        r3 = r92[r52];	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        if (r3 != 0) goto L_0x0c57;
    L_0x0c55:
        r34[r52] = r84;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
    L_0x0c57:
        r52 = r52 + 1;
        r0 = r17;
        r3 = r0.length;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r52;
        if (r0 != r3) goto L_0x0ce9;
    L_0x0c60:
        r0 = r51;
        r1 = r46;
        r0.position(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r0 = r51;
        r1 = r34;
        r0.put(r1);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r51.force();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = "lvl patch N5!\n";
        r3.println(r4);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r58 = 0;
        r81 = 1;
    L_0x0c7c:
        r3 = r46 + 1;
        r0 = r51;
        r0.position(r3);	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        r4 = 1;
        r54 = r54 + r4;
        goto L_0x0663;
    L_0x0c89:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x06ab;
    L_0x0c8f:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0717;
    L_0x0c95:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0772;
    L_0x0c9b:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x07cd;
    L_0x0ca1:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0828;
    L_0x0ca7:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x087f;
    L_0x0cad:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x08d3;
    L_0x0cb3:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0930;
    L_0x0cb9:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0989;
    L_0x0cbf:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x09e4;
    L_0x0cc5:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0a3d;
    L_0x0ccb:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0a98;
    L_0x0cd1:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0af1;
    L_0x0cd7:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0b4a;
    L_0x0cdd:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0ba3;
    L_0x0ce3:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0bfe;
    L_0x0ce9:
        r84 = r51.get();	 Catch:{ Exception -> 0x0cef, FileNotFoundException -> 0x0624 }
        goto L_0x0c46;
    L_0x0cef:
        r50 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r0 = r50;
        r4 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0d0a:
        r2.close();	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        if (r78 != 0) goto L_0x0d16;
    L_0x0d0f:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "Error: License Key2 patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0d16:
        if (r79 != 0) goto L_0x0d1f;
    L_0x0d18:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "Error: Internet Connection patch Failed!\nor patch is already applied?!\n\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0d1f:
        if (r80 != 0) goto L_0x0d28;
    L_0x0d21:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "Error: Check License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0d28:
        if (r81 != 0) goto L_0x0d31;
    L_0x0d2a:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "Error: lvl patch 5 failed\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0d31:
        if (r82 != 0) goto L_0x0d3a;
    L_0x0d33:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "Error: lvl patch 6 failed\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0d3a:
        if (r83 != 0) goto L_0x0d43;
    L_0x0d3c:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "Error: lvl patch 7 failed\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
    L_0x0d43:
        if (r77 != 0) goto L_0x062c;
    L_0x0d45:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        r4 = "Error: Cached License Key patch Failed!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0624, Exception -> 0x0d4e }
        goto L_0x062c;
    L_0x0d4e:
        r50 = move-exception;
        r3 = java.lang.System.out;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Exception e";
        r4 = r4.append(r5);
        r5 = r50.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        goto L_0x062c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.runpatch.main(java.lang.String[]):void");
    }
}
