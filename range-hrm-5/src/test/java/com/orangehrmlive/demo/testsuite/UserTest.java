package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestClass;

@Listeners(CustomListeners.class)
public class UserTest extends BaseTest {
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

    //1.adminShouldAddUserSuccessFully().
    @Test(groups = {"sanity","smoke","regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        //Login to Application
        loginPage.loginToApplication();
        //click On "Admin" Tab
        dashBoardPage.clickOnAdminTab();
//Verify "System Users" Text
        adminPage.verifySystemUserText();
//click On "Add" button
        viewSystemUserPage.clickOnAddButton();
//Verify "Add User" Text
        addUserPage.verifyAddUserText();
//Select User Role "Admin"
        addUserPage.selectUserRoleAdmin();
        //enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeNameAnanyaDash("Odis  Adalwin");
        Thread.sleep(2000);
//enter Username
        addUserPage.enterUserName("Ananya");
        Thread.sleep(2000);
        //Select status "Disable"
        addUserPage.selectStatusDisable();
//enter password
        addUserPage.enterPassword("Ananya123");
//enter Confirm Password
        addUserPage.enterConfirmPassword("Ananya123");
//click On "Save" Button
        addUserPage.clickOnSaveButton();
        Thread.sleep(4000);
//verify message "Successfully Saved"
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
    }
    //2. searchTheUserCreatedAndVerifyIt().
    @Test(groups = {"smoke","regression"})
    public void searchTheUserCreatedAndVerifyIt(){
        //Login to Application
        loginPage.loginToApplication();
        //click On "Admin" Tab
        dashBoardPage.clickOnAdminTab();
        //Verify "System Users" Text
        adminPage.verifySystemUserText();
        //Enter Username
        viewSystemUserPage.enterUserName("Ananya");
        //Select User Role
        viewSystemUserPage.selectUserRoleAdmin();
        //Select Satatus
        addUserPage.selectStatusDisable();
        //Click on "Search" Button
        viewSystemUserPage.selectStatus();
        //Verify the User should be in Result list.
        viewSystemUserPage.verifyUserIsOnRecord();
    }
    //3. verifyThatAdminShouldDeleteTheUserSuccessFully().
    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        //Login to Application
        //Login to Application
        loginPage.loginToApplication();
        //click On "Admin" Tab
        dashBoardPage.clickOnAdminTab();
        //Verify "System Users" Text
        adminPage.verifySystemUserText();
        //Enter Username
        viewSystemUserPage.enterUserName("Ananya");
        //Select User Role
        viewSystemUserPage.selectUserRoleAdmin();
        //Select Satatus
        addUserPage.selectStatusDisable();
        //Click on "Search" Button
        viewSystemUserPage.selectStatus();
        //Verify the User should be in Result list.
        viewSystemUserPage.verifyUserIsOnRecord();
        //Click on Check box
        viewSystemUserPage.clickOnCheckBox();
        //Click on Delete Button
       viewSystemUserPage.clickOnDeleteButton();
        //Popup will display
        //Click on Ok Button on Popup
        viewSystemUserPage.clickOnPopYes();
        //verify message "Successfully Deleted"

    }
    @Test(dataProvider = "verified",dataProviderClass = TestClass.class,groups = {"regression"})
    //4. searchTheUserAndVerifyTheMessageRecordFound().
    public void searchTheUserAndVerifyTheMessageRecordFound(String username,String userRole,String employeeName,String status){
    //Login to Application
        loginPage.loginToApplication();
    //click On "Admin" Tab
        dashBoardPage.clickOnAdminTab();
    //Verify "System Users" Text
        adminPage.verifySystemUserText();
    //Enter Username <username>

        viewSystemUserPage.enterUserName(username);
    //Select User Role <userRole>
        viewSystemUserPage.selectUserRoleAdmin(userRole);
    //Enter EmployeeName <employeeName>
        viewSystemUserPage.enterEmployeeName(employeeName);
    //Select Satatus <status>
viewSystemUserPage.selectStatus1(status);
    //Click on "Search" Button verify message "(1) Record Found"

    //Verify username <username>
    //Click on Reset Tab
}

}