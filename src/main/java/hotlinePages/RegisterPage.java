package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ruslan on 11/2/14.
 */
public class RegisterPage {

    private static final By ERROR  = By.className("errors");
    private static final By EMAIL = By.name("email");
    private static final By NICK_NAME = By.name("nick");
    private static final By PASSWORD = By.name("password");
    private static final By PASSWORD_REPEAT = By.name("password2");
    private static final By REGISTER_BUTTON = By.className("blue-button");

    public static void registerNewUser(WebDriver driver, String inputEmail, String inputName, String inputPassword, String inputPasswordRepeat){
        driver.findElement(EMAIL).sendKeys(inputEmail);
        driver.findElement(NICK_NAME).sendKeys(inputName);
        driver.findElement(PASSWORD).sendKeys(inputPassword);
        driver.findElement(PASSWORD_REPEAT).sendKeys(inputPasswordRepeat);
        driver.findElement(REGISTER_BUTTON).click();
    }

    public static boolean isUserPresent(WebDriver driver){
        if (driver.findElement(ERROR).isDisplayed()){
            return true;
        }
        return false;
    }
}
