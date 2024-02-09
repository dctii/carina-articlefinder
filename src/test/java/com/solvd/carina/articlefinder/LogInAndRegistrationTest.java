package com.solvd.carina.articlefinder;

import com.solvd.carina.articlefinder.testutil.DriverUtils;
import com.solvd.carina.articlefinder.testutil.WebTestConstants;
import com.solvd.carina.articlefinder.testutil.WebTestUtils;
import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.PostLoginSubscriptionOfferPage;
import com.solvd.carina.articlefinder.web.UserAccessPage;
import com.solvd.carina.articlefinder.web.components.generalpage.UserModalDrawer;
import com.solvd.carina.articlefinder.web.components.homepage.HomeMasterHeader;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.EnterEmailForm;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.LogInForm;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.RegisterForm;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInAndRegistrationTest extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(LogInAndRegistrationTest.class);

    @DataProvider
    public static Object[][] userCredentials() {
        return new Object[][]{
                {
                        Configuration.getRequired(ConfigConstants.NYT_USER_EMAIL_KEY),
                        Configuration.getRequired(ConfigConstants.NYT_USER_PW_KEY),
                }
        };
    }

    @DataProvider
    public static Object[][] invalidEmail() {
        return new Object[][]{
                {"billy@g"},
                {"johnny@gmailcom"}
        };
    }

    @DataProvider
    public static Object[][] validEmailAndInvalidPassword() {
        return new Object[][]{
                {
                        Configuration.getRequired(ConfigConstants.NYT_USER_EMAIL_KEY),
                        "11drag0ns12345",
                },
                {
                        Configuration.getRequired(ConfigConstants.NYT_USER_EMAIL_KEY),
                        "everythingisawesome",
                }
        };
    }

    @DataProvider
    public static Object[][] validEmailAndTooShortPassword() {
        return new Object[][]{
                {
                        "johnny_martinez2010@gmail.com",
                        "12345",
                },
                {
                        "billy_gonzalez2012@yahoo.com",
                        "six",
                }
        };
    }

    @Test(
            description = "Validate logging in and logging out",
            dataProvider = "userCredentials"
    )
    public void validateLogInAndOut(String userEmail, String userPassword) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        WebTestUtils.checkHomePageUrlAndTitle(homePage);

        HomeMasterHeader homeMasterHeader = homePage.getMasterHeader();

        // click the login button, taking you to the user access page for log in and registration
        DriverUtils.implicitlyWait(driver, 3);
        UserAccessPage userAccessPage = homeMasterHeader.clickLogInButton();

        // type user email for login handle
        EnterEmailForm enterEmailForm = userAccessPage.getEnterEmailForm();
        DriverUtils.implicitlyWait(driver, 3);
        enterEmailForm.typeEmailInputValue(userEmail);

        DriverUtils.implicitlyWait(driver, 4);
        enterEmailForm.clickContinueButton();

        LogInForm logInForm = userAccessPage.getLogInForm();
        DriverUtils.implicitlyWait(driver, 5);
        logInForm.typePasswordInputValue(userPassword);

        // click on the continue without subscribing link on the subscription offer page
        DriverUtils.implicitlyWait(driver, 3);
        PostLoginSubscriptionOfferPage postLoginPage = logInForm.clickSubmitButton();
        DriverUtils.implicitlyWait(driver, 3);
        homePage = postLoginPage.clickContinueWithoutSubscribingLink();
        homeMasterHeader = homePage.getMasterHeader();

        Assert.assertEquals(
                homeMasterHeader.getUserSettingsButton().getText(),
                WebTestConstants.EXPECTED_USER_SETTINGS_BUTTON_TEXT,
                String.format(
                        "User settings button text does not match -- actual: %s ; expected %s",
                        homeMasterHeader.getUserSettingsButton().getText(),
                        WebTestConstants.EXPECTED_USER_SETTINGS_BUTTON_TEXT
                )
        );

        // open user modal drawer and click the log out link
        homeMasterHeader.clickUserSettingsButton();
        UserModalDrawer userSettingsDrawer = homePage.getUserModalDrawer();
        homePage = userSettingsDrawer.clickLogOutLink();
        homeMasterHeader = homePage.getMasterHeader();

        Assert.assertFalse(
                homeMasterHeader.getUserSettingsButton().isPresent(),
                "User settings button exists, meaning that user is not logged out"
        );

        Assert.assertTrue(
                homeMasterHeader.getLogInButton().isPresent(),
                "Log In button does not exist, meaning that user is not logged out"
        );
    }

    @Test(
            description = "Try logging in with an invalid email",
            dataProvider = "invalidEmail"
    )
    public void tryToLogInWithInvalidEmail(String userEmail) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        WebTestUtils.checkHomePageUrlAndTitle(homePage);

        HomeMasterHeader homeMasterHeader = homePage.getMasterHeader();

        // click the login button, taking you to the user access page for log in and registration
        UserAccessPage userAccessPage = homeMasterHeader.clickLogInButton();

        // type user email for login handle
        EnterEmailForm enterEmailForm = userAccessPage.getEnterEmailForm();
        enterEmailForm.typeEmailInputValue(userEmail);

        enterEmailForm.clickContinueButton();

        Assert.assertTrue(
                enterEmailForm.getErrorMessageSpan().isElementPresent(),
                "Error message for email should be present since email is invalid"
        );

        Assert.assertEquals(
                enterEmailForm.getErrorMessageTextString(),
                WebTestConstants.EXPECTED_EMAIL_ERROR_MSG,
                String.format(
                        "Error message does not match -- actual: %s ; expected: %s",
                        enterEmailForm.getErrorMessageTextString(),
                        WebTestConstants.EXPECTED_EMAIL_ERROR_MSG
                )
        );
    }

    @Test(
            description = "Try logging in with a valid email and an invalid password",
            dataProvider = "validEmailAndInvalidPassword"
    )
    public void tryToLogInWithInvalidPassword(String userEmail, String userPassword) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        WebTestUtils.checkHomePageUrlAndTitle(homePage);

        HomeMasterHeader homeMasterHeader = homePage.getMasterHeader();

        // click the login button, taking you to the user access page for log in and registration
        UserAccessPage userAccessPage = homeMasterHeader.clickLogInButton();

        // type user email for login handle
        EnterEmailForm enterEmailForm = userAccessPage.getEnterEmailForm();
        enterEmailForm.typeEmailInputValue(userEmail);

        enterEmailForm.clickContinueButton();

        LogInForm logInForm = userAccessPage.getLogInForm();
        logInForm.typePasswordInputValue(userPassword);
        logInForm.clickSubmitButton();

        Assert.assertTrue(
                logInForm.getEmailOrPasswordIncorrectMessageSpan().isElementPresent(),
                "Error message for invalid password is not present."
        );

        Assert.assertEquals(
                logInForm.getEmailOrPasswordIncorrectMessageTextString(),
                WebTestConstants.EXPECTED_INVALID_LOGIN_ERROR_MSG,
                String.format(
                        "Error message does not match -- actual: %s ; expected: %s",
                        logInForm.getEmailOrPasswordIncorrectMessageTextString(),
                        WebTestConstants.EXPECTED_INVALID_LOGIN_ERROR_MSG
                )
        );
    }

    @Test(
            description = "Try logging in with a valid email and an invalid password",
            dataProvider = "validEmailAndTooShortPassword"
    )
    public void tryToRegisterWithInvalidPasswordLength(String userEmail, String userPassword) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        WebTestUtils.checkHomePageUrlAndTitle(homePage);

        HomeMasterHeader homeMasterHeader = homePage.getMasterHeader();

        // click the login button, taking you to the user access page for log in and registration
        UserAccessPage userAccessPage = homeMasterHeader.clickLogInButton();

        // type user email for login handle
        EnterEmailForm enterEmailForm = userAccessPage.getEnterEmailForm();
        enterEmailForm.typeEmailInputValue(userEmail);

        enterEmailForm.clickContinueButton();

        RegisterForm registerForm = userAccessPage.getRegisterForm();
        registerForm.typePasswordInputValue(userPassword);
        registerForm.clickSubmitButton();

        Assert.assertTrue(
                registerForm.getPasswordErrorMessageSpan().isElementPresent(),
                "Error message for password being too short is not present."
        );

        Assert.assertEquals(
                registerForm.getPasswordErrorMessageTextString(),
                WebTestConstants.EXPECTED_INVALID_PASSWORD_LENGTH_REGISTRATION_MESSAGE,
                String.format(
                        "Error message does not match -- actual: %s ; expected: %s",
                        registerForm.getPasswordErrorMessageTextString(),
                        WebTestConstants.EXPECTED_INVALID_PASSWORD_LENGTH_REGISTRATION_MESSAGE
                )
        );
    }

}
