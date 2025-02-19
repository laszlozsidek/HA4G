package com.zsidek.pages.saucedemo;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutCompletePage extends BasePage {

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    public WebElement textCompleted;

    public CheckOutCompletePage() {
        super();
    }
}
