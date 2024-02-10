package com.solvd.carina.articlefinder;

import com.solvd.carina.articlefinder.testutil.TestClassConstants;
import com.solvd.carina.articlefinder.testutil.WebTestConstants;
import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.SearchResultsPage;
import com.solvd.carina.articlefinder.web.components.generalpage.HeaderSearchInputForm;
import com.solvd.carina.articlefinder.web.components.homepage.HomeMasterHeader;
import com.solvd.carina.articlefinder.web.components.searchpage.SearchPageSearchStatus;
import com.zebrunner.carina.core.AbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchWebTest extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.SEARCH_WEB_TEST);

    @DataProvider
    public static Object[][] queryText() {
        return new Object[][]{
                {"trump"},
                {"biden"}
        };
    }

    @DataProvider
    public static Object[][] absurdQueryText() {
        return new Object[][]{
                {"24j5k6jnkchdfkljgsgkjslfjdf"},
                {"tjkjn2l3k4jn5234"}
        };
    }


    @Test(
            description = "Validate functionality of search expander",
            dataProvider = "queryText"
    )
    public void validateSearchExpander(String queryText) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        HomeMasterHeader homeMasterHeader = homePage.getMasterHeader();

        // initially, it should not be expanded
        Assert.assertFalse(
                homeMasterHeader.getSearchButtonAriaExpandedBoolean(),
                "Search input form should not be expanded"
        );

        // expand and check expansion
        homeMasterHeader.expandSearchInputBox();

        Assert.assertTrue(
                homeMasterHeader.getSearchButtonAriaExpandedBoolean(),
                "Search input form should not be collapsed"
        );

        // collapse and check if expanded
        homeMasterHeader.collapseSearchInputBox();

        Assert.assertFalse(
                homeMasterHeader.getSearchButtonAriaExpandedBoolean(),
                "Search input form should not be expanded"
        );

        // expand again, type something in, and then collapse, asserting throughout
        homeMasterHeader.expandSearchInputBox();

        Assert.assertTrue(
                homeMasterHeader.getSearchButtonAriaExpandedBoolean(),
                "Search input form should not be collapsed"
        );

        homeMasterHeader.getSearchInputForm().typeSearchInputValue(queryText);

        homeMasterHeader.collapseSearchInputBox();

        Assert.assertFalse(
                homeMasterHeader.getSearchButtonAriaExpandedBoolean(),
                "Search input form should not be expanded"
        );
    }

    @Test(
            description = "Validate a simple search query",
            dataProvider = "queryText"
    )
    public void validateSimpleSearchQuery(String queryText) {
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
        SearchResultsPage searchResultsPage = headerSearchInputForm.clickSearchSubmitButton();

        final String EXPECTED_SEARCH_URL =
                WebTestConstants.URL_SEARCH_RESULTS_PAGE_URL
                        + WebTestConstants.URL_QS_QUERY_PARAM
                        + queryText;

        // check if url is as expected
        Assert.assertEquals(
                searchResultsPage.getCurrentUrl(),
                EXPECTED_SEARCH_URL,
                String.format(
                        "URLs do not match -- actual: %s ; expected: %s",
                        searchResultsPage.getCurrentUrl(),
                        EXPECTED_SEARCH_URL
                )
        );

        // validate that search query value for search page matches query text
        SearchPageSearchStatus searchStatus = searchResultsPage.getSearchForm().getSearchResultsStatus();
        Assert.assertEquals(
                searchStatus.getSearchQueryTextString(),
                queryText,
                String.format(
                        "The input query text does not match the value being used for the search results"
                                + " page -- actual: %s ; expected: %s",
                        searchStatus.getSearchQueryTextString(),
                        queryText
                )
        );

        // validate that one or more results for query
        Assert.assertTrue(
                searchStatus.getTotalResultsCount() > 0,
                String.format(
                        "There should be one or more search results. Total results count: %s.",
                        searchStatus.getTotalResultsCount()
                )
        );
    }

    @Test(
            description = "Validate a simple search query with an absurd string and expect 0 search results",
            dataProvider = "absurdQueryText"
    )
    public void validateSimpleSearchWithAbsurdString(String absurdQueryText) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        HomeMasterHeader homeMasterHeader = homePage.getMasterHeader();

        homeMasterHeader.expandSearchInputBox();

        // type in query value
        HeaderSearchInputForm headerSearchInputForm = homeMasterHeader.getSearchInputForm();
        headerSearchInputForm.typeSearchInputValue(absurdQueryText);

        // check if value attribute matches query text
        Assert.assertEquals(
                headerSearchInputForm.getSearchInputValueAttrString(),
                absurdQueryText,
                String.format(
                        "Search input value does not match expected input queryText -- actual: %s" +
                                " ; expected: %s",
                        headerSearchInputForm.getSearchInputValueAttrString(),
                        absurdQueryText
                )
        );

        // submit
        SearchResultsPage searchResultsPage = headerSearchInputForm.clickSearchSubmitButton();

        String expectedSearchUrl =
                WebTestConstants.URL_SEARCH_RESULTS_PAGE_URL
                        + WebTestConstants.URL_QS_QUERY_PARAM
                        + absurdQueryText;

        // check if url is as expected
        Assert.assertEquals(
                searchResultsPage.getCurrentUrl(),
                expectedSearchUrl,
                String.format(
                        "URLs do not match -- actual: %s ; expected: %s",
                        searchResultsPage.getCurrentUrl(),
                        expectedSearchUrl
                )
        );

        // validate that search query value for search page matches query text
        SearchPageSearchStatus searchStatus = searchResultsPage.getSearchForm().getSearchResultsStatus();
        Assert.assertEquals(
                searchStatus.getSearchQueryTextString(),
                absurdQueryText,
                "The input query text does not match the value being used for the search results page."
        );

        // there should be 0 results
        Assert.assertEquals(
                searchStatus.getTotalResultsCount(),
                0,
                "There should be one or more search results."
        );
    }


}
