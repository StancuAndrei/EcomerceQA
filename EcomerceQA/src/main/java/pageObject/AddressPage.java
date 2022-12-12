package pageObject;

import actionDriver.Action;
import base.Base;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends Base {

    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    public AddressPage(){
        PageFactory.initElements(driver, this);
    }

    public ShippingPage clickOnCheckout() throws  Throwable{
        Action.click(driver, proceedToCheckOut);
        return new ShippingPage();
    }


}
