/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package pxb.android.axmlLP;

import pxb.android.axmlLP.AxmlVisitor;

public class EmptyAdapter
extends AxmlVisitor {
    @Override
    public AxmlVisitor.NodeVisitor first(String string, String string2) {
        return new EmptyNode();
    }

    public static class EmptyNode
    extends AxmlVisitor.NodeVisitor {
        @Override
        public AxmlVisitor.NodeVisitor child(String string, String string2) {
            return new EmptyNode();
        }
    }

}

