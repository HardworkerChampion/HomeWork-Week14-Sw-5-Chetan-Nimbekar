package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends Utility {
    @CacheLookup@FindBy(xpath = "//h1[text()='Checkout']")
    WebElement checkout;
    @CacheLookup@FindBy(xpath = "//h2[text()='New Customer']")WebElement newCustomerText;
    @CacheLookup@FindBy(css = "input[value='guest']")WebElement guestCheckoutButtonLink;
    @CacheLookup@FindBy(id = "button-account")WebElement continueTabLink;
    @CacheLookup@FindBy(id = "input-payment-firstname")WebElement firstNameTextFieldLink;
    @CacheLookup@FindBy(id = "input-payment-lastname")WebElement lastNameTextFieldLink;
    @CacheLookup@FindBy(id = "input-payment-email")WebElement emailTextFieldLink;
    @CacheLookup@FindBy(id = "input-payment-telephone")WebElement telephoneTextFieldLink;
  @CacheLookup@FindBy(id = "input-payment-address-1")WebElement addressTextFieldLink;
  @CacheLookup@FindBy(id = "input-payment-city")WebElement cityTextFieldLink;
  @CacheLookup@FindBy(id="input-payment-postcode")WebElement postCodeTextFieldLink;
  @CacheLookup@FindBy(id = "input-payment-country")WebElement dropdownCountry;
  @CacheLookup@FindBy(id = "input-payment-zone")WebElement dropDownZone;
  @CacheLookup@FindBy(id = "button-guest")WebElement continue2TabLink;
  @CacheLookup@FindBy(xpath = "//textarea[@name='comment']")WebElement commentBoxLink;
  @CacheLookup@FindBy(linkText = "Terms & Conditions")WebElement tAndCLink;
  @CacheLookup@FindBy(xpath = "//div[text()='Warning: Payment method required!']")WebElement warningMessageLink;

    public String verifytheTextCheckout ( ){
        return getTextFromElement(checkout);
    }
    public String verifyTheTextNewCustomer(){
        return getTextFromElement(newCustomerText);
    }
    public void clickOnGuestCheckoutRadioButton(){
        clickOnElement(guestCheckoutButtonLink);
    }
    public void clickOnContinueTab(){
        clickOnElement(continueTabLink);
    }
    public void fillTheMandaToryFields(){
        sendTextToElement(firstNameTextFieldLink,"John");
        sendTextToElement(lastNameTextFieldLink,"Picket");
        sendTextToElement(emailTextFieldLink,"xyz@gmail.com");
        sendTextToElement(telephoneTextFieldLink,"07717999237");
        sendTextToElement(addressTextFieldLink,"24 kenton gardens");
        sendTextToElement(cityTextFieldLink,"london");
        sendTextToElement(postCodeTextFieldLink,"ha3 8de");
        Select select = new Select(dropdownCountry);
        select.selectByValue("222");
        Select select1 = new Select(dropDownZone);
        select1.selectByValue("3513");
    }
    public void clickOnContinueButton(){
        clickOnElement(continue2TabLink);
    }
    public void addComments(){
        sendTextToElement(commentBoxLink,"Hello");
    }
    public void clickOnTandCCheckBox(){
        clickOnElement(tAndCLink);
    }
    public String verifyTheWarningText(){
     return    getTextFromElement(warningMessageLink);


    }

}
