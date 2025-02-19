package com.zsidek.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.zsidek.driver.Driver;
import com.zsidek.pages.saucedemo.*;
import com.zsidek.utils.ResourceReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.zsidek.pages.saucedemo.InventoryPage.INVENTORY_ITEM_BUTTON_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class C1AutomatePurchaseProcessTest {
    private final WebDriver driver = Driver.getInstance();
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckOutStep1Page checkOutStep1Page;
    private CheckOutStep2Page checkOutStep2Page;
    private CheckOutCompletePage checkOutCompletePage;

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage("https://www.saucedemo.com/inventory.html");
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkOutStep1Page = new CheckOutStep1Page();
        checkOutStep2Page = new CheckOutStep2Page();
        checkOutCompletePage = new CheckOutCompletePage();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void automatePurchaseProcess() {
        JsonNode jsonNode = ResourceReader.getJsonNode("credential.json");
        assertNotNull(jsonNode, "Failed to load credentials from JSON.");
        loginPage.inputUserName.sendKeys(jsonNode.get("username").asText());
        loginPage.inputPassword.sendKeys(jsonNode.get("password").asText());
        loginPage.buttonLogin.click();

        driver.findElement(By.xpath(String.format(INVENTORY_ITEM_BUTTON_FORMAT, "Sauce Labs Backpack"))).click();
        driver.findElement(By.xpath(String.format(INVENTORY_ITEM_BUTTON_FORMAT, "Sauce Labs Fleece Jacket"))).click();
        assertEquals("2", inventoryPage.counterShoppingCart.getText());
        inventoryPage.iconShoppingCart.click();

        cartPage.buttonCheckout.click();

        checkOutStep1Page.inputFirstName.sendKeys("John");
        checkOutStep1Page.inputLastName.sendKeys("Smith");
        checkOutStep1Page.inputPostalCode.sendKeys("12345");
        checkOutStep1Page.buttonContinue.click();

        checkOutStep2Page.buttonFinish.click();

        assertEquals("Thank you for your order!", checkOutCompletePage.textCompleted.getText());
    }
}
