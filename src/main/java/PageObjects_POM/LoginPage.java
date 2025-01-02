package PageObjects_POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        //try

    }

    // Locators
    @FindBy(id = "login-username")
    private WebElement usernameField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(name = "submit")
    private WebElement loginButton;

    @FindBy(css = ".error-box.round")
    private WebElement errorMessage;

    @FindBy(xpath = "//label[@for='login-username' and @class='error']")
    private WebElement usernameError;

    @FindBy(xpath = "//label[@for='login-password' and @class='error']")
    private WebElement passwordError;

    // Methods


    public void openLoginPage(String url) {
        navigateTo(url);
    }

    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public String getErrorMessage() {
        if (isErrorMessageDisplayed(errorMessage)) {
            return getText(errorMessage);
        }
         if (isErrorMessageDisplayed(usernameError))
        {
            return getText(usernameError);
        }
         if (isErrorMessageDisplayed(passwordError))
        {
            return getText(passwordError);
        }
        return null;
    }
    public String getCurrentPage() {
        return getCurrentPageName();
    }

    public boolean isUsernameFieldVisible() {
        return isElementDisplayed(usernameField);
    }

    public boolean isPasswordFieldVisible() {
        return isElementDisplayed(passwordField);
    }

    public boolean isLoginButtonVisible() {
        return isElementDisplayed(loginButton);
    }

    public boolean isPasswordFieldMasked() {
        return verifyAttribute(passwordField, "type", "password");
    }
}
