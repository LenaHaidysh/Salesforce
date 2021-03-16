package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String dropdownLocator = "//*[contains(text(),'Salutation')]/../descendant::input";////*[contains(text(),'Salutation')]/../div/lightning-base-combobox/div/div/input
    // и //*[contains(text(),'Salutation')]/../descendant::input
    // dropdown:
    ////*[contains(text(),'%s')]/ancestor::lightning-picklist//input
    //
    //textarea:
    ////*[contains(text(),'%s')]/ancestor::lightning-textarea//textarea
    String optionLocator = "//*[@data-value=\"%s\"]";
    String option;


    public DropDown(WebDriver driver, String option) {
        this.driver = driver;
        this.option = option;
    }

    public void choose() {
        driver.findElement(By.xpath(dropdownLocator)).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}
