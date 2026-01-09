package api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static org.junit.Assert.assertEquals;

public class CommonApiSteps {

    public static Response response;

    @Given("API is ready")
    public void apiIsReady() {
        baseURI = "https://dummyapi.io/data/v1";
    }

    @Then("response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }
}
