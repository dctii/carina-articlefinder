package com.solvd.carina.articlefinder.web;

import org.openqa.selenium.WebDriver;

// https://help.nytimes.com/hc/en-us/articles/115014893428-Terms-of-Service
public class HelpArticlePage extends HelpArticlePageContainer {
    // article content
        // title
        // body
            // last updated
            // description
            // notices
                // read instructions
                // arbitration agreement and class action waiver
                // why nyt collects personal info
            // table of contents
            // content

    public HelpArticlePage(WebDriver driver) {
        super(driver);
    }
}
