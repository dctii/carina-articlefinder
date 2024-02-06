package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.DATE_TIME_UTILS);
    private DateTimeUtils() {
        ExceptionUtils.preventUtilityInstantiation();
    }

    public static DateTimeFormatter createDateTimeFormatterFromPattern(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    public static DateTimeFormatter getNyTimesFormatter() {
        return createDateTimeFormatterFromPattern(StringConstants.NY_TIMES_PUB_DATE_PATTERN);
    }


}
