package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {"api"},
        plugin = {
                "pretty",
                "html:reports/api/cucumber.html",
                "json:reports/api/cucumber.json"
        }
)
public class ApiTestRunner {
}
