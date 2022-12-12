package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.indexPage;

public class HomePageTest extends Base {

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
    public void WishListTest() throws Throwable{
        indexPage = new indexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
        boolean result = homePage.validateMyWishList();
        Assert.assertTrue(result);

    }

    @Test
    public void orderHistoryandDetailsTest() throws Throwable{
        indexPage = new indexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
        boolean result = homePage.validateOrderHistory();
        Assert.assertTrue(result);
    }



}
