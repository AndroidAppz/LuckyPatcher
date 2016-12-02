/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.FileWriter
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.PrintWriter
 *  java.io.Writer
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.Key
 *  java.security.KeyStore
 *  java.security.KeyStore$Entry
 *  java.security.Provider
 *  java.security.Security
 *  java.security.cert.Certificate
 *  org.spongycastle.jce.provider.BouncyCastleProvider
 */
package kellinwood.security.zipsigner.optional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.security.Key;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.security.zipsigner.optional.JksKeyStore;
import kellinwood.security.zipsigner.optional.KeyNameConflictException;
import kellinwood.security.zipsigner.optional.PasswordObfuscator;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class KeyStoreFileManager {
    static LoggerInterface logger;
    static Provider provider;

    static {
        provider = new BouncyCastleProvider();
        logger = LoggerManager.getLogger(KeyStoreFileManager.class.getName());
        Security.addProvider((Provider)KeyStoreFileManager.getProvider());
    }

    public static boolean containsKey(String string, String string2, String string3) throws Exception {
        return KeyStoreFileManager.loadKeyStore(string, string2).containsAlias(string3);
    }

    /*
     * Exception decompiling
     */
    static void copyFile(File var0_1, File var1, boolean var2_2) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredCatch.transformStructuredChildren(StructuredCatch.java:72)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredTry.transformStructuredChildren(StructuredTry.java:81)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredCatch.transformStructuredChildren(StructuredCatch.java:72)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredTry.transformStructuredChildren(StructuredTry.java:81)
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
     * Enabled aggressive block sorting
     */
    public static KeyStore createKeyStore(String string, char[] arrc) throws Exception {
        JksKeyStore jksKeyStore = string.toLowerCase().endsWith(".bks") ? KeyStore.getInstance((String)"bks", (Provider)new BouncyCastleProvider()) : new JksKeyStore();
        jksKeyStore.load(null, arrc);
        return jksKeyStore;
    }

    public static void deleteKey(String string, String string2, String string3) throws Exception {
        KeyStore keyStore = KeyStoreFileManager.loadKeyStore(string, string2);
        keyStore.deleteEntry(string3);
        KeyStoreFileManager.writeKeyStore(keyStore, string, string2);
    }

    /*
     * Exception decompiling
     */
    public static KeyStore.Entry getKeyEntry(String var0_1, String var1, String var2_3, String var3_2) throws Exception {
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

    public static Provider getProvider() {
        return provider;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static KeyStore loadKeyStore(String var0_1, String var1) throws Exception {
        var2_2 = null;
        if (var1 == null) ** GOTO lbl5
        try {
            var2_2 = PasswordObfuscator.getInstance().decodeKeystorePassword(var0_1, var1);
lbl5: // 2 sources:
            var4_3 = KeyStoreFileManager.loadKeyStore(var0_1, (char[])var2_2);
            return var4_3;
        }
        finally {
            if (var2_2 != null) {
                PasswordObfuscator.flush((char[])var2_2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static KeyStore loadKeyStore(String string, char[] arrc) throws Exception {
        JksKeyStore jksKeyStore;
        try {
            jksKeyStore = new JksKeyStore();
        }
        catch (Exception var8_4) {}
        try {
            FileInputStream fileInputStream = new FileInputStream(string);
            jksKeyStore.load((InputStream)fileInputStream, arrc);
            fileInputStream.close();
            return jksKeyStore;
        }
        catch (Exception var4_8) {}
        {
            try {
                KeyStore keyStore = KeyStore.getInstance((String)"bks", (Provider)KeyStoreFileManager.getProvider());
                FileInputStream fileInputStream = new FileInputStream(string);
                keyStore.load((InputStream)fileInputStream, arrc);
                fileInputStream.close();
                return keyStore;
            }
            catch (Exception var5_7) {
                throw new RuntimeException("Failed to load keystore: " + var5_7.getMessage(), (Throwable)var5_7);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String renameKey(String string, String string2, String string3, String string4, String string5) throws Exception {
        Object object = null;
        try {
            KeyStore keyStore = KeyStoreFileManager.loadKeyStore(string, string2);
            boolean bl = keyStore instanceof JksKeyStore;
            object = null;
            if (bl) {
                string4 = string4.toLowerCase();
            }
            boolean bl2 = keyStore.containsAlias(string4);
            object = null;
            if (bl2) {
                throw new KeyNameConflictException();
            }
            object = PasswordObfuscator.getInstance().decodeAliasPassword(string, string3, string5);
            keyStore.setKeyEntry(string4, keyStore.getKey(string3, (char[])object), (char[])object, new Certificate[]{keyStore.getCertificate(string3)});
            keyStore.deleteEntry(string3);
            KeyStoreFileManager.writeKeyStore(keyStore, string, string2);
            return string4;
        }
        finally {
            PasswordObfuscator.flush((char[])object);
        }
    }

    public static void renameTo(File file, File file2) throws IOException {
        KeyStoreFileManager.copyFile(file, file2, true);
        if (!file.delete()) {
            throw new IOException("Failed to delete " + (Object)file);
        }
    }

    public static void setProvider(Provider provider) {
        if (KeyStoreFileManager.provider != null) {
            Security.removeProvider((String)KeyStoreFileManager.provider.getName());
        }
        KeyStoreFileManager.provider = provider;
        Security.addProvider((Provider)provider);
    }

    public static void validateKeyPassword(String string, String string2, String string3) throws Exception {
        Object object = null;
        try {
            KeyStore keyStore = KeyStoreFileManager.loadKeyStore(string, (char[])null);
            object = PasswordObfuscator.getInstance().decodeAliasPassword(string, string2, string3);
            keyStore.getKey(string2, (char[])object);
            return;
        }
        finally {
            if (object != null) {
                PasswordObfuscator.flush((char[])object);
            }
        }
    }

    public static void validateKeystorePassword(String string, String string2) throws Exception {
        try {
            KeyStoreFileManager.loadKeyStore(string, string2);
            return;
        }
        finally {
            if (false) {
                PasswordObfuscator.flush(null);
            }
        }
    }

    public static void writeKeyStore(KeyStore keyStore, String string, String string2) throws Exception {
        Object object = null;
        try {
            object = PasswordObfuscator.getInstance().decodeKeystorePassword(string, string2);
            KeyStoreFileManager.writeKeyStore(keyStore, string, (char[])object);
            return;
        }
        finally {
            if (object != null) {
                PasswordObfuscator.flush((char[])object);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void writeKeyStore(KeyStore keyStore, String string, char[] arrc) throws Exception {
        File file = new File(string);
        try {
            if (file.exists()) {
                File file2 = File.createTempFile((String)file.getName(), (String)null, (File)file.getParentFile());
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                keyStore.store((OutputStream)fileOutputStream, arrc);
                fileOutputStream.flush();
                fileOutputStream.close();
                KeyStoreFileManager.renameTo(file2, file);
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            keyStore.store((OutputStream)fileOutputStream, arrc);
            fileOutputStream.close();
            return;
        }
        catch (Exception var4_7) {
            try {
                PrintWriter printWriter = new PrintWriter((Writer)new FileWriter(File.createTempFile((String)"zipsigner-error", (String)".log", (File)file.getParentFile())));
                var4_7.printStackTrace(printWriter);
                printWriter.flush();
                printWriter.close();
            }
            catch (Exception var6_9) {
                throw var4_7;
            }
            do {
                throw var4_7;
                break;
            } while (true);
        }
    }
}

