/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package net.lingala.zip4j.progress;

import com.chelpus.Utils;
import net.lingala.zip4j.exception.ZipException;

public class ProgressMonitor {
    public static final int OPERATION_ADD = 0;
    public static final int OPERATION_CALC_CRC = 3;
    public static final int OPERATION_EXTRACT = 1;
    public static final int OPERATION_MERGE = 4;
    public static final int OPERATION_NONE = -1;
    public static final int OPERATION_REMOVE = 2;
    public static final int RESULT_CANCELLED = 3;
    public static final int RESULT_ERROR = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_WORKING = 1;
    public static final int STATE_BUSY = 1;
    public static final int STATE_READY;
    private boolean cancelAllTasks;
    private int currentOperation;
    private Throwable exception;
    private String fileName;
    private boolean pause;
    private int percentDone;
    private int result;
    private int state;
    private long totalWork;
    private long workCompleted;

    public ProgressMonitor() {
        this.reset();
        this.percentDone = 0;
    }

    public void cancelAllTasks() {
        this.cancelAllTasks = true;
    }

    public void endProgressMonitorError(Throwable throwable) throws ZipException {
        this.reset();
        this.result = 2;
        this.exception = throwable;
    }

    public void endProgressMonitorSuccess() throws ZipException {
        this.reset();
        this.result = 0;
    }

    public void fullReset() {
        this.reset();
        this.exception = null;
        this.result = 0;
    }

    public int getCurrentOperation() {
        return this.currentOperation;
    }

    public Throwable getException() {
        return this.exception;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getPercentDone() {
        return this.percentDone;
    }

    public int getResult() {
        return this.result;
    }

    public int getState() {
        return this.state;
    }

    public long getTotalWork() {
        return this.totalWork;
    }

    public long getWorkCompleted() {
        return this.workCompleted;
    }

    public boolean isCancelAllTasks() {
        return this.cancelAllTasks;
    }

    public boolean isPause() {
        return this.pause;
    }

    public void reset() {
        this.currentOperation = -1;
        this.state = 0;
        this.fileName = null;
        this.totalWork = 0;
        this.workCompleted = 0;
        this.percentDone = 0;
    }

    public void setCurrentOperation(int n) {
        this.currentOperation = n;
    }

    public void setException(Throwable throwable) {
        this.exception = throwable;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    public void setPause(boolean bl) {
        this.pause = bl;
    }

    public void setPercentDone(int n) {
        this.percentDone = n;
    }

    public void setResult(int n) {
        this.result = n;
    }

    public void setState(int n) {
        this.state = n;
    }

    public void setTotalWork(long l) {
        this.totalWork = l;
    }

    public void updateWorkCompleted(long l) {
        this.workCompleted = l + this.workCompleted;
        if (this.totalWork > 0) {
            this.percentDone = (int)(100 * this.workCompleted / this.totalWork);
            if (this.percentDone > 100) {
                this.percentDone = 100;
            }
        }
        while (this.pause) {
            new Utils("w").waitLP(150);
        }
    }
}

