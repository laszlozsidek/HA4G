package com.zsidek.pages;

import com.zsidek.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public WebElement findElementByFormat(String format, String value) {
        return Driver.getInstance().findElement(By.xpath(String.format(format, value)));
    }

    public void switchToFrame(WebElement frame) {
        Driver.getInstance().switchTo().frame(frame);
    }

    public WebDriver switchToWindowByIndex(int index) {
        Set<String> handles = Driver.getInstance().getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);
        return Driver.getInstance().switchTo().window(tabs.get(index));
    }

    public Alert switchToAlert() {
        return Driver.getInstance().switchTo().alert();
    }

}
