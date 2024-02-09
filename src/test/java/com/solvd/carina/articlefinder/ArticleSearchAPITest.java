package com.solvd.carina.articlefinder;

import com.solvd.carina.articlefinder.api.ArticleSearch;
import com.solvd.carina.articlefinder.api.BadArticleSearch;
import com.solvd.carina.articlefinder.api.UnauthorizedArticleSearch;
import com.solvd.carina.articlefinder.bin.Article;
import com.solvd.carina.articlefinder.bin.ArticleSearchResponse;
import com.solvd.carina.articlefinder.bin.BadResponse;
import com.solvd.carina.articlefinder.bin.FaultResponse;
import com.solvd.carina.articlefinder.testutil.TestClassConstants;
import com.solvd.carina.articlefinder.testutil.TestUtils;
import com.solvd.carina.articlefinder.util.ArticleSearchResponseConstants;
import com.solvd.carina.articlefinder.util.BooleanUtils;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.FilepathConstants;
import com.solvd.carina.articlefinder.util.JacksonUtils;
import com.solvd.carina.articlefinder.util.QueryStringBuilder;
import com.solvd.carina.articlefinder.util.StringConstants;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class ArticleSearchAPITest {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.ARTICLE_SEARCH_TEST);

    @DataProvider
    public static Object[][] queriesWithBrokenFilterQueryParam() {
        return new Object[][]{
                // leave off opening parenthesis on value for pub_date filter query field
                {
                        new QueryStringBuilder().addQueryParam("trump")
                                .addFilterQueryParam("headline:\"Supreme Court to Mull Trump Ballot Questions\")")
                                .build()
                },
                // leave off closing parenthesis on value for pub_date filter query field
                {
                        new QueryStringBuilder().addQueryParam("biden")
                                .addFilterQueryParam("pub_year:(\"2024\"")
                                .build()
                }
        };
    }

    @DataProvider
    public static Object[][] articleSearchQueries() {
        return new Object[][]{
                // query with "trump"
                {
                        new QueryStringBuilder().addQueryParam("trump").build()
                },

                // query with "biden"
                {
                        new QueryStringBuilder().addQueryParam("biden").build()
                },
        };
    }

    @DataProvider
    public static Object[][] mainHeadlineValues() {
        return new Object[][]{
                {"\"Supreme Court to Mull Trump Ballot Questions\""},
                {"\"How Trump Uses the Power and Imagery of His Presidency\""}
        };
    }

    @DataProvider
    public static Object[][] queriesSortedByNewest() {
        return new Object[][]{
                // query "trump" with sort=newest
                {
                        new QueryStringBuilder().addQueryParam("trump")
                                .addSortByNewestParam().build()
                }

                // NOTE: temporarily disabled to avoid hitting api call limit
                // query "biden" with sort=newest
//                {
//                        new QueryStringBuilder().addQueryParam("biden")
//                                .addSortByNewestParam().build()
//                },
        };
    }


    @Test(
            description = "Try an invalid filter query with missing value boundary markers",
            dataProvider = "queriesWithBrokenFilterQueryParam"
    )
    public void tryInvalidFilterQuery(String queryString) {

        // instantiate the BadArticleSearch API method with the query string
        BadArticleSearch badArticleSearch = new BadArticleSearch(queryString);

        // call api, expect 400 response
        badArticleSearch.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
        String rs = badArticleSearch.callAPI().asString();

        // validate 400 response json schema
        badArticleSearch.validateResponseAgainstSchema(FilepathConstants.ARTICLE_SEARCH_400_RS_SCHEMA_JSON);

        // deserialize the response into BadResponse
        BadResponse response = JacksonUtils.deserializeJson(rs, ClassConstants.BAD_RESPONSE);


        // assert the status is "ERROR"
        Assert.assertEquals(
                response.getStatus(),
                ArticleSearchResponseConstants.STATUS_ERROR,
                "The status is not ERROR."
        );
        // assert the copyright matches
        Assert.assertEquals(response.getCopyright(),
                ArticleSearchResponseConstants.COPYRIGHT_STRING,
                "The copyright string doesn't match."
        );
    }

    @Test(
            description = "Try to make a search query with an empty string for the 'api-key' parameter.",
            dataProvider = "articleSearchQueries"
    )
    public void tryQueryWithEmptyApiKey(String queryString) {

        // instantiate the UnauthorizedArticleSearch API method with the queryString but have empty string for the api key
        UnauthorizedArticleSearch articleSearch = new UnauthorizedArticleSearch(
                queryString,
                StringConstants.EMPTY_STRING
        );

        // call the api and expect a 401
        articleSearch.expectResponseStatus(HttpResponseStatusType.UNAUTHORIZED_401);
        String rs = articleSearch.callAPI().asString();

        // validate the response against the fault response JSON schema
        articleSearch.validateResponseAgainstSchema(FilepathConstants.ARTICLE_SEARCH_FAULT_RS_SCHEMA_JSON);

        // deserialize the response into FaultResponse
        FaultResponse response = JacksonUtils.deserializeJson(rs, ClassConstants.FAULT_RESPONSE);

        // assert the faultstring for the error matches
        Assert.assertEquals(
                response.getFault().getFaultString(),
                ArticleSearchResponseConstants.EMPTY_API_KEY_VALUE_FAULTSTRING,
                "The FaultResponse.Fault.faultString does not match."
        );
        // assert the detail.errorcode for the error matches
        Assert.assertEquals(
                response.getFault().getDetail().getErrorCode(),
                ArticleSearchResponseConstants.EMPTY_API_KEY_VALUE_DETAIL_ERRORCODE,
                "The FaultResponse.Fault.Detail.errorCode does not match."
        );
    }

    @Test(
            description = "Try to make a search query without an 'api-key' parameter.",
            dataProvider = "articleSearchQueries"
    )
    public void tryQueryWithoutApiKey(String queryString) {

        // instantiate the UnauthorizedArticleSearch API method with queryString, but use null for the api key
        // null for the apiKeyValue with this constructor will completely exclude the 'api-key' param
        UnauthorizedArticleSearch articleSearch =
                new UnauthorizedArticleSearch(queryString, null);

        // call the api and expect a 401
        articleSearch.expectResponseStatus(HttpResponseStatusType.UNAUTHORIZED_401);
        String rs = articleSearch.callAPI().asString();

        // validate the response against the fault response JSON schema
        articleSearch.validateResponseAgainstSchema(FilepathConstants.ARTICLE_SEARCH_FAULT_RS_SCHEMA_JSON);

        // deserialize the response into FaultResponse
        FaultResponse response = JacksonUtils.deserializeJson(rs, ClassConstants.FAULT_RESPONSE);

        // assert the faultstring for the error matches
        Assert.assertEquals(
                response.getFault().getFaultString(),
                ArticleSearchResponseConstants.NO_API_KEY_PARAM_FAULTSTRING,
                "The FaultResponse.Fault.faultString does not match."
        );
        // assert the detail.errorcode for the error matches
        Assert.assertEquals(
                response.getFault().getDetail().getErrorCode(),
                ArticleSearchResponseConstants.NO_API_KEY_PARAM_DETAIL_ERRORCODE,
                "The FaultResponse.Fault.Detail.errorCode does not match."
        );
    }


    @Test(
            description = "Verify main headline exists for article search with filter query parameter for headline",
            dataProvider = "mainHeadlineValues"
    )
    public void verifyFilterQueryForHeadline(String mainHeadline) {

        // build the query string with the filter query that uses the 'headline' field and mainHeadline as value
        QueryStringBuilder queryStringBuilder = new QueryStringBuilder();
        queryStringBuilder.addFilterQueryParam(
                String.format("headline:(%s)", mainHeadline)
        );

        // instantiate the ArticleSearch API method with the built query string
        ArticleSearch articleSearch = new ArticleSearch(queryStringBuilder.build());

        // call api, expect 200
        articleSearch.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = articleSearch.callAPI().asString();

        // validate the response against good article search response json schema
        articleSearch.validateResponseAgainstSchema(FilepathConstants.ARTICLE_SEARCH_RS_SCHEMA_JSON);

        // deserialize the response into ArticleSearchResponse
        ArticleSearchResponse response = JacksonUtils.deserializeJson(rs, ClassConstants.ARTICLE_SEARCH_RESPONSE);

        // assert status string is OK
        Assert.assertEquals(
                response.getStatus(),
                ArticleSearchResponseConstants.STATUS_OK,
                "The status is not OK."
        );

        // assert that all articles have the given main headline
        boolean articlesFound = BooleanUtils.allArticlesHaveMainHeadline(mainHeadline, response);
        Assert.assertTrue(articlesFound, "The expected article was not found.");
    }

    @Test(
            description = "Verify 'sort=newest' query parameter is returning sorting order from newest pub_date to oldest pub_date for the first page",
            dataProvider = "queriesSortedByNewest"
    )
    public void verifyQuerySortingIsNewest(String queryString) {

        // instantiate the ArticleSearch API method with the queryString
        ArticleSearch articleSearch = new ArticleSearch(queryString);

        // call api, expect 200
        articleSearch.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = articleSearch.callAPI().asString();

        // validate the response against good article search response json schema
        articleSearch.validateResponseAgainstSchema(FilepathConstants.ARTICLE_SEARCH_RS_SCHEMA_JSON);

        // Deserialize the response into ArticleSearchResponse
        ArticleSearchResponse response = JacksonUtils.deserializeJson(rs, ClassConstants.ARTICLE_SEARCH_RESPONSE);


        // assert status string is OK
        Assert.assertEquals(
                response.getStatus(),
                ArticleSearchResponseConstants.STATUS_OK,
                "The status is not OK."
        );

        List<Article> articles = response.getResponse().getDocs();


        boolean isSortedByNewest = TestUtils.areArticlesSortedByNewest(articles);

        Assert.assertTrue(isSortedByNewest, "Articles are not sorted by newest first.");
    }
}
