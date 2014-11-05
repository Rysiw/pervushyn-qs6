package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ruslan on 11/2/14.
 */
public class RegisterPage {

    public static String ERROR  = "errors";
    public static String EMAIL = "email";
    public static String NICK_NAME = "nick";
    public static String PASSWORD = "password";
    public static String PASSWORD_REPEAT = "password2";
    public static String REGISTER_BUTTON = "blue-button";


    public static void registerNewUser(WebDriver driver, String inputEmail, String inputName, String inputPassword, String inputPasswordRepeat){
        driver.findElement(By.name(EMAIL)).sendKeys(inputEmail);
        driver.findElement(By.name(NICK_NAME)).sendKeys(inputName);
        driver.findElement(By.name(PASSWORD)).sendKeys(inputPassword);
        driver.findElement(By.name(PASSWORD_REPEAT)).sendKeys(inputPasswordRepeat);
        driver.findElement(By.className(REGISTER_BUTTON)).click();

    }

    public static boolean isUserPresent(WebDriver driver){
        if (driver.findElement(By.className(ERROR)).isDisplayed()){
            return true;
        }
        return false;

    }
}
