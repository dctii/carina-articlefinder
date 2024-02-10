package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SSOButton extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(SSOButton.class);
    @FindBy(xpath = "./span[contains(@class, 'ButtonText')]")
    private ExtendedWebElement ssoActionPromptText;

    public SSOButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        self
    */

    public ExtendedWebElement getSelf() {
        return this.getRootExtendedElement();
    }

    public boolean isPresent(long timeout) {
        return this.getSelf().isPresent(timeout);
    }

    public boolean isPresent() {
        return this.isPresent(1);
    }

    public void click() {
        this.getSelf().click();
    }

    public String getDataProviderString() {
        return this.getSelf().getAttribute(AttributeConstants.DATA_PROVIDER);
    }

    /*
        ssoActionPromptText
    */

    public ExtendedWebElement getSsoActionPromptText() {
        return ssoActionPromptText;
    }

    public boolean isSsoActionPromptTextPresent(long timeout) {
        return ssoActionPromptText.isPresent(timeout);
    }

    public boolean isSsoActionPromptTextPresent() {
        return this.isSsoActionPromptTextPresent(1);
    }

    public String getSsoActionPromptTextString() {
        return ssoActionPromptText.getText();
    }
}
