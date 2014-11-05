package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Ruslan on 11/2/14.
 */
public class HomePage {

    public static String CLOSE_BANNER = "close";
    public static String SELECT_PLACE = "blue-button";
    public static String REGISTER_LINK = "reg";


    public static void loadHomePage(WebDriver driver){
        driver.findElement(By.className(CLOSE_BANNER)).click();
        driver.findElement(By.className(SELECT_PLACE)).click();
    }

    public static void openRegisterPage(WebDriver driver){
        driver.findElement(By.className(REGISTER_LINK)).click();
    }

}
