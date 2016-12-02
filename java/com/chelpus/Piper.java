package com.chelpus;

import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Utils */
class Piper implements Runnable {
    private InputStream input;
    private OutputStream output;

    public Piper(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r7 = this;
        r6 = -1;
        r3 = 512; // 0x200 float:7.17E-43 double:2.53E-321;
        r0 = new byte[r3];	 Catch:{ Exception -> 0x0019 }
        r2 = 1;
    L_0x0006:
        if (r2 <= r6) goto L_0x0028;
    L_0x0008:
        r3 = r7.input;	 Catch:{ Exception -> 0x0019 }
        r4 = 0;
        r5 = r0.length;	 Catch:{ Exception -> 0x0019 }
        r2 = r3.read(r0, r4, r5);	 Catch:{ Exception -> 0x0019 }
        if (r2 <= r6) goto L_0x0006;
    L_0x0012:
        r3 = r7.output;	 Catch:{ Exception -> 0x0019 }
        r4 = 0;
        r3.write(r0, r4, r2);	 Catch:{ Exception -> 0x0019 }
        goto L_0x0006;
    L_0x0019:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0035 }
        r3 = r7.input;	 Catch:{ Exception -> 0x0047 }
        r3.close();	 Catch:{ Exception -> 0x0047 }
    L_0x0022:
        r3 = r7.output;	 Catch:{ Exception -> 0x0045 }
        r3.close();	 Catch:{ Exception -> 0x0045 }
    L_0x0027:
        return;
    L_0x0028:
        r3 = r7.input;	 Catch:{ Exception -> 0x0049 }
        r3.close();	 Catch:{ Exception -> 0x0049 }
    L_0x002d:
        r3 = r7.output;	 Catch:{ Exception -> 0x0033 }
        r3.close();	 Catch:{ Exception -> 0x0033 }
        goto L_0x0027;
    L_0x0033:
        r3 = move-exception;
        goto L_0x0027;
    L_0x0035:
        r3 = move-exception;
        r4 = r7.input;	 Catch:{ Exception -> 0x0043 }
        r4.close();	 Catch:{ Exception -> 0x0043 }
    L_0x003b:
        r4 = r7.output;	 Catch:{ Exception -> 0x0041 }
        r4.close();	 Catch:{ Exception -> 0x0041 }
    L_0x0040:
        throw r3;
    L_0x0041:
        r4 = move-exception;
        goto L_0x0040;
    L_0x0043:
        r4 = move-exception;
        goto L_0x003b;
    L_0x0045:
        r3 = move-exception;
        goto L_0x0027;
    L_0x0047:
        r3 = move-exception;
        goto L_0x0022;
    L_0x0049:
        r3 = move-exception;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.Piper.run():void");
    }
}
