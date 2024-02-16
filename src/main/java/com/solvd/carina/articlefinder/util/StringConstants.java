package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class StringConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.STRING_CONSTANTS);
    public static final char LOWER_CASE_M_CHAR = 'm';
    public static final char UPPER_CASE_V_CHAR = 'V';
    public static final String EMPTY_STRING = "";
    public static final String SINGLE_WHITESPACE = " ";
    public static final String DOUBLE_WHITESPACE = SINGLE_WHITESPACE + SINGLE_WHITESPACE;
    public static final String SINGLE_QUOTATION = "'";
    public static final String ESCAPED_DOUBLE_QUOTATION = "\"";
    public static final String FULL_STOP = ".";
    public static final String AMPERSAND = "&";
    public static final String OPENING_BRACKET = "[";
    public static final String CLOSING_BRACKET = "]";
    public static final String BACKTICK = "`";
    public static final String OPENING_CURLY_BRACE = "{";
    public static final String CLOSING_CURLY_BRACE = "}";
    public static final String OPENING_PARENTHESIS = "(";
    public static final String CLOSING_PARENTHESIS = ")";
    public static final String PLUS_SIGN = "+";
    public static final String ASTERISK_SIGN = "*";
    public static final String ESCAPE_SEQUENCE = "\033";
    public static final String CARRIAGE_RETURN = "\r";
    public static final String NEWLINE = "\n";
    public static final String LOWER_CASE_TRUE = "true";
    public static final String LOWER_CASE_FALSE = "false";
    public static final String EQUALS_OPERATOR = "=";
    public static final String PADDED_EQUALS_OPERATOR = StringFormatters.nestInChars(
            SINGLE_WHITESPACE,
            SINGLE_WHITESPACE,
            EQUALS_OPERATOR
    );
    public static final String COMMA = ",";
    public static final String COMMA_DELIMITER = COMMA + SINGLE_WHITESPACE;
    public static final String COLON = ":";
    public static final String COLON_DELIMITER = COLON + SINGLE_WHITESPACE;
    public static final String NULL_STRING = "null";
    public static final String ADD_STRING = "add";
    public static final String SUBTRACT_STRING = "subtract";
    public static final String MULTIPLY_STRING = "multiply";
    public static final String DIVIDE_STRING = "divide";
    public static final String DASH_STRING = "-";
    public static final String AT_SIGN = "@";
    public static final String QUESTION_MARK = "?";
    public static final String SOLIDUS = "/";
    public static final String INF = "INF";
    public static final String DECIMAL_FORMAT_OF_SCALE_2 = "%.2f";
    public static final String YEAR_FIRST_DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIMESTAMP_PATTERN = YEAR_FIRST_DATE_PATTERN + SINGLE_WHITESPACE + "HH:mm:ss";
    public static final String NY_TIMES_PUB_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssX";

    public static final String DOTW_MONTH_D_YYYY_DATE_PATTERN = "EEEE, MMMM d, yyyy";
    public static final String MONTH_D_YYYY_DATE_PATTERN = "MMMM d, yyyy";
    public static final String MONTH_ABBREV_D_YYYY_DATE_PATTERN = "MMM. d, yyyy";


    private StringConstants() {
        ExceptionUtils.preventConstantsInstantiation();
    }
}
