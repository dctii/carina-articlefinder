package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInForm extends AbstractPasswordEnabledForm {
    private static final Logger LOGGER = LogManager.getLogger(LogInForm.class);

    @FindBy(xpath = ".//a[@data-testid='forgot-password']")
    private Anchor forgotYourPasswordLink;

    @FindBy(xpath = ".//button[contains(text(), 'without password')]")
    private ExtendedWebElement logInWithoutPasswordButton;

    @FindBy(xpath = ".//div[@data-testid='api-error']/span[@role='alert']")
    private ExtendedWebElement wrongEmailOrPasswordMessage;


    public LogInForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    /*
        forgotYourPasswordLink
    */

    public Anchor getForgotYourPasswordLink() {
        return forgotYourPasswordLink;
    }

    public boolean isForgotYourPasswordLinkPresent(long timeout) {
        return forgotYourPasswordLink.isPresent(timeout);
    }

    public boolean isForgotYourPasswordLinkPresent() {
        return this.isForgotYourPasswordLinkPresent(1);
    }

    public void clickForgotYourPassword() {
        forgotYourPasswordLink.click();
    }

    /*
        logInWithoutPasswordButton
    */

    public ExtendedWebElement getLogInWithoutPasswordButton() {
        return logInWithoutPasswordButton;
    }

    public void clickLogInWithoutPassword() {
        logInWithoutPasswordButton.click();
    }

    /*
        getWrongEmailOrPasswordMessage
    */

    public ExtendedWebElement getWrongEmailOrPasswordMessage() {
        return wrongEmailOrPasswordMessage;
    }

    public boolean isWrongEmailOrPasswordMessagePresent(long timeout) {
        return wrongEmailOrPasswordMessage.isPresent(timeout);
    }

    public boolean isWrongEmailOrPasswordMessagePresent() {
        return this.isWrongEmailOrPasswordMessagePresent(1);
    }

    public String getWrongEmailOrPasswordMessageTextString() {
        return wrongEmailOrPasswordMessage.getText();
    }
}
