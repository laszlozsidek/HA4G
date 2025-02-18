package com.zsidek.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.zsidek.pages.InventoryPage;
import com.zsidek.pages.LoginPage;
import com.zsidek.utils.JsonParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.zsidek.pages.InventoryPage.INVENTORY_ITEM_BUTTON_FORMAT;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/inventory.html");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void navigationToAllTools() {
        JsonNode jsonNode = JsonParser.parseIt(LoginPageTest.class, "credential.json");
        assertNotNull(jsonNode, "Failed to load credentials from JSON.");
        loginPage.inputUserName.sendKeys(jsonNode.get("username").asText());
        loginPage.inputPassword.sendKeys(jsonNode.get("password").asText());
        loginPage.buttonLogin.click();

        driver.findElement(By.xpath(String.format(INVENTORY_ITEM_BUTTON_FORMAT, "Sauce Labs Backpack"))).click();
        driver.findElement(By.xpath(String.format(INVENTORY_ITEM_BUTTON_FORMAT, "Sauce Labs Fleece Jacket"))).click();
        assertEquals("2", inventoryPage.counterShoppingCart.getText());


    }
}
