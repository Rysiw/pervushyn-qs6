package functionalTest;

import hotlinePages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;

import java.util.List;


/**
 * Created by Ruslan on 11/9/14.
 */
public class ComparePrices extends FunctionalTest {


    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
                new Object[] {"Galaxy"},
        };
    }

    @Test(dataProvider = "searchData")
    public void comparePrices(String searchItem) throws InterruptedException {
        Log4Test.info("Test ComparePrices is started");
        Log4Test.info("Search Item");
        ProductPage.findProduct(driver, searchItem);
        Log4Test.info("Find Price");
        driver.findElement(By.className("but-box")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElements(By.className("box")).size() > 1, Log4Test.info("Found more than one price"));
        Log4Test.info("More than one price were found. Test ComparePrices passed successful");


    }
}
