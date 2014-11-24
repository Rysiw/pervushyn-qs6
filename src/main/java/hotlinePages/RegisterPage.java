package hotlinePages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverWrapper;
import utils.Log4Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ruslan on 11/2/14.
 */
public class RegisterPage {
    private WebDriverWrapper driver;
    private static final By ERROR  = By.className("errors");
    private static final By EMAIL = By.name("email");
    private static final By NICK_NAME = By.name("nick");
    private static final By PASSWORD = By.name("password");
    private static final By PASSWORD_REPEAT = By.name("password2");
    private static final By REGISTER_BUTTON = By.className("blue-button");
    private static final By REG_SUCCESS  = By.className("registr-successful");

    public RegisterPage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void registerNewUser(String inputEmail, String inputName, String inputPassword, String inputPasswordRepeat){
        Log4Test.info("Add new User wuth such data: " + "E-mail: " + inputEmail + "Name: " + inputName + "Password: " + inputPassword );
        driver.findElement(EMAIL).sendKeys(inputEmail);
        driver.findElement(NICK_NAME).sendKeys(inputName);
        driver.findElement(PASSWORD).sendKeys(inputPassword);
        driver.findElement(PASSWORD_REPEAT).sendKeys(inputPasswordRepeat);
        Log4Test.info("Registering new User");
        driver.findElement(REGISTER_BUTTON).click();
    }

    public boolean successRegister(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log4Test.info("Verify that Registration passed successful ");
        if (driver.findElement(REG_SUCCESS).isDisplayed()){
            Log4Test.info("Welcome message is present");
            return true;
        }
        else {
            Log4Test.info("Welcome message is absent");
            return false;
        }
    }

    public boolean isUserPresent(){
        Log4Test.info("Verification of USER presence");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log4Test.info("Verify if User exist");
        if (driver.findElements(ERROR).size() !=0){
            Log4Test.info("Error message is appear. User with such input data is exist");
            return true;
        }else {
            Log4Test.info("Data for register new user is unique");
            return false;
        }
    }
}
