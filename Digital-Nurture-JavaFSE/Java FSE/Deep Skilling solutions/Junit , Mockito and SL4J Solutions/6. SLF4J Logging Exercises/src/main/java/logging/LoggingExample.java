package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("Application started.");
        
        // Error and Warning Logging
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        
        // Parameterized Logging
        String user = "Alice";
        int id = 101;
        logger.info("User {} logged in with ID: {}", user, id);
        
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage(), e);
        }
        
        logger.info("Application finished.");
    }
}
