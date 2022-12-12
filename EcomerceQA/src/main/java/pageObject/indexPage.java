package pageObject;

import actionDriver.Action;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage extends Base {

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInBtn;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement logo;

    @FindBy(id = "search_query_top")
    WebElement searchProductBox;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    public indexPage(){
        PageFactory.initElements(driver, this);

    }


    public LoginPage clickOnSignIn() throws Throwable{
        Action.fluentWait(driver, signInBtn, 10);
        Action.click(driver, signInBtn);
        return new LoginPage();
    }

    public boolean validateLogo() throws Throwable{
        return Action.isDisplayed(driver, logo);
    }

    public String getMyStoreTitle(){
        String myStoreTitle = driver.getTitle();
        return myStoreTitle;
    }

    public SearchResultPage searchProduct(String productName){

        Action.type(searchProductBox, productName);
        Action.click(driver, searchButton);
        return new SearchResultPage();

    }




}
