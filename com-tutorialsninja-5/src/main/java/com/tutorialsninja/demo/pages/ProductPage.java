package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Utility {
    @CacheLookup@FindBy(xpath ="//div[@id = 'content']//h1" )WebElement productText;
    //By productText = By.xpath("//div[@id = 'content']//h1");
    @CacheLookup@FindBy(xpath = "//div[@class = 'input-group date']//button")WebElement calendarButton;
    //By calendarButton = By.xpath("//div[@class = 'input-group date']//button");
    @CacheLookup@FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")WebElement monthAndYearText;
    //By monthAndYearText = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    @CacheLookup@FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")WebElement nextButton;
    //By nextButton = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    @CacheLookup@FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")WebElement dateList;
    //By dateList = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    @CacheLookup@FindBy(css = "#input-quantity")WebElement qtyField;
    //By qtyField = By.cssSelector("#input-quantity");
    @CacheLookup@FindBy(xpath = "//button[@id='button-cart']")WebElement addToCartButton;
    //By addToCartButton = By.xpath("//button[@id='button-cart']");
    @CacheLookup@FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")WebElement successMessage;
    //By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    @CacheLookup@FindBy(xpath = "//a[contains(text(),'shopping cart')]")WebElement shoppingCartLink;
    //By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    @CacheLookup@FindBy(xpath = "//div[@class = 'input-group date']//button")WebElement datePicker;
    //By datePicker = By.xpath("//div[@class = 'input-group date']//button");


    public String getProductText() {
        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = getListOfElements((By) dateList);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }
    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
//    public void clickOnAddToCartButton(){
//        clickOnElement(addToCartButton);
    }


    public String getProductAddedSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        clickOnElement(shoppingCartLink);
    }

    public void enterQuantity(String qty) {
        clearTextOnElement(qtyField);
        sendTextToElement(qtyField, qty);
    }

}
