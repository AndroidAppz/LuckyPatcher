package kellinwood.zipio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import kellinwood.logging.LoggerInterface;

public class ZipListingHelper {
    static DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy HH:mm");

    public static void listHeader(LoggerInterface log) {
        log.debug(" Length   Method    Size  Ratio   Date   Time   CRC-32    Name");
        log.debug("--------  ------  ------- -----   ----   ----   ------    ----");
    }

    public static void listEntry(LoggerInterface log, ZioEntry entry) {
        int ratio = 0;
        if (entry.getSize() > 0) {
            ratio = ((entry.getSize() - entry.getCompressedSize()) * 100) / entry.getSize();
        }
        String str = "%8d  %6s %8d %4d%% %s  %08x  %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(entry.getSize());
        objArr[1] = entry.getCompression() == (short) 0 ? "Stored" : "Defl:N";
        objArr[2] = Integer.valueOf(entry.getCompressedSize());
        objArr[3] = Integer.valueOf(ratio);
        objArr[4] = dateFormat.format(new Date(entry.getTime()));
        objArr[5] = Integer.valueOf(entry.getCrc32());
        objArr[6] = entry.getName();
        log.debug(String.format(str, objArr));
    }
}
