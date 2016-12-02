package com.chelpus.root.utils;

public class liverunpatchlib {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r29) {
        /*
        r3 = new com.chelpus.root.utils.liverunpatchlib$1;
        r3.<init>();
        com.chelpus.Utils.startRootJava(r3);
        r3 = 1;
        r3 = r29[r3];
        r4 = " ";
        r23 = r3.split(r4);
        r3 = 2;
        r3 = r29[r3];
        r4 = " ";
        r27 = r3.split(r4);
        r0 = r23;
        r3 = r0.length;
        r8 = new byte[r3];
        r0 = r27;
        r3 = r0.length;
        r9 = new byte[r3];
        r0 = r23;
        r3 = r0.length;
        r0 = new byte[r3];
        r22 = r0;
        r0 = r27;
        r3 = r0.length;
        r0 = new byte[r3];
        r26 = r0;
        r14 = 0;
        r0 = r26;
        r3 = r0.length;
        r0 = r22;
        r4 = r0.length;
        if (r3 != r4) goto L_0x0207;
    L_0x003b:
        r3 = r8.length;
        r4 = r9.length;
        if (r3 != r4) goto L_0x0207;
    L_0x003f:
        r3 = r9.length;
        r4 = 3;
        if (r3 <= r4) goto L_0x0207;
    L_0x0043:
        r3 = r8.length;
        r4 = 3;
        if (r3 <= r4) goto L_0x0207;
    L_0x0047:
        r28 = 0;
    L_0x0049:
        r0 = r23;
        r3 = r0.length;
        r0 = r28;
        if (r0 >= r3) goto L_0x00cb;
    L_0x0050:
        r3 = r23[r28];
        r4 = "*";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x0069;
    L_0x005a:
        r3 = r23[r28];
        r4 = "**";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0069;
    L_0x0064:
        r14 = 1;
        r3 = "00";
        r23[r28] = r3;
    L_0x0069:
        r3 = r27[r28];
        r4 = "*";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x0082;
    L_0x0073:
        r3 = r27[r28];
        r4 = "**";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0082;
    L_0x007d:
        r14 = 1;
        r3 = "00";
        r27[r28] = r3;
    L_0x0082:
        r3 = r23[r28];
        r4 = "**";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x00c3;
    L_0x008c:
        r3 = "00";
        r23[r28] = r3;
        r3 = 1;
        r22[r28] = r3;
    L_0x0093:
        r3 = r23[r28];
        r4 = 16;
        r3 = java.lang.Integer.valueOf(r3, r4);
        r3 = r3.byteValue();
        r8[r28] = r3;
        r3 = r27[r28];
        r4 = "**";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x00c7;
    L_0x00ab:
        r3 = "00";
        r27[r28] = r3;
        r3 = 0;
        r26[r28] = r3;
    L_0x00b2:
        r3 = r27[r28];
        r4 = 16;
        r3 = java.lang.Integer.valueOf(r3, r4);
        r3 = r3.byteValue();
        r9[r28] = r3;
        r28 = r28 + 1;
        goto L_0x0049;
    L_0x00c3:
        r3 = 0;
        r22[r28] = r3;
        goto L_0x0093;
    L_0x00c7:
        r3 = 1;
        r26[r28] = r3;
        goto L_0x00b2;
    L_0x00cb:
        if (r14 != 0) goto L_0x01fe;
    L_0x00cd:
        r3 = 0;
        r12 = r29[r3];
        r17 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r0 = r17;
        r0.<init>(r12);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r20 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3 = "/data/data/";
        r4 = "/mnt/asec/";
        r3 = r12.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r0 = r20;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3 = r17.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        if (r3 == 0) goto L_0x00ee;
    L_0x00ec:
        r20 = r17;
    L_0x00ee:
        r3 = r20.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        if (r3 != 0) goto L_0x010e;
    L_0x00f4:
        r20 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3 = r3.append(r12);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r4 = "-1";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r0 = r20;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
    L_0x010e:
        r3 = r20.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        if (r3 != 0) goto L_0x0123;
    L_0x0114:
        r20 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3 = "-1";
        r4 = "-2";
        r3 = r12.replace(r3, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r0 = r20;
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
    L_0x0123:
        r3 = r20.exists();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        if (r3 != 0) goto L_0x013b;
    L_0x0129:
        r3 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        throw r3;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
    L_0x012f:
        r21 = move-exception;
        r3 = java.lang.System.out;
        r4 = "Error: Program files are not found!\n\nMove Program to internal storage.";
        r3.println(r4);
    L_0x0137:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x013b:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r4 = "rw";
        r0 = r20;
        r3.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r2 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r4 = 0;
        r6 = r2.size();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r6 = (int) r6;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r6 = (long) r6;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r15 = r2.map(r3, r4, r6);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r24 = 0;
        r18 = 0;
    L_0x015a:
        r3 = r15.hasRemaining();	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        if (r3 == 0) goto L_0x01ed;
    L_0x0160:
        r11 = r15.position();	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r10 = r15.get();	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        if (r10 != r3) goto L_0x01c5;
    L_0x016d:
        r3 = 0;
        r3 = r26[r3];	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x0175;
    L_0x0172:
        r3 = 0;
        r9[r3] = r10;	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
    L_0x0175:
        r16 = 1;
        r3 = r11 + 1;
        r15.position(r3);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r25 = r15.get();	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
    L_0x0180:
        r3 = r8[r16];	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r0 = r25;
        if (r0 == r3) goto L_0x018b;
    L_0x0186:
        r3 = r22[r16];	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r4 = 1;
        if (r3 != r4) goto L_0x01c5;
    L_0x018b:
        r3 = r26[r16];	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        if (r3 != 0) goto L_0x0191;
    L_0x018f:
        r9[r16] = r25;	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
    L_0x0191:
        r16 = r16 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r0 = r16;
        if (r0 != r3) goto L_0x01cf;
    L_0x0198:
        r15.position(r11);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r15.put(r9);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r15.force();	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r4.<init>();	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r5 = "Offset in file:";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r5 = java.lang.Integer.toHexString(r11);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r5 = " - Patch done!\n";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r3.println(r4);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r24 = 1;
    L_0x01c5:
        r3 = r11 + 1;
        r15.position(r3);	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        r4 = 1;
        r18 = r18 + r4;
        goto L_0x015a;
    L_0x01cf:
        r25 = r15.get();	 Catch:{ Exception -> 0x01d4, FileNotFoundException -> 0x012f }
        goto L_0x0180;
    L_0x01d4:
        r13 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r4 = r4.append(r13);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
    L_0x01ed:
        r2.close();	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        if (r24 != 0) goto L_0x0137;
    L_0x01f2:
        r3 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        r4 = "Error: Pattern not found!\nor patch is already applied?!\n";
        r3.println(r4);	 Catch:{ FileNotFoundException -> 0x012f, Exception -> 0x01fb }
        goto L_0x0137;
    L_0x01fb:
        r3 = move-exception;
        goto L_0x0137;
    L_0x01fe:
        r3 = java.lang.System.out;
        r4 = "Error: Pattern not valid!\n\nPattern can not be \"*4\" or \"A*\", etc.\n\n It can only be ** ";
        r3.println(r4);
        goto L_0x0137;
    L_0x0207:
        r3 = java.lang.System.out;
        r4 = "Error: Original & Replace hex-string not valid!\n\nOriginal.hex.length != Replacmant.hex.length.\nOR\nLength of hex-string < 4";
        r3.println(r4);
        goto L_0x0137;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.liverunpatchlib.main(java.lang.String[]):void");
    }
}
