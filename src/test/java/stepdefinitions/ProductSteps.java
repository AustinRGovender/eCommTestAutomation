package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import utils.WebDriverManager;

public class ProductSteps {
    private WebDriver driver;

    @Given("I am on the Products page")
    public void i_am_on_the_products_page() throws Throwable {
        driver = WebDriverManager.getDriver();
        driver.get(WebDriverManager.getProperty("base.url") + "products.html");
    }

    @When("I click on a product")
    public void i_click_on_a_product() {
        driver.findElement(By.cssSelector(".product-item")).click();
    }

    @Then("I should see a product details modal")
    public void i_should_see_a_product_details_modal() {
        assertTrue(driver.findElement(By.cssSelector(".modal")).isDisplayed());
    }
}
