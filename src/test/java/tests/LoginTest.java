package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginWithValidData() {
        loginPage.openLoginPage();
        loginPage.login("", "");
        //homePage.isPageOpened();
        //WebElement HomeTitle = driver.findElement(By.cssSelector("[title=Sales]"));
        //String actualResult = HomeTitle.getText();
        //assertEquals(actualResult, "Sales", "Логин прошел неуспешно");
    }
}
