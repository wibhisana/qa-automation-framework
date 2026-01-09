package api.steps;

import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class UserSteps {

    @When("I request user by id {string}")
    public void getUserById(String id) {

        CommonApiSteps.response =
                given()
                        .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                        .get("/user/" + id);

        CommonApiSteps.response.then().log().body();

        JsonPath json = CommonApiSteps.response.jsonPath();

        if (json.get("id") != null) {
            return;
        }
    }
}
