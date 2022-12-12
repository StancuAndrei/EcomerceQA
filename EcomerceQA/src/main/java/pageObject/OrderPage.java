package pageObject;

import actionDriver.Action;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends Base {

    @FindBy(xpath="//td[@class='cart_unit']/span/span")
    private WebElement unitPrice;

    @FindBy(id="total_price")
    private WebElement totalPrice;

    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    public OrderPage(){
        PageFactory.initElements(driver, this);
    }

    public double getUnitPrice(){
        String unit = unitPrice.getText();
        String editedUnit = unit.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice = Double.parseDouble(editedUnit);
        return finalUnitPrice/100;
    }

    public double getTotalPrice(){
        String total = totalPrice.getText();
        String editedTotal = total.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice = Double.parseDouble(editedTotal);
        return finalTotalPrice/100;
    }

    public LoginPage clickOnCheckOut() throws Throwable {
        Action.click(driver, proceedToCheckOut);
        return new LoginPage();
    }


}
