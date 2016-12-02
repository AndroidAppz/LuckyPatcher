package org.tukaani.xz;

import java.io.InputStream;

class DeltaDecoder extends DeltaCoder implements FilterDecoder {
    private final int distance;

    DeltaDecoder(byte[] props) throws UnsupportedOptionsException {
        if (props.length != 1) {
            throw new UnsupportedOptionsException("Unsupported Delta filter properties");
        }
        this.distance = (props[0] & 255) + 1;
    }

    public int getMemoryUsage() {
        return 1;
    }

    public InputStream getInputStream(InputStream in) {
        return new DeltaInputStream(in, this.distance);
    }
}
