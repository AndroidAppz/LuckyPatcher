package kellinwood.logging;

public class ConsoleLoggerFactory implements LoggerFactory {
    public LoggerInterface getLogger(String category) {
        return new StreamLogger(category, System.out);
    }
}
