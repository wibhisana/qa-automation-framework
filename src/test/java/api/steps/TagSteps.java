package api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;

public class TagSteps {

    @When("I send request to get list of tags")
    public void getListOfTags() {

        CommonApiSteps.response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                .get("/tag");

        CommonApiSteps.response.then().log().body();
    }

    @Then("response should contain list of tags")
    public void validateTags() {
        List<String> tags =
                CommonApiSteps.response.jsonPath().getList("data");

        assertFalse("Tag list should not be empty", tags.isEmpty());
    }
}
