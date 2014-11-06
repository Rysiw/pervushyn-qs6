package functionalTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Ruslan on 11/5/14.
 */
public class FunctionalTest {
    public static WebDriver driver;


    @BeforeSuite
    public void setInv(){
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void after(){
        if (driver !=null){
            driver.quit();
        }
    }
}
