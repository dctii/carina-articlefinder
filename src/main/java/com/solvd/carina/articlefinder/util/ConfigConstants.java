package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConfigConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.CONFIG_CONSTANTS);

    public static final String CONFIG_PROPS_FILE_NAME = FilepathConstants.CONFIG_PROPERTIES;
    public static final String NYT_API_URL_KEY = "nyt_api_url";
    public static final String NYT_API_KEY_KEY = "nyt_api_key";
    public static final String NYT_SECRET_KEY = "nyt_secret";


    private ConfigConstants() {
        ExceptionUtils.preventConstantsInstantiation();
    }
}
