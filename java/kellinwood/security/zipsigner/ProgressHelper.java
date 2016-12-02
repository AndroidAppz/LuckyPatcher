package kellinwood.security.zipsigner;

import java.util.ArrayList;
import java.util.Iterator;

public class ProgressHelper {
    private ArrayList<ProgressListener> listeners = new ArrayList();
    private int progressCurrentItem = 0;
    private ProgressEvent progressEvent = new ProgressEvent();
    private int progressTotalItems = 0;

    public void initProgress() {
        this.progressTotalItems = 10000;
        this.progressCurrentItem = 0;
    }

    public int getProgressTotalItems() {
        return this.progressTotalItems;
    }

    public void setProgressTotalItems(int progressTotalItems) {
        this.progressTotalItems = progressTotalItems;
    }

    public int getProgressCurrentItem() {
        return this.progressCurrentItem;
    }

    public void setProgressCurrentItem(int progressCurrentItem) {
        this.progressCurrentItem = progressCurrentItem;
    }

    public void progress(int priority, String message) {
        int percentDone;
        this.progressCurrentItem++;
        if (this.progressTotalItems == 0) {
            percentDone = 0;
        } else {
            percentDone = (this.progressCurrentItem * 100) / this.progressTotalItems;
        }
        Iterator i$ = this.listeners.iterator();
        while (i$.hasNext()) {
            ProgressListener listener = (ProgressListener) i$.next();
            this.progressEvent.setMessage(message);
            this.progressEvent.setPercentDone(percentDone);
            this.progressEvent.setPriority(priority);
            listener.onProgress(this.progressEvent);
        }
    }

    public synchronized void addProgressListener(ProgressListener l) {
        ArrayList<ProgressListener> list = (ArrayList) this.listeners.clone();
        list.add(l);
        this.listeners = list;
    }

    public synchronized void removeProgressListener(ProgressListener l) {
        ArrayList<ProgressListener> list = (ArrayList) this.listeners.clone();
        list.remove(l);
        this.listeners = list;
    }
}
