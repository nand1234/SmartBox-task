package WebdriverLib;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ElementWait {

    private static final int GLOBAL_TIME_OUT = 60; // In Seconds
    private static final int GLOBAL_POLLING_TIME = 1; // In Seconds
    private static final int GLOBAL_EXP_CONDITION_TIME_OUT = 60; // In Seconds

    /**
     *
     * @param locator
     * @param driver
     * @return
     */
    public WebElement waitForElement(By locator , WebDriver driver) {
        return waitForElement(locator , driver,false);

    }


    /**
     * Wait for Element before performing Action
     * @param locator Element locator value
     * @param driver WebDriver Instance
     * @return Found element
     */
    public WebElement waitForElement(By locator , WebDriver driver, Boolean... obClickable) {

        boolean bClick = false;
        if(obClickable.length > 0)
            bClick = obClickable[0];
        WebDriverWait wait = new WebDriverWait(driver, GLOBAL_TIME_OUT);
        wait.pollingEvery(Duration.ofSeconds(GLOBAL_POLLING_TIME));

        if(bClick)
            return wait.until(
                    ExpectedConditions.elementToBeClickable(locator));
        else {
            /*try {
                return ElementWait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator));
            }catch(TimeoutException e){*/
            return wait.until(
                    ExpectedConditions.presenceOfElementLocated(locator));
            //}
        }
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //return element;
    }

    /**
     * Wait for Element before performing Action
     * @param locator Element locator value
     * @param driver WebDriver Instance
     * @return Found List of Elements
     */
    public List<WebElement> waitForElements(By locator, WebDriver driver) throws InterruptedException
    {
        int i = 0;
        List<WebElement> elements = null;

        do {
            try {
                elements = driver.findElements(locator);
                if (elements.isEmpty())
                {
                    Thread.sleep(GLOBAL_POLLING_TIME * 1000);
                    i = i + GLOBAL_POLLING_TIME * 1000;
                }
            } catch (NoSuchElementException ex) {

            }
        }
        while (i < GLOBAL_TIME_OUT * 60000);
        //while (i != GLOBAL_TIME_OUT * 60000);

        return  elements;
    }


    /**
     * Wait Until Element is clickable
     * @param elementLocator Element to be ElementWait for
     * @param driver WebDriver Instance
     * @return WebElement
     */
    public WebElement WaitElementToBeClickable(By elementLocator, WebDriver driver)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, GLOBAL_EXP_CONDITION_TIME_OUT);
            return wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
