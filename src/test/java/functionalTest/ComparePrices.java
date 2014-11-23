package functionalTest;

import hotlinePages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;


/**
 * Created by Ruslan on 11/9/14.
 */
public class ComparePrices extends Functional {



    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
                new Object[] {"Galaxy"},
        };
    }

    @Test(dataProvider = "searchData")
    public void comparePrices(String searchItem) throws InterruptedException {
        Log4Test.info("++++++++++++++Test ComparePrices is started++++++++++++++");
        ProductPage productPage = new ProductPage(driver);
        productPage.findProduct(searchItem);
        Assert.assertTrue(productPage.comparePrice(), Log4Test.info("Found more than one price"));
        Log4Test.info("++++++++++++++More than one price were found. Test ComparePrices passed successful++++++++++++++");


    }
}
