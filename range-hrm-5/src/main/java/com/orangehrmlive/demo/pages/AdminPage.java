package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminPage extends Utility {
    @CacheLookup@FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUserTextLink;
    public void verifySystemUserText(){
        Assert.assertEquals(getTextFromElement(systemUserTextLink),"System Users");
    }
}
