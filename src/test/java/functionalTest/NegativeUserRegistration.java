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

/**
 * Created by Ruslan on 11/5/14.
 */
public class NegativeUserRegistration extends FunctionalTest {

    @DataProvider
    public Object[][] registerNegativeData() {
        return new Object[][] {
                new Object[] {"user@gmail.com","user", "Qwerty123","Qwerty123"},
        };
    }

    @Test(dataProvider = "registerNegativeData")
    public void registerUserTest2(String email, String regName, String password, String passwordRepeat) throws InterruptedException {
        Log4Test.info("Test NegativeUserRegistration is started");
        HomePage.openRegisterPage(driver);
        RegisterPage.registerNewUser(driver, email, regName, password, passwordRepeat);
        Assert.assertTrue(RegisterPage.isUserPresent(driver), Log4Test.info("Registration failed. Please verify input data."));
        Log4Test.info("Existed User were found. Test NegativeUserRegistration passed successful");
    }

}
