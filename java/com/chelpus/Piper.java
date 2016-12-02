/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.chelpus;

import java.io.InputStream;
import java.io.OutputStream;

class Piper
implements Runnable {
    private InputStream input;
    private OutputStream output;

    public Piper(InputStream inputStream, OutputStream outputStream) {
        this.input = inputStream;
        this.output = outputStream;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        var7_1 = new byte[512];
        var8_2 = 1;
        while (var8_2 > -1) {
            var8_2 = this.input.read(var7_1, 0, var7_1.length);
            if (var8_2 <= -1) continue;
            try {
                this.output.write(var7_1, 0, var8_2);
                continue;
            }
            catch (Exception var4_3) {
                var4_3.printStackTrace();
                this.input.close();
lbl17: // 3 sources:
                this.output.close();
                return;
            }
        }
        try {
            this.input.close();
        }
        catch (Exception var9_10) {
            ** continue;
        }
lbl23: // 2 sources:
        do {
            try {
                this.output.close();
                return;
            }
            catch (Exception var10_4) {
                return;
            }
            break;
        } while (true);
        {
            catch (Throwable var1_5) {
                try {
                    this.input.close();
                }
                catch (Exception var2_7) {
                    ** continue;
                }
lbl34: // 2 sources:
                do {
                    try {
                        this.output.close();
                    }
                    catch (Exception var3_6) {
                        throw var1_5;
                    }
                    do {
                        throw var1_5;
                        break;
                    } while (true);
                    break;
                } while (true);
            }
            catch (Exception var6_8) {
                return;
            }
            catch (Exception var5_9) {
                ** GOTO lbl17
            }
        }
    }
}

