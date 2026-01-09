package web.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import web.base.BaseTest;
import web.pages.HomePage;
import web.pages.LoginPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Given("user open login page")
    public void openLoginPage() {
        setup();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("user login with valid credential")
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("user should see home page")
    public void verifyHomePage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInventoryDisplayed());
        tearDown();
    }
}
