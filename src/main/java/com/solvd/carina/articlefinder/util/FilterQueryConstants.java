package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class FilterQueryConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.FILTER_QUERY_CONSTANTS);

    private FilterQueryConstants() {
        ExceptionUtils.preventUtilityInstantiation();
    }

    public static final String SEARCH_SUFFIX = ".search";
    public static final String CONTAINS_SUFFIX = ".contains";
    public static final String BODY = "body";
    public static final String BODY_SEARCH = BODY + SEARCH_SUFFIX;
    public static final String CREATIVE_WORKS = "creative_works";
    public static final String CREATIVE_WORKS_CONTAINS = CREATIVE_WORKS + CONTAINS_SUFFIX;
    public static final String DAY_OF_WEEK = "day_of_week";
    public static final String DOCUMENT_TYPE = "document_type";
    public static final String GLOCATIONS = "glocations";
    public static final String GLOCATIONS_CONTAINS = GLOCATIONS + CONTAINS_SUFFIX;
    public static final String HEADLINE = "headline";
    public static final String HEADLINE_SEARCH = HEADLINE + SEARCH_SUFFIX;
    public static final String KICKER = "kicker";
    public static final String KICKER_CONTAINS = KICKER + CONTAINS_SUFFIX;
    public static final String NEWS_DESK = "news_desk";
    public static final String NEWS_DESK_CONTAINS = NEWS_DESK + CONTAINS_SUFFIX;
    public static final String ORGANIZATIONS = "organizations";
    public static final String ORGANIZATIONS_CONTAINS = ORGANIZATIONS + CONTAINS_SUFFIX;
    public static final String PERSONS = "persons";
    public static final String PERSONS_CONTAINS = PERSONS + CONTAINS_SUFFIX;
    public static final String PUB_DATE = "pub_date";
    public static final String PUB_YEAR = "pub_year";
    public static final String SECPG = "secpg";
    public static final String SOURCE = "source";
    public static final String SOURCE_CONTAINS = SOURCE + CONTAINS_SUFFIX;
    public static final String SUBJECT = "subject";
    public static final String SUBJECT_CONTAINS = SUBJECT + CONTAINS_SUFFIX;
    public static final String SECTION_NAME = "section_name";
    public static final String SECTION_NAME_CONTAINS = SECTION_NAME + CONTAINS_SUFFIX;
    public static final String TYPE_OF_MATERIAL = "type_of_material";
    public static final String TYPE_OF_MATERIAL_CONTAINS = TYPE_OF_MATERIAL + CONTAINS_SUFFIX;
    public static final String WEB_URL = "web_url";
    public static final String WORD_COUNT = "word_count";
    public static final String AND_OPERATOR = StringFormatters.nestInChars(
            StringConstants.SINGLE_WHITESPACE, "AND"
    );

    public static final String OR_OPERATOR = StringFormatters.nestInChars(
            StringConstants.SINGLE_WHITESPACE, "OR"
    );
}
