package clickUpApi.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/report.xml"
        },
        features = {"src/test/resources/Features"},
        glue = {"clickUpApi/stepDefinitions"}
)

public class TestRunner {
}
