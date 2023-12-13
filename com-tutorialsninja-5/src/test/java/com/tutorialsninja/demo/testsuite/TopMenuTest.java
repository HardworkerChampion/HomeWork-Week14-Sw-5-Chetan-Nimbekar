package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage ;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    //string
    //1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
    }

    @Test(groups = {"sanity","regression"})
    //Write the following Test:
    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverOnDesktopsLinkAndClick();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
       String expectedText = "Desktops";
       String actualText = desktopPage.getDesktopsText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to Desktop page");


    }
    //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click


        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(laptopsAndNotebooksPage.getLaptopsAndNotebooksText(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }
    //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click

        homePage.mouseHoverOnComponentLinkAndClick();
        //3.2 call selectMenu method and pass the menu = “Show All Components”

        homePage.selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals(componentsPage.getComponentsText(),
                "Components", "Not navigate to Laptops and Notebooks page");
    }


}
