package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConfigConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.CONFIG_CONSTANTS);

    public static final String CONFIG_PROPS_FILE_NAME = FilepathConstants.CONFIG_PROPERTIES;
    public static final String NYT_API_KEY_KEY = "nyt_api_key";
    public static final String NYT_SECRET_KEY = "nyt_secret";
    public static final String NYT_API_URL_KEY = "nyt_api_url";
    public static final String NYT_API_ARTICLE_SEARCH_PATH_KEY = "nyt_api_article_search_path";

    public static final String NYT_HOME_URL_KEY = "nytimes_home_url";
    public static final String NYT_URL_KEY = "nytimes_url";
    public static final String NYT_USER_EMAIL_KEY = "nytimes_user_email";
    public static final String NYT_USER_PW_KEY = "nytimes_user_pw";
    public static final String BROWSER_KEY = "browser";
    public static final String SELENIUM_URL = "selenium_url";
    public static final String ADIDAS_SNEAKERS_LISTING_PAGE_URL_KEY = "adidas_sneakers_lp_url";


    private ConfigConstants() {
        ExceptionUtils.preventConstantsInstantiation();
    }
}
