package com.chelpus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class SimpleXPath {
    public static final String XPATH_SEPARATOR = "/";
    Document mDocument;

    public class XNode {
        Node mNode;

        public XNode(Node node) {
            this.mNode = node;
        }

        XNode getChild(String path) throws XNodeException {
            List<XNode> nodes = SimpleXPath.this.getXPathNodes(this.mNode, path);
            if (nodes.size() != 0) {
                return (XNode) nodes.get(0);
            }
            throw new XNodeException(String.format("Node [%s] has no child at path [%s]!", new Object[]{this.mNode.getNodeName(), path}));
        }

        List<XNode> getChildren(String path) throws XNodeException {
            List<XNode> result = SimpleXPath.this.getXPathNodes(this.mNode, path);
            if (!result.isEmpty()) {
                return result;
            }
            throw new XNodeException(String.format("Node [%s] has no children at path [%s]!", new Object[]{this.mNode.getNodeName(), path}));
        }

        public String getName() {
            return this.mNode.getNodeName();
        }

        public String getValue() {
            return this.mNode.getChildNodes().item(0).getNodeValue();
        }

        String getAttribute(String name) throws XNodeException {
            String attribute = this.mNode.getAttribute(name);
            if (attribute.length() != 0) {
                return attribute;
            }
            throw new XNodeException(String.format("Node [%s] has no [%s] attribute!", new Object[]{getName(), name}));
        }

        public String getStringAttribute(String name) throws XNodeException {
            return getAttribute(name);
        }

        public int getIntAttribute(String name) throws XNodeException {
            return Integer.parseInt(getAttribute(name));
        }

        float getFloatAttribute(String name) throws XNodeException {
            return Float.parseFloat(getAttribute(name));
        }
    }

    public SimpleXPath(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        this.mDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(xmlFile));
    }

    public Node getRoot() {
        return this.mDocument;
    }

    public XNode getXPathNode(Node root, String path) {
        boolean isFinishing;
        String[] node = path.split(XPATH_SEPARATOR, 2);
        if (node.length == 1) {
            isFinishing = true;
        } else {
            isFinishing = false;
        }
        Node n = root.getFirstChild();
        while (n != null) {
            if (!node[0].equals(n.getNodeName())) {
                try {
                    n = n.getNextSibling();
                } catch (Exception e) {
                    n = null;
                }
            } else if (isFinishing) {
                return new XNode(n);
            } else {
                return getXPathNode(n, node[1]);
            }
        }
        return null;
    }

    public List<XNode> getXPathNodes(Node root, String path) {
        List<XNode> result = new ArrayList();
        getNodes(root, path, result);
        return result;
    }

    private void getNodes(Node root, String path, List<XNode> result) {
        boolean isFinishing;
        String[] node = path.split(XPATH_SEPARATOR, 2);
        if (node.length == 1) {
            isFinishing = true;
        } else {
            isFinishing = false;
        }
        Node n = root.getFirstChild();
        while (n != null) {
            if (node[0].equals(n.getNodeName())) {
                if (isFinishing) {
                    result.add(new XNode(n));
                } else {
                    getNodes(n, node[1], result);
                }
            }
            try {
                n = n.getNextSibling();
            } catch (Exception e) {
                n = null;
            }
        }
    }
}
