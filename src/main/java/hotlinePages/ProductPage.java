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
        Log4Test.info("Click search button");
        driver.findElement(SEARCH_BUTTON).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean comparePrice (){
        Log4Test.info("Execute method to compare prices");
        driver.findElement(PRICE_BUTTON).click();
        if (driver.findElements(PRICE_COUNT).size() > 1){
            Log4Test.info("More than one prices were found");
            return true;
        } else {
            Log4Test.info("Number of prices equal to one");
            return false;
        }
    }

    public boolean isProductPresent (String searchItem) {
        Log4Test.info("Execute method for verification of product presence");
        final By productPresence = By.xpath(String.format(findProduct,searchItem));
        if (driver.findElement(productPresence).isDisplayed()) {
            Log4Test.info("Product " + searchItem + "was found");
            return true;
        } else {
            Log4Test.info("Product " + searchItem + "wasn't found");
            return false;
        }
    }

    public boolean incorrectSearch () {
        Log4Test.info("Execute method for incorrect search");
        if (driver.findElement(INCORRECT_SEARCH).isDisplayed()){
            Log4Test.info("Search query was incorrect");
            return true;
        } else {
            Log4Test.info("Search query was correct");
            return false;
        }
    }



}
