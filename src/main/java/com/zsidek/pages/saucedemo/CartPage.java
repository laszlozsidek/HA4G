package com.zsidek.pages.saucedemo;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement buttonCheckout;

    public CartPage() {
        super();
    }
}
