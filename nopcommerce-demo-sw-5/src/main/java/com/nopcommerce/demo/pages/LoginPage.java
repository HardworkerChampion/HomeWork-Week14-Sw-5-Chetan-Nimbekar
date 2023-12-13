package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends Utility {

    @CacheLookup@FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement welcomeText;
    @CacheLookup@FindBy(id = "Email")
    WebElement emailTextFieldLink;
    @CacheLookup@FindBy(id = "Password")
    WebElement passwordTextFieldLink;
    @CacheLookup@FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement loginBtnLink;
    @CacheLookup@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessageLink;
    @CacheLookup@FindBy(linkText = "Log out")
    WebElement logoutTextLink;


    public void verifyTextWelcome(){
        Assert.assertEquals(welcomeText.getText(),"Welcome, Please Sign In!","Text is not verify");
    }
    public void enterEmailId(String email){
        sendTextToElement(emailTextFieldLink,email);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordTextFieldLink,password);
    }
public void clickOnLoginButton(){
        clickOnElement(loginBtnLink);
}
    public void verifyErrorMessage(){
        Assert.assertEquals(errorMessageLink.getText(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found","Text is not verify");
    }
    public void verifyLogoutText(){
        Assert.assertEquals(logoutTextLink.getText(),"Log out","Text is not verify");
    }
    public void clickOnLogoutTab(){
        clickOnElement(logoutTextLink);
    }



}
