package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.loginregistrationpage.EnterEmailForm;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.LogInForm;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.RegisterForm;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserAccessPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(UserAccessPage.class);

    @FindBy(xpath = "//*[@id=\"myAccountAuth\"]/header/div[@role='banner']")
    private ExtendedWebElement headerBanner;

    @FindBy(xpath = ".//form[@data-testid='enter-email-form']")
    private EnterEmailForm enterEmailForm;

    @FindBy(xpath = ".//form[@data-testid='login-form']")
    private LogInForm logInForm;

    @FindBy(xpath = ".//form[@data-testid='register-form']")
    private RegisterForm registerForm;

    public UserAccessPage(WebDriver driver) {
        super(driver);
    }

    /*
        headerBanner
    */
    public ExtendedWebElement getHeaderBanner() {
        return headerBanner;
    }

    public boolean isHeaderBannerPresent(long timeout) {
        return headerBanner.isPresent(timeout);
    }

    public boolean isHeaderBannerPresent() {
        return this.isHeaderBannerPresent(1);
    }

    /*
        emailForm
    */
    public EnterEmailForm getEnterEmailForm() {
        return enterEmailForm;
    }

    public boolean isEnterEmailFormPresent(long timeout) {
        return enterEmailForm.isPresent(timeout);
    }

    public boolean isEnterEmailFormPresent() {
        return this.isEnterEmailFormPresent(1);
    }

    /*
        logInForm
    */
    public LogInForm getLogInForm() {
        return logInForm;
    }

    public boolean isLogInFormPresent(long timeout) {
        return logInForm.isPresent(timeout);
    }

    public boolean isLogInFormPresent() {
        return this.isLogInFormPresent(1);
    }

    /*
        registerForm
    */

    public RegisterForm getRegisterForm() {
        return registerForm;
    }

    public boolean isRegisterFormPresent(long timeout) {
        return registerForm.isPresent(timeout);
    }

    public boolean isRegisterFormPresent() {
        return this.isRegisterFormPresent(1);
    }
}
