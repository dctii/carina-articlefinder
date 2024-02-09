package com.solvd.carina.articlefinder.web.components.generic;

import com.solvd.carina.articlefinder.util.AttributeUtils;
import com.solvd.carina.articlefinder.util.BooleanUtils;
import com.solvd.carina.articlefinder.util.RegExpConstants;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anchor extends ExtendedWebElement {
    public Anchor(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getHref() {
        return AttributeUtils.getHrefString(this);
    }

    public String getHref(String baseUrl) {
        return AttributeUtils.getHrefString(this);
    }

    public URL getHrefAsURL() {
        return AttributeUtils.getHrefAsUrl(this);
    }

    public Integer getTabIndex() {
        return AttributeUtils.getTabIndex(this);
    }

    public String getRel() {
        return AttributeUtils.getRelString(this);
    }

    public List<String> getRelationshipsListToLinked() {
        String relValueString = getRel();
        List<String> relValues;
        if (BooleanUtils.isBlankString(relValueString)) {
            relValues = Arrays.asList(
                    relValueString.split(RegExpConstants.WHITESPACE)
            );
        } else {
            relValues = Collections.emptyList();
        }
        return relValues;
    }

    public List<String> getRelListToLinked() {
        return getRelationshipsListToLinked();
    }

    public boolean willOpenInNewTabOrWindow() {
        final String TARGET_ATTR_BLANK_VALUE = "_blank";
        return AttributeUtils.getTargetString(this).equals(TARGET_ATTR_BLANK_VALUE);
    }
}
