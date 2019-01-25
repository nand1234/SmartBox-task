package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import java.lang.Exception;
import java.util.List;

public class elementFactory {

    /**
     * Create Locators based on User Provided Locator Type and Value
     * @param locatorType Locator Type (id etc)
     * @param locatorValue Locator Value
     * @return Locator
     */
    public By getLocator(String locatorType, String locatorValue)
    {
        By Locator = null;

        try {
            switch (locatorType) {
                case "id":
                    Locator = By.id(locatorValue);
                    break;
                case "name":
                    Locator = By.name(locatorValue);
                    break;
                case "className":
                    Locator = By.className(locatorValue);
                    break;
                case "xpath":
                    Locator = By.xpath(locatorValue);
                    break;
                case "css":
                    Locator = By.cssSelector(locatorValue);
                    break;
                default:
                    throw new Exception("Locator Type not found");
            }
        }
        catch (Exception ex)
        {
        }

        return  Locator;
    }


    /**
     * Find Element On Browser to perform Action
     * @param locatorType Locator Type to search
     * @param locatorValue Locator Value to be search by
     * @param driver browser webDriver
     * @return WebElement
     */
    public WebElement FindElement(String locatorType, String locatorValue,WebDriver driver)
    {
        elementWait wait = new elementWait();
        By locator;
        WebElement element;
        try {
            locator = getLocator(locatorType, locatorValue);
            element= wait.waitForElement(locator,driver);
        }
        catch (Exception ex)
        {
            throw ex;
        }

        return element;
    }

    /**
     * Find Elements as List On Browser to perform Action
     * @param locatorType Locator Type to search
     * @param locatorValue Locator Value to be search by
     * @param driver browser webDriver
     * @return WebElement
     * @throws InterruptedException
     */
    public List<WebElement> FindElements(String locatorType, String locatorValue, WebDriver driver) throws InterruptedException
    {
        elementWait wait = new elementWait();
        By locator;
        List<WebElement> element;


        try {
            locator = getLocator(locatorType, locatorValue);
            element =  wait.waitForElements(locator,driver);
        }
        catch (Exception ex)
        {
            throw ex;
        }

        return element;
    }
}
