package com.fintech.internship.wat.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Helper extends BaseRunner {
    public static WebDriver driver;

    public void checkText(String xpath, String expected) {
        assertEquals(expected,
                driver.findElement(By.xpath(xpath)).getText());
    }

    public static void clickElement(String name) {

        driver.findElement(By.name(name)).click();
    }
}
