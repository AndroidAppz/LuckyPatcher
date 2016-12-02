/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.BCJCoder;
import org.tukaani.xz.FilterDecoder;
import org.tukaani.xz.SimpleInputStream;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.simple.ARM;
import org.tukaani.xz.simple.ARMThumb;
import org.tukaani.xz.simple.IA64;
import org.tukaani.xz.simple.PowerPC;
import org.tukaani.xz.simple.SPARC;
import org.tukaani.xz.simple.SimpleFilter;
import org.tukaani.xz.simple.X86;

class BCJDecoder
extends BCJCoder
implements FilterDecoder {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final long filterID;
    private final int startOffset;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !BCJDecoder.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    BCJDecoder(long l, byte[] arrby) throws UnsupportedOptionsException {
        if (!$assertionsDisabled && !BCJDecoder.isBCJFilterID(l)) {
            throw new AssertionError();
        }
        this.filterID = l;
        if (arrby.length == 0) {
            this.startOffset = 0;
            return;
        }
        if (arrby.length == 4) {
            int n = 0;
            for (int i = 0; i < 4; ++i) {
                n |= (255 & arrby[i]) << i * 8;
            }
            this.startOffset = n;
            return;
        }
        throw new UnsupportedOptionsException("Unsupported BCJ filter properties");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public InputStream getInputStream(InputStream inputStream) {
        void var2_3;
        if (this.filterID == 4) {
            X86 x86 = new X86(false, this.startOffset);
            do {
                return new SimpleInputStream(inputStream, (SimpleFilter)var2_3);
                break;
            } while (true);
        }
        if (this.filterID == 5) {
            PowerPC powerPC = new PowerPC(false, this.startOffset);
            return new SimpleInputStream(inputStream, (SimpleFilter)var2_3);
        }
        if (this.filterID == 6) {
            IA64 iA64 = new IA64(false, this.startOffset);
            return new SimpleInputStream(inputStream, (SimpleFilter)var2_3);
        }
        if (this.filterID == 7) {
            ARM aRM = new ARM(false, this.startOffset);
            return new SimpleInputStream(inputStream, (SimpleFilter)var2_3);
        }
        if (this.filterID == 8) {
            ARMThumb aRMThumb = new ARMThumb(false, this.startOffset);
            return new SimpleInputStream(inputStream, (SimpleFilter)var2_3);
        }
        if (this.filterID == 9) {
            SPARC sPARC = new SPARC(false, this.startOffset);
            return new SimpleInputStream(inputStream, (SimpleFilter)var2_3);
        }
        boolean bl = $assertionsDisabled;
        java.lang.Object var2_9 = null;
        if (bl) return new SimpleInputStream(inputStream, (SimpleFilter)var2_3);
        throw new AssertionError();
    }

    @Override
    public int getMemoryUsage() {
        return SimpleInputStream.getMemoryUsage();
    }
}

