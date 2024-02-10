package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterForm extends AbstractPasswordEnabledForm {
    private static final Logger LOGGER = LogManager.getLogger(RegisterForm.class);

    @FindBy(xpath = "//div[contains(@class, 'DefaultLegaleseLinks')]/span")
    private ExtendedWebElement accountCreationLegalNotice;
    @FindBy(xpath = "//div[contains(@class, 'DefaultLegaleseLinks')]/span/a")
    private List<Anchor> defaultLegaleseLinks;

    @FindBy(xpath = "//fieldset[@type='password']//div[@data-testid='error-message']/span[@role='alert']")
    private ExtendedWebElement passwordErrorMessage;

    private final String LEGALESE_LINK_TEXT_TERMS_OF_SALE = "Terms of Sale";
    private final String LEGALESE_LINK_TEXT_TERMS_OF_SERVICE = "Terms of Service";
    private final String LEGALESE_LINK_TEXT_PRIVACY_POLICY = "Privacy Policy";

    public RegisterForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        getAccountCreationLegalNotice
    */

    public ExtendedWebElement getAccountCreationLegalNotice() {
        return accountCreationLegalNotice;
    }

    public boolean isAccountCreationNoticePresent(long timeout) {
        return accountCreationLegalNotice.isPresent(timeout);
    }

    public boolean isAccountCreationNoticePresent() {
        return this.isAccountCreationNoticePresent(1);
    }

    public String getAccountCreationLegalNoticeTextString() {
        return accountCreationLegalNotice.getText();
    }

    /*
        defaultLegaleseLinks
    */

    public List<Anchor> getDefaultLegaleseLinks() {
        return defaultLegaleseLinks;
    }

    public boolean isLegaliseLinkPresent(String legaleseLinkText) {
        return defaultLegaleseLinks.stream()
                .filter(legaleseLink ->
                        legaleseLink.getText().equalsIgnoreCase(legaleseLinkText)
                )
                .findFirst()
                .map(Anchor::isPresent)
                .orElse(false);
    }

    public boolean isTermsOfSaleLinkPresent() {
        return isLegaliseLinkPresent(LEGALESE_LINK_TEXT_TERMS_OF_SALE);
    }

    public boolean isTermsOfServiceLinkPresent() {
        return isLegaliseLinkPresent(LEGALESE_LINK_TEXT_TERMS_OF_SERVICE);
    }

    public boolean isPrivacyPolicyLinkPresent() {
        return isLegaliseLinkPresent(LEGALESE_LINK_TEXT_PRIVACY_POLICY);
    }


    public void clickLegaleseLinkByText(String legaleseLinkText) {
        defaultLegaleseLinks.stream()
                .filter(anchor -> anchor.getText().equals(legaleseLinkText))
                .findFirst()
                .ifPresent(Anchor::click);
    }

    public void clickTermsOfSaleLink() {
        clickLegaleseLinkByText(LEGALESE_LINK_TEXT_TERMS_OF_SALE);
    }

    public void clickTermsOfServiceLink() {
        clickLegaleseLinkByText(LEGALESE_LINK_TEXT_TERMS_OF_SERVICE);
    }

    public void clickPrivacyPolicyLink() {
        clickLegaleseLinkByText(LEGALESE_LINK_TEXT_PRIVACY_POLICY);
    }

    /*
        getPasswordErrorMessage
    */

    public ExtendedWebElement getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public boolean isPasswordErrorMessagePresent(long timeout) {
        return passwordErrorMessage.isPresent(timeout);
    }

    public boolean isPasswordErrorMessagePresent() {
        return this.isPasswordErrorMessagePresent(1);
    }

    public String getPasswordErrorMessageTextString() {
        return passwordErrorMessage.getText();
    }
}
