package com.zsidek.pages.guru99;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TooltipPage extends BasePage {

    @FindBy(xpath = "//a[@id='download_now']")
    public WebElement buttonDownloadNow;

    public TooltipPage() {
        super();
    }

}
