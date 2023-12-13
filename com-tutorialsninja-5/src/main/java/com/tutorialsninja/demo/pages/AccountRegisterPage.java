package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountRegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath ="//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement topMenu;
    By registerAccountText = By.xpath("//h1[contains(text(),'Register Account')]");

    @CacheLookup
    @FindBy(id="input-firstname")
    WebElement firstNameField;
    //By firstNameField = By.id("input-firstname");
    @CacheLookup
    @FindBy(id="input-lastname")
    WebElement LastNameField;
    //By LastNameField = By.id("input-lastname");
    @CacheLookup
    @FindBy(id="input-email")
    WebElement emailField;
    // By emailField = By.id("input-email");
    @CacheLookup
    @FindBy(id="input-telephone")
    WebElement telephoneField;
    //By telephoneField = By.id("input-telephone");
    @CacheLookup
    @FindBy(id="input-password")
    WebElement passwordField;
    //By passwordField = By.id("input-password");
    @CacheLookup
    @FindBy(xpath ="//fieldset[3]//input")
    WebElement subscribeRadios;
    // By subscribeRadios = By.xpath("//fieldset[3]//input");
    @CacheLookup
    @FindBy(id="input-confirm")
    WebElement passwordConfirmField;
    //By passwordConfirmField = By.id("input-confirm");

    @CacheLookup
    @FindBy(xpath ="//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    //By privacyPolicyCheckBox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    @CacheLookup
    @FindBy(xpath ="//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;
    //By continueBtn = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    @CacheLookup
    @FindBy(xpath ="//form[contains(@action,'login')]//input[@type='submit']")
    WebElement  loginBtn;
    // By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstNameField, fName);
    }

    public void enterLastName(String lName) {
        sendTextToElement(LastNameField, lName);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String telephone) {
        sendTextToElement(telephoneField, telephone);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String cPassword) {
        sendTextToElement(passwordConfirmField, cPassword);
    }

    public void selectSubscription(String option) {
        List<WebElement> radioButtons = getListOfElements((By) subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
    }

    public void registerUser(String fName, String lName, String age){
        enterLastName(fName);
        enterLastName(lName);
    }

}
