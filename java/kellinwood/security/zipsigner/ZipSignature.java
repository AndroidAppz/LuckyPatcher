package kellinwood.security.zipsigner;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class ZipSignature {
    byte[] afterAlgorithmIdBytes = new byte[]{(byte) 4, (byte) 20};
    byte[] algorithmIdBytes = new byte[]{(byte) 48, (byte) 9, (byte) 6, (byte) 5, (byte) 43, (byte) 14, (byte) 3, (byte) 2, (byte) 26, (byte) 5, (byte) 0};
    byte[] beforeAlgorithmIdBytes = new byte[]{(byte) 48, (byte) 33};
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    MessageDigest md = MessageDigest.getInstance("SHA1");

    public void initSign(PrivateKey privateKey) throws InvalidKeyException {
        this.cipher.init(1, privateKey);
    }

    public void update(byte[] data) {
        this.md.update(data);
    }

    public void update(byte[] data, int offset, int count) {
        this.md.update(data, offset, count);
    }

    public byte[] sign() throws BadPaddingException, IllegalBlockSizeException {
        this.cipher.update(this.beforeAlgorithmIdBytes);
        this.cipher.update(this.algorithmIdBytes);
        this.cipher.update(this.afterAlgorithmIdBytes);
        this.cipher.update(this.md.digest());
        return this.cipher.doFinal();
    }
}
