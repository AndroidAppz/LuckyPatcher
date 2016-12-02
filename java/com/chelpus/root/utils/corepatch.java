/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.android.vending.billing.InAppBillingService.LOCK.PatchesItem
 *  java.io.File
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.MappedByteBuffer
 *  java.util.ArrayList
 */
package com.chelpus.root.utils;

import com.android.vending.billing.InAppBillingService.LOCK.PatchesItem;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;

public class corepatch {
    public static final byte[] MAGIC = new byte[]{100, 101, 121, 10, 48, 51, 53, 0};
    public static int adler;
    public static byte[] byteOrig10;
    public static byte[] byteOrig11;
    public static byte[] byteOrig12;
    public static byte[] byteOrig13;
    public static byte[] byteOrig14;
    public static byte[] byteOrig15;
    public static byte[] byteOrig16;
    public static byte[] byteOrig17;
    public static byte[] byteOrig18;
    public static byte[] byteOrig19;
    public static byte[] byteOrig2;
    public static byte[] byteOrig20;
    public static byte[] byteOrig21;
    public static byte[] byteOrig22;
    public static byte[] byteOrig23;
    public static byte[] byteOrig3;
    public static byte[] byteOrig4;
    public static byte[] byteOrig5;
    public static byte[] byteOrig6;
    public static byte[] byteOrig7;
    public static byte[] byteOrig8;
    public static byte[] byteOrig9;
    public static byte[] byteOrigOat1;
    public static byte[] byteOrigOat2;
    public static byte[] byteOrigOat3;
    public static byte[] byteOrigOat3_1;
    public static byte[] byteOrigOat3_2;
    public static byte[] byteOrigOat4;
    public static byte[] byteOrigOat5;
    public static byte[] byteOrigOat6;
    public static byte[] byteOrigOat6_1;
    public static byte[] byteOrigOat7;
    public static byte[] byteOrigOat7_1;
    public static byte[] byteOrigOatUpd1;
    public static byte[] byteOrigOatUpd2;
    public static byte[] byteOrigOatUpd4;
    public static byte[] byteOrigOatUpd4_1;
    public static byte[] byteOrigOatUpd5;
    public static byte[] byteOrigOatUpd5_1;
    public static byte[] byteOrigS13;
    public static byte[] byteOrigS13_1;
    public static byte[] byteOrigS14;
    public static byte[] byteOrigS2;
    public static byte[] byteOrigS3;
    public static byte[] byteOrigS4;
    public static byte[] byteOrigS5;
    public static byte[] byteOrigS6;
    public static byte[] byteOrigS7;
    public static byte[] byteOrigS7_1;
    public static byte[] byteOrigSOat1;
    public static byte[] byteOrigSOat10;
    public static byte[] byteOrigSOat10_1;
    public static byte[] byteOrigSOat11;
    public static byte[] byteOrigSOat11_1;
    public static byte[] byteOrigSOat11_2;
    public static byte[] byteOrigSOat12;
    public static byte[] byteOrigSOat12_1;
    public static byte[] byteOrigSOat1_1;
    public static byte[] byteOrigSOat1_2;
    public static byte[] byteOrigSOat2;
    public static byte[] byteOrigSOat3;
    public static byte[] byteOrigSOat4;
    public static byte[] byteOrigSOat5;
    public static byte[] byteOrigSOat5_1;
    public static byte[] byteOrigSOat6;
    public static byte[] byteOrigSOat6_2;
    public static byte[] byteOrigSOat6_3;
    public static byte[] byteOrigSOat6_4;
    public static byte[] byteOrigSOat6_5;
    public static byte[] byteOrigSOat7;
    public static byte[] byteOrigSOat7_2;
    public static byte[] byteOrigSOat8;
    public static byte[] byteOrigSOat8_1;
    public static byte[] byteOrigSOat8_2;
    public static byte[] byteOrigSOat9;
    public static byte[] byteOrigSOat9_1;
    public static byte[] byteOrigSOat9_2;
    public static byte[] byteOrigSOat9_3;
    public static byte[] byteOrig_patch1_arm;
    public static byte[] byteOrig_patch1_arm64;
    public static byte[] byteOrig_patch1_arm64_1;
    public static byte[] byteOrig_patch1_arm64_2;
    public static byte[] byteOrig_patch1_arm_1;
    public static byte[] byteOrig_patch1_x86;
    public static byte[] byteOrig_patch2_arm;
    public static byte[] byteOrig_patch2_arm64;
    public static byte[] byteOrig_patch2_arm64_1;
    public static byte[] byteOrig_patch2_arm64_2;
    public static byte[] byteOrig_patch2_arm_1;
    public static byte[] byteOrig_patch2_x86;
    public static byte[] byteOrig_patch2_x86_64;
    public static byte[] byteOrig_patch3_arm;
    public static byte[] byteOrig_patch3_arm64;
    public static byte[] byteOrig_patch3_x86;
    public static byte[] byteOrig_patch3cm_arm;
    public static byte[] byteOrig_patch3cm_arm64;
    public static byte[] byteOrig_patch3p_arm;
    public static byte[] byteOrig_patch3p_arm64;
    public static byte[] byteOrig_patch3p_x86;
    public static byte[] byteReplace10;
    public static byte[] byteReplace11;
    public static byte[] byteReplace12;
    public static byte[] byteReplace13;
    public static byte[] byteReplace14;
    public static byte[] byteReplace15;
    public static byte[] byteReplace16;
    public static byte[] byteReplace17;
    public static byte[] byteReplace18;
    public static byte[] byteReplace19;
    public static byte[] byteReplace2;
    public static byte[] byteReplace20;
    public static byte[] byteReplace21;
    public static byte[] byteReplace22;
    public static byte[] byteReplace23;
    public static byte[] byteReplace3;
    public static byte[] byteReplace4;
    public static byte[] byteReplace5;
    public static byte[] byteReplace6;
    public static byte[] byteReplace7;
    public static byte[] byteReplace8;
    public static byte[] byteReplace9;
    public static byte[] byteReplaceOat1;
    public static byte[] byteReplaceOat2;
    public static byte[] byteReplaceOat3;
    public static byte[] byteReplaceOat3_1;
    public static byte[] byteReplaceOat3_2;
    public static byte[] byteReplaceOat4;
    public static byte[] byteReplaceOat5;
    public static byte[] byteReplaceOat6;
    public static byte[] byteReplaceOat6_1;
    public static byte[] byteReplaceOat7;
    public static byte[] byteReplaceOat7_1;
    public static byte[] byteReplaceOatUpd1;
    public static byte[] byteReplaceOatUpd2;
    public static byte[] byteReplaceOatUpd4;
    public static byte[] byteReplaceOatUpd4_1;
    public static byte[] byteReplaceOatUpd5;
    public static byte[] byteReplaceOatUpd5_1;
    public static byte[] byteReplaceS13;
    public static byte[] byteReplaceS13_1;
    public static byte[] byteReplaceS14;
    public static byte[] byteReplaceS2;
    public static byte[] byteReplaceS3;
    public static byte[] byteReplaceS4;
    public static byte[] byteReplaceS5;
    public static byte[] byteReplaceS6;
    public static byte[] byteReplaceS7;
    public static byte[] byteReplaceS7_1;
    public static byte[] byteReplaceSOat1;
    public static byte[] byteReplaceSOat10;
    public static byte[] byteReplaceSOat10_1;
    public static byte[] byteReplaceSOat11;
    public static byte[] byteReplaceSOat11_1;
    public static byte[] byteReplaceSOat11_2;
    public static byte[] byteReplaceSOat12;
    public static byte[] byteReplaceSOat12_1;
    public static byte[] byteReplaceSOat1_1;
    public static byte[] byteReplaceSOat1_2;
    public static byte[] byteReplaceSOat2;
    public static byte[] byteReplaceSOat3;
    public static byte[] byteReplaceSOat4;
    public static byte[] byteReplaceSOat5;
    public static byte[] byteReplaceSOat5_1;
    public static byte[] byteReplaceSOat6;
    public static byte[] byteReplaceSOat6_2;
    public static byte[] byteReplaceSOat6_3;
    public static byte[] byteReplaceSOat6_4;
    public static byte[] byteReplaceSOat6_5;
    public static byte[] byteReplaceSOat7;
    public static byte[] byteReplaceSOat7_2;
    public static byte[] byteReplaceSOat8;
    public static byte[] byteReplaceSOat8_1;
    public static byte[] byteReplaceSOat8_2;
    public static byte[] byteReplaceSOat9;
    public static byte[] byteReplaceSOat9_1;
    public static byte[] byteReplaceSOat9_2;
    public static byte[] byteReplaceSOat9_3;
    public static byte[] byteReplace_patch1_arm;
    public static byte[] byteReplace_patch1_arm64;
    public static byte[] byteReplace_patch1_arm64_1;
    public static byte[] byteReplace_patch1_arm64_2;
    public static byte[] byteReplace_patch1_arm_1;
    public static byte[] byteReplace_patch1_x86;
    public static byte[] byteReplace_patch2_arm;
    public static byte[] byteReplace_patch2_arm64;
    public static byte[] byteReplace_patch2_arm64_1;
    public static byte[] byteReplace_patch2_arm64_2;
    public static byte[] byteReplace_patch2_arm_1;
    public static byte[] byteReplace_patch2_x86;
    public static byte[] byteReplace_patch2_x86_64;
    public static byte[] byteReplace_patch3_arm;
    public static byte[] byteReplace_patch3_arm64;
    public static byte[] byteReplace_patch3_x86;
    public static byte[] byteReplace_patch3cm_arm;
    public static byte[] byteReplace_patch3cm_arm64;
    public static byte[] byteReplace_patch3p_arm;
    public static byte[] byteReplace_patch3p_arm64;
    public static byte[] byteReplace_patch3p_x86;
    public static MappedByteBuffer fileBytes;
    public static byte[] lastByteReplace;
    public static int lastPatchPosition;
    public static byte[] mask10;
    public static byte[] mask11;
    public static byte[] mask12;
    public static byte[] mask13;
    public static byte[] mask14;
    public static byte[] mask15;
    public static byte[] mask16;
    public static byte[] mask17;
    public static byte[] mask18;
    public static byte[] mask19;
    public static byte[] mask2;
    public static byte[] mask20;
    public static byte[] mask21;
    public static byte[] mask22;
    public static byte[] mask23;
    public static byte[] mask4;
    public static byte[] mask5;
    public static byte[] mask6;
    public static byte[] mask7;
    public static byte[] mask8;
    public static byte[] mask9;
    public static byte[] maskOat1;
    public static byte[] maskOat2;
    public static byte[] maskOat3;
    public static byte[] maskOat3_1;
    public static byte[] maskOat3_2;
    public static byte[] maskOat4;
    public static byte[] maskOat5;
    public static byte[] maskOat6;
    public static byte[] maskOat6_1;
    public static byte[] maskOat7;
    public static byte[] maskOat7_1;
    public static byte[] maskOatUpd1;
    public static byte[] maskOatUpd2;
    public static byte[] maskOatUpd4;
    public static byte[] maskOatUpd4_1;
    public static byte[] maskOatUpd5;
    public static byte[] maskOatUpd5_1;
    public static byte[] maskS13;
    public static byte[] maskS13_1;
    public static byte[] maskS14;
    public static byte[] maskS2;
    public static byte[] maskS3;
    public static byte[] maskS4;
    public static byte[] maskS5;
    public static byte[] maskS6;
    public static byte[] maskS7;
    public static byte[] maskS7_1;
    public static byte[] maskSOat1;
    public static byte[] maskSOat10;
    public static byte[] maskSOat10_1;
    public static byte[] maskSOat11;
    public static byte[] maskSOat11_1;
    public static byte[] maskSOat11_2;
    public static byte[] maskSOat12;
    public static byte[] maskSOat12_1;
    public static byte[] maskSOat1_1;
    public static byte[] maskSOat1_2;
    public static byte[] maskSOat2;
    public static byte[] maskSOat3;
    public static byte[] maskSOat4;
    public static byte[] maskSOat5;
    public static byte[] maskSOat5_1;
    public static byte[] maskSOat6;
    public static byte[] maskSOat6_2;
    public static byte[] maskSOat6_3;
    public static byte[] maskSOat6_4;
    public static byte[] maskSOat6_5;
    public static byte[] maskSOat7;
    public static byte[] maskSOat7_2;
    public static byte[] maskSOat8;
    public static byte[] maskSOat8_1;
    public static byte[] maskSOat8_2;
    public static byte[] maskSOat9;
    public static byte[] maskSOat9_1;
    public static byte[] maskSOat9_2;
    public static byte[] maskSOat9_3;
    public static byte[] mask_patch1_arm;
    public static byte[] mask_patch1_arm64;
    public static byte[] mask_patch1_arm64_1;
    public static byte[] mask_patch1_arm64_2;
    public static byte[] mask_patch1_arm_1;
    public static byte[] mask_patch1_x86;
    public static byte[] mask_patch2_arm;
    public static byte[] mask_patch2_arm64;
    public static byte[] mask_patch2_arm64_1;
    public static byte[] mask_patch2_arm64_2;
    public static byte[] mask_patch2_arm_1;
    public static byte[] mask_patch2_x86;
    public static byte[] mask_patch2_x86_64;
    public static byte[] mask_patch3_arm;
    public static byte[] mask_patch3_arm64;
    public static byte[] mask_patch3_x86;
    public static byte[] mask_patch3cm_arm;
    public static byte[] mask_patch3cm_arm64;
    public static byte[] mask_patch3p_arm;
    public static byte[] mask_patch3p_arm64;
    public static byte[] mask_patch3p_x86;
    public static boolean not_found_bytes_for_patch;
    public static boolean onlyDalvik;
    public static boolean patchOat1;
    public static boolean patchOat2;
    public static boolean patchOat3;
    public static boolean patchOat4;
    public static boolean patchOat6;
    public static boolean patchOatUpd1;
    public static byte[] rep_mask10;
    public static byte[] rep_mask11;
    public static byte[] rep_mask12;
    public static byte[] rep_mask13;
    public static byte[] rep_mask14;
    public static byte[] rep_mask15;
    public static byte[] rep_mask16;
    public static byte[] rep_mask17;
    public static byte[] rep_mask18;
    public static byte[] rep_mask19;
    public static byte[] rep_mask2;
    public static byte[] rep_mask20;
    public static byte[] rep_mask21;
    public static byte[] rep_mask22;
    public static byte[] rep_mask23;
    public static byte[] rep_mask4;
    public static byte[] rep_mask5;
    public static byte[] rep_mask6;
    public static byte[] rep_mask7;
    public static byte[] rep_mask8;
    public static byte[] rep_mask9;
    public static byte[] rep_maskOat1;
    public static byte[] rep_maskOat2;
    public static byte[] rep_maskOat3;
    public static byte[] rep_maskOat3_1;
    public static byte[] rep_maskOat3_2;
    public static byte[] rep_maskOat4;
    public static byte[] rep_maskOat5;
    public static byte[] rep_maskOat6;
    public static byte[] rep_maskOat6_1;
    public static byte[] rep_maskOat7;
    public static byte[] rep_maskOat7_1;
    public static byte[] rep_maskOatUpd1;
    public static byte[] rep_maskOatUpd2;
    public static byte[] rep_maskOatUpd4;
    public static byte[] rep_maskOatUpd4_1;
    public static byte[] rep_maskOatUpd5;
    public static byte[] rep_maskOatUpd5_1;
    public static byte[] rep_maskS13;
    public static byte[] rep_maskS13_1;
    public static byte[] rep_maskS14;
    public static byte[] rep_maskS2;
    public static byte[] rep_maskS3;
    public static byte[] rep_maskS4;
    public static byte[] rep_maskS5;
    public static byte[] rep_maskS6;
    public static byte[] rep_maskS7;
    public static byte[] rep_maskS7_1;
    public static byte[] rep_maskSOat1;
    public static byte[] rep_maskSOat10;
    public static byte[] rep_maskSOat10_1;
    public static byte[] rep_maskSOat11;
    public static byte[] rep_maskSOat11_1;
    public static byte[] rep_maskSOat11_2;
    public static byte[] rep_maskSOat12;
    public static byte[] rep_maskSOat12_1;
    public static byte[] rep_maskSOat1_1;
    public static byte[] rep_maskSOat1_2;
    public static byte[] rep_maskSOat2;
    public static byte[] rep_maskSOat3;
    public static byte[] rep_maskSOat4;
    public static byte[] rep_maskSOat5;
    public static byte[] rep_maskSOat5_1;
    public static byte[] rep_maskSOat6;
    public static byte[] rep_maskSOat6_2;
    public static byte[] rep_maskSOat6_3;
    public static byte[] rep_maskSOat6_4;
    public static byte[] rep_maskSOat6_5;
    public static byte[] rep_maskSOat7;
    public static byte[] rep_maskSOat7_2;
    public static byte[] rep_maskSOat8;
    public static byte[] rep_maskSOat8_1;
    public static byte[] rep_maskSOat8_2;
    public static byte[] rep_maskSOat9;
    public static byte[] rep_maskSOat9_1;
    public static byte[] rep_maskSOat9_2;
    public static byte[] rep_maskSOat9_3;
    public static byte[] rep_mask_patch1_arm;
    public static byte[] rep_mask_patch1_arm64;
    public static byte[] rep_mask_patch1_arm64_1;
    public static byte[] rep_mask_patch1_arm64_2;
    public static byte[] rep_mask_patch1_arm_1;
    public static byte[] rep_mask_patch1_x86;
    public static byte[] rep_mask_patch2_arm;
    public static byte[] rep_mask_patch2_arm64;
    public static byte[] rep_mask_patch2_arm64_1;
    public static byte[] rep_mask_patch2_arm64_2;
    public static byte[] rep_mask_patch2_arm_1;
    public static byte[] rep_mask_patch2_x86;
    public static byte[] rep_mask_patch2_x86_64;
    public static byte[] rep_mask_patch3_arm;
    public static byte[] rep_mask_patch3_arm64;
    public static byte[] rep_mask_patch3_x86;
    public static byte[] rep_mask_patch3cm_arm;
    public static byte[] rep_mask_patch3cm_arm64;
    public static byte[] rep_mask_patch3p_arm;
    public static byte[] rep_mask_patch3p_arm64;
    public static byte[] rep_mask_patch3p_x86;
    public static String toolfilesdir;

    static {
        toolfilesdir = "";
        onlyDalvik = false;
        not_found_bytes_for_patch = false;
        fileBytes = null;
        lastPatchPosition = 0;
        lastByteReplace = null;
        byteOrig_patch1_arm = null;
        mask_patch1_arm = null;
        byteReplace_patch1_arm = null;
        rep_mask_patch1_arm = null;
        byteOrig_patch1_arm_1 = null;
        mask_patch1_arm_1 = null;
        byteReplace_patch1_arm_1 = null;
        rep_mask_patch1_arm_1 = null;
        byteOrig_patch2_arm = null;
        mask_patch2_arm = null;
        byteReplace_patch2_arm = null;
        rep_mask_patch2_arm = null;
        byteOrig_patch2_arm_1 = null;
        mask_patch2_arm_1 = null;
        byteReplace_patch2_arm_1 = null;
        rep_mask_patch2_arm_1 = null;
        byteOrig_patch3_arm = null;
        mask_patch3_arm = null;
        byteReplace_patch3_arm = null;
        rep_mask_patch3_arm = null;
        byteOrig_patch3p_arm = null;
        mask_patch3p_arm = null;
        byteReplace_patch3p_arm = null;
        rep_mask_patch3p_arm = null;
        byteOrig_patch3cm_arm = null;
        mask_patch3cm_arm = null;
        byteReplace_patch3cm_arm = null;
        rep_mask_patch3cm_arm = null;
        byteOrig_patch3cm_arm64 = null;
        mask_patch3cm_arm64 = null;
        byteReplace_patch3cm_arm64 = null;
        rep_mask_patch3cm_arm64 = null;
        byteOrig_patch1_arm64 = null;
        mask_patch1_arm64 = null;
        byteReplace_patch1_arm64 = null;
        rep_mask_patch1_arm64 = null;
        byteOrig_patch1_arm64_1 = null;
        mask_patch1_arm64_1 = null;
        byteReplace_patch1_arm64_1 = null;
        rep_mask_patch1_arm64_1 = null;
        byteOrig_patch1_arm64_2 = null;
        mask_patch1_arm64_2 = null;
        byteReplace_patch1_arm64_2 = null;
        rep_mask_patch1_arm64_2 = null;
        byteOrig_patch2_arm64 = null;
        mask_patch2_arm64 = null;
        byteReplace_patch2_arm64 = null;
        rep_mask_patch2_arm64 = null;
        byteOrig_patch2_arm64_1 = null;
        mask_patch2_arm64_1 = null;
        byteReplace_patch2_arm64_1 = null;
        rep_mask_patch2_arm64_1 = null;
        byteOrig_patch2_arm64_2 = null;
        mask_patch2_arm64_2 = null;
        byteReplace_patch2_arm64_2 = null;
        rep_mask_patch2_arm64_2 = null;
        byteOrig_patch3_arm64 = null;
        mask_patch3_arm64 = null;
        byteReplace_patch3_arm64 = null;
        rep_mask_patch3_arm64 = null;
        byteOrig_patch3p_arm64 = null;
        mask_patch3p_arm64 = null;
        byteReplace_patch3p_arm64 = null;
        rep_mask_patch3p_arm64 = null;
        byteOrig_patch1_x86 = null;
        mask_patch1_x86 = null;
        byteReplace_patch1_x86 = null;
        rep_mask_patch1_x86 = null;
        byteOrig_patch2_x86 = null;
        mask_patch2_x86 = null;
        byteReplace_patch2_x86 = null;
        rep_mask_patch2_x86 = null;
        byteOrig_patch3_x86 = null;
        mask_patch3_x86 = null;
        byteReplace_patch3_x86 = null;
        rep_mask_patch3_x86 = null;
        byteOrig_patch3p_x86 = null;
        mask_patch3p_x86 = null;
        byteReplace_patch3p_x86 = null;
        rep_mask_patch3p_x86 = null;
        byteOrig_patch2_x86_64 = null;
        mask_patch2_x86_64 = null;
        byteReplace_patch2_x86_64 = null;
        rep_mask_patch2_x86_64 = null;
        byteOrig2 = null;
        mask2 = null;
        byteReplace2 = null;
        rep_mask2 = null;
        byteOrigOatUpd1 = null;
        maskOatUpd1 = null;
        byteReplaceOatUpd1 = null;
        rep_maskOatUpd1 = null;
        byteOrigOatUpd2 = null;
        maskOatUpd2 = null;
        byteReplaceOatUpd2 = null;
        rep_maskOatUpd2 = null;
        byteOrigOat1 = null;
        maskOat1 = null;
        byteReplaceOat1 = null;
        rep_maskOat1 = null;
        byteOrigOat2 = null;
        maskOat2 = null;
        byteReplaceOat2 = null;
        rep_maskOat2 = null;
        byteOrigOat3 = null;
        maskOat3 = null;
        byteReplaceOat3 = null;
        rep_maskOat3 = null;
        byteOrigOat3_1 = null;
        maskOat3_1 = null;
        byteReplaceOat3_1 = null;
        rep_maskOat3_1 = null;
        byteOrigOat3_2 = null;
        maskOat3_2 = null;
        byteReplaceOat3_2 = null;
        rep_maskOat3_2 = null;
        byteOrigOatUpd4 = null;
        maskOatUpd4 = null;
        byteReplaceOatUpd4 = null;
        rep_maskOatUpd4 = null;
        byteOrigOatUpd4_1 = null;
        maskOatUpd4_1 = null;
        byteReplaceOatUpd4_1 = null;
        rep_maskOatUpd4_1 = null;
        byteOrigOatUpd5 = null;
        maskOatUpd5 = null;
        byteReplaceOatUpd5 = null;
        rep_maskOatUpd5 = null;
        byteOrigOatUpd5_1 = null;
        maskOatUpd5_1 = null;
        byteReplaceOatUpd5_1 = null;
        rep_maskOatUpd5_1 = null;
        byteOrigOat4 = null;
        maskOat4 = null;
        byteReplaceOat4 = null;
        rep_maskOat4 = null;
        byteOrigOat5 = null;
        maskOat5 = null;
        byteReplaceOat5 = null;
        rep_maskOat5 = null;
        byteOrigOat6 = null;
        maskOat6 = null;
        byteReplaceOat6 = null;
        rep_maskOat6 = null;
        byteOrigOat6_1 = null;
        maskOat6_1 = null;
        byteReplaceOat6_1 = null;
        rep_maskOat6_1 = null;
        byteOrigOat7 = null;
        maskOat7 = null;
        byteReplaceOat7 = null;
        rep_maskOat7 = null;
        byteOrigOat7_1 = null;
        maskOat7_1 = null;
        byteReplaceOat7_1 = null;
        rep_maskOat7_1 = null;
        byteOrigSOat1 = null;
        maskSOat1 = null;
        byteReplaceSOat1 = null;
        rep_maskSOat1 = null;
        byteOrigSOat1_1 = null;
        maskSOat1_1 = null;
        byteReplaceSOat1_1 = null;
        rep_maskSOat1_1 = null;
        byteOrigSOat1_2 = null;
        maskSOat1_2 = null;
        byteReplaceSOat1_2 = null;
        rep_maskSOat1_2 = null;
        byteOrigSOat2 = null;
        maskSOat2 = null;
        byteReplaceSOat2 = null;
        rep_maskSOat2 = null;
        byteOrigSOat4 = null;
        maskSOat4 = null;
        byteReplaceSOat4 = null;
        rep_maskSOat4 = null;
        byteOrigSOat5 = null;
        maskSOat5 = null;
        byteReplaceSOat5 = null;
        rep_maskSOat5 = null;
        byteOrigSOat5_1 = null;
        maskSOat5_1 = null;
        byteReplaceSOat5_1 = null;
        rep_maskSOat5_1 = null;
        byteOrigSOat6_2 = null;
        maskSOat6_2 = null;
        byteReplaceSOat6_2 = null;
        rep_maskSOat6_2 = null;
        byteOrigSOat6_3 = null;
        maskSOat6_3 = null;
        byteReplaceSOat6_3 = null;
        rep_maskSOat6_3 = null;
        byteOrigSOat6_4 = null;
        maskSOat6_4 = null;
        byteReplaceSOat6_4 = null;
        rep_maskSOat6_4 = null;
        byteOrigSOat6_5 = null;
        maskSOat6_5 = null;
        byteReplaceSOat6_5 = null;
        rep_maskSOat6_5 = null;
        byteOrigSOat3 = null;
        maskSOat3 = null;
        byteReplaceSOat3 = null;
        rep_maskSOat3 = null;
        byteOrigSOat6 = null;
        maskSOat6 = null;
        byteReplaceSOat6 = null;
        rep_maskSOat6 = null;
        byteOrigSOat7 = null;
        maskSOat7 = null;
        byteReplaceSOat7 = null;
        rep_maskSOat7 = null;
        byteOrigSOat7_2 = null;
        maskSOat7_2 = null;
        byteReplaceSOat7_2 = null;
        rep_maskSOat7_2 = null;
        byteOrigSOat8 = null;
        maskSOat8 = null;
        byteReplaceSOat8 = null;
        rep_maskSOat8 = null;
        byteOrigSOat8_1 = null;
        maskSOat8_1 = null;
        byteReplaceSOat8_1 = null;
        rep_maskSOat8_1 = null;
        byteOrigSOat8_2 = null;
        maskSOat8_2 = null;
        byteReplaceSOat8_2 = null;
        rep_maskSOat8_2 = null;
        byteOrigSOat9 = null;
        maskSOat9 = null;
        byteReplaceSOat9 = null;
        rep_maskSOat9 = null;
        byteOrigSOat9_1 = null;
        maskSOat9_1 = null;
        byteReplaceSOat9_1 = null;
        rep_maskSOat9_1 = null;
        byteOrigSOat9_2 = null;
        maskSOat9_2 = null;
        byteReplaceSOat9_2 = null;
        rep_maskSOat9_2 = null;
        byteOrigSOat9_3 = null;
        maskSOat9_3 = null;
        byteReplaceSOat9_3 = null;
        rep_maskSOat9_3 = null;
        byteOrigSOat10 = null;
        maskSOat10 = null;
        byteReplaceSOat10 = null;
        rep_maskSOat10 = null;
        byteOrigSOat10_1 = null;
        maskSOat10_1 = null;
        byteReplaceSOat10_1 = null;
        rep_maskSOat10_1 = null;
        byteOrigSOat11 = null;
        maskSOat11 = null;
        byteReplaceSOat11 = null;
        rep_maskSOat11 = null;
        byteOrigSOat11_1 = null;
        maskSOat11_1 = null;
        byteReplaceSOat11_1 = null;
        rep_maskSOat11_1 = null;
        byteOrigSOat11_2 = null;
        maskSOat11_2 = null;
        byteReplaceSOat11_2 = null;
        rep_maskSOat11_2 = null;
        byteOrigSOat12 = null;
        maskSOat12 = null;
        byteReplaceSOat12 = null;
        rep_maskSOat12 = null;
        byteOrigSOat12_1 = null;
        maskSOat12_1 = null;
        byteReplaceSOat12_1 = null;
        rep_maskSOat12_1 = null;
        byteOrigS2 = null;
        maskS2 = null;
        byteReplaceS2 = null;
        rep_maskS2 = null;
        byteOrigS3 = null;
        maskS3 = null;
        byteReplaceS3 = null;
        rep_maskS3 = null;
        byteOrigS4 = null;
        maskS4 = null;
        byteReplaceS4 = null;
        rep_maskS4 = null;
        byteOrigS5 = null;
        maskS5 = null;
        byteReplaceS5 = null;
        rep_maskS5 = null;
        byteOrigS6 = null;
        maskS6 = null;
        byteReplaceS6 = null;
        rep_maskS6 = null;
        byteOrigS7 = null;
        maskS7 = null;
        byteReplaceS7 = null;
        rep_maskS7 = null;
        byteOrigS7_1 = null;
        maskS7_1 = null;
        byteReplaceS7_1 = null;
        rep_maskS7_1 = null;
        byteOrigS13 = null;
        maskS13 = null;
        byteReplaceS13 = null;
        rep_maskS13 = null;
        byteOrigS13_1 = null;
        maskS13_1 = null;
        byteReplaceS13_1 = null;
        rep_maskS13_1 = null;
        byteOrigS14 = null;
        maskS14 = null;
        byteReplaceS14 = null;
        rep_maskS14 = null;
        byteOrig3 = null;
        byteReplace3 = null;
        byteOrig4 = null;
        mask4 = null;
        byteReplace4 = null;
        rep_mask4 = null;
        byteOrig5 = null;
        mask5 = null;
        byteReplace5 = null;
        rep_mask5 = null;
        byteOrig6 = null;
        mask6 = null;
        byteReplace6 = null;
        rep_mask6 = null;
        byteOrig7 = null;
        mask7 = null;
        byteReplace7 = null;
        rep_mask7 = null;
        byteOrig8 = null;
        mask8 = null;
        byteReplace8 = null;
        rep_mask8 = null;
        byteOrig9 = null;
        mask9 = null;
        byteReplace9 = null;
        rep_mask9 = null;
        byteOrig10 = null;
        mask10 = null;
        byteReplace10 = null;
        rep_mask10 = null;
        byteOrig11 = null;
        mask11 = null;
        byteReplace11 = null;
        rep_mask11 = null;
        byteOrig12 = null;
        mask12 = null;
        byteReplace12 = null;
        rep_mask12 = null;
        byteOrig13 = null;
        mask13 = null;
        byteReplace13 = null;
        rep_mask13 = null;
        byteOrig14 = null;
        mask14 = null;
        byteReplace14 = null;
        rep_mask14 = null;
        byteOrig15 = null;
        mask15 = null;
        byteReplace15 = null;
        rep_mask15 = null;
        byteOrig16 = null;
        mask16 = null;
        byteReplace16 = null;
        rep_mask16 = null;
        byteOrig17 = null;
        mask17 = null;
        byteReplace17 = null;
        rep_mask17 = null;
        byteOrig18 = null;
        mask18 = null;
        byteReplace18 = null;
        rep_mask18 = null;
        byteOrig19 = null;
        mask19 = null;
        byteReplace19 = null;
        rep_mask19 = null;
        byteOrig20 = null;
        mask20 = null;
        byteReplace20 = null;
        rep_mask20 = null;
        byteOrig21 = null;
        mask21 = null;
        byteReplace21 = null;
        rep_mask21 = null;
        byteOrig22 = null;
        mask22 = null;
        byteReplace22 = null;
        rep_mask22 = null;
        byteOrig23 = null;
        mask23 = null;
        byteReplace23 = null;
        rep_mask23 = null;
        patchOatUpd1 = false;
        patchOat1 = false;
        patchOat2 = false;
        patchOat3 = false;
        patchOat4 = false;
        patchOat6 = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean applyPatch(int n, byte by, byte[] arrby, byte[] arrby2, byte[] arrby3, byte[] arrby4, boolean bl) {
        if (arrby == null) return false;
        if (by != arrby[0]) return false;
        if (!bl) return false;
        try {
            fileBytes.position(n + (-1 + arrby.length));
            if (fileBytes.get() != arrby[-1 + arrby.length]) return false;
            if (arrby4[0] == 0) {
                arrby3[0] = by;
            }
            int n2 = 1;
            fileBytes.position(n + 1);
            byte by2 = fileBytes.get();
            while (by2 == arrby[n2] || arrby2[n2] == 1) {
                if (arrby4[n2] == 0) {
                    arrby3[n2] = by2;
                }
                if (arrby4[n2] == 3) {
                    arrby3[n2] = (byte)(by2 & 15);
                }
                if (arrby4[n2] == 2) {
                    arrby3[n2] = (byte)((by2 & 15) + 16 * (by2 & 15));
                }
                if (++n2 == arrby.length) {
                    fileBytes.position(n);
                    fileBytes.put(arrby3);
                    fileBytes.force();
                    return true;
                }
                by2 = fileBytes.get();
            }
            fileBytes.position(n + 1);
            return false;
        }
        catch (IllegalArgumentException var7_9) {
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    public static void main(String[] var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.UnsupportedOperationException
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op01WithProcessedDataAndByteJumps.getAStoreIdx(Op01WithProcessedDataAndByteJumps.java:77)
        // org.benf.cfr.reader.entities.exceptions.ExceptionGroup.isSynchronisedHandler(ExceptionGroup.java:90)
        // org.benf.cfr.reader.entities.exceptions.ExceptionGroup.removeSynchronisedHandlers(ExceptionGroup.java:67)
        // org.benf.cfr.reader.entities.exceptions.ExceptionAggregator.removeSynchronisedHandlers(ExceptionAggregator.java:376)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:317)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    static void patchWithOatDumpP12(ArrayList<File> var0_1, String[] var1, boolean var2_3, boolean var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 14[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    static void patchWithOatDumpP3(File var0_1, String[] var1, boolean var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public static void unzip(File var0_1, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

}

