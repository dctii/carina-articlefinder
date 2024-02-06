package com.solvd.carina.articlefinder.api;

import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.util.FilepathConstants;
import com.solvd.carina.articlefinder.util.QueryStringUtils;
import com.solvd.carina.articlefinder.util.StringConstants;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Endpoint(
        url = "${config.nyt_api_url}/${config.nyt_api_article_search_path}"
                + "?${queryString}"
                + "${apiKeyValue}",
        methodType = HttpMethodType.GET
)
@ResponseTemplatePath(path = FilepathConstants.ARTICLE_SEARCH_RS_TEMPLATE_JSON)
public class ArticleSearch extends AbstractApiMethodV2 {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.ARTICLE_SEARCH);

    private static final String QUERY_STRING_PLACEHOLDER_KEY = "queryString";

    private static final String API_KEY_VALUE_PLACEHOLDER_KEY = "apiKeyValue";
    private static final String API_KEY_VALUE = Configuration.getRequired(ConfigConstants.NYT_API_KEY_KEY);

    public ArticleSearch(String queryString, String apiKeyValue) {
        replaceUrlPlaceholder(QUERY_STRING_PLACEHOLDER_KEY, queryString);
        replaceUrlPlaceholder(
                API_KEY_VALUE_PLACEHOLDER_KEY,
                apiKeyValue != null
                        ? QueryStringUtils.createApiKeyParamString(apiKeyValue)
                        : StringConstants.EMPTY_STRING
        );

        ignorePropertiesProcessor(ClassConstants.NOT_STRING_VALUES_PROCESSOR);
    }

    public ArticleSearch(String queryString) {
        this(
                queryString,
                API_KEY_VALUE
        );
    }


}
