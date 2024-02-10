package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.BooleanUtils;
import com.solvd.carina.articlefinder.util.RegExpConstants;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anchor extends ExtendedWebElement {
    private static final Logger LOGGER = LogManager.getLogger(Anchor.class);

    public Anchor(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getHref() {
        return this.getAttribute(AttributeConstants.HREF);
    }

    public Integer getTabIndex() {
        String tabIndexValueString = this.getAttribute(AttributeConstants.TABINDEX);
        return Integer.parseInt(tabIndexValueString);
    }

    public String getRel() {
        return this.getAttribute(AttributeConstants.REL);
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
        return this.getRelationshipsListToLinked();
    }

    public boolean willOpenInNewTabOrWindow() {
        final String TARGET_ATTR_BLANK_VALUE = "_blank";
        return this
                .getAttribute(AttributeConstants.TARGET)
                .equals(TARGET_ATTR_BLANK_VALUE);
    }
}
