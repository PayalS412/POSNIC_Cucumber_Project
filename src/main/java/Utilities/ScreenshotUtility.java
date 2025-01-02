package Utilities;


import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {
    public static String captureScreenshot(WebDriver driver, String fileName, Scenario scenario) {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "screenshots/" + fileName + ".png";
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

        try {
            FileUtils.copyFile(srcFile, new File(filePath));
            scenario.attach(screenshot, "image/png", "Failure Screenshot"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}

