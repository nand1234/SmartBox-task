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
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ScenarioSteps {

    private WebDriver _driver;
    private BrowserFactory _browser;
    private MainMenu _menu;
    private ProductList _productList;
    private ProductDetails _productDetails;
    private CommomFactory _factory;
    private ShoppingCart _cart;


    @Before
    public void setup() throws InterruptedException
    {
        _browser = new BrowserFactory();
        _driver = _browser.launchBrowser();
        _menu = new MainMenu(_driver);
        _productList = new ProductList(_driver);
        _productDetails = new ProductDetails(_driver);
        _cart = new ShoppingCart(_driver);
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
        _menu.selectCategoryAndSubCategory("1 unit","1 unit");
    }

    @Then("^List of products displayed$")
    public void List_of_products_displayed() throws Throwable {
        _productList.checkSearchFilter();

    }

    @When("^Customer select the product$")
    public void Customer_select_the_product() throws Throwable {
        _productList.selectProduct("Week-end gourmand en amoureux");
    }

    @Then("^Selected Product Detail displayed$")
    public void Selected_Product_Detail_displayed() throws  Throwable {
        _productDetails.productTitleDisplay();

    }

    @When("^Customer add item to the Cart$")
    public void Customer_add_item_to_the_Cart() throws Throwable {
        _productDetails.addToBasket();
        _productDetails.viewCart();
        _menu.viewShoppingCart();
    }

    @Then("^Product display in the shopping cart$")
    public void Product_display_in_the_shopping_cart() throws Throwable {
        _menu.viewShoppingCart();
        _cart.checkItemAddedToCart();
    }

    @Then("^Customer can Remove the Item from the Cart$")
    public void Customer_can_Remove_the_Item_from_the_Cart() throws Throwable {
        _menu.viewShoppingCart();
        _cart.removeItemfromCart();
    }

    @Given("^Customer added item to cart$")
    public void Customer_added_item_to_cart() throws Throwable {
        _browser.navigateToURL(_driver);
        _factory.addItemToTheBasket("sejour", "1  nuit","Week-end gourmand en amoureux");
        _productDetails.continueShopping();
    }

    @Then("^Customer continue shopping by adding another item to the cart$")
    public void Customer_continue_shopping_by_adding_another_item_to_the_cart() throws Throwable {
        _productDetails.continueShopping();
        _factory.addItemToTheBasket("sejour", "1  nuit","Week-end gourmand en amoureux");
    }

    @Given("^Customer added item to (\\d+) items to cart$")
    public void Customer_added_item_to_items_to_cart(int arg1) throws Throwable {
        _browser.navigateToURL(_driver);
        _factory.addItemToTheBasket("sejour", "1  nuit","Week-end gourmand en amoureux");
        _productDetails.viewCart();
        _cart.adjustQty("6");

    }

    @Then("^Customer cannot do purchase$")
    public void Customer_cannot_do_purchase() throws Throwable {
        _menu.viewShoppingCart();
        _cart.checkOut();
        boolean status = _cart.verifyCheckout();
        if (status == true)
        {
            Assert.fail();
        }
    }

    @Given("^Customer on smart box landing page$")
    public void Customer_on_smart_box_landing_page() throws Throwable {
        _browser.navigateToURL(_driver);

    }

    @When("^Customer enters box name on the main search field$")
    public void Customer_enters_box_name_on_the_main_search_field() throws Throwable {
        _menu.searchBox("Week-End Gourmand En Amoureux");

    }

    @Then("^Suggestions are displayed as customer type$")
    public void Suggestions_are_displayed_as_customer_type() throws Throwable {
        _menu.selectBoxFromSuggestion();

    }

    @When("^Customer select category and sub category$")
    public void Customer_select_category_and_sub_category() throws Throwable {
        _menu.selectCategoryAndSubCategory("sejour", "1  nuit");

    }

    @Then("^filter options displays$")
    public void filter_options_displays() throws Throwable {
        _productList.checkSearchFilter();

    }

    @Then("^filter options displays on UI$")
    public void filter_options_display_on_UI() throws Throwable {
        _productList.checkSearchFilter();
    }

    @Then("^suggestions displays in filter box$")
    public void suggestions_displays_in_filter_box() throws Throwable {

        throw new PendingException("Auto Suggest functionality is not implemented for filter search box");
    }

    @Then("^Review link displays on a box$")
    public void Review_link_displays_on_a_box() throws Throwable {
       _productList.checkReviewLink();
    }
}

