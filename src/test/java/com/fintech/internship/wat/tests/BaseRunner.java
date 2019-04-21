package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.app.TestApplication;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BaseRunner {
    public static ThreadLocal<TestApplication> thlTestApp = new ThreadLocal<>();
    public TestApplication testApp;

    //    protected WebDriver driver;
//    protected WebDriverWait wait;
//    private String browserName = "chrome";
    protected String tinkoffMobileUrl;
    protected String tinkoffVacanciesUrl;
//    protected String googleUrl;

    @Before
    public void setUp() {
        if (thlTestApp.get() != null) {
            testApp = thlTestApp.get();
            return;
        }
        testApp = new TestApplication();
        thlTestApp.set(testApp);

        tinkoffVacanciesUrl = "https://www.tinkoff.ru/career/vacancies/";
        tinkoffMobileUrl = "https://www.tinkoff.ru/mobile-operator/tariffs/";
//        googleUrl = "https://google.ru/";

//        driver = new EventFiringWebDriver(getDriver());
//        ((EventFiringWebDriver) driver).register(new BrowsersFactory.TestListener());
//        threadLocal.set(driver);
//        wait = new WebDriverWait(driver, 10);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        testApp.quit();
    }

//    private WebDriver getDriver() {
//        return BrowsersFactory.createDriver(browserName);
//    }


//    public void clickElement(String xpath) {
//        driver.findElement(By.xpath(xpath)).click();
//    }
//
//    public void clickElementByName(String name) {
//        driver.findElement(By.name(name)).click();
//    }
//
//    public void checkText(String labelName, String expected) {
//        String textSelector = String.format("//span[text()='%s']/ancestor::div[@class='ui-form__field']//div[@data-qa-file='UIFormRowError']", labelName);
//        assertEquals(expected,
//                driver.findElement(By.xpath(textSelector)).getText());
//    }
}