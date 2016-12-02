/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Key
 *  java.security.KeyStore
 *  java.security.PrivateKey
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 */
package kellinwood.security.zipsigner.optional;

import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import kellinwood.security.zipsigner.ZipSigner;
import kellinwood.security.zipsigner.optional.KeyStoreFileManager;

public class CustomKeySigner {
    public static void signZip(ZipSigner zipSigner, String string, char[] arrc, String string2, char[] arrc2, String string3, String string4, String string5) throws Exception {
        zipSigner.issueLoadingCertAndKeysProgressEvent();
        KeyStore keyStore = KeyStoreFileManager.loadKeyStore(string, arrc);
        zipSigner.setKeys("custom", (X509Certificate)keyStore.getCertificate(string2), (PrivateKey)keyStore.getKey(string2, arrc2), string3, null);
        zipSigner.signZip(string4, string5);
    }
}

