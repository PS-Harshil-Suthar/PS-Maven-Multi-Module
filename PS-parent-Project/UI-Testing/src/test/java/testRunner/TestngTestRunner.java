package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = ".//features/",
//    tags = "@LoginPage",
    glue = {"stepDefinitions", "hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "junit:target/cucumber-results.xml",
        "utilities.ExtentReportListener"
    }
)
public class TestngTestRunner extends AbstractTestNGCucumberTests {
}
