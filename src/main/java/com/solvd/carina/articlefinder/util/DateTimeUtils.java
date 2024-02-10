package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class DateTimeUtils {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.DATE_TIME_UTILS);

    private DateTimeUtils() {
        ExceptionUtils.preventUtilityInstantiation();
    }

    public static DateTimeFormatter createDateTimeFormatterFromPattern(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    public static DateTimeFormatter createDateTimeFormatterFromPattern(
            String pattern,
            Locale locale
    ) {
        return DateTimeFormatter.ofPattern(pattern, locale);
    }

    public static DateTimeFormatter getNyTimesFormatter() {
        return createDateTimeFormatterFromPattern(StringConstants.NY_TIMES_PUB_DATE_PATTERN);
    }

    public static DateTimeFormatter getFullMonthFormatter() {
        return createDateTimeFormatterFromPattern(StringConstants.MONTH_D_YYYY_DATE_PATTERN,
                Locale.ENGLISH
        );
    }

    public static DateTimeFormatter getAbbrMonthFormatter() {
        return createDateTimeFormatterFromPattern(StringConstants.MONTH_ABBREV_D_YYYY_DATE_PATTERN,
                Locale.ENGLISH
        );
    }

    public static LocalDate pubDateToLocalDate(String pubDate) {
        LocalDate pubLocalDate;

        // Check if the year is included in the publication date
        if (!pubDate.matches(RegExpConstants.YEAR)) {
            // if year is not present, append the current year to the publication date string
            // e.g., if "Feb. 6", then append ", 2024" given that "2024" is the current year
            pubDate += StringConstants.COMMA_DELIMITER + LocalDate.now().getYear();
        }
        try {
            // try to parse the date with the full month name first
            pubLocalDate = LocalDate.parse(pubDate, getFullMonthFormatter());
        } catch (DateTimeParseException e) {
            // if fails, try parsing with the abbreviated month name
            pubLocalDate = LocalDate.parse(pubDate, getAbbrMonthFormatter());
        }

        return pubLocalDate;
    }

    public static boolean areDatesSortedByNewest(List<LocalDate> dates) {
        return IntStream.range(0, dates.size() - 1)
                .noneMatch(i -> dates.get(i).isBefore(dates.get(i + 1)));
    }

    public boolean areDatesSortedByOldest(List<LocalDate> dates) {
        return IntStream.range(0, dates.size() - 1)
                .noneMatch(i -> dates.get(i).isAfter(dates.get(i + 1)));
    }


}
