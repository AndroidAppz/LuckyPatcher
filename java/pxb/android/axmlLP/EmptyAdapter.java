package pxb.android.axmlLP;

import pxb.android.axmlLP.AxmlVisitor.NodeVisitor;

public class EmptyAdapter extends AxmlVisitor {

    public static class EmptyNode extends NodeVisitor {
        public NodeVisitor child(String ns, String name) {
            return new EmptyNode();
        }
    }

    public NodeVisitor first(String ns, String name) {
        return new EmptyNode();
    }
}
