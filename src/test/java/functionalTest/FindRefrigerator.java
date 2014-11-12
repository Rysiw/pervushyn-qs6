package functionalTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log4Test;

import java.util.List;


/**
 * Created by Ruslan on 11/12/14.
 */
public class FindRefrigerator extends FunctionalTest{

    private static final String REF_URL = "http://hotline.ua/bt/holodilniki/";
    private static final By LG = By.xpath("//a[contains(text(),'LG')]");

    @Test
    public void findRefrigerator() throws InterruptedException {
        /*Actions actions = new Actions (driver);
        WebElement menuHoverLink = driver.findElement(By.linkText("Бытовая техника"));
        actions.moveToElement(menuHoverLink).perform();
        WebElement subLink = driver.findElement(By.xpath("//a[@href='/bt/holodilniki/']"));
        actions.moveToElement(subLink);
        actions.click();
        actions.perform();*/
        Log4Test.info("Test FindRefrigerator is started");
        driver.get(REF_URL);
        driver.findElement(By.linkText("LG")).click();
        Log4Test.info("Uses filter for brand LG");
        driver.findElement(By.className("ddopener")).click();
        Log4Test.info("Select price filter");
        driver.findElement(By.xpath("//a[contains(text(),'возрастанию цены')]")).click();
        Log4Test.info("Find more than 2 first refrigerators are LG ");
        Assert.assertTrue(driver.findElements(LG).size()>2, Log4Test.info("More than 2 prices of LG refrigerators"));
        Log4Test.info("Test passed successful");

        //WebElement element = driver.findElement(By.xpath("//div[@class='price']"));
        //List<WebElement> prices = element.findElements(By.xpath("//span[@class='orng']"));


    }
}

