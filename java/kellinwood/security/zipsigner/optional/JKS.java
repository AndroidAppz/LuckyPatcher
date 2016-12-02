/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.DataInputStream
 *  java.io.DataOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.DigestInputStream
 *  java.security.DigestOutputStream
 *  java.security.Key
 *  java.security.KeyFactory
 *  java.security.KeyStoreException
 *  java.security.KeyStoreSpi
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.SecureRandom
 *  java.security.UnrecoverableKeyException
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateException
 *  java.security.cert.CertificateFactory
 *  java.security.spec.InvalidKeySpecException
 *  java.security.spec.KeySpec
 *  java.security.spec.PKCS8EncodedKeySpec
 *  java.util.Date
 *  java.util.Enumeration
 *  java.util.HashMap
 *  java.util.Set
 *  java.util.Vector
 *  javax.crypto.EncryptedPrivateKeyInfo
 *  javax.crypto.spec.SecretKeySpec
 */
package kellinwood.security.zipsigner.optional;

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
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.spec.SecretKeySpec;

public class JKS
extends KeyStoreSpi {
    private static final int MAGIC = -17957139;
    private static final int PRIVATE_KEY = 1;
    private static final int TRUSTED_CERT = 2;
    private final Vector aliases = new Vector();
    private final HashMap certChains = new HashMap();
    private final HashMap dates = new HashMap();
    private final HashMap privateKeys = new HashMap();
    private final HashMap trustedCerts = new HashMap();

    private static byte[] charsToBytes(char[] arrc) {
        byte[] arrby = new byte[2 * arrc.length];
        int n = 0;
        for (int i = 0; i < arrc.length; ++i) {
            int n2 = n + 1;
            arrby[n] = (byte)(arrc[i] >>> 8);
            n = n2 + 1;
            arrby[n2] = (byte)arrc[i];
        }
        return arrby;
    }

    private static byte[] decryptKey(byte[] arrby, byte[] arrby2) throws UnrecoverableKeyException {
        byte[] arrby3 = new EncryptedPrivateKeyInfo(arrby).getEncryptedData();
        byte[] arrby4 = new byte[20];
        System.arraycopy((Object)arrby3, (int)0, (Object)arrby4, (int)0, (int)20);
        byte[] arrby5 = new byte[20];
        System.arraycopy((Object)arrby3, (int)(-20 + arrby3.length), (Object)arrby5, (int)0, (int)20);
        byte[] arrby6 = new byte[-40 + arrby3.length];
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA1");
        int n = 0;
        block5 : do {
            if (n >= arrby6.length) break;
            messageDigest.reset();
            messageDigest.update(arrby2);
            messageDigest.update(arrby4);
            messageDigest.digest(arrby4, 0, arrby4.length);
            int n2 = 0;
            do {
                if (n2 >= arrby4.length || n >= arrby6.length) continue block5;
                arrby6[n] = (byte)(arrby4[n2] ^ arrby3[n + 20]);
                ++n;
                ++n2;
            } while (true);
            break;
        } while (true);
        try {
            messageDigest.reset();
            messageDigest.update(arrby2);
            messageDigest.update(arrby6);
            if (!MessageDigest.isEqual((byte[])arrby5, (byte[])messageDigest.digest())) {
                throw new UnrecoverableKeyException("checksum mismatch");
            }
        }
        catch (Exception var2_9) {
            throw new UnrecoverableKeyException(var2_9.getMessage());
        }
        return arrby6;
    }

    private static byte[] encryptKey(Key key, byte[] arrby) throws KeyStoreException {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA1");
        SecureRandom.getInstance((String)"SHA1PRNG");
        byte[] arrby2 = key.getEncoded();
        byte[] arrby3 = new byte[40 + arrby2.length];
        byte[] arrby4 = SecureRandom.getSeed((int)20);
        System.arraycopy((Object)arrby4, (int)0, (Object)arrby3, (int)0, (int)20);
        int n = 0;
        block5 : do {
            if (n >= arrby2.length) break;
            messageDigest.reset();
            messageDigest.update(arrby);
            messageDigest.update(arrby4);
            messageDigest.digest(arrby4, 0, arrby4.length);
            int n2 = 0;
            do {
                if (n2 >= arrby4.length || n >= arrby2.length) continue block5;
                arrby3[n + 20] = (byte)(arrby4[n2] ^ arrby2[n]);
                ++n;
                ++n2;
            } while (true);
            break;
        } while (true);
        try {
            messageDigest.reset();
            messageDigest.update(arrby);
            messageDigest.update(arrby2);
            messageDigest.digest(arrby3, -20 + arrby3.length, 20);
            byte[] arrby5 = new EncryptedPrivateKeyInfo("1.3.6.1.4.1.42.2.17.1.1", arrby3).getEncoded();
            return arrby5;
        }
        catch (Exception var2_9) {
            throw new KeyStoreException(var2_9.getMessage());
        }
    }

    private static Certificate readCert(DataInputStream dataInputStream) throws IOException, CertificateException, NoSuchAlgorithmException {
        String string = dataInputStream.readUTF();
        byte[] arrby = new byte[dataInputStream.readInt()];
        dataInputStream.read(arrby);
        return CertificateFactory.getInstance((String)string).generateCertificate((InputStream)new ByteArrayInputStream(arrby));
    }

    private static void writeCert(DataOutputStream dataOutputStream, Certificate certificate) throws IOException, CertificateException {
        dataOutputStream.writeUTF(certificate.getType());
        byte[] arrby = certificate.getEncoded();
        dataOutputStream.writeInt(arrby.length);
        dataOutputStream.write(arrby);
    }

    public Enumeration engineAliases() {
        return this.aliases.elements();
    }

    public boolean engineContainsAlias(String string) {
        String string2 = string.toLowerCase();
        return this.aliases.contains((Object)string2);
    }

    public void engineDeleteEntry(String string) throws KeyStoreException {
        String string2 = string.toLowerCase();
        this.aliases.remove((Object)string2);
    }

    public Certificate engineGetCertificate(String string) {
        Certificate[] arrcertificate;
        String string2 = string.toLowerCase();
        if (this.engineIsKeyEntry(string2) && (arrcertificate = (Certificate[])this.certChains.get((Object)string2)) != null && arrcertificate.length > 0) {
            return arrcertificate[0];
        }
        return (Certificate)this.trustedCerts.get((Object)string2);
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        for (String string : this.trustedCerts.keySet()) {
            if (!certificate.equals(this.trustedCerts.get((Object)string))) continue;
            return string;
        }
        return null;
    }

    public Certificate[] engineGetCertificateChain(String string) {
        String string2 = string.toLowerCase();
        return (Certificate[])this.certChains.get((Object)string2);
    }

    public Date engineGetCreationDate(String string) {
        String string2 = string.toLowerCase();
        return (Date)this.dates.get((Object)string2);
    }

    public Key engineGetKey(String string, char[] arrc) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        String string2 = string.toLowerCase();
        if (!this.privateKeys.containsKey((Object)string2)) {
            return null;
        }
        byte[] arrby = JKS.decryptKey((byte[])this.privateKeys.get((Object)string2), JKS.charsToBytes(arrc));
        Certificate[] arrcertificate = this.engineGetCertificateChain(string2);
        if (arrcertificate.length > 0) {
            try {
                PrivateKey privateKey = KeyFactory.getInstance((String)arrcertificate[0].getPublicKey().getAlgorithm()).generatePrivate((KeySpec)new PKCS8EncodedKeySpec(arrby));
                return privateKey;
            }
            catch (InvalidKeySpecException var6_7) {
                throw new UnrecoverableKeyException(var6_7.getMessage());
            }
        }
        return new SecretKeySpec(arrby, string2);
    }

    public boolean engineIsCertificateEntry(String string) {
        String string2 = string.toLowerCase();
        return this.trustedCerts.containsKey((Object)string2);
    }

    public boolean engineIsKeyEntry(String string) {
        String string2 = string.toLowerCase();
        return this.privateKeys.containsKey((Object)string2);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void engineLoad(InputStream inputStream, char[] arrc) throws IOException, NoSuchAlgorithmException, CertificateException {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA");
        if (arrc != null) {
            messageDigest.update(JKS.charsToBytes(arrc));
        }
        messageDigest.update("Mighty Aphrodite".getBytes("UTF-8"));
        this.aliases.clear();
        this.trustedCerts.clear();
        this.privateKeys.clear();
        this.certChains.clear();
        this.dates.clear();
        if (inputStream == null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream((InputStream)new DigestInputStream(inputStream, messageDigest));
        if (dataInputStream.readInt() != -17957139) {
            throw new IOException("not a JavaKeyStore");
        }
        dataInputStream.readInt();
        int n = dataInputStream.readInt();
        this.aliases.ensureCapacity(n);
        if (n < 0) {
            throw new IOException("negative entry count");
        }
        int n2 = 0;
        do {
            if (n2 >= n) {
                byte[] arrby = new byte[20];
                dataInputStream.read(arrby);
                if (arrc == null) return;
                if (!MessageDigest.isEqual((byte[])arrby, (byte[])messageDigest.digest())) return;
                throw new IOException("signature not verified");
            }
            int n3 = dataInputStream.readInt();
            String string = dataInputStream.readUTF();
            this.aliases.add((Object)string);
            this.dates.put((Object)string, (Object)new Date(dataInputStream.readLong()));
            switch (n3) {
                default: {
                    throw new IOException("malformed key store");
                }
                case 1: {
                    byte[] arrby = new byte[dataInputStream.readInt()];
                    dataInputStream.read(arrby);
                    this.privateKeys.put((Object)string, (Object)arrby);
                    int n4 = dataInputStream.readInt();
                    Certificate[] arrcertificate = new Certificate[n4];
                    for (int i = 0; i < n4; ++i) {
                        arrcertificate[i] = JKS.readCert(dataInputStream);
                    }
                    this.certChains.put((Object)string, (Object)arrcertificate);
                    break;
                }
                case 2: {
                    this.trustedCerts.put((Object)string, (Object)JKS.readCert(dataInputStream));
                }
            }
            ++n2;
        } while (true);
    }

    public void engineSetCertificateEntry(String string, Certificate certificate) throws KeyStoreException {
        String string2 = string.toLowerCase();
        if (this.privateKeys.containsKey((Object)string2)) {
            throw new KeyStoreException("\"" + string2 + "\" is a private key entry");
        }
        if (certificate == null) {
            throw new NullPointerException();
        }
        this.trustedCerts.put((Object)string2, (Object)certificate);
        if (!this.aliases.contains((Object)string2)) {
            this.dates.put((Object)string2, (Object)new Date());
            this.aliases.add((Object)string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void engineSetKeyEntry(String string, Key key, char[] arrc, Certificate[] arrcertificate) throws KeyStoreException {
        String string2 = string.toLowerCase();
        if (this.trustedCerts.containsKey((Object)string2)) {
            throw new KeyStoreException("\"" + string2 + " is a trusted certificate entry");
        }
        this.privateKeys.put((Object)string2, (Object)JKS.encryptKey(key, JKS.charsToBytes(arrc)));
        if (arrcertificate != null) {
            this.certChains.put((Object)string2, (Object)arrcertificate);
        } else {
            this.certChains.put((Object)string2, (Object)new Certificate[0]);
        }
        if (!this.aliases.contains((Object)string2)) {
            this.dates.put((Object)string2, (Object)new Date());
            this.aliases.add((Object)string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void engineSetKeyEntry(String string, byte[] arrby, Certificate[] arrcertificate) throws KeyStoreException {
        String string2 = string.toLowerCase();
        if (this.trustedCerts.containsKey((Object)string2)) {
            throw new KeyStoreException("\"" + string2 + "\" is a trusted certificate entry");
        }
        try {
            new EncryptedPrivateKeyInfo(arrby);
        }
        catch (IOException var11_5) {
            throw new KeyStoreException("encoded key is not an EncryptedPrivateKeyInfo");
        }
        this.privateKeys.put((Object)string2, (Object)arrby);
        if (arrcertificate != null) {
            this.certChains.put((Object)string2, (Object)arrcertificate);
        } else {
            this.certChains.put((Object)string2, (Object)new Certificate[0]);
        }
        if (!this.aliases.contains((Object)string2)) {
            this.dates.put((Object)string2, (Object)new Date());
            this.aliases.add((Object)string2);
        }
    }

    public int engineSize() {
        return this.aliases.size();
    }

    public void engineStore(OutputStream outputStream, char[] arrc) throws IOException, NoSuchAlgorithmException, CertificateException {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA1");
        messageDigest.update(JKS.charsToBytes(arrc));
        messageDigest.update("Mighty Aphrodite".getBytes("UTF-8"));
        DataOutputStream dataOutputStream = new DataOutputStream((OutputStream)new DigestOutputStream(outputStream, messageDigest));
        dataOutputStream.writeInt(-17957139);
        dataOutputStream.writeInt(2);
        dataOutputStream.writeInt(this.aliases.size());
        Enumeration enumeration = this.aliases.elements();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            if (this.trustedCerts.containsKey((Object)string)) {
                dataOutputStream.writeInt(2);
                dataOutputStream.writeUTF(string);
                dataOutputStream.writeLong(((Date)this.dates.get((Object)string)).getTime());
                JKS.writeCert(dataOutputStream, (Certificate)this.trustedCerts.get((Object)string));
                continue;
            }
            dataOutputStream.writeInt(1);
            dataOutputStream.writeUTF(string);
            dataOutputStream.writeLong(((Date)this.dates.get((Object)string)).getTime());
            byte[] arrby = (byte[])this.privateKeys.get((Object)string);
            dataOutputStream.writeInt(arrby.length);
            dataOutputStream.write(arrby);
            Certificate[] arrcertificate = (Certificate[])this.certChains.get((Object)string);
            dataOutputStream.writeInt(arrcertificate.length);
            for (int i = 0; i < arrcertificate.length; ++i) {
                JKS.writeCert(dataOutputStream, arrcertificate[i]);
            }
        }
        dataOutputStream.write(messageDigest.digest());
    }
}

