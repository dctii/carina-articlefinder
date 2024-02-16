package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.web.components.generalpage.Footer;
import com.solvd.carina.articlefinder.web.elements.Button;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WirecutterHomePage extends AbstractPage {
    @FindBy(xpath = "//footer/div[@data-testid='footer-grid']")
    Footer footer;

    @FindBy(xpath = "//button[@data-gtm-trigger='newsletter_close']")
    Button closeNewsLetterButton;


    public WirecutterHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        final String wirecutterHomeUrl =
                Configuration.getRequired(ConfigConstants.NYT_HOME_URL_KEY) + "/wirecutter";
        openURL(
                wirecutterHomeUrl
        );
    }

    public Footer getFooter() {
        return footer;
    }

    public boolean isFooterPresent(long timeout) {
        return footer.isPresent(timeout);
    }

    public boolean isFooterPresent() {
        return isFooterPresent(1);
    }

    /*
        closeNewsLetterButton
     */

    public Button getCloseNewsletterButton() {
        return closeNewsLetterButton;
    }

    public void clickCloseNewsletterButton() {
        closeNewsLetterButton.clickIfPresent(10);
    }
}
