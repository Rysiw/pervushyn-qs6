package functionalTest;

import hotlinePages.HomePage;
import hotlinePages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.EmailGenerator;
import utils.Log4Test;

/**
 * Created by Ruslan on 11/22/14.
 */
public class RegistrationTests extends Functional {
    @DataProvider
    public Object[][] registerPositiveData() {
        return new Object[][] {
                new Object[] {EmailGenerator.emailGenerator("user", "@gmail.com"),"user", "Qwerty123","Qwerty123"},
        };
    }

    @DataProvider
    public Object[][] registerNegativeData() {
        return new Object[][] {
                new Object[] {"user@gmail.com","user", "Qwerty123","Qwerty123"},
        };
    }

    @Test(dataProvider = "registerPositiveData")
    public void registerUserTestPositive(String email, String regName, String password, String passwordRepeat){
        Log4Test.start(getClass().getName());
        HomePage homePage = new HomePage(driver);
        homePage.openRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(email, regName, password, passwordRepeat);
        Assert.assertTrue(registerPage.successRegister(), "Unable ro register user with data: "+ email + regName + password + passwordRepeat);
        Log4Test.end(getClass().getName());
    }

    @Test(dataProvider = "registerNegativeData")
    public void registerUserTestNegative(String email, String regName, String password, String passwordRepeat){
        Log4Test.start(getClass().getName());
        HomePage homePage = new HomePage(driver);
        homePage.openRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(email, regName, password, passwordRepeat);
        Assert.assertTrue(registerPage.isUserPresent(), "User : " + email + regName + password + " isn't present");
        Log4Test.end(getClass().getName());
    }
}
