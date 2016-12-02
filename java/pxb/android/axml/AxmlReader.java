/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Stack
 */
package pxb.android.axml;

import java.io.IOException;
import java.util.Stack;
import pxb.android.axml.AxmlParser;
import pxb.android.axml.AxmlVisitor;
import pxb.android.axml.NodeVisitor;

public class AxmlReader {
    public static final NodeVisitor EMPTY_VISITOR = new NodeVisitor(){

        @Override
        public NodeVisitor child(String string, String string2) {
            return this;
        }
    };
    final AxmlParser parser;

    public AxmlReader(byte[] arrby) {
        this.parser = new AxmlParser(arrby);
    }

    public void accept(AxmlVisitor axmlVisitor) throws IOException {
        Stack stack = new Stack();
        NodeVisitor nodeVisitor = axmlVisitor;
        block8 : do {
            switch (this.parser.next()) {
                case 5: {
                    continue block8;
                }
                default: {
                    continue block8;
                }
                case 2: {
                    stack.push((Object)nodeVisitor);
                    nodeVisitor = nodeVisitor.child(this.parser.getNamespaceUri(), this.parser.getName());
                    if (nodeVisitor != null) {
                        if (nodeVisitor == EMPTY_VISITOR) continue block8;
                        nodeVisitor.line(this.parser.getLineNumber());
                        int n = 0;
                        do {
                            if (n >= this.parser.getAttrCount()) continue block8;
                            nodeVisitor.attr(this.parser.getAttrNs(n), this.parser.getAttrName(n), this.parser.getAttrResId(n), this.parser.getAttrType(n), this.parser.getAttrValue(n));
                            ++n;
                        } while (true);
                    }
                    nodeVisitor = EMPTY_VISITOR;
                    continue block8;
                }
                case 3: {
                    nodeVisitor.end();
                    nodeVisitor = (NodeVisitor)stack.pop();
                    continue block8;
                }
                case 4: {
                    axmlVisitor.ns(this.parser.getNamespacePrefix(), this.parser.getNamespaceUri(), this.parser.getLineNumber());
                    continue block8;
                }
                case 6: {
                    nodeVisitor.text(this.parser.getLineNumber(), this.parser.getText());
                    continue block8;
                }
                case 7: 
            }
            break;
        } while (true);
    }

}

