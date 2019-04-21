package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.pages.GooglePage;
import com.fintech.internship.wat.pages.TinkoffMobilePage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestThird extends BaseRunner {
    Logger logger = LoggerFactory.getLogger(TestThird.class);

    @Test
    public void testThird() {
        GooglePage googlePage = testApp.googlePage;
        googlePage.openGoogle();
        googlePage.openSearchResultsByRequest("мобайл тинькофф ", "Тарифы Тинькофф Мобайла");
        googlePage.switchToTab("Тарифы Тинькофф Мобайла");
        TinkoffMobilePage mobilePage = testApp.mobilePage;
        mobilePage.switchToTab("tinkoff mobile тарифы - Поиск в Google");
        googlePage.closeCurrentTab();
        mobilePage.switchToMainTab();
        mobilePage.checkCurrentTabUrl(tinkoffMobileUrl);
        //        driver.get(googleUrl);
//        logger.info("Перешли на страницу" + googleUrl);
//        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"))
//                .sendKeys("мобайл тинькофф ");
//        driver.findElement(By.xpath("//span[b[text()='tinkoff mobile тарифы']]")).click();
//        logger.info("Ввели поисковый запрос 'мобайл тинькофф'");
//        testApp.openSearchResultsByRequest("Тарифы Тинькофф Мобайла", "Тарифы Тинькофф Мобайла");
//        testApp.switchToTab("Тарифы Тинькофф Мобайла");
//        testApp.switchToTab("tinkoff mobile тарифы - Поиск в Google");
////        testApp.closeCurrentTab();
//        testApp.switchToMainTab();
//        testApp.checkCurrentTabUrl(tinkoffMobileUrl);
    }
}

//        wait
//                .ignoring(StaleElementReferenceException.class)
//                .pollingEvery(Duration.ofMillis(500))
//                .until(driver -> {
//                    By listItems = By.xpath("//div//h3[@class='LC20lb'][text()='Тарифы Тинькофф Мобайла']");
//                    List<WebElement> items = driver.findElements(listItems);
//                    for (WebElement element : items) {
//                        if (element.getText().contains("Тарифы Тинькофф Мобайла")) {
//                            element.click();
//                            logger.info("В результатах поиска выбрали пункт 'Тарифы Тинькофф Мобайла'");
//                            break;
//                        }
//                    }
//                    Set<String> ids = driver.getWindowHandles();
//                    ids.forEach(id -> {
//                        if (!id.equals(driver.getWindowHandle())) {
//                            driver.switchTo().window(id);
//                            logger.info("Переключились на вкладку" + driver.getTitle());
//                        }
//                    });
////                    return driver.getTitle().equals("Тарифы Тинькофф Мобайла");
//                });
//
//
//        wait.until(d -> {
//            boolean check = false;
//            for (String title : driver.getWindowHandles()) {
//                driver.switchTo().window(title);
//                check = d.getTitle().equals("tinkoff mobile тарифы - Поиск в Google");
//                if (check) {
//                    driver.close();
//                    logger.info("Закрыли вкладку Поиск в Google");
//                    break;
//                }
//            }
//            return check;
//        });
//
//        driver.switchTo().window(driver.getWindowHandles().iterator().next());
//        wait.until(d -> driver.getCurrentUrl().equals(tinkoffMobileUrl));
//        logger.info("Убедились, что url активной вкладки = " + tinkoffMobileUrl);
//    }