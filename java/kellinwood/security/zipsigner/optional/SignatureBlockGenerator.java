/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.PrivateKey
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  org.spongycastle.asn1.cms.ContentInfo
 *  org.spongycastle.cert.jcajce.JcaCertStore
 *  org.spongycastle.cms.CMSProcessableByteArray
 *  org.spongycastle.cms.CMSSignedData
 *  org.spongycastle.cms.CMSSignedDataGenerator
 *  org.spongycastle.cms.CMSTypedData
 *  org.spongycastle.cms.SignerInfoGenerator
 *  org.spongycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder
 *  org.spongycastle.operator.ContentSigner
 *  org.spongycastle.operator.DigestCalculatorProvider
 *  org.spongycastle.operator.jcajce.JcaContentSignerBuilder
 *  org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder
 *  org.spongycastle.util.Store
 */
package kellinwood.security.zipsigner.optional;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import kellinwood.security.zipsigner.KeySet;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.cert.jcajce.JcaCertStore;
import org.spongycastle.cms.CMSProcessableByteArray;
import org.spongycastle.cms.CMSSignedData;
import org.spongycastle.cms.CMSSignedDataGenerator;
import org.spongycastle.cms.CMSTypedData;
import org.spongycastle.cms.SignerInfoGenerator;
import org.spongycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.spongycastle.operator.ContentSigner;
import org.spongycastle.operator.DigestCalculatorProvider;
import org.spongycastle.operator.jcajce.JcaContentSignerBuilder;
import org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.spongycastle.util.Store;

public class SignatureBlockGenerator {
    public static byte[] generate(KeySet keySet, byte[] arrby) {
        try {
            ArrayList arrayList = new ArrayList();
            CMSProcessableByteArray cMSProcessableByteArray = new CMSProcessableByteArray(arrby);
            arrayList.add((Object)keySet.getPublicKey());
            JcaCertStore jcaCertStore = new JcaCertStore((Collection)arrayList);
            CMSSignedDataGenerator cMSSignedDataGenerator = new CMSSignedDataGenerator();
            ContentSigner contentSigner = new JcaContentSignerBuilder(keySet.getSignatureAlgorithm()).setProvider("SC").build(keySet.getPrivateKey());
            JcaSignerInfoGeneratorBuilder jcaSignerInfoGeneratorBuilder = new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("SC").build());
            jcaSignerInfoGeneratorBuilder.setDirectSignature(true);
            cMSSignedDataGenerator.addSignerInfoGenerator(jcaSignerInfoGeneratorBuilder.build(contentSigner, keySet.getPublicKey()));
            cMSSignedDataGenerator.addCertificates((Store)jcaCertStore);
            byte[] arrby2 = cMSSignedDataGenerator.generate((CMSTypedData)cMSProcessableByteArray, false).toASN1Structure().getEncoded("DER");
            return arrby2;
        }
        catch (Exception var4_9) {
            throw new RuntimeException(var4_9.getMessage(), (Throwable)var4_9);
        }
    }
}

