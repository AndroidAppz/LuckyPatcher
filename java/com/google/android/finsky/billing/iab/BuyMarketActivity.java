/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.TextView
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.google.android.finsky.billing.iab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.io.PrintStream;

public class BuyMarketActivity
extends Activity {
    public static final String BUY_INTENT = "org.billinghack.BUY";
    public static final String EXTRA_DEV_PAYLOAD = "payload";
    public static final String EXTRA_PACKAGENAME = "packageName";
    public static final String EXTRA_PRODUCT_ID = "product";
    public static final String TAG = "BillingHack";
    CheckBox check = null;
    CheckBox check2 = null;
    CheckBox check3 = null;
    public BuyMarketActivity context = null;
    String pData;
    public String packageName = "";

    public void onConfigurationChanged(Configuration configuration) {
        int n = configuration.orientation;
        if (n == 2) {
            this.setRequestedOrientation(0);
        }
        if (n == 1) {
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
        Log.d((String)"BillingHack", (String)"Buy intent!");
        this.packageName = bundle != null ? bundle.getString("packageName") : this.getIntent().getExtras().getString("packageName");
        String string = this.getIntent().getExtras().getString("autorepeat");
        if (string != null) {
            if (string.equals((Object)"1")) {
                listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
            } else {
                listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", true).commit();
            }
            Intent intent = new Intent("com.android.vending.billing.IN_APP_NOTIFY");
            intent.setPackage(this.packageName);
            intent.putExtra("notification_id", "" + Utils.getRandom(1000000000000000000L, Long.MAX_VALUE));
            this.sendBroadcast(intent);
            this.finish();
        }
        this.setContentView(2130968591);
        Button button = (Button)this.findViewById(2131558443);
        Button button2 = (Button)this.findViewById(2131558441);
        listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
        listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", false).commit();
        this.check = (CheckBox)this.findViewById(2131558479);
        this.check2 = (CheckBox)this.findViewById(2131558480);
        this.check3 = (CheckBox)this.findViewById(2131558481);
        TextView textView = (TextView)this.findViewById(2131558468);
        textView.setText((CharSequence)Utils.getText(2131165231));
        textView.append((CharSequence)("\n" + Utils.getText(2131165232)));
        this.check.setChecked(false);
        this.check2.setChecked(false);
        this.check3.setChecked(false);
        try {
            if (!Utils.checkCoreJarPatch11() && !Utils.isRebuildedOrOdex(this.packageName, (Context)this)) {
                this.check.setChecked(true);
            }
        }
        catch (Exception var9_7) {
            var9_7.printStackTrace();
        }
        button.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                if (!BuyMarketActivity.this.check.isChecked()) {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
                } else {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", true).commit();
                }
                if (!BuyMarketActivity.this.check2.isChecked()) {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", false).commit();
                } else {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", true).commit();
                }
                if (!BuyMarketActivity.this.check3.isChecked()) {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("AutoRepeat", false).commit();
                } else {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("AutoRepeat", true).commit();
                }
                Intent intent = new Intent("com.android.vending.billing.IN_APP_NOTIFY");
                intent.setPackage(BuyMarketActivity.this.packageName);
                intent.putExtra("notification_id", "" + Utils.getRandom(1000000000000000000L, Long.MAX_VALUE));
                BuyMarketActivity.this.sendBroadcast(intent);
                BuyMarketActivity.this.finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("RESPONSE_CODE", 1);
                intent.putExtras(bundle);
                BuyMarketActivity.this.setResult(0, intent);
                BuyMarketActivity.this.finish();
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
        super.onSaveInstanceState(bundle);
    }

}

