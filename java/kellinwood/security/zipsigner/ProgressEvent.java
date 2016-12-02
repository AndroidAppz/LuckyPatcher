/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package kellinwood.security.zipsigner;

public class ProgressEvent {
    public static final int PRORITY_IMPORTANT = 1;
    public static final int PRORITY_NORMAL;
    private String message;
    private int percentDone;
    private int priority;

    public String getMessage() {
        return this.message;
    }

    public int getPercentDone() {
        return this.percentDone;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setMessage(String string) {
        this.message = string;
    }

    public void setPercentDone(int n) {
        this.percentDone = n;
    }

    public void setPriority(int n) {
        this.priority = n;
    }
}

