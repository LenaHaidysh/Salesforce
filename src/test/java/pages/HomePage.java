package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public static final By BANNER = By.cssSelector(".oneTrialHeader");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://coherentsolutionsinc.lightning.force.com/lightning/page/home");
    }


    public boolean isPageOpened1() {
        try {
            driver.findElement(BANNER);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
