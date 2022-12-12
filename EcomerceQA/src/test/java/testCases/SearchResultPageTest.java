package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.SearchResultPage;
import pageObject.indexPage;

public class SearchResultPageTest extends Base {

    indexPage index;
    SearchResultPage searchResultPage;



    @BeforeMethod
    public void setup(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void productAvailabilityTest() throws Throwable{

        index = new indexPage();
        searchResultPage = index.searchProduct("productName");
        boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);

    }


}
