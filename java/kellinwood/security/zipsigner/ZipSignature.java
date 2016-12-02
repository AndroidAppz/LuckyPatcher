/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.InvalidKeyException
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.PrivateKey
 *  javax.crypto.BadPaddingException
 *  javax.crypto.Cipher
 *  javax.crypto.IllegalBlockSizeException
 */
package kellinwood.security.zipsigner;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PrivateKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class ZipSignature {
    byte[] afterAlgorithmIdBytes = new byte[]{4, 20};
    byte[] algorithmIdBytes = new byte[]{48, 9, 6, 5, 43, 14, 3, 2, 26, 5, 0};
    byte[] beforeAlgorithmIdBytes = new byte[]{48, 33};
    Cipher cipher = Cipher.getInstance((String)"RSA/ECB/PKCS1Padding");
    MessageDigest md = MessageDigest.getInstance((String)"SHA1");

    public void initSign(PrivateKey privateKey) throws InvalidKeyException {
        this.cipher.init(1, (Key)privateKey);
    }

    public byte[] sign() throws BadPaddingException, IllegalBlockSizeException {
        this.cipher.update(this.beforeAlgorithmIdBytes);
        this.cipher.update(this.algorithmIdBytes);
        this.cipher.update(this.afterAlgorithmIdBytes);
        this.cipher.update(this.md.digest());
        return this.cipher.doFinal();
    }

    public void update(byte[] arrby) {
        this.md.update(arrby);
    }

    public void update(byte[] arrby, int n, int n2) {
        this.md.update(arrby, n, n2);
    }
}

