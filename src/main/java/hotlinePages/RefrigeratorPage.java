package hotlinePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.WebDriverWrapper;
import utils.Log4Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ruslan on 11/17/14.
 */
public class RefrigeratorPage {
    private static final String URL = "http://hotline.ua";
    private static final By LG = By.xpath("//a[contains(text(),'LG')]");
    private static final By BT = By.xpath("//a[@href='/bt/']");
    private static final By FRIDGE = By.xpath("//a[@href='/bt/holodilniki/']");
    private static final By SORT_BY_PRICE_RISE = By.xpath("//a[@href='http://hotline.ua/bt/holodilniki/627/?sort=0']");
    private static final By PRICE_LIST = By.xpath("//div[@class='price']");
    private static final By PRICE = By.xpath("//span[@class='orng']");
    private WebDriverWrapper driver;

    public RefrigeratorPage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void openFridgePage() throws InterruptedException {
        driver.get(URL);
        Actions actions = new Actions(driver.getOriginalDriver());
        actions.moveToElement(driver.findElement(BT));
        actions.perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(FRIDGE).click();
    }

    public void filterFridgeBrand(){
        driver.findElement(By.linkText("LG")).click();
        driver.findElement(By.className("ddopener")).click();
        //, String brand
    }

    public void sortFridge(){
        Log4Test.info("Select price filter");
        driver.findElement(SORT_BY_PRICE_RISE).click();
    }

    public boolean priceCompare() {
        WebElement element = driver.findElement(PRICE_LIST);
        List<WebElement> price = element.findElements(PRICE);
        Integer firstPrice = strToInt(price.get(0).getText());
        Log4Test.info("First price = " + firstPrice);
        Integer secondPrice = strToInt(price.get(1).getText());
        Log4Test.info("Second price = " + secondPrice);
        if (firstPrice < secondPrice) {
            Log4Test.info("First price smaller then second: " + firstPrice +" < " + secondPrice);
            return true;
        } else {
            Log4Test.info("Second price bigger then first: " + secondPrice +" > " + secondPrice);
            return false;
        }
    }

    public boolean countOfProduct(String inputData){
        if (driver.findElements(By.xpath("//a[contains(text(),'"+ inputData +"')]")).size()>2) {
            return true;
        } else {
            return false;
        }
    }

    public int strToInt(String str){
            String [] inputStr = str.split("\u0433\u0440\u043d");
            String rmSpaces = inputStr[0].replace(" ", "");
            int price = Integer.parseInt(rmSpaces);
            return price;
    }
}
