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
    public void comparePrices(String searchItem){
        Log4Test.start(getClass().getName());
        ProductPage productPage = new ProductPage(driver);
        productPage.findProduct(searchItem);
        Assert.assertTrue(productPage.comparePrice(), "Price for product " + searchItem + " wasn't compared");
        Log4Test.end(getClass().getName());
    }
}
