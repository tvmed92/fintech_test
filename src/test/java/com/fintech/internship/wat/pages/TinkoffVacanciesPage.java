package com.fintech.internship.wat.pages;

import com.fintech.internship.wat.tools.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void clickCheckBox() {
        driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
    }

    public void clickSendButton() {
        driver.findElement(By.cssSelector("[type='submit']")).click();
    }

    public void checkText(String xpath, String expected) {
        assertEquals(expected, driver.findElement(By.xpath(xpath)).getText());
    }

    public void checkErrorText(String fieldName, String expected) {
        String textSelector = String.format("//span[text()='%s']/ancestor::div[@class='ui-form__field']//div[@data-qa-file='UIFormRowError']", fieldName);
        assertEquals(expected,
                driver.findElement(By.xpath(textSelector)).getText());
    }

    public void inputTextToField(String fieldName, String value) {
        new TextInput(driver, initTextField(fieldName)).sendKeys(value);
    }

    private WebElement initTextField(String fieldName) {
        String textInputSelector = String.format("//*[@class='ui-input__label'][span[contains(text(),'%s')]]", fieldName);
        return driver.findElement(By.xpath(textInputSelector));
    }

    public void clearField(String fieldName) {
        WebElement textField = initTextField(fieldName);
        textField.clear();
    }
}
