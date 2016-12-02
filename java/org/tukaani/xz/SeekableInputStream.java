/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 */
package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

public abstract class SeekableInputStream
extends InputStream {
    public abstract long length() throws IOException;

    public abstract long position() throws IOException;

    public abstract void seek(long var1) throws IOException;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public long skip(long l) throws IOException {
        if (l <= 0) {
            return 0;
        }
        long l2 = this.length();
        long l3 = this.position();
        if (l3 >= l2) return 0;
        if (l2 - l3 < l) {
            l = l2 - l3;
        }
        this.seek(l3 + l);
        return l;
    }
}

