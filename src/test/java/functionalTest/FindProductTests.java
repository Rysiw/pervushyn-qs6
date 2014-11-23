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
    public void findProductPositive(String searchItem) throws InterruptedException {
        Log4Test.start("++++++++++++++Test FindProductPositive is started++++++++++++++");
        ProductPage productPage = new ProductPage(driver);
        productPage.findProduct(searchItem);
        Assert.assertTrue(productPage.isProductPresent(searchItem), Log4Test.info("Item was found. Test is success"));
        Log4Test.end("++++++++++++++Item was found. Test FindProductPositive passed successful++++++++++++++");
    }

    @Test(dataProvider = "searchDataNegative")
    public void findProductNegative(String searchItem) throws InterruptedException {
        Log4Test.start("++++++++++++++Test FindProductNegative is started++++++++++++++");
        ProductPage productPage = new ProductPage(driver);
        productPage.findProduct(searchItem);
        Assert.assertTrue(productPage.incorrectSearch(), Log4Test.error("Product wasn't found."));
        Log4Test.end("++++++++++++++Item wasn't found. Test FindProductNegative passed successful++++++++++++++");
    }
}
