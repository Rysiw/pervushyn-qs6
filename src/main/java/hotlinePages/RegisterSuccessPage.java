package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Ruslan on 11/4/14.
 */
public class RegisterSuccessPage {

    private static final By REG_SUCCESS  = By.className("registr-successful");

    public static boolean successRegister(WebDriver driver){
        if (driver.findElement(REG_SUCCESS).isDisplayed()) return true;
        else return false;
    }
}
