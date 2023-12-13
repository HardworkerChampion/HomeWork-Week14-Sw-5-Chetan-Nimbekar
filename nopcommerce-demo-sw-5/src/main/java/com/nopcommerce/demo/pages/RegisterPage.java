package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage extends Utility {
    @CacheLookup@FindBy(xpath = "//h1[normalize-space()='Register']")
    WebElement registerTextLink;
    @CacheLookup@FindBy(id = "register-button")
    WebElement registerButtonLink;
    @CacheLookup@FindBy(xpath = "//span[@data-valmsg-for='FirstName']")
    WebElement errorMsg1stNameLink;
    @CacheLookup@FindBy(id = "LastName-error")
    WebElement errorMsgLastNameLink;
    @CacheLookup@FindBy(id = "Email-error")
    WebElement errorMsgEmailLink;
    @CacheLookup@FindBy(id = "Password-error")
    WebElement errorMsgPasswordLink;
    @CacheLookup@FindBy(id = "ConfirmPassword-error")
    WebElement errorMsgCnfPasswordLink;
    @CacheLookup@FindBy(id = "gender-female")
    WebElement maleLink;
    @CacheLookup@FindBy(id = "FirstName")
    WebElement firstNameTextFieldLink;
    @CacheLookup@FindBy(id = "LastName")
    WebElement lastNameTextFieldLink;
    @CacheLookup@FindBy(xpath = "//select[@name='DateOfBirthDay']")WebElement day;
    @CacheLookup@FindBy(xpath = "//select[@name='DateOfBirthMonth']")WebElement month;
    @CacheLookup@FindBy(xpath = "//select[@name='DateOfBirthYear']")WebElement year;
    @CacheLookup@FindBy(id = "Email")WebElement emaill;
    @CacheLookup@FindBy(id = "Password")WebElement passwordl;
    @CacheLookup@FindBy(id = "ConfirmPassword")WebElement confPasswordl;
    @CacheLookup@FindBy(id = "register-button")WebElement registerButton;
    @CacheLookup@FindBy(xpath = "//div[@class='result']")WebElement msgRegistration;

    public void verifyRegisterText(){
        Assert.assertEquals(registerTextLink.getText(),"Register","Text is not verify");
    }
    public void clickOnRegisterBtn(){
        clickOnElement(registerButtonLink);
    }
    public void verifyErrorMsg1stName(){
        Assert.assertEquals(errorMsg1stNameLink.getText(),"First name is required.","Text is not verify");
    }
    public void verifyErrorLastName(){
        Assert.assertEquals(errorMsgLastNameLink.getText(),"Last name is required.","Text is not verify");
    }
    public void verifyErrorMsgEmail(){
        Assert.assertEquals(errorMsgEmailLink.getText(),"Email is required.","Text is not verify");
    }
    public void verifyErrorMsgPassword(){
        Assert.assertEquals(errorMsgPasswordLink.getText(),"Password is required.","Text is not verify");
    }
    public void verifyErrorMsgCnfPassword(){
        Assert.assertEquals(errorMsgCnfPasswordLink.getText(),"Password is required.","Text is not verify");
    }
    public void selectGenderFemale(){
        clickOnElement(maleLink);
    }
    public void enterFirstName(String name){
        sendTextToElement(firstNameTextFieldLink,name);
    }
    public void enterLastName(String lastName){
        sendTextToElement(lastNameTextFieldLink,lastName);
    }
    public void selectDay(){

        Select select = new Select(day);
        select.selectByValue("5");
    }
    public void selectMonth(){

        Select select = new Select(month);
        select.selectByValue("5");
    }
    public void selectYear(){

        Select select = new Select(year);
        select.selectByValue("2023");
    }
    public void enterEmail(String email){
      sendTextToElement(emaill,email);
    }
    public void enterPassword(String password){
      sendTextToElement(passwordl,password);
    }
    public void enterConfPassword(String password){
      sendTextToElement(confPasswordl,password);
    }
    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
    }
    public void verifyMsgRegistrationComplete(){
        Assert.assertEquals(msgRegistration.getText(),"Your registration completed","Text is not verify");
    }



}
