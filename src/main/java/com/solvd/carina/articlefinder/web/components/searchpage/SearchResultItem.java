package com.solvd.carina.articlefinder.web.components.searchpage;

import com.solvd.carina.articlefinder.util.CSSConstants;
import com.solvd.carina.articlefinder.util.DateTimeUtils;
import com.solvd.carina.articlefinder.util.StringConstants;
import com.solvd.carina.articlefinder.web.ArticlePage;
import com.solvd.carina.articlefinder.web.GeneralPage;
import com.solvd.carina.articlefinder.web.LiveArticlePage;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.solvd.carina.articlefinder.web.elements.Img;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class SearchResultItem extends AbstractGlobalUIObject {
    private static final Logger LOGGER = LogManager.getLogger(SearchResultItem.class);
    @FindBy(xpath = ".//span[@data-testid='todays-date']")
    private BoringElement pubDate;
    @FindBy(xpath = ".//a[1]")
    private Anchor articleLink;
    @FindBy(xpath = ".//a[1]/preceding-sibling::p[1]")
    private BoringElement articleTopic;
    @FindBy(xpath = ".//a[1]/h4[1]")
    private BoringElement articleHeadline;
    @FindBy(xpath = ".//a[1]/p[1]")
    private BoringElement articleDescription;
    @FindBy(xpath = ".//a[1]/p[2]")
    private BoringElement articleAuthor;
    @FindBy(xpath = ".//figure[@aria-label='media']/div/img")
    private Img previewImage;

    /* TODO:
        @FindBy(xpath = ".//a[1]/span[1]/span[text()='PRINT EDITION']/following-sibling::span")
        ExtendedWebElement printEditionDate;
     */

    public SearchResultItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
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

    public String getPubDateFontFamily() {
        return pubDate.getCssValue(CSSConstants.FONT_FAMILY);
    }

    public Double getPubDateFontSize() {
        String propertyValueString = articleTopic.getCssValue(CSSConstants.FONT_SIZE);
        double fontSize = 0.0;

        if (StringUtils.isNotBlank(propertyValueString)) {
            if (propertyValueString.contains(CSSConstants.REM)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.REM,
                        StringConstants.EMPTY_STRING
                );
            } else if (propertyValueString.contains(CSSConstants.PX)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.PX,
                        StringConstants.EMPTY_STRING
                );
            }

            fontSize = Double.parseDouble(propertyValueString);
        }

        return fontSize;
    }

    public String getPubDateColor() {
        return pubDate.getCssValue(CSSConstants.COLOR);
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

    public GeneralPage clickArticleLink() {
        String hrefValue = getArticleLinkHrefString();
        articleLink.click();

        GeneralPage articlePage;

        if (hrefValue != null && hrefValue.contains("/live/")) {
            articlePage = new LiveArticlePage(getDriver());
        } else {
            articlePage = new ArticlePage(getDriver());
        }

        return articlePage;
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

    public String getArticleTopicFontFamily() {
        return articleTopic.getCssValue(CSSConstants.FONT_FAMILY);
    }

    public Double getArticleTopicFontSize() {
        String propertyValueString = articleTopic.getCssValue(CSSConstants.FONT_SIZE);

        double fontSize = 0.0;


        if (StringUtils.isNotBlank(propertyValueString)) {
            if (propertyValueString.contains(CSSConstants.REM)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.REM,
                        StringConstants.EMPTY_STRING
                );
            } else if (propertyValueString.contains(CSSConstants.PX)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.PX,
                        StringConstants.EMPTY_STRING
                );
            }

            fontSize = Double.parseDouble(propertyValueString);
        }

        return fontSize;
    }

    public String getArticleTopicColor() {
        return articleTopic.getCssValue(CSSConstants.COLOR);
    }

    /*
        articleHeadline
    */

    public ExtendedWebElement getArticleHeadline() {
        return articleHeadline;
    }

    public boolean isArticleHeadlinePresent(long timeout) {
        return articleHeadline.isPresent(timeout);
    }

    public boolean isArticleHeadlinePresent() {
        return this.isArticleHeadlinePresent(1);
    }

    public String getArticleHeadlineTextString() {
        return articleHeadline.getText();
    }

    public String getArticleHeadlineFontFamily() {
        return articleHeadline.getCssValue(CSSConstants.FONT_FAMILY);
    }

    public Double getArticleHeadlineFontSize() {
        String propertyValueString = articleHeadline.getCssValue(CSSConstants.FONT_SIZE);
        double fontSize = 0.0;

        if (StringUtils.isNotBlank(propertyValueString)) {
            if (propertyValueString.contains(CSSConstants.REM)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.REM,
                        StringConstants.EMPTY_STRING
                );
            } else if (propertyValueString.contains(CSSConstants.PX)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.PX,
                        StringConstants.EMPTY_STRING
                );
            }

            fontSize = Double.parseDouble(propertyValueString);
        }

        return fontSize;
    }

    public String getArticleTitleColor() {
        return articleHeadline.getCssValue(CSSConstants.COLOR);
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

    public String getArticleDescriptionFontFamily() {
        return articleDescription.getCssValue(CSSConstants.FONT_FAMILY);
    }

    public Double getArticleDescriptionFontSize() {
        String propertyValueString =
                articleDescription.getCssValue(CSSConstants.FONT_SIZE);
        double fontSize = 0.0;

        if (StringUtils.isNotBlank(propertyValueString)) {
            if (propertyValueString.contains(CSSConstants.REM)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.REM,
                        StringConstants.EMPTY_STRING
                );
            } else if (propertyValueString.contains(CSSConstants.PX)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.PX,
                        StringConstants.EMPTY_STRING
                );
            }

            fontSize = Double.parseDouble(propertyValueString);
        }

        return fontSize;
    }

    public String getArticleDescriptionColor() {
        return articleDescription.getCssValue(CSSConstants.COLOR);
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

    public String getArticleAuthorFontFamily() {
        return articleAuthor.getCssValue(CSSConstants.FONT_FAMILY);
    }

    public Double getArticleAuthorFontSize() {
        String propertyValueString = articleAuthor.getCssValue(CSSConstants.FONT_SIZE);
        double fontSize = 0.0;

        if (StringUtils.isNotBlank(propertyValueString)) {
            if (propertyValueString.contains(CSSConstants.PX)) {
                propertyValueString = propertyValueString.replace(
                        CSSConstants.PX,
                        StringConstants.EMPTY_STRING
                );
            }

            fontSize = Double.parseDouble(propertyValueString);
        }

        return fontSize;
    }

    public String getArticleAuthorColor() {
        return articleAuthor.getCssValue(CSSConstants.COLOR);
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

    public String getPreviewImageSizesAttr() {
        return previewImage.getSizesAttrValueString();
    }

    public String getPreviewImageDecodingAttr() {
        return previewImage.getDecoding();
    }
}
