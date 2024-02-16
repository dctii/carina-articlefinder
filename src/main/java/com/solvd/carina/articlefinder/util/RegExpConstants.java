package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegExpConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.REG_EXP_CONSTANTS);
    public static final String LOWERCASE_Y_OR_N = "[yn]";
    public static final String DECIMAL_WITH_SCALE_OF_0_OR_2 = "\\d+(\\.\\d{1,2})?";

    public static final String YYYYMMDD_DATE_FORMAT = "^\\d{8}$";

    public static final String YEAR = ".*\\d{4}";

    public static final String NUMBERS_WITH_COMMAS = "(\\d+[\\,\\d+]*)";

    public static final String WHITESPACE = "\\s+";
    public static final String COMMA_AND_MAYBE_POST_WHITESPACE = ",\\s*";
    public static final String SEMICOLON_AND_MAYBE_POST_WHITESPACE = ";\\s*";


    private RegExpConstants() {
        ExceptionUtils.preventConstantsInstantiation();
    }
}
