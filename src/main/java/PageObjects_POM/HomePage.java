package PageObjects_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    // locators
    @FindBy(xpath = "//a[text()='Dashboard']")
    private WebElement dashboard_btn;
    @FindBy(linkText = "Sales")
    private WebElement Sales_tab;
    @FindBy(linkText = "Customers")
    private WebElement Customer_tab;
    @FindBy(linkText = "Purchase")
    private WebElement Purchase_tab;
    @FindBy(linkText = "Supplier")
    private WebElement Supplier_tab;
    @FindBy(linkText = "Stocks / Products")
    private WebElement Stock_tab;
    @FindBy(linkText = "Payments / Outstandings")
    private WebElement Payment_tab;
    @FindBy(linkText = "Reports")
    private WebElement Reports_tab;
    @FindBy(xpath = "//a[normalize-space()='Show Shortcuts']")
    private WebElement Shortcuts;
    @FindBy(xpath="//a[@class='round button dark menu-user image-left']")
    private WebElement LoggedAs;
    @FindBy(css = "a[href='change_password.php']")
    private WebElement Change_pwd;
    @FindBy(css = "a[href='logout.php']")
    private WebElement logout;
    @FindBy(xpath="//a[normalize-space()='Update Store Details']")
    private WebElement Update_Store_Details;
    @FindBy(xpath="//a[@class='round button dark menu-logoff image-left']")
    private WebElement logoff;
    @FindBy(id="search-keyword")
    private WebElement Search_opt;
    @FindBy(xpath="//img[@alt='Point of Sale']")
    private WebElement logo;
    @FindBy(xpath = "//div[@id='top-bar']")
    private WebElement topmenu;
    @FindBy(xpath = "//div[@class='side-menu fl']//ul")
    private WebElement sidemenu;
    @FindBy(xpath="//div[@class='side-menu fl']//a")
    private List<WebElement> menulinks;
    @FindBy(xpath="//a[normalize-space()='Add Sales']")
    private WebElement addsales;
    @FindBy(xpath="//a[normalize-space()='Add Purchase']")
    private WebElement addPurchase;
    @FindBy(xpath="//a[normalize-space()='Add Supplier']")
    private WebElement addSupplier;
    @FindBy(xpath="//a[normalize-space()='Add Customer']")
    private WebElement addCustomer;
    @FindBy(xpath="//a[normalize-space()='Report']")
    private WebElement Reportlink;
    @FindBy(xpath = "//span[@class='fr expand-collapse-text']")
    private WebElement collapseopt;


    public boolean isLogoVisible() {
        return isElementDisplayed(logo);
    }
    public boolean isNavigationMenuVisible() {
        return isElementDisplayed(topmenu);
    }
    public boolean isSidebarVisible() {
        return isElementDisplayed(sidemenu);
    }

    public boolean isLogoutButtonVisible() {
        return isElementDisplayed(logoff);
    }
    public String getTextOfElement()
    {
        String temp = getText(LoggedAs);
        return temp;
    }
    public void clickOnLogout()
    {
        clickElement(logoff);
    }
    public void clickOnReport()
    {
        clickElement(Reports_tab);
    }

    public void clickOnSettings() {
        clickElement(Update_Store_Details);
    }
}
