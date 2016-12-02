package pxb.android.arsc;

import java.util.TreeMap;

public class Pkg {
    public final int id;
    public String name;
    public TreeMap<Integer, Type> types = new TreeMap();

    public Pkg(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Type getType(int tid, String name, int entrySize) {
        Type type = (Type) this.types.get(Integer.valueOf(tid));
        if (type == null) {
            type = new Type();
            type.id = tid;
            type.name = name;
            type.specs = new ResSpec[entrySize];
            this.types.put(Integer.valueOf(tid), type);
            return type;
        } else if (name == null) {
            return type;
        } else {
            if (type.name == null) {
                type.name = name;
            } else if (!name.endsWith(type.name)) {
                throw new RuntimeException();
            }
            if (type.specs.length == entrySize) {
                return type;
            }
            throw new RuntimeException();
        }
    }
}
