package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TablePage {
    WebDriver driver;

    private final By tableNameText = By.xpath(".//th[text()='Наименование']");
    private final By tableTypeText = By.xpath(".//th[text()='Тип']");
    private final By tableExoticTest = By.xpath(".//th[text()='Экзотический']");
    private final By addButton = By.xpath(".//button[text()='Добавить']");


    private final By nameCell = By.xpath((".//tbody/tr[last()]/td[1]"));
    private final By typeCell = By.xpath((".//tbody/tr[last()]/td[2]"));
    private final By exoticCell = By.xpath((".//tbody/tr[last()]/td[3]"));


    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public TablePage checkTable(String expectedNameText, String expectedTypeText, String expectedExoticText){
        driver.findElement(tableNameText).isDisplayed();

        String nameText = driver.findElement(tableNameText).getText();
        String typeText = driver.findElement(tableTypeText).getText();
        String exoticText = driver.findElement(tableExoticTest).getText();

        assertEquals(expectedNameText, nameText);
        assertEquals(expectedTypeText, typeText);
        assertEquals(expectedExoticText, exoticText);
        return this;
    }


    public TablePage clickAddButton() {
        driver.findElement(addButton).click();
        return this;
    }

    public TablePage checkNewRawTable(String expectedNameCellText, String expectedTypeCellText, String expectedExoticCellText){
        String nameCellText = driver.findElement(nameCell).getText();
        String typeCellText = driver.findElement(typeCell).getText();
        String exoticCellText = driver.findElement(exoticCell).getText();

        assertEquals(expectedNameCellText, nameCellText);
        assertEquals(expectedTypeCellText, typeCellText);
        assertEquals(expectedExoticCellText, exoticCellText);
        return this;
    }

}
