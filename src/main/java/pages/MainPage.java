package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

;


public class MainPage {
    private static WebDriver driver;

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
}

