package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.web.elements.interfaces.IFormElementAssociate;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Label
        extends AbstractGlobalElement
        implements IFormElementAssociate {

    public Label(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getFor() {
        return this.getAttribute(AttributeConstants.FOR);
    }

    @Override
    public String getFormAttrValueString() {
        return this.getAttribute(AttributeConstants.FORM);
    }
}
