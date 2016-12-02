/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.DataInputStream
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.PrintStream
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.net.URL
 *  java.security.AlgorithmParameters
 *  java.security.DigestOutputStream
 *  java.security.GeneralSecurityException
 *  java.security.Key
 *  java.security.KeyFactory
 *  java.security.KeyStore
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PrivateKey
 *  java.security.Provider
 *  java.security.Security
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateFactory
 *  java.security.cert.X509Certificate
 *  java.security.spec.InvalidKeySpecException
 *  java.security.spec.KeySpec
 *  java.security.spec.PKCS8EncodedKeySpec
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Observable
 *  java.util.Observer
 *  java.util.Set
 *  java.util.jar.Attributes
 *  java.util.jar.Manifest
 *  java.util.regex.Pattern
 *  javax.crypto.Cipher
 *  javax.crypto.EncryptedPrivateKeyInfo
 *  javax.crypto.SecretKey
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.PBEKeySpec
 */
package kellinwood.security.zipsigner;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AlgorithmParameters;
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
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.security.zipsigner.Base64;
import kellinwood.security.zipsigner.DefaultResourceAdapter;
import kellinwood.security.zipsigner.HexDumpEncoder;
import kellinwood.security.zipsigner.KeySet;
import kellinwood.security.zipsigner.ProgressHelper;
import kellinwood.security.zipsigner.ProgressListener;
import kellinwood.security.zipsigner.ResourceAdapter;
import kellinwood.security.zipsigner.ZipSignature;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipInput;
import kellinwood.zipio.ZipOutput;

public class ZipSigner {
    private static final String CERT_RSA_NAME = "META-INF/CERT.RSA";
    private static final String CERT_SF_NAME = "META-INF/CERT.SF";
    public static final String KEY_NONE = "none";
    public static final String KEY_TESTKEY = "testkey";
    public static final String MODE_AUTO = "auto";
    public static final String MODE_AUTO_NONE = "auto-none";
    public static final String MODE_AUTO_TESTKEY = "auto-testkey";
    public static final String[] SUPPORTED_KEY_MODES;
    static LoggerInterface log;
    private static Pattern stripPattern;
    Map<String, String> autoKeyDetect = new HashMap();
    AutoKeyObservable autoKeyObservable = new AutoKeyObservable();
    private boolean canceled = false;
    KeySet keySet = null;
    String keymode = "testkey";
    Map<String, KeySet> loadedKeys = new HashMap();
    private ProgressHelper progressHelper = new ProgressHelper();
    private ResourceAdapter resourceAdapter = new DefaultResourceAdapter();

    static {
        log = null;
        stripPattern = Pattern.compile((String)"^META-INF/(.*)[.](SF|RSA|DSA)$");
        SUPPORTED_KEY_MODES = new String[]{"auto-testkey", "auto", "auto-none", "media", "platform", "shared", "testkey", "none"};
    }

    public ZipSigner() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.autoKeyDetect.put((Object)"aa9852bc5a53272ac8031d49b65e4b0e", (Object)"media");
        this.autoKeyDetect.put((Object)"e60418c4b638f20d0721e115674ca11f", (Object)"platform");
        this.autoKeyDetect.put((Object)"3e24e49741b60c215c010dc6048fca7d", (Object)"shared");
        this.autoKeyDetect.put((Object)"dab2cead827ef5313f28e22b6fa8479f", (Object)"testkey");
    }

    /*
     * Exception decompiling
     */
    private Manifest addDigestsToManifest(Map<String, ZioEntry> var1) throws IOException, GeneralSecurityException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredWhile.transformStructuredChildren(StructuredWhile.java:50)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void copyFiles(Map<String, ZioEntry> map, ZipOutput zipOutput) throws IOException {
        int n = 1;
        for (ZioEntry zioEntry : map.values()) {
            if (this.canceled) {
                return;
            }
            ProgressHelper progressHelper = this.progressHelper;
            ResourceAdapter resourceAdapter = this.resourceAdapter;
            ResourceAdapter.Item item = ResourceAdapter.Item.COPYING_ZIP_ENTRY;
            Object[] arrobject = new Object[]{n, map.size()};
            progressHelper.progress(0, resourceAdapter.getString(item, arrobject));
            ++n;
            zipOutput.write(zioEntry);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void copyFiles(Manifest manifest, Map<String, ZioEntry> map, ZipOutput zipOutput, long l) throws IOException {
        ArrayList arrayList = new ArrayList((Collection)manifest.getEntries().keySet());
        Collections.sort((List)arrayList);
        int n = 1;
        for (String string : arrayList) {
            if (this.canceled) {
                return;
            }
            ProgressHelper progressHelper = this.progressHelper;
            ResourceAdapter resourceAdapter = this.resourceAdapter;
            ResourceAdapter.Item item = ResourceAdapter.Item.COPYING_ZIP_ENTRY;
            Object[] arrobject = new Object[]{n, arrayList.size()};
            progressHelper.progress(0, resourceAdapter.getString(item, arrobject));
            ++n;
            ZioEntry zioEntry = (ZioEntry)map.get((Object)string);
            zioEntry.setTime(l);
            zipOutput.write(zioEntry);
        }
    }

    private KeySpec decryptPrivateKey(byte[] arrby, String string) throws GeneralSecurityException {
        EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;
        try {
            encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(arrby);
        }
        catch (IOException var9_8) {
            return null;
        }
        char[] arrc = string.toCharArray();
        SecretKey secretKey = SecretKeyFactory.getInstance((String)encryptedPrivateKeyInfo.getAlgName()).generateSecret((KeySpec)new PBEKeySpec(arrc));
        Cipher cipher = Cipher.getInstance((String)encryptedPrivateKeyInfo.getAlgName());
        cipher.init(2, (Key)secretKey, encryptedPrivateKeyInfo.getAlgParameters());
        try {
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = encryptedPrivateKeyInfo.getKeySpec(cipher);
            return pKCS8EncodedKeySpec;
        }
        catch (InvalidKeySpecException var7_9) {
            ZipSigner.getLogger().error("signapk: Password for private key may be bad.");
            throw var7_9;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void generateSignatureFile(Manifest manifest, OutputStream outputStream) throws IOException, GeneralSecurityException {
        outputStream.write("Signature-Version: 1.0\r\n".getBytes());
        outputStream.write("Created-By: 1.0 (Android SignApk)\r\n".getBytes());
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA1");
        PrintStream printStream = new PrintStream((OutputStream)new DigestOutputStream((OutputStream)new ByteArrayOutputStream(), messageDigest), true, "UTF-8");
        manifest.write((OutputStream)printStream);
        printStream.flush();
        outputStream.write(("SHA1-Digest-Manifest: " + Base64.encode(messageDigest.digest()) + "\r\n\r\n").getBytes());
        for (Map.Entry entry : manifest.getEntries().entrySet()) {
            if (this.canceled) {
                return;
            }
            this.progressHelper.progress(0, this.resourceAdapter.getString(ResourceAdapter.Item.GENERATING_SIGNATURE_FILE, new Object[0]));
            String string = "Name: " + (String)entry.getKey() + "\r\n";
            printStream.print(string);
            for (Map.Entry entry2 : ((Attributes)entry.getValue()).entrySet()) {
                printStream.print(entry2.getKey() + ": " + entry2.getValue() + "\r\n");
            }
            printStream.print("\r\n");
            printStream.flush();
            outputStream.write(string.getBytes());
            outputStream.write(("SHA1-Digest: " + Base64.encode(messageDigest.digest()) + "\r\n\r\n").getBytes());
        }
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipSigner.class.getName());
        }
        return log;
    }

    public static String[] getSupportedKeyModes() {
        return SUPPORTED_KEY_MODES;
    }

    private void writeSignatureBlock(KeySet keySet, byte[] arrby, OutputStream outputStream) throws IOException, GeneralSecurityException {
        if (keySet.getSigBlockTemplate() != null) {
            ZipSignature zipSignature = new ZipSignature();
            zipSignature.initSign(keySet.getPrivateKey());
            zipSignature.update(arrby);
            byte[] arrby2 = zipSignature.sign();
            outputStream.write(keySet.getSigBlockTemplate());
            outputStream.write(arrby2);
            if (ZipSigner.getLogger().isDebugEnabled()) {
                MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA1");
                messageDigest.update(arrby);
                byte[] arrby3 = messageDigest.digest();
                ZipSigner.getLogger().debug("Sig File SHA1: \n" + HexDumpEncoder.encode(arrby3));
                ZipSigner.getLogger().debug("Signature: \n" + HexDumpEncoder.encode(arrby2));
                Cipher cipher = Cipher.getInstance((String)"RSA/ECB/PKCS1Padding");
                cipher.init(2, (Certificate)keySet.getPublicKey());
                byte[] arrby4 = cipher.doFinal(arrby2);
                ZipSigner.getLogger().debug("Signature Decrypted: \n" + HexDumpEncoder.encode(arrby4));
            }
            return;
        }
        try {
            Class class_ = Class.forName((String)"kellinwood.security.zipsigner.optional.SignatureBlockGenerator");
            Class[] arrclass = new Class[]{KeySet.class, new byte[1].getClass()};
            outputStream.write((byte[])class_.getMethod("generate", arrclass).invoke((Object)null, new Object[]{keySet, arrby}));
            return;
        }
        catch (Exception var10_12) {
            throw new RuntimeException(var10_12.getMessage(), (Throwable)var10_12);
        }
    }

    public void addAutoKeyObserver(Observer observer) {
        this.autoKeyObservable.addObserver(observer);
    }

    public void addProgressListener(ProgressListener progressListener) {
        this.progressHelper.addProgressListener(progressListener);
    }

    /*
     * Exception decompiling
     */
    protected String autoDetectKey(String var1, Map<String, ZioEntry> var2_2) throws NoSuchAlgorithmException, IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public void cancel() {
        this.canceled = true;
    }

    public KeySet getKeySet() {
        return this.keySet;
    }

    public String getKeymode() {
        return this.keymode;
    }

    public ResourceAdapter getResourceAdapter() {
        return this.resourceAdapter;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void issueLoadingCertAndKeysProgressEvent() {
        this.progressHelper.progress(1, this.resourceAdapter.getString(ResourceAdapter.Item.LOADING_CERTIFICATE_AND_KEY, new Object[0]));
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void loadKeys(String string) throws IOException, GeneralSecurityException {
        this.keySet = (KeySet)this.loadedKeys.get((Object)string);
        if (this.keySet != null) {
            return;
        }
        this.keySet = new KeySet();
        this.keySet.setName(string);
        this.loadedKeys.put((Object)string, (Object)this.keySet);
        if ("none".equals((Object)string)) return;
        this.issueLoadingCertAndKeysProgressEvent();
        URL uRL = this.getClass().getResource("/keys/" + string + ".pk8");
        this.keySet.setPrivateKey(this.readPrivateKey(uRL, null));
        URL uRL2 = this.getClass().getResource("/keys/" + string + ".x509.pem");
        this.keySet.setPublicKey(this.readPublicKey(uRL2));
        URL uRL3 = this.getClass().getResource("/keys/" + string + ".sbt");
        if (uRL3 == null) return;
        this.keySet.setSigBlockTemplate(this.readContentAsBytes(uRL3));
    }

    public void loadProvider(String string) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Security.insertProviderAt((Provider)((Provider)Class.forName((String)string).newInstance()), (int)1);
    }

    public byte[] readContentAsBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[2048];
        int n = inputStream.read(arrby);
        while (n != -1) {
            byteArrayOutputStream.write(arrby, 0, n);
            n = inputStream.read(arrby);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] readContentAsBytes(URL uRL) throws IOException {
        return this.readContentAsBytes(uRL.openStream());
    }

    public PrivateKey readPrivateKey(URL uRL, String string) throws IOException, GeneralSecurityException {
        DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
        try {
            byte[] arrby = this.readContentAsBytes((InputStream)dataInputStream);
            KeySpec keySpec = super.decryptPrivateKey(arrby, string);
            if (keySpec == null) {
                keySpec = new PKCS8EncodedKeySpec(arrby);
            }
            try {
                PrivateKey privateKey = KeyFactory.getInstance((String)"RSA").generatePrivate(keySpec);
                return privateKey;
            }
            catch (InvalidKeySpecException var7_7) {
                PrivateKey privateKey = KeyFactory.getInstance((String)"DSA").generatePrivate(keySpec);
                dataInputStream.close();
                return privateKey;
            }
        }
        finally {
            dataInputStream.close();
        }
    }

    public X509Certificate readPublicKey(URL uRL) throws IOException, GeneralSecurityException {
        InputStream inputStream = uRL.openStream();
        try {
            X509Certificate x509Certificate = (X509Certificate)CertificateFactory.getInstance((String)"X.509").generateCertificate(inputStream);
            return x509Certificate;
        }
        finally {
            inputStream.close();
        }
    }

    public void removeProgressListener(ProgressListener progressListener) {
        void var3_2 = this;
        synchronized (var3_2) {
            this.progressHelper.removeProgressListener(progressListener);
            return;
        }
    }

    public void resetCanceled() {
        this.canceled = false;
    }

    public void setKeymode(String string) throws IOException, GeneralSecurityException {
        if (ZipSigner.getLogger().isDebugEnabled()) {
            ZipSigner.getLogger().debug("setKeymode: " + string);
        }
        this.keymode = string;
        if (this.keymode.startsWith("auto")) {
            this.keySet = null;
            return;
        }
        this.progressHelper.initProgress();
        this.loadKeys(this.keymode);
    }

    public void setKeys(String string, X509Certificate x509Certificate, PrivateKey privateKey, String string2, byte[] arrby) {
        this.keySet = new KeySet(string, x509Certificate, privateKey, string2, arrby);
    }

    public void setKeys(String string, X509Certificate x509Certificate, PrivateKey privateKey, byte[] arrby) {
        this.keySet = new KeySet(string, x509Certificate, privateKey, arrby);
    }

    public void setResourceAdapter(ResourceAdapter resourceAdapter) {
        this.resourceAdapter = resourceAdapter;
    }

    public void signZip(String string, String string2) throws IOException, GeneralSecurityException {
        if (new File(string).getCanonicalFile().equals((Object)new File(string2).getCanonicalFile())) {
            throw new IllegalArgumentException(this.resourceAdapter.getString(ResourceAdapter.Item.INPUT_SAME_AS_OUTPUT_ERROR, new Object[0]));
        }
        this.progressHelper.initProgress();
        this.progressHelper.progress(1, this.resourceAdapter.getString(ResourceAdapter.Item.PARSING_CENTRAL_DIRECTORY, new Object[0]));
        this.signZip(ZipInput.read(string).getEntries(), (OutputStream)new FileOutputStream(string2), string2);
    }

    public void signZip(URL uRL, String string, String string2, String string3, String string4, String string5, String string6) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException {
        this.signZip(uRL, string, string2.toCharArray(), string3, string4.toCharArray(), "SHA1withRSA", string5, string6);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void signZip(URL var1_5, String var2_8, char[] var3_3, String var4_4, char[] var5_2, String var6_7, String var7_6, String var8) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException {
        var9_9 = null;
        if (var2_8 != null) ** GOTO lbl5
        try {
            var2_8 = KeyStore.getDefaultType();
lbl5: // 2 sources:
            var11_10 = KeyStore.getInstance((String)var2_8);
            var9_9 = var1_5.openStream();
            var11_10.load(var9_9, var3_3);
            this.setKeys("custom", (X509Certificate)var11_10.getCertificate(var4_4), (PrivateKey)var11_10.getKey(var4_4, var5_2), var6_7, null);
            this.signZip(var7_6, var8);
            return;
        }
        finally {
            if (var9_9 != null) {
                var9_9.close();
            }
        }
    }

    /*
     * Exception decompiling
     */
    public void signZip(Map<String, ZioEntry> var1, OutputStream var2_3, String var3_2) throws IOException, GeneralSecurityException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 23[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public void signZip(Map<String, ZioEntry> map, String string) throws IOException, GeneralSecurityException {
        this.progressHelper.initProgress();
        this.signZip(map, (OutputStream)new FileOutputStream(string), string);
    }

    public static class AutoKeyObservable
    extends Observable {
        public void notifyObservers(Object object) {
            super.setChanged();
            super.notifyObservers(object);
        }
    }

}

