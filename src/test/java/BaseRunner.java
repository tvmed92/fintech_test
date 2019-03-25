import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseRunner {
    WebDriver driver;
    public String browserName = System.getProperty("browser");
    String baseUrl;

    @Before
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        try {
            BrowsersFactory.valueOf(System.getProperty("browser"));
        } catch (NullPointerException | IllegalArgumentException e) {
            browserName = randomBrowserPicker();
            System.setProperty("browser", browserName);
        }
        return BrowsersFactory.valueOf(browserName).create();
    }

    private String randomBrowserPicker() {
        System.out.println("\nThe driver is not set. Running a random browser...");
        int pick = new Random().nextInt(BrowsersFactory.values().length);
        return BrowsersFactory.values()[pick].toString();
    }
}