package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AddUserPage extends Utility {
    @CacheLookup@FindBy(xpath = "//h6[text()='Add User']")
    WebElement addUserTextLink;
    @CacheLookup@FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]")WebElement selectLink;
    @CacheLookup@FindBy(xpath = "//input[@placeholder='Type for hints...']")WebElement employeeNameTextField;
    @CacheLookup@FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")WebElement userNameTextField;
    @CacheLookup@FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]")WebElement selectLink2;
    @CacheLookup@FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-input--error']")WebElement passwordTextFieldLink;
    @CacheLookup@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")WebElement confirmPasswordLink;

    @CacheLookup@FindBy(xpath = "//button[normalize-space()='Save']") WebElement saveButtonLink;
    @CacheLookup@FindBy(xpath ="//div[text()='Admin']")WebElement role;
    public void verifyAddUserText(){
        Assert.assertEquals(getTextFromElement(addUserTextLink),"Add User");
    }
    public void selectUserRoleAdmin(){
       clickOnElement(selectLink);
       clickOnElement(role);

//        List<WebElement> selectList = driver.findElements(By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]"));
//        for (WebElement element : selectList){
//            if (element.getText().equalsIgnoreCase("Admin")){
//                element.click();
//                break;
//            }
//        }
    }
    public void enterEmployeeNameAnanyaDash(String name){
        sendTextToElement(employeeNameTextField,name);
    }
    public void enterUserName(String userName){
        sendTextToElement(userNameTextField,userName);
    }
    public void selectStatusDisable(){
        clickOnElement(selectLink2);
        List<WebElement> selectList1 = driver.findElements(By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]"));
        for (WebElement element : selectList1){
            if (element.getText().equalsIgnoreCase("Disable")){
                element.click();
                break;
            }
        }

    }
    public void enterPassword(String password){
        sendTextToElement(passwordTextFieldLink,password);
    }
    public void enterConfirmPassword(String confirmPassword){
        sendTextToElement(confirmPasswordLink,confirmPassword);
    }
    public void clickOnSaveButton(){
        clickOnElement(saveButtonLink);
    }
}
