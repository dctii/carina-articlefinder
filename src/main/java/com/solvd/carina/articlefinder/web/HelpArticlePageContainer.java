package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.helppage.HelpArticleCard;
import com.solvd.carina.articlefinder.web.components.helppage.HelpArticleSubNav;
import com.solvd.carina.articlefinder.web.components.helppage.HelpArticleVoter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HelpArticlePageContainer extends HelpPageContainer {

    @FindBy(xpath = ".//nav[@class='sub-nav']")
    private HelpArticleSubNav subNav;
    @FindBy(xpath = ".//aside[@class='UH-layout-sidebar']/section[@class='UH-help-card']")
    private HelpArticleCard helpCard;
    @FindBy(xpath = ".//div[@class='article-votes']")
    private HelpArticleVoter articleVoter;

    public HelpArticlePageContainer(WebDriver driver) {
        super(driver);
    }
}
