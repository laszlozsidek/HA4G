package com.zsidek.pages.saucedemo;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    public WebElement inputUserName;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement messageError;

    @FindBy(id = "login-button")
    public WebElement buttonLogin;

    public LoginPage(String url) {
        super(url);
    }

}
