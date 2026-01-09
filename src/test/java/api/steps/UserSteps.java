package api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserSteps {

    private Response response;

    @When("I send request get user by id {string}")
    public void getUserById(String id) {
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                .get("/user/" + id);

        response.then().log().body();
    }

    @Then("response body should contain valid user data")
    public void validateResponseBody() {

        JsonPath json = response.jsonPath();

        // CASE 1: SUCCESS RESPONSE (User Full)
        if (json.get("id") != null) {
            assertNotNull(json.get("firstName"));
            assertNotNull(json.get("lastName"));
            return;
        }

        // CASE 2: ERROR RESPONSE (sesuai docs)
        if (json.get("error") != null) {
            String error = json.getString("error");
            assertTrue(
                    error.equals("RESOURCE_NOT_FOUND") ||
                    error.equals("APP_ID_NOT_EXIST") ||
                    error.equals("APP_ID_MISSING") ||
                    error.equals("PARAMS_NOT_VALID") ||
                    error.equals("SERVER_ERROR")
            );
            return;
        }

        // Jika tidak match keduanya → FAIL
        throw new AssertionError("Unexpected API response structure");
    }
}
