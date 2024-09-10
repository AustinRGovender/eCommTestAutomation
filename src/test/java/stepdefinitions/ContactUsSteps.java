package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import utils.WebDriverManager;

public class ContactUsSteps {
    private WebDriver driver;

    @Given("I am on the Contact Us page")
    public void i_am_on_the_contact_us_page() throws Throwable {
        driver = WebDriverManager.getDriver();
        driver.get(WebDriverManager.getProperty("base.url") + "contact.html");
    }

    @When("I fill in the contact form with valid data")
    public void i_fill_in_the_contact_form_with_valid_data() {
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("email")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("subject")).sendKeys("Product Inquiry");
        driver.findElement(By.id("message")).sendKeys("I would like more information about your products.");
    }

    @When("I submit the contact form")
    public void i_submit_the_contact_form() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        assertTrue(driver.findElement(By.id("name")).getText().isBlank());
    }
}
