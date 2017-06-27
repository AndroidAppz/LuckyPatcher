package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import net.lingala.zip4j.util.InternalZipConstants;

public class liverunpatch {
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";

    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        String[] orhex = paramArrayOfString[1].split(" ");
        String[] rephex = paramArrayOfString[2].split(" ");
        byte[] byteOrig = new byte[orhex.length];
        byte[] byteReplace = new byte[rephex.length];
        byte[] mask = new byte[orhex.length];
        byte[] rep_mask = new byte[rephex.length];
        boolean error = false;
        if (rep_mask.length != mask.length || byteOrig.length != byteReplace.length || byteReplace.length <= 3 || byteOrig.length <= 3) {
            System.out.println("Error: Original & Replace hex-string not valid!\n\nOriginal.hex.length != Replacmant.hex.length.\nOR\nLength of hex-string < 4");
        } else {
            int t = 0;
            while (t < orhex.length) {
                if (orhex[t].contains("*") && !orhex[t].contains("**")) {
                    error = true;
                    orhex[t] = "00";
                }
                if (rephex[t].contains("*") && !rephex[t].contains("**")) {
                    error = true;
                    rephex[t] = "00";
                }
                if (orhex[t].contains("**") || orhex[t].contains("??")) {
                    orhex[t] = "00";
                    mask[t] = (byte) 1;
                } else {
                    mask[t] = (byte) 0;
                }
                byteOrig[t] = Integer.valueOf(orhex[t], 16).byteValue();
                if (rephex[t].contains("**") || rephex[t].contains("??")) {
                    rephex[t] = "00";
                    rep_mask[t] = (byte) 0;
                } else {
                    rep_mask[t] = (byte) 1;
                }
                byteReplace[t] = Integer.valueOf(rephex[t], 16).byteValue();
                t++;
            }
            if (error) {
                System.out.println("Error: Pattern not valid!\n\nPattern can not be \"*4\" or \"A*\", etc.\n\n It can only be ** ");
            } else {
                String dalvikDex = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
                try {
                    File localFile2;
                    File file = new File(dalvikDex);
                    if (!file.exists()) {
                        file = new File(dalvikDex.replace("-1", "-2"));
                    }
                    file = new File(dalvikDex.replace("-1", ""));
                    if (localFile1.exists()) {
                        localFile2 = localFile1;
                    }
                    String dalvikDexTemp = dalvikDex.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
                    file = new File(dalvikDexTemp);
                    if (file.exists()) {
                        localFile2 = file;
                    }
                    file = new File(dalvikDexTemp.replace("-1", "-2"));
                    if (file.exists()) {
                        localFile2 = file;
                    }
                    file = new File(dalvikDexTemp.replace("-1", ""));
                    if (file.exists()) {
                        localFile2 = file;
                    }
                    if (localFile2.exists()) {
                        FileChannel ChannelDex = new RandomAccessFile(localFile2, InternalZipConstants.WRITE_MODE).getChannel();
                        MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                        boolean patch = false;
                        long j = 0;
                        while (fileBytes.hasRemaining()) {
                            try {
                                int curentPos = fileBytes.position();
                                byte curentByte = fileBytes.get();
                                if (curentByte == byteOrig[0]) {
                                    if (rep_mask[0] == (byte) 0) {
                                        byteReplace[0] = curentByte;
                                    }
                                    int i = 1;
                                    fileBytes.position(curentPos + 1);
                                    byte prufbyte = fileBytes.get();
                                    while (true) {
                                        if (prufbyte != byteOrig[i] && mask[i] != (byte) 1) {
                                            break;
                                        }
                                        if (rep_mask[i] == (byte) 0) {
                                            byteReplace[i] = prufbyte;
                                        }
                                        i++;
                                        if (i == byteOrig.length) {
                                            break;
                                        }
                                        prufbyte = fileBytes.get();
                                    }
                                    fileBytes.position(curentPos);
                                    fileBytes.put(byteReplace);
                                    fileBytes.force();
                                    System.out.println("Offset in file:" + Integer.toHexString(curentPos) + " - Patch done!\n");
                                    patch = true;
                                }
                                fileBytes.position(curentPos + 1);
                                j++;
                            } catch (Exception e) {
                                System.out.println(e);
                            } catch (FileNotFoundException e2) {
                                System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
                            }
                        }
                        ChannelDex.close();
                        if (!patch) {
                            System.out.println("Error: Pattern not found!\nor patch is already applied?!\n");
                        }
                    } else {
                        throw new FileNotFoundException();
                    }
                } catch (FileNotFoundException e22) {
                    System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
                } catch (Exception e3) {
                }
            }
        }
        Utils.exitFromRootJava();
    }
}
