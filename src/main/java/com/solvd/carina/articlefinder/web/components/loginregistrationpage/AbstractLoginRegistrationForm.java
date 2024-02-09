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
    ExtendedWebElement emailAddressInputLabel;
    @FindBy(xpath = ".//input[@type='email']")
    ExtendedWebElement emailInputField;

    @FindBy(xpath = ".//input[@type='password']")
    ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//form[@name='Lire-UI-Form']//h2")
    ExtendedWebElement formHeader;

    public AbstractLoginRegistrationForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEmailAddressInputLabel() {
        return emailAddressInputLabel;
    }

    public String getEmailAddresInputLabelTextString() {
        return emailAddressInputLabel.getText();
    }

    public ExtendedWebElement getEmailInputField() {
        return emailInputField;
    }

    public void typeEmailInputValue(String value) {
        // type something into the email input box
        emailInputField.type(value);
    }

    // no typeEmailInputValue method in this class since unable to use in EnterEmailForm extension,
    // but still available as hidden, so can be used for testing if hidden or not
    public ExtendedWebElement getPasswordInputField() {
        return passwordInputField;
    }

    public void typePasswordInputValue(String value) {
        // type something into the password input box
        passwordInputField.type(value);
    }

    public ExtendedWebElement getFormHeader() {
        return formHeader;
    }

    public String getFormHeaderTextString() {
        return formHeader.getText();
    }


}
