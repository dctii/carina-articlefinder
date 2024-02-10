package com.solvd.carina.articlefinder.testutil;

import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.util.QueryParametersConstants;
import com.solvd.carina.articlefinder.util.StringConstants;
import com.zebrunner.carina.utils.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class WebTestConstants {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.WEB_TEST_CONSTANTS);
    public WebTestConstants() {
    }

    public static final String EXPECTED_HOME_PAGE_TITLE =
            "The New York Times - Breaking News, US News, World News and Videos";

    public static final String HOME_URL_STRING =
            Configuration.getRequired(ConfigConstants.NYT_HOME_URL_KEY) + StringConstants.SOLIDUS;

    public static final String URL_SEARCH_RESULTS_PAGE_URL = HOME_URL_STRING + "search?";
    // QS = query string
    public static final String URL_QS_QUERY_PARAM = "query=";
    public static final String URL_QS_DROPMAB_PARAM = "dropmab=";
    public static final String URL_QS_SORT_PARAM =
            QueryParametersConstants.SORT + StringConstants.EQUALS_OPERATOR;
    public static final String URL_QS_SORT_IS_NEWEST_PARAM =
            URL_QS_SORT_PARAM + QueryParametersConstants.ALLOWED_SORT_VALUES.get(0);
    public static final String URL_QS_SORT_IS_OLDEST_PARAM =
            URL_QS_SORT_PARAM + QueryParametersConstants.ALLOWED_SORT_VALUES.get(1);
    public static final String URL_QS_SORT_IS_RELEVANCE_PARAM =
            URL_QS_SORT_PARAM + QueryParametersConstants.ALLOWED_SORT_VALUES.get(2);

    // TODO: add for Date Range, Section, and Type later

    public static final String EXPECTED_USER_SETTINGS_BUTTON_TEXT = "Account";
    public static final String EXPECTED_EMAIL_ERROR_MSG = "Please enter a valid email address.";
    public static final String EXPECTED_INVALID_LOGIN_ERROR_MSG = "The email address or password you entered is incorrect. Please try again.";
    public static final String EXPECTED_INVALID_PASSWORD_LENGTH_REGISTRATION_MESSAGE =
            "Please provide a password that is at least 6 characters.";
}
