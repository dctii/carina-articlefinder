package com.solvd.carina.articlefinder.testutil;

import com.solvd.carina.articlefinder.ArticleSearchAPITest;
import com.solvd.carina.articlefinder.HomePageWebTest;
import com.solvd.carina.articlefinder.LogInAndRegistrationTest;
import com.solvd.carina.articlefinder.SearchWebTest;
import com.solvd.carina.articlefinder.util.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TestClassConstants {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.class);

    private TestClassConstants() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    // com.solvd.carina.articlefinder
    public static final Class<ArticleSearchAPITest> ARTICLE_SEARCH_API_TEST = ArticleSearchAPITest.class;
    public static final Class<HomePageWebTest> HOME_PAGE_WEB_TEST = HomePageWebTest.class;
    public static final Class<LogInAndRegistrationTest> LOG_IN_AND_REGISTRATION_TEST = LogInAndRegistrationTest.class;
    public static final Class<SearchWebTest> SEARCH_WEB_TEST = SearchWebTest.class;

    // com.solvd.carina.articlefinder.testutil

    public static final Class<TestClassConstants> TEST_CLASS_CONSTANTS = TestClassConstants.class;
    public static final Class<TestUtils> TEST_UTILS = TestUtils.class;
    public static final Class<WebTestConstants> WEB_TEST_CONSTANTS = WebTestConstants.class;
    public static final Class<WebTestUtils> WEB_TEST_UTILS = WebTestUtils.class;


}
