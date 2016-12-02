package com.chelpus.root.utils;

public class AdsBlockOFF {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r26) {
        /*
        r22 = new com.chelpus.root.utils.AdsBlockOFF$1;
        r22.<init>();
        com.chelpus.Utils.startRootJava(r22);
        r15 = "#Lucky Patcher block Ads start#";
        r8 = "#Lucky Patcher block Ads finish#";
        r22 = 0;
        r10 = r26[r22];
        r22 = 1;
        r17 = r26[r22];
        r22 = 2;
        r18 = r26[r22];
        r5 = "/data/data/hosts";
        r11 = 0;
        r9 = 0;
        r22 = "/system";
        r23 = "rw";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r13 = 0;
        r19 = 0;
        r16 = com.chelpus.Utils.getSimulink(r10);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = "";
        r0 = r16;
        r1 = r22;
        r22 = r0.equals(r1);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        if (r22 != 0) goto L_0x0072;
    L_0x0070:
        r5 = r16;
    L_0x0072:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r5);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = r22.exists();	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        if (r22 == 0) goto L_0x00d7;
    L_0x007f:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r5);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = r22.length();	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r0 = r24;
        r0.<init>(r10);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r24 = r24.length();	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 != 0) goto L_0x00d7;
    L_0x0099:
        r11 = 1;
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = "Hosts to Data";
        r22.println(r23);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
    L_0x00d7:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r10);	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r22 = r22.exists();	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        if (r22 != 0) goto L_0x00f0;
    L_0x00e4:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r23 = "127.0.0.1       localhost\n";
        com.chelpus.Utils.save_text_to_file(r22, r23);	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
    L_0x00f0:
        if (r11 != 0) goto L_0x0158;
    L_0x00f2:
        r14 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r22 = "r";
        r0 = r22;
        r14.<init>(r10, r0);	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r13 = r14;
    L_0x00fc:
        r22 = 0;
        r0 = r22;
        r13.seek(r0);	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r20 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r22 = "rw";
        r0 = r20;
        r1 = r17;
        r2 = r22;
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r22 = 0;
        r0 = r20;
        r1 = r22;
        r0.setLength(r1);	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        r22 = 0;
        r0 = r20;
        r1 = r22;
        r0.seek(r1);	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        r21 = 1;
    L_0x0124:
        r12 = r13.readLine();	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        if (r12 == 0) goto L_0x0167;
    L_0x012a:
        r22 = r12.contains(r15);	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        if (r22 != 0) goto L_0x0163;
    L_0x0130:
        if (r21 == 0) goto L_0x0163;
    L_0x0132:
        r22 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        r22.<init>();	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r22 = r0.append(r12);	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        r23 = "\n";
        r22 = r22.append(r23);	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        r22 = r22.toString();	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        r0 = r20;
        r1 = r22;
        r0.writeBytes(r1);	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
    L_0x014e:
        r22 = r12.contains(r8);	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        if (r22 == 0) goto L_0x0124;
    L_0x0154:
        r9 = 1;
        r21 = 1;
        goto L_0x0124;
    L_0x0158:
        r14 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r22 = "r";
        r0 = r22;
        r14.<init>(r5, r0);	 Catch:{ Exception -> 0x0282, OutOfMemoryError -> 0x03bc }
        r13 = r14;
        goto L_0x00fc;
    L_0x0163:
        r21 = 0;
        r9 = 1;
        goto L_0x014e;
    L_0x0167:
        r13.close();	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        r20.close();	 Catch:{ Exception -> 0x05ec, OutOfMemoryError -> 0x03bc }
        if (r9 == 0) goto L_0x0176;
    L_0x016f:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = "Changes remove from host";
        r22.println(r23);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
    L_0x0176:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "/system";
        r24 = "rw";
        r23 = com.chelpus.Utils.remount(r23, r24);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.println(r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "/system";
        r24 = "rw";
        r23 = com.chelpus.Utils.remount(r23, r24);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.println(r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        if (r11 != 0) goto L_0x03c9;
    L_0x01af:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = "/system/etc/hosts";
        r23.<init>(r24);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.copyFile(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r22.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r25 = "/system/etc/hosts";
        r24.<init>(r25);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = r24.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 == 0) goto L_0x038a;
    L_0x01de:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = r17.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.println(r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = "/system/etc/hosts";
        r23.<init>(r24);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = r23.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r24;
        r0.println(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r10);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r23;
        r0.<init>(r5);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.copyFile(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r22.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r24;
        r0.<init>(r5);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = r24.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 == 0) goto L_0x02cd;
    L_0x0234:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "no_space_to_data";
        r22.println(r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r5);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "127.0.0.1       localhost\n";
        com.chelpus.Utils.save_text_to_file(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
    L_0x0281:
        return;
    L_0x0282:
        r7 = move-exception;
    L_0x0283:
        r7.printStackTrace();	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = "no_space_to_data";
        r22.println(r23);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        goto L_0x0281;
    L_0x02be:
        r6 = move-exception;
        r6.printStackTrace();
        r22 = java.lang.System.out;
        r23 = "unknown error";
        r22.println(r23);
    L_0x02c9:
        com.chelpus.Utils.exitFromRootJava();
        goto L_0x0281;
    L_0x02cd:
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0.0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0:0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 4;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "ln";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "-s";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 3;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
    L_0x038a:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "host updated!";
        r22.println(r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
    L_0x0391:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        goto L_0x02c9;
    L_0x03bc:
        r4 = move-exception;
        r4.printStackTrace();
        r22 = java.lang.System.out;
        r23 = "out.of.memory";
        r22.println(r23);
        goto L_0x02c9;
    L_0x03c9:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r10);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r23;
        r0.<init>(r5);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.copyFile(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r22.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r24;
        r0.<init>(r5);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = r24.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 == 0) goto L_0x0463;
    L_0x0402:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "no_space_to_data";
        r22.println(r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r5);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = "127.0.0.1       localhost\n";
        com.chelpus.Utils.save_text_to_file(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        goto L_0x0281;
    L_0x0451:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        r23 = "127.0.0.1       localhost\n";
        com.chelpus.Utils.save_text_to_file(r22, r23);	 Catch:{ Exception -> 0x02be, OutOfMemoryError -> 0x03bc }
        goto L_0x0391;
    L_0x0463:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r10);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r22.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r24;
        r0.<init>(r5);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r24 = r24.length();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 == 0) goto L_0x057e;
    L_0x047d:
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r0.<init>(r10);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0.0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0:0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 4;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "ln";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "-s";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 3;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
    L_0x054c:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22.delete();	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        goto L_0x038a;
    L_0x057e:
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0.0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 1;
        r24 = "0:0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        r23 = 2;
        r22[r23] = r5;	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x0451, OutOfMemoryError -> 0x03bc }
        goto L_0x054c;
    L_0x05ec:
        r7 = move-exception;
        r19 = r20;
        goto L_0x0283;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.AdsBlockOFF.main(java.lang.String[]):void");
    }
}
