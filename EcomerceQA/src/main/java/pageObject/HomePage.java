package pageObject;

import actionDriver.Action;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    @FindBy(xpath = "//span[text()='My wishlists']")
    WebElement myWishListsBtn;

    @FindBy(xpath = "//span[text()='Order history and details']")
    WebElement orderHistory;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean validateMyWishList() throws Throwable{
        return Action.isDisplayed(driver, myWishListsBtn);
    }

    public boolean validateOrderHistory(){
        return Action.isDisplayed(driver, orderHistory);
    }

    public String getCurrURL(){
        return driver.getCurrentUrl();
    }


}
