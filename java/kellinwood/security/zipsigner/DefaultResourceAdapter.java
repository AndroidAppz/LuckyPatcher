package kellinwood.security.zipsigner;

import kellinwood.security.zipsigner.ResourceAdapter.Item;
import org.tukaani.xz.LZMA2Options;
import pxb.android.axml.AxmlParser;
import pxb.android.axml.ValueWrapper;
import pxb.android.axmlLP.AxmlVisitor;

public class DefaultResourceAdapter implements ResourceAdapter {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item = new int[Item.values().length];

        static {
            try {
                $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[Item.INPUT_SAME_AS_OUTPUT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[Item.AUTO_KEY_SELECTION_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[Item.LOADING_CERTIFICATE_AND_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[Item.PARSING_CENTRAL_DIRECTORY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[Item.GENERATING_MANIFEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[Item.GENERATING_SIGNATURE_FILE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[Item.GENERATING_SIGNATURE_BLOCK.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[Item.COPYING_ZIP_ENTRY.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public String getString(Item item, Object... args) {
        switch (AnonymousClass1.$SwitchMap$kellinwood$security$zipsigner$ResourceAdapter$Item[item.ordinal()]) {
            case AxmlVisitor.TYPE_REFERENCE /*1*/:
                return "Input and output files are the same.  Specify a different name for the output.";
            case ValueWrapper.STYLE /*2*/:
                return "Unable to auto-select key for signing " + args[0];
            case AxmlVisitor.TYPE_STRING /*3*/:
                return "Loading certificate and private key";
            case AxmlParser.START_NS /*4*/:
                return "Parsing the input's central directory";
            case AxmlParser.END_NS /*5*/:
                return "Generating manifest";
            case AxmlParser.TEXT /*6*/:
                return "Generating signature file";
            case AxmlParser.END_FILE /*7*/:
                return "Generating signature block file";
            case LZMA2Options.NICE_LEN_MIN /*8*/:
                return String.format("Copying zip entry %d of %d", new Object[]{args[0], args[1]});
            default:
                throw new IllegalArgumentException("Unknown item " + item);
        }
    }
}
