package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.indexPage;

public class LoginPageTest extends Base {

    indexPage indexPage;
    LoginPage loginPage;

    HomePage homePage;

    @BeforeMethod
    public void setup(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest() throws Throwable{
        indexPage = new indexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );

        String actualURL = homePage.getCurrURL();
        String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(actualURL, expectedURL);

    }



}
