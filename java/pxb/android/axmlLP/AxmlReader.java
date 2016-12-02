package pxb.android.axmlLP;

import com.googlecode.dex2jar.reader.io.ArrayDataIn;
import com.googlecode.dex2jar.reader.io.DataIn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import pxb.android.axmlLP.AxmlVisitor.NodeVisitor;

public class AxmlReader {
    static final int CHUNK_AXML_FILE = 524291;
    static final int CHUNK_RESOURCEIDS = 524672;
    static final int CHUNK_STRINGS = 1835009;
    static final int CHUNK_XML_END_NAMESPACE = 1048833;
    static final int CHUNK_XML_END_TAG = 1048835;
    static final int CHUNK_XML_START_NAMESPACE = 1048832;
    static final int CHUNK_XML_START_TAG = 1048834;
    static final int CHUNK_XML_TEXT = 1048836;
    public static final NodeVisitor EMPTY_VISITOR = new NodeVisitor() {
        public NodeVisitor child(String ns, String name) {
            return AxmlReader.EMPTY_VISITOR;
        }
    };
    static final int UTF8_FLAG = 256;
    private DataIn in;
    private List<Integer> resourceIds;
    private StringItems stringItems;

    public AxmlReader(byte[] data) {
        this(ArrayDataIn.le(data));
    }

    public AxmlReader(DataIn in) {
        this.resourceIds = new ArrayList();
        this.stringItems = new StringItems();
        this.in = in;
    }

    public void accept(AxmlVisitor documentVisitor) throws IOException {
        DataIn in = this.in;
        if (in.readIntx() != CHUNK_AXML_FILE) {
            throw new RuntimeException();
        }
        NodeVisitor root;
        int fileSize = in.readIntx();
        if (documentVisitor == null) {
            root = EMPTY_VISITOR;
        } else {
            final AxmlVisitor axmlVisitor = documentVisitor;
            NodeVisitor anonymousClass2 = new NodeVisitor() {
                public NodeVisitor child(String ns, String name) {
                    return axmlVisitor.first(ns, name);
                }
            };
        }
        NodeVisitor tos = root;
        Stack<NodeVisitor> nvs = new Stack();
        nvs.push(root);
        for (int p = in.getCurrentPosition(); p < fileSize; p = in.getCurrentPosition()) {
            int type = in.readIntx();
            int size = in.readIntx();
            int i;
            int lineNumber;
            int nameIdx;
            switch (type) {
                case CHUNK_RESOURCEIDS /*524672*/:
                    int count = (size / 4) - 2;
                    for (i = 0; i < count; i++) {
                        this.resourceIds.add(Integer.valueOf(in.readIntx()));
                    }
                    break;
                case CHUNK_XML_START_NAMESPACE /*1048832*/:
                    if (documentVisitor != null) {
                        lineNumber = in.readIntx();
                        in.skip(4);
                        documentVisitor.ns(((StringItem) this.stringItems.get(in.readIntx())).data, ((StringItem) this.stringItems.get(in.readIntx())).data, lineNumber);
                        break;
                    }
                    in.skip(16);
                    break;
                case CHUNK_XML_END_NAMESPACE /*1048833*/:
                    in.skip(size - 8);
                    break;
                case CHUNK_XML_START_TAG /*1048834*/:
                    lineNumber = in.readIntx();
                    in.skip(4);
                    int nsIdx = in.readIntx();
                    nameIdx = in.readIntx();
                    if (in.readIntx() == 1310740) {
                        tos = tos.child(nsIdx >= 0 ? ((StringItem) this.stringItems.get(nsIdx)).data : null, ((StringItem) this.stringItems.get(nameIdx)).data);
                        if (tos == null) {
                            tos = EMPTY_VISITOR;
                        }
                        nvs.push(tos);
                        tos.line(lineNumber);
                        int attributeCount = in.readUShortx();
                        in.skip(6);
                        if (tos == EMPTY_VISITOR) {
                            in.skip(20);
                            break;
                        }
                        for (i = 0; i < attributeCount; i++) {
                            Object value;
                            nsIdx = in.readIntx();
                            nameIdx = in.readIntx();
                            in.skip(4);
                            int aValueType = in.readIntx() >>> 24;
                            int aValue = in.readIntx();
                            String name = ((StringItem) this.stringItems.get(nameIdx)).data;
                            String ns = nsIdx >= 0 ? ((StringItem) this.stringItems.get(nsIdx)).data : null;
                            switch (aValueType) {
                                case AxmlVisitor.TYPE_STRING /*3*/:
                                    value = ((StringItem) this.stringItems.get(aValue)).data;
                                    break;
                                case AxmlVisitor.TYPE_INT_BOOLEAN /*18*/:
                                    value = Boolean.valueOf(aValue != 0);
                                    break;
                                default:
                                    value = Integer.valueOf(aValue);
                                    break;
                            }
                            tos.attr(ns, name, nameIdx < this.resourceIds.size() ? ((Integer) this.resourceIds.get(nameIdx)).intValue() : -1, aValueType, value);
                        }
                        break;
                    }
                    throw new RuntimeException();
                case CHUNK_XML_END_TAG /*1048835*/:
                    in.skip(size - 8);
                    tos.end();
                    nvs.pop();
                    tos = (NodeVisitor) nvs.peek();
                    break;
                case CHUNK_XML_TEXT /*1048836*/:
                    if (tos != EMPTY_VISITOR) {
                        lineNumber = in.readIntx();
                        in.skip(4);
                        nameIdx = in.readIntx();
                        in.skip(8);
                        tos.text(lineNumber, ((StringItem) this.stringItems.get(nameIdx)).data);
                        break;
                    }
                    in.skip(20);
                    break;
                case CHUNK_STRINGS /*1835009*/:
                    this.stringItems.read(in, size);
                    break;
                default:
                    throw new RuntimeException();
            }
            in.move(p + size);
        }
    }
}
