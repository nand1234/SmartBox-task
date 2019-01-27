package WebdriverLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonActions {

   private WebDriver _driver;

    /**
     * Constructor to store driver instance for reuse
     * @param driver WebDriver
     */
    public CommonActions(WebDriver driver)
    {
        _driver = driver;
    }

    /**
     * Perform Mouse over action on element
     * @param element Elemnt ID to perform mouse action
     */
    public void moveToElement(WebElement element)
    {
        Actions action = new Actions(_driver);
        action.moveToElement(element).perform();
    }
}
