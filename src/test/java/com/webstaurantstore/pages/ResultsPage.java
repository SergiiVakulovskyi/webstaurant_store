package com.webstaurantstore.pages;

import org.openqa.selenium.By;
import java.util.List;

import static com.webstaurantstore.utilities.BrowserUtils.*;


public class ResultsPage extends Page{

    private final By product_titles_displayed_on_page = By.cssSelector("a[data-testid='itemLink']");


    public List<String> allSearchResultTitles() {

        int pages = Integer.parseInt(getText(By.xpath("//a[starts-with(@aria-label, 'last page')]")));

        String firstPageURL = getPageURL();

        List<String> resultsString = getElementsText(product_titles_displayed_on_page);

        for (int i = 2; i <= pages; i++) {
            navigateTo(firstPageURL + "?page=" + i);
            resultsString.addAll(getElementsText(product_titles_displayed_on_page));
        }

        return resultsString;
    }

    public boolean checkAllSearchResultsContain(List<String> results, String searchItem) {
        for (String result : results) {
            if (!(result.contains(searchItem))) {
                return false;
            }
        }
        return true;
    }


}
