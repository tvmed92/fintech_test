package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//класс не доведен до конца и без рефакторинга


public class TestFourth extends BaseRunner {

    @Test
    public void testFourth() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");

        clickElement("//span[@class='MvnoRegionConfirmation__option_v9PfP']");

        WebElement city = driver.findElement(By.xpath(
                "//div[@class='MvnoRegionConfirmation__title_DOqnW'][text()='Москва и Московская область']"));
        Assert.assertTrue(city.isDisplayed());

        driver.navigate().refresh();
        WebElement city1 = driver.findElement(By.xpath(
                "//div[@class='MvnoRegionConfirmation__title_DOqnW'][text()='Москва и Московская область']"));
        Assert.assertTrue(city1.isDisplayed());

        String price1 = driver.findElement(By.xpath("//h3[@data-qa-file='UITitle']")).getText();
        clickElement("//div[@class='MvnoRegionConfirmation__title_DOqnW']");
        clickElement("//div[@class='Text__text_3OSYn'][text()='Краснодарский кр.']");

        String price2 = driver.findElement(By.xpath("//h3[@data-qa-file='UITitle']")).getText();
        Assert.assertNotSame(price1, price2);

        clickElement("//div[@data-qa-file='UISelectTitle'][span[text()='Интернет']]/..");
        clickElement("//span[@class='ui-dropdown-field-list__item-text'][text()='Безлимитный интернет']");
        clickElement("//div[@data-qa-file='UISelectTitle'][span[text()='Звонки']]/..");
        clickElement("//span[@class='ui-dropdown-field-list__item-text'][text()='Безлимитные минуты']");


//        driver.findElement(By.cssSelector("(//div[@data-qa-type='uikit/checkbox'])[1]")).click();
//        driver.findElement(By.cssSelector("(//div[@data-qa-type='uikit/checkbox'])[1]")).click();

//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Безлимитный интернет в приложениях'])[1]/following::div[6]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='?'])[1]/following::div[7]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]");
//
//        String price3 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]")).getText();
//
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Город'])[1]/following::div[5]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Интернет'])[1]/following::div[2]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::div[5]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Безлимитный интернет'])[3]/following::div[7]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::form[1]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Безлимитный интернет в приложениях'])[1]/following::div[6]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='?'])[1]/following::div[7]");
//        clickElement("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]");
//
//        String price4 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]")).getText();

    }

    private void clickElement(String s) {
        driver.findElement(By.xpath(s)).click();
    }
}
