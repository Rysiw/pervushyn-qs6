package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by Ruslan on 11/2/14.
 */
public class HomePage {

    private static final By CLOSE_BANNER = By.className("close");
    private static final By SELECT_PLACE = By.className("blue-button");
    private static final By REGISTER_LINK = By.className("reg");



    public static void closeBanner(WebDriver driver){
        driver.findElement(CLOSE_BANNER).click();
        driver.findElement(SELECT_PLACE).click();
    }

    public static void openRegisterPage(WebDriver driver)
    {
        driver.findElement(REGISTER_LINK).click();
    }

}
