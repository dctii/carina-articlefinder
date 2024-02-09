package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {
    private static final Logger LOGGER = LogManager.getLogger(ActionUtils.class);

    public static Actions escape(WebDriver driver) {
        return new Actions(driver).sendKeys(Keys.ESCAPE);
    }

    public static Action commandAndClick(WebDriver driver, WebElement element) {
        LOGGER.info("{}In commandAndClick, getting current osName{}", AnsiCodes.RED_ON_YELLOW, AnsiCodes.RESET_ALL);
        String osName = OperatingSystem.getCurrentOperatingSystemString();

        LOGGER.info("{}OS NAME STRING: {}{}", AnsiCodes.RED_ON_YELLOW, osName, AnsiCodes.RESET_ALL);

        Action commandAndClickAction;
        LOGGER.info("{}Attempting to build new action{}",
                AnsiCodes.RED_ON_YELLOW,
                AnsiCodes.RESET_ALL);
        if (OperatingSystem.isMac(osName)) {
            commandAndClickAction =
                    new Actions(driver).keyDown(Keys.COMMAND)
                            .click(element)
                            .keyUp(Keys.COMMAND)
                            .build();
        } else {
            LOGGER.warn("Non-Mac OS detected. COMMAND + CLICK is a Mac-only composite action. Using CTRL + CLICK instead.");
            commandAndClickAction = controlAndClick(driver, element);
        }
        LOGGER.info("{}Returning commandAndClickAction{}", AnsiCodes.RED_ON_YELLOW,
                AnsiCodes.RESET_ALL);

        return commandAndClickAction;
    }

    public static Action controlAndClick(WebDriver driver, WebElement element) {
        return new Actions(driver).keyDown(Keys.CONTROL)
                .click(element)
                .keyUp(Keys.CONTROL)
                .build();
    }


}
