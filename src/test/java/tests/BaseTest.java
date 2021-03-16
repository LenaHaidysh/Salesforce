package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.ContactSteps;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ContactsPage contactsPage;
    HomePage homePage;
    LoginSteps loginSteps;
    ContactSteps contactSteps;
    AccountListPage accountListPage;
    ContactListPage contactListPage;


    @BeforeMethod(description = "Opening browser")
    public void setup(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        contactsPage = new ContactsPage(driver);
        homePage = new HomePage(driver);
        loginSteps = new LoginSteps(driver);
        contactSteps = new ContactSteps(driver);
        accountListPage = new AccountListPage(driver);
        contactListPage= new ContactListPage(driver);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
