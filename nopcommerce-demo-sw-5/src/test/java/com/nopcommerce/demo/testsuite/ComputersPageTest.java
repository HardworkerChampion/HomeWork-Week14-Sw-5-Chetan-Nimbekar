package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
@Listeners(CustomListeners.class)
public class ComputersPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage;
    ComputersPage computersPage;
    DeskTopsPage deskTopsPage;
    BuildYourOwnComputer buildYourOwnComputer;

    @BeforeMethod(alwaysRun = true)


    public void inIt() {
        buildYourOwnComputer = new BuildYourOwnComputer();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        computersPage  = new ComputersPage();
        deskTopsPage = new DeskTopsPage();}
    @Test(groups = {"sanity","smoke","regression"})
//Inside ComputerPageTest class create following testmethods
//1. verifyUserShouldNavigateToComputerPageSuccessfully()
public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        //Click on Computer tab
        homePage.clickOnComputerTab();
//Verify "Computer" text
        computersPage.verifyComputersText();
    }
    @Test(groups = {"smoke","regression"})
//2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
//Click on Computer tab
        homePage.clickOnComputerTab();
        //Click on Desktops link
        computersPage.clickOnDeskTopsLink();
//Verify "Desktops" text
    deskTopsPage.verifyDesktopsText();
    }


    @Test(dataProvider = "credential", dataProviderClass = TestData.class ,groups = {"regression"})
    //3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        //Click on Computer tab
        homePage.clickOnComputerTab();
        //Click on Desktops link
        computersPage.clickOnDeskTopsLink();
        //Click on product name "Build your own computer"
        deskTopsPage.clickOnBuildYourOwnComputer();
        //Select processor "processor"
        //https://github.com/Mathematics13?tab=repositories
        buildYourOwnComputer.selectTheBrowser(processor);
        //Select RAM "ram"
        buildYourOwnComputer.selectTheRam(ram);
        //Select HDD "hdd"
        buildYourOwnComputer.selectTheHdd(hdd);
        //Select OS "os"
        buildYourOwnComputer.selectTheOs(os);
        //Select Software "software"
        buildYourOwnComputer.selectTheSoftware(software);
        //Click on "ADD TO CART" Button
        buildYourOwnComputer.clickOnAddCartButton();
        //Verify message "The product has been added to your shopping cart"

    }
}
