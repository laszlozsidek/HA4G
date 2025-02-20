package com.zsidek.pages.guru99;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPage extends BasePage {

    @FindBy(xpath = "//nav[@role='navigation']")
    public WebElement navigation;

    @FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Selenium']")
    public WebElement dropdownSelenium;

    @FindBy(xpath = "//a[normalize-space()='Tooltip']")
    public WebElement menuItemTooltip;

    @FindBy(xpath = "//iframe[@id='a077aa5e']")
    public WebElement iFrame;

    @FindBy(xpath = "//body//a")
    public WebElement imageOfIframe;

    @FindBy(xpath = "//h3[contains(text(),'Email')]")
    public WebElement textEmail;

    @FindBy(xpath = "//input[@id='philadelphia-field-email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//button[@id='philadelphia-field-submit']")
    public WebElement buttonSubmit;

    public DemoPage(String url) {
        super(url);
    }

}
