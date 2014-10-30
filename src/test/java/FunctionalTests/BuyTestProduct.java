package FunctionalTests;

import Actors.Users;
import InternetShop.BusketPage;
import InternetShop.HomePage;
import InternetShop.LoginRegisterPage;
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
        BusketPage busketPage = new BusketPage();
        busketPage.buy();
        if (busketPage.isBuySucess()){
            LoginRegisterPage loginRegisterPage = new LoginRegisterPage();
            loginRegisterPage.login(user);
        }
        Assert.assertTrue(busketPage.isBuySucess());

    }
}
