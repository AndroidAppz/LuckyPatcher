/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  javax.xml.parsers.DocumentBuilder
 *  javax.xml.parsers.DocumentBuilderFactory
 *  javax.xml.parsers.ParserConfigurationException
 *  org.w3c.dom.Document
 *  org.w3c.dom.Element
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 *  org.xml.sax.SAXException
 */
package com.chelpus;

import com.chelpus.XNodeException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SimpleXPath {
    public static final String XPATH_SEPARATOR = "/";
    Document mDocument;

    public SimpleXPath(File file) throws ParserConfigurationException, SAXException, IOException {
        this.mDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse((InputStream)new FileInputStream(file));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void getNodes(Node node, String string, List<XNode> list) {
        String[] arrstring = string.split("/", 2);
        boolean bl = arrstring.length == 1;
        Node node2 = node.getFirstChild();
        while (node2 != null) {
            if (arrstring[0].equals((Object)node2.getNodeName())) {
                if (bl) {
                    list.add((Object)(SimpleXPath)this.new XNode(node2));
                } else {
                    super.getNodes(node2, arrstring[1], list);
                }
            }
            try {
                Node node3;
                node2 = node3 = node2.getNextSibling();
            }
            catch (Exception var7_8) {}
            return;
        }
        return;
    }

    public Node getRoot() {
        return this.mDocument;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public XNode getXPathNode(Node node, String string) {
        String[] arrstring = string.split("/", 2);
        boolean bl = arrstring.length == 1;
        Node node2 = node.getFirstChild();
        do {
            XNode xNode = null;
            if (node2 == null) return xNode;
            if (arrstring[0].equals((Object)node2.getNodeName())) {
                if (bl) return (SimpleXPath)this.new XNode(node2);
                return this.getXPathNode(node2, arrstring[1]);
            }
            try {
                Node node3;
                node2 = node3 = node2.getNextSibling();
                continue;
            }
            catch (Exception var7_7) {}
            return null;
        } while (true);
    }

    public List<XNode> getXPathNodes(Node node, String string) {
        ArrayList arrayList = new ArrayList();
        super.getNodes(node, string, (List<XNode>)arrayList);
        return arrayList;
    }

    public class XNode {
        Node mNode;

        public XNode(Node node) {
            this.mNode = node;
        }

        String getAttribute(String string) throws XNodeException {
            String string2 = ((Element)this.mNode).getAttribute(string);
            if (string2.length() == 0) {
                Object[] arrobject = new Object[]{this.getName(), string};
                throw new XNodeException(String.format((String)"Node [%s] has no [%s] attribute!", (Object[])arrobject));
            }
            return string2;
        }

        XNode getChild(String string) throws XNodeException {
            List<XNode> list = SimpleXPath.this.getXPathNodes(this.mNode, string);
            if (list.size() == 0) {
                Object[] arrobject = new Object[]{this.mNode.getNodeName(), string};
                throw new XNodeException(String.format((String)"Node [%s] has no child at path [%s]!", (Object[])arrobject));
            }
            return (XNode)list.get(0);
        }

        List<XNode> getChildren(String string) throws XNodeException {
            List<XNode> list = SimpleXPath.this.getXPathNodes(this.mNode, string);
            if (list.isEmpty()) {
                Object[] arrobject = new Object[]{this.mNode.getNodeName(), string};
                throw new XNodeException(String.format((String)"Node [%s] has no children at path [%s]!", (Object[])arrobject));
            }
            return list;
        }

        float getFloatAttribute(String string) throws XNodeException {
            return Float.parseFloat((String)this.getAttribute(string));
        }

        public int getIntAttribute(String string) throws XNodeException {
            return Integer.parseInt((String)this.getAttribute(string));
        }

        public String getName() {
            return this.mNode.getNodeName();
        }

        public String getStringAttribute(String string) throws XNodeException {
            return this.getAttribute(string);
        }

        public String getValue() {
            return this.mNode.getChildNodes().item(0).getNodeValue();
        }
    }

}

