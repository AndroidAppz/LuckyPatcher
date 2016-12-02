package kellinwood.security.zipsigner;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class KeySet {
    String name;
    PrivateKey privateKey = null;
    X509Certificate publicKey = null;
    byte[] sigBlockTemplate = null;
    String signatureAlgorithm = "SHA1withRSA";

    public KeySet(String name, X509Certificate publicKey, PrivateKey privateKey, byte[] sigBlockTemplate) {
        this.name = name;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.sigBlockTemplate = sigBlockTemplate;
    }

    public KeySet(String name, X509Certificate publicKey, PrivateKey privateKey, String signatureAlgorithm, byte[] sigBlockTemplate) {
        this.name = name;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        if (signatureAlgorithm != null) {
            this.signatureAlgorithm = signatureAlgorithm;
        }
        this.sigBlockTemplate = sigBlockTemplate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public X509Certificate getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(X509Certificate publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public byte[] getSigBlockTemplate() {
        return this.sigBlockTemplate;
    }

    public void setSigBlockTemplate(byte[] sigBlockTemplate) {
        this.sigBlockTemplate = sigBlockTemplate;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public void setSignatureAlgorithm(String signatureAlgorithm) {
        if (signatureAlgorithm == null) {
            signatureAlgorithm = "SHA1withRSA";
        } else {
            this.signatureAlgorithm = signatureAlgorithm;
        }
    }
}
