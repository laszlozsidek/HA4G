package com.zsidek.tests;

import com.zsidek.driver.Driver;
import com.zsidek.pages.saucedemo.*;
import com.zsidek.utils.TestDataProvider;
import com.zsidek.utils.model.TestUser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.zsidek.pages.saucedemo.InventoryPage.INVENTORY_ITEM_BUTTON_FORMAT;
import static com.zsidek.utils.ResourceReader.getValueFromJsonNode;
import static com.zsidek.utils.StringConstants.PASSWORD;
import static com.zsidek.utils.StringConstants.USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SauceDemoTest {

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

    @AfterAll
    public static void tearDown() {
        Driver.getInstance().quit();
    }

    @Test
    public void automatePurchaseProcess() {
        String resource = "credential.json";
        loginPage.inputUserName.sendKeys(getValueFromJsonNode(resource, USERNAME));
        loginPage.inputPassword.sendKeys(getValueFromJsonNode(resource, PASSWORD));
        loginPage.buttonLogin.click();

        inventoryPage.findElementByFormat(INVENTORY_ITEM_BUTTON_FORMAT, TestDataProvider.provideCartItemsC1().get(0)).click();
        inventoryPage.findElementByFormat(INVENTORY_ITEM_BUTTON_FORMAT, TestDataProvider.provideCartItemsC1().get(1)).click();
        assertEquals("2", inventoryPage.counterShoppingCart.getText(), "Counter should be 2");
        inventoryPage.iconShoppingCart.click();

        cartPage.buttonCheckout.click();

        TestUser testUser = TestDataProvider.provideValidUserDataC1();
        checkOutStep1Page.inputFirstName.sendKeys(testUser.getFirstName());
        checkOutStep1Page.inputLastName.sendKeys(testUser.getLastName());
        checkOutStep1Page.inputPostalCode.sendKeys(testUser.getPostalCode());
        checkOutStep1Page.buttonContinue.click();

        checkOutStep2Page.buttonFinish.click();

        assertEquals("Thank you for your order!",
                checkOutCompletePage.textCompleted.getText(),
                "Text should be as expected");
    }

    @Test
    public void verifyErrorMessagesForMandatoryFields() {
        loginPage.buttonLogin.click();

        assertEquals("Epic sadface: Username is required", loginPage.messageError.getText(), "Text should be as expected");

        String resource = "credential2.json";
        loginPage.inputUserName.sendKeys(getValueFromJsonNode(resource, USERNAME));
        loginPage.inputPassword.sendKeys(getValueFromJsonNode(resource, PASSWORD));
        loginPage.buttonLogin.click();

        loginPage.scrollToElement(inventoryPage.textFooter);

        String footerText = inventoryPage.textFooter.getText();
        assertTrue(footerText.contains("2025") && footerText.contains("Terms of Service"),
                "Footer text should contain correct text");
    }

}
