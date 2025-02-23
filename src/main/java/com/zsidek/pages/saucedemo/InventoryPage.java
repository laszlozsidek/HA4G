package com.zsidek.pages.saucedemo;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {
    public static final String INVENTORY_ITEM_BUTTON_FORMAT =
            "//div[contains(text(),'%s')]//ancestor::div[@data-test='inventory-item-description']//button";

    @FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
    public WebElement counterShoppingCart;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    public WebElement iconShoppingCart;

    @FindBy(xpath = "//div[@data-test='footer-copy']")
    public WebElement textFooter;

    public InventoryPage() {
        super();
    }

}
