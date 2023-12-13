package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.ArrayList;
import java.util.Collections;
@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    HomePage homePage ;
    DesktopPage desktopPage ;
    ProductPage productPage;
    ShoppingCartPage cartPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
    }

//Write the following Test:
//1.Test name verifyProductArrangeInAlphaBaticalOrder()

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
       //1.1 Mouse hover on Desktops Tab. and click

        homePage.selectCurrency("£Pound Sterling");
        //1.2 Click on “Show All Desktops”

        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopPage.getProductsNameList();
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        // Select sort by Name Z - A
        desktopPage.selectSortByOption("Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        ArrayList<String> afterSortByZToAProductsName = desktopPage.getProductsNameList();
//1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
    }

    @Test(dataProvider = "allData", dataProviderClass = TestData.class,groups = {"sanity","smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(String product,String qty,String successMessage,String productName,String model,String total) {
        //2.1 Mouse hover on Currency Dropdown and click
        // 2.2 Mouse hover on £Pound Sterling and click
        homePage.selectCurrency("£Pound Sterling");
        //2.3 Mouse hover on Desktops Tab.
        //2.4 Click on “Show All Desktops”
        homePage.mouseHoverOnDesktopsLinkAndClick();
//        2.5 Select Sort By position "Name: A to Z"
        homePage.selectMenu("Show AllDesktops");
        desktopPage.selectSortByOption("Name (A - Z)");
        //2.6 Select product <product>
        desktopPage.selectProductByName(product);
//        Assert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");
//        productPage.selectDeliveryDate("30", "November", "2023");
        // 2.7 Enter Qty <qty> using Select class.
        productPage.enterQuantity(qty);
        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();
       Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains(successMessage),
                "Product not added to cart");
//        2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLinkIntoMessage();
        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
        //2.12 Verify the Product name <productName>
        Assert.assertEquals(cartPage.getProductName(), productName, "Product name not matched");

        Assert.assertTrue(cartPage.getDeliveryDate().contains("2023-11-30"), model);
        //2.13 Verify the Model <model>
        Assert.assertEquals(cartPage.getModel(), model, "Model not matched");
        //2.14 Verify the Total <total>
        Assert.assertEquals(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]"),"total");
    }

}
