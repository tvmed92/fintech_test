package com.fintech.internship.wat.tools;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseRunner {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String browserName = System.getProperty("browser");
    protected String tinkoffMobileUrl;
    protected String tinkoffVacanciesUrl;
    protected String googleUrl;

    @Before
    public void setUp() {
        tinkoffVacanciesUrl = "https://www.tinkoff.ru/career/vacancies/";
        tinkoffMobileUrl = "https://www.tinkoff.ru/mobile-operator/tariffs/";
        googleUrl = "https://google.ru/";
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

    private WebDriver getDriver() {
        try {
            BrowsersFactory.valueOf(browserName);
        } catch (NullPointerException | IllegalArgumentException e) {
            browserName = "chrome";
            System.setProperty("browser", browserName);
        }
        return BrowsersFactory.valueOf(browserName).create();
    }

    public void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickElementByName(String name) {
        driver.findElement(By.name(name)).click();
    }

    public void checkText(String labelName, String expected) {
        String textSelector = String.format("//span[text()='%s']/ancestor::div[@class='ui-form__field']//div[@data-qa-file='UIFormRowError']", labelName);
        assertEquals(expected,
                driver.findElement(By.xpath(textSelector)).getText());
    }
}