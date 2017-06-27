package com.chelpus.root.utils;

public class pa {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r15) {
        /*
        r3 = 1;
        r2 = 0;
        r1 = new com.chelpus.root.utils.pa$1;
        r1.<init>();
        com.chelpus.Utils.startRootJava(r1);
        r14 = r15[r2];
        r12 = r15[r3];
        r0 = 0;
        r13 = new com.chelpus.Utils;	 Catch:{ Exception -> 0x00ec }
        r1 = "asd";
        r13.<init>(r1);	 Catch:{ Exception -> 0x00ec }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x00ec }
        r2 = "/data/data/com.maxmpz.audioplayer/";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = "folders.db";
        r9 = r13.findFile(r1, r2);	 Catch:{ Exception -> 0x00ec }
        r1 = "";
        r1 = r9.equals(r1);	 Catch:{ Exception -> 0x00ec }
        if (r1 != 0) goto L_0x0172;
    L_0x002b:
        r1 = 3;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x00ec }
        r2 = 0;
        r3 = "chmod";
        r1[r2] = r3;	 Catch:{ Exception -> 0x00ec }
        r2 = 1;
        r3 = "777";
        r1[r2] = r3;	 Catch:{ Exception -> 0x00ec }
        r2 = 2;
        r1[r2] = r9;	 Catch:{ Exception -> 0x00ec }
        com.chelpus.Utils.run_all_no_root(r1);	 Catch:{ Exception -> 0x00ec }
        r1 = 0;
        r2 = 0;
        r0 = android.database.sqlite.SQLiteDatabase.openDatabase(r9, r1, r2);	 Catch:{ Exception -> 0x00ec }
        r1 = "storages";
        r2 = 4;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x00ec }
        r3 = 0;
        r4 = "_id";
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ec }
        r3 = 1;
        r4 = "path";
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ec }
        r3 = 2;
        r4 = "path_hash";
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ec }
        r3 = 3;
        r4 = "updated_at";
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ec }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00ec }
        r8.moveToFirst();	 Catch:{ Exception -> 0x00ec }
        r11 = "";
    L_0x006b:
        r1 = "path";
        r1 = r8.getColumnIndex(r1);	 Catch:{ Exception -> 0x00ec }
        r11 = r8.getString(r1);	 Catch:{ Exception -> 0x00ec }
        r1 = r8.moveToNext();	 Catch:{ Exception -> 0x00e7 }
        if (r1 != 0) goto L_0x00f4;
    L_0x007b:
        r8.close();	 Catch:{ Exception -> 0x00e7 }
    L_0x007e:
        if (r11 != 0) goto L_0x0082;
    L_0x0080:
        r11 = "/mnt/sdcard";
    L_0x0082:
        r1 = java.lang.System.out;	 Catch:{ Exception -> 0x00ec }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ec }
        r3 = "4 ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ec }
        r2 = r2.append(r11);	 Catch:{ Exception -> 0x00ec }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ec }
        r1.println(r2);	 Catch:{ Exception -> 0x00ec }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ec }
        r2 = "UPDATE storages SET path='";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00ec }
        r1 = r1.append(r11);	 Catch:{ Exception -> 0x00ec }
        r2 = "',path_hash='";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ec }
        r1 = r1.append(r14);	 Catch:{ Exception -> 0x00ec }
        r2 = "',updated_at='";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00ec }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = "'";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ec }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00ec }
        r0.execSQL(r1);	 Catch:{ Exception -> 0x00ec }
        r1 = java.lang.System.out;	 Catch:{ Exception -> 0x00ec }
        r2 = "Add info";
        r1.println(r2);	 Catch:{ Exception -> 0x00ec }
    L_0x00cd:
        r0.close();	 Catch:{ Exception -> 0x00ec }
        r1 = 3;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x00ec }
        r2 = 0;
        r3 = "chmod";
        r1[r2] = r3;	 Catch:{ Exception -> 0x00ec }
        r2 = 1;
        r3 = "644";
        r1[r2] = r3;	 Catch:{ Exception -> 0x00ec }
        r2 = 2;
        r1[r2] = r9;	 Catch:{ Exception -> 0x00ec }
        com.chelpus.Utils.run_all_no_root(r1);	 Catch:{ Exception -> 0x00ec }
    L_0x00e3:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x00e7:
        r10 = move-exception;
        r8.close();	 Catch:{ Exception -> 0x00ec }
        goto L_0x007e;
    L_0x00ec:
        r10 = move-exception;
        r0.close();
        r10.printStackTrace();
        goto L_0x00e3;
    L_0x00f4:
        r1 = r11.length();	 Catch:{ Exception -> 0x0154 }
        r2 = 4;
        if (r1 >= r2) goto L_0x0103;
    L_0x00fb:
        r1 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0154 }
        r11 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x0154 }
    L_0x0103:
        r1 = java.lang.System.out;	 Catch:{ Exception -> 0x0154 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0154 }
        r3 = "2 ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0154 }
        r2 = r2.append(r11);	 Catch:{ Exception -> 0x0154 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0154 }
        r1.println(r2);	 Catch:{ Exception -> 0x0154 }
    L_0x0117:
        if (r11 != 0) goto L_0x011b;
    L_0x0119:
        r11 = "/mnt/sdcard";
    L_0x011b:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ec }
        r2 = "UPDATE storages SET path='";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00ec }
        r1 = r1.append(r11);	 Catch:{ Exception -> 0x00ec }
        r2 = "',path_hash='";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ec }
        r1 = r1.append(r14);	 Catch:{ Exception -> 0x00ec }
        r2 = "',updated_at='";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00ec }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = "'";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ec }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00ec }
        r0.execSQL(r1);	 Catch:{ Exception -> 0x00ec }
        r1 = java.lang.System.out;	 Catch:{ Exception -> 0x00ec }
        r2 = "Add info";
        r1.println(r2);	 Catch:{ Exception -> 0x00ec }
        goto L_0x006b;
    L_0x0154:
        r10 = move-exception;
        r1 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x00ec }
        r11 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x00ec }
        r1 = java.lang.System.out;	 Catch:{ Exception -> 0x00ec }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ec }
        r3 = "3 ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ec }
        r2 = r2.append(r11);	 Catch:{ Exception -> 0x00ec }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ec }
        r1.println(r2);	 Catch:{ Exception -> 0x00ec }
        goto L_0x0117;
    L_0x0172:
        r1 = java.lang.System.out;	 Catch:{ Exception -> 0x00ec }
        r2 = "SU Java-Code Running!\nYou must run Poweramp before patch!\nRun Poweramp and apply custom patch again!\n\nGood Luck!\nSaNX@forpda.ru";
        r1.println(r2);	 Catch:{ Exception -> 0x00ec }
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.pa.main(java.lang.String[]):void");
    }
}
