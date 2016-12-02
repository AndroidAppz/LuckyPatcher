/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.InvalidKeyException
 *  java.security.KeyFactory
 *  java.security.NoSuchAlgorithmException
 *  java.security.PublicKey
 *  java.security.Signature
 *  java.security.SignatureException
 *  java.security.spec.InvalidKeySpecException
 *  java.security.spec.KeySpec
 *  java.security.spec.X509EncodedKeySpec
 */
package com.google.android.finsky.billing.iab.google.util;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.finsky.billing.iab.google.util.Base64;
import com.google.android.finsky.billing.iab.google.util.Base64DecoderException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Security {
    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private static final String TAG = "IABUtil/Security";

    public static PublicKey generatePublicKey(String string) {
        try {
            byte[] arrby = Base64.decode(string);
            PublicKey publicKey = KeyFactory.getInstance((String)"RSA").generatePublic((KeySpec)new X509EncodedKeySpec(arrby));
            return publicKey;
        }
        catch (NoSuchAlgorithmException var5_3) {
            throw new RuntimeException((Throwable)var5_3);
        }
        catch (InvalidKeySpecException var3_4) {
            Log.e((String)"IABUtil/Security", (String)"Invalid key specification.");
            throw new IllegalArgumentException((Throwable)var3_4);
        }
        catch (Base64DecoderException var1_5) {
            Log.e((String)"IABUtil/Security", (String)"Base64 decoding failed.");
            throw new IllegalArgumentException((Throwable)var1_5);
        }
    }

    public static boolean verify(PublicKey publicKey, String string, String string2) {
        try {
            Signature signature = Signature.getInstance((String)"SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(string.getBytes());
            if (!signature.verify(Base64.decode(string2))) {
                Log.e((String)"IABUtil/Security", (String)"Signature verification failed.");
                return false;
            }
            return true;
        }
        catch (NoSuchAlgorithmException var9_4) {
            Log.e((String)"IABUtil/Security", (String)"NoSuchAlgorithmException.");
            return false;
        }
        catch (InvalidKeyException var7_5) {
            Log.e((String)"IABUtil/Security", (String)"Invalid key specification.");
            return false;
        }
        catch (SignatureException var5_6) {
            Log.e((String)"IABUtil/Security", (String)"Signature exception.");
            return false;
        }
        catch (Base64DecoderException var3_7) {
            Log.e((String)"IABUtil/Security", (String)"Base64 decoding failed.");
            return false;
        }
    }

    public static boolean verifyPurchase(String string, String string2, String string3) {
        if (string2 == null) {
            Log.e((String)"IABUtil/Security", (String)"data is null");
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)string3) && !Security.verify(Security.generatePublicKey(string), string2, string3)) {
            Log.w((String)"IABUtil/Security", (String)"signature does not match data.");
            return false;
        }
        return true;
    }
}

