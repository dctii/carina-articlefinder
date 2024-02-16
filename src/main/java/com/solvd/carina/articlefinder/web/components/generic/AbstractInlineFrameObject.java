package com.solvd.carina.articlefinder.web.components.generic;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.DriverUtils;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.elements.interfaces.IPoliceReferrerElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractInlineFrameObject
        extends AbstractGlobalUIObject
        implements IPoliceReferrerElement {
    public AbstractInlineFrameObject(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        self
     */


    public String getAllow() {
        return getSelf().getAttribute(AttributeConstants.ALLOW);
    }

    public Boolean getAllowFullScreen() {
        return ElementUtils.getBooleanFromAttrValueString(
                getSelf(),
                AttributeConstants.ALLOW_FULL_SCREEN
        );
    }

    public Boolean getAllowPaymentRequest() {
        return ElementUtils.getBooleanFromAttrValueString(
                getSelf(),
                AttributeConstants.ALLOW_PAYMENT_REQUEST
        );
    }

    public String getLoading() {
        return getSelf().getAttribute(AttributeConstants.LOADING);
    }

    public String getNameAttrValue() {
        return getSelf().getAttribute(AttributeConstants.NAME);
    }

    public Boolean hasSandbox() {
        return ElementUtils.getBooleanFromAttrValueString(
                getSelf(),
                AttributeConstants.SANDBOX
        );
    }

    public String getSandboxAttrValues() {
        return getSelf().getAttribute(AttributeConstants.SANDBOX);
    }

    public String getSrcDoc() {
        return getSelf().getAttribute(AttributeConstants.REFERRERPOLICY);
    }

    @Override
    public String getReferrerPolicy() {
        return getSelf().getAttribute(AttributeConstants.REFERRERPOLICY);
    }

    /*
        iframe actions
     */

    public void switchToThisFrame(WebDriver driver) {
        DriverUtils.switchToFrame(driver, this);
    }
}
