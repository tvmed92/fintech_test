package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFive extends BaseRunner {

    @Test
    public void testFive() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");




        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(By
                        .xpath("")));
//        element.click();

    }
}
