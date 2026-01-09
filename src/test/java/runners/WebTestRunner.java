package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = {"web"},
        plugin = {
                "pretty",
                "html:reports/web/cucumber.html",
                "json:reports/web/cucumber.json"
        }
)
public class WebTestRunner {
}
