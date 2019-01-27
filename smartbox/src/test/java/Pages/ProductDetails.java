package Pages;

import WebdriverLib.ElementFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetails {

    private WebDriver _driver;

    /**
     * UI Locator details
     */
    private String _cssLocatorType = "css";
    private String _basketLocatorValue = "div#box-type-ebox-classic span > span > span";
    private String _continueLocatorValue = "div#box-type-ebox-classic span > span > span";
    private String _seeCartLocatorValue = "div#addtocart-confirmation a.button.primary.no-margin-bottom";

    /**
     * Constructor to store driver instance for reuse
     * @param driver WebDriver
     */
    public ProductDetails(WebDriver driver)
    {
        _driver = driver;
    }

    /**
     * Find Basket element on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return basket element
     */
    public WebElement eleBasket(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * Find Check Cart item on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return
     */
    public WebElement eleCheckCart(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * Find Continue shopping button on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return Continue shopping button
     */
    public WebElement eleContinueShopping(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * add item to the basket
     */
    public void addToBasket()
    {
        eleBasket(_cssLocatorType,_basketLocatorValue).click();
        seeCart();
    }

    /**
     * See shopping cart
     */
    public void seeCart()
    {
        eleCheckCart(_cssLocatorType,_seeCartLocatorValue).click();
    }

    /**
     * See shopping cart
     */
    public void continueShopping()
    {
        eleContinueShopping(_cssLocatorType,_continueLocatorValue).click();
    }
}
