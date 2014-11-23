package functionalTest;

import hotlinePages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by Ruslan on 11/22/14.
 */
public class FindProductTests extends Functional {

    @DataProvider
    public Object[][] searchDataPositive() {
        return new Object[][] {
                new Object[] {"Galaxy"},
        };
    }

    @DataProvider
    public Object[][] searchDataNegative() {
        return new Object[][] {
                new Object[] {"#$%"},
        };
    }

    @Test(dataProvider = "searchDataPositive")
    public void findProductPositive(String searchItem){
        Log4Test.start(getClass().getName());
        ProductPage productPage = new ProductPage(driver);
        productPage.findProduct(searchItem);
        Assert.assertTrue(productPage.isProductPresent(searchItem), "Item " + searchItem + " wasn't found.");
        Log4Test.end(getClass().getName());
    }

    @Test(dataProvider = "searchDataNegative")
    public void findProductNegative(String searchItem){
        Log4Test.start(getClass().getName());
        ProductPage productPage = new ProductPage(driver);
        productPage.findProduct(searchItem);
        Assert.assertTrue(productPage.incorrectSearch(), "Search input " + searchItem + " incorrect.");
        Log4Test.end(getClass().getName());
    }
}
