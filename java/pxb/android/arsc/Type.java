/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package pxb.android.arsc;

import java.util.ArrayList;
import java.util.List;
import pxb.android.arsc.Config;
import pxb.android.arsc.ResSpec;

public class Type {
    public List<Config> configs = new ArrayList();
    public int id;
    public String name;
    public ResSpec[] specs;
    int wPosition;

    public void addConfig(Config config) {
        if (config.entryCount != this.specs.length) {
            throw new RuntimeException();
        }
        this.configs.add((Object)config);
    }

    public ResSpec getSpec(int n) {
        ResSpec resSpec = this.specs[n];
        if (resSpec == null) {
            this.specs[n] = resSpec = new ResSpec(n);
        }
        return resSpec;
    }
}

