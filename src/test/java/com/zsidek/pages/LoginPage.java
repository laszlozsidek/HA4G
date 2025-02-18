package com.zsidek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement inputUserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement messageError;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //public LoginPage(WebDriver driver) {        PageFactory.initElements(driver, this);    }


}
