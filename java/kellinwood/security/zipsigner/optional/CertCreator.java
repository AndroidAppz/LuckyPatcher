package kellinwood.security.zipsigner.optional;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import kellinwood.security.zipsigner.KeySet;
import net.lingala.zip4j.util.InternalZipConstants;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.x509.X509V3CertificateGenerator;

public class CertCreator {
    public static void createKeystoreAndKey(String storePath, char[] password, String keyName, DistinguishedNameValues distinguishedNameValues) {
        createKeystoreAndKey(storePath, password, "RSA", InternalZipConstants.UFT8_NAMES_FLAG, keyName, password, "SHA1withRSA", 30, distinguishedNameValues);
    }

    public static KeySet createKeystoreAndKey(String storePath, char[] storePass, String keyAlgorithm, int keySize, String keyName, char[] keyPass, String certSignatureAlgorithm, int certValidityYears, DistinguishedNameValues distinguishedNameValues) {
        try {
            KeySet keySet = createKey(keyAlgorithm, keySize, keyName, certSignatureAlgorithm, certValidityYears, distinguishedNameValues);
            KeyStore privateKS = KeyStoreFileManager.createKeyStore(storePath, storePass);
            privateKS.setKeyEntry(keyName, keySet.getPrivateKey(), keyPass, new Certificate[]{keySet.getPublicKey()});
            if (new File(storePath).exists()) {
                throw new IOException("File already exists: " + storePath);
            }
            KeyStoreFileManager.writeKeyStore(privateKS, storePath, storePass);
            return keySet;
        } catch (RuntimeException x) {
            throw x;
        } catch (Exception x2) {
            throw new RuntimeException(x2.getMessage(), x2);
        }
    }

    public static KeySet createKey(String storePath, char[] storePass, String keyAlgorithm, int keySize, String keyName, char[] keyPass, String certSignatureAlgorithm, int certValidityYears, DistinguishedNameValues distinguishedNameValues) {
        try {
            KeySet keySet = createKey(keyAlgorithm, keySize, keyName, certSignatureAlgorithm, certValidityYears, distinguishedNameValues);
            KeyStore privateKS = KeyStoreFileManager.loadKeyStore(storePath, storePass);
            privateKS.setKeyEntry(keyName, keySet.getPrivateKey(), keyPass, new Certificate[]{keySet.getPublicKey()});
            KeyStoreFileManager.writeKeyStore(privateKS, storePath, storePass);
            return keySet;
        } catch (RuntimeException x) {
            throw x;
        } catch (Exception x2) {
            throw new RuntimeException(x2.getMessage(), x2);
        }
    }

    public static KeySet createKey(String keyAlgorithm, int keySize, String keyName, String certSignatureAlgorithm, int certValidityYears, DistinguishedNameValues distinguishedNameValues) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(keyAlgorithm);
            keyPairGenerator.initialize(keySize);
            KeyPair KPair = keyPairGenerator.generateKeyPair();
            X509V3CertificateGenerator v3CertGen = new X509V3CertificateGenerator();
            X509Principal principal = distinguishedNameValues.getPrincipal();
            BigInteger serialNumber = BigInteger.valueOf((long) new SecureRandom().nextInt());
            while (serialNumber.compareTo(BigInteger.ZERO) < 0) {
                serialNumber = BigInteger.valueOf((long) new SecureRandom().nextInt());
            }
            v3CertGen.setSerialNumber(serialNumber);
            v3CertGen.setIssuerDN(principal);
            v3CertGen.setNotBefore(new Date(System.currentTimeMillis() - 2592000000L));
            v3CertGen.setNotAfter(new Date(System.currentTimeMillis() + (31622400000L * ((long) certValidityYears))));
            v3CertGen.setSubjectDN(principal);
            v3CertGen.setPublicKey(KPair.getPublic());
            v3CertGen.setSignatureAlgorithm(certSignatureAlgorithm);
            X509Certificate PKCertificate = v3CertGen.generate(KPair.getPrivate(), "BC");
            KeySet keySet = new KeySet();
            keySet.setName(keyName);
            keySet.setPrivateKey(KPair.getPrivate());
            keySet.setPublicKey(PKCertificate);
            return keySet;
        } catch (Exception x) {
            throw new RuntimeException(x.getMessage(), x);
        }
    }
}
