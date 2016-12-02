package kellinwood.security.zipsigner.optional;

import java.util.ArrayList;
import java.util.List;
import kellinwood.security.zipsigner.KeySet;
import org.spongycastle.cert.jcajce.JcaCertStore;
import org.spongycastle.cms.CMSProcessableByteArray;
import org.spongycastle.cms.CMSSignedDataGenerator;
import org.spongycastle.cms.CMSTypedData;
import org.spongycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.spongycastle.operator.ContentSigner;
import org.spongycastle.operator.jcajce.JcaContentSignerBuilder;
import org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.spongycastle.util.Store;

public class SignatureBlockGenerator {
    public static byte[] generate(KeySet keySet, byte[] content) {
        try {
            List certList = new ArrayList();
            CMSTypedData msg = new CMSProcessableByteArray(content);
            certList.add(keySet.getPublicKey());
            Store certs = new JcaCertStore(certList);
            CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
            ContentSigner sha1Signer = new JcaContentSignerBuilder(keySet.getSignatureAlgorithm()).setProvider("SC").build(keySet.getPrivateKey());
            JcaSignerInfoGeneratorBuilder jcaSignerInfoGeneratorBuilder = new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("SC").build());
            jcaSignerInfoGeneratorBuilder.setDirectSignature(true);
            gen.addSignerInfoGenerator(jcaSignerInfoGeneratorBuilder.build(sha1Signer, keySet.getPublicKey()));
            gen.addCertificates(certs);
            return gen.generate(msg, false).toASN1Structure().getEncoded("DER");
        } catch (Exception x) {
            throw new RuntimeException(x.getMessage(), x);
        }
    }
}
