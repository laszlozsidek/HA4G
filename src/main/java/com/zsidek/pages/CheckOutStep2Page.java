package com.zsidek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutStep2Page extends BasePage {

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement buttonFinish;

    public CheckOutStep2Page() {
        super();
    }
}
