package pxb.android.arsc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pxb.android.axml.Util;

public class ArscDumper {
    public static void dump(List<Pkg> pkgs) {
        for (int x = 0; x < pkgs.size(); x++) {
            Pkg pkg = (Pkg) pkgs.get(x);
            System.out.println(String.format("  Package %d id=%d name=%s typeCount=%d", new Object[]{Integer.valueOf(x), Integer.valueOf(pkg.id), pkg.name, Integer.valueOf(pkg.types.size())}));
            for (Type type : pkg.types.values()) {
                int i;
                System.out.println(String.format("    type %d %s", new Object[]{Integer.valueOf(type.id - 1), type.name}));
                int resPrefix = (pkg.id << 24) | (type.id << 16);
                for (i = 0; i < type.specs.length; i++) {
                    ResSpec spec = type.getSpec(i);
                    System.out.println(String.format("      spec 0x%08x 0x%08x %s", new Object[]{Integer.valueOf(spec.id | resPrefix), Integer.valueOf(spec.flags), spec.name}));
                }
                for (i = 0; i < type.configs.size(); i++) {
                    Config config = (Config) type.configs.get(i);
                    System.out.println("      config");
                    List<ResEntry> entries = new ArrayList(config.resources.values());
                    for (int j = 0; j < entries.size(); j++) {
                        ResEntry entry = (ResEntry) entries.get(j);
                        System.out.println(String.format("        resource 0x%08x %-20s: %s", new Object[]{Integer.valueOf(entry.spec.id | resPrefix), entry.spec.name, entry.value}));
                    }
                }
            }
        }
    }

    public static void main(String... args) throws IOException {
        if (args.length == 0) {
            System.err.println("asrc-dump file.arsc");
        } else {
            dump(new ArscParser(Util.readFile(new File(args[0]))).parse());
        }
    }
}
