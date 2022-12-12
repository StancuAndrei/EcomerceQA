package pageObject;

import actionDriver.Action;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends Base {

    @FindBy(xpath = "//*[id=\"center_column\"]")
    WebElement productResult;

    public SearchResultPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isProductAvailable() throws Throwable{
        return Action.isDisplayed(driver, productResult);
    }

    public AddToCartPage clickOnProduct() throws  Throwable{
        Action.click(driver, productResult);
        return new AddToCartPage();
    }

}
