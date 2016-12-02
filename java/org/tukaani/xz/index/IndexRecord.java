package org.tukaani.xz.index;

class IndexRecord {
    final long uncompressed;
    final long unpadded;

    IndexRecord(long unpadded, long uncompressed) {
        this.unpadded = unpadded;
        this.uncompressed = uncompressed;
    }
}
