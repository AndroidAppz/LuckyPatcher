/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.security.Key
 *  java.security.KeyPair
 *  java.security.KeyPairGenerator
 *  java.security.KeyStore
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.SecureRandom
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.Date
 *  org.spongycastle.asn1.x509.X509Name
 *  org.spongycastle.jce.X509Principal
 *  org.spongycastle.x509.X509V3CertificateGenerator
 */
package kellinwood.security.zipsigner.optional;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import kellinwood.security.zipsigner.KeySet;
import kellinwood.security.zipsigner.optional.DistinguishedNameValues;
import kellinwood.security.zipsigner.optional.KeyStoreFileManager;
import org.spongycastle.asn1.x509.X509Name;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.x509.X509V3CertificateGenerator;

public class CertCreator {
    public static KeySet createKey(String string, int n, String string2, String string3, int n2, DistinguishedNameValues distinguishedNameValues) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance((String)string);
            keyPairGenerator.initialize(n);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            X509V3CertificateGenerator x509V3CertificateGenerator = new X509V3CertificateGenerator();
            X509Principal x509Principal = distinguishedNameValues.getPrincipal();
            BigInteger bigInteger = BigInteger.valueOf((long)new SecureRandom().nextInt());
            while (bigInteger.compareTo(BigInteger.ZERO) < 0) {
                bigInteger = BigInteger.valueOf((long)new SecureRandom().nextInt());
            }
            x509V3CertificateGenerator.setSerialNumber(bigInteger);
            x509V3CertificateGenerator.setIssuerDN((X509Name)x509Principal);
            x509V3CertificateGenerator.setNotBefore(new Date(System.currentTimeMillis() - 2592000000L));
            x509V3CertificateGenerator.setNotAfter(new Date(System.currentTimeMillis() + 31622400000L * (long)n2));
            x509V3CertificateGenerator.setSubjectDN((X509Name)x509Principal);
            x509V3CertificateGenerator.setPublicKey(keyPair.getPublic());
            x509V3CertificateGenerator.setSignatureAlgorithm(string3);
            X509Certificate x509Certificate = x509V3CertificateGenerator.generate(keyPair.getPrivate(), "BC");
            KeySet keySet = new KeySet();
            keySet.setName(string2);
            keySet.setPrivateKey(keyPair.getPrivate());
            keySet.setPublicKey(x509Certificate);
            return keySet;
        }
        catch (Exception var6_13) {
            throw new RuntimeException(var6_13.getMessage(), (Throwable)var6_13);
        }
    }

    public static KeySet createKey(String string, char[] arrc, String string2, int n, String string3, char[] arrc2, String string4, int n2, DistinguishedNameValues distinguishedNameValues) {
        try {
            KeySet keySet = CertCreator.createKey(string2, n, string3, string4, n2, distinguishedNameValues);
            KeyStore keyStore = KeyStoreFileManager.loadKeyStore(string, arrc);
            PrivateKey privateKey = keySet.getPrivateKey();
            Certificate[] arrcertificate = new Certificate[]{keySet.getPublicKey()};
            keyStore.setKeyEntry(string3, (Key)privateKey, arrc2, arrcertificate);
            KeyStoreFileManager.writeKeyStore(keyStore, string, arrc);
            return keySet;
        }
        catch (RuntimeException var10_13) {
            throw var10_13;
        }
        catch (Exception var9_14) {
            throw new RuntimeException(var9_14.getMessage(), (Throwable)var9_14);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static KeySet createKeystoreAndKey(String string, char[] arrc, String string2, int n, String string3, char[] arrc2, String string4, int n2, DistinguishedNameValues distinguishedNameValues) {
        try {
            KeySet keySet = CertCreator.createKey(string2, n, string3, string4, n2, distinguishedNameValues);
            KeyStore keyStore = KeyStoreFileManager.createKeyStore(string, arrc);
            PrivateKey privateKey = keySet.getPrivateKey();
            Certificate[] arrcertificate = new Certificate[]{keySet.getPublicKey()};
            keyStore.setKeyEntry(string3, (Key)privateKey, arrc2, arrcertificate);
            if (new File(string).exists()) {
                throw new IOException("File already exists: " + string);
            }
            KeyStoreFileManager.writeKeyStore(keyStore, string, arrc);
            return keySet;
        }
        catch (RuntimeException var10_13) {
            throw var10_13;
        }
        catch (Exception var9_14) {
            throw new RuntimeException(var9_14.getMessage(), (Throwable)var9_14);
        }
    }

    public static void createKeystoreAndKey(String string, char[] arrc, String string2, DistinguishedNameValues distinguishedNameValues) {
        CertCreator.createKeystoreAndKey(string, arrc, "RSA", 2048, string2, arrc, "SHA1withRSA", 30, distinguishedNameValues);
    }
}

