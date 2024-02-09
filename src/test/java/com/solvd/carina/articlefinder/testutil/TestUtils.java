package com.solvd.carina.articlefinder.testutil;

import com.solvd.carina.articlefinder.bin.Article;
import com.solvd.carina.articlefinder.util.BooleanUtils;
import com.solvd.carina.articlefinder.util.DateTimeUtils;
import com.solvd.carina.articlefinder.util.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.IntStream;

public class TestUtils {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.TEST_UTILS);

    private TestUtils() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    public static boolean areArticlesSortedByNewest(List<Article> articles) {
        return IntStream.range(0, articles.size() - 1)
                .allMatch(i -> {
                    String currArticlePubDateString = articles.get(i).getPubDate();
                    String nextArticlePubDateString = articles.get(i + 1).getPubDate();

                    return BooleanUtils.isNotOlderDateTime(
                            currArticlePubDateString,
                            nextArticlePubDateString,
                            DateTimeUtils.getNyTimesFormatter()
                    );
                });
    }

}
