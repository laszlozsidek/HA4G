package com.zsidek.tests;

import com.zsidek.driver.Driver;
import com.zsidek.pages.onlinehtmleditor.StartPage;
import com.zsidek.utils.StringUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineHtmlEditorTest {
    private static final WebDriver driver = Driver.getInstance();
    private StartPage startPage;

    @BeforeEach
    public void setUp() {
        startPage = new StartPage("https://onlinehtmleditor.dev/");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyErrorMessagesForMandatoryFields() {
        startPage.buttonBold.click();
        startPage.textboxEditor.sendKeys("Automation ");
        startPage.buttonBold.click();
        startPage.buttonUnderline.click();
        startPage.textboxEditor.sendKeys("Test");
        startPage.buttonUnderline.click();
        startPage.textboxEditor.sendKeys(" Example");

        assertEquals("Automation Test Example",
                StringUtil.normalizeString(startPage.textboxEditor.getText()),
                "Textbox should contain expected text"
        );
    }
}
