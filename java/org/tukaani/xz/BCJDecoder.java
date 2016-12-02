package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.ARM;
import org.tukaani.xz.simple.ARMThumb;
import org.tukaani.xz.simple.IA64;
import org.tukaani.xz.simple.PowerPC;
import org.tukaani.xz.simple.SPARC;
import org.tukaani.xz.simple.SimpleFilter;
import org.tukaani.xz.simple.X86;

class BCJDecoder extends BCJCoder implements FilterDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = (!BCJDecoder.class.desiredAssertionStatus());
    private final long filterID;
    private final int startOffset;

    BCJDecoder(long filterID, byte[] props) throws UnsupportedOptionsException {
        if ($assertionsDisabled || BCJCoder.isBCJFilterID(filterID)) {
            this.filterID = filterID;
            if (props.length == 0) {
                this.startOffset = 0;
                return;
            } else if (props.length == 4) {
                int n = 0;
                for (int i = 0; i < 4; i++) {
                    n |= (props[i] & 255) << (i * 8);
                }
                this.startOffset = n;
                return;
            } else {
                throw new UnsupportedOptionsException("Unsupported BCJ filter properties");
            }
        }
        throw new AssertionError();
    }

    public int getMemoryUsage() {
        return SimpleInputStream.getMemoryUsage();
    }

    public InputStream getInputStream(InputStream in) {
        SimpleFilter simpleFilter = null;
        if (this.filterID == 4) {
            simpleFilter = new X86(false, this.startOffset);
        } else if (this.filterID == 5) {
            simpleFilter = new PowerPC(false, this.startOffset);
        } else if (this.filterID == 6) {
            simpleFilter = new IA64(false, this.startOffset);
        } else if (this.filterID == 7) {
            simpleFilter = new ARM(false, this.startOffset);
        } else if (this.filterID == 8) {
            simpleFilter = new ARMThumb(false, this.startOffset);
        } else if (this.filterID == 9) {
            simpleFilter = new SPARC(false, this.startOffset);
        } else if (!$assertionsDisabled) {
            throw new AssertionError();
        }
        return new SimpleInputStream(in, simpleFilter);
    }
}
