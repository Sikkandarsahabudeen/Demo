package Definitions;

import Base.baseTest;
import Pages.logIN;
import Pages.productPage;
import Pages.resulPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
@Test
public class SubmitOrderDefinition extends baseTest {
    logIN Log;
    productPage pp;
    resulPage rP;
    @Given("User landed on login page")
    public void landing_page(){
        Log=initializeDriver();
    }

    @Given("User has logged in the ecommerce website with {string} {string}")
    public void user_has_logged_in_the_ecommerce_website_with(String username, String password) {
        pp = Log.logged(username, password);
    }

    @When("I ordered the product {string}")
    public void i_ordered_the_product(String product) {
        List<WebElement> prod = pp.getPro();
        rP = pp.findProduct(prod, product);
    }

    @When("Check out the submit order {string}")
    public void check_out_the_submit_order(String product) {
        Boolean isThere = rP.getHeaders(product);
        Assert.assertTrue(isThere);
    }

    @Then("Ensure the ordered messages {string}")
    public void ensure_the_ordered_messages(String message) {
        String cnfMessage = rP.finalresult();
        Assert.assertTrue(cnfMessage.equalsIgnoreCase(message));
        driver.close();
    }

}
