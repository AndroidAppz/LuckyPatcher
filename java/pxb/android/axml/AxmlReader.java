package pxb.android.axml;

import java.io.IOException;
import java.util.Stack;
import pxb.android.axmlLP.AxmlVisitor;

public class AxmlReader {
    public static final NodeVisitor EMPTY_VISITOR = new NodeVisitor() {
        public NodeVisitor child(String ns, String name) {
            return this;
        }
    };
    final AxmlParser parser;

    public AxmlReader(byte[] data) {
        this.parser = new AxmlParser(data);
    }

    public void accept(AxmlVisitor av) throws IOException {
        Stack<NodeVisitor> nvs = new Stack();
        NodeVisitor tos = av;
        while (true) {
            switch (this.parser.next()) {
                case ValueWrapper.STYLE /*2*/:
                    nvs.push(tos);
                    tos = tos.child(this.parser.getNamespaceUri(), this.parser.getName());
                    if (tos != null) {
                        if (tos == EMPTY_VISITOR) {
                            break;
                        }
                        tos.line(this.parser.getLineNumber());
                        for (int i = 0; i < this.parser.getAttrCount(); i++) {
                            tos.attr(this.parser.getAttrNs(i), this.parser.getAttrName(i), this.parser.getAttrResId(i), this.parser.getAttrType(i), this.parser.getAttrValue(i));
                        }
                        break;
                    }
                    tos = EMPTY_VISITOR;
                    break;
                case AxmlVisitor.TYPE_STRING /*3*/:
                    tos.end();
                    tos = (NodeVisitor) nvs.pop();
                    break;
                case AxmlParser.START_NS /*4*/:
                    av.ns(this.parser.getNamespacePrefix(), this.parser.getNamespaceUri(), this.parser.getLineNumber());
                    break;
                case AxmlParser.END_NS /*5*/:
                    break;
                case AxmlParser.TEXT /*6*/:
                    tos.text(this.parser.getLineNumber(), this.parser.getText());
                    break;
                case AxmlParser.END_FILE /*7*/:
                    return;
                default:
                    break;
            }
        }
    }
}
