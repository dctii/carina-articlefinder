package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class AttributeConstants {
    private static final Logger LOGGER = LogManager.getLogger(AttributeConstants.class);

    private AttributeConstants() {
    }

    public final static String CLASS = "class";
    public final static String STYLE = "style";

    public final static String VALUE = "value";
    public final static String PLACEHOLDER = "placeholder";
    public final static String TYPE = "type";
    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String WIDTH = "width";
    public final static String HEIGHT = "height";
    public final static String METHOD = "method";
    public final static String TITLE = "title";
    public final static String SRC = "src";
    public final static String HREF = "href";

    public final static String TAB_INDEX = "tabindex";
    public final static String TABINDEX = TAB_INDEX;
    public final static String TARGET = "target";
    public final static String RELATIONSHIP = "rel";
    public final static String REL = RELATIONSHIP;
    public final static String DATA_PREFIX = "data-";
    public final static String DATA_TESTID = DATA_PREFIX + "testid";
    public final static String DATA_NAVID = DATA_PREFIX + "navid";
    public final static String DATA_PROVIDER = DATA_PREFIX + "provider";
    public final static String ARIA_PREFIX = "aria-";
    public final static String ARIA_LABEL = ARIA_PREFIX + "label";
    public final static String ARIA_HIDDEN = ARIA_PREFIX + "hidden";
    public final static String ARIA_EXPANDED = ARIA_PREFIX + "expanded";


}
