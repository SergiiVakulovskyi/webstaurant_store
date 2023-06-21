package com.webstaurantstore.pages;

import com.webstaurantstore.utilities.ConfigurationReader;
import org.openqa.selenium.By;

import static com.webstaurantstore.utilities.BrowserUtils.*;


public class CartPage extends Page{


    private final static By all_products_available_for_purchase = By.xpath("//input[@name='addToCartButton']");
    private final static By cart_button = By.xpath("//a[@class= 'btn btn-small btn-primary']");
    private final static By item_in_cart = By.cssSelector("li[class^='cartItemWrapper']");
    private final static By number_item_in_cart = By.id("cartItemCountSpan");
    private final static By empty_cart_button = By.xpath("//button[.='Empty Cart']");
    private final static By empty_cart_button_alert = By.xpath("//footer[@class]//button[.='Empty Cart']");
    private final static By notification_cart_is_empty = By.className("empty-cart__text");



    public void addProductsToCart() {

        int numberProductsForCart = Integer.parseInt(ConfigurationReader.getProperty("productsForCart"));

        int numberProductsAvailableForPurchaseOnPage = getElements(all_products_available_for_purchase).size();

        for (int i = numberProductsAvailableForPurchaseOnPage;
                 i >= numberProductsAvailableForPurchaseOnPage - (numberProductsForCart-1); i--) {

           clickElement(By.xpath("(//input[@name='addToCartButton'])[" + i + "]"));
            
        }

    }

    public void openCart() {
        clickElement(cart_button);
    }

    public boolean isCartEmpty() {
        return !isElementDisplayed(item_in_cart);
    }

    public String amountItemsInCart() {
        String items = getText(number_item_in_cart);
        return items;
    }

    public void emptyCart() {
        clickElement(empty_cart_button);
        clickElement(empty_cart_button_alert);
    }

    public boolean isCartEmptyNotification() {
        return isElementDisplayed(notification_cart_is_empty);
    }


}
