package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SSOButton extends AbstractUIObject {
    @FindBy(xpath = ".")
    private ExtendedWebElement self; // selects the button
    @FindBy(xpath = "./span[contains(@class, 'ButtonText')]")
    private ExtendedWebElement ssoActionPromptText;

    public SSOButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSelf() {
        return self;
    }

    public void clickSelf() {
        self.click();
    }

    public String getDataProviderString() {
        return AttributeUtils.getDataProviderString(self);
    }

    public ExtendedWebElement getSsoActionPromptText() {
        return ssoActionPromptText;
    }

    public String getSsoActionPromptTextString() {
        return ssoActionPromptText.getText();
    }


}
