package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XpathUtils {
    private static final Logger LOGGER = LogManager.getLogger(XpathUtils.class);

    private XpathUtils() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    public static String evalTextAsCaseInsensitive(String xpathExpression) {
        if (BooleanUtils.isBlankString(xpathExpression)) {
            return xpathExpression;
        }

        final String UPPER_CASE_BEFORE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String LOWER_CASE_AFTER = "abcdefghijklmnopqrstuvwxyz";
        final String TEXT_FUNCTION = "text()";

        // extract the text to be compared
        String textToCompare =
                xpathExpression.substring(
                                xpathExpression.indexOf(StringConstants.SINGLE_QUOTATION) + 1,
                                xpathExpression.lastIndexOf(StringConstants.SINGLE_QUOTATION)
                        )
                        .toLowerCase();

        // build
        return String.format(
                "translate(%s, '%s', '%s') = '%s'",
                TEXT_FUNCTION, UPPER_CASE_BEFORE, LOWER_CASE_AFTER, textToCompare
        );
    }
}
