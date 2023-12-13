package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup@FindBy(name = "username")
    WebElement userNameTextFieldLink;
    @CacheLookup@FindBy(name = "password")
    WebElement passwordTextFieldLink;
    @CacheLookup@FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButtonLink;

    public void loginToApplication(){
        sendTextToElement(userNameTextFieldLink,"Admin");
        sendTextToElement(passwordTextFieldLink,"admin123");
        clickOnElement(loginButtonLink);
    }


}
