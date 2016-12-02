package kellinwood.security.zipsigner.optional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PasswordProtection;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.tukaani.xz.LZMA2Options;

public class KeyStoreFileManager {
    static LoggerInterface logger = LoggerManager.getLogger(KeyStoreFileManager.class.getName());
    static Provider provider = new BouncyCastleProvider();

    static {
        Security.addProvider(getProvider());
    }

    public static Provider getProvider() {
        return provider;
    }

    public static void setProvider(Provider provider) {
        if (provider != null) {
            Security.removeProvider(provider.getName());
        }
        provider = provider;
        Security.addProvider(provider);
    }

    public static KeyStore loadKeyStore(String keystorePath, String encodedPassword) throws Exception {
        char[] password = null;
        if (encodedPassword != null) {
            try {
                password = PasswordObfuscator.getInstance().decodeKeystorePassword(keystorePath, encodedPassword);
            } catch (Throwable th) {
                if (null != null) {
                    PasswordObfuscator.flush(null);
                }
            }
        }
        KeyStore loadKeyStore = loadKeyStore(keystorePath, password);
        if (password != null) {
            PasswordObfuscator.flush(password);
        }
        return loadKeyStore;
    }

    public static KeyStore createKeyStore(String keystorePath, char[] password) throws Exception {
        KeyStore ks;
        if (keystorePath.toLowerCase().endsWith(".bks")) {
            ks = KeyStore.getInstance("bks", new BouncyCastleProvider());
        } else {
            ks = new JksKeyStore();
        }
        ks.load(null, password);
        return ks;
    }

    public static KeyStore loadKeyStore(String keystorePath, char[] password) throws Exception {
        FileInputStream fis;
        KeyStore keyStore;
        try {
            KeyStore ks = new JksKeyStore();
            try {
                fis = new FileInputStream(keystorePath);
                ks.load(fis, password);
                fis.close();
                keyStore = ks;
                return ks;
            } catch (Exception e) {
                keyStore = ks;
                try {
                    keyStore = KeyStore.getInstance("bks", getProvider());
                    fis = new FileInputStream(keystorePath);
                    keyStore.load(fis, password);
                    fis.close();
                    return keyStore;
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to load keystore: " + e2.getMessage(), e2);
                }
            }
        } catch (Exception e3) {
            keyStore = KeyStore.getInstance("bks", getProvider());
            fis = new FileInputStream(keystorePath);
            keyStore.load(fis, password);
            fis.close();
            return keyStore;
        }
    }

    public static void writeKeyStore(KeyStore ks, String keystorePath, String encodedPassword) throws Exception {
        char[] password = null;
        try {
            password = PasswordObfuscator.getInstance().decodeKeystorePassword(keystorePath, encodedPassword);
            writeKeyStore(ks, keystorePath, password);
        } finally {
            if (password != null) {
                PasswordObfuscator.flush(password);
            }
        }
    }

    public static void writeKeyStore(KeyStore ks, String keystorePath, char[] password) throws Exception {
        File keystoreFile = new File(keystorePath);
        try {
            FileOutputStream fos;
            if (keystoreFile.exists()) {
                File tmpFile = File.createTempFile(keystoreFile.getName(), null, keystoreFile.getParentFile());
                fos = new FileOutputStream(tmpFile);
                ks.store(fos, password);
                fos.flush();
                fos.close();
                renameTo(tmpFile, keystoreFile);
                return;
            }
            fos = new FileOutputStream(keystorePath);
            ks.store(fos, password);
            fos.close();
        } catch (Exception x) {
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(File.createTempFile("zipsigner-error", ".log", keystoreFile.getParentFile())));
                x.printStackTrace(pw);
                pw.flush();
                pw.close();
            } catch (Exception e) {
            }
            throw x;
        }
    }

    static void copyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
        if (destFile.exists() && destFile.isDirectory()) {
            throw new IOException("Destination '" + destFile + "' exists but is a directory");
        }
        FileInputStream input = new FileInputStream(srcFile);
        FileOutputStream output;
        try {
            output = new FileOutputStream(destFile);
            byte[] buffer = new byte[LZMA2Options.DICT_SIZE_MIN];
            long count = 0;
            while (true) {
                int n = input.read(buffer);
                if (-1 != n) {
                    output.write(buffer, 0, n);
                    count += (long) n;
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                    }
                }
            }
            output.close();
            try {
                input.close();
            } catch (IOException e2) {
            }
            if (srcFile.length() != destFile.length()) {
                throw new IOException("Failed to copy full contents from '" + srcFile + "' to '" + destFile + "'");
            } else if (preserveFileDate) {
                destFile.setLastModified(srcFile.lastModified());
            }
        } catch (Throwable th) {
            try {
                input.close();
            } catch (IOException e3) {
            }
        }
    }

    public static void renameTo(File fromFile, File toFile) throws IOException {
        copyFile(fromFile, toFile, true);
        if (!fromFile.delete()) {
            throw new IOException("Failed to delete " + fromFile);
        }
    }

    public static void deleteKey(String storePath, String storePass, String keyName) throws Exception {
        KeyStore ks = loadKeyStore(storePath, storePass);
        ks.deleteEntry(keyName);
        writeKeyStore(ks, storePath, storePass);
    }

    public static String renameKey(String keystorePath, String storePass, String oldKeyName, String newKeyName, String keyPass) throws Exception {
        char[] keyPw = null;
        try {
            KeyStore ks = loadKeyStore(keystorePath, storePass);
            if (ks instanceof JksKeyStore) {
                newKeyName = newKeyName.toLowerCase();
            }
            if (ks.containsAlias(newKeyName)) {
                throw new KeyNameConflictException();
            }
            keyPw = PasswordObfuscator.getInstance().decodeAliasPassword(keystorePath, oldKeyName, keyPass);
            ks.setKeyEntry(newKeyName, ks.getKey(oldKeyName, keyPw), keyPw, new Certificate[]{ks.getCertificate(oldKeyName)});
            ks.deleteEntry(oldKeyName);
            writeKeyStore(ks, keystorePath, storePass);
            return newKeyName;
        } finally {
            PasswordObfuscator.flush(keyPw);
        }
    }

    public static Entry getKeyEntry(String keystorePath, String storePass, String keyName, String keyPass) throws Exception {
        Throwable th;
        char[] keyPw = null;
        PasswordProtection passwordProtection = null;
        try {
            KeyStore ks = loadKeyStore(keystorePath, storePass);
            keyPw = PasswordObfuscator.getInstance().decodeAliasPassword(keystorePath, keyName, keyPass);
            PasswordProtection passwordProtection2 = new PasswordProtection(keyPw);
            try {
                Entry entry = ks.getEntry(keyName, passwordProtection2);
                if (keyPw != null) {
                    PasswordObfuscator.flush(keyPw);
                }
                if (passwordProtection2 != null) {
                    passwordProtection2.destroy();
                }
                return entry;
            } catch (Throwable th2) {
                th = th2;
                passwordProtection = passwordProtection2;
                if (keyPw != null) {
                    PasswordObfuscator.flush(keyPw);
                }
                if (passwordProtection != null) {
                    passwordProtection.destroy();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (keyPw != null) {
                PasswordObfuscator.flush(keyPw);
            }
            if (passwordProtection != null) {
                passwordProtection.destroy();
            }
            throw th;
        }
    }

    public static boolean containsKey(String keystorePath, String storePass, String keyName) throws Exception {
        return loadKeyStore(keystorePath, storePass).containsAlias(keyName);
    }

    public static void validateKeystorePassword(String keystorePath, String encodedPassword) throws Exception {
        try {
            loadKeyStore(keystorePath, encodedPassword);
        } finally {
            if (null != null) {
                PasswordObfuscator.flush(null);
            }
        }
    }

    public static void validateKeyPassword(String keystorePath, String keyName, String encodedPassword) throws Exception {
        char[] password = null;
        try {
            KeyStore ks = loadKeyStore(keystorePath, (char[]) null);
            password = PasswordObfuscator.getInstance().decodeAliasPassword(keystorePath, keyName, encodedPassword);
            ks.getKey(keyName, password);
        } finally {
            if (password != null) {
                PasswordObfuscator.flush(password);
            }
        }
    }
}
