package com.zsidek.tests;

import com.zsidek.driver.Driver;
import com.zsidek.pages.guru99.DemoPage;
import com.zsidek.pages.guru99.TooltipPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

        driver.switchTo().frame(demoPage.iFrame);
        demoPage.imageOfIframe.click();

        Set<String> handles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);
        driver.switchTo().window(tabs.get(1)).close();

        driver.switchTo().window(tabs.get(0));

        demoPage.scrollToElement(demoPage.textEmail);
        demoPage.inputEmail.sendKeys("john@doe.com");
        demoPage.buttonSubmit.click();

        String popupMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        assertTrue(popupMessage.contains("Successfully"), "Popup message should contain 'Successfully'");

        demoPage.scrollToElement(demoPage.navigation);
        demoPage.dropdownSelenium.click();
        demoPage.menuItemTooltip.click();

        assertTrue(tooltipPage.buttonDownloadNow.isDisplayed(), "Button should be displayed");
    }
}
