package com.zsidek.pages.saucedemo;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutStep2Page extends BasePage {

    @FindBy(id = "finish")
    public WebElement buttonFinish;

    public CheckOutStep2Page() {
        super();
    }

}
