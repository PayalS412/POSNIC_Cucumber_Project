package StepDefinitions_Testcases;


import PageObjects_POM.HomePage;
import PageObjects_POM.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Priority;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utilities.DriverManager;
import org.testng.annotations.Test;

public class HomePageSteps {

    WebDriver driver;
    LoginPage loginPage;
    HomePage dashboardPage;
    String Context;

    @Before
    public void setUp() {
        // Initialize WebDriver and other configurations
        DriverManager.initializeDriver();  // Ensure DriverManager handles WebDriver creation
        driver = DriverManager.getDriver(); // Get the driver instance from DriverManager
        loginPage = new LoginPage(driver);  // Initialize LoginPage with the driver
     //   dashboardPage = new HomePage(driver);  // Initialize DashboardPage with the driver
    }

    @After
    public void tearDown() {
        // Quit the driver after tests are done
        DriverManager.quitDriver();
    }

    // Validate that the dashboard page is accessible

    @Given("I am logged in as {string} and Entered the {string} and on the dashboard page")
    public void iAmLoggedInAsAndEnteredTheAndOnTheDashboardPage(String un, String pwd) {
        loginPage.openLoginPage("https://stock.scriptinglogic.in/");
        loginPage.enterUsername(un);
        loginPage.enterPassword(pwd);
        loginPage.clickLoginButton();
        this.Context=un;
        dashboardPage= new HomePage(driver);  // Open the dashboard page after login
    }

    // Validate UI elements on the dashboard
    @Then("I should see the logo")
    public void iShouldSeeTheLogo() {
        Assert.assertTrue(dashboardPage.isLogoVisible(), "Logo is not visible on the dashboard");
    }

    @Then("I should see the navigation menu")
    public void iShouldSeeTheNavigationMenu() {
        Assert.assertTrue(dashboardPage.isNavigationMenuVisible(), "Navigation menu is not visible");
    }
    @Then("I should see the sidebar")
    public void iShouldSeeTheSidebar() {
        Assert.assertTrue(dashboardPage.isSidebarVisible(), "Sidebar is not visible");
    }

    @Then("I should see the logout button")
    public void iShouldSeeTheLogoutButton() {
        Assert.assertTrue(dashboardPage.isLogoutButtonVisible(), "Logout button is not visible");
    }

    @Then("I should be redirected to the dashboard page")
    public void iShouldBeRedirectedToTheDashboardPage() {
        String name= dashboardPage.getCurrentPageName();
        //System.out.println(name);
        Assert.assertTrue(name.contains("Dashboard"),"Not on Dashboard Page");
    }

    @Then("I should get {string}")
    public void iShouldGet(String Expectedstr) {
        String actualResult = dashboardPage.getTextOfElement();
        //System.out.println(actualResult);
        //System.out.println(Expectedstr);

        String expectedMessage = Expectedstr.replace("<username>", this.Context);
        //System.out.println(expectedMessage);
        Assert.assertEquals(actualResult, expectedMessage, "Validation message mismatch!");
    }


    @When("I click on the {string} button")
    public void iClickOnTheButton(String arg0) {
        dashboardPage.clickOnLogout();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
      String pageName =dashboardPage.getCurrentPageName();
      Assert.assertTrue(pageName.contains("Login"),"Not on Login Page");

    }


    @When("I click on the Reports link")
    public void iClickOnTheReportsLink() {
        dashboardPage.clickOnReport();
    }


    @Then("I should be redirected to the Reports page")
    public void iShouldBeRedirectedToTheReportsPage() {
        String pageName =dashboardPage.getCurrentPageName();
        Assert.assertTrue(pageName.contains("Report"),"Not on Report Page");
    }


    @When("I click on the Settings link")
    public void iClickOnTheSettingsLink() {
        dashboardPage.clickOnSettings();
    }


    @Then("I should be redirected to the Settings page that is {string}")
    public void iShouldBeRedirectedToTheSettingsPageThatIs(String actualresult) {
        String urllink=  dashboardPage.getCurrenturllink();
        Assert.assertEquals(actualresult,urllink,"Not matching the url");
    }
}
