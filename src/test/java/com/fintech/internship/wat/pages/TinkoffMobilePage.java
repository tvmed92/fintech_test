package com.fintech.internship.wat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TinkoffMobilePage extends Page {
    public TinkoffMobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openMobile() {
        driver.navigate().to("https://www.tinkoff.ru/mobile-operator/tariffs/");
        isLoadedByTitleContains("Тарифы Тинькофф Мобайла");
    }

}
