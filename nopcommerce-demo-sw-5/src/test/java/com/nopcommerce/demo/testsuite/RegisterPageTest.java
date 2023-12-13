package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage;
    ComputersPage computersPage;
    DeskTopsPage deskTopsPage;

    @BeforeMethod(alwaysRun = true)


    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
       computersPage  = new ComputersPage();
       deskTopsPage = new DeskTopsPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
//1. verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Verify "Register" text
        registerPage.verifyRegisterText();


    }

    @Test(groups = {"smoke","regression"})
    //2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Click on "REGISTER" button
        registerPage.clickOnRegisterBtn();
        //Verify the error message "First name is required."
        registerPage.verifyErrorMsg1stName();
        //Verify the error message "Last name is required."
        registerPage.verifyErrorLastName();
        //Verify the error message "Email is required."
        registerPage.verifyErrorMsgEmail();
        //Verify the error message "Password is required."
        registerPage.verifyErrorMsgPassword();
        //Verify the error message "Password is required."
        registerPage.verifyErrorMsgCnfPassword();
    }

    @Test(groups = {"regression"})
    //2. verifyThatUserShouldCreateAccountSuccessfully()
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Select gender "Female"
        registerPage.selectGenderFemale();
        //Enter firstname
        registerPage.enterFirstName("Elizabeth");
        //Enter lastname
        registerPage.enterLastName("Prince");
        //Select day
        registerPage.selectDay();
        //Select month
        registerPage.selectMonth();
        //Select year
        registerPage.selectYear();
        //Enter email
        registerPage.enterEmail("Elizabeth@gmail.com");
        //Enter password
        registerPage.enterPassword("Elizabeth123");
        //Enter Confirm Password
        registerPage.enterConfPassword("Elizabeth123");
        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //Verify message "Your registration completed"
        registerPage.verifyMsgRegistrationComplete();
    }


}