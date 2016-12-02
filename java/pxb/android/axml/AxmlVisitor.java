/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package pxb.android.axml;

import pxb.android.axml.NodeVisitor;

public class AxmlVisitor
extends NodeVisitor {
    public AxmlVisitor() {
    }

    public AxmlVisitor(NodeVisitor nodeVisitor) {
        super(nodeVisitor);
    }

    public void ns(String string, String string2, int n) {
        if (this.nv != null && this.nv instanceof AxmlVisitor) {
            ((AxmlVisitor)this.nv).ns(string, string2, n);
        }
    }
}

