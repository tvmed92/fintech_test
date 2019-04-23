package com.fintech.internship.wat.pages;

import com.fintech.internship.wat.tools.CheckBox;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class TinkoffVacanciesPage extends Page {
    public TinkoffVacanciesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openVacancies() {
        driver.navigate().to("https://www.tinkoff.ru/career/vacancies/");
        isLoadedByTitleContains("Вакансии");
    }

    public void clickElementByName(String name) {
        driver.findElement(By.name(name)).click();
    }

    public void checkText(String xpath, String expected) {
        assertEquals(expected, driver.findElement(By.xpath(xpath)).getText());
    }

//    public void checkText(String labelName, String expected) {
//        String textSelector = String.format("//span[text()='%s']/ancestor::div[@class='ui-form__field']//div[@data-qa-file='UIFormRowError']", labelName);
//        assertEquals(expected,
//                driver.findElement(By.xpath(textSelector)).getText());
//    }

    public void clickElementByCss(String css) {
        driver.findElement(By.cssSelector(css)).click();
    }

    public void clickElementByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

//    @FindBy(xpath = "//*[contains(@class,'ui-input__column')]/input[@name='name']")
//    WebElement name;
//
//    public void typeNameField(String value) {
//        //Заполняем форму максиально быстро, пытаясь игнорировать анимацию страницы
//        wait.ignoring(StaleElementReferenceException.class)
//                .ignoring(ElementNotInteractableException.class)
//                .until(d -> {
//                    name.sendKeys(value);
//                    return true;
//                });
//    }
//
//    public void checkNameField(String value){
//        name.sendKeys(Keys.ENTER);
//        assertEquals(value,name.getAttribute("value"));
//    }
}
