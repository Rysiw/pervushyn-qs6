package functionalTest;


import hotlinePages.RefrigeratorPage;
import hotlinePages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;


/**
 * Created by Ruslan on 11/12/14.
 */
public class FindRefrigerator extends Functional {

    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
                new Object[] {"LG"},
        };
    }

    @Test(dataProvider = "searchData")
    public void findRefrigerator(String inputData) throws InterruptedException {
        Log4Test.info("++++++++++++++Test FindRefrigerator is started++++++++++++++");
        //Log4Test.startTest("test name");
        RefrigeratorPage refrigeratorPage = new RefrigeratorPage(driver);
        refrigeratorPage.openFridgePage();
        refrigeratorPage.filterFridgeBrand();
        refrigeratorPage.sortFridge();
        Assert.assertTrue(refrigeratorPage.countOfProduct(inputData), "More than 2 prices of LG refrigerators");
        Assert.assertTrue(refrigeratorPage.priceCompare(), "Prices were compared");
        Log4Test.info("++++++++++++++Test passed successful++++++++++++++");

    }
}

