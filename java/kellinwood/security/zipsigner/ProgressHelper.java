/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package kellinwood.security.zipsigner;

import java.util.ArrayList;
import java.util.Iterator;
import kellinwood.security.zipsigner.ProgressEvent;
import kellinwood.security.zipsigner.ProgressListener;

public class ProgressHelper {
    private ArrayList<ProgressListener> listeners = new ArrayList();
    private int progressCurrentItem = 0;
    private ProgressEvent progressEvent = new ProgressEvent();
    private int progressTotalItems = 0;

    public void addProgressListener(ProgressListener progressListener) {
        void var5_2 = this;
        synchronized (var5_2) {
            ArrayList arrayList = (ArrayList)this.listeners.clone();
            arrayList.add((Object)progressListener);
            this.listeners = arrayList;
            return;
        }
    }

    public int getProgressCurrentItem() {
        return this.progressCurrentItem;
    }

    public int getProgressTotalItems() {
        return this.progressTotalItems;
    }

    public void initProgress() {
        this.progressTotalItems = 10000;
        this.progressCurrentItem = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void progress(int n, String string) {
        this.progressCurrentItem = 1 + this.progressCurrentItem;
        int n2 = this.progressTotalItems == 0 ? 0 : 100 * this.progressCurrentItem / this.progressTotalItems;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ProgressListener progressListener = (ProgressListener)iterator.next();
            this.progressEvent.setMessage(string);
            this.progressEvent.setPercentDone(n2);
            this.progressEvent.setPriority(n);
            progressListener.onProgress(this.progressEvent);
        }
        return;
    }

    public void removeProgressListener(ProgressListener progressListener) {
        void var5_2 = this;
        synchronized (var5_2) {
            ArrayList arrayList = (ArrayList)this.listeners.clone();
            arrayList.remove((Object)progressListener);
            this.listeners = arrayList;
            return;
        }
    }

    public void setProgressCurrentItem(int n) {
        this.progressCurrentItem = n;
    }

    public void setProgressTotalItems(int n) {
        this.progressTotalItems = n;
    }
}

