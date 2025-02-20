package com.zsidek.pages;

import com.zsidek.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected BasePage(String url) {
        WebDriver driver = Driver.getInstance();
        driver.manage().deleteAllCookies();
        if (url != null) {
            driver.get(url);
        }
        PageFactory.initElements(driver, this);
    }

    protected BasePage() {
        this(null);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
