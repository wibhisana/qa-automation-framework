package api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserSteps {

    private Response response;

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

    @Then("response body should contain valid user data")
    public void validateResponseBody() {
        response.then()
                .body("id", notNullValue())
                .body("firstName", notNullValue())
                .body("lastName", notNullValue())
                .body("email", containsString("@"))
                .body("picture", notNullValue());
    }

    @Then("response schema should be valid")
    public void validateSchema() {
        response.then()
                .body(
                        JsonSchemaValidator
                                .matchesJsonSchemaInClasspath("schema/user-schema.json")
                );
    }
}
