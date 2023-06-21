package com.webstaurantstore.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    private BrowserUtils() {}

    public static void navigateTo(String url) {
        Driver.getDriver().get(url);
    }

    public static void quitDriver(){
        Driver.closeDriver();
    }

    public static WebElement getElement(By element) {
        return Driver.getDriver().findElement(element);
    }
    public static String getText(By element) {
        String str = getElement(element).getText();
        return str;
    }

    public static void clickElement(By element) {
        getElement(element).click();
    }

    public static void sendKeys(By element, String input) {
        getElement(element).sendKeys(input);
    }

    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<WebElement> getElements(By element) {
        return Driver.getDriver().findElements(element);
    }

    public static String getPageURL() {
        return Driver.getDriver().getCurrentUrl();
    }


    public static boolean isElementDisplayed(By element) {
        try {
            getElement(element);
        } catch (NotFoundException e) {
            return false;
        }
        return true;
    }


}
