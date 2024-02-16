package com.solvd.carina.articlefinder.web.components.helppage;

import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.IntStream;

public class HelpArticleSubNav extends AbstractGlobalUIObject {
    @FindBy(xpath = ".//ol[@class='breadcrumbs']")
    List<Anchor> breadcrumbs;
    // get first, get last, get by index, get breadcrumb count
    @FindBy(xpath = ".//form[@role='search' and @method='get']")
    HelpSearchForm searchForm;

    public HelpArticleSubNav(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        breadcrumbs
     */

    public List<Anchor> getBreadcrumbs() {
        return breadcrumbs;
    }

    public List<String> getBreadcrumbsTextsAsList() {
        return ElementUtils.getElementsTextsAsList(breadcrumbs);
    }

    public boolean validateBreadcrumbsTexts(String... expectedTexts) {
        List<String> actualTexts = getBreadcrumbsTextsAsList();

        // check if lengths are the same
        if (expectedTexts.length != actualTexts.size()) {
            return false;
        }

        // check if all texts match
        return IntStream.range(0, actualTexts.size())
                .allMatch(i -> actualTexts.get(i).equals(expectedTexts[i]));
    }

    /*
        searchForm
     */


    public HelpSearchForm getSearchForm() {
        return searchForm;
    }
}
