package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountListPage extends BasePage {

    public static final By NEW_BUTTON = By.cssSelector("[title=New]");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }


    @Step("Opening AccountPage")
    public void openAccountPage() {
        driver.get("https://coherentsolutionsinc.lightning.force.com/lightning/o/Account/list?filterName=Recent");
    }

    @Step("Creating account {accountName}")
    //то, что в фигурных скобках - это перееменные, которые будут записаны в отчет в аллюр
    public void create(String accountName) {
        new Input(driver, "Account Name").write("Account Name 1");
    }

    @Step("Click 'New'")
    public void clickNew() {
        driver.findElement(NEW_BUTTON).click();
    }
}
