package com.solvd.carina.articlefinder.web.components.searchpage;

import com.solvd.carina.articlefinder.util.DateTimeUtils;
import com.solvd.carina.articlefinder.web.components.generic.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class SearchResultItem extends AbstractUIObject {
    @FindBy(xpath = ".//span[@data-testid='todays-date']")
    ExtendedWebElement pubDate;
    @FindBy(xpath = ".//a[1]")
    Anchor articleLink;
    @FindBy(xpath = ".//a[1]/preceding-sibling::p[1]")
    ExtendedWebElement articleTopic;
    @FindBy(xpath = ".//a[1]/h4[1]")
    ExtendedWebElement articleTitle;
    @FindBy(xpath = ".//a[1]/p[1]")
    ExtendedWebElement articleDescription;
    @FindBy(xpath = ".//a[1]/p[2]")
    ExtendedWebElement articleAuthor;
    @FindBy(xpath = ".//figure[@aria-label='media']/div/img")
    ExtendedWebElement previewImage;

    /* TODO:
        @FindBy(xpath = ".//a[1]/span[1]/span[text()='PRINT EDITION']/following-sibling::span")
        ExtendedWebElement printEditionDate;
     */

    public SearchResultItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getPubDate() {
        return pubDate;
    }

    public String getPubDateTextString() {
        /* Date format examples below of what would be returned:
            Feb. 6 --> Feb. 6, 2024
            Oct. 2, 2023
            June 27, 2023
            April 3, 2023
        */
        return pubDate.getText();
    }

    public LocalDate getPubDateAsLocalDate() {
        return DateTimeUtils.pubDateToLocalDate(getPubDateTextString());
    }

    public Anchor getArticleLink() {
        return articleLink;
    }

    public String getArticleLinkHrefString() {
        return articleLink.getHref();
    }

    public void clickArticleLink() {
        articleLink.click();
    }

    public ExtendedWebElement getArticleTopic() {
        return articleTopic;
    }

    public String getArticleTopicTextString() {
        return articleTopic.getText();
    }

    public ExtendedWebElement getArticleTitle() {
        return articleTitle;
    }

    public String getArticleTitleTextString() {
        return articleAuthor.getText();
    }

    public ExtendedWebElement getArticleDescription() {
        return articleDescription;
    }

    public String getArticleDescriptionTextString() {
        return articleDescription.getText();
    }

    public ExtendedWebElement getArticleAuthor() {
        return articleAuthor;
    }

    public String getArticleAuthorTextString() {
        return articleAuthor.getText();
    }

    public ExtendedWebElement getPreviewImage() {
        return previewImage;
    }

}
