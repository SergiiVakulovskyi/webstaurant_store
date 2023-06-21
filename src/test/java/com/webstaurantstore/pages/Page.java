package com.webstaurantstore.pages;

import com.webstaurantstore.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
