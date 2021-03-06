package functionalTest;

import hotlinePages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriverFactory;
import selenium.WebDriverWrapper;
import utils.Log4Test;
import utils.PropertyLoader;

/**
 * Created by Ruslan on 11/5/14.
 */
public class Functional {
    public static  WebDriverWrapper driver;
    //public static WebDriverWrapper driver;
    //public static String URL = "http://hotline.ua";



    @BeforeSuite
    public void setInv(){
        System.out.println(PropertyLoader.loadProperty("browser.name"));
        Log4Test.info("Loading browser: " + PropertyLoader.loadProperty("browser.name"));
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        Log4Test.info("Opening URL: " + PropertyLoader.loadProperty("site.url") );
        driver.get(PropertyLoader.loadProperty("site.url"));
        HomePage homePage = new HomePage(driver);
        homePage.closeBanner();
    }


    @AfterSuite
    public void after(){
        Log4Test.info("Exit Browser");
        if (driver !=null){
            driver.quit();
        }
    }
}
