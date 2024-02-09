package com.solvd.carina.articlefinder.testutil;

import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.util.StringConstants;
import com.solvd.carina.articlefinder.web.HomePage;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebTestUtils {

    public WebTestUtils() {
    }

    public static void checkHomePageUrlAndTitle(HomePage page) {
        checkUrlAndTitle(
                page.getDriver(),
                Configuration.getRequired(ConfigConstants.NYT_HOME_URL_KEY) + StringConstants.SOLIDUS,
                WebTestConstants.EXPECTED_HOME_PAGE_TITLE
        );
    }

    public static void checkUrlAndTitle(WebDriver driver, String expectedUrl, String expectedTitle) {
        Assert.assertEquals(
                driver.getCurrentUrl(),
                expectedUrl,
                "Actual url does not match expected."
        );

        Assert.assertEquals(
                driver.getTitle(),
                expectedTitle,
                "Actual title does not match expected."
        );
    }
}
