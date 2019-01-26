package Lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.IOException;
import java.text.ParseException;

public class BrowserFactory {

    private WebDriver driver;
    private String browserName;
    private String executionType = "";


    /**
     * Launch Browser Based on Config Settings/Values
     *
     * @return Browser Instance
     * @throws IOException
     * @throws ParseException
     */
    public WebDriver GetBrowser() throws IOException, ParseException {

        SetExecutionType();
        if (executionType.equals("local"))
            switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new EdgeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        else
        {
            //driver = new RemoteWebDriver(new URL(gridUrl), getBrowserCapabilities(browserName));

        }

        return driver;
    }

    /**
     * Set Execution Type
     *
     * @throws IOException
     * @throws ParseException
     */
    private void SetExecutionType() throws IOException, ParseException {

        executionType = "local";

        browserName = System.getProperty("BrowserName");
    }

}
