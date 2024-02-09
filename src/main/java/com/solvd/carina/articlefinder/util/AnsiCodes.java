package com.solvd.carina.articlefinder.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.pattern.AnsiEscape;

public final class AnsiCodes {

    private static final Logger LOGGER = LogManager.getLogger(com.solvd.carina.articlefinder.util.ClassConstants.ANSI_CODES);
    public static final String RED = toAnsiString(AnsiEscape.RED);
    public static final String MAGENTA = toAnsiString(AnsiEscape.MAGENTA);
    public static final String YELLOW = toAnsiString(AnsiEscape.YELLOW);
    public static final String GREEN = toAnsiString(AnsiEscape.GREEN);
    public static final String BLUE = toAnsiString(AnsiEscape.BLUE);
    public static final String BLACK = toAnsiString(AnsiEscape.BLACK);
    public static final String BOLD = toAnsiString(AnsiEscape.BOLD);
    public static final String BG_RED = toAnsiString(AnsiEscape.BG_RED);
    public static final String BG_BLUE = toAnsiString(AnsiEscape.BG_BLUE);
    public static final String BG_YELLOW = toAnsiString(AnsiEscape.BG_YELLOW);
    public static final String BG_GREEN = toAnsiString(AnsiEscape.BG_GREEN);
    public static final String BLACK_ON_YELLOW = BG_YELLOW + BLACK;
    public static final String BLUE_ON_YELLOW = BG_YELLOW + BLUE;
    public static final String RED_ON_YELLOW = BG_YELLOW + RED;
    public static final String RESET_ALL = toAnsiString(AnsiEscape.NORMAL);

    private static String toAnsiString(AnsiEscape STYLE) {
        return wrapAnsiStyleCode(STYLE.getCode());
    }

    /*
    Example output:
        wrapAnsiStyleCode("31") --> "\u001b[31m"
     */

    private static String wrapAnsiStyleCode(String STYLE_CODE) {
        return StringUtils.join(
                com.solvd.carina.articlefinder.util.StringConstants.ESCAPE_SEQUENCE,
                com.solvd.carina.articlefinder.util.StringConstants.OPENING_BRACKET,
                STYLE_CODE,
                com.solvd.carina.articlefinder.util.StringConstants.LOWER_CASE_M_CHAR
        );
    }

    private AnsiCodes() {
        com.solvd.carina.articlefinder.util.ExceptionUtils.preventUtilityInstantiation();
    }
}
