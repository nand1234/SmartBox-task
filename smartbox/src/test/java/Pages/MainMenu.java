package Pages;

import WebdriverLib.CommonActions;
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
    private String _linktextPathLocatorType = "linktext";
    private String _categoryLocatorValue = "#qa-megamenu-stay";
    private String _subCategoryLocatorValue = "1 nuit";
    private String _mainSearchLocatorValue = "form#search input[name=\"text\"]";

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
        return element.findElement(locatorType,locatorValue, _driver , false);
    }

    /**
     * Find Subcategoy element displayed on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return SubCategory to select
     */
    public WebElement eleGetSubCategory(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver , false);
    }

    /**
     * Find Main search element displayed on UI
     * @param locatorType Locator Type e.g id. Css
     * @param locatorValue locator value displayed on the UI
     * @return search box to select
     */
    public WebElement eleMainSearch(String locatorType, String locatorValue)
    {
        ElementFactory element = new ElementFactory();
        return element.findElement(locatorType,locatorValue, _driver ,true);
    }

    /**
     * Select Category & Subcategory provided by user
     * @param categoryName Category Name to be selected
     * @param subCategoryName SubCategoryName to be selected
     */
    public void selectCategoryAndSubCategory(String categoryName, String subCategoryName) throws InterruptedException
    {
        CommonActions mouseAction = new CommonActions(_driver);
        WebElement category = eleGetCategory(_cssLocatorType, _categoryLocatorValue);
        mouseAction.moveToElement(category);
        WebElement subCategory  = eleGetSubCategory(_linktextPathLocatorType,_subCategoryLocatorValue);
        subCategory.click();
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
        WebElement box = element.findElement("css","form#search strong", _driver ,true);
        box.click();
    }

    /**
     * Click on VIew Shopping cart
     */
    public void viewShoppingCart()
    {
        ElementFactory element = new ElementFactory();
        CommonActions click = new CommonActions(_driver);
        WebElement cart = element.findElement("css","section#header-dropdown-wrapper span.header-cart__title.header-cart__title--show-for-large", _driver, false );
        click.mouseClick(cart);
    }
}
