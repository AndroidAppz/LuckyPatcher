/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.android.finsky.billing.iab;

public class ItemsListItem {
    public int autobuy = 0;
    public String itemID;
    public String pData;
    public String pSignature;
    public int savePurchase = 0;

    public ItemsListItem(String string, String string2, String string3, int n, int n2) {
        this.itemID = string;
        this.pData = string2;
        this.pSignature = string3;
        this.savePurchase = n;
        this.autobuy = n2;
    }
}

