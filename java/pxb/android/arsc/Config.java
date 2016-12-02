/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Map
 *  java.util.TreeMap
 */
package pxb.android.arsc;

import java.util.Map;
import java.util.TreeMap;
import pxb.android.arsc.ResEntry;

public class Config {
    public final int entryCount;
    public final byte[] id;
    public Map<Integer, ResEntry> resources = new TreeMap();
    int wChunkSize;
    int wEntryStart;
    int wPosition;

    public Config(byte[] arrby, int n) {
        this.id = arrby;
        this.entryCount = n;
    }
}

