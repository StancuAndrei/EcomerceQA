package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.AddToCartPage;
import pageObject.SearchResultPage;
import pageObject.indexPage;

public class AddToCartPageTest extends Base {

    indexPage index;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;



    @BeforeMethod
    public void setup(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void addToCartTest() throws Throwable{
        index = new indexPage();
        searchResultPage = index.searchProduct("productName");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("1");
        addToCartPage.selectSize("1");
        addToCartPage.clickOnAddToCart();
        boolean result  = addToCartPage.validateAddToCart();
        Assert.assertTrue(result);
    }


}
