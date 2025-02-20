package com.zsidek.pages;

import com.zsidek.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(String url) {
        WebDriver driver = Driver.getInstance();
        driver.manage().deleteAllCookies();
        if (url != null) {
            driver.get(url);
        }
        PageFactory.initElements(driver, this);
    }

    public BasePage() {
        this(null);
    }

}
