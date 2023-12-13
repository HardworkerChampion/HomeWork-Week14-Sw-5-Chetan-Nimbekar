package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends Utility {
    @CacheLookup@FindBy(linkText = "Log in")
    WebElement loginLink;
    @CacheLookup@FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginLink1;
    @CacheLookup@FindBy(linkText = "Register")
    WebElement registerLink;
    @CacheLookup@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computersLink;
    public void clickOnLoginTab(){
        clickOnElement(loginLink);
    }
    public void verifyLoginText(){
        Assert.assertEquals(loginLink1.getText(),"Log in","Text is not verify");
    }
    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }
    public void clickOnComputerTab(){
        clickOnElement(computersLink);
    }
}
