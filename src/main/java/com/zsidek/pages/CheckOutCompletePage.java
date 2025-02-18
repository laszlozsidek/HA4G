package com.zsidek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutCompletePage extends BasePage {

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    public WebElement textCompleted;

    public CheckOutCompletePage() {
        super();
    }
}
