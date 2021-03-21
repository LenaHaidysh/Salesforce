package pages;

import io.qameta.allure.Step;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class NewContactModal extends BasePage {

    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']"); //By.cssSelector("[name=SaveEdit]");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Step("Creating contact {contact.lastName}") //то, что в фигурных скобках - это перееменные
    public void create(Contact contact) {
        new Input(driver, "Last Name").write(contact.getLastName());
        new LookUp(driver, "Account Name").select(contact.getAccountName());
        new DropDown(driver, "Mr.").choose();
        new Input(driver, "First Name").write(contact.getFirstName());
        //new Input(driver, "Middle Name").write("El");
        new Input(driver, "Title").write("Group");
        new Input(driver, "Department").write("QA");
        new Input(driver, "Email").write("aromantikova@mail.ru");
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Mailing City").write("Minsk");
        new Input(driver, "Mailing Zip/Postal Code").write("221100");
        new Input(driver, "Mailing State/Province").write("Oregon");
        new Input(driver, "Mailing Country").write("USA");
        new TextArea(driver, "Mailing Street").writeForArea("Wall street");
    }

    @Step("Click Save")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void isPageOpened1() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(SAVE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница с модальным окном не была загружена");
        }
    }
}
