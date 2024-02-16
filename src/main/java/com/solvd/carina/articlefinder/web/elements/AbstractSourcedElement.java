package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSourcedElement extends AbstractGlobalElement{

    public AbstractSourcedElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getSrc() {
        return this.getAttribute(AttributeConstants.SRC);
    }
}
