package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.elements.interfaces.IPolytypeElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Anchor
        extends AbstractGlobalElement
        implements IPolytypeElement {
    private static final Logger LOGGER = LogManager.getLogger(Anchor.class);

    public Anchor(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public String getHref() {
        return this.getAttribute(AttributeConstants.HREF);
    }

    public List<String> getRelValues() {
        return ElementUtils.getAttributeValuesAsList(
                this,
                AttributeConstants.REL
        );
    }

    public boolean willOpenInNewTabOrWindow() {
        final String TARGET_ATTR_BLANK_VALUE = "_blank";
        return this
                .getAttribute(AttributeConstants.TARGET)
                .equals(TARGET_ATTR_BLANK_VALUE);
    }

    @Override
    public String getType() {
        return this.getAttribute(AttributeConstants.TYPE);
    }

}
