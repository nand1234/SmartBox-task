package Pages;

import WebdriverLib.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WebdriverLib.ElementFactory;
/*
Store information related to tye Main menu items
 */
public class MainMenu {

    private WebDriver _driver;

    /**
     * UI Locator details
     */
    private String _cssLocatorType = "css";
    private String _categoryLocatorValue = "ul#aut-header-menu li:nth-child(1) > a";
    private String _subCategoryLocatorValue = "ul#aut-header-menu li:nth-child(1) > ul > li:nth-child(3) > a";
    private String _mainSearchLocatorValue = "input[class=\"search-input\"]";

    /**
     * Constructor to store driver instance to reuse
     * @param driver WebDriver
     */
    public MainMenu(WebDriver driver)
    {
        _driver = driver;
    }

    /**
     * Return categoy element displayed on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return Category to select
     */
    public WebElement eleGetCategory(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * Return Subcategoy element displayed on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return SubCategory to select
     */
    public WebElement eleGetSubCategory(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * Return Main search element displayed on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return search box to select
     */
    public WebElement eleMainSearch(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver );
    }

    /**
     * Select Category & Subcategory provided by user
     * @param categoryName Category Name to be selected
     * @param subCategoryName SubCategoryName to be selected
     */
    public void selectCategoryAndSubCategory(String categoryName, String subCategoryName)
    {
        CommonActions mouseOver = new CommonActions(_driver);
        WebElement category = eleGetCategory(_cssLocatorType, _categoryLocatorValue);
        mouseOver.moveToElement(category);
        eleGetSubCategory(_cssLocatorType,_subCategoryLocatorValue).click();
    }

    /**
     * Search Box using main menu search
     * @param boxNameToSearch Name of the box to search
     */
    public void searchBox(String boxNameToSearch)
    {
        eleMainSearch(_cssLocatorType, _mainSearchLocatorValue).sendKeys(boxNameToSearch);

    }

    /**
     * select box from suggestion
     */
    public void selectBoxFromSuggestion()
    {
        ElementFactory element = new ElementFactory();
        WebElement box = element.findElement("css","form#search strong", _driver );
        box.click();
    }

    /**
     * select box from suggestion
     */
    public void viewShoppingCart()
    {
        ElementFactory element = new ElementFactory();
        CommonActions click = new CommonActions(_driver);
        WebElement cart = element.findElement("css","a[class=\"header-cart qa-cart-icon js-cart-icon has-basket-count\"]", _driver );
        click.mouseClick(cart);
    }
}
