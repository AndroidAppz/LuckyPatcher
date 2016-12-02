package org.tukaani.xz;

class RawCoder {
    RawCoder() {
    }

    static void validate(FilterCoder[] filters) throws UnsupportedOptionsException {
        int i = 0;
        while (i < filters.length - 1) {
            if (filters[i].nonLastOK()) {
                i++;
            } else {
                throw new UnsupportedOptionsException("Unsupported XZ filter chain");
            }
        }
        if (filters[filters.length - 1].lastOK()) {
            int changesSizeCount = 0;
            for (FilterCoder changesSize : filters) {
                if (changesSize.changesSize()) {
                    changesSizeCount++;
                }
            }
            if (changesSizeCount > 3) {
                throw new UnsupportedOptionsException("Unsupported XZ filter chain");
            }
            return;
        }
        throw new UnsupportedOptionsException("Unsupported XZ filter chain");
    }
}
