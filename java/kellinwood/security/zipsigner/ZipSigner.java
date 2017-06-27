package kellinwood.security.zipsigner;

import com.chelpus.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.DigestOutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.security.zipsigner.ResourceAdapter.Item;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipInput;
import kellinwood.zipio.ZipOutput;
import net.lingala.zip4j.util.InternalZipConstants;
import pxb.android.ResConst;

public class ZipSigner {
    private static final String CERT_RSA_NAME = "META-INF/CERT.RSA";
    private static final String CERT_SF_NAME = "META-INF/CERT.SF";
    public static final String KEY_NONE = "none";
    public static final String KEY_TESTKEY = "testkey";
    public static final String MODE_AUTO = "auto";
    public static final String MODE_AUTO_NONE = "auto-none";
    public static final String MODE_AUTO_TESTKEY = "auto-testkey";
    public static final String[] SUPPORTED_KEY_MODES = new String[]{MODE_AUTO_TESTKEY, MODE_AUTO, MODE_AUTO_NONE, "media", "platform", "shared", KEY_TESTKEY, KEY_NONE};
    static LoggerInterface log = null;
    private static Pattern stripPattern = Pattern.compile("^META-INF/(.*)[.](SF|RSA|DSA)$");
    Map<String, String> autoKeyDetect = new HashMap();
    AutoKeyObservable autoKeyObservable = new AutoKeyObservable();
    private boolean canceled = false;
    KeySet keySet = null;
    String keymode = KEY_TESTKEY;
    Map<String, KeySet> loadedKeys = new HashMap();
    private ProgressHelper progressHelper = new ProgressHelper();
    private ResourceAdapter resourceAdapter = new DefaultResourceAdapter();

    public static class AutoKeyObservable extends Observable {
        public void notifyObservers(Object arg) {
            super.setChanged();
            super.notifyObservers(arg);
        }
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipSigner.class.getName());
        }
        return log;
    }

    public ZipSigner() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.autoKeyDetect.put("aa9852bc5a53272ac8031d49b65e4b0e", "media");
        this.autoKeyDetect.put("e60418c4b638f20d0721e115674ca11f", "platform");
        this.autoKeyDetect.put("3e24e49741b60c215c010dc6048fca7d", "shared");
        this.autoKeyDetect.put("dab2cead827ef5313f28e22b6fa8479f", KEY_TESTKEY);
    }

    public ResourceAdapter getResourceAdapter() {
        return this.resourceAdapter;
    }

    public void setResourceAdapter(ResourceAdapter resourceAdapter) {
        this.resourceAdapter = resourceAdapter;
    }

    public void addAutoKeyObserver(Observer o) {
        this.autoKeyObservable.addObserver(o);
    }

    public String getKeymode() {
        return this.keymode;
    }

    public void setKeymode(String km) throws IOException, GeneralSecurityException {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug("setKeymode: " + km);
        }
        this.keymode = km;
        if (this.keymode.startsWith(MODE_AUTO)) {
            this.keySet = null;
            return;
        }
        this.progressHelper.initProgress();
        loadKeys(this.keymode);
    }

    public static String[] getSupportedKeyModes() {
        return SUPPORTED_KEY_MODES;
    }

    protected String autoDetectKey(String mode, Map<String, ZioEntry> zioEntries) throws NoSuchAlgorithmException, IOException {
        boolean debug = getLogger().isDebugEnabled();
        if (!mode.startsWith(MODE_AUTO)) {
            return mode;
        }
        String keyName = null;
        for (Entry<String, ZioEntry> entry : zioEntries.entrySet()) {
            String entryName = (String) entry.getKey();
            if (entryName.startsWith("META-INF/") && entryName.endsWith(".RSA")) {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] entryData = ((ZioEntry) entry.getValue()).getData();
                if (entryData.length < 1458) {
                    break;
                }
                md5.update(entryData, 0, 1458);
                byte[] rawDigest = md5.digest();
                StringBuilder builder = new StringBuilder();
                int len$ = rawDigest.length;
                for (int i$ = 0; i$ < len$; i$++) {
                    builder.append(String.format("%02x", new Object[]{Byte.valueOf(arr$[i$])}));
                }
                keyName = (String) this.autoKeyDetect.get(builder.toString());
                if (debug) {
                    if (keyName != null) {
                        getLogger().debug(String.format("Auto-determined key=%s using md5=%s", new Object[]{keyName, md5String}));
                    } else {
                        getLogger().debug(String.format("Auto key determination failed for md5=%s", new Object[]{md5String}));
                    }
                }
                if (keyName != null) {
                    return keyName;
                }
            }
        }
        if (mode.equals(MODE_AUTO_TESTKEY)) {
            if (debug) {
                getLogger().debug("Falling back to key=" + keyName);
            }
            return KEY_TESTKEY;
        }
        if (!mode.equals(MODE_AUTO_NONE)) {
            return null;
        }
        if (debug) {
            getLogger().debug("Unable to determine key, returning: none");
        }
        return KEY_NONE;
    }

    public void issueLoadingCertAndKeysProgressEvent() {
        this.progressHelper.progress(1, this.resourceAdapter.getString(Item.LOADING_CERTIFICATE_AND_KEY, new Object[0]));
    }

    public void loadKeys(String name) throws IOException, GeneralSecurityException {
        this.keySet = (KeySet) this.loadedKeys.get(name);
        if (this.keySet == null) {
            this.keySet = new KeySet();
            this.keySet.setName(name);
            this.loadedKeys.put(name, this.keySet);
            if (!KEY_NONE.equals(name)) {
                issueLoadingCertAndKeysProgressEvent();
                this.keySet.setPrivateKey(readPrivateKey(getClass().getResource("/keys/" + name + ".pk8"), null));
                this.keySet.setPublicKey(readPublicKey(getClass().getResource("/keys/" + name + ".x509.pem")));
                URL sigBlockTemplateUrl = getClass().getResource("/keys/" + name + ".sbt");
                if (sigBlockTemplateUrl != null) {
                    this.keySet.setSigBlockTemplate(readContentAsBytes(sigBlockTemplateUrl));
                }
            }
        }
    }

    public void setKeys(String name, X509Certificate publicKey, PrivateKey privateKey, byte[] signatureBlockTemplate) {
        this.keySet = new KeySet(name, publicKey, privateKey, signatureBlockTemplate);
    }

    public void setKeys(String name, X509Certificate publicKey, PrivateKey privateKey, String signatureAlgorithm, byte[] signatureBlockTemplate) {
        this.keySet = new KeySet(name, publicKey, privateKey, signatureAlgorithm, signatureBlockTemplate);
    }

    public KeySet getKeySet() {
        return this.keySet;
    }

    public void cancel() {
        this.canceled = true;
    }

    public void resetCanceled() {
        this.canceled = false;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void loadProvider(String providerClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Security.insertProviderAt((Provider) Class.forName(providerClassName).newInstance(), 1);
    }

    public X509Certificate readPublicKey(URL publicKeyUrl) throws IOException, GeneralSecurityException {
        InputStream input = publicKeyUrl.openStream();
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(input);
            return x509Certificate;
        } finally {
            input.close();
        }
    }

    private KeySpec decryptPrivateKey(byte[] encryptedPrivateKey, String keyPassword) throws GeneralSecurityException {
        try {
            EncryptedPrivateKeyInfo epkInfo = new EncryptedPrivateKeyInfo(encryptedPrivateKey);
            Key key = SecretKeyFactory.getInstance(epkInfo.getAlgName()).generateSecret(new PBEKeySpec(keyPassword.toCharArray()));
            Cipher cipher = Cipher.getInstance(epkInfo.getAlgName());
            cipher.init(2, key, epkInfo.getAlgParameters());
            try {
                return epkInfo.getKeySpec(cipher);
            } catch (InvalidKeySpecException ex) {
                getLogger().error("signapk: Password for private key may be bad.");
                throw ex;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public byte[] readContentAsBytes(URL contentUrl) throws IOException {
        return readContentAsBytes(contentUrl.openStream());
    }

    public byte[] readContentAsBytes(InputStream input) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[InternalZipConstants.UFT8_NAMES_FLAG];
        int numRead = input.read(buffer);
        while (numRead != -1) {
            baos.write(buffer, 0, numRead);
            numRead = input.read(buffer);
        }
        return baos.toByteArray();
    }

    public PrivateKey readPrivateKey(URL privateKeyUrl, String keyPassword) throws IOException, GeneralSecurityException {
        PrivateKey generatePrivate;
        InputStream input = new DataInputStream(privateKeyUrl.openStream());
        KeySpec spec;
        try {
            byte[] bytes = readContentAsBytes(input);
            spec = decryptPrivateKey(bytes, keyPassword);
            if (spec == null) {
                spec = new PKCS8EncodedKeySpec(bytes);
            }
            generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(spec);
        } catch (InvalidKeySpecException e) {
            generatePrivate = KeyFactory.getInstance("DSA").generatePrivate(spec);
        } finally {
            input.close();
        }
        return generatePrivate;
    }

    private Manifest addDigestsToManifest(Map<String, ZioEntry> entries) throws IOException, GeneralSecurityException {
        Manifest input = null;
        ZioEntry manifestEntry = (ZioEntry) entries.get("META-INF/MANIFEST.MF");
        if (manifestEntry != null) {
            input = new Manifest();
            input.read(manifestEntry.getInputStream());
        }
        Manifest output = new Manifest();
        Attributes main = output.getMainAttributes();
        if (input != null) {
            main.putAll(input.getMainAttributes());
        } else {
            main.putValue("Manifest-Version", "1.0");
            main.putValue("Created-By", "1.0 (Android SignApk)");
        }
        MessageDigest md = MessageDigest.getInstance("SHA1");
        byte[] buffer = new byte[ResConst.RES_TABLE_PACKAGE_TYPE];
        TreeMap<String, ZioEntry> byName = new TreeMap();
        byName.putAll(entries);
        boolean debug = getLogger().isDebugEnabled();
        if (debug) {
            getLogger().debug("Manifest entries:");
        }
        for (ZioEntry entry : byName.values()) {
            if (this.canceled) {
                break;
            }
            String name = entry.getName();
            if (debug) {
                getLogger().debug(name);
            }
            if (!(entry.isDirectory() || name.equals("META-INF/MANIFEST.MF") || name.equals(CERT_SF_NAME) || name.equals(CERT_RSA_NAME))) {
                if (stripPattern == null || !stripPattern.matcher(name).matches()) {
                    this.progressHelper.progress(0, this.resourceAdapter.getString(Item.GENERATING_MANIFEST, new Object[0]));
                    InputStream data = entry.getInputStream();
                    while (true) {
                        int num = data.read(buffer);
                        if (num <= 0) {
                            break;
                        }
                        md.update(buffer, 0, num);
                    }
                    Attributes attributes = null;
                    if (input != null) {
                        Attributes inAttr = input.getAttributes(name);
                        if (inAttr != null) {
                            attributes = new Attributes(inAttr);
                        }
                    }
                    if (attributes == null) {
                        attributes = new Attributes();
                    }
                    attributes.putValue("SHA1-Digest", Base64.encode(md.digest()));
                    output.getEntries().put(name, attributes);
                }
            }
        }
        return output;
    }

    private void generateSignatureFile(Manifest manifest, OutputStream out) throws IOException, GeneralSecurityException {
        out.write("Signature-Version: 1.0\r\n".getBytes());
        out.write("Created-By: 1.0 (Android SignApk)\r\n".getBytes());
        MessageDigest md = MessageDigest.getInstance("SHA1");
        PrintStream print = new PrintStream(new DigestOutputStream(new ByteArrayOutputStream(), md), true, HttpRequest.CHARSET_UTF8);
        manifest.write(print);
        print.flush();
        out.write(("SHA1-Digest-Manifest: " + Base64.encode(md.digest()) + "\r\n\r\n").getBytes());
        for (Entry<String, Attributes> entry : manifest.getEntries().entrySet()) {
            if (!this.canceled) {
                this.progressHelper.progress(0, this.resourceAdapter.getString(Item.GENERATING_SIGNATURE_FILE, new Object[0]));
                String nameEntry = "Name: " + ((String) entry.getKey()) + "\r\n";
                print.print(nameEntry);
                for (Entry<Object, Object> att : ((Attributes) entry.getValue()).entrySet()) {
                    print.print(att.getKey() + ": " + att.getValue() + "\r\n");
                }
                print.print("\r\n");
                print.flush();
                out.write(nameEntry.getBytes());
                out.write(("SHA1-Digest: " + Base64.encode(md.digest()) + "\r\n\r\n").getBytes());
            } else {
                return;
            }
        }
    }

    private void writeSignatureBlock(KeySet keySet, byte[] signatureFileBytes, OutputStream out) throws IOException, GeneralSecurityException {
        if (keySet.getSigBlockTemplate() != null) {
            ZipSignature signature = new ZipSignature();
            signature.initSign(keySet.getPrivateKey());
            signature.update(signatureFileBytes);
            byte[] signatureBytes = signature.sign();
            out.write(keySet.getSigBlockTemplate());
            out.write(signatureBytes);
            if (getLogger().isDebugEnabled()) {
                MessageDigest md = MessageDigest.getInstance("SHA1");
                md.update(signatureFileBytes);
                getLogger().debug("Sig File SHA1: \n" + HexDumpEncoder.encode(md.digest()));
                getLogger().debug("Signature: \n" + HexDumpEncoder.encode(signatureBytes));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, keySet.getPublicKey());
                getLogger().debug("Signature Decrypted: \n" + HexDumpEncoder.encode(cipher.doFinal(signatureBytes)));
                return;
            }
            return;
        }
        try {
            out.write((byte[]) Class.forName("kellinwood.security.zipsigner.optional.SignatureBlockGenerator").getMethod("generate", new Class[]{KeySet.class, new byte[1].getClass()}).invoke(null, new Object[]{keySet, signatureFileBytes}));
        } catch (Exception x) {
            throw new RuntimeException(x.getMessage(), x);
        }
    }

    private void copyFiles(Manifest manifest, Map<String, ZioEntry> input, ZipOutput output, long timestamp) throws IOException {
        List<String> names = new ArrayList(manifest.getEntries().keySet());
        Collections.sort(names);
        int i = 1;
        for (String name : names) {
            if (!this.canceled) {
                this.progressHelper.progress(0, this.resourceAdapter.getString(Item.COPYING_ZIP_ENTRY, Integer.valueOf(i), Integer.valueOf(names.size())));
                i++;
                ZioEntry inEntry = (ZioEntry) input.get(name);
                inEntry.setTime(timestamp);
                output.write(inEntry);
            } else {
                return;
            }
        }
    }

    private void copyFiles(Map<String, ZioEntry> input, ZipOutput output) throws IOException {
        int i = 1;
        for (ZioEntry inEntry : input.values()) {
            if (!this.canceled) {
                this.progressHelper.progress(0, this.resourceAdapter.getString(Item.COPYING_ZIP_ENTRY, Integer.valueOf(i), Integer.valueOf(input.size())));
                i++;
                output.write(inEntry);
            } else {
                return;
            }
        }
    }

    public void signZip(URL keystoreURL, String keystoreType, String keystorePw, String certAlias, String certPw, String inputZipFilename, String outputZipFilename) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException {
        signZip(keystoreURL, keystoreType, keystorePw.toCharArray(), certAlias, certPw.toCharArray(), "SHA1withRSA", inputZipFilename, outputZipFilename);
    }

    public void signZip(URL keystoreURL, String keystoreType, char[] keystorePw, String certAlias, char[] certPw, String signatureAlgorithm, String inputZipFilename, String outputZipFilename) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException {
        InputStream keystoreStream = null;
        if (keystoreType == null) {
            try {
                keystoreType = KeyStore.getDefaultType();
            } catch (Throwable th) {
                if (keystoreStream != null) {
                    keystoreStream.close();
                }
            }
        }
        KeyStore keystore = KeyStore.getInstance(keystoreType);
        keystoreStream = keystoreURL.openStream();
        keystore.load(keystoreStream, keystorePw);
        setKeys("custom", (X509Certificate) keystore.getCertificate(certAlias), (PrivateKey) keystore.getKey(certAlias, certPw), signatureAlgorithm, null);
        signZip(inputZipFilename, outputZipFilename);
        if (keystoreStream != null) {
            keystoreStream.close();
        }
    }

    public void signZip(Map<String, ZioEntry> zioEntries, String outputZipFilename) throws IOException, GeneralSecurityException {
        this.progressHelper.initProgress();
        signZip(zioEntries, new FileOutputStream(outputZipFilename), outputZipFilename);
    }

    public void signZip(String inputZipFilename, String outputZipFilename) throws IOException, GeneralSecurityException {
        if (new File(inputZipFilename).getCanonicalFile().equals(new File(outputZipFilename).getCanonicalFile())) {
            throw new IllegalArgumentException(this.resourceAdapter.getString(Item.INPUT_SAME_AS_OUTPUT_ERROR, new Object[0]));
        }
        this.progressHelper.initProgress();
        this.progressHelper.progress(1, this.resourceAdapter.getString(Item.PARSING_CENTRAL_DIRECTORY, new Object[0]));
        signZip(ZipInput.read(inputZipFilename).getEntries(), new FileOutputStream(outputZipFilename), outputZipFilename);
    }

    public void signZip(Map<String, ZioEntry> zioEntries, OutputStream outputStream, String outputZipFilename) throws IOException, GeneralSecurityException {
        Throwable th;
        boolean debug = getLogger().isDebugEnabled();
        this.progressHelper.initProgress();
        if (this.keySet == null) {
            if (this.keymode.startsWith(MODE_AUTO)) {
                String keyName = autoDetectKey(this.keymode, zioEntries);
                if (keyName == null) {
                    throw new AutoKeyException(this.resourceAdapter.getString(Item.AUTO_KEY_SELECTION_ERROR, new File(outputZipFilename).getName()));
                }
                this.autoKeyObservable.notifyObservers(keyName);
                loadKeys(keyName);
            } else {
                throw new IllegalStateException("No keys configured for signing the file!");
            }
        }
        ZipOutput zipOutput;
        try {
            zipOutput = new ZipOutput(outputStream);
            try {
                if (KEY_NONE.equals(this.keySet.getName())) {
                    this.progressHelper.setProgressTotalItems(zioEntries.size());
                    this.progressHelper.setProgressCurrentItem(0);
                    copyFiles(zioEntries, zipOutput);
                    zipOutput.close();
                    if (this.canceled && outputZipFilename != null) {
                        try {
                            new File(outputZipFilename).delete();
                            return;
                        } catch (Throwable t) {
                            getLogger().warning(t.getClass().getName() + ":" + t.getMessage());
                            return;
                        }
                    }
                    return;
                }
                int progressTotalItems = 0;
                for (ZioEntry entry : zioEntries.values()) {
                    String name = entry.getName();
                    if (!(entry.isDirectory() || name.equals("META-INF/MANIFEST.MF") || name.equals(CERT_SF_NAME) || name.equals(CERT_RSA_NAME))) {
                        if (stripPattern == null || !stripPattern.matcher(name).matches()) {
                            progressTotalItems += 3;
                        }
                    }
                }
                this.progressHelper.setProgressTotalItems(progressTotalItems + 1);
                this.progressHelper.setProgressCurrentItem(0);
                long timestamp = this.keySet.getPublicKey().getNotBefore().getTime() + 3600000;
                Manifest manifest = addDigestsToManifest(zioEntries);
                if (this.canceled) {
                    zipOutput.close();
                    if (this.canceled && outputZipFilename != null) {
                        try {
                            new File(outputZipFilename).delete();
                            return;
                        } catch (Throwable t2) {
                            getLogger().warning(t2.getClass().getName() + ":" + t2.getMessage());
                            return;
                        }
                    }
                    return;
                }
                ZioEntry zioEntry = new ZioEntry("META-INF/MANIFEST.MF");
                zioEntry.setTime(timestamp);
                manifest.write(zioEntry.getOutputStream());
                zipOutput.write(zioEntry);
                zioEntry = new ZioEntry(CERT_SF_NAME);
                zioEntry.setTime(timestamp);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                generateSignatureFile(manifest, out);
                if (this.canceled) {
                    zipOutput.close();
                    if (this.canceled && outputZipFilename != null) {
                        try {
                            new File(outputZipFilename).delete();
                            return;
                        } catch (Throwable t22) {
                            getLogger().warning(t22.getClass().getName() + ":" + t22.getMessage());
                            return;
                        }
                    }
                    return;
                }
                byte[] sfBytes = out.toByteArray();
                if (debug) {
                    getLogger().debug("Signature File: \n" + new String(sfBytes) + "\n" + HexDumpEncoder.encode(sfBytes));
                }
                zioEntry.getOutputStream().write(sfBytes);
                zipOutput.write(zioEntry);
                this.progressHelper.progress(0, this.resourceAdapter.getString(Item.GENERATING_SIGNATURE_BLOCK, new Object[0]));
                zioEntry = new ZioEntry(CERT_RSA_NAME);
                zioEntry.setTime(timestamp);
                writeSignatureBlock(this.keySet, sfBytes, zioEntry.getOutputStream());
                zipOutput.write(zioEntry);
                if (this.canceled) {
                    zipOutput.close();
                    if (this.canceled && outputZipFilename != null) {
                        try {
                            new File(outputZipFilename).delete();
                            return;
                        } catch (Throwable t222) {
                            getLogger().warning(t222.getClass().getName() + ":" + t222.getMessage());
                            return;
                        }
                    }
                    return;
                }
                copyFiles(manifest, zioEntries, zipOutput, timestamp);
                if (this.canceled) {
                    zipOutput.close();
                    if (this.canceled && outputZipFilename != null) {
                        try {
                            new File(outputZipFilename).delete();
                            return;
                        } catch (Throwable t2222) {
                            getLogger().warning(t2222.getClass().getName() + ":" + t2222.getMessage());
                            return;
                        }
                    }
                    return;
                }
                zipOutput.close();
                if (this.canceled && outputZipFilename != null) {
                    try {
                        new File(outputZipFilename).delete();
                    } catch (Throwable t22222) {
                        getLogger().warning(t22222.getClass().getName() + ":" + t22222.getMessage());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutput.close();
                if (this.canceled && outputZipFilename != null) {
                    try {
                        new File(outputZipFilename).delete();
                    } catch (Throwable t222222) {
                        getLogger().warning(t222222.getClass().getName() + ":" + t222222.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipOutput = null;
            zipOutput.close();
            new File(outputZipFilename).delete();
            throw th;
        }
    }

    public void addProgressListener(ProgressListener l) {
        this.progressHelper.addProgressListener(l);
    }

    public synchronized void removeProgressListener(ProgressListener l) {
        this.progressHelper.removeProgressListener(l);
    }
}
