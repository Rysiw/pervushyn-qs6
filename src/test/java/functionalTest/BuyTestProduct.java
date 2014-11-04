package functionalTest;

import users.Users;
import inetShop.BasketPage;
import inetShop.HomePage;
import inetShop.LoginRegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Ruslan on 10/29/14.
 */
public class BuyTestProduct {

    @Test
    public void buySingleProduct(HashMap<String, Double> product, Users user){
        HomePage homePage = new HomePage();
        homePage.addToBasket(product);
        homePage.openBasket();
        BasketPage basketPage = new BasketPage();
        basketPage.buy();
        if (basketPage.isBuySuccess()){
            LoginRegisterPage loginRegisterPage = new LoginRegisterPage();
            loginRegisterPage.login(user);
        }
        Assert.assertTrue(basketPage.isBuySuccess());

    }
}
