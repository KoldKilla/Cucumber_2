package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//Элементы страницы оформления заказа сайта:
public class ModalWindow {
    private final WebDriver driver;
    private By headerModalWindow = By.xpath(".//h5[text()='Добавление товара']");

    private By nameInputField = By.id("name");
    private By typeDropDownMenu = By.id("type");

    private By vegetablesType = By.xpath(".//option[@value = 'VEGETABLE']");
    private By fruitType = By.xpath(".//option[@value = 'FRUIT']");
    private By exoticCheckBox = By.id("exotic");
    private By saveButton = By.xpath(".//button[text()='Сохранить']");

    private final By nameCell = By.xpath((".//tbody/tr[last()]/td[1]"));


    public ModalWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void checkModalWindowHeader() {
        driver.findElement(headerModalWindow).isDisplayed();
    }

    public ModalWindow sendName(String textName) {
        driver.findElement(nameInputField).sendKeys(textName);
        return this;
    }

    public ModalWindow clickTypeDropDownMenu(){
        driver.findElement(typeDropDownMenu).click();
        return this;
    }

    public ModalWindow clickVegetablesType() {
        driver.findElement(vegetablesType).click();
        return this;
    }

    public ModalWindow clickFruitType() {
        driver.findElement(fruitType).click();
        return this;
    }

    public ModalWindow clickExoticCheckBox() {
        driver.findElement(exoticCheckBox).click();
        return this;
    }

    public ModalWindow clickSaveButton() {
        driver.findElement(saveButton)
                .click();


        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(nameCell));
        driver.findElement(nameCell).isDisplayed();

        return this;
    }
}
