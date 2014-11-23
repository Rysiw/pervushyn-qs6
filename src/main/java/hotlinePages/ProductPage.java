package hotlinePages;

import org.openqa.selenium.By;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created by Ruslan on 11/5/14.
 */
public class ProductPage {

    private static final By SEARCH_BOX = By.id("searchbox");
    private static final By SEARCH_BUTTON = By.id("doSearch");
    private static final By PRICE_BUTTON = By.className("but-box");
    private static final By PRICE_COUNT = By.className("box");
    private static final By INCORRECT_SEARCH = By.className("sabj");
    private String findProduct = "//a[contains(text(),'%s')]";
    private WebDriverWrapper driver;

    public ProductPage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void findProduct(String searchItem){
        Log4Test.info("Clear Search Box");
        driver.findElement(SEARCH_BOX).clear();
        Log4Test.info("Find product: " + searchItem);
        driver.findElement(SEARCH_BOX).sendKeys(searchItem);
        driver.findElement(SEARCH_BUTTON).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean comparePrice (){
        driver.findElement(PRICE_BUTTON).click();
        if (driver.findElements(PRICE_COUNT).size() > 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean isProductPresent (String searchItem) {
        final By productPresence = By.xpath(String.format(findProduct,searchItem));
        if (driver.findElement(productPresence).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean incorrectSearch () {
       if (driver.findElement(INCORRECT_SEARCH).isDisplayed()){
           return true;
       } else {
           return false;
       }
    }



}
