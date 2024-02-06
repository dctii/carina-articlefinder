package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class QueryParametersConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.QUERY_PARAMETERS_CONSTANTS);

    private QueryParametersConstants() {
    }

    public final static String BEGIN_DATE = "begin_date";
    public final static String BEGIN_DATE_MATCH_REGEXP = RegExpConstants.YYYYMMDD_DATE_FORMAT;
    public final static String END_DATE = "end_date";
    public final static String END_DATE_MATCH_REGEXP = RegExpConstants.YYYYMMDD_DATE_FORMAT;
    public final static String FACET = "facet";
    public final static List<String> ALLOWED_FACET_VALUES = List.of(
            "true",
            "false"
    );
    public final static QueryParameter FACET_TRUE = new QueryParameter(FACET, ALLOWED_FACET_VALUES.get(0));
    public final static QueryParameter FACET_FALSE = new QueryParameter(FACET, ALLOWED_FACET_VALUES.get(1));
    public final static String FACET_FIELDS = "facet_fields";
    public final static List<String> ALLOWED_FACET_FIELDS_VALUES = List.of(
            FacetConstants.DAY_OF_WEEK,
            FacetConstants.DOCUMENT_TYPE,
            FacetConstants.INGREDIENTS,
            FacetConstants.NEWS_DESK,
            FacetConstants.PUB_MONTH,
            FacetConstants.PUB_YEAR,
            FacetConstants.SECTION_NAME,
            FacetConstants.SOURCE,
            FacetConstants.SUBSECTION_NAME,
            FacetConstants.TYPE_OF_MATERIAL
    );
    public final static String FACET_FILTER = "facet_filter";


    public final static QueryParameter FACET_FILTER_TRUE = new QueryParameter(FACET_FILTER, "true");
    public final static QueryParameter FACET_FILTER_FALSE = new QueryParameter(FACET_FILTER, "false");
    public final static String FIELD_LIST = "fl";
    public final static String FILTER_QUERY = "fq";
    public final static String PAGE_NUMBER = "page";
    public final static String QUERY = "q";
    public final static String SORT = "sort";
    public final static List<String> ALLOWED_SORT_VALUES = List.of(
            "newest",
            "oldest",
            "relevance"
    );
    public final static QueryParameter SORT_NEWEST = new QueryParameter(SORT, ALLOWED_SORT_VALUES.get(0));
    public final static QueryParameter SORT_OLDEST = new QueryParameter(SORT, ALLOWED_SORT_VALUES.get(1));
    public final static QueryParameter SORT_RELEVANCE = new QueryParameter(SORT, ALLOWED_SORT_VALUES.get(2));

    public final static String API_KEY = "api-key";


}
