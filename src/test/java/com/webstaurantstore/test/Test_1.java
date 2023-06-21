package com.webstaurantstore.test;


import com.webstaurantstore.pages.CartPage;
import com.webstaurantstore.pages.HomePage;
import com.webstaurantstore.pages.ResultsPage;
import com.webstaurantstore.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.List;

import static com.webstaurantstore.utilities.BrowserUtils.*;


public class Test_1 {

    private final HomePage homePage = new HomePage();
    private final ResultsPage resultsPage = new ResultsPage();

    private SoftAssert softAssert = new SoftAssert();

    private final CartPage cartPage = new CartPage();


    @BeforeMethod
    public void setUp() {
        //Go to www.webstaurantstore.com
        navigateTo("https://www.webstaurantstore.com/");
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
        softAssert.assertAll();
    }


    @Test
    public void task_1() {
        //Search for 'stainless work table'.
        homePage.searchItem(ConfigurationReader.getProperty("searchItem"));

        //Check the result ensuring every product has the word 'Table' in its title.
        List<String> results = resultsPage.allSearchResultTitles();

        softAssert.assertTrue(resultsPage.checkAllSearchResultsContain(results, ConfigurationReader.getProperty("checkWord")),
                "WARNING!!! NOT all results contain the word \"" + ConfigurationReader.getProperty("checkWord")
                        + "\"");

        //Add 4 last items to Cart.
        cartPage.addProductsToCart();
        cartPage.openCart();

        softAssert.assertFalse(cartPage.isCartEmpty(), "Cart EMPTY!");
        softAssert.assertEquals(cartPage.amountItemsInCart(), ConfigurationReader.getProperty("productsForCart"));

        //Empty Cart.
        cartPage.emptyCart();

        softAssert.assertTrue(cartPage.isCartEmptyNotification(), "Card is empty notification NOT DISPLAYED!");

    }

}
