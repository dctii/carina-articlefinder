package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.elements.interfaces.IDisableableElement;
import com.solvd.carina.articlefinder.web.elements.interfaces.IFormElementAssociate;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractInputElement
        extends AbstractGlobalElement
        implements IFormElementAssociate, IDisableableElement
{

    public AbstractInputElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getNameAttrValueString() {
        return this.getAttribute(AttributeConstants.NAME);
    }

    public String getPlaceholder() {
        return this.getAttribute(AttributeConstants.PLACEHOLDER);
    }

    public Integer getMaxLength() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.MAX_LENGTH
        );
    }

    public Integer getMinLength() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.MIN_LENGTH
        );
    }

    @Override
    public String getFormAttrValueString() {
        return this.getAttribute(AttributeConstants.FORM);
    }

    public String getAutoComplete() {
        return this.getAttribute(AttributeConstants.AUTO_COMPLETE);
    }

    public String getDirName() {
        return this.getAttribute(AttributeConstants.DIR_NAME);
    }

    public boolean isRequired() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.REQUIRED
        );
    }

    public boolean isReadOnly() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.READONLY
        );
    }

    @Override
    public boolean isDisabled() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.DISABLED
        );
    }


    public String getAriaLabel() {
        return this.getAttribute(AttributeConstants.ARIA_LABEL);
    }

    public String getAriaExpanded() {
        return this.getAttribute(AttributeConstants.ARIA_EXPANDED);
    }

    public String getAriaAutocomplete() {
        return this.getAttribute(AttributeConstants.ARIA_AUTOCOMPLETE);
    }

}
