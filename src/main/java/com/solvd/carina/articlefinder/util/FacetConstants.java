package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class FacetConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.FACET_CONSTANTS);
    private FacetConstants() {
        ExceptionUtils.preventUtilityInstantiation();
    }

    public static final String DAY_OF_WEEK = "day_of_week";
    public static final String DOCUMENT_TYPE = "document_type";
    public static final String INGREDIENTS = "ingredients";
    public static final String NEWS_DESK = "news_desk";
    public static final String PUB_MONTH = "pub_month";
    public static final String PUB_YEAR = "pub_year";
    public static final String SECTION_NAME = "section_name";
    public static final String SOURCE = "source";
    public static final String SUBSECTION_NAME = "subsection_name";
    public static final String TYPE_OF_MATERIAL = "type_of_material";
}
