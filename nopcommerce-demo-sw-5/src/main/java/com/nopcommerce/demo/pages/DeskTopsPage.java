package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DeskTopsPage extends Utility {
    @CacheLookup@FindBy(linkText = "Build your own computer")
    WebElement buildComputerLink;
    @CacheLookup@FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsLinkText;


    public void clickOnBuildYourOwnComputer() {
    clickOnElement(buildComputerLink);
    }
    public void verifyDesktopsText(){
        Assert.assertEquals(desktopsLinkText.getText(),"Desktops");
    }
}
