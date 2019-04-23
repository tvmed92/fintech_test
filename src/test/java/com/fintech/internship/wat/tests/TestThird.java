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
//        mobilePage.checkCurrentTabUrl(tinkoffMobileUrl);
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