package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EnterEmailForm extends AbstractLoginRegistrationForm {

    @FindBy(xpath = ".")
    ExtendedWebElement self;

    @FindBy(xpath = ".//button[@type='submit' and @data-testid='submit-email']")
    ExtendedWebElement continueButton;
    @FindBy(xpath = ".//div[contains(@class, 'ButtonsMainContainer')]//button")
    List<SSOButton> ssoButtons;

    @FindBy(xpath = ".//fieldset[@type='email']div[@data-testid='error-message']/span[@role='alert']")
    ExtendedWebElement errorMessageSpan;

    public EnterEmailForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSelf() {
        return self;
    }

    public String getFormMethodString() {
        return AttributeUtils.getFormMethodString(self);
    }

    public ExtendedWebElement getContinueButton() {
        return continueButton;
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public List<SSOButton> getSsoButtons() {
        return ssoButtons;
    }

    public void clickSsoButtonByProvider(String dataProvider) {
        ssoButtons.stream()
                .filter(button ->
                        dataProvider.equalsIgnoreCase(
                                button.getDataProviderString()
                        ))
                .findFirst()
                .ifPresent(SSOButton::clickSelf);
    }

    public void clickGoogleSsoButton() {
        final String dataProvider = "google";

        clickSsoButtonByProvider(dataProvider);
    }

    public void clickFacebookSsoButton() {
        final String dataProvider = "facebook";

        clickSsoButtonByProvider(dataProvider);
    }

    public void clickAppleSsoButton() {
        final String dataProvider = "apple";

        clickSsoButtonByProvider(dataProvider);
    }

    public ExtendedWebElement getErrorMessageSpan() {
        return errorMessageSpan;
    }

    public String getErrorMessageTextString() {
        return errorMessageSpan.getText();
    }
}
