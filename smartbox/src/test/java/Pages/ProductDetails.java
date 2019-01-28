package Pages;

import WebdriverLib.CommonActions;
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
    private String _continueLocatorValue = "div#addtocart-confirmation a.button.no-margin-bottom.close-reveal-modal.close-reveal-modal--no-style";
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
        return element.findElement(locatorType,locatorValue, _driver ,true);
    }

    /**
     * Find Check Cart item on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return WebElement
     */
    public WebElement eleCheckCart(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver ,true  );
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
        return element.findElement(locatorType,locatorValue, _driver, true   );
    }

    /**
     * add item to the basket
     */
    public void addToBasket()
    {
        eleBasket(_cssLocatorType,_basketLocatorValue).click();
    }

    /**
     * Vievu shopping cart
     */
    public void viewCart()
    {
        CommonActions action = new CommonActions(_driver);
        WebElement viewCart= eleCheckCart(_cssLocatorType,_seeCartLocatorValue);
        action.mouseClick(viewCart);
    }

    /**
     * Click on Continue shopping
     */
    public void continueShopping()
    {
        CommonActions action = new CommonActions(_driver);
        WebElement continueShop= eleContinueShopping(_cssLocatorType,_continueLocatorValue);
        action.mouseClick(continueShop);
    }

    /**
     * Check Box title displayed
     */
    public void productTitleDisplay()
    {
        ElementFactory element = new ElementFactory();
        WebElement review = element.findElement("css","h1#product-info__title", _driver ,false);
        review.isDisplayed();
    }


}
