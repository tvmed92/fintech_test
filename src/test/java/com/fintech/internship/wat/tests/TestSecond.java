package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestSecond extends BaseRunner {

    @Test
    public void testSecond() {
        driver.get(baseUrl);

        sendKeys("name", "ttt");
        sendKeys("birthday", "12.12.2020");
        sendKeys("city", "123456");
        sendKeys("email", "пролдж");
        sendKeys("phone", "+7(000) 000-00-00");
        driver.findElement(By.xpath("//button[span[@class='Button__content_3MlYx']]")).click();

        checkText("(//div[@data-qa-file='UIFormRowError'])[1]",
                "Допустимо использовать только буквы русского алфавита и дефис");
        checkText("(//div[@data-qa-file='UIFormRowError'])[2]",
                "Мы не нанимаем пришельцев из будущего");
        checkText("(//div[@data-qa-file='UIFormRowError'])[3]",
                "Введите корректный адрес эл. почты");
        checkText("(//div[@data-qa-file='UIFormRowError'])[4]",
                "Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");

        sendKeys("birthday", "41.12.2018");
        driver.findElement(By.xpath("//button[span[@class='Button__content_3MlYx']]")).click();
        checkText("(//div[@data-qa-file='UIFormRowError'])[2]",
                "Поле заполнено некорректно");

    }

    private void sendKeys(String name, String value) {
        driver.findElement(By.name(name)).sendKeys(value);
    }

    private void checkText(String xpath, String expected) {
        assertEquals(expected,
                driver.findElement(By.xpath(xpath)).getText());
    }
}
