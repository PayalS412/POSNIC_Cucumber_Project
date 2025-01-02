package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

public class DriverManager {
    private static WebDriver driver;

    public static void initializeDriver() {
        if (driver == null) {
            // Selenium Manager handles downloading and setting up the correct driver
            driver = new ChromeDriver(getChromeOptions());

        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
       // driver.get(url);
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public static void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        return options;
    }
}


