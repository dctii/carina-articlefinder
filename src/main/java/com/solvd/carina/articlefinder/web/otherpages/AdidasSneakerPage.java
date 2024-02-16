package com.solvd.carina.articlefinder.web.otherpages;

import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.web.components.othercomponents.SneakerProductCard;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdidasSneakerPage extends AbstractPage {
    @FindBy(xpath = "//*[@data-auto-id='product-card-title']"
            + "/ancestor::div[@data-auto-id='glass-product-card']"
    )
    List<SneakerProductCard> sneakers;

    public AdidasSneakerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(
                Configuration.getRequired(
                        ConfigConstants.ADIDAS_SNEAKERS_LISTING_PAGE_URL_KEY)
        );
    }

    public SneakerProductCard getSneakerByTitle(String sneakerTitle) {
        return sneakers.stream().filter(
                        sneaker ->
                                sneaker.getSneakerDetails().getProductTitleText().equals(sneakerTitle)
                ).findFirst()
                .orElse(null);
    }

    public boolean doesSneakerByTitleExist(String sneakerTitle, long timeout) {
        return getSneakerByTitle(sneakerTitle).isPresent(timeout);
    }

    public boolean doesSneakerByTitleExist(String sneakerTitle) {
        return doesSneakerByTitleExist(sneakerTitle, 1);
    }
}
