package com.solvd.carina.articlefinder.util;

import com.solvd.carina.articlefinder.web.elements.AbstractGlobalElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ElementUtils {
    private static final Logger LOGGER = LogManager.getLogger(ElementUtils.class);

    private ElementUtils() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    public static boolean isListElementWithTextPresent(
            List<? extends ExtendedWebElement> elementsList,
            String elementText
    ) {
        return elementsList.stream()
                .filter(element ->
                        element.getText().equalsIgnoreCase(elementText)
                )
                .findFirst()
                .map(ExtendedWebElement::isPresent)
                .orElse(false);
    }

    public static boolean isListElementByIdPresent(
            List<? extends AbstractGlobalElement> elementsList,
            String elementIdString
    ) {
        return elementsList.stream()
                .filter(element ->
                        element.getIdAttrValueString().equalsIgnoreCase(elementIdString)
                )
                .findFirst()
                .map(AbstractGlobalElement::isPresent)
                .orElse(false);
    }


    public static void clickListElementWithText(
            List<? extends ExtendedWebElement> elementsList,
            String elementText
    ) {
        elementsList.stream()
                .filter(element -> element.getText().equals(elementText))
                .findFirst()
                .ifPresent(ExtendedWebElement::click);
    }

    public static List<String> getAttributeValuesAsList(
            ExtendedWebElement element,
            String attributeName
    ) {
        String attributeValueString = element.getAttribute(attributeName);
        if (StringUtils.isBlank(attributeValueString)) {
            return Arrays.asList(attributeValueString.split(RegExpConstants.WHITESPACE));
        } else {
            return Collections.emptyList();
        }
    }

    public static List<String> getClassValuesAsList(
            ExtendedWebElement element
    ) {
        String attributeValueString = element.getAttribute(AttributeConstants.CLASS);

        List<String> attrValueList = new ArrayList<>();

        if (StringUtils.isNotBlank(attributeValueString)) {
            attrValueList = Arrays.asList(attributeValueString.split(RegExpConstants.WHITESPACE));
        } else {
            attrValueList = Collections.emptyList();
        }

        return attrValueList;
    }

    public static List<String> getElementsTextsAsList(
            List<? extends ExtendedWebElement> elementsList
    ) {
        return elementsList.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    public static List<String> getAttributeValuesAsList(
            ExtendedWebElement element,
            String attributeName,
            String delimiterRegExpPattern
    ) {
        String attributeValueString = element.getAttribute(attributeName);
        if (StringUtils.isBlank(attributeValueString)) {
            return Arrays.asList(attributeValueString.split(delimiterRegExpPattern));
        } else {
            return Collections.emptyList();
        }
    }


    public static void clickIfEnabled(ExtendedWebElement element) {
        if (element.getElement().isEnabled()) {
            element.click();
        } else {

            LOGGER.warn(
                    "The '<{}>' element is not enabled and cannot be clicked.",
                    element.getTagName()
            );
        }
    }

    public static boolean isAttributePresent(ExtendedWebElement element, String attributeName) {
        boolean hasAttribute = false;
        String attrString = element.getAttribute(attributeName);

        if (StringUtils.isNotBlank(attrString)) {
            hasAttribute = true;
        }

        return hasAttribute;
    }

    public static boolean isAttributeTrueOrTrueSinceEmptyString(ExtendedWebElement element,
                                                                String attributeName) {
        boolean isTrue = false;
        String attrString = element.getAttribute(attributeName);

        if (
                attrString != null
                        && (
                        attrString.equals(StringConstants.LOWER_CASE_TRUE)
                                || attrString.equals(StringConstants.EMPTY_STRING)
                )
        ) {
            isTrue = true;
        }

        return isTrue;
    }

    public static boolean isAttributeTrue(ExtendedWebElement element,
                                          String attributeName) {
        boolean isTrue = false;
        String attrString = element.getAttribute(attributeName);

        if (
                attrString != null
                        && attrString.equals(StringConstants.LOWER_CASE_TRUE)
        ) {
            isTrue = true;
        }

        return isTrue;
    }

    public static Integer getIntFromAttrValueString(ExtendedWebElement element, String attributeName) {
        String attrValueString = element.getAttribute(attributeName);
        Integer attrIntValue = null;

        if (StringUtils.isNotBlank(attrValueString)) {
            attrIntValue = Integer.parseInt(attrValueString);
        }

        return attrIntValue;
    }

    public static Float getFloatFromAttrValueString(
            ExtendedWebElement element,
            String attributeName
    ) {
        String attrValueString = element.getAttribute(attributeName);
        Float attrFloatValue = null;

        if (StringUtils.isNotBlank(attrValueString)) {
            attrFloatValue = Float.parseFloat(attrValueString);
        }

        return attrFloatValue;
    }

    public static Boolean getBooleanFromAttrValueString(ExtendedWebElement element, String attributeName) {
        String attrValueString = element.getAttribute(attributeName);
        boolean attrBooleanValue = false;

        if (StringUtils.isNotBlank(attrValueString)) {
            attrBooleanValue = Boolean.parseBoolean(attrValueString);
        }

        return attrBooleanValue;
    }


}
