package com.google.android.finsky.billing.iab;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.google.util.IabHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.tukaani.xz.common.Util;

public class BuyActivity extends Activity {
    public static final String BUY_INTENT = "com.google.android.finsky.billing.iab.BUY";
    public static final String EXTRA_DEV_PAYLOAD = "payload";
    public static final String EXTRA_PACKAGENAME = "packageName";
    public static final String EXTRA_PRODUCT_ID = "product";
    public static final String TAG = "BillingHack";
    Bundle bundle = null;
    public BuyActivity context = null;
    String devPayload = "";
    String packageName = "";
    String productId = "";
    String type = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        if (BUY_INTENT.equals(getIntent().getAction()) || savedInstanceState != null) {
            Log.d(TAG, "Buy intent!");
            System.out.println(getRequestedOrientation());
            if (savedInstanceState != null) {
                this.packageName = savedInstanceState.getString(EXTRA_PACKAGENAME);
                this.productId = savedInstanceState.getString(EXTRA_PRODUCT_ID);
                this.devPayload = savedInstanceState.getString(EXTRA_DEV_PAYLOAD);
                this.type = savedInstanceState.getString("Type");
            } else {
                this.packageName = getIntent().getExtras().getString(EXTRA_PACKAGENAME);
                this.productId = getIntent().getExtras().getString(EXTRA_PRODUCT_ID);
                this.devPayload = getIntent().getExtras().getString(EXTRA_DEV_PAYLOAD);
                this.type = getIntent().getExtras().getString("Type");
            }
            System.out.println(this.type);
            JSONObject purch = new JSONObject();
            try {
                purch.put("orderId", new StringBuilder(String.valueOf(Utils.getRandom(1000000000000000000L, Util.VLI_MAX) + Utils.getRandom(0, 9))).append(".").append(Utils.getRandom(1000000000000000L, 9999999999999999L)).toString());
                purch.put(EXTRA_PACKAGENAME, this.packageName);
                purch.put("productId", this.productId);
                purch.put("purchaseTime", new Long(System.currentTimeMillis()));
                purch.put("purchaseState", new Integer(0));
                purch.put("developerPayload", this.devPayload);
                purch.put("purchaseToken", Utils.getRandomStringLowerCase(24));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final String pData = purch.toString();
            String autorepeat = getIntent().getExtras().getString("autorepeat");
            if (autorepeat != null) {
                Intent data = new Intent();
                Bundle extras = new Bundle();
                String signature = "";
                if (autorepeat.equals("1")) {
                    signature = Utils.gen_sha1withrsa(pData);
                } else {
                    signature = "";
                }
                extras.putInt(IabHelper.RESPONSE_CODE, 0);
                extras.putString(IabHelper.RESPONSE_INAPP_PURCHASE_DATA, pData);
                extras.putString(IabHelper.RESPONSE_INAPP_SIGNATURE, signature);
                data.putExtras(extras);
                setResult(-1, data);
                finish();
            }
            setContentView(2130968591);
            Button btnYes = (Button) findViewById(2131558443);
            Button btnNo = (Button) findViewById(2131558441);
            final CheckBox check = (CheckBox) findViewById(2131558479);
            try {
                if (!(Utils.checkCoreJarPatch11() || Utils.isRebuildedOrOdex(this.packageName, this))) {
                    check.setChecked(true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            final CheckBox check2 = (CheckBox) findViewById(2131558480);
            final CheckBox check3 = (CheckBox) findViewById(2131558481);
            TextView text2 = (TextView) findViewById(2131558468);
            text2.setText(Utils.getText(2131361830));
            text2.append("\n" + Utils.getText(2131361831));
            check2.setChecked(false);
            check3.setChecked(false);
            btnYes.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent data = new Intent();
                    Bundle extras = new Bundle();
                    String signature = "";
                    String save_signature = "";
                    if (check.isChecked()) {
                        save_signature = "";
                        signature = "";
                    } else {
                        signature = Utils.gen_sha1withrsa(pData);
                        save_signature = "1";
                    }
                    if (check3.isChecked() || check2.isChecked()) {
                        int sp = 0;
                        int ab = 0;
                        if (check3.isChecked()) {
                            ab = 1;
                        }
                        if (check2.isChecked()) {
                            sp = 1;
                        }
                        new DbHelper(BuyActivity.this.getApplicationContext(), BuyActivity.this.packageName).saveItem(new ItemsListItem(BuyActivity.this.productId, pData, save_signature, sp, ab));
                    }
                    extras.putInt(IabHelper.RESPONSE_CODE, 0);
                    extras.putString(IabHelper.RESPONSE_INAPP_PURCHASE_DATA, pData);
                    extras.putString(IabHelper.RESPONSE_INAPP_SIGNATURE, signature);
                    data.putExtras(extras);
                    BuyActivity.this.setResult(-1, data);
                    BuyActivity.this.finish();
                }
            });
            btnNo.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent data = new Intent();
                    Bundle extras = new Bundle();
                    extras.putInt(IabHelper.RESPONSE_CODE, 1);
                    data.putExtras(extras);
                    BuyActivity.this.setResult(0, data);
                    BuyActivity.this.finish();
                }
            });
            return;
        }
        finish();
    }

    protected void onSaveInstanceState(Bundle outState) {
        System.out.println("save instance");
        outState.putString(EXTRA_PACKAGENAME, this.packageName);
        outState.putString(EXTRA_PRODUCT_ID, this.productId);
        outState.putString(EXTRA_DEV_PAYLOAD, this.devPayload);
        outState.putString("Type", this.type);
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        System.out.println("load instance");
        this.packageName = savedInstanceState.getString(EXTRA_PACKAGENAME);
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.orientation == 2) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
        super.onConfigurationChanged(newConfig);
    }
}
