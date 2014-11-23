package utils;

import org.testng.Reporter;
import org.apache.log4j.Logger;

/**
 * Created by Ruslan on 11/10/14.
 */
public class Log4Test {
    private Log4Test() {}

    private static final Logger LOGGER = Logger.getLogger(Log4Test.class);

    // ****************** Default message content ********************
    private static final String INFO_LOG = "INFO: \"%s\"";
    private static final String ERROR_LOG = "ERROR: \"%s\" !";
    private static final String START_TEST_LOG = "START TEST: \"%s\"";
    private static final String END_TEST_LOG = "END TEST: \"%s\" !";

    public static String error (String message)
    {
        LOGGER.error(String.format(ERROR_LOG, message));
        Reporter.log(String.format(ERROR_LOG, message));
        return String.format(ERROR_LOG, message);
    }

    public static String info(String message)
    {
        LOGGER.info(String.format(INFO_LOG, message));
        Reporter.log(String.format(INFO_LOG, message));
        return String.format(INFO_LOG, message);
    }
    public static String start(String message)
    {
        LOGGER.info(String.format(START_TEST_LOG, message));
        Reporter.log(String.format(START_TEST_LOG, message));
        return String.format(START_TEST_LOG, message);
    }

    public static String end(String message)
    {
        LOGGER.info(String.format(END_TEST_LOG, message));
        Reporter.log(String.format(END_TEST_LOG, message));
        return String.format(END_TEST_LOG, message);
    }


}
