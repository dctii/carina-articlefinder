package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.loginregistrationpage.EnterEmailForm;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.LogInForm;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.RegisterForm;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserAccessPage extends AbstractPage {

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

    public ExtendedWebElement getHeaderBanner() {
        return headerBanner;
    }

    public EnterEmailForm getEnterEmailForm() {
        return enterEmailForm;
    }

    public LogInForm getLogInForm() {
        return logInForm;
    }

    public RegisterForm getRegisterForm() {
        return registerForm;
    }
}
