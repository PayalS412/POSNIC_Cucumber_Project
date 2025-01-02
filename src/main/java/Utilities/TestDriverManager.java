package Utilities;


import org.openqa.selenium.WebDriver;

public class TestDriverManager {
    public static void main(String[] args) {
          WebDriver driver;
        DriverManager.initializeDriver();
        driver=DriverManager.getDriver();


      //  DriverManager.initializeDriver(); // Initialize the driver
      //  WebDriver driver = DriverManager.getDriver();
       // driver.manage().window().maximize();

        driver.get("https://google.com"); // Open Google
        System.out.println("Page title: " + driver.getTitle()); // Print page title

        DriverManager.quitDriver(); // Quit the driver
    }
}