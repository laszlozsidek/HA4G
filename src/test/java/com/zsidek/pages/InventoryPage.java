package com.zsidek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {
    public static final String INVENTORY_ITEM_BUTTON_FORMAT = "//div[contains(text(),'%s')]//ancestor::div[@data-test='inventory-item-description']//button";

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public WebElement counterShoppingCart;

//    @FindBy(xpath = "//input[@id='password']")
//    public WebElement inputPassword;
//
//    @FindBy(xpath = "//h3[@data-test='error']")
//    public WebElement messageError;
//
//    @FindBy(xpath = "//input[@id='login-button']")
//    public WebElement buttonLogin;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
}
