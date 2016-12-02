/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 *  com.android.vending.billing.IInAppBillingService
 *  com.android.vending.billing.IInAppBillingService$Stub
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONException
 */
package com.google.android.finsky.billing.iab.google.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.google.android.finsky.billing.iab.google.util.IabException;
import com.google.android.finsky.billing.iab.google.util.IabResult;
import com.google.android.finsky.billing.iab.google.util.Inventory;
import com.google.android.finsky.billing.iab.google.util.Purchase;
import com.google.android.finsky.billing.iab.google.util.Security;
import com.google.android.finsky.billing.iab.google.util.SkuDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class IabHelper {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
    public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
    public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
    public static final int IABHELPER_BAD_RESPONSE = -1002;
    public static final int IABHELPER_ERROR_BASE = -1000;
    public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
    public static final int IABHELPER_MISSING_TOKEN = -1007;
    public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
    public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
    public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
    public static final int IABHELPER_UNKNOWN_ERROR = -1008;
    public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
    public static final int IABHELPER_USER_CANCELLED = -1005;
    public static final int IABHELPER_VERIFICATION_FAILED = -1003;
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String ITEM_TYPE_SUBS = "subs";
    public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    boolean mAsyncInProgress = false;
    String mAsyncOperation = "";
    Context mContext;
    boolean mDebugLog = false;
    String mDebugTag = "IabHelper";
    boolean mDisposed = false;
    OnIabPurchaseFinishedListener mPurchaseListener;
    String mPurchasingItemType;
    int mRequestCode;
    IInAppBillingService mService;
    ServiceConnection mServiceConn;
    boolean mSetupDone = false;
    String mSignatureBase64 = null;
    boolean mSubscriptionsSupported = false;

    public IabHelper(Context context, String string) {
        this.mContext = context.getApplicationContext();
        this.mSignatureBase64 = string;
        this.logDebug("IAB helper created.");
    }

    private void checkNotDisposed() {
        if (this.mDisposed) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    public static String getResponseDesc(int n) {
        String[] arrstring = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] arrstring2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (n <= -1000) {
            int n2 = -1000 - n;
            if (n2 >= 0 && n2 < arrstring2.length) {
                return arrstring2[n2];
            }
            return String.valueOf((int)n) + ":Unknown IAB Helper Error";
        }
        if (n < 0 || n >= arrstring.length) {
            return String.valueOf((int)n) + ":Unknown";
        }
        return arrstring[n];
    }

    void checkSetupDone(String string) {
        if (!this.mSetupDone) {
            this.logError("Illegal state for operation (" + string + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void consume(Purchase purchase) throws IabException {
        int n;
        String string;
        super.checkNotDisposed();
        this.checkSetupDone("consume");
        if (!purchase.mItemType.equals((Object)"inapp")) {
            throw new IabException(-1010, "Items of type '" + purchase.mItemType + "' can't be consumed.");
        }
        try {
            String string2 = purchase.getToken();
            string = purchase.getSku();
            if (string2 == null || string2.equals((Object)"")) {
                this.logError("Can't consume " + string + ". No token.");
                throw new IabException(-1007, "PurchaseInfo is missing token for sku: " + string + " " + purchase);
            }
            this.logDebug("Consuming sku: " + string + ", token: " + string2);
            n = this.mService.consumePurchase(3, this.mContext.getPackageName(), string2);
            if (n == 0) {
                this.logDebug("Successfully consumed sku: " + string);
                return;
            }
        }
        catch (RemoteException var2_4) {
            throw new IabException(-1001, "Remote exception while consuming. PurchaseInfo: " + purchase, (Exception)var2_4);
        }
        this.logDebug("Error consuming consuming sku " + string + ". " + IabHelper.getResponseDesc(n));
        throw new IabException(n, "Error consuming sku " + string);
    }

    public void consumeAsync(Purchase purchase, OnConsumeFinishedListener onConsumeFinishedListener) {
        super.checkNotDisposed();
        this.checkSetupDone("consume");
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)purchase);
        this.consumeAsyncInternal((List<Purchase>)arrayList, onConsumeFinishedListener, null);
    }

    public void consumeAsync(List<Purchase> list, OnConsumeMultiFinishedListener onConsumeMultiFinishedListener) {
        super.checkNotDisposed();
        this.checkSetupDone("consume");
        this.consumeAsyncInternal(list, null, onConsumeMultiFinishedListener);
    }

    void consumeAsyncInternal(final List<Purchase> list, final OnConsumeFinishedListener onConsumeFinishedListener, final OnConsumeMultiFinishedListener onConsumeMultiFinishedListener) {
        final Handler handler = new Handler();
        this.flagStartAsync("consume");
        new Thread(new Runnable(){

            public void run() {
                ArrayList arrayList = new ArrayList();
                for (Purchase purchase : list) {
                    try {
                        IabHelper.this.consume(purchase);
                        arrayList.add((Object)new IabResult(0, "Successful consume of sku " + purchase.getSku()));
                    }
                    catch (IabException var6_4) {
                        arrayList.add((Object)var6_4.getResult());
                    }
                }
                IabHelper.this.flagEndAsync();
                if (!IabHelper.this.mDisposed && onConsumeFinishedListener != null) {
                    handler.post(new Runnable((List)arrayList){
                        final /* synthetic */ List val$results;

                        public void run() {
                            onConsumeFinishedListener.onConsumeFinished((Purchase)list.get(0), (IabResult)this.val$results.get(0));
                        }
                    });
                }
                if (!IabHelper.this.mDisposed && onConsumeMultiFinishedListener != null) {
                    handler.post(new Runnable((List)arrayList){
                        final /* synthetic */ List val$results;

                        public void run() {
                            onConsumeMultiFinishedListener.onConsumeMultiFinished(list, this.val$results);
                        }
                    });
                }
            }

        }).start();
    }

    public void dispose() {
        this.logDebug("Disposing.");
        this.mSetupDone = false;
        if (this.mServiceConn != null) {
            this.logDebug("Unbinding from service.");
            if (this.mContext != null) {
                this.mContext.unbindService(this.mServiceConn);
            }
        }
        this.mDisposed = true;
        this.mContext = null;
        this.mServiceConn = null;
        this.mService = null;
        this.mPurchaseListener = null;
    }

    public void enableDebugLogging(boolean bl) {
        super.checkNotDisposed();
        this.mDebugLog = bl;
    }

    public void enableDebugLogging(boolean bl, String string) {
        super.checkNotDisposed();
        this.mDebugLog = bl;
        this.mDebugTag = string;
    }

    void flagEndAsync() {
        this.logDebug("Ending async operation: " + this.mAsyncOperation);
        this.mAsyncOperation = "";
        this.mAsyncInProgress = false;
    }

    void flagStartAsync(String string) {
        if (this.mAsyncInProgress) {
            throw new IllegalStateException("Can't start async operation (" + string + ") because another async operation(" + this.mAsyncOperation + ") is in progress.");
        }
        this.mAsyncOperation = string;
        this.mAsyncInProgress = true;
        this.logDebug("Starting async operation: " + string);
    }

    int getResponseCodeFromBundle(Bundle bundle) {
        Object object = bundle.get("RESPONSE_CODE");
        if (object == null) {
            this.logDebug("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (object instanceof Integer) {
            return (Integer)object;
        }
        if (object instanceof Long) {
            return (int)((Long)object).longValue();
        }
        this.logError("Unexpected type for bundle response code.");
        this.logError(object.getClass().getName());
        throw new RuntimeException("Unexpected type for bundle response code: " + object.getClass().getName());
    }

    int getResponseCodeFromIntent(Intent intent) {
        Object object = intent.getExtras().get("RESPONSE_CODE");
        if (object == null) {
            this.logError("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (object instanceof Integer) {
            return (Integer)object;
        }
        if (object instanceof Long) {
            return (int)((Long)object).longValue();
        }
        this.logError("Unexpected type for intent response code.");
        this.logError(object.getClass().getName());
        throw new RuntimeException("Unexpected type for intent response code: " + object.getClass().getName());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean handleActivityResult(int var1, int var2_3, Intent var3_2) {
        if (var1 != this.mRequestCode) {
            return false;
        }
        super.checkNotDisposed();
        this.checkSetupDone("handleActivityResult");
        this.flagEndAsync();
        if (var3_2 == null) {
            this.logError("Null data in IAB activity result.");
            var16_4 = new IabResult(-1002, "Null data in IAB result");
            if (this.mPurchaseListener == null) return true;
            this.mPurchaseListener.onIabPurchaseFinished(var16_4, null);
            return true;
        }
        var4_5 = this.getResponseCodeFromIntent(var3_2);
        var5_6 = var3_2.getStringExtra("INAPP_PURCHASE_DATA");
        var6_7 = var3_2.getStringExtra("INAPP_DATA_SIGNATURE");
        if (var2_3 != -1 || var4_5 != 0) ** GOTO lbl45
        this.logDebug("Successful resultcode from purchase activity.");
        this.logDebug("Purchase data: " + var5_6);
        this.logDebug("Data signature: " + var6_7);
        this.logDebug("Extras: " + (Object)var3_2.getExtras());
        this.logDebug("Expected item type: " + this.mPurchasingItemType);
        if (var5_6 == null || var6_7 == null) {
            this.logError("BUG: either purchaseData or dataSignature is null.");
            this.logDebug("Extras: " + var3_2.getExtras().toString());
            var10_8 = new IabResult(-1008, "IAB returned null purchaseData or dataSignature");
            if (this.mPurchaseListener == null) return true;
            this.mPurchaseListener.onIabPurchaseFinished(var10_8, null);
            return true;
        }
        try {
            var11_9 = new Purchase(this.mPurchasingItemType, var5_6, var6_7);
        }
        catch (JSONException var12_12) {}
        try {
            var14_10 = var11_9.getSku();
            if (!Security.verifyPurchase(this.mSignatureBase64, var5_6, var6_7)) {
                this.logError("Purchase signature verification FAILED for sku " + var14_10);
                var15_11 = new IabResult(-1003, "Signature verification failed for sku " + var14_10);
                if (this.mPurchaseListener == null) return true;
                this.mPurchaseListener.onIabPurchaseFinished(var15_11, var11_9);
                return true;
            }
            this.logDebug("Purchase signature successfully verified.");
            if (this.mPurchaseListener == null) return true;
        }
        catch (JSONException var12_14) {}
        this.mPurchaseListener.onIabPurchaseFinished(new IabResult(0, "Success"), var11_9);
        return true;
        ** GOTO lbl-1000
lbl45: // 1 sources:
        if (var2_3 == -1) {
            this.logDebug("Result code was OK but in-app billing response was not OK: " + IabHelper.getResponseDesc(var4_5));
            if (this.mPurchaseListener == null) return true;
            var9_16 = new IabResult(var4_5, "Problem purchashing item.");
            this.mPurchaseListener.onIabPurchaseFinished(var9_16, null);
            return true;
        }
        if (var2_3 == 0) {
            this.logDebug("Purchase canceled - Response: " + IabHelper.getResponseDesc(var4_5));
            var8_17 = new IabResult(-1005, "User canceled.");
            if (this.mPurchaseListener == null) return true;
            this.mPurchaseListener.onIabPurchaseFinished(var8_17, null);
            return true;
        }
        this.logError("Purchase failed. Result code: " + Integer.toString((int)var2_3) + ". Response: " + IabHelper.getResponseDesc(var4_5));
        var7_18 = new IabResult(-1006, "Unknown purchase response.");
        if (this.mPurchaseListener == null) return true;
        this.mPurchaseListener.onIabPurchaseFinished(var7_18, null);
        return true;
lbl-1000: // 2 sources:
        {
            this.logError("Failed to parse purchase data.");
            var12_13.printStackTrace();
            var13_15 = new IabResult(-1002, "Failed to parse purchase data.");
            if (this.mPurchaseListener == null) return true;
            this.mPurchaseListener.onIabPurchaseFinished(var13_15, null);
            return true;
        }
    }

    public void launchPurchaseFlow(Activity activity, String string, int n, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener) {
        this.launchPurchaseFlow(activity, string, n, onIabPurchaseFinishedListener, "");
    }

    public void launchPurchaseFlow(Activity activity, String string, int n, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener, String string2) {
        this.launchPurchaseFlow(activity, string, "inapp", n, onIabPurchaseFinishedListener, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void launchPurchaseFlow(Activity activity, String string, String string2, int n, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener, String string3) {
        this.checkNotDisposed();
        this.checkSetupDone("launchPurchaseFlow");
        this.flagStartAsync("launchPurchaseFlow");
        if (string2.equals((Object)"subs") && !this.mSubscriptionsSupported) {
            IabResult iabResult = new IabResult(-1009, "Subscriptions are not available.");
            this.flagEndAsync();
            if (onIabPurchaseFinishedListener == null) return;
            {
                onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null);
                return;
            }
        }
        try {
            this.logDebug("Constructing buy intent for " + string + ", item type: " + string2);
            Bundle bundle = this.mService.getBuyIntent(3, this.mContext.getPackageName(), string, string2, string3);
            int n2 = this.getResponseCodeFromBundle(bundle);
            if (n2 != 0) {
                this.logError("Unable to buy item, Error response: " + IabHelper.getResponseDesc(n2));
                this.flagEndAsync();
                IabResult iabResult = new IabResult(n2, "Unable to buy item");
                if (onIabPurchaseFinishedListener == null) return;
                {
                    onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null);
                    return;
                }
            }
            PendingIntent pendingIntent = (PendingIntent)bundle.getParcelable("BUY_INTENT");
            this.logDebug("Launching buy intent for " + string + ". Request code: " + n);
            this.mRequestCode = n;
            this.mPurchaseListener = onIabPurchaseFinishedListener;
            this.mPurchasingItemType = string2;
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), n, new Intent(), Integer.valueOf((int)0).intValue(), Integer.valueOf((int)0).intValue(), Integer.valueOf((int)0).intValue());
            return;
        }
        catch (IntentSender.SendIntentException var9_11) {
            this.logError("SendIntentException while launching purchase flow for sku " + string);
            var9_11.printStackTrace();
            this.flagEndAsync();
            IabResult iabResult = new IabResult(-1004, "Failed to send intent.");
            if (onIabPurchaseFinishedListener == null) return;
            {
                onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null);
                return;
            }
        }
        catch (RemoteException var7_14) {
            this.logError("RemoteException while launching purchase flow for sku " + string);
            var7_14.printStackTrace();
            this.flagEndAsync();
            IabResult iabResult = new IabResult(-1001, "Remote exception while starting purchase flow");
            if (onIabPurchaseFinishedListener == null) return;
            onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null);
            return;
        }
    }

    public void launchSubscriptionPurchaseFlow(Activity activity, String string, int n, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener) {
        this.launchSubscriptionPurchaseFlow(activity, string, n, onIabPurchaseFinishedListener, "");
    }

    public void launchSubscriptionPurchaseFlow(Activity activity, String string, int n, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener, String string2) {
        this.launchPurchaseFlow(activity, string, "subs", n, onIabPurchaseFinishedListener, string2);
    }

    void logDebug(String string) {
        if (this.mDebugLog) {
            Log.d((String)this.mDebugTag, (String)string);
        }
    }

    void logError(String string) {
        Log.e((String)this.mDebugTag, (String)("In-app billing error: " + string));
    }

    void logWarn(String string) {
        Log.w((String)this.mDebugTag, (String)("In-app billing warning: " + string));
    }

    public Inventory queryInventory(boolean bl, List<String> list) throws IabException {
        return this.queryInventory(bl, list, null);
    }

    /*
     * Exception decompiling
     */
    public Inventory queryInventory(boolean var1, List<String> var2_3, List<String> var3_2) throws IabException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener queryInventoryFinishedListener) {
        this.queryInventoryAsync(true, null, queryInventoryFinishedListener);
    }

    public void queryInventoryAsync(boolean bl, QueryInventoryFinishedListener queryInventoryFinishedListener) {
        this.queryInventoryAsync(bl, null, queryInventoryFinishedListener);
    }

    public void queryInventoryAsync(final boolean bl, final List<String> list, final QueryInventoryFinishedListener queryInventoryFinishedListener) {
        final Handler handler = new Handler();
        super.checkNotDisposed();
        this.checkSetupDone("queryInventory");
        this.flagStartAsync("refresh inventory");
        new Thread(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                Inventory inventory;
                IabResult iabResult = new IabResult(0, "Inventory refresh successful.");
                try {
                    Inventory inventory2;
                    inventory = inventory2 = IabHelper.this.queryInventory(bl, list);
                }
                catch (IabException var2_6) {
                    iabResult = var2_6.getResult();
                    inventory = null;
                }
                IabHelper.this.flagEndAsync();
                final IabResult iabResult2 = iabResult;
                final Inventory inventory3 = inventory;
                if (!IabHelper.this.mDisposed && queryInventoryFinishedListener != null) {
                    handler.post(new Runnable(){

                        public void run() {
                            queryInventoryFinishedListener.onQueryInventoryFinished(iabResult2, inventory3);
                        }
                    });
                }
            }

        }).start();
    }

    /*
     * Enabled aggressive block sorting
     */
    int queryPurchases(Inventory inventory, String string) throws JSONException, RemoteException {
        this.logDebug("Querying owned items, item type: " + string);
        this.logDebug("Package name: " + this.mContext.getPackageName());
        boolean bl = false;
        String string2 = null;
        do {
            this.logDebug("Calling getPurchases with continuation token: " + string2);
            Bundle bundle = this.mService.getPurchases(3, this.mContext.getPackageName(), string, string2);
            int n = this.getResponseCodeFromBundle(bundle);
            this.logDebug("Owned items response: " + String.valueOf((int)n));
            if (n != 0) {
                this.logDebug("getPurchases() failed: " + IabHelper.getResponseDesc(n));
                return n;
            }
            if (!(bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundle.containsKey("INAPP_PURCHASE_DATA_LIST") && bundle.containsKey("INAPP_DATA_SIGNATURE_LIST"))) {
                this.logError("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            }
            ArrayList arrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            for (int i = 0; i < arrayList2.size(); ++i) {
                String string3 = (String)arrayList2.get(i);
                String string4 = (String)arrayList3.get(i);
                String string5 = (String)arrayList.get(i);
                if (Security.verifyPurchase(this.mSignatureBase64, string3, string4)) {
                    this.logDebug("Sku is owned: " + string5);
                    Purchase purchase = new Purchase(string, string3, string4);
                    if (TextUtils.isEmpty((CharSequence)purchase.getToken())) {
                        this.logWarn("BUG: empty/null token!");
                        this.logDebug("Purchase data: " + string3);
                    }
                    inventory.addPurchase(purchase);
                    continue;
                }
                this.logWarn("Purchase signature verification **FAILED**. Not adding item.");
                this.logDebug("   Purchase data: " + string3);
                this.logDebug("   Signature: " + string4);
                bl = true;
            }
            string2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
            this.logDebug("Continuation token: " + string2);
        } while (!TextUtils.isEmpty((CharSequence)string2));
        if (!bl) return 0;
        return -1003;
    }

    /*
     * Enabled aggressive block sorting
     */
    int querySkuDetails(String string, Inventory inventory, List<String> list) throws RemoteException, JSONException {
        this.logDebug("Querying SKU details.");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(inventory.getAllOwnedSkus(string));
        if (list != null) {
            for (String string2 : list) {
                if (arrayList.contains((Object)string2)) continue;
                arrayList.add((Object)string2);
            }
        }
        if (arrayList.size() == 0) {
            this.logDebug("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        } else {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle bundle2 = this.mService.getSkuDetails(3, this.mContext.getPackageName(), string, bundle);
            if (!bundle2.containsKey("DETAILS_LIST")) {
                int n = this.getResponseCodeFromBundle(bundle2);
                if (n != 0) {
                    this.logDebug("getSkuDetails() failed: " + IabHelper.getResponseDesc(n));
                    return n;
                }
                this.logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                return -1002;
            }
            Iterator iterator = bundle2.getStringArrayList("DETAILS_LIST").iterator();
            while (iterator.hasNext()) {
                SkuDetails skuDetails = new SkuDetails(string, (String)iterator.next());
                this.logDebug("Got sku details: " + skuDetails);
                inventory.addSkuDetails(skuDetails);
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void startSetup(final OnIabSetupFinishedListener onIabSetupFinishedListener) {
        super.checkNotDisposed();
        if (this.mSetupDone) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        this.logDebug("Starting in-app billing setup.");
        this.mServiceConn = new ServiceConnection(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (IabHelper.this.mDisposed) {
                    return;
                }
                IabHelper.this.logDebug("Billing service connected.");
                IabHelper.this.mService = IInAppBillingService.Stub.asInterface((IBinder)iBinder);
                String string = IabHelper.this.mContext.getPackageName();
                try {
                    IabHelper.this.logDebug("Checking for in-app billing 3 support.");
                    int n = IabHelper.this.mService.isBillingSupported(3, string, "inapp");
                    if (n != 0) {
                        if (onIabSetupFinishedListener != null) {
                            onIabSetupFinishedListener.onIabSetupFinished(new IabResult(n, "Error checking for billing v3 support."));
                        }
                        IabHelper.this.mSubscriptionsSupported = false;
                        return;
                    }
                    IabHelper.this.logDebug("In-app billing version 3 supported for " + string);
                    int n2 = IabHelper.this.mService.isBillingSupported(3, string, "subs");
                    if (n2 == 0) {
                        IabHelper.this.logDebug("Subscriptions AVAILABLE.");
                        IabHelper.this.mSubscriptionsSupported = true;
                    } else {
                        IabHelper.this.logDebug("Subscriptions NOT AVAILABLE. Response: " + n2);
                    }
                }
                catch (RemoteException var4_5) {
                    if (onIabSetupFinishedListener != null) {
                        onIabSetupFinishedListener.onIabSetupFinished(new IabResult(-1001, "RemoteException while setting up in-app billing."));
                    }
                    var4_5.printStackTrace();
                    return;
                }
                IabHelper.this.mSetupDone = true;
                if (onIabSetupFinishedListener == null) return;
                onIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful."));
            }

            public void onServiceDisconnected(ComponentName componentName) {
                IabHelper.this.logDebug("Billing service disconnected.");
                IabHelper.this.mService = null;
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        if (!this.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            this.mContext.bindService(intent, this.mServiceConn, 1);
            return;
        } else {
            if (onIabSetupFinishedListener == null) return;
            {
                onIabSetupFinishedListener.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
                return;
            }
        }
    }

    public boolean subscriptionsSupported() {
        this.checkNotDisposed();
        return this.mSubscriptionsSupported;
    }

    public static interface OnConsumeFinishedListener {
        public void onConsumeFinished(Purchase var1, IabResult var2);
    }

    public static interface OnConsumeMultiFinishedListener {
        public void onConsumeMultiFinished(List<Purchase> var1, List<IabResult> var2);
    }

    public static interface OnIabPurchaseFinishedListener {
        public void onIabPurchaseFinished(IabResult var1, Purchase var2);
    }

    public static interface OnIabSetupFinishedListener {
        public void onIabSetupFinished(IabResult var1);
    }

    public static interface QueryInventoryFinishedListener {
        public void onQueryInventoryFinished(IabResult var1, Inventory var2);
    }

}

