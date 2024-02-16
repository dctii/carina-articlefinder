package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.ElementUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class AbstractSizeableElement extends AbstractSourcedElement{

    public AbstractSizeableElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Integer getHeight() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.HEIGHT
        );
    }

    public Integer getWidth() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.WIDTH
        );
    }
}
