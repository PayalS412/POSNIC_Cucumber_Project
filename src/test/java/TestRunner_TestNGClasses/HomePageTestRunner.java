package TestRunner_TestNGClasses;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/java/FeatureFiles/HomePage.feature",
        glue = "StepDefinitions_Testcases",
        plugin = {"pretty", "html:target/cucumber-reports/HomePageTestRunner.html"},
        monochrome = true,
        tags = "@SmokeTest or @UI or @EdgeCase or @Security"
)

public class HomePageTestRunner extends AbstractTestNGCucumberTests {
}
