package com.chelpus.root.utils;

public class liverunpatch {
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r30) {
        /*
        r3 = new com.chelpus.root.utils.liverunpatch$1;
        r3.<init>();
        com.chelpus.Utils.startRootJava(r3);
        r3 = 1;
        r3 = r30[r3];
        r4 = " ";
        r24 = r3.split(r4);
        r3 = 2;
        r3 = r30[r3];
        r4 = " ";
        r28 = r3.split(r4);
        r0 = r24;
        r3 = r0.length;
        r8 = new byte[r3];
        r0 = r28;
        r3 = r0.length;
        r9 = new byte[r3];
        r0 = r24;
        r3 = r0.length;
        r0 = new byte[r3];
        r23 = r0;
        r0 = r28;
        r3 = r0.length;
        r0 = new byte[r3];
        r27 = r0;
        r15 = 0;
        r0 = r27;
        r3 = r0.length;
        r0 = r23;
        r4 = r0.length;
        if (r3 != r4) goto L_0x0259;
    L_0x003b:
        r3 = r8.length;
        r4 = r9.length;
        if (r3 != r4) goto L_0x0259;
    L_0x003f:
        r3 = r9.length;
        r4 = 3;
        if (r3 <= r4) goto L_0x0259;
    L_0x0043:
        r3 = r8.length;
        r4 = 3;
        if (r3 <= r4) goto L_0x0259;
    L_0x0047:
        r29 = 0;
    L_0x0049:
        r0 = r24;
        r3 = r0.length;
        r0 = r29;
        if (r0 >= r3) goto L_0x00e0;
    L_0x0050:
        r3 = r24[r29];
        r4 = "*";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x0069;
    L_0x005a:
        r3 = r24[r29];
        r4 = "**";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0069;
    L_0x0064:
        r15 = 1;
        r3 = "00";
        r24[r29] = r3;
    L_0x0069:
        r3 = r28[r29];
        r4 = "*";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x0082;
    L_0x0073:
        r3 = r28[r29];
        r4 = "**";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0082;
    L_0x007d:
        r15 = 1;
        r3 = "00";
        r28[r29] = r3;
    L_0x0082:
        r3 = r24[r29];
        r4 = "**";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0096;
    L_0x008c:
        r3 = r24[r29];
        r4 = "??";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x00d8;
    L_0x0096:
        r3 = "00";
        r24[r29] = r3;
        r3 = 1;
        r23[r29] = r3;
    L_0x009d:
        r3 = r24[r29];
        r4 = 16;
        r3 = java.lang.Integer.valueOf(r3, r4);
        r3 = r3.byteValue();
        r8[r29] = r3;
        r3 = r28[r29];
        r4 = "**";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x00bf;
    L_0x00b5:
        r3 = r28[r29];
        r4 = "??";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x00dc;
    L_0x00bf:
        r3 = "00";
        r28[r29] = r3;
        r3 = 0;
        r27[r29] = r3;
    L_0x00c6:
        r3 = r28[r29];
        r4 = 16;
        r3 = java.lang.Integer.valueOf(r3, r4);
        r3 = r3.byteValue();
        r9[r29] = r3;
        r29 = r29 + 1;
        goto L_0x0049;
    L_0x00d8:
        r3 = 0;
        r23[r29] = r3;
        goto L_0x009d;
    L_0x00dc:
        r3 = 1;
        r27[r29] = r3;
        goto L_0x00c6;
    L_0x00e0:
        if (r15 != 0) goto L_0x0250;
    L_0x00e2:
        r3 = dalvikDexIn;
        r4 = "zamenitetodelo";
        r5 = 0;
        r5 = r30[r5];
        r12 = r3.replace(r4, r5);
        r20 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r0 = r20;
        r0.<init>(r12);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = r20.exists();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        if (r3 != 0) goto L_0x0109;
    L_0x00fa:
        r20 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = "-1";
        r4 = "-2";
        r3 = r12.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r0 = r20;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
    L_0x0109:
        r21 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = "-1";
        r4 = "";
        r3 = r12.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r0 = r21;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = r20.exists();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        if (r3 == 0) goto L_0x0120;
    L_0x011e:
        r21 = r20;
    L_0x0120:
        r3 = "data@app";
        r4 = "mnt@asec";
        r13 = r12.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = ".apk@classes.dex";
        r4 = "@pkg.apk@classes.dex";
        r13 = r13.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r20 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r0 = r20;
        r0.<init>(r13);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = r20.exists();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        if (r3 == 0) goto L_0x013f;
    L_0x013d:
        r21 = r20;
    L_0x013f:
        r20 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = "-1";
        r4 = "-2";
        r3 = r13.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r0 = r20;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = r20.exists();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        if (r3 == 0) goto L_0x0156;
    L_0x0154:
        r21 = r20;
    L_0x0156:
        r20 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = "-1";
        r4 = "";
        r3 = r13.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r0 = r20;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = r20.exists();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        if (r3 == 0) goto L_0x016d;
    L_0x016b:
        r21 = r20;
    L_0x016d:
        r3 = r21.exists();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        if (r3 != 0) goto L_0x0185;
    L_0x0173:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        throw r3;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
    L_0x0179:
        r22 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*";
        r3.println(r4);
    L_0x0181:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x0185:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r4 = "rw";
        r0 = r21;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r16 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r25 = 0;
        r18 = 0;
    L_0x01a4:
        r3 = r16.hasRemaining();	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        if (r3 == 0) goto L_0x023f;
    L_0x01aa:
        r11 = r16.position();	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r10 = r16.get();	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        if (r10 != r3) goto L_0x0215;
    L_0x01b7:
        r3 = 0;
        r3 = r27[r3];	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        if (r3 != 0) goto L_0x01bf;
    L_0x01bc:
        r3 = 0;
        r9[r3] = r10;	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
    L_0x01bf:
        r17 = 1;
        r3 = r11 + 1;
        r0 = r16;
        r0.position(r3);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r26 = r16.get();	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
    L_0x01cc:
        r3 = r8[r17];	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r0 = r26;
        if (r0 == r3) goto L_0x01d7;
    L_0x01d2:
        r3 = r23[r17];	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r4 = 1;
        if (r3 != r4) goto L_0x0215;
    L_0x01d7:
        r3 = r27[r17];	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        if (r3 != 0) goto L_0x01dd;
    L_0x01db:
        r9[r17] = r26;	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
    L_0x01dd:
        r17 = r17 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r0 = r17;
        if (r0 != r3) goto L_0x0221;
    L_0x01e4:
        r0 = r16;
        r0.position(r11);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r0 = r16;
        r0.put(r9);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r16.force();	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r4.<init>();	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r5 = "Offset in file:";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r5 = java.lang.Integer.toHexString(r11);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r5 = " - Patch done!\n";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r3.println(r4);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r25 = 1;
    L_0x0215:
        r3 = r11 + 1;
        r0 = r16;
        r0.position(r3);	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        r4 = 1;
        r18 = r18 + r4;
        goto L_0x01a4;
    L_0x0221:
        r26 = r16.get();	 Catch:{ Exception -> 0x0226, FileNotFoundException -> 0x0179 }
        goto L_0x01cc;
    L_0x0226:
        r14 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r4 = r4.append(r14);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
    L_0x023f:
        r2.close();	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        if (r25 != 0) goto L_0x0181;
    L_0x0244:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        r4 = "Error: Pattern not found!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x0179, Exception -> 0x024d }
        goto L_0x0181;
    L_0x024d:
        r3 = move-exception;
        goto L_0x0181;
    L_0x0250:
        r3 = java.lang.System.out;
        r4 = "Error: Pattern not valid!\n\nPattern can not be \"*4\" or \"A*\", etc.\n\n It can only be ** ";
        r3.println(r4);
        goto L_0x0181;
    L_0x0259:
        r3 = java.lang.System.out;
        r4 = "Error: Original & Replace hex-string not valid!\n\nOriginal.hex.length != Replacmant.hex.length.\nOR\nLength of hex-string < 4";
        r3.println(r4);
        goto L_0x0181;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.liverunpatch.main(java.lang.String[]):void");
    }
}
