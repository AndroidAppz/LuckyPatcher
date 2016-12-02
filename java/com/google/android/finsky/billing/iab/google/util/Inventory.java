/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.google.android.finsky.billing.iab.google.util;

import com.google.android.finsky.billing.iab.google.util.Purchase;
import com.google.android.finsky.billing.iab.google.util.SkuDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Inventory {
    Map<String, Purchase> mPurchaseMap = new HashMap();
    Map<String, SkuDetails> mSkuMap = new HashMap();

    Inventory() {
    }

    void addPurchase(Purchase purchase) {
        this.mPurchaseMap.put((Object)purchase.getSku(), (Object)purchase);
    }

    void addSkuDetails(SkuDetails skuDetails) {
        this.mSkuMap.put((Object)skuDetails.getSku(), (Object)skuDetails);
    }

    public void erasePurchase(String string) {
        if (this.mPurchaseMap.containsKey((Object)string)) {
            this.mPurchaseMap.remove((Object)string);
        }
    }

    List<String> getAllOwnedSkus() {
        return new ArrayList((Collection)this.mPurchaseMap.keySet());
    }

    List<String> getAllOwnedSkus(String string) {
        ArrayList arrayList = new ArrayList();
        for (Purchase purchase : this.mPurchaseMap.values()) {
            if (!purchase.getItemType().equals((Object)string)) continue;
            arrayList.add((Object)purchase.getSku());
        }
        return arrayList;
    }

    List<Purchase> getAllPurchases() {
        return new ArrayList(this.mPurchaseMap.values());
    }

    public Purchase getPurchase(String string) {
        return (Purchase)this.mPurchaseMap.get((Object)string);
    }

    public SkuDetails getSkuDetails(String string) {
        return (SkuDetails)this.mSkuMap.get((Object)string);
    }

    public boolean hasDetails(String string) {
        return this.mSkuMap.containsKey((Object)string);
    }

    public boolean hasPurchase(String string) {
        return this.mPurchaseMap.containsKey((Object)string);
    }
}

