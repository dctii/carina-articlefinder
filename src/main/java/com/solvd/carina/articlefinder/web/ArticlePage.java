package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.util.DriverUtils;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.solvd.carina.articlefinder.web.elements.InlineFrame;
import com.solvd.carina.articlefinder.web.elements.interfaces.IHeadline;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlePage
        extends GeneralPage
        implements IHeadline {

    @FindBy(xpath = "//div[@id='gateway-content']//div[@name='user-profile-iframe']//iframe")
    InlineFrame registrationWall;

    @FindBy(xpath = "//main[@id='site-content']//article//h1")
    BoringElement headline;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    /*
        registrationWall
     */

    public InlineFrame getRegistrationWall() {
        return registrationWall;
    }

    public boolean isRegistrationWallPresent(long timeout) {
        return registrationWall.isPresent(timeout);
    }

    public boolean isRegistrationWallPresent() {
        return isRegistrationWallPresent(1);
    }

    public RegistrationWallFrame switchToRegistrationWallFrame() {
        registrationWall.switchToThisFrame(getDriver());
        return new RegistrationWallFrame(getDriver());
    }

    /*
        primaryHeadline
     */

    public BoringElement getHeadline() {
        return headline;
    }

    @Override
    public BoringElement getHeadline(String headlineText) {
        BoringElement headline = null;
        if (getHeadlineText().equals(headlineText)) {
            headline = this.headline;
        }

        return headline;
    }

    public boolean isHeadlinePresent(long timeout) {

        return headline.isPresent(timeout);
    }

    public boolean isHeadlinePresent() {
        return isHeadlinePresent(1);
    }

    public String getHeadlineText() {
        return headline.getText();
    }


    @Override
    public Boolean doesHeadlineExistOnPage(String headlineText) {
        return getHeadlineText().equals(headlineText);
    }

    /*
        iframe action
     */
    public ArticlePage switchToThisRootFrame() {
        DriverUtils.switchToRootFrame(getDriver());
        return new ArticlePage(getDriver());
    }
}
