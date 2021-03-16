package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class LookUp {

    WebDriver driver;
    String label;
    String locator = "//*[contains(text(),'%s')]/ancestor::lightning-lookup//input"; //было "//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'uiInput')]//input"
    String optionLocator = "//lightning-base-combobox-formatted-text[@title='%s']"; //было "//*[@title='%s']/ancestor::a[@role='option']"

    public LookUp(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
        try {
            driver.findElement(By.xpath(String.format(optionLocator, text))).click();
        } catch (NoSuchElementException ex) {
            Assert.fail(String.format("Can not find option '%s'", text)); //добавили try-catch
            // для того чтобы в отчете в аллюре выводило понятную ошибку
        }
    }
}
//можно вынести в baseelement
