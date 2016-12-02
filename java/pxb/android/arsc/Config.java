package pxb.android.arsc;

import java.util.Map;
import java.util.TreeMap;

public class Config {
    public final int entryCount;
    public final byte[] id;
    public Map<Integer, ResEntry> resources = new TreeMap();
    int wChunkSize;
    int wEntryStart;
    int wPosition;

    public Config(byte[] id, int entryCount) {
        this.id = id;
        this.entryCount = entryCount;
    }
}
