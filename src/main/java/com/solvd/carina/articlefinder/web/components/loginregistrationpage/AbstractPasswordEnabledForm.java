package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.web.PostLoginSubscriptionOfferPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPasswordEnabledForm extends AbstractLoginRegistrationForm {
    private static final Logger LOGGER = LogManager.getLogger(AbstractPasswordEnabledForm.class);
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

    /*
        self
    */

    public String getFormMethodString() {
        return this.getSelf().getAttribute(AttributeConstants.METHOD);
    }

    /*
        editEmailButton
    */

    public ExtendedWebElement getEditEmailButton() {
        return editEmailButton;
    }

    public boolean isEditEmailButtonPresent(long timeout) {
        return editEmailButton.isPresent(timeout);
    }

    public boolean isEditEmailButtonPresent() {
        return this.isEditEmailButtonPresent(1);
    }

    public void clickEditEmailButton() {
        editEmailButton.clickIfPresent();
    }

    public String getEditEmailButtonTextString() {
        return editEmailButton.getText();
    }

    /*
        passwordInputLabel
    */

    public ExtendedWebElement getPasswordInputLabel() {
        return passwordInputLabel;
    }

    public boolean isPasswordInputLabelPresent(long timeout) {
        return passwordInputLabel.isPresent(timeout);
    }

    public boolean isPasswordInputLabelPresent() {
        return this.isPasswordInputLabelPresent(1);
    }

    public String getPasswordInputLabelTextString() {
        return passwordInputLabel.getText();
    }

    /*
        showPasswordButton
    */

    public ExtendedWebElement getShowPasswordButton() {
        return showPasswordButton;
    }

    public boolean isShowPasswordButtonPresent(long timeout) {
        return showPasswordButton.isPresent(timeout);
    }

    public boolean isShowPasswordButtonPresent() {
        return this.isShowPasswordButtonPresent(1);
    }

    public String getShowPasswordButtonTextString() {
        return showPasswordButton.getText();
    }

    /*
        submitButton
    */

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }

    public boolean isSubmitButtonPresent(long timeout) {
        return submitButton.isPresent(timeout);
    }

    public boolean isSubmitButtonPresent() {
        return this.isSubmitButtonPresent(1);
    }

    public PostLoginSubscriptionOfferPage clickSubmitButton() {
        submitButton.click();
        return new PostLoginSubscriptionOfferPage(getDriver());
    }

    public String getSubmitButtonText() {
        return submitButton.getText();
    }
}
