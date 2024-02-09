package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeUtils;
import com.solvd.carina.articlefinder.web.components.generic.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInForm extends AbstractPasswordEnabledForm {

    @FindBy(xpath = ".")
    private ExtendedWebElement self;
    @FindBy(xpath = ".//a[@data-testid='forgot-password']")
    private Anchor forgotYourPassword;

    @FindBy(xpath = ".//button[contains(text(), 'without password')]")
    private ExtendedWebElement logInWithoutPasswordButton;

    @FindBy(xpath = ".//div[@data-testid='api-error']/span[@role='alert']")
    private ExtendedWebElement emailOrPasswordIncorrectMessageSpan;


    public LogInForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSelf() {
        return self;
    }

    public String getFormMethodString() {
        return AttributeUtils.getFormMethodString(self);
    }

    public Anchor getForgotYourPassword() {
        return forgotYourPassword;
    }

    public void clickForgotYourPassword() {
        forgotYourPassword.click();
    }

    public ExtendedWebElement getLogInWithoutPasswordButton() {
        return logInWithoutPasswordButton;
    }

    public void clickLogInWithoutPassword() {
        logInWithoutPasswordButton.click();
    }

    public ExtendedWebElement getEmailOrPasswordIncorrectMessageSpan() {
        return emailOrPasswordIncorrectMessageSpan;
    }

    public String getEmailOrPasswordIncorrectMessageTextString() {
        return emailOrPasswordIncorrectMessageSpan.getText();
    }
}
