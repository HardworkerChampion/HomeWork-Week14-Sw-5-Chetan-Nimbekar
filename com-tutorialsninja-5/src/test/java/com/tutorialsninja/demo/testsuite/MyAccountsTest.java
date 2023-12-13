package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {
    HomePage homePage ;
    ProductPage productPage;
    ShoppingCartPage cartPage ;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage ;
    CheckoutPage checkoutPage ;
    SoftAssert softAssert ;
    AccountRegisterPage accountRegisterPage;
    MyAccountPage myAccountPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        checkoutPage = new CheckoutPage();
        accountRegisterPage = new AccountRegisterPage();
        myAccountPage = new MyAccountPage();

    }
    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    //1.2 This method should click on the options whatever name is passed as parameter.
    //(Hint: Handle List of Element and Select options
    public void selectMyAccountOptions(String option){

        List<WebElement> myAccountList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']"));
      for (WebElement element : myAccountList){
          if (element.getText().equalsIgnoreCase(option)){
              element.click();
              break;
          }
      }


    }
    @Test(groups = {"sanity","regression"})
    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully (){
        //1.1 Click on My Account Link.
        homePage.clickOnMyQAccountTab();
    //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
    //“Register”
       selectMyAccountOptions("Register");
    //1.3 Verify the text “Register Account”.
        Assert.assertEquals(getTextFromElement(By.xpath("//h1[text()='Register Account']")),"Register Account");
    }
    //2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    @Test(groups = {"sanity","smoke","regression"} )
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Clickr on My Account Link.
        homePage.clickOnMyQAccountTab();
    //2.2 Call the method “selectMyAccountOptions” method and pass the parameter
    //“Login”
        selectMyAccountOptions("Login");
    //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(getTextFromElement(By.xpath("//h2=text()='Returning Customer']")),"Returning Customer");

    }
    //3. Test name verifyThatUserRegisterAccountSuccessfully()
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        homePage.clickOnMyQAccountTab();
    //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        accountRegisterPage.enterFirstName("John" + getAlphaNumericString(4));
        //3.4 Enter Last Name
        accountRegisterPage.enterLastName("Lewis" + getAlphaNumericString(4));
        //3.5 Enter Email
        accountRegisterPage.enterEmail("Lewis" + getAlphaNumericString(4) + "@gmail.com");
        //3.6 Enter Telephone
        accountRegisterPage.enterTelephone("07988112233");
        //3.7 Enter Password
        accountRegisterPage.enterPassword("Jane123");
        //3.8 Enter Password Confirm
        accountRegisterPage.enterConfirmPassword("Jane123");
        //3.9 Select Subscribe Yes radio button
        accountRegisterPage.selectSubscription("Yes");
        //3.10 Click on Privacy Policy check box
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();
        //3.11 Click on Continue button
        accountRegisterPage.clickOnContinueButton();
        // 3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(myAccountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                "Account not created");
 //3.13 Click on Continue button 3.14 Clickr on My Account Link.
        myAccountPage.clickOnContinueButton();
        //3.14 Click on My Account Link.
        homePage.clickOnMyQAccountTab();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(myAccountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
        //3.17 Click on Continue button
        myAccountPage.clickOnContinueButton();
}
@Test(groups = {"regression"})
    //4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Clickr on My Account Link.
    homePage.clickOnMyQAccountTab();
    //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
    //“Login”
    selectMyAccountOptions("Login");
    //4.3 Enter Email address
    accountRegisterPage.enterFirstName("John" + getAlphaNumericString(4));
    accountRegisterPage.enterLastName("Lewis" + getAlphaNumericString(4));
    accountRegisterPage.enterEmail("Lewis" + getAlphaNumericString(4) + "@gmail.com");
    accountRegisterPage.enterTelephone("07988112233");
    accountRegisterPage.enterPassword("Jane123");
    accountRegisterPage.enterConfirmPassword("Jane123");
    accountRegisterPage.selectSubscription("Yes");
    accountRegisterPage.clickOnPrivacyPolicyCheckBox();
    accountRegisterPage.clickOnContinueButton();
    Assert.assertEquals(myAccountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
            "Account not created");
    myAccountPage.clickOnContinueButton();
    homePage.clickOnMyQAccountTab();
    selectMyAccountOptions("Logout");
    Assert.assertEquals(myAccountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
    myAccountPage.clickOnContinueButton();

}
}