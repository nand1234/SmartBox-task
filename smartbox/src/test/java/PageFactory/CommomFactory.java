package PageFactory;

import Pages.MainMenu;
import Pages.ProductDetails;
import Pages.ProductList;
import org.openqa.selenium.WebDriver;

public class CommomFactory {

    WebDriver Driver;

    /**
     *     Constructor to store driver instance for reuse
     * @param driver WebDriver
     */
    public CommomFactory(WebDriver driver)
    {
        Driver = driver;
    }

    /**
     * Helper method to add item to the Shopping cart
     * @param categoryName category Name to be selected
     * @param categoryValue subcategory to be selected
     * @param itemName Box/Item to be selected
     * @throws InterruptedException
     */
    public void addItemToTheBasket(String categoryName, String categoryValue, String itemName) throws InterruptedException
    {
        MainMenu menu = new MainMenu(Driver);
        ProductList list = new ProductList(Driver);
        ProductDetails details = new ProductDetails(Driver);
        menu.selectCategoryAndSubCategory(categoryName, categoryValue);
        list.selectProduct(itemName);
        details.addToBasket();
    }
}
