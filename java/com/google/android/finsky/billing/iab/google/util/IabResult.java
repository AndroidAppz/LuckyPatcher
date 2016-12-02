/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.android.finsky.billing.iab.google.util;

import com.google.android.finsky.billing.iab.google.util.IabHelper;

public class IabResult {
    String mMessage;
    int mResponse;

    public IabResult(int n, String string) {
        this.mResponse = n;
        if (string == null || string.trim().length() == 0) {
            this.mMessage = IabHelper.getResponseDesc(n);
            return;
        }
        this.mMessage = string + " (response: " + IabHelper.getResponseDesc(n) + ")";
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getResponse() {
        return this.mResponse;
    }

    public boolean isFailure() {
        if (!this.isSuccess()) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (this.mResponse == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "IabResult: " + this.getMessage();
    }
}

