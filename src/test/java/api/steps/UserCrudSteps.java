package api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class UserCrudSteps {

    private static String userId;

    @When("I create a new user")
    public void createUser() {

        String body = """
            {
              "firstName": "QA",
              "lastName": "Automation",
              "email": "qa_automation_%d@test.com"
            }
            """.formatted(System.currentTimeMillis());

        CommonApiSteps.response =
                given()
                    .header("app-id", "63a804408eb0cb069b57e43a")
                    .header("Content-Type", "application/json")
                    .body(body)
                .when()
                    .post("/user/create");

        CommonApiSteps.response.then().log().body();

        JsonPath json = CommonApiSteps.response.jsonPath();
        userId = json.getString("id");
    }

    @Then("user id should be returned")
    public void userIdShouldBeReturned() {
        assertNotNull("User ID should not be null", userId);
    }

    @When("I update the user first name to {string}")
    public void updateUser(String newName) {

        String body = """
            {
              "firstName": "%s"
            }
            """.formatted(newName);

        CommonApiSteps.response =
                given()
                    .header("app-id", "63a804408eb0cb069b57e43a")
                    .header("Content-Type", "application/json")
                    .body(body)
                .when()
                    .put("/user/" + userId);

        CommonApiSteps.response.then().log().body();
    }

    @When("I delete the user")
    public void deleteUser() {

        CommonApiSteps.response =
                given()
                    .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                    .delete("/user/" + userId);

        CommonApiSteps.response.then().log().body();
    }
}
