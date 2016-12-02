/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package kellinwood.logging.android;

import kellinwood.logging.LoggerFactory;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.android.AndroidLogger;

public class AndroidLoggerFactory
implements LoggerFactory {
    @Override
    public LoggerInterface getLogger(String string) {
        return new AndroidLogger(string);
    }
}

