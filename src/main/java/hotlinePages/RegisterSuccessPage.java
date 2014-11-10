package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by Ruslan on 11/4/14.
 */
public class RegisterSuccessPage {

    private static final By REG_SUCCESS  = By.className("registr-successful");

    public static boolean successRegister(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver.findElement(REG_SUCCESS).isDisplayed()) return true;
        else return false;
    }
}
