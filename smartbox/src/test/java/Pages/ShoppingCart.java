package Pages;

import WebdriverLib.CommonActions;
import WebdriverLib.ElementFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {

   private WebDriver _driver;

    /**
     * UI Locator details
     */
    private String _cssLocatorType = "css";
    private String _removeItemLocatorValue = "div#cart-items div.columns.item__box-qty__remove-wrapper > a";
    private String _checkOutLocatorValue = "a[class=\"item__box-qty__remove button no-arrow\"]";

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
        return element.findElement(locatorType,locatorValue, _driver , true);
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
        return element.findElement(locatorType,locatorValue, _driver , true );
    }

    /**
     * Remove item from the Cart
     */
    public void removeItemfromCart()
    {
        ElementFactory element = new ElementFactory();
        CommonActions click = new CommonActions(_driver);
        eleRemoveItem(_cssLocatorType,_removeItemLocatorValue).click();
        WebElement confirm = element.findElement("css","a[id=\"cart-remove-confirm-accept\"]", _driver, true );
        click.mouseClick(confirm);
    }

    /**
     * Proceed to checkout the cart
     */
    public void checkOut()
    {
        eleCheckOut(_cssLocatorType,_checkOutLocatorValue).click();
    }

    /**
     * Check Item added to the Cart
     */
    public void checkItemAddedToCart()
    {
        ElementFactory element = new ElementFactory();
        WebElement total = element.findElement("css","div[class=\"total summary-total__section clearfix\"]", _driver ,false );
        total.isDisplayed();
    }

    /**
     * Adjust item quantity
     */
    public void adjustQty(String qty)
    {
        ElementFactory element = new ElementFactory();
        CommonActions action = new CommonActions(_driver);
        WebElement eleqty = element.findElement("css","select[class=\"quote-item-version-qty\"]", _driver ,true);
        action.selectFromDropDown(eleqty, qty);
    }

    /**
     * Check user navigated to payment page
     * @return
     */
    public boolean verifyCheckout() throws InterruptedException
    {
        Thread.sleep(1000);
       if (_driver.getCurrentUrl().equals("https://www.smartbox.com/fr/checkout/newpayment/"))
       {
           return true;
       }
       else
       {
           return false;
       }
    }
}
