package com.google.android.finsky.billing.iab.google.util;

public class IabException extends Exception {
    IabResult mResult;

    public IabException(IabResult r) {
        this(r, null);
    }

    public IabException(int response, String message) {
        this(new IabResult(response, message));
    }

    public IabException(IabResult r, Exception cause) {
        super(r.getMessage(), cause);
        this.mResult = r;
    }

    public IabException(int response, String message, Exception cause) {
        this(new IabResult(response, message), cause);
    }

    public IabResult getResult() {
        return this.mResult;
    }
}
