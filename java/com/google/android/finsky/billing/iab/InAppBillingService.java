package com.google.android.finsky.billing.iab;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Common;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.google.util.IabHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppBillingService extends Service {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String ITEM_TYPE_SUBS = "subs";
    public static final String TAG = "BillingHack";
    static ServiceConnection mServiceConn;
    boolean googleBillingDisabled = false;
    IBinder mB = null;
    private final Stub mBinder = new Stub() {
        final ArrayList<String> productIDinapp = new ArrayList();
        final ArrayList<String> productIDsubs = new ArrayList();

        public int isBillingSupported(int apiVersion, String packageName, String type) throws RemoteException {
            Log.d(InAppBillingService.TAG, "isBillingSupported");
            InAppBillingService.this.startGoogleBilling();
            return InAppBillingService.BILLING_RESPONSE_RESULT_OK;
        }

        public Bundle getSkuDetails(int apiVersion, String packageName, String type, Bundle skusBundle) throws RemoteException {
            ArrayList<String> skus;
            Iterator it;
            boolean found;
            Iterator it2;
            Log.d(InAppBillingService.TAG, "getSkuDetails");
            try {
                if (!(InAppBillingService.this.mSetupDone || InAppBillingService.this.skipSetupDone)) {
                    InAppBillingService.this.connectToBilling(packageName);
                }
                new Bundle().putInt(IabHelper.RESPONSE_CODE, InAppBillingService.BILLING_RESPONSE_RESULT_OK);
                if (!(!InAppBillingService.this.mSetupDone || InAppBillingService.this.mService == null || InAppBillingService.this.skipSetupDone)) {
                    try {
                        System.out.println("Connect to google billing");
                        Bundle skuDetails = InAppBillingService.this.mService.getSkuDetails(apiVersion, packageName, type, skusBundle);
                        ArrayList<String> res_skus = skuDetails.getStringArrayList(IabHelper.RESPONSE_GET_SKU_DETAILS_LIST);
                        skus = skusBundle.getStringArrayList(IabHelper.GET_SKU_DETAILS_ITEM_LIST);
                        int response = skuDetails.getInt(IabHelper.RESPONSE_CODE);
                        System.out.println(response);
                        if (response != 0) {
                            InAppBillingService.this.skipSetupDone = true;
                        } else if (res_skus == null) {
                            return skuDetails;
                        } else {
                            if (res_skus.size() == 0) {
                                return skuDetails;
                            }
                            it = res_skus.iterator();
                            while (it.hasNext()) {
                                JSONObject item = new JSONObject((String) it.next());
                                if (item.getString("type").equals(InAppBillingService.ITEM_TYPE_INAPP)) {
                                    found = false;
                                    it2 = this.productIDinapp.iterator();
                                    while (it2.hasNext()) {
                                        if (item.get("productId").equals((String) it2.next())) {
                                            found = true;
                                        }
                                    }
                                    if (!found) {
                                        this.productIDinapp.add(item.getString("productId"));
                                    }
                                }
                            }
                            return skuDetails;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            skus = skusBundle.getStringArrayList(IabHelper.GET_SKU_DETAILS_ITEM_LIST);
            ArrayList<String> itemsList = new ArrayList();
            if (!InAppBillingService.this.mSetupDone || InAppBillingService.this.mService == null || InAppBillingService.this.skipSetupDone) {
                String sku;
                System.out.println("Dont Connect to google billing");
                it = skus.iterator();
                while (it.hasNext()) {
                    sku = (String) it.next();
                    if (type.equals(InAppBillingService.ITEM_TYPE_SUBS)) {
                        found = false;
                        it2 = this.productIDsubs.iterator();
                        while (it2.hasNext()) {
                            if (sku.equals((String) it2.next())) {
                                found = true;
                            }
                        }
                        if (!found) {
                            this.productIDsubs.add(sku);
                        }
                    }
                    if (type.equals(InAppBillingService.ITEM_TYPE_INAPP)) {
                        found = false;
                        it2 = this.productIDinapp.iterator();
                        while (it2.hasNext()) {
                            if (sku.equals((String) it2.next())) {
                                found = true;
                            }
                        }
                        if (!found) {
                            this.productIDinapp.add(sku);
                        }
                    }
                }
                it = skus.iterator();
                while (it.hasNext()) {
                    sku = (String) it.next();
                    String[] w = sku.split("\\.");
                    String item_name = "";
                    if (w == null || w.length == 0) {
                        item_name = sku.replaceAll("_", " ");
                    } else {
                        if (w.length >= 2) {
                            item_name = w[w.length - 2] + " " + w[w.length - 1];
                        }
                        if (w.length == 1) {
                            item_name = w[InAppBillingService.BILLING_RESPONSE_RESULT_OK].replaceAll("_", " ");
                        }
                    }
                    long micro_price = Utils.getRandom(0, 99);
                    String price = "0." + micro_price;
                    it2 = new DbHelper(InAppBillingService.this.mContext, packageName).getItems().iterator();
                    while (it2.hasNext()) {
                        ItemsListItem it3 = (ItemsListItem) it2.next();
                        if (it3.itemID.equals(sku) && it3.savePurchase == 1) {
                            price = "Purchased";
                        }
                    }
                    JSONObject purch;
                    if (type.equals(InAppBillingService.ITEM_TYPE_SUBS)) {
                        found = false;
                        it2 = this.productIDinapp.iterator();
                        while (it2.hasNext()) {
                            if (((String) it2.next()).equals(sku)) {
                                found = true;
                            }
                        }
                        if (found) {
                            System.out.println("skip " + sku + " " + type);
                        } else {
                            purch = new JSONObject();
                            try {
                                purch.put("productId", sku);
                                purch.put("type", type);
                                purch.put("price", price);
                                purch.put("title", item_name);
                                purch.put("description", item_name);
                                purch.put("price_amount_micros", 1000000 * micro_price);
                                purch.put("price_currency_code", "USD");
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            itemsList.add(purch.toString());
                        }
                    } else {
                        purch = new JSONObject();
                        try {
                            purch.put("productId", sku);
                            purch.put("type", type);
                            purch.put("price", price);
                            purch.put("title", item_name);
                            purch.put("description", item_name);
                            purch.put("price_amount_micros", 1000000 * micro_price);
                            purch.put("price_currency_code", "USD");
                        } catch (JSONException e32) {
                            e32.printStackTrace();
                        }
                        itemsList.add(purch.toString());
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt(IabHelper.RESPONSE_CODE, InAppBillingService.BILLING_RESPONSE_RESULT_OK);
            bundle.putStringArrayList(IabHelper.RESPONSE_GET_SKU_DETAILS_LIST, itemsList);
            return bundle;
        }

        public Bundle getBuyIntent(int apiVersion, String packageName, String sku, String type, String developerPayload) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putInt(IabHelper.RESPONSE_CODE, InAppBillingService.BILLING_RESPONSE_RESULT_OK);
            Intent intent = new Intent();
            intent.setClass(InAppBillingService.this.getApplicationContext(), BuyActivity.class);
            intent.setAction(BuyActivity.BUY_INTENT);
            intent.addFlags(InAppBillingService.BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE);
            intent.putExtra(BuyMarketActivity.EXTRA_PACKAGENAME, packageName);
            intent.putExtra(BuyMarketActivity.EXTRA_PRODUCT_ID, sku);
            intent.putExtra(BuyMarketActivity.EXTRA_DEV_PAYLOAD, developerPayload);
            intent.putExtra("Type", type);
            ArrayList<ItemsListItem> list = new DbHelper(InAppBillingService.this.mContext, packageName).getItems();
            if (list.size() != 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ItemsListItem aList = (ItemsListItem) it.next();
                    if (aList.autobuy == 1 && aList.itemID.equals(sku)) {
                        intent.putExtra("autorepeat", aList.pSignature);
                    }
                }
            }
            bundle.putParcelable(IabHelper.RESPONSE_BUY_INTENT, PendingIntent.getActivity(InAppBillingService.this.getApplicationContext(), InAppBillingService.BILLING_RESPONSE_RESULT_OK, intent, 134217728));
            return bundle;
        }

        public Bundle getPurchases(int apiVersion, String packageName, String type, String continuationToken) throws RemoteException {
            Log.d(InAppBillingService.TAG, "getPurchases");
            ArrayList<ItemsListItem> list = new DbHelper(InAppBillingService.this.mContext, packageName).getItems();
            ArrayList<String> items_id = new ArrayList();
            ArrayList<String> datas = new ArrayList();
            ArrayList<String> signatures = new ArrayList();
            if (list.size() != 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ItemsListItem aList = (ItemsListItem) it.next();
                    if (aList.savePurchase == 1) {
                        items_id.add(aList.itemID);
                        datas.add(aList.pData);
                        if (aList.pSignature.equals("1")) {
                            signatures.add(Utils.gen_sha1withrsa(aList.pData));
                        } else {
                            signatures.add("");
                        }
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt(IabHelper.RESPONSE_CODE, InAppBillingService.BILLING_RESPONSE_RESULT_OK);
            bundle.putStringArrayList(IabHelper.RESPONSE_INAPP_ITEM_LIST, items_id);
            bundle.putStringArrayList(IabHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST, datas);
            bundle.putStringArrayList(IabHelper.RESPONSE_INAPP_SIGNATURE_LIST, signatures);
            return bundle;
        }

        public int consumePurchase(int apiVersion, String packageName, String purchaseToken) throws RemoteException {
            Log.d(InAppBillingService.TAG, "consumePurchase");
            return InAppBillingService.BILLING_RESPONSE_RESULT_OK;
        }

        public Bundle getBuyIntentToReplaceSkus(int apiVersion, String packageName, List skus, String newSku, String type, String developerPayload) throws RemoteException {
            System.out.println("LuckyPatcher: use api 5 getBuyIntentToReplaceSkus");
            Bundle bundle = new Bundle();
            bundle.putInt(IabHelper.RESPONSE_CODE, InAppBillingService.BILLING_RESPONSE_RESULT_OK);
            Intent intent = new Intent();
            intent.setClass(InAppBillingService.this.getApplicationContext(), BuyActivity.class);
            intent.setAction(BuyActivity.BUY_INTENT);
            intent.addFlags(InAppBillingService.BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE);
            intent.putExtra(BuyMarketActivity.EXTRA_PACKAGENAME, packageName);
            intent.putExtra(BuyMarketActivity.EXTRA_PRODUCT_ID, newSku);
            intent.putExtra(BuyMarketActivity.EXTRA_DEV_PAYLOAD, developerPayload);
            intent.putExtra("Type", type);
            bundle.putParcelable(IabHelper.RESPONSE_BUY_INTENT, PendingIntent.getActivity(InAppBillingService.this.getApplicationContext(), InAppBillingService.BILLING_RESPONSE_RESULT_OK, intent, 134217728));
            return bundle;
        }

        public int isPromoEligible(int apiVersion, String packageName, String type) throws RemoteException {
            return InAppBillingService.BILLING_RESPONSE_RESULT_OK;
        }
    };
    Context mContext;
    IInAppBillingService mService;
    boolean mSetupDone = false;
    boolean skipSetupDone = false;

    void startGoogleBilling() {
        listAppsFragment.init(this);
        if (listAppsFragment.su) {
            PackageInfo info = null;
            try {
                info = listAppsFragment.getPkgMng().getPackageInfo(Common.GOOGLEPLAY_PKG, 516);
            } catch (NameNotFoundException e1) {
                e1.printStackTrace();
            }
            if (info != null && info.services != null && info.services.length != 0) {
                int d = BILLING_RESPONSE_RESULT_OK;
                while (d < info.services.length) {
                    try {
                        if ((info.services[d].name.endsWith("InAppBillingService") || info.services[d].name.endsWith("MarketBillingService")) && listAppsFragment.getPkgMng().getComponentEnabledSetting(new ComponentName(Common.GOOGLEPLAY_PKG, info.services[d].name)) != 1) {
                            this.googleBillingDisabled = true;
                            Utils.market_billing_services(true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    d++;
                }
            }
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            if (intent.getStringExtra("xexe") == null || !intent.getStringExtra("xexe").equals("lp")) {
                System.out.println("Connect from app.");
            } else {
                this.skipSetupDone = true;
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void onCreate() {
        super.onCreate();
        System.out.println("create bill+skip:" + this.skipSetupDone);
        this.mContext = this;
        if (listAppsFragment.su) {
            startGoogleBilling();
        }
    }

    public void onTaskRemoved(Intent rootInent) {
        super.onTaskRemoved(rootInent);
        System.out.println("on Task Removed billing");
    }

    public void onDestroy() {
        System.out.println("destroy billing");
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        System.out.println("destroy billing");
        return super.onUnbind(intent);
    }

    public void connectToBilling(final String pkgName) {
        startGoogleBilling();
        if (this.mSetupDone) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        mServiceConn = new ServiceConnection() {
            public void onServiceDisconnected(ComponentName name) {
                System.out.println("Billing service disconnected.");
                InAppBillingService.this.mService = null;
                InAppBillingService.this.mSetupDone = false;
            }

            public void onServiceConnected(ComponentName name, IBinder service) {
                System.out.println("Billing service try to connect.");
                InAppBillingService.this.mService = Stub.asInterface(service);
                try {
                    int response = InAppBillingService.this.mService.isBillingSupported(InAppBillingService.BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE, pkgName, InAppBillingService.ITEM_TYPE_INAPP);
                    if (response != 0) {
                        System.out.println("bill error:" + response);
                        InAppBillingService.this.skipSetupDone = true;
                        return;
                    }
                    response = InAppBillingService.this.mService.isBillingSupported(InAppBillingService.BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE, pkgName, InAppBillingService.ITEM_TYPE_SUBS);
                    System.out.println("Billing service connected.");
                    InAppBillingService.this.mSetupDone = true;
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage(Common.GOOGLEPLAY_PKG);
        serviceIntent.putExtra("xexe", "lp");
        if (listAppsFragment.getPkgMng().queryIntentServices(serviceIntent, BILLING_RESPONSE_RESULT_OK).isEmpty()) {
            new Utils("w").waitLP(2000);
        }
        if (listAppsFragment.getPkgMng().queryIntentServices(serviceIntent, BILLING_RESPONSE_RESULT_OK).isEmpty()) {
            System.out.println("Billing service unavailable on device.");
            return;
        }
        for (ResolveInfo se : listAppsFragment.getPkgMng().queryIntentServices(serviceIntent, BILLING_RESPONSE_RESULT_OK)) {
            if (se.serviceInfo.packageName != null && se.serviceInfo.packageName.equals(Common.GOOGLEPLAY_PKG)) {
                ComponentName component = new ComponentName(se.serviceInfo.packageName, se.serviceInfo.name);
                serviceIntent = new Intent();
                serviceIntent.setComponent(component);
                serviceIntent.putExtra("xexe", "lp");
                if (listAppsFragment.getInstance().bindService(serviceIntent, mServiceConn, 1)) {
                    int i = BILLING_RESPONSE_RESULT_OK;
                    while (!this.mSetupDone && !this.skipSetupDone) {
                        new Utils("w").waitLP(500);
                        i++;
                        if (i == 30) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        if (intent != null) {
            if (intent.getStringExtra("xexe") != null && intent.getStringExtra("xexe").equals("lp") && intent.getPackage() == null) {
                System.out.println("Connect from proxy.");
                this.mSetupDone = false;
                this.skipSetupDone = true;
            } else {
                System.out.println("Connect from patch.");
            }
        }
        return this.mBinder;
    }
}
