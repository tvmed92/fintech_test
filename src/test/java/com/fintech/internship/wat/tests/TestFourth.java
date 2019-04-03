package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import com.fintech.internship.wat.tools.Select;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

//класс без рефакторинга

public class TestFourth extends BaseRunner {

    @Test
    public void testFourth() {
        driver.get(tinkoffMobileUrl);

        clickElement("//span[@class='MvnoRegionConfirmation__option_v9PfP']");
        checkCityIsRight("Москва и Московская область");

        driver.navigate().refresh();
        checkCityIsRight("Москва и Московская область");

        String price1 = getPrice();
        setCity("Краснодарский кр.");
        String price2 = getPrice();
        Assert.assertNotSame(price1, price2);

        setMaxValues();
        String price3 = getPrice();
        setCity("Москва и Московская обл.");
        setMaxValues();
        String price4 = getPrice();
        Assert.assertSame(price3, price4);

    }

    private void setMaxValues() {
        Select.selectElementFromDropdown("internet", "Безлимитный интернет");
        Select.selectElementFromDropdown("calls", "Безлимитные минуты");
        setActiveCheckBox("Режим модема (499\u00a0\u20BD)");
        setActiveCheckBox("Безлимитные СМС (49\u00a0\u20BD)");
    }

    private String getPrice() {
        return driver.findElement(By.xpath("//h3[@data-qa-file='UITitle']")).getText();
    }

    private void checkCityIsRight(String cityName) {
        WebElement element = driver.findElement(By.xpath(
                "//div[@class='MvnoRegionConfirmation__title_DOqnW'][text()='" + cityName +"']"));
        Assert.assertTrue(element.isDisplayed());
    }

    private void setCity(String cityName) {
        clickElement("//div[@class='MvnoRegionConfirmation__title_DOqnW']");
        clickElement("//div[@class='Text__text_3OSYn'][text()='" + cityName + "']");
    }

    private void setActiveCheckBox(String labelName) {
        if (!driver.findElement(By.xpath("//label[text()='" + labelName + "']")).isSelected()) {
            driver.findElement(By.xpath("//label[text()='" + labelName + "']")).click();
        }
    }

//    private void selectElementFromDropdown(String listName, String value) {
//        clickElement("//div[@data-qa-file='UIDropdownSelectActive'][select[@name='" + listName + "']]");
//        By listItems = By.xpath("//div[@class='ui-dropdown-field-list__item']");
//        List<WebElement> items = driver.findElements(listItems);
//        for (WebElement element : items) {
//            if (element.getText().contains(value)) {
//                element.click();
//                break;
//            }
//        }
//    }
}
