package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ArticleSearchResponseConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.ARTICLE_SEARCH_RESPONSE_CONSTANTS);

    private ArticleSearchResponseConstants() {
        ExceptionUtils.preventUtilityInstantiation();
    }

    public final static String NO_API_KEY_PARAM_FAULTSTRING =
            "Failed to resolve API Key variable request.queryparam.api-key";
    public final static String NO_API_KEY_PARAM_DETAIL_ERRORCODE =
            "steps.oauth.v2.FailedToResolveAPIKey";

    public final static String EMPTY_API_KEY_VALUE_FAULTSTRING =
            "Invalid ApiKey";
    public final static String EMPTY_API_KEY_VALUE_DETAIL_ERRORCODE =
            "oauth.v2.InvalidApiKey";

    public final static String API_CALL_LIMIT_MET_VALUE_FAULTSTRING_PREFIX =
            "Rate limit quota violation. Quota limit exceeded. Identifier :";
    public final static String API_CALL_LIMIT_MET_VALUE_DETAIL_ERRORCODE =
            "policies.ratelimit.QuotaViolation";

    public final static String COPYRIGHT_STRING =
            "Copyright (c) 2024 The New York Times Company. All Rights Reserved.";

    public final static String STATUS_OK = "OK";

    public final static String STATUS_ERROR = "ERROR";
}
