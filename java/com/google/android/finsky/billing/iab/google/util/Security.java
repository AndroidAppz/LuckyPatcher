package com.google.android.finsky.billing.iab.google.util;

import android.text.TextUtils;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Security {
    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private static final String TAG = "IABUtil/Security";

    public static boolean verifyPurchase(String base64PublicKey, String signedData, String signature) {
        if (signedData == null) {
            Log.e(TAG, "data is null");
            return false;
        } else if (TextUtils.isEmpty(signature) || verify(generatePublicKey(base64PublicKey), signedData, signature)) {
            return true;
        } else {
            Log.w(TAG, "signature does not match data.");
            return false;
        }
    }

    public static PublicKey generatePublicKey(String encodedPublicKey) {
        try {
            return KeyFactory.getInstance(KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(encodedPublicKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e2) {
            Log.e(TAG, "Invalid key specification.");
            throw new IllegalArgumentException(e2);
        } catch (Base64DecoderException e3) {
            Log.e(TAG, "Base64 decoding failed.");
            throw new IllegalArgumentException(e3);
        }
    }

    public static boolean verify(PublicKey publicKey, String signedData, String signature) {
        try {
            Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initVerify(publicKey);
            sig.update(signedData.getBytes());
            if (sig.verify(Base64.decode(signature))) {
                return true;
            }
            Log.e(TAG, "Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            Log.e(TAG, "Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            Log.e(TAG, "Signature exception.");
            return false;
        } catch (Base64DecoderException e4) {
            Log.e(TAG, "Base64 decoding failed.");
            return false;
        }
    }
}
