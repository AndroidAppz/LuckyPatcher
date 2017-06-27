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
    public static final byte[] MAGIC;
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
    public static byte[] byteOrig_patch2_x86_2 = null;
    public static byte[] byteOrig_patch2_x86_64 = null;
    public static byte[] byteOrig_patch3_arm = null;
    public static byte[] byteOrig_patch3_arm64 = null;
    public static byte[] byteOrig_patch3_arm64_2 = null;
    public static byte[] byteOrig_patch3_arm_2 = null;
    public static byte[] byteOrig_patch3_x86 = null;
    public static byte[] byteOrig_patch3cm_arm = null;
    public static byte[] byteOrig_patch3cm_arm64 = null;
    public static byte[] byteOrig_patch3cm_arm64_2 = null;
    public static byte[] byteOrig_patch3p_arm = null;
    public static byte[] byteOrig_patch3p_arm64 = null;
    public static byte[] byteOrig_patch3p_arm_2 = null;
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
    public static byte[] byteReplace_patch2_x86_2 = null;
    public static byte[] byteReplace_patch2_x86_64 = null;
    public static byte[] byteReplace_patch3_arm = null;
    public static byte[] byteReplace_patch3_arm64 = null;
    public static byte[] byteReplace_patch3_arm64_2 = null;
    public static byte[] byteReplace_patch3_arm_2 = null;
    public static byte[] byteReplace_patch3_x86 = null;
    public static byte[] byteReplace_patch3cm_arm = null;
    public static byte[] byteReplace_patch3cm_arm64 = null;
    public static byte[] byteReplace_patch3cm_arm64_2 = null;
    public static byte[] byteReplace_patch3p_arm = null;
    public static byte[] byteReplace_patch3p_arm64 = null;
    public static byte[] byteReplace_patch3p_arm_2 = null;
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
    public static byte[] mask_patch2_x86_2 = null;
    public static byte[] mask_patch2_x86_64 = null;
    public static byte[] mask_patch3_arm = null;
    public static byte[] mask_patch3_arm64 = null;
    public static byte[] mask_patch3_arm64_2 = null;
    public static byte[] mask_patch3_arm_2 = null;
    public static byte[] mask_patch3_x86 = null;
    public static byte[] mask_patch3cm_arm = null;
    public static byte[] mask_patch3cm_arm64 = null;
    public static byte[] mask_patch3cm_arm64_2 = null;
    public static byte[] mask_patch3p_arm = null;
    public static byte[] mask_patch3p_arm64 = null;
    public static byte[] mask_patch3p_arm_2 = null;
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
    public static byte[] rep_mask_patch2_x86_2 = null;
    public static byte[] rep_mask_patch2_x86_64 = null;
    public static byte[] rep_mask_patch3_arm = null;
    public static byte[] rep_mask_patch3_arm64 = null;
    public static byte[] rep_mask_patch3_arm64_2 = null;
    public static byte[] rep_mask_patch3_arm_2 = null;
    public static byte[] rep_mask_patch3_x86 = null;
    public static byte[] rep_mask_patch3cm_arm = null;
    public static byte[] rep_mask_patch3cm_arm64 = null;
    public static byte[] rep_mask_patch3cm_arm64_2 = null;
    public static byte[] rep_mask_patch3p_arm = null;
    public static byte[] rep_mask_patch3p_arm64 = null;
    public static byte[] rep_mask_patch3p_arm_2 = null;
    public static byte[] rep_mask_patch3p_x86 = null;
    public static String toolfilesdir = "";

    class AnonymousClass4 extends ArrayList<String> {
        AnonymousClass4(boolean z, boolean z2, boolean z3) {
            if (z) {
                add("boolean java.security.MessageDigest.isEqual(byte[], byte[])");
            }
            if (!z2 && z3) {
                add("boolean com.android.org.conscrypt.OpenSSLSignature.engineVerify(byte[])");
            }
        }
    }

    static {
        byte[] bArr = new byte[8];
        bArr[0] = (byte) 100;
        bArr[1] = (byte) 101;
        bArr[2] = (byte) 121;
        bArr[3] = (byte) 10;
        bArr[4] = (byte) 48;
        bArr[5] = (byte) 51;
        bArr[6] = (byte) 53;
        MAGIC = bArr;
    }

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
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0872 }
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0872 }
        r7.println(r8);	 Catch:{ Exception -> 0x0872 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0872 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0872 }
        r7.println(r8);	 Catch:{ Exception -> 0x0872 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0872 }
        r8 = 2;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0872 }
        r7.println(r8);	 Catch:{ Exception -> 0x0872 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0872 }
        r8 = 3;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0872 }
        r7.println(r8);	 Catch:{ Exception -> 0x0872 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0872 }
        r8 = 4;
        r8 = r71[r8];	 Catch:{ Exception -> 0x0872 }
        r7.println(r8);	 Catch:{ Exception -> 0x0872 }
        r7 = 4;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0872 }
        if (r7 == 0) goto L_0x004e;
    L_0x0040:
        r7 = 4;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0872 }
        r8 = "OnlyDalvik";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0872 }
        if (r7 == 0) goto L_0x004e;
    L_0x004b:
        r7 = 1;
        onlyDalvik = r7;	 Catch:{ Exception -> 0x0872 }
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
        if (r7 == 0) goto L_0x086e;
    L_0x0190:
        r42 = new java.util.ArrayList;
        r42.<init>();
        r42.clear();
        if (r11 != 0) goto L_0x019c;
    L_0x019a:
        if (r18 == 0) goto L_0x0402;
    L_0x019c:
        r54 = new java.util.ArrayList;
        r54.<init>();
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x0897;
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
        if (r7 < r8) goto L_0x0878;
    L_0x0209:
        r7 = java.lang.System.out;
        r8 = "check cache";
        r7.println(r8);
        r7 = r54.size();
        if (r7 <= 0) goto L_0x0233;
    L_0x0216:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 24;
        if (r7 < r8) goto L_0x0233;
    L_0x021c:
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
    L_0x0233:
        r7 = r54.size();
        if (r7 <= 0) goto L_0x0353;
    L_0x0239:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 21;
        if (r7 < r8) goto L_0x0353;
    L_0x023f:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 23;
        if (r7 > r8) goto L_0x0353;
    L_0x0245:
        r7 = java.lang.System.out;
        r8 = "found cache";
        r7.println(r8);
        r30 = 0;
        r0 = r54;
        r1 = r71;
        r2 = r18;
        patchWithOatDumpP12(r0, r1, r11, r2);
        if (r11 == 0) goto L_0x025d;
    L_0x0259:
        r7 = patchOat1;
        if (r7 == 0) goto L_0x0263;
    L_0x025d:
        if (r18 == 0) goto L_0x0278;
    L_0x025f:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x0278;
    L_0x0263:
        r7 = patchOat1;
        if (r7 == 0) goto L_0x0268;
    L_0x0267:
        r11 = 0;
    L_0x0268:
        r7 = patchOat2;
        if (r7 == 0) goto L_0x026e;
    L_0x026c:
        r18 = 0;
    L_0x026e:
        r19 = r54.iterator();
    L_0x0272:
        r7 = r19.hasNext();
        if (r7 != 0) goto L_0x0919;
    L_0x0278:
        r7 = patchOatUpd1;
        if (r7 != 0) goto L_0x0288;
    L_0x027c:
        r7 = patchOat1;
        if (r7 != 0) goto L_0x0288;
    L_0x0280:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x0288;
    L_0x0284:
        r7 = patchOat3;
        if (r7 == 0) goto L_0x0353;
    L_0x0288:
        r7 = r54.size();
        r0 = r30;
        if (r0 != r7) goto L_0x0353;
    L_0x0290:
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x0334;
    L_0x0294:
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
    L_0x0334:
        r7 = java.lang.System.out;
        r8 = new java.lang.StringBuilder;
        r9 = "patched cache ";
        r8.<init>(r9);
        r9 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.toolfilesdir;
        r8 = r8.append(r9);
        r9 = "/reboot";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.println(r8);
        com.chelpus.Utils.reboot();
    L_0x0353:
        r49 = 0;
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "framework";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x0f4f;
    L_0x0360:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "core.jar";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 != 0) goto L_0x0376;
    L_0x036b:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "core-libart.jar";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03ca;
    L_0x0376:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = com.chelpus.Utils.classes_test(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03ca;
    L_0x0384:
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = com.chelpus.Utils.getDirs(r64);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r7.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = com.chelpus.Utils.getDirs(r64);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/classes.dex";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03ca;
    L_0x03c3:
        r0 = r42;
        r1 = r26;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x03ca:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "core.odex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 != 0) goto L_0x03eb;
    L_0x03d5:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "core-libart.odex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 != 0) goto L_0x03eb;
    L_0x03e0:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "boot.oat";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03f8;
    L_0x03eb:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r42;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x03f8:
        r19 = r42.iterator();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x03fc:
        r7 = r19.hasNext();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 != 0) goto L_0x10ac;
    L_0x0402:
        if (r25 != 0) goto L_0x0406;
    L_0x0404:
        if (r62 == 0) goto L_0x086e;
    L_0x0406:
        r7 = java.lang.System.out;
        r8 = "Start patch for services.jar";
        r7.println(r8);
        r47 = "";
        r66 = "";
        r40 = "";
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x1f88;
    L_0x0417:
        r66 = "/system/framework";
        r40 = "/services.odex";
        r7 = new java.io.File;
        r8 = "/system/framework/arm/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x042a;
    L_0x0428:
        r47 = "/arm";
    L_0x042a:
        r7 = new java.io.File;
        r8 = "/system/framework/arm64/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x0439;
    L_0x0437:
        r47 = "/arm64";
    L_0x0439:
        r7 = new java.io.File;
        r8 = "/system/framework/x86/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x0448;
    L_0x0446:
        r47 = "/x86";
    L_0x0448:
        r7 = new java.io.File;
        r8 = "/system/framework/x86_64/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x0457;
    L_0x0455:
        r47 = "/x86_64";
    L_0x0457:
        r7 = new java.io.File;
        r8 = "/system/framework/arm/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x0466;
    L_0x0464:
        r47 = "/arm";
    L_0x0466:
        r7 = new java.io.File;
        r8 = "/system/framework/arm64/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x0475;
    L_0x0473:
        r47 = "/arm64";
    L_0x0475:
        r7 = new java.io.File;
        r8 = "/system/framework/x86/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x0484;
    L_0x0482:
        r47 = "/x86";
    L_0x0484:
        r7 = new java.io.File;
        r8 = "/system/framework/x86_64/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x0493;
    L_0x0491:
        r47 = "/x86_64";
    L_0x0493:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/arm/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x04a2;
    L_0x04a0:
        r47 = "/oat/arm";
    L_0x04a2:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/arm64/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x04b1;
    L_0x04af:
        r47 = "/oat/arm64";
    L_0x04b1:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/x86/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x04c0;
    L_0x04be:
        r47 = "/oat/x86";
    L_0x04c0:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/x86_64/services.odex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x04cf;
    L_0x04cd:
        r47 = "/oat/x86_64";
    L_0x04cf:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/arm/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x04de;
    L_0x04dc:
        r47 = "/oat/arm";
    L_0x04de:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/arm64/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x04ed;
    L_0x04eb:
        r47 = "/oat/arm64";
    L_0x04ed:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/x86/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x04fc;
    L_0x04fa:
        r47 = "/oat/x86";
    L_0x04fc:
        r7 = new java.io.File;
        r8 = "/system/framework/oat/x86_64/services.odex.xz";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x050b;
    L_0x0509:
        r47 = "/oat/x86_64";
    L_0x050b:
        r7 = "";
        r0 = r47;
        r7 = r0.equals(r7);
        if (r7 != 0) goto L_0x0638;
    L_0x0515:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 24;
        if (r7 < r8) goto L_0x0638;
    L_0x051b:
        r4 = 0;
        r43 = new java.io.File;
        r7 = new java.lang.StringBuilder;
        r8 = java.lang.String.valueOf(r66);
        r7.<init>(r8);
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
        r9 = java.lang.String.valueOf(r66);
        r8.<init>(r9);
        r0 = r47;
        r8 = r8.append(r0);
        r9 = "/services.odex.xz";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x05c8;
    L_0x0562:
        r7 = java.lang.System.out;
        r8 = "try unpack services.odex.xz";
        r7.println(r8);
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r9 = java.lang.String.valueOf(r66);
        r8.<init>(r9);
        r0 = r47;
        r8 = r8.append(r0);
        r9 = "/services.odex.xz";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r8 = new java.lang.StringBuilder;
        r9 = "/system/framework";
        r8.<init>(r9);
        r0 = r47;
        r8 = r8.append(r0);
        r8 = r8.toString();
        r7 = com.chelpus.Utils.XZDecompress(r7, r8);
        if (r7 != 0) goto L_0x2022;
    L_0x059e:
        r46 = 0;
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r9 = java.lang.String.valueOf(r66);
        r8.<init>(r9);
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
    L_0x05c8:
        if (r46 == 0) goto L_0x20a8;
    L_0x05ca:
        if (r25 == 0) goto L_0x20a8;
    L_0x05cc:
        r0 = r43;
        r1 = r71;
        r2 = r25;
        patchWithOatDumpP3(r0, r1, r2);
    L_0x05d5:
        r7 = patchOat1;
        if (r7 != 0) goto L_0x05e1;
    L_0x05d9:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x05e1;
    L_0x05dd:
        r7 = patchOat6;
        if (r7 == 0) goto L_0x0638;
    L_0x05e1:
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x0635;
    L_0x05e5:
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
    L_0x0635:
        com.chelpus.Utils.reboot();
    L_0x0638:
        r7 = "";
        r0 = r47;
        r7 = r0.equals(r7);
        if (r7 != 0) goto L_0x07e0;
    L_0x0642:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 21;
        if (r7 < r8) goto L_0x07e0;
    L_0x0648:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;
        r8 = 23;
        if (r7 > r8) goto L_0x07e0;
    L_0x064e:
        r4 = 0;
        r43 = new java.io.File;
        r7 = new java.lang.StringBuilder;
        r8 = java.lang.String.valueOf(r66);
        r7.<init>(r8);
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
        r9 = java.lang.String.valueOf(r66);
        r8.<init>(r9);
        r0 = r47;
        r8 = r8.append(r0);
        r9 = "/services.odex.xz";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x06fb;
    L_0x0695:
        r7 = java.lang.System.out;
        r8 = "try unpack services.odex.xz";
        r7.println(r8);
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r9 = java.lang.String.valueOf(r66);
        r8.<init>(r9);
        r0 = r47;
        r8 = r8.append(r0);
        r9 = "/services.odex.xz";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r8 = new java.lang.StringBuilder;
        r9 = "/system/framework";
        r8.<init>(r9);
        r0 = r47;
        r8 = r8.append(r0);
        r8 = r8.toString();
        r7 = com.chelpus.Utils.XZDecompress(r7, r8);
        if (r7 != 0) goto L_0x20b1;
    L_0x06d1:
        r46 = 0;
        r7 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r9 = java.lang.String.valueOf(r66);
        r8.<init>(r9);
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
    L_0x06fb:
        if (r46 == 0) goto L_0x2845;
    L_0x06fd:
        r0 = r43;
        r1 = r71;
        r2 = r25;
        patchWithOatDumpP3(r0, r1, r2);
        r7 = patchOat1;
        if (r7 != 0) goto L_0x070c;
    L_0x070a:
        if (r25 != 0) goto L_0x0712;
    L_0x070c:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x077d;
    L_0x0710:
        if (r25 == 0) goto L_0x077d;
    L_0x0712:
        r7 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x2836 }
        r8 = "rw";
        r0 = r43;
        r7.<init>(r0, r8);	 Catch:{ IOException -> 0x2836 }
        r4 = r7.getChannel();	 Catch:{ IOException -> 0x2836 }
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ IOException -> 0x2836 }
        r14 = 0;
        r8 = r4.size();	 Catch:{ IOException -> 0x2836 }
        r7 = (int) r8;	 Catch:{ IOException -> 0x2836 }
        r0 = (long) r7;	 Catch:{ IOException -> 0x2836 }
        r16 = r0;
        r12 = r4;
        r7 = r12.map(r13, r14, r16);	 Catch:{ IOException -> 0x2836 }
        fileBytes = r7;	 Catch:{ IOException -> 0x2836 }
        r7 = fileBytes;	 Catch:{ IOException -> 0x2836 }
        r8 = 4120; // 0x1018 float:5.773E-42 double:2.0356E-320;
        r7.position(r8);	 Catch:{ IOException -> 0x2836 }
        r7 = fileBytes;	 Catch:{ IOException -> 0x2836 }
        r7 = r7.get();	 Catch:{ IOException -> 0x2836 }
        r8 = fileBytes;	 Catch:{ IOException -> 0x2836 }
        r8 = r8.get();	 Catch:{ IOException -> 0x2836 }
        r9 = fileBytes;	 Catch:{ IOException -> 0x2836 }
        r9 = r9.get();	 Catch:{ IOException -> 0x2836 }
        r10 = fileBytes;	 Catch:{ IOException -> 0x2836 }
        r10 = r10.get();	 Catch:{ IOException -> 0x2836 }
        r63 = com.chelpus.Utils.convertFourBytesToInt(r7, r8, r9, r10);	 Catch:{ IOException -> 0x2836 }
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x2836 }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x2836 }
        r9 = "Start position:";
        r8.<init>(r9);	 Catch:{ IOException -> 0x2836 }
        r0 = r63;
        r8 = r8.append(r0);	 Catch:{ IOException -> 0x2836 }
        r8 = r8.toString();	 Catch:{ IOException -> 0x2836 }
        r7.println(r8);	 Catch:{ IOException -> 0x2836 }
        r7 = fileBytes;	 Catch:{ IOException -> 0x2836 }
        r0 = r63;
        r7.position(r0);	 Catch:{ IOException -> 0x2836 }
    L_0x0772:
        r7 = fileBytes;	 Catch:{ Exception -> 0x281f }
        r7 = r7.hasRemaining();	 Catch:{ Exception -> 0x281f }
        if (r7 != 0) goto L_0x2137;
    L_0x077a:
        r4.close();	 Catch:{ IOException -> 0x2836 }
    L_0x077d:
        r7 = patchOat1;
        if (r7 != 0) goto L_0x0789;
    L_0x0781:
        r7 = patchOat2;
        if (r7 != 0) goto L_0x0789;
    L_0x0785:
        r7 = patchOat6;
        if (r7 == 0) goto L_0x07e0;
    L_0x0789:
        r7 = onlyDalvik;
        if (r7 != 0) goto L_0x07dd;
    L_0x078d:
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
    L_0x07dd:
        com.chelpus.Utils.reboot();
    L_0x07e0:
        r49 = 0;
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "framework";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x284e;
    L_0x07ed:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "services.jar";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x084c;
    L_0x07f8:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = com.chelpus.Utils.classes_test(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x084c;
    L_0x0806:
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = com.chelpus.Utils.getDirs(r64);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = r7.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = com.chelpus.Utils.getDirs(r64);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "/classes.dex";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x084c;
    L_0x0845:
        r0 = r42;
        r1 = r26;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x084c:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "services.odex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x0864;
    L_0x0857:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r42;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x0864:
        r7 = r42.iterator();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x0868:
        r8 = r7.hasNext();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 != 0) goto L_0x29ce;
    L_0x086e:
        com.chelpus.Utils.exitFromRootJava();
        return;
    L_0x0872:
        r38 = move-exception;
        r38.printStackTrace();
        goto L_0x004e;
    L_0x0878:
        r55 = r56[r7];
        r9 = new java.io.File;
        r0 = r55;
        r9.<init>(r0);
        r9 = r9.exists();
        if (r9 == 0) goto L_0x0893;
    L_0x0887:
        r9 = new java.io.File;
        r0 = r55;
        r9.<init>(r0);
        r0 = r54;
        r0.add(r9);
    L_0x0893:
        r7 = r7 + 1;
        goto L_0x0207;
    L_0x0897:
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
    L_0x08f9:
        if (r7 >= r8) goto L_0x0209;
    L_0x08fb:
        r55 = r56[r7];
        r9 = new java.io.File;
        r0 = r55;
        r9.<init>(r0);
        r9 = r9.exists();
        if (r9 == 0) goto L_0x0916;
    L_0x090a:
        r9 = new java.io.File;
        r0 = r55;
        r9.<init>(r0);
        r0 = r54;
        r0.add(r9);
    L_0x0916:
        r7 = r7 + 1;
        goto L_0x08f9;
    L_0x0919:
        r39 = r19.next();
        r39 = (java.io.File) r39;
        r30 = r30 + 1;
        r7 = java.lang.System.out;
        r8 = new java.lang.StringBuilder;
        r9 = "oat file for patch:";
        r8.<init>(r9);
        r9 = r39.getAbsolutePath();
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.println(r8);
        r4 = 0;
        r70 = 0;
        r57 = 0;
        r58 = 0;
        r59 = 0;
        r68 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x09ce }
        r7 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x09ce }
        r8 = "rw";
        r0 = r39;
        r7.<init>(r0, r8);	 Catch:{ IOException -> 0x09ce }
        r4 = r7.getChannel();	 Catch:{ IOException -> 0x09ce }
        r5 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ IOException -> 0x09ce }
        r6 = 0;
        r8 = r4.size();	 Catch:{ IOException -> 0x09ce }
        r8 = (int) r8;	 Catch:{ IOException -> 0x09ce }
        r8 = (long) r8;	 Catch:{ IOException -> 0x09ce }
        r7 = r4.map(r5, r6, r8);	 Catch:{ IOException -> 0x09ce }
        fileBytes = r7;	 Catch:{ IOException -> 0x09ce }
        r7 = fileBytes;	 Catch:{ IOException -> 0x09ce }
        r8 = 4120; // 0x1018 float:5.773E-42 double:2.0356E-320;
        r7.position(r8);	 Catch:{ IOException -> 0x09ce }
        r7 = fileBytes;	 Catch:{ IOException -> 0x09ce }
        r7 = r7.get();	 Catch:{ IOException -> 0x09ce }
        r8 = fileBytes;	 Catch:{ IOException -> 0x09ce }
        r8 = r8.get();	 Catch:{ IOException -> 0x09ce }
        r9 = fileBytes;	 Catch:{ IOException -> 0x09ce }
        r9 = r9.get();	 Catch:{ IOException -> 0x09ce }
        r10 = fileBytes;	 Catch:{ IOException -> 0x09ce }
        r10 = r10.get();	 Catch:{ IOException -> 0x09ce }
        r63 = com.chelpus.Utils.convertFourBytesToInt(r7, r8, r9, r10);	 Catch:{ IOException -> 0x09ce }
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x09ce }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x09ce }
        r9 = "Start position:";
        r8.<init>(r9);	 Catch:{ IOException -> 0x09ce }
        r0 = r63;
        r8 = r8.append(r0);	 Catch:{ IOException -> 0x09ce }
        r8 = r8.toString();	 Catch:{ IOException -> 0x09ce }
        r7.println(r8);	 Catch:{ IOException -> 0x09ce }
        r7 = fileBytes;	 Catch:{ IOException -> 0x09ce }
        r0 = r63;
        r7.position(r0);	 Catch:{ IOException -> 0x09ce }
        r67 = 0;
    L_0x09a5:
        r7 = fileBytes;	 Catch:{ Exception -> 0x0f38 }
        r7 = r7.hasRemaining();	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x09af;
    L_0x09ad:
        if (r67 == 0) goto L_0x09d4;
    L_0x09af:
        r4.close();	 Catch:{ IOException -> 0x09ce }
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x09ce }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x09ce }
        r9 = "time=";
        r8.<init>(r9);	 Catch:{ IOException -> 0x09ce }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x09ce }
        r12 = r12 - r68;
        r8 = r8.append(r12);	 Catch:{ IOException -> 0x09ce }
        r8 = r8.toString();	 Catch:{ IOException -> 0x09ce }
        r7.println(r8);	 Catch:{ IOException -> 0x09ce }
        goto L_0x0272;
    L_0x09ce:
        r38 = move-exception;
        r38.printStackTrace();
        goto L_0x0272;
    L_0x09d4:
        r7 = fileBytes;	 Catch:{ Exception -> 0x0f38 }
        r5 = r7.position();	 Catch:{ Exception -> 0x0f38 }
        r7 = fileBytes;	 Catch:{ Exception -> 0x0f38 }
        r6 = r7.get();	 Catch:{ Exception -> 0x0f38 }
        r7 = byteOrigOatUpd1;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOatUpd1;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOatUpd1;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOatUpd1;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0a2f;
    L_0x09ee:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0a14;
    L_0x09f9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0a14:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0a26;
    L_0x0a1f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0a26:
        r7 = 1;
        patchOatUpd1 = r7;	 Catch:{ Exception -> 0x0f38 }
        r70 = 1;
        r57 = 1;
        r58 = 1;
    L_0x0a2f:
        r7 = byteOrigOatUpd2;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOatUpd2;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOatUpd2;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOatUpd2;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0a7e;
    L_0x0a3d:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0a63;
    L_0x0a48:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0a63:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0a75;
    L_0x0a6e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0a75:
        r7 = 1;
        patchOatUpd1 = r7;	 Catch:{ Exception -> 0x0f38 }
        r70 = 1;
        r57 = 1;
        r58 = 1;
    L_0x0a7e:
        r7 = byteOrigOat1;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOat1;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOat1;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOat1;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0ac9;
    L_0x0a8c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0ab2;
    L_0x0a97:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core11 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0ab2:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0ac4;
    L_0x0abd:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core11 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0ac4:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x0f38 }
        r57 = 1;
    L_0x0ac9:
        r7 = byteOrigOatUpd4;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOatUpd4;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOatUpd4;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOatUpd4;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0b18;
    L_0x0ad7:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0afd;
    L_0x0ae2:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0afd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0b0f;
    L_0x0b08:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0b0f:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x0f38 }
        r57 = 1;
        r58 = 1;
        r70 = 1;
    L_0x0b18:
        r7 = byteOrigOatUpd4_1;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOatUpd4_1;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOatUpd4_1;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOatUpd4_1;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0b67;
    L_0x0b26:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0b4c;
    L_0x0b31:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0b4c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0b5e;
    L_0x0b57:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0b5e:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x0f38 }
        r57 = 1;
        r58 = 1;
        r70 = 1;
    L_0x0b67:
        r7 = byteOrigOatUpd5;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOatUpd5;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOatUpd5;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOatUpd5;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0bb6;
    L_0x0b75:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0b9b;
    L_0x0b80:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0b9b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0bad;
    L_0x0ba6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0bad:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x0f38 }
        r70 = 1;
        r57 = 1;
        r58 = 1;
    L_0x0bb6:
        r7 = byteOrigOatUpd5_1;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOatUpd5_1;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOatUpd5_1;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOatUpd5_1;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0c05;
    L_0x0bc4:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0bea;
    L_0x0bcf:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0bea:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0bfc;
    L_0x0bf5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0bfc:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x0f38 }
        r70 = 1;
        r57 = 1;
        r58 = 1;
    L_0x0c05:
        r7 = byteOrigOat4;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOat4;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOat4;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOat4;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0c50;
    L_0x0c13:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0c39;
    L_0x0c1e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core11 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0c39:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0c4b;
    L_0x0c44:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core11 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0c4b:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x0f38 }
        r57 = 1;
    L_0x0c50:
        r7 = byteOrigOat2;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOat2;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOat2;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOat2;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0c9b;
    L_0x0c5e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0c84;
    L_0x0c69:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core12 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0c84:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0c96;
    L_0x0c8f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core12 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0c96:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x0f38 }
        r58 = 1;
    L_0x0c9b:
        r7 = byteOrigOat5;	 Catch:{ Exception -> 0x0f38 }
        r8 = maskOat5;	 Catch:{ Exception -> 0x0f38 }
        r9 = byteReplaceOat5;	 Catch:{ Exception -> 0x0f38 }
        r10 = rep_maskOat5;	 Catch:{ Exception -> 0x0f38 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0ce6;
    L_0x0ca9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0ccf;
    L_0x0cb4:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core12 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0ccf:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0ce1;
    L_0x0cda:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core12 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0ce1:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x0f38 }
        r58 = 1;
    L_0x0ce6:
        r14 = byteOrigOat3;	 Catch:{ Exception -> 0x0f38 }
        r15 = maskOat3;	 Catch:{ Exception -> 0x0f38 }
        r16 = byteReplaceOat3;	 Catch:{ Exception -> 0x0f38 }
        r17 = rep_maskOat3;	 Catch:{ Exception -> 0x0f38 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0d33;
    L_0x0cf6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0d1c;
    L_0x0d01:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0d1c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0d2e;
    L_0x0d27:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0d2e:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x0f38 }
        r59 = 1;
    L_0x0d33:
        r14 = byteOrigOat3_1;	 Catch:{ Exception -> 0x0f38 }
        r15 = maskOat3_1;	 Catch:{ Exception -> 0x0f38 }
        r16 = byteReplaceOat3_1;	 Catch:{ Exception -> 0x0f38 }
        r17 = rep_maskOat3_1;	 Catch:{ Exception -> 0x0f38 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0d80;
    L_0x0d43:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0d69;
    L_0x0d4e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0d69:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0d7b;
    L_0x0d74:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0d7b:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x0f38 }
        r59 = 1;
    L_0x0d80:
        r14 = byteOrigOat3_2;	 Catch:{ Exception -> 0x0f38 }
        r15 = maskOat3_2;	 Catch:{ Exception -> 0x0f38 }
        r16 = byteReplaceOat3_2;	 Catch:{ Exception -> 0x0f38 }
        r17 = rep_maskOat3_2;	 Catch:{ Exception -> 0x0f38 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0dcd;
    L_0x0d90:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0db6;
    L_0x0d9b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0db6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0dc8;
    L_0x0dc1:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0dc8:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x0f38 }
        r59 = 1;
    L_0x0dcd:
        r14 = byteOrigOat6;	 Catch:{ Exception -> 0x0f38 }
        r15 = maskOat6;	 Catch:{ Exception -> 0x0f38 }
        r16 = byteReplaceOat6;	 Catch:{ Exception -> 0x0f38 }
        r17 = rep_maskOat6;	 Catch:{ Exception -> 0x0f38 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0e1a;
    L_0x0ddd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0e03;
    L_0x0de8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0e03:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0e15;
    L_0x0e0e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0e15:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x0f38 }
        r59 = 1;
    L_0x0e1a:
        r14 = byteOrigOat6_1;	 Catch:{ Exception -> 0x0f38 }
        r15 = maskOat6_1;	 Catch:{ Exception -> 0x0f38 }
        r16 = byteReplaceOat6_1;	 Catch:{ Exception -> 0x0f38 }
        r17 = rep_maskOat6_1;	 Catch:{ Exception -> 0x0f38 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0e67;
    L_0x0e2a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0e50;
    L_0x0e35:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0e50:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0e62;
    L_0x0e5b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0e62:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x0f38 }
        r59 = 1;
    L_0x0e67:
        r14 = byteOrigOat7;	 Catch:{ Exception -> 0x0f38 }
        r15 = maskOat7;	 Catch:{ Exception -> 0x0f38 }
        r16 = byteReplaceOat7;	 Catch:{ Exception -> 0x0f38 }
        r17 = rep_maskOat7;	 Catch:{ Exception -> 0x0f38 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0eb4;
    L_0x0e77:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0e9d;
    L_0x0e82:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0e9d:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0eaf;
    L_0x0ea8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0eaf:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x0f38 }
        r59 = 1;
    L_0x0eb4:
        r14 = byteOrigOat7_1;	 Catch:{ Exception -> 0x0f38 }
        r15 = maskOat7_1;	 Catch:{ Exception -> 0x0f38 }
        r16 = byteReplaceOat7_1;	 Catch:{ Exception -> 0x0f38 }
        r17 = rep_maskOat7_1;	 Catch:{ Exception -> 0x0f38 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0f01;
    L_0x0ec4:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0eea;
    L_0x0ecf:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0f38 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0f38 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0f38 }
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0eea:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x0f38 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x0f38 }
        if (r7 == 0) goto L_0x0efc;
    L_0x0ef5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x0f38 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x0f38 }
    L_0x0efc:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x0f38 }
        r59 = 1;
    L_0x0f01:
        if (r11 == 0) goto L_0x0f09;
    L_0x0f03:
        if (r18 == 0) goto L_0x0f09;
    L_0x0f05:
        if (r70 == 0) goto L_0x0f09;
    L_0x0f07:
        if (r59 != 0) goto L_0x0f2b;
    L_0x0f09:
        if (r11 == 0) goto L_0x0f15;
    L_0x0f0b:
        if (r18 == 0) goto L_0x0f15;
    L_0x0f0d:
        if (r70 == 0) goto L_0x0f15;
    L_0x0f0f:
        if (r57 == 0) goto L_0x0f15;
    L_0x0f11:
        if (r58 == 0) goto L_0x0f15;
    L_0x0f13:
        if (r59 != 0) goto L_0x0f2b;
    L_0x0f15:
        if (r11 == 0) goto L_0x0f1b;
    L_0x0f17:
        if (r18 != 0) goto L_0x0f1b;
    L_0x0f19:
        if (r70 != 0) goto L_0x0f2b;
    L_0x0f1b:
        if (r11 == 0) goto L_0x0f25;
    L_0x0f1d:
        if (r18 != 0) goto L_0x0f25;
    L_0x0f1f:
        if (r70 == 0) goto L_0x0f25;
    L_0x0f21:
        if (r57 == 0) goto L_0x0f25;
    L_0x0f23:
        if (r58 != 0) goto L_0x0f2b;
    L_0x0f25:
        if (r11 != 0) goto L_0x0f2f;
    L_0x0f27:
        if (r18 == 0) goto L_0x0f2f;
    L_0x0f29:
        if (r59 == 0) goto L_0x0f2f;
    L_0x0f2b:
        r67 = 1;
        goto L_0x09af;
    L_0x0f2f:
        r7 = fileBytes;	 Catch:{ Exception -> 0x0f38 }
        r8 = r5 + 1;
        r7.position(r8);	 Catch:{ Exception -> 0x0f38 }
        goto L_0x09a5;
    L_0x0f38:
        r38 = move-exception;
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x09ce }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x09ce }
        r8.<init>();	 Catch:{ IOException -> 0x09ce }
        r0 = r38;
        r8 = r8.append(r0);	 Catch:{ IOException -> 0x09ce }
        r8 = r8.toString();	 Catch:{ IOException -> 0x09ce }
        r7.println(r8);	 Catch:{ IOException -> 0x09ce }
        goto L_0x09af;
    L_0x0f4f:
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "ART";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x0fc3;
    L_0x0f5a:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/system/framework/core-libart.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x0f84;
    L_0x0f67:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/system/framework/core-libart.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r7.length();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 == 0) goto L_0x0f84;
    L_0x0f78:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/system/framework/core-libart.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r42;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x0f84:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/system/framework/core-libart.jar";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = com.chelpus.Utils.classes_test(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03f8;
    L_0x0f91:
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = "/system/framework/core-libart.jar";
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = "/data/app";
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = "/data/app/classes.dex";
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03f8;
    L_0x0fb0:
        r0 = r42;
        r1 = r26;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x03f8;
    L_0x0fb9:
        r53 = move-exception;
    L_0x0fba:
        r7 = java.lang.System.out;
        r8 = "Error: core.odex not found!\n\nPlease Odex core.jar and try again!";
        r7.println(r8);
        goto L_0x0402;
    L_0x0fc3:
        r7 = onlyDalvik;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x1003;
    L_0x0fc7:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = "OnlyDalvik: add for patch ";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = 1;
        r9 = r71[r9];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r52;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r52.exists();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        if (r7 != 0) goto L_0x0ff8;
    L_0x0fee:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
    L_0x0ff4:
        r53 = move-exception;
        r49 = r52;
        goto L_0x0fba;
    L_0x0ff8:
        r0 = r42;
        r1 = r52;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r49 = r52;
        goto L_0x03f8;
    L_0x1003:
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r52;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r52.exists();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        if (r7 != 0) goto L_0x1036;
    L_0x1013:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
    L_0x1019:
        r38 = move-exception;
        r49 = r52;
    L_0x101c:
        r7 = java.lang.System.out;
        r8 = new java.lang.StringBuilder;
        r9 = "Exception e";
        r8.<init>(r9);
        r9 = r38.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.println(r8);
        goto L_0x0402;
    L_0x1036:
        r7 = r52.toString();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r8 = "system@framework@core.jar@classes.dex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        if (r7 == 0) goto L_0x105e;
    L_0x1042:
        r28 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r7 = "/system/framework/core.odex";
        r0 = r28;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r7 = r28.exists();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        if (r7 == 0) goto L_0x105e;
    L_0x1051:
        r8 = r28.length();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 != 0) goto L_0x105e;
    L_0x105b:
        r28.delete();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
    L_0x105e:
        r0 = r42;
        r1 = r52;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r7 = r52.toString();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r8 = "/system/framework/core.odex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        if (r7 == 0) goto L_0x10a8;
    L_0x1071:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.api;	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r8 = 20;
        if (r7 >= r8) goto L_0x10a8;
    L_0x1077:
        r7 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.runtime;	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r8 = "ART";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        if (r7 != 0) goto L_0x10a8;
    L_0x1081:
        r28 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r7 = "/system/framework/core-libart.odex";
        r0 = r28;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r7 = r28.exists();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        if (r7 == 0) goto L_0x10a8;
    L_0x1090:
        r8 = r28.length();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 != 0) goto L_0x10a1;
    L_0x109a:
        r28.delete();	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
        r49 = r52;
        goto L_0x03f8;
    L_0x10a1:
        r0 = r42;
        r1 = r28;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x0ff4, Exception -> 0x1019 }
    L_0x10a8:
        r49 = r52;
        goto L_0x03f8;
    L_0x10ac:
        r45 = r19.next();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r45 = (java.io.File) r45;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r49 = r45;
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = "file for patch: ";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = " size:";
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r12 = r49.length();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.append(r12);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "rw";
        r0 = r49;
        r7.<init>(r0, r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r4 = r7.getChannel();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r14 = 0;
        r8 = r4.size();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = (int) r8;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = (long) r7;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r16 = r0;
        r12 = r4;
        r7 = r12.map(r13, r14, r16);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        fileBytes = r7;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r60 = 0;
        r7 = r49.getName();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "boot.oat";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 != 0) goto L_0x1719;
    L_0x1108:
        r44 = new java.util.ArrayList;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r44.<init>();	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r0 = r44;
        r1 = r49;
        r0.add(r1);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r0 = r44;
        r1 = r71;
        r2 = r18;
        patchWithOatDumpP12(r0, r1, r11, r2);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r11 == 0) goto L_0x1123;
    L_0x111f:
        r7 = patchOat1;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1129;
    L_0x1123:
        if (r18 == 0) goto L_0x1151;
    L_0x1125:
        r7 = patchOat2;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 != 0) goto L_0x1151;
    L_0x1129:
        r7 = patchOat1;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x112e;
    L_0x112d:
        r11 = 0;
    L_0x112e:
        r7 = patchOat2;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1134;
    L_0x1132:
        r18 = 0;
    L_0x1134:
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r14 = 0;
        r8 = r4.size();	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = (int) r8;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r0 = (long) r7;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r16 = r0;
        r12 = r4;
        r7 = r12.map(r13, r14, r16);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        fileBytes = r7;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r50 = 0;
    L_0x1149:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = r7.hasRemaining();	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 != 0) goto L_0x1267;
    L_0x1151:
        r4.close();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "framework";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x1cdb;
    L_0x115f:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/classes.dex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x11da;
    L_0x116b:
        r7 = 0;
        not_found_bytes_for_patch = r7;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        com.chelpus.Utils.fixadler(r49);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r60 == 0) goto L_0x1cd6;
    L_0x1173:
        r7 = 1;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = ".jar";
        r9 = "-patched.jar";
        r37 = r7.replace(r8, r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = 1;
        r65 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r37;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r41 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r41.<init>();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "add files";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = new com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r10 = com.chelpus.Utils.getDirs(r49);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r10 = r10.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9.<init>(r10);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r10 = "/";
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.<init>(r8, r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r41;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r65;
        r1 = r37;
        r2 = r41;
        com.chelpus.Utils.addFilesToZip(r0, r1, r2);	 Catch:{ Exception -> 0x1cc6, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1cc6, FileNotFoundException -> 0x0fb9 }
        r8 = "add files finish";
        r7.println(r8);	 Catch:{ Exception -> 0x1cc6, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1cc6, FileNotFoundException -> 0x0fb9 }
        r0 = r65;
        r7.<init>(r0);	 Catch:{ Exception -> 0x1cc6, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1cc6, FileNotFoundException -> 0x0fb9 }
    L_0x11da:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/core.odex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 != 0) goto L_0x11f2;
    L_0x11e6:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/core-libart.odex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x123e;
    L_0x11f2:
        r7 = 0;
        r0 = r49;
        com.chelpus.Utils.fixadlerOdex(r0, r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r60 == 0) goto L_0x123e;
    L_0x11fa:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/core.odex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x121c;
    L_0x1206:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = "/core.odex";
        r10 = "/core-patched.odex";
        r8 = r8.replace(r9, r10);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r49;
        r0.renameTo(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x121c:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/core-libart.odex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x123e;
    L_0x1228:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = "/core-libart.odex";
        r10 = "/core-libart-patched.odex";
        r8 = r8.replace(r9, r10);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r49;
        r0.renameTo(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x123e:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/boot.oat";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03fc;
    L_0x124a:
        if (r60 == 0) goto L_0x03fc;
    L_0x124c:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = "/boot.oat";
        r10 = "/boot-patched.oat";
        r8 = r8.replace(r9, r10);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r49;
        r0.renameTo(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x03fc;
    L_0x1264:
        r38 = move-exception;
        goto L_0x101c;
    L_0x1267:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r5 = r7.position();	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = fileBytes;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r6 = r7.get();	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = byteOrig2;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask2;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace2;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask2;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x12a7;
    L_0x1281:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1293;
    L_0x128c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1293:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x12a5;
    L_0x129e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x12a5:
        r60 = 1;
    L_0x12a7:
        r7 = byteOrig3;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask2;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace3;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask2;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x12db;
    L_0x12b5:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x12c7;
    L_0x12c0:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x12c7:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x12d9;
    L_0x12d2:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x12d9:
        r60 = 1;
    L_0x12db:
        r14 = byteOrig4;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r15 = mask4;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplace4;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r17 = rep_mask4;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1311;
    L_0x12eb:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x12fd;
    L_0x12f6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x12fd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x130f;
    L_0x1308:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x130f:
        r60 = 1;
    L_0x1311:
        r14 = byteOrig5;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r15 = mask5;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplace5;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r17 = rep_mask5;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1347;
    L_0x1321:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1333;
    L_0x132c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1333:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1345;
    L_0x133e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1345:
        r60 = 1;
    L_0x1347:
        r7 = byteOrig6;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask6;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace6;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask6;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x137b;
    L_0x1355:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1367;
    L_0x1360:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1367:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1379;
    L_0x1372:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1379:
        r60 = 1;
    L_0x137b:
        r7 = byteOrig7;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask7;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace7;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask7;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x13af;
    L_0x1389:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x139b;
    L_0x1394:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x139b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x13ad;
    L_0x13a6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x13ad:
        r60 = 1;
    L_0x13af:
        r7 = byteOrig8;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask8;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace8;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask8;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x13e3;
    L_0x13bd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x13cf;
    L_0x13c8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x13cf:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x13e1;
    L_0x13da:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x13e1:
        r60 = 1;
    L_0x13e3:
        r7 = byteOrig9;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask9;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace9;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask9;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1417;
    L_0x13f1:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1403;
    L_0x13fc:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1403:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1415;
    L_0x140e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1415:
        r60 = 1;
    L_0x1417:
        r7 = byteOrig10;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask10;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace10;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask10;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x144b;
    L_0x1425:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1437;
    L_0x1430:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1437:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1449;
    L_0x1442:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1449:
        r60 = 1;
    L_0x144b:
        r7 = byteOrig11;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask11;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace11;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask11;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x147f;
    L_0x1459:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x146b;
    L_0x1464:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x146b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x147d;
    L_0x1476:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x147d:
        r60 = 1;
    L_0x147f:
        r14 = byteOrig12;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r15 = mask12;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplace12;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r17 = rep_mask12;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x14b5;
    L_0x148f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x14a1;
    L_0x149a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x14a1:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x14b3;
    L_0x14ac:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x14b3:
        r60 = 1;
    L_0x14b5:
        r14 = byteOrig13;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r15 = mask13;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplace13;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r17 = rep_mask13;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x14eb;
    L_0x14c5:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x14d7;
    L_0x14d0:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x14d7:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x14e9;
    L_0x14e2:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x14e9:
        r60 = 1;
    L_0x14eb:
        r14 = byteOrig20;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r15 = mask20;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplace20;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r17 = rep_mask20;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1521;
    L_0x14fb:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x150d;
    L_0x1506:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x150d:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x151f;
    L_0x1518:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core unsigned install restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x151f:
        r60 = 1;
    L_0x1521:
        r7 = byteOrig21;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask21;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace21;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask21;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1555;
    L_0x152f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1541;
    L_0x153a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1541:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1553;
    L_0x154c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1553:
        r60 = 1;
    L_0x1555:
        r7 = byteOrig22;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask22;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace22;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask22;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1589;
    L_0x1563:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1575;
    L_0x156e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1575:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1587;
    L_0x1580:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1587:
        r60 = 1;
    L_0x1589:
        r7 = byteOrig14;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask14;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace14;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask14;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x15bd;
    L_0x1597:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x15a9;
    L_0x15a2:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x15a9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x15bb;
    L_0x15b4:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x15bb:
        r60 = 1;
    L_0x15bd:
        r7 = byteOrig15;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask15;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace15;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask15;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x15f1;
    L_0x15cb:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x15dd;
    L_0x15d6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x15dd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x15ef;
    L_0x15e8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x15ef:
        r60 = 1;
    L_0x15f1:
        r7 = byteOrig16;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask16;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace16;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask16;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1625;
    L_0x15ff:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1611;
    L_0x160a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1611:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1623;
    L_0x161c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1623:
        r60 = 1;
    L_0x1625:
        r7 = byteOrig17;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask17;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace17;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask17;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1659;
    L_0x1633:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1645;
    L_0x163e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1645:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1657;
    L_0x1650:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1657:
        r60 = 1;
    L_0x1659:
        r7 = byteOrig18;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask18;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace18;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask18;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x168d;
    L_0x1667:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1679;
    L_0x1672:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x1679:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x168b;
    L_0x1684:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x168b:
        r60 = 1;
    L_0x168d:
        r7 = byteOrig19;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask19;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace19;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask19;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x16c1;
    L_0x169b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x16ad;
    L_0x16a6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x16ad:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x16bf;
    L_0x16b8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x16bf:
        r60 = 1;
    L_0x16c1:
        r7 = byteOrig23;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = mask23;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplace23;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r10 = rep_mask23;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x16f5;
    L_0x16cf:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x16e1;
    L_0x16da:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x16e1:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x16f3;
    L_0x16ec:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = "Core 2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
    L_0x16f3:
        r60 = 1;
    L_0x16f5:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = r5 + 1;
        r7.position(r8);	 Catch:{ Exception -> 0x1702, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r50 = r50 + r8;
        goto L_0x1149;
    L_0x1702:
        r38 = move-exception;
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r38;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x1151;
    L_0x1719:
        r7 = fileBytes;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 4120; // 0x1018 float:5.773E-42 double:2.0356E-320;
        r7.position(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = fileBytes;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r7.get();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.get();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = fileBytes;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = r9.get();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r10 = fileBytes;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r10 = r10.get();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r63 = com.chelpus.Utils.convertFourBytesToInt(r7, r8, r9, r10);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r9 = "Start position:";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r63;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = fileBytes;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r63;
        r7.position(r0);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x1759:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = r7.hasRemaining();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1151;
    L_0x1761:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r5 = r7.position();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = fileBytes;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r6 = r7.get();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = byteOrigOatUpd1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOatUpd1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOatUpd1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOatUpd1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x17b8;
    L_0x177b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x17a1;
    L_0x1786:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x17a1:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x17b3;
    L_0x17ac:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x17b3:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x17b8:
        r7 = byteOrigOatUpd2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOatUpd2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOatUpd2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOatUpd2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1803;
    L_0x17c6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x17ec;
    L_0x17d1:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x17ec:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x17fe;
    L_0x17f7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x17fe:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1803:
        r7 = byteOrigOat1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOat1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOat1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOat1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x184e;
    L_0x1811:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1837;
    L_0x181c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core11 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1837:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1849;
    L_0x1842:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core11 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1849:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x184e:
        r7 = byteOrigOatUpd4;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOatUpd4;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOatUpd4;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOatUpd4;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1899;
    L_0x185c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1882;
    L_0x1867:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1882:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1894;
    L_0x188d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1894:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1899:
        r7 = byteOrigOatUpd4_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOatUpd4_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOatUpd4_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOatUpd4_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x18e4;
    L_0x18a7:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x18cd;
    L_0x18b2:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x18cd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x18df;
    L_0x18d8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x18df:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x18e4:
        r7 = byteOrigOatUpd5;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOatUpd5;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOatUpd5;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOatUpd5;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x192f;
    L_0x18f2:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1918;
    L_0x18fd:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1918:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x192a;
    L_0x1923:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x192a:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x192f:
        r7 = byteOrigOatUpd5_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOatUpd5_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOatUpd5_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOatUpd5_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x197a;
    L_0x193d:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1963;
    L_0x1948:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1963:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1975;
    L_0x196e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core1uni restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1975:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x197a:
        r7 = byteOrigOat4;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOat4;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOat4;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOat4;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x19c5;
    L_0x1988:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x19ae;
    L_0x1993:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core11 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x19ae:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x19c0;
    L_0x19b9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core11 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x19c0:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x19c5:
        r7 = byteOrigOat2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOat2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOat2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOat2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1a10;
    L_0x19d3:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x19f9;
    L_0x19de:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core12 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x19f9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1a0b;
    L_0x1a04:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core12 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1a0b:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1a10:
        r7 = byteOrigOat5;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = maskOat5;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = byteReplaceOat5;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r10 = rep_maskOat5;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = applyPatch(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1a5b;
    L_0x1a1e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1a44;
    L_0x1a29:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core12 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1a44:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1a56;
    L_0x1a4f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core12 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1a56:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1a5b:
        r14 = byteOrigOat3;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r15 = maskOat3;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplaceOat3;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r17 = rep_maskOat3;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1aa8;
    L_0x1a6b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1a91;
    L_0x1a76:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1a91:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1aa3;
    L_0x1a9c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1aa3:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1aa8:
        r14 = byteOrigOat3_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r15 = maskOat3_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplaceOat3_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r17 = rep_maskOat3_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1af5;
    L_0x1ab8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1ade;
    L_0x1ac3:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1ade:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1af0;
    L_0x1ae9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1af0:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1af5:
        r14 = byteOrigOat3_2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r15 = maskOat3_2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplaceOat3_2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r17 = rep_maskOat3_2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1b42;
    L_0x1b05:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1b2b;
    L_0x1b10:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1b2b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1b3d;
    L_0x1b36:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1b3d:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1b42:
        r14 = byteOrigOat6;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r15 = maskOat6;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplaceOat6;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r17 = rep_maskOat6;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1b8f;
    L_0x1b52:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1b78;
    L_0x1b5d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1b78:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1b8a;
    L_0x1b83:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1b8a:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1b8f:
        r14 = byteOrigOat6_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r15 = maskOat6_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplaceOat6_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r17 = rep_maskOat6_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1bdc;
    L_0x1b9f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1bc5;
    L_0x1baa:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1bc5:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1bd7;
    L_0x1bd0:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1bd7:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1bdc:
        r14 = byteOrigOat7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r15 = maskOat7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplaceOat7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r17 = rep_maskOat7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c29;
    L_0x1bec:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c12;
    L_0x1bf7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1c12:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c24;
    L_0x1c1d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1c24:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1c29:
        r14 = byteOrigOat7_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r15 = maskOat7_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r16 = byteReplaceOat7_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r17 = rep_maskOat7_1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r12 = r5;
        r13 = r6;
        r7 = applyPatch(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c76;
    L_0x1c39:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c5f;
    L_0x1c44:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r9 = "position:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1c5f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c71;
    L_0x1c6a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = "Oat Core2 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
    L_0x1c71:
        r7 = 1;
        patchOat3 = r7;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r60 = 1;
    L_0x1c76:
        if (r11 == 0) goto L_0x1c8a;
    L_0x1c78:
        r7 = patchOatUpd1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r7 = r7 & r18;
        if (r7 == 0) goto L_0x1c8a;
    L_0x1c7e:
        r7 = patchOat1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c8a;
    L_0x1c82:
        r7 = patchOat2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c8a;
    L_0x1c86:
        r7 = patchOat3;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 != 0) goto L_0x1ca2;
    L_0x1c8a:
        if (r11 == 0) goto L_0x1c9a;
    L_0x1c8c:
        if (r18 != 0) goto L_0x1c9a;
    L_0x1c8e:
        r7 = patchOatUpd1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c9a;
    L_0x1c92:
        r7 = patchOat1;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1c9a;
    L_0x1c96:
        r7 = patchOat2;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 != 0) goto L_0x1ca2;
    L_0x1c9a:
        if (r11 != 0) goto L_0x1ca6;
    L_0x1c9c:
        if (r18 == 0) goto L_0x1ca6;
    L_0x1c9e:
        r7 = patchOat3;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1ca6;
    L_0x1ca2:
        r60 = 1;
        goto L_0x1151;
    L_0x1ca6:
        r7 = fileBytes;	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        r8 = r5 + 1;
        r7.position(r8);	 Catch:{ Exception -> 0x1caf, FileNotFoundException -> 0x0fb9 }
        goto L_0x1759;
    L_0x1caf:
        r38 = move-exception;
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r38;
        r8 = r8.append(r0);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x1151;
    L_0x1cc6:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r37;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x11da;
    L_0x1cd6:
        r7 = 1;
        not_found_bytes_for_patch = r7;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x11da;
    L_0x1cdb:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/classes.dex";
        r7 = r7.endsWith(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x1ea9;
    L_0x1ce7:
        com.chelpus.Utils.fixadler(r49);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x1cea:
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "ART";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x1edb;
    L_0x1cf5:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/classes.dex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03fc;
    L_0x1d01:
        if (r60 == 0) goto L_0x03fc;
    L_0x1d03:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "start";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r37 = "/system/framework/core-libart.backup";
        r65 = "/system/framework/core-libart.jar";
        r7 = 1;
        r8 = 0;
        r0 = r65;
        r1 = r37;
        r7 = com.chelpus.Utils.copyFile(r0, r1, r7, r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x1ec8;
    L_0x1d1a:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "good space";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r37;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r41 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r41.<init>();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "add files";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = new com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/data/app/classes.dex";
        r9 = "/data/app/";
        r7.<init>(r8, r9);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r41;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = "/system/framework/core-libart.jar";
        r8 = "/system/framework/core-libart.backup";
        r0 = r41;
        com.chelpus.Utils.addFilesToZip(r7, r8, r0);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "add files finish";
        r7.println(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = "0644";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 2;
        r9 = "/system/framework/core-libart.backup";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = "0:0";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 2;
        r9 = "/system/framework/core-libart.backup";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = "0.0";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 2;
        r9 = "/system/framework/core-libart.backup";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = 2;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "rm";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/system/framework/core-libart.jar";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = r7.exists();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1dbb;
    L_0x1db1:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/system/framework/core-libart.jar";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
    L_0x1dbb:
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "mv";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = "/system/framework/core.backup";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 2;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/system/framework/core-libart.jar";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = r7.exists();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        if (r7 != 0) goto L_0x1dee;
    L_0x1ddd:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/system/framework/core-libart.backup";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r9 = "/system/framework/core-libart.jar";
        r8.<init>(r9);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.renameTo(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
    L_0x1dee:
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = "0644";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 2;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = "0:0";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 2;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = "0.0";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 2;
        r9 = "/system/framework/core-libart.jar";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = "/system/framework/core-libart.jar";
        r36 = com.chelpus.Utils.getFileDalvikCache(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        if (r36 == 0) goto L_0x1e50;
    L_0x1e35:
        r7 = 2;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 0;
        r9 = "rm";
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = 1;
        r9 = r36.getAbsolutePath();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = r36.exists();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        if (r7 == 0) goto L_0x1e50;
    L_0x1e4d:
        r36.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
    L_0x1e50:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/data/dalvik-cache/arm/system@framework@arm@boot.oat";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/data/dalvik-cache/arm/system@framework@arm@boot.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/data/dalvik-cache/arm64/system@framework@arm@boot.oat";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/data/dalvik-cache/arm64/system@framework@arm@boot.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/data/dalvik-cache/x86/system@framework@arm@boot.oat";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/data/dalvik-cache/x86/system@framework@arm@boot.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/data/dalvik-cache/x86_64/system@framework@arm@boot.oat";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r8 = "/data/dalvik-cache/x86_64/system@framework@arm@boot.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
        r7.delete();	 Catch:{ Exception -> 0x1eb2, FileNotFoundException -> 0x0fb9 }
    L_0x1ea0:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "finish";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x03fc;
    L_0x1ea9:
        r7 = "/system/framework/core.jar";
        r0 = r49;
        com.chelpus.Utils.fixadlerOdex(r0, r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x1cea;
    L_0x1eb2:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "/system/framework/core.backup";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x1ea0;
    L_0x1ec8:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r0 = r37;
        r7.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7.delete();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x03fc;
    L_0x1edb:
        r7 = onlyDalvik;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 != 0) goto L_0x03fc;
    L_0x1edf:
        r7 = r49.toString();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "system@framework@core.jar@classes.dex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x1f48;
    L_0x1eeb:
        if (r60 == 0) goto L_0x1f48;
    L_0x1eed:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "LuckyPatcher: dalvik-cache patched! ";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r29 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = "/system/framework/core.patched";
        r0 = r29;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r37 = "/system/framework/core.patched";
        r65 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = 1;
        r8 = 0;
        r0 = r65;
        r1 = r37;
        r7 = com.chelpus.Utils.copyFile(r0, r1, r7, r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x1f76;
    L_0x1f0f:
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 0;
        r9 = "chmod";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 1;
        r9 = "0644";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 2;
        r7[r8] = r37;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 1;
        r9 = "0.0";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 2;
        r7[r8] = r37;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = 3;
        r7 = new java.lang.String[r7];	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 0;
        r9 = "chown";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 1;
        r9 = "0:0";
        r7[r8] = r9;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = 2;
        r7[r8] = r37;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        com.chelpus.Utils.run_all_no_root(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x1f48:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = "/system/framework/core.patched";
        r0 = r27;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r27.exists();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x1f5e;
    L_0x1f57:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "LuckyPatcher: root found core.patched! ";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
    L_0x1f5e:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = "/system/framework/core.odex";
        r0 = r27;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = r27.exists();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        if (r7 == 0) goto L_0x03fc;
    L_0x1f6d:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "LuckyPatcher: root found core.odex! ";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x03fc;
    L_0x1f76:
        r29.delete();	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "LuckyPatcher: not space to system for odex core.jar! ";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x0fb9, Exception -> 0x1264 }
        goto L_0x1f48;
    L_0x1f88:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1f9b;
    L_0x1f95:
        r66 = "/data/dalvik-cache";
        r47 = "/arm";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x1f9b:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1fae;
    L_0x1fa8:
        r66 = "/data/dalvik-cache";
        r47 = "/arm64";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x1fae:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1fc1;
    L_0x1fbb:
        r66 = "/data/dalvik-cache";
        r47 = "/x86";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x1fc1:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1fd4;
    L_0x1fce:
        r66 = "/data/dalvik-cache";
        r47 = "/x86_64";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x1fd4:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/arm/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1fe7;
    L_0x1fe1:
        r66 = "/data/dalvik-cache/oat";
        r47 = "/arm";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x1fe7:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/arm64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x1ffa;
    L_0x1ff4:
        r66 = "/data/dalvik-cache/oat";
        r47 = "/arm64";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x1ffa:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/x86/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x200d;
    L_0x2007:
        r66 = "/data/dalvik-cache/oat";
        r47 = "/x86";
        r40 = "/system@framework@services.jar@classes.dex";
    L_0x200d:
        r7 = new java.io.File;
        r8 = "/data/dalvik-cache/oat/x86_64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);
        r7 = r7.exists();
        if (r7 == 0) goto L_0x050b;
    L_0x201a:
        r66 = "/data/dalvik-cache/oat";
        r47 = "/x86_64";
        r40 = "/system@framework@services.jar@classes.dex";
        goto L_0x050b;
    L_0x2022:
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
        r10 = java.lang.String.valueOf(r66);
        r9.<init>(r10);
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
        r10 = java.lang.String.valueOf(r66);
        r9.<init>(r10);
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
        r10 = java.lang.String.valueOf(r66);
        r9.<init>(r10);
        r0 = r47;
        r9 = r9.append(r0);
        r0 = r40;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r7[r8] = r9;
        com.chelpus.Utils.run_all_no_root(r7);
        goto L_0x05c8;
    L_0x20a8:
        r7 = java.lang.System.out;
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);
        goto L_0x05d5;
    L_0x20b1:
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
        r10 = java.lang.String.valueOf(r66);
        r9.<init>(r10);
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
        r10 = java.lang.String.valueOf(r66);
        r9.<init>(r10);
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
        r10 = java.lang.String.valueOf(r66);
        r9.<init>(r10);
        r0 = r47;
        r9 = r9.append(r0);
        r0 = r40;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r7[r8] = r9;
        com.chelpus.Utils.run_all_no_root(r7);
        goto L_0x06fb;
    L_0x2137:
        r7 = fileBytes;	 Catch:{ Exception -> 0x281f }
        r5 = r7.position();	 Catch:{ Exception -> 0x281f }
        r7 = fileBytes;	 Catch:{ Exception -> 0x281f }
        r6 = r7.get();	 Catch:{ Exception -> 0x281f }
        r21 = byteOrigSOat1;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat1;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat1;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat1;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x217c;
    L_0x2155:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2167;
    L_0x2160:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2167:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2179;
    L_0x2172:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2179:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x217c:
        r21 = byteOrigSOat1_1;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat1_1;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat1_1;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat1_1;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x21b5;
    L_0x218e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x21a0;
    L_0x2199:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x21a0:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x21b2;
    L_0x21ab:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x21b2:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x21b5:
        r21 = byteOrigSOat1_2;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat1_2;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat1_2;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat1_2;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x21ee;
    L_0x21c7:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x21d9;
    L_0x21d2:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x21d9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x21eb;
    L_0x21e4:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x21eb:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x21ee:
        r21 = byteOrigSOat2;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat2;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat2;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat2;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2227;
    L_0x2200:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2212;
    L_0x220b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2212:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2224;
    L_0x221d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2224:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2227:
        r21 = byteOrigSOat6_2;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat6_2;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat6_2;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat6_2;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2260;
    L_0x2239:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x224b;
    L_0x2244:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x224b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x225d;
    L_0x2256:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x225d:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2260:
        r21 = byteOrigSOat6_3;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat6_3;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat6_3;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat6_3;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2299;
    L_0x2272:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2284;
    L_0x227d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2284:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2296;
    L_0x228f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2296:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2299:
        r21 = byteOrigSOat6_4;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat6_4;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat6_4;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat6_4;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x22d2;
    L_0x22ab:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x22bd;
    L_0x22b6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x22bd:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x22cf;
    L_0x22c8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x22cf:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x22d2:
        r21 = byteOrigSOat6_5;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat6_5;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat6_5;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat6_5;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x230b;
    L_0x22e4:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x22f6;
    L_0x22ef:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x22f6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2308;
    L_0x2301:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2308:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x230b:
        r21 = byteOrigSOat3;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat3;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat3;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat3;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2344;
    L_0x231d:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x232f;
    L_0x2328:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x232f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2341;
    L_0x233a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2341:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2344:
        r21 = byteOrigSOat6;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat6;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat6;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat6;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x237d;
    L_0x2356:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2368;
    L_0x2361:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2368:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x237a;
    L_0x2373:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x237a:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x237d:
        r21 = byteOrigSOat7;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat7;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat7;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat7;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x23b6;
    L_0x238f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x23a1;
    L_0x239a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x23a1:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x23b3;
    L_0x23ac:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x23b3:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x23b6:
        r21 = byteOrigSOat7_2;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat7_2;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat7_2;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat7_2;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x23ef;
    L_0x23c8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x23da;
    L_0x23d3:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x23da:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x23ec;
    L_0x23e5:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x23ec:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x23ef:
        r21 = byteOrigSOat4;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat4;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat4;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat4;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2428;
    L_0x2401:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2413;
    L_0x240c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2413:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2425;
    L_0x241e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2425:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2428:
        r21 = byteOrigSOat5;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat5;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat5;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat5;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2461;
    L_0x243a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x244c;
    L_0x2445:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x244c:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x245e;
    L_0x2457:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x245e:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2461:
        r21 = byteOrigSOat5_1;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat5_1;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat5_1;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat5_1;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x249a;
    L_0x2473:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2485;
    L_0x247e:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2485:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2497;
    L_0x2490:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!FixForCM\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2497:
        r7 = 1;
        patchOat6 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x249a:
        r21 = byteOrigSOat8;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat8;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat8;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat8;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x24d3;
    L_0x24ac:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x24be;
    L_0x24b7:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x24be:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x24d0;
    L_0x24c9:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x24d0:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x24d3:
        r21 = byteOrigSOat8_1;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat8_1;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat8_1;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat8_1;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x250c;
    L_0x24e5:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x24f7;
    L_0x24f0:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x24f7:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2509;
    L_0x2502:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2509:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x250c:
        r21 = byteOrigSOat8_2;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat8_2;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat8_2;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat8_2;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2545;
    L_0x251e:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2530;
    L_0x2529:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2530:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2542;
    L_0x253b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2542:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2545:
        r21 = byteOrigSOat9;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat9;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat9;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat9;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x257e;
    L_0x2557:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2569;
    L_0x2562:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2569:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x257b;
    L_0x2574:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x257b:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x257e:
        r21 = byteOrigSOat9_1;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat9_1;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat9_1;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat9_1;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x25b7;
    L_0x2590:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x25a2;
    L_0x259b:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x25a2:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x25b4;
    L_0x25ad:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x25b4:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x25b7:
        r21 = byteOrigSOat9_3;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat9_3;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat9_3;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat9_3;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x25f0;
    L_0x25c9:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x25db;
    L_0x25d4:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x25db:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x25ed;
    L_0x25e6:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x25ed:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x25f0:
        r21 = byteOrigSOat9_2;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat9_2;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat9_2;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat9_2;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2629;
    L_0x2602:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2614;
    L_0x260d:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2614:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2626;
    L_0x261f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2626:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2629:
        r21 = byteOrigSOat12;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat12;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat12;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat12;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2662;
    L_0x263b:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x264d;
    L_0x2646:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x264d:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x265f;
    L_0x2658:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x265f:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2662:
        r21 = byteOrigSOat12_1;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat12_1;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat12_1;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat12_1;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x269b;
    L_0x2674:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2686;
    L_0x267f:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2686:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2698;
    L_0x2691:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!InstallLocationPolice\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2698:
        r7 = 1;
        patchOat2 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x269b:
        r21 = byteOrigSOat10;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat10;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat10;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat10;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x26d4;
    L_0x26ad:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x26bf;
    L_0x26b8:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x26bf:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x26d1;
    L_0x26ca:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x26d1:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x26d4:
        r21 = byteOrigSOat10_1;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat10_1;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat10_1;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat10_1;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x270d;
    L_0x26e6:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x26f8;
    L_0x26f1:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x26f8:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x270a;
    L_0x2703:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x270a:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x270d:
        r21 = byteOrigSOat11;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat11;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat11;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat11;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2746;
    L_0x271f:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2731;
    L_0x272a:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2731:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x2743;
    L_0x273c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x2743:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x2746:
        r21 = byteOrigSOat11_1;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat11_1;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat11_1;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat11_1;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x277f;
    L_0x2758:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x276a;
    L_0x2763:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x276a:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x277c;
    L_0x2775:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x277c:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x277f:
        r21 = byteOrigSOat11_2;	 Catch:{ Exception -> 0x281f }
        r22 = maskSOat11_2;	 Catch:{ Exception -> 0x281f }
        r23 = byteReplaceSOat11_2;	 Catch:{ Exception -> 0x281f }
        r24 = rep_maskSOat11_2;	 Catch:{ Exception -> 0x281f }
        r19 = r5;
        r20 = r6;
        r7 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x27b8;
    L_0x2791:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "patch";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x27a3;
    L_0x279c:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 patched!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x27a3:
        r7 = 0;
        r7 = r71[r7];	 Catch:{ Exception -> 0x281f }
        r8 = "restore";
        r7 = r7.contains(r8);	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x27b5;
    L_0x27ae:
        r7 = java.lang.System.out;	 Catch:{ Exception -> 0x281f }
        r8 = "Core4 restored!\n";
        r7.println(r8);	 Catch:{ Exception -> 0x281f }
    L_0x27b5:
        r7 = 1;
        patchOat1 = r7;	 Catch:{ Exception -> 0x281f }
    L_0x27b8:
        if (r25 == 0) goto L_0x283c;
    L_0x27ba:
        r7 = patchOat1;	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x283c;
    L_0x27be:
        r7 = patchOat2;	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x283c;
    L_0x27c2:
        r7 = patchOat6;	 Catch:{ Exception -> 0x281f }
        if (r7 == 0) goto L_0x283c;
    L_0x27c6:
        r7 = onlyDalvik;	 Catch:{ Exception -> 0x281f }
        if (r7 != 0) goto L_0x281a;
    L_0x27ca:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x281f }
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.dex";
        r7.<init>(r8);	 Catch:{ Exception -> 0x281f }
        r7.delete();	 Catch:{ Exception -> 0x281f }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x281f }
        r8 = "/data/dalvik-cache/arm/system@framework@services.jar@classes.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x281f }
        r7.delete();	 Catch:{ Exception -> 0x281f }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x281f }
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);	 Catch:{ Exception -> 0x281f }
        r7.delete();	 Catch:{ Exception -> 0x281f }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x281f }
        r8 = "/data/dalvik-cache/arm64/system@framework@services.jar@classes.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x281f }
        r7.delete();	 Catch:{ Exception -> 0x281f }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x281f }
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.dex";
        r7.<init>(r8);	 Catch:{ Exception -> 0x281f }
        r7.delete();	 Catch:{ Exception -> 0x281f }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x281f }
        r8 = "/data/dalvik-cache/x86/system@framework@services.jar@classes.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x281f }
        r7.delete();	 Catch:{ Exception -> 0x281f }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x281f }
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.dex";
        r7.<init>(r8);	 Catch:{ Exception -> 0x281f }
        r7.delete();	 Catch:{ Exception -> 0x281f }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x281f }
        r8 = "/data/dalvik-cache/x86_64/system@framework@services.jar@classes.art";
        r7.<init>(r8);	 Catch:{ Exception -> 0x281f }
        r7.delete();	 Catch:{ Exception -> 0x281f }
    L_0x281a:
        com.chelpus.Utils.reboot();	 Catch:{ Exception -> 0x281f }
        goto L_0x077a;
    L_0x281f:
        r38 = move-exception;
        r7 = java.lang.System.out;	 Catch:{ IOException -> 0x2836 }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x2836 }
        r8.<init>();	 Catch:{ IOException -> 0x2836 }
        r0 = r38;
        r8 = r8.append(r0);	 Catch:{ IOException -> 0x2836 }
        r8 = r8.toString();	 Catch:{ IOException -> 0x2836 }
        r7.println(r8);	 Catch:{ IOException -> 0x2836 }
        goto L_0x077a;
    L_0x2836:
        r38 = move-exception;
        r38.printStackTrace();
        goto L_0x077d;
    L_0x283c:
        r7 = fileBytes;	 Catch:{ Exception -> 0x281f }
        r8 = r5 + 1;
        r7.position(r8);	 Catch:{ Exception -> 0x281f }
        goto L_0x0772;
    L_0x2845:
        r7 = java.lang.System.out;
        r8 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r7.println(r8);
        goto L_0x077d;
    L_0x284e:
        r7 = 4;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "ART";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x28d7;
    L_0x2859:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "/system/framework/services.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = r7.exists();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x288a;
    L_0x2866:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "/system/framework/services.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r7.length();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 == 0) goto L_0x288a;
    L_0x2877:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "Add services.odex for patch";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "/system/framework/services.odex";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r42;
        r0.add(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x288a:
        r7 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "/system/framework/services.jar";
        r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = com.chelpus.Utils.classes_test(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x0864;
    L_0x2897:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "services.jar contain classes,dex";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = "/system/framework/services.jar";
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = "/data/app";
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = "/data/app/classes.dex";
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x0864;
    L_0x28bd:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "Add classes.dex for patch";
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r42;
        r1 = r26;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x0864;
    L_0x28cd:
        r53 = move-exception;
    L_0x28ce:
        r7 = java.lang.System.out;
        r8 = "Error: services.odex not found!\n\nPlease Odex services.jar and try again!";
        r7.println(r8);
        goto L_0x086e;
    L_0x28d7:
        r7 = onlyDalvik;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x2900;
    L_0x28db:
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = 2;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r52;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = r52.exists();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        if (r7 != 0) goto L_0x28f5;
    L_0x28eb:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        throw r7;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
    L_0x28f1:
        r53 = move-exception;
        r49 = r52;
        goto L_0x28ce;
    L_0x28f5:
        r0 = r42;
        r1 = r52;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r49 = r52;
        goto L_0x0864;
    L_0x2900:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "Vhodjashij file ";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = 2;
        r9 = r71[r9];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = 2;
        r7 = r71[r7];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r52;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = r52.exists();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        if (r7 != 0) goto L_0x294a;
    L_0x2927:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        throw r7;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
    L_0x292d:
        r38 = move-exception;
        r49 = r52;
    L_0x2930:
        r7 = java.lang.System.out;
        r8 = new java.lang.StringBuilder;
        r9 = "Exception e";
        r8.<init>(r9);
        r9 = r38.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.println(r8);
        goto L_0x086e;
    L_0x294a:
        r7 = r52.toString();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = "system@framework@services.jar@classes.dex";
        r7 = r7.contains(r8);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        if (r7 == 0) goto L_0x39c7;
    L_0x2956:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = "Vhodjashij file byl dalvick-cache ";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = 2;
        r9 = r71[r9];	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r64 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r7 = "/system/framework/services.jar";
        r0 = r64;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r7 = "/data/app";
        r0 = r64;
        unzip(r0, r7);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r26 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r7 = "/data/app/classes.dex";
        r0 = r26;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r7 = r26.exists();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        if (r7 == 0) goto L_0x39c3;
    L_0x298c:
        r49 = r26;
    L_0x298e:
        r28 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = "/system/framework/services.odex";
        r0 = r28;
        r0.<init>(r7);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7 = r28.exists();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r7 == 0) goto L_0x29aa;
    L_0x299d:
        r8 = r28.length();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r12 = 0;
        r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r7 != 0) goto L_0x29aa;
    L_0x29a7:
        r28.delete();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x29aa:
        r7 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "Add file for patch ";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r49.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r8.append(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r7.println(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r42;
        r1 = r49;
        r0.add(r1);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x0864;
    L_0x29cb:
        r38 = move-exception;
        goto L_0x2930;
    L_0x29ce:
        r45 = r7.next();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r45 = (java.io.File) r45;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10 = "Start patch for ";
        r9.<init>(r10);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10 = r45.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r9.append(r10);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r49 = r45;
        r48 = 0;
        r8 = com.chelpus.Utils.isELFfiles(r49);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x29f8;
    L_0x29f6:
        r48 = 1;
    L_0x29f8:
        r8 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "rw";
        r0 = r49;
        r8.<init>(r0, r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r4 = r8.getChannel();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r14 = 0;
        r8 = r4.size();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = (int) r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = (long) r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r16 = r0;
        r12 = r4;
        r8 = r12.map(r13, r14, r16);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        fileBytes = r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r61 = 0;
        r31 = 0;
        r32 = 0;
        if (r48 != 0) goto L_0x2d70;
    L_0x2a20:
        r8 = 0;
        lastByteReplace = r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = 0;
        lastPatchPosition = r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r50 = 0;
    L_0x2a28:
        r8 = fileBytes;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r8 = r8.hasRemaining();	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 != 0) goto L_0x2b0d;
    L_0x2a30:
        r8 = lastPatchPosition;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 <= 0) goto L_0x2a4b;
    L_0x2a34:
        r8 = lastByteReplace;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x2a4b;
    L_0x2a38:
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = lastPatchPosition;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.position(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = lastByteReplace;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.put(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.force();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x2a4b:
        r4.close();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = 4;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "framework";
        r8 = r8.contains(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x34de;
    L_0x2a59:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "Rebuild file!";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "/classes.dex";
        r8 = r8.endsWith(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x2adb;
    L_0x2a6c:
        com.chelpus.Utils.fixadler(r49);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r61 == 0) goto L_0x34d9;
    L_0x2a71:
        r8 = 0;
        not_found_bytes_for_patch = r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = 1;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "/services.jar";
        r10 = "/services-patched.jar";
        r37 = r8.replace(r9, r10);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = 1;
        r65 = r71[r8];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r37;
        r8.<init>(r0);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r41 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r41.<init>();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "add files";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r12 = com.chelpus.Utils.getDirs(r49);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r12 = r12.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r12 = java.lang.String.valueOf(r12);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10.<init>(r12);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r12 = "/";
        r10 = r10.append(r12);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10 = r10.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.<init>(r9, r10);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r41;
        r0.add(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r65;
        r1 = r37;
        r2 = r41;
        com.chelpus.Utils.addFilesToZip(r0, r1, r2);	 Catch:{ Exception -> 0x34c9, FileNotFoundException -> 0x28cd }
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34c9, FileNotFoundException -> 0x28cd }
        r9 = "add files finish";
        r8.println(r9);	 Catch:{ Exception -> 0x34c9, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x34c9, FileNotFoundException -> 0x28cd }
        r0 = r65;
        r8.<init>(r0);	 Catch:{ Exception -> 0x34c9, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x34c9, FileNotFoundException -> 0x28cd }
    L_0x2adb:
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "/services.odex";
        r8 = r8.endsWith(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x0868;
    L_0x2ae7:
        r8 = com.chelpus.Utils.isELFfiles(r49);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 != 0) goto L_0x2af3;
    L_0x2aed:
        r8 = 0;
        r0 = r49;
        com.chelpus.Utils.fixadlerOdex(r0, r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x2af3:
        if (r61 == 0) goto L_0x0868;
    L_0x2af5:
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r49.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10 = "/services.odex";
        r12 = "/services-patched.odex";
        r9 = r9.replace(r10, r12);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r49;
        r0.renameTo(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x0868;
    L_0x2b0d:
        r8 = fileBytes;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r5 = r8.position();	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r8 = fileBytes;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r6 = r8.get();	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r21 = byteOrigS2;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS2;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS2;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS2;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2b51;
    L_0x2b2b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2b3d;
    L_0x2b36:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2b3d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2b4f;
    L_0x2b48:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2b4f:
        r61 = 1;
    L_0x2b51:
        r21 = byteOrigS5;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS5;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS5;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS5;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2b89;
    L_0x2b63:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2b75;
    L_0x2b6e:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2b75:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2b87;
    L_0x2b80:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2b87:
        r61 = 1;
    L_0x2b89:
        r21 = byteOrigS14;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS14;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS14;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS14;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2bc1;
    L_0x2b9b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2bad;
    L_0x2ba6:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2bad:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2bbf;
    L_0x2bb8:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2bbf:
        r61 = 1;
    L_0x2bc1:
        r21 = byteOrigS6;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS6;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS6;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS6;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2bf9;
    L_0x2bd3:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2be5;
    L_0x2bde:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!checkUpgradeKeySetLP\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2be5:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2bf7;
    L_0x2bf0:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!checkUpgradeKeySetLP\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2bf7:
        r61 = 1;
    L_0x2bf9:
        r21 = byteOrigS7;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS7;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS7;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS7;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2c31;
    L_0x2c0b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2c1d;
    L_0x2c16:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2c1d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2c2f;
    L_0x2c28:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2c2f:
        r61 = 1;
    L_0x2c31:
        r21 = byteOrigS7_1;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS7_1;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS7_1;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS7_1;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2c69;
    L_0x2c43:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2c55;
    L_0x2c4e:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2c55:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2c67;
    L_0x2c60:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2c67:
        r61 = 1;
    L_0x2c69:
        r21 = byteOrigS3;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS3;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS3;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS3;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2ca1;
    L_0x2c7b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2c8d;
    L_0x2c86:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\nCM11";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2c8d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2c9f;
    L_0x2c98:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\nCM11";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2c9f:
        r61 = 1;
    L_0x2ca1:
        r21 = byteOrigS4;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS4;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS4;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS4;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2cd9;
    L_0x2cb3:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2cc5;
    L_0x2cbe:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2cc5:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2cd7;
    L_0x2cd0:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2cd7:
        r61 = 1;
    L_0x2cd9:
        r21 = byteOrigS13;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS13;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS13;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS13;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2d11;
    L_0x2ceb:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2cfd;
    L_0x2cf6:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2cfd:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2d0f;
    L_0x2d08:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2d0f:
        r61 = 1;
    L_0x2d11:
        r21 = byteOrigS13_1;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r22 = maskS13_1;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceS13_1;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r24 = rep_maskS13_1;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2d49;
    L_0x2d23:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2d35;
    L_0x2d2e:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2d35:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2d47;
    L_0x2d40:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
    L_0x2d47:
        r61 = 1;
    L_0x2d49:
        r8 = fileBytes;	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r9 = r5 + 1;
        r8.position(r9);	 Catch:{ Exception -> 0x2d56, FileNotFoundException -> 0x28cd }
        r8 = 1;
        r50 = r50 + r8;
        goto L_0x2a28;
    L_0x2d56:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r38;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x2a30;
    L_0x2d70:
        r0 = r49;
        r1 = r71;
        r2 = r25;
        patchWithOatDumpP3(r0, r1, r2);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = patchOat1;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 != 0) goto L_0x2d7f;
    L_0x2d7d:
        if (r25 != 0) goto L_0x2d85;
    L_0x2d7f:
        r8 = patchOat2;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 != 0) goto L_0x2a4b;
    L_0x2d83:
        if (r25 == 0) goto L_0x2a4b;
    L_0x2d85:
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r14 = 0;
        r8 = r4.size();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = (int) r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = (long) r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r16 = r0;
        r12 = r4;
        r8 = r12.map(r13, r14, r16);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        fileBytes = r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = 4120; // 0x1018 float:5.773E-42 double:2.0356E-320;
        r8.position(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r8.get();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r9.get();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10 = r10.get();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r12 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r12 = r12.get();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r63 = com.chelpus.Utils.convertFourBytesToInt(r8, r9, r10, r12);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r10 = "Start position:";
        r9.<init>(r10);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r63;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r63;
        r8.position(r0);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x2dd8:
        r8 = fileBytes;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r8 = r8.hasRemaining();	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2a4b;
    L_0x2de0:
        r8 = fileBytes;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r5 = r8.position();	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r8 = fileBytes;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r6 = r8.get();	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r21 = byteOrigSOat1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e27;
    L_0x2dfe:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e10;
    L_0x2e09:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2e10:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e22;
    L_0x2e1b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2e22:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2e27:
        r21 = byteOrigSOat1_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat1_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat1_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat1_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e62;
    L_0x2e39:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e4b;
    L_0x2e44:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2e4b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e5d;
    L_0x2e56:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2e5d:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2e62:
        r21 = byteOrigSOat1_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat1_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat1_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat1_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e9d;
    L_0x2e74:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e86;
    L_0x2e7f:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2e86:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2e98;
    L_0x2e91:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2e98:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2e9d:
        r21 = byteOrigSOat2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2ed8;
    L_0x2eaf:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2ec1;
    L_0x2eba:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2ec1:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2ed3;
    L_0x2ecc:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2ed3:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2ed8:
        r21 = byteOrigSOat6_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat6_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat6_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat6_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2f13;
    L_0x2eea:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2efc;
    L_0x2ef5:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2efc:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2f0e;
    L_0x2f07:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2f0e:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2f13:
        r21 = byteOrigSOat6_3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat6_3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat6_3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat6_3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2f4e;
    L_0x2f25:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2f37;
    L_0x2f30:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2f37:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2f49;
    L_0x2f42:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2f49:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2f4e:
        r21 = byteOrigSOat6_4;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat6_4;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat6_4;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat6_4;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2f89;
    L_0x2f60:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2f72;
    L_0x2f6b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2f72:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2f84;
    L_0x2f7d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2f84:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2f89:
        r21 = byteOrigSOat6_5;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat6_5;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat6_5;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat6_5;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2fc4;
    L_0x2f9b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2fad;
    L_0x2fa6:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2fad:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2fbf;
    L_0x2fb8:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2fbf:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2fc4:
        r21 = byteOrigSOat3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2fff;
    L_0x2fd6:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2fe8;
    L_0x2fe1:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2fe8:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x2ffa;
    L_0x2ff3:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x2ffa:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x2fff:
        r21 = byteOrigSOat6;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat6;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat6;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat6;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x303a;
    L_0x3011:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3023;
    L_0x301c:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3023:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3035;
    L_0x302e:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3035:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x303a:
        r21 = byteOrigSOat7;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat7;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat7;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat7;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3075;
    L_0x304c:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x305e;
    L_0x3057:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x305e:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3070;
    L_0x3069:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3070:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3075:
        r21 = byteOrigSOat7_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat7_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat7_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat7_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x30b0;
    L_0x3087:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3099;
    L_0x3092:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3099:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x30ab;
    L_0x30a4:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x30ab:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x30b0:
        r21 = byteOrigSOat4;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat4;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat4;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat4;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x30eb;
    L_0x30c2:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x30d4;
    L_0x30cd:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x30d4:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x30e6;
    L_0x30df:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x30e6:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x30eb:
        r21 = byteOrigSOat5;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat5;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat5;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat5;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3126;
    L_0x30fd:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x310f;
    L_0x3108:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x310f:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3121;
    L_0x311a:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3121:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3126:
        r21 = byteOrigSOat5_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat5_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat5_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat5_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3161;
    L_0x3138:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x314a;
    L_0x3143:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x314a:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x315c;
    L_0x3155:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!FixForCM\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x315c:
        r8 = 1;
        patchOat6 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3161:
        r21 = byteOrigSOat8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x319c;
    L_0x3173:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3185;
    L_0x317e:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3185:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3197;
    L_0x3190:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3197:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x319c:
        r21 = byteOrigSOat8_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat8_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat8_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat8_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x31d7;
    L_0x31ae:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x31c0;
    L_0x31b9:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x31c0:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x31d2;
    L_0x31cb:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x31d2:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x31d7:
        r21 = byteOrigSOat8_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat8_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat8_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat8_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3212;
    L_0x31e9:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x31fb;
    L_0x31f4:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x31fb:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x320d;
    L_0x3206:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x320d:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3212:
        r21 = byteOrigSOat10;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat10;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat10;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat10;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x324d;
    L_0x3224:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3236;
    L_0x322f:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3236:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3248;
    L_0x3241:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3248:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x324d:
        r21 = byteOrigSOat10_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat10_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat10_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat10_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3288;
    L_0x325f:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3271;
    L_0x326a:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3271:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3283;
    L_0x327c:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3283:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3288:
        r21 = byteOrigSOat11;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat11;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat11;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat11;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x32c3;
    L_0x329a:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x32ac;
    L_0x32a5:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x32ac:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x32be;
    L_0x32b7:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x32be:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x32c3:
        r21 = byteOrigSOat11_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat11_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat11_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat11_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x32fe;
    L_0x32d5:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x32e7;
    L_0x32e0:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x32e7:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x32f9;
    L_0x32f2:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x32f9:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x32fe:
        r21 = byteOrigSOat11_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat11_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat11_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat11_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3339;
    L_0x3310:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3322;
    L_0x331b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3322:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3334;
    L_0x332d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3334:
        r8 = 1;
        patchOat1 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3339:
        r21 = byteOrigSOat9;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat9;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat9;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat9;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3374;
    L_0x334b:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x335d;
    L_0x3356:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x335d:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x336f;
    L_0x3368:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x336f:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3374:
        r21 = byteOrigSOat9_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat9_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat9_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat9_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x33af;
    L_0x3386:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3398;
    L_0x3391:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3398:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x33aa;
    L_0x33a3:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x33aa:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x33af:
        r21 = byteOrigSOat9_3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat9_3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat9_3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat9_3;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x33ea;
    L_0x33c1:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x33d3;
    L_0x33cc:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x33d3:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x33e5;
    L_0x33de:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x33e5:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x33ea:
        r21 = byteOrigSOat9_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat9_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat9_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat9_2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3425;
    L_0x33fc:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x340e;
    L_0x3407:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x340e:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3420;
    L_0x3419:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3420:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3425:
        r21 = byteOrigSOat12;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat12;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat12;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat12;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3460;
    L_0x3437:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3449;
    L_0x3442:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3449:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x345b;
    L_0x3454:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x345b:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x3460:
        r21 = byteOrigSOat12_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r22 = maskSOat12_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r23 = byteReplaceSOat12_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r24 = rep_maskSOat12_1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x349b;
    L_0x3472:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3484;
    L_0x347d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 patched!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3484:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x3496;
    L_0x348f:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = "Core4 restored!InstallLocationPolice\n";
        r8.println(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
    L_0x3496:
        r8 = 1;
        patchOat2 = r8;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r61 = 1;
    L_0x349b:
        if (r25 == 0) goto L_0x34a9;
    L_0x349d:
        r8 = patchOat1;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x34a9;
    L_0x34a1:
        r8 = patchOat2;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x34a9;
    L_0x34a5:
        r8 = patchOat6;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        if (r8 != 0) goto L_0x2a4b;
    L_0x34a9:
        r8 = fileBytes;	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        r9 = r5 + 1;
        r8.position(r9);	 Catch:{ Exception -> 0x34b2, FileNotFoundException -> 0x28cd }
        goto L_0x2dd8;
    L_0x34b2:
        r38 = move-exception;
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r38;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x2a4b;
    L_0x34c9:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r37;
        r8.<init>(r0);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x2adb;
    L_0x34d9:
        r8 = 1;
        not_found_bytes_for_patch = r8;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x2adb;
    L_0x34de:
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "/classes.dex";
        r8 = r8.endsWith(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x36ec;
    L_0x34ea:
        com.chelpus.Utils.fixadler(r49);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x34ed:
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "system@framework@services.jar@classes.dex";
        r8 = r8.contains(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x3502;
    L_0x34f9:
        if (r61 == 0) goto L_0x3502;
    L_0x34fb:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "LuckyPatcher: dalvik-cache patched! ";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x3502:
        r8 = r49.toString();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "/classes.dex";
        r8 = r8.contains(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x36a5;
    L_0x350e:
        if (r61 == 0) goto L_0x36a5;
    L_0x3510:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "start";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r37 = "/system/framework/services.backup";
        r65 = "/system/framework/services.jar";
        r8 = 1;
        r9 = 0;
        r0 = r65;
        r1 = r37;
        r8 = com.chelpus.Utils.copyFile(r0, r1, r8, r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x3710;
    L_0x3527:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "good space";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r37;
        r8.<init>(r0);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r41 = new java.util.ArrayList;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r41.<init>();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "add files";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new com.android.vending.billing.InAppBillingService.LOCK.AddFilesItem;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "/data/app/classes.dex";
        r10 = "/data/app/";
        r8.<init>(r9, r10);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r41;
        r0.add(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "/system/framework/services.jar";
        r9 = "/system/framework/services.backup";
        r0 = r41;
        com.chelpus.Utils.addFilesToZip(r8, r9, r0);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = "add files finish";
        r8.println(r9);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 0;
        r10 = "chmod";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 1;
        r10 = "0644";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 2;
        r10 = "/system/framework/services.backup";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 0;
        r10 = "chown";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 1;
        r10 = "0:0";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 2;
        r10 = "/system/framework/services.backup";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 0;
        r10 = "chmod";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 1;
        r10 = "0.0";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 2;
        r10 = "/system/framework/services.backup";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r28 = new java.io.File;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = "/system/framework/services.odex";
        r0 = r28;
        r0.<init>(r8);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = "/system/framework/services.jar";
        r35 = com.chelpus.Utils.getFileDalvikCache(r8);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = r28.exists();	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x35c4;
    L_0x35b6:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = "fix odex na osnove rebuild services";
        r8.println(r9);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = "/system/framework/services.backup";
        r0 = r28;
        com.chelpus.Utils.fixadlerOdex(r0, r8);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
    L_0x35c4:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r10 = com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment.toolfilesdir;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9.<init>(r10);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r10 = "/ClearDalvik.on";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = r9.toString();	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8.<init>(r9);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8.createNewFile();	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = "/system/framework/services.jar";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = 2;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 0;
        r10 = "rm";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 1;
        r10 = "/system/framework/services.jar";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = "/system/framework/services.backup";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = new java.io.File;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r10 = "/system/framework/services.jar";
        r9.<init>(r10);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8.renameTo(r9);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = "/system/framework/services.jar";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r8 = r8.exists();	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        if (r8 != 0) goto L_0x362e;
    L_0x3619:
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 0;
        r10 = "mv";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 1;
        r10 = "/system/framework/services.backup";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        r9 = 2;
        r10 = "/system/framework/services.jar";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
    L_0x362e:
        if (r35 == 0) goto L_0x364b;
    L_0x3630:
        r8 = 2;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = 0;
        r10 = "rm";
        r8[r9] = r10;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = 1;
        r10 = r35.getAbsolutePath();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8[r9] = r10;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        com.chelpus.Utils.run_all_no_root(r8);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8 = r35.exists();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        if (r8 == 0) goto L_0x364b;
    L_0x3648:
        r35.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
    L_0x364b:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = "/data/dalvik-cache/arm/system@framework@arm@boot.oat";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = "/data/dalvik-cache/arm/system@framework@arm@boot.art";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = "/data/dalvik-cache/arm64/system@framework@arm@boot.oat";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = "/data/dalvik-cache/arm64/system@framework@arm@boot.art";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = "/data/dalvik-cache/x86/system@framework@arm@boot.oat";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = "/data/dalvik-cache/x86/system@framework@arm@boot.art";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = "/data/dalvik-cache/x86_64/system@framework@arm@boot.oat";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r9 = "/data/dalvik-cache/x86_64/system@framework@arm@boot.art";
        r8.<init>(r9);	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
        r8.delete();	 Catch:{ Exception -> 0x36f5, FileNotFoundException -> 0x28cd }
    L_0x369b:
        com.chelpus.Utils.clear_dalvik_cache();	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
    L_0x369e:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "finish";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x36a5:
        r8 = onlyDalvik;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 != 0) goto L_0x0868;
    L_0x36a9:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "/system/framework/services.patched";
        r0 = r27;
        r0.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r27.exists();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x36bf;
    L_0x36b8:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "LuckyPatcher: root found services.patched! ";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x36bf:
        r27 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = "/system/framework/services.odex";
        r0 = r27;
        r0.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = r27.exists();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x36d5;
    L_0x36ce:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "LuckyPatcher: root found services.odex! ";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
    L_0x36d5:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        if (r8 == 0) goto L_0x0868;
    L_0x36e0:
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "/system/framework/patch3.done";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x0868;
    L_0x36ec:
        r8 = "/system/framework/services.jar";
        r0 = r49;
        com.chelpus.Utils.fixadlerOdex(r0, r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x34ed;
    L_0x36f5:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ Exception -> 0x36fa, FileNotFoundException -> 0x28cd }
        goto L_0x369b;
    L_0x36fa:
        r38 = move-exception;
        r38.printStackTrace();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r9 = "/system/framework/services.backup";
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        goto L_0x369e;
    L_0x3710:
        r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r37;
        r8.<init>(r0);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8.delete();	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r52 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = 2;
        r8 = r71[r8];	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r0 = r52;
        r0.<init>(r8);	 Catch:{ FileNotFoundException -> 0x28cd, Exception -> 0x29cb }
        r8 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = "rw";
        r0 = r52;
        r8.<init>(r0, r9);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r4 = r8.getChannel();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r13 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r14 = 0;
        r8 = r4.size();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = (int) r8;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r0 = (long) r8;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r16 = r0;
        r12 = r4;
        r8 = r12.map(r13, r14, r16);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        fileBytes = r8;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r31 = 0;
        r32 = 0;
        r8 = 0;
        lastByteReplace = r8;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = 0;
        lastPatchPosition = r8;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r61 = 0;
        r50 = 0;
    L_0x3752:
        r8 = fileBytes;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r8 = r8.hasRemaining();	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 != 0) goto L_0x3792;
    L_0x375a:
        r8 = lastPatchPosition;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        if (r8 <= 0) goto L_0x3775;
    L_0x375e:
        r8 = lastByteReplace;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        if (r8 == 0) goto L_0x3775;
    L_0x3762:
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = lastPatchPosition;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8.position(r9);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = lastByteReplace;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8.put(r9);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = fileBytes;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8.force();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
    L_0x3775:
        r4.close();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8 = r52.toString();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = "/classes.dex";
        r8 = r8.endsWith(r9);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        if (r8 == 0) goto L_0x39ba;
    L_0x3784:
        com.chelpus.Utils.fixadler(r52);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
    L_0x3787:
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = "LuckyPatcher: odex not equal lenght patched! Not enougth space in /system/!";
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r49 = r52;
        goto L_0x36a5;
    L_0x3792:
        r8 = fileBytes;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r5 = r8.position();	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r8 = fileBytes;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r6 = r8.get();	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r21 = byteOrigS2;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS2;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS2;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS2;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x37d6;
    L_0x37b0:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x37c2;
    L_0x37bb:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x37c2:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x37d4;
    L_0x37cd:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x37d4:
        r61 = 1;
    L_0x37d6:
        r21 = byteOrigS5;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS5;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS5;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS5;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x380e;
    L_0x37e8:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x37fa;
    L_0x37f3:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x37fa:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x380c;
    L_0x3805:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x380c:
        r61 = 1;
    L_0x380e:
        r21 = byteOrigS14;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS14;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS14;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS14;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3846;
    L_0x3820:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3832;
    L_0x382b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x3832:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3844;
    L_0x383d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x3844:
        r61 = 1;
    L_0x3846:
        r21 = byteOrigS6;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS6;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS6;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS6;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x387e;
    L_0x3858:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x386a;
    L_0x3863:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 patched!checkUpgradeKeySetLP\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x386a:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x387c;
    L_0x3875:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 restored!checkUpgradeKeySetLP\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x387c:
        r61 = 1;
    L_0x387e:
        r21 = byteOrigS7;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS7;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS7;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS7;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x38b6;
    L_0x3890:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x38a2;
    L_0x389b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 patched!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x38a2:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x38b4;
    L_0x38ad:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 restored!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x38b4:
        r61 = 1;
    L_0x38b6:
        r21 = byteOrigS7_1;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS7_1;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS7_1;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS7_1;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x38ee;
    L_0x38c8:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x38da;
    L_0x38d3:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 patched!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x38da:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x38ec;
    L_0x38e5:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 restored!\nCM12";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x38ec:
        r61 = 1;
    L_0x38ee:
        r21 = byteOrigS3;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS3;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS3;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS3;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3926;
    L_0x3900:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3912;
    L_0x390b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 patched!\nCM11";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x3912:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3924;
    L_0x391d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 restored!\nCM11";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x3924:
        r61 = 1;
    L_0x3926:
        r21 = byteOrigS4;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS4;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS4;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS4;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x395e;
    L_0x3938:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x394a;
    L_0x3943:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x394a:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x395c;
    L_0x3955:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x395c:
        r61 = 1;
    L_0x395e:
        r21 = byteOrigS13_1;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r22 = maskS13_1;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r23 = byteReplaceS13_1;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r24 = rep_maskS13_1;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r19 = r5;
        r20 = r6;
        r8 = applyPatch(r19, r20, r21, r22, r23, r24, r25);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3996;
    L_0x3970:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "patch";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3982;
    L_0x397b:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 policy patched!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x3982:
        r8 = 0;
        r8 = r71[r8];	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "restore";
        r8 = r8.contains(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        if (r8 == 0) goto L_0x3994;
    L_0x398d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = "Core4 policy restored!\n";
        r8.println(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
    L_0x3994:
        r61 = 1;
    L_0x3996:
        r8 = fileBytes;	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r9 = r5 + 1;
        r8.position(r9);	 Catch:{ Exception -> 0x39a3, FileNotFoundException -> 0x28f1 }
        r8 = 1;
        r50 = r50 + r8;
        goto L_0x3752;
    L_0x39a3:
        r38 = move-exception;
        r8 = java.lang.System.out;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9.<init>();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r0 = r38;
        r9 = r9.append(r0);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        r8.println(r9);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        goto L_0x375a;
    L_0x39ba:
        r8 = "/system/framework/services.jar";
        r0 = r52;
        com.chelpus.Utils.fixadlerOdex(r0, r8);	 Catch:{ FileNotFoundException -> 0x28f1, Exception -> 0x292d }
        goto L_0x3787;
    L_0x39c3:
        r49 = r52;
        goto L_0x298e;
    L_0x39c7:
        r49 = r52;
        goto L_0x29aa;
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
                    FileOutputStream fout = new FileOutputStream(new StringBuilder(String.valueOf(dir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append("classes.dex").toString());
                    byte[] buffer = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
                    while (true) {
                        int length = zin.read(buffer);
                        if (length == -1) {
                            break;
                        }
                        fout.write(buffer, 0, length);
                    }
                    Utils.run_all_no_root("chmod", "777", new StringBuilder(String.valueOf(dir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append("classes.dex").toString());
                    Utils.run_all_no_root("chown", "0.0", new StringBuilder(String.valueOf(dir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append("classes.dex").toString());
                    Utils.run_all_no_root("chown", "0:0", new StringBuilder(String.valueOf(dir)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append("classes.dex").toString());
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
                        if (rep_mask[i] == (byte) 20) {
                            byteReplace[i] = (byte) (prufbyte & 15);
                        }
                        if (rep_mask[i] == (byte) 21) {
                            byteReplace[i] = (byte) ((prufbyte & 15) + 16);
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
                OatFuncDump oatDump = new Utils("").getOffsetOatdump(fileForPatch, new ArrayList<String>() {
                    {
                        add("boolean com.android.org.conscrypt.OpenSSLSignature.engineVerify(byte[])");
                    }
                });
                System.out.println(oatDump.instruction);
                it3 = oatDump.funcArray.iterator();
                while (it3.hasNext()) {
                    try {
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
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!(patch_for_boot_aot && pattern2 && conscryptFound)) {
                if (patch_for_boot_aot && !conscryptFound) {
                    if (!(pattern1 || pattern2)) {
                    }
                }
            }
            try {
                oatDump = new Utils("").getOffsetOatdump(fileForPatch, new AnonymousClass4(pattern2, conscryptFound, pattern1));
                System.out.println(oatDump.instruction);
                try {
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
                                        add(new PatchesItem(corepatch.byteOrig_patch2_x86_2, null, corepatch.byteReplace_patch2_x86_2, null, "", false));
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
                            ChannelDex.close();
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
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e22) {
                e22.printStackTrace();
                return;
            }
        }
        if ((patchOat1 || patchOat2) && count_oat_files == oatForPatch.size() && listAppsFragment.api >= 24) {
            System.out.println("patched cache " + listAppsFragment.toolfilesdir + "/reboot");
            Utils.reboot();
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
                                add(new PatchesItem(corepatch.byteOrig_patch3_arm_2, null, corepatch.byteReplace_patch3_arm_2, null, "", false));
                                add(new PatchesItem(corepatch.byteOrig_patch3_arm64_2, null, corepatch.byteReplace_patch3_arm64_2, null, "", false));
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
                                add(new PatchesItem(corepatch.byteOrig_patch3p_arm_2, null, corepatch.byteReplace_patch3p_arm_2, null, "", false));
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
                            if (applyPatch(curentPos, curentByte, byteOrig_patch3cm_arm64_2, mask_patch3cm_arm64_2, byteReplace_patch3cm_arm64_2, rep_mask_patch3cm_arm64_2, pattern3)) {
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
