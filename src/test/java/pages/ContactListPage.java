package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage {

    public static final By NEW_BUTTON = By.cssSelector("[title=New]");
    public static final By CLASS = By.className("slds-cell-fixed");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening contact list")
    public void openContactsPage() {
        driver.get("https://coherentsolutionsinc.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
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
}
