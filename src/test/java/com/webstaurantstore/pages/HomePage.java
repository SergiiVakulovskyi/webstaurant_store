package com.webstaurantstore.pages;

import org.openqa.selenium.By;

import static com.webstaurantstore.utilities.BrowserUtils.*;


public class HomePage extends Page{
    private final static By search_box = By.id("searchval");
    private final static By search_button = By.xpath("//button[@value='Search']");

    public void searchItem(String searchItem) {
        sendKeys(search_box, searchItem);
        clickElement(search_button);
    }
}
