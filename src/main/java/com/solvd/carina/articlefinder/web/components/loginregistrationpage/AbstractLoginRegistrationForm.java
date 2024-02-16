package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.solvd.carina.articlefinder.web.elements.Input;
import com.solvd.carina.articlefinder.web.elements.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractLoginRegistrationForm extends AbstractGlobalUIObject {
    private static final Logger LOGGER = LogManager.getLogger(AbstractLoginRegistrationForm.class);

    @FindBy(xpath = "//form[@name='Lire-UI-Form']//h2[contains(text(), 'og in')]")
    private BoringElement formHeader;
    @FindBy(xpath = "//form[@name='Lire-UI-Form']//h2[contains(text(), 'og in')]//following-sibling::h2")
    private BoringElement formSubHeader;
    @FindBy(xpath = "//label[@for='email']")
    private Label emailAddressInputLabel;
    @FindBy(xpath = "//input[@type='email']")
    private Input emailInputField;

    @FindBy(xpath = ".//input[@type='password']")
    private Input passwordInputField;


    public AbstractLoginRegistrationForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        self
     */

    public String getFormMethodString() {
        return this.getSelf().getAttribute(AttributeConstants.METHOD);
    }

    /*
        emailAddressInputLabel
    */

    public Label getEmailAddressInputLabel() {
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

    public Input getEmailInputField() {
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
    public Input getPasswordInputField() {
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

    public BoringElement getFormHeader() {
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

    /*
        formSubHeader
    */

    public BoringElement getFormSubHeader() {
        return formSubHeader;
    }

    public boolean isFormSubHeaderPresent(long timeout) {
        return formHeader.isPresent(timeout);
    }

    public boolean isFormSubHeaderPresent() {
        return this.isFormSubHeaderPresent(1);
    }

    public String getFormSubHeaderTextString() {
        return formSubHeader.getText();
    }
}
