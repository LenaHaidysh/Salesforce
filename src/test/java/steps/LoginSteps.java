package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    //login
    @Step("Login by user {user}") //названия шагов для аллюра
    public void login(String user, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login(user, password);
        assertTrue(new HomePage(driver).isPageOpened1(), "Home page was not opened");
    }
}
