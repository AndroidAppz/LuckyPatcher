/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 */
package pxb.android.axmlLP;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import pxb.android.axmlLP.AxmlVisitor;

public class DumpAdapter
extends AxmlVisitor {
    private Map<String, String> nses;

    public DumpAdapter() {
        this.nses = new HashMap();
    }

    public DumpAdapter(AxmlVisitor axmlVisitor) {
        super(axmlVisitor);
        this.nses = new HashMap();
    }

    @Override
    public void end() {
        super.end();
    }

    @Override
    public AxmlVisitor.NodeVisitor first(String string, String string2) {
        System.out.print("<");
        if (string != null) {
            System.out.println((String)this.nses.get((Object)string) + ":");
        }
        System.out.println(string2);
        AxmlVisitor.NodeVisitor nodeVisitor = super.first(string, string2);
        if (nodeVisitor != null) {
            return new DumpNodeAdapter(nodeVisitor, 1, this.nses);
        }
        return null;
    }

    @Override
    public void ns(String string, String string2, int n) {
        System.out.println(string + "=" + string2);
        this.nses.put((Object)string2, (Object)string);
        super.ns(string, string2, n);
    }

    public static class DumpNodeAdapter
    extends AxmlVisitor.NodeVisitor {
        protected int deep;
        protected Map<String, String> nses;

        public DumpNodeAdapter(AxmlVisitor.NodeVisitor nodeVisitor) {
            super(nodeVisitor);
            this.deep = 0;
            this.nses = null;
        }

        public DumpNodeAdapter(AxmlVisitor.NodeVisitor nodeVisitor, int n, Map<String, String> map) {
            super(nodeVisitor);
            this.deep = n;
            this.nses = map;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void attr(String string, String string2, int n, int n2, Object object) {
            for (int i = 0; i < this.deep; ++i) {
                System.out.print("  ");
            }
            if (string != null) {
                PrintStream printStream = System.out;
                Object[] arrobject = new Object[]{this.getPrefix(string)};
                printStream.print(String.format((String)"%s:", (Object[])arrobject));
            }
            System.out.print(string2);
            if (n != -1) {
                PrintStream printStream = System.out;
                Object[] arrobject = new Object[]{n};
                printStream.print(String.format((String)"(%08x)", (Object[])arrobject));
            }
            if (object instanceof String) {
                PrintStream printStream = System.out;
                Object[] arrobject = new Object[]{n2, object};
                printStream.print(String.format((String)"=[%08x]\"%s\"", (Object[])arrobject));
            } else if (object instanceof Boolean) {
                PrintStream printStream = System.out;
                Object[] arrobject = new Object[]{n2, object};
                printStream.print(String.format((String)"=[%08x]\"%b\"", (Object[])arrobject));
            } else {
                PrintStream printStream = System.out;
                Object[] arrobject = new Object[]{n2, object};
                printStream.print(String.format((String)"=[%08x]%08x", (Object[])arrobject));
            }
            System.out.println();
            super.attr(string, string2, n, n2, object);
        }

        @Override
        public AxmlVisitor.NodeVisitor child(String string, String string2) {
            for (int i = 0; i < this.deep; ++i) {
                System.out.print("  ");
            }
            System.out.print("<");
            if (string != null) {
                System.out.println(this.getPrefix(string) + ":");
            }
            System.out.println(string2);
            AxmlVisitor.NodeVisitor nodeVisitor = super.child(string, string2);
            if (nodeVisitor != null) {
                return new DumpNodeAdapter(nodeVisitor, 1 + this.deep, this.nses);
            }
            return null;
        }

        protected String getPrefix(String string) {
            String string2;
            if (this.nses != null && (string2 = (String)this.nses.get((Object)string)) != null) {
                return string2;
            }
            return string;
        }

        @Override
        public void text(int n, String string) {
            for (int i = 0; i < 1 + this.deep; ++i) {
                System.out.print("  ");
            }
            System.out.println(string);
            super.text(n, string);
        }
    }

}

