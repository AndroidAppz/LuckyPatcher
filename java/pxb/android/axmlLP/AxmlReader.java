/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package pxb.android.axmlLP;

import com.googlecode.dex2jar.reader.io.ArrayDataIn;
import com.googlecode.dex2jar.reader.io.DataIn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pxb.android.axmlLP.AxmlVisitor;
import pxb.android.axmlLP.StringItems;

public class AxmlReader {
    static final int CHUNK_AXML_FILE = 524291;
    static final int CHUNK_RESOURCEIDS = 524672;
    static final int CHUNK_STRINGS = 1835009;
    static final int CHUNK_XML_END_NAMESPACE = 1048833;
    static final int CHUNK_XML_END_TAG = 1048835;
    static final int CHUNK_XML_START_NAMESPACE = 1048832;
    static final int CHUNK_XML_START_TAG = 1048834;
    static final int CHUNK_XML_TEXT = 1048836;
    public static final AxmlVisitor.NodeVisitor EMPTY_VISITOR = new AxmlVisitor.NodeVisitor(){

        @Override
        public AxmlVisitor.NodeVisitor child(String string, String string2) {
            return AxmlReader.EMPTY_VISITOR;
        }
    };
    static final int UTF8_FLAG = 256;
    private DataIn in;
    private List<Integer> resourceIds;
    private StringItems stringItems;

    public AxmlReader(DataIn dataIn) {
        this.resourceIds = new ArrayList();
        this.stringItems = new StringItems();
        this.in = dataIn;
    }

    public AxmlReader(byte[] arrby) {
        super(ArrayDataIn.le(arrby));
    }

    /*
     * Exception decompiling
     */
    public void accept(AxmlVisitor var1) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
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

}

