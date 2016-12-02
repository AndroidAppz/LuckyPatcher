/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.String
 *  java.lang.Throwable
 */
package kellinwood.logging;

import java.io.PrintStream;
import kellinwood.logging.AbstractLogger;

public class StreamLogger
extends AbstractLogger {
    PrintStream out;

    public StreamLogger(String string, PrintStream printStream) {
        super(string);
        this.out = printStream;
    }

    @Override
    protected void write(String string, String string2, Throwable throwable) {
        this.out.print(this.format(string, string2));
        if (throwable != null) {
            throwable.printStackTrace(this.out);
        }
    }
}

