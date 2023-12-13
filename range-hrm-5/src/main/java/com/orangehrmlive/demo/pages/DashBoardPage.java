package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends Utility {
    @CacheLookup@FindBy(xpath = "//span[text()='Admin']")
    WebElement adminTabLink;

    public void clickOnAdminTab(){
        clickOnElement(adminTabLink);

    }
}
