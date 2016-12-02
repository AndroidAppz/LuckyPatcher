/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.security.MessageDigest
 *  org.spongycastle.util.encoders.HexTranslator
 */
package kellinwood.security.zipsigner.optional;

import java.security.MessageDigest;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.security.zipsigner.Base64;
import org.spongycastle.util.encoders.HexTranslator;

public class Fingerprint {
    static LoggerInterface logger = LoggerManager.getLogger(Fingerprint.class.getName());

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String base64Fingerprint(String string, byte[] arrby) {
        try {
            byte[] arrby2 = Fingerprint.calcDigest(string, arrby);
            if (arrby2 != null) return Base64.encode(arrby2);
            return null;
        }
        catch (Exception var2_4) {
            logger.error(var2_4.getMessage(), (Throwable)var2_4);
            return null;
        }
    }

    static byte[] calcDigest(String string, byte[] arrby) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)string);
            messageDigest.update(arrby);
            byte[] arrby2 = messageDigest.digest();
            return arrby2;
        }
        catch (Exception var2_4) {
            logger.error(var2_4.getMessage(), (Throwable)var2_4);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String hexFingerprint(String string, byte[] arrby) {
        StringBuilder stringBuilder;
        byte[] arrby2;
        int n;
        try {
            byte[] arrby3 = Fingerprint.calcDigest(string, arrby);
            if (arrby3 == null) {
                return null;
            }
            HexTranslator hexTranslator = new HexTranslator();
            arrby2 = new byte[2 * arrby3.length];
            hexTranslator.encode(arrby3, 0, arrby3.length, arrby2, 0);
            stringBuilder = new StringBuilder();
            n = 0;
        }
        catch (Exception var2_8) {
            logger.error(var2_8.getMessage(), (Throwable)var2_8);
            return null;
        }
        while (n < arrby2.length) {
            stringBuilder.append(arrby2[n]);
            stringBuilder.append(arrby2[n + 1]);
            if (n != -2 + arrby2.length) {
                stringBuilder.append(':');
            }
            n += 2;
        }
        return stringBuilder.toString().toUpperCase();
    }
}

