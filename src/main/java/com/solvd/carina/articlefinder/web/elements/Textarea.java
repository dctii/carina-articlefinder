package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.ElementUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Textarea extends AbstractInputElement {

    public Textarea(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Integer getCols() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.COLS
        );
    }

    public Integer getRows() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.ROWS
        );
    }

    public String getSpellcheck() {
        return this.getAttribute(AttributeConstants.SPELLCHECK);
    }

    public String getWrap() {
        return this.getAttribute(AttributeConstants.WRAP);
    }
}
