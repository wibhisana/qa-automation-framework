package web.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    @When("user login with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should see product page")
    public void verifyHomePage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInventoryDisplayed());
        tearDown();
    }

    @Then("error message {string} should be displayed")
    public void verifyErrorMessage(String message) {
        String errorText =
            driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

        Assert.assertEquals(message, errorText);
        tearDown();
    }

    @Then("product images should be incorrect")
    public void verifyBrokenImages() {
        boolean isBroken =
            driver.findElements(By.cssSelector(".inventory_item_img img"))
                  .stream()
                  .anyMatch(img ->
                      img.getAttribute("src").contains("sl-404"));

        Assert.assertTrue(isBroken);
        tearDown();
    }
}
