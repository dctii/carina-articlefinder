package com.solvd.carina.articlefinder.web.components.othercomponents;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.solvd.carina.articlefinder.web.elements.Img;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SneakerProductCard extends AbstractGlobalUIObject {

    @FindBy(xpath = ".//a[@data-auto-id='glass-hockeycard-link']/img[1]")
    Img productImage; // changes when hovering over different variations

    @FindBy(xpath = ".//div[@class='glass-product-card__details']//parent::a")
    SneakerProductDetails sneakerDetails;

    @FindBy(xpath = ".//div[@data-auto-id='gl-price-item']/div[contains(@class, 'price')]")
    BoringElement price;

    @FindBy(
            xpath = ".//a[@data-auto-id='product-card-variations-carousel-item']"
                    + "/img[@data-auto-id='image']"
    )
    List<Img> productVariationThumbs;


    public SneakerProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        productImage
     */

    public Img productImage() {
        return productImage;
    }

    public String getProductImageSrc() {
        return productImage.getSrc();
    }

    public String getProductImageSrcSet() {
        return productImage.getSrcSetAttrValueString();
    }

    public void hoverOnProductImage() {
        productImage.hover();
    }

    /*
        sneakerDetails
     */


    public SneakerProductDetails getSneakerDetails() {
        return sneakerDetails;
    }

    public String getSneakerDetailsHrefVal() {
        return sneakerDetails.getSelf().getAttribute(AttributeConstants.HREF);
    }

    /*
        price
     */

    public BoringElement getPrice() {
        return price;
    }

    /*
        productVariationThumbs
     */

    public List<Img> getProductVariationThumbs() {
        return productVariationThumbs;
    }

    public void hoverOnProductVariationThumbByIndex(int index) {
        productVariationThumbs.get(index).hover();
    }
}
