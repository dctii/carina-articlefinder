package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.DriverUtils;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.elements.interfaces.IPoliceReferrerElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class InlineFrame
        extends AbstractSizeableElement
        implements IPoliceReferrerElement {
    public InlineFrame(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public String getAllow() {
        return this.getAttribute(AttributeConstants.ALLOW);
    }

    public Boolean getAllowFullScreen() {
        return ElementUtils.getBooleanFromAttrValueString(
                this,
                AttributeConstants.ALLOW_FULL_SCREEN
        );
    }

    public Boolean getAllowPaymentRequest() {
        return ElementUtils.getBooleanFromAttrValueString(
                this,
                AttributeConstants.ALLOW_PAYMENT_REQUEST
        );
    }

    public String getLoading() {
        return this.getAttribute(AttributeConstants.LOADING);
    }

    public String getNameAttrValue() {
        return this.getAttribute(AttributeConstants.NAME);
    }

    public Boolean hasSandbox() {
        return ElementUtils.getBooleanFromAttrValueString(
                this,
                AttributeConstants.SANDBOX
        );
    }

    public String getSandboxAttrValues() {
        return this.getAttribute(AttributeConstants.SANDBOX);
    }

    public String getSrcDoc() {
        return this.getAttribute(AttributeConstants.REFERRERPOLICY);
    }
    @Override
    public String getReferrerPolicy() {
        return this.getAttribute(AttributeConstants.REFERRERPOLICY);
    }

    /*
        iframe actions
     */

    public void switchToThisFrame(WebDriver driver) {
        DriverUtils.switchToFrame(driver, this);
    }
}
