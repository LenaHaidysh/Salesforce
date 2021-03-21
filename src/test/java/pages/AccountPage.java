package pages;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AccountPage extends BasePage {

    public static final By NEW_BUTTON = By.cssSelector("[title=New]");
    public static final By CLASS = By.className("slds-cell-fixed");
    public static final By SAVE_BUTTON = By.cssSelector("[title=Save]");
    public static final By EDIT_BUTTON = By.cssSelector("[name=Edit]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening account list")
    public void openAccountPage() {
        driver.get("https://coherentsolutionsinc.lightning.force.com/lightning/o/Account/list?filterName=Recent");
    }

    @Step("Click 'New'")
    public void clickNew() {
        driver.findElement(NEW_BUTTON).click();
    }

    public boolean isPageOpened() {
        try {
            driver.findElement(CLASS);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Step("Creating account") //то, что в фигурных скобках - это перееменные
    public void create(Account account) {
        new Input(driver, "Account Name").writeForAccount(account.getAccountName1());
        new Input(driver, "Parent Account").click();
        new Input(driver, "Phone").writeForAccount(account.getPhone());
        new Input(driver, "Website").writeForAccount("www.abc.ru");
        new Input(driver, "Billing City").writeForAccount("Minsk");
        new Input(driver, "Shipping City").writeForAccount("Minsk");
    }

    @Step("Click Save")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void isModalOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница с модалкой не была загружена");
        }
    }

    public void isModalClosed() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(EDIT_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница с модалкой не была закрыта");
        }
    }
}
