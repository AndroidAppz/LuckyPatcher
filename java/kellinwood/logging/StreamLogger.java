package kellinwood.logging;

import java.io.PrintStream;

public class StreamLogger extends AbstractLogger {
    PrintStream out;

    public StreamLogger(String category, PrintStream out) {
        super(category);
        this.out = out;
    }

    protected void write(String level, String message, Throwable t) {
        this.out.print(format(level, message));
        if (t != null) {
            t.printStackTrace(this.out);
        }
    }
}
