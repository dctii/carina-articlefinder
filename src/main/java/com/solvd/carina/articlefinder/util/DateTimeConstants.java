package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class DateTimeConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.DATE_TIME_CONSTANTS);

    public DateTimeConstants() {
    }

    public final static ZoneId AMERICA_NEW_YORK_ZID = ZoneId.of("America/New_York");

    public final static DateTimeFormatter NYT_TODAY_DATE_FORMATTER = DateTimeFormatter.ofPattern(
            StringConstants.DOTW_MONTH_D_YYYY_DATE_PATTERN,
            Locale.ENGLISH
    );
}
