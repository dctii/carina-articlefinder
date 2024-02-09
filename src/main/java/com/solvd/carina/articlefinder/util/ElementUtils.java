package com.solvd.carina.articlefinder.util;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ElementUtils {
    private static final Logger LOGGER = LogManager.getLogger(ElementUtils.class);

    private ElementUtils() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    public static String getText(ExtendedWebElement element) {
        return element.getText();
    }

    public static String getTagName(WebElement element) {
        return element.getTagName();
    }

    public static void clickIfEnabled(ExtendedWebElement element) {
        if (element.isEnabled()) {
            element.click();
        } else {

            LOGGER.warn(
                    "The '<{}>' element is not enabled and cannot be clicked.",
                    element.getTagName()
            );
        }
    }

}
