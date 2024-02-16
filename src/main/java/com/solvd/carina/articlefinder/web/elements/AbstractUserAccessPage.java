package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.web.components.loginregistrationpage.EnterEmailForm;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.LogInForm;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.RegisterForm;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AbstractUserAccessPage extends AbstractPage {

    @FindBy(xpath = "//form[@data-testid='enter-email-form']")
    private EnterEmailForm enterEmailForm;

    @FindBy(xpath = "//form[@data-testid='login-form']")
    private LogInForm logInForm;

    @FindBy(xpath = "//form[@data-testid='register-form']")
    private RegisterForm registerForm;

    public AbstractUserAccessPage(WebDriver driver) {
        super(driver);
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
