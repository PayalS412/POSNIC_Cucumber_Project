package Hooks;

import Utilities.DriverManager;
import Utilities.ScreenshotUtility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Hooks {

    private WebDriver driver = DriverManager.getDriver();


    @AfterStep
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture screenshot on failure
//            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            LocalDateTime currentDateTime = LocalDateTime.now();
            // Format the date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String formattedDateTime = currentDateTime.format(formatter);
            String filename= scenario.getName().substring(0,15).replaceAll(" ", "_") +"_"+formattedDateTime;
            // Alternatively, save the screenshot file and attach the path
            String filePath = ScreenshotUtility.captureScreenshot(driver, filename,scenario);
            System.out.println("Screenshot saved at: " + filePath);

        }
    }
}
