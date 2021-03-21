package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import models.Account;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AccountTest extends BaseTest {

    @Test//(retryAnalyzer = Retry.class) //чтобы запустить несколько раз тест, если тест падает
    @Link("https://instagram.com/dmitryrak11")
    @Issue("COVID-19")
    @TmsLink("123")
    @Attachment(value = "screenshot", type = "image/png")

    public void createAccount() {
        loginSteps.login("aromantikova-uhgn@force.com", "aroma9091");
        Account account = new Account("Hello222", "123", "www.abc.ru", "Minsk", "Minsk");
        accountPage.openAccountPage();
        accountPage.isPageOpened();
        accountPage.clickNew();
        accountPage.isModalOpened();
        accountPage.create(account);
        accountPage.save();
        accountPage.isModalClosed();
        accountPage.openAccountPage();
        accountPage.isPageOpened();
        //WebElement accountPresent = driver.findElement(By.xpath("//*[text()='" + account.getAccountName1() + "']"));
        WebElement accountPresent2 = driver.findElement(By.cssSelector("[title="+account.getAccountName1()+"]"));
        String actualResult = accountPresent2.getText();
        assertEquals(actualResult, String.format(account.getAccountName1()), "контакт не найден");
    }
}
