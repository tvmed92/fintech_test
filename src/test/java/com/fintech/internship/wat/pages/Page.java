package com.fintech.internship.wat.pages;

import com.fintech.internship.wat.app.TestApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Page {

    Logger logger = LoggerFactory.getLogger(TestApplication.class);

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isLoadedByTitleContains(String title) {
        wait.until(d -> d.getTitle().contains(title));
        return true;
    }

    public void switchToTab(String windowTitle) {
        wait.until(d -> {
            boolean check = false;
            for (String title : driver.getWindowHandles()) {
                driver.switchTo().window(title);
                System.out.println(d.getTitle());
                check = d.getTitle().equals(windowTitle);
//                if (check) {
//                    driver.close();
//                    logger.info("Закрыли вкладку Поиск в Google");
//                    break;
//                }
            }
            return check;
        });
    }

    public void closeCurrentTab() {
        driver.close();
        logger.info("Закрыта активная вкладка");
    }

    public void switchToMainTab() {

        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

    public void checkCurrentTabUrl(String url) {
        wait.until(d -> driver.getCurrentUrl().equals(url));
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
