package lessonsWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Ruslan on 11/5/14.
 */
public class Lesson7 {
    public static WebDriver driver;
    public static String URL = "http://hotline.ua";

    @BeforeSuite
    public void setInv(){
        driver = new FirefoxDriver();
    }

    @Test
    public void lesson(){
        driver.get(URL);
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/ul/li[2]/a/b")).click();
    }


    /*@AfterSuite
    public void after(){
        if (driver !=null){
            driver.quit();
        }
    }*/
}
