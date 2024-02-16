package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.elements.interfaces.IDisableableElement;
import com.solvd.carina.articlefinder.web.elements.interfaces.IFormElement;
import com.solvd.carina.articlefinder.web.elements.interfaces.IFormElementAssociate;
import com.solvd.carina.articlefinder.web.elements.interfaces.IPolytypeElement;
import com.solvd.carina.articlefinder.web.elements.interfaces.IValueElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Button
        extends
        AbstractGlobalElement
        implements
        IFormElementAssociate, IFormElement, IPolytypeElement,
        IValueElement, IDisableableElement {
    public Button(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getFormAttrValueString() {
        return this.getAttribute(AttributeConstants.FORM);
    }

    @Override
    public String getFormAction() {
        return this.getAttribute(AttributeConstants.FORMACTION);
    }

    @Override
    public String getFormEncType() {
        return this.getAttribute(AttributeConstants.FORMENCTYPE);
    }

    @Override
    public String getFormMethod() {
        return this.getAttribute(AttributeConstants.FORMMETHOD);
    }

    @Override
    public String getFormNoValidate() {
        return this.getAttribute(AttributeConstants.FORMNOVALIDATE);
    }

    @Override
    public String getFormTarget() {
        return this.getAttribute(AttributeConstants.FORMTARGET);
    }

    @Override
    public String getPopoverTarget() {
        return this.getAttribute(AttributeConstants.POPOVERTARGET);
    }

    @Override
    public String getPopoverTargetAction() {
        return this.getAttribute(AttributeConstants.POPOVERTARGETACTION);
    }

    @Override
    public String getType() {
        return this.getAttribute(AttributeConstants.TYPE);
    }

    @Override
    public String getValueAttrValueString() {
        return this.getAttribute(AttributeConstants.VALUE);
    }

    @Override
    public boolean isDisabled() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.DISABLED
        );
    }
}
