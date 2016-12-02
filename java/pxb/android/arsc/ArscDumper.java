/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.TreeMap
 */
package pxb.android.arsc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import pxb.android.arsc.ArscParser;
import pxb.android.arsc.Config;
import pxb.android.arsc.Pkg;
import pxb.android.arsc.ResEntry;
import pxb.android.arsc.ResSpec;
import pxb.android.arsc.Type;
import pxb.android.axml.Util;

public class ArscDumper {
    public static void dump(List<Pkg> list) {
        for (int i = 0; i < list.size(); ++i) {
            Pkg pkg = (Pkg)list.get(i);
            PrintStream printStream = System.out;
            Object[] arrobject = new Object[]{i, pkg.id, pkg.name, pkg.types.size()};
            printStream.println(String.format((String)"  Package %d id=%d name=%s typeCount=%d", (Object[])arrobject));
            for (Type type : pkg.types.values()) {
                PrintStream printStream2 = System.out;
                Object[] arrobject2 = new Object[]{-1 + type.id, type.name};
                printStream2.println(String.format((String)"    type %d %s", (Object[])arrobject2));
                int n = pkg.id << 24 | type.id << 16;
                for (int j = 0; j < type.specs.length; ++j) {
                    ResSpec resSpec = type.getSpec(j);
                    PrintStream printStream3 = System.out;
                    Object[] arrobject3 = new Object[]{n | resSpec.id, resSpec.flags, resSpec.name};
                    printStream3.println(String.format((String)"      spec 0x%08x 0x%08x %s", (Object[])arrobject3));
                }
                for (int k = 0; k < type.configs.size(); ++k) {
                    Config config = (Config)type.configs.get(k);
                    System.out.println("      config");
                    ArrayList arrayList = new ArrayList(config.resources.values());
                    for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                        ResEntry resEntry = (ResEntry)arrayList.get(i2);
                        PrintStream printStream4 = System.out;
                        Object[] arrobject4 = new Object[]{n | resEntry.spec.id, resEntry.spec.name, resEntry.value};
                        printStream4.println(String.format((String)"        resource 0x%08x %-20s: %s", (Object[])arrobject4));
                    }
                }
            }
        }
    }

    public static /* varargs */ void main(String ... arrstring) throws IOException {
        if (arrstring.length == 0) {
            System.err.println("asrc-dump file.arsc");
            return;
        }
        ArscDumper.dump(new ArscParser(Util.readFile(new File(arrstring[0]))).parse());
    }
}

