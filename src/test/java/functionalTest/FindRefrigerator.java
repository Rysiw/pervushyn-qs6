package functionalTest;


import hotlinePages.RefrigeratorPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;


/**
 * Created by Ruslan on 11/12/14.
 */
public class FindRefrigerator extends FunctionalTest{
    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
                new Object[] {"LG"},
        };
    }

    @Test(dataProvider = "searchData")
    public void findRefrigerator(String inputData) throws InterruptedException {
        Log4Test.info("Test FindRefrigerator is started");
        RefrigeratorPage.openFridgePage(driver);
        RefrigeratorPage.filterFridgeBrand(driver);
        RefrigeratorPage.sortFridge(driver);
        Assert.assertTrue(RefrigeratorPage.countOfProduct(driver,inputData), Log4Test.info("More than 2 prices of LG refrigerators"));
        Assert.assertTrue(RefrigeratorPage.priceCompare(driver), Log4Test.info("Prices were compared"));
        Log4Test.info("Test passed successful");

    }
}

