package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import models.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactTest extends BaseTest {

    @Test(description = "Creation of contact")
    @Link("https://instagram.com/dmitryrak11")
    @Issue("COVID-19")
    @TmsLink("123")
    @Attachment(value = "screenshot", type = "image/png")

    public void createContact() {
        loginSteps.login("aromantikova-uhgn@force.com", "aroma9091");
        Contact contact = new Contact("Lena1", "Smith", "Lenana", "+375291111111", "2223344");
        //BUILDER pattern
        //FACTORY
        contactSteps.create(contact);
        contactListPage.openContactsPage();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        contactListPage.isPageOpened();
        WebElement contactPresent = driver.findElement(By.xpath("//*[text()='" + contact.getFirstName() + " " + contact.getLastName() + "']"));
        String actualResult = contactPresent.getText();
        assertEquals(actualResult, String.format(contact.getFirstName() + " " + contact.getLastName()), "контакт не найден");
    }
}