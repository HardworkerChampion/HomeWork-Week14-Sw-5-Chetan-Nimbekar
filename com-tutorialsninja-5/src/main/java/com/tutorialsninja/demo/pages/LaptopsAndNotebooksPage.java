package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
            @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
            WebElement laptopsAndNotebooksText;
    //By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    @CacheLookup
            @FindBy(xpath = "//p[@class ='price']")
            WebElement productsList;

    //By productsList = By.xpath("//h4/a");
    @CacheLookup
            @FindBy(xpath ="//p[@class ='price']" )
            WebElement productsPrices;
    // By productsPrices = By.xpath("//p[@class ='price']");
    @CacheLookup
            @FindBy(id = "input-sort")
    WebElement sortBy;
    //By sortBy = By.id("input-sort");

    public String getLaptopsAndNotebooksText() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = getListOfElements((By) productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
    }

    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements((By) productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

}
