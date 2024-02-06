package com.solvd.carina.articlefinder.testutil;

import com.solvd.carina.articlefinder.ArticleSearchTest;
import com.solvd.carina.articlefinder.util.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TestClassConstants {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.class);

    private TestClassConstants() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    // com.solvd.carina.articlefinder
    public static final Class<ArticleSearchTest> ARTICLE_SEARCH_TEST = ArticleSearchTest.class;

    // com.solvd.carina.articlefinder.testutil
    public static final Class<TestClassConstants> TEST_CLASS_CONSTANTS = TestClassConstants.class;
    public static final Class<TestUtils> TEST_UTILS = TestUtils.class;


}
