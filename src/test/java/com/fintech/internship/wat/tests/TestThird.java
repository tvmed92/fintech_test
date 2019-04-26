package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.pages.GooglePage;
import com.fintech.internship.wat.pages.TinkoffMobilePage;
import org.junit.Test;

public class TestThird extends BaseRunner {

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

    }
}