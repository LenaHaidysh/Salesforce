package steps;

import models.Contact;
import org.openqa.selenium.WebDriver;
import pages.ContactListPage;
import pages.NewContactModal;

import static org.testng.Assert.assertTrue;

public class ContactSteps {
    WebDriver driver;

    public ContactSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void create(Contact contact) {
        ContactListPage contactListPage = new ContactListPage(driver);
        contactListPage.openContactsPage();
        contactListPage.clickNew();
        NewContactModal newContactModal = new NewContactModal(driver);
        newContactModal.create(contact);
        newContactModal.save();
    }
}
