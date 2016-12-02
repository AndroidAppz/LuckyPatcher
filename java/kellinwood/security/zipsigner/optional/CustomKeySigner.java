package kellinwood.security.zipsigner.optional;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import kellinwood.security.zipsigner.ZipSigner;

public class CustomKeySigner {
    public static void signZip(ZipSigner zipSigner, String keystorePath, char[] keystorePw, String certAlias, char[] certPw, String signatureAlgorithm, String inputZipFilename, String outputZipFilename) throws Exception {
        zipSigner.issueLoadingCertAndKeysProgressEvent();
        KeyStore keystore = KeyStoreFileManager.loadKeyStore(keystorePath, keystorePw);
        ZipSigner zipSigner2 = zipSigner;
        zipSigner2.setKeys("custom", (X509Certificate) keystore.getCertificate(certAlias), (PrivateKey) keystore.getKey(certAlias, certPw), signatureAlgorithm, null);
        zipSigner.signZip(inputZipFilename, outputZipFilename);
    }
}
