package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.indexPage;


public class IndexPageTest extends Base {

    indexPage indexPage;


    @BeforeMethod
    public void setup(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyLogo() throws Throwable{
        indexPage = new indexPage();
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test
    public void verifyTitle(){
        String actTitle = indexPage.getMyStoreTitle();
        String expectTitle = "My Store";
        Assert.assertEquals(actTitle, expectTitle);
    }



}
