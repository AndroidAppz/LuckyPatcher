/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivateKey
 *  java.security.cert.X509Certificate
 */
package kellinwood.security.zipsigner;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class KeySet {
    String name;
    PrivateKey privateKey;
    X509Certificate publicKey;
    byte[] sigBlockTemplate;
    String signatureAlgorithm;

    public KeySet() {
        this.publicKey = null;
        this.privateKey = null;
        this.sigBlockTemplate = null;
        this.signatureAlgorithm = "SHA1withRSA";
    }

    public KeySet(String string, X509Certificate x509Certificate, PrivateKey privateKey, String string2, byte[] arrby) {
        this.publicKey = null;
        this.privateKey = null;
        this.sigBlockTemplate = null;
        this.signatureAlgorithm = "SHA1withRSA";
        this.name = string;
        this.publicKey = x509Certificate;
        this.privateKey = privateKey;
        if (string2 != null) {
            this.signatureAlgorithm = string2;
        }
        this.sigBlockTemplate = arrby;
    }

    public KeySet(String string, X509Certificate x509Certificate, PrivateKey privateKey, byte[] arrby) {
        this.publicKey = null;
        this.privateKey = null;
        this.sigBlockTemplate = null;
        this.signatureAlgorithm = "SHA1withRSA";
        this.name = string;
        this.publicKey = x509Certificate;
        this.privateKey = privateKey;
        this.sigBlockTemplate = arrby;
    }

    public String getName() {
        return this.name;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public X509Certificate getPublicKey() {
        return this.publicKey;
    }

    public byte[] getSigBlockTemplate() {
        return this.sigBlockTemplate;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public void setName(String string) {
        this.name = string;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public void setPublicKey(X509Certificate x509Certificate) {
        this.publicKey = x509Certificate;
    }

    public void setSigBlockTemplate(byte[] arrby) {
        this.sigBlockTemplate = arrby;
    }

    public void setSignatureAlgorithm(String string) {
        if (string == null) {
            return;
        }
        this.signatureAlgorithm = string;
    }
}

