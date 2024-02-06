package com.solvd.carina.articlefinder.util;

import com.solvd.carina.articlefinder.bin.ArticleSearchResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BooleanUtils {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.BOOLEAN_UTILS);

    /*
        Abstract checkers
    */
    public static boolean isEmptyOrNullArray(Object[] array) {
        return array == null
                || array.length == 0
                || Arrays.stream(array).allMatch(Objects::isNull);
    }

    public static boolean isNotEmptyOrNullArray(Object[] array) {
        return !isEmptyOrNullArray(array);
    }

    public static boolean isEmptyOrNullMap(Map<?, ?> map) {
        return map == null
                || map.isEmpty();
    }

    public static boolean isNotEmptyOrNullMap(Map<?, ?> map) {
        return !isEmptyOrNullMap(map);
    }

    public static boolean isEmptyOrNullCollection(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmptyOrNullCollection(Collection<?> collection) {
        return !isEmptyOrNullCollection(collection);
    }

    public static <T> boolean anyMatchInArray(T[] array, Predicate<T> predicate) {
        return Arrays.stream(array).anyMatch(predicate);
    }

    public static <T> boolean allMatchInArray(T[] array, Predicate<T> predicate) {
        return Arrays.stream(array).allMatch(predicate);
    }

    public static <T> boolean areEqual(T object1, T object2) {
        return Objects.equals(object1, object2);
    }

    public static boolean areCoordinatesWithinRange(
            Double[] coordinates,
            Double[] coordinatesRange
    ) {
        if (coordinatesRange.length % 2 != 0) {
            throw new IllegalArgumentException("coordinatesRange array must have an even length");
        }

        if (coordinates.length * 2 != coordinatesRange.length) {
            throw new IllegalArgumentException("coordinates array length must be half of coordinatesRange array length");
        }

        return allMatchInArray(coordinates, value -> {
            int i = Arrays.asList(coordinates).indexOf(value);
            double min = Math.min(coordinatesRange[i], coordinatesRange[i + 1]);
            double max = Math.max(coordinatesRange[i], coordinatesRange[i + 1]);
            return value >= min && value <= max;
        });
    }

    public static <K, V> boolean containsKeyWithPredicate(Map<K, V> map, K key) {
        return map != null && map.containsKey(key);
    }

    public static boolean isBlankString(String string) {
        return StringUtils.isBlank(string);
    }

    public static boolean isNotBlankString(String string) {
        return !isBlankString(string);
    }

    public static boolean areAnyStringsBlank(String... strings) {
        return anyMatchInArray(strings, BooleanUtils::isBlankString);
    }

    /*
        Specific checkers
    */

    public static boolean isSameDate(LocalDate comparans, LocalDate comparandum) {
        return areEqual(comparans, comparandum);
    }

    public static boolean isSameDate(ZonedDateTime comparans, ZonedDateTime comparandum) {
        return areEqual(comparans, comparandum);
    }


    public static boolean isDoubleNaN(double value) {
        return Double.isNaN(value);
    }

    public static boolean areDoublesNan(Double... values) {
        return allMatchInArray(values, BooleanUtils::isDoubleNaN);
    }


    private BooleanUtils() {
        ExceptionUtils.preventUtilityInstantiation();
    }

    public static boolean isISO8601DateValid(String date) {
        try {
            // Parse the date to check if it's in valid ISO 8601 format
            OffsetDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isZonedDateTimeValid(String date) {
        try {
            ZonedDateTime.parse(date);
            ZonedDateTime zdt = ZonedDateTime.now();

            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isNotOlderDateTime(LocalDateTime date1, LocalDateTime date2) {
        return isNewerDateTime(date1, date2) || isSameDateTime(date1, date2);
    }

    public static boolean isNotOlderDateTime(String date1String, String date2String, DateTimeFormatter formatter) {
        LocalDateTime date1 = LocalDateTime.parse(date1String, formatter);
        LocalDateTime date2 = LocalDateTime.parse(date2String, formatter);
        return isNewerDateTime(date1, date2) || isSameDateTime(date1, date2);
    }


    public static boolean isNotNewerDateTime(LocalDateTime date1, LocalDateTime date2) {
        return isOlderDateTime(date1, date2) || isSameDateTime(date1, date2);
    }

    public static boolean isNewerDateTime(LocalDateTime date1, LocalDateTime date2) {
        return date1.isAfter(date2);
    }

    public static boolean isOlderDateTime(LocalDateTime date1, LocalDateTime date2) {
        return date1.isBefore(date2);
    }

    public static boolean isSameDateTime(LocalDateTime date1, LocalDateTime date2) {
        return date1.isEqual(date2);
    }

    public static boolean isNotOlderDateTime(ZonedDateTime date1, ZonedDateTime date2) {
        return isNewerDateTime(date1, date2) || isSameDateTime(date1, date2);
    }

    public static boolean isNotNewerDateTime(ZonedDateTime date1, ZonedDateTime date2) {
        return isOlderDateTime(date1, date2) || isSameDateTime(date1, date2);
    }

    public static boolean isNewerDateTime(ZonedDateTime date1, ZonedDateTime date2) {
        return date1.isAfter(date2);
    }

    public static boolean isOlderDateTime(ZonedDateTime date1, ZonedDateTime date2) {
        return date1.isBefore(date2);
    }

    public static boolean isSameDateTime(ZonedDateTime date1, ZonedDateTime date2) {
        return date1.isEqual(date2);
    }

    public static boolean allArticlesHaveMainHeadline(String headline, ArticleSearchResponse response) {
        boolean articlesFound = response.getResponse().getDocs().stream()
                .allMatch(
                        article ->
                                headline.replace(
                                        StringConstants.ESCAPED_DOUBLE_QUOTATION,
                                        StringConstants.EMPTY_STRING
                                ).equals(article.getHeadline().getMain())
                );
        return articlesFound;
    }
}
