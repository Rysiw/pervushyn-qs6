package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Log4Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ruslan on 11/5/14.
 */
public class ProductPage {

    private static final By SEARCH_BOX = By.id("searchbox");
    private static final By SEARCH_BUTTON = By.id("doSearch");
    //private static final By SEARCH_RESULT = By.xpath("//a[contains(text(), 'Galaxy')]");

    public static void findProduct(WebDriver driver, String searchItem) throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log4Test.info("Clear Search Box");
        driver.findElement(SEARCH_BOX).clear();
        Log4Test.info("Find product: " + searchItem);
        driver.findElement(SEARCH_BOX).sendKeys(searchItem);
        driver.findElement(SEARCH_BUTTON).click();
        Thread.sleep(5000);
    }

    /*public static boolean isProductPresent (WebDriver driver){
        if (driver.findElement(SEARCH_RESULT).isDisplayed()){
            return true;
        }
        return false;
    }*/

}
