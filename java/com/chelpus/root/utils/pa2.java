package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import net.lingala.zip4j.util.InternalZipConstants;

public class pa2 {
    public static void main(String[] paramArrayOfString) {
        byte[] byteOrig2 = new byte[]{(byte) 112, (byte) 97, (byte) 116, (byte) 104, (byte) 95, (byte) 104, (byte) 97, (byte) 115, (byte) 104};
        byte[] bArr = new byte[9];
        bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        byte[] byteReplace2 = new byte[]{(byte) 112, (byte) 97, (byte) 108, (byte) 104, (byte) 95, (byte) 104, (byte) 97, (byte) 115, (byte) 104};
        byte[] bArr2 = new byte[9];
        bArr2 = new byte[]{(byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        try {
            Utils.startRootJava(new Object() {
            });
            File file = new File("/data/data/com.maxmpz.audioplayer/databases/folders.db");
            if (file.exists()) {
                FileChannel ChannelDex = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE).getChannel();
                MappedByteBuffer fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                long j = 0;
                while (fileBytes.hasRemaining()) {
                    try {
                        int curentPos = fileBytes.position();
                        byte curentByte = fileBytes.get();
                        if (curentByte == byteOrig2[0]) {
                            if (bArr2[0] == (byte) 0) {
                                byteReplace2[0] = curentByte;
                            }
                            int i = 1;
                            fileBytes.position(curentPos + 1);
                            byte prufbyte = fileBytes.get();
                            while (true) {
                                if (prufbyte != byteOrig2[i] && bArr[i] != (byte) 1) {
                                    break;
                                }
                                if (bArr2[i] == (byte) 0) {
                                    byteReplace2[i] = prufbyte;
                                }
                                i++;
                                if (i == byteOrig2.length) {
                                    break;
                                }
                                prufbyte = fileBytes.get();
                            }
                            fileBytes.position(curentPos);
                            fileBytes.put(byteReplace2);
                            fileBytes.force();
                            fileBytes.position(curentPos + 1);
                        }
                        fileBytes.position(curentPos + 1);
                        j++;
                    } catch (Exception e) {
                        System.out.println("" + e);
                    }
                }
                ChannelDex.close();
                Utils.exitFromRootJava();
                return;
            }
            throw new FileNotFoundException();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
