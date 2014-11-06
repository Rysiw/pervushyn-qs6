package functionalTest;


import hotlinePages.HomePage;
import hotlinePages.ProductPage;
import org.testng.annotations.Test;


/**
 * Created by Ruslan on 11/5/14.
 */
public class FindProduct extends FunctionalTest {
    public static String URL = "http://hotline.ua";

    @Test
    public void findProduct(){
        driver.get(URL);
        HomePage.loadHomePage(driver);
        ProductPage.findProduct(driver);
        //Assert.assertTrue(ProductPage.isProductPresent(driver));
    }


}
