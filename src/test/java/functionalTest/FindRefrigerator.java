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
    public void findRefrigerator(String inputData){
        Log4Test.start(getClass().getName());
        RefrigeratorPage refrigeratorPage = new RefrigeratorPage(driver);
        refrigeratorPage.openFridgePage();
        refrigeratorPage.filterFridgeBrand(inputData);
        refrigeratorPage.sortFridge();
        Assert.assertTrue(refrigeratorPage.countOfProduct(inputData), "Unable to count product: " + inputData);
        Assert.assertTrue(refrigeratorPage.priceCompare(), "Unable to compare prices for product: " + inputData);
        Log4Test.end(getClass().getName());

    }
}

