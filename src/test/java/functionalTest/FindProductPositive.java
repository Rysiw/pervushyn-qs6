package functionalTest;


import hotlinePages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;


/**
 * Created by Ruslan on 11/5/14.
 */
public class FindProductPositive extends FunctionalTest {

    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
                new Object[] {"Galaxy"},
        };
    }

    @Test(dataProvider = "searchData")
    public void findProductPositive(String searchItem) throws InterruptedException {
        Log4Test.info("FindProductPositive Test");
        Log4Test.info("Search Item");
        ProductPage.findProduct(driver, searchItem);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'" + searchItem + "')]")).isDisplayed(),Log4Test.info("Item was found. Test is success"));
    }

}
