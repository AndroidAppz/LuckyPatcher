/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Throwable
 */
package net.lingala.zip4j.exception;

public class ZipException
extends Exception {
    private static final long serialVersionUID = 1;
    private int code;

    public ZipException() {
        this.code = -1;
    }

    public ZipException(String string) {
        super(string);
        this.code = -1;
    }

    public ZipException(String string, int n) {
        super(string);
        this.code = -1;
        this.code = n;
    }

    public ZipException(String string, Throwable throwable) {
        super(string, throwable);
        this.code = -1;
    }

    public ZipException(String string, Throwable throwable, int n) {
        super(string, throwable);
        this.code = -1;
        this.code = n;
    }

    public ZipException(Throwable throwable) {
        super(throwable);
        this.code = -1;
    }

    public ZipException(Throwable throwable, int n) {
        super(throwable);
        this.code = -1;
        this.code = n;
    }

    public int getCode() {
        return this.code;
    }
}

