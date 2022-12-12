package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.AccountCreationPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.indexPage;

import java.util.HashMap;

public class AccountCreationPageTest extends Base {

    indexPage indexPage;
    LoginPage loginPage;
    AccountCreationPage accountCreationPage;
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
    public void verifyCreateAccontPageTest() throws Throwable{
        indexPage = new indexPage();
        loginPage = indexPage.clickOnSignIn();
        accountCreationPage = loginPage.createNewAccount("mail@mail.com");
        boolean result = accountCreationPage.validateAccoumCreatePage();
        Assert.assertTrue(result);
    }

//    @Test
//    public void createAccountTest(HashMap<String, String> hashMapValue) throws Throwable{
//        indexPage = new indexPage();
//        loginPage = indexPage.clickOnSignIn();
//        accountCreationPage = loginPage.createNewAccount();
//
//
//    }

}
