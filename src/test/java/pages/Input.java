package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;
    String locator = "//*[contains(text(),'%s')]/ancestor::lightning-input//input";
    String locatorForAccount="//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'uiInput')]//input";
    String locatorForClick = "//*[contains(text(), 'Parent Account')]";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
    }

    public void writeForAccount(String text) {
        driver.findElement(By.xpath(String.format(locatorForAccount, label))).sendKeys(text);
    }

    public void click(){
        driver.findElement(By.xpath(String.format(locatorForClick))).click();
    }

}

