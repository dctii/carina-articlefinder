package com.solvd.carina.articlefinder.testutil;

import com.solvd.carina.articlefinder.api.domain.Article;
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

    public static String transformLiveArticleHrefToDestinationUrl (String hrefVal) {
        /*
            When clicking on a link that goes to a LiveArticlePage, it will change the URL
            when it reaches the destination. Most of the substrings of the URL are the same,
            but some parts are moved around.

            - From the original href URL, the terminating subpath becomes an #anchor in the actual destination.
            - The #anchor is moved to the end of the URL, and then the query param 'searchResultPosition=n'
                becomes immediately after the query param initializer '?'

            Example:
            Original Href Value:
                https://www.nytimes.com/live/2024/02/08/us/trump-supreme-court-colorado-ballot/
                the-supreme-court-could-dramatically-shape-the-2024-election?searchResultPosition=4

            Destination URL:
                https://www.nytimes.com/live/2024/02/08/us/trump-supreme-court-colorado-ballot
                    ?searchResultPosition=4#the-supreme-court-could-dramatically-shape-the-2024-election

         */

        int lastSlashIndex = hrefVal.lastIndexOf('/');
        int queryParamIndex = hrefVal.indexOf('?');

        // get the base URL up to the last '/'
        String baseUpToLastSlash = hrefVal.substring(0, lastSlashIndex);

        // get the anchor part
        String anchorPart = hrefVal.substring(lastSlashIndex + 1, queryParamIndex);

        // reconstruct the URL
        return baseUpToLastSlash + hrefVal.substring(queryParamIndex) + "#" + anchorPart;

    }

}
