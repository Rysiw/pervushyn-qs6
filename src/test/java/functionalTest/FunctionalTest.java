package functionalTest;

import hotlinePages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Log4Test;

/**
 * Created by Ruslan on 11/5/14.
 */
public class FunctionalTest {
    public static WebDriver driver;
    public static String URL = "http://hotline.ua";

    @BeforeSuite
    public void setInv(){
        driver = new FirefoxDriver();
        Log4Test.info("Open Browser");
        driver.get(URL);
        Log4Test.info("Open target URL");
        HomePage.closeBanner(driver);
        Log4Test.info("Close Banners");
    }

    @AfterSuite
    public void after(){
        Log4Test.info("Exit Browser");
        if (driver !=null){
            driver.quit();
        }
    }
}
