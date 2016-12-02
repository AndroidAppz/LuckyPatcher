/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.PrintStream
 *  java.io.RandomAccessFile
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.MappedByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.channels.FileChannel$MapMode
 */
package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class pa2 {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void main(String[] var0) {
        var1_1 = new byte[]{112, 97, 116, 104, 95, 104, 97, 115, 104};
        var2_2 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        var3_3 = new byte[]{112, 97, 108, 104, 95, 104, 97, 115, 104};
        var4_4 = new byte[]{0, 0, 1, 0, 0, 0, 0, 0, 0};
        Utils.startRootJava(new Object(){});
        var6_5 = new File("/data/data/com.maxmpz.audioplayer/databases/folders.db");
        if (!var6_5.exists()) {
            throw new FileNotFoundException();
        }
        var7_7 = new RandomAccessFile(var6_5, "rw").getChannel();
        var8_8 = var7_7.map(FileChannel.MapMode.READ_WRITE, 0, (long)((int)var7_7.size()));
        var9_9 = 0;
        {
            catch (Exception var5_6) {
                var5_6.printStackTrace();
lbl16: // 2 sources:
                do {
                    Utils.exitFromRootJava();
                    return;
                    break;
                } while (true);
            }
            try {
                block8 : while (var8_8.hasRemaining()) {
                    var12_15 = var8_8.position();
                    var13_10 = var8_8.get();
                    if (var13_10 != var1_1[0]) ** GOTO lbl38
                    if (var4_4[0] == 0) {
                        var3_3[0] = var13_10;
                    }
                    var15_12 = 1;
                    var8_8.position(var12_15 + 1);
                    var17_14 = var8_8.get();
                    do {
                        if (var17_14 != (var18_13 = var1_1[var15_12]) && var2_2[var15_12] != 1) ** GOTO lbl37
                        if (var4_4[var15_12] == 0) {
                            var3_3[var15_12] = var17_14;
                        }
                        if (++var15_12 == var1_1.length) {
                            var8_8.position(var12_15);
                            var8_8.put(var3_3);
                            var8_8.force();
lbl37: // 2 sources:
                            var8_8.position(var12_15 + 1);
lbl38: // 2 sources:
                            var8_8.position(var12_15 + 1);
                            ++var9_9;
                            continue block8;
                        }
                        var17_14 = var19_11 = var8_8.get();
                    } while (true);
                }
                ** GOTO lbl46
            }
            catch (Exception var11_16) {}
            {
                System.out.println("" + (Object)var11_16);
lbl46: // 2 sources:
                var7_7.close();
                ** continue;
            }
        }
    }

}

