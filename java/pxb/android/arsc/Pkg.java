/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.TreeMap
 */
package pxb.android.arsc;

import java.util.TreeMap;
import pxb.android.arsc.ResSpec;
import pxb.android.arsc.Type;

public class Pkg {
    public final int id;
    public String name;
    public TreeMap<Integer, Type> types = new TreeMap();

    public Pkg(int n, String string) {
        this.id = n;
        this.name = string;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Type getType(int n, String string, int n2) {
        Type type = (Type)this.types.get((Object)n);
        if (type != null) {
            if (string == null) return type;
            {
                if (type.name == null) {
                    type.name = string;
                } else if (!string.endsWith(type.name)) {
                    throw new RuntimeException();
                }
                if (type.specs.length == n2) return type;
                {
                    throw new RuntimeException();
                }
            }
        } else {
            type = new Type();
            type.id = n;
            type.name = string;
            type.specs = new ResSpec[n2];
            this.types.put((Object)n, (Object)type);
        }
        return type;
    }
}

