package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BuildYourOwnComputer extends Utility {
    @CacheLookup@FindBy(xpath = "(//select[@id='product_attribute_1'])[1]" )
    WebElement selectLink;
    @CacheLookup@FindBy(xpath = "(//select[@id='product_attribute_2'])[1]" )
    WebElement ram;
    @CacheLookup@FindBy(xpath = "(//select[@id='product_attribute_2'])[1]" )
    WebElement hdd;
    @CacheLookup@FindBy(xpath = "//label[normalize-space()='OS']" )
    WebElement os;
    @CacheLookup@FindBy(xpath = "//label[normalize-space()='Software']" )
    WebElement software;
    @CacheLookup@FindBy(xpath = "//label[normalize-space()='Software']" )
    WebElement addCartLink;


    public void selectTheBrowser(String browser){
        Select select = new Select(selectLink);
        select.selectByVisibleText(browser);
    }
    public void selectTheRam(String browser){
        Select select = new Select(ram);
        select.selectByVisibleText(browser);
    }
    public void selectTheHdd(String browser){
        Select select = new Select(hdd);
        select.selectByVisibleText(browser);
    }
    public void selectTheOs(String browser){
        Select select = new Select(os);
        select.selectByVisibleText(browser);
    }
    public void selectTheSoftware(String browser){
        Select select = new Select(software);
        select.selectByVisibleText(browser);
    }
    public void clickOnAddCartButton(){
        clickOnElement(addCartLink);
    }

}
