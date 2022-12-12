package pageObject;

import actionDriver.Action;
import base.Base;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends Base {

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(name = "group_1")
    WebElement size;

    @FindBy(xpath = "//span[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]//h2/i")
    WebElement addToCartMessage;

    @FindBy(xpath = "//span[contains(text(), 'Proceed to checkout')]")
    WebElement proceedToCheckout;

    public AddToCartPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterQuantity(String quantity_1) throws Throwable{
        Action.type(quantity, quantity_1);
    }

    public void selectSize(String size_1) throws Throwable{
        Action.selectByVisibleText(size_1, size);
    }

    public void clickOnAddToCart() throws Throwable{
        Action.click(driver, addToCartBtn);

    }

    public boolean validateAddToCart() throws Throwable{
        Action.fluentWait(driver, addToCartMessage, 10);
        return Action.isDisplayed(driver, addToCartMessage);
    }

    public OrderPage clickOnCheckout(){
        Action.JSClick(driver, proceedToCheckout);
        return new OrderPage();
    }

}
