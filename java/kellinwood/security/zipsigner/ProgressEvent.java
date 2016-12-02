package kellinwood.security.zipsigner;

public class ProgressEvent {
    public static final int PRORITY_IMPORTANT = 1;
    public static final int PRORITY_NORMAL = 0;
    private String message;
    private int percentDone;
    private int priority;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPercentDone() {
        return this.percentDone;
    }

    public void setPercentDone(int percentDone) {
        this.percentDone = percentDone;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
