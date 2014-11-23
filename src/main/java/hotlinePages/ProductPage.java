package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverWrapper;
import utils.Log4Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ruslan on 11/5/14.
 */
public class ProductPage {

    private static final By SEARCH_BOX = By.id("searchbox");
    private static final By SEARCH_BUTTON = By.id("doSearch");
    private static final By PRICE_BUTTON = By.className("but-box");
    private WebDriverWrapper driver;

    public ProductPage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void findProduct(String searchItem) throws InterruptedException {
        Log4Test.info("Clear Search Box");
        driver.findElement(SEARCH_BOX).clear();
        Log4Test.info("Find product: " + searchItem);
        driver.findElement(SEARCH_BOX).sendKeys(searchItem);
        driver.findElement(SEARCH_BUTTON).click();
        Thread.sleep(5000);
    }

    public boolean comparePrice (){
        driver.findElement(PRICE_BUTTON).click();
        if (driver.findElements(By.className("box")).size() > 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean isProductPresent (String searchItem) {
        if (driver.findElement(By.xpath("//a[contains(text(),'" + searchItem + "')]")).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean incorrectSearch () {
       if (driver.findElement(By.className("sabj")).isDisplayed()){
           return true;
       } else {
           return false;
       }
    }



}
