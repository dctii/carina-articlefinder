package com.solvd.carina.articlefinder.web.components.loginregistrationpage;

import com.solvd.carina.articlefinder.util.AttributeUtils;
import com.solvd.carina.articlefinder.web.components.generic.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterForm extends AbstractPasswordEnabledForm {

    @FindBy(xpath = ".")
    private ExtendedWebElement self;

    @FindBy(xpath = "//div[contains(@class, 'DefaultLegaleseLinks')]/span")
    private ExtendedWebElement accountCreationLegalNotice;
    @FindBy(xpath = "//div[contains(@class, 'DefaultLegaleseLinks')]/span/a")
    private List<Anchor> defaultLegaleseLinks;

    @FindBy(xpath = "//fieldset[@type='password']//div[@data-testid='error-message']/span[@role='alert']")
    private ExtendedWebElement passwordErrorMessageSpan;

    public RegisterForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSelf() {
        return self;
    }

    public String getFormMethodString() {
        return AttributeUtils.getFormMethodString(self);
    }

    public ExtendedWebElement getAccountCreationLegalNotice() {
        return accountCreationLegalNotice;
    }

    public String getAccountCreationLegalNoticeTextString() {
        return accountCreationLegalNotice.getText();
    }

    public List<Anchor> getDefaultLegaleseLinks() {
        return defaultLegaleseLinks;
    }

    public void clickLegaleseLinkByText(String text) {
        defaultLegaleseLinks.stream()
                .filter(anchor -> anchor.getText().equals(text))
                .findFirst()
                .ifPresent(Anchor::click);
    }

    public void clickTermsOfSaleLink() {
        final String TERMS_OF_SALE = "Terms of Sale";
        clickLegaleseLinkByText(TERMS_OF_SALE);
    }

    public void clickTermsOfServiceLink() {
        final String TERMS_OF_SERVICE = "Terms of Service";
        clickLegaleseLinkByText(TERMS_OF_SERVICE);
    }

    public void clickPrivacyPolicyLink() {
        final String PRIVACY_POLICY = "Privacy Policy";
        clickLegaleseLinkByText(PRIVACY_POLICY);
    }

    public ExtendedWebElement getPasswordErrorMessageSpan() {
        return passwordErrorMessageSpan;
    }

    public String getPasswordErrorMessageTextString() {
        return passwordErrorMessageSpan.getText();
    }
}
