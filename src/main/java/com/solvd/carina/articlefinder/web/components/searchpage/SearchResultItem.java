package com.solvd.carina.articlefinder.web.components.searchpage;

import com.solvd.carina.articlefinder.util.DateTimeUtils;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class SearchResultItem extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(SearchResultItem.class);
    @FindBy(xpath = ".//span[@data-testid='todays-date']")
    private ExtendedWebElement pubDate;
    @FindBy(xpath = ".//a[1]")
    private Anchor articleLink;
    @FindBy(xpath = ".//a[1]/preceding-sibling::p[1]")
    private ExtendedWebElement articleTopic;
    @FindBy(xpath = ".//a[1]/h4[1]")
    private ExtendedWebElement articleTitle;
    @FindBy(xpath = ".//a[1]/p[1]")
    private ExtendedWebElement articleDescription;
    @FindBy(xpath = ".//a[1]/p[2]")
    private ExtendedWebElement articleAuthor;
    @FindBy(xpath = ".//figure[@aria-label='media']/div/img")
    private ExtendedWebElement previewImage;

    /* TODO:
        @FindBy(xpath = ".//a[1]/span[1]/span[text()='PRINT EDITION']/following-sibling::span")
        ExtendedWebElement printEditionDate;
     */

    public SearchResultItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        self
     */

    public ExtendedWebElement getSelf() {
        return this.getRootExtendedElement();
    }

    public boolean isPresent(long timeout) {
        return this.getSelf().isPresent(timeout);
    }

    public boolean isPresent() {
        return this.isPresent(1);
    }

    /*
        pubDate
    */

    public ExtendedWebElement getPubDate() {
        return pubDate;
    }

    public boolean isPubDatePresent(long timeout) {
        return pubDate.isPresent(timeout);
    }

    public boolean isPubDatePresent() {
        return this.isPubDatePresent(1);
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

    /*
        articleLink
    */

    public Anchor getArticleLink() {
        return articleLink;
    }

    public boolean isArticleLinkPresent(long timeout) {
        return articleLink.isPresent(timeout);
    }

    public boolean isArticleLinkPresent() {
        return this.isArticleLinkPresent(1);
    }

    public String getArticleLinkHrefString() {
        return articleLink.getHref();
    }

    public void clickArticleLink() {
        articleLink.click();
    }

    /*
        articleTopic
    */

    public ExtendedWebElement getArticleTopic() {
        return articleTopic;
    }

    public boolean isArticleTopicPresent(long timeout) {
        return articleTopic.isPresent(timeout);
    }

    public boolean isArticleTopicPresent() {
        return this.isArticleTopicPresent(1);
    }

    public String getArticleTopicTextString() {
        return articleTopic.getText();
    }

    /*
        articleTitle
    */

    public ExtendedWebElement getArticleTitle() {
        return articleTitle;
    }

    public boolean isArticleTitlePresent(long timeout) {
        return articleTitle.isPresent(timeout);
    }

    public boolean isArticleTitlePresent() {
        return this.isArticleTitlePresent(1);
    }

    public String getArticleTitleTextString() {
        return articleTitle.getText();
    }

    /*
        articleDescription
    */

    public ExtendedWebElement getArticleDescription() {
        return articleDescription;
    }

    public boolean isArticleDescriptionPresent(long timeout) {
        return articleDescription.isPresent(timeout);
    }

    public boolean isArticleDescriptionPresent() {
        return this.isArticleDescriptionPresent(1);
    }

    public String getArticleDescriptionTextString() {
        return articleDescription.getText();
    }

    /*
        articleAuthor
    */

    public ExtendedWebElement getArticleAuthor() {
        return articleAuthor;
    }

    public boolean isArticleAuthorPresent(long timeout) {
        return articleAuthor.isPresent(timeout);
    }

    public boolean isArticleAuthorPresent() {
        return this.isArticleAuthorPresent(1);
    }

    public String getArticleAuthorTextString() {
        return articleAuthor.getText();
    }

    /*
        previewImage
    */

    public ExtendedWebElement getPreviewImage() {
        return previewImage;
    }

    public boolean isPreviewImagePresent(long timeout) {
        return previewImage.isPresent(timeout);
    }

    public boolean isPreviewImagePresent() {
        return this.isPreviewImagePresent(1);
    }
}
