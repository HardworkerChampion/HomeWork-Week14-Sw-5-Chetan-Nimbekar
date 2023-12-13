package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {
    @CacheLookup@FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    //By shoppingCartText = By.xpath("//div[@id='content']//h1");
    @CacheLookup@FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")WebElement productName;
    //By productName = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    @CacheLookup@FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")WebElement deliveryDate;
    //By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    @CacheLookup@FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")WebElement model;
    // By model = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    @CacheLookup@FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")WebElement total;
    //By total = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
   @CacheLookup@FindBy(xpath = "//input[contains(@name, 'quantity')]")WebElement qtyField;
    //By qtyField = By.xpath("//input[contains(@name, 'quantity')]");
    @CacheLookup@FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")WebElement qtyUpdateBtn;
    //By qtyUpdateBtn = By.xpath("//button[contains(@data-original-title, 'Update')]");
   @CacheLookup@FindBy(xpath = "//div[@id='checkout-cart']/div[1]" )WebElement successModifiedMessage;
    //By successModifiedMessage = By.xpath("//div[@id='checkout-cart']/div[1]");
    @CacheLookup@FindBy(linkText = "Checkout")WebElement checkoutButton;

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
            }

    public String getProductName() {
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        return getTextFromElement(model);
    }

    public String getTotal() {
        return getTextFromElement(total);

    }


    public void changeQuantity(String qty) {
        sendTextToElement(qtyField, qty);
    }

    public void clickOnQtyUpdateButton() {
        clickOnElement(qtyUpdateBtn);
    }

    public String getSuccessModifiedMessage() {
        return getTextFromElement(successModifiedMessage);
    }
    public void clickOnCheckOutButton(){
        clickOnElement(checkoutButton);
    }

}
