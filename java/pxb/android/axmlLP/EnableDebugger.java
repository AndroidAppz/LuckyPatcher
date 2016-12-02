/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package pxb.android.axmlLP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import pxb.android.axmlLP.AxmlReader;
import pxb.android.axmlLP.AxmlVisitor;
import pxb.android.axmlLP.AxmlWriter;

public class EnableDebugger {
    public static /* varargs */ void main(String ... arrstring) throws Exception {
        if (arrstring.length < 2) {
            System.err.println("test5 in out");
            return;
        }
        new EnableDebugger().a(new File(arrstring[0]), new File(arrstring[1]));
    }

    void a(File file, File file2) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] arrby = new byte[fileInputStream.available()];
        fileInputStream.read(arrby);
        fileInputStream.close();
        AxmlReader axmlReader = new AxmlReader(arrby);
        AxmlWriter axmlWriter = new AxmlWriter();
        axmlReader.accept(new AxmlVisitor(axmlWriter){

            @Override
            public AxmlVisitor.NodeVisitor first(String string, String string2) {
                return new AxmlVisitor.NodeVisitor(super.first(string, string2)){

                    @Override
                    public AxmlVisitor.NodeVisitor child(String string, String string2) {
                        return new AxmlVisitor.NodeVisitor(super.child(string, string2)){

                            @Override
                            public void attr(String string, String string2, int n, int n2, Object object) {
                                if ("http://schemas.android.com/apk/res/android".equals((Object)string) && "debuggable".equals((Object)string2)) {
                                    return;
                                }
                                super.attr(string, string2, n, n2, object);
                            }

                            @Override
                            public void end() {
                                super.attr("http://schemas.android.com/apk/res/android", "debuggable", 16842767, 18, -1);
                                super.end();
                            }
                        };
                    }

                };
            }

        });
        byte[] arrby2 = axmlWriter.toByteArray();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(arrby2);
        fileOutputStream.close();
    }

}

