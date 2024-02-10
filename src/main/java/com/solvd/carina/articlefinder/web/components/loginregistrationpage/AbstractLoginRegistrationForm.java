package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractLoginRegistrationForm extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(AbstractLoginRegistrationForm.class);

    @FindBy(xpath = ".//label[@for='email']")
    private ExtendedWebElement emailAddressInputLabel;
    @FindBy(xpath = ".//input[@type='email']")
    private ExtendedWebElement emailInputField;

    @FindBy(xpath = ".//input[@type='password']")
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//form[@name='Lire-UI-Form']//h2")
    private ExtendedWebElement formHeader;

    public AbstractLoginRegistrationForm(WebDriver driver, SearchContext searchContext) {
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

    /*
        emailAddressInputLabel
    */

    public ExtendedWebElement getEmailAddressInputLabel() {
        return emailAddressInputLabel;
    }

    public boolean isEmailAddressInputLabelPresent(long timeout) {
        return emailAddressInputLabel.isPresent(timeout);
    }

    public boolean isEmailAddressInputLabelPresent() {
        return this.isEmailAddressInputLabelPresent(1);
    }

    public String getEmailAddresInputLabelTextString() {
        return emailAddressInputLabel.getText();
    }

    /*
        emailInputField
    */

    public ExtendedWebElement getEmailInputField() {
        return emailInputField;
    }

    public boolean isEmailInputFieldPresent(long timeout) {
        return emailInputField.isPresent(timeout);
    }

    public boolean isEmailInputFieldPresent() {
        return this.isEmailInputFieldPresent(1);
    }

    public void typeEmailInputValue(String value) {
        // type something into the email input box
        emailInputField.type(value);
    }

    /*
        passwordInputField
    */
    public ExtendedWebElement getPasswordInputField() {
        return passwordInputField;
    }

    public boolean isPasswordInputFieldPresent(long timeout) {
        return passwordInputField.isPresent(timeout);
    }

    public boolean isPasswordInputFieldPresent() {
        return this.isPasswordInputFieldPresent(1);
    }

    public void typePasswordInputValue(String value) {
        // type something into the password input box
        passwordInputField.type(value);
    }

    /*
        formHeader
    */

    public ExtendedWebElement getFormHeader() {
        return formHeader;
    }

    public boolean isFormHeaderPresent(long timeout) {
        return formHeader.isPresent(timeout);
    }

    public boolean isFormHeaderPresent() {
        return this.isFormHeaderPresent(1);
    }

    public String getFormHeaderTextString() {
        return formHeader.getText();
    }


}
