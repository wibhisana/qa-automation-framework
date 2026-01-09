package web.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import web.pages.LoginPage;

public class LoginSteps {

    ChromeDriver driver;
    LoginPage loginPage;

    @Given("user open login page")
    public void openLoginPage() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("user login with valid credential")
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("user should see home page")
    public void verifyHomePage() {
        driver.quit();
    }
}
