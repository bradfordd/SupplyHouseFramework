package features;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\java\\features\\SearchForItem.feature",
    glue = "StepDefinitions",
    monochrome = true,
    plugin = {"html:target\\cucumber.html"}
)
public class SearchForItemTestRunner extends AbstractTestNGCucumberTests {
}
