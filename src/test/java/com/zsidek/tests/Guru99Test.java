package com.zsidek.tests;

import com.zsidek.driver.Driver;
import com.zsidek.pages.guru99.DemoPage;
import com.zsidek.pages.guru99.TooltipPage;
import com.zsidek.utils.TestDataProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.zsidek.pages.guru99.DemoPage.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Guru99Test {
    private static final WebDriver driver = Driver.getInstance();

    private DemoPage demoPage;
    private TooltipPage tooltipPage;

    @BeforeEach
    public void setUp() {
        demoPage = new DemoPage("https://demo.guru99.com/test/guru99home/");
        tooltipPage = new TooltipPage();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void handleIFrameAndTab() {

        demoPage.scrollToElement(demoPage.iFrame);

        demoPage.switchToFrame(demoPage.iFrame);
        demoPage.imageOfIframe.click();

        demoPage.switchToWindowByIndex(1).close();

        demoPage.switchToWindowByIndex(0);

        demoPage.scrollToElement(demoPage.textEmail);
        demoPage.inputEmail.sendKeys(TestDataProvider.provideValidUserDataC4().getEmail());
        demoPage.buttonSubmit.click();

        String popupMessage = demoPage.switchToAlert().getText();
        demoPage.switchToAlert().accept();

        assertTrue(popupMessage.contains(SUCCESSFULLY), "Popup message should contain 'Successfully'");

        demoPage.selectOptionOnDropDown(SELENIUM, TOOLTIP);

        assertTrue(tooltipPage.buttonDownloadNow.isDisplayed(), "Button should be displayed");

    }
}
