package com.solvd.carina.articlefinder.web.components.othercomponents;

import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SneakerProductDetails extends AbstractGlobalUIObject {
    @FindBy(xpath = ".//p[@data-auto-id='product-card-title']")
    BoringElement productTitle;

    @FindBy(xpath = ".//p[@data-auto-id='product-card-category']")
    BoringElement category;

    @FindBy(xpath = ".//p[@class='glass-product-card__label']")
    BoringElement label;
    public SneakerProductDetails(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BoringElement getProductTitle() {
        return productTitle;
    }

    public String getProductTitleText() {
        return productTitle.getText();
    }

    public BoringElement getCategory() {
        return category;
    }

    public BoringElement getLabel() {
        return label;
    }
}
