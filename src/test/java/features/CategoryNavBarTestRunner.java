package features;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\java\\features\\CategoryNavBar.feature",
    glue = "StepDefinitions",
    monochrome = true,
    plugin = {"html:target\\cucumber.html"}
)
public class CategoryNavBarTestRunner extends AbstractTestNGCucumberTests {
}