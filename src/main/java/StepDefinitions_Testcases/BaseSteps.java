package StepDefinitions_Testcases;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import Utilities.DriverManager;

public class BaseSteps {

    @Before
    public void setUp() {
        DriverManager.initializeDriver();

       // DriverManager.maximizeWindow();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

