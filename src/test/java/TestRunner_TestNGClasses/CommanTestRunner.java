package TestRunner_TestNGClasses;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/java/FeatureFiles",
        glue = {"StepDefinitions_Testcases","Hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/CommonTestRunner.html"},
        monochrome = true //,
        //tags = "@SmokeTest"
)


public class CommanTestRunner extends AbstractTestNGCucumberTests {
}
