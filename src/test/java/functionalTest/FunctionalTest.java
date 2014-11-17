package functionalTest;

import hotlinePages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriverFactory;
import selenium.WebDriverWrapper;
import utils.Log4Test;
import utils.PropertyLoader;

/**
 * Created by Ruslan on 11/5/14.
 */
public class FunctionalTest {
    public static WebDriverWrapper driver;
    //public static String URL = "http://hotline.ua";

    @BeforeSuite
    public void setInv(){
        System.out.println(PropertyLoader.loadProperty("browser.name"));
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        driver.get(PropertyLoader.loadProperty("site.url"));
        HomePage.closeBanner(driver);

    }


    @AfterSuite
    public void after(){
        Log4Test.info("Exit Browser");
        if (driver !=null){
            driver.quit();
        }
    }
}
