package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewSystemUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButtonLink;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement userNameLink;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement selectRoleLink;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'-- Select --')]")
    WebElement selectStatus;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card']//div[@role='row']")
    WebElement rowlist;
    @CacheLookup@FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")WebElement checkbox;
@CacheLookup@FindBy(xpath = "//button[normalize-space()='Delete Selected']")WebElement deleteButtonLink;
@CacheLookup@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")WebElement popUpYesLink;
@CacheLookup@FindBy(xpath = "//input[@placeholder='Type for hints...']")WebElement employeeNameTextFieldLink;
public void clickOnAddButton() {
        clickOnElement(addButtonLink);
    }

    public void enterUserName(String name) {
        sendTextToElement(userNameLink, name);
    }

    public void selectUserRoleAdmin() {
        clickOnElement(selectRoleLink);
        List<WebElement> selectList = driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        for (WebElement element : selectList) {
            if (element.getText().equalsIgnoreCase("Admin")) {
                element.click();
                break;
            }
        }
    }

    public void selectStatus() {
        clickOnElement(selectStatus);
        List<WebElement> selectList = driver.findElements(By.xpath("//div[contains(text(),'-- Select --')]"));
        for (WebElement element : selectList) {
            if (element.getText().equalsIgnoreCase("Disable")) {
                element.click();
                break;
            }
        }
    }

    public void verifyUserIsOnRecord() {
        List<WebElement> userRecord = driver.findElements(By.xpath("//div[@class='oxd-table-card']//div[@role='row']"));
        for (WebElement a : userRecord ) {
            String text = a.getText();
            System.out.println(text);
        }
    }
    public void clickOnCheckBox(){
        clickOnElement(checkbox);
    }
    public void clickOnDeleteButton(){
        clickOnElement(deleteButtonLink);
    }
    public void clickOnPopYes(){
    clickOnElement(popUpYesLink);
    }
    public void selectUserRoleAdmin(String userRole){
        clickOnElement(selectRoleLink);
        List<WebElement> selectList = driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        for (WebElement element : selectList) {
            if (element.getText().equalsIgnoreCase("Admin")) {
                element.click();
                break;
            }
        }
    }
 public void enterEmployeeName(String employee){
    sendTextToElement(employeeNameTextFieldLink,employee);
 }
    public void selectStatus1(String status) {
        clickOnElement(selectStatus);
        List<WebElement> selectList = driver.findElements(By.xpath("//div[contains(text(),'-- Select --')]"));
        for (WebElement element : selectList) {
            if (element.getText().equalsIgnoreCase("Disable")) {
                element.click();
                break;
            }
}}}