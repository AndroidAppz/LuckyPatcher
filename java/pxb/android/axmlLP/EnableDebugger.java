package pxb.android.axmlLP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import pxb.android.axml.R;
import pxb.android.axmlLP.AxmlVisitor.NodeVisitor;

public class EnableDebugger {
    public static void main(String... args) throws Exception {
        if (args.length < 2) {
            System.err.println("test5 in out");
        } else {
            new EnableDebugger().a(new File(args[0]), new File(args[1]));
        }
    }

    void a(File a, File b) throws Exception {
        InputStream is = new FileInputStream(a);
        byte[] xml = new byte[is.available()];
        is.read(xml);
        is.close();
        AxmlReader rd = new AxmlReader(xml);
        AxmlWriter wr = new AxmlWriter();
        rd.accept(new AxmlVisitor(wr) {
            public NodeVisitor first(String ns, String name) {
                return new NodeVisitor(super.first(ns, name)) {
                    public NodeVisitor child(String ns, String name) {
                        return new NodeVisitor(super.child(ns, name)) {
                            public void attr(String ns, String name, int resourceId, int type, Object obj) {
                                if (!"http://schemas.android.com/apk/res/android".equals(ns) || !"debuggable".equals(name)) {
                                    super.attr(ns, name, resourceId, type, obj);
                                }
                            }

                            public void end() {
                                super.attr("http://schemas.android.com/apk/res/android", "debuggable", R.attr.debuggable, 18, Integer.valueOf(-1));
                                super.end();
                            }
                        };
                    }
                };
            }
        });
        byte[] modified = wr.toByteArray();
        FileOutputStream fos = new FileOutputStream(b);
        fos.write(modified);
        fos.close();
    }
}
