package stepDefinitions;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginSteps {
    public WebDriver driver;
    public LoginPage loginPage;
    public ProductsPage productsPage;


    @Given("User launch Chrome browser for login")
    public void user_launch_chrome_browser_for_login() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Given("User opens URL {string} in login")
    public void user_opens_url_in_login(String url) {
        String urlValue = url;
        driver.get(urlValue);
    }

    @When("User enters Username as {string}")
    public void user_enters_username_as(String username) {
        String userValue = username;
        loginPage.setUsername(userValue);
    }

    @When("User enters Password as {string}")
    public void user_enters_password_as(String pass) {
        String passValue = pass;
        loginPage.setPassword(passValue);
    }

    @When("User clicks on LOGIN button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should be logged and first screen should appear")
    public void user_should_be_logged_and_first_screen_should_appear() {
        assertThat(productsPage.getProductBanner().isDisplayed(), is(true));
    }

    @Then("User won't be logged and warning will appear")
    public void user_won_t_be_logged_and_warning_will_appear() {
        assertThat(loginPage.getErrorMessage().isDisplayed(), is(true));
    }

    //Close browser for each scenario

    //@After("@Login")
    //public void closeBrowser(){
    //    driver.close();
    //}

}
