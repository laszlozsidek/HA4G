package com.zsidek.pages.guru99;

import com.zsidek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPage extends BasePage {

    public static final String SELENIUM = "Selenium";
    public static final String TOOLTIP = "Tooltip";
    public static final String SUCCESSFULLY = "Successfully";

    private static final String DROP_DOWN_FORMAT =
            "//a[@class='dropdown-toggle'][normalize-space()='%s']";

    private static final String OPTION_FORMAT =
            "//a[normalize-space()='%s']";

    @FindBy(xpath = "//nav[@role='navigation']")
    public WebElement navigation;

    @FindBy(id = "a077aa5e")
    public WebElement iFrame;

    @FindBy(xpath = "//body//a")
    public WebElement imageOfIframe;

    @FindBy(xpath = "//h3[contains(text(),'Email')]")
    public WebElement textEmail;

    @FindBy(id = "philadelphia-field-email")
    public WebElement inputEmail;

    @FindBy(id = "philadelphia-field-submit")
    public WebElement buttonSubmit;

    public DemoPage(String url) {
        super(url);
    }

    public void selectOptionOnDropDown(String dropdown, String option){
        scrollToElement(navigation);
        findElementByFormat(DROP_DOWN_FORMAT, dropdown).click();
        findElementByFormat(OPTION_FORMAT, option).click();
    }

}
