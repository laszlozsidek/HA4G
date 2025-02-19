package com.zsidek.pages.onlinehtmleditor;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//button[contains(@data-cke-tooltip-text,'Bold')]")
    public WebElement buttonBold;

    @FindBy(xpath = "//button[contains(@data-cke-tooltip-text,'Underline')]")
    public WebElement buttonUnderline;

    @FindBy(xpath = "//div[contains(@aria-label,'Rich Text Editor')]")
    public WebElement textboxEditor;

    public StartPage(String url) {
        super(url);
    }

}
