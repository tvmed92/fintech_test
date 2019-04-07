package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import com.fintech.internship.wat.tools.TextInput;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestSecond extends BaseRunner {

    @Test
    public void testSecond() {
        driver.get(tinkoffVacanciesUrl);

        new TextInput(driver, initTextField("Фамилия и имя")).sendKeys("ttt");
        new TextInput(driver, initTextField("Дата рождения")).sendKeys("12.12.2020");
        new TextInput(driver, initTextField("Город проживания")).sendKeys("123456");
        new TextInput(driver, initTextField("Электронная почта")).sendKeys("пролдж");
        new TextInput(driver, initTextField("Мобильный телефон")).sendKeys("+7(000) 000-00-00");
        driver.findElement(By.xpath("//button[span[@class='Button__content_3MlYx']]")).click();

        checkText("(//div[@data-qa-file='UIFormRowError'])[1]",
                "Допустимо использовать только буквы русского алфавита и дефис");
        checkText("(//div[@data-qa-file='UIFormRowError'])[2]",
                "Мы не нанимаем пришельцев из будущего");
        checkText("(//div[@data-qa-file='UIFormRowError'])[3]",
                "Введите корректный адрес эл. почты");
        checkText("(//div[@data-qa-file='UIFormRowError'])[4]",
                "Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");

        new TextInput(driver, initTextField("Дата рождения")).sendKeys("41.12.2018");
        driver.findElement(By.xpath("//button[span[@class='Button__content_3MlYx']]")).click();
        checkText("(//div[@data-qa-file='UIFormRowError'])[2]",
                "Поле заполнено некорректно");

    }

//    private void sendKeys(String name, String value) {
//        driver.findElement(By.name(name)).sendKeys(value);
//    }

    private WebElement initTextField(String labelName) {
        String textInputSelector = String.format("//*[@class='ui-input__label'][span[contains(text(),'%s')]]", labelName);
        return driver.findElement(By.xpath(textInputSelector));
    }

}
