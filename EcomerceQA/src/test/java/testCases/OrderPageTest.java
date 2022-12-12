package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.AddToCartPage;
import pageObject.OrderPage;
import pageObject.SearchResultPage;
import pageObject.indexPage;

public class OrderPageTest extends Base {


    indexPage index;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;

    @BeforeMethod
    public void setup(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyTotalPrice() throws Throwable{
        index = new indexPage();
        searchResultPage = index.searchProduct("name");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("1");
        addToCartPage.selectSize("1");
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckout();
        Double unitPrice = orderPage.getUnitPrice();
        Double totalPrice  = orderPage.getTotalPrice();
        Double totalExpectedPrice = ( unitPrice * (Double.parseDouble("1")))+2;
        Assert.assertEquals(totalPrice, totalExpectedPrice);
    }

}
