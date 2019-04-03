package com.fintech.internship.wat.tools;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseRunner {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    private String browserName = System.getProperty("browser");
    public String tinkoffMobileUrl;
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

    public static void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void clickElementByName(String name) {
        driver.findElement(By.name(name)).click();
    }

    public static void checkText(String xpath, String expected) {
        assertEquals(expected,
                driver.findElement(By.xpath(xpath)).getText());
    }
//
//    public void setActiveCheckBox(String labelName) {
//        if (!driver.findElement(By.xpath("//label[text()='" + labelName + "']")).isSelected()) {
//            driver.findElement(By.xpath("//label[text()='" + labelName + "']")).click();
//        }
//    }
//
//    public void setCity(String cityName) {
//        clickElement("//div[@class='MvnoRegionConfirmation__title_DOqnW']");
//        clickElement("//div[@class='Text__text_3OSYn'][text()='" + cityName + "']");
//    }
//
//    public String getPrice() {
//        return driver.findElement(By.xpath("//h3[@data-qa-file='UITitle']")).getText();
//    }
//
//    public void checkCityIsRight(String cityName) {
//        WebElement element = driver.findElement(By.xpath(
//                "//div[@class='MvnoRegionConfirmation__title_DOqnW'][text()='" + cityName +"']"));
//        Assert.assertTrue(element.isDisplayed());
//    }
//
//    public void setMaxValues() {
//        Select.selectElementFromDropdown("internet", "Безлимитный интернет");
//        Select.selectElementFromDropdown("calls", "Безлимитные минуты");
//        setActiveCheckBox("Режим модема (499\u00a0\u20BD)");
//        setActiveCheckBox("Безлимитные СМС (49\u00a0\u20BD)");
//    }
}