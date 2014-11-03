package functionalTests;

import hotlineBase.HomePage;
import hotlineBase.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Ruslan on 11/2/14.
 */
public class RegisterHotlineUser  {

    @DataProvider
    public Object[][] registerData() {
        return new Object[][] {
                new Object[] {"user1@gmail.com","user1","Qwerty123","Qwerty123"},
                new Object[] {"user2@gmail.com","user2","Asdfg321"},
        };
    }

    @Test(dataProvider = "registerData")
    public void registerUserTest(String email, String regName, String password, String repeatPassword){
        HomePage homePage = new HomePage();
        homePage.openRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.registerNewUser(email, regName, password, repeatPassword);
        Assert.assertTrue(registerPage.isRegistrationSuccess());

    }
}
