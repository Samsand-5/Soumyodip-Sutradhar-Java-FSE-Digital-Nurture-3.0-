public class SingletonTest {
    public static void main(String[] args) {
        // Get the only instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages using the Logger instance
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Verify that both logger1 and logger2 refer to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
