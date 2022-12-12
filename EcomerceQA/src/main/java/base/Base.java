package base;

import actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig(){

        try{
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\Config.properties"
            );
            prop.load(ip);
            System.out.println("driver: " + driver);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch ( IOException e){
            e.printStackTrace();
        }
    }

    public static void launchApp(){
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if( browserName.contains("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ( browserName.contains("FireFox")){
            driver = new FirefoxDriver();
        } else if (browserName.contains("IE")) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Action.implicitWait(driver, 10);
        Action.pageLoadTimeOut(driver, 10);

        driver.get(prop.getProperty("url"));



//        getDriver.manage().timeouts().implicitlyWait(
//                Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS
//        );
//        getDriver.manage().timeouts().pageLoadTimeout(
//                Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS
//        );
//        getDriver().get(prop.getProperty("url"));

    }



}
