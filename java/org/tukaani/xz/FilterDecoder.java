package org.tukaani.xz;

import java.io.InputStream;

interface FilterDecoder extends FilterCoder {
    InputStream getInputStream(InputStream inputStream);

    int getMemoryUsage();
}
