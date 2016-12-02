/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.index;

class IndexRecord {
    final long uncompressed;
    final long unpadded;

    IndexRecord(long l, long l2) {
        this.unpadded = l;
        this.uncompressed = l2;
    }
}

