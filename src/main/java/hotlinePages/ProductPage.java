package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ruslan on 11/5/14.
 */
public class ProductPage {

    public static String PRODUCT = "searchbox";
    public static String SEARCH_BUTTON = "doSearch";
    public static String SEARCH_RESULT = "//a[contains(text(), 'Galaxy')]";

    public static void findProduct(WebDriver driver){
        driver.findElement(By.id(PRODUCT)).sendKeys("galaxy");
        driver.findElement(By.id(SEARCH_BUTTON)).click();
    }

    public static boolean isProductPresent (WebDriver driver){
        if (driver.findElement(By.xpath(SEARCH_RESULT)).isDisplayed()){
            return true;
        }
        return false;
    }

}
