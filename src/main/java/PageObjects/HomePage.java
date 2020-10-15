package PageObjects;

import Utilities.ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }
    //access to SelectSizeLocator

    public void selectEnglishLang() {
        wait.until(ExpectedConditions.elementToBeClickable(ObjectRepo.EnglishBTNSelection));
        WebElement selectEngBTN = driver.findElement(ObjectRepo.EnglishBTNSelection);
        selectEngBTN.click();
    }
}
