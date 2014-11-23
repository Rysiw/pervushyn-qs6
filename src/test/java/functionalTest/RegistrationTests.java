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
    public void registerUserTestPositive(String email, String regName, String password, String passwordRepeat) throws InterruptedException {
        Log4Test.start("++++++++++++++Test PositiveUserRegistration is started++++++++++++++");
        HomePage homePage = new HomePage(driver);
        homePage.openRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(email, regName, password, passwordRepeat);
        Assert.assertTrue(registerPage.successRegister(), "Welcome to HotLine. Register is success");
        Log4Test.end("++++++++++++++New User was registered. Test PositiveUserRegistration passed successful++++++++++++++");
    }

    @Test(dataProvider = "registerNegativeData")
    public void registerUserTestNegative(String email, String regName, String password, String passwordRepeat) throws InterruptedException {
        Log4Test.start("++++++++++++++Test NegativeUserRegistration is started++++++++++++++");
        HomePage homePage = new HomePage(driver);
        homePage.openRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(email, regName, password, passwordRepeat);
        Assert.assertTrue(registerPage.isUserPresent(), "Registration failed. Please verify input data.");
        Log4Test.end("++++++++++++++Existed User were found. Test NegativeUserRegistration passed successful++++++++++++++");
    }
}
