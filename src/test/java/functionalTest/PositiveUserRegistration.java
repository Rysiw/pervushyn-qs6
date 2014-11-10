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
import utils.Log4Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ruslan on 11/2/14.
 */
public class PositiveUserRegistration extends FunctionalTest{

    @DataProvider
    public Object[][] registerPositiveData() {
        return new Object[][] {
                new Object[] {EmailGenerator.emailGenerator("user", "@gmail.com"),"user", "Qwerty123","Qwerty123"},
        };
    }

    @Test(dataProvider = "registerPositiveData")
    public void registerUserTest(String email, String regName, String password, String passwordRepeat) throws InterruptedException {
        Log4Test.info("Test PositiveUserRegistration is started");
        Log4Test.info("Open Register Page");
        HomePage.openRegisterPage(driver);
        Log4Test.info("Register new User");
        RegisterPage.registerNewUser(driver, email, regName, password, passwordRepeat);
        Assert.assertTrue(RegisterSuccessPage.successRegister(driver), "Welcome to HotLine. Register is success");
        Log4Test.info("New User was registered. Test PositiveUserRegistration passed successful");

    }

}
