package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Ruslan on 11/4/14.
 */
public class RegisterSuccessPage {

    private static final String REG_SUCCESS  = "registr-successful";

    public static boolean successRegister(WebDriver driver){
        if (driver.findElement(By.className(REG_SUCCESS)).isDisplayed()) return true;
        else return false;
    }
}
