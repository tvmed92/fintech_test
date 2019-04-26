package com.fintech.internship.wat.pages;

import com.fintech.internship.wat.app.TestApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

}
