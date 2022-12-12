package pageObject;

import actionDriver.Action;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends Base {

    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    private WebElement bankWireMethod;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    private WebElement payByCheckMethod;

    public PaymentPage(){
        PageFactory.initElements(driver, this);
    }

    public OrderSummary clickOnPaymentMethod() throws Throwable{
        Action.click(driver, bankWireMethod);
        return new OrderSummary();
    }



}
