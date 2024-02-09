package com.solvd.carina.articlefinder.util;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class AttributeUtils {
    private static final Logger LOGGER = LogManager.getLogger(AttributeUtils.class);

    private AttributeUtils() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    public static boolean doesAttributeExist(ExtendedWebElement element, String attributeName) {
        return element.getAttribute(attributeName) != null;
    }

    public static String getValueString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.VALUE);
    }

    public static String getPlaceholderString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.PLACEHOLDER);
    }

    public static String getTypeString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.TYPE);
    }

    public static String getIdString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.ID);
    }

    public static String getNameString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.NAME);
    }

    public static String getWidthString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.WIDTH);
    }

    public static Integer getWidth(ExtendedWebElement element) {
        return Integer.parseInt(getWidthString(element));
    }

    public static String getHeightString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.HEIGHT);
    }

    public static Integer getHeight(ExtendedWebElement element) {
        return Integer.parseInt(getHeightString(element));
    }

    public static String getFormMethodString(ExtendedWebElement element) {
        String formMethodString = null;
        if (element.getTagName().equals(TagConstants.FORM)) {
            formMethodString = element.getAttribute(AttributeConstants.METHOD);
        } else {
            LOGGER.warn("Element is not a '<form>' type. Will not get 'method' attribute. ");
        }
        return formMethodString;
    }

    public static String getDataTestIdString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.DATA_TESTID);
    }

    public static String getDataNavIdString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.DATA_NAVID);
    }

    public static String getDataProviderString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.DATA_PROVIDER);
    }

    public static Integer getTabIndex(ExtendedWebElement element) {
        String tabIndexValueString = element.getAttribute(AttributeConstants.TABINDEX);
        return Integer.parseInt(tabIndexValueString);
    }

    public static String getTitleAttributeString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.TITLE);
    }

    public static String getAriaLabelString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.ARIA_LABEL);
    }

    public static String getAriaHiddenString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.ARIA_HIDDEN);
    }

    public static String getAriaExpandedString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.ARIA_EXPANDED);
    }

    public static Boolean getAriaExpandedBoolean(ExtendedWebElement element) {
        return Boolean.parseBoolean(getAriaExpandedString(element));
    }

    public static boolean isAriaExpanded(ExtendedWebElement element) {
        return getAriaExpandedBoolean(element);
    }

    public static boolean isAriaNotExpanded(ExtendedWebElement element) {
        return !getAriaExpandedBoolean(element);
    }


    public static String getSrcString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.SRC);
    }

    public static URL getSrcAsUrl(ExtendedWebElement element) {
        return toUrl(getSrcString(element));
    }

    public static String getHrefString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.HREF);
    }

    public static URL getHrefAsUrl(ExtendedWebElement element) {
        return toUrl(getHrefString(element));
    }

    public static URL toUrl(String urlString) {
        URL newUrl = null;
        try {
            newUrl = new URL(urlString);
        } catch (MalformedURLException e) {
            LOGGER.warn("The URL from the the url string is malformed. Unable to convert to URL type.");
        }
        return newUrl;
    }

    public static String getTargetString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.TARGET);
    }

    public static String getRelString(ExtendedWebElement element) {
        return element.getAttribute(AttributeConstants.REL);
    }

}
