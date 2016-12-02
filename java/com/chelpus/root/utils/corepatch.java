package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import com.chelpus.Utils.OatFunc;
import com.chelpus.Utils.OatFuncDump;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.tukaani.xz.LZMA2Options;

public class corepatch {
    public static final byte[] MAGIC = new byte[]{(byte) 100, (byte) 101, (byte) 121, (byte) 10, (byte) 48, (byte) 51, (byte) 53, (byte) 0};
    public static int adler;
    public static byte[] byteOrig10 = null;
    public static byte[] byteOrig11 = null;
    public static byte[] byteOrig12 = null;
    public static byte[] byteOrig13 = null;
    public static byte[] byteOrig14 = null;
    public static byte[] byteOrig15 = null;
    public static byte[] byteOrig16 = null;
    public static byte[] byteOrig17 = null;
    public static byte[] byteOrig18 = null;
    public static byte[] byteOrig19 = null;
    public static byte[] byteOrig2 = null;
    public static byte[] byteOrig20 = null;
    public static byte[] byteOrig21 = null;
    public static byte[] byteOrig22 = null;
    public static byte[] byteOrig23 = null;
    public static byte[] byteOrig3 = null;
    public static byte[] byteOrig4 = null;
    public static byte[] byteOrig5 = null;
    public static byte[] byteOrig6 = null;
    public static byte[] byteOrig7 = null;
    public static byte[] byteOrig8 = null;
    public static byte[] byteOrig9 = null;
    public static byte[] byteOrigOat1 = null;
    public static byte[] byteOrigOat2 = null;
    public static byte[] byteOrigOat3 = null;
    public static byte[] byteOrigOat3_1 = null;
    public static byte[] byteOrigOat3_2 = null;
    public static byte[] byteOrigOat4 = null;
    public static byte[] byteOrigOat5 = null;
    public static byte[] byteOrigOat6 = null;
    public static byte[] byteOrigOat6_1 = null;
    public static byte[] byteOrigOat7 = null;
    public static byte[] byteOrigOat7_1 = null;
    public static byte[] byteOrigOatUpd1 = null;
    public static byte[] byteOrigOatUpd2 = null;
    public static byte[] byteOrigOatUpd4 = null;
    public static byte[] byteOrigOatUpd4_1 = null;
    public static byte[] byteOrigOatUpd5 = null;
    public static byte[] byteOrigOatUpd5_1 = null;
    public static byte[] byteOrigS13 = null;
    public static byte[] byteOrigS13_1 = null;
    public static byte[] byteOrigS14 = null;
    public static byte[] byteOrigS2 = null;
    public static byte[] byteOrigS3 = null;
    public static byte[] byteOrigS4 = null;
    public static byte[] byteOrigS5 = null;
    public static byte[] byteOrigS6 = null;
    public static byte[] byteOrigS7 = null;
    public static byte[] byteOrigS7_1 = null;
    public static byte[] byteOrigSOat1 = null;
    public static byte[] byteOrigSOat10 = null;
    public static byte[] byteOrigSOat10_1 = null;
    public static byte[] byteOrigSOat11 = null;
    public static byte[] byteOrigSOat11_1 = null;
    public static byte[] byteOrigSOat11_2 = null;
    public static byte[] byteOrigSOat12 = null;
    public static byte[] byteOrigSOat12_1 = null;
    public static byte[] byteOrigSOat1_1 = null;
    public static byte[] byteOrigSOat1_2 = null;
    public static byte[] byteOrigSOat2 = null;
    public static byte[] byteOrigSOat3 = null;
    public static byte[] byteOrigSOat4 = null;
    public static byte[] byteOrigSOat5 = null;
    public static byte[] byteOrigSOat5_1 = null;
    public static byte[] byteOrigSOat6 = null;
    public static byte[] byteOrigSOat6_2 = null;
    public static byte[] byteOrigSOat6_3 = null;
    public static byte[] byteOrigSOat6_4 = null;
    public static byte[] byteOrigSOat6_5 = null;
    public static byte[] byteOrigSOat7 = null;
    public static byte[] byteOrigSOat7_2 = null;
    public static byte[] byteOrigSOat8 = null;
    public static byte[] byteOrigSOat8_1 = null;
    public static byte[] byteOrigSOat8_2 = null;
    public static byte[] byteOrigSOat9 = null;
    public static byte[] byteOrigSOat9_1 = null;
    public static byte[] byteOrigSOat9_2 = null;
    public static byte[] byteOrigSOat9_3 = null;
    public static byte[] byteOrig_patch1_arm = null;
    public static byte[] byteOrig_patch1_arm64 = null;
    public static byte[] byteOrig_patch1_arm64_1 = null;
    public static byte[] byteOrig_patch1_arm64_2 = null;
    public static byte[] byteOrig_patch1_arm_1 = null;
    public static byte[] byteOrig_patch1_x86 = null;
    public static byte[] byteOrig_patch2_arm = null;
    public static byte[] byteOrig_patch2_arm64 = null;
    public static byte[] byteOrig_patch2_arm64_1 = null;
    public static byte[] byteOrig_patch2_arm64_2 = null;
    public static byte[] byteOrig_patch2_arm_1 = null;
    public static byte[] byteOrig_patch2_x86 = null;
    public static byte[] byteOrig_patch2_x86_64 = null;
    public static byte[] byteOrig_patch3_arm = null;
    public static byte[] byteOrig_patch3_arm64 = null;
    public static byte[] byteOrig_patch3_x86 = null;
    public static byte[] byteOrig_patch3cm_arm = null;
    public static byte[] byteOrig_patch3cm_arm64 = null;
    public static byte[] byteOrig_patch3p_arm = null;
    public static byte[] byteOrig_patch3p_arm64 = null;
    public static byte[] byteOrig_patch3p_x86 = null;
    public static byte[] byteReplace10 = null;
    public static byte[] byteReplace11 = null;
    public static byte[] byteReplace12 = null;
    public static byte[] byteReplace13 = null;
    public static byte[] byteReplace14 = null;
    public static byte[] byteReplace15 = null;
    public static byte[] byteReplace16 = null;
    public static byte[] byteReplace17 = null;
    public static byte[] byteReplace18 = null;
    public static byte[] byteReplace19 = null;
    public static byte[] byteReplace2 = null;
    public static byte[] byteReplace20 = null;
    public static byte[] byteReplace21 = null;
    public static byte[] byteReplace22 = null;
    public static byte[] byteReplace23 = null;
    public static byte[] byteReplace3 = null;
    public static byte[] byteReplace4 = null;
    public static byte[] byteReplace5 = null;
    public static byte[] byteReplace6 = null;
    public static byte[] byteReplace7 = null;
    public static byte[] byteReplace8 = null;
    public static byte[] byteReplace9 = null;
    public static byte[] byteReplaceOat1 = null;
    public static byte[] byteReplaceOat2 = null;
    public static byte[] byteReplaceOat3 = null;
    public static byte[] byteReplaceOat3_1 = null;
    public static byte[] byteReplaceOat3_2 = null;
    public static byte[] byteReplaceOat4 = null;
    public static byte[] byteReplaceOat5 = null;
    public static byte[] byteReplaceOat6 = null;
    public static byte[] byteReplaceOat6_1 = null;
    public static byte[] byteReplaceOat7 = null;
    public static byte[] byteReplaceOat7_1 = null;
    public static byte[] byteReplaceOatUpd1 = null;
    public static byte[] byteReplaceOatUpd2 = null;
    public static byte[] byteReplaceOatUpd4 = null;
    public static byte[] byteReplaceOatUpd4_1 = null;
    public static byte[] byteReplaceOatUpd5 = null;
    public static byte[] byteReplaceOatUpd5_1 = null;
    public static byte[] byteReplaceS13 = null;
    public static byte[] byteReplaceS13_1 = null;
    public static byte[] byteReplaceS14 = null;
    public static byte[] byteReplaceS2 = null;
    public static byte[] byteReplaceS3 = null;
    public static byte[] byteReplaceS4 = null;
    public static byte[] byteReplaceS5 = null;
    public static byte[] byteReplaceS6 = null;
    public static byte[] byteReplaceS7 = null;
    public static byte[] byteReplaceS7_1 = null;
    public static byte[] byteReplaceSOat1 = null;
    public static byte[] byteReplaceSOat10 = null;
    public static byte[] byteReplaceSOat10_1 = null;
    public static byte[] byteReplaceSOat11 = null;
    public static byte[] byteReplaceSOat11_1 = null;
    public static byte[] byteReplaceSOat11_2 = null;
    public static byte[] byteReplaceSOat12 = null;
    public static byte[] byteReplaceSOat12_1 = null;
    public static byte[] byteReplaceSOat1_1 = null;
    public static byte[] byteReplaceSOat1_2 = null;
    public static byte[] byteReplaceSOat2 = null;
    public static byte[] byteReplaceSOat3 = null;
    public static byte[] byteReplaceSOat4 = null;
    public static byte[] byteReplaceSOat5 = null;
    public static byte[] byteReplaceSOat5_1 = null;
    public static byte[] byteReplaceSOat6 = null;
    public static byte[] byteReplaceSOat6_2 = null;
    public static byte[] byteReplaceSOat6_3 = null;
    public static byte[] byteReplaceSOat6_4 = null;
    public static byte[] byteReplaceSOat6_5 = null;
    public static byte[] byteReplaceSOat7 = null;
    public static byte[] byteReplaceSOat7_2 = null;
    public static byte[] byteReplaceSOat8 = null;
    public static byte[] byteReplaceSOat8_1 = null;
    public static byte[] byteReplaceSOat8_2 = null;
    public static byte[] byteReplaceSOat9 = null;
    public static byte[] byteReplaceSOat9_1 = null;
    public static byte[] byteReplaceSOat9_2 = null;
    public static byte[] byteReplaceSOat9_3 = null;
    public static byte[] byteReplace_patch1_arm = null;
    public static byte[] byteReplace_patch1_arm64 = null;
    public static byte[] byteReplace_patch1_arm64_1 = null;
    public static byte[] byteReplace_patch1_arm64_2 = null;
    public static byte[] byteReplace_patch1_arm_1 = null;
    public static byte[] byteReplace_patch1_x86 = null;
    public static byte[] byteReplace_patch2_arm = null;
    public static byte[] byteReplace_patch2_arm64 = null;
    public static byte[] byteReplace_patch2_arm64_1 = null;
    public static byte[] byteReplace_patch2_arm64_2 = null;
    public static byte[] byteReplace_patch2_arm_1 = null;
    public static byte[] byteReplace_patch2_x86 = null;
    public static byte[] byteReplace_patch2_x86_64 = null;
    public static byte[] byteReplace_patch3_arm = null;
    public static byte[] byteReplace_patch3_arm64 = null;
    public static byte[] byteReplace_patch3_x86 = null;
    public static byte[] byteReplace_patch3cm_arm = null;
    public static byte[] byteReplace_patch3cm_arm64 = null;
    public static byte[] byteReplace_patch3p_arm = null;
    public static byte[] byteReplace_patch3p_arm64 = null;
    public static byte[] byteReplace_patch3p_x86 = null;
    public static MappedByteBuffer fileBytes = null;
    public static byte[] lastByteReplace = null;
    public static int lastPatchPosition = 0;
    public static byte[] mask10 = null;
    public static byte[] mask11 = null;
    public static byte[] mask12 = null;
    public static byte[] mask13 = null;
    public static byte[] mask14 = null;
    public static byte[] mask15 = null;
    public static byte[] mask16 = null;
    public static byte[] mask17 = null;
    public static byte[] mask18 = null;
    public static byte[] mask19 = null;
    public static byte[] mask2 = null;
    public static byte[] mask20 = null;
    public static byte[] mask21 = null;
    public static byte[] mask22 = null;
    public static byte[] mask23 = null;
    public static byte[] mask4 = null;
    public static byte[] mask5 = null;
    public static byte[] mask6 = null;
    public static byte[] mask7 = null;
    public static byte[] mask8 = null;
    public static byte[] mask9 = null;
    public static byte[] maskOat1 = null;
    public static byte[] maskOat2 = null;
    public static byte[] maskOat3 = null;
    public static byte[] maskOat3_1 = null;
    public static byte[] maskOat3_2 = null;
    public static byte[] maskOat4 = null;
    public static byte[] maskOat5 = null;
    public static byte[] maskOat6 = null;
    public static byte[] maskOat6_1 = null;
    public static byte[] maskOat7 = null;
    public static byte[] maskOat7_1 = null;
    public static byte[] maskOatUpd1 = null;
    public static byte[] maskOatUpd2 = null;
    public static byte[] maskOatUpd4 = null;
    public static byte[] maskOatUpd4_1 = null;
    public static byte[] maskOatUpd5 = null;
    public static byte[] maskOatUpd5_1 = null;
    public static byte[] maskS13 = null;
    public static byte[] maskS13_1 = null;
    public static byte[] maskS14 = null;
    public static byte[] maskS2 = null;
    public static byte[] maskS3 = null;
    public static byte[] maskS4 = null;
    public static byte[] maskS5 = null;
    public static byte[] maskS6 = null;
    public static byte[] maskS7 = null;
    public static byte[] maskS7_1 = null;
    public static byte[] maskSOat1 = null;
    public static byte[] maskSOat10 = null;
    public static byte[] maskSOat10_1 = null;
    public static byte[] maskSOat11 = null;
    public static byte[] maskSOat11_1 = null;
    public static byte[] maskSOat11_2 = null;
    public static byte[] maskSOat12 = null;
    public static byte[] maskSOat12_1 = null;
    public static byte[] maskSOat1_1 = null;
    public static byte[] maskSOat1_2 = null;
    public static byte[] maskSOat2 = null;
    public static byte[] maskSOat3 = null;
    public static byte[] maskSOat4 = null;
    public static byte[] maskSOat5 = null;
    public static byte[] maskSOat5_1 = null;
    public static byte[] maskSOat6 = null;
    public static byte[] maskSOat6_2 = null;
    public static byte[] maskSOat6_3 = null;
    public static byte[] maskSOat6_4 = null;
    public static byte[] maskSOat6_5 = null;
    public static byte[] maskSOat7 = null;
    public static byte[] maskSOat7_2 = null;
    public static byte[] maskSOat8 = null;
    public static byte[] maskSOat8_1 = null;
    public static byte[] maskSOat8_2 = null;
    public static byte[] maskSOat9 = null;
    public static byte[] maskSOat9_1 = null;
    public static byte[] maskSOat9_2 = null;
    public static byte[] maskSOat9_3 = null;
    public static byte[] mask_patch1_arm = null;
    public static byte[] mask_patch1_arm64 = null;
    public static byte[] mask_patch1_arm64_1 = null;
    public static byte[] mask_patch1_arm64_2 = null;
    public static byte[] mask_patch1_arm_1 = null;
    public static byte[] mask_patch1_x86 = null;
    public static byte[] mask_patch2_arm = null;
    public static byte[] mask_patch2_arm64 = null;
    public static byte[] mask_patch2_arm64_1 = null;
    public static byte[] mask_patch2_arm64_2 = null;
    public static byte[] mask_patch2_arm_1 = null;
    public static byte[] mask_patch2_x86 = null;
    public static byte[] mask_patch2_x86_64 = null;
    public static byte[] mask_patch3_arm = null;
    public static byte[] mask_patch3_arm64 = null;
    public static byte[] mask_patch3_x86 = null;
    public static byte[] mask_patch3cm_arm = null;
    public static byte[] mask_patch3cm_arm64 = null;
    public static byte[] mask_patch3p_arm = null;
    public static byte[] mask_patch3p_arm64 = null;
    public static byte[] mask_patch3p_x86 = null;
    public static boolean not_found_bytes_for_patch = false;
    public static boolean onlyDalvik = false;
    public static boolean patchOat1 = false;
    public static boolean patchOat2 = false;
    public static boolean patchOat3 = false;
    public static boolean patchOat4 = false;
    public static boolean patchOat6 = false;
    public static boolean patchOatUpd1 = false;
    public static byte[] rep_mask10 = null;
    public static byte[] rep_mask11 = null;
    public static byte[] rep_mask12 = null;
    public static byte[] rep_mask13 = null;
    public static byte[] rep_mask14 = null;
    public static byte[] rep_mask15 = null;
    public static byte[] rep_mask16 = null;
    public static byte[] rep_mask17 = null;
    public static byte[] rep_mask18 = null;
    public static byte[] rep_mask19 = null;
    public static byte[] rep_mask2 = null;
    public static byte[] rep_mask20 = null;
    public static byte[] rep_mask21 = null;
    public static byte[] rep_mask22 = null;
    public static byte[] rep_mask23 = null;
    public static byte[] rep_mask4 = null;
    public static byte[] rep_mask5 = null;
    public static byte[] rep_mask6 = null;
    public static byte[] rep_mask7 = null;
    public static byte[] rep_mask8 = null;
    public static byte[] rep_mask9 = null;
    public static byte[] rep_maskOat1 = null;
    public static byte[] rep_maskOat2 = null;
    public static byte[] rep_maskOat3 = null;
    public static byte[] rep_maskOat3_1 = null;
    public static byte[] rep_maskOat3_2 = null;
    public static byte[] rep_maskOat4 = null;
    public static byte[] rep_maskOat5 = null;
    public static byte[] rep_maskOat6 = null;
    public static byte[] rep_maskOat6_1 = null;
    public static byte[] rep_maskOat7 = null;
    public static byte[] rep_maskOat7_1 = null;
    public static byte[] rep_maskOatUpd1 = null;
    public static byte[] rep_maskOatUpd2 = null;
    public static byte[] rep_maskOatUpd4 = null;
    public static byte[] rep_maskOatUpd4_1 = null;
    public static byte[] rep_maskOatUpd5 = null;
    public static byte[] rep_maskOatUpd5_1 = null;
    public static byte[] rep_maskS13 = null;
    public static byte[] rep_maskS13_1 = null;
    public static byte[] rep_maskS14 = null;
    public static byte[] rep_maskS2 = null;
    public static byte[] rep_maskS3 = null;
    public static byte[] rep_maskS4 = null;
    public static byte[] rep_maskS5 = null;
    public static byte[] rep_maskS6 = null;
    public static byte[] rep_maskS7 = null;
    public static byte[] rep_maskS7_1 = null;
    public static byte[] rep_maskSOat1 = null;
    public static byte[] rep_maskSOat10 = null;
    public static byte[] rep_maskSOat10_1 = null;
    public static byte[] rep_maskSOat11 = null;
    public static byte[] rep_maskSOat11_1 = null;
    public static byte[] rep_maskSOat11_2 = null;
    public static byte[] rep_maskSOat12 = null;
    public static byte[] rep_maskSOat12_1 = null;
    public static byte[] rep_maskSOat1_1 = null;
    public static byte[] rep_maskSOat1_2 = null;
    public static byte[] rep_maskSOat2 = null;
    public static byte[] rep_maskSOat3 = null;
    public static byte[] rep_maskSOat4 = null;
    public static byte[] rep_maskSOat5 = null;
    public static byte[] rep_maskSOat5_1 = null;
    public static byte[] rep_maskSOat6 = null;
    public static byte[] rep_maskSOat6_2 = null;
    public static byte[] rep_maskSOat6_3 = null;
    public static byte[] rep_maskSOat6_4 = null;
    public static byte[] rep_maskSOat6_5 = null;
    public static byte[] rep_maskSOat7 = null;
    public static byte[] rep_maskSOat7_2 = null;
    public static byte[] rep_maskSOat8 = null;
    public static byte[] rep_maskSOat8_1 = null;
    public static byte[] rep_maskSOat8_2 = null;
    public static byte[] rep_maskSOat9 = null;
    public static byte[] rep_maskSOat9_1 = null;
    public static byte[] rep_maskSOat9_2 = null;
    public static byte[] rep_maskSOat9_3 = null;
    public static byte[] rep_mask_patch1_arm = null;
    public static byte[] rep_mask_patch1_arm64 = null;
    public static byte[] rep_mask_patch1_arm64_1 = null;
    public static byte[] rep_mask_patch1_arm64_2 = null;
    public static byte[] rep_mask_patch1_arm_1 = null;
    public static byte[] rep_mask_patch1_x86 = null;
    public static byte[] rep_mask_patch2_arm = null;
    public static byte[] rep_mask_patch2_arm64 = null;
    public static byte[] rep_mask_patch2_arm64_1 = null;
    public static byte[] rep_mask_patch2_arm64_2 = null;
    public static byte[] rep_mask_patch2_arm_1 = null;
    public static byte[] rep_mask_patch2_x86 = null;
    public static byte[] rep_mask_patch2_x86_64 = null;
    public static byte[] rep_mask_patch3_arm = null;
    public static byte[] rep_mask_patch3_arm64 = null;
    public static byte[] rep_mask_patch3_x86 = null;
    public static byte[] rep_mask_patch3cm_arm = null;
    public static byte[] rep_mask_patch3cm_arm64 = null;
    public static byte[] rep_mask_patch3p_arm = null;
    public static byte[] rep_mask_patch3p_arm64 = null;
    public static byte[] rep_mask_patch3p_x86 = null;
    public static String toolfilesdir = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r71) {
        /*
        r7 = new com.chelpus.root.utils.corepatch$1;
        r7.<init>();
        com.chelpus.Utils.startRootJava(r7);
        r11 = 0;
        r18 = 0;
        r25 = 0;
        r62 = 0;
        r33 = 0;
        r34 = 0;
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0227 }
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0227 }
        r7.println(r8);	 Catch:{ Exception -> 0x0227 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0227 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0227 }
        r7.println(r8);	 Catch:{ Exception -> 0x0227 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0227 }
        r8 = 2;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0227 }
        r7.println(r8);	 Catch:{ Exception -> 0x0227 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0227 }
        r8 = 3;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0227 }
        r7.println(r8);	 Catch:{ Exception -> 0x0227 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0227 }
        r8 = 4;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0227 }
        r7.println(r8);	 Catch:{ Exception -> 0x0227 }
        r7 = 4;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0227 }
        if (r7 == 0) goto L_0x004e;
    L_0x0040:
        r7 = 4;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0227 }
        r8 = "OnlyDalvik";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0227 }
        if (r7 == 0) goto L_0x004e;
    L_0x004b:
        r7 = 1;
        onlyDalvik = r7;	 Catch:{ Exception -> 0x0227 }
    L_0x004e:
        r7 = 3;
        r7 = r71[r7];
        if (r7 == 0) goto L_0x0058;
    L_0x0053:
        r7 = 3;
        r7 = r71[r7];
        toolfilesdir = r7;
    L_0x0058:
        r7 = 4;
        r7 = r71[r7];
        r8 = "framework";
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x0075;
    L_0x0063:
        r7 = 4;
        r7 = r71[r7];
        r8 = "OnlyDalvik";
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x0075;
    L_0x006e:
        r7 = "/system";
        r8 = "rw";
        com.chelpus.Utils.remount(r7, r8);
    L_0x0075:
        r7 = 1;
        r7 = r71[r7];
        r8 = "core.odex";
        r7 = r7.contains(r8);
        if (r7 != 0) goto L_0x00ac;
    L_0x0080:
        r7 = 1;
        r7 = r71[r7];
        r8 = "core.jar";
        r7 = r7.contains(r8);
        if (r7 != 0) goto L_0x00ac;
    L_0x008b:
        r7 = 1;
        r7 = r71[r7];
        r8 = "core-libart.jar";
        r7 = r7.contains(r8);
        if (r7 != 0) goto L_0x00ac;
    L_0x0096:
        r7 = 1;
        r7 = r71[r7];
        r8 = "boot.oat";
        r7 = r7.contains(r8);
        if (r7 != 0) goto L_0x00ac;
    L_0x00a1:
        r7 = 1;
        r7 = r71[r7];
        r8 = "core-libart.odex";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x00c6;
    L_0x00ac:
        r7 = 4;
        r7 = r71[r7];
        r8 = "framework";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x00c6;
    L_0x00b7:
        r11 = 1;
        r18 = 1;
        r7 = 0;
        r7 = java.lang.Boolean.valueOf(r7);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r7;
        r7 = 0;
        r8 = "patch";
        r71[r7] = r8;
    L_0x00c6:
        r7 = 1;
        r7 = r71[r7];
        r8 = "services.jar";
        r7 = r7.contains(r8);
        if (r7 != 0) goto L_0x00dc;
    L_0x00d1:
        r7 = 1;
        r7 = r71[r7];
        r8 = "services.odex";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x00f7;
    L_0x00dc:
        r7 = 4;
        r7 = r71[r7];
        r8 = "framework";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x00f7;
    L_0x00e7:
        r25 = 1;
        r62 = 0;
        r7 = 0;
        r7 = java.lang.Boolean.valueOf(r7);
        com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.startUnderRoot = r7;
        r7 = 0;
        r8 = "patch";
        r71[r7] = r8;
    L_0x00f7:
        r7 = 0;
        r7 = r71[r7];
        r8 = "patch";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x013e;
    L_0x0102:
        r7 = 0;
        r7 = r71[r7];
        r8 = "_patch1";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x010e;
    L_0x010d:
        r11 = 1;
    L_0x010e:
        r7 = 0;
        r7 = r71[r7];
        r8 = "_patch2";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x011b;
    L_0x0119:
        r18 = 1;
    L_0x011b:
        r7 = 0;
        r7 = r71[r7];
        r8 = "_patch3";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x0128;
    L_0x0126:
        r25 = 1;
    L_0x0128:
        r7 = 0;
        r7 = r71[r7];
        r8 = "_patch4";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x0135;
    L_0x0133:
        r62 = 1;
    L_0x0135:
        r33 = 2;
        r34 = 2;
        r7 = new com.chelpus.root.utils.SetCorePatch;
        r7.<init>();
    L_0x013e:
        r7 = 0;
        r7 = r71[r7];
        r8 = "restore";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x016f;
    L_0x0149:
        r7 = 0;
        r7 = r71[r7];
        r8 = "restoreCore";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x0157;
    L_0x0154:
        r11 = 1;
        r18 = 1;
    L_0x0157:
        r7 = 0;
        r7 = r71[r7];
        r8 = "restoreServices";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x0166;
    L_0x0162:
        r25 = 1;
        r62 = 1;
    L_0x0166:
        r33 = 0;
        r34 = 0;
        r7 = new com.chelpus.root.utils.SetCoreRestore;
        r7.<init>();
    L_0x016f:
        r7 = 0;
        r7 = r71[r7];
        r8 = "restore";
        r7 = r7.contains(r8);
        if (r7 != 0) goto L_0x0190;
    L_0x017a:
        r7 = 0;
        r7 = r71[r7];
        r8 = "patch";
        r7 = r7.contains(r8);
        if (r7 != 0) goto L_0x0190;
    L_0x0185:
        r7 = 0;
        r7 = r71[r7];
        r8 = "all";
        r7 = r7.contains(r8);
        if (r7 == 0) goto L_0x2c5f;
    L_0x0190:
        r42 = new java.util.ArrayList;
        r42.<init>();
        r42.clear();
        if (r11 != 0) goto L_0x019c;
    L_0x019a:
        if (r18 == 0) goto L_0x10eb;
    L_0x019c:
        r54 = new java.util.ArrayList;
        r54.<init>();
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x022d;
    L_0x01a5:
        r7 = 16;
        r0 = new java.lang.String[r7];
        r56 = r0;
        r7 = 0;
        r8 = "/system/framework/x86/boot.oat";
        r56[r7] = r8;
        r7 = 1;
        r8 = "/system/framework/x86_64/boot.oat";
        r56[r7] = r8;
        r7 = 2;
        r8 = "/system/framework/arm64/boot.oat";
        r56[r7] = r8;
        r7 = 3;
        r8 = "/system/framework/arm/boot.oat";
        r56[r7] = r8;
        r7 = 4;
        r8 = "/system/framework/oat/x86/boot.oat";
        r56[r7] = r8;
        r7 = 5;
        r8 = "/system/framework/oat/x86_64/boot.oat";
        r56[r7] = r8;
        r7 = 6;
        r8 = "/system/framework/oat/arm64/boot.oat";
        r56[r7] = r8;
        r7 = 7;
        r8 = "/system/framework/oat/arm/boot.oat";
        r56[r7] = r8;
        r7 = 8;
        r8 = "/system/framework/x86/boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 9;
        r8 = "/system/framework/x86_64/boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 10;
        r8 = "/system/framework/arm64/boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 11;
        r8 = "/system/framework/arm/boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 12;
        r8 = "/system/framework/oat/x86/boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 13;
        r8 = "/system/framework/oat/x86_64/boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 14;
        r8 = "/system/framework/oat/arm64/boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 15;
        r8 = "/system/framework/oat/arm/boot-conscrypt.oat";
        r56[r7] = r8;
        r0 = r56;
        r8 = r0.length;
        r7 = 0;
    L_0x0207:
        if (r7 >= r8) goto L_0x02af;
    L_0x0209:
        r55 = r56[r7];
        r9 = new java.io.File;
        r0 = r55;
        r9.<init>(r0);
        r9 = r9.exists();
        if (r9 == 0) goto L_0x0224;
    L_0x0218:
        r9 = new java.io.File;
        r0 = r55;
        r9.<init>(r0);
        r0 = r54;
        r0.add(r9);
    L_0x0224:
        r7 = r7 + 1;
        goto L_0x0207;
    L_0x0227:
        r38 = move-exception;
        r38.printStackTrace();
        goto L_0x004e;
    L_0x022d:
        r7 = 16;
        r0 = new java.lang.String[r7];
        r56 = r0;
        r7 = 0;
        r8 = "/data/dalvik-cache/x86/system@framework@boot.oat";
        r56[r7] = r8;
        r7 = 1;
        r8 = "/data/dalvik-cache/x86_64/system@framework@boot.oat";
        r56[r7] = r8;
        r7 = 2;
        r8 = "/data/dalvik-cache/arm64/system@framework@boot.oat";
        r56[r7] = r8;
        r7 = 3;
        r8 = "/data/dalvik-cache/arm/system@framework@boot.oat";
        r56[r7] = r8;
        r7 = 4;
        r8 = "/data/dalvik-cache/oat/x86/system@framework@boot.oat";
        r56[r7] = r8;
        r7 = 5;
        r8 = "/data/dalvik-cache/oat/x86_64/system@framework@boot.oat";
        r56[r7] = r8;
        r7 = 6;
        r8 = "/data/dalvik-cache/oat/arm64/system@framework@boot.oat";
        r56[r7] = r8;
        r7 = 7;
        r8 = "/data/dalvik-cache/oat/arm/system@framework@boot.oat";
        r56[r7] = r8;
        r7 = 8;
        r8 = "/data/dalvik-cache/x86/system@framework@boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 9;
        r8 = "/data/dalvik-cache/x86_64/system@framework@boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 10;
        r8 = "/data/dalvik-cache/arm64/system@framework@boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 11;
        r8 = "/data/dalvik-cache/arm/system@framework@boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 12;
        r8 = "/data/dalvik-cache/oat/x86/system@framework@boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 13;
        r8 = "/data/dalvik-cache/oat/x86_64/system@framework@boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 14;
        r8 = "/data/dalvik-cache/oat/arm64/system@framework@boot-conscrypt.oat";
        r56[r7] = r8;
        r7 = 15;
        r8 = "/data/dalvik-cache/oat/arm/system@framework@boot-conscrypt.oat";
        r56[r7] = r8;
        r0 = r56;
        r8 = r0.length;
        r7 = 0;
    L_0x028f:
        if (r7 >= r8) goto L_0x02af;
    L_0x0291:
        r55 = r56[r7];
        r9 = new java.io.File;
        r0 = r55;
        r9.<init>(r0);
        r9 = r9.exists();
        if (r9 == 0) goto L_0x02ac;
    L_0x02a0:
        r9 = new java.io.File;
        r0 = r55;
        r9.<init>(r0);
        r0 = r54;
        r0.add(r9);
    L_0x02ac:
        r7 = r7 + 1;
        goto L_0x028f;
    L_0x02af:
        r7 = java.lang.System.out;
        r8 = "check cache";
        r7.println(r8);
        r7 = r54.size();
        if (r7 <= 0) goto L_0x02d9;
    L_0x02bc:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 24;
        if (r7 < r8) goto L_0x02d9;
    L_0x02c2:
        r7 = "/system";
        r8 = "RW";
        com.chelpus.Utils.remount(r7, r8);
        r7 = java.lang.System.out;
        r8 = "found cache android 7";
        r7.println(r8);
        r0 = r54;
        r1 = r71;
        r2 = r18;
        patchWithOatDumpP12(r0, r1, r11, r2);
    L_0x02d9:
        r7 = r54.size();
        if (r7 <= 0) goto L_0x0a86;
    L_0x02df:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 21;
        if (r7 < r8) goto L_0x0a86;
    L_0x02e5:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 23;
        if (r7 > r8) goto L_0x0a86;
    L_0x02eb:
        r7 = java.lang.System.out;
        r8 = "found cache";
        r7.println(r8);
        r30 = 0;
        r0 = r54;
        r1 = r71;
        r2 = r18;
        patchWithOatDumpP12(r0, r1, r11, r2);
        if (r11 == 0) goto L_0x0303;
    L_0x02ff:
        r7 = patchOat1;
        if (r7 == 0) goto L_0x0309;
    L_0x0303:
        if (r18 == 0) goto L_0x09a7;
    L_0x0305:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x09a7;
    L_0x0309:
        r7 = patchOat1;
        if (r7 == 0) goto L_0x030e;
    L_0x030d:
        r11 = 0;
    L_0x030e:
        r7 = patchOat2;
        if (r7 == 0) goto L_0x0314;
    L_0x0312:
        r18 = 0;
    L_0x0314:
        r19 = r54.iterator();
    L_0x0318:
        r7 = r19.hasNext();
        if (r7 == 0) goto L_0x09a7;
    L_0x031e:
        r39 = r19.next();
        r39 = (java.io.File) r39;
        r30 = r30 + 1;
        r7 = java.lang.System.out;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "oat file for patch:";
        r8 = r8.append(r9);
        r9 = r39.getAbsolutePath();
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.println(r8);
        r4 = 0;
        r70 = 0;
        r57 = 0;
        r58 = 0;
        r59 = 0;
        r68 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x097c }
        r7 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x097c }
        r8 = "rw";
        r0 = r39;
        r7.<init>(r0, r8);	 Catch:{ IOException -> 0x097c }
        r4 = r7.getChannel();	 Catch:{ IOException -> 0x097c }
        r5 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ IOException -> 0x097c }
        r6 = 0;
        r8 = r4.size();	 Catch:{ IOException -> 0x097c }
        r8 = (int) r8;	 Catch:{ IOException -> 0x097c }
        r8 = (long) r8;	 Catch:{ IOException -> 0x097c }
        r7 = r4.map(r5, r6, r8);	 Catch:{ IOException -> 0x097c }
        fileBytes = r7;	 Catch:{ IOException -> 0x097c }
        r7 = fileBytes;	 Catch:{ IOException -> 0x097c }
        r8 = 4120; // 0x1018 float:5.773E-42 double:2.0356E-320;
        r7.position(r8);	 Catch:{ IOException -> 0x097c }
        r7 = fileBytes;	 Catch:{ IOException -> 0x097c }
        r7 = r7.get();	 Catch:{ IOException -> 0x097c }
        r8 = fileBytes;	 Catch:{ IOException -> 0x097c }
        r8 = r8.get();	 Catch:{ IOException -> 0x097c }
        r9 = fileBytes;	 Catch:{ IOException -> 0x097c }
        r9 = r9.get();	 Catch:{ IOException -> 0x097c }
        r10 = fileBytes;	 Catch:{ IOException -> 0x097c }
        r10 = r10.get();	 Catch:{ IOException -> 0x097c }
        r63 = com.chelpus.Utils.convertFourBytesToInt(r7, r8, r9, r10);	 Catch:{ IOException -> 0x097c }
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x097c }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x097c }
        r8.<init>();	 Catch:{ IOException -> 0x097c }
        r9 = "Start position:";
        r8 = r8.append(r9);	 Catch:{ IOException -> 0x097c }
        r0 = r63;
        r8 = r8.append(r0);	 Catch:{ IOException -> 0x097c }
        r8 = r8.toString();	 Catch:{ IOException -> 0x097c }
        r7.println(r8);	 Catch:{ IOException -> 0x097c }
        r7 = fileBytes;	 Catch:{ IOException -> 0x097c }
        r0 = r63;
        r7.position(r0);	 Catch:{ IOException -> 0x097c }
        r67 = 0;
    L_0x03b2:
        r7 = fileBytes;	 Catch:{ Exception -> 0x098b }
        r7 = r7.hasRemaining();	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0959;
    L_0x03ba:
        if (r67 != 0) goto L_0x0959;
    L_0x03bc:
        r7 = fileBytes;	 Catch:{ Exception -> 0x098b }
        r5 = r7.position();	 Catch:{ Exception -> 0x098b }
        r7 = fileBytes;	 Catch:{ Exception -> 0x098b }
        r6 = r7.get();	 Catch:{ Exception -> 0x098b }
        r7 = byteOrigOatUpd1;	 Catch:{ Exception -> 0x098b }
        r8 = maskOatUpd1;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOatUpd1;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOatUpd1;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x041b;
    L_0x03d6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0400;
    L_0x03e1:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0400:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0412;
    L_0x040b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0412:
        r7 = 1;
        patchOatUpd1 = r7;	 Catch:{ Exception -> 0x098b }
        r70 = 1;
        r57 = 1;
        r58 = 1;
    L_0x041b:
        r7 = byteOrigOatUpd2;	 Catch:{ Exception -> 0x098b }
        r8 = maskOatUpd2;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOatUpd2;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOatUpd2;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x046e;
    L_0x0429:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0453;
    L_0x0434:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0453:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0465;
    L_0x045e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0465:
        r7 = 1;
        patchOatUpd1 = r7;	 Catch:{ Exception -> 0x098b }
        r70 = 1;
        r57 = 1;
        r58 = 1;
    L_0x046e:
        r7 = byteOrigOat1;	 Catch:{ Exception -> 0x098b }
        r8 = maskOat1;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOat1;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOat1;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x04bd;
    L_0x047c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x04a6;
    L_0x0487:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core11 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x04a6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x04b8;
    L_0x04b1:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core11 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x04b8:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x098b }
        r57 = 1;
    L_0x04bd:
        r7 = byteOrigOatUpd4;	 Catch:{ Exception -> 0x098b }
        r8 = maskOatUpd4;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOatUpd4;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOatUpd4;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0510;
    L_0x04cb:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x04f5;
    L_0x04d6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x04f5:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0507;
    L_0x0500:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0507:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x098b }
        r57 = 1;
        r58 = 1;
        r70 = 1;
    L_0x0510:
        r7 = byteOrigOatUpd4_1;	 Catch:{ Exception -> 0x098b }
        r8 = maskOatUpd4_1;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOatUpd4_1;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOatUpd4_1;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0563;
    L_0x051e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0548;
    L_0x0529:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0548:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x055a;
    L_0x0553:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x055a:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x098b }
        r57 = 1;
        r58 = 1;
        r70 = 1;
    L_0x0563:
        r7 = byteOrigOatUpd5;	 Catch:{ Exception -> 0x098b }
        r8 = maskOatUpd5;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOatUpd5;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOatUpd5;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x05b6;
    L_0x0571:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x059b;
    L_0x057c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x059b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x05ad;
    L_0x05a6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x05ad:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x098b }
        r70 = 1;
        r57 = 1;
        r58 = 1;
    L_0x05b6:
        r7 = byteOrigOatUpd5_1;	 Catch:{ Exception -> 0x098b }
        r8 = maskOatUpd5_1;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOatUpd5_1;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOatUpd5_1;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0609;
    L_0x05c4:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x05ee;
    L_0x05cf:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x05ee:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0600;
    L_0x05f9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0600:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x098b }
        r70 = 1;
        r57 = 1;
        r58 = 1;
    L_0x0609:
        r7 = byteOrigOat4;	 Catch:{ Exception -> 0x098b }
        r8 = maskOat4;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOat4;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOat4;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0658;
    L_0x0617:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0641;
    L_0x0622:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core11 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0641:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0653;
    L_0x064c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core11 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0653:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x098b }
        r57 = 1;
    L_0x0658:
        r7 = byteOrigOat2;	 Catch:{ Exception -> 0x098b }
        r8 = maskOat2;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOat2;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOat2;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x06a7;
    L_0x0666:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0690;
    L_0x0671:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core12 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0690:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x06a2;
    L_0x069b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core12 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x06a2:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x098b }
        r58 = 1;
    L_0x06a7:
        r7 = byteOrigOat5;	 Catch:{ Exception -> 0x098b }
        r8 = maskOat5;	 Catch:{ Exception -> 0x098b }
        r9 = byteReplaceOat5;	 Catch:{ Exception -> 0x098b }
        r10 = rep_maskOat5;	 Catch:{ Exception -> 0x098b }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x06f6;
    L_0x06b5:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x06df;
    L_0x06c0:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core12 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x06df:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x06f1;
    L_0x06ea:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core12 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x06f1:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x098b }
        r58 = 1;
    L_0x06f6:
        r14 = byteOrigOat3;	 Catch:{ Exception -> 0x098b }
        r15 = maskOat3;	 Catch:{ Exception -> 0x098b }
        r16 = byteReplaceOat3;	 Catch:{ Exception -> 0x098b }
        r17 = rep_maskOat3;	 Catch:{ Exception -> 0x098b }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0747;
    L_0x0706:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0730;
    L_0x0711:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0730:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0742;
    L_0x073b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0742:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x098b }
        r59 = 1;
    L_0x0747:
        r14 = byteOrigOat3_1;	 Catch:{ Exception -> 0x098b }
        r15 = maskOat3_1;	 Catch:{ Exception -> 0x098b }
        r16 = byteReplaceOat3_1;	 Catch:{ Exception -> 0x098b }
        r17 = rep_maskOat3_1;	 Catch:{ Exception -> 0x098b }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0798;
    L_0x0757:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0781;
    L_0x0762:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0781:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0793;
    L_0x078c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0793:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x098b }
        r59 = 1;
    L_0x0798:
        r14 = byteOrigOat3_2;	 Catch:{ Exception -> 0x098b }
        r15 = maskOat3_2;	 Catch:{ Exception -> 0x098b }
        r16 = byteReplaceOat3_2;	 Catch:{ Exception -> 0x098b }
        r17 = rep_maskOat3_2;	 Catch:{ Exception -> 0x098b }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x07e9;
    L_0x07a8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x07d2;
    L_0x07b3:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x07d2:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x07e4;
    L_0x07dd:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x07e4:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x098b }
        r59 = 1;
    L_0x07e9:
        r14 = byteOrigOat6;	 Catch:{ Exception -> 0x098b }
        r15 = maskOat6;	 Catch:{ Exception -> 0x098b }
        r16 = byteReplaceOat6;	 Catch:{ Exception -> 0x098b }
        r17 = rep_maskOat6;	 Catch:{ Exception -> 0x098b }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x083a;
    L_0x07f9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0823;
    L_0x0804:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0823:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0835;
    L_0x082e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0835:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x098b }
        r59 = 1;
    L_0x083a:
        r14 = byteOrigOat6_1;	 Catch:{ Exception -> 0x098b }
        r15 = maskOat6_1;	 Catch:{ Exception -> 0x098b }
        r16 = byteReplaceOat6_1;	 Catch:{ Exception -> 0x098b }
        r17 = rep_maskOat6_1;	 Catch:{ Exception -> 0x098b }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x088b;
    L_0x084a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0874;
    L_0x0855:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0874:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0886;
    L_0x087f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0886:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x098b }
        r59 = 1;
    L_0x088b:
        r14 = byteOrigOat7;	 Catch:{ Exception -> 0x098b }
        r15 = maskOat7;	 Catch:{ Exception -> 0x098b }
        r16 = byteReplaceOat7;	 Catch:{ Exception -> 0x098b }
        r17 = rep_maskOat7;	 Catch:{ Exception -> 0x098b }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x08dc;
    L_0x089b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x08c5;
    L_0x08a6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x08c5:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x08d7;
    L_0x08d0:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x08d7:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x098b }
        r59 = 1;
    L_0x08dc:
        r14 = byteOrigOat7_1;	 Catch:{ Exception -> 0x098b }
        r15 = maskOat7_1;	 Catch:{ Exception -> 0x098b }
        r16 = byteReplaceOat7_1;	 Catch:{ Exception -> 0x098b }
        r17 = rep_maskOat7_1;	 Catch:{ Exception -> 0x098b }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x092d;
    L_0x08ec:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0916;
    L_0x08f7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x098b }
        r8.<init>();	 Catch:{ Exception -> 0x098b }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x098b }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x098b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x098b }
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0916:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x098b }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x098b }
        if (r7 == 0) goto L_0x0928;
    L_0x0921:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x098b }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x098b }
    L_0x0928:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x098b }
        r59 = 1;
    L_0x092d:
        if (r11 == 0) goto L_0x0935;
    L_0x092f:
        if (r18 == 0) goto L_0x0935;
    L_0x0931:
        if (r70 == 0) goto L_0x0935;
    L_0x0933:
        if (r59 != 0) goto L_0x0957;
    L_0x0935:
        if (r11 == 0) goto L_0x0941;
    L_0x0937:
        if (r18 == 0) goto L_0x0941;
    L_0x0939:
        if (r70 == 0) goto L_0x0941;
    L_0x093b:
        if (r57 == 0) goto L_0x0941;
    L_0x093d:
        if (r58 == 0) goto L_0x0941;
    L_0x093f:
        if (r59 != 0) goto L_0x0957;
    L_0x0941:
        if (r11 == 0) goto L_0x0947;
    L_0x0943:
        if (r18 != 0) goto L_0x0947;
    L_0x0945:
        if (r70 != 0) goto L_0x0957;
    L_0x0947:
        if (r11 == 0) goto L_0x0951;
    L_0x0949:
        if (r18 != 0) goto L_0x0951;
    L_0x094b:
        if (r70 == 0) goto L_0x0951;
    L_0x094d:
        if (r57 == 0) goto L_0x0951;
    L_0x094f:
        if (r58 != 0) goto L_0x0957;
    L_0x0951:
        if (r11 != 0) goto L_0x0982;
    L_0x0953:
        if (r18 == 0) goto L_0x0982;
    L_0x0955:
        if (r59 == 0) goto L_0x0982;
    L_0x0957:
        r67 = 1;
    L_0x0959:
        r4.close();	 Catch:{ IOException -> 0x097c }
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x097c }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x097c }
        r8.<init>();	 Catch:{ IOException -> 0x097c }
        r9 = "time=";
        r8 = r8.append(r9);	 Catch:{ IOException -> 0x097c }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x097c }
        r12 = r12 - r68;
        r8 = r8.append(r12);	 Catch:{ IOException -> 0x097c }
        r8 = r8.toString();	 Catch:{ IOException -> 0x097c }
        r7.println(r8);	 Catch:{ IOException -> 0x097c }
        goto L_0x0318;
    L_0x097c:
        r38 = move-exception;
        r38.printStackTrace();
        goto L_0x0318;
    L_0x0982:
        r7 = fileBytes;	 Catch:{ Exception -> 0x098b }
        r8 = r5 + 1;
        r7.position(r8);	 Catch:{ Exception -> 0x098b }
        goto L_0x03b2;
    L_0x098b:
        r38 = move-exception;
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x097c }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x097c }
        r8.<init>();	 Catch:{ IOException -> 0x097c }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ IOException -> 0x097c }
        r0 = r38;
        r8 = r8.append(r0);	 Catch:{ IOException -> 0x097c }
        r8 = r8.toString();	 Catch:{ IOException -> 0x097c }
        r7.println(r8);	 Catch:{ IOException -> 0x097c }
        goto L_0x0959;
    L_0x09a7:
        r7 = patchOatUpd1;
        if (r7 != 0) goto L_0x09b7;
    L_0x09ab:
        r7 = patchOat1;
        if (r7 != 0) goto L_0x09b7;
    L_0x09af:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x09b7;
    L_0x09b3:
        r7 = patchOat3;
        if (r7 == 0) goto L_0x0a86;
    L_0x09b7:
        r7 = r54.size();
        r0 = r30;
        if (r0 != r7) goto L_0x0a86;
    L_0x09bf:
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x0a63;
    L_0x09c3:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm/system@framework@boot.oat";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm/system@framework@boot.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm64/system@framework@boot.oat";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm64/system@framework@boot.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86/system@framework@boot.oat";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86/system@framework@boot.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86_64/system@framework@boot.oat";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86_64/system@framework@boot.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/arm/system@framework@boot.oat";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/arm/system@framework@boot.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/arm64/system@framework@boot.oat";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/arm64/system@framework@boot.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/x86/system@framework@boot.oat";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/x86/system@framework@boot.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/x86_64/system@framework@boot.oat";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/x86_64/system@framework@boot.art";
        r7.<init>(r8);
        r7.delete();
    L_0x0a63:
        r7 = java.lang.System.out;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "patched cache ";
        r8 = r8.append(r9);
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.toolfilesdir;
        r8 = r8.append(r9);
        r9 = "/reboot";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.println(r8);
        com.chelpus.Utils.reboot();
    L_0x0a86:
        r49 = 0;
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "framework";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x1079;
    L_0x0a93:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "core.jar";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 != 0) goto L_0x0aa9;
    L_0x0a9e:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "core-libart.jar";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0afd;
    L_0x0aa9:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = com.chelpus.Utils.classes_test(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0afd;
    L_0x0ab7:
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = com.chelpus.Utils.getDirs(r64);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r7.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = com.chelpus.Utils.getDirs(r64);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/classes.dex";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0afd;
    L_0x0af6:
        r0 = r42;
        r1 = r26;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x0afd:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "core.odex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 != 0) goto L_0x0b1e;
    L_0x0b08:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "core-libart.odex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 != 0) goto L_0x0b1e;
    L_0x0b13:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "boot.oat";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0b2b;
    L_0x0b1e:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r42;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x0b2b:
        r19 = r42.iterator();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x0b2f:
        r7 = r19.hasNext();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x10eb;
    L_0x0b35:
        r45 = r19.next();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r45 = (java.io.File) r45;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r49 = r45;
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = "file for patch: ";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = " size:";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r12 = r49.length();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "rw";
        r0 = r49;
        r7.<init>(r0, r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r4 = r7.getChannel();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r14 = 0;
        r8 = r4.size();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = (int) r8;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = (long) r7;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r16 = r0;
        r12 = r4;
        r7 = r12.map(r13, r14, r16);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        fileBytes = r7;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r60 = 0;
        r7 = r49.getName();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "boot.oat";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 != 0) goto L_0x212b;
    L_0x0b95:
        r44 = new java.util.ArrayList;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r44.<init>();	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r0 = r44;
        r1 = r49;
        r0.add(r1);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r0 = r44;
        r1 = r71;
        r2 = r18;
        patchWithOatDumpP12(r0, r1, r11, r2);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r11 == 0) goto L_0x0bb0;
    L_0x0bac:
        r7 = patchOat1;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0bb6;
    L_0x0bb0:
        if (r18 == 0) goto L_0x2015;
    L_0x0bb2:
        r7 = patchOat2;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 != 0) goto L_0x2015;
    L_0x0bb6:
        r7 = patchOat1;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0bbb;
    L_0x0bba:
        r11 = 0;
    L_0x0bbb:
        r7 = patchOat2;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0bc1;
    L_0x0bbf:
        r18 = 0;
    L_0x0bc1:
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r14 = 0;
        r8 = r4.size();	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = (int) r8;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r0 = (long) r7;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r16 = r0;
        r12 = r4;
        r7 = r12.map(r13, r14, r16);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        fileBytes = r7;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r50 = 0;
    L_0x0bd6:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = r7.hasRemaining();	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2015;
    L_0x0bde:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r5 = r7.position();	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = fileBytes;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r6 = r7.get();	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = byteOrig2;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask2;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace2;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask2;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c1e;
    L_0x0bf8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c0a;
    L_0x0c03:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0c0a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c1c;
    L_0x0c15:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0c1c:
        r60 = 1;
    L_0x0c1e:
        r7 = byteOrig3;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask2;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace3;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask2;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c52;
    L_0x0c2c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c3e;
    L_0x0c37:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0c3e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c50;
    L_0x0c49:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0c50:
        r60 = 1;
    L_0x0c52:
        r14 = byteOrig4;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r15 = mask4;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r16 = byteReplace4;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r17 = rep_mask4;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c88;
    L_0x0c62:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c74;
    L_0x0c6d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0c74:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0c86;
    L_0x0c7f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0c86:
        r60 = 1;
    L_0x0c88:
        r14 = byteOrig5;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r15 = mask5;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r16 = byteReplace5;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r17 = rep_mask5;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0cbe;
    L_0x0c98:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0caa;
    L_0x0ca3:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0caa:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0cbc;
    L_0x0cb5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0cbc:
        r60 = 1;
    L_0x0cbe:
        r7 = byteOrig6;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask6;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace6;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask6;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0cf2;
    L_0x0ccc:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0cde;
    L_0x0cd7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0cde:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0cf0;
    L_0x0ce9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0cf0:
        r60 = 1;
    L_0x0cf2:
        r7 = byteOrig7;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask7;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace7;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask7;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d26;
    L_0x0d00:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d12;
    L_0x0d0b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0d12:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d24;
    L_0x0d1d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0d24:
        r60 = 1;
    L_0x0d26:
        r7 = byteOrig8;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask8;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace8;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask8;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d5a;
    L_0x0d34:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d46;
    L_0x0d3f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0d46:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d58;
    L_0x0d51:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0d58:
        r60 = 1;
    L_0x0d5a:
        r7 = byteOrig9;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask9;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace9;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask9;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d8e;
    L_0x0d68:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d7a;
    L_0x0d73:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0d7a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0d8c;
    L_0x0d85:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0d8c:
        r60 = 1;
    L_0x0d8e:
        r7 = byteOrig10;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask10;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace10;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask10;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0dc2;
    L_0x0d9c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0dae;
    L_0x0da7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0dae:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0dc0;
    L_0x0db9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0dc0:
        r60 = 1;
    L_0x0dc2:
        r7 = byteOrig11;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask11;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace11;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask11;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0df6;
    L_0x0dd0:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0de2;
    L_0x0ddb:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0de2:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0df4;
    L_0x0ded:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0df4:
        r60 = 1;
    L_0x0df6:
        r14 = byteOrig12;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r15 = mask12;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r16 = byteReplace12;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r17 = rep_mask12;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e2c;
    L_0x0e06:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e18;
    L_0x0e11:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0e18:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e2a;
    L_0x0e23:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0e2a:
        r60 = 1;
    L_0x0e2c:
        r14 = byteOrig13;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r15 = mask13;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r16 = byteReplace13;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r17 = rep_mask13;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e62;
    L_0x0e3c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e4e;
    L_0x0e47:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0e4e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e60;
    L_0x0e59:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0e60:
        r60 = 1;
    L_0x0e62:
        r14 = byteOrig20;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r15 = mask20;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r16 = byteReplace20;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r17 = rep_mask20;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e98;
    L_0x0e72:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e84;
    L_0x0e7d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0e84:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0e96;
    L_0x0e8f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0e96:
        r60 = 1;
    L_0x0e98:
        r7 = byteOrig21;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask21;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace21;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask21;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0ecc;
    L_0x0ea6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0eb8;
    L_0x0eb1:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0eb8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0eca;
    L_0x0ec3:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0eca:
        r60 = 1;
    L_0x0ecc:
        r7 = byteOrig22;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask22;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace22;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask22;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f00;
    L_0x0eda:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0eec;
    L_0x0ee5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0eec:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0efe;
    L_0x0ef7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0efe:
        r60 = 1;
    L_0x0f00:
        r7 = byteOrig14;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask14;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace14;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask14;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f34;
    L_0x0f0e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f20;
    L_0x0f19:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0f20:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f32;
    L_0x0f2b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0f32:
        r60 = 1;
    L_0x0f34:
        r7 = byteOrig15;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask15;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace15;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask15;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f68;
    L_0x0f42:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f54;
    L_0x0f4d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0f54:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f66;
    L_0x0f5f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0f66:
        r60 = 1;
    L_0x0f68:
        r7 = byteOrig16;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask16;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace16;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask16;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f9c;
    L_0x0f76:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f88;
    L_0x0f81:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0f88:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0f9a;
    L_0x0f93:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0f9a:
        r60 = 1;
    L_0x0f9c:
        r7 = byteOrig17;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask17;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace17;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask17;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0fd0;
    L_0x0faa:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0fbc;
    L_0x0fb5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0fbc:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0fce;
    L_0x0fc7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0fce:
        r60 = 1;
    L_0x0fd0:
        r7 = byteOrig18;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask18;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace18;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask18;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x1004;
    L_0x0fde:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x0ff0;
    L_0x0fe9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x0ff0:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x1002;
    L_0x0ffb:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x1002:
        r60 = 1;
    L_0x1004:
        r7 = byteOrig19;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask19;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace19;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask19;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x1038;
    L_0x1012:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x1024;
    L_0x101d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x1024:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x1036;
    L_0x102f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x1036:
        r60 = 1;
    L_0x1038:
        r7 = byteOrig23;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = mask23;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r9 = byteReplace23;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r10 = rep_mask23;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x106c;
    L_0x1046:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x1058;
    L_0x1051:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x1058:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x106a;
    L_0x1063:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
    L_0x106a:
        r60 = 1;
    L_0x106c:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = r5 + 1;
        r7.position(r8);	 Catch:{ Exception -> 0x1ffa, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r50 = r50 + r8;
        goto L_0x0bd6;
    L_0x1079:
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "ART";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x1f08;
    L_0x1084:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/system/framework/core-libart.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x10ae;
    L_0x1091:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/system/framework/core-libart.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r7.length();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 == 0) goto L_0x10ae;
    L_0x10a2:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/system/framework/core-libart.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r42;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x10ae:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/system/framework/core-libart.jar";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = com.chelpus.Utils.classes_test(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0b2b;
    L_0x10bb:
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = "/system/framework/core-libart.jar";
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = "/data/app";
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = "/data/app/classes.dex";
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0b2b;
    L_0x10da:
        r0 = r42;
        r1 = r26;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x0b2b;
    L_0x10e3:
        r53 = move-exception;
    L_0x10e4:
        r7 = java.lang.System.out;
        r8 = "Error: core.odex not found!\n\nPlease Odex core.jar and try again!";
        r7.println(r8);
    L_0x10eb:
        if (r25 != 0) goto L_0x10ef;
    L_0x10ed:
        if (r62 == 0) goto L_0x2c5f;
    L_0x10ef:
        r7 = java.lang.System.out;
        r8 = "Start patch for services.jar";
        r7.println(r8);
        r47 = "";
        r66 = "";
        r40 = "";
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x29e8;
    L_0x1100:
        r66 = "/system/framework";
        r40 = "/services.odex";
        r7 = new java.io.File;
        r8 = "/system/framework/arm/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1113;
    L_0x1111:
        r47 = "/arm";
    L_0x1113:
        r7 = new java.io.File;
        r8 = "/system/framework/arm64/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1122;
    L_0x1120:
        r47 = "/arm64";
    L_0x1122:
        r7 = new java.io.File;
        r8 = "/system/framework/x86/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1131;
    L_0x112f:
        r47 = "/x86";
    L_0x1131:
        r7 = new java.io.File;
        r8 = "/system/framework/x86_64/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1140;
    L_0x113e:
        r47 = "/x86_64";
    L_0x1140:
        r7 = new java.io.File;
        r8 = "/system/framework/arm/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x114f;
    L_0x114d:
        r47 = "/arm";
    L_0x114f:
        r7 = new java.io.File;
        r8 = "/system/framework/arm64/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x115e;
    L_0x115c:
        r47 = "/arm64";
    L_0x115e:
        r7 = new java.io.File;
        r8 = "/system/framework/x86/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x116d;
    L_0x116b:
        r47 = "/x86";
    L_0x116d:
        r7 = new java.io.File;
        r8 = "/system/framework/x86_64/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x117c;
    L_0x117a:
        r47 = "/x86_64";
    L_0x117c:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/arm/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x118b;
    L_0x1189:
        r47 = "/oat/arm";
    L_0x118b:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/arm64/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x119a;
    L_0x1198:
        r47 = "/oat/arm64";
    L_0x119a:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/x86/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x11a9;
    L_0x11a7:
        r47 = "/oat/x86";
    L_0x11a9:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/x86_64/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x11b8;
    L_0x11b6:
        r47 = "/oat/x86_64";
    L_0x11b8:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/arm/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x11c7;
    L_0x11c5:
        r47 = "/oat/arm";
    L_0x11c7:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/arm64/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x11d6;
    L_0x11d4:
        r47 = "/oat/arm64";
    L_0x11d6:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/x86/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x11e5;
    L_0x11e3:
        r47 = "/oat/x86";
    L_0x11e5:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/x86_64/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x11f4;
    L_0x11f2:
        r47 = "/oat/x86_64";
    L_0x11f4:
        r7 = "";
        r0 = r47;
        r7 = r0.equals(r7);
        if (r7 != 0) goto L_0x132d;
    L_0x11fe:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 24;
        if (r7 < r8) goto L_0x132d;
    L_0x1204:
        r4 = 0;
        r43 = new java.io.File;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r66;
        r7 = r7.append(r0);
        r0 = r47;
        r7 = r7.append(r0);
        r0 = r40;
        r7 = r7.append(r0);
        r7 = r7.toString();
        r0 = r43;
        r0.<init>(r7);
        r46 = 1;
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r66;
        r8 = r8.append(r0);
        r0 = r47;
        r8 = r8.append(r0);
        r9 = "/services.odex.xz";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x12bd;
    L_0x124f:
        r7 = java.lang.System.out;
        r8 = "try unpack services.odex.xz";
        r7.println(r8);
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r66;
        r8 = r8.append(r0);
        r0 = r47;
        r8 = r8.append(r0);
        r9 = "/services.odex.xz";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "/system/framework";
        r8 = r8.append(r9);
        r0 = r47;
        r8 = r8.append(r0);
        r8 = r8.toString();
        r7 = com.chelpus.Utils.XZDecompress(r7, r8);
        if (r7 != 0) goto L_0x2a82;
    L_0x1291:
        r46 = 0;
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r66;
        r8 = r8.append(r0);
        r0 = r47;
        r8 = r8.append(r0);
        r0 = r40;
        r8 = r8.append(r0);
        r8 = r8.toString();
        r7.<init>(r8);
        r7.delete();
        r7 = java.lang.System.out;
        r8 = "not enought space for unpack services.odex.xz";
        r7.println(r8);
    L_0x12bd:
        if (r46 == 0) goto L_0x2b0e;
    L_0x12bf:
        if (r25 == 0) goto L_0x2b0e;
    L_0x12c1:
        r0 = r43;
        r1 = r71;
        r2 = r25;
        patchWithOatDumpP3(r0, r1, r2);
    L_0x12ca:
        r7 = patchOat1;
        if (r7 != 0) goto L_0x12d6;
    L_0x12ce:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x12d6;
    L_0x12d2:
        r7 = patchOat6;
        if (r7 == 0) goto L_0x132d;
    L_0x12d6:
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x132a;
    L_0x12da:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.art";
        r7.<init>(r8);
        r7.delete();
    L_0x132a:
        com.chelpus.Utils.reboot();
    L_0x132d:
        r7 = "";
        r0 = r47;
        r7 = r0.equals(r7);
        if (r7 != 0) goto L_0x1bcb;
    L_0x1337:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 21;
        if (r7 < r8) goto L_0x1bcb;
    L_0x133d:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 23;
        if (r7 > r8) goto L_0x1bcb;
    L_0x1343:
        r4 = 0;
        r43 = new java.io.File;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r66;
        r7 = r7.append(r0);
        r0 = r47;
        r7 = r7.append(r0);
        r0 = r40;
        r7 = r7.append(r0);
        r7 = r7.toString();
        r0 = r43;
        r0.<init>(r7);
        r46 = 1;
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r66;
        r8 = r8.append(r0);
        r0 = r47;
        r8 = r8.append(r0);
        r9 = "/services.odex.xz";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x13fc;
    L_0x138e:
        r7 = java.lang.System.out;
        r8 = "try unpack services.odex.xz";
        r7.println(r8);
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r66;
        r8 = r8.append(r0);
        r0 = r47;
        r8 = r8.append(r0);
        r9 = "/services.odex.xz";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "/system/framework";
        r8 = r8.append(r9);
        r0 = r47;
        r8 = r8.append(r0);
        r8 = r8.toString();
        r7 = com.chelpus.Utils.XZDecompress(r7, r8);
        if (r7 != 0) goto L_0x2b17;
    L_0x13d0:
        r46 = 0;
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r66;
        r8 = r8.append(r0);
        r0 = r47;
        r8 = r8.append(r0);
        r0 = r40;
        r8 = r8.append(r0);
        r8 = r8.toString();
        r7.<init>(r8);
        r7.delete();
        r7 = java.lang.System.out;
        r8 = "not enought space for unpack services.odex.xz";
        r7.println(r8);
    L_0x13fc:
        if (r46 == 0) goto L_0x2bcf;
    L_0x13fe:
        r0 = r43;
        r1 = r71;
        r2 = r25;
        patchWithOatDumpP3(r0, r1, r2);
        r7 = patchOat1;
        if (r7 != 0) goto L_0x140d;
    L_0x140b:
        if (r25 != 0) goto L_0x1413;
    L_0x140d:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x1b68;
    L_0x1411:
        if (r25 == 0) goto L_0x1b68;
    L_0x1413:
        r7 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x2bc9 }
        r8 = "rw";
        r0 = r43;
        r7.<init>(r0, r8);	 Catch:{ IOException -> 0x2bc9 }
        r4 = r7.getChannel();	 Catch:{ IOException -> 0x2bc9 }
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ IOException -> 0x2bc9 }
        r14 = 0;
        r8 = r4.size();	 Catch:{ IOException -> 0x2bc9 }
        r7 = (int) r8;	 Catch:{ IOException -> 0x2bc9 }
        r0 = (long) r7;	 Catch:{ IOException -> 0x2bc9 }
        r16 = r0;
        r12 = r4;
        r7 = r12.map(r13, r14, r16);	 Catch:{ IOException -> 0x2bc9 }
        fileBytes = r7;	 Catch:{ IOException -> 0x2bc9 }
        r7 = fileBytes;	 Catch:{ IOException -> 0x2bc9 }
        r8 = 4120; // 0x1018 float:5.773E-42 double:2.0356E-320;
        r7.position(r8);	 Catch:{ IOException -> 0x2bc9 }
        r7 = fileBytes;	 Catch:{ IOException -> 0x2bc9 }
        r7 = r7.get();	 Catch:{ IOException -> 0x2bc9 }
        r8 = fileBytes;	 Catch:{ IOException -> 0x2bc9 }
        r8 = r8.get();	 Catch:{ IOException -> 0x2bc9 }
        r9 = fileBytes;	 Catch:{ IOException -> 0x2bc9 }
        r9 = r9.get();	 Catch:{ IOException -> 0x2bc9 }
        r10 = fileBytes;	 Catch:{ IOException -> 0x2bc9 }
        r10 = r10.get();	 Catch:{ IOException -> 0x2bc9 }
        r63 = com.chelpus.Utils.convertFourBytesToInt(r7, r8, r9, r10);	 Catch:{ IOException -> 0x2bc9 }
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x2bc9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x2bc9 }
        r8.<init>();	 Catch:{ IOException -> 0x2bc9 }
        r9 = "Start position:";
        r8 = r8.append(r9);	 Catch:{ IOException -> 0x2bc9 }
        r0 = r63;
        r8 = r8.append(r0);	 Catch:{ IOException -> 0x2bc9 }
        r8 = r8.toString();	 Catch:{ IOException -> 0x2bc9 }
        r7.println(r8);	 Catch:{ IOException -> 0x2bc9 }
        r7 = fileBytes;	 Catch:{ IOException -> 0x2bc9 }
        r0 = r63;
        r7.position(r0);	 Catch:{ IOException -> 0x2bc9 }
    L_0x1477:
        r7 = fileBytes;	 Catch:{ Exception -> 0x2bac }
        r7 = r7.hasRemaining();	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1b65;
    L_0x147f:
        r7 = fileBytes;	 Catch:{ Exception -> 0x2bac }
        r5 = r7.position();	 Catch:{ Exception -> 0x2bac }
        r7 = fileBytes;	 Catch:{ Exception -> 0x2bac }
        r6 = r7.get();	 Catch:{ Exception -> 0x2bac }
        r21 = byteOrigSOat1;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat1;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat1;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat1;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x14c4;
    L_0x149d:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x14af;
    L_0x14a8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x14af:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x14c1;
    L_0x14ba:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x14c1:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x14c4:
        r21 = byteOrigSOat1_1;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat1_1;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat1_1;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat1_1;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x14fd;
    L_0x14d6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x14e8;
    L_0x14e1:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x14e8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x14fa;
    L_0x14f3:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x14fa:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x14fd:
        r21 = byteOrigSOat1_2;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat1_2;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat1_2;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat1_2;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1536;
    L_0x150f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1521;
    L_0x151a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1521:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1533;
    L_0x152c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1533:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1536:
        r21 = byteOrigSOat2;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat2;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat2;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat2;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x156f;
    L_0x1548:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x155a;
    L_0x1553:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x155a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x156c;
    L_0x1565:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x156c:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x156f:
        r21 = byteOrigSOat6_2;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat6_2;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat6_2;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat6_2;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x15a8;
    L_0x1581:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1593;
    L_0x158c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1593:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x15a5;
    L_0x159e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x15a5:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x15a8:
        r21 = byteOrigSOat6_3;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat6_3;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat6_3;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat6_3;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x15e1;
    L_0x15ba:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x15cc;
    L_0x15c5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x15cc:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x15de;
    L_0x15d7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x15de:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x15e1:
        r21 = byteOrigSOat6_4;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat6_4;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat6_4;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat6_4;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x161a;
    L_0x15f3:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1605;
    L_0x15fe:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1605:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1617;
    L_0x1610:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1617:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x161a:
        r21 = byteOrigSOat6_5;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat6_5;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat6_5;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat6_5;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1653;
    L_0x162c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x163e;
    L_0x1637:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x163e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1650;
    L_0x1649:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1650:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1653:
        r21 = byteOrigSOat3;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat3;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat3;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat3;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x168c;
    L_0x1665:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1677;
    L_0x1670:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1677:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1689;
    L_0x1682:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1689:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x168c:
        r21 = byteOrigSOat6;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat6;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat6;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat6;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x16c5;
    L_0x169e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x16b0;
    L_0x16a9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x16b0:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x16c2;
    L_0x16bb:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x16c2:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x16c5:
        r21 = byteOrigSOat7;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat7;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat7;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat7;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x16fe;
    L_0x16d7:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x16e9;
    L_0x16e2:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x16e9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x16fb;
    L_0x16f4:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x16fb:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x16fe:
        r21 = byteOrigSOat7_2;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat7_2;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat7_2;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat7_2;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1737;
    L_0x1710:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1722;
    L_0x171b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1722:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1734;
    L_0x172d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1734:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1737:
        r21 = byteOrigSOat4;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat4;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat4;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat4;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1770;
    L_0x1749:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x175b;
    L_0x1754:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x175b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x176d;
    L_0x1766:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x176d:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1770:
        r21 = byteOrigSOat5;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat5;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat5;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat5;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x17a9;
    L_0x1782:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1794;
    L_0x178d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1794:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x17a6;
    L_0x179f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x17a6:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x17a9:
        r21 = byteOrigSOat5_1;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat5_1;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat5_1;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat5_1;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x17e2;
    L_0x17bb:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x17cd;
    L_0x17c6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x17cd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x17df;
    L_0x17d8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x17df:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x17e2:
        r21 = byteOrigSOat8;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat8;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat8;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat8;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x181b;
    L_0x17f4:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1806;
    L_0x17ff:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1806:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1818;
    L_0x1811:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1818:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x181b:
        r21 = byteOrigSOat8_1;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat8_1;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat8_1;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat8_1;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1854;
    L_0x182d:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x183f;
    L_0x1838:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x183f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1851;
    L_0x184a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1851:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1854:
        r21 = byteOrigSOat8_2;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat8_2;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat8_2;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat8_2;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x188d;
    L_0x1866:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1878;
    L_0x1871:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1878:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x188a;
    L_0x1883:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x188a:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x188d:
        r21 = byteOrigSOat9;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat9;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat9;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat9;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x18c6;
    L_0x189f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x18b1;
    L_0x18aa:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x18b1:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x18c3;
    L_0x18bc:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x18c3:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x18c6:
        r21 = byteOrigSOat9_1;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat9_1;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat9_1;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat9_1;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x18ff;
    L_0x18d8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x18ea;
    L_0x18e3:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x18ea:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x18fc;
    L_0x18f5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x18fc:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x18ff:
        r21 = byteOrigSOat9_3;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat9_3;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat9_3;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat9_3;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1938;
    L_0x1911:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1923;
    L_0x191c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1923:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1935;
    L_0x192e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1935:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1938:
        r21 = byteOrigSOat9_2;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat9_2;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat9_2;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat9_2;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1971;
    L_0x194a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x195c;
    L_0x1955:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x195c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x196e;
    L_0x1967:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x196e:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1971:
        r21 = byteOrigSOat12;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat12;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat12;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat12;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x19aa;
    L_0x1983:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1995;
    L_0x198e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1995:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x19a7;
    L_0x19a0:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x19a7:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x19aa:
        r21 = byteOrigSOat12_1;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat12_1;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat12_1;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat12_1;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x19e3;
    L_0x19bc:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x19ce;
    L_0x19c7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x19ce:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x19e0;
    L_0x19d9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x19e0:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x19e3:
        r21 = byteOrigSOat10;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat10;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat10;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat10;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a1c;
    L_0x19f5:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a07;
    L_0x1a00:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1a07:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a19;
    L_0x1a12:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1a19:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1a1c:
        r21 = byteOrigSOat10_1;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat10_1;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat10_1;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat10_1;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a55;
    L_0x1a2e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a40;
    L_0x1a39:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1a40:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a52;
    L_0x1a4b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1a52:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1a55:
        r21 = byteOrigSOat11;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat11;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat11;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat11;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a8e;
    L_0x1a67:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a79;
    L_0x1a72:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1a79:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1a8b;
    L_0x1a84:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1a8b:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1a8e:
        r21 = byteOrigSOat11_1;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat11_1;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat11_1;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat11_1;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1ac7;
    L_0x1aa0:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1ab2;
    L_0x1aab:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1ab2:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1ac4;
    L_0x1abd:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1ac4:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1ac7:
        r21 = byteOrigSOat11_2;	 Catch:{ Exception -> 0x2bac }
        r22 = maskSOat11_2;	 Catch:{ Exception -> 0x2bac }
        r23 = byteReplaceSOat11_2;	 Catch:{ Exception -> 0x2bac }
        r24 = rep_maskSOat11_2;	 Catch:{ Exception -> 0x2bac }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1b00;
    L_0x1ad9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1aeb;
    L_0x1ae4:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1aeb:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2bac }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x1afd;
    L_0x1af6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2bac }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2bac }
    L_0x1afd:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2bac }
    L_0x1b00:
        if (r25 == 0) goto L_0x2ba3;
    L_0x1b02:
        r7 = patchOat1;	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x2ba3;
    L_0x1b06:
        r7 = patchOat2;	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x2ba3;
    L_0x1b0a:
        r7 = patchOat6;	 Catch:{ Exception -> 0x2bac }
        if (r7 == 0) goto L_0x2ba3;
    L_0x1b0e:
        r7 = onlyDalvik;	 Catch:{ Exception -> 0x2bac }
        if (r7 != 0) goto L_0x1b62;
    L_0x1b12:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2bac }
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.dex";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2bac }
        r7.delete();	 Catch:{ Exception -> 0x2bac }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2bac }
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2bac }
        r7.delete();	 Catch:{ Exception -> 0x2bac }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2bac }
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2bac }
        r7.delete();	 Catch:{ Exception -> 0x2bac }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2bac }
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2bac }
        r7.delete();	 Catch:{ Exception -> 0x2bac }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2bac }
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.dex";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2bac }
        r7.delete();	 Catch:{ Exception -> 0x2bac }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2bac }
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2bac }
        r7.delete();	 Catch:{ Exception -> 0x2bac }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2bac }
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2bac }
        r7.delete();	 Catch:{ Exception -> 0x2bac }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2bac }
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2bac }
        r7.delete();	 Catch:{ Exception -> 0x2bac }
    L_0x1b62:
        com.chelpus.Utils.reboot();	 Catch:{ Exception -> 0x2bac }
    L_0x1b65:
        r4.close();	 Catch:{ IOException -> 0x2bc9 }
    L_0x1b68:
        r7 = patchOat1;
        if (r7 != 0) goto L_0x1b74;
    L_0x1b6c:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x1b74;
    L_0x1b70:
        r7 = patchOat6;
        if (r7 == 0) goto L_0x1bcb;
    L_0x1b74:
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x1bc8;
    L_0x1b78:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.art";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7.delete();
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.art";
        r7.<init>(r8);
        r7.delete();
    L_0x1bc8:
        com.chelpus.Utils.reboot();
    L_0x1bcb:
        r49 = 0;
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "framework";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x2bd8;
    L_0x1bd8:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "services.jar";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x1c37;
    L_0x1be3:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = com.chelpus.Utils.classes_test(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x1c37;
    L_0x1bf1:
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = com.chelpus.Utils.getDirs(r64);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r7.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = com.chelpus.Utils.getDirs(r64);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "/classes.dex";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x1c37;
    L_0x1c30:
        r0 = r42;
        r1 = r26;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x1c37:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "services.odex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x1c4f;
    L_0x1c42:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r42;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x1c4f:
        r7 = r42.iterator();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x1c53:
        r8 = r7.hasNext();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x2c5f;
    L_0x1c59:
        r45 = r7.next();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r45 = (java.io.File) r45;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = "Start patch for ";
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = r45.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r49 = r45;
        r48 = 0;
        r8 = com.chelpus.Utils.isELFfiles(r49);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x1c87;
    L_0x1c85:
        r48 = 1;
    L_0x1c87:
        r8 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "rw";
        r0 = r49;
        r8.<init>(r0, r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r4 = r8.getChannel();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r14 = 0;
        r8 = r4.size();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = (int) r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = (long) r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r16 = r0;
        r12 = r4;
        r8 = r12.map(r13, r14, r16);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        fileBytes = r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r61 = 0;
        r31 = 0;
        r32 = 0;
        if (r48 != 0) goto L_0x2e64;
    L_0x1caf:
        r8 = 0;
        lastByteReplace = r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = 0;
        lastPatchPosition = r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r50 = 0;
    L_0x1cb7:
        r8 = fileBytes;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r8 = r8.hasRemaining();	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2d87;
    L_0x1cbf:
        r8 = fileBytes;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r5 = r8.position();	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r8 = fileBytes;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r6 = r8.get();	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r21 = byteOrigS2;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS2;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS2;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS2;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d03;
    L_0x1cdd:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1cef;
    L_0x1ce8:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1cef:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d01;
    L_0x1cfa:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1d01:
        r61 = 1;
    L_0x1d03:
        r21 = byteOrigS5;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS5;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS5;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS5;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d3b;
    L_0x1d15:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d27;
    L_0x1d20:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1d27:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d39;
    L_0x1d32:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1d39:
        r61 = 1;
    L_0x1d3b:
        r21 = byteOrigS14;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS14;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS14;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS14;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d73;
    L_0x1d4d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d5f;
    L_0x1d58:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1d5f:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d71;
    L_0x1d6a:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1d71:
        r61 = 1;
    L_0x1d73:
        r21 = byteOrigS6;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS6;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS6;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS6;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1dab;
    L_0x1d85:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1d97;
    L_0x1d90:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!checkUpgradeKeySetLP\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1d97:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1da9;
    L_0x1da2:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!checkUpgradeKeySetLP\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1da9:
        r61 = 1;
    L_0x1dab:
        r21 = byteOrigS7;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS7;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS7;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS7;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1de3;
    L_0x1dbd:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1dcf;
    L_0x1dc8:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1dcf:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1de1;
    L_0x1dda:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1de1:
        r61 = 1;
    L_0x1de3:
        r21 = byteOrigS7_1;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS7_1;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS7_1;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS7_1;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e1b;
    L_0x1df5:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e07;
    L_0x1e00:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1e07:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e19;
    L_0x1e12:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1e19:
        r61 = 1;
    L_0x1e1b:
        r21 = byteOrigS3;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS3;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS3;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS3;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e53;
    L_0x1e2d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e3f;
    L_0x1e38:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\nCM11";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1e3f:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e51;
    L_0x1e4a:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\nCM11";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1e51:
        r61 = 1;
    L_0x1e53:
        r21 = byteOrigS4;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS4;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS4;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS4;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e8b;
    L_0x1e65:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e77;
    L_0x1e70:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1e77:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1e89;
    L_0x1e82:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1e89:
        r61 = 1;
    L_0x1e8b:
        r21 = byteOrigS13;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS13;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS13;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS13;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1ec3;
    L_0x1e9d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1eaf;
    L_0x1ea8:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1eaf:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1ec1;
    L_0x1eba:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1ec1:
        r61 = 1;
    L_0x1ec3:
        r21 = byteOrigS13_1;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r22 = maskS13_1;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceS13_1;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskS13_1;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1efb;
    L_0x1ed5:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1ee7;
    L_0x1ee0:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1ee7:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x1ef9;
    L_0x1ef2:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
    L_0x1ef9:
        r61 = 1;
    L_0x1efb:
        r8 = fileBytes;	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r9 = r5 + 1;
        r8.position(r9);	 Catch:{ Exception -> 0x2d69, FileNotFoundException -> 0x2c57 }
        r8 = 1;
        r50 = r50 + r8;
        goto L_0x1cb7;
    L_0x1f08:
        r7 = onlyDalvik;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x1f4d;
    L_0x1f0c:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = "OnlyDalvik: add for patch ";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = 1;
        r9 = r71[r9];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r52;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r52.exists();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        if (r7 != 0) goto L_0x1f42;
    L_0x1f37:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
    L_0x1f3d:
        r53 = move-exception;
        r49 = r52;
        goto L_0x10e4;
    L_0x1f42:
        r0 = r42;
        r1 = r52;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r49 = r52;
        goto L_0x0b2b;
    L_0x1f4d:
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r52;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r52.exists();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        if (r7 != 0) goto L_0x1f84;
    L_0x1f5d:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
    L_0x1f63:
        r38 = move-exception;
        r49 = r52;
    L_0x1f66:
        r7 = java.lang.System.out;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Exception e";
        r8 = r8.append(r9);
        r9 = r38.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.println(r8);
        goto L_0x10eb;
    L_0x1f84:
        r7 = r52.toString();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r8 = "system@framework@core.jar@classes.dex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        if (r7 == 0) goto L_0x1fac;
    L_0x1f90:
        r28 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r7 = "/system/framework/core.odex";
        r0 = r28;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r7 = r28.exists();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        if (r7 == 0) goto L_0x1fac;
    L_0x1f9f:
        r8 = r28.length();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 != 0) goto L_0x1fac;
    L_0x1fa9:
        r28.delete();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
    L_0x1fac:
        r0 = r42;
        r1 = r52;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r7 = r52.toString();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r8 = "/system/framework/core.odex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        if (r7 == 0) goto L_0x1ff6;
    L_0x1fbf:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r8 = 20;
        if (r7 >= r8) goto L_0x1ff6;
    L_0x1fc5:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.runtime;	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r8 = "ART";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        if (r7 != 0) goto L_0x1ff6;
    L_0x1fcf:
        r28 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r7 = "/system/framework/core-libart.odex";
        r0 = r28;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r7 = r28.exists();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        if (r7 == 0) goto L_0x1ff6;
    L_0x1fde:
        r8 = r28.length();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 != 0) goto L_0x1fef;
    L_0x1fe8:
        r28.delete();	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
        r49 = r52;
        goto L_0x0b2b;
    L_0x1fef:
        r0 = r42;
        r1 = r28;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x1f3d, Exception -> 0x1f63 }
    L_0x1ff6:
        r49 = r52;
        goto L_0x0b2b;
    L_0x1ffa:
        r38 = move-exception;
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r38;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x2015:
        r4.close();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "framework";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x273b;
    L_0x2023:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/classes.dex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x209e;
    L_0x202f:
        r7 = 0;
        not_found_bytes_for_patch = r7;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        com.chelpus.Utils.fixadler(r49);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r60 == 0) goto L_0x2736;
    L_0x2037:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = ".jar";
        r9 = "-patched.jar";
        r37 = r7.replace(r8, r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = 1;
        r65 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r37;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r41 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r41.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "add files";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = new com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r10 = com.chelpus.Utils.getDirs(r49);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r10 = r10.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r10 = "/";
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.<init>(r8, r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r41;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r65;
        r1 = r37;
        r2 = r41;
        com.chelpus.Utils.addFilesToZip(r0, r1, r2);	 Catch:{ Exception -> 0x2726, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2726, FileNotFoundException -> 0x10e3 }
        r8 = "add files finish";
        r7.println(r8);	 Catch:{ Exception -> 0x2726, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2726, FileNotFoundException -> 0x10e3 }
        r0 = r65;
        r7.<init>(r0);	 Catch:{ Exception -> 0x2726, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2726, FileNotFoundException -> 0x10e3 }
    L_0x209e:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/core.odex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 != 0) goto L_0x20b6;
    L_0x20aa:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/core-libart.odex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x2102;
    L_0x20b6:
        r7 = 0;
        r0 = r49;
        com.chelpus.Utils.fixadlerOdex(r0, r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r60 == 0) goto L_0x2102;
    L_0x20be:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/core.odex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x20e0;
    L_0x20ca:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = "/core.odex";
        r10 = "/core-patched.odex";
        r8 = r8.replace(r9, r10);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r49;
        r0.renameTo(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x20e0:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/core-libart.odex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x2102;
    L_0x20ec:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = "/core-libart.odex";
        r10 = "/core-libart-patched.odex";
        r8 = r8.replace(r9, r10);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r49;
        r0.renameTo(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x2102:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/boot.oat";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0b2f;
    L_0x210e:
        if (r60 == 0) goto L_0x0b2f;
    L_0x2110:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = "/boot.oat";
        r10 = "/boot-patched.oat";
        r8 = r8.replace(r9, r10);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r49;
        r0.renameTo(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x0b2f;
    L_0x2128:
        r38 = move-exception;
        goto L_0x1f66;
    L_0x212b:
        r7 = fileBytes;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 4120; // 0x1018 float:5.773E-42 double:2.0356E-320;
        r7.position(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = fileBytes;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r7.get();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.get();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = fileBytes;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = r9.get();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r10 = fileBytes;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r10 = r10.get();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r63 = com.chelpus.Utils.convertFourBytesToInt(r7, r8, r9, r10);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = "Start position:";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r63;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = fileBytes;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r63;
        r7.position(r0);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x216f:
        r7 = fileBytes;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = r7.hasRemaining();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2015;
    L_0x2177:
        r7 = fileBytes;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r5 = r7.position();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = fileBytes;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r6 = r7.get();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = byteOrigOatUpd1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOatUpd1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOatUpd1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOatUpd1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x21d2;
    L_0x2191:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x21bb;
    L_0x219c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x21bb:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x21cd;
    L_0x21c6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x21cd:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x21d2:
        r7 = byteOrigOatUpd2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOatUpd2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOatUpd2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOatUpd2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2221;
    L_0x21e0:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x220a;
    L_0x21eb:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x220a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x221c;
    L_0x2215:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x221c:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x2221:
        r7 = byteOrigOat1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOat1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOat1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOat1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2270;
    L_0x222f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2259;
    L_0x223a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core11 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2259:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x226b;
    L_0x2264:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core11 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x226b:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x2270:
        r7 = byteOrigOatUpd4;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOatUpd4;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOatUpd4;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOatUpd4;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x22bf;
    L_0x227e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x22a8;
    L_0x2289:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x22a8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x22ba;
    L_0x22b3:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x22ba:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x22bf:
        r7 = byteOrigOatUpd4_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOatUpd4_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOatUpd4_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOatUpd4_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x230e;
    L_0x22cd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x22f7;
    L_0x22d8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x22f7:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2309;
    L_0x2302:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2309:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x230e:
        r7 = byteOrigOatUpd5;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOatUpd5;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOatUpd5;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOatUpd5;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x235d;
    L_0x231c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2346;
    L_0x2327:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2346:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2358;
    L_0x2351:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2358:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x235d:
        r7 = byteOrigOatUpd5_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOatUpd5_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOatUpd5_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOatUpd5_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x23ac;
    L_0x236b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2395;
    L_0x2376:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2395:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x23a7;
    L_0x23a0:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x23a7:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x23ac:
        r7 = byteOrigOat4;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOat4;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOat4;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOat4;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x23fb;
    L_0x23ba:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x23e4;
    L_0x23c5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core11 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x23e4:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x23f6;
    L_0x23ef:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core11 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x23f6:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x23fb:
        r7 = byteOrigOat2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOat2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOat2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOat2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x244a;
    L_0x2409:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2433;
    L_0x2414:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core12 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2433:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2445;
    L_0x243e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core12 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2445:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x244a:
        r7 = byteOrigOat5;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = maskOat5;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = byteReplaceOat5;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r10 = rep_maskOat5;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2499;
    L_0x2458:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2482;
    L_0x2463:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core12 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2482:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2494;
    L_0x248d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core12 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2494:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x2499:
        r14 = byteOrigOat3;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r15 = maskOat3;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r16 = byteReplaceOat3;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r17 = rep_maskOat3;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x24ea;
    L_0x24a9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x24d3;
    L_0x24b4:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x24d3:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x24e5;
    L_0x24de:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x24e5:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x24ea:
        r14 = byteOrigOat3_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r15 = maskOat3_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r16 = byteReplaceOat3_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r17 = rep_maskOat3_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x253b;
    L_0x24fa:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2524;
    L_0x2505:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2524:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2536;
    L_0x252f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2536:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x253b:
        r14 = byteOrigOat3_2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r15 = maskOat3_2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r16 = byteReplaceOat3_2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r17 = rep_maskOat3_2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x258c;
    L_0x254b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2575;
    L_0x2556:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2575:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2587;
    L_0x2580:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2587:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x258c:
        r14 = byteOrigOat6;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r15 = maskOat6;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r16 = byteReplaceOat6;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r17 = rep_maskOat6;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x25dd;
    L_0x259c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x25c6;
    L_0x25a7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x25c6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x25d8;
    L_0x25d1:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x25d8:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x25dd:
        r14 = byteOrigOat6_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r15 = maskOat6_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r16 = byteReplaceOat6_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r17 = rep_maskOat6_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x262e;
    L_0x25ed:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2617;
    L_0x25f8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2617:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2629;
    L_0x2622:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2629:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x262e:
        r14 = byteOrigOat7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r15 = maskOat7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r16 = byteReplaceOat7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r17 = rep_maskOat7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x267f;
    L_0x263e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2668;
    L_0x2649:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x2668:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x267a;
    L_0x2673:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x267a:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x267f:
        r14 = byteOrigOat7_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r15 = maskOat7_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r16 = byteReplaceOat7_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r17 = rep_maskOat7_1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x26d0;
    L_0x268f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x26b9;
    L_0x269a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8.<init>();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r9 = "position:";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x26b9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x26cb;
    L_0x26c4:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
    L_0x26cb:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r60 = 1;
    L_0x26d0:
        if (r11 == 0) goto L_0x26e4;
    L_0x26d2:
        r7 = patchOatUpd1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r7 = r7 & r18;
        if (r7 == 0) goto L_0x26e4;
    L_0x26d8:
        r7 = patchOat1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x26e4;
    L_0x26dc:
        r7 = patchOat2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x26e4;
    L_0x26e0:
        r7 = patchOat3;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 != 0) goto L_0x26fc;
    L_0x26e4:
        if (r11 == 0) goto L_0x26f4;
    L_0x26e6:
        if (r18 != 0) goto L_0x26f4;
    L_0x26e8:
        r7 = patchOatUpd1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x26f4;
    L_0x26ec:
        r7 = patchOat1;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x26f4;
    L_0x26f0:
        r7 = patchOat2;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 != 0) goto L_0x26fc;
    L_0x26f4:
        if (r11 != 0) goto L_0x2700;
    L_0x26f6:
        if (r18 == 0) goto L_0x2700;
    L_0x26f8:
        r7 = patchOat3;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x2700;
    L_0x26fc:
        r60 = 1;
        goto L_0x2015;
    L_0x2700:
        r7 = fileBytes;	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        r8 = r5 + 1;
        r7.position(r8);	 Catch:{ Exception -> 0x2709, FileNotFoundException -> 0x10e3 }
        goto L_0x216f;
    L_0x2709:
        r38 = move-exception;
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r38;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x2015;
    L_0x2726:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r37;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x209e;
    L_0x2736:
        r7 = 1;
        not_found_bytes_for_patch = r7;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x209e;
    L_0x273b:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/classes.dex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x2909;
    L_0x2747:
        com.chelpus.Utils.fixadler(r49);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x274a:
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "ART";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x293b;
    L_0x2755:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/classes.dex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0b2f;
    L_0x2761:
        if (r60 == 0) goto L_0x0b2f;
    L_0x2763:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "start";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r37 = "/system/framework/core-libart.backup";
        r65 = "/system/framework/core-libart.jar";
        r7 = 1;
        r8 = 0;
        r0 = r65;
        r1 = r37;
        r7 = com.chelpus.Utils.copyFile(r0, r1, r7, r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x2928;
    L_0x277a:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "good space";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r37;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r41 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r41.<init>();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "add files";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = new com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/data/app/classes.dex";
        r9 = "/data/app/";
        r7.<init>(r8, r9);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r41;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = "/system/framework/core-libart.jar";
        r8 = "/system/framework/core-libart.backup";
        r0 = r41;
        com.chelpus.Utils.addFilesToZip(r7, r8, r0);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "add files finish";
        r7.println(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = "0644";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 2;
        r9 = "/system/framework/core-libart.backup";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = "0:0";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 2;
        r9 = "/system/framework/core-libart.backup";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = "0.0";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 2;
        r9 = "/system/framework/core-libart.backup";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = 2;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "rm";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/system/framework/core-libart.jar";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = r7.exists();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x281b;
    L_0x2811:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/system/framework/core-libart.jar";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
    L_0x281b:
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "mv";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = "/system/framework/core.backup";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 2;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/system/framework/core-libart.jar";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = r7.exists();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        if (r7 != 0) goto L_0x284e;
    L_0x283d:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/system/framework/core-libart.backup";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r9 = "/system/framework/core-libart.jar";
        r8.<init>(r9);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.renameTo(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
    L_0x284e:
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = "0644";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 2;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = "0:0";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 2;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = "0.0";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 2;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = "/system/framework/core-libart.jar";
        r36 = com.chelpus.Utils.getFileDalvikCache(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        if (r36 == 0) goto L_0x28b0;
    L_0x2895:
        r7 = 2;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 0;
        r9 = "rm";
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = 1;
        r9 = r36.getAbsolutePath();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = r36.exists();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        if (r7 == 0) goto L_0x28b0;
    L_0x28ad:
        r36.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
    L_0x28b0:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/data/dalvik-cache/arm/system@framework@arm@boot.oat";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/data/dalvik-cache/arm/system@framework@arm@boot.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/data/dalvik-cache/arm64/system@framework@arm@boot.oat";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/data/dalvik-cache/arm64/system@framework@arm@boot.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/data/dalvik-cache/x86/system@framework@arm@boot.oat";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/data/dalvik-cache/x86/system@framework@arm@boot.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/data/dalvik-cache/x86_64/system@framework@arm@boot.oat";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r8 = "/data/dalvik-cache/x86_64/system@framework@arm@boot.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
        r7.delete();	 Catch:{ Exception -> 0x2912, FileNotFoundException -> 0x10e3 }
    L_0x2900:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "finish";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x0b2f;
    L_0x2909:
        r7 = "/system/framework/core.jar";
        r0 = r49;
        com.chelpus.Utils.fixadlerOdex(r0, r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x274a;
    L_0x2912:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "/system/framework/core.backup";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x2900;
    L_0x2928:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r0 = r37;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x0b2f;
    L_0x293b:
        r7 = onlyDalvik;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 != 0) goto L_0x0b2f;
    L_0x293f:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "system@framework@core.jar@classes.dex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x29a8;
    L_0x294b:
        if (r60 == 0) goto L_0x29a8;
    L_0x294d:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "LuckyPatcher: dalvik-cache patched! ";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r29 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = "/system/framework/core.patched";
        r0 = r29;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r37 = "/system/framework/core.patched";
        r65 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = 1;
        r8 = 0;
        r0 = r65;
        r1 = r37;
        r7 = com.chelpus.Utils.copyFile(r0, r1, r7, r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x29d6;
    L_0x296f:
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 1;
        r9 = "0644";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 2;
        r7[r8] = r37;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 1;
        r9 = "0.0";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 2;
        r7[r8] = r37;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 1;
        r9 = "0:0";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = 2;
        r7[r8] = r37;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x29a8:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = "/system/framework/core.patched";
        r0 = r27;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r27.exists();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x29be;
    L_0x29b7:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "LuckyPatcher: root found core.patched! ";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
    L_0x29be:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = "/system/framework/core.odex";
        r0 = r27;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = r27.exists();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        if (r7 == 0) goto L_0x0b2f;
    L_0x29cd:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "LuckyPatcher: root found core.odex! ";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x0b2f;
    L_0x29d6:
        r29.delete();	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "LuckyPatcher: not space to system for odex core.jar! ";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x10e3, Exception -> 0x2128 }
        goto L_0x29a8;
    L_0x29e8:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x29fb;
    L_0x29f5:
        r66 = "/data/dalvik-cache";
        r47 = "/arm";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x29fb:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x2a0e;
    L_0x2a08:
        r66 = "/data/dalvik-cache";
        r47 = "/arm64";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x2a0e:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x2a21;
    L_0x2a1b:
        r66 = "/data/dalvik-cache";
        r47 = "/x86";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x2a21:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x2a34;
    L_0x2a2e:
        r66 = "/data/dalvik-cache";
        r47 = "/x86_64";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x2a34:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/arm/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x2a47;
    L_0x2a41:
        r66 = "/data/dalvik-cache/oat";
        r47 = "/arm";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x2a47:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/arm64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x2a5a;
    L_0x2a54:
        r66 = "/data/dalvik-cache/oat";
        r47 = "/arm64";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x2a5a:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/x86/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x2a6d;
    L_0x2a67:
        r66 = "/data/dalvik-cache/oat";
        r47 = "/x86";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x2a6d:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/x86_64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x11f4;
    L_0x2a7a:
        r66 = "/data/dalvik-cache/oat";
        r47 = "/x86_64";
        r40 = "/system@framework@services.jar@classes.dex";
        goto L_0x11f4;
    L_0x2a82:
        r7 = 3;
        r7 = new java.lang.String[r7];
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;
        r8 = 1;
        r9 = "644";
        r7[r8] = r9;
        r8 = 2;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r66;
        r9 = r9.append(r0);
        r0 = r47;
        r9 = r9.append(r0);
        r0 = r40;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r7[r8] = r9;
        com.chelpus.Utils.run_all_no_root(r7);
        r7 = 3;
        r7 = new java.lang.String[r7];
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;
        r8 = 1;
        r9 = "0:0";
        r7[r8] = r9;
        r8 = 2;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r66;
        r9 = r9.append(r0);
        r0 = r47;
        r9 = r9.append(r0);
        r0 = r40;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r7[r8] = r9;
        com.chelpus.Utils.run_all_no_root(r7);
        r7 = 3;
        r7 = new java.lang.String[r7];
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;
        r8 = 1;
        r9 = "0.0";
        r7[r8] = r9;
        r8 = 2;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r66;
        r9 = r9.append(r0);
        r0 = r47;
        r9 = r9.append(r0);
        r0 = r40;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r7[r8] = r9;
        com.chelpus.Utils.run_all_no_root(r7);
        goto L_0x12bd;
    L_0x2b0e:
        r7 = java.lang.System.out;
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);
        goto L_0x12ca;
    L_0x2b17:
        r7 = 3;
        r7 = new java.lang.String[r7];
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;
        r8 = 1;
        r9 = "644";
        r7[r8] = r9;
        r8 = 2;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r66;
        r9 = r9.append(r0);
        r0 = r47;
        r9 = r9.append(r0);
        r0 = r40;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r7[r8] = r9;
        com.chelpus.Utils.run_all_no_root(r7);
        r7 = 3;
        r7 = new java.lang.String[r7];
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;
        r8 = 1;
        r9 = "0:0";
        r7[r8] = r9;
        r8 = 2;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r66;
        r9 = r9.append(r0);
        r0 = r47;
        r9 = r9.append(r0);
        r0 = r40;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r7[r8] = r9;
        com.chelpus.Utils.run_all_no_root(r7);
        r7 = 3;
        r7 = new java.lang.String[r7];
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;
        r8 = 1;
        r9 = "0.0";
        r7[r8] = r9;
        r8 = 2;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r66;
        r9 = r9.append(r0);
        r0 = r47;
        r9 = r9.append(r0);
        r0 = r40;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r7[r8] = r9;
        com.chelpus.Utils.run_all_no_root(r7);
        goto L_0x13fc;
    L_0x2ba3:
        r7 = fileBytes;	 Catch:{ Exception -> 0x2bac }
        r8 = r5 + 1;
        r7.position(r8);	 Catch:{ Exception -> 0x2bac }
        goto L_0x1477;
    L_0x2bac:
        r38 = move-exception;
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x2bc9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x2bc9 }
        r8.<init>();	 Catch:{ IOException -> 0x2bc9 }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ IOException -> 0x2bc9 }
        r0 = r38;
        r8 = r8.append(r0);	 Catch:{ IOException -> 0x2bc9 }
        r8 = r8.toString();	 Catch:{ IOException -> 0x2bc9 }
        r7.println(r8);	 Catch:{ IOException -> 0x2bc9 }
        goto L_0x1b65;
    L_0x2bc9:
        r38 = move-exception;
        r38.printStackTrace();
        goto L_0x1b68;
    L_0x2bcf:
        r7 = java.lang.System.out;
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);
        goto L_0x1b68;
    L_0x2bd8:
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "ART";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x2c63;
    L_0x2be3:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "/system/framework/services.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x2c14;
    L_0x2bf0:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "/system/framework/services.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r7.length();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 == 0) goto L_0x2c14;
    L_0x2c01:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "Add services.odex for patch";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "/system/framework/services.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r42;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x2c14:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "/system/framework/services.jar";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = com.chelpus.Utils.classes_test(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x1c4f;
    L_0x2c21:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "services.jar contain classes,dex";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = "/system/framework/services.jar";
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = "/data/app";
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = "/data/app/classes.dex";
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x1c4f;
    L_0x2c47:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "Add classes.dex for patch";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r42;
        r1 = r26;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x1c4f;
    L_0x2c57:
        r53 = move-exception;
    L_0x2c58:
        r7 = java.lang.System.out;
        r8 = "Error: services.odex not found!\n\nPlease Odex services.jar and try again!";
        r7.println(r8);
    L_0x2c5f:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x2c63:
        r7 = onlyDalvik;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x2c8c;
    L_0x2c67:
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = 2;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r52;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r52.exists();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        if (r7 != 0) goto L_0x2c81;
    L_0x2c77:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        throw r7;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
    L_0x2c7d:
        r53 = move-exception;
        r49 = r52;
        goto L_0x2c58;
    L_0x2c81:
        r0 = r42;
        r1 = r52;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r49 = r52;
        goto L_0x1c4f;
    L_0x2c8c:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "Vhodjashij file ";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = 2;
        r9 = r71[r9];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = 2;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r52;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r52.exists();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        if (r7 != 0) goto L_0x2cdd;
    L_0x2cb7:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        throw r7;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
    L_0x2cbd:
        r38 = move-exception;
        r49 = r52;
    L_0x2cc0:
        r7 = java.lang.System.out;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Exception e";
        r8 = r8.append(r9);
        r9 = r38.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.println(r8);
        goto L_0x2c5f;
    L_0x2cdd:
        r7 = r52.toString();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = "system@framework@services.jar@classes.dex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        if (r7 == 0) goto L_0x3ac8;
    L_0x2ce9:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = "Vhodjashij file byl dalvick-cache ";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = 2;
        r9 = r71[r9];	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r7 = "/system/framework/services.jar";
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r7 = "/data/app";
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r7 = "/data/app/classes.dex";
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        if (r7 == 0) goto L_0x3ac4;
    L_0x2d23:
        r49 = r26;
    L_0x2d25:
        r28 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = "/system/framework/services.odex";
        r0 = r28;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7 = r28.exists();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r7 == 0) goto L_0x2d41;
    L_0x2d34:
        r8 = r28.length();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 != 0) goto L_0x2d41;
    L_0x2d3e:
        r28.delete();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x2d41:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "Add file for patch ";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r49.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r42;
        r1 = r49;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x1c4f;
    L_0x2d66:
        r38 = move-exception;
        goto L_0x2cc0;
    L_0x2d69:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = "";
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r38;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x2d87:
        r8 = lastPatchPosition;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 <= 0) goto L_0x2da2;
    L_0x2d8b:
        r8 = lastByteReplace;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x2da2;
    L_0x2d8f:
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = lastPatchPosition;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.position(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = lastByteReplace;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.put(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.force();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x2da2:
        r4.close();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = 4;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "framework";
        r8 = r8.contains(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x35dc;
    L_0x2db0:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "Rebuild file!";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "/classes.dex";
        r8 = r8.endsWith(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x2e32;
    L_0x2dc3:
        com.chelpus.Utils.fixadler(r49);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r61 == 0) goto L_0x35d7;
    L_0x2dc8:
        r8 = 0;
        not_found_bytes_for_patch = r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "/services.jar";
        r10 = "/services-patched.jar";
        r37 = r8.replace(r9, r10);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = 1;
        r65 = r71[r8];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r37;
        r8.<init>(r0);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r41 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r41.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "add files";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r12 = com.chelpus.Utils.getDirs(r49);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r12 = r12.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = r10.append(r12);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r12 = "/";
        r10 = r10.append(r12);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = r10.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.<init>(r9, r10);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r41;
        r0.add(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r65;
        r1 = r37;
        r2 = r41;
        com.chelpus.Utils.addFilesToZip(r0, r1, r2);	 Catch:{ Exception -> 0x35c7, FileNotFoundException -> 0x2c57 }
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35c7, FileNotFoundException -> 0x2c57 }
        r9 = "add files finish";
        r8.println(r9);	 Catch:{ Exception -> 0x35c7, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x35c7, FileNotFoundException -> 0x2c57 }
        r0 = r65;
        r8.<init>(r0);	 Catch:{ Exception -> 0x35c7, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x35c7, FileNotFoundException -> 0x2c57 }
    L_0x2e32:
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "/services.odex";
        r8 = r8.endsWith(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x1c53;
    L_0x2e3e:
        r8 = com.chelpus.Utils.isELFfiles(r49);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 != 0) goto L_0x2e4a;
    L_0x2e44:
        r8 = 0;
        r0 = r49;
        com.chelpus.Utils.fixadlerOdex(r0, r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x2e4a:
        if (r61 == 0) goto L_0x1c53;
    L_0x2e4c:
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = "/services.odex";
        r12 = "/services-patched.odex";
        r9 = r9.replace(r10, r12);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r49;
        r0.renameTo(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x1c53;
    L_0x2e64:
        r0 = r49;
        r1 = r71;
        r2 = r25;
        patchWithOatDumpP3(r0, r1, r2);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = patchOat1;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 != 0) goto L_0x2e73;
    L_0x2e71:
        if (r25 != 0) goto L_0x2e79;
    L_0x2e73:
        r8 = patchOat2;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 != 0) goto L_0x2da2;
    L_0x2e77:
        if (r25 == 0) goto L_0x2da2;
    L_0x2e79:
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r14 = 0;
        r8 = r4.size();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = (int) r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = (long) r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r16 = r0;
        r12 = r4;
        r8 = r12.map(r13, r14, r16);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        fileBytes = r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = 4120; // 0x1018 float:5.773E-42 double:2.0356E-320;
        r8.position(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r8.get();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r9.get();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = r10.get();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r12 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r12 = r12.get();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r63 = com.chelpus.Utils.convertFourBytesToInt(r8, r9, r10, r12);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = "Start position:";
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r63;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r63;
        r8.position(r0);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x2ed0:
        r8 = fileBytes;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r8 = r8.hasRemaining();	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2da2;
    L_0x2ed8:
        r8 = fileBytes;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r5 = r8.position();	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r8 = fileBytes;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r6 = r8.get();	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r21 = byteOrigSOat1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f1f;
    L_0x2ef6:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f08;
    L_0x2f01:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2f08:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f1a;
    L_0x2f13:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2f1a:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x2f1f:
        r21 = byteOrigSOat1_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat1_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat1_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat1_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f5a;
    L_0x2f31:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f43;
    L_0x2f3c:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2f43:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f55;
    L_0x2f4e:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2f55:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x2f5a:
        r21 = byteOrigSOat1_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat1_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat1_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat1_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f95;
    L_0x2f6c:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f7e;
    L_0x2f77:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2f7e:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2f90;
    L_0x2f89:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2f90:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x2f95:
        r21 = byteOrigSOat2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2fd0;
    L_0x2fa7:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2fb9;
    L_0x2fb2:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2fb9:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2fcb;
    L_0x2fc4:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2fcb:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x2fd0:
        r21 = byteOrigSOat6_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat6_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat6_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat6_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x300b;
    L_0x2fe2:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x2ff4;
    L_0x2fed:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x2ff4:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3006;
    L_0x2fff:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3006:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x300b:
        r21 = byteOrigSOat6_3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat6_3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat6_3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat6_3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3046;
    L_0x301d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x302f;
    L_0x3028:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x302f:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3041;
    L_0x303a:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3041:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3046:
        r21 = byteOrigSOat6_4;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat6_4;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat6_4;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat6_4;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3081;
    L_0x3058:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x306a;
    L_0x3063:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x306a:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x307c;
    L_0x3075:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x307c:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3081:
        r21 = byteOrigSOat6_5;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat6_5;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat6_5;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat6_5;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x30bc;
    L_0x3093:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x30a5;
    L_0x309e:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x30a5:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x30b7;
    L_0x30b0:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x30b7:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x30bc:
        r21 = byteOrigSOat3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x30f7;
    L_0x30ce:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x30e0;
    L_0x30d9:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x30e0:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x30f2;
    L_0x30eb:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x30f2:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x30f7:
        r21 = byteOrigSOat6;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat6;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat6;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat6;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3132;
    L_0x3109:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x311b;
    L_0x3114:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x311b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x312d;
    L_0x3126:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x312d:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3132:
        r21 = byteOrigSOat7;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat7;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat7;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat7;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x316d;
    L_0x3144:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3156;
    L_0x314f:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3156:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3168;
    L_0x3161:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3168:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x316d:
        r21 = byteOrigSOat7_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat7_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat7_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat7_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x31a8;
    L_0x317f:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3191;
    L_0x318a:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3191:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x31a3;
    L_0x319c:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x31a3:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x31a8:
        r21 = byteOrigSOat4;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat4;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat4;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat4;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x31e3;
    L_0x31ba:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x31cc;
    L_0x31c5:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x31cc:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x31de;
    L_0x31d7:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x31de:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x31e3:
        r21 = byteOrigSOat5;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat5;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat5;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat5;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x321e;
    L_0x31f5:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3207;
    L_0x3200:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3207:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3219;
    L_0x3212:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3219:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x321e:
        r21 = byteOrigSOat5_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat5_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat5_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat5_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3259;
    L_0x3230:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3242;
    L_0x323b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3242:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3254;
    L_0x324d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3254:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3259:
        r21 = byteOrigSOat8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3294;
    L_0x326b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x327d;
    L_0x3276:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x327d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x328f;
    L_0x3288:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x328f:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3294:
        r21 = byteOrigSOat8_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat8_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat8_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat8_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x32cf;
    L_0x32a6:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x32b8;
    L_0x32b1:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x32b8:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x32ca;
    L_0x32c3:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x32ca:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x32cf:
        r21 = byteOrigSOat8_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat8_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat8_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat8_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x330a;
    L_0x32e1:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x32f3;
    L_0x32ec:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x32f3:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3305;
    L_0x32fe:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3305:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x330a:
        r21 = byteOrigSOat10;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat10;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat10;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat10;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3345;
    L_0x331c:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x332e;
    L_0x3327:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x332e:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3340;
    L_0x3339:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3340:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3345:
        r21 = byteOrigSOat10_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat10_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat10_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat10_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3380;
    L_0x3357:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3369;
    L_0x3362:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3369:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x337b;
    L_0x3374:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x337b:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3380:
        r21 = byteOrigSOat11;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat11;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat11;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat11;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x33bb;
    L_0x3392:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x33a4;
    L_0x339d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x33a4:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x33b6;
    L_0x33af:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x33b6:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x33bb:
        r21 = byteOrigSOat11_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat11_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat11_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat11_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x33f6;
    L_0x33cd:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x33df;
    L_0x33d8:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x33df:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x33f1;
    L_0x33ea:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x33f1:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x33f6:
        r21 = byteOrigSOat11_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat11_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat11_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat11_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3431;
    L_0x3408:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x341a;
    L_0x3413:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x341a:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x342c;
    L_0x3425:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x342c:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3431:
        r21 = byteOrigSOat9;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat9;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat9;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat9;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x346c;
    L_0x3443:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3455;
    L_0x344e:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3455:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3467;
    L_0x3460:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3467:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x346c:
        r21 = byteOrigSOat9_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat9_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat9_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat9_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x34a7;
    L_0x347e:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3490;
    L_0x3489:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3490:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x34a2;
    L_0x349b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x34a2:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x34a7:
        r21 = byteOrigSOat9_3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat9_3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat9_3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat9_3;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x34e2;
    L_0x34b9:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x34cb;
    L_0x34c4:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x34cb:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x34dd;
    L_0x34d6:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x34dd:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x34e2:
        r21 = byteOrigSOat9_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat9_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat9_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat9_2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x351d;
    L_0x34f4:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3506;
    L_0x34ff:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3506:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3518;
    L_0x3511:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3518:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x351d:
        r21 = byteOrigSOat12;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat12;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat12;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat12;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3558;
    L_0x352f:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3541;
    L_0x353a:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3541:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3553;
    L_0x354c:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x3553:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3558:
        r21 = byteOrigSOat12_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r22 = maskSOat12_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r23 = byteReplaceSOat12_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r24 = rep_maskSOat12_1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3593;
    L_0x356a:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x357c;
    L_0x3575:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x357c:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x358e;
    L_0x3587:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
    L_0x358e:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r61 = 1;
    L_0x3593:
        if (r25 == 0) goto L_0x35a1;
    L_0x3595:
        r8 = patchOat1;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x35a1;
    L_0x3599:
        r8 = patchOat2;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x35a1;
    L_0x359d:
        r8 = patchOat6;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        if (r8 != 0) goto L_0x2da2;
    L_0x35a1:
        r8 = fileBytes;	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        r9 = r5 + 1;
        r8.position(r9);	 Catch:{ Exception -> 0x35aa, FileNotFoundException -> 0x2c57 }
        goto L_0x2ed0;
    L_0x35aa:
        r38 = move-exception;
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r10 = "";
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r38;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x2da2;
    L_0x35c7:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r37;
        r8.<init>(r0);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x2e32;
    L_0x35d7:
        r8 = 1;
        not_found_bytes_for_patch = r8;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x2e32;
    L_0x35dc:
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "/classes.dex";
        r8 = r8.endsWith(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x37ea;
    L_0x35e8:
        com.chelpus.Utils.fixadler(r49);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x35eb:
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "system@framework@services.jar@classes.dex";
        r8 = r8.contains(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x3600;
    L_0x35f7:
        if (r61 == 0) goto L_0x3600;
    L_0x35f9:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "LuckyPatcher: dalvik-cache patched! ";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x3600:
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "/classes.dex";
        r8 = r8.contains(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x37a3;
    L_0x360c:
        if (r61 == 0) goto L_0x37a3;
    L_0x360e:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "start";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r37 = "/system/framework/services.backup";
        r65 = "/system/framework/services.jar";
        r8 = 1;
        r9 = 0;
        r0 = r65;
        r1 = r37;
        r8 = com.chelpus.Utils.copyFile(r0, r1, r8, r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x380e;
    L_0x3625:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "good space";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r37;
        r8.<init>(r0);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r41 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r41.<init>();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "add files";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "/data/app/classes.dex";
        r10 = "/data/app/";
        r8.<init>(r9, r10);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r41;
        r0.add(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "/system/framework/services.jar";
        r9 = "/system/framework/services.backup";
        r0 = r41;
        com.chelpus.Utils.addFilesToZip(r8, r9, r0);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = "add files finish";
        r8.println(r9);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 0;
        r10 = "chmod";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 1;
        r10 = "0644";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 2;
        r10 = "/system/framework/services.backup";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 0;
        r10 = "chown";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 1;
        r10 = "0:0";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 2;
        r10 = "/system/framework/services.backup";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 0;
        r10 = "chmod";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 1;
        r10 = "0.0";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 2;
        r10 = "/system/framework/services.backup";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r28 = new java.io.File;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = "/system/framework/services.odex";
        r0 = r28;
        r0.<init>(r8);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = "/system/framework/services.jar";
        r35 = com.chelpus.Utils.getFileDalvikCache(r8);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = r28.exists();	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x36c2;
    L_0x36b4:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = "fix odex na osnove rebuild services";
        r8.println(r9);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = "/system/framework/services.backup";
        r0 = r28;
        com.chelpus.Utils.fixadlerOdex(r0, r8);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
    L_0x36c2:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9.<init>();	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r10 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.toolfilesdir;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r10 = "/ClearDalvik.on";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8.createNewFile();	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = "/system/framework/services.jar";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = 2;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 0;
        r10 = "rm";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 1;
        r10 = "/system/framework/services.jar";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = "/system/framework/services.backup";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = new java.io.File;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r10 = "/system/framework/services.jar";
        r9.<init>(r10);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8.renameTo(r9);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = "/system/framework/services.jar";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r8 = r8.exists();	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        if (r8 != 0) goto L_0x372c;
    L_0x3717:
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 0;
        r10 = "mv";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 1;
        r10 = "/system/framework/services.backup";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        r9 = 2;
        r10 = "/system/framework/services.jar";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
    L_0x372c:
        if (r35 == 0) goto L_0x3749;
    L_0x372e:
        r8 = 2;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = 0;
        r10 = "rm";
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = 1;
        r10 = r35.getAbsolutePath();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8 = r35.exists();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        if (r8 == 0) goto L_0x3749;
    L_0x3746:
        r35.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
    L_0x3749:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = "/data/dalvik-cache/arm/system@framework@arm@boot.oat";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = "/data/dalvik-cache/arm/system@framework@arm@boot.art";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = "/data/dalvik-cache/arm64/system@framework@arm@boot.oat";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = "/data/dalvik-cache/arm64/system@framework@arm@boot.art";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = "/data/dalvik-cache/x86/system@framework@arm@boot.oat";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = "/data/dalvik-cache/x86/system@framework@arm@boot.art";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = "/data/dalvik-cache/x86_64/system@framework@arm@boot.oat";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r9 = "/data/dalvik-cache/x86_64/system@framework@arm@boot.art";
        r8.<init>(r9);	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
        r8.delete();	 Catch:{ Exception -> 0x37f3, FileNotFoundException -> 0x2c57 }
    L_0x3799:
        com.chelpus.Utils.clear_dalvik_cache();	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
    L_0x379c:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "finish";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x37a3:
        r8 = onlyDalvik;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 != 0) goto L_0x1c53;
    L_0x37a7:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "/system/framework/services.patched";
        r0 = r27;
        r0.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r27.exists();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x37bd;
    L_0x37b6:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "LuckyPatcher: root found services.patched! ";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x37bd:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = "/system/framework/services.odex";
        r0 = r27;
        r0.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = r27.exists();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x37d3;
    L_0x37cc:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "LuckyPatcher: root found services.odex! ";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
    L_0x37d3:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        if (r8 == 0) goto L_0x1c53;
    L_0x37de:
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "/system/framework/patch3.done";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x1c53;
    L_0x37ea:
        r8 = "/system/framework/services.jar";
        r0 = r49;
        com.chelpus.Utils.fixadlerOdex(r0, r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x35eb;
    L_0x37f3:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ Exception -> 0x37f8, FileNotFoundException -> 0x2c57 }
        goto L_0x3799;
    L_0x37f8:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r9 = "/system/framework/services.backup";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        goto L_0x379c;
    L_0x380e:
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r37;
        r8.<init>(r0);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = 2;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r0 = r52;
        r0.<init>(r8);	 Catch:{ FileNotFoundException -> 0x2c57, Exception -> 0x2d66 }
        r8 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = "rw";
        r0 = r52;
        r8.<init>(r0, r9);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r4 = r8.getChannel();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r14 = 0;
        r8 = r4.size();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = (int) r8;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r0 = (long) r8;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r16 = r0;
        r12 = r4;
        r8 = r12.map(r13, r14, r16);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        fileBytes = r8;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r31 = 0;
        r32 = 0;
        r8 = 0;
        lastByteReplace = r8;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = 0;
        lastPatchPosition = r8;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r61 = 0;
        r50 = 0;
    L_0x3850:
        r8 = fileBytes;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r8 = r8.hasRemaining();	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3a84;
    L_0x3858:
        r8 = fileBytes;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r5 = r8.position();	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r8 = fileBytes;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r6 = r8.get();	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r21 = byteOrigS2;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS2;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS2;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS2;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x389c;
    L_0x3876:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3888;
    L_0x3881:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x3888:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x389a;
    L_0x3893:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x389a:
        r61 = 1;
    L_0x389c:
        r21 = byteOrigS5;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS5;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS5;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS5;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x38d4;
    L_0x38ae:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x38c0;
    L_0x38b9:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x38c0:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x38d2;
    L_0x38cb:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x38d2:
        r61 = 1;
    L_0x38d4:
        r21 = byteOrigS14;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS14;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS14;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS14;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x390c;
    L_0x38e6:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x38f8;
    L_0x38f1:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x38f8:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x390a;
    L_0x3903:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x390a:
        r61 = 1;
    L_0x390c:
        r21 = byteOrigS6;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS6;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS6;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS6;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3944;
    L_0x391e:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3930;
    L_0x3929:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 patched!checkUpgradeKeySetLP\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x3930:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3942;
    L_0x393b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 restored!checkUpgradeKeySetLP\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x3942:
        r61 = 1;
    L_0x3944:
        r21 = byteOrigS7;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS7;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS7;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS7;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x397c;
    L_0x3956:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3968;
    L_0x3961:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 patched!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x3968:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x397a;
    L_0x3973:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 restored!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x397a:
        r61 = 1;
    L_0x397c:
        r21 = byteOrigS7_1;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS7_1;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS7_1;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS7_1;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x39b4;
    L_0x398e:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x39a0;
    L_0x3999:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 patched!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x39a0:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x39b2;
    L_0x39ab:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 restored!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x39b2:
        r61 = 1;
    L_0x39b4:
        r21 = byteOrigS3;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS3;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS3;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS3;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x39ec;
    L_0x39c6:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x39d8;
    L_0x39d1:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 patched!\nCM11";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x39d8:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x39ea;
    L_0x39e3:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 restored!\nCM11";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x39ea:
        r61 = 1;
    L_0x39ec:
        r21 = byteOrigS4;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS4;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS4;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS4;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3a24;
    L_0x39fe:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3a10;
    L_0x3a09:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x3a10:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3a22;
    L_0x3a1b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x3a22:
        r61 = 1;
    L_0x3a24:
        r21 = byteOrigS13_1;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r22 = maskS13_1;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r23 = byteReplaceS13_1;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r24 = rep_maskS13_1;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3a5c;
    L_0x3a36:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3a48;
    L_0x3a41:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x3a48:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        if (r8 == 0) goto L_0x3a5a;
    L_0x3a53:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
    L_0x3a5a:
        r61 = 1;
    L_0x3a5c:
        r8 = fileBytes;	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r9 = r5 + 1;
        r8.position(r9);	 Catch:{ Exception -> 0x3a69, FileNotFoundException -> 0x2c7d }
        r8 = 1;
        r50 = r50 + r8;
        goto L_0x3850;
    L_0x3a69:
        r38 = move-exception;
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r10 = "";
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r0 = r38;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
    L_0x3a84:
        r8 = lastPatchPosition;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        if (r8 <= 0) goto L_0x3a9f;
    L_0x3a88:
        r8 = lastByteReplace;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        if (r8 == 0) goto L_0x3a9f;
    L_0x3a8c:
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = lastPatchPosition;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8.position(r9);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = lastByteReplace;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8.put(r9);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8.force();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
    L_0x3a9f:
        r4.close();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r8 = r52.toString();	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = "/classes.dex";
        r8 = r8.endsWith(r9);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        if (r8 == 0) goto L_0x3abc;
    L_0x3aae:
        com.chelpus.Utils.fixadler(r52);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
    L_0x3ab1:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r9 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        r49 = r52;
        goto L_0x37a3;
    L_0x3abc:
        r8 = "/system/framework/services.jar";
        r0 = r52;
        com.chelpus.Utils.fixadlerOdex(r0, r8);	 Catch:{ FileNotFoundException -> 0x2c7d, Exception -> 0x2cbd }
        goto L_0x3ab1;
    L_0x3ac4:
        r49 = r52;
        goto L_0x2d25;
    L_0x3ac8:
        r49 = r52;
        goto L_0x2d41;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chelpus.root.utils.corepatch.main(java.lang.String[]):void");
    }

    public static void unzip(File apk, String dirr) {
        boolean found1 = false;
        String dir = dirr;
        try {
            FileInputStream fin = new FileInputStream(apk);
            ZipInputStream zin = new ZipInputStream(fin);
            for (ZipEntry ze = zin.getNextEntry(); ze != null && true; ze = zin.getNextEntry()) {
                if (ze.getName().equals("classes.dex")) {
                    FileOutputStream fout = new FileOutputStream(dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex");
                    byte[] buffer = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
                    while (true) {
                        int length = zin.read(buffer);
                        if (length == -1) {
                            break;
                        }
                        fout.write(buffer, 0, length);
                    }
                    Utils.run_all_no_root("chmod", "777", dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex");
                    Utils.run_all_no_root("chown", "0.0", dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex");
                    Utils.run_all_no_root("chown", "0:0", dir + InternalZipConstants.ZIP_FILE_SEPARATOR + "classes.dex");
                    zin.closeEntry();
                    fout.close();
                    found1 = true;
                }
                if (found1) {
                    break;
                }
            }
            zin.close();
            fin.close();
        } catch (Exception e) {
            try {
                new ZipFile(apk).extractFile("classes.dex", dir);
            } catch (ZipException e1) {
                System.out.println("Error classes.dex decompress! " + e1);
                System.out.println("Exception e1" + e.toString());
            } catch (Exception e12) {
                System.out.println("Error classes.dex decompress! " + e12);
                System.out.println("Exception e1" + e.toString());
            }
            System.out.println("Exception e" + e.toString());
        }
    }

    private static boolean applyPatch(int curentPos, byte currentByte, byte[] byteOrig, byte[] mask, byte[] byteReplace, byte[] rep_mask, boolean pattern) {
        if (byteOrig != null && currentByte == byteOrig[0] && pattern) {
            try {
                fileBytes.position((byteOrig.length - 1) + curentPos);
                if (fileBytes.get() == byteOrig[byteOrig.length - 1]) {
                    if (rep_mask[0] == (byte) 0) {
                        byteReplace[0] = currentByte;
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
                        if (rep_mask[i] == (byte) 3) {
                            byteReplace[i] = (byte) (prufbyte & 15);
                        }
                        if (rep_mask[i] == (byte) 2) {
                            byteReplace[i] = (byte) ((prufbyte & 15) + ((prufbyte & 15) * 16));
                        }
                        i++;
                        if (i == byteOrig.length) {
                            fileBytes.position(curentPos);
                            fileBytes.put(byteReplace);
                            fileBytes.force();
                            return true;
                        }
                        prufbyte = fileBytes.get();
                    }
                    fileBytes.position(curentPos + 1);
                }
            } catch (IllegalArgumentException e) {
            }
        }
        return false;
    }

    static void patchWithOatDumpP12(ArrayList<File> oatForPatch, String[] paramArrayOfString, boolean pattern1, boolean pattern2) {
        int count_oat_files = 0;
        boolean conscryptFound = false;
        Iterator it = oatForPatch.iterator();
        while (it.hasNext()) {
            File oatfile = (File) it.next();
            if (oatfile.exists() && oatfile.getAbsolutePath().contains("conscrypt")) {
                conscryptFound = true;
            }
        }
        Iterator it2 = oatForPatch.iterator();
        while (it2.hasNext()) {
            OatFuncDump oatDump;
            Iterator it3;
            OatFunc oatFunc;
            Iterator it4;
            PatchesItem pattern;
            int[] iArr;
            int length;
            int i;
            int headerOffset;
            boolean test;
            File fileForPatch = (File) it2.next();
            boolean patch_for_boot_aot = false;
            boolean patch_for_conscrypt_oat = false;
            if (fileForPatch.getAbsolutePath().toLowerCase().contains("boot.oat")) {
                patch_for_boot_aot = true;
            }
            if (fileForPatch.getAbsolutePath().toLowerCase().contains("conscrypt")) {
                patch_for_conscrypt_oat = true;
            }
            count_oat_files++;
            System.out.println("oat file for patch:" + fileForPatch.getAbsolutePath());
            if (patch_for_conscrypt_oat && pattern1 && conscryptFound) {
                oatDump = new Utils("").getOffsetOatdump(fileForPatch, new ArrayList<String>() {
                    {
                        add("boolean com.android.org.conscrypt.OpenSSLSignature.engineVerify(byte[])");
                    }
                });
                System.out.println(oatDump.instruction);
                try {
                    it3 = oatDump.funcArray.iterator();
                    while (it3.hasNext()) {
                        oatFunc = (OatFunc) it3.next();
                        System.out.println(oatFunc.funcName);
                        FileChannel ChannelDex = new RandomAccessFile(fileForPatch, InternalZipConstants.WRITE_MODE).getChannel();
                        fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                        if (oatFunc.codeOffset != 0) {
                            it4 = new ArrayList<PatchesItem>() {
                                {
                                    add(new PatchesItem(corepatch.byteOrig_patch1_arm, null, corepatch.byteReplace_patch1_arm, null, "", false));
                                    add(new PatchesItem(corepatch.byteOrig_patch1_arm_1, null, corepatch.byteReplace_patch1_arm_1, null, "", false));
                                    add(new PatchesItem(corepatch.byteOrig_patch1_arm64, null, corepatch.byteReplace_patch1_arm64, null, "", false));
                                    add(new PatchesItem(corepatch.byteOrig_patch1_arm64_1, null, corepatch.byteReplace_patch1_arm64_1, null, "", false));
                                    add(new PatchesItem(corepatch.byteOrig_patch1_arm64_2, null, corepatch.byteReplace_patch1_arm64_2, null, "", false));
                                    add(new PatchesItem(corepatch.byteOrig_patch1_x86, null, corepatch.byteReplace_patch1_x86, null, "", false));
                                }
                            }.iterator();
                            while (it4.hasNext()) {
                                pattern = (PatchesItem) it4.next();
                                iArr = new int[10];
                                iArr = new int[]{4090, 4091, 4092, 4093, 4094, 4095, LZMA2Options.DICT_SIZE_MIN, 4097, 4098, 4099};
                                length = iArr.length;
                                i = 0;
                                while (i < length) {
                                    headerOffset = iArr[i];
                                    test = true;
                                    fileBytes.position(oatFunc.codeOffset + headerOffset);
                                    for (byte current : pattern.origByte) {
                                        if (fileBytes.get() != current) {
                                            test = false;
                                        }
                                    }
                                    if (test) {
                                        fileBytes.position(oatFunc.codeOffset + headerOffset);
                                        fileBytes.put(pattern.repByte);
                                        fileBytes.force();
                                        if (paramArrayOfString[0].contains("patch")) {
                                            System.out.println("Oat Core1uni patched!\n");
                                        }
                                        if (paramArrayOfString[0].contains("restore")) {
                                            System.out.println("Oat Core1uni restored!\n");
                                        }
                                        patchOat1 = true;
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        }
                        ChannelDex.close();
                    }
                } catch (Exception e) {
                    try {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            if (!(patch_for_boot_aot && pattern2 && conscryptFound)) {
                if (patch_for_boot_aot && !conscryptFound) {
                    if (!(pattern1 || pattern2)) {
                    }
                }
            }
            final boolean cf = conscryptFound;
            final boolean z = pattern2;
            final boolean z2 = pattern1;
            oatDump = new Utils("").getOffsetOatdump(fileForPatch, new ArrayList<String>() {
            });
            System.out.println(oatDump.instruction);
            it3 = oatDump.funcArray.iterator();
            while (it3.hasNext()) {
                oatFunc = (OatFunc) it3.next();
                System.out.println(oatFunc.funcName);
                if (oatFunc.funcName.equals("boolean java.security.MessageDigest.isEqual(byte[], byte[])")) {
                    System.out.println(oatFunc.funcName);
                    System.out.println(oatFunc.codeOffset);
                    ChannelDex = new RandomAccessFile(fileForPatch, InternalZipConstants.WRITE_MODE).getChannel();
                    fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                    if (oatFunc.codeOffset != 0) {
                        it4 = new ArrayList<PatchesItem>() {
                            {
                                add(new PatchesItem(corepatch.byteOrig_patch2_arm, null, corepatch.byteReplace_patch2_arm, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch2_arm_1, null, corepatch.byteReplace_patch2_arm_1, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch2_arm64, null, corepatch.byteReplace_patch2_arm64, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch2_arm64_1, null, corepatch.byteReplace_patch2_arm64_1, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch2_arm64_2, null, corepatch.byteReplace_patch2_arm64_2, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch2_x86, null, corepatch.byteReplace_patch2_x86, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch2_x86_64, null, corepatch.byteReplace_patch2_x86_64, null, "", false));
                            }
                        }.iterator();
                        while (it4.hasNext()) {
                            pattern = (PatchesItem) it4.next();
                            iArr = new int[10];
                            iArr = new int[]{4090, 4091, 4092, 4093, 4094, 4095, LZMA2Options.DICT_SIZE_MIN, 4097, 4098, 4099};
                            length = iArr.length;
                            i = 0;
                            while (i < length) {
                                headerOffset = iArr[i];
                                test = true;
                                fileBytes.position(oatFunc.codeOffset + headerOffset);
                                for (byte current2 : pattern.origByte) {
                                    if (fileBytes.get() != current2) {
                                        test = false;
                                    }
                                }
                                if (test) {
                                    fileBytes.position(oatFunc.codeOffset + headerOffset);
                                    fileBytes.put(pattern.repByte);
                                    fileBytes.force();
                                    if (paramArrayOfString[0].contains("patch")) {
                                        System.out.println("Oat Core2 patched!\n");
                                    }
                                    if (paramArrayOfString[0].contains("restore")) {
                                        System.out.println("Oat Core2 restored!\n");
                                    }
                                    patchOat2 = true;
                                } else {
                                    i++;
                                }
                            }
                        }
                    }
                    try {
                        ChannelDex.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                }
                if (oatFunc.funcName.equals("boolean com.android.org.conscrypt.OpenSSLSignature.engineVerify(byte[])")) {
                    System.out.println(oatFunc.funcName);
                    System.out.println(oatFunc.codeOffset);
                    ChannelDex = new RandomAccessFile(fileForPatch, InternalZipConstants.WRITE_MODE).getChannel();
                    fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, (long) ((int) ChannelDex.size()));
                    if (oatFunc.codeOffset != 0) {
                        it4 = new ArrayList<PatchesItem>() {
                            {
                                add(new PatchesItem(corepatch.byteOrig_patch1_arm, null, corepatch.byteReplace_patch1_arm, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch1_arm_1, null, corepatch.byteReplace_patch1_arm_1, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch1_arm64, null, corepatch.byteReplace_patch1_arm64, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch1_arm64_1, null, corepatch.byteReplace_patch1_arm64_1, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch1_arm64_2, null, corepatch.byteReplace_patch1_arm64_2, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch1_x86, null, corepatch.byteReplace_patch1_x86, null, "", false));
                            }
                        }.iterator();
                        while (it4.hasNext()) {
                            pattern = (PatchesItem) it4.next();
                            iArr = new int[10];
                            iArr = new int[]{4090, 4091, 4092, 4093, 4094, 4095, LZMA2Options.DICT_SIZE_MIN, 4097, 4098, 4099};
                            length = iArr.length;
                            i = 0;
                            while (i < length) {
                                headerOffset = iArr[i];
                                test = true;
                                fileBytes.position(oatFunc.codeOffset + headerOffset);
                                for (byte current22 : pattern.origByte) {
                                    if (fileBytes.get() != current22) {
                                        test = false;
                                    }
                                }
                                if (test) {
                                    fileBytes.position(oatFunc.codeOffset + headerOffset);
                                    fileBytes.put(pattern.repByte);
                                    fileBytes.force();
                                    if (paramArrayOfString[0].contains("patch")) {
                                        System.out.println("Oat Core1uni patched!\n");
                                    }
                                    if (paramArrayOfString[0].contains("restore")) {
                                        System.out.println("Oat Core1uni restored!\n");
                                    }
                                    patchOat1 = true;
                                } else {
                                    i++;
                                }
                            }
                        }
                    }
                    ChannelDex.close();
                }
            }
        }
        if ((patchOat1 || patchOat2) && count_oat_files == oatForPatch.size()) {
            if (onlyDalvik) {
            }
            if (listAppsFragment.api >= 24) {
                System.out.println("patched cache " + listAppsFragment.toolfilesdir + "/reboot");
                Utils.reboot();
            }
        }
    }

    static void patchWithOatDumpP3(File for_patch, String[] paramArrayOfString, boolean pattern3) {
        OatFuncDump oatDump = new Utils("").getOffsetOatdump(for_patch, new ArrayList<String>() {
            {
                add("int com.android.server.pm.PackageManagerService.compareSignatures(android.content.pm.Signature[], android.content.pm.Signature[])");
                add("void com.android.server.pm.PackageManagerService.checkDowngrade(android.content.pm.PackageParser$Package, android.content.pm.PackageInfoLite)");
                add("android.content.pm.PackageParser$Package com.android.server.pm.PackageManagerService.scanPackageDirtyLI(android.content.pm.PackageParser$Package, int, int, long, android.os.UserHandle)");
            }
        });
        System.out.println(oatDump.instruction);
        try {
            Iterator it = oatDump.funcArray.iterator();
            while (it.hasNext()) {
                FileChannel ChannelDex;
                Iterator it2;
                PatchesItem pattern;
                int[] headerOffsets;
                int length;
                int i;
                int headerOffset;
                boolean test;
                OatFunc oatFunc = (OatFunc) it.next();
                System.out.println(oatFunc.funcName);
                if (oatFunc.funcName.equals("int com.android.server.pm.PackageManagerService.compareSignatures(android.content.pm.Signature[], android.content.pm.Signature[])")) {
                    System.out.println(oatFunc.funcName);
                    System.out.println(oatFunc.codeOffset);
                    if (oatFunc.codeOffset != 0) {
                        ChannelDex = new RandomAccessFile(for_patch, InternalZipConstants.WRITE_MODE).getChannel();
                        fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, ChannelDex.size());
                        it2 = new ArrayList<PatchesItem>() {
                            {
                                add(new PatchesItem(corepatch.byteOrig_patch3_arm, null, corepatch.byteReplace_patch3_arm, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch3_arm64, null, corepatch.byteReplace_patch3_arm64, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch3_x86, null, corepatch.byteReplace_patch3_x86, null, "", false));
                            }
                        }.iterator();
                        while (it2.hasNext()) {
                            pattern = (PatchesItem) it2.next();
                            headerOffsets = new int[]{4090, 4091, 4092, 4093, 4094, 4095, LZMA2Options.DICT_SIZE_MIN, 4097, 4098, 4099};
                            length = headerOffsets.length;
                            i = 0;
                            while (i < length) {
                                headerOffset = headerOffsets[i];
                                test = true;
                                fileBytes.position(oatFunc.codeOffset + headerOffset);
                                for (byte current : pattern.origByte) {
                                    if (fileBytes.get() != current) {
                                        test = false;
                                    }
                                }
                                if (test) {
                                    fileBytes.position(oatFunc.codeOffset + headerOffset);
                                    fileBytes.put(pattern.repByte);
                                    fileBytes.force();
                                    if (paramArrayOfString[0].contains("patch")) {
                                        System.out.println("Core4 patched!\n");
                                    }
                                    if (paramArrayOfString[0].contains("restore")) {
                                        System.out.println("Core4 restored!\n");
                                    }
                                    patchOat1 = true;
                                } else {
                                    i++;
                                }
                            }
                        }
                        ChannelDex.close();
                    }
                }
                if (oatFunc.funcName.equals("void com.android.server.pm.PackageManagerService.checkDowngrade(android.content.pm.PackageParser$Package, android.content.pm.PackageInfoLite)")) {
                    System.out.println(oatFunc.funcName);
                    System.out.println(oatFunc.codeOffset);
                    if (oatFunc.codeOffset != 0) {
                        ChannelDex = new RandomAccessFile(for_patch, InternalZipConstants.WRITE_MODE).getChannel();
                        fileBytes = ChannelDex.map(MapMode.READ_WRITE, 0, ChannelDex.size());
                        it2 = new ArrayList<PatchesItem>() {
                            {
                                add(new PatchesItem(corepatch.byteOrig_patch3p_arm, null, corepatch.byteReplace_patch3p_arm, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch3p_arm64, null, corepatch.byteReplace_patch3p_arm64, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch3p_x86, null, corepatch.byteReplace_patch3p_x86, null, "", false));
                            }
                        }.iterator();
                        while (it2.hasNext()) {
                            pattern = (PatchesItem) it2.next();
                            headerOffsets = new int[]{4090, 4091, 4092, 4093, 4094, 4095, LZMA2Options.DICT_SIZE_MIN, 4097, 4098, 4099};
                            length = headerOffsets.length;
                            i = 0;
                            while (i < length) {
                                headerOffset = headerOffsets[i];
                                test = true;
                                fileBytes.position(oatFunc.codeOffset + headerOffset);
                                for (byte current2 : pattern.origByte) {
                                    if (fileBytes.get() != current2) {
                                        test = false;
                                    }
                                }
                                if (test) {
                                    fileBytes.position(oatFunc.codeOffset + headerOffset);
                                    fileBytes.put(pattern.repByte);
                                    fileBytes.force();
                                    if (paramArrayOfString[0].contains("patch")) {
                                        System.out.println("Core4 patched!InstallLocationPolice\n");
                                    }
                                    if (paramArrayOfString[0].contains("restore")) {
                                        System.out.println("Core4 restored!InstallLocationPolice\n");
                                    }
                                    patchOat2 = true;
                                } else {
                                    i++;
                                }
                            }
                        }
                        ChannelDex.close();
                    }
                }
                if (oatFunc.funcName.equals("android.content.pm.PackageParser$Package com.android.server.pm.PackageManagerService.scanPackageDirtyLI(android.content.pm.PackageParser$Package, int, int, long, android.os.UserHandle)")) {
                    System.out.println(oatFunc.funcName);
                    System.out.println(oatFunc.codeOffset);
                    System.out.println(oatFunc.codeSize);
                    if (oatFunc.codeOffset != 0) {
                        ChannelDex = new RandomAccessFile(for_patch, InternalZipConstants.WRITE_MODE).getChannel();
                        fileBytes = ChannelDex.map(MapMode.READ_WRITE, (long) (oatFunc.codeOffset + 4095), (long) oatFunc.codeSize);
                        while (fileBytes.hasRemaining()) {
                            int curentPos = fileBytes.position();
                            byte curentByte = fileBytes.get();
                            if (applyPatch(curentPos, curentByte, byteOrig_patch3cm_arm, mask_patch3cm_arm, byteReplace_patch3cm_arm, rep_mask_patch3cm_arm, pattern3)) {
                                if (paramArrayOfString[0].contains("patch")) {
                                    System.out.println("Core4 patched!FixForCM\n");
                                }
                                if (paramArrayOfString[0].contains("restore")) {
                                    System.out.println("Core4 restored!FixForCM\n");
                                }
                                patchOat6 = true;
                            }
                            if (applyPatch(curentPos, curentByte, byteOrig_patch3cm_arm64, mask_patch3cm_arm64, byteReplace_patch3cm_arm64, rep_mask_patch3cm_arm64, pattern3)) {
                                if (paramArrayOfString[0].contains("patch")) {
                                    System.out.println("Core4 patched!FixForCM\n");
                                }
                                if (paramArrayOfString[0].contains("restore")) {
                                    System.out.println("Core4 restored!FixForCM\n");
                                }
                                patchOat6 = true;
                            }
                            if (applyPatch(curentPos, curentByte, byteOrigSOat6, maskSOat6, byteReplaceSOat6, rep_maskSOat6, pattern3)) {
                                if (paramArrayOfString[0].contains("patch")) {
                                    System.out.println("Core4 patched!FixForCM\n");
                                }
                                if (paramArrayOfString[0].contains("restore")) {
                                    System.out.println("Core4 restored!FixForCM\n");
                                }
                                patchOat6 = true;
                            }
                            if (applyPatch(curentPos, curentByte, byteOrigSOat7, maskSOat7, byteReplaceSOat7, rep_maskSOat7, pattern3)) {
                                if (paramArrayOfString[0].contains("patch")) {
                                    System.out.println("Core4 patched!FixForCM\n");
                                }
                                if (paramArrayOfString[0].contains("restore")) {
                                    System.out.println("Core4 restored!FixForCM\n");
                                }
                                patchOat6 = true;
                            }
                            if (applyPatch(curentPos, curentByte, byteOrigSOat7_2, maskSOat7_2, byteReplaceSOat7_2, rep_maskSOat7_2, pattern3)) {
                                if (paramArrayOfString[0].contains("patch")) {
                                    System.out.println("Core4 patched!FixForCM\n");
                                }
                                if (paramArrayOfString[0].contains("restore")) {
                                    System.out.println("Core4 restored!FixForCM\n");
                                }
                                patchOat6 = true;
                            }
                            if (applyPatch(curentPos, curentByte, byteOrigSOat4, maskSOat4, byteReplaceSOat4, rep_maskSOat4, pattern3)) {
                                if (paramArrayOfString[0].contains("patch")) {
                                    System.out.println("Core4 patched!FixForCM\n");
                                }
                                if (paramArrayOfString[0].contains("restore")) {
                                    System.out.println("Core4 restored!FixForCM\n");
                                }
                                patchOat6 = true;
                            }
                            if (applyPatch(curentPos, curentByte, byteOrigSOat5, maskSOat5, byteReplaceSOat5, rep_maskSOat5, pattern3)) {
                                if (paramArrayOfString[0].contains("patch")) {
                                    System.out.println("Core4 patched!FixForCM\n");
                                }
                                if (paramArrayOfString[0].contains("restore")) {
                                    System.out.println("Core4 restored!FixForCM\n");
                                }
                                patchOat6 = true;
                            }
                            if (applyPatch(curentPos, curentByte, byteOrigSOat5_1, maskSOat5_1, byteReplaceSOat5_1, rep_maskSOat5_1, pattern3)) {
                                if (paramArrayOfString[0].contains("patch")) {
                                    System.out.println("Core4 patched!FixForCM\n");
                                }
                                if (paramArrayOfString[0].contains("restore")) {
                                    System.out.println("Core4 restored!FixForCM\n");
                                }
                                patchOat6 = true;
                            }
                            fileBytes.position(curentPos + 1);
                        }
                        ChannelDex.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
