package PageObjects_POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }
    public String getCurrentPageName() {
        return driver.getTitle();
    }
    public String getCurrenturllink() {
        String url= driver.getCurrentUrl();
        return url;
    }

    // Navigate to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Enter text into a field
    public void enterText(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    // Click on an element
    public void clickElement(WebElement element) {
        waitUntilClickable(element);
        element.click();
    }

    // Get text from an element
    public String getText(WebElement element) {
        waitUntilVisible(element);
        return element.getText();
    }

    // Check if an element is displayed
    public boolean isElementDisplayed(WebElement element) {
        try {
            if (element == null) {
                throw new NullPointerException("The WebElement is null. Ensure it is initialized properly.");
            }
            wait.until(ExpectedConditions.visibilityOf(element)); // Wait until visible
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace(); // Log exception for debugging
            return false;
        }
    }

    // Wait until an element is visible
    private void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isErrorMessageDisplayed(WebElement element)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Use the element to ensure it exists
        try {
          return  element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element is not visible within the provided implicit wait time.");
        }
        return false;
    }

    // Wait until an element is clickable
    private void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Verify if an attribute matches the expected value
    public boolean verifyAttribute(WebElement element, String attribute, String expectedValue) {
        return element.getAttribute(attribute).equals(expectedValue);
    }
}
