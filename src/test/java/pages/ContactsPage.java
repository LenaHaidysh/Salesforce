package pages;

import io.qameta.allure.Step;
import models.Contact;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {


    public ContactsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Opening contactsPage")
    public void openContactsPage() {
        driver.get("https://coherentsolutionsinc.lightning.force.com/lightning/" +
                "o/Contact/new?count=1&nooverride=1&useRecordTypeCheck=" +
                "1&navigationLocation=MRU_LIST&backgroundContext=%2Flightning%2Fo%2FContact%2Flist%3FfilterName%3DRecent");
    }

    @Step("Creating contact {contact.lastName}") //то, что в фигурных скобках - это перееменные, которые будут записаны в отчет в аллюр
    public void create(Contact contact) {
        new Input(driver, "Last Name").write(contact.getLastName());
        new LookUp(driver, "Account Name").select(contact.getAccountName());
        new DropDown(driver, "Mr.").choose();
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Middle Name").write("El");
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

    public void validateDetails(Contact contact) {
    }
}

////*[contains(text(),'Account Name')]/ancestor::lightning-lookup//input
////*[contains(text(),'Last Name')]/ancestor::lightning-input//input