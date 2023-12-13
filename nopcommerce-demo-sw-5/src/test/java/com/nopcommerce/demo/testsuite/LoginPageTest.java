package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)


    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    //1.userShouldNavigateToLoginPageSuccessFully().
    public void userShouldNavigateToLoginPageSuccessFully() {
        //Click on login link
        homePage.clickOnLoginTab();
        //verify that "Welcome, Please Sign In!" message display
        loginPage.verifyTextWelcome();
    }
    @Test
    //2. verifyTheErrorMessageWithInValidCredentials().
    public void verifyTheErrorMessageWithInValidCredentials(){
        //Click on login link
        homePage.clickOnLoginTab();
        //Enter EmailId
       loginPage.enterEmailId("xyz@gmail.com");
        //Enter Password
        loginPage.enterPassword("xyz123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that the Error message
       loginPage.verifyErrorMessage();
    }
    @Test
    //3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        //Click on login link
        homePage.clickOnLoginTab();
        //Enter EmailId
        loginPage.enterEmailId("arjun@gmail.com");
        //Enter Password
        loginPage.enterPassword("arjun123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that LogOut link is display
       loginPage.verifyLogoutText();
    }
    @Test(groups = {"sanity","smoke","regression"})
    //4. verifyThatUserShouldLogOutSuccessFully()
    public void verifyThatUserShouldLogOutSuccessFully() throws InterruptedException {
        //Click on login link
        homePage.clickOnLoginTab();
        //Enter EmailId
        loginPage.enterEmailId("arjun@gmail.com");
        //Enter Password
        loginPage.enterPassword("arjun123");
        Thread.sleep(2000);
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Click on LogOut Link
        loginPage.clickOnLogoutTab();
        //Verify that LogIn Link Display
        homePage.verifyLoginText();
    }




}