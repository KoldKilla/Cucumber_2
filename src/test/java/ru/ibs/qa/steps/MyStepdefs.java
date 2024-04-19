package ru.ibs.qa.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.MainPage;
import pages.ModalWindow;
import pages.TablePage;

import java.util.concurrent.TimeUnit;


public class MyStepdefs {
    WebDriver driver;

    @io.cucumber.java.Before
    public void настраиваемОкружениеВБраузере() {
        if ("remote".equalsIgnoreCase(ConfProp.getProperty("type_driver"))) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(ConfProp.getProperty("type_browser"));
            capabilities.setVersion("109.0");
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", false
            ));
            try {
                driver = new RemoteWebDriver(URI.create(ConfProp.getProperty("selenoid_url")).toURL(),
                        capabilities, true);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            BasePage.setDriver(driver);
            driver.get(ConfProp.getProperty("remote_url"));

        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            BasePage.setDriver(driver);
            driver.get(ConfProp.getProperty("base_url"));
        }     
    }

    @io.cucumber.java.After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }


    @And("Открыть сайт QualIT")
    public void test() {
        driver.get("http://localhost:8080");
    }

    @And("Нажать на меню 'Песочница'")
    public void clickSandBoxMenu() {
        new MainPage(driver)
                .clickDropDownMenuSandBox();
    }

    @And("Нажать на меню 'Товары'")
    public void clickItemsMenu() {
        new MainPage(driver)
                .clickDropDownMenuItemsText();
    }

    @And("Нажать на кнопку 'Добавить'")
    public void clickAddButton() {
        new TablePage(driver)
                .clickAddButton();
    }

    @And("В модальном окне ввести текст {string} в поле 'Наименование'")
    public void sendName(String textName) {
        new ModalWindow(driver)
                .sendName(textName);
    }

    @And("В модальном окне нажать меню с типом товара")
    public void clickTypeDropDownMenu(){
        new ModalWindow(driver)
                .clickTypeDropDownMenu();
    }

    @And("В модальном окне выбрать тип 'Фрукт'")
    public void clickFruitType() {
        new ModalWindow(driver)
                .clickFruitType();
    }

    @And("В модальном окне выбрать тип 'Овощ'")
    public void clickVegetableType() {
        new ModalWindow(driver)
                .clickVegetablesType();
    }

    @And("В модальном окне выбрать чекбокс экзотический")
    public void clickExoticCheckBox() {
        new ModalWindow(driver)
                .clickExoticCheckBox();
    }

    @And("Нажимаем на кнопку 'Сохранить'")
    public void clickSaveButton() {
        new ModalWindow(driver)
                .clickSaveButton();
    }

    @Then("Товар добавляется в таблицу, проверить что он добавлен. Проверить отображение: {string}, {string}, {string}")
    public void checkNewRawTable(String expectedNameCellText, String expectedTypeCellText, String expectedExoticCellText) {
        new TablePage(driver)
                .checkNewRawTable(expectedNameCellText, expectedTypeCellText, expectedExoticCellText);
        throw new io.cucumber.java.PendingException();
    }

    @Then("Проверить столбцы 'Наименование', 'Тип', 'Экзотический' в таблице товаров")
    public void checkTable(){
        new TablePage(driver)
                .checkTable("Наименование", "Тип", "Экзотический");
    }
}

