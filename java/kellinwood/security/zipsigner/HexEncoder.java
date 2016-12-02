/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 */
package kellinwood.security.zipsigner;

import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder {
    protected final byte[] decodingTable = new byte[128];
    protected final byte[] encodingTable = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public HexEncoder() {
        this.initialiseDecodingTable();
    }

    private boolean ignore(char c) {
        if (c == '\n' || c == '\r' || c == '\t' || c == ' ') {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int decode(String string, OutputStream outputStream) throws IOException {
        int n = 0;
        int n2 = string.length();
        do {
            if (n2 <= 0 || !super.ignore(string.charAt(n2 - 1))) break;
            --n2;
        } while (true);
        int n3 = 0;
        while (n3 < n2) {
            int n4;
            int n5;
            for (n4 = n3; n4 < n2 && super.ignore(string.charAt(n4)); ++n4) {
            }
            byte[] arrby = this.decodingTable;
            int n6 = n4 + 1;
            byte by = arrby[string.charAt(n4)];
            for (n5 = n6; n5 < n2 && super.ignore(string.charAt(n5)); ++n5) {
            }
            byte[] arrby2 = this.decodingTable;
            n3 = n5 + 1;
            outputStream.write(arrby2[string.charAt(n5)] | by << 4);
            ++n;
        }
        return n;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int decode(byte[] arrby, int n, int n2, OutputStream outputStream) throws IOException {
        int n3 = 0;
        int n4 = n + n2;
        do {
            if (n4 <= n || !super.ignore(arrby[n4 - 1])) break;
            --n4;
        } while (true);
        int n5 = n;
        while (n5 < n4) {
            int n6;
            int n7;
            for (n6 = n5; n6 < n4 && super.ignore(arrby[n6]); ++n6) {
            }
            byte[] arrby2 = this.decodingTable;
            int n8 = n6 + 1;
            byte by = arrby2[arrby[n6]];
            for (n7 = n8; n7 < n4 && super.ignore(arrby[n7]); ++n7) {
            }
            byte[] arrby3 = this.decodingTable;
            n5 = n7 + 1;
            outputStream.write(arrby3[arrby[n7]] | by << 4);
            ++n3;
        }
        return n3;
    }

    public int encode(byte[] arrby, int n, int n2, OutputStream outputStream) throws IOException {
        for (int i = n; i < n + n2; ++i) {
            int n3 = 255 & arrby[i];
            outputStream.write((int)this.encodingTable[n3 >>> 4]);
            outputStream.write((int)this.encodingTable[n3 & 15]);
        }
        return n2 * 2;
    }

    protected void initialiseDecodingTable() {
        for (int i = 0; i < this.encodingTable.length; ++i) {
            this.decodingTable[this.encodingTable[i]] = (byte)i;
        }
        this.decodingTable[65] = this.decodingTable[97];
        this.decodingTable[66] = this.decodingTable[98];
        this.decodingTable[67] = this.decodingTable[99];
        this.decodingTable[68] = this.decodingTable[100];
        this.decodingTable[69] = this.decodingTable[101];
        this.decodingTable[70] = this.decodingTable[102];
    }
}

