package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String labelForArea;
    String locator = "//*[contains(text(),'%s')]/ancestor::div/ancestor::div//textarea";

    public TextArea(WebDriver driver, String labelForArea) {
        this.driver = driver;
        this.labelForArea = labelForArea;
    }

    public void writeForArea(String text) {
        driver.findElement(By.xpath(String.format(locator, labelForArea))).sendKeys(text);
    }
}

