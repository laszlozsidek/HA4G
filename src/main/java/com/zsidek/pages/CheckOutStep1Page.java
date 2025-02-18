package com.zsidek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutStep1Page extends BasePage {

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement inputLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement inputPostalCode;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement buttonContinue;

    public CheckOutStep1Page() {
        super();
    }
}
