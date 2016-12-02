/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package pxb.android.axml;

public abstract class NodeVisitor {
    public static final int TYPE_FIRST_INT = 16;
    public static final int TYPE_INT_BOOLEAN = 18;
    public static final int TYPE_INT_HEX = 17;
    public static final int TYPE_REFERENCE = 1;
    public static final int TYPE_STRING = 3;
    protected NodeVisitor nv;

    public NodeVisitor() {
    }

    public NodeVisitor(NodeVisitor nodeVisitor) {
        this.nv = nodeVisitor;
    }

    public void attr(String string, String string2, int n, int n2, Object object) {
        if (this.nv != null) {
            this.nv.attr(string, string2, n, n2, object);
        }
    }

    public NodeVisitor child(String string, String string2) {
        if (this.nv != null) {
            return this.nv.child(string, string2);
        }
        return null;
    }

    public void end() {
        if (this.nv != null) {
            this.nv.end();
        }
    }

    public void line(int n) {
        if (this.nv != null) {
            this.nv.line(n);
        }
    }

    public void text(int n, String string) {
        if (this.nv != null) {
            this.nv.text(n, string);
        }
    }
}

