package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QueryStringUtils {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.QUERY_STRING_UTILS);

    private QueryStringUtils() {
        ExceptionUtils.preventUtilityInstantiation();
    }

    public static String createApiKeyParamString(String apiKeyValue) {
        return StringConstants.AMPERSAND + QueryParametersConstants.API_KEY
                + StringConstants.EQUALS_OPERATOR + apiKeyValue;
    }
}
