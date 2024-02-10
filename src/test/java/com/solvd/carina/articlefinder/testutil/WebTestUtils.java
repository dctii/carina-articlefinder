package com.solvd.carina.articlefinder.testutil;

import com.solvd.carina.articlefinder.util.AnsiCodes;
import com.solvd.carina.articlefinder.util.DateTimeConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class WebTestUtils {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.WEB_TEST_UTILS);

    public WebTestUtils() {
    }

    public static boolean isMatchingCurrentNewYorkDate(String dateString) {
        // e.g., "Thursday, February 8, 2024"
        LocalDate date = LocalDate.parse(dateString, DateTimeConstants.NYT_TODAY_DATE_FORMATTER);

        // get current date in New York timezone
        LocalDate currentNewYorkDate =
                ZonedDateTime.now(DateTimeConstants.AMERICA_NEW_YORK_ZID).toLocalDate();

        LOGGER.info("{}Today date display after converted: {}{}", AnsiCodes.RED_ON_YELLOW,
                date.toString(),
                AnsiCodes.RESET_ALL);
        LOGGER.info("{}LocalDate.now() in New York: {}{}", AnsiCodes.RED_ON_YELLOW, currentNewYorkDate.toString(), AnsiCodes.RESET_ALL);

        return date.equals(currentNewYorkDate);
    }
}
