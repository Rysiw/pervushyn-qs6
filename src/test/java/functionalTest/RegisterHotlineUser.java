package functionalTest;

import hotlinePages.EmailGenerator;
import hotlinePages.HomePage;
import hotlinePages.RegisterPage;
import hotlinePages.RegisterSuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Ruslan on 11/2/14.
 */
public class RegisterHotlineUser  {

    public static WebDriver driver;
    public static String URL = "http://hotline.ua";

    @BeforeSuite
    public void setInv(){
        driver = new FirefoxDriver();
    }


    @DataProvider
    public Object[][] registerData() {
        return new Object[][] {
                new Object[] {EmailGenerator.emailGenerator("user", "@gmail.com"),"user", "Qwerty123","Qwerty123"},
        };
    }


    @Test(dataProvider = "registerData")
    public void registerUserTest(String email, String regName, String password, String passwordRepeat){
        driver.get(URL);
        HomePage.loadHomePage(driver);
        HomePage.openRegisterPage(driver);
        RegisterPage.registerNewUser(driver, email, regName, password, passwordRepeat);
        Assert.assertTrue(RegisterSuccessPage.successRegister(driver));

    }


    @AfterSuite
    public void after(){
        if (driver !=null){
            driver.quit();
        }
    }
}
