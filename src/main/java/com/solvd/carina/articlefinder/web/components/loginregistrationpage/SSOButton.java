package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SSOButton extends AbstractGlobalUIObject {
    private static final Logger LOGGER = LogManager.getLogger(SSOButton.class);
    @FindBy(xpath = "./span[contains(@class, 'ButtonText')]")
    private BoringElement ssoActionPromptText;

    public SSOButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        self
    */

    public void click() {
        getSelf().click();
    }

    public String getDataProviderString() {
        return getSelf().getAttribute(AttributeConstants.DATA_PROVIDER);
    }

    /*
        ssoActionPromptText
    */

    public BoringElement getSsoActionPromptText() {
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
