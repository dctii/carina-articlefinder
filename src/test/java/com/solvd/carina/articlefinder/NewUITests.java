package com.solvd.carina.articlefinder;

import com.solvd.carina.articlefinder.exception.WindowTabNotFoundException;
import com.solvd.carina.articlefinder.testutil.TestUtils;
import com.solvd.carina.articlefinder.testutil.WebTestConstants;
import com.solvd.carina.articlefinder.util.DriverUtils;
import com.solvd.carina.articlefinder.util.PageUtils;
import com.solvd.carina.articlefinder.web.ArticlePage;
import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.RegistrationWallFrame;
import com.solvd.carina.articlefinder.web.SearchResultsPage;
import com.solvd.carina.articlefinder.web.WirecutterHomePage;
import com.solvd.carina.articlefinder.web.components.generalpage.Footer;
import com.solvd.carina.articlefinder.web.components.generalpage.HeaderSearchInputForm;
import com.solvd.carina.articlefinder.web.components.generalpage.SiteIndex;
import com.solvd.carina.articlefinder.web.components.generalpage.SiteIndexOption;
import com.solvd.carina.articlefinder.web.components.homepage.HomeMasterHeader;
import com.solvd.carina.articlefinder.web.components.loginregistrationpage.EnterEmailForm;
import com.solvd.carina.articlefinder.web.components.othercomponents.SneakerProductCard;
import com.solvd.carina.articlefinder.web.components.searchpage.SearchPageSearchForm;
import com.solvd.carina.articlefinder.web.components.searchpage.SearchResultItem;
import com.solvd.carina.articlefinder.web.elements.interfaces.IHeadline;
import com.solvd.carina.articlefinder.web.otherpages.AdidasSneakerPage;
import com.zebrunner.carina.core.AbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class NewUITests extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(NewUITests.class);

    @DataProvider
    public static Object[][] queryText() {
        return new Object[][]{
//                {"trump"},
                {"biden"}
        };
    }

    @DataProvider
    public static Object[][] siteIndexSectionText() {
        return new Object[][]{
                {"news", "home page"},
                {"opinion", "columnists"},
                {"subscribe", "home delivery"},
        };
    }

    @DataProvider
    public static Object[][] expectedTabInfo() {
        return new Object[][]{
                {
                    "Licensing & Reprints",
                    "https://info.wrightsmedia.com/nyt-wirecutter-licensing"
                },
                {
                        "Jobs at Wirecutter",
                        "https://nytimes.wd5.myworkdayjobs.com/Wirecutter"
                },

        };
    }

    @DataProvider
    public static Object[][] sneakerTitles() {
        return new Object[][]{
                {"Samba Classic Shoes"},
                {"Samba Classic"}
        };
    }

    @DataProvider
    public static Object[][] siteIndexOptions() {
        return new Object[][]{
                {SiteIndexOption.BUSINESS},
                {SiteIndexOption.TECH},
                {SiteIndexOption.SCIENCE}
        };
    }

   /*
        1. Implement 1 Test which will take list of UI objects(not extended web element from the page) and
        check each element in this list on presenting of text, images and buttons. then check if all links
        in terms of element are working correctly. Example: Grid of search results on any e-commerce web
        site which has several products listed and you may see same elements in terms of 1 item like name
        price color and image (check this link https://www.nike.com/en/w?q=air&vst=air)
    */

    @Test(
            description = "Validate a simple search query",
            dataProvider = "queryText"
    )
    public void validateSearchItemElements(String queryText) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        HomeMasterHeader homeMasterHeader = homePage.getMasterHeader();

        homeMasterHeader.expandSearchInputBox();

        // type in query value
        HeaderSearchInputForm headerSearchInputForm = homeMasterHeader.getSearchInputForm();
        headerSearchInputForm.typeSearchInputValue(queryText);

        // check if value attribute matches query text
        Assert.assertEquals(
                headerSearchInputForm.getSearchInputValueAttrString(),
                queryText,
                String.format(
                        "Search input value does not match expected input queryText -- actual: %s" +
                                " ; expected: %s",
                        headerSearchInputForm.getSearchInputValueAttrString(),
                        queryText
                )
        );

        // submit
        AtomicReference<SearchResultsPage> searchResultsPage
                = new AtomicReference<>(headerSearchInputForm.clickSearchSubmitButton());

        AtomicReference<List<SearchResultItem>> searchResults
                = new AtomicReference<>(searchResultsPage.get().getSearchResultItems());

        // 'color' expectations
        final String PUB_DATE_COLOR = "rgba(153, 153, 153, 1)";
        final String TITLE_COLOR = "rgba(0, 0, 0, 1)";
        final String AUTHOR_COLOR = "rgba(18, 18, 18, 1)";
        final String OTHER_COLOR = "rgba(51, 51, 51, 1)";
        String topicColor, descriptionColor;
        topicColor = descriptionColor = OTHER_COLOR;

        // 'font-family' expectations
        final String FONT_NYT_FRANKLIN = "nyt-franklin";
        final String FONT_NYT_CHELTENHAM = "nyt-cheltenham";
        final String FONT_NYT_IMPERIAL = "nyt-imperial";
        String pubDateFont, topicFont, titleFont, descriptionFont, authorFont;
        pubDateFont = topicFont = FONT_NYT_FRANKLIN;
        titleFont = authorFont = FONT_NYT_CHELTENHAM;
        descriptionFont = FONT_NYT_IMPERIAL;

        // 'sizes' and decoding attributes expectations
        final String IMG_SIZES_EXPECTED_VAL = "(max-width: 600px) 120px, (max-width: 1024px) 165px, 205px";
        final String IMG_DECODING_EXPECTED_VAL = "async";

        // check each item
        searchResults.get().forEach(item -> {
            boolean isPubDateSmallestFontSize =
                    item.getPubDateFontSize() < item.getArticleHeadlineFontSize()
                            && item.getPubDateFontSize() < item.getArticleDescriptionFontSize();
            boolean isTopicAndPubDateFontSizeSame = Objects.equals(
                    item.getPubDateFontSize(),
                    item.getArticleTopicFontSize()
            );

            Assert.assertTrue(item.isPresent(), "Search item is not present");

            Assert.assertTrue(item.isPubDatePresent(), "Publishing date is not present");
            Assert.assertTrue(item.isArticleTopicPresent(), "Topic is not present");
            Assert.assertTrue(item.isArticleHeadlinePresent(), "Title is not present");
            Assert.assertTrue(item.isArticleDescriptionPresent(), "Description is not present");
            Assert.assertTrue(item.isPreviewImagePresent(), "Preview image is not present");


            /*
                Check colors
             */
            Assert.assertEquals(
                    item.getPubDateColor(),
                    PUB_DATE_COLOR,
                    "Publishing date color not matching"
            );

            Assert.assertEquals(
                    item.getArticleTopicColor(),
                    topicColor,
                    "Topic color not matching"
            );


            Assert.assertEquals(
                    item.getArticleTitleColor(),
                    TITLE_COLOR,
                    "Title color not matching"
            );


            Assert.assertEquals(
                    item.getArticleDescriptionColor(),
                    descriptionColor,
                    "Description color not matching"
            );

            /*
                Check fontFamily
             */

            Assert.assertTrue(
                    item.getPubDateFontFamily().contains(pubDateFont),
                    String.format(
                            "The '%s' font should not be missing from the font-family",
                            pubDateFont
                    )
            );
            Assert.assertTrue(
                    item.getArticleTopicFontFamily().contains(topicFont),
                    String.format(
                            "The '%s' font should not be missing from the font-family",
                            topicFont
                    )
            );
            Assert.assertTrue(
                    item.getArticleHeadlineFontFamily().contains(titleFont),
                    String.format(
                            "The '%s' font should not be missing from the font-family",
                            titleFont
                    )
            );
            Assert.assertTrue(
                    item.getArticleDescriptionFontFamily().contains(descriptionFont),
                    String.format(
                            "The '%s' font should not be missing from the font-family",
                            descriptionFont
                    )
            );



            /*
                Check font-sizes
                    - pubDate <= all
                    - titleFont >= all
             */

            Assert.assertTrue(
                    isPubDateSmallestFontSize && isTopicAndPubDateFontSizeSame,
                    "The pubDate's font size should be the smallest and the same as topic's"
            );

            Assert.assertTrue(
                    item.getArticleHeadlineFontSize() > item.getArticleDescriptionFontSize(),
                    "The title should not have a smaller font size than the description "

            );

            /*
                Check previewImage attribute values:
                - `sizes` attribute contains: (max-width: 600px) 120px, (max-width: 1024px) 165px, 205px
                - `decoding` attribute is async
             */

            Assert.assertEquals(
                    item.getPreviewImageSizesAttr(),
                    IMG_SIZES_EXPECTED_VAL
            );

            Assert.assertEquals(
                    item.getPreviewImageDecodingAttr(),
                    IMG_DECODING_EXPECTED_VAL
            );

            /*
                Check article author css values:
                - font-family: contains 'nyt-cheltenham'
                - font-size: no check
                - font-color: this==#121212
             */

            /*
                Check author element
                    - author is not always present, so check separately and at end
                        - e.g., https://www.nytimes.com/interactive/2024/02/08/us/special-counsel-report-on-biden-and-classified-documents.html
             */

            if (item.isArticleAuthorPresent()) {
                // author font size should be less than description's and greater than pubDate
                Assert.assertTrue(
                        item.getArticleAuthorFontSize() < item.getArticleDescriptionFontSize()
                                && item.getArticleAuthorFontSize() > item.getPubDateFontSize(),
                        String.format(
                                "Author font size (%s) should be between and not equal to description(%s) and pubDate(%s)",
                                item.getArticleAuthorFontSize(),
                                item.getArticleDescriptionFontSize(),
                                item.getPubDateFontSize()
                        )
                );

                Assert.assertEquals(
                        item.getArticleAuthorColor(),
                        AUTHOR_COLOR,
                        "Author color not matching"
                );

                Assert.assertTrue(
                        item.getArticleAuthorFontFamily().contains(authorFont),
                        String.format(
                                "The '%s' font should not be missing from the font-family",
                                authorFont
                        )
                );
            }

        });


        /* Do this after checking elements
            1. Click element and go to link.
            2. Check that page is correct link
                2.1. Check if URL contains the href from Anchor articleLink
                2.2. Check that title matches the article link -- use getTitle(), it should contain {articleLink}
            3. Use driver to go back and do the same for the rest
        */

        int halfSearchResultsSize = searchResults.get().size() / 2;

        IntStream.range(0, halfSearchResultsSize).forEach(i -> {
            // re-fetch page and results
            searchResultsPage.set(new SearchResultsPage(driver));
            searchResults.set(searchResultsPage.get().getSearchResultItems());

            SearchResultItem item = searchResults.get().get(i);
            String itemHeadlineString = item.getArticleHeadlineTextString();
            String itemHrefVal = item.getArticleLinkHrefString();
            if (itemHrefVal.contains("/live/")) {
                // expect url to be transformed url for live article pages
                itemHrefVal =
                        TestUtils.transformLiveArticleHrefToDestinationUrl(itemHrefVal);
            }

            // use IHeadline for different pages
            IHeadline articlePage = (IHeadline) item.clickArticleLink();
            String currUrl = driver.getCurrentUrl();

            // check that the url matches
            Assert.assertTrue(
                    currUrl.contains(itemHrefVal),
                    String.format(
                            "Current URL does not contain href value."
                                    + "\n - currentUrl = '%s'"
                                    + "\n - hrefValue = '%s'",
                            currUrl,
                            itemHrefVal
                    )
            );

            // check if headline exists
            Assert.assertTrue(
                    articlePage.doesHeadlineExistOnPage(itemHeadlineString),
                    "Headline does not exist on page."
            );

            // go back to previous page
            DriverUtils.navBack(driver);
        });
    }



    /*
        2. Find elements on the page by formatting of xpath in which you include in FindBy
        annotation. ExtendedWebElement is able to format string xpath with needed value. Example
        //div[@id='product-%s'] xpath in annotation than in method you call method format and it
        will replace automatically %s symbol to your value
     */

    @Test(
            description = "Validate site index section text exists while using formatting FindBy",
            dataProvider = "siteIndexSectionText"
    )
    public void validateSiteIndexElementsExist(String sectionLabelText, String sectionLinkText) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        SiteIndex siteIndex = homePage.getSiteIndex();

        // site index does not load until you scroll to it
        PageUtils.scrollToBottom(driver);

        Assert.assertTrue(
                siteIndex.isSectionLabelPresent(sectionLabelText),
                String.format(
                        "Section label '%s' is not present.",
                        sectionLabelText
                )
        );

        Assert.assertTrue(
                siteIndex.isSectionLinkPresent(sectionLinkText),
                String.format(
                        "Section link '%s' is not present.",
                        sectionLabelText
                )
        );
    }

    /*
        3. Find website with iframe element and switch context to this iframe and do some checks
        of elements

        iframe = registration paywall on article on New York Times website
     */

    @Test(
            description = "See the registration paywall drawer appear, switch to its frame and " +
                    "validate its elements",
            dataProvider = "queryText"
    )
    public void verifyRegistrationPaywallElements(String queryText) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        HomeMasterHeader homeMasterHeader = homePage.getMasterHeader();

        // expand the search query, type in query value and submit
        homeMasterHeader.expandSearchInputBox();
        HeaderSearchInputForm headerSearchInputForm = homeMasterHeader.getSearchInputForm();
        headerSearchInputForm.typeSearchInputValue(queryText);
        SearchResultsPage searchResultsPage = headerSearchInputForm.clickSearchSubmitButton();

        // get a non-live article; non-live articles won't have a registration wall that appears
        SearchResultItem searchResult =
                searchResultsPage.getSearchResultItems().stream()
                        .filter(
                                item -> !item.getArticleLinkHrefString().contains("/live/")
                        ).findFirst()
                        .orElse(null);

        ArticlePage articlePage = (ArticlePage) searchResult.clickArticleLink();

        // check for registration wall
        Assert.assertTrue(
                articlePage.isRegistrationWallPresent(10),
                "Registration wall iframe is not present after 10 seconds"
        );

        RegistrationWallFrame wallFrame =
                articlePage.switchToRegistrationWallFrame();

        /*
            verify elements in registration frame
         */
        Assert.assertTrue(
                wallFrame.isEnterEmailFormPresent(5),
                "Email form is not present"
        );

        EnterEmailForm emailForm = wallFrame.getEnterEmailForm();

        Assert.assertEquals(
                emailForm.getFormHeaderTextString().trim(),
                "Create a free account, or log in.",
                String.format(
                        "Form header text does not match. Actual '%s'; Expected: '%s'",
                        emailForm.getFormHeaderTextString().trim(),
                        "Create a free account, or log in."
                )
        );
        Assert.assertEquals(
                emailForm.getFormSubHeaderTextString().trim(),
                "Gain access to limited free articles, news alerts, select newsletters, podcasts and some daily games.",
                String.format(
                        "Form sub header text does not match. Actual '%s'; Expected: '%s'",
                        emailForm.getFormSubHeaderTextString().trim(),
                        "Gain access to limited free articles, news alerts, select newsletters, podcasts and some daily games."
                )
        );
        Assert.assertEquals(
                emailForm.getEmailAddresInputLabelTextString().trim(),
                "Email Address",
                String.format(
                        "Email input label text does not match. Actual '%s'; Expected: '%s'",
                        emailForm.getEmailAddresInputLabelTextString().trim(),
                        "Email Address"
                )
        );
        Assert.assertTrue(
                emailForm.isEmailInputFieldPresent(),
                "Email input field is not present."
        );
        Assert.assertTrue(
                emailForm.isContinueButtonPresent(),
                "Continue button is not present."
        );
        Assert.assertTrue(
                emailForm.isSsoFacebookButtonPresent(),
                "SSO Button for facebook is not present."
        );
        Assert.assertTrue(
                emailForm.isSsoGoogleButtonPresent(),
                "SSO Button for google is not present."
        );
        Assert.assertTrue(
                emailForm.isSsoAppleButtonPresent(),
                "SSO Button for apple is not present."
        );


        // switch back to the root frame and verify if iframe is present
        // if true, means switched back to root frame successfully
        articlePage = articlePage.switchToThisRootFrame();
        Assert.assertTrue(
                articlePage.isRegistrationWallPresent(5),
                "Registration wall is present"
        );
    }

    /*
        4. Find web site where click on the link automatically opens new tab in browser, switch to
        this tab and check that link is correct.
     */
    @Test(
            description = "Open the California Notices link, switch the opened tab and verify link",
            dataProvider = "expectedTabInfo"
    )
    public void validateNewTabUrls(String footerText, String expectedTabUrl) {
        WebDriver driver = getDriver();

        WirecutterHomePage page = new WirecutterHomePage(driver);
        page.open();

        PageUtils.scrollToBottom(driver);

        // store originalTabId and originalUrl
        String originalTab = driver.getWindowHandle();
        String originalUrl = driver.getCurrentUrl();

        // close the newsletter if it appears
        page.clickCloseNewsletterButton();

        // click the footer link
        Footer footer = page.getFooter();
        footer.clickFooterLink(footerText);

        // get the new tab handle and switch to it
        String newTab = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(originalTab))
                .findFirst()
                .orElseThrow(() -> new WindowTabNotFoundException("New tab not found"));

        // switch to new tab, check that two tabs are open
        driver.switchTo().window(newTab);
        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        // validate the url is not original tab and that new one matches expected
        Assert.assertNotEquals(
                driver.getCurrentUrl(),
                originalUrl,
                String.format(
                        "URL matches original tab url when it shouldn't. Actual: '%s'; Expected: '%s'",
                        driver.getCurrentUrl(),
                        expectedTabUrl
                )
        );
        Assert.assertEquals(
                driver.getCurrentUrl(),
                expectedTabUrl,
                String.format(
                        "URL does not match expected. Actual: '%s'; Expected: '%s'",
                        driver.getCurrentUrl(),
                        expectedTabUrl
                )
        );

        // close currently opened tab and go back to original window
        driver.close();
        driver.switchTo().window(originalTab);

        Assert.assertEquals(driver.getWindowHandles().size(), 1);

    }

    /*
        5. Find web site which uses hover logic and check if it is works correctly( shows needed
        elements). Example (https://www.nike.com/en/w?q=air&vst=air) if you will hover image of
        product by mouse you will see variants of the product

     */

    @Test(
            description = "check hover logic on sneakers",
            dataProvider = "sneakerTitles"
    )
    public void verifySneakerHoverChanges(String sneakerTitle) {
        WebDriver driver = getDriver();
        AdidasSneakerPage page = new AdidasSneakerPage(driver);
        page.open();

        Assert.assertTrue(
                page.doesSneakerByTitleExist(sneakerTitle),
                String.format(
                        "'%s' sneakers do not exist",
                        sneakerTitle
                )
        );

        SneakerProductCard sneaker = page.getSneakerByTitle(sneakerTitle);

        // hover over the image so the product variations appear
        sneaker.hoverOnProductImage();

        // hover over product variation 1
        // save the productImage src and srcset into a string value
        // save the product details href after hovering on var 1
        sneaker.hoverOnProductVariationThumbByIndex(0);
        String sneakerDetailsHrefVar1 = sneaker.getSneakerDetailsHrefVal();
        String sneakerProductImageSrcVar1 = sneaker.getProductImageSrc();
        String sneakerProductImageSrcSetVar1 = sneaker.getProductImageSrcSet();

        // hover over product variation 2
        // save the productImage src and srcset into a string value
        // save the product details href after hovering on var 2
        sneaker.hoverOnProductVariationThumbByIndex(1);
        String sneakerDetailsHrefVar2 = sneaker.getSneakerDetailsHrefVal();
        String sneakerProductImageSrcVar2 = sneaker.getProductImageSrc();
        String sneakerProductImageSrcSetVar2 = sneaker.getProductImageSrcSet();

        Assert.assertNotEquals(
                sneakerDetailsHrefVar1,
                sneakerDetailsHrefVar2,
                String.format(
                        "The href value for the product did not change on hover. \nVar1: '%s' " +
                                "\nVar2: '%s'",
                        sneakerDetailsHrefVar1,
                        sneakerDetailsHrefVar2
                )
        );
        Assert.assertNotEquals(
                sneakerProductImageSrcVar1,
                sneakerProductImageSrcVar2,
                String.format(
                        "The product image src value for the product did not change on hover. " +
                                "\nVar1: '%s' " +
                                "\nVar2: '%s'",
                        sneakerProductImageSrcVar1,
                        sneakerProductImageSrcVar2
                )
        );
        Assert.assertNotEquals(
                sneakerProductImageSrcSetVar1,
                sneakerProductImageSrcSetVar2,
                String.format(
                        "The product image srcset value for the product did not change on hover. " +
                                "\nVar1: '%s' " +
                                "\nVar2: '%s'",
                        sneakerProductImageSrcSetVar1,
                        sneakerProductImageSrcSetVar2
                )
        );
    }

    /*
        6. Find web site which support search suggestions and check that they correspond to your
        search input.
     */

    @Test(
            description = "Make a search query on the search page and see if the search " +
                    "suggestion items contain the query text",
            dataProvider = "queryText"
    )
    public void validateSearchSuggestions(String queryText) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        driver.navigate().to(WebTestConstants.URL_SEARCH_RESULTS_PAGE_URL);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        SearchPageSearchForm searchForm = searchResultsPage.getSearchForm();
        searchForm.typeSearchInputValue(queryText);

        Assert.assertTrue(
                searchResultsPage.allSuggestionsHaveQueryText(queryText),
                String.format(
                        "One or more of the search suggestions exclude the queryText: '%s'.",
                        queryText
                )
        );
    }

    /*
        7. Find website with navigation menu and implement navigation logic with enum input.
        Example somePage.getMenu().navigate(Option.SHOES); and this should open appropriate point in menu.

        Use with navigation menu
     */

    @Test(
            description = "Navigate to site index links with SiteIndexOption",
            dataProvider = "siteIndexOptions"
    )
    public void verifyNavigationWithEnum(SiteIndexOption option) {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();

        String originalUrl = driver.getCurrentUrl();

        // navigate to option
        page.getSiteIndex().navigate(option);

        String currUrl = driver.getCurrentUrl();


        Assert.assertNotEquals(
                originalUrl,
                currUrl,
                String.format(
                        "URLs should not match. Original: '%s'; Expected Curr: '%s'",
                        originalUrl,
                        currUrl
                )
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains(option.getSubPath()),
                String.format(
                        "URLs should include sub path. Current URL: '%s'; Expected Sub Path: '%s'",
                        driver.getCurrentUrl(),
                        option.getSubPath()
                )
        );
    }



    /*
        8. (Optional challenge) Using 1 selenium as Hub and 2 seleniums as nodes locally execute 2 several tests
        in 2 threads.
     */

    /*
        9. (Optional challenge) Start new session of browser in test and login to the site with new
         user created by HTTP call in separate thread. You will see how it saves time when you
         need to create new user for particular test case
     */


}
