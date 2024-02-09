package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {

    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.NUMBER_UTILS);

    public static int roundToInt(Number number) {
        if (number instanceof Float) {
            return Math.round((float) number);
        } else if (number instanceof Double) {
            return (int) Math.round((double) number);
        } else if (number instanceof BigDecimal) {
            /*
                "Java BigDecimal: Round to the nearest whole value"
                https://stackoverflow.com/questions/4134047/java-bigdecimal-round-to-the-nearest-whole-value
            */
            return ((BigDecimal) number)
                    .setScale(0, RoundingMode.HALF_UP)
                    .setScale(2, RoundingMode.HALF_UP)
                    .intValue();
        } else if (number instanceof Integer) {
            return number.intValue();
        } else {
            throw new IllegalArgumentException("Number type not supported");
        }
    }

    public static double roundToScale(double number, int scale) {
        BigDecimal bd = BigDecimal.valueOf(number);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double roundToScale(int number, int scale) {
        BigDecimal bd = BigDecimal.valueOf(number);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double parseDoubleOrNaN(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    public static int parseNestedIntSubstring(String text, String leftBoundaryMarker, String rightBoundaryMarker) {
        int nestedInt = 0;

        // extract a number, even if it has commas in it
        Pattern pattern = Pattern.compile(leftBoundaryMarker + RegExpConstants.NUMBERS_WITH_COMMAS + rightBoundaryMarker);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            // remove the comma
            String number = matcher.group(1).replace(",", "");
            nestedInt = Integer.parseInt(number);
        } else {
            LOGGER.warn("No match found for the first integer in the string: {}; Returning '0'", text);
        }
        return nestedInt;
    }


    private NumberUtils() {
        ExceptionUtils.preventUtilityInstantiation();
    }
}
