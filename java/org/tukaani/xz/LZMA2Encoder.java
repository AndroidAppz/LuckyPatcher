package org.tukaani.xz;

import org.tukaani.xz.lzma.LZMAEncoder;

class LZMA2Encoder extends LZMA2Coder implements FilterEncoder {
    private final LZMA2Options options;
    private final byte[] props = new byte[1];

    LZMA2Encoder(LZMA2Options options) {
        if (options.getPresetDict() != null) {
            throw new IllegalArgumentException("XZ doesn't support a preset dictionary for now");
        }
        if (options.getMode() == 0) {
            this.props[0] = (byte) 0;
        } else {
            this.props[0] = (byte) (LZMAEncoder.getDistSlot(Math.max(options.getDictSize(), LZMA2Options.DICT_SIZE_MIN) - 1) - 23);
        }
        this.options = (LZMA2Options) options.clone();
    }

    public long getFilterID() {
        return 33;
    }

    public byte[] getFilterProps() {
        return this.props;
    }

    public boolean supportsFlushing() {
        return true;
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream out) {
        return this.options.getOutputStream(out);
    }
}
