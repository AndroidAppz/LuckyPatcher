package com.google.android.finsky.billing.iab;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import com.android.vending.billing.IMarketBillingService.Stub;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.google.util.IabHelper;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tukaani.xz.common.Util;

public class MarketBillingService extends Service {
    public static final String TAG = "BillingHack";
    private static Context context;
    private static String dev_pay = "";
    private static String item = "";
    private static Random sRandom;
    private final Stub mBinder = new Stub() {
        long request_id = -1;

        public Bundle sendBillingRequest(Bundle arguments) {
            String request = arguments.getString("BILLING_REQUEST");
            int api_version = arguments.getInt("API_VERSION", -1);
            String package_name = arguments.getString("PACKAGE_NAME");
            String dev_payload = arguments.getString("DEVELOPER_PAYLOAD");
            String item_id = arguments.getString("ITEM_ID");
            long nonce = arguments.getLong("NONCE");
            String[] notify_ids = arguments.getStringArray("NOTIFY_IDS");
            if (item_id != null) {
                MarketBillingService.item = item_id;
            }
            Bundle bundle = new Bundle();
            String pData = "";
            if ("CHECK_BILLING_SUPPORTED".equals(request)) {
                System.out.println("CHECK_BILLING_SUPPORTED");
                bundle.putInt(IabHelper.RESPONSE_CODE, 0);
            } else if ("REQUEST_PURCHASE".equals(request)) {
                System.out.println("REQUEST_PURCHASE");
                PackageInfo v0 = null;
                try {
                    v0 = listAppsFragment.getPkgMng().getPackageInfo(package_name, 0);
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent = null;
                if (v0 != null) {
                    long request_id = getNextInAppRequestId();
                    bundle.putLong("REQUEST_ID", request_id);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setClass(MarketBillingService.this, BuyMarketActivity.class);
                    intent2.putExtra("assetid", "inapp:" + package_name + ":" + item_id);
                    intent2.putExtra("asset_package", package_name);
                    MarketBillingService.item = item_id;
                    if (dev_payload != null) {
                        MarketBillingService.dev_pay = dev_payload;
                    } else {
                        MarketBillingService.dev_pay = "";
                    }
                    intent2 = intent2;
                    intent2.putExtra("asset_version_code", v0.versionCode);
                    intent2.putExtra("request_id", request_id);
                    intent2.putExtra(BuyMarketActivity.EXTRA_PACKAGENAME, package_name);
                    intent2.putExtra(BuyMarketActivity.EXTRA_PRODUCT_ID, item_id);
                    intent2.putExtra(BuyMarketActivity.EXTRA_DEV_PAYLOAD, dev_payload);
                    if (dev_payload != null) {
                        intent2.putExtra("developer_payload", dev_payload);
                    }
                    list = new DbHelper(listAppsFragment.getInstance(), package_name).getItems();
                    if (list.size() != 0) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ItemsListItem aList = (ItemsListItem) it.next();
                            if (aList.autobuy == 1 && aList.itemID.equals(item_id)) {
                                intent2.putExtra("autorepeat", aList.pSignature);
                            }
                        }
                    }
                }
                bundle.putParcelable("PURCHASE_INTENT", PendingIntent.getActivity(MarketBillingService.this, 0, intent, 1073741824));
                bundle.putInt(IabHelper.RESPONSE_CODE, 0);
            } else if ("RESTORE_TRANSACTIONS".equals(request)) {
                System.out.println("RESTORE_TRANSACTIONS");
                list = new DbHelper(listAppsFragment.getInstance(), package_name).getItems();
                if (list.size() != 0) {
                    base = new JSONObject();
                    purch_list = new JSONArray();
                    signature = "";
                    int i = 0;
                    while (i < list.size()) {
                        try {
                            if (((ItemsListItem) list.get(i)).savePurchase == 1) {
                                purch_list.put(new JSONObject(((ItemsListItem) list.get(i)).pData));
                                if (((ItemsListItem) list.get(i)).pSignature.equals("1")) {
                                    signature = "1";
                                } else {
                                    signature = "";
                                }
                            }
                            i++;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    base.put("nonce", nonce);
                    base.put("orders", purch_list);
                    pData = base.toString();
                    if (signature.equals("1")) {
                        signature = Utils.gen_sha1withrsa(pData);
                    }
                    System.out.println(pData);
                    MarketBillingService.this.mNotifier.sendPurchaseStateChanged(package_name, pData, signature);
                }
                if (package_name.equals("com.dynamixsoftware.printhand")) {
                    base = new JSONObject();
                    purch_list = new JSONArray();
                    purch = new JSONObject();
                    try {
                        base.put("nonce", nonce);
                        purch.put("notificationId", Utils.getRandom(1000000000000000000L, Util.VLI_MAX));
                        purch.put("orderId", Utils.getRandom(1000000000000000000L, Util.VLI_MAX) + Utils.getRandom(0, 9) + "." + Utils.getRandom(1000000000000000L, 9999999999999999L));
                        purch.put(BuyMarketActivity.EXTRA_PACKAGENAME, package_name);
                        purch.put("productId", "printhand.premium");
                        purch.put("purchaseTime", new Long(System.currentTimeMillis()));
                        purch.put("purchaseState", new Integer(0));
                        purch.put("developerPayload", MarketBillingService.dev_pay);
                        purch.put("purchaseToken", Utils.getRandomStringLowerCase(24));
                        purch_list.put(purch);
                        base.put("orders", purch_list);
                    } catch (JSONException e22) {
                        e22.printStackTrace();
                    }
                    pData = base.toString();
                    signature = Utils.gen_sha1withrsa(pData);
                    System.out.println(pData);
                    MarketBillingService.this.mNotifier.sendPurchaseStateChanged(package_name, pData, signature);
                }
                MarketBillingService.this.mNotifier.sendResponseCode(package_name, this.request_id, 0);
                bundle.putInt(IabHelper.RESPONSE_CODE, updateWithRequestId(bundle, restoreTransactions(package_name, nonce)));
            } else if ("GET_PURCHASE_INFORMATION".equals(request)) {
                System.out.println("GET_PURCHASE_INFORMATION");
                int order = (int) Utils.getRandom(0, 2147483647L);
                base = new JSONObject();
                purch_list = new JSONArray();
                purch = new JSONObject();
                try {
                    base.put("nonce", nonce);
                    purch.put("notificationId", notify_ids[0]);
                    purch.put("orderId", new StringBuilder(String.valueOf(Utils.getRandom(1000000000000000000L, Util.VLI_MAX) + Utils.getRandom(0, 9))).append(".").append(Utils.getRandom(1000000000000000L, 9999999999999999L)).toString());
                    purch.put(BuyMarketActivity.EXTRA_PACKAGENAME, package_name);
                    purch.put("productId", MarketBillingService.item);
                    purch.put("purchaseTime", new Long(System.currentTimeMillis()));
                    purch.put("purchaseState", new Integer(0));
                    purch.put("developerPayload", MarketBillingService.dev_pay);
                    purch.put("purchaseToken", Utils.getRandomStringLowerCase(24));
                    purch_list.put(purch);
                    base.put("orders", purch_list);
                } catch (JSONException e222) {
                    e222.printStackTrace();
                }
                pData = base.toString();
                signature = "";
                if (!listAppsFragment.getInstance().getSharedPreferences("config", 4).getBoolean("UnSign", false)) {
                    System.out.println("send sign");
                    signature = Utils.gen_sha1withrsa(pData);
                }
                String pSignatureSave = "";
                if (!signature.equals("")) {
                    pSignatureSave = "1";
                }
                if (listAppsFragment.getInstance().getSharedPreferences("config", 4).getBoolean("AutoRepeat", false)) {
                    new DbHelper(MarketBillingService.this, package_name).saveItem(new ItemsListItem(MarketBillingService.item, "auto.repeat.LP", pSignatureSave, 0, 1));
                }
                if (listAppsFragment.getInstance().getSharedPreferences("config", 4).getBoolean("SavePurchase", false)) {
                    new DbHelper(MarketBillingService.this, package_name).saveItem(new ItemsListItem(MarketBillingService.item, purch.toString(), pSignatureSave, 1, 0));
                }
                MarketBillingService.this.mNotifier.sendPurchaseStateChanged(package_name, pData, signature);
                MarketBillingService.this.mNotifier.sendResponseCode(package_name, this.request_id, 0);
                updateWithRequestId(bundle, restoreTransactions(package_name, nonce));
                bundle.putInt(IabHelper.RESPONSE_CODE, 0);
            } else if ("CONFIRM_NOTIFICATIONS".equals(request)) {
                System.out.println("CONFIRM_NOTIFICATIONS");
                bundle.putInt(IabHelper.RESPONSE_CODE, updateWithRequestId(bundle, confirmNotifications(package_name, notify_ids)));
                MarketBillingService.this.mNotifier.sendResponseCode(package_name, this.request_id, 0);
            } else {
                bundle.putInt(IabHelper.RESPONSE_CODE, 0);
            }
            return bundle;
        }

        public long restoreTransactions(String packageName, long nonce) {
            return getNextInAppRequestId();
        }

        public long confirmNotifications(String packageName, String[] notifyIds) {
            return getNextInAppRequestId();
        }

        private long getNextInAppRequestId() {
            this.request_id = MarketBillingService.sRandom.nextLong() & Util.VLI_MAX;
            return this.request_id;
        }

        private int updateWithRequestId(Bundle bundle, long requestId) {
            bundle.putLong("REQUEST_ID", requestId);
            return 0;
        }
    };
    BillingNotifier mNotifier = new BillingNotifier(this);
    PackageManager mPackageManager;

    public class BillingNotifier {
        private MarketBillingService mService;

        public BillingNotifier(MarketBillingService service) {
            this.mService = service;
        }

        protected boolean sendPurchaseStateChanged(String packageName, String data, String signature) {
            Intent v0 = MarketBillingService.findReceiverName(this.mService, packageName, new Intent("com.android.vending.billing.PURCHASE_STATE_CHANGED"));
            if (v0 == null) {
                return false;
            }
            v0.putExtra("inapp_signed_data", data);
            v0.putExtra("inapp_signature", signature);
            this.mService.sendBroadcast(v0);
            return true;
        }

        protected boolean sendResponseCode(String packageName, long requestId, int responseCode) {
            return MarketBillingService.sendResponseCode(this.mService, packageName, requestId, responseCode);
        }
    }

    static {
        sRandom = new Random();
        sRandom = new Random();
    }

    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public static Intent findReceiverName(Context context, String packageName, Intent intent) {
        Intent v4;
        ListIterator v0 = listAppsFragment.getPkgMng().queryBroadcastReceivers(intent, 0).listIterator();
        while (v0.hasNext()) {
            Object v2 = v0.next();
            if (((ResolveInfo) v2).activityInfo != null && packageName.equals(((ResolveInfo) v2).activityInfo.packageName)) {
                intent.setClassName(packageName, ((ResolveInfo) v2).activityInfo.name);
                v4 = intent;
                v4.setPackage(packageName);
                return v4;
            }
        }
        v4 = intent;
        System.out.println("Cannot find billing receiver in package '" + packageName + "' for action: " + intent.getAction());
        return null;
    }

    public static boolean sendResponseCode(Context context, String packageName, long requestId, int responseCode) {
        Intent v0 = findReceiverName(listAppsFragment.getInstance(), packageName, new Intent("com.android.vending.billing.RESPONSE_CODE"));
        if (v0 == null) {
            return false;
        }
        v0.putExtra("request_id", requestId);
        v0.putExtra("response_code", responseCode);
        listAppsFragment.getInstance().sendBroadcast(v0);
        return true;
    }
}
