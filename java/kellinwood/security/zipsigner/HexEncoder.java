package kellinwood.security.zipsigner;

import com.chelpus.Common;
import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder {
    protected final byte[] decodingTable = new byte[Common.INSTALL_ALLOW_DOWNGRADE];
    protected final byte[] encodingTable = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};

    protected void initialiseDecodingTable() {
        for (int i = 0; i < this.encodingTable.length; i++) {
            this.decodingTable[this.encodingTable[i]] = (byte) i;
        }
        this.decodingTable[65] = this.decodingTable[97];
        this.decodingTable[66] = this.decodingTable[98];
        this.decodingTable[67] = this.decodingTable[99];
        this.decodingTable[68] = this.decodingTable[100];
        this.decodingTable[69] = this.decodingTable[101];
        this.decodingTable[70] = this.decodingTable[102];
    }

    public HexEncoder() {
        initialiseDecodingTable();
    }

    public int encode(byte[] data, int off, int length, OutputStream out) throws IOException {
        for (int i = off; i < off + length; i++) {
            int v = data[i] & 255;
            out.write(this.encodingTable[v >>> 4]);
            out.write(this.encodingTable[v & 15]);
        }
        return length * 2;
    }

    private boolean ignore(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    public int decode(byte[] data, int off, int length, OutputStream out) throws IOException {
        int outLen = 0;
        int end = off + length;
        while (end > off && ignore((char) data[end - 1])) {
            end--;
        }
        int i = off;
        while (i < end) {
            int i2 = i;
            while (i2 < end && ignore((char) data[i2])) {
                i2++;
            }
            i = i2 + 1;
            byte b1 = this.decodingTable[data[i2]];
            i2 = i;
            while (i2 < end && ignore((char) data[i2])) {
                i2++;
            }
            i = i2 + 1;
            out.write((b1 << 4) | this.decodingTable[data[i2]]);
            outLen++;
        }
        return outLen;
    }

    public int decode(String data, OutputStream out) throws IOException {
        int length = 0;
        int end = data.length();
        while (end > 0 && ignore(data.charAt(end - 1))) {
            end--;
        }
        int i = 0;
        while (i < end) {
            int i2 = i;
            while (i2 < end && ignore(data.charAt(i2))) {
                i2++;
            }
            i = i2 + 1;
            byte b1 = this.decodingTable[data.charAt(i2)];
            i2 = i;
            while (i2 < end && ignore(data.charAt(i2))) {
                i2++;
            }
            i = i2 + 1;
            out.write((b1 << 4) | this.decodingTable[data.charAt(i2)]);
            length++;
        }
        return length;
    }
}
