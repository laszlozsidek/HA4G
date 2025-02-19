package com.zsidek.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.zsidek.driver.Driver;
import com.zsidek.pages.saucedemo.InventoryPage;
import com.zsidek.pages.saucedemo.LoginPage;
import com.zsidek.utils.ResourceReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class C2VerifyErrorMessagesForMandatoryFieldsTest {
    private final WebDriver driver = Driver.getInstance();
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage("https://www.saucedemo.com/inventory.html");
        inventoryPage = new InventoryPage();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyErrorMessagesForMandatoryFields() {
        JsonNode jsonNode = ResourceReader.getJsonNode("credential2.json");
        assertNotNull(jsonNode, "Failed to load credentials from JSON.");
        loginPage.buttonLogin.click();

        assertEquals("Epic sadface: Username is required", loginPage.messageError.getText());

        loginPage.inputUserName.sendKeys(jsonNode.get("username").asText());
        loginPage.inputPassword.sendKeys(jsonNode.get("password").asText());
        loginPage.buttonLogin.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        String footerText = inventoryPage.textFooter.getText();

        assertTrue(footerText.contains("2025") && footerText.contains("Terms of Service"));
    }
}
