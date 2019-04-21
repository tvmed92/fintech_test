package com.fintech.internship.wat.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BrowsersFactory {

    public static class TestListener extends AbstractWebDriverEventListener {

        Logger logger = LoggerFactory.getLogger(BrowsersFactory.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Обращение к элементу" + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Найден элемент" + by);
        }
    }

    static WebDriver createDriver(String browserName) {
        updateProperty("chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

    static void updateProperty(String browserName) {
        System.out.println(String.format("\nstarting %s-browser......", browserName));
        if (System.getProperty(browserName) == null) System.setProperty("browser", browserName);
    }
}