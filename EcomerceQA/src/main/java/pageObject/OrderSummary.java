package pageObject;

import actionDriver.Action;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends Base {

    @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;

    public OrderSummary(){
        PageFactory.initElements(driver, this);
    }

    public OrderConfirmationPage clickOnConfirmOrderBtn() throws Throwable{
        Action.click(driver, confirmOrderBtn);
        return new OrderConfirmationPage();
    }


}
