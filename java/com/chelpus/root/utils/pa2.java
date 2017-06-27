package com.chelpus.root.utils;

public class pa2 {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r23) {
        /*
        r3 = 9;
        r8 = new byte[r3];
        r8 = {112, 97, 116, 104, 95, 104, 97, 115, 104};
        r3 = 9;
        r0 = new byte[r3];
        r19 = r0;
        r3 = 9;
        r9 = new byte[r3];
        r9 = {112, 97, 108, 104, 95, 104, 97, 115, 104};
        r3 = 9;
        r0 = new byte[r3];
        r21 = r0;
        r3 = 2;
        r4 = 1;
        r21[r3] = r4;
        r3 = new com.chelpus.root.utils.pa2$1;	 Catch:{ Exception -> 0x003b }
        r3.<init>();	 Catch:{ Exception -> 0x003b }
        com.chelpus.Utils.startRootJava(r3);	 Catch:{ Exception -> 0x003b }
        r18 = new java.io.File;	 Catch:{ Exception -> 0x003b }
        r3 = "/data/data/com.maxmpz.audioplayer/databases/folders.db";
        r0 = r18;
        r0.<init>(r3);	 Catch:{ Exception -> 0x003b }
        r3 = r18.exists();	 Catch:{ Exception -> 0x003b }
        if (r3 != 0) goto L_0x0043;
    L_0x0035:
        r3 = new java.io.FileNotFoundException;	 Catch:{ Exception -> 0x003b }
        r3.<init>();	 Catch:{ Exception -> 0x003b }
        throw r3;	 Catch:{ Exception -> 0x003b }
    L_0x003b:
        r13 = move-exception;
        r13.printStackTrace();
    L_0x003f:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x0043:
        r3 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x003b }
        r4 = "rw";
        r0 = r18;
        r3.<init>(r0, r4);	 Catch:{ Exception -> 0x003b }
        r2 = r3.getChannel();	 Catch:{ Exception -> 0x003b }
        r3 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ Exception -> 0x003b }
        r4 = 0;
        r6 = r2.size();	 Catch:{ Exception -> 0x003b }
        r6 = (int) r6;	 Catch:{ Exception -> 0x003b }
        r6 = (long) r6;	 Catch:{ Exception -> 0x003b }
        r14 = r2.map(r3, r4, r6);	 Catch:{ Exception -> 0x003b }
        r12 = 0;
        r22 = 0;
        r16 = 0;
    L_0x0063:
        r3 = r14.hasRemaining();	 Catch:{ Exception -> 0x00bb }
        if (r3 != 0) goto L_0x006d;
    L_0x0069:
        r2.close();	 Catch:{ Exception -> 0x003b }
        goto L_0x003f;
    L_0x006d:
        r11 = r14.position();	 Catch:{ Exception -> 0x00bb }
        r10 = r14.get();	 Catch:{ Exception -> 0x00bb }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ Exception -> 0x00bb }
        if (r10 != r3) goto L_0x009c;
    L_0x007a:
        r3 = 0;
        r3 = r21[r3];	 Catch:{ Exception -> 0x00bb }
        if (r3 != 0) goto L_0x0082;
    L_0x007f:
        r3 = 0;
        r9[r3] = r10;	 Catch:{ Exception -> 0x00bb }
    L_0x0082:
        r15 = 1;
        r3 = r11 + 1;
        r14.position(r3);	 Catch:{ Exception -> 0x00bb }
        r20 = r14.get();	 Catch:{ Exception -> 0x00bb }
    L_0x008c:
        r3 = r8[r15];	 Catch:{ Exception -> 0x00bb }
        r0 = r20;
        if (r0 == r3) goto L_0x00a6;
    L_0x0092:
        r3 = r19[r15];	 Catch:{ Exception -> 0x00bb }
        r4 = 1;
        if (r3 == r4) goto L_0x00a6;
    L_0x0097:
        r3 = r11 + 1;
        r14.position(r3);	 Catch:{ Exception -> 0x00bb }
    L_0x009c:
        r3 = r11 + 1;
        r14.position(r3);	 Catch:{ Exception -> 0x00bb }
        r4 = 1;
        r16 = r16 + r4;
        goto L_0x0063;
    L_0x00a6:
        r3 = r21[r15];	 Catch:{ Exception -> 0x00bb }
        if (r3 != 0) goto L_0x00ac;
    L_0x00aa:
        r9[r15] = r20;	 Catch:{ Exception -> 0x00bb }
    L_0x00ac:
        r15 = r15 + 1;
        r3 = r8.length;	 Catch:{ Exception -> 0x00bb }
        if (r15 != r3) goto L_0x00cf;
    L_0x00b1:
        r14.position(r11);	 Catch:{ Exception -> 0x00bb }
        r14.put(r9);	 Catch:{ Exception -> 0x00bb }
        r14.force();	 Catch:{ Exception -> 0x00bb }
        goto L_0x0097;
    L_0x00bb:
        r13 = move-exception;
        r3 = java.lang.System.out;	 Catch:{ Exception -> 0x003b }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003b }
        r4.<init>();	 Catch:{ Exception -> 0x003b }
        r4 = r4.append(r13);	 Catch:{ Exception -> 0x003b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x003b }
        r3.println(r4);	 Catch:{ Exception -> 0x003b }
        goto L_0x0069;
    L_0x00cf:
        r20 = r14.get();	 Catch:{ Exception -> 0x00bb }
        goto L_0x008c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.pa2.main(java.lang.String[]):void");
    }
}
