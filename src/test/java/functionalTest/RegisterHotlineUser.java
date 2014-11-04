package functionalTest;

import hotlinePages.HomePage;
import hotlinePages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Ruslan on 11/2/14.
 */
public class RegisterHotlineUser  {

    public static WebDriver driver;

    @BeforeSuite
    public void setInv(){
        driver = new FirefoxDriver();
    }

    @DataProvider
    public Object[][] registerData() {
        return new Object[][] {
                new Object[] {"user1@gmail.com","user1","Qwerty123","Qwerty123"},
        };
    }

    @Test(dataProvider = "registerData")
    public void registerUserTest(String email, String regName, String password, String repeatPassword){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
        driver.get("http://hotline.ua");
        driver.findElement(By.className("blue-button")).click();
        driver.findElement(By.className("reg")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("nick")).sendKeys(regName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("password2")).sendKeys(repeatPassword);
        driver.findElement(By.className("blue-button")).click();
        //Assert.assertTrue(driver.findElement(By.name("first_name"))).isDisplayed();
        HomePage homePage = new HomePage();
        homePage.openRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.registerNewUser(email, regName, password, repeatPassword);
        Assert.assertTrue(registerPage.isRegistrationSuccess());

    }

    @AfterSuite
    public void after(){
        if (driver !=null){
            driver.quit();
        }
    }
}
