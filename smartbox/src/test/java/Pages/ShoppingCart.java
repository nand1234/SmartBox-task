package Pages;

import WebdriverLib.ElementFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {

   private WebDriver _driver;

    /**
     * UI Locator details
     */
    private String _cssLocatorType = "css";
    private String _removeItemLocatorValue = "div#cart-items i";
    private String _checkOutLocatorValue = "div#sticky button[type=\"button\"] > span";

    /**
     * Constructor to store driver instance for reuse
     * @param driver WebDriver
     */
    public ShoppingCart(WebDriver driver)
    {
        _driver = driver;
    }

    /**
     * Find remove item icon on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return remove item to perform action
     */
    public WebElement eleRemoveItem(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * Find checkout element displayed on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return checkout element to perform action
     */
    public WebElement eleCheckOut(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * Remove item from the Cart
     */
    public void removeitemfromCart()
    {
        eleRemoveItem(_cssLocatorType,_removeItemLocatorValue).click();
    }

    /**
     * Proceed to checkout the cart
     */
    public void checkOut()
    {
        eleCheckOut(_cssLocatorType,_checkOutLocatorValue).click();
    }
}
