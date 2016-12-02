package com.google.android.finsky.billing.iab;

public class ItemsListItem {
    public int autobuy = 0;
    public String itemID;
    public String pData;
    public String pSignature;
    public int savePurchase = 0;

    public ItemsListItem(String itemId, String Data, String Signature, int savePurchase, int autobuy) {
        this.itemID = itemId;
        this.pData = Data;
        this.pSignature = Signature;
        this.savePurchase = savePurchase;
        this.autobuy = autobuy;
    }
}
