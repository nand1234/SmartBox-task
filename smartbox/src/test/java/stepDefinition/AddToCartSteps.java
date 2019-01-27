package stepDefinition;

import PageFactory.CommomFactory;
import Pages.MainMenu;
import Pages.ProductDetails;
import Pages.ProductList;
import Pages.ShoppingCart;
import WebdriverLib.BrowserFactory;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddToCartSteps {

    private WebDriver _driver;
    private BrowserFactory _browser;
    private MainMenu _menu;
    private ProductList _productList;
    private ProductDetails _productDetails;
    private CommomFactory _factory;
    private ShoppingCart _cart;


    @Before
    public void setup()
    {
        _browser = new BrowserFactory();
        _driver = _browser.launchBrowser();
        _menu = new MainMenu(_driver);
        _productList = new ProductList(_driver);
        _productDetails = new ProductDetails(_driver);
        _factory = new CommomFactory(_driver);
    }

    @After
    public void quitBrowser()
    {
        _driver.quit();
    }

    @Given("^Customer on smart Box Landing page$")
    public void Customer_on_smart_Box_Landing_page() throws Throwable {
        _browser.navigateToURL(_driver);
    }

    @When("^Customer select category and Subcategory$")
    public void Customer_select_category_and_Subcategory() throws Throwable {
        _menu.selectCategoryAndSubCategory("sejour", "1  nuit");
    }

    @Then("^List of products displayed$")
    public void List_of_products_displayed() throws Throwable {

    }

    @When("^Customer select the product$")
    public void Customer_select_the_product() throws Throwable {
        _productList.selectProduct("Week-end gourmand en amoureux");
    }

    @Then("^Selected Product Detail displayed$")
    public void Selected_Product_Detail_displayed() throws  Throwable {

    }

    @When("^Customer add item to the Cart$")
    public void Customer_add_item_to_the_Cart() throws Throwable {

        _productDetails.addToBasket();
    }

    @Then("^Product display in the shopping cart$")
    public void Product_display_in_the_shopping_cart() throws Throwable {
        _productDetails.viewCart();

    }

    @Then("^Customer can Remove the Item from the Cart$")
    public void Customer_can_Remove_the_Item_from_the_Cart() throws Throwable {
        _cart.removeitemfromCart();
    }

    @Given("^Customer added item to cart$")
    public void Customer_added_item_to_cart() throws Throwable {
        _browser.navigateToURL(_driver);
        _factory.addItemToTheBasket("sejour", "1  nuit","Week-end gourmand en amoureux");

    }

    @Then("^Customer continue shopping by adding another item to the cart$")
    public void Customer_continue_shopping_by_adding_another_item_to_the_cart() throws Throwable {
        _factory.addItemToTheBasket("sejour", "1  nuit","Week-end gourmand en amoureux");
        _productDetails.continueShopping();
        _factory.addItemToTheBasket("sejour", "1  nuit","Week-end gourmand en amoureux");
    }

    @Given("^Customer added item to (\\d+) items to cart$")
    public void Customer_added_item_to_items_to_cart(int arg1) throws Throwable {
        _browser.navigateToURL(_driver);
        _factory.addItemToTheBasket("sejour", "1  nuit","Week-end gourmand en amoureux");
        _productDetails.viewCart();

    }

    @Then("^Customer cannot do purchase$")
    public void Customer_cannot_do_purchase() throws Throwable {
        _cart.checkOut();
    }
}

