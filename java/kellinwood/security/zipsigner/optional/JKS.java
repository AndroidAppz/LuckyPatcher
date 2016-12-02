package kellinwood.security.zipsigner.optional;

import com.chelpus.HttpRequest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.spec.SecretKeySpec;

public class JKS extends KeyStoreSpi {
    private static final int MAGIC = -17957139;
    private static final int PRIVATE_KEY = 1;
    private static final int TRUSTED_CERT = 2;
    private final Vector aliases = new Vector();
    private final HashMap certChains = new HashMap();
    private final HashMap dates = new HashMap();
    private final HashMap privateKeys = new HashMap();
    private final HashMap trustedCerts = new HashMap();

    public Key engineGetKey(String alias, char[] password) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        alias = alias.toLowerCase();
        if (!this.privateKeys.containsKey(alias)) {
            return null;
        }
        byte[] key = decryptKey((byte[]) this.privateKeys.get(alias), charsToBytes(password));
        Certificate[] chain = engineGetCertificateChain(alias);
        if (chain.length <= 0) {
            return new SecretKeySpec(key, alias);
        }
        try {
            return KeyFactory.getInstance(chain[0].getPublicKey().getAlgorithm()).generatePrivate(new PKCS8EncodedKeySpec(key));
        } catch (InvalidKeySpecException x) {
            throw new UnrecoverableKeyException(x.getMessage());
        }
    }

    public Certificate[] engineGetCertificateChain(String alias) {
        return (Certificate[]) this.certChains.get(alias.toLowerCase());
    }

    public Certificate engineGetCertificate(String alias) {
        alias = alias.toLowerCase();
        if (engineIsKeyEntry(alias)) {
            Certificate[] certChain = (Certificate[]) this.certChains.get(alias);
            if (certChain != null && certChain.length > 0) {
                return certChain[0];
            }
        }
        return (Certificate) this.trustedCerts.get(alias);
    }

    public Date engineGetCreationDate(String alias) {
        return (Date) this.dates.get(alias.toLowerCase());
    }

    public void engineSetKeyEntry(String alias, Key key, char[] passwd, Certificate[] certChain) throws KeyStoreException {
        alias = alias.toLowerCase();
        if (this.trustedCerts.containsKey(alias)) {
            throw new KeyStoreException("\"" + alias + " is a trusted certificate entry");
        }
        this.privateKeys.put(alias, encryptKey(key, charsToBytes(passwd)));
        if (certChain != null) {
            this.certChains.put(alias, certChain);
        } else {
            this.certChains.put(alias, new Certificate[0]);
        }
        if (!this.aliases.contains(alias)) {
            this.dates.put(alias, new Date());
            this.aliases.add(alias);
        }
    }

    public void engineSetKeyEntry(String alias, byte[] encodedKey, Certificate[] certChain) throws KeyStoreException {
        alias = alias.toLowerCase();
        if (this.trustedCerts.containsKey(alias)) {
            throw new KeyStoreException("\"" + alias + "\" is a trusted certificate entry");
        }
        try {
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(encodedKey);
            this.privateKeys.put(alias, encodedKey);
            if (certChain != null) {
                this.certChains.put(alias, certChain);
            } else {
                this.certChains.put(alias, new Certificate[0]);
            }
            if (!this.aliases.contains(alias)) {
                this.dates.put(alias, new Date());
                this.aliases.add(alias);
            }
        } catch (IOException e) {
            throw new KeyStoreException("encoded key is not an EncryptedPrivateKeyInfo");
        }
    }

    public void engineSetCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
        alias = alias.toLowerCase();
        if (this.privateKeys.containsKey(alias)) {
            throw new KeyStoreException("\"" + alias + "\" is a private key entry");
        } else if (cert == null) {
            throw new NullPointerException();
        } else {
            this.trustedCerts.put(alias, cert);
            if (!this.aliases.contains(alias)) {
                this.dates.put(alias, new Date());
                this.aliases.add(alias);
            }
        }
    }

    public void engineDeleteEntry(String alias) throws KeyStoreException {
        this.aliases.remove(alias.toLowerCase());
    }

    public Enumeration engineAliases() {
        return this.aliases.elements();
    }

    public boolean engineContainsAlias(String alias) {
        return this.aliases.contains(alias.toLowerCase());
    }

    public int engineSize() {
        return this.aliases.size();
    }

    public boolean engineIsKeyEntry(String alias) {
        return this.privateKeys.containsKey(alias.toLowerCase());
    }

    public boolean engineIsCertificateEntry(String alias) {
        return this.trustedCerts.containsKey(alias.toLowerCase());
    }

    public String engineGetCertificateAlias(Certificate cert) {
        for (String alias : this.trustedCerts.keySet()) {
            if (cert.equals(this.trustedCerts.get(alias))) {
                return alias;
            }
        }
        return null;
    }

    public void engineStore(OutputStream out, char[] passwd) throws IOException, NoSuchAlgorithmException, CertificateException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(charsToBytes(passwd));
        md.update("Mighty Aphrodite".getBytes(HttpRequest.CHARSET_UTF8));
        DataOutputStream dout = new DataOutputStream(new DigestOutputStream(out, md));
        dout.writeInt(MAGIC);
        dout.writeInt(TRUSTED_CERT);
        dout.writeInt(this.aliases.size());
        Enumeration e = this.aliases.elements();
        while (e.hasMoreElements()) {
            String alias = (String) e.nextElement();
            if (this.trustedCerts.containsKey(alias)) {
                dout.writeInt(TRUSTED_CERT);
                dout.writeUTF(alias);
                dout.writeLong(((Date) this.dates.get(alias)).getTime());
                writeCert(dout, (Certificate) this.trustedCerts.get(alias));
            } else {
                dout.writeInt(PRIVATE_KEY);
                dout.writeUTF(alias);
                dout.writeLong(((Date) this.dates.get(alias)).getTime());
                byte[] key = (byte[]) this.privateKeys.get(alias);
                dout.writeInt(key.length);
                dout.write(key);
                Certificate[] chain = (Certificate[]) this.certChains.get(alias);
                dout.writeInt(chain.length);
                for (int i = 0; i < chain.length; i += PRIVATE_KEY) {
                    writeCert(dout, chain[i]);
                }
            }
        }
        dout.write(md.digest());
    }

    public void engineLoad(InputStream in, char[] passwd) throws IOException, NoSuchAlgorithmException, CertificateException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        if (passwd != null) {
            md.update(charsToBytes(passwd));
        }
        md.update("Mighty Aphrodite".getBytes(HttpRequest.CHARSET_UTF8));
        this.aliases.clear();
        this.trustedCerts.clear();
        this.privateKeys.clear();
        this.certChains.clear();
        this.dates.clear();
        if (in != null) {
            DataInputStream din = new DataInputStream(new DigestInputStream(in, md));
            if (din.readInt() != MAGIC) {
                throw new IOException("not a JavaKeyStore");
            }
            din.readInt();
            int n = din.readInt();
            this.aliases.ensureCapacity(n);
            if (n < 0) {
                throw new IOException("negative entry count");
            }
            for (int i = 0; i < n; i += PRIVATE_KEY) {
                int type = din.readInt();
                String alias = din.readUTF();
                this.aliases.add(alias);
                this.dates.put(alias, new Date(din.readLong()));
                switch (type) {
                    case PRIVATE_KEY /*1*/:
                        byte[] encoded = new byte[din.readInt()];
                        din.read(encoded);
                        this.privateKeys.put(alias, encoded);
                        int count = din.readInt();
                        Certificate[] chain = new Certificate[count];
                        for (int j = 0; j < count; j += PRIVATE_KEY) {
                            chain[j] = readCert(din);
                        }
                        this.certChains.put(alias, chain);
                        break;
                    case TRUSTED_CERT /*2*/:
                        this.trustedCerts.put(alias, readCert(din));
                        break;
                    default:
                        throw new IOException("malformed key store");
                }
            }
            byte[] hash = new byte[20];
            din.read(hash);
            if (passwd != null && MessageDigest.isEqual(hash, md.digest())) {
                throw new IOException("signature not verified");
            }
        }
    }

    private static Certificate readCert(DataInputStream in) throws IOException, CertificateException, NoSuchAlgorithmException {
        String type = in.readUTF();
        byte[] encoded = new byte[in.readInt()];
        in.read(encoded);
        return CertificateFactory.getInstance(type).generateCertificate(new ByteArrayInputStream(encoded));
    }

    private static void writeCert(DataOutputStream dout, Certificate cert) throws IOException, CertificateException {
        dout.writeUTF(cert.getType());
        byte[] b = cert.getEncoded();
        dout.writeInt(b.length);
        dout.write(b);
    }

    private static byte[] decryptKey(byte[] encryptedPKI, byte[] passwd) throws UnrecoverableKeyException {
        try {
            byte[] encr = new EncryptedPrivateKeyInfo(encryptedPKI).getEncryptedData();
            byte[] keystream = new byte[20];
            System.arraycopy(encr, 0, keystream, 0, 20);
            byte[] check = new byte[20];
            System.arraycopy(encr, encr.length - 20, check, 0, 20);
            byte[] key = new byte[(encr.length - 40)];
            MessageDigest sha = MessageDigest.getInstance("SHA1");
            int count = 0;
            while (count < key.length) {
                sha.reset();
                sha.update(passwd);
                sha.update(keystream);
                sha.digest(keystream, 0, keystream.length);
                for (int i = 0; i < keystream.length && count < key.length; i += PRIVATE_KEY) {
                    key[count] = (byte) (keystream[i] ^ encr[count + 20]);
                    count += PRIVATE_KEY;
                }
            }
            sha.reset();
            sha.update(passwd);
            sha.update(key);
            if (MessageDigest.isEqual(check, sha.digest())) {
                return key;
            }
            throw new UnrecoverableKeyException("checksum mismatch");
        } catch (Exception x) {
            throw new UnrecoverableKeyException(x.getMessage());
        }
    }

    private static byte[] encryptKey(Key key, byte[] passwd) throws KeyStoreException {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA1");
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            byte[] k = key.getEncoded();
            byte[] encrypted = new byte[(k.length + 40)];
            byte[] keystream = SecureRandom.getSeed(20);
            System.arraycopy(keystream, 0, encrypted, 0, 20);
            int count = 0;
            while (count < k.length) {
                sha.reset();
                sha.update(passwd);
                sha.update(keystream);
                sha.digest(keystream, 0, keystream.length);
                for (int i = 0; i < keystream.length && count < k.length; i += PRIVATE_KEY) {
                    encrypted[count + 20] = (byte) (keystream[i] ^ k[count]);
                    count += PRIVATE_KEY;
                }
            }
            sha.reset();
            sha.update(passwd);
            sha.update(k);
            sha.digest(encrypted, encrypted.length - 20, 20);
            return new EncryptedPrivateKeyInfo("1.3.6.1.4.1.42.2.17.1.1", encrypted).getEncoded();
        } catch (Exception x) {
            throw new KeyStoreException(x.getMessage());
        }
    }

    private static byte[] charsToBytes(char[] passwd) {
        byte[] buf = new byte[(passwd.length * TRUSTED_CERT)];
        int j = 0;
        for (int i = 0; i < passwd.length; i += PRIVATE_KEY) {
            int i2 = j + PRIVATE_KEY;
            buf[j] = (byte) (passwd[i] >>> 8);
            j = i2 + PRIVATE_KEY;
            buf[i2] = (byte) passwd[i];
        }
        return buf;
    }
}
