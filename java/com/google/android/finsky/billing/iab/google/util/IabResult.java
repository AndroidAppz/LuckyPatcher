package com.google.android.finsky.billing.iab.google.util;

public class IabResult {
    String mMessage;
    int mResponse;

    public IabResult(int response, String message) {
        this.mResponse = response;
        if (message == null || message.trim().length() == 0) {
            this.mMessage = IabHelper.getResponseDesc(response);
        } else {
            this.mMessage = new StringBuilder(String.valueOf(message)).append(" (response: ").append(IabHelper.getResponseDesc(response)).append(")").toString();
        }
    }

    public int getResponse() {
        return this.mResponse;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public boolean isSuccess() {
        return this.mResponse == 0;
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public String toString() {
        return "IabResult: " + getMessage();
    }
}
