package com.google.android.finsky.billing.iab.google.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    Map<String, Purchase> mPurchaseMap = new HashMap();
    Map<String, SkuDetails> mSkuMap = new HashMap();

    Inventory() {
    }

    public SkuDetails getSkuDetails(String sku) {
        return (SkuDetails) this.mSkuMap.get(sku);
    }

    public Purchase getPurchase(String sku) {
        return (Purchase) this.mPurchaseMap.get(sku);
    }

    public boolean hasPurchase(String sku) {
        return this.mPurchaseMap.containsKey(sku);
    }

    public boolean hasDetails(String sku) {
        return this.mSkuMap.containsKey(sku);
    }

    public void erasePurchase(String sku) {
        if (this.mPurchaseMap.containsKey(sku)) {
            this.mPurchaseMap.remove(sku);
        }
    }

    List<String> getAllOwnedSkus() {
        return new ArrayList(this.mPurchaseMap.keySet());
    }

    List<String> getAllOwnedSkus(String itemType) {
        List<String> result = new ArrayList();
        for (Purchase p : this.mPurchaseMap.values()) {
            if (p.getItemType().equals(itemType)) {
                result.add(p.getSku());
            }
        }
        return result;
    }

    List<Purchase> getAllPurchases() {
        return new ArrayList(this.mPurchaseMap.values());
    }

    void addSkuDetails(SkuDetails d) {
        this.mSkuMap.put(d.getSku(), d);
    }

    void addPurchase(Purchase p) {
        this.mPurchaseMap.put(p.getSku(), p);
    }
}
