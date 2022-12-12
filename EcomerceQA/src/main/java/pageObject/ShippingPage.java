package pageObject;

import actionDriver.Action;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends Base {
    @FindBy(id="cgv")
    private WebElement terms;

    @FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public ShippingPage(){
        PageFactory.initElements(driver, this);
    }

    public void checkTheTerms() throws  Throwable{
        Action.click(driver, terms);
    }

    public PaymentPage clickOnProceedToCheckout() throws Throwable{
        Action.click(driver, proceedToCheckOutBtn);
        return new PaymentPage();
    }

}
