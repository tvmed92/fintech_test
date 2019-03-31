package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestThird extends BaseRunner {

    @Test
    public void testThird() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://google.ru/");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"))
                .sendKeys("мобайл тинькофф");
        driver.findElement(By.xpath("//span[text()='мобайл тинькофф']/b[text()=' тарифы']")).click();
        By listItems = By.xpath("//div//h3[@class='LC20lb'][text()='Тарифы Тинькофф Мобайла']");
        List<WebElement> items = driver.findElements(listItems);
        wait
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofMillis(500))
                .until(driver -> {
                    for (WebElement element : items) {
                        if (element.getText().contains("Тарифы Тинькофф Мобайла")) {
                            element.click();
                            break;
                        }
                    }
                    Set<String> ids = driver.getWindowHandles();
                    ids.forEach(id -> {
                        if (!id.equals(driver.getWindowHandle())) {
                            driver.switchTo().window(id);
                        }
                    });
                    return driver.getTitle().equals("Тарифы Тинькофф Мобайла");
                });

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();

        //следующий код пока не работает, т.к. driver.close() закрывает браузер
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.tinkoff.ru/mobile-operator/tariffs/");
    }
}
