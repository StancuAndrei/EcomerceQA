package pageObject;

import actionDriver.Action;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    @FindBy(id = "email")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submitLogin")
    WebElement signInBtn;

    @FindBy(name = "email_create")
    WebElement emailForNewAccount;

    @FindBy(name = "submitCreate")
    WebElement createNewAccountBtn;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String username, String pwd){
        Action.type(userName, username);
        Action.type(password, pwd);
        Action.click(driver, signInBtn);

        return new HomePage();
    }

    public AddressPage login_with_already_existing_account(String username, String pwd){
        Action.type(userName, username);
        Action.type(password, pwd);
        Action.click(driver, signInBtn);

        return new AddressPage();
    }

    public AccountCreationPage createNewAccount(String mail){
        Action.type(emailForNewAccount, mail);
        Action.click(driver, createNewAccountBtn);
        return new AccountCreationPage();
    }



}
