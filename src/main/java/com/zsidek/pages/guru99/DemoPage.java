package com.zsidek.pages.guru99;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPage extends BasePage {

    @FindBy(xpath = "//button[contains(@data-cke-tooltip-text,'Bold')]")
    public WebElement buttonBold;

    @FindBy(xpath = "//button[contains(@data-cke-tooltip-text,'Underline')]")
    public WebElement buttonUnderline;

    @FindBy(xpath = "//div[contains(@aria-label,'Rich Text Editor')]")
    public WebElement textboxEditor;

    public DemoPage(String url) {
        super(url);
    }

}
