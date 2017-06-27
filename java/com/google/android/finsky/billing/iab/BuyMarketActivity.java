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
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.google.util.IabHelper;
import org.tukaani.xz.common.Util;

public class BuyMarketActivity extends Activity {
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        Log.d(TAG, "Buy intent!");
        if (savedInstanceState != null) {
            this.packageName = savedInstanceState.getString(EXTRA_PACKAGENAME);
        } else {
            this.packageName = getIntent().getExtras().getString(EXTRA_PACKAGENAME);
        }
        String autorepeat = getIntent().getExtras().getString("autorepeat");
        if (autorepeat != null) {
            if (autorepeat.equals("1")) {
                listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
            } else {
                listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", true).commit();
            }
            Intent v2 = new Intent("com.android.vending.billing.IN_APP_NOTIFY");
            v2.setPackage(this.packageName);
            v2.putExtra("notification_id", Utils.getRandom(1000000000000000000L, Util.VLI_MAX));
            sendBroadcast(v2);
            finish();
        }
        setContentView(2130968591);
        Button btnYes = (Button) findViewById(2131558443);
        Button btnNo = (Button) findViewById(2131558441);
        listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
        listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", false).commit();
        this.check = (CheckBox) findViewById(2131558479);
        this.check2 = (CheckBox) findViewById(2131558480);
        this.check3 = (CheckBox) findViewById(2131558481);
        TextView text2 = (TextView) findViewById(2131558468);
        text2.setText(Utils.getText(2131361830));
        text2.append("\n" + Utils.getText(2131361831));
        this.check.setChecked(false);
        this.check2.setChecked(false);
        this.check3.setChecked(false);
        try {
            if (!(Utils.checkCoreJarPatch11() || Utils.isRebuildedOrOdex(this.packageName, this))) {
                this.check.setChecked(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnYes.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (BuyMarketActivity.this.check.isChecked()) {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", true).commit();
                } else {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("UnSign", false).commit();
                }
                if (BuyMarketActivity.this.check2.isChecked()) {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", true).commit();
                } else {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("SavePurchase", false).commit();
                }
                if (BuyMarketActivity.this.check3.isChecked()) {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("AutoRepeat", true).commit();
                } else {
                    listAppsFragment.getInstance().getSharedPreferences("config", 4).edit().putBoolean("AutoRepeat", false).commit();
                }
                Intent v2 = new Intent("com.android.vending.billing.IN_APP_NOTIFY");
                v2.setPackage(BuyMarketActivity.this.packageName);
                v2.putExtra("notification_id", Utils.getRandom(1000000000000000000L, Util.VLI_MAX));
                BuyMarketActivity.this.sendBroadcast(v2);
                BuyMarketActivity.this.finish();
            }
        });
        btnNo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent data = new Intent();
                Bundle extras = new Bundle();
                extras.putInt(IabHelper.RESPONSE_CODE, 1);
                data.putExtras(extras);
                BuyMarketActivity.this.setResult(0, data);
                BuyMarketActivity.this.finish();
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState) {
        System.out.println("save instance");
        outState.putString(EXTRA_PACKAGENAME, this.packageName);
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        System.out.println("load instance");
        this.packageName = savedInstanceState.getString(EXTRA_PACKAGENAME);
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        int currentOrientation = newConfig.orientation;
        if (currentOrientation == 2) {
            setRequestedOrientation(0);
        }
        if (currentOrientation == 1) {
            setRequestedOrientation(1);
        }
        super.onConfigurationChanged(newConfig);
    }
}
