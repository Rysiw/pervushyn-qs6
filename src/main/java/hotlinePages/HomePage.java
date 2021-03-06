package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverWrapper;
import utils.Log4Test;



/**
 * Created by Ruslan on 11/2/14.
 */
public class HomePage {

    private static final By CLOSE_BANNER = By.className("close");
    private static final By SELECT_PLACE = By.className("blue-button");
    private static final By REGISTER_LINK = By.className("reg");
    private WebDriver driver;

    public HomePage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void closeBanner(){
        Log4Test.info("Close Banner");
        driver.findElement(CLOSE_BANNER).click();
        Log4Test.info("Select location");
        driver.findElement(SELECT_PLACE).click();
    }

    public void openRegisterPage(){
        Log4Test.info("Open Register Page");
        driver.findElement(REGISTER_LINK).click();
    }

}
