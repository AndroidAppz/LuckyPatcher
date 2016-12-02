/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.text.DateFormat
 *  java.text.SimpleDateFormat
 *  java.util.Date
 */
package kellinwood.zipio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import kellinwood.logging.LoggerInterface;
import kellinwood.zipio.ZioEntry;

public class ZipListingHelper {
    static DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy HH:mm");

    /*
     * Enabled aggressive block sorting
     */
    public static void listEntry(LoggerInterface loggerInterface, ZioEntry zioEntry) {
        int n = zioEntry.getSize();
        int n2 = 0;
        if (n > 0) {
            n2 = 100 * (zioEntry.getSize() - zioEntry.getCompressedSize()) / zioEntry.getSize();
        }
        Object[] arrobject = new Object[7];
        arrobject[0] = zioEntry.getSize();
        String string = zioEntry.getCompression() == 0 ? "Stored" : "Defl:N";
        arrobject[1] = string;
        arrobject[2] = zioEntry.getCompressedSize();
        arrobject[3] = n2;
        arrobject[4] = dateFormat.format(new Date(zioEntry.getTime()));
        arrobject[5] = zioEntry.getCrc32();
        arrobject[6] = zioEntry.getName();
        loggerInterface.debug(String.format((String)"%8d  %6s %8d %4d%% %s  %08x  %s", (Object[])arrobject));
    }

    public static void listHeader(LoggerInterface loggerInterface) {
        loggerInterface.debug(" Length   Method    Size  Ratio   Date   Time   CRC-32    Name");
        loggerInterface.debug("--------  ------  ------- -----   ----   ----   ------    ----");
    }
}

