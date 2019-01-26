package stepDefinition;

import Lib.BrowserFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddToCartSteps {

    @Given("^I am officiating a FizzBuzz game$")
    public void I_am_officiating_a_FizzBuzz_game() throws Throwable {
        BrowserFactory browser = new BrowserFactory();
         WebDriver driver= browser.GetBrowser();
         driver.get(System.getProperty("TestURL"));
        // Express the Regexp above with the code you wish you had
    }

    @When("^the number (\\d+) is played$")
    public void the_number_is_played(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
    }
}

