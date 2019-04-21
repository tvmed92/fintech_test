package com.fintech.internship.wat.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class GooglePage extends Page{
    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement searchField;

    @FindBy(xpath = "//div//h3[@class='LC20lb'][text()='Тарифы Тинькофф Мобайла']")
    public List<WebElement> searchedList;

    public void openGoogle() {
        driver.navigate().to("https://www.google.ru/");
        isLoadedByTitleContains("Google");
    }

    public void openSearchResultsByRequest(String request, String requestItem) {
        searchField.sendKeys(request);
        searchField.sendKeys(Keys.ENTER);
        wait
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofMillis(500))
                .until(driver -> {
                    List<WebElement> items = searchedList;
                    for (WebElement element : items) {
                        if (element.getText().contains(requestItem)) {
                            element.click();
                            logger.info("В результатах поиска выбрали пункт" + requestItem);
                            break;
                        }
                    }
//                    Set<String> ids = driver.getWindowHandles();
//                    ids.forEach(id -> {
//                        if (!id.equals(driver.getWindowHandle())) {
//                            driver.switchTo().window(id);
//                            logger.info("Переключились на вкладку" + driver.getTitle());
//                        }
//                    });
                    return isLoadedByTitleContains(requestItem);
                });
    }

    public boolean isLoadedByTitleContains(String title) {
        wait.until(d -> d.getTitle().contains(title));
        return true;
    }
}
