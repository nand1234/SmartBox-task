package WebdriverLib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

    private WebDriver _driver;
    private String _executionType;


    public BrowserFactory()
    {
        _executionType = System.getProperty("ExecutionType");
    }
    /**
     * Launch Browser Based on Config Settings/Values
     * @param browserName Browser to Launch
     * @return Browser instance
     */
    public WebDriver getBrowser(String browserName) {
        if (_executionType.toLowerCase().equals("local".toLowerCase()))
            switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                _driver = new FirefoxDriver();
                break;
            case "ie":
                _driver = new EdgeDriver();
                break;
            default:
                _driver = new FirefoxDriver();
                break;
        }
        else
        {
            //driver = new RemoteWebDriver(new URL(gridUrl), getBrowserCapabilities(browserName));

        }

        return _driver;
    }

    /**
     * Launch browser
     * @return webdriver instance
     */
    public WebDriver launchBrowser()
    {
        _driver = getBrowser(System.getProperty("BrowserName"));

        return _driver;
    }
    /**
     * Navigate to the Test URL
     * @return Launched URL
     */
    public void navigateToURL(WebDriver driver) throws InterruptedException
    {
        ElementFactory element = new ElementFactory();
        ElementWait wait = new ElementWait();
        driver.get(System.getProperty("TestURL"));
        wait.waitForPageLoad(_driver);
        Thread.sleep(1500);
        WebElement ele = element.findElement("css","a[class=\"optanon-allow-all accept-cookies-button\"]", _driver ,true);
        if (ele.isDisplayed())
        {
            ele.click();
        }
    }
}
