package com.fintech.internship.wat.app;

import com.fintech.internship.wat.pages.GooglePage;
import com.fintech.internship.wat.pages.TinkoffMobilePage;
import com.fintech.internship.wat.pages.TinkoffVacanciesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestApplication {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private String browserName = "chrome";
    public GooglePage googlePage;
    public TinkoffVacanciesPage vacanciesPage;
    public TinkoffMobilePage mobilePage;

    public TestApplication() {
        driver = new EventFiringWebDriver(getDriver());
        ((EventFiringWebDriver) driver).register(new BrowsersFactory.TestListener());
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        googlePage = new GooglePage(driver);
        vacanciesPage = new TinkoffVacanciesPage(driver);
        mobilePage = new TinkoffMobilePage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    private WebDriver getDriver() {
        return BrowsersFactory.createDriver(browserName);
    }
}
