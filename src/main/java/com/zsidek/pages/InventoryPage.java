package com.zsidek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {
    public static final String INVENTORY_ITEM_BUTTON_FORMAT =
            "//div[contains(text(),'%s')]//ancestor::div[@data-test='inventory-item-description']//button";

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public WebElement counterShoppingCart;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    public WebElement iconShoppingCart;

    public InventoryPage() {
        super();
    }
}
