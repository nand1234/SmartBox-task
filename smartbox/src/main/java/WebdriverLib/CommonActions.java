package WebdriverLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

    /**
     * Perform Mouse click action on element
     * @param element Elemnt ID to perform mouse action
     */
    public void mouseClick(WebElement element)
    {
        Actions action = new Actions(_driver);
        action.click(element).perform();
    }

    /**
     * Select value from dropdown
     * @param element element ID
     * @param value value to be selected
     */
    public void selectFromDropDown(WebElement element, String  value)
    {
        Select dropdown= new Select(element);
        dropdown.selectByValue(value);
    }
}
