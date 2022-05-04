package com.saucedemo.testsuite;

import com.saucedemo.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    private InventoryPage inventoryPage1;

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserNameField("standard_user");
        loginPage.enterPasswordField("secret_sauce");
        loginPage.clickOnLoginButton();
        String actualMessage = inventoryPage.getProductText();
        Assert.assertEquals(actualMessage, "PRODUCTS", "error");

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        loginPage.enterUserNameField("standard_user");
        loginPage.enterPasswordField("secret_sauce");
        loginPage.clickOnLoginButton();
        //inventoryPage1.getFindActualNumberOfProducts();
        int actualMessage = inventoryPage.getFindActualNumberOfProducts();
        int expected = 6;
        Assert.assertEquals(actualMessage, expected, "error");

    }
}

