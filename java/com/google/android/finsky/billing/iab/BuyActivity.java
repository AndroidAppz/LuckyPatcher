/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.TextView
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.finsky.billing.iab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.DbHelper;
import com.google.android.finsky.billing.iab.ItemsListItem;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class BuyActivity
extends Activity {
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

    /*
     * Enabled aggressive block sorting
     */
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 2) {
            this.setRequestedOrientation(0);
        } else {
            this.setRequestedOrientation(1);
        }
        super.onConfigurationChanged(configuration);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = this;
        if (!"com.google.android.finsky.billing.iab.BUY".equals((Object)this.getIntent().getAction()) && bundle == null) {
            this.finish();
            return;
        }
        Log.d((String)"BillingHack", (String)"Buy intent!");
        System.out.println(this.getRequestedOrientation());
        if (bundle != null) {
            this.packageName = bundle.getString("packageName");
            this.productId = bundle.getString("product");
            this.devPayload = bundle.getString("payload");
            this.type = bundle.getString("Type");
        } else {
            this.packageName = this.getIntent().getExtras().getString("packageName");
            this.productId = this.getIntent().getExtras().getString("product");
            this.devPayload = this.getIntent().getExtras().getString("payload");
            this.type = this.getIntent().getExtras().getString("Type");
        }
        System.out.println(this.type);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orderId", (Object)("" + (Utils.getRandom(1000000000000000000L, Long.MAX_VALUE) + Utils.getRandom(0, 9)) + "." + Utils.getRandom(1000000000000000L, 9999999999999999L)));
            jSONObject.put("packageName", (Object)this.packageName);
            jSONObject.put("productId", (Object)this.productId);
            jSONObject.put("purchaseTime", (Object)new Long(System.currentTimeMillis()));
            jSONObject.put("purchaseState", (Object)new Integer(0));
            jSONObject.put("developerPayload", (Object)this.devPayload);
            jSONObject.put("purchaseToken", (Object)Utils.getRandomStringLowerCase(24));
        }
        catch (JSONException var4_14) {
            var4_14.printStackTrace();
        }
        final String string = jSONObject.toString();
        String string2 = this.getIntent().getExtras().getString("autorepeat");
        if (string2 != null) {
            Intent intent = new Intent();
            Bundle bundle2 = new Bundle();
            String string3 = string2.equals((Object)"1") ? Utils.gen_sha1withrsa(string) : "";
            bundle2.putInt("RESPONSE_CODE", 0);
            bundle2.putString("INAPP_PURCHASE_DATA", string);
            bundle2.putString("INAPP_DATA_SIGNATURE", string3);
            intent.putExtras(bundle2);
            this.setResult(-1, intent);
            this.finish();
        }
        this.setContentView(2130968591);
        Button button = (Button)this.findViewById(2131558443);
        Button button2 = (Button)this.findViewById(2131558441);
        final CheckBox checkBox = (CheckBox)this.findViewById(2131558479);
        try {
            if (!Utils.checkCoreJarPatch11() && !Utils.isRebuildedOrOdex(this.packageName, (Context)this)) {
                checkBox.setChecked(true);
            }
        }
        catch (Exception var14_15) {
            var14_15.printStackTrace();
        }
        final CheckBox checkBox2 = (CheckBox)this.findViewById(2131558480);
        final CheckBox checkBox3 = (CheckBox)this.findViewById(2131558481);
        TextView textView = (TextView)this.findViewById(2131558468);
        textView.setText((CharSequence)Utils.getText(2131165231));
        textView.append((CharSequence)("\n" + Utils.getText(2131165232)));
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        button.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                String string3;
                String string2;
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                if (!checkBox.isChecked()) {
                    string3 = Utils.gen_sha1withrsa(string);
                    string2 = "1";
                } else {
                    string2 = "";
                    string3 = "";
                }
                if (checkBox3.isChecked() || checkBox2.isChecked()) {
                    boolean bl = checkBox3.isChecked();
                    int n = 0;
                    if (bl) {
                        n = 1;
                    }
                    boolean bl2 = checkBox2.isChecked();
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    new DbHelper(BuyActivity.this.getApplicationContext(), BuyActivity.this.packageName).saveItem(new ItemsListItem(BuyActivity.this.productId, string, string2, n2, n));
                }
                bundle.putInt("RESPONSE_CODE", 0);
                bundle.putString("INAPP_PURCHASE_DATA", string);
                bundle.putString("INAPP_DATA_SIGNATURE", string3);
                intent.putExtras(bundle);
                BuyActivity.this.setResult(-1, intent);
                BuyActivity.this.finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("RESPONSE_CODE", 1);
                intent.putExtras(bundle);
                BuyActivity.this.setResult(0, intent);
                BuyActivity.this.finish();
            }
        });
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        System.out.println("load instance");
        this.packageName = bundle.getString("packageName");
        super.onRestoreInstanceState(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        System.out.println("save instance");
        bundle.putString("packageName", this.packageName);
        bundle.putString("product", this.productId);
        bundle.putString("payload", this.devPayload);
        bundle.putString("Type", this.type);
        super.onSaveInstanceState(bundle);
    }

}

