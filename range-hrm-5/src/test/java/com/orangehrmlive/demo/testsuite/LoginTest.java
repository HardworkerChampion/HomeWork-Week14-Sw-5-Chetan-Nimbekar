package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    HomePage homePage;
    DashBoardPage dashBoardPage;
    LoginPage loginPage;
    AdminPage adminPage;
    ViewSystemUserPage viewSystemUserPage;
    AddUserPage addUserPage;


    @BeforeMethod(alwaysRun = true)


    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        adminPage = new AdminPage();
        viewSystemUserPage = new ViewSystemUserPage();
        addUserPage = new AddUserPage();
    }
    @Test(groups = {"sanity"})
    //1. verifyUserShouldLoginSuccessFully()
    public void verifyUserShouldLoginSuccessFully(){
        //Enter username
    //Enter password
    //Click on Login Button
        loginPage.loginToApplication();
    //Verify "WelCome" Message

    //2.
}
}