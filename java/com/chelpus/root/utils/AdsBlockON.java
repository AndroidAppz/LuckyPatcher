package com.chelpus.root.utils;

public class AdsBlockON {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r26) {
        /*
        r22 = new com.chelpus.root.utils.AdsBlockON$1;
        r22.<init>();
        com.chelpus.Utils.startRootJava(r22);
        r15 = "#Lucky Patcher block Ads start#";
        r8 = "#Lucky Patcher block Ads finish#";
        r22 = 0;
        r9 = r26[r22];
        r22 = 1;
        r17 = r26[r22];
        r22 = 2;
        r14 = r26[r22];
        r22 = 3;
        r18 = r26[r22];
        r5 = "/data/data/hosts";
        r10 = 0;
        r16 = com.chelpus.Utils.getSimulink(r9);
        r22 = "";
        r0 = r16;
        r1 = r22;
        r22 = r0.equals(r1);
        if (r22 != 0) goto L_0x0031;
    L_0x002f:
        r5 = r16;
    L_0x0031:
        r22 = "/system";
        r23 = "rw";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r12 = 0;
        r19 = 0;
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r5);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r22.exists();	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        if (r22 == 0) goto L_0x00de;
    L_0x0082:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r5);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r22.length();	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r0 = r24;
        r0.<init>(r9);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r24 = r24.length();	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 != 0) goto L_0x00de;
    L_0x009c:
        r10 = 1;
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = "Hosts to Data";
        r22.println(r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
    L_0x00de:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r9);	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r22 = r22.exists();	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        if (r22 != 0) goto L_0x00f7;
    L_0x00eb:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r23 = "127.0.0.1       localhost\n";
        com.chelpus.Utils.save_text_to_file(r22, r23);	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
    L_0x00f7:
        if (r10 != 0) goto L_0x015e;
    L_0x00f9:
        r13 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r22 = "r";
        r0 = r22;
        r13.<init>(r9, r0);	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r12 = r13;
    L_0x0103:
        r22 = 0;
        r0 = r22;
        r12.seek(r0);	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r20 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r22 = "rw";
        r0 = r20;
        r1 = r17;
        r2 = r22;
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r22 = 0;
        r0 = r20;
        r1 = r22;
        r0.setLength(r1);	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r22 = 0;
        r0 = r20;
        r1 = r22;
        r0.seek(r1);	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r21 = 1;
    L_0x012b:
        r11 = r12.readLine();	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        if (r11 == 0) goto L_0x016c;
    L_0x0131:
        r22 = r11.contains(r15);	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        if (r22 != 0) goto L_0x0169;
    L_0x0137:
        if (r21 == 0) goto L_0x0169;
    L_0x0139:
        r22 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r22.<init>();	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r22 = r0.append(r11);	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r23 = "\n";
        r22 = r22.append(r23);	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r22 = r22.toString();	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r0 = r20;
        r1 = r22;
        r0.writeBytes(r1);	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
    L_0x0155:
        r22 = r11.contains(r8);	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        if (r22 == 0) goto L_0x012b;
    L_0x015b:
        r21 = 1;
        goto L_0x012b;
    L_0x015e:
        r13 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r22 = "r";
        r0 = r22;
        r13.<init>(r5, r0);	 Catch:{ Exception -> 0x0294, OutOfMemoryError -> 0x03d8 }
        r12 = r13;
        goto L_0x0103;
    L_0x0169:
        r21 = 0;
        goto L_0x0155;
    L_0x016c:
        r12.close();	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r20.close();	 Catch:{ Exception -> 0x065d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r0 = r23;
        r0.<init>(r14);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = com.chelpus.Utils.save_text_to_end_file_from_file(r22, r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        if (r22 == 0) goto L_0x0654;
    L_0x0188:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "/system";
        r24 = "rw";
        r23 = com.chelpus.Utils.remount(r23, r24);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.println(r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "/system";
        r24 = "rw";
        r23 = com.chelpus.Utils.remount(r23, r24);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.println(r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        if (r10 != 0) goto L_0x03e5;
    L_0x01c1:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = "/system/etc/hosts";
        r23.<init>(r24);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.copyFile(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r22.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r25 = "/system/etc/hosts";
        r24.<init>(r25);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = r24.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 == 0) goto L_0x03a6;
    L_0x01f0:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = r17.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.println(r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = "/system/etc/hosts";
        r23.<init>(r24);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = r23.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r24;
        r0.println(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r9);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = "/data/data/hosts";
        r23.<init>(r24);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.copyFile(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r22.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r25 = "/data/data/hosts";
        r24.<init>(r25);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = r24.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 == 0) goto L_0x02df;
    L_0x0246:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "no_space_to_data";
        r22.println(r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r5);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "127.0.0.1       localhost\n";
        com.chelpus.Utils.save_text_to_file(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
    L_0x0293:
        return;
    L_0x0294:
        r7 = move-exception;
    L_0x0295:
        r7.printStackTrace();	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = "no_space_to_data";
        r22.println(r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        goto L_0x0293;
    L_0x02d0:
        r6 = move-exception;
        r6.printStackTrace();
        r22 = java.lang.System.out;
        r23 = "unknown error";
        r22.println(r23);
    L_0x02db:
        com.chelpus.Utils.exitFromRootJava();
        goto L_0x0293;
    L_0x02df:
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0.0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0:0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 4;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "ln";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "-s";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 3;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
    L_0x03a6:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "host updated!";
        r22.println(r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
    L_0x03ad:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        goto L_0x02db;
    L_0x03d8:
        r4 = move-exception;
        r4.printStackTrace();
        r22 = java.lang.System.out;
        r23 = "out.of.memory";
        r22.println(r23);
        goto L_0x02db;
    L_0x03e5:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r9);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = "/data/data/hosts";
        r23.<init>(r24);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.copyFile(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r22.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r25 = "/data/data/hosts";
        r24.<init>(r25);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = r24.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 == 0) goto L_0x04b7;
    L_0x041e:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "no_space_to_data";
        r22.println(r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r5);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = "127.0.0.1       localhost\n";
        com.chelpus.Utils.save_text_to_file(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        goto L_0x0293;
    L_0x046d:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = "127.0.0.1       localhost\n";
        com.chelpus.Utils.save_text_to_file(r22, r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = "/system/etc/hosts";
        r22.<init>(r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = new java.io.File;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r0 = r23;
        r0.<init>(r14);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r22 = com.chelpus.Utils.save_text_to_end_file_from_file(r22, r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        if (r22 != 0) goto L_0x03ad;
    L_0x04ae:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = "out.of.memory";
        r22.println(r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        goto L_0x03ad;
    L_0x04b7:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r9);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r22.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r24;
        r0.<init>(r5);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r24 = r24.length();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 == 0) goto L_0x05de;
    L_0x04d1:
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r0.<init>(r9);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0777";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0.0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0:0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 4;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "ln";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "-s";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 3;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
    L_0x05ac:
        r22 = new java.io.File;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r0 = r22;
        r1 = r17;
        r0.<init>(r1);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22.delete();	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/system/etc/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = "/system";
        r23 = "ro";
        com.chelpus.Utils.remount(r22, r23);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        goto L_0x03a6;
    L_0x05de:
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chmod";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0644";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chattr";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "-ai";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0.0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = 3;
        r0 = r22;
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r22 = r0;
        r23 = 0;
        r24 = "chown";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 1;
        r24 = "0:0";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        r23 = 2;
        r24 = "/data/data/hosts";
        r22[r23] = r24;	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        com.chelpus.Utils.run_all_no_root(r22);	 Catch:{ Exception -> 0x046d, OutOfMemoryError -> 0x03d8 }
        goto L_0x05ac;
    L_0x0654:
        r22 = java.lang.System.out;	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        r23 = "no_space_to_data";
        r22.println(r23);	 Catch:{ Exception -> 0x02d0, OutOfMemoryError -> 0x03d8 }
        goto L_0x03ad;
    L_0x065d:
        r7 = move-exception;
        r19 = r20;
        goto L_0x0295;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.AdsBlockON.main(java.lang.String[]):void");
    }
}
