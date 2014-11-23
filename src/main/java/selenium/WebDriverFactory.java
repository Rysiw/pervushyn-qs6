package selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Ruslan on 11/10/14.
 */
public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String FIREFOX_REMOTE = "firefox_remote";
    public static final String HTMLUNIT = "htmlunit";


    public static WebDriverWrapper initDriver(String driverName){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        WebDriverWrapper driverWrapper = null;
        if (driverName.equals(FIREFOX)) {
            driverWrapper = new WebDriverWrapper(new FirefoxDriver());
        } else {
            if (driverName.equals(HTMLUNIT)) {
                driverWrapper = new WebDriverWrapper(new HtmlUnitDriver());
            } else {
                if (driverName.equals(FIREFOX_REMOTE)) {
                    try {
                        driverWrapper = new WebDriverWrapper(new RemoteWebDriver(new URL(PropertyLoader.loadProperty("selenium.hub")), capabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else
                    Assert.fail("Invalid driver name");
            }
        }

        driverWrapper.manage().deleteAllCookies();
        driverWrapper.manage().window().maximize();
        return driverWrapper;
    }





}
