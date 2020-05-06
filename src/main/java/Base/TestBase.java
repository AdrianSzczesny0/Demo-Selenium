package Base;

import Utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{

    public static WebDriver driver;
    public static Properties prop;

    public TestBase ()
    {

        try
        {
            prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/Config/config.properties"));
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /*  Initialization method below will set all the basic things at the start.
        First I am reading what browser should be initialized. This is taken from the config.properties file
        Next its time to initialize the given browser.
        maximizing the window.
        clearing up all the cookies <-- this can be problematic if we wan to use them from previous test. however it't ok for this test.
        I set up the Page load time just in case the page takes to long to start up.
        Additionally i set up the IMPLICITE wait time so that the driver will check up to 10 sec for given element before it fails the test
        because of no element found.
    */

    public static void Initialization()
    {
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","src/main/resources/WebDrivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else
        if(browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Utility.IMPLICITE_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }

}
