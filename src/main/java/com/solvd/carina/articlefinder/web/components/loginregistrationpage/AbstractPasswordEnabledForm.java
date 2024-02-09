package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.web.PostLoginSubscriptionOfferPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPasswordEnabledForm extends AbstractLoginRegistrationForm {


    @FindBy(xpath = ".//button[@data-testid='edit-email']")
    private ExtendedWebElement editEmailButton;
    @FindBy(xpath = ".//label[@for='password']")
    private ExtendedWebElement passwordInputLabel;
    @FindBy(xpath = ".//button[@data-testid='show-password']")
    private ExtendedWebElement showPasswordButton;
    @FindBy(xpath = ".//button[@type='submit']")
    private ExtendedWebElement submitButton;

    public AbstractPasswordEnabledForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEditEmailButton() {
        return editEmailButton;
    }

    public void clickEditEmailButton() {
        editEmailButton.clickIfPresent();
    }

    public String getEditEmailButtonTextString() {
        return editEmailButton.getText();
    }

    public ExtendedWebElement getPasswordInputLabel() {
        return passwordInputLabel;
    }

    public String getPasswordInputLabelTextString() {
        return passwordInputLabel.getText();
    }



    public ExtendedWebElement getShowPasswordButton() {
        return showPasswordButton;
    }

    public String getShowPasswordButtonTextString() {
        return showPasswordButton.getText();
    }

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }

    public PostLoginSubscriptionOfferPage clickSubmitButton() {
        submitButton.click();

        return new PostLoginSubscriptionOfferPage(getDriver());
    }

    public String getSubmitButtonText() {
        return submitButton.getText();
    }
}
