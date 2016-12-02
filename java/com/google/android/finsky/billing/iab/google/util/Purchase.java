package com.google.android.finsky.billing.iab.google.util;

import com.google.android.finsky.billing.iab.BuyMarketActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase {
    String mDeveloperPayload;
    String mItemType;
    String mOrderId;
    String mOriginalJson;
    String mPackageName;
    int mPurchaseState;
    long mPurchaseTime;
    String mSignature;
    String mSku;
    String mToken;

    public Purchase(String itemType, String jsonPurchaseInfo, String signature) throws JSONException {
        this.mItemType = itemType;
        this.mOriginalJson = jsonPurchaseInfo;
        JSONObject o = new JSONObject(this.mOriginalJson);
        this.mOrderId = o.optString("orderId");
        this.mPackageName = o.optString(BuyMarketActivity.EXTRA_PACKAGENAME);
        this.mSku = o.optString("productId");
        this.mPurchaseTime = o.optLong("purchaseTime");
        this.mPurchaseState = o.optInt("purchaseState");
        this.mDeveloperPayload = o.optString("developerPayload");
        this.mToken = o.optString("token", o.optString("purchaseToken"));
        this.mSignature = signature;
    }

    public String getItemType() {
        return this.mItemType;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getSku() {
        return this.mSku;
    }

    public long getPurchaseTime() {
        return this.mPurchaseTime;
    }

    public int getPurchaseState() {
        return this.mPurchaseState;
    }

    public String getDeveloperPayload() {
        return this.mDeveloperPayload;
    }

    public String getToken() {
        return this.mToken;
    }

    public String getOriginalJson() {
        return this.mOriginalJson;
    }

    public String getSignature() {
        return this.mSignature;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.mItemType + "):" + this.mOriginalJson;
    }
}
