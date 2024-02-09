package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.homepage.HomeMasterHeader;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

// NY Times Home Page
public class HomePage extends PageContainer {

    @FindBy(xpath = "//div[@data-testid='masthead-container']/header")
    private HomeMasterHeader masterHeader;

    /* TODO:
        // HomeNavigationMenu
        // site-content
    */

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        // 3rd approach to making the base url available
        openURL(Configuration.getRequired("nytimes_home_url"));
    }

    public HomeMasterHeader getMasterHeader() {
        return masterHeader;
    }
}


