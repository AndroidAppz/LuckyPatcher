/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package kellinwood.security.zipsigner;

import kellinwood.security.zipsigner.ResourceAdapter;

public class DefaultResourceAdapter
implements ResourceAdapter {
    @Override
    public /* varargs */ String getString(ResourceAdapter.Item item, Object ... arrobject) {
        switch (.$SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[item.ordinal()]) {
            default: {
                throw new IllegalArgumentException("Unknown item " + (Object)((Object)item));
            }
            case 1: {
                return "Input and output files are the same.  Specify a different name for the output.";
            }
            case 2: {
                return "Unable to auto-select key for signing " + arrobject[0];
            }
            case 3: {
                return "Loading certificate and private key";
            }
            case 4: {
                return "Parsing the input's central directory";
            }
            case 5: {
                return "Generating manifest";
            }
            case 6: {
                return "Generating signature file";
            }
            case 7: {
                return "Generating signature block file";
            }
            case 8: 
        }
        Object[] arrobject2 = new Object[]{arrobject[0], arrobject[1]};
        return String.format((String)"Copying zip entry %d of %d", (Object[])arrobject2);
    }

}

