package com.fintech.internship.wat.tools;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseRunner {
    public WebDriver driver;
    public String baseUrl;
    public String browserName = System.getProperty("browser");
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver = getDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            driver.quit();
            driver = null;
        }));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        try {
            BrowsersFactory.valueOf(browserName);
        } catch (NullPointerException | IllegalArgumentException e) {
            browserName = "chrome";
            System.setProperty("browser", browserName);
        }
        return BrowsersFactory.valueOf(browserName).create();
    }
}