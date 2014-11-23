package functionalTest;

import hotlinePages.HomePage;
import hotlinePages.RegisterPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.EmailGenerator;
import utils.Log4Test;
import utils.ScreenShotMaker;

/**
 * Created by Ruslan on 11/23/14.
 */
public class ScreenshotMaker extends Functional {
    @DataProvider
    public Object[][] registerPositiveData() {
        return new Object[][] {
                new Object[] {EmailGenerator.emailGenerator("user", "@gmail.com"),"user", "Qwerty123","Qwerty123"},
        };
    }


    @Test(dataProvider = "registerPositiveData")
    public void registerUserTestPositive(String email, String regName, String password, String passwordRepeat){
        Log4Test.start(getClass().getName());
        HomePage homePage = new HomePage(driver);
        homePage.openRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(email, regName, password, passwordRepeat);
        Assert.assertFalse(registerPage.successRegister(), "Unable ro register user with data: " + email + regName + password + passwordRepeat);
        Log4Test.end(getClass().getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("it is work!!!");
            ScreenShotMaker screenShotMaker = new ScreenShotMaker(driver);
            screenShotMaker.takeScreenShot("fail_"+getClass().getName());
        }
    }
}
