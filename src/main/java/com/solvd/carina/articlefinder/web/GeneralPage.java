package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.generalpage.GeneralMasterHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class GeneralPage extends PageContainer {

    @FindBy(xpath = "//div[@data-testid='masthead-container']/header")
    GeneralMasterHeader masterHeader;


    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    public GeneralMasterHeader getMasterHeader() {
        return masterHeader;
    }

}
