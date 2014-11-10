package selenium;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;

/**
 * Created by Ruslan on 11/10/14.
 */
public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String HTMLUNIT = "htmlunit";

    public static WebDriverWrapper initDriver(String driverName){
        WebDriverWrapper driverWrapper = null;
        if (driverName.equals(FIREFOX)) {
            driverWrapper = new WebDriverWrapper(new FirefoxDriver());
        } else

        {
            if (driverName.equals(HTMLUNIT)) {
                driverWrapper = new WebDriverWrapper(new HtmlUnitDriver());
            } else
                Assert.fail("Invalid driver name");
        }

        driverWrapper.manage().deleteAllCookies();
        driverWrapper.manage().window().maximize();
        return driverWrapper;
    }





}
