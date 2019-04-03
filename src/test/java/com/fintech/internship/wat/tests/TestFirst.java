package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestFirst extends BaseRunner {

    @Test
    public void testFirst() {
        driver.get(tinkoffVacanciesUrl);

        clickElementByName("name");
        clickElementByName("birthday");
        clickElementByName("city");
        clickElementByName("email");
        clickElementByName("phone");
        clickElementByName("socialLink0");
        driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
        driver.findElement(By.xpath("//button[span[@class='Button__content_3MlYx']]")).click();

        for (int i = 1; i <= 6; i++) {
            checkText("(//div[@data-qa-file='UIFormRowError'])[" + i + "]", "Поле обязательное");
        }
    }
}
