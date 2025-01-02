package StepDefinitions_Testcases;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjects_POM.LoginPage;
import Utilities.DriverManager;

import java.util.Objects;


public class LoginPageSteps {



    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        // Initialize the WebDriver and other configurations
        DriverManager.initializeDriver(); // Ensure DriverManager handles WebDriver creation
        driver = DriverManager.getDriver(); // Get the driver instance from DriverManager
        loginPage = new LoginPage(driver);  // Initialize LoginPage with the driver
    }

    @After
    public void tearDown() {
        // Quit the driver after tests are done
        DriverManager.quitDriver();
    }



    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.openLoginPage("https://stock.scriptinglogic.in/");
        DriverManager.maximizeWindow();
    }

    @When("I enter {string} and {string}")
    public void iEnterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }



    @Then("I should see the username field")
    public void iShouldSeeTheUsernameField() {
        Assert.assertTrue(loginPage.isUsernameFieldVisible(), "Username field not displayed");
    }

    @Then("I should see the password field")
    public void iShouldSeeThePasswordField() {
        Assert.assertTrue(loginPage.isPasswordFieldVisible(), "Password field not displayed");
    }

    @Then("I should see the login button")
    public void iShouldSeeTheLoginButton() {
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button not displayed");
    }

    @Then("the password field should be masked")
    public void thePasswordFieldShouldBeMasked() {
        Assert.assertTrue(loginPage.isPasswordFieldMasked(), "Password field is not masked");
    }
    @When("I enter {string} into the password field")
    public void iEnterIntoThePasswordField(String password) {
        loginPage.enterPassword(password);
    }
//    @Then("I should be redirected to the {String} Page")
//    public void iVerifyTheCurrentPageTitleIs(String expectedTitle) {
//        String actualTitle = loginPage.getCurrentPageName();
//        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
//    }
    @Then("I should see {string}")
    public void iShouldSee(String expectedResult) {
        String actualResult = loginPage.getErrorMessage();
        Assert.assertEquals(actualResult, expectedResult, "Validation message mismatch!");
    }

    @Then("I should be redirected to the {string} Page or I should see {string}")
    public void iShouldBeRedirectedToThePageOrIShouldSee(String expectedTitle, String expectedMessage) {
        String actualTitle = loginPage.getCurrentPageName(); // Get the current page title
        if (actualTitle.contains("Dashboard")) {
            Assert.assertEquals(
                    actualTitle,expectedTitle,"title not match");
        }
        else
        {
            String actualMessage = loginPage.getErrorMessage();  // Get the error message
            // Assert that either the user is on the expected page or the expected error message is displayed
            Assert.assertTrue(
                    actualTitle.equals(expectedTitle) || actualMessage.equalsIgnoreCase(expectedMessage),
                    String.format("Neither redirected to '%s' nor displayed the error message '%s'. Actual title: '%s', Actual message: '%s'.",
                            expectedTitle, expectedMessage, actualTitle, actualMessage)
            );
        }

    }
}
