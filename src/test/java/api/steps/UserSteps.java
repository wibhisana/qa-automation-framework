package api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserSteps {

    Response response;

    @Given("API is ready")
    public void apiIsReady() {
        baseURI = "https://dummyapi.io/data/v1";
    }

    @When("I send request get user by id {string}")
    public void getUserById(String id) {
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                .get("/user/" + id);
    }

    @Then("response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }
}
