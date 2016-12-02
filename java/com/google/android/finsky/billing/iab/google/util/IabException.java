/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.google.android.finsky.billing.iab.google.util;

import com.google.android.finsky.billing.iab.google.util.IabResult;

public class IabException
extends Exception {
    IabResult mResult;

    public IabException(int n, String string) {
        super(new IabResult(n, string));
    }

    public IabException(int n, String string, Exception exception) {
        super(new IabResult(n, string), exception);
    }

    public IabException(IabResult iabResult) {
        super(iabResult, null);
    }

    public IabException(IabResult iabResult, Exception exception) {
        super(iabResult.getMessage(), (Throwable)exception);
        this.mResult = iabResult;
    }

    public IabResult getResult() {
        return this.mResult;
    }
}

