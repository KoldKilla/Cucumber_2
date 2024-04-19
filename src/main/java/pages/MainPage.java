package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

;import java.time.Duration;


public class MainPage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        MainPage.driver = driver;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By dropDownMenuSandBox = By.xpath(".//a[@id='navbarDropdown']");
    private final By dropDownMenuItemsText = By.xpath(".//a[text()='Товары']");

    public MainPage clickDropDownMenuSandBox(){
        driver.findElement(dropDownMenuSandBox).click();
        return this;
    }

    public MainPage clickDropDownMenuItemsText(){
        driver.findElement(dropDownMenuItemsText).click();
        return this;
    }

    public static boolean isElementVisibleAndClickable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}

