package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksPageTest extends BaseTest {
    HomePage homePage ;
    ProductPage productPage;
    ShoppingCartPage cartPage ;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage ;
    CheckoutPage checkoutPage ;
    SoftAssert softAssert ;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        checkoutPage = new CheckoutPage();

    }
    //  1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        // 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        //        1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectCurrency("£Pound Sterling");
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenu("Show AllLaptops & Notebooks");
        // Get all the products price and stored into array list
        List<Double> originalProductsPrice = laptopsAndNotebooksPage.getProductsPriceList();
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        // Select sort by Price (High > Low)
        laptopsAndNotebooksPage.selectSortByOption("Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        ArrayList<Double> afterSortByPrice = laptopsAndNotebooksPage.getProductsPriceList();
        Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }

   // 2. Test name verifyThatUserPlaceOrderSuccessfully()
    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
//       2.1 Mouse hover on Laptops & Notebooks Tab and click
//2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectCurrency("£Pound Sterling");
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenu("Show AllLaptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortByOption("Price (High > Low)");
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectProductByName("MacBook");
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(productPage.getProductText(), "MacBook", "MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        productPage.clickOnAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added MacBook to your shopping cart!"),
                "Product not added to cart");
        //2.8 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLinkIntoMessage();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(cartPage.getProductName(), "MacBook", "Product name not matched");
        //2.11 Change Quantity "2"
        cartPage.changeQuantity("2");
        //2.12 Click on “Update”Tab
        cartPage.clickOnQtyUpdateButton();
       //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(cartPage.getSuccessModifiedMessage().contains("Success: You have modified your shopping cart!"));
        //2.14 Verify the Total £737.45
        softAssert.assertEquals(cartPage.getTotal(), "£737.45", "Total not matched");
        softAssert.assertAll();
        //2.15 Click on “Checkout” button
        cartPage.clickOnCheckOutButton();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(checkoutPage.verifytheTextCheckout(),"Checkout");
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(checkoutPage.verifyTheTextNewCustomer(),"New Customer");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestCheckoutRadioButton();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueTab();
        //2.20 Fill the mandatory fields
        checkoutPage.fillTheMandaToryFields();
        //2.21 Click on “Continue” Button
        checkoutPage.clickOnContinueButton();
       //2.22 Add Comments About your order into text area
        checkoutPage.addComments();
        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnTandCCheckBox();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnContinueTab();
        // 2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(checkoutPage.verifyTheWarningText(),"Warning: Payment method required!");
    }

}
