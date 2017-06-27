package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import net.lingala.zip4j.util.InternalZipConstants;

public class testcore {
    public static void main(String[] er) {
        File localFile2;
        Exception e;
        FileChannel ChannelDex;
        MappedByteBuffer fileBytes;
        long j;
        byte curentByte;
        byte prufbyte;
        Utils.startRootJava(new Object() {
        });
        File file = null;
        maskS2 = new byte[16];
        maskS3 = new byte[64];
        mask2 = new byte[35];
        mask4 = new byte[30];
        mask5 = new byte[28];
        mask6 = new byte[43];
        mask7 = new byte[30];
        mask8 = new byte[29];
        mask9 = new byte[37];
        byteOrigS2 = new byte[16];
        maskS2 = new byte[16];
        byteOrigS3 = new byte[24];
        byteOrigS3 = new byte[]{(byte) 18, (byte) 102, (byte) 56, (byte) 102, (byte) 102, (byte) 102, (byte) 26, (byte) 102, (byte) 102, (byte) 102, (byte) 26, (byte) 102, (byte) 102, (byte) 102, (byte) 113, (byte) 102, (byte) 102, (byte) 102, (byte) 102, (byte) 102, (byte) 19, (byte) 102, (byte) -19, (byte) -1};
        maskS3 = new byte[24];
        byte[] byteOrigS4 = new byte[19];
        byteOrigS4[0] = Byte.MIN_VALUE;
        byteOrigS4[2] = (byte) 57;
        byteOrigS4[3] = (byte) 102;
        byteOrigS4[4] = (byte) 102;
        byteOrigS4[5] = (byte) 102;
        byteOrigS4[6] = (byte) 102;
        byteOrigS4[7] = (byte) 102;
        byteOrigS4[8] = (byte) 102;
        byteOrigS4[9] = (byte) 102;
        byteOrigS4[10] = (byte) 102;
        byteOrigS4[11] = (byte) 102;
        byteOrigS4[12] = (byte) 102;
        byteOrigS4[13] = (byte) 102;
        byteOrigS4[14] = (byte) 53;
        byteOrigS4[15] = (byte) -120;
        byteOrigS4[16] = (byte) 102;
        byteOrigS4[17] = (byte) 102;
        byteOrigS4[18] = (byte) 26;
        maskS4 = new byte[19];
        r18 = new byte[35];
        r19 = new byte[36];
        r20 = new byte[30];
        r21 = new byte[28];
        r22 = new byte[43];
        r23 = new byte[30];
        r24 = new byte[29];
        r25 = new byte[37];
        r8 = new byte[35];
        r44 = new byte[35];
        r9 = new byte[36];
        r10 = new byte[30];
        r45 = new byte[30];
        r11 = new byte[28];
        r46 = new byte[28];
        r12 = new byte[43];
        r47 = new byte[43];
        byte[] bArr = new byte[44];
        bArr[0] = (byte) 56;
        bArr[1] = (byte) 102;
        bArr[2] = (byte) 102;
        bArr[3] = (byte) 102;
        bArr[4] = (byte) 58;
        bArr[5] = (byte) 102;
        bArr[6] = (byte) 102;
        bArr[7] = (byte) 102;
        bArr[8] = (byte) 58;
        bArr[9] = (byte) 102;
        bArr[10] = (byte) 102;
        bArr[11] = (byte) 102;
        bArr[12] = (byte) -112;
        bArr[13] = (byte) 102;
        bArr[14] = (byte) 102;
        bArr[15] = (byte) 102;
        bArr[16] = (byte) 33;
        bArr[17] = (byte) 102;
        bArr[18] = (byte) 55;
        bArr[19] = (byte) 102;
        bArr[20] = (byte) 102;
        bArr[21] = (byte) 102;
        bArr[22] = (byte) 34;
        bArr[23] = (byte) 102;
        bArr[24] = (byte) 102;
        bArr[25] = (byte) 102;
        bArr[26] = (byte) 112;
        bArr[27] = (byte) 102;
        bArr[28] = (byte) 102;
        bArr[29] = (byte) 102;
        bArr[30] = (byte) 102;
        bArr[31] = (byte) 102;
        bArr[32] = (byte) 39;
        bArr[33] = (byte) 102;
        bArr[34] = (byte) 102;
        bArr[35] = (byte) 102;
        bArr[36] = (byte) 102;
        bArr[37] = (byte) 102;
        bArr[38] = (byte) 102;
        bArr[39] = (byte) 102;
        bArr[40] = (byte) 18;
        bArr[41] = (byte) 16;
        bArr[42] = (byte) 15;
        r48 = new byte[44];
        byte[] bArr2 = new byte[70];
        bArr2[0] = (byte) 56;
        bArr2[1] = (byte) 102;
        bArr2[2] = (byte) 102;
        bArr2[3] = (byte) 102;
        bArr2[4] = (byte) 58;
        bArr2[5] = (byte) 102;
        bArr2[6] = (byte) 102;
        bArr2[7] = (byte) 102;
        bArr2[8] = (byte) 58;
        bArr2[9] = (byte) 102;
        bArr2[10] = (byte) 102;
        bArr2[11] = (byte) 102;
        bArr2[12] = (byte) -112;
        bArr2[13] = (byte) 102;
        bArr2[14] = (byte) 102;
        bArr2[15] = (byte) 102;
        bArr2[16] = (byte) 33;
        bArr2[17] = (byte) 102;
        bArr2[18] = (byte) 55;
        bArr2[19] = (byte) 102;
        bArr2[20] = (byte) 102;
        bArr2[21] = (byte) 102;
        bArr2[22] = (byte) 34;
        bArr2[23] = (byte) 102;
        bArr2[24] = (byte) 102;
        bArr2[25] = (byte) 102;
        bArr2[26] = (byte) 112;
        bArr2[27] = (byte) 102;
        bArr2[28] = (byte) 102;
        bArr2[29] = (byte) 102;
        bArr2[30] = (byte) 102;
        bArr2[31] = (byte) 102;
        bArr2[32] = (byte) 39;
        bArr2[33] = (byte) 102;
        bArr2[34] = (byte) 33;
        bArr2[35] = (byte) 102;
        bArr2[36] = (byte) 102;
        bArr2[37] = (byte) 102;
        bArr2[38] = (byte) 102;
        bArr2[39] = (byte) 102;
        bArr2[40] = (byte) 102;
        bArr2[41] = (byte) 102;
        bArr2[42] = (byte) 102;
        bArr2[43] = (byte) 102;
        bArr2[44] = (byte) 102;
        bArr2[45] = (byte) 102;
        bArr2[46] = (byte) 102;
        bArr2[47] = (byte) 102;
        bArr2[48] = (byte) 102;
        bArr2[49] = (byte) 102;
        bArr2[50] = (byte) 102;
        bArr2[51] = (byte) 102;
        bArr2[52] = (byte) 102;
        bArr2[53] = (byte) 102;
        bArr2[54] = (byte) 102;
        bArr2[55] = (byte) 102;
        bArr2[56] = (byte) 102;
        bArr2[57] = (byte) 102;
        bArr2[58] = (byte) 102;
        bArr2[59] = (byte) 102;
        bArr2[60] = (byte) 102;
        bArr2[61] = (byte) 102;
        bArr2[62] = (byte) 102;
        bArr2[63] = (byte) 102;
        bArr2[64] = (byte) 102;
        bArr2[65] = (byte) 102;
        bArr2[66] = (byte) 18;
        bArr2[67] = (byte) 16;
        bArr2[68] = (byte) 15;
        r49 = new byte[70];
        byte[] bArr3 = new byte[56];
        bArr3[0] = (byte) 56;
        bArr3[1] = (byte) 102;
        bArr3[2] = (byte) 102;
        bArr3[3] = (byte) 102;
        bArr3[4] = (byte) 58;
        bArr3[5] = (byte) 102;
        bArr3[6] = (byte) 102;
        bArr3[7] = (byte) 102;
        bArr3[8] = (byte) 58;
        bArr3[9] = (byte) 102;
        bArr3[10] = (byte) 102;
        bArr3[11] = (byte) 102;
        bArr3[12] = (byte) -112;
        bArr3[13] = (byte) 102;
        bArr3[14] = (byte) 102;
        bArr3[15] = (byte) 102;
        bArr3[16] = (byte) 33;
        bArr3[17] = (byte) 102;
        bArr3[18] = (byte) 55;
        bArr3[19] = (byte) 102;
        bArr3[20] = (byte) 102;
        bArr3[21] = (byte) 102;
        bArr3[22] = (byte) 34;
        bArr3[23] = (byte) 102;
        bArr3[24] = (byte) 102;
        bArr3[25] = (byte) 102;
        bArr3[26] = (byte) 26;
        bArr3[27] = (byte) 102;
        bArr3[28] = (byte) 102;
        bArr3[29] = (byte) 102;
        bArr3[30] = (byte) 113;
        bArr3[31] = (byte) 102;
        bArr3[32] = (byte) 102;
        bArr3[33] = (byte) 102;
        bArr3[34] = (byte) 102;
        bArr3[35] = (byte) 102;
        bArr3[36] = (byte) 12;
        bArr3[37] = (byte) 102;
        bArr3[38] = (byte) 112;
        bArr3[39] = (byte) 102;
        bArr3[40] = (byte) 102;
        bArr3[41] = (byte) 102;
        bArr3[42] = (byte) 102;
        bArr3[43] = (byte) 102;
        bArr3[44] = (byte) 39;
        bArr3[45] = (byte) 102;
        bArr3[46] = (byte) 102;
        bArr3[47] = (byte) 102;
        bArr3[48] = (byte) 102;
        bArr3[49] = (byte) 102;
        bArr3[50] = (byte) 102;
        bArr3[51] = (byte) 102;
        bArr3[52] = (byte) 18;
        bArr3[53] = (byte) 16;
        bArr3[54] = (byte) 15;
        r50 = new byte[56];
        r16 = new byte[41];
        r51 = new byte[41];
        byte[] bArr4 = new byte[50];
        bArr4[0] = (byte) 56;
        bArr4[1] = (byte) 102;
        bArr4[2] = (byte) 102;
        bArr4[3] = (byte) 102;
        bArr4[4] = (byte) 58;
        bArr4[5] = (byte) 102;
        bArr4[6] = (byte) 102;
        bArr4[7] = (byte) 102;
        bArr4[8] = (byte) 58;
        bArr4[9] = (byte) 102;
        bArr4[10] = (byte) 102;
        bArr4[11] = (byte) 102;
        bArr4[12] = (byte) -112;
        bArr4[13] = (byte) 102;
        bArr4[14] = (byte) 102;
        bArr4[15] = (byte) 102;
        bArr4[16] = (byte) 33;
        bArr4[17] = (byte) 102;
        bArr4[18] = (byte) 55;
        bArr4[19] = (byte) 102;
        bArr4[20] = (byte) 102;
        bArr4[21] = (byte) 102;
        bArr4[22] = (byte) 34;
        bArr4[23] = (byte) 102;
        bArr4[24] = (byte) 102;
        bArr4[25] = (byte) 102;
        bArr4[26] = (byte) 112;
        bArr4[27] = (byte) 102;
        bArr4[28] = (byte) 102;
        bArr4[29] = (byte) 102;
        bArr4[30] = (byte) 102;
        bArr4[31] = (byte) 102;
        bArr4[32] = (byte) 39;
        bArr4[33] = (byte) 102;
        bArr4[34] = (byte) 102;
        bArr4[35] = (byte) 102;
        bArr4[36] = (byte) 102;
        bArr4[37] = (byte) 102;
        bArr4[38] = (byte) 102;
        bArr4[39] = (byte) 102;
        bArr4[40] = (byte) 102;
        bArr4[41] = (byte) 102;
        bArr4[42] = (byte) 102;
        bArr4[43] = (byte) 102;
        bArr4[44] = (byte) 102;
        bArr4[45] = (byte) 102;
        bArr4[46] = (byte) 18;
        bArr4[47] = (byte) 16;
        bArr4[48] = (byte) 15;
        byte[] bArr5 = new byte[50];
        bArr5[1] = (byte) 1;
        bArr5[2] = (byte) 1;
        bArr5[3] = (byte) 1;
        bArr5[5] = (byte) 1;
        bArr5[6] = (byte) 1;
        bArr5[7] = (byte) 1;
        bArr5[9] = (byte) 1;
        bArr5[10] = (byte) 1;
        bArr5[11] = (byte) 1;
        bArr5[13] = (byte) 1;
        bArr5[14] = (byte) 1;
        bArr5[15] = (byte) 1;
        bArr5[17] = (byte) 1;
        bArr5[19] = (byte) 1;
        bArr5[20] = (byte) 1;
        bArr5[21] = (byte) 1;
        bArr5[23] = (byte) 1;
        bArr5[24] = (byte) 1;
        bArr5[25] = (byte) 1;
        bArr5[27] = (byte) 1;
        bArr5[28] = (byte) 1;
        bArr5[29] = (byte) 1;
        bArr5[30] = (byte) 1;
        bArr5[31] = (byte) 1;
        bArr5[33] = (byte) 1;
        bArr5[34] = (byte) 1;
        bArr5[35] = (byte) 1;
        bArr5[36] = (byte) 1;
        bArr5[37] = (byte) 1;
        bArr5[38] = (byte) 1;
        bArr5[39] = (byte) 1;
        bArr5[40] = (byte) 1;
        bArr5[41] = (byte) 1;
        bArr5[42] = (byte) 1;
        bArr5[43] = (byte) 1;
        bArr5[44] = (byte) 1;
        bArr5[45] = (byte) 1;
        try {
            File file2 = new File("/system/framework/core.odex");
            int curentPos;
            int i;
            try {
                if (file2.exists()) {
                    file = file2;
                } else {
                    file = file2;
                    for (String tail : new String[]{"/data/dalvik-cache/", "/data/dalvik-cache/arm/", "/sd-ext/data/dalvik-cache/", "/cache/dalvik-cache/", "/sd-ext/data/cache/dalvik-cache/", "/data/cache/dalvik-cache/"}) {
                        file2 = new File(tail + "system@framework@core.jar@classes.dex");
                        if (file2.exists()) {
                            System.out.println("Dalvik Cache (" + file2.toString() + ")!");
                            file = file2;
                        }
                    }
                }
                if (file.exists()) {
                    file2 = new File("/system/framework/patch1.done");
                    file2 = new File("/system/framework/patch2.done");
                    file2 = new File("/system/framework/patch1.2.done");
                    file2 = new File("/system/framework/patch3.done");
                    file2.delete();
                    file2.delete();
                    file2.delete();
                    file2.delete();
                    localFile2 = file;
                    try {
                        if (Utils.getFileDalvikCacheName("/system/framework/services.jar").exists()) {
                            file = localFile2;
                        } else {
                            file2 = new File("/system/framework/services.odex");
                            try {
                                if (!file2.exists()) {
                                    throw new FileNotFoundException();
                                }
                            } catch (FileNotFoundException e2) {
                            } catch (Exception e3) {
                                e = e3;
                                System.out.println("Exception e" + e.toString());
                                Utils.exitFromRootJava();
                            }
                        }
                        try {
                            file2 = new File("/system/framework/patch3.done");
                            file2.delete();
                            ChannelDex = new RandomAccessFile(file, InternalZipConstants.READ_MODE).getChannel();
                            fileBytes = ChannelDex.map(MapMode.READ_ONLY, 0, (long) ((int) ChannelDex.size()));
                            j = 0;
                            while (fileBytes.hasRemaining()) {
                                curentPos = fileBytes.position();
                                curentByte = fileBytes.get();
                                if (curentByte == byteOrigS2[0]) {
                                    i = 1;
                                    fileBytes.position(curentPos + 1);
                                    prufbyte = fileBytes.get();
                                    while (true) {
                                        if (prufbyte == byteOrigS2[i] && maskS2[i] != (byte) 1) {
                                            break;
                                        }
                                        i++;
                                        if (i != byteOrigS2.length) {
                                            break;
                                        }
                                        prufbyte = fileBytes.get();
                                    }
                                    System.out.println("Core patch3 found!\n");
                                    file2.createNewFile();
                                    fileBytes.position(curentPos + 1);
                                }
                                if (curentByte == byteOrigS3[0]) {
                                    i = 1;
                                    fileBytes.position(curentPos + 1);
                                    prufbyte = fileBytes.get();
                                    while (true) {
                                        if (prufbyte == byteOrigS3[i] && maskS3[i] != (byte) 1) {
                                            break;
                                        }
                                        i++;
                                        if (i != byteOrigS3.length) {
                                            break;
                                        }
                                        prufbyte = fileBytes.get();
                                    }
                                    System.out.println("Core patch3 found!\n");
                                    file2.createNewFile();
                                    fileBytes.position(curentPos + 1);
                                }
                                if (curentByte != byteOrigS4[0]) {
                                    i = 1;
                                    fileBytes.position(curentPos + 1);
                                    prufbyte = fileBytes.get();
                                    while (true) {
                                        if (prufbyte == byteOrigS4[i] && maskS4[i] != (byte) 1) {
                                            break;
                                        }
                                        i++;
                                        if (i != byteOrigS4.length) {
                                            break;
                                        }
                                        prufbyte = fileBytes.get();
                                    }
                                    System.out.println("Core patch3 found!\n");
                                    file2.createNewFile();
                                    fileBytes.position(curentPos + 1);
                                }
                                fileBytes.position(curentPos + 1);
                                j++;
                            }
                        } catch (Exception e4) {
                            System.out.println(e4);
                        } catch (FileNotFoundException e22) {
                        }
                        ChannelDex.close();
                    } catch (FileNotFoundException e5) {
                        file = localFile2;
                        System.out.println("Error: core.odex not found!\n\nPlease Odex core.jar and try again!");
                        Utils.exitFromRootJava();
                    } catch (Exception e6) {
                        e4 = e6;
                        file = localFile2;
                        System.out.println("Exception e" + e4.toString());
                        Utils.exitFromRootJava();
                    }
                    Utils.exitFromRootJava();
                }
                throw new FileNotFoundException();
            } catch (FileNotFoundException e7) {
                file = file2;
                System.out.println("Error: core.odex not found!\n\nPlease Odex core.jar and try again!");
                localFile2 = file;
                if (Utils.getFileDalvikCacheName("/system/framework/services.jar").exists()) {
                    file = localFile2;
                } else {
                    file2 = new File("/system/framework/services.odex");
                    if (file2.exists()) {
                        throw new FileNotFoundException();
                    }
                }
                file2 = new File("/system/framework/patch3.done");
                file2.delete();
                ChannelDex = new RandomAccessFile(file, InternalZipConstants.READ_MODE).getChannel();
                fileBytes = ChannelDex.map(MapMode.READ_ONLY, 0, (long) ((int) ChannelDex.size()));
                j = 0;
                while (fileBytes.hasRemaining()) {
                    curentPos = fileBytes.position();
                    curentByte = fileBytes.get();
                    if (curentByte == byteOrigS2[0]) {
                        i = 1;
                        fileBytes.position(curentPos + 1);
                        prufbyte = fileBytes.get();
                        while (true) {
                            if (prufbyte == byteOrigS2[i]) {
                            }
                            i++;
                            if (i != byteOrigS2.length) {
                                break;
                            }
                            prufbyte = fileBytes.get();
                        }
                        System.out.println("Core patch3 found!\n");
                        file2.createNewFile();
                        fileBytes.position(curentPos + 1);
                    }
                    if (curentByte == byteOrigS3[0]) {
                        i = 1;
                        fileBytes.position(curentPos + 1);
                        prufbyte = fileBytes.get();
                        while (true) {
                            if (prufbyte == byteOrigS3[i]) {
                            }
                            i++;
                            if (i != byteOrigS3.length) {
                                break;
                            }
                            prufbyte = fileBytes.get();
                        }
                        System.out.println("Core patch3 found!\n");
                        file2.createNewFile();
                        fileBytes.position(curentPos + 1);
                    }
                    if (curentByte != byteOrigS4[0]) {
                        i = 1;
                        fileBytes.position(curentPos + 1);
                        prufbyte = fileBytes.get();
                        while (true) {
                            if (prufbyte == byteOrigS4[i]) {
                            }
                            i++;
                            if (i != byteOrigS4.length) {
                                break;
                            }
                            prufbyte = fileBytes.get();
                        }
                        System.out.println("Core patch3 found!\n");
                        file2.createNewFile();
                        fileBytes.position(curentPos + 1);
                    }
                    fileBytes.position(curentPos + 1);
                    j++;
                }
                ChannelDex.close();
                Utils.exitFromRootJava();
            } catch (Exception e8) {
                e4 = e8;
                file = file2;
                System.out.println("Exception e" + e4.toString());
                localFile2 = file;
                if (Utils.getFileDalvikCacheName("/system/framework/services.jar").exists()) {
                    file2 = new File("/system/framework/services.odex");
                    if (file2.exists()) {
                        throw new FileNotFoundException();
                    }
                }
                file = localFile2;
                file2 = new File("/system/framework/patch3.done");
                file2.delete();
                ChannelDex = new RandomAccessFile(file, InternalZipConstants.READ_MODE).getChannel();
                fileBytes = ChannelDex.map(MapMode.READ_ONLY, 0, (long) ((int) ChannelDex.size()));
                j = 0;
                while (fileBytes.hasRemaining()) {
                    curentPos = fileBytes.position();
                    curentByte = fileBytes.get();
                    if (curentByte == byteOrigS2[0]) {
                        i = 1;
                        fileBytes.position(curentPos + 1);
                        prufbyte = fileBytes.get();
                        while (true) {
                            if (prufbyte == byteOrigS2[i]) {
                            }
                            i++;
                            if (i != byteOrigS2.length) {
                                break;
                            }
                            prufbyte = fileBytes.get();
                        }
                        System.out.println("Core patch3 found!\n");
                        file2.createNewFile();
                        fileBytes.position(curentPos + 1);
                    }
                    if (curentByte == byteOrigS3[0]) {
                        i = 1;
                        fileBytes.position(curentPos + 1);
                        prufbyte = fileBytes.get();
                        while (true) {
                            if (prufbyte == byteOrigS3[i]) {
                            }
                            i++;
                            if (i != byteOrigS3.length) {
                                break;
                            }
                            prufbyte = fileBytes.get();
                        }
                        System.out.println("Core patch3 found!\n");
                        file2.createNewFile();
                        fileBytes.position(curentPos + 1);
                    }
                    if (curentByte != byteOrigS4[0]) {
                        i = 1;
                        fileBytes.position(curentPos + 1);
                        prufbyte = fileBytes.get();
                        while (true) {
                            if (prufbyte == byteOrigS4[i]) {
                            }
                            i++;
                            if (i != byteOrigS4.length) {
                                break;
                            }
                            prufbyte = fileBytes.get();
                        }
                        System.out.println("Core patch3 found!\n");
                        file2.createNewFile();
                        fileBytes.position(curentPos + 1);
                    }
                    fileBytes.position(curentPos + 1);
                    j++;
                }
                ChannelDex.close();
                Utils.exitFromRootJava();
            }
        } catch (FileNotFoundException e9) {
        } catch (Exception e10) {
            e4 = e10;
        }
    }
}
