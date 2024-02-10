package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EnterEmailForm extends AbstractLoginRegistrationForm {
    private static final Logger LOGGER = LogManager.getLogger(EnterEmailForm.class);

    @FindBy(xpath = ".//button[@type='submit' and @data-testid='submit-email']")
    private ExtendedWebElement continueButton;
    @FindBy(xpath = ".//div[contains(@class, 'ButtonsMainContainer')]//button")
    private List<SSOButton> ssoButtons;

    @FindBy(xpath = ".//fieldset[@type='email']/div[@data-testid='error-message']/span[@role='alert']")
    private ExtendedWebElement invalidEmailErrorMessage;

    private final String GOOGLE_DATA_PROVIDER_STRING = "google";
    private final String FACEBOOK_DATA_PROVIDER_STRING = "facebook";
    private final String APPLE_DATA_PROVIDER_STRING = "apple";

    public EnterEmailForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getFormMethodString() {
        return this.getSelf().getAttribute(AttributeConstants.METHOD);
    }

    /*
        continueButton
    */

    public ExtendedWebElement getContinueButton() {
        return continueButton;
    }

    public boolean isContinueButtonPresent(long timeout) {
        return continueButton.isPresent(timeout);
    }

    public boolean isContinueButtonPresent() {
        return this.isContinueButtonPresent(1);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    /*
        ssoButtons
    */

    public List<SSOButton> getSsoButtons() {
        return ssoButtons;
    }

    public boolean isSsoButtonPresent(String dataProvider) {
        return ssoButtons.stream()
                .filter(ssoButton ->
                        ssoButton.getDataProviderString().equalsIgnoreCase(
                                dataProvider)
                )
                .findFirst()
                .map(SSOButton::isPresent)
                .orElse(false);
    }

    public boolean isSsoAppleButtonPresent() {
        return isSsoButtonPresent(APPLE_DATA_PROVIDER_STRING);
    }

    public boolean isSsoGoogleButtonPresent() {
        return isSsoButtonPresent(GOOGLE_DATA_PROVIDER_STRING);
    }

    public boolean isSsoFacebookButtonPresent() {
        return isSsoButtonPresent(FACEBOOK_DATA_PROVIDER_STRING);
    }

    public void clickSsoButtonByProvider(String dataProvider) {
        ssoButtons.stream()
                .filter(button ->
                        dataProvider.equalsIgnoreCase(
                                button.getDataProviderString()
                        ))
                .findFirst()
                .ifPresent(SSOButton::click);
    }

    public void clickGoogleSsoButton() {
        clickSsoButtonByProvider(GOOGLE_DATA_PROVIDER_STRING);
    }

    public void clickFacebookSsoButton() {
        clickSsoButtonByProvider(FACEBOOK_DATA_PROVIDER_STRING);
    }

    public void clickAppleSsoButton() {
        clickSsoButtonByProvider(APPLE_DATA_PROVIDER_STRING);
    }

    /*
        invalidEmailErrorMessage
    */

    public ExtendedWebElement getInvalidEmailErrorMessage() {
        return invalidEmailErrorMessage;
    }

    public boolean isInvalidEmailErrorMessagePresent(long timeout) {
        return invalidEmailErrorMessage.isPresent(timeout);
    }

    public boolean isInvalidEmailErrorMessagePresent() {
        return this.isInvalidEmailErrorMessagePresent(1);
    }

    public String getErrorMessageTextString() {
        return invalidEmailErrorMessage.getText();
    }
}
