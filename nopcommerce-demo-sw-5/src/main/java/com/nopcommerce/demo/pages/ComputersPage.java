package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ComputersPage extends Utility {
    @CacheLookup@FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Desktops']")
    WebElement desktopsLink;
    @CacheLookup@FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computersTextLink;

    public void clickOnDeskTopsLink(){
      clickOnElement(desktopsLink);
    }
    public void verifyComputersText(){
        Assert.assertEquals(computersTextLink.getText(),"Computers");
    }

}
