package Pages;

import WebdriverLib.ElementFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductList {

    private WebDriver _driver;

    /**
     * UI Locator details
     */
    private String _cssLocatorType = "css";
    private String _locatorValue = "section#ac-cloudSearchResults article:nth-child(1) > a > div.thematic__bottom > div.button.hide-for-small";
    private String _filterTextLocatorType = "aside#catalog-search-menu div > header > h2";

    /**
     * Constructor to store driver instance for reuse
     * @param driver WebDriver
     */
    public ProductList(WebDriver driver)
    {
        _driver = driver;
    }


    /**
     * find List of Products on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return Product to be selected
     */
    public WebElement getListOfProducts(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * Select item from product List
     * @param productName Name of the Product to be selected
     */
    public void selectProduct(String productName) {
        getListOfProducts(_cssLocatorType, _locatorValue).click();
    }

    /**
     * Check Search filter displayed on product List Page
     */
    public void checkSearchFilter()
    {
        ElementFactory element = new ElementFactory();
        WebElement filter = element.findElement("css","aside#catalog-search-menu div > header > h2", _driver );
        filter.click();
    }


    /**
     * Check Review Link displayed on product List Page
     */
    public void checkReviewLink()
    {
        ElementFactory element = new ElementFactory();
        WebElement review = element.findElement("css","section#ac-cloudSearchResults article:nth-child(1) > a > div.thematic__bottom > div.price.clearfix.hide-for-small > span.rating.right > i", _driver );
        review.isDisplayed();
    }
}
